package com.aliyun.gumiho.sql.basic.ast.element.expr.condition;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * Updating [ ( 'column' ) ]
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/expression.html#GUID-D4700B45-F2C8-443E-AEE7-2BD20FFD45B8
 *
 * @author kongtong.ouyang on 2018/6/15.
 */
public class SQLUpdatingCondition extends AbstractSQLExpr implements ISQLCondition {

    protected SQLExpr column;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, column);
        }
    }

    @Override
    public SQLUpdatingCondition clone() {
        SQLUpdatingCondition x = new SQLUpdatingCondition();

        if (this.column != null) {
            SQLExpr columnClone = this.column.clone();
            x.setColumn(columnClone);
        }

        return x;
    }


    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == column) {
            setColumn(target);
            return true;
        }

        return false;
    }

    public SQLExpr getColumn() {
        return column;
    }

    public void setColumn(SQLExpr column) {
        setChildParent(column);
        this.column = column;
    }
}
