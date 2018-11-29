package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common;

import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.OracleSQLExpr;

/**
 *
 *  PIPELINED [USING [ "schema" "." ] "implementation_type" ]
 *  |
 *  PIPELINED ( ROW | TABLE ) POLYMORPHIC USING ["schema" "."] "implementation_package" )
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/PIPELINED-clause.html#GUID-FA182210-C68D-4E03-85B9-A6C681099705
 *
 * @author kongtong.ouyang on 2018/6/1.
 */
public interface IOracleSQLPipelinedClause extends OracleSQLExpr {

    @Override
    OracleSQLExpr clone();
}
