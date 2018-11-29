package com.aliyun.gumiho.sql.basic.ast.element.expr;

/**
 * @author kongtong.ouyang on 2018/7/25.
 */
public interface ISQLVariable extends SQLExpr {
    @Override
    ISQLVariable clone();
}
