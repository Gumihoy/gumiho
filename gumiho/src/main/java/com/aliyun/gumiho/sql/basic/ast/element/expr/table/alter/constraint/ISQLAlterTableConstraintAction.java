package com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.constraint;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;

/**
 * @author kongtong.ouyang on 2018/7/11.
 */
public interface ISQLAlterTableConstraintAction extends SQLExpr {
    @Override
    ISQLAlterTableConstraintAction clone();
}
