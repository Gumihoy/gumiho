package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common;

import com.aliyun.gumiho.sql.basic.ast.element.datatype.SQLDataType;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLParameterDeclaration;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;

import java.util.ArrayList;
import java.util.List;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/element-specification.html#GUID-20D95D8A-5C17-4C89-9AAB-1852CDB57CE2
 *
 * @author kongtong.ouyang on 2018/6/17.
 */
public abstract class OracleSQLConstructorHeading extends AbstractOracleSQLExpr {

    protected boolean final_;

    protected boolean instantiable;

    protected SQLDataType dataType;

    protected SQLDataType selfInOutDataType;

    protected final List<SQLParameterDeclaration> parameters = new ArrayList<>();


    @Override
    public OracleSQLConstructorHeading clone() {
        throw new UnsupportedOperationException(getClass().getName());
    }

    public void cloneTo(OracleSQLConstructorHeading x) {
        super.cloneTo(x);
        x.final_ = this.final_;
        x.instantiable = this.instantiable;

        if (this.dataType != null) {
            SQLDataType dataTypeClone = this.dataType.clone();
            x.setDataType(dataTypeClone);
        }

        if (this.selfInOutDataType != null) {
            SQLDataType selfInOutDataTypeClone = this.selfInOutDataType.clone();
            x.setSelfInOutDataType(selfInOutDataTypeClone);
        }

        for (SQLParameterDeclaration parameter : parameters) {
            SQLParameterDeclaration parameterClone = parameter.clone();
            x.addParameter(parameterClone);
        }
    }


    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == dataType
                && target instanceof SQLDataType) {
            setDataType((SQLDataType) target);
            return true;
        }

        if (source == selfInOutDataType
                && target instanceof SQLDataType) {
            setSelfInOutDataType((SQLDataType) target);
            return true;
        }

        return false;
    }

    public boolean isFinal_() {
        return final_;
    }

    public void setFinal_(boolean final_) {
        this.final_ = final_;
    }

    public boolean isInstantiable() {
        return instantiable;
    }

    public void setInstantiable(boolean instantiable) {
        this.instantiable = instantiable;
    }

    public SQLDataType getDataType() {
        return dataType;
    }

    public void setDataType(SQLDataType dataType) {
        setChildParent(dataType);
        this.dataType = dataType;
    }

    public SQLDataType getSelfInOutDataType() {
        return selfInOutDataType;
    }

    public void setSelfInOutDataType(SQLDataType selfInOutDataType) {
        setChildParent(selfInOutDataType);
        this.selfInOutDataType = selfInOutDataType;
    }

    public List<SQLParameterDeclaration> getParameters() {
        return parameters;
    }

    public void addParameter(SQLParameterDeclaration parameter) {
        if (parameter == null) {
            return;
        }
        setChildParent(parameter);
        this.parameters.add(parameter);
    }
}
