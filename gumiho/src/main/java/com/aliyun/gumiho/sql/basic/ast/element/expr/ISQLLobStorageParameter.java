package com.aliyun.gumiho.sql.basic.ast.element.expr;

/**
 * { { { TABLESPACE tablespace
 * | TABLESPACE SET tablespace_set }
 * | LOB_parameters [storage_clause]
 * }...
 * | storage_clause
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-MATERIALIZED-VIEW.html#GUID-EE262CA4-01E5-4618-B659-6165D993CA1B
 *
 * @author kongtong.ouyang on 2018/6/27.
 */
public interface ISQLLobStorageParameter extends SQLExpr {
    @Override
    ISQLLobStorageParameter clone();
}
