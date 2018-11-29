package com.aliyun.gumiho.sql.basic.ast.element.expr.table.partition.values;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;

import java.util.ArrayList;
import java.util.List;

/**
 * partition_definition 中的 VALUES
 * https://dev.mysql.com/doc/refman/5.7/en/create-table.html
 * <p>
 * range_values_clause、list_values_clause
 * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/sqlrf/CREATE-TABLE.html
 *
 * @author kongtong.ouyang onCondition 2018/4/9.
 */
public abstract class AbstractSQLPartitionValues extends AbstractSQLExpr implements ISQLPartitionValues {

    protected final List<SQLExpr> values = new ArrayList<>();

    @Override
    public AbstractSQLPartitionValues clone() {
        throw new UnsupportedOperationException(getClass().getName());
    }

    public void cloneTo(AbstractSQLPartitionValues x) {
        super.cloneTo(x);

        for (SQLExpr value : values) {
            SQLExpr valueClone = value.clone();
            x.addValue(valueClone);
        }
    }

    @Override
    public List<SQLExpr> getValues() {
        return values;
    }

    public void addValue(SQLExpr value) {
        if (value == null) {
            return;
        }
        setChildParent(value);
        this.values.add(value);
    }
}
