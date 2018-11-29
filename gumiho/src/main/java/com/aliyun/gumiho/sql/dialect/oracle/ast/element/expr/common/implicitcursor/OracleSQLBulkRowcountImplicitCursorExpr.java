package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common.implicitcursor;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

/**
 * SQL%BULK_ROWCOUNT (index)
 *
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/implicit-cursor-attribute.html#GUID-5A938EE7-E8D2-468C-B60F-81898F110BE1
 * @author kongtong.ouyang on 2018/7/2.
 */
public class OracleSQLBulkRowcountImplicitCursorExpr extends AbstractOracleSQLExpr implements IOracleSQLImplicitCursorExpr {

    protected SQLExpr index;

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, index);
        }
    }

    @Override
    public OracleSQLBulkRowcountImplicitCursorExpr clone() {
        OracleSQLBulkRowcountImplicitCursorExpr x = new OracleSQLBulkRowcountImplicitCursorExpr();
        SQLExpr indexClone = this.index.clone();
        x.setIndex(indexClone);
        return x;
    }

    public SQLExpr getIndex() {
        return index;
    }

    public void setIndex(SQLExpr index) {
        setChildParent(index);
        this.index = index;
    }
}
