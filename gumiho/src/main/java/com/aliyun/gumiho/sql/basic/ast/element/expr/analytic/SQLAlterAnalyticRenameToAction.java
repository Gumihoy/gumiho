package com.aliyun.gumiho.sql.basic.ast.element.expr.analytic;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * RENAME TO new_av_name
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-ANALYTIC-VIEW.html#GUID-5256BE3A-F134-40D4-8E70-684E073574C8
 *
 * @author kongtong.ouyang on 2018/8/1.
 */
public class SQLAlterAnalyticRenameToAction extends AbstractSQLExpr implements ISQLAlterAnalyticAction {

    protected SQLName name;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
        }
    }

    @Override
    public SQLAlterAnalyticRenameToAction clone() {
        SQLAlterAnalyticRenameToAction x = new SQLAlterAnalyticRenameToAction();
        return x;
    }

    public SQLName getName() {
        return name;
    }

    public void setName(SQLName name) {
        setChildParent(name);
        this.name = name;
    }
}
