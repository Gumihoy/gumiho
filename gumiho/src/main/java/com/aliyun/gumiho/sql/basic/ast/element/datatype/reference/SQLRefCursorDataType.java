package com.aliyun.gumiho.sql.basic.ast.element.datatype.reference;

import com.aliyun.gumiho.sql.basic.ast.element.datatype.AbstractSQLDataType;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * REF CURSOR
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/cursor-variable-declaration.html#GUID-CE884B31-07F0-46AA-8067-EBAF73821F3D
 *
 * @author kongtong.ouyang on 2018/4/19.
 */
public class SQLRefCursorDataType extends AbstractSQLDataType implements ISQLRefDataType {


    @Override
    protected void accept0(SQLASTVisitor visitor) {

    }

}
