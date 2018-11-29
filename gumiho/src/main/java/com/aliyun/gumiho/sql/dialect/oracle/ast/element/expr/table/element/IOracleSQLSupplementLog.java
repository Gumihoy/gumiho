package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.table.element;

import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.SQLTableElement;

/**
 * SUPPLEMENTAL LOG GROUP log_group (column [ NO LOG ] [, column [ NO LOG ] ]...) [ ALWAYS ]
 * <p>
 * SUPPLEMENTAL LOG DATA ( { ALL | PRIMARY KEY | UNIQUE | FOREIGN KEY } [, { ALL | PRIMARY KEY | UNIQUE | FOREIGN KEY } ]... ) COLUMNS
 * <p>
 * supplemental_logging_props
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-TABLE.html#GUID-F9CE0CC3-13AE-4744-A43C-EAC7A71AAAB6
 *
 * @author kongtong.ouyang on 2018/7/16.
 */
public interface IOracleSQLSupplementLog extends SQLTableElement {
    @Override
    IOracleSQLSupplementLog clone();


}
