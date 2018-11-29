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
package com.aliyun.gumiho.sql.basic.ast.element.expr.select.order;

import com.aliyun.gumiho.sql.basic.ast.enums.SQLNullOrderingType;
import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.util.SQLUtils;

/**
 * sortKey (orderingSpecification) (nullOrdering)
 *
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#sort%20specification
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/sqlrf/SELECT.html#GUID-CFA006CA-6FF1-4972-821E-6996142A51C6
 *
 * @author kongtong.ouyang onCondition 2018/2/8.
 */
public class SQLOrderByItem extends AbstractSQLExpr {

    private SQLExpr sortKey;

    private SQLExpr orderingSpecification;

    private SQLNullOrderingType nullOrdering;

    public SQLOrderByItem(String sortKey) {
        if (sortKey == null) {
            throw new IllegalArgumentException("sortKey is null.");
        }
        setSortKey(SQLUtils.ofName(sortKey));
    }

    public SQLOrderByItem(SQLExpr sortKey) {
        setSortKey(sortKey);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, sortKey);
        }
    }

    @Override
    public SQLOrderByItem clone() {
        SQLExpr sortKeyClone = this.sortKey.clone();
        SQLOrderByItem x = new SQLOrderByItem(sortKeyClone);

        if (this.orderingSpecification != null) {
            SQLExpr orderingSpecificationClone = this.orderingSpecification.clone();
            x.setOrderingSpecification(orderingSpecificationClone);
        }

        x.nullOrdering = this.nullOrdering;

        return x;
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == sortKey) {
            this.setSortKey(target);
            return true;
        }
        if (source == orderingSpecification) {
            this.setOrderingSpecification(target);
            return true;
        }
        return false;
    }

    public SQLExpr getSortKey() {
        return sortKey;
    }

    public void setSortKey(SQLExpr sortKey) {
        setChildParent(sortKey);
        this.sortKey = sortKey;
    }

    public SQLExpr getOrderingSpecification() {
        return orderingSpecification;
    }

    public void setOrderingSpecification(SQLExpr orderingSpecification) {
        setChildParent(orderingSpecification);
        this.orderingSpecification = orderingSpecification;
    }

    public SQLNullOrderingType getNullOrdering() {
        return nullOrdering;
    }

    public void setNullOrdering(SQLNullOrderingType nullOrdering) {
        this.nullOrdering = nullOrdering;
    }

}
