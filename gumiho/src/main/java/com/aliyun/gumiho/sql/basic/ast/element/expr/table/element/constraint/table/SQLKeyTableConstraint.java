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
package com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.constraint.table;

import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#unique%20constraint%20definition
 * <p>
 * <p>
 * <p>
 * [ CONSTRAINT constraint_name ] UNIQUE (column [, column ]...) [ constraint_state ]
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/constraint.html#GUID-1055EA97-BA6F-4764-A15F-1024FD5B6DFE
 *
 * @author kongtong.ouyang onCondition 2018/3/13.
 */
public class SQLKeyTableConstraint extends AbstractSQLIndexTableConstraint implements ISQLTableConstraint {

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
            this.acceptChild(visitor, columns);
            this.acceptChild(visitor, options);
        }
    }

    @Override
    public SQLKeyTableConstraint clone() {
        SQLKeyTableConstraint x = new SQLKeyTableConstraint();
        this.cloneTo(x);
        return x;
    }


}
