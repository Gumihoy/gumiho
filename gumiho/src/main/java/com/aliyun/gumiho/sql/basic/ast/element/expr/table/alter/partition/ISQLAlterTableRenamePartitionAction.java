package com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.partition;

/**
 * @author kongtong.ouyang on 2018/7/16.
 */
public interface ISQLAlterTableRenamePartitionAction extends ISQLAlterTablePartitionAction {
    @Override
    ISQLAlterTableRenamePartitionAction clone();
}
