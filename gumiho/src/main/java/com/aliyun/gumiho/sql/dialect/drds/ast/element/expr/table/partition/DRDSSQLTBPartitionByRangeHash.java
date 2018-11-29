package com.aliyun.gumiho.sql.dialect.drds.ast.element.expr.table.partition;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.literal.numeric.SQLIntegerLiteral;
import com.aliyun.gumiho.sql.dialect.drds.visitor.DRDSSQLASTVisitor;

/**
 * TBPARTITION BY RANGE_HASH(column)
 * [TBPARTITIONS num]
 * <p>
 * https://help.aliyun.com/document_detail/71300.html?spm=a2c4g.11186623.6.691.2490989ffJMNAN
 *
 * @author kongtong.ouyang on 2018/8/28.
 */
public class DRDSSQLTBPartitionByRangeHash extends AbstractDRDSSQLTBPartitionBy {

    public static final int DEFAULT_RANGE_HASH_NUM = 10;

    protected SQLExpr rangeHashNum = SQLIntegerLiteral.of(DEFAULT_RANGE_HASH_NUM);

    @Override
    public void accept0(DRDSSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, columns);
            this.acceptChild(visitor, rangeHashNum);
            this.acceptChild(visitor, tbPartitionsNum);
        }
    }

    @Override
    public DRDSSQLTBPartitionByRangeHash clone() {
        DRDSSQLTBPartitionByRangeHash x = new DRDSSQLTBPartitionByRangeHash();
        this.cloneTo(x);
        return x;
    }

    public void cloneTo(DRDSSQLTBPartitionByRangeHash x) {
        super.cloneTo(x);
    }

    public SQLExpr getRangeHashNum() {
        return rangeHashNum;
    }

    public void setRangeHashNum(int rangeHashNum) {
        setRangeHashNum(SQLIntegerLiteral.of(rangeHashNum));
    }

    public void setRangeHashNum(SQLExpr rangeHashNum) {
        setChildParent(rangeHashNum);
        this.rangeHashNum = rangeHashNum;
    }
}
