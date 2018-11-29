package com.aliyun.gumiho.sql.basic.ast.element.expr.select;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;

/**
 * @author kongtong.ouyang on 2018/7/24.
 */
public interface ISQLLockClause extends SQLExpr {
    @Override
    ISQLLockClause clone();
}
