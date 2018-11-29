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
package com.aliyun.gumiho.sql.basic.ast.element.expr.table;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.enums.ISQLEnum;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * OBJECT IDENTIFIER IS { SYSTEM GENERATED | PRIMARY KEY }
 * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/sqlrf/CREATE-TABLE.html#GUID-F9CE0CC3-13AE-4744-A43C-EAC7A71AAAB6
 *
 * @author kongtong.ouyang onCondition 2018/3/25.
 */
public class SQLOidClause extends AbstractSQLExpr {

    private SQLType type;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }


    public SQLType getType() {
        return type;
    }

    public void setType(SQLType type) {
        this.type = type;
    }

    public enum SQLType implements ISQLEnum {

        SYSTEM_GENERATED(SQLReserved.SYSTEM_GENERATED),
        PRIMARY_KEY(SQLReserved.PRIMARY_KEY);

        public final SQLReserved name;

        SQLType(SQLReserved name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name.upper;
        }


        @Override
        public SQLReserved getName() {
            return name;
        }
    }
}
