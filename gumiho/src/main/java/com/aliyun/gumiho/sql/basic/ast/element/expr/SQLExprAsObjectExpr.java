package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.ast.SQLObject;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * expr as? alias
 * <p>
 * expr as? dataType
 *
 * @author kongtong.ouyang on 2018/5/18.
 */
public class SQLExprAsObjectExpr extends AbstractSQLExpr {

    protected SQLExpr expr;
    protected boolean as;
    protected SQLObject asObject;

    public SQLExprAsObjectExpr(SQLExpr expr, SQLObject asObject) {
        setExpr(expr);
        setAsObject(asObject);
    }

    public SQLExprAsObjectExpr(SQLExpr expr, boolean as, SQLObject asObject) {
        setExpr(expr);
        setAsObject(asObject);
        this.as = as;
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, expr);
            this.acceptChild(visitor, asObject);
        }
    }

    @Override
    public SQLExprAsObjectExpr clone() {
        SQLExpr exprClone = this.expr.clone();
        SQLObject asObjectClone = this.asObject.clone();

        return new SQLExprAsObjectExpr(exprClone, this.as, asObjectClone);
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == expr) {
            setExpr(target);
            return true;
        }

        if (source == asObject) {
            setAsObject(target);
            return true;
        }
        return false;
    }

    public SQLExpr getExpr() {
        return expr;
    }

    public void setExpr(SQLExpr expr) {
        setChildParent(expr);
        this.expr = expr;
    }

    public boolean isAs() {
        return as;
    }

    public void setAs(boolean as) {
        this.as = as;
    }

    public SQLObject getAsObject() {
        return asObject;
    }

    public void setAsObject(SQLObject asObject) {
        setChildParent(asObject);
        this.asObject = asObject;
    }
}
