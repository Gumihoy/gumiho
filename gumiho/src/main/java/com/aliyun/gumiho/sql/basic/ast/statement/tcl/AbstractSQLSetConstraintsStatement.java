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
package com.aliyun.gumiho.sql.basic.ast.statement.tcl;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.enums.DBType;

import java.util.ArrayList;
import java.util.List;

/**
 * SET { CONSTRAINT | CONSTRAINTS } { constraint [, constraint ]... | ALL } { IMMEDIATE | DEFERRED } ;
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/SET-CONSTRAINTS.html#GUID-1EF5B212-17C5-4F7C-9412-D777DFDEDCE9
 *
 * @author kongtong.ouyang onCondition 2018/6/29.
 */
public abstract class AbstractSQLSetConstraintsStatement extends AbstractSQLStatement implements ISQLSetConstraintsStatement {

    protected final List<SQLExpr> items = new ArrayList<>();
    protected SQLOption option;

    public AbstractSQLSetConstraintsStatement(DBType dbType) {
        super(dbType);
    }


    @Override
    public AbstractSQLSetConstraintsStatement clone() {
        throw new UnsupportedOperationException(getClass().getName());
    }

    public void cloneTo(AbstractSQLSetConstraintsStatement x) {
        super.cloneTo(x);

        for (SQLExpr item : this.items) {
            SQLExpr itemClone = item.clone();
            x.setChildParent(itemClone);
        }

        x.option = this.option;
    }


    public List<SQLExpr> getItems() {
        return items;
    }

    public void addItem(SQLExpr item) {
        if (item == null) {
            return;
        }
        setChildParent(item);
        this.items.add(item);
    }

    public SQLOption getOption() {
        return option;
    }

    public void setOption(SQLOption option) {
        this.option = option;
    }

}
