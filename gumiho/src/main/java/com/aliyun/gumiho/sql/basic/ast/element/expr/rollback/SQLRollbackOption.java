package com.aliyun.gumiho.sql.basic.ast.element.expr.rollback;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.statement.tcl.SQLRollbackStatement;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ROLLBACK.html#GUID-94551F0C-A47F-43DE-BC68-9B1C1ED38C93
 *
 * @author kongtong.ouyang on 2018/6/29.
 * @see SQLRollbackStatement
 */
public interface SQLRollbackOption extends SQLExpr {
    @Override
    SQLRollbackOption clone();
}
