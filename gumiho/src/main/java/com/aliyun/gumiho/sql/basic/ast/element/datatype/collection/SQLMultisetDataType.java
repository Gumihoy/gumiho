package com.aliyun.gumiho.sql.basic.ast.element.datatype.collection;

import com.aliyun.gumiho.sql.basic.ast.SQLObject;
import com.aliyun.gumiho.sql.basic.ast.element.datatype.AbstractSQLDataType;
import com.aliyun.gumiho.sql.basic.ast.element.datatype.SQLDataType;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * <data type> MULTISET
 * <p>
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#multiset%20type
 * <p>
 *
 * @author kongtong.ouyang on 2018/4/20.
 */
public class SQLMultisetDataType extends AbstractSQLDataType {

    protected SQLDataType dataType;

    @Override
    protected void accept0(SQLASTVisitor visitor) {

    }


    @Override
    public SQLMultisetDataType clone() {
        SQLMultisetDataType x = new SQLMultisetDataType();
        return x;
    }

    @Override
    public void cloneTo(SQLObject x) {
        super.cloneTo(x);
    }

    public SQLDataType getDataType() {
        return dataType;
    }

    public void setDataType(SQLDataType dataType) {
        this.dataType = dataType;
    }
}
