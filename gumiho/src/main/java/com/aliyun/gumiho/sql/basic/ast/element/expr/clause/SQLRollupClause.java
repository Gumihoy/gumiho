package com.aliyun.gumiho.sql.basic.ast.element.expr.clause;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * ROLLUP <left paren> <ordinary grouping set list> <right paren>
 * <p>
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#grouping%20element
 * <p>
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#rollup%20list
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/SELECT.html#GUID-CFA006CA-6FF1-4972-821E-6996142A51C6
 *
 * @author kongtong.ouyang on 2018/5/2.
 */
public class SQLRollupClause extends AbstractSQLExpr {

    protected final List<SQLExpr> items = new ArrayList<>();


    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, items);
        }
    }

    @Override
    public SQLRollupClause clone() {
        SQLRollupClause x = new SQLRollupClause();

        for (SQLExpr item : items) {
            SQLExpr clone = item.clone();
            x.addItem(clone);
        }
        return x;
    }

    public List<SQLExpr> getItems() {
        return items;
    }

    public void addItem(SQLExpr item) {
        if (item == null) {
            return;
        }
        setChildParent(item);
        this.items.add(item);
    }


}
