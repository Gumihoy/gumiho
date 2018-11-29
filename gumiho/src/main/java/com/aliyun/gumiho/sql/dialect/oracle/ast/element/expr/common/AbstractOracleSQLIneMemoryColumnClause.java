package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;

import java.util.ArrayList;
import java.util.List;

/**
 * INMEMORY [ inmemory_memcompress ] | NO INMEMORY } ( column [, column ]... )
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-TABLE.html#GUID-F9CE0CC3-13AE-4744-A43C-EAC7A71AAAB6
 *
 * @author kongtong.ouyang on 2018/6/25.
 */
public abstract class AbstractOracleSQLIneMemoryColumnClause extends AbstractOracleSQLExpr implements IOracleSQLInMemoryColumnClause {

    protected final List<SQLExpr> columns = new ArrayList<>();

    @Override
    public AbstractOracleSQLIneMemoryColumnClause clone() {
        throw new UnsupportedOperationException(getClass().getName());
    }

    public void cloneTo(AbstractOracleSQLIneMemoryColumnClause x) {
        super.cloneTo(x);

        for (SQLExpr column : this.columns) {
            SQLExpr columnClone = column.clone();
            x.addColumn(columnClone);
        }
    }

    public List<SQLExpr> getColumns() {
        return columns;
    }

    public void addColumn(SQLExpr column) {
        if (column == null) {
            return;
        }
        setChildParent(column);
        this.columns.add(column);
    }
}
