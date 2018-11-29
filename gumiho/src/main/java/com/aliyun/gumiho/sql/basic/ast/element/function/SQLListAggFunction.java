package com.aliyun.gumiho.sql.basic.ast.element.function;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.function.aggreate.AbstractSQLAggregateFunction;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * LISTAGG( [ ALL ]measure_expr [, 'delimiter'] [listagg_overflow_clause] )
 * WITHIN GROUP (order_by_clause) [OVER query_partition_clause]
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/LISTAGG.html#GUID-B6E50D8E-F467-425B-9436-F7F8BF38D466
 *
 * @author kongtong.ouyang on 2018/5/22.
 */
public class SQLListAggFunction extends AbstractSQLAggregateFunction {

    protected SQLExpr listAggOverflowClause;

    public SQLListAggFunction() {
        super(SQLReserved.LISTAGG.ofExpr());
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, arguments);
            this.acceptChild(visitor, listAggOverflowClause);
            this.acceptChild(visitor, withinGroup);
            this.acceptChild(visitor, overClause);
        }
    }


    public SQLExpr getListAggOverflowClause() {
        return listAggOverflowClause;
    }

    public void setListAggOverflowClause(SQLExpr listAggOverflowClause) {
        setChildParent(listAggOverflowClause);
        this.listAggOverflowClause = listAggOverflowClause;
    }


    public interface SQLListAggOverflowClause extends SQLExpr {
    }

    /**
     * ON OVERFLOW TRUNCATE indicator=[ 'truncation-indicator' ]  withCount=[ { WITH | WITHOUT } COUNT ]
     */
    public static class SQLOnOverflowTruncateClause extends AbstractSQLExpr implements SQLListAggOverflowClause {

        protected SQLExpr indicator;

        protected SQLReserved withCount;


        @Override
        protected void accept0(SQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, indicator);
            }
        }

        @Override
        public SQLOnOverflowTruncateClause clone() {
            SQLOnOverflowTruncateClause x = new SQLOnOverflowTruncateClause();

            SQLExpr indicatorClone = this.indicator.clone();
            x.setIndicator(indicatorClone);

            x.withCount = this.withCount;

            return x;
        }

        public SQLExpr getIndicator() {
            return indicator;
        }

        public void setIndicator(SQLExpr indicator) {
            setChildParent(indicator);
            this.indicator = indicator;
        }

        public SQLReserved getWithCount() {
            return withCount;
        }

        public void setWithCount(SQLReserved withCount) {
            this.withCount = withCount;
        }
    }

}
