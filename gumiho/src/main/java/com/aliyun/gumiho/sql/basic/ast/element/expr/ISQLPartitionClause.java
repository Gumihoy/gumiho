package com.aliyun.gumiho.sql.basic.ast.element.expr;


/**
 * PARTITION ( expr[, expr ]... )
 * PARTITION FOR ( expr[, expr ]... )
 * SUBPARTITION (subpartition)
 * SUBPARTITION FOR  ( expr[, expr ]... )
 * @author kongtong.ouyang on 2018/6/29.
 */
public interface ISQLPartitionClause extends SQLExpr {
    @Override
    ISQLPartitionClause clone();
}
