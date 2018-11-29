package com.aliyun.gumiho.sql.basic.ast.element.datatype.collection;

import com.aliyun.gumiho.sql.basic.ast.element.datatype.AbstractSQLDataType;
import com.aliyun.gumiho.sql.basic.ast.element.datatype.SQLDataType;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * TABLE OF datatype [ NOT NULL ] INDEX BY { PLS_INTEGER | BINARY_INTEGER | VARCHAR2 ( v_size ) | data_type }
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/collection-variable.html#GUID-89A1863C-65A1-40CF-9392-86E9FDC21BE9
 *
 * @author kongtong.ouyang on 2018/4/20.
 */
public class SQLAssocArrayDataType extends AbstractSQLDataType implements ISQLCollectionDataType {

    protected SQLDataType ofDataType;

    protected boolean notNull;

    protected SQLDataType indexByDataType;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, ofDataType);
            this.acceptChild(visitor, indexByDataType);
        }
    }


    @Override
    public SQLAssocArrayDataType clone() {
        SQLAssocArrayDataType x = new SQLAssocArrayDataType();

        this.cloneTo(x);
        return x;
    }

    public void cloneTo(SQLAssocArrayDataType x) {
        super.cloneTo(x);

        SQLDataType ofDataTypeClone = this.ofDataType.clone();
        x.setOfDataType(ofDataTypeClone);

        x.notNull = this.notNull;

        SQLDataType indexByDataTypeClone = this.indexByDataType.clone();
        x.setIndexByDataType(indexByDataTypeClone);
    }


    public SQLDataType getOfDataType() {
        return ofDataType;
    }

    public void setOfDataType(SQLDataType ofDataType) {
        setChildParent(ofDataType);
        this.ofDataType = ofDataType;
    }

    public boolean isNotNull() {
        return notNull;
    }

    public void setNotNull(boolean notNull) {
        this.notNull = notNull;
    }

    public SQLDataType getIndexByDataType() {
        return indexByDataType;
    }

    public void setIndexByDataType(SQLDataType indexByDataType) {
        setChildParent(indexByDataType);
        this.indexByDataType = indexByDataType;
    }
}
