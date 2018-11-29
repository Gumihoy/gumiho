package com.aliyun.gumiho.sql.basic.ast.element.expr.clause;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#window%20clause
 *
 * @author kongtong.ouyang on 2018/5/2.
 */
public class SQLWindowClause extends AbstractSQLExpr {

    public final List<SQLWindowClauseItem> items = new ArrayList<>();

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        // TODO;
//        if (visitor.visit(this)) {
//            this.acceptChild(visitor, items);
//        }
    }


    @Override
    public SQLWindowClause clone() {
        SQLWindowClause x = new SQLWindowClause();
        this.cloneTo(x);
        return x;
    }

    public void cloneTo(SQLWindowClause x) {
        super.cloneTo(x);


    }

    public List<SQLWindowClauseItem> getItems() {
        return items;
    }

    public class SQLWindowClauseItem extends AbstractSQLExpr {

        protected SQLName name;


        @Override
        protected void accept0(SQLASTVisitor visitor) {

        }


    }
}
