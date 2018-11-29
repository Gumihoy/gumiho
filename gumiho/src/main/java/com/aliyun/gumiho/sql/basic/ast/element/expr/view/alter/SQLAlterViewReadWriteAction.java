package com.aliyun.gumiho.sql.basic.ast.element.expr.view.alter;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * READ WRITE
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-VIEW.html#GUID-0DEDE960-B481-4B55-8027-EA9E4C863625
 * @author kongtong.ouyang on 2018/7/13.
 */
public class SQLAlterViewReadWriteAction extends AbstractSQLExpr implements ISQLAlterViewAction {


    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SQLAlterViewReadWriteAction clone() {
        SQLAlterViewReadWriteAction x = new SQLAlterViewReadWriteAction();
        return x;
    }

}
