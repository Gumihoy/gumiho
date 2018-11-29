package com.aliyun.gumiho.sql.basic.ast.statement.fcl;

import com.aliyun.gumiho.sql.basic.ast.SQLObject;
import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

import java.util.ArrayList;
import java.util.List;

/**
 * CASE [selector]
 * WHEN boolean_expression THEN statement ;
 * [ WHEN boolean_expression THEN statement ; ]...
 * [ ELSE statement [ statement ]... ;
 * END CASE
 * https://dev.mysql.com/doc/refman/5.7/en/case.html
 * <p>
 * <p>
 * CASE expr? caseStatementWhenItem+  caseStatementElseClause? END CASE nameIdentifier?
 * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/lnpls/CASE-statement.html#GUID-F4251A23-0284-4990-A156-00A92F83BC35
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/CASE-statement.html#GUID-F4251A23-0284-4990-A156-00A92F83BC35
 *
 * @author kongtong.ouyang onCondition 2018/4/4.
 */
public class SQLCaseStatement extends AbstractSQLStatement {

    protected SQLExpr selector;

    protected final List<SQLCaseStatementWhenItem> whenItems = new ArrayList<>();

    protected SQLCaseStatementElseClause elseClause;

    protected SQLName endLabel;

    public SQLCaseStatement(DBType dbType) {
        super(dbType);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, selector);
            this.acceptChild(visitor, whenItems);
            this.acceptChild(visitor, elseClause);
        }
    }

    @Override
    public SQLCaseStatement clone() {
        SQLCaseStatement x = new SQLCaseStatement(this.dbType);
        this.cloneTo(x);
        return x;
    }


    public void cloneTo(SQLCaseStatement x) {
        super.cloneTo(x);

        SQLExpr selectorClone = this.selector.clone();
        x.setSelector(selectorClone);

        for (SQLCaseStatementWhenItem whenItem : whenItems) {
            SQLCaseStatementWhenItem whenItemClone = whenItem.clone();
            x.addWhenItem(whenItem);
        }

        if (elseClause != null) {
            SQLCaseStatementElseClause elseClauseClone = elseClause.clone();
            x.setElseClause(elseClauseClone);
        }
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == selector) {
            setSelector(target);
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
        return SQLObjectType.CASE;
    }

    public SQLExpr getSelector() {
        return selector;
    }

    public void setSelector(SQLExpr selector) {
        setChildParent(selector);
        this.selector = selector;
    }


    public List<SQLCaseStatementWhenItem> getWhenItems() {
        return whenItems;
    }

    public void addWhenItem(SQLCaseStatementWhenItem whenItem) {
        if (whenItem == null) {
            return;
        }
        setChildParent(whenItem);
        this.whenItems.add(whenItem);
    }

    public SQLCaseStatementElseClause getElseClause() {
        return elseClause;
    }

    public void setElseClause(SQLCaseStatementElseClause elseClause) {
        setChildParent(elseClause);
        this.elseClause = elseClause;
    }


    public SQLName getEndLabel() {
        return endLabel;
    }

    public void setEndLabel(SQLName endLabel) {
        setChildParent(endLabel);
        this.endLabel = endLabel;
    }


    /**
     * when expr then statement
     */
    public static class SQLCaseStatementWhenItem extends AbstractSQLExpr {

        protected SQLExpr expr;

        protected SQLObject statement;

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, expr);
                this.acceptChild(visitor, statement);
            }
        }

        @Override
        public SQLCaseStatementWhenItem clone() {
            SQLCaseStatementWhenItem x = new SQLCaseStatementWhenItem();

            SQLExpr exprClone = this.expr.clone();
            x.setExpr(exprClone);

            SQLObject statementClone = this.statement.clone();
            x.setStatement(statementClone);

            return x;
        }

        @Override
        public boolean replace(SQLExpr source, SQLExpr target) {
            if (source == expr) {
                setExpr(target);
                return true;
            }
            return false;
        }

        public SQLExpr getExpr() {
            return expr;
        }

        public void setExpr(SQLExpr expr) {
            setChildParent(expr);
            this.expr = expr;
        }

        public SQLObject getStatement() {
            return statement;
        }

        public void setStatement(SQLObject statement) {
            setChildParent(statement);
            this.statement = statement;
        }
    }

    /**
     * else statement... ;
     */
    public static class SQLCaseStatementElseClause extends AbstractSQLExpr {

        protected final List<SQLObject> statements = new ArrayList<>();

        public SQLCaseStatementElseClause() {
            setAfterSemi(true);
        }

        public SQLCaseStatementElseClause(SQLObject... stmts) {
            setAfterSemi(true);

            for (SQLObject stmt : stmts) {
                this.addStatement(stmt);
            }
        }

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, statements);
            }
        }

        @Override
        public SQLCaseStatementElseClause clone() {
            SQLCaseStatementElseClause x = new SQLCaseStatementElseClause();
            this.cloneTo(x);

            for (SQLObject statement : statements) {
                SQLObject statementClone = statement.clone();
                x.addStatement(statementClone);
            }
            return x;
        }


        public List<SQLObject> getStatements() {
            return statements;
        }

        public void addStatement(SQLObject statement) {
            if (statement == null) {
                return;
            }
            setChildParent(statement);
            this.statements.add(statement);
        }
    }


}
