package com.aliyun.gumiho.sql.dialect.mysql.visitor;

import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.dialect.mysql.ast.element.expr.MySQLSQLMatchExpr;
import com.aliyun.gumiho.sql.dialect.mysql.ast.element.expr.select.MySQLSQLOJTableReference;
import com.aliyun.gumiho.sql.dialect.mysql.ast.element.expr.select.MySQLSQLSelectQuery;
import com.aliyun.gumiho.sql.dialect.mysql.ast.statement.utility.MySQLSQLHelpStatement;

/**
 * @author kongtong.ouyang onCondition 2018/2/8.
 */
public interface MySQLSQLASTVisitor extends SQLASTVisitor {

    boolean visit(MySQLSQLHelpStatement x);


    // ------------------------- Literal Start ----------------------------------------

    // ------------------------- Literal End ----------------------------------------

    // ------------------------- Comment Start ----------------------------------------

    // ------------------------- Comment End ----------------------------------------

    // ------------------------- Hint Start ----------------------------------------

    // ------------------------- Hint End ----------------------------------------


    // ------------------------- Functions Start ----------------------------------------
    // ------------------------- Functions End ----------------------------------------

    // ------------------------- Commons Expr Start ----------------------------------------
    boolean visit(MySQLSQLMatchExpr x);
    // ------------------------- Commons Expr End ----------------------------------------


    // ------------------ Select Details Start ----------------------
    boolean visit(MySQLSQLSelectQuery x);

    boolean visit(MySQLSQLSelectQuery.MySQLSQLIntoOutFileClause x);

    boolean visit(MySQLSQLSelectQuery.MySQLSQLIntoDumpFileClause x);

    boolean visit(MySQLSQLSelectQuery.MySQLSQLIntoClause x);

    boolean visit(MySQLSQLOJTableReference x);

    // ------------------ Select Details End ----------------------
}
