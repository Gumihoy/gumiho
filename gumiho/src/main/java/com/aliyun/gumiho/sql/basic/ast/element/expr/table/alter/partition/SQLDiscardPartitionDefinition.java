package com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.partition;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.ISQLAlterTableAction;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * DISCARD PARTITION {partition_names | ALL} TABLESPACE
 * https://dev.mysql.com/doc/refman/8.0/en/alter-table.html
 *
 *
 * @author kongtong.ouyang on 2018/6/4.
 */
public class SQLDiscardPartitionDefinition extends AbstractSQLExpr implements ISQLAlterTableAction {

    protected final List<SQLExpr> names = new ArrayList<>();

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, names);
        }
    }

    @Override
    public SQLDiscardPartitionDefinition clone() {
        SQLDiscardPartitionDefinition x = new SQLDiscardPartitionDefinition();
        this.cloneTo(x);
        return x;
    }

    public void cloneTo(SQLDiscardPartitionDefinition x) {
        super.cloneTo(x);
        for (SQLExpr name : this.names) {
            SQLExpr nameClone = name.clone();
            x.addName(nameClone);
        }
    }

    public List<SQLExpr> getNames() {
        return names;
    }

    public void addName(SQLExpr name) {
        if (name == null) {
            return;
        }
        setChildParent(name);
        this.names.add(name);
    }
}
