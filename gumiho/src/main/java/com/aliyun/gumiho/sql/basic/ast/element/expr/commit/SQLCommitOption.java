package com.aliyun.gumiho.sql.basic.ast.element.expr.commit;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.statement.tcl.SQLCommitStatement;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/COMMIT.html#GUID-6CD5C9A7-54B9-4FA2-BA3C-D6B4492B9EE2
 *
 * @author kongtong.ouyang on 2018/6/29.
 * @see SQLCommitStatement
 */
public interface SQLCommitOption extends SQLExpr {
    @Override
    SQLCommitOption clone();
}
