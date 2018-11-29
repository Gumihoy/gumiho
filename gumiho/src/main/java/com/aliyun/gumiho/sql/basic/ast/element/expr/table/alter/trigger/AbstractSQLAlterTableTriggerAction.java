package com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.trigger;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.ISQLAlterTableAction;

/**
 * DISABLE TRIGGER [ trigger_name | ALL | USER ]
 * https://www.postgresql.org/docs/devel/static/sql-altertable.html
 * @author kongtong.ouyang on 2018/6/4.
 */
public abstract class AbstractSQLAlterTableTriggerAction extends AbstractSQLExpr implements ISQLAlterTableAction {

    protected SQLExpr name;

    @Override
    public AbstractSQLAlterTableTriggerAction clone() {
        throw new UnsupportedOperationException(getClass().getName());
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
}
