package com.aliyun.gumiho.sql.dialect.drds.ast.element.expr.table.partition;

import com.aliyun.gumiho.sql.dialect.drds.visitor.DRDSSQLASTVisitor;

/**
 * TBPARTITION BY DD (column)}
 * [TBPARTITIONS num]
 * <p>
 * https://help.aliyun.com/document_detail/71300.html?spm=a2c4g.11186623.6.691.2490989ffJMNAN
 *
 * @author kongtong.ouyang on 2018/8/28.
 */
public class DRDSSQLTBPartitionByDD extends AbstractDRDSSQLTBPartitionBy {

    @Override
    public void accept0(DRDSSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, columns);
            this.acceptChild(visitor, tbPartitionsNum);
        }
    }

    @Override
    public DRDSSQLTBPartitionByDD clone() {
        DRDSSQLTBPartitionByDD x = new DRDSSQLTBPartitionByDD();
        this.cloneTo(x);
        return x;
    }

    public void cloneTo(DRDSSQLTBPartitionByDD x) {
        super.cloneTo(x);

    }
}
