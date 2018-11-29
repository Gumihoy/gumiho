package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common;

import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

/**
 * { INMEMORY [ inmemory_attributes ] } | { NO INMEMORY }
 * <p>
 * inmemory_clause
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-TABLE.html#GUID-F9CE0CC3-13AE-4744-A43C-EAC7A71AAAB6
 *
 * @author kongtong.ouyang on 2018/6/25.
 */
public class OracleSQLNoInMemoryClause extends AbstractOracleSQLExpr implements IOracleSQLInMemoryClause {

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public OracleSQLNoInMemoryClause clone() {
        OracleSQLNoInMemoryClause x = new OracleSQLNoInMemoryClause();
        return x;
    }

}
