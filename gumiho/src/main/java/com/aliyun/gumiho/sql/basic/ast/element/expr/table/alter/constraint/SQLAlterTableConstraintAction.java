package com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.constraint;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.ISQLAlterTableAction;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.column.SQLAlterTableAlterColumnAction;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLDeferrableType;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLInitiallyType;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * ALTER CONSTRAINT constraint_name [ DEFERRABLE | NOT DEFERRABLE ] [ INITIALLY DEFERRED | INITIALLY IMMEDIATE ]
 * https://www.postgresql.org/docs/devel/static/sql-altertable.html
 *
 * @author kongtong.ouyang on 2018/6/4.
 */
public class SQLAlterTableConstraintAction extends AbstractSQLExpr implements ISQLAlterTableAction {

    protected SQLName name;
    protected SQLDeferrableType deferrable;
    protected SQLInitiallyType initially;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
        }
    }

    @Override
    public SQLAlterTableAlterColumnAction clone() {
        return null;
    }


    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == name
                && target instanceof SQLName) {
            setName((SQLName) target);
            return true;
        }
        return false;
    }

    public SQLName getName() {
        return name;
    }

    public void setName(SQLName name) {
        setChildParent(name);
        this.name = name;
    }

    public SQLDeferrableType getDeferrable() {
        return deferrable;
    }

    public void setDeferrable(SQLDeferrableType deferrable) {
        this.deferrable = deferrable;
    }

    public SQLInitiallyType getInitially() {
        return initially;
    }

    public void setInitially(SQLInitiallyType initially) {
        this.initially = initially;
    }
}
