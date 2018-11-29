package com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.constraint;

/**
 * DROP { { PRIMARY KEY | UNIQUE (column [, column ]...) } [ CASCADE ] [ { KEEP | DROP } INDEX ] | CONSTRAINT constraint_name [ CASCADE ] } [ ONLINE ]
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-TABLE.html#GUID-552E7373-BF93-477D-9DA3-B2C9386F2877
 *
 * @author kongtong.ouyang on 2018/7/11.
 */
public interface ISQLAlterTableDropTableConstraintAction extends ISQLAlterTableConstraintAction {
    @Override
    ISQLAlterTableDropTableConstraintAction clone();
}
