package com.aliyun.gumiho.sql.dialect.postgresql.ast.element.expr;

import com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.ISQLAlterTableAction;
import com.aliyun.gumiho.sql.dialect.postgresql.visitor.PostgreSQLSQLASTVisitor;

/**
 * $num
 *
 * @author kongtong.ouyang on 2018/7/18.
 */
public class PostgreSQLSQLPositionVariableExpr extends AbstractPostgreSQLSQLExpr implements ISQLAlterTableAction {

    protected long position;

    public PostgreSQLSQLPositionVariableExpr(long position) {
        this.position = position;
    }

    @Override
    public void accept0(PostgreSQLSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
        }
    }

    @Override
    public PostgreSQLSQLPositionVariableExpr clone() {
        PostgreSQLSQLPositionVariableExpr x = new PostgreSQLSQLPositionVariableExpr(this.position);
        return x;
    }


    public long getPosition() {
        return position;
    }

    public void setPosition(long position) {
        this.position = position;
    }
}
