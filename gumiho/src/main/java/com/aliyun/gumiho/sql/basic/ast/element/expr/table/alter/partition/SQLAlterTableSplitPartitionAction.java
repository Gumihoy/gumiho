package com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.partition;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * SPLIT PARTITION name=nameIdentifier iAlterTableSplitPartitionActionItem
 * splitNestedTablePart? filterCondition? dependentTablesClause? updateIndexClause?
 * parallelClause? allowDisallowClustering? ONLINE?
 * <p>
 * split_table_partition
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-TABLE.html#GUID-552E7373-BF93-477D-9DA3-B2C9386F2877
 *
 * @author kongtong.ouyang on 2018/6/4.
 */
public class SQLAlterTableSplitPartitionAction extends AbstractSQLAlterTableSplitPartitionAction {

    protected SQLExpr name;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
        }
    }

    @Override
    public SQLAlterTableSplitPartitionAction clone() {
        SQLAlterTableSplitPartitionAction x = new SQLAlterTableSplitPartitionAction();
        this.cloneTo(x);
        return x;
    }

    public void cloneTo(SQLAlterTableSplitPartitionAction x) {
        super.cloneTo(x);


    }

    public SQLExpr getName() {
        return name;
    }

    public void setName(SQLExpr name) {
        setChildParent(name);
        this.name = name;
    }
}
