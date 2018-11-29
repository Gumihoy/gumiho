package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * WITH OBJECT { IDENTIFIER | ID } { DEFAULT | ( attribute [, attribute ]... ) }
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-VIEW.html#GUID-61D2D2B4-DACC-4C7C-89EB-7E50D9594D30
 *
 * @author kongtong.ouyang on 2018/7/13.
 */
public interface ISQLWithObjectIdClause extends SQLExpr {

    SQLExpr getExpr();

    @Override
    ISQLWithObjectIdClause clone();


    /**
     * WITH OBJECT { IDENTIFIER | ID } { DEFAULT | ( attribute [, attribute ]... ) }
     * <p>
     * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-VIEW.html#GUID-61D2D2B4-DACC-4C7C-89EB-7E50D9594D30
     *
     * @author kongtong.ouyang on 2018/7/13.
     */
    abstract class AbstractSQLWithObjectIdClause extends AbstractSQLExpr implements ISQLWithObjectIdClause {

        protected SQLExpr expr;

        @Override
        public AbstractSQLWithObjectIdClause clone() {
            throw new UnsupportedOperationException(getClass().getName());
        }

        public void cloneTo(AbstractSQLWithObjectIdClause x) {
            super.cloneTo(x);
            SQLExpr exprClone = this.expr.clone();
            x.setExpr(exprClone);
        }

        @Override
        public boolean replace(SQLExpr source, SQLExpr target) {
            if (source == expr) {
                setExpr(target);
                return true;
            }
            return false;
        }

        @Override
        public SQLExpr getExpr() {
            return expr;
        }

        public void setExpr(SQLExpr expr) {
            setChildParent(expr);
            this.expr = expr;
        }
    }

    /**
     * WITH OBJECT ID { DEFAULT | ( attribute [, attribute ]... ) }
     */
    class SQLWithObjectIdClause extends AbstractSQLWithObjectIdClause {

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, expr);
            }
        }

        @Override
        public SQLWithObjectIdClause clone() {
            SQLWithObjectIdClause x = new SQLWithObjectIdClause();
            this.cloneTo(x);
            return x;
        }

    }

    /**
     * WITH OBJECT IDENTIFIER { DEFAULT | ( attribute [, attribute ]... ) }
     */
    class SQLWithObjectIdentifierClause extends AbstractSQLWithObjectIdClause {

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, expr);
            }
        }

        @Override
        public SQLWithObjectIdentifierClause clone() {
            SQLWithObjectIdentifierClause x = new SQLWithObjectIdentifierClause();
            this.cloneTo(x);
            return x;
        }

    }

}
