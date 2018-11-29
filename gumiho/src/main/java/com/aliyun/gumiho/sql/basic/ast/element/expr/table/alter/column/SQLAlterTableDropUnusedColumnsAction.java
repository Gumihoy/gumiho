package com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.column;

import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * DROP UNUSED COLUMNS [ CHECKPOINT integer ]
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-TABLE.html#GUID-552E7373-BF93-477D-9DA3-B2C9386F2877
 *
 * @author kongtong.ouyang on 2018/6/4.
 */
public class SQLAlterTableDropUnusedColumnsAction extends AbstractSQLAlterTableDropColumnAction implements ISQLAlterTableDropColumnAction {

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, checkPoint);
        }
    }

    @Override
    public SQLAlterTableDropUnusedColumnsAction clone() {
        SQLAlterTableDropUnusedColumnsAction x = new SQLAlterTableDropUnusedColumnsAction();
        this.cloneTo(x);
        return x;
    }


}
