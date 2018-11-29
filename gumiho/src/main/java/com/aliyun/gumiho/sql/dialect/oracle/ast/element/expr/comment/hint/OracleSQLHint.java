package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.comment.hint;

import com.aliyun.gumiho.sql.basic.ast.element.hint.SQLHint;

/**
 * @author kongtong.ouyang on 2018/4/25.
 */
public interface OracleSQLHint extends SQLHint {

    @Override
    OracleSQLHint clone();
}
