package com.aliyun.gumiho.sql.basic.ast.element.literal.numeric;

import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * xxd/xxD
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Literals.html#GUID-083FEFEA-B33F-436B-AEBF-9101A49EF189
 *
 * @author kongtong.ouyang on 2018/5/15.
 */
public class SQLBinaryDoubleLiteral extends AbstractSQLNumericLiteral {


    public SQLBinaryDoubleLiteral() {
    }

    public SQLBinaryDoubleLiteral(String source) {
        this.source = source;
        this.value = Double.parseDouble(source);
    }

    public SQLBinaryDoubleLiteral(Double value) {
        this.value = value;
    }


    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SQLBinaryDoubleLiteral clone() {
        SQLBinaryDoubleLiteral x = new SQLBinaryDoubleLiteral();
        this.cloneTo(x);
        return x;
    }

    @Override
    public Double getValue() {
        return value.doubleValue();
    }
}
