package com.aliyun.gumiho.sql.translate.visitor;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLAssignmentExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLBody;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLNewVariableRefExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.clause.SQLDefaultClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.condition.SQLIsNullCondition;
import com.aliyun.gumiho.sql.basic.ast.element.expr.operator.SQLBinaryOperatorExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.SQLSelectQuery;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.SQLColumnDefinition;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.SQLTableElement;
import com.aliyun.gumiho.sql.basic.ast.element.expr.trigger.SQLTriggerDMLEvent;
import com.aliyun.gumiho.sql.basic.ast.element.function.ISQLFunction;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.element.literal.datetime.SQLDateLiteral;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.ast.statement.dal.SQLSetVariableStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.table.SQLCreateTableStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.trigger.SQLCreateTriggerStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.fcl.SQLIfStatement;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.translate.SQLTransformConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * default xx => trigger
 * <p>
 *
 * @author kongtong.ouyang on 2018/5/18.
 */
public class SQLDefaultClauseToTriggerAndRemoveASTVisitor extends SQLASTTransformVisitor {

    protected final ConcurrentHashMap<String, SQLSelectQuery> MAP = new ConcurrentHashMap<>();

    public SQLDefaultClauseToTriggerAndRemoveASTVisitor() {
    }

    public SQLDefaultClauseToTriggerAndRemoveASTVisitor(SQLTransformConfig config) {
        super(config);
    }

    @Override
    public boolean visit(SQLCreateTableStatement x) {
        SQLName name = x.getName();

        List<SQLColumnDefinition> columns = new ArrayList<>();
        for (int i = x.getTableElements().size() - 1; i >= 0; i--) {
            SQLTableElement element = x.getTableElements().get(i);
            if (!(element instanceof SQLColumnDefinition)) {
                continue;
            }
            SQLColumnDefinition column = (SQLColumnDefinition) element;
            if (column.getDefaultExpr() == null
                    || !(column.getDefaultExpr() instanceof SQLDefaultClause)) {
                continue;
            }

            SQLExpr expr = ((SQLDefaultClause) column.getDefaultExpr()).getExpr();

            if (expr instanceof ISQLFunction) {
                boolean support = false;
                if (((ISQLFunction) expr).getNameExpr() instanceof SQLName) {
                    long methodNameLowerHash = ((SQLName) ((ISQLFunction) expr).getNameExpr()).lowerHash();
                    support = methodNameLowerHash == SQLReserved.CURRENT_TIMESTAMP.lowerHashCode64
                            || methodNameLowerHash == SQLReserved.CURRENT_DATE.lowerHashCode64
                            || methodNameLowerHash == SQLReserved.LOCALTIMESTAMP.lowerHashCode64;
                }
                if (!support) {
                    columns.add(column);
                }
            } else if (expr instanceof SQLBinaryOperatorExpr) {
                columns.add(column);
            } else if (expr instanceof SQLDateLiteral) {
                columns.add(column);
            }
        }

        SQLCreateTriggerStatement createTriggerStatement = createTriggerStatementAndRemove(name, columns, x.getDbType(), x.getTargetDBType());
        if (createTriggerStatement != null) {
            config.stmtList.add(config.index + 1, createTriggerStatement);
        }

        return false;
    }

    /**
     * CREATE TRIGGER before_insert_U3C_MG_BRANCHUPLOG
     * BEFORE INSERT ON `U3C_MG_BRANCHUPLOG`
     * FOR EACH ROW
     * BEGIN
     * IF new.`OPERATEDATE` IS NULL THEN
     * SET new.`OPERATEDATE` = sysdate();
     * END IF;
     * END
     */
    public SQLCreateTriggerStatement createTriggerStatementAndRemove(SQLName name, List<SQLColumnDefinition> columns, DBType dbType, DBType targetDBType) {
        if (columns == null
                || columns.size() == 0) {
            return null;
        }


        SQLCreateTriggerStatement x = new SQLCreateTriggerStatement(dbType);
        x.setTargetDBType(targetDBType);

        String triggerName = "before_insert_" + name.getName();
        x.setName(triggerName);
        x.setActionTime(SQLCreateTriggerStatement.SQLTriggerActionTime.BEFORE);
        SQLTriggerDMLEvent event = new SQLTriggerDMLEvent(SQLTriggerDMLEvent.SQLTriggerDMLEventType.INSERT);
        x.addEvent(event);
        x.setOnExpr(name.getName());

        SQLBody body = new SQLBody();

        for (SQLColumnDefinition column : columns) {
            if (column.getDefaultExpr() == null
                    || !(column.getDefaultExpr() instanceof SQLDefaultClause)) {
                continue;
            }
            SQLDefaultClause defaultClause = (SQLDefaultClause) column.getDefaultExpr();
            SQLExpr expr = defaultClause.getExpr();

            SQLIfStatement ifStatement = new SQLIfStatement(dbType);

            SQLIsNullCondition isNullCondition = new SQLIsNullCondition();
            isNullCondition.setExpr(SQLNewVariableRefExpr.of(column.getColumnName()));

            ifStatement.setCondition(isNullCondition);

            SQLSetVariableStatement setVariableStatement = new SQLSetVariableStatement(dbType);
            SQLNewVariableRefExpr setColumn = SQLNewVariableRefExpr.of(column.getColumnName());
            SQLAssignmentExpr item = new SQLAssignmentExpr(setColumn, expr);
            setVariableStatement.addItem(item);
            setVariableStatement.setAfterSemi(true);

            ifStatement.addStatement(setVariableStatement);

            // add trigger
            body.addBodyItem(ifStatement);


            // remove
            column.setDefaultExpr(null);
        }

        // add trigger body
        x.setTriggerBody(body);

        return x;
    }

}
