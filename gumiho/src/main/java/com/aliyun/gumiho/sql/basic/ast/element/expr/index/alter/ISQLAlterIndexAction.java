package com.aliyun.gumiho.sql.basic.ast.element.expr.index.alter;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;

/**
 * https://www.postgresql.org/docs/devel/static/sql-alterindex.html
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-INDEX.html#GUID-D8F648E7-8C07-4C89-BB71-862512536558
 *
 * @author kongtong.ouyang on 2018/7/9.
 */
public interface ISQLAlterIndexAction extends SQLExpr {
    @Override
    ISQLAlterIndexAction clone();
}
