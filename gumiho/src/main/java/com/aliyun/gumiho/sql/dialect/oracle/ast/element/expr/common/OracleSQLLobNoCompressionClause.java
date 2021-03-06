package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common;

import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

/**
 * NOCOMPRESS
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-TABLE.html#GUID-F9CE0CC3-13AE-4744-A43C-EAC7A71AAAB6
 *
 * @author kongtong.ouyang on 2018/6/25.
 */
public class OracleSQLLobNoCompressionClause extends AbstractOracleSQLExpr implements IOracleSQLLobCompressionClause {

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public OracleSQLLobNoCompressionClause clone() {
        OracleSQLLobNoCompressionClause x = new OracleSQLLobNoCompressionClause();
        return x;
    }

}
