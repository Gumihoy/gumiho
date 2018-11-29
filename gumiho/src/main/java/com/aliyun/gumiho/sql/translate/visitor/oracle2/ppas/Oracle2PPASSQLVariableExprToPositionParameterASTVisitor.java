package com.aliyun.gumiho.sql.translate.visitor.oracle2.ppas;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLVariableExpr;
import com.aliyun.gumiho.sql.dialect.postgresql.ast.element.expr.PostgreSQLSQLPositionVariableExpr;
import com.aliyun.gumiho.sql.translate.visitor.SQLASTTransformVisitor;
import com.aliyun.gumiho.sql.translate.SQLTransformConfig;
import com.aliyun.gumiho.sql.util.SQLUtils;

import java.util.concurrent.atomic.AtomicLong;

/**
 * ? => $1
 *
 * @author kongtong.ouyang on 2018/5/18.
 */
public class Oracle2PPASSQLVariableExprToPositionParameterASTVisitor extends SQLASTTransformVisitor {

    protected AtomicLong atomicLong = new AtomicLong(0);

    public Oracle2PPASSQLVariableExprToPositionParameterASTVisitor() {
    }

    public Oracle2PPASSQLVariableExprToPositionParameterASTVisitor(SQLTransformConfig config) {
        super(config);
    }

    @Override
    public boolean visit(SQLVariableExpr x) {
        long index = atomicLong.incrementAndGet();
        PostgreSQLSQLPositionVariableExpr target = new PostgreSQLSQLPositionVariableExpr(index);
        boolean replaceInParent = SQLUtils.replaceInParent(x, target);
        if (!replaceInParent) {
            atomicLong.decrementAndGet();
        }
        return true;
    }



}
