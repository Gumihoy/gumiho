package com.aliyun.gumiho.sql.basic.ast.element.expr.analytic;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-ANALYTIC-VIEW.html#GUID-5256BE3A-F134-40D4-8E70-684E073574C8
 *
 * @author kongtong.ouyang on 2018/8/1.
 */
public interface ISQLAlterAnalyticAction extends SQLExpr {
    @Override
    ISQLAlterAnalyticAction clone();
}
