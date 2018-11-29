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
public class OracleSQLInMemoryClause extends AbstractOracleSQLExpr implements IOracleSQLInMemoryClause {

    protected OracleSQLInMemoryAttributes inMemoryAttributes;

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, inMemoryAttributes);
        }
    }

    @Override
    public OracleSQLInMemoryClause clone() {
        OracleSQLInMemoryClause x = new OracleSQLInMemoryClause();

        if (this.inMemoryAttributes != null) {
            OracleSQLInMemoryAttributes inMemoryAttributesClone = this.inMemoryAttributes.clone();
            x.setInMemoryAttributes(inMemoryAttributesClone);
        }
        return x;
    }

    public OracleSQLInMemoryAttributes getInMemoryAttributes() {
        return inMemoryAttributes;
    }

    public void setInMemoryAttributes(OracleSQLInMemoryAttributes inMemoryAttributes) {
        setChildParent(inMemoryAttributes);
        this.inMemoryAttributes = inMemoryAttributes;
    }
}
