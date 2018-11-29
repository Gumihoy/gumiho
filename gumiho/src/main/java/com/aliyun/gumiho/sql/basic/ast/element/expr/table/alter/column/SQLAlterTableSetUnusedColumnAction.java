package com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.column;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * SET UNUSED { COLUMN column | (column [, column ]...) } [ { CASCADE CONSTRAINTS | INVALIDATE }... ] [ ONLINE ]
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-TABLE.html#GUID-552E7373-BF93-477D-9DA3-B2C9386F2877
 *
 * @author kongtong.ouyang on 2018/6/4.
 */
public class SQLAlterTableSetUnusedColumnAction extends AbstractSQLAlterTableDropColumnAction {

    protected boolean column;
    protected boolean paren = true;
    protected final List<SQLExpr> columns = new ArrayList<>();
    protected boolean online;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, columns);
        }
    }

    @Override
    public SQLAlterTableSetUnusedColumnAction clone() {
        SQLAlterTableSetUnusedColumnAction x = new SQLAlterTableSetUnusedColumnAction();
        x.column = this.column;

        for (SQLExpr column : this.columns) {
            SQLExpr columnClone = column.clone();
            x.addColumn(columnClone);
        }

        return x;
    }


    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        boolean replace = replaceInList(columns, source, target, this);
        if (replace) {
            return true;
        }


        return false;
    }


    public boolean isColumn() {
        return column;
    }

    public void setColumn(boolean column) {
        this.column = column;
    }

    public boolean isParen() {
        return paren;
    }

    public void setParen(boolean paren) {
        this.paren = paren;
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


    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }


}
