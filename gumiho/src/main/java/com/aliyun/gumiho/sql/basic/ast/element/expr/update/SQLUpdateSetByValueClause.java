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
package com.aliyun.gumiho.sql.basic.ast.element.expr.update;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * VALUE (t_alias) = { expr | (subquery) }
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/UPDATE.html#GUID-027A462D-379D-4E35-8611-410F3AC8FDA5
 *
 * @author kongtong.ouyang onCondition 2018/2/8.
 */
public class SQLUpdateSetByValueClause extends AbstractSQLExpr implements ISQLUpdateSetClause {

    protected SQLExpr column;
    protected SQLExpr value;

    public SQLUpdateSetByValueClause() {
    }

    public SQLUpdateSetByValueClause(SQLExpr column, SQLExpr value) {
        setColumn(column);
        setValue(value);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, column);
            this.acceptChild(visitor, value);
        }
    }

    @Override
    public SQLUpdateSetByValueClause clone() {
        SQLUpdateSetByValueClause x = new SQLUpdateSetByValueClause();
        this.cloneTo(x);
        return x;
    }


    public void cloneTo(SQLUpdateSetByValueClause x) {
        super.cloneTo(x);
    }

    public SQLExpr getColumn() {
        return column;
    }

    public void setColumn(SQLExpr column) {
        setChildParent(column);
        this.column = column;
    }

    public SQLExpr getValue() {
        return value;
    }

    public void setValue(SQLExpr value) {
        setChildParent(value);
        this.value = value;
    }
}
