package com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.constraint;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLVisibleType;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * ALTER INDEX index_name {VISIBLE | INVISIBLE}
 * https://dev.mysql.com/doc/refman/8.0/en/alter-table.html
 *
 * @author kongtong.ouyang on 2018/7/29.
 */
public class SQLAlterTableAlterIndexConstraintAction extends AbstractSQLExpr implements ISQLAlterTableConstraintAction {

    protected SQLExpr name;
    protected SQLVisibleType visible;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
        }
    }

    @Override
    public SQLAlterTableAlterIndexConstraintAction clone() {
        SQLAlterTableAlterIndexConstraintAction x = new SQLAlterTableAlterIndexConstraintAction();

        return x;
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == name) {
            setName(target);
            return true;
        }
        return false;
    }

    public SQLExpr getName() {
        return name;
    }

    public void setName(SQLExpr name) {
        setChildParent(name);
        this.name = name;
    }

    public SQLVisibleType getVisible() {
        return visible;
    }

    public void setVisible(SQLVisibleType visible) {
        this.visible = visible;
    }
}
