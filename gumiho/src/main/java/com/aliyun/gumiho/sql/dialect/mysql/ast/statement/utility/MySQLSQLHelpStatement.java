package com.aliyun.gumiho.sql.dialect.mysql.ast.statement.utility;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.dialect.mysql.ast.AbstractMySQLSQLObject;
import com.aliyun.gumiho.sql.dialect.mysql.visitor.MySQLSQLASTVisitor;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

/**
 * HELP 'search_string'
 * https://dev.mysql.com/doc/refman/8.0/en/help.html
 *
 * @author kongtong.ouyang on 2018/6/4.
 */
public class MySQLSQLHelpStatement extends AbstractMySQLSQLObject {

    protected SQLExpr value;

    @Override
    public void accept0(MySQLSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, value);
        }
    }

    @Override
    public SQLObjectType getObjectType() {
        return null;
    }

    public SQLExpr getValue() {
        return value;
    }

    public void setValue(SQLExpr value) {
        setChildParent(value);
        this.value = value;
    }
}
