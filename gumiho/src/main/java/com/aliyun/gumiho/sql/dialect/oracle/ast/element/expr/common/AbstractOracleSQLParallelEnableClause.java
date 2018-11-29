package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.OracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/PARALLEL_ENABLE-clause.html#GUID-CFF3C7D3-6438-44C2-9FAF-569F246C37CA
 *
 * @author kongtong.ouyang on 2018/5/31.
 */
public abstract class AbstractOracleSQLParallelEnableClause extends AbstractOracleSQLExpr implements IOracleParallelEnableClause {

    protected SQLExpr argument;

    protected final List<SQLName> columns = new ArrayList<>();

    protected IOracleSQLStreamingClause streamingClause;

    @Override
    public AbstractOracleSQLParallelEnableClause clone() {
        throw new UnsupportedOperationException(getClass().getName());
    }


    public void cloneTo(AbstractOracleSQLParallelEnableClause x) {
        super.cloneTo(x);

        if (argument != null) {
            SQLExpr argumentClone = this.argument.clone();
            x.setArgument(argumentClone);
        }

        for (SQLName column : columns) {
            SQLName columnClone = column.clone();
            x.addColumn(columnClone);
        }

        if (streamingClause != null) {
            IOracleSQLStreamingClause streamingClauseClone = this.streamingClause.clone();
            x.setArgument(streamingClauseClone);
        }

    }

    public SQLExpr getArgument() {
        return argument;
    }

    public void setArgument(SQLExpr argument) {
        setChildParent(argument);
        this.argument = argument;
    }

    public List<SQLName> getColumns() {
        return columns;
    }

    public void addColumn(SQLName column) {
        if (column == null) {
            return;
        }
        setChildParent(column);
        this.columns.add(column);
    }

    public IOracleSQLStreamingClause getStreamingClause() {
        return streamingClause;
    }

    public void setStreamingClause(IOracleSQLStreamingClause streamingClause) {
        setChildParent(streamingClause);
        this.streamingClause = streamingClause;
    }

    /**
     * { ORDER | CLUSTER } expr BY (column [, column ]...)
     */
    public interface IOracleSQLStreamingClause extends OracleSQLExpr {
        @Override
        IOracleSQLStreamingClause clone();
    }

    /**
     * { ORDER | CLUSTER } expr BY (column [, column ]...)
     */
    public static abstract class AbstractOracleSQLStreamingClause extends AbstractOracleSQLExpr implements IOracleSQLStreamingClause {

        protected SQLExpr expr;

        protected final List<SQLExpr> columns = new ArrayList<>();

        @Override
        public AbstractOracleSQLStreamingClause clone() {
            throw new UnsupportedOperationException(getClass().getName());
        }

        public void cloneTo(AbstractOracleSQLStreamingClause x) {
            super.cloneTo(x);

            SQLExpr exprClone = expr.clone();
            x.setExpr(exprClone);

            for (SQLExpr column : columns) {
                SQLExpr columnClone = column.clone();
                x.addColumn(columnClone);
            }
        }

        public SQLExpr getExpr() {
            return expr;
        }

        public void setExpr(SQLExpr expr) {
            setChildParent(expr);
            this.expr = expr;
        }

        public List<SQLExpr> getColumns() {
            return columns;
        }

        public void addColumn(SQLExpr column) {
            if (column == null) {
                return;
            }
            setChildParent(column);
            this.columns.add(column);
        }

    }

    /**
     * { ORDER | CLUSTER } expr BY (column [, column ]...)
     */
    public static class OracleSQLStreamingClauseByOrder extends AbstractOracleSQLStreamingClause {

        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, expr);
                this.acceptChild(visitor, columns);
            }
        }
        @Override
        public OracleSQLStreamingClauseByOrder clone() {
            OracleSQLStreamingClauseByOrder x = new OracleSQLStreamingClauseByOrder();
            this.cloneTo(x);
            return x;
        }
    }

    public static class OracleSQLStreamingClusterByCluster extends AbstractOracleSQLStreamingClause {

        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, expr);
                this.acceptChild(visitor, columns);
            }
        }

        @Override
        public OracleSQLStreamingClusterByCluster clone() {
            OracleSQLStreamingClusterByCluster x = new OracleSQLStreamingClusterByCluster();
            this.cloneTo(x);
            return x;
        }
    }

}
