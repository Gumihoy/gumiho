package com.aliyun.gumiho.sql.basic.ast.element.datatype;

import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * xx%TYPE
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/TYPE-attribute.html#GUID-EAB44F7E-B2AB-4AC6-B83D-B586193D75FC
 *
 * @author kongtong.ouyang on 2018/4/20.
 */
public class SQLPercentTypeDataType extends AbstractSQLDataType {

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, nameExpr);
        }
    }

    @Override
    public String getName() {
        if (this.name == null) {
            this.name = nameExpr.getFullName() + SQLReserved.PERCENT_TYPE;
        }
        return name;
    }

}
