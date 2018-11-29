package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.ast.statement.AbstractOracleSQLStatement;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

/**
 * assignment_statement_target := expression ;
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/assignment-statement.html#GUID-4C3BEFDF-3FFA-4E9D-96D0-4C5E13E08643
 *
 * @author kongtong.ouyang on 2018/6/9.
 */
public class OracleSQLAssignmentStatement extends AbstractOracleSQLStatement {

    protected SQLExpr target;

    protected SQLExpr expr;

    public OracleSQLAssignmentStatement() {
    }

    public OracleSQLAssignmentStatement(SQLExpr target, SQLExpr expr) {
        setTarget(target);
        setExpr(expr);
    }

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, target);
            this.acceptChild(visitor, expr);
        }
    }

    @Override
    public OracleSQLAssignmentStatement clone() {
        OracleSQLAssignmentStatement x = new OracleSQLAssignmentStatement();
        this.cloneTo(x);
        return x;
    }

    public void cloneTo(OracleSQLAssignmentStatement x) {
        super.cloneTo(x);

        SQLExpr targetClone = this.target.clone();
        x.setTarget(targetClone);

        SQLExpr exprClone = this.expr.clone();
        x.setExpr(exprClone);
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == this.target) {
            this.setTarget(target);
            return true;
        }

        if (source == this.expr) {
            this.setExpr(target);
            return true;
        }
        return false;
    }

    @Override
    public SQLObjectType getObjectType() {
        return null;
    }

    public SQLExpr getTarget() {
        return target;
    }

    public void setTarget(SQLExpr target) {
        setChildParent(target);
        this.target = target;
    }

    public SQLExpr getExpr() {
        return expr;
    }

    public void setExpr(SQLExpr expr) {
        setChildParent(expr);
        this.expr = expr;
    }


    
}
