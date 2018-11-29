package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

import java.util.List;

/**
 * RESULT_CACHE [ RELIES_ON ( [ data_source [, data_source]... ] ) ]
 *
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/RESULT_CACHE-clause.html#GUID-7B0FFFDF-C953-46E5-9FD6-C41DFBDE1B0B
 *
 * @author kongtong.ouyang on 2018/5/31.
 */
public class OracleSQLResultCacheClause extends AbstractOracleSQLExpr {

    protected List<SQLExpr> dataSources;

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, dataSources);
        }
    }


    public List<SQLExpr> getDataSources() {
        return dataSources;
    }

    public void addDataSource(SQLExpr dataSource) {
        if (dataSource == null) {
            return;
        }
        setChildParent(dataSource);
        this.dataSources.add(dataSource);
    }
}
