package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common;

import com.aliyun.gumiho.sql.basic.ast.element.expr.ISQLPhysicalProperty;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * CLUSTER cluster (column [, column ]...)
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-MATERIALIZED-VIEW.html#GUID-EE262CA4-01E5-4618-B659-6165D993CA1B
 *
 * @author kongtong.ouyang on 2018/6/22.
 */
public class OracleSQLPhysicalPropertyClusterClause extends AbstractOracleSQLExpr implements ISQLPhysicalProperty {

    protected SQLExpr cluster;

    protected final List<SQLExpr> columns = new ArrayList<>();


    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, cluster);
            this.acceptChild(visitor, columns);
        }
    }

    @Override
    public OracleSQLPhysicalPropertyClusterClause clone() {
        OracleSQLPhysicalPropertyClusterClause x = new OracleSQLPhysicalPropertyClusterClause();

        SQLExpr clusterClone = this.cluster.clone();
        x.setCluster(clusterClone);

        for (SQLExpr column : this.columns) {
            SQLExpr columnClone = column.clone();
            x.addColumn(columnClone);
        }

        return x;
    }

    public SQLExpr getCluster() {
        return cluster;
    }

    public String getClusterName() {
        if (cluster instanceof  SQLName) {
            return ((SQLName) cluster).getName();
        }
        return null;
    }

    public void setCluster(SQLExpr cluster) {
        setChildParent(cluster);
        this.cluster = cluster;
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
