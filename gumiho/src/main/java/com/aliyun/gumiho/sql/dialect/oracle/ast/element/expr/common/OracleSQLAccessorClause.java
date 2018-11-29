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

import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;
import com.aliyun.gumiho.sql.hash.FNVHash;

/**
 * accessor
 * <p>
 * https://docs.oracle.com/database/121/LNPLS/create_function.htm#GUID-B71BC5BD-B87C-4054-AAA5-213E856651F2__CIHFDACE
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/lnpls/ACCESSIBLE-BY-clause.html#GUID-9720619C-9862-4123-96E7-3E85F240FF36
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/ACCESSIBLE-BY-clause.html#GUID-9720619C-9862-4123-96E7-3E85F240FF36
 *
 * @author kongtong.ouyang onCondition 2018/3/18.
 */
public class OracleSQLAccessorClause extends AbstractOracleSQLExpr {

    private SQLUnitKind unitKind;

    private SQLName name;

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
        }
    }


    public enum SQLUnitKind {
        FUNCTION(SQLReserved.FUNCTION),
        PACKAGE(SQLReserved.PACKAGE),
        PROCEDURE(SQLReserved.PROCEDURE),
        TYPE(SQLReserved.TYPE),
        TRIGGER(SQLReserved.TRIGGER);

        public final SQLReserved name;

        SQLUnitKind(SQLReserved name) {
            this.name = name;
        }

        public static SQLUnitKind of(String unitKind) {
            long lowerHashCode64 = FNVHash.fnv1a_64_lower(unitKind);
            SQLUnitKind[] unitKinds = SQLUnitKind.values();
            for (SQLUnitKind kind : unitKinds) {
                if (kind.name.lowerHashCode64 == lowerHashCode64) {
                    return kind;
                }
            }
            return null;
        }

    }

    public SQLUnitKind getUnitKind() {
        return unitKind;
    }

    public void setUnitKind(SQLUnitKind unitKind) {
        this.unitKind = unitKind;
    }

    public SQLName getName() {
        return name;
    }

    public void setName(SQLName name) {
        setChildParent(name);
        this.name = name;
    }
}
