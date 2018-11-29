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
package com.aliyun.gumiho.sql.basic.ast.statement.ddl.table;


import com.aliyun.gumiho.sql.basic.ast.element.datatype.SQLDataType;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLCollationExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLSharingClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLXmlSchemaSpec;
import com.aliyun.gumiho.sql.basic.ast.element.expr.parallel.ISQLParallelClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.ISQLSelectQuery;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.*;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.constraint.SQLAlterTableAddTableConstraintAction;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.ISQLColumnDefinition;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.SQLColumnDefinition;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.SQLTableElement;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.constraint.table.SQLForeignKeyTableConstraint;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.partition.ISQLPartitionBy;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLPropertyExpr;
import com.aliyun.gumiho.sql.basic.ast.enums.*;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.SQLCreateStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.comment.SQLCommentOnColumnStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.comment.SQLCommentOnTableStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.SQLObjectType;
import com.aliyun.gumiho.sql.util.SQLParserUtils;
import com.aliyun.gumiho.sql.util.SQLUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#table definition
 * <p>
 * <p>
 * CREATE [TEMPORARY] TABLE [IF NOT EXISTS] tbl_name
 * (create_definition,...)
 * [table_options]
 * [partition_options]
 * https://dev.mysql.com/doc/refman/8.0/en/create-table.html
 * <p>
 * <p>
 * CREATE [ { GLOBAL | PRIVATE } TEMPORARY | SHARDED | DUPLICATED ] TABLE
 * [ schema. ] table
 * [ SHARING = { METADATA | DATA | EXTENDED DATA | NONE } ]
 * [OF [ schema. ] object_type ] [object_table_substitution]
 * [ (relational_properties) ]
 * [ DEFAULT COLLATION collation_name ]
 * [ XMLTYPE XMLType_storage ] [ XMLSchema_spec ] [ XMLType_virtual_columns ]
 * [ ON COMMIT { DROP | PRESERVE } DEFINITION ]
 * [ ON COMMIT { DELETE | PRESERVE } ROWS ]
 * [ OID_clause ] [ OID_index_clause ]
 * [ physical_properties ]
 * [ table_properties ]
 * [ MEMOPTIMIZE FOR READ ]
 * [ PARENT [ schema. ] table ] ;
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-TABLE.html#GUID-F9CE0CC3-13AE-4744-A43C-EAC7A71AAAB6
 *
 * @author kongtong.ouyang onCondition 2018/1/23.
 */
public class SQLCreateTableStatement extends AbstractSQLStatement implements SQLCreateStatement {

    protected SQLTableScope scope;

    protected boolean ifNotExists = false;

    protected SQLName name;

    protected SQLSharingClause sharingClause;

    protected SQLDataType ofDataType;
    protected SQLExpr subTable;

    protected SQLObjectTableSubstitution objectTableSubstitution;

    protected boolean tableElementsParen = true;
    protected final List<SQLTableElement> tableElements = new ArrayList<>();

    protected SQLCollationExpr collationExpr;

//    protected OracleSQLXmlTypeStorage xmlTypeStorage;
    protected SQLXmlSchemaSpec xmlSchemaSpec;
//    protected OracleSQLXMLTypeVirtualColumns xmlTypeVirtualColumn;

    protected SQLOnCommitActionDefinitionType commitActionDefinition;
    protected SQLOnCommitActionRowsType commitActionRows;

    protected SQLOidClause oidClause;
    protected SQLOidIndexClause oidIndexClause;

    // oracle physical property / column property
    protected final List<SQLExpr> properties = new ArrayList<>();

    protected SQLReadOnlyType readOnly;
    protected SQLIndexingOnType indexingOn;
    protected ISQLPartitionBy partitionBy;
    protected SQLAttributeClusteringClause attributeClusteringClause;
    protected SQLCacheType cache;
    protected SQLTablePropertyResultCache resultCache;
    protected ISQLParallelClause parallelClause;
    protected SQLRowDependenciesType rowDependencies;
    protected final List<ISQLEnableDisableClause> enableDisableClauses = new ArrayList<>();
    protected SQLRowMovementClause rowMovementClause;
    protected ISQLFlashbackArchiveClause flashbackArchiveClause;
    protected boolean rowArchival;
    protected SQLForExchangeWithTableClause forExchangeWithTableClause;

    // mysql
    protected SQLKeyViolate keyViolate;

    protected boolean as;
    protected ISQLSelectQuery subQuery;

    protected boolean memOptimizeForRead;
    protected SQLExpr parentTable;


    public SQLCreateTableStatement(DBType dbType) {
        super(dbType);
    }


    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
            this.acceptChild(visitor, sharingClause);
            this.acceptChild(visitor, ofDataType);
            this.acceptChild(visitor, objectTableSubstitution);

            this.acceptChild(visitor, tableElements);

            this.acceptChild(visitor, collationExpr);

//            this.acceptChild(visitor, xmlTypeStorage);
            this.acceptChild(visitor, xmlSchemaSpec);
//            this.acceptChild(visitor, xmlTypeVirtualColumn);

            this.acceptChild(visitor, oidClause);
            this.acceptChild(visitor, oidIndexClause);
            this.acceptChild(visitor, properties);

            this.acceptChild(visitor, partitionBy);

            this.acceptChild(visitor, resultCache);
            this.acceptChild(visitor, parallelClause);
            this.acceptChild(visitor, enableDisableClauses);
            this.acceptChild(visitor, rowMovementClause);
            this.acceptChild(visitor, flashbackArchiveClause);

            this.acceptChild(visitor, subQuery);
            this.acceptChild(visitor, parentTable);
        }
    }


    @Override
    public SQLCreateTableStatement clone() {
        SQLCreateTableStatement x = new SQLCreateTableStatement(this.dbType);
        this.cloneTo(x);
        return x;
    }

    public void cloneTo(SQLCreateTableStatement x) {
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

        if (source == ofDataType
                && target instanceof SQLDataType) {
            setOfDataType((SQLDataType) target);
            return true;
        }

        if (source == parentTable) {
            setParentTable(target);
            return true;
        }
        return false;
    }

    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.CREATE_TABLE;
    }

    public SQLTableElement findColumn(String column) {
        if (column == null) {
            return null;
        }

        for (SQLTableElement tableElement : this.tableElements) {

        }
        return null;
    }

    public SQLColumnDefinition findColumn(SQLName name) {
        if (name == null) {
            return null;
        }

        for (SQLTableElement element : this.tableElements) {
            if (!(element instanceof SQLColumnDefinition)) {
                continue;
            }
            SQLColumnDefinition column = (SQLColumnDefinition) element;
            if (column.getName().lowerHash() == name.lowerHash()) {
                return column;
            }
        }
        return null;
    }

    public void addColumn(String columnName, String dataType) {
        if (columnName == null
                || columnName.length() == 0) {
            throw new IllegalArgumentException("columnName is null.");
        }
        if (dataType == null
                || dataType.length() == 0) {
            throw new IllegalArgumentException("dataType is null.");
        }
        SQLColumnDefinition column = new SQLColumnDefinition();
        column.setColumnName(columnName);
        column.setDataType(SQLParserUtils.toSQLDataType(dataType, dbType));
        addColumn(column);
    }

    public void addColumn(SQLColumnDefinition column) {
        if (column == null) {
            throw new IllegalArgumentException("column is null.");
        }
        addTableElement(column);
    }

    public List<SQLForeignKeyTableConstraint> foreignKeys() {
        List<SQLForeignKeyTableConstraint> foreignKeys = new ArrayList<>();
        for (SQLTableElement element : this.tableElements) {
            if (!(element instanceof SQLForeignKeyTableConstraint)) {
                continue;
            }
            foreignKeys.add((SQLForeignKeyTableConstraint) element);
        }
        return foreignKeys;
    }

    public List<SQLName> referencedTables() {
        List<SQLName> referencedTables = new ArrayList<>();
        for (SQLTableElement element : this.tableElements) {

            if (element instanceof SQLForeignKeyTableConstraint) {
                referencedTables.add(((SQLForeignKeyTableConstraint) element).getReferencedTable());
            } else if (element instanceof ISQLColumnDefinition) {
                referencedTables.addAll(((ISQLColumnDefinition) element).referencedTables());
            }
        }

        return referencedTables;
    }

    public SQLAlterTableStatement createAddForeignKeyAndRemove(DBType type) {

        for (int i = 0; i < this.tableElements.size(); i++) {
            SQLTableElement element = tableElements.get(i);
            if (!(element instanceof SQLForeignKeyTableConstraint)) {
                continue;
            }

            SQLForeignKeyTableConstraint foreignKey = (SQLForeignKeyTableConstraint) element;
            SQLAlterTableStatement x = new SQLAlterTableStatement(type);

            SQLAlterTableAddTableConstraintAction action = new SQLAlterTableAddTableConstraintAction();
            action.addConstraint(foreignKey);
            x.addItem(action);

            tableElements.remove(i);

            return x;
        }

        return null;
    }

    public boolean comment(SQLCommentOnTableStatement x) {
        if (x == null) {
            return false;
        }

        SQLExpr comment = x.getComment();
        if (comment == null) {
            return false;
        }

        boolean equalsIgnoreCase = SQLUtils.nameEqualsIgnoreCase(this.getName(), x.getName());
        if (!equalsIgnoreCase) {
            return false;
        }

        for (int i = 0; i < this.properties.size(); i++) {
            SQLExpr property = this.properties.get(i);
            if (property instanceof SQLCommentOptionExpr) {
                ((SQLCommentOptionExpr) property).setValue(comment.clone());
                return true;
            }
        }

        this.properties.add(SQLCommentOptionExpr.of(comment.clone()));

        return true;
    }

    public boolean comment(SQLCommentOnColumnStatement x) {
        if (x == null) {
            return false;
        }

        SQLExpr comment = x.getComment();
        if (comment == null) {
            return false;
        }

        if (!(x.getName() instanceof SQLPropertyExpr)
                || !(((SQLPropertyExpr) x.getName()).getOwner() instanceof SQLName)) {
            return false;
        }

        SQLPropertyExpr name = (SQLPropertyExpr) x.getName();
        boolean equalsIgnoreCase = SQLUtils.nameEqualsIgnoreCase(this.getName(), (SQLName) name.getOwner());
        if (!equalsIgnoreCase) {
            return false;
        }

        SQLColumnDefinition column = findColumn(name.getNameExpr());
        if (column == null) {
            return false;
        }
        column.setComment(comment.clone());

        return true;
    }

    public List<SQLCommentOnColumnStatement> createCommentOnColumnAndRemove(DBType dbType) {

        List<SQLCommentOnColumnStatement> xx = new ArrayList<>();

        for (SQLTableElement tableElement : this.tableElements) {
            if (!(tableElement instanceof SQLColumnDefinition)) {
                continue;
            }
            SQLColumnDefinition column = (SQLColumnDefinition) tableElement;
            SQLExpr comment = column.getComment();
            if (comment == null) {
                continue;
            }
            SQLCommentOnColumnStatement x = new SQLCommentOnColumnStatement(dbType);
            xx.add(x);
            x.setName(getName().clone());
            x.setComment(comment.clone());

            // remove
            column.setCommentClause(null);
        }
        return xx;

    }

    public SQLCommentOnTableStatement createCommentOnTableAndRemove(DBType dbType) {
        for (int i = 0; i < properties.size(); i++) {
            if (!(properties.get(i) instanceof SQLCommentOptionExpr)) {
                continue;
            }

            SQLCommentOptionExpr commentClause = (SQLCommentOptionExpr) properties.get(i);

            SQLCommentOnTableStatement x = new SQLCommentOnTableStatement(dbType);
            x.setName(getName().clone());
            x.setComment(commentClause.getValue().clone());

            // remove
            properties.remove(i);

            return x;
        }
        return null;
    }


    public SQLTableScope getScope() {
        return scope;
    }

    public void setScope(SQLTableScope scope) {
        this.scope = scope;
    }

    public boolean isIfNotExists() {
        return ifNotExists;
    }

    public void setIfNotExists(boolean ifNotExists) {
        this.ifNotExists = ifNotExists;
    }


    public SQLName getSchema() {
        SQLExpr name = getName();
        if (name == null) {
            return null;
        }

        if (name instanceof SQLPropertyExpr
                && ((SQLPropertyExpr) name).getOwner() instanceof SQLName) {
            return (SQLName) ((SQLPropertyExpr) name).getOwner();
        }

        return null;
    }

    public SQLName getName() {
        return name;
    }

    public String getTableName() {
        if (name != null) {
            return name.getName();
        }
        return null;
    }

    public void setName(SQLName name) {
        setChildParent(name);
        this.name = name;
    }

    public void setTableName(String tableName) {
        if (tableName == null) {
            return;
        }
        setName(SQLUtils.ofName(tableName));
    }

    public SQLSharingClause getSharingClause() {
        return sharingClause;
    }

    public void setSharingClause(SQLSharingClause sharingClause) {
        setChildParent(sharingClause);
        this.sharingClause = sharingClause;
    }

    public SQLDataType getOfDataType() {
        return ofDataType;
    }

    public void setOfDataType(SQLDataType ofDataType) {
        setChildParent(ofDataType);
        this.ofDataType = ofDataType;
    }

    public SQLExpr getSubTable() {
        return subTable;
    }

    public void setSubTable(SQLExpr subTable) {
        this.subTable = subTable;
    }

    public SQLObjectTableSubstitution getObjectTableSubstitution() {
        return objectTableSubstitution;
    }

    public void setObjectTableSubstitution(SQLObjectTableSubstitution objectTableSubstitution) {
        setChildParent(objectTableSubstitution);
        this.objectTableSubstitution = objectTableSubstitution;
    }


    public boolean isTableElementsParen() {
        return tableElementsParen;
    }

    public void setTableElementsParen(boolean tableElementsParen) {
        this.tableElementsParen = tableElementsParen;
    }

    public List<SQLTableElement> getTableElements() {
        return tableElements;
    }

    public void addTableElement(SQLTableElement tableElement) {
        if (tableElement == null) {
            return;
        }
        setChildParent(tableElement);
        tableElements.add(tableElement);
    }

    public SQLCollationExpr getCollationExpr() {
        return collationExpr;
    }

    public void setCollationExpr(SQLCollationExpr collationExpr) {
        setChildParent(collationExpr);
        this.collationExpr = collationExpr;
    }


//    public OracleSQLXmlTypeStorage getXmlTypeStorage() {
//        return xmlTypeStorage;
//    }
//
//    public void setXmlTypeStorage(OracleSQLXmlTypeStorage xmlTypeStorage) {
//        setChildParent(xmlTypeStorage);
//        this.xmlTypeStorage = xmlTypeStorage;
//    }

    public SQLXmlSchemaSpec getXmlSchemaSpec() {
        return xmlSchemaSpec;
    }

    public void setXmlSchemaSpec(SQLXmlSchemaSpec xmlSchemaSpec) {
        setChildParent(xmlSchemaSpec);
        this.xmlSchemaSpec = xmlSchemaSpec;
    }

//    public OracleSQLXMLTypeVirtualColumns getXmlTypeVirtualColumn() {
//        return xmlTypeVirtualColumn;
//    }
//
//    public void setXmlTypeVirtualColumn(OracleSQLXMLTypeVirtualColumns xmlTypeVirtualColumn) {
//        setChildParent(xmlTypeVirtualColumn);
//        this.xmlTypeVirtualColumn = xmlTypeVirtualColumn;
//    }

    public SQLOnCommitActionDefinitionType getCommitActionDefinition() {
        return commitActionDefinition;
    }

    public void setCommitActionDefinition(SQLOnCommitActionDefinitionType commitActionDefinition) {
        this.commitActionDefinition = commitActionDefinition;
    }

    public SQLOnCommitActionRowsType getCommitActionRows() {
        return commitActionRows;
    }

    public void setCommitActionRows(SQLOnCommitActionRowsType commitActionRows) {
        this.commitActionRows = commitActionRows;
    }

    public SQLOidClause getOidClause() {
        return oidClause;
    }

    public void setOidClause(SQLOidClause oidClause) {
        setChildParent(oidClause);
        this.oidClause = oidClause;
    }

    public SQLOidIndexClause getOidIndexClause() {
        return oidIndexClause;
    }

    public void setOidIndexClause(SQLOidIndexClause oidIndexClause) {
        setChildParent(oidIndexClause);
        this.oidIndexClause = oidIndexClause;
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

    public SQLReadOnlyType getReadOnly() {
        return readOnly;
    }

    public void setReadOnly(SQLReadOnlyType readOnly) {
        this.readOnly = readOnly;
    }

    public SQLIndexingOnType getIndexingOn() {
        return indexingOn;
    }

    public void setIndexingOn(SQLIndexingOnType indexingOn) {
        this.indexingOn = indexingOn;
    }

    public ISQLPartitionBy getPartitionBy() {
        return partitionBy;
    }

    public void setPartitionBy(ISQLPartitionBy partitionBy) {
        setChildParent(partitionBy);
        this.partitionBy = partitionBy;
    }


    public SQLAttributeClusteringClause getAttributeClusteringClause() {
        return attributeClusteringClause;
    }

    public void setAttributeClusteringClause(SQLAttributeClusteringClause attributeClusteringClause) {
        setChildParent(attributeClusteringClause);
        this.attributeClusteringClause = attributeClusteringClause;
    }

    public SQLCacheType getCache() {
        return cache;
    }

    public void setCache(SQLCacheType cache) {
        this.cache = cache;
    }

    public SQLTablePropertyResultCache getResultCache() {
        return resultCache;
    }

    public void setResultCache(SQLTablePropertyResultCache resultCache) {
        setChildParent(resultCache);
        this.resultCache = resultCache;
    }

    public ISQLParallelClause getParallelClause() {
        return parallelClause;
    }

    public void setParallelClause(ISQLParallelClause parallelClause) {
        setChildParent(parallelClause);
        this.parallelClause = parallelClause;
    }

    public SQLRowDependenciesType getRowDependencies() {
        return rowDependencies;
    }

    public void setRowDependencies(SQLRowDependenciesType rowDependencies) {
        this.rowDependencies = rowDependencies;
    }

    public List<ISQLEnableDisableClause> getEnableDisableClauses() {
        return enableDisableClauses;
    }

    public void addEnableDisableClause(ISQLEnableDisableClause enableDisableClause) {
        if (enableDisableClause == null) {
            return;
        }
        setChildParent(enableDisableClause);
        this.enableDisableClauses.add(enableDisableClause);
    }

    public SQLRowMovementClause getRowMovementClause() {
        return rowMovementClause;
    }

    public void setRowMovementClause(SQLRowMovementClause rowMovementClause) {
        setChildParent(rowMovementClause);
        this.rowMovementClause = rowMovementClause;
    }

    public ISQLFlashbackArchiveClause getFlashbackArchiveClause() {
        return flashbackArchiveClause;
    }

    public void setFlashbackArchiveClause(ISQLFlashbackArchiveClause flashbackArchiveClause) {
        setChildParent(flashbackArchiveClause);
        this.flashbackArchiveClause = flashbackArchiveClause;
    }

    public boolean isRowArchival() {
        return rowArchival;
    }

    public void setRowArchival(boolean rowArchival) {
        this.rowArchival = rowArchival;
    }

    public SQLForExchangeWithTableClause getForExchangeWithTableClause() {
        return forExchangeWithTableClause;
    }

    public void setForExchangeWithTableClause(SQLForExchangeWithTableClause forExchangeWithTableClause) {
        setChildParent(forExchangeWithTableClause);
        this.forExchangeWithTableClause = forExchangeWithTableClause;
    }


    public SQLKeyViolate getKeyViolate() {
        return keyViolate;
    }

    public void setKeyViolate(SQLKeyViolate keyViolate) {
        this.keyViolate = keyViolate;
    }

    public boolean isAs() {
        return as;
    }

    public void setAs(boolean as) {
        this.as = as;
    }

    public ISQLSelectQuery getSubQuery() {
        return subQuery;
    }

    public void setSubQuery(ISQLSelectQuery subQuery) {
        setChildParent(subQuery);
        this.subQuery = subQuery;
    }

    public boolean isMemOptimizeForRead() {
        return memOptimizeForRead;
    }

    public void setMemOptimizeForRead(boolean memOptimizeForRead) {
        this.memOptimizeForRead = memOptimizeForRead;
    }

    public SQLExpr getParentTable() {
        return parentTable;
    }

    public String getParentTableName() {
        if (parentTable instanceof SQLName) {
            return ((SQLName) parentTable).getName();
        }
        return null;
    }

    public void setParentTable(SQLExpr parentTable) {
        setChildParent(parentTable);
        this.parentTable = parentTable;
    }


    public enum SQLWithDataType implements ISQLEnum {

        WITH_NO_DATA(SQLReserved.WITH_NO_DATA),
        WITH_DATA(SQLReserved.WITH_DATA);

        public final SQLReserved name;

        SQLWithDataType(SQLReserved name) {
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
