package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common;

import com.aliyun.gumiho.sql.basic.ast.element.expr.ISQLPhysicalProperty;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

/**
 * SEGMENT CREATION { IMMEDIATE | DEFERRED }
 *
 * deferred_segment_creation
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-MATERIALIZED-VIEW.html#GUID-EE262CA4-01E5-4618-B659-6165D993CA1B
 * @author kongtong.ouyang on 2018/6/22.
 */
public class OracleSQLDeferredSegmentCreation extends AbstractOracleSQLExpr implements ISQLPhysicalProperty {

    protected OracleSQLSegmentCreationType type;


    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public OracleSQLDeferredSegmentCreation clone() {
        OracleSQLDeferredSegmentCreation x = new OracleSQLDeferredSegmentCreation();
        x.type = this.type;
        return x;
    }

    public OracleSQLSegmentCreationType getType() {
        return type;
    }

    public void setType(OracleSQLSegmentCreationType type) {
        this.type = type;
    }

    public enum OracleSQLSegmentCreationType {

        IMMEDIATE(SQLReserved.IMMEDIATE),
        DEFERRED(SQLReserved.DEFERRED),;

        public final SQLReserved name;

        OracleSQLSegmentCreationType(SQLReserved name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name.upper;
        }
    }
}
