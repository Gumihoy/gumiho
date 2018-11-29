package com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.partition;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.ISQLAlterTableAction;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * COALESCE PARTITION number
 * https://dev.mysql.com/doc/refman/8.0/en/alter-table.html
 *
 *
 * @author kongtong.ouyang on 2018/6/4.
 */
public class SQLCoalescePartitionDefinition extends AbstractSQLExpr implements ISQLAlterTableAction {

    protected SQLExpr num;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, num);
        }
    }

    @Override
    public SQLCoalescePartitionDefinition clone() {
        SQLCoalescePartitionDefinition x = new SQLCoalescePartitionDefinition();
        this.cloneTo(x);
        return x;
    }

    public void cloneTo(SQLCoalescePartitionDefinition x) {
        super.cloneTo(x);

        SQLExpr numClone = this.num.clone();
        x.setNum(numClone);
    }

    public SQLExpr getNum() {
        return num;
    }

    public void setNum(SQLExpr num) {
        setChildParent(num);
        this.num = num;
    }
}
