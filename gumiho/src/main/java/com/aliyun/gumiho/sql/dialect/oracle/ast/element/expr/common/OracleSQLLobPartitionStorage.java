package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * PARTITION partition { LOB_storage_clause | varray_col_properties }... [ (SUBPARTITION subpartition { LOB_partitioning_storage | varray_col_properties }... ) ]
 *
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-TABLE.html#GUID-F9CE0CC3-13AE-4744-A43C-EAC7A71AAAB6
 *
 * @author kongtong.ouyang on 2018/6/25.
 */
public class OracleSQLLobPartitionStorage extends AbstractOracleSQLExpr {

    protected SQLExpr name;
    protected final List<SQLExpr> items = new ArrayList<>();


    protected SQLExpr subPartitionName;
    protected final List<SQLExpr> subPartitionItems = new ArrayList<>();

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
            this.acceptChild(visitor, items);
            this.acceptChild(visitor, subPartitionName);
            this.acceptChild(visitor, subPartitionItems);
        }
    }

    public SQLExpr getName() {
        return name;
    }

    public void setName(SQLExpr name) {
        setChildParent(name);
        this.name = name;
    }

    public List<SQLExpr> getItems() {
        return items;
    }

    public void addItem(SQLExpr item) {
        if (item == null) {
            return;
        }
        setChildParent(item);
        this.items.add(item);
    }

    public SQLExpr getSubPartitionName() {
        return subPartitionName;
    }

    public void setSubPartitionName(SQLExpr subPartitionName) {
        setChildParent(subPartitionName);
        this.subPartitionName = subPartitionName;
    }

    public List<SQLExpr> getSubPartitionItems() {
        return subPartitionItems;
    }

    public void addSubPartitionItem(SQLExpr item) {
        if (item == null) {
            return;
        }
        setChildParent(item);
        this.subPartitionItems.add(item);
    }
}
