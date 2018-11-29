package com.aliyun.gumiho.sql.basic.ast.element.expr.table.partition.values;

import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * VALUES LESS THAN MAXVALUE
 * <p>
 * partition_definition 中的 VALUES
 * https://dev.mysql.com/doc/refman/5.7/en/create-table.html
 *
 * @author kongtong.ouyang onCondition 2018/4/9.
 */
public class SQLPartitionValuesLessThanMaxValue extends AbstractSQLPartitionValues {

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SQLPartitionValuesLessThanMaxValue clone() {
        SQLPartitionValuesLessThanMaxValue x = new SQLPartitionValuesLessThanMaxValue();
        this.cloneTo(x);
        return x;
    }

}
