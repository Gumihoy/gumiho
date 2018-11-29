package com.aliyun.gumiho.sql.basic.ast.element.datatype.collection;

import com.aliyun.gumiho.sql.basic.ast.element.datatype.AbstractSQLDataType;
import com.aliyun.gumiho.sql.basic.ast.element.datatype.SQLDataType;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * VARRAY ( size_limit ) OF datatype [ NOT NULL ]
 * VARRAY ( size_limit ) OF ( datatype [ NOT NULL ] )
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/collection-variable.html#GUID-89A1863C-65A1-40CF-9392-86E9FDC21BE9
 *
 * @author kongtong.ouyang on 2018/4/20.
 */
public class SQLVarrayDataType extends AbstractSQLDataType implements ISQLCollectionDataType {

    protected SQLExpr size;

    protected SQLDataType dataType;

    protected boolean notNull;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, size);
            this.acceptChild(visitor, dataType);
        }
    }

    @Override
    public SQLVarrayDataType clone() {
        SQLVarrayDataType x = new SQLVarrayDataType();

        this.cloneTo(x);
        return x;
    }


    public void cloneTo(SQLVarrayDataType x) {
        super.cloneTo(x);

        SQLExpr sizeClone = this.size.clone();
        x.setSize(sizeClone);

        x.notNull = this.notNull;

        SQLDataType dataTypeClone = this.dataType.clone();
        x.setDataType(dataTypeClone);
    }


    public SQLExpr getSize() {
        return size;
    }

    public void setSize(SQLExpr size) {
        setChildParent(size);
        this.size = size;
    }

    public SQLDataType getDataType() {
        return dataType;
    }

    public void setDataType(SQLDataType dataType) {
        setChildParent(dataType);
        this.dataType = dataType;
    }

    public boolean isNotNull() {
        return notNull;
    }

    public void setNotNull(boolean notNull) {
        this.notNull = notNull;
    }

}
