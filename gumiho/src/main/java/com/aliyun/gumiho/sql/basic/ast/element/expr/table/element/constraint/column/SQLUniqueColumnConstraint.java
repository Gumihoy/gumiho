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
package com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.constraint.column;

import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.constraint.AbstractSQLConstraint;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * [ CONSTRAINT <constraint name>] UNIQUE [<constraint options>]
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#column%20constraint%20definition
 * <p>
 * UNIQUE [KEY]
 * https://dev.mysql.com/doc/refman/5.6/en/create-table.html
 * <p>
 * <p>
 * [ CONSTRAINT constraint_name ] UNIQUE [ constraint_state ]
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/constraint.html
 *
 * @author kongtong.ouyang onCondition 2018/3/13.
 */
public class SQLUniqueColumnConstraint extends AbstractSQLConstraint implements ISQLUniqueColumnConstraint {

    protected boolean key = false;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
            this.acceptChild(visitor, options);
        }
    }

    @Override
    public SQLUniqueColumnConstraint clone() {
        SQLUniqueColumnConstraint x = new SQLUniqueColumnConstraint();
        this.cloneTo(x);
        x.key = this.key;
        return x;
    }


    public boolean isKey() {
        return key;
    }

    public void setKey(boolean key) {
        this.key = key;
    }
}
