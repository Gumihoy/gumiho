package com.aliyun.gumiho.sql.basic.ast.element.expr.type.alter;

import com.aliyun.gumiho.sql.basic.ast.element.datatype.SQLDataType;
import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 *
 *
 * MODIFY ELEMENT TYPE datatype
 *
 * alter_attribute_definition
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/ALTER-TYPE-statement.html#GUID-A8B449E7-E3A8-48F4-A4C6-5BB87B1841CD
 *
 * @author kongtong.ouyang on 2018/9/11.
 */
public class SQLAlterTypeModifyElementTypeAction extends AbstractSQLExpr implements ISQLAlterTypeAction {

    protected SQLDataType dataType;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, dataType);
        }
    }

    @Override
    public SQLAlterTypeModifyElementTypeAction clone() {
        SQLAlterTypeModifyElementTypeAction x = new SQLAlterTypeModifyElementTypeAction();
        super.cloneTo(x);
        return x;
    }


    public SQLDataType getDataType() {
        return dataType;
    }

    public void setDataType(SQLDataType dataType) {
        setChildParent(dataType);
        this.dataType = dataType;
    }
}
