package com.aliyun.gumiho.sql.dialect.postgresql.visitor;

import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTOutputVisitor;
import com.aliyun.gumiho.sql.config.SQLOutputConfig;
import com.aliyun.gumiho.sql.dialect.postgresql.ast.element.expr.PostgreSQLSQLPositionVariableExpr;
import com.aliyun.gumiho.sql.dialect.postgresql.ast.element.expr.PostgreSQLSQLTypeCastExpr;

/**
 * @author kongtong.ouyang onCondition 2018/2/8.
 */
public class PostgreSQLSQLASTOutputVisitor extends SQLASTOutputVisitor implements PostgreSQLSQLASTVisitor {

    public PostgreSQLSQLASTOutputVisitor(StringBuilder appender) {
        super(appender);
    }

    public PostgreSQLSQLASTOutputVisitor(StringBuilder appender, SQLOutputConfig config) {
        super(appender, config);
    }




    // ------------------------- Expr Start ----------------------------------------
    @Override
    public boolean visit(PostgreSQLSQLTypeCastExpr x) {
        x.getExpr().accept(this);
        print(SQLReserved.DOUBLE_COLON);
        x.getDataType().accept(this);
        return false;
    }

    @Override
    public boolean visit(PostgreSQLSQLPositionVariableExpr x) {
        print(SQLReserved.DOLLAR);
        print(x.getPosition());
        return false;
    }
    // ------------------------- Expr End ----------------------------------------

}
