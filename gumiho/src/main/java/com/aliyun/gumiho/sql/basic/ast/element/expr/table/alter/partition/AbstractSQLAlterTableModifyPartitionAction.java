package com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.partition;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.parallel.ISQLParallelClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.ISQLUpdateIndexClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.SQLDependentTablesClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.partition.sub.SQLSubPartitionDefinition;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * MODIFY <PARTITION nameIdentifier | PARTITION FOR LEFT_PAREN nameIdentifier (COMMA nameIdentifier)* RIGHT_PAREN>
 * <p>
 * <p>
 * MODIFY <SUBPARTITION nameIdentifier | SUBPARTITION FOR LEFT_PAREN nameIdentifier (COMMA nameIdentifier)* RIGHT_PAREN>
 * <p>
 * modify_table_partition
 * modify_table_subpartition
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-TABLE.html#GUID-552E7373-BF93-477D-9DA3-B2C9386F2877
 *
 * @author kongtong.ouyang on 2018/7/12.
 */
public abstract class AbstractSQLAlterTableModifyPartitionAction extends AbstractSQLExpr implements ISQLAlterTablePartitionAction {

    protected final List<SQLExpr> items = new ArrayList<>();

    @Override
    public AbstractSQLAlterTableModifyPartitionAction clone() {
        throw new UnsupportedOperationException(getClass().getName());
    }

    public void cloneTo(AbstractSQLAlterTableModifyPartitionAction x) {
        super.cloneTo(x);

        for (SQLExpr item : items) {
            SQLExpr itemClone = item.clone();
            x.addItem(itemClone);
        }
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


    /**
     * ADD VALUES LEFT_PAREN expr (COMMA expr)* RIGHT_PAREN
     */
    public static class SQLModifyPartitionAddValuesAction extends AbstractSQLExpr {
        protected final List<SQLExpr> items = new ArrayList<>();
        @Override
        protected void accept0(SQLASTVisitor visitor) {
            if(visitor.visit(this)) {
                this.acceptChild(visitor, items);
            }
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
    }


    /**
     * DROP VALUES LEFT_PAREN expr (COMMA expr)* RIGHT_PAREN
     */
    public static class SQLModifyPartitionDropValuesAction extends AbstractSQLExpr {
        protected final List<SQLExpr> items = new ArrayList<>();
        @Override
        protected void accept0(SQLASTVisitor visitor) {
            if(visitor.visit(this)) {
                this.acceptChild(visitor, items);
            }
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
    }

    /**
     * REBUILD? UNUSABLE LOCAL INDEXES
     */
    public static class SQLModifyPartitionUnusableLocalIndexesAction extends AbstractSQLExpr {
        protected boolean rebuild = false;
        @Override
        protected void accept0(SQLASTVisitor visitor) {
            visitor.visit(this);
        }

        public boolean isRebuild() {
            return rebuild;
        }

        public void setRebuild(boolean rebuild) {
            this.rebuild = rebuild;
        }
    }


    /**
     * ADD subpartition [, subpartition ]... [ dependent_tables_clause ] [ update_index_clauses ] [ parallel_clause ]
     * <p>
     * add_range_subpartition、add_hash_subpartition、add_list_subpartition
     * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-TABLE.html#GUID-552E7373-BF93-477D-9DA3-B2C9386F2877
     *
     * @author kongtong.ouyang on 2018/7/12.
     */
    public static class SQLModifyPartitionAddSubPartitionAction extends AbstractSQLExpr {

        protected final List<SQLSubPartitionDefinition> subPartitions = new ArrayList<>();
        protected SQLDependentTablesClause dependentTables;
        protected ISQLUpdateIndexClause updateIndex;
        protected ISQLParallelClause parallel;

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, subPartitions);
            }
        }

        @Override
        public SQLModifyPartitionAddSubPartitionAction clone() {
            SQLModifyPartitionAddSubPartitionAction x = new SQLModifyPartitionAddSubPartitionAction();
            this.cloneTo(x);
            return x;
        }

        public void cloneTo(SQLModifyPartitionAddSubPartitionAction x) {
            super.cloneTo(x);

        }

        public List<SQLSubPartitionDefinition> getSubPartitions() {
            return subPartitions;
        }

        public void addSubSubPartition(SQLSubPartitionDefinition subPartition) {
            if (subPartition == null) {
                return;
            }
            setChildParent(subPartition);
            this.subPartitions.add(subPartition);
        }

        public SQLDependentTablesClause getDependentTables() {
            return dependentTables;
        }

        public void setDependentTables(SQLDependentTablesClause dependentTables) {
            setChildParent(dependentTables);
            this.dependentTables = dependentTables;
        }

        public ISQLUpdateIndexClause getUpdateIndex() {
            return updateIndex;
        }

        public void setUpdateIndex(ISQLUpdateIndexClause updateIndex) {
            setChildParent(updateIndex);
            this.updateIndex = updateIndex;
        }

        public ISQLParallelClause getParallel() {
            return parallel;
        }

        public void setParallel(ISQLParallelClause parallel) {
            setChildParent(parallel);
            this.parallel = parallel;
        }
    }




}