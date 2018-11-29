package com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.trigger;

import com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.ISQLAlterTableAction;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * DISABLE TRIGGER [ trigger_name | ALL | USER ]
 * https://www.postgresql.org/docs/devel/static/sql-altertable.html
 * @author kongtong.ouyang on 2018/6/4.
 */
public class SQLAlterTableDisableTriggerAction extends AbstractSQLAlterTableTriggerAction implements ISQLAlterTableAction {

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
        }
    }

    @Override
    public SQLAlterTableDisableTriggerAction clone() {
        SQLAlterTableDisableTriggerAction x = new SQLAlterTableDisableTriggerAction();
        this.cloneTo(x);
        return x;
    }

}
