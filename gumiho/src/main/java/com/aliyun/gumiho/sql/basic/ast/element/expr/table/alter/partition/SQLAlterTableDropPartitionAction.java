package com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.partition;

import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * DROP PARTITION name [,name]
 * https://dev.mysql.com/doc/refman/8.0/en/alter-table.html
 * <p>
 * <p>
 * DROP (PARTITION | PARTITIONS) dropPartitionActionItem (COMMA dropPartitionActionItem)*
 * nameIdentifier | FOR LEFT_PAREN names+=nameIdentifier (COMMA names+=nameIdentifier)
 * drop_table_partition
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-TABLE.html#GUID-552E7373-BF93-477D-9DA3-B2C9386F2877
 *
 * @author kongtong.ouyang on 2018/6/4.
 */
public class SQLAlterTableDropPartitionAction extends AbstractSQLAlterTableDropPartitionAction implements ISQLAlterTablePartitionAction {

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, items);
            this.acceptChild(visitor, updateIndex);
            this.acceptChild(visitor, parallel);
        }
    }

    @Override
    public SQLAlterTableDropPartitionAction clone() {
        SQLAlterTableDropPartitionAction x = new SQLAlterTableDropPartitionAction();
        this.cloneTo(x);
        return x;
    }

    public void cloneTo(SQLAlterTableDropPartitionAction x) {
        super.cloneTo(x);
    }

}
