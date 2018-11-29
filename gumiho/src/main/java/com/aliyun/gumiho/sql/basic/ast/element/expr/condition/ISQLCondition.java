package com.aliyun.gumiho.sql.basic.ast.element.expr.condition;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;

/**
 * @author kongtong.ouyang on 2018/5/11.
 */
public interface ISQLCondition extends SQLExpr {

    @Override
    ISQLCondition clone();
}
