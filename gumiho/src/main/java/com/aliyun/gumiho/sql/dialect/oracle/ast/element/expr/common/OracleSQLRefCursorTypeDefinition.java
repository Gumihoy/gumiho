package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common;

import com.aliyun.gumiho.sql.basic.ast.element.datatype.SQLDataType;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

/**
 * ref_cursor_type_definition
 * 
 * TYPE type IS REF CURSOR [ RETURN { {db_table_or_view | cursor | cursor_variable}%ROWTYPE | record%TYPE | record_type | ref_cursor_type }] ;
 * 
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/cursor-variable-declaration.html#GUID-CE884B31-07F0-46AA-8067-EBAF73821F3D
 *
 * @author kongtong.ouyang on 2018/4/25.
 */
public class OracleSQLRefCursorTypeDefinition extends AbstractOracleSQLExpr implements OracleSQLTypeDefinition {

    protected SQLName name;

    protected SQLDataType returnDataType;

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
            this.acceptChild(visitor, returnDataType);
        }
    }


    public SQLName getName() {
        return name;
    }

    public void setName(SQLName name) {
        this.name = name;
    }

    public SQLDataType getReturnDataType() {
        return returnDataType;
    }

    public void setReturnDataType(SQLDataType returnDataType) {
        this.returnDataType = returnDataType;
    }
}
