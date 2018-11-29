package com.aliyun.gumiho.sql.basic.ast.statement.dal;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

import java.util.ArrayList;
import java.util.List;

/**
 * SET DEFAULT ROLE {NONE | ALL | role [, role ] ...} TO user [, user ] ...
 * <p>
 * https://dev.mysql.com/doc/refman/8.0/en/set-default-role.html
 *
 * @author kongtong.ouyang on 2018/7/26.
 */
public class SQLSetDefaultRoleStatement extends AbstractSQLStatement {

    protected final List<SQLExpr> roles = new ArrayList<>();
    protected final List<SQLExpr> users = new ArrayList<>();

    public SQLSetDefaultRoleStatement(DBType dbType) {
        super(dbType);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, roles);
            this.acceptChild(visitor, users);
        }
    }

    @Override
    public SQLSetDefaultRoleStatement clone() {
        SQLSetDefaultRoleStatement x = new SQLSetDefaultRoleStatement(this.dbType);

        return x;
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        boolean replace = replaceInList(roles, source, target,this);
        if (replace) {
            return true;
        }

        replace = replaceInList(users, source, target,this);
        if (replace) {
            return true;
        }

        return false;
    }

    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.SET_DEFAULT_ROLE;
    }



    public List<SQLExpr> getRoles() {
        return roles;
    }

    public void addRole(SQLExpr role) {
        if (role == null) {
            return;
        }
        setChildParent(role);
        this.roles.add(role);
    }

    public List<SQLExpr> getUsers() {
        return users;
    }

    public void addUser(SQLExpr user) {
        if (user == null) {
            return;
        }
        setChildParent(user);
        this.roles.add(user);
    }
}
