package com.aliyun.gumiho.sql.dialect.mysql.ast.element.expr.index;

import com.aliyun.gumiho.sql.dialect.mysql.ast.element.expr.AbstractMySQLSQLExpr;
import com.aliyun.gumiho.sql.dialect.mysql.visitor.MySQLSQLASTVisitor;

/**
 * USING HASH
 * https://dev.mysql.com/doc/refman/5.6/en/alter-table.html
 *
 * @author kongtong.ouyang on 2018/7/29.
 */
public class MySQLSQLIndexOptionUsingHash extends AbstractMySQLSQLExpr implements IMySQLSQLIndexOption {

    @Override
    public void accept0(MySQLSQLASTVisitor visitor) {

    }

    @Override
    public MySQLSQLIndexOptionUsingHash clone() {
        MySQLSQLIndexOptionUsingHash x = new MySQLSQLIndexOptionUsingHash();
        super.cloneTo(x);
        return x;
    }
}
