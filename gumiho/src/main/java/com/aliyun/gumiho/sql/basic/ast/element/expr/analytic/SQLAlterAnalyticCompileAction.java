package com.aliyun.gumiho.sql.basic.ast.element.expr.analytic;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * COMPILE
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-ANALYTIC-VIEW.html#GUID-5256BE3A-F134-40D4-8E70-684E073574C8
 *
 * @author kongtong.ouyang on 2018/8/1.
 */
public class SQLAlterAnalyticCompileAction extends AbstractSQLExpr implements ISQLAlterAnalyticAction {

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SQLAlterAnalyticCompileAction clone() {
        return new SQLAlterAnalyticCompileAction();
    }
}
