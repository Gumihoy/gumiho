package com.aliyun.gumiho.sql.dialect.ppas.visitor;

import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.config.SQLOutputConfig;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTOutputVisitor;
import com.aliyun.gumiho.sql.dialect.postgresql.ast.element.expr.PostgreSQLSQLPositionVariableExpr;
import com.aliyun.gumiho.sql.dialect.postgresql.ast.element.expr.PostgreSQLSQLTypeCastExpr;
import com.aliyun.gumiho.sql.dialect.postgresql.visitor.PostgreSQLSQLASTOutputVisitor;

/**
 * @author kongtong.ouyang on 2018/10/31.
 */
public class PPASSQLASTOutputVisitor extends OracleSQLASTOutputVisitor implements PPASSQLASTVisitor {

    private final PostgreSQLSQLASTOutputVisitor postgreSQLSQLASTOutputVisitor;

    public PPASSQLASTOutputVisitor(StringBuilder appender) {
        super(appender);
        postgreSQLSQLASTOutputVisitor = new PostgreSQLSQLASTOutputVisitor(appender);
    }

    public PPASSQLASTOutputVisitor(StringBuilder appender, SQLOutputConfig config) {
        super(appender, config);
        postgreSQLSQLASTOutputVisitor = new PostgreSQLSQLASTOutputVisitor(appender, config);
    }


    // ------------------------- Expr Start ----------------------------------------
    @Override
    public boolean visit(PostgreSQLSQLTypeCastExpr x) {
        postgreSQLSQLASTOutputVisitor.visit(x);
        return false;
    }

    @Override
    public boolean visit(PostgreSQLSQLPositionVariableExpr x) {
        postgreSQLSQLASTOutputVisitor.visit(x);
        return false;
    }
    // ------------------------- Expr End ----------------------------------------

}
