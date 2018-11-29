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
package com.aliyun.gumiho.sql.basic.ast.element.expr.table.element;

import com.aliyun.gumiho.sql.basic.ast.SQLObject;
import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.constraint.AbstractSQLConstraint;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.constraint.column.SQLReferencesColumnConstraint;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.enums.ISQLEnum;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReferentialAction;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.hash.FNVHash;

import java.util.ArrayList;
import java.util.List;

/**
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#references%20specification
 * <p>
 * <p>
 * https://docs.oracle.com/cd/B28359_01/server.111/b28286/clauses002.htm#CJAFFBAA
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/constraint.html#GUID-1055EA97-BA6F-4764-A15F-1024FD5B6DFE
 *
 * @author kongtong.ouyang onCondition 2018/3/28.
 */
public abstract class AbstractSQLReferencesConstraint extends AbstractSQLConstraint implements SQLTableElement {

    protected SQLName referencedTable;

    protected final List<SQLColumn> referencedColumns = new ArrayList<>();

    protected MatchType matchType;

    protected final List<SQLReferentialTriggerAction> actions = new ArrayList<>();


    @Override
    public AbstractSQLReferencesConstraint clone() {
        throw new UnsupportedOperationException(getClass().getName());
    }

    @Override
    public void cloneTo(SQLObject x) {
        super.cloneTo(x);
    }

    public SQLName getReferencedTable() {
        return referencedTable;
    }

    public void setReferencedTable(SQLName referencedTable) {
        this.referencedTable = referencedTable;
    }

    public List<SQLColumn> getReferencedColumns() {
        return referencedColumns;
    }

    public void addReferencedColumn(SQLColumn referencedColumn) {
        if (referencedColumn == null) {
            return;
        }
        setChildParent(referencedColumn);
        this.referencedColumns.add(referencedColumn);
    }

    public void addReferencedColumn(SQLExpr expr) {
        if (expr == null) {
            return;
        }
        SQLColumn referencedColumn;
        if (expr instanceof SQLColumn) {
            referencedColumn = (SQLColumn) expr;
        } else {
            referencedColumn = SQLColumn.of(expr);
        }
        setChildParent(referencedColumn);
        this.referencedColumns.add(referencedColumn);
    }

    public MatchType getMatchType() {
        return matchType;
    }

    public void setMatchType(MatchType matchType) {
        this.matchType = matchType;
    }

    public List<SQLReferentialTriggerAction> getActions() {
        return actions;
    }

    public void addAction(SQLReferentialTriggerAction action) {
        if (action == null) {
            return;
        }
        setChildParent(action);
        this.actions.add(action);
    }

    /**
     * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#match%20type
     */
    public enum MatchType implements ISQLEnum {
        FULL(SQLReserved.FULL),
        PARTIAL(SQLReserved.PARTIAL),
        SIMPLE(SQLReserved.SIMPLE);

        public final SQLReserved name;

        MatchType(SQLReserved name) {
            this.name = name;
        }

        public static final MatchType of(String name) {
            long lowerHashCode64 = FNVHash.fnv1a_64_lower(name);
            for (MatchType matchType : MatchType.values()) {
                if (matchType.name.lowerHashCode64 == lowerHashCode64) {
                    return matchType;
                }
            }
            return null;
        }

        @Override
        public SQLReserved getName() {
            return name;
        }

        @Override
        public String toString() {
            return name.upper;
        }
    }

    /**
     * ON UPDATE <referential action>
     * ON DELETE <referential action>
     * <referential triggered action>
     * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#referential%20triggered%20action
     */
    public interface SQLReferentialTriggerAction extends SQLExpr {
        @Override
        SQLReferentialTriggerAction clone();
    }

    static abstract class AbstractSQLReferentialTriggerAction extends AbstractSQLExpr implements SQLReferentialTriggerAction {

        protected SQLReferentialAction action;

        @Override
        public AbstractSQLReferentialTriggerAction clone() {
            throw new UnsupportedOperationException(getClass().getName());
        }

        public void cloneTo(AbstractSQLReferentialTriggerAction x) {
            super.cloneTo(x);
            x.action = this.action;
        }

        public SQLReferentialAction getAction() {
            return action;
        }

        public void setAction(SQLReferentialAction action) {
            this.action = action;
        }
    }

    /**
     * ON UPDATE <referential action>
     */
    public static class SQLOnUpdateAction extends AbstractSQLReferentialTriggerAction {
        @Override
        protected void accept0(SQLASTVisitor visitor) {
            visitor.visit(this);
        }

        @Override
        public SQLOnUpdateAction clone() {
            SQLOnUpdateAction x = new SQLOnUpdateAction();
            this.cloneTo(x);
            return x;
        }
    }

    /**
     * ON DELETE <referential action>
     */
    public static class SQLOnDeleteAction extends AbstractSQLReferentialTriggerAction {
        @Override
        protected void accept0(SQLASTVisitor visitor) {
            visitor.visit(this);
        }

        @Override
        public SQLOnDeleteAction clone() {
            SQLOnDeleteAction x = new SQLOnDeleteAction();
            this.cloneTo(x);
            return x;
        }
    }
}
