package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * RANGE low .. high
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/block.html#GUID-9ACEB9ED-567E-4E1A-A16A-B8B35214FC9D
 *
 * @author kongtong.ouyang on 2018/5/31.
 */
public class SQLRangeExpr extends AbstractSQLExpr {

    protected SQLExpr lowValue;
    protected SQLExpr highValue;

    public SQLRangeExpr() {
    }

    public SQLRangeExpr(SQLExpr lowValue, SQLExpr highValue) {
        setLowValue(lowValue);
        setHighValue(highValue);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, lowValue);
            this.acceptChild(visitor, highValue);
        }
    }


    public SQLExpr getLowValue() {
        return lowValue;
    }

    public void setLowValue(SQLExpr lowValue) {
        setChildParent(lowValue);
        this.lowValue = lowValue;
    }

    public SQLExpr getHighValue() {
        return highValue;
    }

    public void setHighValue(SQLExpr highValue) {
        setChildParent(highValue);
        this.highValue = highValue;
    }
}
