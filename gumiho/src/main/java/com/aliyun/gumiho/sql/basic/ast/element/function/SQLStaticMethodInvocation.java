package com.aliyun.gumiho.sql.basic.ast.element.function;

import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.util.SQLUtils;

/**
 * owner::name()
 * <p>
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#static%20method%20invocation
 *
 * @author kongtong.ouyang on 2018/4/28.
 */
public class SQLStaticMethodInvocation extends AbstractSQLFunction {

    protected SQLName owner;

    public SQLStaticMethodInvocation(String owner, String name) {
        super(name);
        setOwner(SQLUtils.ofName(owner));
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, owner);
            this.acceptChild(visitor, nameExpr);
            this.acceptChild(visitor, arguments);
        }
    }


    public SQLName getOwner() {
        return owner;
    }

    public void setOwner(SQLName owner) {
        setChildParent(owner);
        this.owner = owner;
    }
}
