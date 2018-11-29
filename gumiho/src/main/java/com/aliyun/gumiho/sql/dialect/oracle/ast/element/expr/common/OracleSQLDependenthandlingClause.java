package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common;

import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.constraint.option.SQExceptionsClause;
import com.aliyun.gumiho.sql.basic.ast.enums.ISQLEnum;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.OracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

/**
 * { INVALIDATE
 * | CASCADE [ { [ NOT ] INCLUDING TABLE DATA
 * | CONVERT TO SUBSTITUTABLE
 * }
 * ]
 * [ [FORCE ] exceptions_clause ]
 * }
 * <p>
 * dependent_handling_clause
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/ALTER-TYPE-statement.html#GUID-A8B449E7-E3A8-48F4-A4C6-5BB87B1841CD
 *
 * @author kongtong.ouyang on 2018/9/11.
 */
public interface OracleSQLDependenthandlingClause extends OracleSQLExpr {
    @Override
    OracleSQLDependenthandlingClause clone();

    /**
     * INVALIDATE
     */
    class OracleSQLInvalidate extends AbstractOracleSQLExpr implements OracleSQLDependenthandlingClause {
        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            visitor.visit(this);
        }

        @Override
        public OracleSQLInvalidate clone() {
            return new OracleSQLInvalidate();
        }
    }


    /**
     * CASCADE [ { [ NOT ] INCLUDING TABLE DATA | CONVERT TO SUBSTITUTABLE}] [ [FORCE ] exceptions_clause ]
     */
    class OracleSQLCascade extends AbstractOracleSQLExpr implements OracleSQLDependenthandlingClause {

        protected SQLCascadeOption option;
        protected boolean force;
        protected SQExceptionsClause exceptionsClause;

        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, exceptionsClause);
            }
        }

        @Override
        public OracleSQLCascade clone() {
            OracleSQLCascade x = new OracleSQLCascade();
            return x;
        }

        public SQLCascadeOption getOption() {
            return option;
        }

        public void setOption(SQLCascadeOption option) {
            this.option = option;
        }

        public boolean isForce() {
            return force;
        }

        public void setForce(boolean force) {
            this.force = force;
        }

        public SQExceptionsClause getExceptionsClause() {
            return exceptionsClause;
        }

        public void setExceptionsClause(SQExceptionsClause exceptionsClause) {
            setChildParent(exceptionsClause);
            this.exceptionsClause = exceptionsClause;
        }
    }

    /**
     * [ NOT ] INCLUDING TABLE DATA | CONVERT TO SUBSTITUTABLE
     */
    enum SQLCascadeOption implements ISQLEnum {
        INCLUDING_TABLE_DATA(SQLReserved.INCLUDING_TABLE_DATA),
        NOT_INCLUDING_TABLE_DATA(SQLReserved.NOT_INCLUDING_TABLE_DATA),
        CONVERT_TO_SUBSTITUTABLE(SQLReserved.CONVERT_TO_SUBSTITUTABLE),;

        public final SQLReserved name;

        SQLCascadeOption(SQLReserved name) {
            this.name = name;
        }

        @Override
        public SQLReserved getName() {
            return name;
        }

        @Override
        public String toString() {
            return name.upper;
        }
    }
}
