package com.aliyun.gumiho.sql.basic.ast.element.expr.index.attribute;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * COMPUTE STATISTICS
 * <p>
 * index_attributes
 * https://docs.oracle.com/cd/B19306_01/server.102/b14200/statements_5010.htm
 *
 * @author kongtong.ouyang on 2018/7/9.
 */
public class SQLIndexAttributeComputeStatistics extends AbstractSQLExpr implements ISQLIndexAttribute {

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SQLIndexAttributeComputeStatistics clone() {
        return new SQLIndexAttributeComputeStatistics();
    }
}
