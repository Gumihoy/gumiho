package com.aliyun.gumiho.sql.basic.ast.element.expr.index.alter;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.parallel.ISQLParallelClause;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * COALESCE [ CLEANUP ] [ parallel_clause ]
 * <p>
 * alter_index
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-INDEX.html#GUID-D8F648E7-8C07-4C89-BB71-862512536558
 *
 * @author kongtong.ouyang on 2018/7/9.
 */
public class SQLAlterIndexCoalesceAction extends AbstractSQLExpr implements ISQLAlterIndexAction {

    protected boolean cleanup;
    protected ISQLParallelClause parallelClause;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SQLAlterIndexCoalesceAction clone() {
        return new SQLAlterIndexCoalesceAction();
    }

    public boolean isCleanup() {
        return cleanup;
    }

    public void setCleanup(boolean cleanup) {
        this.cleanup = cleanup;
    }

    public ISQLParallelClause getParallelClause() {
        return parallelClause;
    }

    public void setParallelClause(ISQLParallelClause parallelClause) {
        setChildParent(parallelClause);
        this.parallelClause = parallelClause;
    }
}
