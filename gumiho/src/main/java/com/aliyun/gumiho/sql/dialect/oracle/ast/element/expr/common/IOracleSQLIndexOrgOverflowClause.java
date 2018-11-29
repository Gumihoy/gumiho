package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.iot.ISQLAlterTableIotAction;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.OracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

/**
 * index_org_overflow_clause
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-TABLE.html#GUID-F9CE0CC3-13AE-4744-A43C-EAC7A71AAAB6
 *
 * @author kongtong.ouyang on 2018/9/5.
 */
public interface IOracleSQLIndexOrgOverflowClause extends OracleSQLExpr, ISQLAlterTableIotAction {
    @Override
    IOracleSQLIndexOrgOverflowClause clone();


    class OracleSQLIncludeClause extends AbstractOracleSQLExpr implements IOracleSQLIndexOrgOverflowClause {
        protected SQLExpr name;

        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, name);
            }
        }

        @Override
        public OracleSQLOverflowExpr clone() {
            OracleSQLOverflowExpr x = new OracleSQLOverflowExpr();

            return x;
        }

        @Override
        public boolean replace(SQLExpr source, SQLExpr target) {
            if (source == name) {
                setName(target);
                return true;
            }
            return false;
        }

        public SQLExpr getName() {
            return name;
        }

        public void setName(SQLExpr name) {
            setChildParent(name);
            this.name = name;
        }
    }

    /**
     * OVERFLOW
     */
    class OracleSQLOverflowExpr extends AbstractOracleSQLExpr implements IOracleSQLIndexOrgOverflowClause {
        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            visitor.visit(this);
        }

        @Override
        public OracleSQLOverflowExpr clone() {
            return new OracleSQLOverflowExpr();
        }
    }


}
