package com.aliyun.gumiho.sql.dialect.oracle.visitor;

import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
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

/**
 * @author kongtong.ouyang onCondition 2018/2/8.
 */
public interface OracleSQLASTVisitor extends SQLASTVisitor {

    boolean visit(OracleSQLAssignmentStatement x);


    // ------------------------- DataType Start ----------------------------------------
    // ------------------------- DataType End ----------------------------------------

    // ------------------------- Literal Start ----------------------------------------

    // ------------------------- Literal End ----------------------------------------


    // --------------- Common SQL DDL Clauses Start ----------------------------

    boolean visit(OracleSQLAllocateExtentClause x);

    boolean visit(OracleSQLAllocateExtentClause.OracleSQLAllocateExtentSizeClauseItem x);

    boolean visit(OracleSQLAllocateExtentClause.OracleSQLAllocateExtentDataFileClauseItem x);

    boolean visit(OracleSQLAllocateExtentClause.OracleSQLAllocateExtentInstanceClauseItem x);

    boolean visit(OracleSQLDeallocateUnusedClause x);


    boolean visit(OracleSQLDeferredSegmentCreation x);

    boolean visit(OracleSQLDeletingExpr x);

    boolean visit(OracleSQLDependenthandlingClause.OracleSQLInvalidate x);
    boolean visit(OracleSQLDependenthandlingClause.OracleSQLCascade x);


    boolean visit(OracleSQLDataFileTempFileSpec x);

    boolean visit(OracleSQLRedoLogFileSpec x);


    boolean visit(OracleSQLAutoExtendOffClause x);

    boolean visit(OracleSQLAutoExtendOnClause x);


    boolean visit(OracleSQLLoggingClause x);

    boolean visit(OracleSQLNoLoggingClause x);

    boolean visit(OracleSQLFilesystemLikeLogging x);

    boolean visit(OracleSQLPhysicalPropertyOrganizationHeapClause x);

    boolean visit(OracleSQLPhysicalPropertyOrganizationIndexClause x);

    boolean visit(OracleSQLPhysicalPropertyOrganizationExternalClause x);

    boolean visit(OracleSQLPhysicalPropertyClusterClause x);


    boolean visit(OracleSQLHeapOrgTableClause x);

    boolean visit(OracleSQLIndexOrgOverflowClause x);
    boolean visit(IOracleSQLIndexOrgOverflowClause.OracleSQLIncludeClause x);
    boolean visit(IOracleSQLIndexOrgOverflowClause.OracleSQLOverflowExpr x);

    boolean visit(IOracleSQLPhysicalAttributesClause.OracleSQLUsageQueueClause x);

    boolean visit(IOracleSQLPhysicalAttributesClause.OracleSQLPctfreeClause x);

    boolean visit(IOracleSQLPhysicalAttributesClause.OracleSQLPctusedClause x);

    boolean visit(IOracleSQLPhysicalAttributesClause.OracleSQLInitransClause x);

    boolean visit(IOracleSQLPhysicalAttributesClause.OracleSQLMaxTransClause x);


    boolean visit(OracleSQLSizeClause x);

    boolean visit(IOracleSQLSubstitutableColumnClause.OracleSQLSubstitutableColumnIsOFClause x);

    boolean visit(IOracleSQLSubstitutableColumnClause.OracleSQLSubstitutableColumnAtAllLevelsClause x);


    boolean visit(OracleSQLTableCompressionByCompress x);

    boolean visit(OracleSQLTableCompressionByRowStoreCompress x);

    boolean visit(OracleSQLTableCompressionByColumnStoreCompress x);

    boolean visit(OracleSQLTableCompressionByNoCompress x);

    boolean visit(OracleSQLPrefixCompression x);

    boolean visit(OracleSQLPrefixNoCompression x);

    boolean visit(OracleSQLAdvancedIndexCompression x);

    boolean visit(OracleSQLAdvancedIndexNoCompression x);

    boolean visit(OracleSQLInMemoryClause x);

    boolean visit(OracleSQLNoInMemoryClause x);

    boolean visit(OracleSQLInMemoryTableClause x);

    boolean visit(OracleSQLInMemoryAttributes x);

    boolean visit(OracleSQLInMemoryMemCompressClause x);

    boolean visit(OracleSQLInMemoryNoMemCompressClause x);

    boolean visit(OracleSQLInMemoryPriority x);

    boolean visit(OracleSQLInMemoryDistribute x);

    boolean visit(OracleSQLInMemoryDuplicateClause x);

    boolean visit(OracleSQLInMemoryDuplicateAllClause x);

    boolean visit(OracleSQLInMemoryNoDuplicateClause x);

    boolean visit(OracleSQLInMemoryColumnClause x);

    boolean visit(OracleSQLNoInMemoryColumnClause x);

    boolean visit(OracleSQLIlmClauseAddPolicyOption x);

    boolean visit(OracleSQLIlmClauseDeletePolicyOption x);

    boolean visit(OracleSQLIlmClauseEnablePolicyOption x);

    boolean visit(OracleSQLIlmClauseDisablePolicyOption x);

    boolean visit(OracleSQLIlmClauseDeleteAllOption x);

    boolean visit(OracleSQLIlmClauseEnableAllOption x);

    boolean visit(OracleSQLIlmClauseDisableAllOption x);

    boolean visit(IOracleSQLIlmClause.OracleSQLIlmCompressionPolicyByTableCompression x);

    boolean visit(IOracleSQLIlmClause.OracleSQLIlmCompressionPolicyByRowStoreCompression x);

    boolean visit(IOracleSQLIlmClause.OracleSQLIlmCompressionPolicyByColumnStoreCompression x);

    boolean visit(IOracleSQLIlmClause.OracleSQLIlmTieringPolicy x);

    boolean visit(IOracleSQLIlmClause.OracleSQLIlmInMemoryPolicy x);

    boolean visit(IOracleSQLIlmClause.OracleSQLIlmInMemoryPolicyBySetInMemory x);

    boolean visit(IOracleSQLIlmClause.OracleSQLIlmInMemoryPolicyByModifyInMemory x);

    boolean visit(IOracleSQLIlmClause.OracleSQLIlmInMemoryPolicyByNoInMemory x);

    boolean visit(IOracleSQLIlmClause.AfterOfClause x);

    boolean visit(IOracleSQLIlmClause.OnClause x);

    boolean visit(OracleSQLIlmTimePeriod x);


    boolean visit(OracleSQLStorageClause x);

    boolean visit(OracleSQLStorageClause.OracleSQLStorageInitialSizeClause x);

    boolean visit(OracleSQLStorageClause.OracleSQLStorageNextSizeClause x);

    boolean visit(OracleSQLStorageClause.OracleSQLStorageMinExtentsClause x);

    boolean visit(OracleSQLStorageClause.OracleSQLStorageMaxExtentsClause x);

    boolean visit(OracleSQLStorageClause.OracleSQLStoragePctIncreaseClause x);

    boolean visit(OracleSQLStorageClause.OracleSQLStorageFreeListsClause x);

    boolean visit(OracleSQLStorageClause.OracleSQLStorageFreeListGroupsClause x);

    boolean visit(OracleSQLStorageClause.OracleSQLStorageOptimalClause x);

    boolean visit(OracleSQLStorageClause.OracleSQLStorageBufferPoolClause x);

    boolean visit(OracleSQLStorageClause.OracleSQLStorageFlashCacheClause x);

    boolean visit(OracleSQLStorageClause.OracleSQLStorageCellFlashCacheClause x);

    boolean visit(OracleSQLStorageClause.OracleSQLStorageEncryptClause x);


    boolean visit(OracleSQLNestedTableColProperty x);

    boolean visit(OracleSQLNestedTableColProperty.SQLColumnValue x);


    boolean visit(OracleSQLLobStorageClause x);

    boolean visit(OracleSQLLocationClause x);

    boolean visit(OracleSQLLocationClause.LocationItem x);


    boolean visit(OracleSQLLobParameterEnable x);

    boolean visit(OracleSQLLobParameterDisable x);

    boolean visit(OracleSQLLobParameterChunk x);

    boolean visit(OracleSQLLobParameterPctversion x);

    boolean visit(OracleSQLLobParameterRebuildFreepools x);

    boolean visit(OracleSQLLobParameterFreepools x);

    boolean visit(OracleSQLLobParameterEncrypt x);

    boolean visit(OracleSQLLobParameterDecrypt x);

    boolean visit(OracleSQLLobParameterCache x);

    boolean visit(OracleSQLLobParameterNoCache x);

    boolean visit(OracleSQLLobParameterCacheReads x);

    boolean visit(OracleSQLLobRetentionClause x);

    boolean visit(OracleSQLLobDeduplicateClause x);

    boolean visit(OracleSQLLobKeepDuplicatesClause x);


    boolean visit(OracleSQLLobCompressionClause x);

    boolean visit(OracleSQLLobNoCompressionClause x);


    boolean visit(OracleSQLLobPartitionStorage x);

    boolean visit(OracleSQLLobPartitioningStorage x);


    boolean visit(OracleSQLMaxSizeClause x);


    boolean visit(OracleSQLMappingTableClause x);

    boolean visit(OracleSQLNoMappingTableClause x);

    boolean visit(OracleSQLPctthresholdClause x);

    boolean visit(OracleSQLObjectTypeColProperty x);

    boolean visit(OracleSQLVarrayColPropertyColumnProperty x);

    boolean visit(OracleSQLLobStorageClauseColumnProperty x);


    boolean visit(OracleSQLLobStorageParameters x);


    boolean visit(OracleSQLIsOpenImplicitCursorExpr x);

    boolean visit(OracleSQLFoundImplicitCursorExpr x);

    boolean visit(OracleSQLNotFoundImplicitCursorExpr x);

    boolean visit(OracleSQLRowcountImplicitCursorExpr x);

    boolean visit(OracleSQLBulkRowcountImplicitCursorExpr x);

    boolean visit(OracleSQLBulkExceptionsCountImplicitCursorExpr x);

    boolean visit(OracleSQLBulkExceptionImplicitCursorExpr x);

    boolean visit(OracleSQLIsOpenNameCursorExpr x);

    boolean visit(OracleSQLFoundNameCursorExpr x);

    boolean visit(OracleSQLNotFoundNameCursorExpr x);

    boolean visit(OracleSQLRowcountNameCursorExpr x);

    // ----------- Common SQL DDL Clauses End ------------------------------------------------------------


    // ----------- PL/SQL Language Elements Start ------------------------------------------------------------

    boolean visit(OracleParallelEnableByAnyClause x);

    boolean visit(OracleParallelEnableByHashClause x);

    boolean visit(OracleParallelEnableByRangeClause x);

    boolean visit(OracleParallelEnableByValueClause x);

    boolean visit(OracleParallelEnableClause x);

    boolean visit(AbstractOracleSQLParallelEnableClause.OracleSQLStreamingClauseByOrder x);

    boolean visit(AbstractOracleSQLParallelEnableClause.OracleSQLStreamingClusterByCluster x);


    boolean visit(OracleSQLAccessibleByClause x);

    boolean visit(OracleSQLAccessorClause x);

    boolean visit(OracleSQLAggregateClause x);

    boolean visit(OracleSQLAutonomousTransPragma x);


    boolean visit(OracleSQLBlock x);


    boolean visit(OracleSQLCallSpec.OracleSQLJavaDeclaration x);

    boolean visit(OracleSQLCallSpec.OracleSQLCDeclaration x);

    boolean visit(OracleSQLCallSpec.LanguageCNameExpr x);

    boolean visit(OracleSQLCallSpec.LanguageCLibraryExpr x);

    boolean visit(OracleSQLCallSpec.OracleSQLContextExternalParameter x);

    boolean visit(OracleSQLCallSpec.OracleSQLSelfExternalParameter x);

    boolean visit(OracleSQLCallSpec.OracleSQLReturnExternalParameter x);


    boolean visit(OracleSQLCollectionTypeDefinition x);


    boolean visit(OracleSQLConstantDeclaration x);


    boolean visit(OracleSQLConstructorDeclaration x);

    boolean visit(OracleSQLConstructorDefinition x);


    boolean visit(OracleSQLCoveragePragma x);


    boolean visit(OracleSQLCursorDeclaration x);

    boolean visit(OracleSQLCursorDefinition x);


    boolean visit(OracleSQLDeprecatePragma x);


    boolean visit(OracleSQLElementSpec x);

    boolean visit(OracleSQLElementSpec.SQLExternalNameClause x);

    boolean visit(OracleSQLElementSpec.SQLExternalVariableNameClause x);


    boolean visit(OracleSQLExceptionDeclaration x);

    boolean visit(OracleSQLExceptionHandler x);

    boolean visit(OracleSQLExceptionInitPragma x);


    boolean visit(OracleSQLExecuteImmediateStatement x);

    boolean visit(OracleSQLExternalTableClause x);

    boolean visit(OracleSQLAccessParametersClause x);

    boolean visit(OracleSQLAccessParametersClause.UsingClobClause x);


    boolean visit(OracleSQLFunctionDeclaration x);

    boolean visit(OracleSQLFunctionDefinition x);

    boolean visit(OracleSQLFunctionHeading x);

    boolean visit(OracleSQLInlinePragma x);

    boolean visit(OracleSQLInvokerRightsClause x);


    boolean visit(OracleSQLMapOrderFunctionDeclaration x);


    boolean visit(OracleSQLPipelinedByRowClause x);

    boolean visit(OracleSQLPipelinedByTableClause x);

    boolean visit(OracleSQLPipelinedByUsingClause x);

    boolean visit(OracleSQLPipelinedClause x);


    boolean visit(OracleSQLProcedureDeclaration x);

    boolean visit(OracleSQLProcedureDefinition x);

    boolean visit(OracleSQLProcedureHeading x);


    boolean visit(OracleSQLRecordTypeDefinition x);

    boolean visit(OracleSQLRefCursorTypeDefinition x);


    boolean visit(OracleSQLReliesOnClause x);

    boolean visit(OracleSQLRestrictReferencesPragma x);

    boolean visit(OracleSQLResultCacheClause x);

    boolean visit(OracleSQLSeriallyReusablePragma x);


    boolean visit(OracleSQLSubtypeDefinition x);

    boolean visit(OracleSQLUDFPragma x);

    boolean visit(OracleSQLVarrayStorageClause x);

    boolean visit(OracleSQSubprogramDeclaration x);

    boolean visit(OracleSQLOpaqueTypeColumnProperty x);

    boolean visit(OracleSQLVarrayColProperty x);

    boolean visit(OracleSQLXmlTypeColumnProperty x);


    // ----------- PL/SQL Language Elements End ------------------------------------------------------------


    // ----------- Database Start ------------------------------------------------------------

    // ----------- create ----------------

    boolean visit(OracleSQLUserSysClause x);

    boolean visit(OracleSQLUserSystemClause x);

    boolean visit(OracleSQLLogFileClause x);
    boolean visit(OracleSQLLogFileClause.SQLItem x);

    boolean visit(OracleSQLDefaultTablespace x);

    boolean visit(OracleSQLDefaultTempTablespace x);

    boolean visit(OracleSQLUnDoTablespace x);

    boolean visit(OracleSetTimeZoneClause x);

    boolean visit(OracleSQLUserDataTablespaceClause x);

    boolean visit(OracleSQLEnablePluggableDatabase x);


    boolean visit(OracleSQLExtentManagementLocalClause x);

    boolean visit(OracleSQLExtentManagementLocalAutoAllocateClause x);

    boolean visit(OracleSQLExtentManagementLocalUniformClause x);


    boolean visit(OracleSQLFileNameConvert x);

    boolean visit(OracleSQLFileNameConvertNone x);


    boolean visit(OracleSQLTablespaceDataFileClause x);


    // ----------- Database End ------------------------------------------------------------


    // ----------- Database Link Start ------------------------------------------------------------

    boolean visit(OracleSQLConnectToCurrentUserClause x);

    boolean visit(OracleSQLDBLinkAuthenticationClause x);

    boolean visit(OracleSQLConnectToIdentifiedByClause x);

    // ----------- Database Link End ------------------------------------------------------------


    // ----------- SELECT Start ------------------------------------------------------------

    boolean visit(OracleSQLObjectNameTableTableReference x);

    boolean visit(OracleSQLObjectNameTableTableReference.OracleSQLModifiedExternalTableClause x);

    boolean visit(OracleSQLObjectNameTableTableReference.OracleSQLSampleClause x);

    boolean visit(OracleSQLSubQueryTableReference x);

    boolean visit(OracleSQLTableFunctionTableReference x);

    boolean visit(OracleSQLContainersFunctionTableReference x);

    boolean visit(OracleSQLShardsFunctionTableReference x);

    boolean visit(OracleSQLInlineAnalyticViewTableReference x);


    boolean visit(OracleSQLFlashbackQueryByAsOfClause x);

    boolean visit(OracleSQLFlashbackQueryByAsOfPeriodForClause x);

    boolean visit(OracleSQLFlashbackQueryByVersionsBetweenClause x);

    boolean visit(OracleSQLFlashbackQueryByVersionsPeriodForClause x);

    boolean visit(OracleSQLHierarchiesClause x);

    boolean visit(OracleSQLPivotClause x);

    boolean visit(OracleSQLPivotClause.OracleSQLPivotItem x);

    boolean visit(OracleSQLUnPivotClause x);

    boolean visit(OracleSQLSelectQuery x);

    boolean visit(OracleSQLSubAvClause x);

    boolean visit(OracleSQLSubAvClause.OracleSQLCalcMeasClause x);

    boolean visit(OracleSQLWaitExpr x);

    boolean visit(OracleSQLWithClause x);

    boolean visit(OracleSQLWithClause.OracleSQLSubAvFactoringClause x);


    boolean visit(OracleSQLModelClause x);

    boolean visit(OracleSQLModelClause.OracleSQLCellReferenceOptions x);

    boolean visit(OracleSQLModelClause.OracleSQLReferenceModelClause x);

    boolean visit(OracleSQLModelClause.OracleSQLMainModel x);

    boolean visit(OracleSQLModelClause.OracleSQLModelColumnClauses x);

    boolean visit(OracleSQLModelClause.OracleSQLModelColumnClausesItem x);

    boolean visit(OracleSQLModelClause.OracleSQLModelRulesClause x);

    boolean visit(OracleSQLModelClause.OracleSQLModelRulesClauseItem x);

    boolean visit(OracleSQLModelClause.OracleSQLModelIterateClause x);


    boolean visit(OracleSQLSingleColumnForLoop x);

    boolean visit(OracleSQLSingleColumnForLoop.OracleSQLSingleColumnForLoopInConditionExpr x);

    boolean visit(OracleSQLSingleColumnForLoop.OracleSQLSingleColumnForLoopFromToConditionExpr x);

    boolean visit(OracleSQLMultiColumnForLoop x);


    boolean visit(OracleSQLRowPatternClause x);

    boolean visit(OracleSQLRowPatternClause.OracleSQLRowPatternMeasures x);

    boolean visit(OracleSQLRowPatternClause.OracleSQLRowPatternSkipToNextRowOption x);

    boolean visit(OracleSQLRowPatternClause.OracleSQLRowPatternSkipPastLastRowOption x);

    boolean visit(OracleSQLRowPatternClause.OracleSQLRowPatternSkipToVarOption x);

    boolean visit(OracleSQLRowPatternClause.OracleSQLRowPatternSkipToFirstVarOption x);

    boolean visit(OracleSQLRowPatternClause.OracleSQLRowPatternSkipToLastVarOption x);

    boolean visit(OracleSQLRowPatternClause.OracleSQLRowPatternSubsetClause x);

    boolean visit(OracleSQLRowPatternClause.OracleSQLRowPatternSubsetItem x);


    // ----------- SELECT End ------------------------------------------------------------


    // ------------------ Table Details Start ----------------------
    boolean visit(OracleSQLXmlTypeStorage.OracleSQLXmlTypeStorageAsObjectRelational x);
    boolean visit(OracleSQLXmlTypeStorage.OracleSQLXmlTypeStorageAsClob x);
    boolean visit(OracleSQLXmlTypeStorage.OracleSQLXmlTypeStorageAsBinaryXml x);
    boolean visit(OracleSQLXmlTypeStorage.OracleSQLXmlTypeStorageAsAllVarrays x);

    boolean visit(OracleSQLXMLTypeVirtualColumns x);
    boolean visit(OracleSQLXMLTypeVirtualColumns.SQLItem x);


    boolean visit(OracleSQLAlterTableAddPeriodAction x);

    boolean visit(OracleSQLAlterTableDropPeriodAction x);

    boolean visit(OracleSQLAlterTableModifyDefaultAttrsAction x);

    boolean visit(OracleSQLAlterTableModifyDefaultAttrsAction.SQLForPartition x);

    boolean visit(OracleSQLAlterTableModifyDefaultAttrsAction.SQLForPartitionFor x);

    boolean visit(OracleSQLAlterTableModifyDefaultAttrsAction.LobItem x);

    boolean visit(OracleSQLAlterTableModifyDefaultAttrsAction.VarrayItem x);

    boolean visit(OracleSQLAlterTableAddSupplementalLogAction x);

    boolean visit(OracleSQLAlterTableDropSupplementalLogAction x);

    boolean visit(OracleSQLSupplementalLogGrpClause x);

    boolean visit(OracleSQLSupplementalLogGrpClause.GroupItem x);

    boolean visit(OracleSQLSupplementalIdKeyClause x);

    boolean visit(OracleSQLPeriodDefinition x);

    // ------------------ Table Details End ----------------------

}
