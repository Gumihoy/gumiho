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

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * function_heading [ DETERMINISTIC | PIPELINED | PARALLEL_ENABLE | RESULT_CACHE ]... ;
 * <p>
 * https://docs.oracle.com/database/121/LNPLS/function.htm#GUID-4E19FB09-46B5-4CE5-8A5B-CD815C29DA1C__CJADHAHB
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/function-declaration-and-definition.html#GUID-4E19FB09-46B5-4CE5-8A5B-CD815C29DA1C
 *
 * @author kongtong.ouyang onCondition 2018/3/18.
 */
public class OracleSQLFunctionDeclaration extends OracleSQLFunctionHeading implements OracleSQLElementStatement {

    protected OracleSQLElementSpec.ISQLExternalNameClause externalClause;

    protected final List<SQLExpr> properties = new ArrayList<>();

    public OracleSQLFunctionDeclaration() {
    }

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
            this.acceptChild(visitor, parameters);
            this.acceptChild(visitor, returnDataType);
            this.acceptChild(visitor, externalClause);
            this.acceptChild(visitor, properties);
        }
    }

    @Override
    public OracleSQLFunctionDeclaration clone() {
        OracleSQLFunctionDeclaration x = new OracleSQLFunctionDeclaration();

        this.cloneTo(x);
        return x;
    }

    public void cloneTo(OracleSQLFunctionDeclaration x) {
        super.cloneTo(x);

        for (SQLExpr property : this.properties) {
            SQLExpr propertyClone = property.clone();
            x.addProperty(propertyClone);
        }
    }

    public OracleSQLElementSpec.ISQLExternalNameClause getExternalClause() {
        return externalClause;
    }

    public void setExternalClause(OracleSQLElementSpec.ISQLExternalNameClause externalClause) {
        setChildParent(externalClause);
        this.externalClause = externalClause;
    }

    public List<SQLExpr> getProperties() {
        return properties;
    }

    public void addProperty(SQLExpr property) {
        if (property == null) {
            return;
        }
        setChildParent(property);
        this.properties.add(property);
    }

}
