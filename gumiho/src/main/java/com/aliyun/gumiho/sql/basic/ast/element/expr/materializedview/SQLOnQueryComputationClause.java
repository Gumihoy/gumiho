package com.aliyun.gumiho.sql.basic.ast.element.expr.materializedview;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLEnableType;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * { ENABLE | DISABLE } ON QUERY COMPUTATION
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-MATERIALIZED-VIEW.html#GUID-EE262CA4-01E5-4618-B659-6165D993CA1B
 *
 * @author kongtong.ouyang on 2018/6/23.
 */
public class SQLOnQueryComputationClause extends AbstractSQLExpr {

    protected SQLEnableType action;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SQLOnQueryComputationClause clone() {
        SQLOnQueryComputationClause x = new SQLOnQueryComputationClause();
        x.action = this.action;
        return x;
    }

    public SQLEnableType getAction() {
        return action;
    }

    public void setAction(SQLEnableType action) {
        this.action = action;
    }

}
