package com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.partition;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.ISQLAlterTableAction;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * REORGANIZE PARTITION partition_names INTO (partition_definitions)
 * https://dev.mysql.com/doc/refman/8.0/en/alter-table.html
 *
 *
 * @author kongtong.ouyang on 2018/6/4.
 */
public class SQLExchangePartitionDefinition extends AbstractSQLExpr implements ISQLAlterTableAction {

    protected SQLExpr name;
    protected SQLExpr tableName;


    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
        }
    }

    @Override
    public SQLExchangePartitionDefinition clone() {
        SQLExchangePartitionDefinition x = new SQLExchangePartitionDefinition();
        this.cloneTo(x);
        return x;
    }

    public void cloneTo(SQLExchangePartitionDefinition x) {
        super.cloneTo(x);

        SQLExpr nameClone = this.name.clone();
        x.setName(nameClone);
    }

    public SQLExpr getName() {
        return name;
    }

    public void setName(SQLExpr name) {
        setChildParent(name);
        this.name = name;
    }
}
