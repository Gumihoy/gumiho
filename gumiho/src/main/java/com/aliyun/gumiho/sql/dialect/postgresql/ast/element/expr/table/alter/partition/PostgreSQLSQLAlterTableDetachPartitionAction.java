package com.aliyun.gumiho.sql.dialect.postgresql.ast.element.expr.table.alter.partition;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.ISQLAlterTableAction;
import com.aliyun.gumiho.sql.dialect.postgresql.ast.element.expr.AbstractPostgreSQLSQLExpr;
import com.aliyun.gumiho.sql.dialect.postgresql.visitor.PostgreSQLSQLASTVisitor;

/**
 *
 * DETACH PARTITION partition_name
 *
 * https://dev.mysql.com/doc/refman/8.0/en/alter-table.html
 * @author kongtong.ouyang on 2018/7/18.
 */
public class PostgreSQLSQLAlterTableDetachPartitionAction extends AbstractPostgreSQLSQLExpr implements ISQLAlterTableAction {

    protected SQLExpr name;

    @Override
    public void accept0(PostgreSQLSQLASTVisitor visitor) {
//        if (visitor.visit(this)) {
//            this.acceptChild(visitor, name);
//        }
    }

    @Override
    public PostgreSQLSQLAlterTableDetachPartitionAction clone() {
        PostgreSQLSQLAlterTableDetachPartitionAction x = new PostgreSQLSQLAlterTableDetachPartitionAction();
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
}
