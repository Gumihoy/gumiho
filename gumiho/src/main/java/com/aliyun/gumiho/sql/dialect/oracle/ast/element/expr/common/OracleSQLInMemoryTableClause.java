package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common;

import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * [ { INMEMORY [ inmemory_attributes ] } | { NO INMEMORY } ] [ inmemory_column_clause ]
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-TABLE.html#GUID-F9CE0CC3-13AE-4744-A43C-EAC7A71AAAB6
 *
 * @author kongtong.ouyang on 2018/6/25.
 */
public class OracleSQLInMemoryTableClause extends AbstractOracleSQLExpr {

    protected IOracleSQLInMemoryClause inMemoryClause;
    protected final List<IOracleSQLInMemoryColumnClause> inMemoryColumnClauses = new ArrayList<>();


    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, inMemoryClause);
            this.acceptChild(visitor, inMemoryColumnClauses);
        }
    }

    @Override
    public OracleSQLInMemoryTableClause clone() {
        OracleSQLInMemoryTableClause x = new OracleSQLInMemoryTableClause();

        if (this.inMemoryClause != null) {
            IOracleSQLInMemoryClause inMemoryClauseClone = this.inMemoryClause.clone();
            x.setInMemoryClause(inMemoryClauseClone);
        }

        for (IOracleSQLInMemoryColumnClause inMemoryColumnClause : inMemoryColumnClauses) {
            IOracleSQLInMemoryColumnClause inMemoryColumnClauseClone = inMemoryColumnClause.clone();
            x.addInMemoryColumnClause(inMemoryColumnClauseClone);
        }

        return x;
    }

    public IOracleSQLInMemoryClause getInMemoryClause() {
        return inMemoryClause;
    }

    public void setInMemoryClause(IOracleSQLInMemoryClause inMemoryClause) {
        this.inMemoryClause = inMemoryClause;
    }

    public List<IOracleSQLInMemoryColumnClause> getInMemoryColumnClauses() {
        return inMemoryColumnClauses;
    }

    public void addInMemoryColumnClause(IOracleSQLInMemoryColumnClause inMemoryColumnClause) {
        if (inMemoryColumnClause == null) {
            return;
        }
        setChildParent(inMemoryColumnClause);
        this.inMemoryColumnClauses.add(inMemoryColumnClause);
    }
}
