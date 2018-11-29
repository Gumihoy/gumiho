package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common;

import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

/**
 * MEMCOMPRESS FOR { DML | QUERY [ LOW | HIGH ] | CAPACITY [ LOW | HIGH ] } | NO MEMCOMPRESS
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-TABLE.html#GUID-F9CE0CC3-13AE-4744-A43C-EAC7A71AAAB6
 *
 * @author kongtong.ouyang on 2018/6/25.
 */
public class OracleSQLInMemoryMemCompressClause extends AbstractOracleSQLExpr implements IOracleSQLInMemoryMemCompressClause {

    protected MemCompressMethod method;

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public OracleSQLInMemoryMemCompressClause clone() {
        OracleSQLInMemoryMemCompressClause x = new OracleSQLInMemoryMemCompressClause();

        x.method = this.method;

        return x;
    }


    public MemCompressMethod getMethod() {
        return method;
    }

    public void setMethod(MemCompressMethod method) {
        this.method = method;
    }

    public enum MemCompressMethod {
        DML(SQLReserved.DML),
        QUERY(SQLReserved.QUERY),
        QUERY_LOW(SQLReserved.QUERY_LOW),
        QUERY_HIGH(SQLReserved.QUERY_HIGH),
        CAPACITY(SQLReserved.CAPACITY),
        CAPACITY_LOW(SQLReserved.CAPACITY_LOW),
        CAPACITY_HIGH(SQLReserved.CAPACITY_HIGH),;

        public final SQLReserved name;

        MemCompressMethod(SQLReserved name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name.upper;
        }
    }

}
