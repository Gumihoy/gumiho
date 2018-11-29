package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * SHARING = { METADATA | NONE }
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/SHARING-clause.html#GUID-3C830338-8B7E-43C0-9EA0-4E292AA1A97B
 *
 * @author kongtong.ouyang on 2018/5/28.
 */
public class SQLSharingClause extends SQLSetOptionExpr {

    public SQLSharingClause() {
    }

    public SQLSharingClause(SQLExpr value) {
        super(SQLReserved.SHARING.ofExpr(), value);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, value);
        }
    }

    @Override
    public SQLSharingClause clone() {
        SQLSharingClause x = new SQLSharingClause();
        this.cloneTo(x);
        return x;
    }

}
