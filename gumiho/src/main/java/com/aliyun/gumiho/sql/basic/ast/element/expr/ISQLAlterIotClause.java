package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * alter_iot_clauses
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-TABLE.html#GUID-552E7373-BF93-477D-9DA3-B2C9386F2877
 *
 * @author kongtong.ouyang on 2018/7/16.
 */
public interface ISQLAlterIotClause extends SQLExpr {
    @Override
    ISQLAlterIotClause clone();

    /**
     * COALESCE
     *
     * alter_iot_clauses
     * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-TABLE.html#GUID-552E7373-BF93-477D-9DA3-B2C9386F2877
     */
    class SQLCoalesceClause extends AbstractSQLExpr implements ISQLAlterIotClause {
        @Override
        public void accept0(SQLASTVisitor visitor) {
            visitor.visit(this);
        }

        @Override
        public SQLCoalesceClause clone() {
            return new SQLCoalesceClause();
        }
    }
}
