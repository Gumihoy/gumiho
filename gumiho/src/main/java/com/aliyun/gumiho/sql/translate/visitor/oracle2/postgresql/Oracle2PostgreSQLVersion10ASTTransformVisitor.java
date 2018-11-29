package com.aliyun.gumiho.sql.translate.visitor.oracle2.postgresql;


import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitorAdapter;
import com.aliyun.gumiho.sql.dialect.postgresql.ast.element.expr.PostgreSQLSQLPositionVariableExpr;
import com.aliyun.gumiho.sql.dialect.postgresql.ast.element.expr.PostgreSQLSQLTypeCastExpr;
import com.aliyun.gumiho.sql.dialect.postgresql.visitor.PostgreSQLSQLASTVisitor;
import com.aliyun.gumiho.sql.translate.SQLTransformConfig;

/**
 * @author kongtong.ouyang onCondition 2018/1/16.
 */
public class Oracle2PostgreSQLVersion10ASTTransformVisitor extends OracleSQLASTVisitorAdapter implements PostgreSQLSQLASTVisitor {


    public Oracle2PostgreSQLVersion10ASTTransformVisitor(SQLTransformConfig config) {
        super(config);
    }


    // ------------------------- Expr Start ----------------------------------------
    @Override
    public boolean visit(PostgreSQLSQLTypeCastExpr x) {
        return true;
    }

    @Override
    public boolean visit(PostgreSQLSQLPositionVariableExpr x) {
        return true;
    }
    // ------------------------- Expr End ----------------------------------------

}
