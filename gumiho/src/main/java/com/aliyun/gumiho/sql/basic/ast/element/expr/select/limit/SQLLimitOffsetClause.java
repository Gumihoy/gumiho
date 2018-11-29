package com.aliyun.gumiho.sql.basic.ast.element.expr.select.limit;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLRowType;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * [LIMIT {[offset,] row_count | row_count OFFSET offset}]
 * https://dev.mysql.com/doc/refman/8.0/en/select.html
 * <p>
 * [ LIMIT { count | ALL } ] [ OFFSET start [ ROW | ROWS ] ]
 * [LIMIT {[offset,] row_count | row_count OFFSET offset}]
 * https://www.postgresql.org/docs/devel/static/sql-select.html
 *
 * @author kongtong.ouyang on 2018/5/2.
 */
public class SQLLimitOffsetClause extends AbstractSQLExpr implements ISQLLimitClause {

    protected boolean offset;
    protected SQLExpr offsetExpr;
    protected SQLExpr rowCountExpr;

    private SQLRowType offSetRowType;


    public SQLLimitOffsetClause() {
    }

    public SQLLimitOffsetClause(SQLExpr rowCountExpr) {
        setRowCountExpr(rowCountExpr);
    }

    public SQLLimitOffsetClause(SQLExpr offsetExpr, SQLExpr rowCountExpr) {
        setOffsetExpr(offsetExpr);
        setRowCountExpr(rowCountExpr);
    }

    public SQLLimitOffsetClause(SQLExpr rowCountExpr, boolean offset, SQLExpr offsetExpr) {
        setOffsetExpr(offsetExpr);
        setRowCountExpr(rowCountExpr);
        this.offset = offset;
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, offsetExpr);
            this.acceptChild(visitor, rowCountExpr);
        }
    }

    @Override
    public SQLLimitOffsetClause clone() {
        SQLExpr rowCountClone = this.rowCountExpr.clone();
        SQLLimitOffsetClause x = new SQLLimitOffsetClause(rowCountClone);

        x.offset = this.offset;
        if (this.offsetExpr != null) {
            SQLExpr offsetExprClone = this.offsetExpr.clone();
            x.setOffsetExpr(offsetExprClone);
        }

        x.offSetRowType = this.offSetRowType;

        return x;
    }

    public void cloneTo(SQLLimitOffsetClause x) {
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



    public boolean isOffset() {
        return offset;
    }

    public void setOffset(boolean offset) {
        this.offset = offset;
    }

    public SQLExpr getOffsetExpr() {
        return offsetExpr;
    }

    public void setOffsetExpr(SQLExpr offsetExpr) {
        setChildParent(offsetExpr);
        this.offsetExpr = offsetExpr;
    }

    public SQLExpr getRowCountExpr() {
        return rowCountExpr;
    }

    public void setRowCountExpr(SQLExpr rowCountExpr) {
        setChildParent(rowCountExpr);
        this.rowCountExpr = rowCountExpr;
    }

    public SQLRowType getOffSetRowType() {
        return offSetRowType;
    }

    public void setOffSetRowType(SQLRowType offSetRowType) {
        this.offSetRowType = offSetRowType;
    }
}
