package com.aliyun.gumiho.sql.basic.ast.element.expr.index.alter.partition;

import com.aliyun.gumiho.sql.basic.ast.element.expr.index.alter.ISQLAlterIndexAction;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-INDEX.html#GUID-D8F648E7-8C07-4C89-BB71-862512536558
 *
 * @author kongtong.ouyang on 2018/7/10.
 */
public interface ISQLAlterIndexPartitionAction extends ISQLAlterIndexAction {
    @Override
    ISQLAlterIndexPartitionAction clone();
}
