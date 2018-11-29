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
import com.aliyun.gumiho.sql.util.SQLUtils;

/**
 * [DEFAULT] name [=] value
 *
 * @author kongtong.ouyang onCondition 2018/3/27.
 */
public class SQLSetOptionExpr extends AbstractSQLExpr {

    protected boolean default_ = false;

    protected SQLExpr name;

    protected boolean equalSign = false;

    protected SQLExpr value;


    public SQLSetOptionExpr() {
    }

    public SQLSetOptionExpr(SQLExpr name) {
        setName(name);
    }

    public SQLSetOptionExpr(SQLExpr name, SQLExpr value) {
        setName(name);
        setValue(value);
    }

    public SQLSetOptionExpr(SQLExpr name, boolean equalSign, SQLExpr value) {
        setName(name);
        setEqualSign(equalSign);
        setValue(value);
    }

    public SQLSetOptionExpr(boolean default_, SQLExpr name, boolean equalSign, SQLExpr value) {
        setDefault_(default_);
        setName(name);
        setEqualSign(equalSign);
        setValue(value);
    }

    public static SQLSetOptionExpr of(SQLExpr name, SQLExpr value) {
        return new SQLSetOptionExpr(name, value);
    }

    public static SQLSetOptionExpr of(SQLExpr name, boolean equalSign, SQLExpr value) {
        return new SQLSetOptionExpr(name, equalSign, value);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
            this.acceptChild(visitor, value);
        }
    }

    @Override
    public SQLSetOptionExpr clone() {
        SQLSetOptionExpr x = new SQLSetOptionExpr();
        this.cloneTo(x);
        return x;
    }


    public void cloneTo(SQLSetOptionExpr x) {
        super.cloneTo(x);

        x.default_ = this.default_;
        x.equalSign = this.equalSign;

        SQLExpr nameClone = this.name.clone();
        SQLExpr valueClone = this.value.clone();
        x.setName(nameClone);
        x.setValue(valueClone);
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == name) {
            setName(target);
            return true;
        }
        if (source == value) {
            setValue(target);
            return true;
        }
        return false;
    }

    public boolean isDefault_() {
        return default_;
    }

    public void setDefault_(boolean default_) {
        this.default_ = default_;
    }

    public SQLExpr getName() {
        return name;
    }

    public void setName(SQLExpr name) {
        setChildParent(name);
        this.name = name;
    }

    public boolean isEqualSign() {
        return equalSign;
    }

    public void setEqualSign(boolean equalSign) {
        this.equalSign = equalSign;
    }

    public SQLExpr getValue() {
        return value;
    }

    public void setValue(SQLExpr value) {
        setChildParent(value);
        this.value = value;
        if (value == null) {
            SQLUtils.replaceInParent(this, null);
        }
    }
}
