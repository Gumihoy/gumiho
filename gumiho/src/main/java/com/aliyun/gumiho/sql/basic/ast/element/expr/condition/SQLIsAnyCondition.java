package com.aliyun.gumiho.sql.basic.ast.element.expr.condition;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * [ dimension_column IS ] ANY
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Model-Conditions.html#GUID-1F5B08DB-2B7A-4ECE-B51A-C753A426928B
 *
 * @author kongtong.ouyang on 2018/5/11.
 */
public class SQLIsAnyCondition extends AbstractSQLExpr implements ISQLCondition {

    protected SQLExpr column;


    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, column);
        }
    }

    @Override
    public SQLIsAnyCondition clone() {
        SQLIsAnyCondition x = new SQLIsAnyCondition();
        this.cloneTo(x);
        return x;
    }

    public void cloneTo(SQLIsAnyCondition x) {
        super.cloneTo(x);

        SQLExpr columnClone = this.column.clone();
        x.setColumn(columnClone);

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
