package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common;

import com.aliyun.gumiho.sql.basic.ast.enums.ISQLEnum;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

/**
 * COMPRESS [HIGH | MEDIUM | LOW ]
 * <p>
 * LOB_compression_clause
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-TABLE.html#GUID-F9CE0CC3-13AE-4744-A43C-EAC7A71AAAB6
 *
 * @author kongtong.ouyang on 2018/6/25.
 */
public class OracleSQLLobCompressionClause extends AbstractOracleSQLExpr implements IOracleSQLLobCompressionClause {

    protected CompressionType type;

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public OracleSQLLobCompressionClause clone() {
        OracleSQLLobCompressionClause x = new OracleSQLLobCompressionClause();
        x.type = this.type;
        return x;
    }


    public CompressionType getType() {
        return type;
    }

    public void setType(CompressionType type) {
        this.type = type;
    }

    public enum CompressionType implements ISQLEnum {
        HIGH(SQLReserved.HIGH),
        MEDIUM(SQLReserved.MEDIUM),
        LOW(SQLReserved.LOW),;

        public final SQLReserved name;

        CompressionType(SQLReserved name) {
            this.name = name;
        }

        @Override
        public SQLReserved getName() {
            return name;
        }
    }
}
