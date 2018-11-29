package com.aliyun.gumiho.sql.basic.ast.element.expr.user;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * IDENTIFIED BY PASSWORD password
 * <p>
 * https://dev.mysql.com/doc/refman/5.7/en/create-user.html
 *
 * @author kongtong.ouyang on 2018/6/20.
 */
public class SQLIdentifiedByPasswordClause extends AbstractSQLExpr {

    protected SQLExpr password;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, password);
        }
    }

    public SQLExpr getPassword() {
        return password;
    }

    public void setPassword(SQLExpr password) {
        setChildParent(password);
        this.password = password;
    }
}
