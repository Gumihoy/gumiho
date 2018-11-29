package com.aliyun.gumiho.sql.dialect.mysql.ast.element.expr.index;

import com.aliyun.gumiho.sql.dialect.mysql.ast.element.expr.AbstractMySQLSQLExpr;
import com.aliyun.gumiho.sql.dialect.mysql.visitor.MySQLSQLASTVisitor;

/**
 * WITH PARSER parser_name
 * https://dev.mysql.com/doc/refman/5.6/en/alter-table.html
 *
 * @author kongtong.ouyang on 2018/7/29.
 */
public class MySQLSQLIndexOptionWithParser extends AbstractMySQLSQLExpr implements IMySQLSQLIndexOption {

    @Override
    public void accept0(MySQLSQLASTVisitor visitor) {

    }

    @Override
    public MySQLSQLIndexOptionWithParser clone() {
        MySQLSQLIndexOptionWithParser x = new MySQLSQLIndexOptionWithParser();
        super.cloneTo(x);
        return x;
    }
}
