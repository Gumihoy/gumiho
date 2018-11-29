package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.select;

import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.OracleSQLExpr;

/**
 * @author kongtong.ouyang on 2018/6/6.
 */
public interface IOracleSQLPivotClause extends OracleSQLExpr{

    @Override
    IOracleSQLPivotClause clone();
}
