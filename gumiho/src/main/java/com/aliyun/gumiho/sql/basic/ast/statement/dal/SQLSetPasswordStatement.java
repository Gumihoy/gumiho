package com.aliyun.gumiho.sql.basic.ast.statement.dal;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

/**
 * SET PASSWORD [FOR user] = 'auth_string' [REPLACE 'current_auth_string']
 * <p>
 * https://dev.mysql.com/doc/refman/8.0/en/set-password.html
 *
 * @author kongtong.ouyang on 2018/7/26.
 */
public class SQLSetPasswordStatement extends AbstractSQLStatement {

    protected SQLExpr user;
    protected SQLExpr password;
    protected SQLExpr replace;


    public SQLSetPasswordStatement(DBType dbType) {
        super(dbType);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, user);
            this.acceptChild(visitor, password);
            this.acceptChild(visitor, replace);
        }
    }

    @Override
    public SQLSetCharSetStatement clone() {
        SQLSetCharSetStatement x = new SQLSetCharSetStatement(this.dbType);
        this.cloneTo(x);
        return x;
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        return super.replace(source, target);
    }

    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.SET_PASSWORD;
    }



    public SQLExpr getUser() {
        return user;
    }

    public void setUser(SQLExpr user) {
        setChildParent(user);
        this.user = user;
    }

    public SQLExpr getPassword() {
        return password;
    }

    public void setPassword(SQLExpr password) {
        setChildParent(password);
        this.password = password;
    }

    public SQLExpr getReplace() {
        return replace;
    }

    public void setReplace(SQLExpr replace) {
        setChildParent(replace);
        this.replace = replace;
    }

}
