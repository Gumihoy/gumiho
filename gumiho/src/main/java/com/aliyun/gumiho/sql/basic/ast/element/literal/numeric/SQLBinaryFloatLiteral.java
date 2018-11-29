package com.aliyun.gumiho.sql.basic.ast.element.literal.numeric;

import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * xxf/xxF
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Literals.html#GUID-083FEFEA-B33F-436B-AEBF-9101A49EF189
 *
 * @author kongtong.ouyang on 2018/5/15.
 */
public class SQLBinaryFloatLiteral extends AbstractSQLNumericLiteral {


    public SQLBinaryFloatLiteral() {
    }

    public SQLBinaryFloatLiteral(String source) {
        this.source = source;
        this.value = Float.valueOf(source);
    }

    public SQLBinaryFloatLiteral(Float value) {
        this.source = value.toString();
        this.value = value;
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SQLBinaryFloatLiteral clone() {
        SQLBinaryFloatLiteral x = new SQLBinaryFloatLiteral();
        this.cloneTo(x);
        return x;
    }

    @Override
    public Float getValue() {
        return value.floatValue();
    }
}
