package com.aliyun.gumiho.sql.basic.ast.element.expr.table.partition;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * PARTITION BY LINEAR? KEY LEFT_PAREN expr RIGHT_PAREN (PARTITIONS partitionsNum=expr)? iSubPartitionBy?
 * (LEFT_PAREN partitionDefinition (COMMA partitionDefinition)* RIGHT_PAREN)?
 *
 * https://dev.mysql.com/doc/refman/5.7/en/create-table.html
 * <p>
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/sqlrf/CREATE-TABLE.html
 *
 * @author kongtong.ouyang onCondition 2018/4/10.
 */
public class SQLPartitionByKey extends AbstractSQLPartitionBy {

    protected SQLExpr algorithm;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, algorithm);
            this.acceptChild(visitor, columns);
            this.acceptChild(visitor, partitionsNum);
            this.acceptChild(visitor, storeInClause);
            this.acceptChild(visitor, subPartitionBy);
            this.acceptChild(visitor, partitions);
        }
    }

    @Override
    public SQLPartitionByKey clone() {
        SQLPartitionByKey x = new SQLPartitionByKey();
        this.cloneTo(x);
        return x;
    }

    public SQLExpr getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(SQLExpr algorithm) {
        setChildParent(algorithm);
        this.algorithm = algorithm;
    }
}
