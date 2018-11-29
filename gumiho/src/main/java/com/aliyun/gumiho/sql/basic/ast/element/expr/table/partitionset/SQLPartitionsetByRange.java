package com.aliyun.gumiho.sql.basic.ast.element.expr.table.partitionset;

import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * Partition By
 * <p>
 * https://dev.mysql.com/doc/refman/5.7/en/create-table.html
 * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/sqlrf/CREATE-TABLE.html
 *
 * @author kongtong.ouyang onCondition 2018/4/10.
 */
public class SQLPartitionsetByRange extends AbstractSQLPartitionsetBy {

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, columns);
            this.acceptChild(visitor, partitionBy);
            this.acceptChild(visitor, subPartitionBy);
            this.acceptChild(visitor, partitionsets);
        }
    }

    @Override
    public SQLPartitionsetByRange clone() {
        SQLPartitionsetByRange x = new SQLPartitionsetByRange();
        this.cloneTo(x);
        return x;
    }
}

