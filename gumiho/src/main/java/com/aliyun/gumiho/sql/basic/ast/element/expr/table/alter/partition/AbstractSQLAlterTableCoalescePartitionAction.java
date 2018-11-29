package com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.partition;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.parallel.ISQLParallelClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.ISQLUpdateIndexClause;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLAllowDisallowClusteringType;

/**
 * COALESCE PARTITION [ update_index_clauses ] [ parallel_clause ] [ allow_disallow_clustering ]
 * COALESCE SUBPARTITION subpartition [update_index_clauses] [parallel_clause] [allow_disallow_clustering]
 * <p>
 * coalesce_table_partition
 * coalesce_table_subpartition
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-TABLE.html#GUID-552E7373-BF93-477D-9DA3-B2C9386F2877
 *
 * @author kongtong.ouyang on 2018/6/4.
 */
public abstract class AbstractSQLAlterTableCoalescePartitionAction extends AbstractSQLExpr implements ISQLAlterTablePartitionAction {

    protected SQLExpr expr;
    protected ISQLUpdateIndexClause updateIndex;
    protected ISQLParallelClause parallel;
    protected SQLAllowDisallowClusteringType allowDisallowClustering;

    @Override
    public AbstractSQLAlterTableCoalescePartitionAction clone() {
        throw new UnsupportedOperationException(this.getClass().getName());
    }

    public void cloneTo(AbstractSQLAlterTableCoalescePartitionAction x) {
        super.cloneTo(x);

        SQLExpr exprClone = expr.clone();
        x.setExpr(exprClone);

    }

    public SQLExpr getExpr() {
        return expr;
    }

    public void setExpr(SQLExpr expr) {
        setChildParent(expr);
        this.expr = expr;
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

    public SQLAllowDisallowClusteringType getAllowDisallowClustering() {
        return allowDisallowClustering;
    }

    public void setAllowDisallowClustering(SQLAllowDisallowClusteringType allowDisallowClustering) {
        this.allowDisallowClustering = allowDisallowClustering;
    }
}
