package com.aliyun.gumiho.sql.dialect.drds.ast.element.expr.table.partition;

import com.aliyun.gumiho.sql.dialect.drds.visitor.DRDSSQLASTVisitor;

/**
 * TBPARTITION BY WEEK (column)}
 * [TBPARTITIONS num]
 * <p>
 * https://help.aliyun.com/document_detail/71300.html?spm=a2c4g.11186623.6.691.2490989ffJMNAN
 *
 * @author kongtong.ouyang on 2018/8/28.
 */
public class DRDSSQLTBPartitionByWeek extends AbstractDRDSSQLTBPartitionBy {

    @Override
    public void accept0(DRDSSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, columns);
            this.acceptChild(visitor, tbPartitionsNum);
        }
    }

    @Override
    public DRDSSQLTBPartitionByWeek clone() {
        DRDSSQLTBPartitionByWeek x = new DRDSSQLTBPartitionByWeek();
        this.cloneTo(x);
        return x;
    }

    public void cloneTo(DRDSSQLTBPartitionByWeek x) {
        super.cloneTo(x);
    }
}
