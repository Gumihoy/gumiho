package com.aliyun.gumiho.sql.basic.ast.element.expr.user;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * IDENTIFIED WITH auth_plugin
 * https://dev.mysql.com/doc/refman/5.7/en/create-user.html
 *
 * @author kongtong.ouyang on 2018/6/20.
 */
public class SQLIdentifiedWithClause extends AbstractSQLExpr {

    protected SQLExpr authPlugin;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, authPlugin);
        }
    }

    public SQLExpr getAuthPlugin() {
        return authPlugin;
    }

    public void setAuthPlugin(SQLExpr authPlugin) {
        setChildParent(authPlugin);
        this.authPlugin = authPlugin;
    }
}
