package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * EVALUATE USING { CURRENT EDITION | EDITION edition | NULL EDITION }
 * <p>
 * evaluation_edition_clause
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-MATERIALIZED-VIEW.html#GUID-EE262CA4-01E5-4618-B659-6165D993CA1B
 *
 * @author kongtong.ouyang on 2018/6/21.
 */
public class SQLEvaluationEditionClause extends AbstractSQLExpr {

    protected SQLExpr action;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, action);
        }
    }

    public SQLExpr getAction() {
        return action;
    }

    public void setAction(SQLExpr action) {
        setChildParent(action);
        this.action = action;
    }

    /**
     * CURRENT EDITION
      */
    public static class SQLCurrentEditionAction extends AbstractSQLExpr {

        public static SQLCurrentEditionAction of() {
            return new SQLCurrentEditionAction();
        }

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            visitor.visit(this);
        }

        @Override
        public SQLCurrentEditionAction clone() {
            return new SQLCurrentEditionAction();
        }
    }

    /**
     * EDITION edition
     */
    public static class SQLEditionAction extends AbstractSQLExpr {

        protected SQLExpr edition;

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, edition);
            }
        }

        public SQLExpr getEdition() {
            return edition;
        }

        public void setEdition(SQLExpr edition) {
            setChildParent(edition);
            this.edition = edition;
        }
    }

    /**
     *  NULL EDITION
     */
    public static class SQLNullEditionAction extends AbstractSQLExpr {

        public static SQLNullEditionAction of() {
            return new SQLNullEditionAction();
        }

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            visitor.visit(this);
        }

        @Override
        public SQLNullEditionAction clone() {
            return new SQLNullEditionAction();
        }

    }
}
