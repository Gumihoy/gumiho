package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.select;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

/**
 * UNPIVOT [ {INCLUDE | EXCLUDE} NULLS ] ( { column | ( column [, column]... ) } pivot_for_clause unpivot_in_clause)
 * <p>
 * <p>
 * FOR { column
 * | ( column [, column]... )
 * }
 * <p>
 * unpivot_in_clause :IN
 * ( { column | ( column [, column]... ) }
 * [  AS { literal | ( literal [, literal]... ) } ]
 * [, { column | ( column [, column]... ) }
 * [  AS {literal | ( literal [, literal]... ) } ]
 * ]...
 * )
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/UPDATE.html#GUID-027A462D-379D-4E35-8611-410F3AC8FDA5
 *
 * @author kongtong.ouyang on 2018/5/18.
 */
public class OracleSQLUnPivotClause extends AbstractOracleSQLPivotClause {

    protected NullsType nullsType;

    protected SQLExpr column;

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, column);
            this.acceptChild(visitor, pivotForExpr);
            this.acceptChild(visitor, inItems);
        }
    }


    public NullsType getNullsType() {
        return nullsType;
    }

    public void setNullsType(NullsType nullsType) {
        this.nullsType = nullsType;
    }

    public SQLExpr getColumn() {
        return column;
    }

    public void setColumn(SQLExpr column) {
        this.column = column;
    }

    public enum NullsType {
        INCLUDE_NULLS(SQLReserved.INCLUDE_NULLS),
        EXCLUDE_NULLS(SQLReserved.EXCLUDE_NULLS),;

        public final SQLReserved name;

        NullsType(SQLReserved name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name.upper;
        }
    }

}
