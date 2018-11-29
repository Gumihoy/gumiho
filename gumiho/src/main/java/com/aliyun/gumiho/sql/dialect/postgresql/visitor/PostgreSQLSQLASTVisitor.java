package com.aliyun.gumiho.sql.dialect.postgresql.visitor;

import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.dialect.postgresql.ast.element.expr.PostgreSQLSQLPositionVariableExpr;
import com.aliyun.gumiho.sql.dialect.postgresql.ast.element.expr.PostgreSQLSQLTypeCastExpr;

/**
 * @author kongtong.ouyang onCondition 2018/2/8.
 */
public interface PostgreSQLSQLASTVisitor extends SQLASTVisitor {

    // ------------------------- Expr Start ----------------------------------------

    boolean visit(PostgreSQLSQLTypeCastExpr x);

    boolean visit(PostgreSQLSQLPositionVariableExpr x);


    // ------------------------- Expr End ----------------------------------------

}
