package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.ast.element.expr.select.ISQLSelectQuery;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.SQLSelectQuery;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * MULTISET (subquery)
 *
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#xref-multiset%20value%20constructor%20by%20query
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CAST.html#GUID-5A70235E-1209-4281-8521-B94497AAEF75
 *
 * @author kongtong.ouyang on 2018/4/27.
 */
public class SQLMultisetExpr extends AbstractSQLExpr {

    protected ISQLSelectQuery subQuery;

    public SQLMultisetExpr(ISQLSelectQuery subQuery) {
        setSubQuery(subQuery);
    }

    @Override
    public void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, subQuery);
        }
    }

    public ISQLSelectQuery getSubQuery() {
        return subQuery;
    }

    public void setSubQuery(ISQLSelectQuery subQuery) {
        setChildParent(subQuery);
        this.subQuery = subQuery;
    }
}
