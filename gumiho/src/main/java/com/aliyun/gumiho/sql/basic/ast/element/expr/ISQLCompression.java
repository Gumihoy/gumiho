package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.OracleSQLExpr;

/**
 * @author kongtong.ouyang on 2018/6/26.
 */
public interface ISQLCompression extends SQLExpr {
    @Override
    ISQLCompression clone();
}
