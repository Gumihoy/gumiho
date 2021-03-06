package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common;

import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

/**
 * NO INMEMORY ( column [, column ]... )
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-TABLE.html#GUID-F9CE0CC3-13AE-4744-A43C-EAC7A71AAAB6
 *
 * @author kongtong.ouyang on 2018/6/25.
 */
public class OracleSQLNoInMemoryColumnClause extends AbstractOracleSQLIneMemoryColumnClause {

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, columns);
        }
    }

    @Override
    public OracleSQLNoInMemoryColumnClause clone() {
        OracleSQLNoInMemoryColumnClause x = new OracleSQLNoInMemoryColumnClause();
        this.cloneTo(x);
        return x;
    }


}
