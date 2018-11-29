package com.aliyun.gumiho.sql.basic.ast.element.datatype.money;

import com.aliyun.gumiho.sql.basic.ast.SQLObject;
import com.aliyun.gumiho.sql.basic.ast.element.datatype.AbstractSQLDataType;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * money
 * <p>
 * https://www.postgresql.org/docs/devel/static/datatype-money.html
 *
 * @author kongtong.ouyang on 2018/4/20.
 */
public class SQLMoneyDataType extends AbstractSQLDataType {


    public SQLMoneyDataType() {
        super(SQLReserved.MONEY.ofExpr());
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SQLMoneyDataType clone() {
        SQLMoneyDataType x = new SQLMoneyDataType();
        return x;
    }

    @Override
    public void cloneTo(SQLObject x) {
        super.cloneTo(x);
    }

    @Override
    public String getName() {
        if (this.name == null) {

        }
        return name;
    }

    @Override
    public void setName(String name) {

    }

}
