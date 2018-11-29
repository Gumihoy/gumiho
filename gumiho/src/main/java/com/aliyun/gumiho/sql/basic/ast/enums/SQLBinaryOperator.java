package com.aliyun.gumiho.sql.basic.ast.enums;

import com.aliyun.gumiho.sql.hash.FNVHash;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/sqlrf/About-SQL-Operators.html#GUID-CF1DBF8D-966F-4E5E-8AC8-9BF777B984D8
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/plsql-language-fundamentals.html#GUID-04DDDD9B-2D62-4D2D-BF89-74581CE78840
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/expression.html#GUID-D4700B45-F2C8-443E-AEE7-2BD20FFD45B8
 *
 * @author kongtong.ouyang onCondition 2018/4/4.
 */
public enum SQLBinaryOperator implements ISQLEnum {

    Multiply(SQLReserved.ASTERISK), // *
    Divide(SQLReserved.SOLIDUS),    // /
    DIV(SQLReserved.DIV),   // DIV
    Mod(SQLReserved.MOD),   // mod
    PERCENT(SQLReserved.PERCENT),   // %

    Add(SQLReserved.PLUS_SIGN),     // +
    Subtract(SQLReserved.MINUS_SIGN), // -

    LESS_THAN_LESS_THAN_OP(SQLReserved.LESS_THAN_LESS_THAN_OP),                 // <<
    GREATER_THAN_GREATER_THAN_OP(SQLReserved.GREATER_THAN_GREATER_THAN_OP),     // >>


    AMPERSAND(SQLReserved.AMPERSAND),     // &

    BIT_OR_OP(SQLReserved.BIT_OR_OP),     // |

    EQUALS_OP(SQLReserved.EQUALS_OP),   // =

    LESS_THAN_OR_EQUAL_OR_GREATER_THAN_OP(SQLReserved.LESS_THAN_OR_EQUAL_OR_GREATER_THAN_OP),   // <=>

    NOT_EQUAL_OP(SQLReserved.NOT_EQUAL_OP), // !=
    LESS_THAN_OR_GREATER(SQLReserved.LESS_THAN_OR_GREATER), // <>
    NOT_EQUAL_OP2(SQLReserved.NOT_EQUAL_OP2),   // ~=
    XOR_ASSIGN(SQLReserved.XOR_ASSIGN), // ^=

    GREATER_THAN_OP(SQLReserved.GREATER_THAN_OP), // >
    GREATER_THAN_OR_EQUALS_OP(SQLReserved.GREATER_THAN_OR_EQUALS_OP),   // >=
    LESS_THAN_OP(SQLReserved.LESS_THAN_OP), // <
    LESS_THAN_OR_EQUALS_OP(SQLReserved.LESS_THAN_OR_EQUALS_OP), // <= 4


    LOGIC_AND_OP(SQLReserved.LOGIC_AND_OP),     // &&
    And(SQLReserved.AND),   // and

    XOR(SQLReserved.XOR), // xor

    LOGIC_OR_OP(SQLReserved.LOGIC_OR_OP),       // ||
    Or(SQLReserved.OR), // or


    VarAssign(SQLReserved.VAR_ASSIGN_OP),   // :=

    MULTISET_EXCEPT(SQLReserved.MULTISET_EXCEPT),   // multiset except
    MULTISET_EXCEPT_ALL(SQLReserved.MULTISET_EXCEPT_ALL),
    MULTISET_EXCEPT_DISTINCT(SQLReserved.MULTISET_EXCEPT_DISTINCT),

    MULTISET_INTERSECT(SQLReserved.MULTISET_INTERSECT),
    MULTISET_INTERSECT_ALL(SQLReserved.MULTISET_INTERSECT_ALL),
    MULTISET_INTERSECT_DISTINCT(SQLReserved.MULTISET_INTERSECT_DISTINCT),

    MULTISET_UNION(SQLReserved.MULTISET_UNION),
    MULTISET_UNION_ALL(SQLReserved.MULTISET_UNION_ALL),
    MULTISET_UNION_DISTINCT(SQLReserved.MULTISET_UNION_DISTINCT),


    COLLATE(SQLReserved.COLLATE),   // collate

    ;


    public final SQLReserved name;

    SQLBinaryOperator(SQLReserved name) {
        this.name = name;
    }

    public static SQLBinaryOperator of(String name) {
        long lowerHashCode64 = FNVHash.fnv1a_64_lower(name);
        SQLBinaryOperator[] operators = SQLBinaryOperator.values();
        for (SQLBinaryOperator operator : operators) {
            if (operator.name.lowerHashCode64 != lowerHashCode64) {
                continue;
            }
            return operator;
        }
        return null;
    }

    @Override
    public SQLReserved getName() {
        return name;
    }

    @Override
    public String toString() {
        return name.upper;
    }





    public boolean isLogical () {
        return isLogical(this);
    }


    /**
     * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Arithmetic-Operators.html#GUID-46CD9FD8-FC94-44BA-AA62-30A16063EAAE
     */
    public static boolean isArithmetic(SQLBinaryOperator operator) {
        switch (operator) {
            case Add:
            case Subtract:
            case Multiply:
            case Divide:
                return true;
            default:
                return false;
        }
    }

    /**
     * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Arithmetic-Operators.html#GUID-46CD9FD8-FC94-44BA-AA62-30A16063EAAE
     */
    public static boolean isMultiset(SQLBinaryOperator operator) {
        switch (operator) {
            case MULTISET_EXCEPT:
            case MULTISET_EXCEPT_ALL:
            case MULTISET_EXCEPT_DISTINCT:

            case MULTISET_INTERSECT:
            case MULTISET_INTERSECT_ALL:
            case MULTISET_INTERSECT_DISTINCT:

            case MULTISET_UNION:
            case MULTISET_UNION_ALL:
            case MULTISET_UNION_DISTINCT:
                return true;
            default:
                return false;
        }
    }

    /**
     * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Comparison-Conditions.html#GUID-828576BF-E606-4EA6-B94B-BFF48B67F927
     */
    public static boolean isComparison(SQLBinaryOperator operator) {
        switch (operator) {
            case EQUALS_OP:

            case NOT_EQUAL_OP:
            case LESS_THAN_OR_GREATER:
            case NOT_EQUAL_OP2:
            case XOR_ASSIGN:

            case GREATER_THAN_OP:
            case GREATER_THAN_OR_EQUALS_OP:
            case LESS_THAN_OP:
            case LESS_THAN_OR_EQUALS_OP:

                return true;
            default:
                return false;
        }
    }


    /**
     * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Logical-Conditions.html#GUID-C5E48AF2-3FF9-401D-A104-CDB5FC19E65F
     */
    public static boolean isLogical(SQLBinaryOperator operator) {
        switch (operator) {
            case And:
            case Or:
                return true;
            default:
                return false;
        }
    }

}
