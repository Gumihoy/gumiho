package com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.partition;

import com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.ISQLAlterTableAction;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLSubPartitionType;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * TRUNCATE (SUBPARTITION|SUBPARTITIONS) alterTablePartitionItem (COMMA alterTablePartitionItem)*
 * ((DROP ALL? | REUSE) STORAGE)? updateIndexClause? parallelClause? CASCADE?
 * truncate_partition_subpart
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-TABLE.html#GUID-552E7373-BF93-477D-9DA3-B2C9386F2877
 *
 * @author kongtong.ouyang on 2018/6/4.
 */
public class SQLAlterTableTruncateSubPartitionAction extends AbstractSQLAlterTableTruncatePartitionAction implements ISQLAlterTableAction {

    protected SQLSubPartitionType type = SQLSubPartitionType.SUBPARTITION;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, items);
            this.acceptChild(visitor, updateIndexClause);
            this.acceptChild(visitor, parallelClause);
        }
    }

    @Override
    public SQLAlterTableTruncateSubPartitionAction clone() {
        SQLAlterTableTruncateSubPartitionAction x = new SQLAlterTableTruncateSubPartitionAction();
        this.cloneTo(x);
        return x;
    }

    public void cloneTo(SQLAlterTableTruncateSubPartitionAction x) {
        super.cloneTo(x);
        x.type = this.type;
    }


    public SQLSubPartitionType getType() {
        return type;
    }

    public void setType(SQLSubPartitionType type) {
        this.type = type;
    }
}
