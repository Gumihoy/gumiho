package com.aliyun.gumiho.sql.basic.ast.element.expr.view.alter;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * SET SCHEMA new_schema
 * https://www.postgresql.org/docs/10/static/sql-alterview.html
 *
 * @author kongtong.ouyang on 2018/7/13.
 */
public class SQLAlterViewSetSchemalAction extends AbstractSQLExpr implements ISQLAlterViewAction {

    protected SQLName name;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
//        if (visitor.visit(this)) {
//            this.acceptChild(visitor, name);
//        }
    }

    @Override
    public SQLAlterViewSetSchemalAction clone() {
        SQLAlterViewSetSchemalAction x = new SQLAlterViewSetSchemalAction();
        return x;
    }

    public SQLName getName() {
        return name;
    }

    public void setName(SQLName name) {
        this.name = name;
    }
}
