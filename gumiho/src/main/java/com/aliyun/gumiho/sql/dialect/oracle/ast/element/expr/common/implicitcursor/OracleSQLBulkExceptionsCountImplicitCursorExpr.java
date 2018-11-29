package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common.implicitcursor;

import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

/**
 * SQL%BULK_EXCEPTIONS.COUNT
 *
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/implicit-cursor-attribute.html#GUID-5A938EE7-E8D2-468C-B60F-81898F110BE1
 * @author kongtong.ouyang on 2018/7/2.
 */
public class OracleSQLBulkExceptionsCountImplicitCursorExpr extends AbstractOracleSQLExpr implements IOracleSQLImplicitCursorExpr {

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public OracleSQLBulkExceptionsCountImplicitCursorExpr clone() {
        OracleSQLBulkExceptionsCountImplicitCursorExpr x = new OracleSQLBulkExceptionsCountImplicitCursorExpr();
        return x;
    }
}
