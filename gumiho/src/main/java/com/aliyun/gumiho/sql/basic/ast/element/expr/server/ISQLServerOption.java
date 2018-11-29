package com.aliyun.gumiho.sql.basic.ast.element.expr.server;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;

/**
 * @author kongtong.ouyang on 2018/7/30.
 */
public interface ISQLServerOption extends SQLExpr {
    @Override
    ISQLServerOption clone();
}
