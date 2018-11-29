package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * SCOPE <table name>
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#scope%20clause
 *
 * @author kongtong.ouyang on 2018/7/29.
 */
public class SQLScopeClause extends AbstractSQLExpr  {

    protected SQLName name;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
        }
    }

    @Override
    public SQLScopeClause clone() {
        SQLScopeClause x = new SQLScopeClause();
        SQLName nameClone = this.name.clone();
        x.setName(nameClone);
        return x;
    }

    public SQLName getName() {
        return name;
    }

    public void setName(SQLName name) {
        setChildParent(name);
        this.name = name;
    }
}
