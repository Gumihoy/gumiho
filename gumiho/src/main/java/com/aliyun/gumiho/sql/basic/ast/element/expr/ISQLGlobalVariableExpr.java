package com.aliyun.gumiho.sql.basic.ast.element.expr;

/**
 * [@@global. | @@session. | @@persist. | @@persist_only. | @@] system_var_name
 * <p>
 * https://dev.mysql.com/doc/refman/8.0/en/set-variable.html
 * https://dev.mysql.com/doc/refman/8.0/en/user-variables.html
 *
 * @author kongtong.ouyang on 2018/7/25.
 */
public interface ISQLGlobalVariableExpr extends SQLExpr, ISQLVariable {
    @Override
    ISQLGlobalVariableExpr clone();
}
