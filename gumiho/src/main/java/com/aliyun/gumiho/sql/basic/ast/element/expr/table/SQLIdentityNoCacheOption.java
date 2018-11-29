package com.aliyun.gumiho.sql.basic.ast.element.expr.table;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * NOCACHE
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-TABLE.html#GUID-F9CE0CC3-13AE-4744-A43C-EAC7A71AAAB6
 *
 * @author kongtong.ouyang onCondition 2018/4/2.
 */
public class SQLIdentityNoCacheOption extends AbstractSQLExpr implements SQLIdentityOption {


    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SQLIdentityNoCacheOption clone() {
        return new SQLIdentityNoCacheOption();
    }
}
