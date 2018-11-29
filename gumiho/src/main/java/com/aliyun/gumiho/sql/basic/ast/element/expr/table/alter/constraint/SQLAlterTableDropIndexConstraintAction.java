package com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.constraint;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * DROP {INDEX|KEY} index_name
 * https://dev.mysql.com/doc/refman/8.0/en/alter-table.html
 *
 * @author kongtong.ouyang on 2018/6/4.
 */
public class SQLAlterTableDropIndexConstraintAction extends AbstractSQLExpr implements ISQLAlterTableDropTableConstraintAction {

    protected SQLName name;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
        }
    }

    @Override
    public SQLAlterTableDropIndexConstraintAction clone() {
        SQLAlterTableDropIndexConstraintAction x = new SQLAlterTableDropIndexConstraintAction();

        SQLName nameClone = this.name.clone();
        x.setName(nameClone);

        return x;
    }

    public SQLName getName() {
        return name;
    }

    public void setName(SQLName name) {
        setChildParent(name);
        this.name = name;
    }
}
