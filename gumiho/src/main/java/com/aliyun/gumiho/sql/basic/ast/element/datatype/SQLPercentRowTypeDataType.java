package com.aliyun.gumiho.sql.basic.ast.element.datatype;

import com.aliyun.gumiho.sql.basic.ast.SQLObject;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * xx%ROWTYPE
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/ROWTYPE-attribute.html#GUID-4E0B9FE2-909D-444A-9B4A-E0243B7FCB99
 *
 * @author kongtong.ouyang on 2018/4/20.
 */
public class SQLPercentRowTypeDataType extends AbstractSQLDataType {


    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, nameExpr);
        }
    }

    @Override
    public SQLPercentRowTypeDataType clone() {
        SQLPercentRowTypeDataType x = new SQLPercentRowTypeDataType();
        return x;
    }

    @Override
    public void cloneTo(SQLObject x) {
        super.cloneTo(x);
    }

    @Override
    public String getName() {
        if (this.name == null) {
            this.name = nameExpr.getFullName() + SQLReserved.PERCENT_ROWTYPE;
        }
        return name;
    }

}
