package com.aliyun.gumiho.sql.basic.ast.element.expr.index;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.index.attribute.ISQLIndexAttribute;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLStoreInClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.index.property.ISQLIndexProperty;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.partition.SQLPartitionDefinition;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * LOCAL ( PARTITION [ partition ] [ { segment_attributes_clause | index_compression }... ] [ USABLE | UNUSABLE ] [, PARTITION [ partition ] [ { segment_attributes_clause | index_compression }... ] [ USABLE | UNUSABLE ] ]...)
 * <p>
 * local_partitioned_index
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-INDEX.html#GUID-1F89BBC0-825F-4215-AF71-7588E31D8BFE
 *
 * @author kongtong.ouyang on 2018/7/6.
 */
public class SQLLocalPartitionIndex extends AbstractSQLExpr implements ISQLIndexProperty {

    protected SQLStoreInClause storeInClause;

    protected final List<SQLPartitionDefinition> items = new ArrayList<>();

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, storeInClause);
            this.acceptChild(visitor, items);
        }
    }

    @Override
    public SQLLocalPartitionIndex clone() {
        SQLLocalPartitionIndex x = new SQLLocalPartitionIndex();
        if (storeInClause != null) {
            SQLStoreInClause storeInClauseClone = storeInClause.clone();
            x.setStoreInClause(storeInClauseClone);
        }

        for (SQLPartitionDefinition item : this.items) {
            SQLPartitionDefinition itemClone = item.clone();
            x.addItem(itemClone);
        }
        return x;
    }

    public SQLStoreInClause getStoreInClause() {
        return storeInClause;
    }

    public void setStoreInClause(SQLStoreInClause storeInClause) {
        setChildParent(storeInClause);
        this.storeInClause = storeInClause;
    }

    public List<SQLPartitionDefinition> getItems() {
        return items;
    }

    public void addItem(SQLPartitionDefinition item) {
        if (item == null) {
            return;
        }
        setChildParent(item);
        this.items.add(item);
    }
}
