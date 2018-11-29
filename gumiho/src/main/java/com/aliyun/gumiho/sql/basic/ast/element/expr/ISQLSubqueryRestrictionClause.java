package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.enums.ISQLEnum;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * [ WITH [ <levels clause> ] CHECK OPTION ]
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#view%20definition
 * <p>
 * WITH { READ ONLY | CHECK OPTION } [ CONSTRAINT constraint ]
 * subquery_restriction_clause
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-VIEW.html#GUID-61D2D2B4-DACC-4C7C-89EB-7E50D9594D30
 *
 * @author kongtong.ouyang on 2018/7/13.
 */
public interface ISQLSubqueryRestrictionClause extends SQLExpr {

    SQLName getConstraint();

    @Override
    ISQLSubqueryRestrictionClause clone();


    abstract class AbstractSQLSubqueryRestrictionClause extends AbstractSQLExpr implements ISQLSubqueryRestrictionClause {

        protected SQLName constraint;

        @Override
        public AbstractSQLSubqueryRestrictionClause clone() {
            throw new UnsupportedOperationException(getClass().getName());
        }

        public void cloneTo(AbstractSQLSubqueryRestrictionClause x) {
            super.cloneTo(x);

            if (constraint != null) {
                SQLName constraintClone = this.constraint.clone();
                x.setConstraint(constraintClone);
            }
        }


        @Override
        public boolean replace(SQLExpr source, SQLExpr target) {
            if (source == constraint
                    && target instanceof SQLName) {
                setConstraint((SQLName) target);
                return true;
            }
            return false;
        }

        @Override
        public SQLName getConstraint() {
            return constraint;
        }

        public String getConstraintName() {
            if (constraint == null) {
                return null;
            }
            return constraint.getName();
        }

        public void setConstraint(SQLName constraint) {
            setChildParent(constraint);
            this.constraint = constraint;
        }
    }

    /**
     * WITH [ <levels clause> ] CHECK OPTION [ CONSTRAINT constraint ]
     */
    class SQLWithCheckOption extends AbstractSQLSubqueryRestrictionClause implements ISQLSubqueryRestrictionClause {

        protected SQLLevels levels;

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, constraint);
            }
        }

        @Override
        public SQLWithCheckOption clone() {
            SQLWithCheckOption x = new SQLWithCheckOption();
            this.cloneTo(x);
            return x;
        }


        public SQLLevels getLevels() {
            return levels;
        }

        public void setLevels(SQLLevels levels) {
            this.levels = levels;
        }

    }


    /**
     * WITH READ ONLY [ CONSTRAINT constraint ]
     */
    class SQLWithReadOnly extends AbstractSQLSubqueryRestrictionClause implements ISQLSubqueryRestrictionClause {

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, constraint);
            }
        }

        @Override
        public SQLWithReadOnly clone() {
            SQLWithReadOnly x = new SQLWithReadOnly();
            this.cloneTo(x);
            return x;
        }


    }

    enum SQLLevels implements ISQLEnum {

        CASCADED(SQLReserved.CASCADED),
        LOCAL(SQLReserved.LOCAL);
        public final SQLReserved name;

        SQLLevels(SQLReserved name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name.upper;
        }

        @Override
        public SQLReserved getName() {
            return name;
        }
    }

}
