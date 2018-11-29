/*
 * Copyright (C) 2017-2018 kent(kent.bohai@gmail.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common;

import com.aliyun.gumiho.sql.basic.ast.element.datatype.SQLDataType;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLParameterDeclaration;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * FUNCTION function_name [ ( parameter_declaration [, parameter_declaration ] ) ] RETURN datatype
 *
 * https://docs.oracle.com/database/121/LNPLS/function.htm#GUID-4E19FB09-46B5-4CE5-8A5B-CD815C29DA1C__CJADHAHB
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/function-declaration-and-definition.html#GUID-4E19FB09-46B5-4CE5-8A5B-CD815C29DA1C
 *
 * @author kongtong.ouyang on 2018/3/18.
 */
public class OracleSQLFunctionHeading extends AbstractOracleSQLExpr implements OracleSQLElementStatement {

    protected SQLName name;

    protected final List<SQLParameterDeclaration> parameters = new ArrayList<>();

    protected SQLDataType returnDataType;


    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
            this.acceptChild(visitor, parameters);
            this.acceptChild(visitor, returnDataType);
        }
    }

    public void cloneTo(OracleSQLFunctionHeading x) {
        super.cloneTo(x);

        SQLName nameClone = this.name.clone();
        x.setName(nameClone);

        for (SQLParameterDeclaration parameter : parameters) {
            SQLParameterDeclaration parameterClone = parameter.clone();
            x.addParameter(parameterClone);
        }

        SQLDataType returnDataTypeClone = this.returnDataType.clone();
        x.setReturnDataType(returnDataTypeClone);
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == name
                && target instanceof SQLName) {
            setName((SQLName)target);
            return true;
        }

        if (source == returnDataType
                && target instanceof SQLDataType) {
            setReturnDataType((SQLDataType)target);
            return true;
        }
        return false;
    }

    public SQLName getName() {
        return name;
    }

    public void setName(SQLName name) {
        setChildParent(name);
        this.name = name;
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

    public void addAllParameter(List<SQLParameterDeclaration> parameters) {
        if (parameters == null
                || parameters.size() == 0) {
            return;
        }
        for (SQLParameterDeclaration parameter : parameters) {
            setChildParent(parameter);
        }
        this.parameters.addAll(parameters);
    }

    public SQLDataType getReturnDataType() {
        return returnDataType;
    }

    public void setReturnDataType(SQLDataType returnDataType) {
        setChildParent(returnDataType);
        this.returnDataType = returnDataType;
    }

}
