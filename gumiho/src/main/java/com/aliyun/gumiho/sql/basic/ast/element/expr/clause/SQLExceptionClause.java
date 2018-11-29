package com.aliyun.gumiho.sql.basic.ast.element.expr.clause;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * EXCEPTION exception_handler...
 *
 * @author kongtong.ouyang on 2018/6/13.
 */
public class SQLExceptionClause extends AbstractSQLExpr {

    protected final List<SQLExpr> exceptionHandlers = new ArrayList<>();

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, exceptionHandlers);
        }
    }

    @Override
    public SQLExceptionClause clone() {
        SQLExceptionClause x = new SQLExceptionClause();
        this.cloneTo(x);

        for (SQLExpr exceptionHandler : exceptionHandlers) {
            SQLExpr exceptionHandlerClone = exceptionHandler.clone();
            x.addexceptionHandler(exceptionHandlerClone);
        }
        return x;
    }

    public List<SQLExpr> getExceptionHandlers() {
        return exceptionHandlers;
    }

    public void addexceptionHandler(SQLExpr exceptionHandler) {
        if (exceptionHandler == null) {
            return;
        }
        setChildParent(exceptionHandler);
        this.exceptionHandlers.add(exceptionHandler);
    }

}
