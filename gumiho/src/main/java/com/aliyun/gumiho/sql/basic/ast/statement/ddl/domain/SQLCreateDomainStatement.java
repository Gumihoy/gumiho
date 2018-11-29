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
package com.aliyun.gumiho.sql.basic.ast.statement.ddl.domain;


import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.constraint.SQLConstraint;
import com.aliyun.gumiho.sql.basic.ast.element.datatype.SQLDataType;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.SQLStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.SQLCreateStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

import java.util.List;

/**
 * @author kongtong.ouyang onCondition 2018/1/23.
 * @see {https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#domain definition}
 */
public class SQLCreateDomainStatement extends AbstractSQLStatement implements SQLCreateStatement {

    public SQLName name;

    public boolean as;

    public SQLDataType dataType;

    public SQLExpr defaultExpr;

    public List<SQLConstraint> constraints;

    public SQLName collateName;


    public SQLCreateDomainStatement(DBType dbType) {
        super(dbType);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {

        if (visitor.visit(this)) {
            acceptChild(visitor, name);
        }
    }

    @Override
    public SQLStatement clone() {
        SQLCreateDomainStatement x = new SQLCreateDomainStatement(this.dbType);

        x.setName(this.name);

        return x;
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        return super.replace(source, target);
    }

    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.CREATE_DOMAIN;
    }


    public SQLName getName() {
        return name;
    }

    public void setName(SQLName name) {
        if (name != null) {
            name.setParent(this);
        }

        this.name = name;
    }


    public boolean isAs() {
        return as;
    }

    public void setAs(boolean as) {
        this.as = as;
    }

    public SQLDataType getDataType() {
        return dataType;
    }

    public void setDataType(SQLDataType dataType) {
        this.dataType = dataType;
    }

    public SQLExpr getDefaultExpr() {
        return defaultExpr;
    }

    public void setDefaultExpr(SQLExpr defaultExpr) {
        this.defaultExpr = defaultExpr;
    }

    public List<SQLConstraint> getConstraints() {
        return constraints;
    }

    public void setConstraints(List<SQLConstraint> constraints) {
        this.constraints = constraints;
    }

    public SQLName getCollateName() {
        return collateName;
    }

    public void setCollateName(SQLName collateName) {
        this.collateName = collateName;
    }
}
