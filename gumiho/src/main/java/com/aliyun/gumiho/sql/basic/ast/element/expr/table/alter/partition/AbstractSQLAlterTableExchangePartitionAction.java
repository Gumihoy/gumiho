package com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.partition;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.parallel.ISQLParallelClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.ISQLUpdateIndexClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.constraint.option.SQExceptionsClause;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLIncludingType;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLWithType;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * EXCHANGE PARTITION partition_name WITH TABLE tbl_name [{WITH|WITHOUT} VALIDATION]
 * https://dev.mysql.com/doc/refman/5.6/en/alter-table.html
 * <p>
 * EXCHANGE PARTITION partition_name WITH TABLE [ schema. ] table [ { INCLUDING | EXCLUDING } INDEXES ] [ { WITH | WITHOUT } VALIDATION ] [ exceptions_clause ] [ update_index_clauses [ parallel_clause ] ] [ CASCADE ]
 * <p>
 * exchange_partition_subpart
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-TABLE.html#GUID-552E7373-BF93-477D-9DA3-B2C9386F2877
 *
 * @author kongtong.ouyang on 2018/7/12.
 */
public abstract class AbstractSQLAlterTableExchangePartitionAction extends AbstractSQLExpr implements ISQLAlterTablePartitionAction {

    protected SQLExpr table;
    protected SQLIncludingType indexes;
    protected SQLWithType validation;
    protected SQExceptionsClause exceptionsClause;
    protected ISQLUpdateIndexClause updateIndexClause;
    protected ISQLParallelClause parallelClause;
    protected boolean cascade;


    @Override
    public AbstractSQLAlterTableExchangePartitionAction clone() {
        throw new UnsupportedOperationException(getClass().getName());
    }

    public void cloneTo(AbstractSQLAlterTableExchangePartitionAction x) {
        super.cloneTo(x);

    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        return false;
    }


    public SQLExpr getTable() {
        return table;
    }

    public void setTable(SQLExpr table) {
        setChildParent(table);
        this.table = table;
    }

    public SQLIncludingType getIndexes() {
        return indexes;
    }

    public void setIndexes(SQLIncludingType indexes) {
        this.indexes = indexes;
    }

    public SQLWithType getValidation() {
        return validation;
    }

    public void setValidation(SQLWithType validation) {
        this.validation = validation;
    }

    public SQExceptionsClause getExceptionsClause() {
        return exceptionsClause;
    }

    public void setExceptionsClause(SQExceptionsClause exceptionsClause) {
        this.exceptionsClause = exceptionsClause;
    }

    public ISQLUpdateIndexClause getUpdateIndexClause() {
        return updateIndexClause;
    }

    public void setUpdateIndexClause(ISQLUpdateIndexClause updateIndexClause) {
        setChildParent(updateIndexClause);
        this.updateIndexClause = updateIndexClause;
    }

    public ISQLParallelClause getParallelClause() {
        return parallelClause;
    }

    public void setParallelClause(ISQLParallelClause parallelClause) {
        setChildParent(parallelClause);
        this.parallelClause = parallelClause;
    }

    public boolean isCascade() {
        return cascade;
    }

    public void setCascade(boolean cascade) {
        this.cascade = cascade;
    }
}
