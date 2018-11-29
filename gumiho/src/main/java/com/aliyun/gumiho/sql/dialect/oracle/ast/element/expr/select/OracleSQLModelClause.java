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
package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.select;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLArrayExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.ISQLSelectQuery;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.order.SQLOrderByClause;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * model_clause
 * MODEL [ cell_reference_options ] [ return_rows_clause ] [ reference_model ]... main_model
 * <p>
 * https://docs.oracle.com/database/121/SQLRF/statements_10002.htm#SQLRF01702
 *
 * @author kongtong.ouyang onCondition 2018/3/21.
 */
public class OracleSQLModelClause extends AbstractOracleSQLExpr {

    protected OracleSQLCellReferenceOptions cellReferenceOptions;

    protected SQLReserved returnRowsClause;

    protected final List<OracleSQLReferenceModelClause> referenceModelClauses = new ArrayList<>();

    protected OracleSQLMainModel mainModel;


    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, cellReferenceOptions);
            this.acceptChild(visitor, referenceModelClauses);
            this.acceptChild(visitor, mainModel);
        }
    }

    @Override
    public OracleSQLModelClause clone() {
        OracleSQLModelClause x = new OracleSQLModelClause();
        this.cloneTo(x);

        if (this.cellReferenceOptions != null) {
            OracleSQLCellReferenceOptions cellReferenceOptionsClone = this.cellReferenceOptions.clone();
            x.setCellReferenceOptions(cellReferenceOptionsClone);
        }

        if (this.returnRowsClause != null) {
            x.setReturnRowsClause(this.returnRowsClause);
        }

        for (OracleSQLReferenceModelClause referenceModelClause : referenceModelClauses) {
            OracleSQLReferenceModelClause referenceModelClauseClone = referenceModelClause.clone();
            x.addReferenceModelClause(referenceModelClauseClone);
        }

        if (this.mainModel != null) {
            OracleSQLMainModel mainModelClone = this.mainModel.clone();
            x.setMainModel(mainModelClone);
        }

        return x;
    }

    public void cloneTo(OracleSQLModelClause x) {
        super.cloneTo(x);
    }


    public OracleSQLCellReferenceOptions getCellReferenceOptions() {
        return cellReferenceOptions;
    }

    public void setCellReferenceOptions(OracleSQLCellReferenceOptions cellReferenceOptions) {
        setChildParent(cellReferenceOptions);
        this.cellReferenceOptions = cellReferenceOptions;
    }

    public SQLReserved getReturnRowsClause() {
        return returnRowsClause;
    }

    public void setReturnRowsClause(SQLReserved returnRowsClause) {
        this.returnRowsClause = returnRowsClause;
    }

    public List<OracleSQLReferenceModelClause> getReferenceModelClauses() {
        return referenceModelClauses;
    }

    public void addReferenceModelClause(OracleSQLReferenceModelClause referenceModelClause) {
        if (referenceModelClause == null) {
            return;
        }
        setChildParent(referenceModelClause);
        this.referenceModelClauses.add(referenceModelClause);
    }

    public OracleSQLMainModel getMainModel() {
        return mainModel;
    }

    public void setMainModel(OracleSQLMainModel mainModel) {
        setChildParent(mainModel);
        this.mainModel = mainModel;
    }


    /**
     * [ { IGNORE | KEEP } NAV ] [ UNIQUE { DIMENSION | SINGLE REFERENCE } ]
     */
    public static class OracleSQLCellReferenceOptions extends AbstractOracleSQLExpr {

        private OracleSQLCellReferenceNavOptionType navOptionType;

        private OracleSQLCellReferenceUniqueOptionType uniqueOptionType;

        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            visitor.visit(this);
        }

        @Override
        public OracleSQLCellReferenceOptions clone() {
            OracleSQLCellReferenceOptions x = new OracleSQLCellReferenceOptions();

            x.navOptionType = this.navOptionType;
            x.uniqueOptionType = this.uniqueOptionType;

            return x;
        }

        public OracleSQLCellReferenceNavOptionType getNavOptionType() {
            return navOptionType;
        }

        public void setNavOptionType(OracleSQLCellReferenceNavOptionType navOptionType) {
            this.navOptionType = navOptionType;
        }

        public OracleSQLCellReferenceUniqueOptionType getUniqueOptionType() {
            return uniqueOptionType;
        }

        public void setUniqueOptionType(OracleSQLCellReferenceUniqueOptionType uniqueOptionType) {
            this.uniqueOptionType = uniqueOptionType;
        }
    }

    public enum OracleSQLCellReferenceNavOptionType {
        IGNORE(SQLReserved.IGNORE),
        KEEP(SQLReserved.KEEP);
        public final SQLReserved name;

        OracleSQLCellReferenceNavOptionType(SQLReserved name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name.upper;
        }
    }

    public enum OracleSQLCellReferenceUniqueOptionType {
        DIMENSION(SQLReserved.DIMENSION),
        SINGLE_REFERENCE(SQLReserved.SINGLE_REFERENCE);

        public final SQLReserved name;

        OracleSQLCellReferenceUniqueOptionType(SQLReserved name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name.upper;
        }
    }


    /**
     * REFERENCE reference_model_name ON (subquery) model_column_clauses [ cell_reference_options ]
     * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/img_text/reference_model.html
     */
    public static class OracleSQLReferenceModelClause extends AbstractOracleSQLExpr {

        protected SQLName name;

        protected ISQLSelectQuery subQuery;

        protected OracleSQLModelColumnClauses modelColumnClauses;

        protected OracleSQLCellReferenceOptions cellReferenceOptions;

        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, name);
                this.acceptChild(visitor, subQuery);
                this.acceptChild(visitor, modelColumnClauses);
                this.acceptChild(visitor, cellReferenceOptions);
            }
        }

        @Override
        public OracleSQLReferenceModelClause clone() {
            OracleSQLReferenceModelClause x = new OracleSQLReferenceModelClause();
            this.cloneTo(x);

            SQLName nameClone = this.name.clone();
            x.setName(nameClone);

            ISQLSelectQuery subQueryClone = subQuery.clone();
            x.setSubQuery(subQueryClone);

            OracleSQLModelColumnClauses modelColumnClausesClone = modelColumnClauses.clone();
            x.setModelColumnClauses(modelColumnClausesClone);

            OracleSQLCellReferenceOptions cellReferenceOptionsClone = this.cellReferenceOptions.clone();
            x.setCellReferenceOptions(cellReferenceOptionsClone);

            return x;
        }

        public SQLName getName() {
            return name;
        }

        public void setName(SQLName name) {
            setChildParent(name);
            this.name = name;
        }

        public ISQLSelectQuery getSubQuery() {
            return subQuery;
        }

        public void setSubQuery(ISQLSelectQuery subQuery) {
            setChildParent(subQuery);
            this.subQuery = subQuery;
        }

        public OracleSQLModelColumnClauses getModelColumnClauses() {
            return modelColumnClauses;
        }

        public void setModelColumnClauses(OracleSQLModelColumnClauses modelColumnClauses) {
            setChildParent(modelColumnClauses);
            this.modelColumnClauses = modelColumnClauses;
        }

        public OracleSQLCellReferenceOptions getCellReferenceOptions() {
            return cellReferenceOptions;
        }

        public void setCellReferenceOptions(OracleSQLCellReferenceOptions cellReferenceOptions) {
            setChildParent(cellReferenceOptions);
            this.cellReferenceOptions = cellReferenceOptions;
        }
    }

    /**
     * [ MAIN main_model_name ] model_column_clauses [ cell_reference_options ] model_rules_clause
     * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/img_text/main_model.html
     */
    public static class OracleSQLMainModel extends AbstractOracleSQLExpr {

        protected SQLName name;

        protected OracleSQLModelColumnClauses modelColumnClauses;

        protected OracleSQLCellReferenceOptions cellReferenceOptions;

        protected OracleSQLModelRulesClause modelRulesClause;

        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, name);
                this.acceptChild(visitor, modelColumnClauses);
                this.acceptChild(visitor, cellReferenceOptions);
                this.acceptChild(visitor, modelRulesClause);
            }
        }

        @Override
        public OracleSQLMainModel clone() {
            OracleSQLMainModel x = new OracleSQLMainModel();
            this.cloneTo(x);

            if (this.name != null) {
                SQLName nameClone = this.name.clone();
                x.setName(nameClone);
            }

            if (this.modelColumnClauses != null) {
                OracleSQLModelColumnClauses modelColumnClausesClone = modelColumnClauses.clone();
                x.setModelColumnClauses(modelColumnClausesClone);
            }

            if (this.cellReferenceOptions != null) {
                OracleSQLCellReferenceOptions cellReferenceOptionsClone = cellReferenceOptions.clone();
                x.setCellReferenceOptions(cellReferenceOptionsClone);
            }

            if (this.modelRulesClause != null) {
                OracleSQLModelRulesClause modelRulesClauseClone = modelRulesClause.clone();
                x.setModelRulesClause(modelRulesClauseClone);
            }

            return x;
        }

        public SQLName getName() {
            return name;
        }

        public void setName(SQLName name) {
            setChildParent(name);
            this.name = name;
        }

        public OracleSQLModelColumnClauses getModelColumnClauses() {
            return modelColumnClauses;
        }

        public void setModelColumnClauses(OracleSQLModelColumnClauses modelColumnClauses) {
            setChildParent(modelColumnClauses);
            this.modelColumnClauses = modelColumnClauses;
        }

        public OracleSQLCellReferenceOptions getCellReferenceOptions() {
            return cellReferenceOptions;
        }

        public void setCellReferenceOptions(OracleSQLCellReferenceOptions cellReferenceOptions) {
            setChildParent(cellReferenceOptions);
            this.cellReferenceOptions = cellReferenceOptions;
        }

        public OracleSQLModelRulesClause getModelRulesClause() {
            return modelRulesClause;
        }

        public void setModelRulesClause(OracleSQLModelRulesClause modelRulesClause) {
            setChildParent(modelRulesClause);
            this.modelRulesClause = modelRulesClause;
        }
    }

    /**
     * https://docs.oracle.com/database/121/SQLRF/statements_10002.htm#i2161264
     *
     * @author kongtong.ouyang onCondition 2018/3/22.
     */
    public static class OracleSQLModelColumnClauses extends AbstractOracleSQLExpr {

        protected final List<OracleSQLModelColumnClausesItem> partitionByItems = new ArrayList<>();
        protected final List<OracleSQLModelColumnClausesItem> dimensionByItems = new ArrayList<>();
        protected final List<OracleSQLModelColumnClausesItem> measuresItems = new ArrayList<>();

        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, partitionByItems);
                this.acceptChild(visitor, dimensionByItems);
                this.acceptChild(visitor, measuresItems);
            }
        }

        @Override
        public OracleSQLModelColumnClauses clone() {
            OracleSQLModelColumnClauses x = new OracleSQLModelColumnClauses();
            this.cloneTo(x);

            for (OracleSQLModelColumnClausesItem partitionByItem : partitionByItems) {
                OracleSQLModelColumnClausesItem partitionByItemClone = partitionByItem.clone();
                x.addPartitionByItem(partitionByItemClone);
            }

            for (OracleSQLModelColumnClausesItem dimensionByItem : dimensionByItems) {
                OracleSQLModelColumnClausesItem dimensionByItemClone = dimensionByItem.clone();
                x.addDimensionByItem(dimensionByItemClone);
            }

            for (OracleSQLModelColumnClausesItem measuresItem : measuresItems) {
                OracleSQLModelColumnClausesItem measuresItemClone = measuresItem.clone();
                x.addMeasuresItem(measuresItemClone);
            }

            return x;
        }

        public List<OracleSQLModelColumnClausesItem> getPartitionByItems() {
            return partitionByItems;
        }

        public void addPartitionByItem(OracleSQLModelColumnClausesItem item) {
            if (item == null) {
                return;
            }
            setChildParent(item);
            this.partitionByItems.add(item);
        }

        public List<OracleSQLModelColumnClausesItem> getDimensionByItems() {
            return dimensionByItems;
        }

        public void addDimensionByItem(OracleSQLModelColumnClausesItem item) {
            if (item == null) {
                return;
            }
            setChildParent(item);
            this.dimensionByItems.add(item);
        }

        public List<OracleSQLModelColumnClausesItem> getMeasuresItems() {
            return measuresItems;
        }

        public void addMeasuresItem(OracleSQLModelColumnClausesItem item) {
            if (item == null) {
                return;
            }
            setChildParent(item);
            measuresItems.add(item);
        }
    }

    public static class OracleSQLModelColumnClausesItem extends AbstractOracleSQLExpr {
        protected SQLExpr expr;
        protected SQLName alias;

        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, expr);
                this.acceptChild(visitor, alias);
            }
        }

        @Override
        public OracleSQLModelColumnClausesItem clone() {
            OracleSQLModelColumnClausesItem x = new OracleSQLModelColumnClausesItem();

            SQLExpr exprClone = this.expr.clone();
            x.setExpr(exprClone);

            if (this.alias != null) {
                SQLName aliasClone = this.alias.clone();
                x.setAlias(aliasClone);
            }

            return x;
        }

        public SQLExpr getExpr() {
            return expr;
        }

        public void setExpr(SQLExpr expr) {
            setChildParent(expr);
            this.expr = expr;
        }

        public SQLName getAlias() {
            return alias;
        }

        public void setAlias(SQLName alias) {
            setChildParent(alias);
            this.alias = alias;
        }
    }

    /**
     * [ RULES [ { UPDATE | UPSERT [ ALL ] } ] [ { AUTOMATIC | SEQUENTIAL } ORDER ] [ model_iterate_clause ] ] ( [ { UPDATE | UPSERT [ ALL ] } ] cell_assignment [ order_by_clause ] = expr [,  [ { UPDATE | UPSERT [ ALL ] } ] cell_assignment [ order_by_clause ] = expr ]... )
     * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/img_text/model_rules_clause.html
     */
    public static class OracleSQLModelRulesClause extends AbstractOracleSQLExpr {

        protected boolean rules;

        protected OracleSQLModelRulesType rulesType;

        protected OracleSQLModelRulesOrderType order;

        protected OracleSQLModelIterateClause modelIterateClause;

        protected final List<OracleSQLModelRulesClauseItem> items = new ArrayList<>();


        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, modelIterateClause);
            }
        }

        @Override
        public OracleSQLModelRulesClause clone() {
            OracleSQLModelRulesClause x = new OracleSQLModelRulesClause();
            this.cloneTo(x);

            x.rules = this.rules;

            x.rulesType = this.rulesType;

            x.order = this.order;

            if (this.modelIterateClause != null) {
                OracleSQLModelIterateClause modelIterateClauseClone = modelIterateClause.clone();
                x.setModelIterateClause(modelIterateClauseClone);
            }

            for (OracleSQLModelRulesClauseItem item : items) {
                OracleSQLModelRulesClauseItem itemClone = item.clone();
                x.addItem(itemClone);
            }


            return x;
        }

        public boolean isRules() {
            return rules;
        }

        public void setRules(boolean rules) {
            this.rules = rules;
        }

        public OracleSQLModelRulesType getRulesType() {
            return rulesType;
        }

        public void setRulesType(OracleSQLModelRulesType rulesType) {
            this.rulesType = rulesType;
        }

        public OracleSQLModelRulesOrderType getOrder() {
            return order;
        }

        public void setOrder(OracleSQLModelRulesOrderType order) {
            this.order = order;
        }

        public OracleSQLModelIterateClause getModelIterateClause() {
            return modelIterateClause;
        }

        public void setModelIterateClause(OracleSQLModelIterateClause modelIterateClause) {
            setChildParent(modelIterateClause);
            this.modelIterateClause = modelIterateClause;
        }

        public List<OracleSQLModelRulesClauseItem> getItems() {
            return items;
        }

        public void addItem(OracleSQLModelRulesClauseItem item) {
            if (item == null) {
                return;
            }
            setChildParent(item);
            items.add(item);
        }
    }

    public enum OracleSQLModelRulesType {
        UPDATE(SQLReserved.UPDATE),
        UPSERT(SQLReserved.UPSERT),
        UPSERT_ALL(SQLReserved.UPSERT_ALL),
        ;
        public final SQLReserved name;

        OracleSQLModelRulesType(SQLReserved name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name.upper;
        }
    }

    public enum OracleSQLModelRulesOrderType {
        AUTOMATIC_ORDER(SQLReserved.AUTOMATIC_ORDER),
        SEQUENTIAL_ORDER(SQLReserved.SEQUENTIAL_ORDER),
        ;
        public final SQLReserved name;

        OracleSQLModelRulesOrderType(SQLReserved name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name.upper;
        }
    }

    /**
     * [ { UPDATE | UPSERT [ ALL ] } ] cell_assignment [ order_by_clause ] = expr [,  [ { UPDATE | UPSERT [ ALL ] } ] cell_assignment [ order_by_clause ] = expr ]
     * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/img_text/model_rules_clause.html
     */
    public static class OracleSQLModelRulesClauseItem extends AbstractOracleSQLExpr {

        protected OracleSQLModelRulesType rulesType;

        protected SQLArrayExpr cellAssignment;

        protected SQLOrderByClause orderByClause;

        protected SQLExpr expr;


        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, cellAssignment);
                this.acceptChild(visitor, orderByClause);
                this.acceptChild(visitor, expr);
            }
        }

        @Override
        public OracleSQLModelRulesClauseItem clone() {
            OracleSQLModelRulesClauseItem x = new OracleSQLModelRulesClauseItem();

            x.rulesType = this.rulesType;

            SQLArrayExpr cellAssignmentClone = cellAssignment.clone();
            x.setCellAssignment(cellAssignmentClone);

            SQLOrderByClause orderByClauseClone = this.orderByClause.clone();
            x.setOrderByClause(orderByClauseClone);

            SQLExpr exprClone = this.expr.clone();
            x.setExpr(exprClone);

            return x;
        }

        public OracleSQLModelRulesType getRulesType() {
            return rulesType;
        }

        public void setRulesType(OracleSQLModelRulesType rulesType) {
            this.rulesType = rulesType;
        }

        public SQLArrayExpr getCellAssignment() {
            return cellAssignment;
        }

        public void setCellAssignment(SQLArrayExpr cellAssignment) {
            setChildParent(cellAssignment);
            this.cellAssignment = cellAssignment;
        }

        public SQLOrderByClause getOrderByClause() {
            return orderByClause;
        }

        public void setOrderByClause(SQLOrderByClause orderByClause) {
            setChildParent(orderByClause);
            this.orderByClause = orderByClause;
        }

        public SQLExpr getExpr() {
            return expr;
        }

        public void setExpr(SQLExpr expr) {
            setChildParent(expr);
            this.expr = expr;
        }
    }

    public static class OracleSQLModelIterateClause extends AbstractOracleSQLExpr {

        protected SQLExpr value;

        protected SQLExpr condition;

        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, value);
                this.acceptChild(visitor, condition);
            }
        }

        @Override
        public OracleSQLModelIterateClause clone() {
            OracleSQLModelIterateClause x = new OracleSQLModelIterateClause();
            this.cloneTo(x);

            if (this.value != null) {
                SQLExpr valueClone = this.value.clone();
                x.setValue(valueClone);
            }

            if (this.condition != null) {
                SQLExpr conditionClone = this.condition.clone();
                x.setCondition(conditionClone);
            }

            return x;
        }

        public SQLExpr getValue() {
            return value;
        }

        public void setValue(SQLExpr value) {
            setChildParent(value);
            this.value = value;
        }

        public SQLExpr getCondition() {
            return condition;
        }

        public void setCondition(SQLExpr condition) {
            setChildParent(condition);
            this.condition = condition;
        }
    }


}
