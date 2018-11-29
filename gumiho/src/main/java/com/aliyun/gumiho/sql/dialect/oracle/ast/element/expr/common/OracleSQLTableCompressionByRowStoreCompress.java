package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common;

import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

/**
 * ROW STORE COMPRESS [ BASIC | ADVANCED ]
 * <p>
 * table_compression
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-MATERIALIZED-VIEW.html#GUID-EE262CA4-01E5-4618-B659-6165D993CA1B
 *
 * @author kongtong.ouyang on 2018/6/22.
 */
public class OracleSQLTableCompressionByRowStoreCompress extends AbstractOracleSQLExpr implements IOracleSQLTableCompression {

    protected RowStoreCompressType compressType;

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public OracleSQLTableCompressionByRowStoreCompress clone() {
        OracleSQLTableCompressionByRowStoreCompress x = new OracleSQLTableCompressionByRowStoreCompress();
        x.compressType = this.compressType;
        return x;
    }


    public RowStoreCompressType getCompressType() {
        return compressType;
    }

    public void setCompressType(RowStoreCompressType compressType) {
        this.compressType = compressType;
    }

    public enum RowStoreCompressType {

        BASIC(SQLReserved.BASIC),
        ADVANCED(SQLReserved.ADVANCED),;

        public final SQLReserved name;

        RowStoreCompressType(SQLReserved name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name.upper;
        }
    }
}
