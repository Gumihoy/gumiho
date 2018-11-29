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
package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.databaselink.create;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLIdentifier;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

/**
 * @author kongtong.ouyang onCondition 2018/3/16.
 * @see {https://docs.oracle.com/database/121/SQLRF/statements_5006.htm#SQLRF01205}
 */
public class OracleSQLConnectToIdentifiedByClause extends AbstractOracleSQLExpr {

    protected SQLExpr user;

    protected SQLExpr password;

    protected OracleSQLDBLinkAuthenticationClause dbLinkAuthentication;


    public OracleSQLConnectToIdentifiedByClause() {
    }

    public OracleSQLConnectToIdentifiedByClause(SQLIdentifier user, SQLIdentifier password) {
        this.user = user;
        this.password = password;
    }

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            acceptChild(visitor, dbLinkAuthentication);
        }
    }

    @Override
    public OracleSQLConnectToIdentifiedByClause clone() {

        OracleSQLConnectToIdentifiedByClause x = new OracleSQLConnectToIdentifiedByClause();
        this.cloneTo(x);

        return x;
    }

    public void cloneTo(OracleSQLConnectToIdentifiedByClause x) {

    }

    public SQLExpr getUser() {
        return user;
    }

    public void setUser(SQLExpr user) {
        setChildParent(user);
        this.user = user;
    }

    public SQLExpr getPassword() {
        return password;
    }

    public void setPassword(SQLExpr password) {
        setChildParent(password);
        this.password = password;
    }

    public OracleSQLDBLinkAuthenticationClause getDbLinkAuthentication() {
        return dbLinkAuthentication;
    }

    public void setDbLinkAuthentication(OracleSQLDBLinkAuthenticationClause dbLinkAuthentication) {
        this.dbLinkAuthentication = dbLinkAuthentication;
    }
}
