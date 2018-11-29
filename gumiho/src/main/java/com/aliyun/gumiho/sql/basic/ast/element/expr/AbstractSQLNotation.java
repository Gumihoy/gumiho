package com.aliyun.gumiho.sql.basic.ast.element.expr;

/**
 * @author kongtong.ouyang on 2018/7/23.
 */
public abstract class AbstractSQLNotation extends AbstractSQLExpr implements SQLNotation {

    protected String notation;

    @Override
    public AbstractSQLNotation clone() {
        throw new UnsupportedOperationException(getClass().getName());
    }

    public void cloneTo(AbstractSQLNotation x) {
        super.cloneTo(x);
        x.notation = this.notation;
    }

    @Override
    public String notation() {
        return notation;
    }

}
