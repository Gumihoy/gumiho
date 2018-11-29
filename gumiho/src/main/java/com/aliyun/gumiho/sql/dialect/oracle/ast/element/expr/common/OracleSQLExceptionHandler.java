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

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLBody;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * WHEN { exception [ OR exception ]... | OTHERS }
 * THEN statement [ statement ]...
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/lnpls/exception-handler.html#GUID-3FECF29B-A240-4191-A635-92C612D00C4D
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/exception-handler.html#GUID-3FECF29B-A240-4191-A635-92C612D00C4D
 *
 * @author kongtong.ouyang onCondition 2018/3/22.
 */
public class OracleSQLExceptionHandler extends AbstractOracleSQLExpr {

    private final List<SQLName> exceptions = new ArrayList<>();

    private final List<SQLBody.SQLBodyItem> bodyItems = new ArrayList<>();


    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, exceptions);
            this.acceptChild(visitor, bodyItems);
        }
    }

    public List<SQLName> getExceptions() {
        return exceptions;
    }

    public void addException(SQLName exception) {
        if (exception == null) {
            return;
        }
        setChildParent(exception);
        this.exceptions.add(exception);
    }

    public List<SQLBody.SQLBodyItem> getBodyItems() {
        return bodyItems;
    }

    public void addBodyItem(SQLBody.SQLBodyItem bodyItem) {
        if (bodyItem == null) {
            return;
        }
        setChildParent(bodyItem);
        this.bodyItems.add(bodyItem);
    }
}
