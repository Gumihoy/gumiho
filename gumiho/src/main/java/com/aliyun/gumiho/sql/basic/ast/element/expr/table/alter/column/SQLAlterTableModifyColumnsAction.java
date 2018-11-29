package com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.column;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.ISQLColumnDefinition;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * MODIFY { ( modify_col_properties | modify_virtcol_properties [, modify_col_properties | modify_virtcol_properties ]... ) | ( modify_col_visibility [, modify_col_visibility ]... ) | modify_col_substitutable }
 * modify_column_clauses
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-TABLE.html#GUID-552E7373-BF93-477D-9DA3-B2C9386F2877
 *
 * @author kongtong.ouyang on 2018/6/4.
 */
public class SQLAlterTableModifyColumnsAction extends AbstractSQLExpr implements ISQLAlterTableColumnAction {

    protected final List<ISQLColumnDefinition> columns = new ArrayList<>();

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, columns);
        }
    }

    @Override
    public SQLAlterTableModifyColumnsAction clone() {
        SQLAlterTableModifyColumnsAction x = new SQLAlterTableModifyColumnsAction();
        for (ISQLColumnDefinition column : columns) {
            ISQLColumnDefinition columnClone =  column.clone();
            x.addColumn(columnClone);
        }

        return x;
    }

    public List<ISQLColumnDefinition> getColumns() {
        return columns;
    }

    public void addColumn(ISQLColumnDefinition column) {
        if (column == null) {
            return;
        }
        setChildParent(column);
        this.columns.add(column);
    }

}
