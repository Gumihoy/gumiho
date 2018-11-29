package com.aliyun.gumiho.sql.basic.ast.element.function;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.order.SQLOrderByClause;
import com.aliyun.gumiho.sql.basic.ast.element.function.aggreate.AbstractSQLAggregateFunction;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * aggregate_function KEEP (DENSE_RANK LAST ORDER BY expr [ DESC | ASC ] [ NULLS { FIRST | LAST } ] [, expr [ DESC | ASC ] [ NULLS { FIRST | LAST } ] ]... )
 * [ OVER ( [query_partition_clause] ) ]
 *
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/LAST.html#GUID-4E16BC0E-D3B8-4BA4-8F97-3A08891A85CC
 *
 * @author kongtong.ouyang on 2018/5/22.
 */
public class SQLLastFunction extends AbstractSQLAggregateFunction {

    protected SQLOrderByClause orderByClause;

    public SQLLastFunction(SQLExpr name) {
        super(name);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, nameExpr);
            this.acceptChild(visitor, orderByClause);
        }
    }

    public SQLOrderByClause getOrderByClause() {
        return orderByClause;
    }

    public void setOrderByClause(SQLOrderByClause orderByClause) {
        this.orderByClause = orderByClause;
    }
}
