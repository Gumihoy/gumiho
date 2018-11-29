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
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;
import com.aliyun.gumiho.sql.hash.FNVHash;

/**
 * integer [ K | M | G | T | P | E ]
 * <p>
 * size_clause
 * <p>
 * https://docs.oracle.com/database/121/SQLRF/clauses008.htm#SQLRF30012
 *
 * @author kongtong.ouyang onCondition 2018/3/16.
 */
public class OracleSQLSizeClause extends AbstractOracleSQLExpr {

    protected SQLExpr value;
    protected Type type;


    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, value);
        }
    }

    @Override
    public OracleSQLSizeClause clone() {
        OracleSQLSizeClause x = new OracleSQLSizeClause();
        return x;
    }


    public SQLExpr getValue() {
        return value;
    }

    public void setValue(SQLExpr value) {
        setChildParent(value);
        this.value = value;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public enum Type {
        /**
         * KiloBytes
         */
        K(SQLReserved.K),
        /**
         * MegaBytes
         */
        M(SQLReserved.M),

        // GigaBytes
        G(SQLReserved.G),

        // TeraBytes
        T(SQLReserved.T),
        // PetaBytes
        P(SQLReserved.P),
        // ExaBytes
        E(SQLReserved.E);

        public final SQLReserved name;

        Type(SQLReserved name) {
            this.name = name;
        }

        public static Type of(String name) {
            long lowerHashCode64 = FNVHash.fnv1a_64_lower(name);
            for (Type type : Type.values()) {
                if (type.name.lowerHashCode64 == lowerHashCode64) {
                    return type;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return name.upper;
        }
    }
}
