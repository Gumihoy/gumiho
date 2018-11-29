package com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * DISABLE CONTAINERS_DEFAULT
 *
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-TABLE.html#GUID-552E7373-BF93-477D-9DA3-B2C9386F2877
 * @author kongtong.ouyang on 2018/7/17.
 */
public class SQLAlterTableDisableContainersDefaultAction extends AbstractSQLExpr implements ISQLAlterTableAction {

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SQLAlterTableDisableContainersDefaultAction clone() {
        return new SQLAlterTableDisableContainersDefaultAction();
    }
}