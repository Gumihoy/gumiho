package com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.constraint;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.constraint.table.ISQLTableConstraint;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * ADD <table constraint definition>
 * <table constraint definition>    ::=   [ <constraint name definition> ] <table constraint> [ <constraint characteristics> ]
 * <p>
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#add%20table%20constraint%20definition
 * <p>
 *
 *
 * ADD table_constraint [ NOT VALID ]
 * https://www.postgresql.org/docs/devel/static/sql-altertable.html
 * <p>
 * <p>
 * ADD { { out_of_line_constraint }... | out_of_line_REF_constraint }
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-TABLE.html#GUID-552E7373-BF93-477D-9DA3-B2C9386F2877
 *
 * @author kongtong.ouyang on 2018/6/4.
 */
public class SQLAlterTableAddTableConstraintAction extends AbstractSQLExpr implements ISQLAlterTableConstraintAction {

    protected boolean paren = false;
    protected final List<ISQLTableConstraint> constraints = new ArrayList<>();

    protected boolean notValid;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, constraints);
        }
    }

    @Override
    public SQLAlterTableAddTableConstraintAction clone() {
        SQLAlterTableAddTableConstraintAction x = new SQLAlterTableAddTableConstraintAction();
        this.cloneTo(x);
        return x;
    }

    public void cloneTo(SQLAlterTableAddTableConstraintAction x) {
        super.cloneTo(x);

        for (ISQLTableConstraint constraint : constraints) {
            ISQLTableConstraint constraintClone = constraint.clone();
            x.addConstraint(constraintClone);
        }

        x.notValid = this.notValid;
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {

        if (target == null) {
            boolean replace = replaceInList(constraints, source, null, this);
            if (replace) {
                return true;
            }
            return false;
        }

        if (target instanceof ISQLTableConstraint) {
            boolean replace = replaceInList(constraints, source, (ISQLTableConstraint) target, this);
            if (replace) {
                return true;
            }
        }

        return false;
    }


    public boolean isParen() {
        return paren;
    }

    public void setParen(boolean paren) {
        this.paren = paren;
    }

    public List<ISQLTableConstraint> getConstraints() {
        return constraints;
    }

    public void addConstraint(ISQLTableConstraint constraint) {
        if (constraint == null) {
            return;
        }
        setChildParent(constraint);
        this.constraints.add(constraint);
    }

    public boolean isNotValid() {
        return notValid;
    }

    public void setNotValid(boolean notValid) {
        this.notValid = notValid;
    }
}
