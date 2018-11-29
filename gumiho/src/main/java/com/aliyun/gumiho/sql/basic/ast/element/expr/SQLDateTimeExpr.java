package com.aliyun.gumiho.sql.basic.ast.element.expr;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Datetime-Expressions.html#GUID-F72A753A-98A4-4EBD-84E9-C014CE058384
 *
 * @author kongtong.ouyang on 2018/5/12.
 */
public interface SQLDateTimeExpr extends SQLExpr {
    @Override
    SQLDateTimeExpr clone();
}
