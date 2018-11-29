package com.aliyun.gumiho.sql.dialect.drds.ast.element.expr.table.partition;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.literal.numeric.SQLIntegerLiteral;
import com.aliyun.gumiho.sql.dialect.drds.visitor.DRDSSQLASTVisitor;

/**
 * DBPARTITION BY RANGE_HASH(column, [column], .., num)
 * [ tbPartitionBy ]
 * <p>
 * https://help.aliyun.com/document_detail/71300.html?spm=a2c4g.11186623.6.691.2490989ffJMNAN
 *
 * @author kongtong.ouyang on 2018/8/28.
 */
public class DRDSSQLDBPartitionByRangeHash extends AbstractDRDSSQLDBPartitionBy {

    public static final int DEFAULT_RANGE_HASH_NUM = 10;

    protected SQLExpr rangeHashNum = SQLIntegerLiteral.of(DEFAULT_RANGE_HASH_NUM);

    @Override
    public void accept0(DRDSSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, columns);
            this.acceptChild(visitor, rangeHashNum);
            this.acceptChild(visitor, tbPartitionBy);
        }
    }

    @Override
    public DRDSSQLDBPartitionByRangeHash clone() {
        DRDSSQLDBPartitionByRangeHash x = new DRDSSQLDBPartitionByRangeHash();
        this.cloneTo(x);
        return x;
    }

    public void cloneTo(DRDSSQLDBPartitionByRangeHash x) {
        super.cloneTo(x);
    }

    public SQLExpr getRangeHashNum() {
        return rangeHashNum;
    }

    public void setRangeHashNum(Integer rangeHashNum) {
        if (rangeHashNum == null) {
            return;
        }
        setRangeHashNum(SQLIntegerLiteral.of(rangeHashNum));
    }

    public void setRangeHashNum(SQLExpr rangeHashNum) {
        if (rangeHashNum == null) {
            return;
        }
        setChildParent(rangeHashNum);
        this.rangeHashNum = rangeHashNum;
    }


}
