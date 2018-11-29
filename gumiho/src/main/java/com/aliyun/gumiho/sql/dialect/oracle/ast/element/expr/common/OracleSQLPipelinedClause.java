package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common;

import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

/**
 * PIPELINED
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/PIPELINED-clause.html#GUID-FA182210-C68D-4E03-85B9-A6C681099705
 *
 * @author kongtong.ouyang on 2018/6/1.
 */
public class OracleSQLPipelinedClause extends AbstractOracleSQLExpr implements IOracleSQLPipelinedClause {

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public OracleSQLPipelinedClause clone() {
        return new OracleSQLPipelinedClause();
    }
}
