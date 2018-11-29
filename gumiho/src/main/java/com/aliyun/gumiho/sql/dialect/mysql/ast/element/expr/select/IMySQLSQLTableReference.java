package com.aliyun.gumiho.sql.dialect.mysql.ast.element.expr.select;

import com.aliyun.gumiho.sql.basic.ast.element.expr.select.ISQLTableReference;
import com.aliyun.gumiho.sql.dialect.mysql.ast.element.expr.MySQLSQLExpr;

/**
 * @author kongtong.ouyang on 2018/6/7.
 */
public interface IMySQLSQLTableReference extends MySQLSQLExpr, ISQLTableReference {

    @Override
    IMySQLSQLTableReference clone();
}
