package com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.partition;

import com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.ISQLAlterTableAction;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLPartitionType;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 *
 * TRUNCATE PARTITION {partition_names | ALL}
 * https://dev.mysql.com/doc/refman/5.6/en/alter-table.html
 *
 * truncate_partition_subpart
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-TABLE.html#GUID-552E7373-BF93-477D-9DA3-B2C9386F2877
 *
 * @author kongtong.ouyang on 2018/6/4.
 */
public class SQLAlterTableTruncatePartitionAction extends AbstractSQLAlterTableTruncatePartitionAction implements ISQLAlterTableAction {

    protected SQLPartitionType type = SQLPartitionType.PARTITION;


    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, items);
            this.acceptChild(visitor, updateIndexClause);
            this.acceptChild(visitor, parallelClause);
        }
    }

    @Override
    public SQLAlterTableTruncatePartitionAction clone() {
        SQLAlterTableTruncatePartitionAction x = new SQLAlterTableTruncatePartitionAction();
        this.cloneTo(x);
        x.type = this.type;
        return x;
    }

    public SQLPartitionType getType() {
        return type;
    }

    public void setType(SQLPartitionType type) {
        this.type = type;
    }
}
