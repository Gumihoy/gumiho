package com.aliyun.gumiho.sql.basic.ast.element.expr.clause;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#empty%20grouping%20set
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#grouping%20element
 *
 * @author kongtong.ouyang on 2018/5/2.
 */
public class SQLEmptyGroupingSet extends AbstractSQLExpr {

    @Override
    protected void accept0(SQLASTVisitor visitor) {

    }

    @Override
    public SQLExpr clone() {
        SQLEmptyGroupingSet x = new SQLEmptyGroupingSet();
        return x;
    }
}
