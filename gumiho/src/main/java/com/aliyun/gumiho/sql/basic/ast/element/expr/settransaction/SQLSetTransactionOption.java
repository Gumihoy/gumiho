package com.aliyun.gumiho.sql.basic.ast.element.expr.settransaction;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;

/**
 * https://dev.mysql.com/doc/refman/8.0/en/set-transaction.html
 *
 * https://www.postgresql.org/docs/10/static/sql-set-transaction.html
 *
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/SET-TRANSACTION.html#GUID-F11E1E30-5871-48D1-8266-F80A1DF126A1
 *
 * @author kongtong.ouyang on 2018/6/29.
 * @see com.aliyun.gumiho.sql.basic.ast.statement.tcl.SQLSetTransactionStatement
 */
public interface SQLSetTransactionOption extends SQLExpr {
    @Override
    SQLSetTransactionOption clone();
}
