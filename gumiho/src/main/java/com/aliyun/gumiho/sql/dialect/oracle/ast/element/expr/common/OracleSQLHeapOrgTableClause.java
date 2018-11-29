package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common;

import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

/**
 * [ table_compression ] [ inmemory_table_clause ] [ ilm_clause ]
 *
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-TABLE.html#GUID-F9CE0CC3-13AE-4744-A43C-EAC7A71AAAB6
 *
 * @author kongtong.ouyang on 2018/6/25.
 */
public class OracleSQLHeapOrgTableClause extends AbstractOracleSQLExpr {

    protected IOracleSQLTableCompression tableCompression;
    protected OracleSQLInMemoryTableClause inMemoryTableClause;
    protected IOracleSQLIlmClause ilmClause;



    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, tableCompression);
            this.acceptChild(visitor, inMemoryTableClause);
            this.acceptChild(visitor, ilmClause);
        }
    }

    @Override
    public OracleSQLHeapOrgTableClause clone() {
        OracleSQLHeapOrgTableClause x = new OracleSQLHeapOrgTableClause();

        if (this.tableCompression != null) {
            IOracleSQLTableCompression tableCompressionClone = this.tableCompression.clone();
            x.setTableCompression(tableCompressionClone);
        }

        if (this.inMemoryTableClause != null) {
            OracleSQLInMemoryTableClause inMemoryTableClauseClone = this.inMemoryTableClause.clone();
            x.setInMemoryTableClause(inMemoryTableClauseClone);
        }

        if (this.ilmClause != null) {
            IOracleSQLIlmClause ilmClauseClone = this.ilmClause.clone();
            x.setIlmClause(ilmClauseClone);
        }

        return x;
    }


    public IOracleSQLTableCompression getTableCompression() {
        return tableCompression;
    }

    public void setTableCompression(IOracleSQLTableCompression tableCompression) {
        setChildParent(tableCompression);
        this.tableCompression = tableCompression;
    }

    public OracleSQLInMemoryTableClause getInMemoryTableClause() {
        return inMemoryTableClause;
    }

    public void setInMemoryTableClause(OracleSQLInMemoryTableClause inMemoryTableClause) {
        setChildParent(inMemoryTableClause);
        this.inMemoryTableClause = inMemoryTableClause;
    }

    public IOracleSQLIlmClause getIlmClause() {
        return ilmClause;
    }

    public void setIlmClause(IOracleSQLIlmClause ilmClause) {
        setChildParent(ilmClause);
        this.ilmClause = ilmClause;
    }
}
