package com.aliyun.gumiho.sql.basic.ast.element.expr.view.alter;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.constraint.table.ISQLTableConstraint;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.enums.ISQLEnum;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 *  MODIFY CONSTRAINT constraint  { RELY | NORELY }
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-VIEW.html#GUID-0DEDE960-B481-4B55-8027-EA9E4C863625
 * @author kongtong.ouyang on 2018/7/13.
 */
public class SQLAlterViewModifyConstraintAction extends AbstractSQLExpr implements ISQLAlterViewAction {

    protected SQLName constraint;
    protected SQLOption option;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, constraint);
        }
    }

    @Override
    public SQLAlterViewModifyConstraintAction clone() {
        SQLAlterViewModifyConstraintAction x = new SQLAlterViewModifyConstraintAction();
        SQLName constraintClone = this.constraint.clone();
        x.setConstraint(constraintClone);

        x.option = this.option;

        return x;
    }

    public SQLName getConstraint() {
        return constraint;
    }

    public void setConstraint(SQLName constraint) {
        setChildParent(constraint);
        this.constraint = constraint;
    }

    public SQLOption getOption() {
        return option;
    }

    public void setOption(SQLOption option) {
        this.option = option;
    }

    public enum  SQLOption implements ISQLEnum {

        RELY(SQLReserved.RELY),
        NORELY(SQLReserved.NORELY);

        public final SQLReserved name;

        SQLOption(SQLReserved name) {
            this.name = name;
        }

        @Override
        public SQLReserved getName() {
            return name;
        }
    }
}
