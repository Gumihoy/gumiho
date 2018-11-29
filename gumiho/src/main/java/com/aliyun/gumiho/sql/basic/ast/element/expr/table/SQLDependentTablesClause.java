package com.aliyun.gumiho.sql.basic.ast.element.expr.table;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.partition.SQLPartitionDefinition;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * DEPENDENT TABLES ( table ( partition_spec [, partition_spec]... [, table ( partition_spec [, partition_spec]... ] ))
 * <p>
 * dependent_tables_clause
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-TABLE.html#GUID-552E7373-BF93-477D-9DA3-B2C9386F2877
 *
 * @author kongtong.ouyang on 2018/7/12.
 */
public class SQLDependentTablesClause extends AbstractSQLExpr {

    protected final List<Item> items = new ArrayList<>();

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, items);
        }
    }

    @Override
    public SQLExpr clone() {
        return super.clone();
    }


    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        if (item == null) {
            return;
        }
        setChildParent(item);
        this.items.add(item);
    }

    public static class Item extends AbstractSQLExpr {

        protected SQLName name;
        protected final List<SQLPartitionDefinition> partitions = new ArrayList<>();

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, name);
                this.acceptChild(visitor, partitions);
            }
        }

        @Override
        public SQLExpr clone() {
            return super.clone();
        }

        public SQLName getName() {
            return name;
        }

        public void setName(SQLName name) {
            this.name = name;
        }

        public List<SQLPartitionDefinition> getPartitions() {
            return partitions;
        }

        public void addPartition(SQLPartitionDefinition partition) {
            if (partition == null) {
                return;
            }
            setChildParent(partition);
            this.partitions.add(partition);
        }
    }
}
