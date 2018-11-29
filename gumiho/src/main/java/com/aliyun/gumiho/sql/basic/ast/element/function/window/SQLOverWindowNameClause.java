package com.aliyun.gumiho.sql.basic.ast.element.function.window;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * over windowName
 * <p>
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#window%20function
 *
 * @author kongtong.ouyang on 2018/5/22.
 */
public class SQLOverWindowNameClause extends AbstractSQLExpr implements ISQLOverClause {

    protected SQLName name;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
        }
    }

    @Override
    public SQLOverWindowNameClause clone() {
        SQLOverWindowNameClause x = new SQLOverWindowNameClause();

        this.cloneTo(x);
        return x;
    }


    public void cloneTo(SQLOverWindowNameClause x) {
        super.cloneTo(x);

        SQLName nameClone = this.name.clone();
        x.setName(nameClone);
    }

    public SQLName getName() {
        return name;
    }

    public void setName(SQLName name) {
        this.name = name;
    }
}

