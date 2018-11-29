package com.aliyun.gumiho.sql.basic.ast.element.expr.view.alter;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;

/**
 * @author kongtong.ouyang on 2018/7/13.
 */
public interface ISQLAlterViewAction extends SQLExpr {
    @Override
    ISQLAlterViewAction clone();
}
