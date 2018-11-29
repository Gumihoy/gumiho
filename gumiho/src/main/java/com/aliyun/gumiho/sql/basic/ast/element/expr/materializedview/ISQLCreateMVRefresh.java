package com.aliyun.gumiho.sql.basic.ast.element.expr.materializedview;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;

/**
 * create_mv_refresh
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-MATERIALIZED-VIEW.html#GUID-EE262CA4-01E5-4618-B659-6165D993CA1B
 *
 * @author kongtong.ouyang on 2018/6/23.
 */
public interface ISQLCreateMVRefresh extends SQLExpr {
    @Override
    ISQLCreateMVRefresh clone();
}
