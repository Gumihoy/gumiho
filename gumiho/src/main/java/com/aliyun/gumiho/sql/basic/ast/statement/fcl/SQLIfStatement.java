package com.aliyun.gumiho.sql.basic.ast.statement.fcl;

import com.aliyun.gumiho.sql.basic.ast.SQLObject;
import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.SQLStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

import java.util.ArrayList;
import java.util.List;

/**
 * IF search_condition THEN statement_list
 * [ELSEIF search_condition THEN statement_list] ...
 * [ELSE statement_list]
 * END IF
 * https://dev.mysql.com/doc/refman/5.7/en/if.html
 * <p>
 * <p>
 * IF boolean_expression THEN statement [ statement ]...
 * [ ELSIF boolean_expression THEN statement [ statement ]... ]...
 * [ ELSE statement [ statement ]... ]
 * END IF ;
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/IF-statement.html
 *
 * @author kongtong.ouyang onCondition 2018/4/4.
 */
public class SQLIfStatement extends AbstractSQLStatement {

    protected SQLExpr condition;

    protected final List<SQLObject> statements = new ArrayList<>();

    protected final List<SQLElseIf> elseIfs = new ArrayList<>();

    protected final List<SQLObject> elseStatements = new ArrayList<>();


    public SQLIfStatement(DBType dbType) {
        super(dbType);
    }

    public SQLIfStatement(DBType dbType, SQLExpr condition, SQLStatement... stmts) {
        super(dbType);
        setCondition(condition);
        for (SQLStatement stmt : stmts) {
            this.addStatement(stmt);
        }
    }


    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, condition);
            this.acceptChild(visitor, statements);
            this.acceptChild(visitor, elseIfs);
            this.acceptChild(visitor, elseStatements);
        }
    }

    @Override
    public SQLIfStatement clone() {
        SQLIfStatement x = new SQLIfStatement(this.dbType);

        this.cloneTo(x);
        return x;
    }

    public void cloneTo(SQLIfStatement x) {
        super.cloneTo(x);

        SQLExpr conditionClone = this.condition.clone();
        x.setCondition(conditionClone);

        for (SQLObject i : statements) {
            SQLObject clone = i.clone();
            x.addStatement(clone);
        }

        for (SQLElseIf i : elseIfs) {
            SQLElseIf clone = i.clone();
            x.addElseIf(clone);
        }

        for (SQLObject i : elseStatements) {
            SQLObject clone = i.clone();
            x.addElseStatement(clone);
        }
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == condition) {
            setCondition(target);
            return true;
        }
        return false;
    }

    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.IF;
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

    public List<SQLElseIf> getElseIfs() {
        return elseIfs;
    }

    public void addElseIf(SQLElseIf elseIf) {
        if (elseIf == null) {
            return;
        }
        setChildParent(elseIf);
        this.elseIfs.add(elseIf);
    }

    public List<SQLObject> getElseStatements() {
        return elseStatements;
    }

    public void addElseStatement(SQLObject stmt) {
        if (stmt == null) {
            return;
        }
        setChildParent(stmt);
        this.elseStatements.add(stmt);
    }

    /**
     * ELSIF boolean_expression THEN statement [ statement ]...
     */
    public static class SQLElseIf extends AbstractSQLExpr {

        protected SQLExpr condition;

        protected final List<SQLObject> statements = new ArrayList<>();

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, condition);
                this.acceptChild(visitor, statements);
            }
        }

        @Override
        public boolean replace(SQLExpr source, SQLExpr target) {
            if (source == condition) {
                setCondition(target);
                return true;
            }
            return false;
        }

        @Override
        public SQLElseIf clone() {
            SQLElseIf x = new SQLElseIf();
            this.cloneTo(x);
            return x;
        }


        public void cloneTo(SQLElseIf x) {
            super.cloneTo(x);

            SQLExpr conditionClone = this.condition.clone();
            x.setCondition(conditionClone);

            for (SQLObject i : statements) {
                SQLObject clone = i.clone();
                x.addStatement(clone);
            }
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


    }


}
