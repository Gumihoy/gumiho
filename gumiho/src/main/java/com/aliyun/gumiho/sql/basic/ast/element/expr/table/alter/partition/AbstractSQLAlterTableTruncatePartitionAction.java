package com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.partition;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.parallel.ISQLParallelClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.ISQLUpdateIndexClause;
import com.aliyun.gumiho.sql.basic.ast.enums.ISQLEnum;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.hash.FNVHash;

import java.util.ArrayList;
import java.util.List;

/**
 * TRUNCATE PARTITION {partition_names | ALL}
 * https://dev.mysql.com/doc/refman/5.6/en/alter-table.html
 *
 * TRUNCATE partition_extended_names [ { DROP [ ALL ] | REUSE } STORAGE ] [ CASCADE ] [ update_index_clauses [ parallel_clause ] ]
 * <p>
 * partition_extended_names: { PARTITION | PARTITIONS } partition | { FOR ( partition_key_value [, partition_key_value ]... ) } [, partition | { FOR ( partition_key_value [, partition_key_value ]... ) } ]...
 * truncate_partition_subpart
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-TABLE.html#GUID-552E7373-BF93-477D-9DA3-B2C9386F2877
 *
 * @author kongtong.ouyang on 2018/6/4.
 */
public abstract class AbstractSQLAlterTableTruncatePartitionAction extends AbstractSQLExpr implements ISQLAlterTablePartitionAction {

    protected final List<SQLExpr> items = new ArrayList<>();
    protected SQLStorageType storageType;
    protected boolean cascade;
    protected ISQLUpdateIndexClause updateIndexClause;
    protected ISQLParallelClause parallelClause;

    @Override
    public AbstractSQLAlterTableTruncatePartitionAction clone() {
        throw new UnsupportedOperationException(getClass().getName());
    }

    public void cloneTo(AbstractSQLAlterTableTruncatePartitionAction x) {
        super.cloneTo(x);
        for (SQLExpr item : items) {
            SQLExpr itemClone = item.clone();
            x.addItem(itemClone);
        }

        x.cascade = this.cascade;

        if (this.updateIndexClause != null) {
            ISQLUpdateIndexClause updateIndexClauseClone = this.updateIndexClause.clone();
            x.setUpdateIndexClause(updateIndexClauseClone);
        }

        if (this.parallelClause != null) {
            ISQLParallelClause parallelClauseClone = this.parallelClause.clone();
            x.setParallelClause(parallelClauseClone);
        }
    }



    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        boolean replace = replaceInList(items, source, target, this);
        if (replace) {
            return true;
        }


        return false;
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


    public SQLStorageType getStorageType() {
        return storageType;
    }

    public void setStorageType(SQLStorageType storageType) {
        this.storageType = storageType;
    }

    public boolean isCascade() {
        return cascade;
    }

    public void setCascade(boolean cascade) {
        this.cascade = cascade;
    }

    public ISQLUpdateIndexClause getUpdateIndexClause() {
        return updateIndexClause;
    }

    public void setUpdateIndexClause(ISQLUpdateIndexClause updateIndexClause) {
        setChildParent(updateIndexClause);
        this.updateIndexClause = updateIndexClause;
    }

    public ISQLParallelClause getParallelClause() {
        return parallelClause;
    }

    public void setParallelClause(ISQLParallelClause parallelClause) {
        setChildParent(parallelClause);
        this.parallelClause = parallelClause;
    }



    public enum SQLStorageType implements ISQLEnum {
        DROP_STORAGE(SQLReserved.DROP_STORAGE),
        DROP_ALL_STORAGE(SQLReserved.DROP_ALL_STORAGE),
        REUSE_STORAGE(SQLReserved.REUSE_STORAGE),;

        public final SQLReserved name;

        SQLStorageType(SQLReserved name) {
            this.name = name;
        }

        public static SQLStorageType of (String name) {
            long lowerHash = FNVHash.fnv1a_64_lower(name);
            for (SQLStorageType item : SQLStorageType.values()) {
                if (item.name.lowerHashCode64 == lowerHash) {
                    return item;
                }
            }
            return null;
        }

        @Override
        public SQLReserved getName() {
            return name;
        }

        @Override
        public String toString() {
            return name.upper;
        }
    }
}
