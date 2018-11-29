package com.aliyun.gumiho.sql.basic.ast.enums;

import com.aliyun.gumiho.sql.hash.FNVHash;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Pattern-matching-Conditions.html#GUID-0779657B-06A8-441F-90C5-044B47862A0A
 *
 * @author kongtong.ouyang on 2018/5/11.
 */
public enum SQLLikeOperator {

    LIKE(SQLReserved.LIKE),
    LIKEC(SQLReserved.LIKEC),
    LIKE2(SQLReserved.LIKE2),
    LIKE4(SQLReserved.LIKE4),;
    public final SQLReserved name;

    SQLLikeOperator(SQLReserved name) {
        this.name = name;
    }

    public static SQLLikeOperator of(String name) {
        long lowerHashCode64 = FNVHash.fnv1a_64_lower(name);
        SQLLikeOperator[] operators = SQLLikeOperator.values();
        for (SQLLikeOperator operator : operators) {
            if (operator.name.lowerHashCode64 != lowerHashCode64) {
                continue;
            }
            return operator;
        }
        return null;
    }

    @Override
    public String toString() {
        return name.upper;
    }
}
