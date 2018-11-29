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
package com.aliyun.gumiho.sql.basic.ast.statement.ddl.trigger;


import com.aliyun.gumiho.sql.basic.ast.SQLObject;
import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLCollationExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLDefinerOptionExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.trigger.SQLTriggerEvent;
import com.aliyun.gumiho.sql.basic.ast.element.expr.trigger.SQLTriggerOrderingClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.trigger.SQLTriggerReferencingOption;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.enums.ISQLEnum;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLEditionAbleType;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLEnableType;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.SQLCreateStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.SQLObjectType;
import com.aliyun.gumiho.sql.util.SQLUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * create trigger action event (or evnent) referencingOptions?  on nestedTableClauseExpr? onExpr
 * orderingClause? enableType?  (WHEN whenCondition) triggerBody
 * <p>
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#trigger%20definition
 * <p>
 * CREATE [DEFINER = { user | CURRENT_USER }] TRIGGER trigger_name trigger_time trigger_event ON tbl_name FOR EACH ROW [trigger_order] trigger_body
 * trigger_time: { BEFORE | AFTER }
 * trigger_event: { INSERT | UPDATE | DELETE }
 * trigger_order: { FOLLOWS | PRECEDES } other_trigger_name
 * https://dev.mysql.com/doc/refman/8.0/en/create-trigger.html
 * <p>
 * https://www.postgresql.org/docs/10/static/sql-createtrigger.html
 * <p>
 * <p>
 * CREATE orReplace? editionableType? TRIGGER triggerName=nameIdentifier collationExpr?
 * createTriggerActionTime (createTriggerEvent (OR createTriggerEvent)*)  (ON (NESTED TABLE nestedTable=nameIdentifier OF)? createTriggerOnExpr)?
 * (REFERENCING referencingOption+)? forEachRow? triggerEditionClause? triggerOrderingClause? (ENABLE | DISABLE)? (WHEN LEFT_PAREN whenCondition=expr RIGHT_PAREN)? triggerBody
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/CREATE-TRIGGER-statement.html
 *
 * @author kongtong.ouyang onCondition 2018/1/23.
 */
public class SQLCreateTriggerStatement extends AbstractSQLStatement implements SQLCreateStatement {

    protected boolean orReplace;

    protected SQLEditionAbleType editionAbleType;

    protected SQLDefinerOptionExpr definerExpr;

    protected SQLName name;

    protected SQLCollationExpr collationExpr;

    protected SQLTriggerActionTime actionTime;

    protected final List<SQLTriggerEvent> events = new ArrayList<>();


    protected SQLExpr nestedTableColumn;

    protected SQLExpr onExpr;


    protected final List<SQLTriggerReferencingOption> referencingOptions = new ArrayList<>();

    protected SQLTriggerForEachType forEachType;

    protected SQLTriggerEditionType editionType;

    protected SQLTriggerOrderingClause orderingClause;

    protected SQLEnableType enableType;

    protected SQLExpr whenCondition;

    protected SQLObject triggerBody;

    public SQLCreateTriggerStatement(DBType dbType) {
        super(dbType);
        if (dbType == DBType.MySQL) {
            setForEachType(SQLTriggerForEachType.FOR_EACH_ROW);
        }
    }

    public static SQLCreateTriggerStatement of(DBType dbType) {
        return new SQLCreateTriggerStatement(dbType);
    }


    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, definerExpr);
            this.acceptChild(visitor, name);
            this.acceptChild(visitor, collationExpr);
            this.acceptChild(visitor, events);
            this.acceptChild(visitor, nestedTableColumn);
            this.acceptChild(visitor, onExpr);
            this.acceptChild(visitor, referencingOptions);
            this.acceptChild(visitor, orderingClause);
            this.acceptChild(visitor, whenCondition);
            this.acceptChild(visitor, triggerBody);
        }

    }


    @Override
    public SQLCreateTriggerStatement clone() {

        SQLCreateTriggerStatement x = new SQLCreateTriggerStatement(this.dbType);
        this.cloneTo(x);
        return x;
    }


    public void cloneTo(SQLCreateTriggerStatement x) {
        super.cloneTo(x);

        x.orReplace = this.orReplace;
        x.editionAbleType = this.editionAbleType;

        if (this.definerExpr != null) {
            SQLDefinerOptionExpr definerExprClone = this.definerExpr.clone();
            x.setDefinerExpr(definerExprClone);
        }

        SQLName nameClone = this.name.clone();
        x.setName(nameClone);

        if (this.collationExpr != null) {
            SQLCollationExpr collationExprClone = this.collationExpr.clone();
            x.setCollationExpr(collationExprClone);
        }

        x.actionTime = this.actionTime;
        for (SQLTriggerEvent event : x.events) {
            SQLTriggerEvent eventClone = event.clone();
            x.addEvent(eventClone);
        }

        if (this.nestedTableColumn != null) {
            SQLExpr nestedTableColumnClone = this.nestedTableColumn.clone();
            x.setNestedTableColumn(nestedTableColumnClone);
        }

        SQLExpr onExprClone = this.onExpr.clone();
        x.setOnExpr(onExprClone);


        for (SQLTriggerReferencingOption referencingOption : this.referencingOptions) {
            SQLTriggerReferencingOption referencingOptionClone = referencingOption.clone();
            x.addReferencingOption(referencingOptionClone);
        }

        x.forEachType = this.forEachType;

        x.editionType = this.editionType;

        if (this.orderingClause != null) {
            SQLTriggerOrderingClause orderingClauseClone = this.orderingClause.clone();
            x.setOrderingClause(orderingClauseClone);
        }

        x.enableType = this.enableType;

        if (this.whenCondition != null) {
            SQLExpr whenConditionClone = this.whenCondition.clone();
            x.setWhenCondition(whenConditionClone);
        }

        if (this.triggerBody != null) {
            SQLObject triggerBodyClone = this.triggerBody.clone();
            x.setTriggerBody(triggerBodyClone);
        }

    }


    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == name
                && target instanceof SQLName) {
            this.setName((SQLName) target);
            return true;
        }

        if (source == nestedTableColumn) {
            this.setNestedTableColumn(target);
            return true;
        }

        if (source == onExpr) {
            this.setOnExpr(target);
            return true;
        }

        if (source == whenCondition) {
            this.setWhenCondition(target);
            return true;
        }
        return false;
    }


    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.CREATE_TRIGGER;
    }


    public boolean isOrReplace() {
        return orReplace;
    }

    public void setOrReplace(boolean orReplace) {
        this.orReplace = orReplace;
    }

    public SQLEditionAbleType getEditionAbleType() {
        return editionAbleType;
    }

    public void setEditionAbleType(SQLEditionAbleType editionAbleType) {
        this.editionAbleType = editionAbleType;
    }

    public SQLDefinerOptionExpr getDefinerExpr() {
        return definerExpr;
    }

    public SQLCreateTriggerStatement setDefinerExpr(SQLDefinerOptionExpr definerExpr) {
        setChildParent(definerExpr);
        this.definerExpr = definerExpr;
        return this;
    }

    public SQLName getName() {
        return name;
    }

    public void setName(SQLName name) {
        setChildParent(name);
        this.name = name;
    }

    public void setName(String name) {
        setName(SQLUtils.ofName(name));
    }

    public SQLCollationExpr getCollationExpr() {
        return collationExpr;
    }

    public void setCollationExpr(SQLCollationExpr collationExpr) {
        setChildParent(collationExpr);
        this.collationExpr = collationExpr;
    }

    public SQLTriggerActionTime getActionTime() {
        return actionTime;
    }

    public void setActionTime(SQLTriggerActionTime actionTime) {
        this.actionTime = actionTime;
    }

    public List<SQLTriggerEvent> getEvents() {
        return events;
    }

    public void addEvent(SQLTriggerEvent event) {
        if (event == null) {
            return;
        }
        setChildParent(event);
        if (!TRIGGER_EVENT.add(event.getEvent())) {
            return;
        }
        this.events.add(event);
    }

    public SQLExpr getNestedTableColumn() {
        return nestedTableColumn;
    }

    public void setNestedTableColumn(SQLExpr nestedTableColumn) {
        setChildParent(nestedTableColumn);
        this.nestedTableColumn = nestedTableColumn;
    }

    public SQLExpr getOnExpr() {
        return onExpr;
    }

    public void setOnExpr(SQLExpr onExpr) {
        setChildParent(onExpr);
        this.onExpr = onExpr;
    }
    public void setOnExpr(String name) {
        setOnExpr(SQLUtils.ofName(name));
    }

    public List<SQLTriggerReferencingOption> getReferencingOptions() {
        return referencingOptions;
    }

    public void addReferencingOption(SQLTriggerReferencingOption referencingOption) {
        if (referencingOption == null) {
            return;
        }
        setChildParent(referencingOption);
        this.referencingOptions.add(referencingOption);
    }

    public SQLTriggerForEachType getForEachType() {
        return forEachType;
    }

    public void setForEachType(SQLTriggerForEachType forEachType) {
        this.forEachType = forEachType;
    }

    public SQLTriggerEditionType getEditionType() {
        return editionType;
    }

    public void setEditionType(SQLTriggerEditionType editionType) {
        this.editionType = editionType;
    }

    public SQLTriggerOrderingClause getOrderingClause() {
        return orderingClause;
    }

    public void setOrderingClause(SQLTriggerOrderingClause orderingClause) {
        setChildParent(orderingClause);
        this.orderingClause = orderingClause;
    }

    public SQLEnableType getEnableType() {
        return enableType;
    }

    public void setEnableType(SQLEnableType enableType) {
        this.enableType = enableType;
    }

    public SQLExpr getWhenCondition() {
        return whenCondition;
    }

    public void setWhenCondition(SQLExpr whenCondition) {
        setChildParent(whenCondition);
        this.whenCondition = whenCondition;
    }

    public SQLObject getTriggerBody() {
        return triggerBody;
    }

    public void setTriggerBody(SQLObject triggerBody) {
        setChildParent(triggerBody);
        this.triggerBody = triggerBody;
    }


    private Set<String> TRIGGER_EVENT = new HashSet<>();

    /**
     * [owner.]SCHEMA
     */
    public static class SQLOnSchemaExpr extends AbstractSQLExpr {

        protected SQLName owner;

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, owner);
            }
        }

        public SQLName getOwner() {
            return owner;
        }

        public void setOwner(SQLName owner) {
            setChildParent(owner);
            this.owner = owner;
        }
    }

    public static class SQLOnDatabaseExpr extends AbstractSQLExpr {

        protected boolean pluggable;

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            visitor.visit(this);
        }

        public boolean isPluggable() {
            return pluggable;
        }

        public void setPluggable(boolean pluggable) {
            this.pluggable = pluggable;
        }
    }


    /**
     * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#trigger%20action%20time
     */
    public enum SQLTriggerActionTime implements ISQLEnum {
        BEFORE(SQLReserved.BEFORE),
        AFTER(SQLReserved.AFTER),
        INSTEAD_OF(SQLReserved.INSTEAD_OF),
        FOR(SQLReserved.FOR),;

        public final SQLReserved name;

        SQLTriggerActionTime(SQLReserved name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name.upper;
        }

        @Override
        public SQLReserved getName() {
            return name;
        }
    }

    /**
     * FOR [ EACH ] { ROW | STATEMENT }
     * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#triggered%20action
     * https://www.postgresql.org/docs/devel/static/sql-createtrigger.html
     */
    public enum SQLTriggerForEachType implements ISQLEnum {

        FOR_ROW(SQLReserved.FOR_ROW),
        FOR_EACH_ROW(SQLReserved.FOR_EACH_ROW),

        FOR_STATEMENT(SQLReserved.FOR_STATEMENT),
        FOR_EACH_STATEMENT(SQLReserved.FOR_EACH_STATEMENT),;

        public final SQLReserved name;

        SQLTriggerForEachType(SQLReserved name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name.upper;
        }

        @Override
        public SQLReserved getName() {
            return name;
        }
    }

    /**
     * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/CREATE-TRIGGER-statement.html#GUID-AF9E33F1-64D1-4382-A6A4-EC33C36F237B
     * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/img_text/trigger_edition_clause.html
     */
    public enum SQLTriggerEditionType implements ISQLEnum {

        CROSSEDITION(SQLReserved.CROSSEDITION),
        FORWARD_CROSSEDITION(SQLReserved.FORWARD_CROSSEDITION),
        REVERSE_CROSSEDITION(SQLReserved.REVERSE_CROSSEDITION),;

        public final SQLReserved name;

        SQLTriggerEditionType(SQLReserved name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name.upper;
        }

        @Override
        public SQLReserved getName() {
            return name;
        }
    }
}
