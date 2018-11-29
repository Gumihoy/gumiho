package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common.implicitcursor;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.enums.ISQLEnum;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

/**
 * SQL%BULK_EXCEPTIONS (index) . (ERROR_INDEX|ERROR_CODE)
 *
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/implicit-cursor-attribute.html#GUID-5A938EE7-E8D2-468C-B60F-81898F110BE1
 * @author kongtong.ouyang on 2018/7/2.
 */
public class OracleSQLBulkExceptionImplicitCursorExpr extends AbstractOracleSQLExpr implements IOracleSQLImplicitCursorExpr {

    protected SQLExpr index;
    protected Function function;

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, index);
        }
    }

    @Override
    public OracleSQLBulkExceptionImplicitCursorExpr clone() {
        OracleSQLBulkExceptionImplicitCursorExpr x = new OracleSQLBulkExceptionImplicitCursorExpr();

        SQLExpr indexClone = this.index.clone();
        x.setIndex(indexClone);

        x.function = this.function;
        return x;
    }


    public SQLExpr getIndex() {
        return index;
    }

    public void setIndex(SQLExpr index) {
        setChildParent(index);
        this.index = index;
    }

    public Function getFunction() {
        return function;
    }

    public void setFunction(Function function) {
        this.function = function;
    }

    public enum Function implements ISQLEnum {
        ERROR_INDEX(SQLReserved.ERROR_INDEX),
        ERROR_CODE(SQLReserved.ERROR_CODE),;
        public final SQLReserved name;

        Function(SQLReserved name) {
            this.name = name;
        }

        @Override
        public SQLReserved getName() {
            return name;
        }
    }
}
