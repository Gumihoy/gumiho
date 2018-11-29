package com.aliyun.gumiho.sql.basic.ast.element.expr.condition;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * INSERTING
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/expression.html#GUID-D4700B45-F2C8-443E-AEE7-2BD20FFD45B8
 *
 * @author kongtong.ouyang on 2018/6/15.
 */
public class SQLInsertingCondition extends AbstractSQLExpr implements ISQLCondition {

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SQLInsertingCondition clone() {
        SQLInsertingCondition x = new SQLInsertingCondition();
        return x;
    }
}
