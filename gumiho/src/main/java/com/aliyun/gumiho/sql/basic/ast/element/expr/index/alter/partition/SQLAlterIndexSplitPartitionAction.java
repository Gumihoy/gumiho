package com.aliyun.gumiho.sql.basic.ast.element.expr.index.alter.partition;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.parallel.ISQLParallelClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.partition.SQLPartitionDefinition;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * SPLIT PARTITION nameIdentifier AT LEFT_PAREN expr (COMMA expr)* RIGHT_PAREN
 * (INTO LEFT_PAREN partitionDefinition (COMMA partitionDefinition)* RIGHT_PAREN)?
 * parallelClause?
 * <p>
 * split_index_partition
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-INDEX.html#GUID-D8F648E7-8C07-4C89-BB71-862512536558
 *
 * @author kongtong.ouyang on 2018/7/10.
 */
public class SQLAlterIndexSplitPartitionAction extends AbstractSQLExpr implements ISQLAlterIndexPartitionAction {

    protected SQLExpr name;
    protected final List<SQLExpr> atItems = new ArrayList<>();
    protected final List<SQLPartitionDefinition> partitions = new ArrayList<>();
    protected ISQLParallelClause parallelClause;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
            this.acceptChild(visitor, atItems);
            this.acceptChild(visitor, partitions);
            this.acceptChild(visitor, parallelClause);
        }
    }

    @Override
    public SQLAlterIndexSplitPartitionAction clone() {
        SQLAlterIndexSplitPartitionAction x = new SQLAlterIndexSplitPartitionAction();
        SQLExpr nameClone = this.name.clone();
        x.setName(nameClone);
        return x;
    }


    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == name) {
            setName(target);
            return true;
        }
        return false;
    }

    public SQLExpr getName() {
        return name;
    }

    public void setName(SQLExpr name) {
        setChildParent(name);
        this.name = name;
    }

    public List<SQLExpr> getAtItems() {
        return atItems;
    }

    public void addItem(SQLExpr item) {
        if (item == null) {
            return;
        }
        setChildParent(item);
        this.atItems.add(item);
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

    public ISQLParallelClause getParallelClause() {
        return parallelClause;
    }

    public void setParallelClause(ISQLParallelClause parallelClause) {
        setChildParent(parallelClause);
        this.parallelClause = parallelClause;
    }
}
