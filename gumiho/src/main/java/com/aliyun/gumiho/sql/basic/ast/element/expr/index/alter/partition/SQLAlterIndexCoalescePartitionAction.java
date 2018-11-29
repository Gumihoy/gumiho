package com.aliyun.gumiho.sql.basic.ast.element.expr.index.alter.partition;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.parallel.ISQLParallelClause;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * COALESCE PARTITION [ parallel_clause ]
 *
 *
 * coalesce_index_partition
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-INDEX.html#GUID-D8F648E7-8C07-4C89-BB71-862512536558
 * @author kongtong.ouyang on 2018/7/10.
 */
public class SQLAlterIndexCoalescePartitionAction extends AbstractSQLExpr implements ISQLAlterIndexPartitionAction {

    protected ISQLParallelClause parallelClause;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, parallelClause);
        }
    }

    @Override
    public SQLAlterIndexCoalescePartitionAction clone() {
        SQLAlterIndexCoalescePartitionAction x = new SQLAlterIndexCoalescePartitionAction();
        return x;
    }


    public ISQLParallelClause getParallelClause() {
        return parallelClause;
    }

    public void setParallelClause(ISQLParallelClause parallelClause) {
        setChildParent(parallelClause);
        this.parallelClause = parallelClause;
    }
}
