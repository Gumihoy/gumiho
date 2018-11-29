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

import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * accessible_by_clause
 * <p>
 * https://docs.oracle.com/database/121/LNPLS/create_function.htm#GUID-B71BC5BD-B87C-4054-AAA5-213E856651F2__CIHFDACE
 * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/lnpls/ACCESSIBLE-BY-clause.html
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/ACCESSIBLE-BY-clause.html#GUID-9720619C-9862-4123-96E7-3E85F240FF36
 *
 * @author kongtong.ouyang onCondition 2018/3/20.
 */
public class OracleSQLAccessibleByClause extends AbstractOracleSQLExpr {

    private final List<OracleSQLAccessorClause> accessorClauses = new ArrayList<>();

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, accessorClauses);
        }
    }


    public List<OracleSQLAccessorClause> getAccessorClauses() {
        return accessorClauses;
    }

    public void addAccessorClause(OracleSQLAccessorClause accessorClause) {
        if (accessorClause == null) {
            return;
        }
        setChildParent(accessorClause);
        this.accessorClauses.add(accessorClause);
    }
}
