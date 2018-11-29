package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.select;

import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.OracleSQLExpr;

/**
 * { VERSIONS BETWEEN { SCN | TIMESTAMP } { expr | MINVALUE } AND { expr | MAXVALUE }
 * | VERSIONS PERIOD FOR valid_time_column BETWEEN { expr | MINVALUE } AND { expr | MAXVALUE }
 * | AS OF { SCN | TIMESTAMP } expr
 * | AS OF PERIOD FOR valid_time_column expr }
 *
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/SELECT.html#GUID-CFA006CA-6FF1-4972-821E-6996142A51C6
 *
 * @author kongtong.ouyang on 2018/5/4.
 */
public interface OracleSQLFlashbackQueryClause extends OracleSQLExpr {

    @Override
    OracleSQLFlashbackQueryClause clone();
}
