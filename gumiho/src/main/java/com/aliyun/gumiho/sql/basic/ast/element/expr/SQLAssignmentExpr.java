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
package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * column = value
 * <p>
 * https://dev.mysql.com/doc/refman/8.0/en/insert.html
 *
 * @author kongtong.ouyang onCondition 2018/3/22.
 */
public class SQLAssignmentExpr extends AbstractSQLExpr {

    private SQLExpr column;

    private SQLExpr value;

    public SQLAssignmentExpr() {
    }

    public SQLAssignmentExpr(SQLExpr column, SQLExpr value) {
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
    public SQLAssignmentExpr clone() {
        SQLExpr columnClone = this.column.clone();
        SQLExpr valueClone = this.value.clone();

        SQLAssignmentExpr x = new SQLAssignmentExpr(columnClone, valueClone);
        super.clone();
        return x;
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == column) {
            setColumn(target);
            return true;
        }
        if (source == value) {
            setValue(target);
            return true;
        }
        return false;
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
