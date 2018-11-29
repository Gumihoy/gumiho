package com.aliyun.gumiho.sql.basic.ast.element.expr.view.alter;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.constraint.table.ISQLTableConstraint;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * DROP UNIQUE (column [, column ]...)
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-VIEW.html#GUID-0DEDE960-B481-4B55-8027-EA9E4C863625
 * @author kongtong.ouyang on 2018/7/13.
 */
public class SQLAlterViewDropUniqueConstraintAction extends AbstractSQLExpr implements ISQLAlterViewAction {

    protected final List<SQLExpr> columns = new ArrayList<>();

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, columns);
        }
    }

    @Override
    public SQLAlterViewDropUniqueConstraintAction clone() {
        SQLAlterViewDropUniqueConstraintAction x = new SQLAlterViewDropUniqueConstraintAction();
        for (SQLExpr column : columns) {
            SQLExpr columnClone = column.clone();
            x.addColumn(columnClone);
        }
        return x;
    }

    public List<SQLExpr> getColumns() {
        return columns;
    }

    public void addColumn(SQLExpr column) {
        if (column == null) {
            return;
        }
        setChildParent(column);
        this.columns.add(column);
    }

}
