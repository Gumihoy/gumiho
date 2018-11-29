package com.aliyun.gumiho.sql.basic.ast.element.datatype.row;

import com.aliyun.gumiho.sql.basic.ast.element.datatype.AbstractSQLDataType;
import com.aliyun.gumiho.sql.basic.ast.element.datatype.SQLDataType;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * ROW <row type body>
 *
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#row%20type
 *
 * @author kongtong.ouyang on 2018/4/4.
 */
public class SQLRowDataTypeImpl extends AbstractSQLDataType implements SQLDataType {

    public SQLRowDataTypeImpl() {
        super(SQLReserved.ROW.ofExpr());
    }


    @Override
    protected void accept0(SQLASTVisitor visitor) {

    }


}
