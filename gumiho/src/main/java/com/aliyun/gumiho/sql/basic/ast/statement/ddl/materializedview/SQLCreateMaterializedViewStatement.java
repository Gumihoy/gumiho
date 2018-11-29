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
package com.aliyun.gumiho.sql.basic.ast.statement.ddl.materializedview;


import com.aliyun.gumiho.sql.basic.ast.element.datatype.SQLDataType;
import com.aliyun.gumiho.sql.basic.ast.element.expr.*;
import com.aliyun.gumiho.sql.basic.ast.element.expr.materializedview.ISQLCreateMVRefresh;
import com.aliyun.gumiho.sql.basic.ast.element.expr.materializedview.ISQLUsingIndexClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.materializedview.SQLOnQueryComputationClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.materializedview.SQLQueryRewriteClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.ISQLSelectQuery;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.SQLCreateStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

import java.util.ArrayList;
import java.util.List;

/**
 * CREATE MATERIALIZED VIEW [ IF NOT EXISTS ] table_name [ (column_name [, ...] ) ] [ WITH ( storage_parameter [= value] [, ... ] ) ] [ TABLESPACE tablespace_name ] AS query [ WITH [ NO ] DATA ]
 * https://www.postgresql.org/docs/devel/static/sql-creatematerializedview.html
 * <p>
 * <p>
 * CREATE MATERIALIZED VIEW [ schema. ] materialized_view
 * [ OF [ schema. ] object_type ]
 * [ ( { scoped_table_ref_constraint
 * | column_alias [ENCRYPT [encryption_spec]]
 * }
 * [, { scoped_table_ref_constraint
 * | column_alias [ENCRYPT [encryption_spec]]
 * }
 * ]...
 * )
 * ]
 * [ DEFAULT COLLATION collation_name ]
 * { ON PREBUILT TABLE
 * [ { WITH | WITHOUT } REDUCED PRECISION ]
 * | physical_properties materialized_view_props
 * }
 * [ USING INDEX
 * [ physical_attributes_clause
 * | TABLESPACE tablespace
 * ]...
 * | USING NO INDEX
 * ]
 * [ create_mv_refresh ]
 * [ evaluation_edition_clause ]
 * [ { ENABLE | DISABLE } ON QUERY COMPUTATION ]
 * [ query_rewrite_clause ]
 * AS subquery ;
 * https://docs.oracle.com/cd/B28359_01/server.111/b28286/statements_6002.htm#SQLRF01302
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-MATERIALIZED-VIEW.html#GUID-EE262CA4-01E5-4618-B659-6165D993CA1B
 *
 * @author kongtong.ouyang onCondition 2018/1/23.
 */
public class SQLCreateMaterializedViewStatement extends AbstractSQLStatement implements SQLCreateStatement {

    protected boolean ifNotExists;
    protected SQLName name;

    protected final List<SQLExpr> columns = new ArrayList<>();

    protected boolean ofDataTypeInFrontOfColumn = true;
    protected SQLDataType ofDataType;

    protected final List<SQLExpr> columnConstraints = new ArrayList<>();

    protected SQLCollationExpr collationExpr;

    protected final List<SQLExpr> properties = new ArrayList<>();

    protected ISQLUsingIndexClause usingIndex;

    protected ISQLCreateMVRefresh createMVRefresh;

    protected boolean forUpdate;

    protected SQLEvaluationEditionClause evaluationEditionClause;

    protected SQLOnQueryComputationClause onQueryComputationClause;

    protected SQLQueryRewriteClause queryRewriteClause;


    protected SQLTablespaceOptionExpr tableSpaceClause;


    protected ISQLSelectQuery asSubQuery;

    protected SQLWithDataType withDataType;


    public SQLCreateMaterializedViewStatement(DBType dbType) {
        super(dbType);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
            this.acceptChild(visitor, columns);
            this.acceptChild(visitor, ofDataType);
            this.acceptChild(visitor, columnConstraints);
            this.acceptChild(visitor, properties);
            this.acceptChild(visitor, usingIndex);
            this.acceptChild(visitor, createMVRefresh);
            this.acceptChild(visitor, evaluationEditionClause);
            this.acceptChild(visitor, onQueryComputationClause);
            this.acceptChild(visitor, queryRewriteClause);
            this.acceptChild(visitor, asSubQuery);
        }
    }


    @Override
    public SQLCreateMaterializedViewStatement clone() {
        SQLCreateMaterializedViewStatement x = new SQLCreateMaterializedViewStatement(this.dbType);
        this.cloneTo(x);
        return x;
    }

    public void cloneTo(SQLCreateMaterializedViewStatement x) {
        super.cloneTo(x);

        x.ifNotExists = this.ifNotExists;


        if (this.asSubQuery != null) {
            ISQLSelectQuery asSubQueryClone = this.asSubQuery.clone();
            x.setAsSubQuery(asSubQueryClone);
        }

        x.withDataType = this.withDataType;
    }


    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == name
                && target instanceof SQLName) {
            this.setName((SQLName) target);
            return true;
        }

        if (source == ofDataType
                && target instanceof SQLDataType) {
            this.setOfDataType((SQLDataType) target);
            return true;
        }

        return false;
    }


    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.CREATE_MATERIALIZED_VIEW;
    }



    public boolean isIfNotExists() {
        return ifNotExists;
    }

    public void setIfNotExists(boolean ifNotExists) {
        this.ifNotExists = ifNotExists;
    }

    public SQLName getName() {
        return name;
    }

    public String getMaterializedViewName() {
        if (this.name == null) {
            return null;
        }
        return name.getName();
    }

    public void setName(SQLName name) {
        setChildParent(name);
        this.name = name;
    }


    public List<SQLExpr> getColumns() {
        return columns;
    }

    public void addColumn(SQLExpr column) {
        if (column == null) {
            return;
        }
        setChildParent(column);
        this.columns.add(column);
    }

    public boolean isOfDataTypeInFrontOfColumn() {
        return ofDataTypeInFrontOfColumn;
    }

    public void setOfDataTypeInFrontOfColumn(boolean ofDataTypeInFrontOfColumn) {
        this.ofDataTypeInFrontOfColumn = ofDataTypeInFrontOfColumn;
    }

    public SQLDataType getOfDataType() {
        return ofDataType;
    }

    public void setOfDataType(SQLDataType ofDataType) {
        setChildParent(ofDataType);
        this.ofDataType = ofDataType;
    }


    public List<SQLExpr> getColumnConstraints() {
        return columnConstraints;
    }

    public void addColumnConstraint(SQLExpr columnConstraint) {
        if (columnConstraint == null) {
            return;
        }
        setChildParent(columnConstraint);
        this.columnConstraints.add(columnConstraint);
    }

    public SQLCollationExpr getCollationExpr() {
        return collationExpr;
    }

    public void setCollationExpr(SQLCollationExpr collationExpr) {
        this.collationExpr = collationExpr;
    }


    public List<SQLExpr> getProperties() {
        return properties;
    }

    public void addProperty(SQLExpr property) {
        if (property == null) {
            return;
        }
        setChildParent(property);
        this.properties.add(property);
    }

    public ISQLUsingIndexClause getUsingIndex() {
        return usingIndex;
    }

    public void setUsingIndex(ISQLUsingIndexClause usingIndex) {
        setChildParent(usingIndex);
        this.usingIndex = usingIndex;
    }

    public ISQLCreateMVRefresh getCreateMVRefresh() {
        return createMVRefresh;
    }

    public void setCreateMVRefresh(ISQLCreateMVRefresh createMVRefresh) {
        setChildParent(createMVRefresh);
        this.createMVRefresh = createMVRefresh;
    }

    public boolean isForUpdate() {
        return forUpdate;
    }

    public void setForUpdate(boolean forUpdate) {
        this.forUpdate = forUpdate;
    }

    public SQLEvaluationEditionClause getEvaluationEditionClause() {
        return evaluationEditionClause;
    }

    public void setEvaluationEditionClause(SQLEvaluationEditionClause evaluationEditionClause) {
        setChildParent(evaluationEditionClause);
        this.evaluationEditionClause = evaluationEditionClause;
    }

    public SQLOnQueryComputationClause getOnQueryComputationClause() {
        return onQueryComputationClause;
    }

    public void setOnQueryComputationClause(SQLOnQueryComputationClause onQueryComputationClause) {
        setChildParent(onQueryComputationClause);
        this.onQueryComputationClause = onQueryComputationClause;
    }

    public SQLQueryRewriteClause getQueryRewriteClause() {
        return queryRewriteClause;
    }

    public void setQueryRewriteClause(SQLQueryRewriteClause queryRewriteClause) {
        setChildParent(queryRewriteClause);
        this.queryRewriteClause = queryRewriteClause;
    }


    public SQLTablespaceOptionExpr getTableSpaceClause() {
        return tableSpaceClause;
    }

    public void setTableSpaceClause(SQLTablespaceOptionExpr tableSpaceClause) {
        setChildParent(tableSpaceClause);
        this.tableSpaceClause = tableSpaceClause;
    }

    public ISQLSelectQuery getAsSubQuery() {
        return asSubQuery;
    }

    public void setAsSubQuery(ISQLSelectQuery asSubQuery) {
        setChildParent(asSubQuery);
        this.asSubQuery = asSubQuery;
    }

    public SQLWithDataType getWithDataType() {
        return withDataType;
    }

    public void setWithDataType(SQLWithDataType withDataType) {
        this.withDataType = withDataType;
    }


    /**
     * name [ENCRYPT encryption_spec]
     */
    public static class SQLColumn extends AbstractSQLExpr {

        protected SQLName name;
        protected SQLEncryptClause encryptClause;

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, name);
                this.acceptChild(visitor, encryptClause);
            }
        }

        @Override
        public SQLColumn clone() {
            SQLColumn x = new SQLColumn();
            return x;
        }

        public void cloneTo(SQLColumn x) {
            super.cloneTo(x);
        }

        public SQLName getName() {
            return name;
        }

        public void setName(SQLName name) {
            this.name = name;
        }

        public SQLEncryptClause getEncryptClause() {
            return encryptClause;
        }

        public void setEncryptClause(SQLEncryptClause encryptClause) {
            this.encryptClause = encryptClause;
        }
    }


    /**
     * https://www.postgresql.org/docs/10/static/sql-creatematerializedview.html
     */
    public enum SQLWithDataType {

        WITH_DATA(SQLReserved.WITH_DATA),
        WITH_NO_DATA(SQLReserved.WITH_NO_DATA),;

        public final SQLReserved name;

        SQLWithDataType(SQLReserved name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name.upper;
        }
    }
}
