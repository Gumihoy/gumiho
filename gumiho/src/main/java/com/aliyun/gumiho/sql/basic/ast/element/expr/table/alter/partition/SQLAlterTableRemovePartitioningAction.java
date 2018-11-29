package com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.partition;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.ISQLAlterTableAction;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * REMOVE PARTITIONING
 * https://dev.mysql.com/doc/refman/8.0/en/alter-table.html
 *
 *
 * @author kongtong.ouyang on 2018/6/4.
 */
public class SQLAlterTableRemovePartitioningAction extends AbstractSQLExpr implements ISQLAlterTablePartitionAction {

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SQLAlterTableRemovePartitioningAction clone() {
        SQLAlterTableRemovePartitioningAction x = new SQLAlterTableRemovePartitioningAction();
        this.cloneTo(x);
        return x;
    }

}
