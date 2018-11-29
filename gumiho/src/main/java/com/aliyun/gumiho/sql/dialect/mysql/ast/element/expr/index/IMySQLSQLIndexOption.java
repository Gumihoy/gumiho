package com.aliyun.gumiho.sql.dialect.mysql.ast.element.expr.index;

import com.aliyun.gumiho.sql.basic.ast.element.expr.index.property.ISQLIndexProperty;
import com.aliyun.gumiho.sql.dialect.mysql.ast.element.expr.MySQLSQLExpr;

/**
 * index_option
 * https://dev.mysql.com/doc/refman/8.0/en/alter-table.html
 *
 * @author kongtong.ouyang on 2018/7/29.
 */
public interface IMySQLSQLIndexOption extends MySQLSQLExpr, ISQLIndexProperty {
    @Override
    IMySQLSQLIndexOption clone();
}
