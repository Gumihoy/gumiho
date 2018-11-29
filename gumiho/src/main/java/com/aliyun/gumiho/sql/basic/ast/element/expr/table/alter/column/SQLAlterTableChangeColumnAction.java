package com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.column;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.SQLColumnDefinition;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * CHANGE [COLUMN] old_col_name column_definition [FIRST|AFTER col_name]
 * <p>
 * https://dev.mysql.com/doc/refman/5.6/en/alter-table.html
 *
 * @author kongtong.ouyang on 2018/6/4.
 */
public class SQLAlterTableChangeColumnAction extends AbstractSQLExpr implements ISQLAlterTableColumnAction {

    protected boolean column;
    protected SQLExpr name;
    protected SQLColumnDefinition columnDefinition;
    protected SQLExpr property;


    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
            this.acceptChild(visitor, columnDefinition);
            this.acceptChild(visitor, property);
        }
    }

    @Override
    public SQLAlterTableChangeColumnAction clone() {
        SQLAlterTableChangeColumnAction x = new SQLAlterTableChangeColumnAction();

        x.column = this.column;

        SQLExpr nameClone = this.name.clone();
        x.setName(nameClone);

        SQLColumnDefinition columnDefinitionClone = this.columnDefinition.clone();
        x.setColumnDefinition(columnDefinitionClone);

        return x;
    }


    public boolean isColumn() {
        return column;
    }

    public void setColumn(boolean column) {
        this.column = column;
    }

    public SQLExpr getName() {
        return name;
    }

    public void setName(SQLExpr name) {
        setChildParent(name);
        this.name = name;
    }

    public SQLColumnDefinition getColumnDefinition() {
        return columnDefinition;
    }

    public void setColumnDefinition(SQLColumnDefinition columnDefinition) {
        setChildParent(columnDefinition);
        this.columnDefinition = columnDefinition;
    }

    public SQLExpr getProperty() {
        return property;
    }

    public void setProperty(SQLExpr property) {
        setChildParent(property);
        this.property = property;
    }
}
