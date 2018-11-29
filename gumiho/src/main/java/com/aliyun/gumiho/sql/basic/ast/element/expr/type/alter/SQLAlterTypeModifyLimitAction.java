package com.aliyun.gumiho.sql.basic.ast.element.expr.type.alter;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 *
 *
 * MODIFY LIMIT expr
 *
 * alter_collections_clauses
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/ALTER-TYPE-statement.html#GUID-A8B449E7-E3A8-48F4-A4C6-5BB87B1841CD
 *
 * @author kongtong.ouyang on 2018/9/11.
 */
public class SQLAlterTypeModifyLimitAction extends AbstractSQLExpr implements ISQLAlterTypeAction {

    protected SQLExpr limit;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, limit);
        }
    }

    @Override
    public SQLAlterTypeModifyLimitAction clone() {
        SQLAlterTypeModifyLimitAction x = new SQLAlterTypeModifyLimitAction();
        super.cloneTo(x);
        return x;
    }

    public SQLExpr getLimit() {
        return limit;
    }

    public void setLimit(SQLExpr limit) {
        setChildParent(limit);
        this.limit = limit;
    }
}
