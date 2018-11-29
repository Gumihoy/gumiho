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
 * [CONSTRAINT <constraint name>] PRIMARY KEY [<constraint options>]
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#column%20constraint
 * <p>
 * [PRIMARY] KEY
 * https://dev.mysql.com/doc/refman/5.6/en/create-table.html
 *
 * @author kongtong.ouyang onCondition 2018/3/13.
 */
public class SQLPrimaryKeyColumnConstraint extends AbstractSQLConstraint implements ISQLPrimaryKeyColumnConstraint {

    protected boolean primary = true;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
            this.acceptChild(visitor, options);
        }
    }

    @Override
    public SQLPrimaryKeyColumnConstraint clone() {
        SQLPrimaryKeyColumnConstraint x = new SQLPrimaryKeyColumnConstraint();
        this.cloneTo(x);
        x.primary = this.primary;
        return x;
    }

    public boolean isPrimary() {
        return primary;
    }

    public void setPrimary(boolean primary) {
        this.primary = primary;
    }
}
