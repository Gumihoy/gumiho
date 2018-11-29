package com.aliyun.gumiho.sql.basic.ast.element.function;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLFunctionType;
import com.aliyun.gumiho.sql.hash.SQLHash;

import java.util.List;

/**
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#method%20invocation
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#static%20method%20invocation
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#aggregate%20function
 * <p>
 * <p>
 * https://dev.mysql.com/doc/refman/5.7/en/func-op-summary-ref.html
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Functions.html
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/expression.html#GUID-D4700B45-F2C8-443E-AEE7-2BD20FFD45B8
 * <p>
 * https://www.postgresql.org/docs/devel/static/functions.html
 *
 * @author kongtong.ouyang on 2018/4/24.
 */
public interface ISQLFunction extends SQLExpr, SQLHash {

    String getName();

    SQLExpr getNameExpr();

    boolean isParen();
    void setParen(boolean paren);
    List<SQLExpr> getArguments();

    List<SQLFunctionType> getFunctionType();

    @Override
    ISQLFunction clone();


}
