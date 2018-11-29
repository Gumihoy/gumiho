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

import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.util.SQLUtils;

/**
 * mysql  触发器
 *
 * OLD.name old.name
 *
 * @author kongtong.ouyang onCondition 2018/3/22.
 */
public class SQLOldVariableRefExpr extends AbstractSQLExpr {

    protected SQLName name;

    public SQLOldVariableRefExpr() {
    }

    public SQLOldVariableRefExpr(String name) {
        setName(SQLUtils.ofName(name));
    }

    public SQLOldVariableRefExpr(SQLName name) {
        setName(name);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
        }
    }

    @Override
    public SQLOldVariableRefExpr clone() {
        SQLOldVariableRefExpr x = new SQLOldVariableRefExpr();
        this.cloneTo(x);
        return x;
    }

    public void cloneTo(SQLOldVariableRefExpr x) {
        super.cloneTo(x);
        SQLName nameClone = this.name.clone();
        x.setName(nameClone);
    }


    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == name
                && target instanceof SQLName) {
            setName((SQLName) target);
            return true;
        }
        return false;
    }


    public SQLName getName() {
        return name;
    }

    public void setName(SQLName name) {
        setChildParent(name);
        this.name = name;
    }
}
