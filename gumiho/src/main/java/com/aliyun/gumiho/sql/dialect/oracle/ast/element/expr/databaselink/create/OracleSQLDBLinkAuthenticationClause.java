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
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

/**
 * @author kongtong.ouyang onCondition 2018/3/16.
 * @see {https://docs.oracle.com/database/121/SQLRF/statements_5006.htm#SQLRF01205}
 */
public class OracleSQLDBLinkAuthenticationClause extends AbstractOracleSQLExpr {

    protected SQLExpr user;

    protected SQLExpr password;


    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, user);
            this.acceptChild(visitor, password);
        }
    }

    @Override
    public OracleSQLDBLinkAuthenticationClause clone() {
        OracleSQLDBLinkAuthenticationClause x = new OracleSQLDBLinkAuthenticationClause();
        this.cloneTo(x);
        return x;
    }

    public void cloneTo(OracleSQLDBLinkAuthenticationClause x) {

    }


    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == user) {
            setUser(target);
            return true;
        }
        if (source == password) {
            setPassword(target);
            return true;
        }
        return false;
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
}
