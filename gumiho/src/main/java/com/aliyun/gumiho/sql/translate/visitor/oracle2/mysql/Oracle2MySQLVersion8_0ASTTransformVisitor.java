package com.aliyun.gumiho.sql.translate.visitor.oracle2.mysql;

import com.aliyun.gumiho.sql.dialect.mysql.ast.element.expr.MySQLSQLMatchExpr;
import com.aliyun.gumiho.sql.dialect.mysql.ast.element.expr.select.MySQLSQLOJTableReference;
import com.aliyun.gumiho.sql.dialect.mysql.ast.element.expr.select.MySQLSQLSelectQuery;
import com.aliyun.gumiho.sql.dialect.mysql.ast.statement.utility.MySQLSQLHelpStatement;
import com.aliyun.gumiho.sql.dialect.mysql.visitor.MySQLSQLASTVisitor;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitorAdapter;
import com.aliyun.gumiho.sql.translate.SQLTransformConfig;
import com.aliyun.gumiho.sql.translate.visitor.SQLASTTransformVisitor;

/**
 * @author kongtong.ouyang onCondition 2018/1/16.
 */
public class Oracle2MySQLVersion8_0ASTTransformVisitor extends SQLASTTransformVisitor implements MySQLSQLASTVisitor {

    public Oracle2MySQLVersion8_0ASTTransformVisitor(SQLTransformConfig config) {
        super(config);
    }

    @Override
    public boolean visit(MySQLSQLHelpStatement x) {
        return true;
    }

    // ------------------------- Comment Start ----------------------------------------

    // ------------------------- Comment End ----------------------------------------

    // ------------------------- Hint Start ----------------------------------------
    // ------------------------- Hint End ----------------------------------------


    // ------------------------- Commons Expr Start ----------------------------------------
    @Override
    public boolean visit(MySQLSQLMatchExpr x) {
        return true;
    }


    // ------------------------- Commons Expr End ----------------------------------------


    // ------------------ Details ----------------------


    // ------------------ Select Details Start ----------------------

    @Override
    public boolean visit(MySQLSQLSelectQuery x) {
        return true;
    }

    @Override
    public boolean visit(MySQLSQLSelectQuery.MySQLSQLIntoOutFileClause x) {
        return true;
    }

    @Override
    public boolean visit(MySQLSQLSelectQuery.MySQLSQLIntoDumpFileClause x) {
        return true;
    }

    @Override
    public boolean visit(MySQLSQLSelectQuery.MySQLSQLIntoClause x) {
        return true;
    }

    @Override
    public boolean visit(MySQLSQLOJTableReference x) {
        return true;
    }
    // ------------------ Select Details End ----------------------

}
