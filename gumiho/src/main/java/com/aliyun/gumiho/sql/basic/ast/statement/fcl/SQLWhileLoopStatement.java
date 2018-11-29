package com.aliyun.gumiho.sql.basic.ast.statement.fcl;

import com.aliyun.gumiho.sql.basic.ast.SQLObject;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

import java.util.ArrayList;
import java.util.List;

/**
 * WHILE expr LOOP statement... END LOOP [ label ] ;
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/lnpls/WHILE-LOOP-statement.html#GUID-9339C3AD-7F41-4D3F-9B2D-6FC5DCE44C6B
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/WHILE-LOOP-statement.html#GUID-9339C3AD-7F41-4D3F-9B2D-6FC5DCE44C6B
 *
 * @author kongtong.ouyang on 2018/6/14.
 */
public class SQLWhileLoopStatement extends AbstractSQLStatement {

    protected SQLExpr condition;

    protected final List<SQLObject> statements = new ArrayList<>();

    protected SQLName endLabel;

    public SQLWhileLoopStatement(DBType dbType) {
        super(dbType);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, condition);
            this.acceptChild(visitor, statements);
            this.acceptChild(visitor, endLabel);
        }
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == condition) {
            setCondition(target);
            return true;
        }

        if (source == endLabel
                && target instanceof SQLName) {
            setEndLabel((SQLName) target);
            return true;
        }
        return false;
    }


    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.WHILE_LOOP;
    }


    public SQLExpr getCondition() {
        return condition;
    }

    public void setCondition(SQLExpr condition) {
        setChildParent(condition);
        this.condition = condition;
    }

    public List<SQLObject> getStatements() {
        return statements;
    }

    public void addStatement(SQLObject stmt) {
        if (stmt == null) {
            return;
        }
        setChildParent(stmt);
        this.statements.add(stmt);
    }


    public SQLName getEndLabel() {
        return endLabel;
    }

    public void setEndLabel(SQLName endLabel) {
        setChildParent(endLabel);
        this.endLabel = endLabel;
    }
}
