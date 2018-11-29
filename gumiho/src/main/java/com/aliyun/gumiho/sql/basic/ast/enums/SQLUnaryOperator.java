package com.aliyun.gumiho.sql.basic.ast.enums;

import com.aliyun.gumiho.sql.hash.FNVHash;

import java.util.concurrent.ConcurrentHashMap;

/**
 * +、-、~、!、NOT
 * https://dev.mysql.com/doc/refman/8.0/en/expressions.html
 *
 * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/sqlrf/About-SQL-Operators.html#GUID-CF1DBF8D-966F-4E5E-8AC8-9BF777B984D8
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/expression.html#GUID-D4700B45-F2C8-443E-AEE7-2BD20FFD45B8
 *
 * @author kongtong.ouyang on 2018/4/4.
 */
public enum SQLUnaryOperator {

    POSITIVE(SQLReserved.PLUS_SIGN),  // +
    NEGATIVE(SQLReserved.MINUS_SIGN), // -

    BIT_NOT_OP(SQLReserved.BIT_NOT_OP),  // ~
    EXCLAMATION_SYMBOL(SQLReserved.EXCLAMATION_SYMBOL),  // !
    BINARY(SQLReserved.BINARY),  // binary

    /**
     * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Hierarchical-Query-Operators.html#GUID-95F6A554-C6FE-42CD-88A6-7A1C162ED964
     */
    PRIOR(SQLReserved.PRIOR), // PRIOR

    /**
     * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Hierarchical-Query-Operators.html#GUID-95F6A554-C6FE-42CD-88A6-7A1C162ED964
     */
    CONNECT_BY_ROOT(SQLReserved.CONNECT_BY_ROOT), // CONNECT_BY_ROOT

    COLLATE(SQLReserved.COLLATE), // COLLATE

    ;


    public final SQLReserved name;

    SQLUnaryOperator(SQLReserved name) {
        this.name = name;
    }


    public static SQLUnaryOperator of(String name) {
        long lowerHashCode64 = FNVHash.fnv1a_64_lower(name);
        return SQLUnaryOperatorHolder.MAP.get(lowerHashCode64);
    }


    public static class SQLUnaryOperatorHolder {
        private static final ConcurrentHashMap<Long, SQLUnaryOperator> MAP = new ConcurrentHashMap<>();

        static {
            for (SQLUnaryOperator operator : SQLUnaryOperator.values()) {
                MAP.put(operator.name.lowerHashCode64, operator);
            }
        }

    }

    @Override
    public String toString() {
        return name.upper;
    }


}
