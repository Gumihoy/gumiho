package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common;

import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

/**
 * COLUMN STORE COMPRESS [  FOR { QUERY | ARCHIVE } [ LOW | HIGH ] ] [ [NO] ROW LEVEL LOCKING ]
 * <p>
 * table_compression
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-MATERIALIZED-VIEW.html#GUID-EE262CA4-01E5-4618-B659-6165D993CA1B
 *
 * @author kongtong.ouyang on 2018/6/22.
 */
public class OracleSQLTableCompressionByColumnStoreCompress extends AbstractOracleSQLExpr implements IOracleSQLTableCompression {

    protected ForType forType;
    protected RowLevelLockingType rowLevelLockingType;

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public OracleSQLTableCompressionByColumnStoreCompress clone() {
        OracleSQLTableCompressionByColumnStoreCompress x = new OracleSQLTableCompressionByColumnStoreCompress();
        x.forType = this.forType;
        x.rowLevelLockingType = this.rowLevelLockingType;
        return x;
    }


    public ForType getForType() {
        return forType;
    }

    public void setForType(ForType forType) {
        this.forType = forType;
    }

    public RowLevelLockingType getRowLevelLockingType() {
        return rowLevelLockingType;
    }

    public void setRowLevelLockingType(RowLevelLockingType rowLevelLockingType) {
        this.rowLevelLockingType = rowLevelLockingType;
    }

    public enum ForType {
        FOR_QUERY(SQLReserved.FOR_QUERY),
        FOR_QUERY_LOW(SQLReserved.FOR_QUERY_LOW),
        FOR_QUERY_HIGH(SQLReserved.FOR_QUERY_HIGH),
        FOR_ARCHIVE(SQLReserved.FOR_ARCHIVE),
        FOR_ARCHIVE_LOW(SQLReserved.FOR_ARCHIVE_LOW),
        FOR_ARCHIVE_HIGH(SQLReserved.FOR_ARCHIVE_HIGH),;

        public final SQLReserved name;

        ForType(SQLReserved name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name.upper;
        }
    }

    public enum RowLevelLockingType {

        ROW_LEVEL_LOCKING(SQLReserved.ROW_LEVEL_LOCKING),
        NO_ROW_LEVEL_LOCKING(SQLReserved.NO_ROW_LEVEL_LOCKING),;

        public final SQLReserved name;

        RowLevelLockingType(SQLReserved name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name.upper;
        }
    }
}
