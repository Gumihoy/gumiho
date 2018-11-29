package com.aliyun.gumiho.sql.basic.ast.element.expr.select.limit;

import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLRowType;
import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * [ OFFSET start [ ROW | ROWS ] ] [ FETCH { FIRST | NEXT } [ count ] { ROW | ROWS } ONLY ]
 * [ OFFSET offset { ROW | ROWS } ] [ FETCH { FIRST | NEXT } [ { rowcount | percent PERCENT } ] { ROW | ROWS } { ONLY | WITH TIES } ]
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/SELECT.html#GUID-CFA006CA-6FF1-4972-821E-6996142A51C6
 * <p>
 * https://www.postgresql.org/docs/devel/static/sql-values.html
 *
 * @author kongtong.ouyang onCondition 2018/3/21.
 */
public class SQLOffsetFetchClause extends AbstractSQLExpr implements ISQLLimitClause {

    protected SQLExpr offsetExpr;
    private SQLRowType offSetRowType;

    private SQLFetchType fetchType;
    private SQLExpr rowCountExpr;
    private boolean percent;
    private SQLRowType fetchRowType;
    private SQLFetchOnlyType onlyType;


    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, offsetExpr);
            this.acceptChild(visitor, rowCountExpr);
        }
    }

    @Override
    public SQLOffsetFetchClause clone() {

        SQLOffsetFetchClause x = new SQLOffsetFetchClause();

        if (this.offsetExpr != null) {
            SQLExpr offsetExprClone = this.offsetExpr.clone();
            x.setOffsetExpr(offsetExprClone);
        }
        x.offSetRowType = this.offSetRowType;

        x.fetchType = this.fetchType;
        if (this.rowCountExpr != null) {
            SQLExpr rowCountExprClone = this.rowCountExpr.clone();
            x.setRowCountExpr(rowCountExprClone);
        }
        x.percent = this.percent;

        x.fetchRowType = this.fetchRowType;
        x.onlyType = this.onlyType;

        return x;
    }

    public void cloneTo(SQLOffsetFetchClause x) {
        super.cloneTo(x);
    }


    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == offsetExpr) {
            this.setOffsetExpr(target);
            return true;
        }

        if (source == rowCountExpr) {
            this.setRowCountExpr(target);
            return true;
        }
        return false;
    }

    public SQLExpr getOffsetExpr() {
        return offsetExpr;
    }

    public void setOffsetExpr(SQLExpr offsetExpr) {
        setChildParent(offsetExpr);
        this.offsetExpr = offsetExpr;
    }

    public SQLRowType getOffSetRowType() {
        return offSetRowType;
    }

    public void setOffSetRowType(SQLRowType offSetRowType) {
        this.offSetRowType = offSetRowType;
    }

    public SQLFetchType getFetchType() {
        return fetchType;
    }

    public void setFetchType(SQLFetchType fetchType) {
        this.fetchType = fetchType;
    }

    public SQLExpr getRowCountExpr() {
        return rowCountExpr;
    }

    public void setRowCountExpr(SQLExpr rowCountExpr) {
        setChildParent(rowCountExpr);
        this.rowCountExpr = rowCountExpr;
    }

    public boolean isPercent() {
        return percent;
    }

    public void setPercent(boolean percent) {
        this.percent = percent;
    }

    public SQLRowType getFetchRowType() {
        return fetchRowType;
    }

    public void setFetchRowType(SQLRowType fetchRowType) {
        this.fetchRowType = fetchRowType;
    }

    public SQLFetchOnlyType getOnlyType() {
        return onlyType;
    }

    public void setOnlyType(SQLFetchOnlyType onlyType) {
        this.onlyType = onlyType;
    }

    public enum SQLFetchType {
        FIRST, NEXT;
    }

    public enum SQLFetchOnlyType {
        ONLY(SQLReserved.ONLY), WITH_TIES(SQLReserved.WITH_TIES);

        public final SQLReserved name;

        SQLFetchOnlyType(SQLReserved name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name.upper;
        }
    }
}
