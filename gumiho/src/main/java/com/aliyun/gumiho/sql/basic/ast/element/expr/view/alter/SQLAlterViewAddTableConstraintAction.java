package com.aliyun.gumiho.sql.basic.ast.element.expr.view.alter;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.constraint.table.ISQLTableConstraint;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * ADD out_of_line_constraint
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-VIEW.html#GUID-0DEDE960-B481-4B55-8027-EA9E4C863625
 * @author kongtong.ouyang on 2018/7/13.
 */
public class SQLAlterViewAddTableConstraintAction extends AbstractSQLExpr implements ISQLAlterViewAction {

    protected ISQLTableConstraint constraint;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, constraint);
        }
    }

    @Override
    public SQLAlterViewAddTableConstraintAction clone() {
        SQLAlterViewAddTableConstraintAction x = new SQLAlterViewAddTableConstraintAction();
        ISQLTableConstraint constraintClone = this.constraint.clone();
        x.setConstraint(constraintClone);
        return x;
    }

    public ISQLTableConstraint getConstraint() {
        return constraint;
    }

    public void setConstraint(ISQLTableConstraint constraint) {
        setChildParent(constraint);
        this.constraint = constraint;
    }
}
