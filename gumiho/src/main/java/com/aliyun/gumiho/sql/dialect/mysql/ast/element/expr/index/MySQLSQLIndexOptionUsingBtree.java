package com.aliyun.gumiho.sql.dialect.mysql.ast.element.expr.index;

import com.aliyun.gumiho.sql.dialect.mysql.ast.element.expr.AbstractMySQLSQLExpr;
import com.aliyun.gumiho.sql.dialect.mysql.visitor.MySQLSQLASTVisitor;

/**
 * USING BTREE
 * https://dev.mysql.com/doc/refman/5.6/en/alter-table.html
 *
 * @author kongtong.ouyang on 2018/7/29.
 */
public class MySQLSQLIndexOptionUsingBtree extends AbstractMySQLSQLExpr implements IMySQLSQLIndexOption {

    @Override
    public void accept0(MySQLSQLASTVisitor visitor) {

    }

    @Override
    public MySQLSQLIndexOptionUsingBtree clone() {
        MySQLSQLIndexOptionUsingBtree x = new MySQLSQLIndexOptionUsingBtree();
        super.cloneTo(x);
        return x;
    }
}
