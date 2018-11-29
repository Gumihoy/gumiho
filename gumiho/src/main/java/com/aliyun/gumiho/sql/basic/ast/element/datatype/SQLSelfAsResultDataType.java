package com.aliyun.gumiho.sql.basic.ast.element.datatype;

import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * SELF AS RESULT
 *
 * @author kongtong.ouyang on 2018/6/20.
 */
public class SQLSelfAsResultDataType extends AbstractSQLDataType {

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, arguments);
        }
    }

    @Override
    public SQLSelfAsResultDataType clone() {
        SQLSelfAsResultDataType x = new SQLSelfAsResultDataType();
        this.cloneTo(x);
        return x;
    }
}
