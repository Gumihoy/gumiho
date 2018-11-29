package com.aliyun.gumiho.sql.basic.ast.element.expr.type.alter;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;

/**
 * @author kongtong.ouyang on 2018/9/11.
 */
public interface ISQLAlterTypeAction extends SQLExpr {
    @Override
    ISQLAlterTypeAction clone();
}
