package com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.constraint;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.constraint.option.ISQLConstraintOption;

import java.util.ArrayList;
import java.util.List;

/**
 * MODIFY { CONSTRAINT constraint_name | PRIMARY KEY | UNIQUE (column [, column ]...) } constraint_state [ CASCADE ]
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-TABLE.html#GUID-552E7373-BF93-477D-9DA3-B2C9386F2877
 *
 * @author kongtong.ouyang on 2018/7/11.
 */
public abstract class AbstractSQLAlterTableModifyTableConstraintAction extends AbstractSQLExpr implements ISQLAlterTableModifyTableConstraintAction {

    protected final List<ISQLConstraintOption> options = new ArrayList<>();
    protected boolean cascade;

    @Override
    public AbstractSQLAlterTableModifyTableConstraintAction clone() {
        throw new UnsupportedOperationException(getClass().getName());
    }


    public void cloneTo(AbstractSQLAlterTableModifyTableConstraintAction x) {
        super.cloneTo(x);
        x.cascade = this.cascade;
    }

    public List<ISQLConstraintOption> getOptions() {
        return options;
    }

    public void addOption(ISQLConstraintOption option) {
        if (option == null) {
            return;
        }
        setChildParent(option);
        this.options.add(option);
    }

    public boolean isCascade() {
        return cascade;
    }

    public void setCascade(boolean cascade) {
        this.cascade = cascade;
    }
}
