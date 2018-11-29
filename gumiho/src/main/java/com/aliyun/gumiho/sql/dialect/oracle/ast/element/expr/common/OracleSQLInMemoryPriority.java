package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common;

import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

/**
 * PRIORITY { NONE | LOW | MEDIUM | HIGH | CRITICAL }
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-TABLE.html#GUID-F9CE0CC3-13AE-4744-A43C-EAC7A71AAAB6
 *
 * @author kongtong.ouyang on 2018/6/25.
 */
public class OracleSQLInMemoryPriority extends AbstractOracleSQLExpr {

    protected  OracleSQLInMemoryPriorityType priorityType;

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public OracleSQLInMemoryPriority clone() {
        OracleSQLInMemoryPriority x = new OracleSQLInMemoryPriority();

        x.priorityType = this.priorityType;
        return x;
    }


    public OracleSQLInMemoryPriorityType getPriorityType() {
        return priorityType;
    }

    public void setPriorityType(OracleSQLInMemoryPriorityType priorityType) {
        this.priorityType = priorityType;
    }

    public enum OracleSQLInMemoryPriorityType {

        NONE(SQLReserved.NONE),
        LOW(SQLReserved.LOW),
        MEDIUM(SQLReserved.MEDIUM),
        HIGH(SQLReserved.HIGH),
        CRITICAL(SQLReserved.CRITICAL),;

        public final SQLReserved name;

        OracleSQLInMemoryPriorityType(SQLReserved name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name.upper;
        }
    }
}
