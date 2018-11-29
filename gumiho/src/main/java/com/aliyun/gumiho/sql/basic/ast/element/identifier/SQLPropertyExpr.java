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
package com.aliyun.gumiho.sql.basic.ast.element.identifier;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.util.SQLUtils;

/**
 * owner.name
 *
 * @author kongtong.ouyang onCondition 2018/3/16.
 */
public class SQLPropertyExpr extends AbstractSQLName {

    protected SQLExpr owner;

    public SQLPropertyExpr(String owner, String name) {
        super(name);
        if (owner == null) {
            throw new IllegalArgumentException("owner is null.");
        }
        setOwner(SQLUtils.ofName(owner));
    }

    public SQLPropertyExpr(String owner, SQLName name) {
        super(name);
        if (owner == null) {
            throw new IllegalArgumentException("owner is null.");
        }
        setOwner(SQLUtils.ofName(owner));
    }

    public SQLPropertyExpr(SQLExpr owner, SQLName name) {
        super(name);
        if (owner == null) {
            throw new IllegalArgumentException("owner is null");
        }
        setOwner(owner);
    }

    public static SQLPropertyExpr of(String owner, String name) {
        return new SQLPropertyExpr(owner, name);
    }

    public static SQLPropertyExpr of(String owner, SQLName name) {
        return new SQLPropertyExpr(owner, name);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, owner);
            this.acceptChild(visitor, nameExpr);
        }
    }

    @Override
    public SQLPropertyExpr clone() {

        SQLExpr ownerClone = this.owner.clone();
        SQLName nameClone = this.nameExpr.clone();

        return new SQLPropertyExpr(ownerClone, nameClone);
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == owner) {
            this.setOwner(target);
            return true;
        }

        if (source == nameExpr) {
            this.setName((SQLName) target);
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SQLPropertyExpr that = (SQLPropertyExpr) o;

        if (owner != null ? !owner.equals(that.owner) : that.owner != null) {
            return false;
        }
        return nameExpr != null ? nameExpr.equals(that.nameExpr) : that.nameExpr == null;
    }

    @Override
    public int hashCode() {
        int result = owner != null ? owner.hashCode() : 0;
        result = 31 * result + (nameExpr != null ? nameExpr.hashCode() : 0);
        return result;
    }

    public SQLExpr getOwner() {
        return owner;
    }

    public void setOwner(SQLExpr owner) {
        setChildParent(owner);
        this.owner = owner;
    }

    public void setOwner(String owner) {
        setOwner(SQLUtils.ofName(owner));
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getFullName() {
        if (fullName == null
                && this.owner instanceof SQLName) {
            fullName = ((SQLName) this.owner).getFullName() + "." + this.nameExpr.getFullName();
        }
        return fullName;
    }
}
