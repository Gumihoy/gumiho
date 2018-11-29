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
package com.aliyun.gumiho.sql.basic.ast.element.expr.select;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.clause.SQLFromClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.clause.SQLHierarchicalQueryClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.clause.SQLWhereClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.clause.SQLWindowClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.group.SQLGroupByClause;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLSetQuantifier;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.util.SQLUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#query%20specification
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/SELECT.html#GUID-CFA006CA-6FF1-4972-821E-6996142A51C6
 *
 * @author kongtong.ouyang onCondition 2018/3/20.
 */
public class SQLSelectQuery extends AbstractSQLSelectQuery implements ISQLSelectQuery {

    protected ISQLWithClause withClause;

    protected SQLSetQuantifier setQuantifier;

    protected final List<SQLSelectItem> selectItems = new ArrayList<>();

    protected SQLFromClause fromClause;

    protected SQLWhereClause whereClause;

    protected SQLHierarchicalQueryClause hierarchicalQueryClause;

    protected SQLGroupByClause groupByClause;

    protected SQLWindowClause windowClause;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, withClause);
            this.acceptChild(visitor, selectItems);
            this.acceptChild(visitor, fromClause);
            this.acceptChild(visitor, whereClause);
            this.acceptChild(visitor, windowClause);

            this.acceptChild(visitor, orderByClause);
            this.acceptChild(visitor, limitClause);
            this.acceptChild(visitor, lockClause);
        }
    }

    @Override
    public SQLSelectQuery clone() {
        SQLSelectQuery x = new SQLSelectQuery();
        this.cloneTo(x);
        return x;
    }


    public void cloneTo(SQLSelectQuery x) {
        super.cloneTo(x);

        if (this.withClause != null) {
            ISQLWithClause withClauseClone = this.withClause.clone();
            x.setWithClause(withClauseClone);
        }

        x.setQuantifier = this.setQuantifier;

        for (SQLSelectItem selectItem : this.selectItems) {
            SQLSelectItem selectItemClone = selectItem.clone();
            x.addSelectItem(selectItemClone);
        }

        if (this.fromClause != null) {
            SQLFromClause fromClauseClone = this.fromClause.clone();
            x.setFromClause(fromClauseClone);
        }

        if (this.whereClause != null) {
            SQLWhereClause whereClauseClone = this.whereClause.clone();
            x.setWhereClause(whereClauseClone);
        }

        if (this.hierarchicalQueryClause != null) {
            SQLHierarchicalQueryClause hierarchicalQueryClauseClone = this.hierarchicalQueryClause.clone();
            x.setHierarchicalQueryClause(hierarchicalQueryClauseClone);
        }

        if (this.groupByClause != null) {
            SQLGroupByClause groupByClauseClone = this.groupByClause.clone();
            x.setGroupByClause(groupByClauseClone);
        }

        if (this.windowClause != null) {
            SQLWindowClause windowClauseClone = this.windowClause.clone();
            x.setWindowClause(windowClauseClone);
        }

    }


    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (target == null) {

            if (source == withClause) {
                setWithClause(null);
                return true;
            }

            boolean replace = replaceInList(selectItems, source, null, this);
            if (replace) {
                return true;
            }

            if (source == fromClause) {
                setFromClause(null);
                return true;
            }

            if (source == whereClause) {
                setWhereClause(null);
                return true;
            }

            if (source == hierarchicalQueryClause) {
                setHierarchicalQueryClause(null);
                return true;
            }

            if (source == groupByClause) {
                setGroupByClause(null);
                return true;
            }

            if (source == windowClause) {
                setWindowClause(null);
                return true;
            }

            return false;
        }
        return false;
    }



    public SQLSelectItem findSelectItem(String name) {
        if (name == null) {
            return null;
        }
        return findSelectItem(SQLUtils.ofName(name));
    }

    public SQLSelectItem findSelectItem(long hash) {
        for (SQLSelectItem item : this.selectItems) {
            if (item.match(hash)) {
                return item;
            }
        }
        return null;
    }

    public SQLSelectItem findSelectItem(SQLExpr expr) {
        if (expr == null) {
            return null;
        }
        for (SQLSelectItem item : this.selectItems) {
            if (item.match(expr)) {
                return item;
            }
        }
        return null;
    }


    public ISQLWithClause getWithClause() {
        return withClause;
    }

    public void setWithClause(ISQLWithClause withClause) {
        setChildParent(withClause);
        this.withClause = withClause;
    }

    public SQLSetQuantifier getSetQuantifier() {
        return setQuantifier;
    }

    public void setSetQuantifier(SQLSetQuantifier setQuantifier) {
        this.setQuantifier = setQuantifier;
    }

    public List<SQLSelectItem> getSelectItems() {
        return selectItems;
    }

    public void addSelectItem(SQLSelectItem selectItem) {
        if (selectItem == null) {
            return;
        }
        setChildParent(selectItem);
        this.selectItems.add(selectItem);
    }

    public SQLFromClause getFromClause() {
        return fromClause;
    }

    public void setFromClause(SQLFromClause fromClause) {
        setChildParent(fromClause);
        this.fromClause = fromClause;
    }

    public SQLWhereClause getWhereClause() {
        return whereClause;
    }

    public void setWhereClause(SQLWhereClause whereClause) {
        setChildParent(whereClause);
        this.whereClause = whereClause;
    }

    public void setWhereCondition(SQLExpr condition) {
        if (condition == null) {
            return;
        }
        SQLWhereClause whereClause = SQLWhereClause.of(condition);
        setChildParent(whereClause);
        this.whereClause = whereClause;
    }

    public void andWhereCondition(SQLExpr condition) {
        if (condition == null) {
            return;
        }
        if (this.whereClause == null) {
            setWhereCondition(condition);
            return;
        }

        this.whereClause.andCondition(condition);
    }

    public void orWhereCondition(SQLExpr condition) {
        if (condition == null) {
            return;
        }
        if (this.whereClause == null) {
            setWhereCondition(condition);
            return;
        }
        this.whereClause.orCondition(condition);
    }

    public SQLHierarchicalQueryClause getHierarchicalQueryClause() {
        return hierarchicalQueryClause;
    }

    public void setHierarchicalQueryClause(SQLHierarchicalQueryClause hierarchicalQueryClause) {
        setChildParent(hierarchicalQueryClause);
        this.hierarchicalQueryClause = hierarchicalQueryClause;
    }


    public SQLGroupByClause getGroupByClause() {
        return groupByClause;
    }

    public void setGroupByClause(SQLGroupByClause groupByClause) {
        setChildParent(groupByClause);
        this.groupByClause = groupByClause;
    }

    public SQLWindowClause getWindowClause() {
        return windowClause;
    }

    public void setWindowClause(SQLWindowClause windowClause) {
        setChildParent(windowClause);
        this.windowClause = windowClause;
    }


}
