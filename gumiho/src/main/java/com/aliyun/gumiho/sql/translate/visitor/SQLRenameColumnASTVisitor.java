package com.aliyun.gumiho.sql.translate.visitor;

import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.SQLColumnDefinition;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.SQLLikeClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.SQLTableElement;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.SQLVirtualColumnDefinition;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.constraint.column.*;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.constraint.table.*;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.partition.*;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.partition.sub.*;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.partition.values.SQLPartitionValues;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.partition.values.SQLPartitionValuesIn;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.partition.values.SQLPartitionValuesLessThan;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.partition.values.SQLPartitionValuesLessThanMaxValue;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.partitionset.SQLPartitionsetByList;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.partitionset.SQLPartitionsetByRange;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.partitionset.SQLPartitionsetDefinition;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.table.SQLCreateTableStatement;
import com.aliyun.gumiho.sql.translate.SQLTransformConfig;

/**
 * rename column
 * 修改字段（创建表字段、创建视图字段等）
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-TABLE.html
 *
 * @author kongtong.ouyang on 2018/5/18.
 */
public class SQLRenameColumnASTVisitor extends SQLASTTransformVisitor {

    public SQLRenameColumnASTVisitor(SQLTransformConfig config) {
        super(config);
    }

    @Override
    public boolean visit(SQLCreateTableStatement x) {
        SQLTransformConfig.TableMapping tableMapping = config.findTableMapping(x.getName());
        if (tableMapping == null) {
            return false;
        }

        for (int i = x.getTableElements().size() - 1; i >= 0; i--) {

            SQLTableElement tableElement = x.getTableElements().get(i);

            if (!(tableElement instanceof SQLColumnDefinition)) {
                continue;
            }

            SQLColumnDefinition column = (SQLColumnDefinition) tableElement;

            // modify
            SQLTransformConfig.ColumnMapping columnMapping = tableMapping.findColumnMapping(column.getColumnName());
            if (columnMapping != null) {
                column.setColumnName(columnMapping.targetName);
            }

            // remove
            boolean isRemoveColumn = tableMapping.isRemoveColumn(column.getColumnName());
            if (isRemoveColumn) {
                x.getTableElements().remove(i);
            }
        }


        return false;
    }


    // ------------------------- column constraint Start ----------------------------------------
    @Override
    public boolean visit(SQLCheckColumnConstraint x) {
        return true;
    }

    @Override
    public boolean visit(SQLNotNullColumnConstraint x) {

        return true;
    }

    @Override
    public boolean visit(SQLNullColumnConstraint x) {

        return true;
    }

    @Override
    public boolean visit(SQLPrimaryKeyColumnConstraint x) {
        return true;
    }

    @Override
    public boolean visit(SQLReferencesColumnConstraint x) {

        return true;
    }

    @Override
    public boolean visit(SQLUniqueColumnConstraint x) {

        return true;
    }

    @Override
    public boolean visit(SQLScopeIsColumnConstraint x) {

        return true;
    }

    @Override
    public boolean visit(SQLWithRowIdColumnConstraint x) {

        return true;
    }
    // ------------------------- column constraint End ----------------------------------------


    // ------------------------- table constraint Start ----------------------------------------
    @Override
    public boolean visit(SQLCheckTableConstraint x) {

        return true;
    }

    @Override
    public boolean visit(SQLForeignKeyTableConstraint x) {

        return true;
    }

    @Override
    public boolean visit(SQLPrimaryKeyTableConstraint x) {

        return true;
    }

    @Override
    public boolean visit(SQLUniqueTableConstraint x) {

        return true;
    }

    @Override
    public boolean visit(SQLScopeForTableConstraint x) {

        return true;
    }

    @Override
    public boolean visit(SQLRefWithRowIdTableConstraint x) {
        return true;
    }
    // ------------------------- table constraint End ----------------------------------------


    // ------------------ Table Details Start ----------------------
    @Override
    public boolean visit(SQLColumnDefinition x) {

        return true;
    }

    @Override
    public boolean visit(SQLVirtualColumnDefinition x) {

        return true;
    }

    @Override
    public boolean visit(SQLLikeClause x) {

        return true;
    }

    @Override
    public boolean visit(SQLPartitionByConsistentHash x) {
        return true;
    }

    @Override
    public boolean visit(SQLPartitionByHash x) {
        return true;
    }

    @Override
    public boolean visit(SQLPartitionByKey x) {
        return true;
    }

    @Override
    public boolean visit(SQLPartitionByList x) {
        return true;
    }

    @Override
    public boolean visit(SQLPartitionByListColumns x) {
        return true;
    }

    @Override
    public boolean visit(SQLPartitionByRange x) {
        return true;
    }

    @Override
    public boolean visit(SQLPartitionByRangeColumns x) {
        return true;
    }

    @Override
    public boolean visit(SQLPartitionByReference x) {
        return true;
    }

    @Override
    public boolean visit(SQLPartitionBySystem x) {
        return true;
    }

    @Override
    public boolean visit(SQLPartitionDefinition x) {
        return true;
    }

    @Override
    public boolean visit(SQLPartitionsetByList x) {
        return true;
    }

    @Override
    public boolean visit(SQLPartitionsetByRange x) {
        return true;
    }

    @Override
    public boolean visit(SQLPartitionsetDefinition x) {
        return true;
    }

    @Override
    public boolean visit(SQLSubPartitionByHash x) {
        return true;
    }

    @Override
    public boolean visit(SQLSubPartitionByKey x) {
        return true;
    }

    @Override
    public boolean visit(SQLSubPartitionByList x) {
        return true;
    }

    @Override
    public boolean visit(SQLSubPartitionByRange x) {
        return true;
    }

    @Override
    public boolean visit(SQLSubpartitionTemplate x) {
        return true;
    }

    @Override
    public boolean visit(SQLSubPartitionDefinition x) {
        return true;
    }

    @Override
    public boolean visit(SQLPartitionValuesLessThan x) {
        return true;
    }

    @Override
    public boolean visit(SQLPartitionValuesLessThanMaxValue x) {
        return true;
    }

    @Override
    public boolean visit(SQLPartitionValuesIn x) {
        return true;
    }

    @Override
    public boolean visit(SQLPartitionValues x) {
        return true;
    }
// ------------------ Table Details Start ----------------------
}
