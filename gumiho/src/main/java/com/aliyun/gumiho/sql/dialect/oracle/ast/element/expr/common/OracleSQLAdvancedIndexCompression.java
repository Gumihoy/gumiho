package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common;

import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

/**
 * COMPRESS ADVANCED [ LOW | HIGH ]
 * <p>
 * advanced_index_compression
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-TABLE.html#GUID-F9CE0CC3-13AE-4744-A43C-EAC7A71AAAB6
 *
 * @author kongtong.ouyang on 2018/6/26.
 */
public class OracleSQLAdvancedIndexCompression extends AbstractOracleSQLExpr implements IOracleSQLAdvancedIndexCompression {

    protected AdvancedType advancedType;

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public OracleSQLAdvancedIndexCompression clone() {
        OracleSQLAdvancedIndexCompression x = new OracleSQLAdvancedIndexCompression();
        x.advancedType = this.advancedType;
        return x;
    }


    public AdvancedType getAdvancedType() {
        return advancedType;
    }

    public void setAdvancedType(AdvancedType advancedType) {
        this.advancedType = advancedType;
    }

    public enum AdvancedType {
        LOW(SQLReserved.LOW),
        HIGH(SQLReserved.HIGH),;
        public final SQLReserved name;

        AdvancedType(SQLReserved name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name.upper;
        }
    }
}
