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
package com.aliyun.gumiho.sql.basic.ast.statement.ddl.function;


import com.aliyun.gumiho.sql.basic.ast.element.datatype.SQLDataType;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLDefinerOptionExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLParameterDeclaration;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLSharingClause;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLASType;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLEditionAbleType;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLOrReplaceType;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.SQLCreateStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

import java.util.ArrayList;
import java.util.List;

/**
 * CREATE [ OR REPLACE ] FUNCTION  name
 * [ (parameter declaration...) ]  [ dispatch ]
 * <p>
 * <p>
 * dispatch:  STATIC DISPATCH
 * <p>
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#schema%20function
 * <p>
 * CREATE [DEFINER = { user | CURRENT_USER }] FUNCTION sp_name ([func_parameter[,...]])
 * RETURNS type
 * [characteristic ...] routine_body
 * https://dev.mysql.com/doc/refman/8.0/en/create-procedure.html
 * <p>
 * CREATE [ OR REPLACE ] [ EDITIONABLE | NONEDITIONABLE ] FUNCTION [ schema. ] function_name
 * [ ( parameter_declaration [, parameter_declaration]... ) ] RETURN datatype
 * [ sharing_clause ] [ { invoker_rights_clause | accessible_by_clause | default_collation_clause | deterministic_clause | parallel_enable_clause | result_cache_clause | aggragate_clause | pipelined_clause }... ] { IS | AS }
 * { [ declare_section ] body | call_spec } ;
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/CREATE-FUNCTION-statement.html#GUID-B71BC5BD-B87C-4054-AAA5-213E856651F2
 *
 * @author kongtong.ouyang onCondition 2018/1/23.
 */
public class SQLCreateFunctionStatement extends AbstractSQLStatement implements SQLCreateStatement {

    protected SQLOrReplaceType orReplace;

    protected SQLEditionAbleType editionAbleType;

    protected boolean aggregate;

    protected SQLDefinerOptionExpr definerOptionExpr;

    protected SQLName name;

    protected final List<SQLParameterDeclaration> parameters = new ArrayList<>();

    protected SQLDataType returnDataType;

    protected SQLSharingClause sharingClause;

    protected final List<SQLExpr> options = new ArrayList<>();

    protected boolean dispatch;

    protected SQLASType as;

    protected final List<SQLExpr> declareSections = new ArrayList<>();

    protected SQLExpr asExpr;


    public SQLCreateFunctionStatement(DBType dbType) {
        super(dbType);
    }


    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
            this.acceptChild(visitor, parameters);
            this.acceptChild(visitor, returnDataType);
            this.acceptChild(visitor, sharingClause);
            this.acceptChild(visitor, options);
            this.acceptChild(visitor, declareSections);
            this.acceptChild(visitor, asExpr);
        }
    }

    @Override
    public SQLCreateFunctionStatement clone() {
        SQLCreateFunctionStatement x = new SQLCreateFunctionStatement(this.dbType);
        this.cloneTo(x);
        return x;
    }


    public void cloneTo(SQLCreateFunctionStatement x) {
        super.cloneTo(x);

        x.orReplace = this.orReplace;

        x.editionAbleType = this.editionAbleType;

        x.aggregate = this.aggregate;

        SQLName nameClone = this.name.clone();
        x.setName(nameClone);

        for (SQLParameterDeclaration parameter : parameters) {
            SQLParameterDeclaration parameterClone = parameter.clone();
            x.addParameter(parameterClone);
        }

        if (this.returnDataType != null) {
            SQLDataType returnDataTypeClone = this.returnDataType.clone();
            x.setReturnDataType(returnDataTypeClone);
        }

        if (this.sharingClause != null) {
            SQLSharingClause sharingClauseClone = this.sharingClause.clone();
            x.setSharingClause(sharingClauseClone);
        }

        for (SQLExpr option : this.options) {
            SQLExpr optionClone = option.clone();
            x.addOption(optionClone);
        }

        x.as = this.as;

        for (SQLExpr declareSection : this.declareSections) {
            SQLExpr declareSectionClone = declareSection.clone();
            x.addDeclareSection(declareSectionClone);
        }
        if (this.asExpr != null) {
            SQLExpr asExprClone = this.asExpr.clone();
            x.setAsExpr(asExprClone);
        }

    }


    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == name
                && target instanceof SQLName) {
            this.setName((SQLName) target);
            return true;
        }

        if (source == returnDataType
                && target instanceof SQLDataType) {
            this.setReturnDataType((SQLDataType) target);
            return true;
        }
        return false;
    }


    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.CREATE_FUNCTION;
    }


    public SQLOrReplaceType getOrReplace() {
        return orReplace;
    }

    public void setOrReplace(SQLOrReplaceType orReplace) {
        this.orReplace = orReplace;
    }

    public SQLEditionAbleType getEditionAbleType() {
        return editionAbleType;
    }

    public void setEditionAbleType(SQLEditionAbleType editionAbleType) {
        this.editionAbleType = editionAbleType;
    }

    public boolean isAggregate() {
        return aggregate;
    }

    public void setAggregate(boolean aggregate) {
        this.aggregate = aggregate;
    }


    public SQLDefinerOptionExpr getDefinerOptionExpr() {
        return definerOptionExpr;
    }

    public SQLCreateFunctionStatement setDefinerOptionExpr(SQLDefinerOptionExpr definerOptionExpr) {
        this.definerOptionExpr = definerOptionExpr;
        return this;
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
        parameter.setParent(this);
        this.parameters.add(parameter);
    }

    public SQLDataType getReturnDataType() {
        return returnDataType;
    }

    public void setReturnDataType(SQLDataType returnDataType) {
        setChildParent(returnDataType);
        this.returnDataType = returnDataType;
    }

    public SQLSharingClause getSharingClause() {
        return sharingClause;
    }

    public void setSharingClause(SQLSharingClause sharingClause) {
        setChildParent(sharingClause);
        this.sharingClause = sharingClause;
    }

    public List<SQLExpr> getOptions() {
        return options;
    }

    public void addOption(SQLExpr option) {
        if (option == null) {
            return;
        }
        setChildParent(option);
        this.options.add(option);
    }

    public boolean isDispatch() {
        return dispatch;
    }

    public void setDispatch(boolean dispatch) {
        this.dispatch = dispatch;
    }

    public SQLASType getAs() {
        return as;
    }

    public void setAs(SQLASType as) {
        this.as = as;
    }

    public List<SQLExpr> getDeclareSections() {
        return declareSections;
    }

    public void addDeclareSection(SQLExpr declareSection) {
        if (declareSection == null) {
            return;
        }
        setChildParent(declareSection);
        this.declareSections.add(declareSection);
    }

    public SQLExpr getAsExpr() {
        return asExpr;
    }

    public void setAsExpr(SQLExpr asExpr) {
        setChildParent(asExpr);
        this.asExpr = asExpr;
    }
}
