package com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.constraint;

/**
 * MODIFY { CONSTRAINT constraint_name | PRIMARY KEY | UNIQUE (column [, column ]...) } constraint_state [ CASCADE ]
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-TABLE.html#GUID-552E7373-BF93-477D-9DA3-B2C9386F2877
 *
 * @author kongtong.ouyang on 2018/7/11.
 */
public interface ISQLAlterTableModifyTableConstraintAction extends ISQLAlterTableConstraintAction {
    @Override
    ISQLAlterTableModifyTableConstraintAction clone();
}
