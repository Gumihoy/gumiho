package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common.namecursor;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/named-cursor-attribute.html#GUID-CD8D8415-FF19-4D81-99BA-7825FD40CC96
 * @author kongtong.ouyang on 2018/7/2.
 */
public abstract class AbstractOracleSQLNameCursorExpr extends AbstractOracleSQLExpr implements IOracleSQLNameCursorExpr {

    protected SQLExpr name;

    @Override
    public AbstractOracleSQLNameCursorExpr clone() {
        throw new UnsupportedOperationException(getClass().getName());
    }

    public void cloneTo(AbstractOracleSQLNameCursorExpr x) {
        super.cloneTo(x);

        SQLExpr nameClone = this.name.clone();
        x.setName(nameClone);

    }

    public SQLExpr getName() {
        return name;
    }

    public void setName(SQLExpr name) {
        setChildParent(name);
        this.name = name;
    }
}
