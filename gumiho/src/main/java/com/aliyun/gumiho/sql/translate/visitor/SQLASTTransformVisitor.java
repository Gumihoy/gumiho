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
package com.aliyun.gumiho.sql.translate.visitor;


import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitorAdapter;
import com.aliyun.gumiho.sql.dialect.drds.ast.element.expr.table.partition.*;
import com.aliyun.gumiho.sql.dialect.drds.visitor.DRDSSQLASTVisitor;
import com.aliyun.gumiho.sql.dialect.mysql.ast.element.expr.MySQLSQLMatchExpr;
import com.aliyun.gumiho.sql.dialect.mysql.ast.element.expr.select.MySQLSQLOJTableReference;
import com.aliyun.gumiho.sql.dialect.mysql.ast.element.expr.select.MySQLSQLSelectQuery;
import com.aliyun.gumiho.sql.dialect.mysql.ast.statement.utility.MySQLSQLHelpStatement;
import com.aliyun.gumiho.sql.dialect.mysql.visitor.MySQLSQLASTVisitor;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common.*;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common.allocateextent.OracleSQLAllocateExtentClause;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common.filespecification.OracleSQLAutoExtendOffClause;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common.filespecification.OracleSQLAutoExtendOnClause;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common.filespecification.OracleSQLDataFileTempFileSpec;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common.filespecification.OracleSQLRedoLogFileSpec;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common.implicitcursor.*;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common.logging.OracleSQLFilesystemLikeLogging;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common.logging.OracleSQLLoggingClause;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common.logging.OracleSQLNoLoggingClause;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common.namecursor.OracleSQLFoundNameCursorExpr;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common.namecursor.OracleSQLIsOpenNameCursorExpr;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common.namecursor.OracleSQLNotFoundNameCursorExpr;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common.namecursor.OracleSQLRowcountNameCursorExpr;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common.storage.OracleSQLStorageClause;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.database.create.*;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.databaselink.create.OracleSQLConnectToCurrentUserClause;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.databaselink.create.OracleSQLConnectToIdentifiedByClause;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.databaselink.create.OracleSQLDBLinkAuthenticationClause;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.select.*;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.table.OracleSQLXMLTypeVirtualColumns;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.table.OracleSQLXmlTypeStorage;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.table.alter.column.OracleSQLAlterTableAddPeriodAction;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.table.alter.column.OracleSQLAlterTableDropPeriodAction;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.table.alter.partition.OracleSQLAlterTableModifyDefaultAttrsAction;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.table.alter.supplementallog.OracleSQLAlterTableAddSupplementalLogAction;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.table.alter.supplementallog.OracleSQLAlterTableDropSupplementalLogAction;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.table.element.OracleSQLPeriodDefinition;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.table.element.OracleSQLSupplementalIdKeyClause;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.table.element.OracleSQLSupplementalLogGrpClause;
import com.aliyun.gumiho.sql.dialect.postgresql.ast.element.expr.PostgreSQLSQLPositionVariableExpr;
import com.aliyun.gumiho.sql.dialect.postgresql.ast.element.expr.PostgreSQLSQLTypeCastExpr;
import com.aliyun.gumiho.sql.dialect.ppas.visitor.PPASSQLASTVisitor;
import com.aliyun.gumiho.sql.translate.SQLTransformConfig;
import com.aliyun.gumiho.sql.translate.result.SQLTransformChange;
import com.aliyun.gumiho.sql.translate.result.SQLTransformError;
import com.aliyun.gumiho.sql.translate.result.SQLTransformWarnning;

import java.util.LinkedHashSet;
import java.util.Set;

public class SQLASTTransformVisitor extends SQLASTVisitorAdapter implements PPASSQLASTVisitor, MySQLSQLASTVisitor, DRDSSQLASTVisitor {

    protected SQLTransformConfig config;

    Set<SQLTransformChange> changes = new LinkedHashSet<>();
    Set<SQLTransformWarnning> warnnings = new LinkedHashSet<>();
    Set<SQLTransformError> errors = new LinkedHashSet<>();


    public SQLASTTransformVisitor() {
        this.config = new SQLTransformConfig();
    }

    public SQLASTTransformVisitor(SQLTransformConfig config) {
        if (config == null) {
            config = new SQLTransformConfig();
        }
        this.config = config;
    }


    public Set<SQLTransformChange> getChanges() {
        return changes;
    }

    public void addChange(SQLTransformChange change) {
        if (change == null) {
            return;
        }
        changes.add(change);
    }

    public Set<SQLTransformWarnning> getWarnnings() {
        return warnnings;
    }

    public void addWarnning(SQLTransformWarnning warnning) {
        if (warnning == null) {
            return;
        }
        warnnings.add(warnning);
    }

    public Set<SQLTransformError> getErrors() {
        return errors;
    }

    public void addError(SQLTransformError error) {
        if (error == null) {
            return;
        }
        errors.add(error);
    }


// ----------- Oracle Start ------------------------------------------------------------
    @Override
    public boolean visit(OracleSQLAssignmentStatement x) {
        return true;
    }

    // ------------------------- DataType Start ----------------------------------------

    // ------------------------- DataType End ----------------------------------------


    // ------------------------- Literal Start ----------------------------------------


    // ------------------------- Literal End ----------------------------------------


    // --------------- Common SQL DDL Clauses Start ----------------------------

    @Override
    public boolean visit(OracleSQLAllocateExtentClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLAllocateExtentClause.OracleSQLAllocateExtentSizeClauseItem x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLAllocateExtentClause.OracleSQLAllocateExtentDataFileClauseItem x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLAllocateExtentClause.OracleSQLAllocateExtentInstanceClauseItem x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLDeallocateUnusedClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLDeferredSegmentCreation x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLDeletingExpr x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLDependenthandlingClause.OracleSQLInvalidate x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLDependenthandlingClause.OracleSQLCascade x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLDataFileTempFileSpec x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLRedoLogFileSpec x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLAutoExtendOffClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLAutoExtendOnClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLLoggingClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLNoLoggingClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLFilesystemLikeLogging x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLPhysicalPropertyOrganizationHeapClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLPhysicalPropertyOrganizationIndexClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLPhysicalPropertyOrganizationExternalClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLPhysicalPropertyClusterClause x) {
        return true;
    }


    @Override
    public boolean visit(OracleSQLHeapOrgTableClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLIndexOrgOverflowClause x) {
        return true;
    }

    @Override
    public boolean visit(IOracleSQLIndexOrgOverflowClause.OracleSQLIncludeClause x) {
        return true;
    }

    @Override
    public boolean visit(IOracleSQLIndexOrgOverflowClause.OracleSQLOverflowExpr x) {
        return true;
    }

    @Override
    public boolean visit(IOracleSQLPhysicalAttributesClause.OracleSQLUsageQueueClause x) {
        return true;
    }

    @Override
    public boolean visit(IOracleSQLPhysicalAttributesClause.OracleSQLPctfreeClause x) {
        return true;
    }

    @Override
    public boolean visit(IOracleSQLPhysicalAttributesClause.OracleSQLPctusedClause x) {
        return true;
    }

    @Override
    public boolean visit(IOracleSQLPhysicalAttributesClause.OracleSQLInitransClause x) {
        return true;
    }

    @Override
    public boolean visit(IOracleSQLPhysicalAttributesClause.OracleSQLMaxTransClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLSizeClause x) {
        return true;
    }

    @Override
    public boolean visit(IOracleSQLSubstitutableColumnClause.OracleSQLSubstitutableColumnIsOFClause x) {
        return true;
    }

    @Override
    public boolean visit(IOracleSQLSubstitutableColumnClause.OracleSQLSubstitutableColumnAtAllLevelsClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLTableCompressionByCompress x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLTableCompressionByRowStoreCompress x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLTableCompressionByColumnStoreCompress x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLTableCompressionByNoCompress x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLPrefixCompression x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLPrefixNoCompression x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLAdvancedIndexCompression x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLAdvancedIndexNoCompression x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLInMemoryClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLNoInMemoryClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLInMemoryTableClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLInMemoryAttributes x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLInMemoryMemCompressClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLInMemoryNoMemCompressClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLInMemoryPriority x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLInMemoryDistribute x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLInMemoryDuplicateClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLInMemoryDuplicateAllClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLInMemoryNoDuplicateClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLInMemoryColumnClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLNoInMemoryColumnClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLIlmClauseAddPolicyOption x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLIlmClauseDeletePolicyOption x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLIlmClauseEnablePolicyOption x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLIlmClauseDisablePolicyOption x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLIlmClauseDeleteAllOption x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLIlmClauseEnableAllOption x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLIlmClauseDisableAllOption x) {
        return true;
    }

    @Override
    public boolean visit(IOracleSQLIlmClause.OracleSQLIlmCompressionPolicyByTableCompression x) {
        return true;
    }

    @Override
    public boolean visit(IOracleSQLIlmClause.OracleSQLIlmCompressionPolicyByRowStoreCompression x) {
        return true;
    }

    @Override
    public boolean visit(IOracleSQLIlmClause.OracleSQLIlmCompressionPolicyByColumnStoreCompression x) {
        return true;
    }

    @Override
    public boolean visit(IOracleSQLIlmClause.OracleSQLIlmTieringPolicy x) {
        return true;
    }


    @Override
    public boolean visit(IOracleSQLIlmClause.OracleSQLIlmInMemoryPolicy x) {
        return true;
    }

    @Override
    public boolean visit(IOracleSQLIlmClause.OracleSQLIlmInMemoryPolicyBySetInMemory x) {
        return true;
    }

    @Override
    public boolean visit(IOracleSQLIlmClause.OracleSQLIlmInMemoryPolicyByModifyInMemory x) {
        return true;
    }

    @Override
    public boolean visit(IOracleSQLIlmClause.OracleSQLIlmInMemoryPolicyByNoInMemory x) {
        return true;
    }

    @Override
    public boolean visit(IOracleSQLIlmClause.AfterOfClause x) {
        return true;
    }

    @Override
    public boolean visit(IOracleSQLIlmClause.OnClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLIlmTimePeriod x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLStorageClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLStorageClause.OracleSQLStorageInitialSizeClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLStorageClause.OracleSQLStorageNextSizeClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLStorageClause.OracleSQLStorageMinExtentsClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLStorageClause.OracleSQLStorageMaxExtentsClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLStorageClause.OracleSQLStoragePctIncreaseClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLStorageClause.OracleSQLStorageFreeListsClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLStorageClause.OracleSQLStorageFreeListGroupsClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLStorageClause.OracleSQLStorageOptimalClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLStorageClause.OracleSQLStorageBufferPoolClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLStorageClause.OracleSQLStorageFlashCacheClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLStorageClause.OracleSQLStorageCellFlashCacheClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLStorageClause.OracleSQLStorageEncryptClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLNestedTableColProperty x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLNestedTableColProperty.SQLColumnValue x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLLobStorageClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLLocationClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLLocationClause.LocationItem x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLLobParameterEnable x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLLobParameterDisable x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLLobParameterChunk x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLLobParameterPctversion x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLLobParameterRebuildFreepools x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLLobParameterFreepools x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLLobParameterEncrypt x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLLobParameterDecrypt x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLLobParameterCache x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLLobParameterNoCache x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLLobParameterCacheReads x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLLobRetentionClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLLobDeduplicateClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLLobKeepDuplicatesClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLLobCompressionClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLLobNoCompressionClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLLobPartitionStorage x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLLobPartitioningStorage x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLMaxSizeClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLMappingTableClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLNoMappingTableClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLPctthresholdClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLObjectTypeColProperty x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLVarrayColPropertyColumnProperty x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLLobStorageClauseColumnProperty x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLLobStorageParameters x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLIsOpenImplicitCursorExpr x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLFoundImplicitCursorExpr x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLNotFoundImplicitCursorExpr x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLRowcountImplicitCursorExpr x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLBulkRowcountImplicitCursorExpr x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLBulkExceptionsCountImplicitCursorExpr x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLBulkExceptionImplicitCursorExpr x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLIsOpenNameCursorExpr x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLFoundNameCursorExpr x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLNotFoundNameCursorExpr x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLRowcountNameCursorExpr x) {
        return true;
    }


    // --------------------- Common SQL DDL Clauses End  --------------------------------------------------


    // ----------- PL/SQL Language Elements ------------------------------------------------------------


    @Override
    public boolean visit(OracleParallelEnableByAnyClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleParallelEnableByHashClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleParallelEnableByRangeClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleParallelEnableByValueClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleParallelEnableClause x) {
        return true;
    }

    @Override
    public boolean visit(AbstractOracleSQLParallelEnableClause.OracleSQLStreamingClauseByOrder x) {
        return true;
    }

    @Override
    public boolean visit(AbstractOracleSQLParallelEnableClause.OracleSQLStreamingClusterByCluster x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLAccessibleByClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLAccessorClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLAggregateClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLAutonomousTransPragma x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLBlock x) {
        return true;
    }


    @Override
    public boolean visit(OracleSQLCallSpec.OracleSQLJavaDeclaration x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLCallSpec.OracleSQLCDeclaration x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLCallSpec.LanguageCNameExpr x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLCallSpec.LanguageCLibraryExpr x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLCallSpec.OracleSQLContextExternalParameter x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLCallSpec.OracleSQLSelfExternalParameter x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLCallSpec.OracleSQLReturnExternalParameter x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLCollectionTypeDefinition x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLConstantDeclaration x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLConstructorDeclaration x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLConstructorDefinition x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLCoveragePragma x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLCursorDeclaration x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLCursorDefinition x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLDeprecatePragma x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLElementSpec x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLElementSpec.SQLExternalNameClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLElementSpec.SQLExternalVariableNameClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLExceptionDeclaration x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLExceptionHandler x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLExceptionInitPragma x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLExecuteImmediateStatement x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLExternalTableClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLAccessParametersClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLAccessParametersClause.UsingClobClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLFunctionDeclaration x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLFunctionDefinition x) {

        return true;
    }

    @Override
    public boolean visit(OracleSQLFunctionHeading x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLInlinePragma x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLInvokerRightsClause x) {
        return true;
    }


    @Override
    public boolean visit(OracleSQLMapOrderFunctionDeclaration x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLPipelinedByRowClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLPipelinedByTableClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLPipelinedByUsingClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLPipelinedClause x) {
        return true;
    }


    @Override
    public boolean visit(OracleSQLProcedureDeclaration x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLProcedureDefinition x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLProcedureHeading x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLRecordTypeDefinition x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLRefCursorTypeDefinition x) {
        return true;
    }


    @Override
    public boolean visit(OracleSQLReliesOnClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLRestrictReferencesPragma x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLResultCacheClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLSeriallyReusablePragma x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLSubtypeDefinition x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLUDFPragma x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLVarrayStorageClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQSubprogramDeclaration x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLOpaqueTypeColumnProperty x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLVarrayColProperty x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLXmlTypeColumnProperty x) {
        return true;
    }


    // ----------- PL/SQL Language Elements ------------------------------------------------------------


    // ----------- Database Start ------------------------------------------------------------

    // ----------- create ----------------

    @Override
    public boolean visit(OracleSQLUserSysClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLUserSystemClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLLogFileClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLLogFileClause.SQLItem x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLDefaultTablespace x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLDefaultTempTablespace x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLUnDoTablespace x) {
        return true;
    }

    @Override
    public boolean visit(OracleSetTimeZoneClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLUserDataTablespaceClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLEnablePluggableDatabase x) {
        return true;
    }


    @Override
    public boolean visit(OracleSQLExtentManagementLocalClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLExtentManagementLocalAutoAllocateClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLExtentManagementLocalUniformClause x) {
        return true;
    }


    @Override
    public boolean visit(OracleSQLFileNameConvert x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLFileNameConvertNone x) {
        return true;
    }


    @Override
    public boolean visit(OracleSQLTablespaceDataFileClause x) {
        return true;
    }

    // ----------- Database End ------------------------------------------------------------
    @Override
    public boolean visit(OracleSQLConnectToCurrentUserClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLConnectToIdentifiedByClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLDBLinkAuthenticationClause x) {
        return true;
    }
    // ----------- SELECT Start ------------------------------------------------------------

    @Override
    public boolean visit(OracleSQLObjectNameTableTableReference x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLObjectNameTableTableReference.OracleSQLModifiedExternalTableClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLObjectNameTableTableReference.OracleSQLSampleClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLSubQueryTableReference x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLTableFunctionTableReference x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLContainersFunctionTableReference x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLShardsFunctionTableReference x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLInlineAnalyticViewTableReference x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLFlashbackQueryByAsOfClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLFlashbackQueryByAsOfPeriodForClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLFlashbackQueryByVersionsBetweenClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLFlashbackQueryByVersionsPeriodForClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLHierarchiesClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLPivotClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLPivotClause.OracleSQLPivotItem x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLUnPivotClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLSelectQuery x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLSubAvClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLSubAvClause.OracleSQLCalcMeasClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLWaitExpr x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLWithClause x) {
        return true;
    }


    @Override
    public boolean visit(OracleSQLWithClause.OracleSQLSubAvFactoringClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLModelClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLModelClause.OracleSQLCellReferenceOptions x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLModelClause.OracleSQLReferenceModelClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLModelClause.OracleSQLMainModel x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLModelClause.OracleSQLModelColumnClauses x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLModelClause.OracleSQLModelColumnClausesItem x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLModelClause.OracleSQLModelRulesClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLModelClause.OracleSQLModelRulesClauseItem x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLModelClause.OracleSQLModelIterateClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLSingleColumnForLoop x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLSingleColumnForLoop.OracleSQLSingleColumnForLoopInConditionExpr x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLSingleColumnForLoop.OracleSQLSingleColumnForLoopFromToConditionExpr x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLMultiColumnForLoop x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLRowPatternClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLRowPatternClause.OracleSQLRowPatternMeasures x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLRowPatternClause.OracleSQLRowPatternSkipToNextRowOption x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLRowPatternClause.OracleSQLRowPatternSkipPastLastRowOption x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLRowPatternClause.OracleSQLRowPatternSkipToVarOption x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLRowPatternClause.OracleSQLRowPatternSkipToFirstVarOption x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLRowPatternClause.OracleSQLRowPatternSkipToLastVarOption x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLRowPatternClause.OracleSQLRowPatternSubsetClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLRowPatternClause.OracleSQLRowPatternSubsetItem x) {
        return true;
    }
    // ----------- SELECT End ------------------------------------------------------------


    // ----------- Table Start ------------------------------------------------------------
    @Override
    public boolean visit(OracleSQLXmlTypeStorage.OracleSQLXmlTypeStorageAsObjectRelational x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLXmlTypeStorage.OracleSQLXmlTypeStorageAsClob x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLXmlTypeStorage.OracleSQLXmlTypeStorageAsBinaryXml x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLXmlTypeStorage.OracleSQLXmlTypeStorageAsAllVarrays x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLXMLTypeVirtualColumns x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLXMLTypeVirtualColumns.SQLItem x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLAlterTableAddPeriodAction x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLAlterTableDropPeriodAction x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLAlterTableModifyDefaultAttrsAction x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLAlterTableModifyDefaultAttrsAction.SQLForPartition x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLAlterTableModifyDefaultAttrsAction.SQLForPartitionFor x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLAlterTableModifyDefaultAttrsAction.LobItem x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLAlterTableModifyDefaultAttrsAction.VarrayItem x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLAlterTableAddSupplementalLogAction x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLAlterTableDropSupplementalLogAction x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLSupplementalLogGrpClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLSupplementalLogGrpClause.GroupItem x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLSupplementalIdKeyClause x) {
        return true;
    }

    @Override
    public boolean visit(OracleSQLPeriodDefinition x) {
        return true;
    }

    // ----------- Table End ------------------------------------------------------------

// ----------- Oracle End ------------------------------------------------------------


// ----------- PostgreSQL Start ------------------------------------------------------------

    @Override
    public boolean visit(PostgreSQLSQLTypeCastExpr x) {
        return true;
    }

    @Override
    public boolean visit(PostgreSQLSQLPositionVariableExpr x) {
        return true;
    }

// ----------- PostgreSQL End ------------------------------------------------------------


// ----------- MySQL Start ------------------------------------------------------------

    @Override
    public boolean visit(MySQLSQLHelpStatement x) {
        return true;
    }

    // ------------------------- Comment Start ----------------------------------------

    // ------------------------- Comment End ----------------------------------------

    // ------------------------- Hint Start ----------------------------------------
    // ------------------------- Hint End ----------------------------------------


    // ------------------------- Commons Expr Start ----------------------------------------
    @Override
    public boolean visit(MySQLSQLMatchExpr x) {
        return true;
    }


    // ------------------------- Commons Expr End ----------------------------------------


    // ------------------ Details ----------------------


    // ------------------ Select Details Start ----------------------

    @Override
    public boolean visit(MySQLSQLSelectQuery x) {
        return true;
    }

    @Override
    public boolean visit(MySQLSQLSelectQuery.MySQLSQLIntoOutFileClause x) {
        return true;
    }

    @Override
    public boolean visit(MySQLSQLSelectQuery.MySQLSQLIntoDumpFileClause x) {
        return true;
    }

    @Override
    public boolean visit(MySQLSQLSelectQuery.MySQLSQLIntoClause x) {
        return true;
    }

    @Override
    public boolean visit(MySQLSQLOJTableReference x) {
        return true;
    }
    // ------------------ Select Details End ----------------------

// ----------- MySQL End ------------------------------------------------------------


// ----------- DRDS Start ------------------------------------------------------------

    // ------------------ return true;tails Start ----------------------

    @Override
    public boolean visit(DRDSSQLDBPartitionByHash x) {
        return true;
    }

    @Override
    public boolean visit(DRDSSQLDBPartitionByRangeHash x) {
        return true;
    }

    @Override
    public boolean visit(DRDSSQLTBPartitionByHash x) {
        return true;
    }

    @Override
    public boolean visit(DRDSSQLTBPartitionByRangeHash x) {
        return true;
    }

    @Override
    public boolean visit(DRDSSQLTBPartitionByMM x) {
        return true;
    }

    @Override
    public boolean visit(DRDSSQLTBPartitionByDD x) {
        return true;
    }

    @Override
    public boolean visit(DRDSSQLTBPartitionByWeek x) {
        return true;
    }

    @Override
    public boolean visit(DRDSSQLTBPartitionByMMDD x) {
        return true;
    }

    // ------------------ return true;tails End ----------------------
// ----------- DRDS End ------------------------------------------------------------

}
