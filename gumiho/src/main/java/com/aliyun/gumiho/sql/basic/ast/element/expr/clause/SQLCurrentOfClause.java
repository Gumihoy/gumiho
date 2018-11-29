package com.aliyun.gumiho.sql.basic.ast.element.expr.clause;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.condition.ISQLCondition;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * CURRENT OF <cursor name>
 * <p>
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#delete%20statement:%20positioned
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#update%20statement:%20positioned
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#dynamic%20delete%20statement:%20positioned
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#dynamic%20update%20statement:%20positioned
 *
 * @author kongtong.ouyang on 2018/5/9.
 */
public class SQLCurrentOfClause extends AbstractSQLExpr implements ISQLCondition {

    protected SQLName name;

    public SQLCurrentOfClause() {
    }

    public SQLCurrentOfClause(SQLName name) {
        setName(name);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
        }
    }

    @Override
    public SQLCurrentOfClause clone() {
        SQLCurrentOfClause x = new SQLCurrentOfClause();
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
