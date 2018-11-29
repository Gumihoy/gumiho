package com.aliyun.gumiho.sql.basic.ast.element.datatype.object;

import com.aliyun.gumiho.sql.basic.ast.element.datatype.AbstractSQLDataType;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * OBJECT
 * <p>
 * object_type_def
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/CREATE-TYPE-statement.html#GUID-389D603D-FBD0-452A-8414-240BBBC57034
 *
 * @author kongtong.ouyang on 2018/4/20.
 */
public class SQLObjectDataType extends AbstractSQLDataType {

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SQLObjectDataType clone() {
        SQLObjectDataType x = new SQLObjectDataType();
        return x;
    }


}
