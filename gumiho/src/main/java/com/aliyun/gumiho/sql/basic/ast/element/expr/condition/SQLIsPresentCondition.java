package com.aliyun.gumiho.sql.basic.ast.element.expr.condition;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * cell_reference IS PRESENT
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Model-Conditions.html#GUID-A26216BD-D937-412E-87B3-4B79F511AE38
 *
 * @author kongtong.ouyang on 2018/5/11.
 */
public class SQLIsPresentCondition extends AbstractSQLExpr implements ISQLCondition{

    protected SQLExpr cellReference;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, cellReference);
        }
    }

    @Override
    public SQLIsPresentCondition clone() {
        SQLIsPresentCondition x = new SQLIsPresentCondition();
        this.cloneTo(x);
        return x;
    }

    public void cloneTo(SQLIsPresentCondition x) {
        super.cloneTo(x);

        SQLExpr exprClone = this.cellReference.clone();
        x.setCellReference(exprClone);

    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == cellReference) {
            setCellReference(target);
            return true;
        }

        return false;
    }

    public SQLExpr getCellReference() {
        return cellReference;
    }

    public void setCellReference(SQLExpr cellReference) {
        setChildParent(cellReference);
        this.cellReference = cellReference;
    }
}
