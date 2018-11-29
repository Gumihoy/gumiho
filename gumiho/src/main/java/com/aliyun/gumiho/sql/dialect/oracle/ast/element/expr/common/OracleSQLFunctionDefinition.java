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
import com.aliyun.gumiho.sql.basic.ast.enums.SQLASType;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * function_heading [ DETERMINISTIC | PIPELINED | PARALLEL_ENABLE | RESULT_CACHE [ relies_on_clause ] ]...
 * { IS | AS }
 * { [ declare_section ] body | call_spec }
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/lnpls/function-declaration-and-definition.html#GUID-4E19FB09-46B5-4CE5-8A5B-CD815C29DA1C
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/function-declaration-and-definition.html#GUID-4E19FB09-46B5-4CE5-8A5B-CD815C29DA1C
 *
 * @author kongtong.ouyang onCondition 2018/3/22.
 */
public class OracleSQLFunctionDefinition extends OracleSQLFunctionHeading {

    private final List<SQLExpr> properties = new ArrayList<>();

    private SQLASType as = SQLASType.AS;

    protected final List<SQLExpr> declareSections = new ArrayList<>();

    private SQLExpr asExpr;


    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
            this.acceptChild(visitor, parameters);
            this.acceptChild(visitor, returnDataType);
            this.acceptChild(visitor, properties);
            this.acceptChild(visitor, declareSections);
            this.acceptChild(visitor, asExpr);
        }
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

    public void addAllDeclareSection(List<SQLExpr> declareSections) {
        if (declareSections == null
                || declareSections.size() == 0) {
            return;
        }
        for (SQLExpr declareSection : declareSections) {
            setChildParent(declareSection);
        }
        this.declareSections.addAll(declareSections);
    }

    public SQLExpr getAsExpr() {
        return asExpr;
    }

    public void setAsExpr(SQLExpr asExpr) {
        setChildParent(asExpr);
        this.asExpr = asExpr;
    }
}
