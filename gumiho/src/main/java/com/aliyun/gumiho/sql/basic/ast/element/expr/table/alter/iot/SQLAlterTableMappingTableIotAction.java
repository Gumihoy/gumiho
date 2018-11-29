package com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.iot;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * MAPPING TABLE { allocate_extent_clause | deallocate_unused_clause}
 * <p>
 * alter_mapping_table_clauses
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-TABLE.html#GUID-552E7373-BF93-477D-9DA3-B2C9386F2877
 *
 * @author kongtong.ouyang on 2018/7/17.
 */
public class SQLAlterTableMappingTableIotAction extends AbstractSQLExpr implements ISQLAlterTableIotAction {

    protected SQLExpr expr;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, expr);
        }
    }

    @Override
    public SQLAlterTableMappingTableIotAction clone() {
        SQLAlterTableMappingTableIotAction x = new SQLAlterTableMappingTableIotAction();
        return x;
    }




    public SQLExpr getExpr() {
        return expr;
    }

    public void setExpr(SQLExpr expr) {
        setChildParent(expr);
        this.expr = expr;
    }
}
