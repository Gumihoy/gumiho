package com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.iot;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.ISQLAlterTableAction;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * alter_iot_clauses
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-TABLE.html#GUID-552E7373-BF93-477D-9DA3-B2C9386F2877
 *
 * @author kongtong.ouyang on 2018/7/11.
 */
public interface ISQLAlterTableIotAction extends ISQLAlterTableAction {
    @Override
    ISQLAlterTableIotAction clone();


    /**
     * COALESCE
     * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-TABLE.html#GUID-552E7373-BF93-477D-9DA3-B2C9386F2877
     */
    class SQLAlterTableCoalesceIotAction extends AbstractSQLExpr implements ISQLAlterTableIotAction {

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            visitor.visit(this);
        }

        @Override
        public SQLAlterTableCoalesceIotAction clone() {
            return new SQLAlterTableCoalesceIotAction();
        }
    }

}
