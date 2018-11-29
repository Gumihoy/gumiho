package com.aliyun.gumiho.sql.basic.ast.element.expr.clause;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * [NOT] DETERMINISTIC
 * https://dev.mysql.com/doc/refman/8.0/en/create-procedure.html
 * <p>
 * DETERMINISTIC
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/DETERMINISTIC-clause.html#GUID-6AECC957-27CC-4334-9F43-0FBE88F92654
 *
 * @author kongtong.ouyang on 2018/6/1.
 */
public class SQLDeterministicClause extends AbstractSQLExpr {

    protected boolean not;

    @Override
    public void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SQLDeterministicClause clone() {
        SQLDeterministicClause x = new SQLDeterministicClause();
        this.cloneTo(x);

        x.not = this.not;

        return x;
    }

    public boolean isNot() {
        return not;
    }

    public void setNot(boolean not) {
        this.not = not;
    }
}
