package com.aliyun.gumiho.sql.dialect.drds.ast.element.expr.table.partition;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.partition.ISQLPartitionBy;

import java.util.List;

/**
 * https://help.aliyun.com/document_detail/71300.html?spm=a2c4g.11186623.6.691.2490989ffJMNAN
 *
 * @author kongtong.ouyang on 2018/8/28.
 */
public interface IDRDSSQLDBPartitionBy extends ISQLPartitionBy {
    @Override
    IDRDSSQLDBPartitionBy clone();


    List<SQLExpr> getColumns();

    void addColumn(SQLExpr column);

    IDRDSSQLTBPartitionBy getTbPartitionBy();

    void setTbPartitionBy(IDRDSSQLTBPartitionBy tbPartitionBy);


}
