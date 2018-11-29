package com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.partition;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.ISQLAlterTableAction;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * UPGRADE PARTITIONING
 * https://dev.mysql.com/doc/refman/8.0/en/alter-table.html
 *
 *
 * @author kongtong.ouyang on 2018/6/4.
 */
public class SQLAlterTableUpgradePartitioningAction extends AbstractSQLExpr implements ISQLAlterTableAction {

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SQLAlterTableUpgradePartitioningAction clone() {
        SQLAlterTableUpgradePartitioningAction x = new SQLAlterTableUpgradePartitioningAction();
        this.cloneTo(x);
        return x;
    }

}
