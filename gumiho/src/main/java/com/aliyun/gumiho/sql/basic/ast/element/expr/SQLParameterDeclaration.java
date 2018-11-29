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
package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.ast.element.datatype.SQLDataType;
import com.aliyun.gumiho.sql.basic.ast.element.expr.clause.SQLDefaultClause;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLParameterModel;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * [ <parameter mode> ] [ <SQL parameter name> ] <parameter type> [ RESULT ]
 * <parameter mode>    ::=   IN | OUT | INOUT
 * <parameter type>    ::=   <data type> [ <locator indication> ]
 * <locator indication>    ::=   AS LOCATOR
 * <p>
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#SQL%20parameter%20declaration
 * <p>
 * <p>
 * parameter
 * parameter [ IN ] datatype [ { := | DEFAULT } expression
 * parameter [ IN ] { OUT | IN OUT } [ NOCOPY ] datatype
 *
 * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/lnpls/formal-parameter-declaration.html#GUID-5BA8E033-96B9-439A-A4FC-4844FEC14AD8
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/formal-parameter-declaration.html#GUID-5BA8E033-96B9-439A-A4FC-4844FEC14AD8
 *
 * @author kongtong.ouyang onCondition 2018/3/18.
 */
public class SQLParameterDeclaration extends AbstractSQLExpr {

    protected SQLParameterModel parameterModel;

    protected SQLName name;

    protected boolean noCopy;

    protected SQLDataType dataType;

    protected boolean locatorIndication;

    protected boolean result;

    protected SQLDefaultClause defaultClause;


    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
            this.acceptChild(visitor, dataType);
            this.acceptChild(visitor, defaultClause);
        }
    }

    @Override
    public SQLParameterDeclaration clone() {
        SQLParameterDeclaration x = new SQLParameterDeclaration();


        x.parameterModel = this.parameterModel;

        SQLName nameClone = this.name.clone();
        x.setName(nameClone);

        SQLDataType dataTypeClone = dataType.clone();
        x.setDataType(dataTypeClone);

        x.locatorIndication = this.locatorIndication;

        x.result = this.result;

        SQLDefaultClause defaultExprClone = this.defaultClause.clone();
        x.setDefaultClause(defaultExprClone);

        return x;
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == name
                && target instanceof SQLName) {
            this.setName((SQLName)target);
            return true;
        }

        if (source == dataType
                && target instanceof SQLDataType) {
            this.setDataType((SQLDataType)target);
            return true;
        }

        return false;
    }

    public SQLParameterModel getParameterModel() {
        return parameterModel;
    }

    public void setParameterModel(SQLParameterModel parameterModel) {
        this.parameterModel = parameterModel;
    }

    public SQLName getName() {
        return name;
    }

    public void setName(SQLName name) {
        setChildParent(name);
        this.name = name;
    }

    public boolean isNoCopy() {
        return noCopy;
    }

    public void setNoCopy(boolean noCopy) {
        this.noCopy = noCopy;
    }

    public SQLDataType getDataType() {
        return dataType;
    }

    public void setDataType(SQLDataType dataType) {
        setChildParent(dataType);
        this.dataType = dataType;
    }

    public boolean isLocatorIndication() {
        return locatorIndication;
    }

    public void setLocatorIndication(boolean locatorIndication) {
        this.locatorIndication = locatorIndication;
    }


    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public SQLDefaultClause getDefaultClause() {
        return defaultClause;
    }

    public void setDefaultClause(SQLDefaultClause defaultClause) {
        setChildParent(defaultClause);
        this.defaultClause = defaultClause;
    }
}
