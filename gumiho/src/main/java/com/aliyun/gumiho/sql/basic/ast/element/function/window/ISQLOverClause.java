package com.aliyun.gumiho.sql.basic.ast.element.function.window;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;

/**
 * OVER <window name or specification>
 * <p>
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#window%20function
 *
 * @author kongtong.ouyang on 2018/5/22.
 */
public interface ISQLOverClause extends SQLExpr {

    @Override
    ISQLOverClause clone();
}
