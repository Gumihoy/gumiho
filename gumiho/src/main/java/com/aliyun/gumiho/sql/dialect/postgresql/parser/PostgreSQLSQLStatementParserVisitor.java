// Generated from /Users/kongtong.ouyang/IdeaProjects/gumiho/gumiho/src/main/resources/grammars/sql/dialect/postgresql/PostgreSQLSQLStatementParser.g4 by ANTLR 4.7
package com.aliyun.gumiho.sql.dialect.postgresql.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PostgreSQLSQLStatementParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PostgreSQLSQLStatementParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#parse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParse(PostgreSQLSQLStatementParser.ParseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#swallow_to_semi}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwallow_to_semi(PostgreSQLSQLStatementParser.Swallow_to_semiContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#emptyStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyStatement(PostgreSQLSQLStatementParser.EmptyStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(PostgreSQLSQLStatementParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#ddlStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDdlStatement(PostgreSQLSQLStatementParser.DdlStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#dmlStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDmlStatement(PostgreSQLSQLStatementParser.DmlStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#fclStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFclStatement(PostgreSQLSQLStatementParser.FclStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#tclStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTclStatement(PostgreSQLSQLStatementParser.TclStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#sclStatment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSclStatment(PostgreSQLSQLStatementParser.SclStatmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommand(PostgreSQLSQLStatementParser.CommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#createDatabaseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateDatabaseStatement(PostgreSQLSQLStatementParser.CreateDatabaseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#userSysClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUserSysClause(PostgreSQLSQLStatementParser.UserSysClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#userSystemClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUserSystemClause(PostgreSQLSQLStatementParser.UserSystemClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#controlfileReuseClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitControlfileReuseClause(PostgreSQLSQLStatementParser.ControlfileReuseClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#maxdatafilesClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMaxdatafilesClause(PostgreSQLSQLStatementParser.MaxdatafilesClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#maxinstancesClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMaxinstancesClause(PostgreSQLSQLStatementParser.MaxinstancesClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#characterSet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharacterSet(PostgreSQLSQLStatementParser.CharacterSetContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#nationalCharacterSet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNationalCharacterSet(PostgreSQLSQLStatementParser.NationalCharacterSetContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#setDefaultTablespaceClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetDefaultTablespaceClause(PostgreSQLSQLStatementParser.SetDefaultTablespaceClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#extentManagementClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtentManagementClause(PostgreSQLSQLStatementParser.ExtentManagementClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#extentManagementLocalClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtentManagementLocalClause(PostgreSQLSQLStatementParser.ExtentManagementLocalClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#extentManagementLocalAutoAllocateClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtentManagementLocalAutoAllocateClause(PostgreSQLSQLStatementParser.ExtentManagementLocalAutoAllocateClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#extentManagementLocalUniformClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtentManagementLocalUniformClause(PostgreSQLSQLStatementParser.ExtentManagementLocalUniformClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#dataFileClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataFileClause(PostgreSQLSQLStatementParser.DataFileClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#sysauxClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSysauxClause(PostgreSQLSQLStatementParser.SysauxClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#defaultTablespace}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultTablespace(PostgreSQLSQLStatementParser.DefaultTablespaceContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#defaultTempTablespace}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultTempTablespace(PostgreSQLSQLStatementParser.DefaultTempTablespaceContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#undoTablespace}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUndoTablespace(PostgreSQLSQLStatementParser.UndoTablespaceContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#setTimeZoneClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetTimeZoneClause(PostgreSQLSQLStatementParser.SetTimeZoneClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#userDataTablespaceClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUserDataTablespaceClause(PostgreSQLSQLStatementParser.UserDataTablespaceClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#enablePluggableDatabase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnablePluggableDatabase(PostgreSQLSQLStatementParser.EnablePluggableDatabaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#fileNameConvert}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFileNameConvert(PostgreSQLSQLStatementParser.FileNameConvertContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#fileNameConvertFile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFileNameConvertFile(PostgreSQLSQLStatementParser.FileNameConvertFileContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#fileNameConvertNone}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFileNameConvertNone(PostgreSQLSQLStatementParser.FileNameConvertNoneContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#tablespaceDatafileClauses}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTablespaceDatafileClauses(PostgreSQLSQLStatementParser.TablespaceDatafileClausesContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#databaseLogFileClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDatabaseLogFileClause(PostgreSQLSQLStatementParser.DatabaseLogFileClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#databaseMaxLogFilesClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDatabaseMaxLogFilesClause(PostgreSQLSQLStatementParser.DatabaseMaxLogFilesClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#databaseMaxLogMembersClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDatabaseMaxLogMembersClause(PostgreSQLSQLStatementParser.DatabaseMaxLogMembersClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#databaseMaxLogHistoryClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDatabaseMaxLogHistoryClause(PostgreSQLSQLStatementParser.DatabaseMaxLogHistoryClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#databaseArchiveLogTypeClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDatabaseArchiveLogTypeClause(PostgreSQLSQLStatementParser.DatabaseArchiveLogTypeClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#databaseForceLoggingClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDatabaseForceLoggingClause(PostgreSQLSQLStatementParser.DatabaseForceLoggingClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#createDatabaseLinkStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateDatabaseLinkStatement(PostgreSQLSQLStatementParser.CreateDatabaseLinkStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#connectToCurrentUser}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConnectToCurrentUser(PostgreSQLSQLStatementParser.ConnectToCurrentUserContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#connectToIdentifiedBy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConnectToIdentifiedBy(PostgreSQLSQLStatementParser.ConnectToIdentifiedByContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#dblinkAuthentication}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDblinkAuthentication(PostgreSQLSQLStatementParser.DblinkAuthenticationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#dblinkUsing}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDblinkUsing(PostgreSQLSQLStatementParser.DblinkUsingContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#createFunctionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateFunctionStatement(PostgreSQLSQLStatementParser.CreateFunctionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterFunctionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterFunctionStatement(PostgreSQLSQLStatementParser.AlterFunctionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#dropFunctionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropFunctionStatement(PostgreSQLSQLStatementParser.DropFunctionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#functionOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionOption(PostgreSQLSQLStatementParser.FunctionOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterFunctionOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterFunctionOption(PostgreSQLSQLStatementParser.AlterFunctionOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#createIndexStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateIndexStatement(PostgreSQLSQLStatementParser.CreateIndexStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterIndexStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexStatement(PostgreSQLSQLStatementParser.AlterIndexStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#dropIndexStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropIndexStatement(PostgreSQLSQLStatementParser.DropIndexStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#createIndexStatementColumn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateIndexStatementColumn(PostgreSQLSQLStatementParser.CreateIndexStatementColumnContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#createIndexStatementOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateIndexStatementOption(PostgreSQLSQLStatementParser.CreateIndexStatementOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#indexProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexProperty(PostgreSQLSQLStatementParser.IndexPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#indexTypeIsIndexTypeClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexTypeIsIndexTypeClause(PostgreSQLSQLStatementParser.IndexTypeIsIndexTypeClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#indexAttribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexAttribute(PostgreSQLSQLStatementParser.IndexAttributeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#indexAttributeOnline}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexAttributeOnline(PostgreSQLSQLStatementParser.IndexAttributeOnlineContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#indexAttributeComputeStatistics}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexAttributeComputeStatistics(PostgreSQLSQLStatementParser.IndexAttributeComputeStatisticsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#indexAttributeSort}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexAttributeSort(PostgreSQLSQLStatementParser.IndexAttributeSortContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#indexAttributeNoSort}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexAttributeNoSort(PostgreSQLSQLStatementParser.IndexAttributeNoSortContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#indexAttributeReverse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexAttributeReverse(PostgreSQLSQLStatementParser.IndexAttributeReverseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#indexAttributeVisible}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexAttributeVisible(PostgreSQLSQLStatementParser.IndexAttributeVisibleContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#indexAttributeInvisible}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexAttributeInvisible(PostgreSQLSQLStatementParser.IndexAttributeInvisibleContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#partialIndexClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartialIndexClause(PostgreSQLSQLStatementParser.PartialIndexClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#parametersClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametersClause(PostgreSQLSQLStatementParser.ParametersClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code globalPartitionByRange}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iGlobalPartitionBy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobalPartitionByRange(PostgreSQLSQLStatementParser.GlobalPartitionByRangeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code globalPartitionByHash}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iGlobalPartitionBy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobalPartitionByHash(PostgreSQLSQLStatementParser.GlobalPartitionByHashContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#localPartitionIndex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalPartitionIndex(PostgreSQLSQLStatementParser.LocalPartitionIndexContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterIndexStatementOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexStatementOption(PostgreSQLSQLStatementParser.AlterIndexStatementOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterIndexStatementProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexStatementProperty(PostgreSQLSQLStatementParser.AlterIndexStatementPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#shrinkClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShrinkClause(PostgreSQLSQLStatementParser.ShrinkClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#rebuildClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRebuildClause(PostgreSQLSQLStatementParser.RebuildClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterIndexCompileOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexCompileOption(PostgreSQLSQLStatementParser.AlterIndexCompileOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterIndexEnableOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexEnableOption(PostgreSQLSQLStatementParser.AlterIndexEnableOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterIndexDisableOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexDisableOption(PostgreSQLSQLStatementParser.AlterIndexDisableOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterIndexUnusableOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexUnusableOption(PostgreSQLSQLStatementParser.AlterIndexUnusableOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterIndexVisibleOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexVisibleOption(PostgreSQLSQLStatementParser.AlterIndexVisibleOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterIndexInvisibleOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexInvisibleOption(PostgreSQLSQLStatementParser.AlterIndexInvisibleOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterIndexMonitoringUsageOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexMonitoringUsageOption(PostgreSQLSQLStatementParser.AlterIndexMonitoringUsageOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterIndexCoalesceOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexCoalesceOption(PostgreSQLSQLStatementParser.AlterIndexCoalesceOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterIndexNoMonitoringUsageOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexNoMonitoringUsageOption(PostgreSQLSQLStatementParser.AlterIndexNoMonitoringUsageOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterIndexUpdateBlockReferencesOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexUpdateBlockReferencesOption(PostgreSQLSQLStatementParser.AlterIndexUpdateBlockReferencesOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterIndexPartitioning}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexPartitioning(PostgreSQLSQLStatementParser.AlterIndexPartitioningContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterIndexModifyDefaultAttrsAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexModifyDefaultAttrsAction(PostgreSQLSQLStatementParser.AlterIndexModifyDefaultAttrsActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#modifyDefaultAttrItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModifyDefaultAttrItem(PostgreSQLSQLStatementParser.ModifyDefaultAttrItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterIndexAddPartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexAddPartitionAction(PostgreSQLSQLStatementParser.AlterIndexAddPartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterIndexCoalescePartition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexCoalescePartition(PostgreSQLSQLStatementParser.AlterIndexCoalescePartitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterIndexModifyPartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexModifyPartitionAction(PostgreSQLSQLStatementParser.AlterIndexModifyPartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterIndexRenamePartition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexRenamePartition(PostgreSQLSQLStatementParser.AlterIndexRenamePartitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterIndexRenameSubPartition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexRenameSubPartition(PostgreSQLSQLStatementParser.AlterIndexRenameSubPartitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterIndexDropPartition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexDropPartition(PostgreSQLSQLStatementParser.AlterIndexDropPartitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterIndexSplitPartition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexSplitPartition(PostgreSQLSQLStatementParser.AlterIndexSplitPartitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterIndexModifySubpartition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexModifySubpartition(PostgreSQLSQLStatementParser.AlterIndexModifySubpartitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterIndexModifySubpartitionOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexModifySubpartitionOption(PostgreSQLSQLStatementParser.AlterIndexModifySubpartitionOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#modifySubpartitionUnusableOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModifySubpartitionUnusableOption(PostgreSQLSQLStatementParser.ModifySubpartitionUnusableOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#createPackageStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreatePackageStatement(PostgreSQLSQLStatementParser.CreatePackageStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterPackageStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterPackageStatement(PostgreSQLSQLStatementParser.AlterPackageStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#dropPackageStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropPackageStatement(PostgreSQLSQLStatementParser.DropPackageStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#createPackageBodyStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreatePackageBodyStatement(PostgreSQLSQLStatementParser.CreatePackageBodyStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#dropPackageBodyStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropPackageBodyStatement(PostgreSQLSQLStatementParser.DropPackageBodyStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#createPackageStatementOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreatePackageStatementOption(PostgreSQLSQLStatementParser.CreatePackageStatementOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#createPackageStatementItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreatePackageStatementItem(PostgreSQLSQLStatementParser.CreatePackageStatementItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#createPackageBodyStatementItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreatePackageBodyStatementItem(PostgreSQLSQLStatementParser.CreatePackageBodyStatementItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterPackageStatementOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterPackageStatementOption(PostgreSQLSQLStatementParser.AlterPackageStatementOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#createProcedureStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateProcedureStatement(PostgreSQLSQLStatementParser.CreateProcedureStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterProcedureStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterProcedureStatement(PostgreSQLSQLStatementParser.AlterProcedureStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#dropProcedureStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropProcedureStatement(PostgreSQLSQLStatementParser.DropProcedureStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#createProcedureStatementOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateProcedureStatementOption(PostgreSQLSQLStatementParser.CreateProcedureStatementOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterProcedureStatementOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterProcedureStatementOption(PostgreSQLSQLStatementParser.AlterProcedureStatementOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#createSequenceStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateSequenceStatement(PostgreSQLSQLStatementParser.CreateSequenceStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterSequenceStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterSequenceStatement(PostgreSQLSQLStatementParser.AlterSequenceStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#dropSequenceStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropSequenceStatement(PostgreSQLSQLStatementParser.DropSequenceStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#createSequenceOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateSequenceOption(PostgreSQLSQLStatementParser.CreateSequenceOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterSequenceOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterSequenceOption(PostgreSQLSQLStatementParser.AlterSequenceOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#startWithSequenceOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStartWithSequenceOption(PostgreSQLSQLStatementParser.StartWithSequenceOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#incrementBySequenceOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncrementBySequenceOption(PostgreSQLSQLStatementParser.IncrementBySequenceOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#maxValueSequenceOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMaxValueSequenceOption(PostgreSQLSQLStatementParser.MaxValueSequenceOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#noMaxValueSequenceOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoMaxValueSequenceOption(PostgreSQLSQLStatementParser.NoMaxValueSequenceOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#minValueSequenceOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinValueSequenceOption(PostgreSQLSQLStatementParser.MinValueSequenceOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#noMinValueSequenceOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoMinValueSequenceOption(PostgreSQLSQLStatementParser.NoMinValueSequenceOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#cycleSequenceOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCycleSequenceOption(PostgreSQLSQLStatementParser.CycleSequenceOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#noCycleSequenceOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoCycleSequenceOption(PostgreSQLSQLStatementParser.NoCycleSequenceOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#cacheSequenceOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCacheSequenceOption(PostgreSQLSQLStatementParser.CacheSequenceOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#noCacheSequenceOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoCacheSequenceOption(PostgreSQLSQLStatementParser.NoCacheSequenceOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#orderSequenceOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrderSequenceOption(PostgreSQLSQLStatementParser.OrderSequenceOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#noOrderSequenceOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoOrderSequenceOption(PostgreSQLSQLStatementParser.NoOrderSequenceOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#keepSequenceOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeepSequenceOption(PostgreSQLSQLStatementParser.KeepSequenceOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#noKeepSequenceOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoKeepSequenceOption(PostgreSQLSQLStatementParser.NoKeepSequenceOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#scaleOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScaleOption(PostgreSQLSQLStatementParser.ScaleOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#noScaleOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoScaleOption(PostgreSQLSQLStatementParser.NoScaleOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#sessionSequenceOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSessionSequenceOption(PostgreSQLSQLStatementParser.SessionSequenceOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#globalSequenceOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobalSequenceOption(PostgreSQLSQLStatementParser.GlobalSequenceOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#createSynonymStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateSynonymStatement(PostgreSQLSQLStatementParser.CreateSynonymStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterSynonymStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterSynonymStatement(PostgreSQLSQLStatementParser.AlterSynonymStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#dropSynonymStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropSynonymStatement(PostgreSQLSQLStatementParser.DropSynonymStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#createTableStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTableStatement(PostgreSQLSQLStatementParser.CreateTableStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterTableStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableStatement(PostgreSQLSQLStatementParser.AlterTableStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#dropTableStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropTableStatement(PostgreSQLSQLStatementParser.DropTableStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#tableScope}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableScope(PostgreSQLSQLStatementParser.TableScopeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#tableElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableElement(PostgreSQLSQLStatementParser.TableElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#iColumnDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIColumnDefinition(PostgreSQLSQLStatementParser.IColumnDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#memoptimizeForRead}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemoptimizeForRead(PostgreSQLSQLStatementParser.MemoptimizeForReadContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#columnDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnDefinition(PostgreSQLSQLStatementParser.ColumnDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#identityClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentityClause(PostgreSQLSQLStatementParser.IdentityClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#onNull}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOnNull(PostgreSQLSQLStatementParser.OnNullContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#identityOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentityOption(PostgreSQLSQLStatementParser.IdentityOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#identityStartWithOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentityStartWithOption(PostgreSQLSQLStatementParser.IdentityStartWithOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#identityIncrementByOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentityIncrementByOption(PostgreSQLSQLStatementParser.IdentityIncrementByOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#identityMaxValueOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentityMaxValueOption(PostgreSQLSQLStatementParser.IdentityMaxValueOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#identityNoMaxValueOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentityNoMaxValueOption(PostgreSQLSQLStatementParser.IdentityNoMaxValueOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#identityMinValueOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentityMinValueOption(PostgreSQLSQLStatementParser.IdentityMinValueOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#identityNoMinValueOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentityNoMinValueOption(PostgreSQLSQLStatementParser.IdentityNoMinValueOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#identityCycleOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentityCycleOption(PostgreSQLSQLStatementParser.IdentityCycleOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#identityNoCycleOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentityNoCycleOption(PostgreSQLSQLStatementParser.IdentityNoCycleOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#identityCacheOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentityCacheOption(PostgreSQLSQLStatementParser.IdentityCacheOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#identityNoCacheOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentityNoCacheOption(PostgreSQLSQLStatementParser.IdentityNoCacheOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#identityOrderOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentityOrderOption(PostgreSQLSQLStatementParser.IdentityOrderOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#identityNoOrderOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentityNoOrderOption(PostgreSQLSQLStatementParser.IdentityNoOrderOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#virtualColumnDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVirtualColumnDefinition(PostgreSQLSQLStatementParser.VirtualColumnDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#evaluationEditionClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEvaluationEditionClause(PostgreSQLSQLStatementParser.EvaluationEditionClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code evaluationEditionCurrentEditionAction}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#evaluationEditionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEvaluationEditionCurrentEditionAction(PostgreSQLSQLStatementParser.EvaluationEditionCurrentEditionActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code evaluationEditionEditionAction}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#evaluationEditionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEvaluationEditionEditionAction(PostgreSQLSQLStatementParser.EvaluationEditionEditionActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code evaluationEditionNullEditionAction}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#evaluationEditionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEvaluationEditionNullEditionAction(PostgreSQLSQLStatementParser.EvaluationEditionNullEditionActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#unusableEditionsClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnusableEditionsClause(PostgreSQLSQLStatementParser.UnusableEditionsClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unusableBeforeCurrentEditionAction}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#unusableBeforeAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnusableBeforeCurrentEditionAction(PostgreSQLSQLStatementParser.UnusableBeforeCurrentEditionActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unusableBeforeEditionAction}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#unusableBeforeAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnusableBeforeEditionAction(PostgreSQLSQLStatementParser.UnusableBeforeEditionActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unusableBeginningWithCurrentEditionAction}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#unusableBeginningWithAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnusableBeginningWithCurrentEditionAction(PostgreSQLSQLStatementParser.UnusableBeginningWithCurrentEditionActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unusableBeginningWithEditionAction}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#unusableBeginningWithAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnusableBeginningWithEditionAction(PostgreSQLSQLStatementParser.UnusableBeginningWithEditionActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unusableBeginningWithNullEditionAction}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#unusableBeginningWithAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnusableBeginningWithNullEditionAction(PostgreSQLSQLStatementParser.UnusableBeginningWithNullEditionActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#periodDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPeriodDefinition(PostgreSQLSQLStatementParser.PeriodDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#encryptClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEncryptClause(PostgreSQLSQLStatementParser.EncryptClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#encryptionSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEncryptionSpec(PostgreSQLSQLStatementParser.EncryptionSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#objectTableSubstitution}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectTableSubstitution(PostgreSQLSQLStatementParser.ObjectTableSubstitutionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#objectProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectProperty(PostgreSQLSQLStatementParser.ObjectPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#commitActionDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommitActionDefinition(PostgreSQLSQLStatementParser.CommitActionDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#commitActionRows}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommitActionRows(PostgreSQLSQLStatementParser.CommitActionRowsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#oidClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOidClause(PostgreSQLSQLStatementParser.OidClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#oidIndexClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOidIndexClause(PostgreSQLSQLStatementParser.OidIndexClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#oidIndexClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOidIndexClauseItem(PostgreSQLSQLStatementParser.OidIndexClauseItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#heapOrgTableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHeapOrgTableClause(PostgreSQLSQLStatementParser.HeapOrgTableClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#indexOrgTableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexOrgTableClause(PostgreSQLSQLStatementParser.IndexOrgTableClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#indexOrgTableClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexOrgTableClauseItem(PostgreSQLSQLStatementParser.IndexOrgTableClauseItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#pctthresholdClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPctthresholdClause(PostgreSQLSQLStatementParser.PctthresholdClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mappingTableClause}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iMappingTableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMappingTableClause(PostgreSQLSQLStatementParser.MappingTableClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code noMappingTableClause}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iMappingTableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoMappingTableClause(PostgreSQLSQLStatementParser.NoMappingTableClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#indexCompression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexCompression(PostgreSQLSQLStatementParser.IndexCompressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code prefixCompression}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iPrefixCompression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixCompression(PostgreSQLSQLStatementParser.PrefixCompressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code prefixNoCompression}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iPrefixCompression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixNoCompression(PostgreSQLSQLStatementParser.PrefixNoCompressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code advancedIndexCompression}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iAdvancedIndexCompression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdvancedIndexCompression(PostgreSQLSQLStatementParser.AdvancedIndexCompressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code advancedIndexNoCompression}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iAdvancedIndexCompression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdvancedIndexNoCompression(PostgreSQLSQLStatementParser.AdvancedIndexNoCompressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#indexOrgOverflowClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexOrgOverflowClause(PostgreSQLSQLStatementParser.IndexOrgOverflowClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code supplementalLogGrpClause}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iSupplementalLog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSupplementalLogGrpClause(PostgreSQLSQLStatementParser.SupplementalLogGrpClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code supplementalIdKeyClause}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iSupplementalLog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSupplementalIdKeyClause(PostgreSQLSQLStatementParser.SupplementalIdKeyClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#supplementalLogGrpClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSupplementalLogGrpClauseItem(PostgreSQLSQLStatementParser.SupplementalLogGrpClauseItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#supplementalIdKeyClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSupplementalIdKeyClauseItem(PostgreSQLSQLStatementParser.SupplementalIdKeyClauseItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#columnProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnProperty(PostgreSQLSQLStatementParser.ColumnPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#opaqueTypeColumnProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpaqueTypeColumnProperty(PostgreSQLSQLStatementParser.OpaqueTypeColumnPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#vArrayColPropertyColumnProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVArrayColPropertyColumnProperty(PostgreSQLSQLStatementParser.VArrayColPropertyColumnPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#lobStorageClauseColumnProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobStorageClauseColumnProperty(PostgreSQLSQLStatementParser.LobStorageClauseColumnPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#objectTypeColProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectTypeColProperty(PostgreSQLSQLStatementParser.ObjectTypeColPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#buildClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuildClause(PostgreSQLSQLStatementParser.BuildClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#attributeClusteringClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributeClusteringClause(PostgreSQLSQLStatementParser.AttributeClusteringClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#clusteringJoin}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClusteringJoin(PostgreSQLSQLStatementParser.ClusteringJoinContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#clusteringJoinItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClusteringJoinItem(PostgreSQLSQLStatementParser.ClusteringJoinItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#clusterClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClusterClause(PostgreSQLSQLStatementParser.ClusterClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#clusteringWhen}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClusteringWhen(PostgreSQLSQLStatementParser.ClusteringWhenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code withMaterializedZonemapClause}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#zonemapClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithMaterializedZonemapClause(PostgreSQLSQLStatementParser.WithMaterializedZonemapClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code withoutMaterializedZonemapClause}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#zonemapClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithoutMaterializedZonemapClause(PostgreSQLSQLStatementParser.WithoutMaterializedZonemapClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#memoptimizeReadClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemoptimizeReadClause(PostgreSQLSQLStatementParser.MemoptimizeReadClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableItem(PostgreSQLSQLStatementParser.AlterTableItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterTableEnableDisable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableEnableDisable(PostgreSQLSQLStatementParser.AlterTableEnableDisableContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterTableProerty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableProerty(PostgreSQLSQLStatementParser.AlterTableProertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterTableReadOnlyAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableReadOnlyAction(PostgreSQLSQLStatementParser.AlterTableReadOnlyActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterTableReadWriteAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableReadWriteAction(PostgreSQLSQLStatementParser.AlterTableReadWriteActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableAddSupplementalLoggingAction}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iAlterTableSupplementalLoggingAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableAddSupplementalLoggingAction(PostgreSQLSQLStatementParser.AlterTableAddSupplementalLoggingActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code iAlterTableDropSupplementalLoggingAction}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iAlterTableSupplementalLoggingAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIAlterTableDropSupplementalLoggingAction(PostgreSQLSQLStatementParser.IAlterTableDropSupplementalLoggingActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterTableUpgradeTableAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableUpgradeTableAction(PostgreSQLSQLStatementParser.AlterTableUpgradeTableActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#records_per_block_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecords_per_block_clause(PostgreSQLSQLStatementParser.Records_per_block_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#rowMovementClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowMovementClause(PostgreSQLSQLStatementParser.RowMovementClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterTalbeRenameTableAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTalbeRenameTableAction(PostgreSQLSQLStatementParser.AlterTalbeRenameTableActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterIotClauses}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIotClauses(PostgreSQLSQLStatementParser.AlterIotClausesContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#iAlterOverflowClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIAlterOverflowClause(PostgreSQLSQLStatementParser.IAlterOverflowClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterOverflowClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterOverflowClause(PostgreSQLSQLStatementParser.AlterOverflowClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterOverflowClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterOverflowClauseItem(PostgreSQLSQLStatementParser.AlterOverflowClauseItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#addOverflowClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddOverflowClause(PostgreSQLSQLStatementParser.AddOverflowClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterMappingTableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterMappingTableClause(PostgreSQLSQLStatementParser.AlterMappingTableClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterMappingTableClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterMappingTableClauseItem(PostgreSQLSQLStatementParser.AlterMappingTableClauseItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterTableColumnAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableColumnAction(PostgreSQLSQLStatementParser.AlterTableColumnActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterTableAddColumnAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableAddColumnAction(PostgreSQLSQLStatementParser.AlterTableAddColumnActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterTableModifyColumnAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableModifyColumnAction(PostgreSQLSQLStatementParser.AlterTableModifyColumnActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#modifyColSubstitutable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModifyColSubstitutable(PostgreSQLSQLStatementParser.ModifyColSubstitutableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableSetUnusedColumnAction}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iAlterTableDropColumnAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableSetUnusedColumnAction(PostgreSQLSQLStatementParser.AlterTableSetUnusedColumnActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableDropColumnAction}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iAlterTableDropColumnAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableDropColumnAction(PostgreSQLSQLStatementParser.AlterTableDropColumnActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableDropUnusedColumnsAction}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iAlterTableDropColumnAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableDropUnusedColumnsAction(PostgreSQLSQLStatementParser.AlterTableDropUnusedColumnsActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableDropColumnsContinueAction}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iAlterTableDropColumnAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableDropColumnsContinueAction(PostgreSQLSQLStatementParser.AlterTableDropColumnsContinueActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#iAlterTableDropColumnActionOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIAlterTableDropColumnActionOption(PostgreSQLSQLStatementParser.IAlterTableDropColumnActionOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterTableDropPeriodAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableDropPeriodAction(PostgreSQLSQLStatementParser.AlterTableDropPeriodActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterTableRenameColumnAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableRenameColumnAction(PostgreSQLSQLStatementParser.AlterTableRenameColumnActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterTalbeModifyCollectionRetrievalAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTalbeModifyCollectionRetrievalAction(PostgreSQLSQLStatementParser.AlterTalbeModifyCollectionRetrievalActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterTableModifyLobStorageAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableModifyLobStorageAction(PostgreSQLSQLStatementParser.AlterTableModifyLobStorageActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#modifyLobParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModifyLobParameter(PostgreSQLSQLStatementParser.ModifyLobParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterTableAlterVarrayColPropertyAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableAlterVarrayColPropertyAction(PostgreSQLSQLStatementParser.AlterTableAlterVarrayColPropertyActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableAddTableConstraintAction}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iAlterTableConstraintAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableAddTableConstraintAction(PostgreSQLSQLStatementParser.AlterTableAddTableConstraintActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableModifyTableConstraintAction}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iAlterTableConstraintAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableModifyTableConstraintAction(PostgreSQLSQLStatementParser.AlterTableModifyTableConstraintActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableModifyPrimaryKeyConstraintAction}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iAlterTableConstraintAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableModifyPrimaryKeyConstraintAction(PostgreSQLSQLStatementParser.AlterTableModifyPrimaryKeyConstraintActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableModifyUniqueConstraintAction}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iAlterTableConstraintAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableModifyUniqueConstraintAction(PostgreSQLSQLStatementParser.AlterTableModifyUniqueConstraintActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableRenameTableConstraintAction}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iAlterTableConstraintAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableRenameTableConstraintAction(PostgreSQLSQLStatementParser.AlterTableRenameTableConstraintActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableDropPrimaryKeyConstraintAction}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iAlterTableConstraintAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableDropPrimaryKeyConstraintAction(PostgreSQLSQLStatementParser.AlterTableDropPrimaryKeyConstraintActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableDropUniqueConstraintAction}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iAlterTableConstraintAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableDropUniqueConstraintAction(PostgreSQLSQLStatementParser.AlterTableDropUniqueConstraintActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableDropTableConstraintAction}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iAlterTableConstraintAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableDropTableConstraintAction(PostgreSQLSQLStatementParser.AlterTableDropTableConstraintActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterXmlSchemaClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterXmlSchemaClause(PostgreSQLSQLStatementParser.AlterXmlSchemaClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#iAlterTablePartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIAlterTablePartitionAction(PostgreSQLSQLStatementParser.IAlterTablePartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterTablePartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTablePartitionAction(PostgreSQLSQLStatementParser.AlterTablePartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterTablePartitionActionForItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTablePartitionActionForItem(PostgreSQLSQLStatementParser.AlterTablePartitionActionForItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterTableModifyDefaultAttrsAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableModifyDefaultAttrsAction(PostgreSQLSQLStatementParser.AlterTableModifyDefaultAttrsActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forPartition}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iForPartition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForPartition(PostgreSQLSQLStatementParser.ForPartitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forPartitionFor}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iForPartition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForPartitionFor(PostgreSQLSQLStatementParser.ForPartitionForContext ctx);
	/**
	 * Visit a parse tree produced by the {@code modifyTableDefaultAttrsActionLobItem}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#modifyTableDefaultAttrsActionItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModifyTableDefaultAttrsActionLobItem(PostgreSQLSQLStatementParser.ModifyTableDefaultAttrsActionLobItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code modifyTableDefaultAttrsActionVarrayItem}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#modifyTableDefaultAttrsActionItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModifyTableDefaultAttrsActionVarrayItem(PostgreSQLSQLStatementParser.ModifyTableDefaultAttrsActionVarrayItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterTableSetPartitioningAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableSetPartitioningAction(PostgreSQLSQLStatementParser.AlterTableSetPartitioningActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterTableSetStoreInAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableSetStoreInAction(PostgreSQLSQLStatementParser.AlterTableSetStoreInActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterTableSetIntervalAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableSetIntervalAction(PostgreSQLSQLStatementParser.AlterTableSetIntervalActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterTableSetSubpartitionTemplateAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableSetSubpartitionTemplateAction(PostgreSQLSQLStatementParser.AlterTableSetSubpartitionTemplateActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterTableModifyPartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableModifyPartitionAction(PostgreSQLSQLStatementParser.AlterTableModifyPartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterTableModifyPartitionForAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableModifyPartitionForAction(PostgreSQLSQLStatementParser.AlterTableModifyPartitionForActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterTableModifySubPartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableModifySubPartitionAction(PostgreSQLSQLStatementParser.AlterTableModifySubPartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterTableModifySubPartitionForAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableModifySubPartitionForAction(PostgreSQLSQLStatementParser.AlterTableModifySubPartitionForActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterTableMovePartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableMovePartitionAction(PostgreSQLSQLStatementParser.AlterTableMovePartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterTableMovePartitionForAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableMovePartitionForAction(PostgreSQLSQLStatementParser.AlterTableMovePartitionForActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#filterCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilterCondition(PostgreSQLSQLStatementParser.FilterConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#allowDisallowClustering}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAllowDisallowClustering(PostgreSQLSQLStatementParser.AllowDisallowClusteringContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterTablemoveSubpartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTablemoveSubpartitionAction(PostgreSQLSQLStatementParser.AlterTablemoveSubpartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterTablemoveSubpartitionForAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTablemoveSubpartitionForAction(PostgreSQLSQLStatementParser.AlterTablemoveSubpartitionForActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterTableAddPartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableAddPartitionAction(PostgreSQLSQLStatementParser.AlterTableAddPartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterTableAddSubPartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableAddSubPartitionAction(PostgreSQLSQLStatementParser.AlterTableAddSubPartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#dependentTablesClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDependentTablesClause(PostgreSQLSQLStatementParser.DependentTablesClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#dependentTablesClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDependentTablesClauseItem(PostgreSQLSQLStatementParser.DependentTablesClauseItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterTableCoalesceTablePartition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableCoalesceTablePartition(PostgreSQLSQLStatementParser.AlterTableCoalesceTablePartitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterTableCoalesceTableSubpartition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableCoalesceTableSubpartition(PostgreSQLSQLStatementParser.AlterTableCoalesceTableSubpartitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterTableDropPartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableDropPartitionAction(PostgreSQLSQLStatementParser.AlterTableDropPartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#dropPartitionActionItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropPartitionActionItem(PostgreSQLSQLStatementParser.DropPartitionActionItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterTableDropSubpartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableDropSubpartitionAction(PostgreSQLSQLStatementParser.AlterTableDropSubpartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#dropSubpartitionActionItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropSubpartitionActionItem(PostgreSQLSQLStatementParser.DropSubpartitionActionItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterTableRenamePartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableRenamePartitionAction(PostgreSQLSQLStatementParser.AlterTableRenamePartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterTableRenamePartitionForAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableRenamePartitionForAction(PostgreSQLSQLStatementParser.AlterTableRenamePartitionForActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterTableRenameSubPartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableRenameSubPartitionAction(PostgreSQLSQLStatementParser.AlterTableRenameSubPartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterTableRenameSubPartitionForAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableRenameSubPartitionForAction(PostgreSQLSQLStatementParser.AlterTableRenameSubPartitionForActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterTableTruncatePartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableTruncatePartitionAction(PostgreSQLSQLStatementParser.AlterTableTruncatePartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterTableTruncateSubPartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableTruncateSubPartitionAction(PostgreSQLSQLStatementParser.AlterTableTruncateSubPartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterTablePartitionItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTablePartitionItem(PostgreSQLSQLStatementParser.AlterTablePartitionItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableSplitPartitionaAtAction}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iAlterTableSplitPartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableSplitPartitionaAtAction(PostgreSQLSQLStatementParser.AlterTableSplitPartitionaAtActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableSplitPartitionaValuesAction}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iAlterTableSplitPartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableSplitPartitionaValuesAction(PostgreSQLSQLStatementParser.AlterTableSplitPartitionaValuesActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableSplitPartitionaIntoAction}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iAlterTableSplitPartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableSplitPartitionaIntoAction(PostgreSQLSQLStatementParser.AlterTableSplitPartitionaIntoActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableSplitPartitionaForAtAction}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iAlterTableSplitPartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableSplitPartitionaForAtAction(PostgreSQLSQLStatementParser.AlterTableSplitPartitionaForAtActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableSplitPartitionaForValuesAction}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iAlterTableSplitPartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableSplitPartitionaForValuesAction(PostgreSQLSQLStatementParser.AlterTableSplitPartitionaForValuesActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableSplitPartitionaForIntoAction}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iAlterTableSplitPartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableSplitPartitionaForIntoAction(PostgreSQLSQLStatementParser.AlterTableSplitPartitionaForIntoActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#splitNestedTablePart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSplitNestedTablePart(PostgreSQLSQLStatementParser.SplitNestedTablePartContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableSplitSubPartitionaAtAction}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iAlterTableSubSplitPartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableSplitSubPartitionaAtAction(PostgreSQLSQLStatementParser.AlterTableSplitSubPartitionaAtActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableSplitSubPartitionaValuesAction}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iAlterTableSubSplitPartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableSplitSubPartitionaValuesAction(PostgreSQLSQLStatementParser.AlterTableSplitSubPartitionaValuesActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableSplitSubPartitionaIntoAction}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iAlterTableSubSplitPartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableSplitSubPartitionaIntoAction(PostgreSQLSQLStatementParser.AlterTableSplitSubPartitionaIntoActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableSplitSubPartitionaForAtAction}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iAlterTableSubSplitPartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableSplitSubPartitionaForAtAction(PostgreSQLSQLStatementParser.AlterTableSplitSubPartitionaForAtActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableSplitSubPartitionaForValuesAction}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iAlterTableSubSplitPartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableSplitSubPartitionaForValuesAction(PostgreSQLSQLStatementParser.AlterTableSplitSubPartitionaForValuesActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableSplitSubPartitionaForIntoAction}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iAlterTableSubSplitPartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableSplitSubPartitionaForIntoAction(PostgreSQLSQLStatementParser.AlterTableSplitSubPartitionaForIntoActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableMergePartitionsAction}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iAlterTableMergePartitionsAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableMergePartitionsAction(PostgreSQLSQLStatementParser.AlterTableMergePartitionsActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableMergePartitionsToAction}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iAlterTableMergePartitionsAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableMergePartitionsToAction(PostgreSQLSQLStatementParser.AlterTableMergePartitionsToActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableMergeSubPartitionsAction}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iAlterTableMergeSubPartitionsAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableMergeSubPartitionsAction(PostgreSQLSQLStatementParser.AlterTableMergeSubPartitionsActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableMergeSubPartitionsToAction}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iAlterTableMergeSubPartitionsAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableMergeSubPartitionsToAction(PostgreSQLSQLStatementParser.AlterTableMergeSubPartitionsToActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableExchangePartitionAction}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iAlterTableExchangePartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableExchangePartitionAction(PostgreSQLSQLStatementParser.AlterTableExchangePartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableExchangePartitionForAction}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iAlterTableExchangePartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableExchangePartitionForAction(PostgreSQLSQLStatementParser.AlterTableExchangePartitionForActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableExchangeSubPartitionAction}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iAlterTableExchangeSubPartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableExchangeSubPartitionAction(PostgreSQLSQLStatementParser.AlterTableExchangeSubPartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableExchangeSubPartitionForAction}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iAlterTableExchangeSubPartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableExchangeSubPartitionForAction(PostgreSQLSQLStatementParser.AlterTableExchangeSubPartitionForActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#updateIndexClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdateIndexClause(PostgreSQLSQLStatementParser.UpdateIndexClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#updateGlobalIndexClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdateGlobalIndexClause(PostgreSQLSQLStatementParser.UpdateGlobalIndexClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#updateIndexesClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdateIndexesClause(PostgreSQLSQLStatementParser.UpdateIndexesClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#updateIndexesClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdateIndexesClauseItem(PostgreSQLSQLStatementParser.UpdateIndexesClauseItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterTableMoveTableAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableMoveTableAction(PostgreSQLSQLStatementParser.AlterTableMoveTableActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterTableMoveTableActionUpdateIndexesItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableMoveTableActionUpdateIndexesItem(PostgreSQLSQLStatementParser.AlterTableMoveTableActionUpdateIndexesItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterTableModifyToPartitionedAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableModifyToPartitionedAction(PostgreSQLSQLStatementParser.AlterTableModifyToPartitionedActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterTableModifyToPartitionedActionUpdateIndexesItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableModifyToPartitionedActionUpdateIndexesItem(PostgreSQLSQLStatementParser.AlterTableModifyToPartitionedActionUpdateIndexesItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterTableModifyOpaqueTypeAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableModifyOpaqueTypeAction(PostgreSQLSQLStatementParser.AlterTableModifyOpaqueTypeActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code enableUniqueClause}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iEnableDisableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnableUniqueClause(PostgreSQLSQLStatementParser.EnableUniqueClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code enablePrimaryKeyClause}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iEnableDisableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnablePrimaryKeyClause(PostgreSQLSQLStatementParser.EnablePrimaryKeyClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code enableConstraintClause}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iEnableDisableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnableConstraintClause(PostgreSQLSQLStatementParser.EnableConstraintClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code disableUniqueClause}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iEnableDisableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDisableUniqueClause(PostgreSQLSQLStatementParser.DisableUniqueClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code disablePrimaryKeyClause}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iEnableDisableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDisablePrimaryKeyClause(PostgreSQLSQLStatementParser.DisablePrimaryKeyClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code disableConstraintClause}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iEnableDisableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDisableConstraintClause(PostgreSQLSQLStatementParser.DisableConstraintClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterTableEnableTableLockAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableEnableTableLockAction(PostgreSQLSQLStatementParser.AlterTableEnableTableLockActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterTableEnableAllTriggersAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableEnableAllTriggersAction(PostgreSQLSQLStatementParser.AlterTableEnableAllTriggersActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterTableEnableContainerMapAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableEnableContainerMapAction(PostgreSQLSQLStatementParser.AlterTableEnableContainerMapActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterTableEnableContainersDefaultAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableEnableContainersDefaultAction(PostgreSQLSQLStatementParser.AlterTableEnableContainersDefaultActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterTableDisableTableLockAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableDisableTableLockAction(PostgreSQLSQLStatementParser.AlterTableDisableTableLockActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterTableDisableAllTriggersAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableDisableAllTriggersAction(PostgreSQLSQLStatementParser.AlterTableDisableAllTriggersActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterTableDisableContainerMapAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableDisableContainerMapAction(PostgreSQLSQLStatementParser.AlterTableDisableContainerMapActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterTableDisableContainersDefaultAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableDisableContainersDefaultAction(PostgreSQLSQLStatementParser.AlterTableDisableContainersDefaultActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#createTriggerStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTriggerStatement(PostgreSQLSQLStatementParser.CreateTriggerStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterTriggerStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTriggerStatement(PostgreSQLSQLStatementParser.AlterTriggerStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#dropTriggerStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropTriggerStatement(PostgreSQLSQLStatementParser.DropTriggerStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#createTriggerActionTime}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTriggerActionTime(PostgreSQLSQLStatementParser.CreateTriggerActionTimeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#createTriggerEvent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTriggerEvent(PostgreSQLSQLStatementParser.CreateTriggerEventContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#triggerDmlEvent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTriggerDmlEvent(PostgreSQLSQLStatementParser.TriggerDmlEventContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#triggerDDLEvent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTriggerDDLEvent(PostgreSQLSQLStatementParser.TriggerDDLEventContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#triggerDatabaseEvent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTriggerDatabaseEvent(PostgreSQLSQLStatementParser.TriggerDatabaseEventContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#createTriggerOnExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTriggerOnExpr(PostgreSQLSQLStatementParser.CreateTriggerOnExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#createTriggerOnSchemaExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTriggerOnSchemaExpr(PostgreSQLSQLStatementParser.CreateTriggerOnSchemaExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#createTriggerOnDatabaseExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTriggerOnDatabaseExpr(PostgreSQLSQLStatementParser.CreateTriggerOnDatabaseExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#forEachRow}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForEachRow(PostgreSQLSQLStatementParser.ForEachRowContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#referencingOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReferencingOption(PostgreSQLSQLStatementParser.ReferencingOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#triggerEditionClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTriggerEditionClause(PostgreSQLSQLStatementParser.TriggerEditionClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#triggerOrderingClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTriggerOrderingClause(PostgreSQLSQLStatementParser.TriggerOrderingClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#compoundTriggerBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompoundTriggerBlock(PostgreSQLSQLStatementParser.CompoundTriggerBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#timingPointSection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimingPointSection(PostgreSQLSQLStatementParser.TimingPointSectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#timingPoint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimingPoint(PostgreSQLSQLStatementParser.TimingPointContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#triggerBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTriggerBody(PostgreSQLSQLStatementParser.TriggerBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterTriggerStatementOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTriggerStatementOption(PostgreSQLSQLStatementParser.AlterTriggerStatementOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#createTypeStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTypeStatement(PostgreSQLSQLStatementParser.CreateTypeStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterTypeStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTypeStatement(PostgreSQLSQLStatementParser.AlterTypeStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#dropTypeStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropTypeStatement(PostgreSQLSQLStatementParser.DropTypeStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#createTypeStatementProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTypeStatementProperty(PostgreSQLSQLStatementParser.CreateTypeStatementPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#createTypeExternalNameClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTypeExternalNameClause(PostgreSQLSQLStatementParser.CreateTypeExternalNameClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#createTypeStatementOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTypeStatementOption(PostgreSQLSQLStatementParser.CreateTypeStatementOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterTypeAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTypeAction(PostgreSQLSQLStatementParser.AlterTypeActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#replaceTypeClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReplaceTypeClause(PostgreSQLSQLStatementParser.ReplaceTypeClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alter_method_spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_method_spec(PostgreSQLSQLStatementParser.Alter_method_specContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alter_method_element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_method_element(PostgreSQLSQLStatementParser.Alter_method_elementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alter_attribute_definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_attribute_definition(PostgreSQLSQLStatementParser.Alter_attribute_definitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alter_collection_clauses}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_collection_clauses(PostgreSQLSQLStatementParser.Alter_collection_clausesContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#dependent_handling_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDependent_handling_clause(PostgreSQLSQLStatementParser.Dependent_handling_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#dependent_exceptions_part}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDependent_exceptions_part(PostgreSQLSQLStatementParser.Dependent_exceptions_partContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#createTypeBodyStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTypeBodyStatement(PostgreSQLSQLStatementParser.CreateTypeBodyStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#dropTypeBodyStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropTypeBodyStatement(PostgreSQLSQLStatementParser.DropTypeBodyStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#createTypeBodyStatementItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTypeBodyStatementItem(PostgreSQLSQLStatementParser.CreateTypeBodyStatementItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#createViewStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateViewStatement(PostgreSQLSQLStatementParser.CreateViewStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterViewStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterViewStatement(PostgreSQLSQLStatementParser.AlterViewStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#dropViewStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropViewStatement(PostgreSQLSQLStatementParser.DropViewStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#createViewSubView}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateViewSubView(PostgreSQLSQLStatementParser.CreateViewSubViewContext ctx);
	/**
	 * Visit a parse tree produced by the {@code withObjectIdentifierClause}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iWithObjectIdClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithObjectIdentifierClause(PostgreSQLSQLStatementParser.WithObjectIdentifierClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code withObjectIdClause}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iWithObjectIdClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithObjectIdClause(PostgreSQLSQLStatementParser.WithObjectIdClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#subViewClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubViewClause(PostgreSQLSQLStatementParser.SubViewClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterViewAddTableConstraintAction}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#alterViewAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterViewAddTableConstraintAction(PostgreSQLSQLStatementParser.AlterViewAddTableConstraintActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterViewModifyConstraintAction}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#alterViewAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterViewModifyConstraintAction(PostgreSQLSQLStatementParser.AlterViewModifyConstraintActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterViewDropConstraintAction}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#alterViewAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterViewDropConstraintAction(PostgreSQLSQLStatementParser.AlterViewDropConstraintActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterViewDropPrimaryKeyConstraintAction}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#alterViewAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterViewDropPrimaryKeyConstraintAction(PostgreSQLSQLStatementParser.AlterViewDropPrimaryKeyConstraintActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterViewCompileAction}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#alterViewAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterViewCompileAction(PostgreSQLSQLStatementParser.AlterViewCompileActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterViewAddTableAction}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#alterViewAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterViewAddTableAction(PostgreSQLSQLStatementParser.AlterViewAddTableActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterViewReadOnlyAction}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#alterViewAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterViewReadOnlyAction(PostgreSQLSQLStatementParser.AlterViewReadOnlyActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterViewReadWriteAction}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#alterViewAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterViewReadWriteAction(PostgreSQLSQLStatementParser.AlterViewReadWriteActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterViewEditionableAction}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#alterViewAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterViewEditionableAction(PostgreSQLSQLStatementParser.AlterViewEditionableActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterViewNonEditionableAction}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#alterViewAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterViewNonEditionableAction(PostgreSQLSQLStatementParser.AlterViewNonEditionableActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#createMaterializedViewStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateMaterializedViewStatement(PostgreSQLSQLStatementParser.CreateMaterializedViewStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterMaterializedViewStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterMaterializedViewStatement(PostgreSQLSQLStatementParser.AlterMaterializedViewStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#dropMaterializedViewStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropMaterializedViewStatement(PostgreSQLSQLStatementParser.DropMaterializedViewStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#iCreateMaterializedViewStatementColumn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitICreateMaterializedViewStatementColumn(PostgreSQLSQLStatementParser.ICreateMaterializedViewStatementColumnContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#createMaterializedViewStatementColumn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateMaterializedViewStatementColumn(PostgreSQLSQLStatementParser.CreateMaterializedViewStatementColumnContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#createMaterializedViewStatementProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateMaterializedViewStatementProperty(PostgreSQLSQLStatementParser.CreateMaterializedViewStatementPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#onPrebuiltTableProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOnPrebuiltTableProperty(PostgreSQLSQLStatementParser.OnPrebuiltTablePropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#materializedViewProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMaterializedViewProperty(PostgreSQLSQLStatementParser.MaterializedViewPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#materializedViewPropertyCacheClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMaterializedViewPropertyCacheClause(PostgreSQLSQLStatementParser.MaterializedViewPropertyCacheClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#materializedViewPropertyNoCacheClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMaterializedViewPropertyNoCacheClause(PostgreSQLSQLStatementParser.MaterializedViewPropertyNoCacheClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code usingIndexClause}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iUsingIndexClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUsingIndexClause(PostgreSQLSQLStatementParser.UsingIndexClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code usingNoIndexClause}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iUsingIndexClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUsingNoIndexClause(PostgreSQLSQLStatementParser.UsingNoIndexClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#usingIndexItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUsingIndexItem(PostgreSQLSQLStatementParser.UsingIndexItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#usingIndexCreateIndexStatementItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUsingIndexCreateIndexStatementItem(PostgreSQLSQLStatementParser.UsingIndexCreateIndexStatementItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code createMVRefresh}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iCreateMVRefresh}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateMVRefresh(PostgreSQLSQLStatementParser.CreateMVRefreshContext ctx);
	/**
	 * Visit a parse tree produced by the {@code createMVNeverRefresh}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iCreateMVRefresh}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateMVNeverRefresh(PostgreSQLSQLStatementParser.CreateMVNeverRefreshContext ctx);
	/**
	 * Visit a parse tree produced by the {@code createMVRefreshFastItem}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#createMVRefreshItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateMVRefreshFastItem(PostgreSQLSQLStatementParser.CreateMVRefreshFastItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code createMVRefreshCompleteItem}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#createMVRefreshItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateMVRefreshCompleteItem(PostgreSQLSQLStatementParser.CreateMVRefreshCompleteItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code createMVRefreshForceItem}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#createMVRefreshItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateMVRefreshForceItem(PostgreSQLSQLStatementParser.CreateMVRefreshForceItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code createMVRefreshOnDemandItem}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#createMVRefreshItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateMVRefreshOnDemandItem(PostgreSQLSQLStatementParser.CreateMVRefreshOnDemandItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code createMVRefreshOnCommitItem}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#createMVRefreshItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateMVRefreshOnCommitItem(PostgreSQLSQLStatementParser.CreateMVRefreshOnCommitItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code createMVRefreshOnStatementItem}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#createMVRefreshItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateMVRefreshOnStatementItem(PostgreSQLSQLStatementParser.CreateMVRefreshOnStatementItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code createMVRefreshStartWithItem}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#createMVRefreshItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateMVRefreshStartWithItem(PostgreSQLSQLStatementParser.CreateMVRefreshStartWithItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code createMVRefreshNextItem}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#createMVRefreshItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateMVRefreshNextItem(PostgreSQLSQLStatementParser.CreateMVRefreshNextItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code createMVRefreshWithPrimaryKeyItem}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#createMVRefreshItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateMVRefreshWithPrimaryKeyItem(PostgreSQLSQLStatementParser.CreateMVRefreshWithPrimaryKeyItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code createMVRefreshWithRowidItem}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#createMVRefreshItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateMVRefreshWithRowidItem(PostgreSQLSQLStatementParser.CreateMVRefreshWithRowidItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code createMVRefreshUsingRollbackSegmentItem}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#createMVRefreshItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateMVRefreshUsingRollbackSegmentItem(PostgreSQLSQLStatementParser.CreateMVRefreshUsingRollbackSegmentItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code createMVRefreshUsingEnforcedConstraintsItem}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#createMVRefreshItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateMVRefreshUsingEnforcedConstraintsItem(PostgreSQLSQLStatementParser.CreateMVRefreshUsingEnforcedConstraintsItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code createMVRefreshUsingTrustedConstraintsItem}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#createMVRefreshItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateMVRefreshUsingTrustedConstraintsItem(PostgreSQLSQLStatementParser.CreateMVRefreshUsingTrustedConstraintsItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code usingRollbackSegmentByDefaultItem}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#usingRollbackSegmentItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUsingRollbackSegmentByDefaultItem(PostgreSQLSQLStatementParser.UsingRollbackSegmentByDefaultItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code usingRollbackSegmentByNoDefaultItem}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#usingRollbackSegmentItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUsingRollbackSegmentByNoDefaultItem(PostgreSQLSQLStatementParser.UsingRollbackSegmentByNoDefaultItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#usingRollbackSegmentOptionType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUsingRollbackSegmentOptionType(PostgreSQLSQLStatementParser.UsingRollbackSegmentOptionTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#onQueryComputationClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOnQueryComputationClause(PostgreSQLSQLStatementParser.OnQueryComputationClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#queryRewriteClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQueryRewriteClause(PostgreSQLSQLStatementParser.QueryRewriteClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterMaterializedViewStatementProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterMaterializedViewStatementProperty(PostgreSQLSQLStatementParser.AlterMaterializedViewStatementPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#commentOnAuditPolicyStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommentOnAuditPolicyStatement(PostgreSQLSQLStatementParser.CommentOnAuditPolicyStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#commentOnColumnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommentOnColumnStatement(PostgreSQLSQLStatementParser.CommentOnColumnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#commentOnEditionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommentOnEditionStatement(PostgreSQLSQLStatementParser.CommentOnEditionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#commentOnIndexTypeStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommentOnIndexTypeStatement(PostgreSQLSQLStatementParser.CommentOnIndexTypeStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#commentOnMaterializedViewStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommentOnMaterializedViewStatement(PostgreSQLSQLStatementParser.CommentOnMaterializedViewStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#commentOnMiningModelStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommentOnMiningModelStatement(PostgreSQLSQLStatementParser.CommentOnMiningModelStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#commentOnOperatorStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommentOnOperatorStatement(PostgreSQLSQLStatementParser.CommentOnOperatorStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#commentOnTableStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommentOnTableStatement(PostgreSQLSQLStatementParser.CommentOnTableStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#sqlStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSqlStatement(PostgreSQLSQLStatementParser.SqlStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#cursor_manipulation_statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCursor_manipulation_statements(PostgreSQLSQLStatementParser.Cursor_manipulation_statementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#callStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallStatement(PostgreSQLSQLStatementParser.CallStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#explainStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExplainStatement(PostgreSQLSQLStatementParser.ExplainStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#insertStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsertStatement(PostgreSQLSQLStatementParser.InsertStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#multiInsertStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiInsertStatement(PostgreSQLSQLStatementParser.MultiInsertStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#iValueClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIValueClause(PostgreSQLSQLStatementParser.IValueClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#multiInsertClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiInsertClause(PostgreSQLSQLStatementParser.MultiInsertClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#multiInsertIntoClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiInsertIntoClause(PostgreSQLSQLStatementParser.MultiInsertIntoClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#multiConditionalInsertIntoClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiConditionalInsertIntoClause(PostgreSQLSQLStatementParser.MultiConditionalInsertIntoClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#multiInsertIntoClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiInsertIntoClauseItem(PostgreSQLSQLStatementParser.MultiInsertIntoClauseItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#multiConditionalInsertWhenClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiConditionalInsertWhenClause(PostgreSQLSQLStatementParser.MultiConditionalInsertWhenClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#valuesClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValuesClause(PostgreSQLSQLStatementParser.ValuesClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#valuesClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValuesClauseItem(PostgreSQLSQLStatementParser.ValuesClauseItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#mergeStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMergeStatement(PostgreSQLSQLStatementParser.MergeStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#merge_update_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMerge_update_clause(PostgreSQLSQLStatementParser.Merge_update_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#merge_element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMerge_element(PostgreSQLSQLStatementParser.Merge_elementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#merge_update_delete_part}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMerge_update_delete_part(PostgreSQLSQLStatementParser.Merge_update_delete_partContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#merge_insert_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMerge_insert_clause(PostgreSQLSQLStatementParser.Merge_insert_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#selected_tableview}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelected_tableview(PostgreSQLSQLStatementParser.Selected_tableviewContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#lockTableStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLockTableStatement(PostgreSQLSQLStatementParser.LockTableStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#lockTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLockTableItem(PostgreSQLSQLStatementParser.LockTableItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#lockMode}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLockMode(PostgreSQLSQLStatementParser.LockModeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#deleteStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeleteStatement(PostgreSQLSQLStatementParser.DeleteStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#selectStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectStatement(PostgreSQLSQLStatementParser.SelectStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#iSelectQuery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitISelectQuery(PostgreSQLSQLStatementParser.ISelectQueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#selectQueryBasic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectQueryBasic(PostgreSQLSQLStatementParser.SelectQueryBasicContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#selectQuery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectQuery(PostgreSQLSQLStatementParser.SelectQueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#selectParenQuery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectParenQuery(PostgreSQLSQLStatementParser.SelectParenQueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#selectUnionQuery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectUnionQuery(PostgreSQLSQLStatementParser.SelectUnionQueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#setQuantifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetQuantifier(PostgreSQLSQLStatementParser.SetQuantifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#unionOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnionOperator(PostgreSQLSQLStatementParser.UnionOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#withClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithClause(PostgreSQLSQLStatementParser.WithClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#plsqlDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlsqlDeclaration(PostgreSQLSQLStatementParser.PlsqlDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#withElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithElement(PostgreSQLSQLStatementParser.WithElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#subQueryFactoringClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubQueryFactoringClause(PostgreSQLSQLStatementParser.SubQueryFactoringClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#searchClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSearchClause(PostgreSQLSQLStatementParser.SearchClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#cycleClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCycleClause(PostgreSQLSQLStatementParser.CycleClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#subAvFactoringClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubAvFactoringClause(PostgreSQLSQLStatementParser.SubAvFactoringClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#subAvClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubAvClause(PostgreSQLSQLStatementParser.SubAvClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#hierarchiesClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHierarchiesClause(PostgreSQLSQLStatementParser.HierarchiesClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#subAvClauseFilterClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubAvClauseFilterClause(PostgreSQLSQLStatementParser.SubAvClauseFilterClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#calcMeasClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCalcMeasClause(PostgreSQLSQLStatementParser.CalcMeasClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#selectItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectItem(PostgreSQLSQLStatementParser.SelectItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#selectItemAlias}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectItemAlias(PostgreSQLSQLStatementParser.SelectItemAliasContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#fromClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFromClause(PostgreSQLSQLStatementParser.FromClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#iTableReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitITableReference(PostgreSQLSQLStatementParser.ITableReferenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code objectNameTableReference}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#tableReferenceBasic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectNameTableReference(PostgreSQLSQLStatementParser.ObjectNameTableReferenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lateralSubQueryTableReference}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#tableReferenceBasic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLateralSubQueryTableReference(PostgreSQLSQLStatementParser.LateralSubQueryTableReferenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tableFunctionTableReference}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#tableReferenceBasic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableFunctionTableReference(PostgreSQLSQLStatementParser.TableFunctionTableReferenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code containersFunctionTableReference}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#tableReferenceBasic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContainersFunctionTableReference(PostgreSQLSQLStatementParser.ContainersFunctionTableReferenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code shardsFunctionTableReference}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#tableReferenceBasic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShardsFunctionTableReference(PostgreSQLSQLStatementParser.ShardsFunctionTableReferenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inlineAnalyticViewTableReference}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#tableReferenceBasic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInlineAnalyticViewTableReference(PostgreSQLSQLStatementParser.InlineAnalyticViewTableReferenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenJoinTableReference}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#tableReferenceBasic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenJoinTableReference(PostgreSQLSQLStatementParser.ParenJoinTableReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#joinTableReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoinTableReference(PostgreSQLSQLStatementParser.JoinTableReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#objectNameTableReferenceOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectNameTableReferenceOption(PostgreSQLSQLStatementParser.ObjectNameTableReferenceOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#joinType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoinType(PostgreSQLSQLStatementParser.JoinTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#rightJoinClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRightJoinClause(PostgreSQLSQLStatementParser.RightJoinClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code joinCondition}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#joinSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoinCondition(PostgreSQLSQLStatementParser.JoinConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code namedColumnsJoin}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#joinSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNamedColumnsJoin(PostgreSQLSQLStatementParser.NamedColumnsJoinContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#locationClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocationClause(PostgreSQLSQLStatementParser.LocationClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#locationClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocationClauseItem(PostgreSQLSQLStatementParser.LocationClauseItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#modifiedExternalTableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModifiedExternalTableClause(PostgreSQLSQLStatementParser.ModifiedExternalTableClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code flashbackQueryByVersionsBetweenClause}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#flashbackQueryClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlashbackQueryByVersionsBetweenClause(PostgreSQLSQLStatementParser.FlashbackQueryByVersionsBetweenClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code flashbackQueryByVersionsPeriodForClause}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#flashbackQueryClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlashbackQueryByVersionsPeriodForClause(PostgreSQLSQLStatementParser.FlashbackQueryByVersionsPeriodForClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code flashbackQueryByAsOfClause}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#flashbackQueryClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlashbackQueryByAsOfClause(PostgreSQLSQLStatementParser.FlashbackQueryByAsOfClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code flashbackQueryByAsOfPeriodForClause}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#flashbackQueryClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlashbackQueryByAsOfPeriodForClause(PostgreSQLSQLStatementParser.FlashbackQueryByAsOfPeriodForClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#inlineExternalTable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInlineExternalTable(PostgreSQLSQLStatementParser.InlineExternalTableContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#iPivotClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIPivotClause(PostgreSQLSQLStatementParser.IPivotClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#pivotClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPivotClause(PostgreSQLSQLStatementParser.PivotClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#pivotItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPivotItem(PostgreSQLSQLStatementParser.PivotItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#unpivotClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnpivotClause(PostgreSQLSQLStatementParser.UnpivotClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#sampleClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSampleClause(PostgreSQLSQLStatementParser.SampleClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code partitionClause}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iPartitionClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionClause(PostgreSQLSQLStatementParser.PartitionClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code partitionForClause}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iPartitionClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionForClause(PostgreSQLSQLStatementParser.PartitionForClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code subPartitionClause}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iPartitionClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubPartitionClause(PostgreSQLSQLStatementParser.SubPartitionClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code subPartitionForClause}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iPartitionClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubPartitionForClause(PostgreSQLSQLStatementParser.SubPartitionForClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code withReadOnly}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iSubQueryRestrictionClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithReadOnly(PostgreSQLSQLStatementParser.WithReadOnlyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code withCheckOption}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iSubQueryRestrictionClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithCheckOption(PostgreSQLSQLStatementParser.WithCheckOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#whereClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhereClause(PostgreSQLSQLStatementParser.WhereClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#currentOfClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCurrentOfClause(PostgreSQLSQLStatementParser.CurrentOfClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code hierarchicalQueryConnectByToStartWithClause}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#hierarchicalQueryClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHierarchicalQueryConnectByToStartWithClause(PostgreSQLSQLStatementParser.HierarchicalQueryConnectByToStartWithClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code hierarchicalQueryStartWithToConnectByClause}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#hierarchicalQueryClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHierarchicalQueryStartWithToConnectByClause(PostgreSQLSQLStatementParser.HierarchicalQueryStartWithToConnectByClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code groupByHavingClause}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#groupByClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroupByHavingClause(PostgreSQLSQLStatementParser.GroupByHavingClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code havingGroupByClause}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#groupByClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHavingGroupByClause(PostgreSQLSQLStatementParser.HavingGroupByClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#havingClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHavingClause(PostgreSQLSQLStatementParser.HavingClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#groupByItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroupByItem(PostgreSQLSQLStatementParser.GroupByItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#rollupCubeClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRollupCubeClause(PostgreSQLSQLStatementParser.RollupCubeClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#groupingSetsClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroupingSetsClause(PostgreSQLSQLStatementParser.GroupingSetsClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#groupingSetsClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroupingSetsClauseItem(PostgreSQLSQLStatementParser.GroupingSetsClauseItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#modelClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModelClause(PostgreSQLSQLStatementParser.ModelClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#cellReferenceOptions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCellReferenceOptions(PostgreSQLSQLStatementParser.CellReferenceOptionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#returnRowsClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnRowsClause(PostgreSQLSQLStatementParser.ReturnRowsClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#referenceModel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReferenceModel(PostgreSQLSQLStatementParser.ReferenceModelContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#mainModel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMainModel(PostgreSQLSQLStatementParser.MainModelContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#modelColumnClauses}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModelColumnClauses(PostgreSQLSQLStatementParser.ModelColumnClausesContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#modelColumnClausesItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModelColumnClausesItem(PostgreSQLSQLStatementParser.ModelColumnClausesItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#modelRulesClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModelRulesClause(PostgreSQLSQLStatementParser.ModelRulesClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#modelRulesClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModelRulesClauseItem(PostgreSQLSQLStatementParser.ModelRulesClauseItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#modelIterateClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModelIterateClause(PostgreSQLSQLStatementParser.ModelIterateClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#cellAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCellAssignment(PostgreSQLSQLStatementParser.CellAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#cellAssignmentItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCellAssignmentItem(PostgreSQLSQLStatementParser.CellAssignmentItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#singleColumnForLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleColumnForLoop(PostgreSQLSQLStatementParser.SingleColumnForLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#multiColumnForLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiColumnForLoop(PostgreSQLSQLStatementParser.MultiColumnForLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#orderByClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrderByClause(PostgreSQLSQLStatementParser.OrderByClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#orderByItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrderByItem(PostgreSQLSQLStatementParser.OrderByItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#rowLimitingClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowLimitingClause(PostgreSQLSQLStatementParser.RowLimitingClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#forUpdateClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForUpdateClause(PostgreSQLSQLStatementParser.ForUpdateClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forUpdateSkipLockedOption}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#forUpdateOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForUpdateSkipLockedOption(PostgreSQLSQLStatementParser.ForUpdateSkipLockedOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forUpdateNoWaitOption}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#forUpdateOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForUpdateNoWaitOption(PostgreSQLSQLStatementParser.ForUpdateNoWaitOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forUpdateWaitOption}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#forUpdateOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForUpdateWaitOption(PostgreSQLSQLStatementParser.ForUpdateWaitOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#rowPatternClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowPatternClause(PostgreSQLSQLStatementParser.RowPatternClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#rowPatternRowsPerMatch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowPatternRowsPerMatch(PostgreSQLSQLStatementParser.RowPatternRowsPerMatchContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rowPatternSkipToNextRow}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#rowPatternSkipTo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowPatternSkipToNextRow(PostgreSQLSQLStatementParser.RowPatternSkipToNextRowContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rowPatternSkipPastLastRow}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#rowPatternSkipTo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowPatternSkipPastLastRow(PostgreSQLSQLStatementParser.RowPatternSkipPastLastRowContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rowPatternSkipToFirstVar}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#rowPatternSkipTo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowPatternSkipToFirstVar(PostgreSQLSQLStatementParser.RowPatternSkipToFirstVarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rowPatternSkipToLastVart}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#rowPatternSkipTo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowPatternSkipToLastVart(PostgreSQLSQLStatementParser.RowPatternSkipToLastVartContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rowPatternSkipToVar}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#rowPatternSkipTo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowPatternSkipToVar(PostgreSQLSQLStatementParser.RowPatternSkipToVarContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#rowPattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowPattern(PostgreSQLSQLStatementParser.RowPatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#rowPatternTerm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowPatternTerm(PostgreSQLSQLStatementParser.RowPatternTermContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#rowPatternFactor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowPatternFactor(PostgreSQLSQLStatementParser.RowPatternFactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#rowPatternPrimary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowPatternPrimary(PostgreSQLSQLStatementParser.RowPatternPrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#rowPatternPermute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowPatternPermute(PostgreSQLSQLStatementParser.RowPatternPermuteContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#rowPatternQuantifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowPatternQuantifier(PostgreSQLSQLStatementParser.RowPatternQuantifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#rowPatternSubsetClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowPatternSubsetClause(PostgreSQLSQLStatementParser.RowPatternSubsetClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#row_pattern_subset_item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRow_pattern_subset_item(PostgreSQLSQLStatementParser.Row_pattern_subset_itemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#row_pattern_rec_func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRow_pattern_rec_func(PostgreSQLSQLStatementParser.Row_pattern_rec_funcContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#row_pattern_classifier_func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRow_pattern_classifier_func(PostgreSQLSQLStatementParser.Row_pattern_classifier_funcContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#row_pattern_match_num_func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRow_pattern_match_num_func(PostgreSQLSQLStatementParser.Row_pattern_match_num_funcContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#row_pattern_navigation_func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRow_pattern_navigation_func(PostgreSQLSQLStatementParser.Row_pattern_navigation_funcContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#rowPatternNavLogical}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowPatternNavLogical(PostgreSQLSQLStatementParser.RowPatternNavLogicalContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#rowPatternNavPhysical}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowPatternNavPhysical(PostgreSQLSQLStatementParser.RowPatternNavPhysicalContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#rowPatternNavCompound}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowPatternNavCompound(PostgreSQLSQLStatementParser.RowPatternNavCompoundContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#rowPatternAggregateFunc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowPatternAggregateFunc(PostgreSQLSQLStatementParser.RowPatternAggregateFuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#updateStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdateStatement(PostgreSQLSQLStatementParser.UpdateStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code updateSetClause}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iUpdateSetClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdateSetClause(PostgreSQLSQLStatementParser.UpdateSetClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code updateSetByValueClause}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iUpdateSetClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdateSetByValueClause(PostgreSQLSQLStatementParser.UpdateSetByValueClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#updateSetItemClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdateSetItemClause(PostgreSQLSQLStatementParser.UpdateSetItemClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#commitStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommitStatement(PostgreSQLSQLStatementParser.CommitStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#commitStatementOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommitStatementOption(PostgreSQLSQLStatementParser.CommitStatementOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#commitStatementCommentOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommitStatementCommentOption(PostgreSQLSQLStatementParser.CommitStatementCommentOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#commitStatementWriteOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommitStatementWriteOption(PostgreSQLSQLStatementParser.CommitStatementWriteOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#commitStatementForceOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommitStatementForceOption(PostgreSQLSQLStatementParser.CommitStatementForceOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#rollbackStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRollbackStatement(PostgreSQLSQLStatementParser.RollbackStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#rollbackStatementOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRollbackStatementOption(PostgreSQLSQLStatementParser.RollbackStatementOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#rollbackStatementToSavepointOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRollbackStatementToSavepointOption(PostgreSQLSQLStatementParser.RollbackStatementToSavepointOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#rollbackStatementForceOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRollbackStatementForceOption(PostgreSQLSQLStatementParser.RollbackStatementForceOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#savepointStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSavepointStatement(PostgreSQLSQLStatementParser.SavepointStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#setTransactionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetTransactionStatement(PostgreSQLSQLStatementParser.SetTransactionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#setTransactionStatementOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetTransactionStatementOption(PostgreSQLSQLStatementParser.SetTransactionStatementOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#setTransactionStatementReadOnlyOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetTransactionStatementReadOnlyOption(PostgreSQLSQLStatementParser.SetTransactionStatementReadOnlyOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#setTransactionStatementReadWriteOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetTransactionStatementReadWriteOption(PostgreSQLSQLStatementParser.SetTransactionStatementReadWriteOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#setTransactionStatementIsolationLevelOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetTransactionStatementIsolationLevelOption(PostgreSQLSQLStatementParser.SetTransactionStatementIsolationLevelOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#setTransactionStatementUseRollbackSegmentOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetTransactionStatementUseRollbackSegmentOption(PostgreSQLSQLStatementParser.SetTransactionStatementUseRollbackSegmentOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#setTransactionStatementNameOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetTransactionStatementNameOption(PostgreSQLSQLStatementParser.SetTransactionStatementNameOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#setConstraintStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetConstraintStatement(PostgreSQLSQLStatementParser.SetConstraintStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#setConstraintsStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetConstraintsStatement(PostgreSQLSQLStatementParser.SetConstraintsStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#alterSessionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterSessionStatement(PostgreSQLSQLStatementParser.AlterSessionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#setRoleStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetRoleStatement(PostgreSQLSQLStatementParser.SetRoleStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#whenever_command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhenever_command(PostgreSQLSQLStatementParser.Whenever_commandContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#set_command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSet_command(PostgreSQLSQLStatementParser.Set_commandContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#exit_command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExit_command(PostgreSQLSQLStatementParser.Exit_commandContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#prompt_command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrompt_command(PostgreSQLSQLStatementParser.Prompt_commandContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#show_errors_command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShow_errors_command(PostgreSQLSQLStatementParser.Show_errors_commandContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#start_command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart_command(PostgreSQLSQLStatementParser.Start_commandContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#native_datatype_element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNative_datatype_element(PostgreSQLSQLStatementParser.Native_datatype_elementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#allTokens}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAllTokens(PostgreSQLSQLStatementParser.AllTokensContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataType(PostgreSQLSQLStatementParser.DataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code charDataType}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iCharacterDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharDataType(PostgreSQLSQLStatementParser.CharDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varchar2DataType}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iCharacterDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarchar2DataType(PostgreSQLSQLStatementParser.Varchar2DataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ncharDataType}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iCharacterDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNcharDataType(PostgreSQLSQLStatementParser.NcharDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nvarchar2DataType}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iCharacterDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNvarchar2DataType(PostgreSQLSQLStatementParser.Nvarchar2DataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numberDataType}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iNumericDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberDataType(PostgreSQLSQLStatementParser.NumberDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code floatDataType}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iNumericDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatDataType(PostgreSQLSQLStatementParser.FloatDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryFloatDataType}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iNumericDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryFloatDataType(PostgreSQLSQLStatementParser.BinaryFloatDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryDoubleDataType}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iNumericDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryDoubleDataType(PostgreSQLSQLStatementParser.BinaryDoubleDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code longDataType}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#longAndRawDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLongDataType(PostgreSQLSQLStatementParser.LongDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code longRawDataType}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#longAndRawDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLongRawDataType(PostgreSQLSQLStatementParser.LongRawDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rawDataType}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#longAndRawDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRawDataType(PostgreSQLSQLStatementParser.RawDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dateDataType}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#dateTimeDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDateDataType(PostgreSQLSQLStatementParser.DateDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code timestampDataType}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#dateTimeDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimestampDataType(PostgreSQLSQLStatementParser.TimestampDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intervalDataType}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#dateTimeDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntervalDataType(PostgreSQLSQLStatementParser.IntervalDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code blobDataType}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#largeObjectDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlobDataType(PostgreSQLSQLStatementParser.BlobDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code clobDataType}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#largeObjectDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClobDataType(PostgreSQLSQLStatementParser.ClobDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nclobDataType}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#largeObjectDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNclobDataType(PostgreSQLSQLStatementParser.NclobDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bfileDataType}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#largeObjectDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBfileDataType(PostgreSQLSQLStatementParser.BfileDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rowidDataType}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iRowidDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowidDataType(PostgreSQLSQLStatementParser.RowidDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code urowidDataType}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iRowidDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUrowidDataType(PostgreSQLSQLStatementParser.UrowidDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#booleanDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanDataType(PostgreSQLSQLStatementParser.BooleanDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code characterDataType}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#ansiSupportedDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharacterDataType(PostgreSQLSQLStatementParser.CharacterDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code characterVaryingDataType}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#ansiSupportedDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharacterVaryingDataType(PostgreSQLSQLStatementParser.CharacterVaryingDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code charVaryingDataType}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#ansiSupportedDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharVaryingDataType(PostgreSQLSQLStatementParser.CharVaryingDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ncharVaryingDataType}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#ansiSupportedDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNcharVaryingDataType(PostgreSQLSQLStatementParser.NcharVaryingDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varcharDataType}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#ansiSupportedDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarcharDataType(PostgreSQLSQLStatementParser.VarcharDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nationalCharacterDataType}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#ansiSupportedDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNationalCharacterDataType(PostgreSQLSQLStatementParser.NationalCharacterDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nationalCharDataType}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#ansiSupportedDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNationalCharDataType(PostgreSQLSQLStatementParser.NationalCharDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nationalCharacterVaryingDataType}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#ansiSupportedDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNationalCharacterVaryingDataType(PostgreSQLSQLStatementParser.NationalCharacterVaryingDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nationalCharVaryingDataType}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#ansiSupportedDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNationalCharVaryingDataType(PostgreSQLSQLStatementParser.NationalCharVaryingDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numericDataType}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#ansiSupportedDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumericDataType(PostgreSQLSQLStatementParser.NumericDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code decimalDataType}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#ansiSupportedDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecimalDataType(PostgreSQLSQLStatementParser.DecimalDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code decDataType}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#ansiSupportedDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecDataType(PostgreSQLSQLStatementParser.DecDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code integerDataType}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#ansiSupportedDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerDataType(PostgreSQLSQLStatementParser.IntegerDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intDataType}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#ansiSupportedDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntDataType(PostgreSQLSQLStatementParser.IntDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code smallintDataType}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#ansiSupportedDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSmallintDataType(PostgreSQLSQLStatementParser.SmallintDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code doublePrecisionDataType}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#ansiSupportedDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoublePrecisionDataType(PostgreSQLSQLStatementParser.DoublePrecisionDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code realDataType}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#ansiSupportedDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRealDataType(PostgreSQLSQLStatementParser.RealDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sysAnyDataDataType}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#anyDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSysAnyDataDataType(PostgreSQLSQLStatementParser.SysAnyDataDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sysAnyTypeDataType}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#anyDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSysAnyTypeDataType(PostgreSQLSQLStatementParser.SysAnyTypeDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sysAnyDataSetDataType}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#anyDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSysAnyDataSetDataType(PostgreSQLSQLStatementParser.SysAnyDataSetDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code xmlTypeDataType}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#xmlDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlTypeDataType(PostgreSQLSQLStatementParser.XmlTypeDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code uriTypeDataType}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#xmlDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUriTypeDataType(PostgreSQLSQLStatementParser.UriTypeDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jsonDataType}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iJsonDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonDataType(PostgreSQLSQLStatementParser.JsonDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sdoGeometryDataType}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#spatialDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSdoGeometryDataType(PostgreSQLSQLStatementParser.SdoGeometryDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sdoTopoGeometryDataType}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#spatialDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSdoTopoGeometryDataType(PostgreSQLSQLStatementParser.SdoTopoGeometryDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sdoGeorasterDataType}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#spatialDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSdoGeorasterDataType(PostgreSQLSQLStatementParser.SdoGeorasterDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code oRDAUDIODataType}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#mediaDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitORDAUDIODataType(PostgreSQLSQLStatementParser.ORDAUDIODataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code oRDIMAGEDataType}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#mediaDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitORDIMAGEDataType(PostgreSQLSQLStatementParser.ORDIMAGEDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code oRDVIDEODataType}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#mediaDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitORDVIDEODataType(PostgreSQLSQLStatementParser.ORDVIDEODataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code oRDDOCDataType}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#mediaDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitORDDOCDataType(PostgreSQLSQLStatementParser.ORDDOCDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code oRDDICOMDataType}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#mediaDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitORDDICOMDataType(PostgreSQLSQLStatementParser.ORDDICOMDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code siStillimageDataType}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#mediaDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSiStillimageDataType(PostgreSQLSQLStatementParser.SiStillimageDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code siAveragecolorDataType}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#mediaDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSiAveragecolorDataType(PostgreSQLSQLStatementParser.SiAveragecolorDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code siPositionalcolorDataType}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#mediaDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSiPositionalcolorDataType(PostgreSQLSQLStatementParser.SiPositionalcolorDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code siColorhistogramDataType}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#mediaDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSiColorhistogramDataType(PostgreSQLSQLStatementParser.SiColorhistogramDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code siTextureDataType}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#mediaDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSiTextureDataType(PostgreSQLSQLStatementParser.SiTextureDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code siFeaturelistDataType}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#mediaDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSiFeaturelistDataType(PostgreSQLSQLStatementParser.SiFeaturelistDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code siColorDataType}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#mediaDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSiColorDataType(PostgreSQLSQLStatementParser.SiColorDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#plsIntegerDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlsIntegerDataType(PostgreSQLSQLStatementParser.PlsIntegerDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#naturalDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNaturalDataType(PostgreSQLSQLStatementParser.NaturalDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#naturalnDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNaturalnDataType(PostgreSQLSQLStatementParser.NaturalnDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#positiveDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPositiveDataType(PostgreSQLSQLStatementParser.PositiveDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#positivenDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPositivenDataType(PostgreSQLSQLStatementParser.PositivenDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#signtypeDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSigntypeDataType(PostgreSQLSQLStatementParser.SigntypeDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#simpleIntegerDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleIntegerDataType(PostgreSQLSQLStatementParser.SimpleIntegerDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#binaryIntegerDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryIntegerDataType(PostgreSQLSQLStatementParser.BinaryIntegerDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#collectionDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCollectionDataType(PostgreSQLSQLStatementParser.CollectionDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#refDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRefDataType(PostgreSQLSQLStatementParser.RefDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#otherDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOtherDataType(PostgreSQLSQLStatementParser.OtherDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#refCursorDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRefCursorDataType(PostgreSQLSQLStatementParser.RefCursorDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#typeDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDataType(PostgreSQLSQLStatementParser.TypeDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#rowtypeDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowtypeDataType(PostgreSQLSQLStatementParser.RowtypeDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#assocArrayDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssocArrayDataType(PostgreSQLSQLStatementParser.AssocArrayDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#varrayDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarrayDataType(PostgreSQLSQLStatementParser.VarrayDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#varyingArrayDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVaryingArrayDataType(PostgreSQLSQLStatementParser.VaryingArrayDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#nestedTableDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNestedTableDataType(PostgreSQLSQLStatementParser.NestedTableDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#objectSubDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectSubDataType(PostgreSQLSQLStatementParser.ObjectSubDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#objectDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectDataType(PostgreSQLSQLStatementParser.ObjectDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#selfAsResultDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelfAsResultDataType(PostgreSQLSQLStatementParser.SelfAsResultDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code asteriskIdentifier}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsteriskIdentifier(PostgreSQLSQLStatementParser.AsteriskIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rowNumExpr}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowNumExpr(PostgreSQLSQLStatementParser.RowNumExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rowIdExpr}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowIdExpr(PostgreSQLSQLStatementParser.RowIdExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code normalIdentifier}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalIdentifier(PostgreSQLSQLStatementParser.NormalIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code doubleQuoteIdentifier}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleQuoteIdentifier(PostgreSQLSQLStatementParser.DoubleQuoteIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code identifier1}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#nameIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier1(PostgreSQLSQLStatementParser.Identifier1Context ctx);
	/**
	 * Visit a parse tree produced by the {@code propertyIdentifier1}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#nameIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertyIdentifier1(PostgreSQLSQLStatementParser.PropertyIdentifier1Context ctx);
	/**
	 * Visit a parse tree produced by the {@code dbLinkNameIdentifier}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#nameIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDbLinkNameIdentifier(PostgreSQLSQLStatementParser.DbLinkNameIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nQCharLiteral}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNQCharLiteral(PostgreSQLSQLStatementParser.NQCharLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nCharLiteral}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNCharLiteral(PostgreSQLSQLStatementParser.NCharLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code qCharLiteral}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQCharLiteral(PostgreSQLSQLStatementParser.QCharLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code charLiteral}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharLiteral(PostgreSQLSQLStatementParser.CharLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code integerLiteral}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerLiteral(PostgreSQLSQLStatementParser.IntegerLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numberLiteral}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberLiteral(PostgreSQLSQLStatementParser.NumberLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryFloatLiteral}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryFloatLiteral(PostgreSQLSQLStatementParser.BinaryFloatLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryDoubleLiteral}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryDoubleLiteral(PostgreSQLSQLStatementParser.BinaryDoubleLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dateLiteral}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDateLiteral(PostgreSQLSQLStatementParser.DateLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code timestampLiteral}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimestampLiteral(PostgreSQLSQLStatementParser.TimestampLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intervalLiteral}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntervalLiteral(PostgreSQLSQLStatementParser.IntervalLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code defaultLiteral}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultLiteral(PostgreSQLSQLStatementParser.DefaultLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code anyLiteral}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnyLiteral(PostgreSQLSQLStatementParser.AnyLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code minValueLiteral}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinValueLiteral(PostgreSQLSQLStatementParser.MinValueLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code maxValueLiteral}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMaxValueLiteral(PostgreSQLSQLStatementParser.MaxValueLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unlimitedLiteral}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnlimitedLiteral(PostgreSQLSQLStatementParser.UnlimitedLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code falseLiteral}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalseLiteral(PostgreSQLSQLStatementParser.FalseLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code trueLiteral}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueLiteral(PostgreSQLSQLStatementParser.TrueLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#unaryOperatorExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryOperatorExpr(PostgreSQLSQLStatementParser.UnaryOperatorExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#unaryOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryOperator(PostgreSQLSQLStatementParser.UnaryOperatorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multisetExceptOperatorExpr}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#multisetOperatorExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultisetExceptOperatorExpr(PostgreSQLSQLStatementParser.MultisetExceptOperatorExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multisetIntersectOperatorExpr}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#multisetOperatorExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultisetIntersectOperatorExpr(PostgreSQLSQLStatementParser.MultisetIntersectOperatorExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multisetUnionOperatorExpr}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#multisetOperatorExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultisetUnionOperatorExpr(PostgreSQLSQLStatementParser.MultisetUnionOperatorExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#variableExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableExpr(PostgreSQLSQLStatementParser.VariableExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#bindVariableExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBindVariableExpr(PostgreSQLSQLStatementParser.BindVariableExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#newVariableRefExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewVariableRefExpr(PostgreSQLSQLStatementParser.NewVariableRefExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#oldVariableRefExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOldVariableRefExpr(PostgreSQLSQLStatementParser.OldVariableRefExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#selectQueryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectQueryExpr(PostgreSQLSQLStatementParser.SelectQueryExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#nullExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullExpr(PostgreSQLSQLStatementParser.NullExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#sequenceExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSequenceExpr(PostgreSQLSQLStatementParser.SequenceExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#caseExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseExpr(PostgreSQLSQLStatementParser.CaseExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#caseExprWhenItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseExprWhenItem(PostgreSQLSQLStatementParser.CaseExprWhenItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#caseExprElseClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseExprElseClause(PostgreSQLSQLStatementParser.CaseExprElseClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#intervalExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntervalExpr(PostgreSQLSQLStatementParser.IntervalExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#placeholderExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlaceholderExpr(PostgreSQLSQLStatementParser.PlaceholderExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#typeConstructorExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeConstructorExpr(PostgreSQLSQLStatementParser.TypeConstructorExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#listExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListExpr(PostgreSQLSQLStatementParser.ListExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#exprBasic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprBasic(PostgreSQLSQLStatementParser.ExprBasicContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inCondition}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInCondition(PostgreSQLSQLStatementParser.InConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code isNullCondition}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsNullCondition(PostgreSQLSQLStatementParser.IsNullConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code iCondition}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitICondition(PostgreSQLSQLStatementParser.IConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code callArgumentExpr}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallArgumentExpr(PostgreSQLSQLStatementParser.CallArgumentExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryOperatorExpr}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryOperatorExpr(PostgreSQLSQLStatementParser.BinaryOperatorExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code likeCondition}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLikeCondition(PostgreSQLSQLStatementParser.LikeConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code propertyIdentifier2}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertyIdentifier2(PostgreSQLSQLStatementParser.PropertyIdentifier2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code isNanCondition}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsNanCondition(PostgreSQLSQLStatementParser.IsNanConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code isInfiniteCondition}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsInfiniteCondition(PostgreSQLSQLStatementParser.IsInfiniteConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dateTimeAtTimeZoneExpr}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDateTimeAtTimeZoneExpr(PostgreSQLSQLStatementParser.DateTimeAtTimeZoneExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cursorExpr}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCursorExpr(PostgreSQLSQLStatementParser.CursorExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code concatenationBinaryOperatorExpr}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConcatenationBinaryOperatorExpr(PostgreSQLSQLStatementParser.ConcatenationBinaryOperatorExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprToExprExpr}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprToExprExpr(PostgreSQLSQLStatementParser.ExprToExprExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code someExpr}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSomeExpr(PostgreSQLSQLStatementParser.SomeExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code isPresentCondition}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsPresentCondition(PostgreSQLSQLStatementParser.IsPresentConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code memberCondition}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberCondition(PostgreSQLSQLStatementParser.MemberConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayExpr}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayExpr(PostgreSQLSQLStatementParser.ArrayExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code isJsonCondition}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsJsonCondition(PostgreSQLSQLStatementParser.IsJsonConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code allExpr}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAllExpr(PostgreSQLSQLStatementParser.AllExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dateTimeAtLocalExpr}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDateTimeAtLocalExpr(PostgreSQLSQLStatementParser.DateTimeAtLocalExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code methodInvocation1}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodInvocation1(PostgreSQLSQLStatementParser.MethodInvocation1Context ctx);
	/**
	 * Visit a parse tree produced by the {@code basicExpr}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicExpr(PostgreSQLSQLStatementParser.BasicExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code methodInvocation2}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodInvocation2(PostgreSQLSQLStatementParser.MethodInvocation2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code relationalBinaryOperatorExpr}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalBinaryOperatorExpr(PostgreSQLSQLStatementParser.RelationalBinaryOperatorExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code outerExpr}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOuterExpr(PostgreSQLSQLStatementParser.OuterExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code betweenCondition}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBetweenCondition(PostgreSQLSQLStatementParser.BetweenConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code anyExpr}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnyExpr(PostgreSQLSQLStatementParser.AnyExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code isOfTypeCondition}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsOfTypeCondition(PostgreSQLSQLStatementParser.IsOfTypeConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#concatenationOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConcatenationOp(PostgreSQLSQLStatementParser.ConcatenationOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#comparisonOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonOp(PostgreSQLSQLStatementParser.ComparisonOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#defaultOnConversionErrorExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultOnConversionErrorExpr(PostgreSQLSQLStatementParser.DefaultOnConversionErrorExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#defaultClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultClause(PostgreSQLSQLStatementParser.DefaultClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#assignmentExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentExpr(PostgreSQLSQLStatementParser.AssignmentExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#editionableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEditionableClause(PostgreSQLSQLStatementParser.EditionableClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#nonEditionableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonEditionableClause(PostgreSQLSQLStatementParser.NonEditionableClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#enableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnableClause(PostgreSQLSQLStatementParser.EnableClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#disableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDisableClause(PostgreSQLSQLStatementParser.DisableClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#renameToClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRenameToClause(PostgreSQLSQLStatementParser.RenameToClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#exceptionClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExceptionClause(PostgreSQLSQLStatementParser.ExceptionClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#usingClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUsingClause(PostgreSQLSQLStatementParser.UsingClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#usingArgumentClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUsingArgumentClause(PostgreSQLSQLStatementParser.UsingArgumentClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#attributeDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributeDefinition(PostgreSQLSQLStatementParser.AttributeDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#finalClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFinalClause(PostgreSQLSQLStatementParser.FinalClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#notFinalClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotFinalClause(PostgreSQLSQLStatementParser.NotFinalClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#instantiableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstantiableClause(PostgreSQLSQLStatementParser.InstantiableClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#notInstantiableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotInstantiableClause(PostgreSQLSQLStatementParser.NotInstantiableClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#persistableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPersistableClause(PostgreSQLSQLStatementParser.PersistableClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#notPersistableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotPersistableClause(PostgreSQLSQLStatementParser.NotPersistableClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#secureFileClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSecureFileClause(PostgreSQLSQLStatementParser.SecureFileClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#basicFileClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicFileClause(PostgreSQLSQLStatementParser.BasicFileClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code isOpenImplicitCursorExpr}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#implicitCursorExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsOpenImplicitCursorExpr(PostgreSQLSQLStatementParser.IsOpenImplicitCursorExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code foundImplicitCursorExpr}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#implicitCursorExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFoundImplicitCursorExpr(PostgreSQLSQLStatementParser.FoundImplicitCursorExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notFoundImplicitCursorExpr}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#implicitCursorExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotFoundImplicitCursorExpr(PostgreSQLSQLStatementParser.NotFoundImplicitCursorExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rowcountImplicitCursorExpr}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#implicitCursorExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowcountImplicitCursorExpr(PostgreSQLSQLStatementParser.RowcountImplicitCursorExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bulkRowcountImplicitCursorExpr}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#implicitCursorExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBulkRowcountImplicitCursorExpr(PostgreSQLSQLStatementParser.BulkRowcountImplicitCursorExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bulkExceptionsCountImplicitCursorExpr}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#implicitCursorExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBulkExceptionsCountImplicitCursorExpr(PostgreSQLSQLStatementParser.BulkExceptionsCountImplicitCursorExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bulkExceptionImplicitCursorExpr}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#implicitCursorExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBulkExceptionImplicitCursorExpr(PostgreSQLSQLStatementParser.BulkExceptionImplicitCursorExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code isOpenNameCursorExpr}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#namedCursorExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsOpenNameCursorExpr(PostgreSQLSQLStatementParser.IsOpenNameCursorExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code foundNameCursorExpr}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#namedCursorExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFoundNameCursorExpr(PostgreSQLSQLStatementParser.FoundNameCursorExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notFoundNameCursorExpr}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#namedCursorExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotFoundNameCursorExpr(PostgreSQLSQLStatementParser.NotFoundNameCursorExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rowcountNameCursorExpr}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#namedCursorExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowcountNameCursorExpr(PostgreSQLSQLStatementParser.RowcountNameCursorExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#namedCursorName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNamedCursorName(PostgreSQLSQLStatementParser.NamedCursorNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(PostgreSQLSQLStatementParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#notCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotCondition(PostgreSQLSQLStatementParser.NotConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#isAnyCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsAnyCondition(PostgreSQLSQLStatementParser.IsAnyConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#isASetCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsASetCondition(PostgreSQLSQLStatementParser.IsASetConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#isEmptyCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsEmptyCondition(PostgreSQLSQLStatementParser.IsEmptyConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#submultisetCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubmultisetCondition(PostgreSQLSQLStatementParser.SubmultisetConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#regexpLikeCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegexpLikeCondition(PostgreSQLSQLStatementParser.RegexpLikeConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#formatJson}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormatJson(PostgreSQLSQLStatementParser.FormatJsonContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#jsonExistsCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonExistsCondition(PostgreSQLSQLStatementParser.JsonExistsConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#exprAsObjectExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAsObjectExpr(PostgreSQLSQLStatementParser.ExprAsObjectExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#jsonExistsOnErrorClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonExistsOnErrorClause(PostgreSQLSQLStatementParser.JsonExistsOnErrorClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#existsCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExistsCondition(PostgreSQLSQLStatementParser.ExistsConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#isOfTypeConditionItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsOfTypeConditionItem(PostgreSQLSQLStatementParser.IsOfTypeConditionItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#insertingCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsertingCondition(PostgreSQLSQLStatementParser.InsertingConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#updatingCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdatingCondition(PostgreSQLSQLStatementParser.UpdatingConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#deletingCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeletingCondition(PostgreSQLSQLStatementParser.DeletingConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(PostgreSQLSQLStatementParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#noArgumentFunctionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoArgumentFunctionName(PostgreSQLSQLStatementParser.NoArgumentFunctionNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#chrFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChrFunction(PostgreSQLSQLStatementParser.ChrFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#usingNCharCS}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUsingNCharCS(PostgreSQLSQLStatementParser.UsingNCharCSContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#translateUsingFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTranslateUsingFunction(PostgreSQLSQLStatementParser.TranslateUsingFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#trimFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrimFunction(PostgreSQLSQLStatementParser.TrimFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#extractFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtractFunction(PostgreSQLSQLStatementParser.ExtractFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#castFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCastFunction(PostgreSQLSQLStatementParser.CastFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#castFunctionArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCastFunctionArgument(PostgreSQLSQLStatementParser.CastFunctionArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#multisetExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultisetExpr(PostgreSQLSQLStatementParser.MultisetExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#treatFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTreatFunction(PostgreSQLSQLStatementParser.TreatFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#validateConversionFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValidateConversionFunction(PostgreSQLSQLStatementParser.ValidateConversionFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#dataMiningFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataMiningFunction(PostgreSQLSQLStatementParser.DataMiningFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#dataMiningFunctionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataMiningFunctionName(PostgreSQLSQLStatementParser.DataMiningFunctionNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#dataMiningFunctionArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataMiningFunctionArgument(PostgreSQLSQLStatementParser.DataMiningFunctionArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#costMatrixClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCostMatrixClause(PostgreSQLSQLStatementParser.CostMatrixClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#miningAttributeClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMiningAttributeClause(PostgreSQLSQLStatementParser.MiningAttributeClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#xmlCastFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlCastFunction(PostgreSQLSQLStatementParser.XmlCastFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#xmlColAttValFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlColAttValFunction(PostgreSQLSQLStatementParser.XmlColAttValFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#xmlElementFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlElementFunction(PostgreSQLSQLStatementParser.XmlElementFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#xmlExistsFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlExistsFunction(PostgreSQLSQLStatementParser.XmlExistsFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#xmlForestFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlForestFunction(PostgreSQLSQLStatementParser.XmlForestFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#xmlParseFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlParseFunction(PostgreSQLSQLStatementParser.XmlParseFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#xmlPiFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlPiFunction(PostgreSQLSQLStatementParser.XmlPiFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#xmlQueryFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlQueryFunction(PostgreSQLSQLStatementParser.XmlQueryFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#xmlRootFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlRootFunction(PostgreSQLSQLStatementParser.XmlRootFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#xmlSerializeFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlSerializeFunction(PostgreSQLSQLStatementParser.XmlSerializeFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#xmlTableFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlTableFunction(PostgreSQLSQLStatementParser.XmlTableFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#xmlRootFunctionVersionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlRootFunctionVersionExpr(PostgreSQLSQLStatementParser.XmlRootFunctionVersionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#xmlColAttValFunctionArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlColAttValFunctionArgument(PostgreSQLSQLStatementParser.XmlColAttValFunctionArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#xmlFunctionEvalNameArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlFunctionEvalNameArgument(PostgreSQLSQLStatementParser.XmlFunctionEvalNameArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#xmlAttributesClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlAttributesClause(PostgreSQLSQLStatementParser.XmlAttributesClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#exprOrExprAsAliasArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprOrExprAsAliasArgument(PostgreSQLSQLStatementParser.ExprOrExprAsAliasArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#xmlNamespacesClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlNamespacesClause(PostgreSQLSQLStatementParser.XmlNamespacesClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#xmlNamespacesClauseArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlNamespacesClauseArgument(PostgreSQLSQLStatementParser.XmlNamespacesClauseArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#xmlTableOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlTableOption(PostgreSQLSQLStatementParser.XmlTableOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#xmlPassingClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlPassingClause(PostgreSQLSQLStatementParser.XmlPassingClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#byValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitByValue(PostgreSQLSQLStatementParser.ByValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#returningSequenceByRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturningSequenceByRef(PostgreSQLSQLStatementParser.ReturningSequenceByRefContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#xmlTableColumn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlTableColumn(PostgreSQLSQLStatementParser.XmlTableColumnContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#sequenceByRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSequenceByRef(PostgreSQLSQLStatementParser.SequenceByRefContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#jsonFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonFunction(PostgreSQLSQLStatementParser.JsonFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#jsonFunctionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonFunctionName(PostgreSQLSQLStatementParser.JsonFunctionNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#jsonFunctionArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonFunctionArgument(PostgreSQLSQLStatementParser.JsonFunctionArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#jsonFormatJsonArgumentExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonFormatJsonArgumentExpr(PostgreSQLSQLStatementParser.JsonFormatJsonArgumentExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#jsonKeyValueArgumentExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonKeyValueArgumentExpr(PostgreSQLSQLStatementParser.JsonKeyValueArgumentExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#jsonOnNullClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonOnNullClause(PostgreSQLSQLStatementParser.JsonOnNullClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#jsonReturningClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonReturningClause(PostgreSQLSQLStatementParser.JsonReturningClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#withUniqueKeys}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithUniqueKeys(PostgreSQLSQLStatementParser.WithUniqueKeysContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#jsonWrapperClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonWrapperClause(PostgreSQLSQLStatementParser.JsonWrapperClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#jsonOnErrorClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonOnErrorClause(PostgreSQLSQLStatementParser.JsonOnErrorClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#jsonOnEmptyClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonOnEmptyClause(PostgreSQLSQLStatementParser.JsonOnEmptyClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#jsonColumnsClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonColumnsClause(PostgreSQLSQLStatementParser.JsonColumnsClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jsonExistsColumn}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#jsonColumnDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonExistsColumn(PostgreSQLSQLStatementParser.JsonExistsColumnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jsonQueryColumn}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#jsonColumnDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonQueryColumn(PostgreSQLSQLStatementParser.JsonQueryColumnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jsonValueColumn}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#jsonColumnDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonValueColumn(PostgreSQLSQLStatementParser.JsonValueColumnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jsonNestedPathColumn}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#jsonColumnDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonNestedPathColumn(PostgreSQLSQLStatementParser.JsonNestedPathColumnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jsonOrdinalityColumn}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#jsonColumnDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonOrdinalityColumn(PostgreSQLSQLStatementParser.JsonOrdinalityColumnContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#aggregateFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAggregateFunction(PostgreSQLSQLStatementParser.AggregateFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#aggregateFunctionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAggregateFunctionName(PostgreSQLSQLStatementParser.AggregateFunctionNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#withinGroupSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithinGroupSpecification(PostgreSQLSQLStatementParser.WithinGroupSpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#firstFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFirstFunction(PostgreSQLSQLStatementParser.FirstFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#lastFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLastFunction(PostgreSQLSQLStatementParser.LastFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#listAggFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListAggFunction(PostgreSQLSQLStatementParser.ListAggFunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code onOverflowErrorClause}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#listaggOverflowClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOnOverflowErrorClause(PostgreSQLSQLStatementParser.OnOverflowErrorClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code onOverflowTruncateClause}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#listaggOverflowClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOnOverflowTruncateClause(PostgreSQLSQLStatementParser.OnOverflowTruncateClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#windowFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWindowFunction(PostgreSQLSQLStatementParser.WindowFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#windowFunctionNullsOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWindowFunctionNullsOption(PostgreSQLSQLStatementParser.WindowFunctionNullsOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#windowFunctionFromOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWindowFunctionFromOption(PostgreSQLSQLStatementParser.WindowFunctionFromOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#overClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOverClause(PostgreSQLSQLStatementParser.OverClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#analyticClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnalyticClause(PostgreSQLSQLStatementParser.AnalyticClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#partitionByClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionByClause(PostgreSQLSQLStatementParser.PartitionByClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#windowFrameClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWindowFrameClause(PostgreSQLSQLStatementParser.WindowFrameClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#windowFrameUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWindowFrameUnit(PostgreSQLSQLStatementParser.WindowFrameUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#windowFrameExtent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWindowFrameExtent(PostgreSQLSQLStatementParser.WindowFrameExtentContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#windowFrameExtentItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWindowFrameExtentItem(PostgreSQLSQLStatementParser.WindowFrameExtentItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#cubeTableFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCubeTableFunction(PostgreSQLSQLStatementParser.CubeTableFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#cubeTableOptionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCubeTableOptionExpr(PostgreSQLSQLStatementParser.CubeTableOptionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#allocateExtentClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAllocateExtentClause(PostgreSQLSQLStatementParser.AllocateExtentClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#allocateExtentItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAllocateExtentItem(PostgreSQLSQLStatementParser.AllocateExtentItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#constraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstraint(PostgreSQLSQLStatementParser.ConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nullColumnConstraint}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#columnConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullColumnConstraint(PostgreSQLSQLStatementParser.NullColumnConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notNullColumnConstraint}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#columnConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotNullColumnConstraint(PostgreSQLSQLStatementParser.NotNullColumnConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code uniqueColumnConstraint}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#columnConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUniqueColumnConstraint(PostgreSQLSQLStatementParser.UniqueColumnConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryKeyColumnConstraint}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#columnConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryKeyColumnConstraint(PostgreSQLSQLStatementParser.PrimaryKeyColumnConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code referencesColumnConstraint}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#columnConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReferencesColumnConstraint(PostgreSQLSQLStatementParser.ReferencesColumnConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code checkColumnConstraint}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#columnConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCheckColumnConstraint(PostgreSQLSQLStatementParser.CheckColumnConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code scopeIsColumnConstraint}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#columnConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScopeIsColumnConstraint(PostgreSQLSQLStatementParser.ScopeIsColumnConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code withRowIdColumnConstraint}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#columnConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithRowIdColumnConstraint(PostgreSQLSQLStatementParser.WithRowIdColumnConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code uniqueTableConstraint}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#tableConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUniqueTableConstraint(PostgreSQLSQLStatementParser.UniqueTableConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryKeyTableConstraint}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#tableConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryKeyTableConstraint(PostgreSQLSQLStatementParser.PrimaryKeyTableConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code foreignKeyTableConstraint}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#tableConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForeignKeyTableConstraint(PostgreSQLSQLStatementParser.ForeignKeyTableConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code checkTableConstraint}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#tableConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCheckTableConstraint(PostgreSQLSQLStatementParser.CheckTableConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code scopeForTableConstraint}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#tableConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScopeForTableConstraint(PostgreSQLSQLStatementParser.ScopeForTableConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code refWithRowIdTableConstraint}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#tableConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRefWithRowIdTableConstraint(PostgreSQLSQLStatementParser.RefWithRowIdTableConstraintContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#iConstraintState}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIConstraintState(PostgreSQLSQLStatementParser.IConstraintStateContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#deferrableConstraintState}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeferrableConstraintState(PostgreSQLSQLStatementParser.DeferrableConstraintStateContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#notDeferrableConstraintState}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotDeferrableConstraintState(PostgreSQLSQLStatementParser.NotDeferrableConstraintStateContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#initiallyImmediateConstraintState}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitiallyImmediateConstraintState(PostgreSQLSQLStatementParser.InitiallyImmediateConstraintStateContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#initiallyDeferredConstraintState}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitiallyDeferredConstraintState(PostgreSQLSQLStatementParser.InitiallyDeferredConstraintStateContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#relyConstraintState}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelyConstraintState(PostgreSQLSQLStatementParser.RelyConstraintStateContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#noRelyConstraintState}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoRelyConstraintState(PostgreSQLSQLStatementParser.NoRelyConstraintStateContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#enableConstraintState}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnableConstraintState(PostgreSQLSQLStatementParser.EnableConstraintStateContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#disableConstraintState}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDisableConstraintState(PostgreSQLSQLStatementParser.DisableConstraintStateContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#validateConstraintState}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValidateConstraintState(PostgreSQLSQLStatementParser.ValidateConstraintStateContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#novalidateConstraintState}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNovalidateConstraintState(PostgreSQLSQLStatementParser.NovalidateConstraintStateContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#exceptionsClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExceptionsClause(PostgreSQLSQLStatementParser.ExceptionsClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#deallocateUnusedClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeallocateUnusedClause(PostgreSQLSQLStatementParser.DeallocateUnusedClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#fileSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFileSpecification(PostgreSQLSQLStatementParser.FileSpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#dataFileTempFileSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataFileTempFileSpec(PostgreSQLSQLStatementParser.DataFileTempFileSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#redoLogFileSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRedoLogFileSpec(PostgreSQLSQLStatementParser.RedoLogFileSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#autoExtendClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAutoExtendClause(PostgreSQLSQLStatementParser.AutoExtendClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#maxSizeClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMaxSizeClause(PostgreSQLSQLStatementParser.MaxSizeClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#loggingClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoggingClause(PostgreSQLSQLStatementParser.LoggingClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#parallelClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParallelClause(PostgreSQLSQLStatementParser.ParallelClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#physicalAttributesClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPhysicalAttributesClause(PostgreSQLSQLStatementParser.PhysicalAttributesClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#usageQueueClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUsageQueueClause(PostgreSQLSQLStatementParser.UsageQueueClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#pctfreeClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPctfreeClause(PostgreSQLSQLStatementParser.PctfreeClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#pctusedClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPctusedClause(PostgreSQLSQLStatementParser.PctusedClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#initransClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitransClause(PostgreSQLSQLStatementParser.InitransClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#maxtransClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMaxtransClause(PostgreSQLSQLStatementParser.MaxtransClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#sizeClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSizeClause(PostgreSQLSQLStatementParser.SizeClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#sizeType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSizeType(PostgreSQLSQLStatementParser.SizeTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#storageClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStorageClause(PostgreSQLSQLStatementParser.StorageClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code storageClauseInitialItem}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#storageClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStorageClauseInitialItem(PostgreSQLSQLStatementParser.StorageClauseInitialItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code storageClauseNextItem}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#storageClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStorageClauseNextItem(PostgreSQLSQLStatementParser.StorageClauseNextItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code storageClauseMinextentsItem}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#storageClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStorageClauseMinextentsItem(PostgreSQLSQLStatementParser.StorageClauseMinextentsItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code storageClauseMaxextentsItem}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#storageClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStorageClauseMaxextentsItem(PostgreSQLSQLStatementParser.StorageClauseMaxextentsItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code storageClauseMaxsizeItem}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#storageClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStorageClauseMaxsizeItem(PostgreSQLSQLStatementParser.StorageClauseMaxsizeItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code storageClausePctincreaseItem}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#storageClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStorageClausePctincreaseItem(PostgreSQLSQLStatementParser.StorageClausePctincreaseItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code storageClauseFreelistsItem}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#storageClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStorageClauseFreelistsItem(PostgreSQLSQLStatementParser.StorageClauseFreelistsItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code storageClauseFreelistGroupsItem}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#storageClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStorageClauseFreelistGroupsItem(PostgreSQLSQLStatementParser.StorageClauseFreelistGroupsItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code storageClauseOptimalItem}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#storageClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStorageClauseOptimalItem(PostgreSQLSQLStatementParser.StorageClauseOptimalItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code storageClauseBufferPoolItem}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#storageClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStorageClauseBufferPoolItem(PostgreSQLSQLStatementParser.StorageClauseBufferPoolItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code storageClauseFlashCacheItem}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#storageClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStorageClauseFlashCacheItem(PostgreSQLSQLStatementParser.StorageClauseFlashCacheItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code storageClauseCellFlashCacheItem}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#storageClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStorageClauseCellFlashCacheItem(PostgreSQLSQLStatementParser.StorageClauseCellFlashCacheItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code storageClauseEncryptItem}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#storageClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStorageClauseEncryptItem(PostgreSQLSQLStatementParser.StorageClauseEncryptItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code physicalPropertySegmentAttributesClause}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#physicalProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPhysicalPropertySegmentAttributesClause(PostgreSQLSQLStatementParser.PhysicalPropertySegmentAttributesClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code physicalPropertyOrganizationHeapClause}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#physicalProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPhysicalPropertyOrganizationHeapClause(PostgreSQLSQLStatementParser.PhysicalPropertyOrganizationHeapClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code physicalPropertyOrganizationIndexClause}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#physicalProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPhysicalPropertyOrganizationIndexClause(PostgreSQLSQLStatementParser.PhysicalPropertyOrganizationIndexClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code physicalPropertyOrganizationExternalClause}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#physicalProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPhysicalPropertyOrganizationExternalClause(PostgreSQLSQLStatementParser.PhysicalPropertyOrganizationExternalClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code physicalPropertyClusterClause}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#physicalProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPhysicalPropertyClusterClause(PostgreSQLSQLStatementParser.PhysicalPropertyClusterClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#externalTableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExternalTableClause(PostgreSQLSQLStatementParser.ExternalTableClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#externalTableDataProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExternalTableDataProperty(PostgreSQLSQLStatementParser.ExternalTableDataPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#accessParametersClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccessParametersClause(PostgreSQLSQLStatementParser.AccessParametersClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#accessParametersItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccessParametersItem(PostgreSQLSQLStatementParser.AccessParametersItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#readOnlyClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadOnlyClause(PostgreSQLSQLStatementParser.ReadOnlyClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#indexingClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexingClause(PostgreSQLSQLStatementParser.IndexingClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#deferredSegmentCreation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeferredSegmentCreation(PostgreSQLSQLStatementParser.DeferredSegmentCreationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#segmentAttributesClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSegmentAttributesClause(PostgreSQLSQLStatementParser.SegmentAttributesClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#tableSpaceClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableSpaceClause(PostgreSQLSQLStatementParser.TableSpaceClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#tableSpaceSetClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableSpaceSetClause(PostgreSQLSQLStatementParser.TableSpaceSetClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tableCompressionByCompress}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#tableCompression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableCompressionByCompress(PostgreSQLSQLStatementParser.TableCompressionByCompressContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tableCompressionByRowStoreCompress}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#tableCompression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableCompressionByRowStoreCompress(PostgreSQLSQLStatementParser.TableCompressionByRowStoreCompressContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tableCompressionByColumnStoreCompress}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#tableCompression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableCompressionByColumnStoreCompress(PostgreSQLSQLStatementParser.TableCompressionByColumnStoreCompressContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tableCompressionByNoCompress}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#tableCompression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableCompressionByNoCompress(PostgreSQLSQLStatementParser.TableCompressionByNoCompressContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#inMemoryTableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInMemoryTableClause(PostgreSQLSQLStatementParser.InMemoryTableClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#inMemoryAttributes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInMemoryAttributes(PostgreSQLSQLStatementParser.InMemoryAttributesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inMemoryMemCompressClause}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iInMemoryMemcompress}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInMemoryMemCompressClause(PostgreSQLSQLStatementParser.InMemoryMemCompressClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inMemoryNoMemCompressClause}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iInMemoryMemcompress}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInMemoryNoMemCompressClause(PostgreSQLSQLStatementParser.InMemoryNoMemCompressClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#inMemoryPriority}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInMemoryPriority(PostgreSQLSQLStatementParser.InMemoryPriorityContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#inMemoryDistribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInMemoryDistribute(PostgreSQLSQLStatementParser.InMemoryDistributeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inMemoryDuplicate}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iInMemoryDuplicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInMemoryDuplicate(PostgreSQLSQLStatementParser.InMemoryDuplicateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inMemoryDuplicateAll}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iInMemoryDuplicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInMemoryDuplicateAll(PostgreSQLSQLStatementParser.InMemoryDuplicateAllContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inMemoryNoDuplicate}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iInMemoryDuplicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInMemoryNoDuplicate(PostgreSQLSQLStatementParser.InMemoryNoDuplicateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inMemoryColumnClause}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iInMemoryColumnClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInMemoryColumnClause(PostgreSQLSQLStatementParser.InMemoryColumnClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code noInMemoryColumnClause}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iInMemoryColumnClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoInMemoryColumnClause(PostgreSQLSQLStatementParser.NoInMemoryColumnClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ilmClauseAddPolicy}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#ilmClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIlmClauseAddPolicy(PostgreSQLSQLStatementParser.IlmClauseAddPolicyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ilmClauseDeleteAll}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#ilmClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIlmClauseDeleteAll(PostgreSQLSQLStatementParser.IlmClauseDeleteAllContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ilmClauseEnableAll}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#ilmClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIlmClauseEnableAll(PostgreSQLSQLStatementParser.IlmClauseEnableAllContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ilmClauseDisableAll}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#ilmClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIlmClauseDisableAll(PostgreSQLSQLStatementParser.IlmClauseDisableAllContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#ilmPolicyClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIlmPolicyClause(PostgreSQLSQLStatementParser.IlmPolicyClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#ilmCompressionPolicy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIlmCompressionPolicy(PostgreSQLSQLStatementParser.IlmCompressionPolicyContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#ilmTieringPolicy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIlmTieringPolicy(PostgreSQLSQLStatementParser.IlmTieringPolicyContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#ilmInMemoryPolicy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIlmInMemoryPolicy(PostgreSQLSQLStatementParser.IlmInMemoryPolicyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ilmInMemoryPolicyBySetInMemory}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#ilmInMemoryPolicyAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIlmInMemoryPolicyBySetInMemory(PostgreSQLSQLStatementParser.IlmInMemoryPolicyBySetInMemoryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ilmInMemoryPolicyByModifyInMemory}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#ilmInMemoryPolicyAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIlmInMemoryPolicyByModifyInMemory(PostgreSQLSQLStatementParser.IlmInMemoryPolicyByModifyInMemoryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ilmInMemoryPolicyByNoInMemory}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#ilmInMemoryPolicyAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIlmInMemoryPolicyByNoInMemory(PostgreSQLSQLStatementParser.IlmInMemoryPolicyByNoInMemoryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ilmAfterOfClause}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#ilmPolicyOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIlmAfterOfClause(PostgreSQLSQLStatementParser.IlmAfterOfClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ilmOnClause}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#ilmPolicyOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIlmOnClause(PostgreSQLSQLStatementParser.IlmOnClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#ilmTimePeriod}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIlmTimePeriod(PostgreSQLSQLStatementParser.IlmTimePeriodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code substitutableColumnIsOfClause}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#substitutableColumnClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubstitutableColumnIsOfClause(PostgreSQLSQLStatementParser.SubstitutableColumnIsOfClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code substitutableColumnAtAllLevelsClause}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#substitutableColumnClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubstitutableColumnAtAllLevelsClause(PostgreSQLSQLStatementParser.SubstitutableColumnAtAllLevelsClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#nestedTableColProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNestedTableColProperty(PostgreSQLSQLStatementParser.NestedTableColPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#nestedTableColPropertyStoreAsItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNestedTableColPropertyStoreAsItem(PostgreSQLSQLStatementParser.NestedTableColPropertyStoreAsItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#varrayColProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarrayColProperty(PostgreSQLSQLStatementParser.VarrayColPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#varrayStorageClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarrayStorageClause(PostgreSQLSQLStatementParser.VarrayStorageClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#lobStorageClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobStorageClause(PostgreSQLSQLStatementParser.LobStorageClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#lobStorageClauseStoreAsItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobStorageClauseStoreAsItem(PostgreSQLSQLStatementParser.LobStorageClauseStoreAsItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#lobStorageParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobStorageParameters(PostgreSQLSQLStatementParser.LobStorageParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#lobStorageParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobStorageParameter(PostgreSQLSQLStatementParser.LobStorageParameterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lobParameterEnable}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#lobParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobParameterEnable(PostgreSQLSQLStatementParser.LobParameterEnableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lobParameterDisable}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#lobParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobParameterDisable(PostgreSQLSQLStatementParser.LobParameterDisableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lobParameterChunk}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#lobParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobParameterChunk(PostgreSQLSQLStatementParser.LobParameterChunkContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lobParameterPctversion}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#lobParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobParameterPctversion(PostgreSQLSQLStatementParser.LobParameterPctversionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lobParameterFreepools}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#lobParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobParameterFreepools(PostgreSQLSQLStatementParser.LobParameterFreepoolsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lobRetentionClause}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#lobParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobRetentionClause(PostgreSQLSQLStatementParser.LobRetentionClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lobDeduplicate}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#lobParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobDeduplicate(PostgreSQLSQLStatementParser.LobDeduplicateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lobKeepDuplicates}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#lobParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobKeepDuplicates(PostgreSQLSQLStatementParser.LobKeepDuplicatesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lobCompressionClause}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#lobParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobCompressionClause(PostgreSQLSQLStatementParser.LobCompressionClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lobNoCompressionClause}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#lobParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobNoCompressionClause(PostgreSQLSQLStatementParser.LobNoCompressionClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lobParameterEncrypt}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#lobParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobParameterEncrypt(PostgreSQLSQLStatementParser.LobParameterEncryptContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lobParameterDecrypt}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#lobParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobParameterDecrypt(PostgreSQLSQLStatementParser.LobParameterDecryptContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lobParameterCache}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#lobParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobParameterCache(PostgreSQLSQLStatementParser.LobParameterCacheContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lobParameterNoCache}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#lobParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobParameterNoCache(PostgreSQLSQLStatementParser.LobParameterNoCacheContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lobParameterCacheReads}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#lobParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobParameterCacheReads(PostgreSQLSQLStatementParser.LobParameterCacheReadsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lobParameterRebuildFreepools}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#lobParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobParameterRebuildFreepools(PostgreSQLSQLStatementParser.LobParameterRebuildFreepoolsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#lobPartitionStorage}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobPartitionStorage(PostgreSQLSQLStatementParser.LobPartitionStorageContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#lobPartitionStoragePartitionItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobPartitionStoragePartitionItem(PostgreSQLSQLStatementParser.LobPartitionStoragePartitionItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#lobPartitionStorageSubpartitionItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobPartitionStorageSubpartitionItem(PostgreSQLSQLStatementParser.LobPartitionStorageSubpartitionItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#lobPartitioningStorage}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobPartitioningStorage(PostgreSQLSQLStatementParser.LobPartitioningStorageContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#xmlTypeColumnProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlTypeColumnProperty(PostgreSQLSQLStatementParser.XmlTypeColumnPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#xmlTypeStorage}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlTypeStorage(PostgreSQLSQLStatementParser.XmlTypeStorageContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#xmlSchemaSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlSchemaSpec(PostgreSQLSQLStatementParser.XmlSchemaSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#xmlTypeVirtualColumns}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlTypeVirtualColumns(PostgreSQLSQLStatementParser.XmlTypeVirtualColumnsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#xmlTypeVirtualColumnsItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlTypeVirtualColumnsItem(PostgreSQLSQLStatementParser.XmlTypeVirtualColumnsItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code flashbackArchiveClause}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iFlashbackArchiveClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlashbackArchiveClause(PostgreSQLSQLStatementParser.FlashbackArchiveClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code noFlashbackArchiveClause}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iFlashbackArchiveClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoFlashbackArchiveClause(PostgreSQLSQLStatementParser.NoFlashbackArchiveClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#storeInClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStoreInClause(PostgreSQLSQLStatementParser.StoreInClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#overflowStoreInClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOverflowStoreInClause(PostgreSQLSQLStatementParser.OverflowStoreInClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#subPartitionsetStoreInClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubPartitionsetStoreInClause(PostgreSQLSQLStatementParser.SubPartitionsetStoreInClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#tablePartitioningClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTablePartitioningClause(PostgreSQLSQLStatementParser.TablePartitioningClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#iPartitionBy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIPartitionBy(PostgreSQLSQLStatementParser.IPartitionByContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#partitionByRange}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionByRange(PostgreSQLSQLStatementParser.PartitionByRangeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#partitionByHash}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionByHash(PostgreSQLSQLStatementParser.PartitionByHashContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#partitionByList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionByList(PostgreSQLSQLStatementParser.PartitionByListContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#partitionByReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionByReference(PostgreSQLSQLStatementParser.PartitionByReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#partitionBySystem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionBySystem(PostgreSQLSQLStatementParser.PartitionBySystemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#partitionByConsistentHash}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionByConsistentHash(PostgreSQLSQLStatementParser.PartitionByConsistentHashContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#partitionDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionDefinition(PostgreSQLSQLStatementParser.PartitionDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#partitionDefinitionOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionDefinitionOption(PostgreSQLSQLStatementParser.PartitionDefinitionOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#ipartitionsetBy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIpartitionsetBy(PostgreSQLSQLStatementParser.IpartitionsetByContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#partitionsetByRange}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionsetByRange(PostgreSQLSQLStatementParser.PartitionsetByRangeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#partitionsetByList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionsetByList(PostgreSQLSQLStatementParser.PartitionsetByListContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#partitionsetDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionsetDefinition(PostgreSQLSQLStatementParser.PartitionsetDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#partitionsetDefinitionOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionsetDefinitionOption(PostgreSQLSQLStatementParser.PartitionsetDefinitionOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#directoryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDirectoryExpr(PostgreSQLSQLStatementParser.DirectoryExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#iCompression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitICompression(PostgreSQLSQLStatementParser.ICompressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code partitionValuesLessThan}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iPartitionValues}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionValuesLessThan(PostgreSQLSQLStatementParser.PartitionValuesLessThanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code partitionValues}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iPartitionValues}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionValues(PostgreSQLSQLStatementParser.PartitionValuesContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#iSubPartitionBy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitISubPartitionBy(PostgreSQLSQLStatementParser.ISubPartitionByContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#subpartitionTemplate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubpartitionTemplate(PostgreSQLSQLStatementParser.SubpartitionTemplateContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#subpartitionByRange}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubpartitionByRange(PostgreSQLSQLStatementParser.SubpartitionByRangeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#subpartitionByList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubpartitionByList(PostgreSQLSQLStatementParser.SubpartitionByListContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#subpartitionByHash}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubpartitionByHash(PostgreSQLSQLStatementParser.SubpartitionByHashContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#subPartitionDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubPartitionDefinition(PostgreSQLSQLStatementParser.SubPartitionDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#subPartitionDefinitionOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubPartitionDefinitionOption(PostgreSQLSQLStatementParser.SubPartitionDefinitionOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#partitioningStorageClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitioningStorageClause(PostgreSQLSQLStatementParser.PartitioningStorageClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#overflowClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOverflowClause(PostgreSQLSQLStatementParser.OverflowClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#overflowClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOverflowClauseItem(PostgreSQLSQLStatementParser.OverflowClauseItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#varrayStorageAsClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarrayStorageAsClause(PostgreSQLSQLStatementParser.VarrayStorageAsClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inMemoryClause}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iInMemoryClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInMemoryClause(PostgreSQLSQLStatementParser.InMemoryClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code noInMemoryClause}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iInMemoryClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoInMemoryClause(PostgreSQLSQLStatementParser.NoInMemoryClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#accessibleByClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccessibleByClause(PostgreSQLSQLStatementParser.AccessibleByClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#accessor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccessor(PostgreSQLSQLStatementParser.AccessorContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#unitKind}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnitKind(PostgreSQLSQLStatementParser.UnitKindContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#aggregateClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAggregateClause(PostgreSQLSQLStatementParser.AggregateClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#assignmentStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentStatement(PostgreSQLSQLStatementParser.AssignmentStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#autonomousTransPragma}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAutonomousTransPragma(PostgreSQLSQLStatementParser.AutonomousTransPragmaContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#basicLoopStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicLoopStatement(PostgreSQLSQLStatementParser.BasicLoopStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#plsqlBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlsqlBlock(PostgreSQLSQLStatementParser.PlsqlBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#declareSection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclareSection(PostgreSQLSQLStatementParser.DeclareSectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#declareSectionItem1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclareSectionItem1(PostgreSQLSQLStatementParser.DeclareSectionItem1Context ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#declareSectionItem2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclareSectionItem2(PostgreSQLSQLStatementParser.DeclareSectionItem2Context ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#typeDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDefinition(PostgreSQLSQLStatementParser.TypeDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#subTypeDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubTypeDefinition(PostgreSQLSQLStatementParser.SubTypeDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#subTypeDefinitionConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubTypeDefinitionConstraint(PostgreSQLSQLStatementParser.SubTypeDefinitionConstraintContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#rangeExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRangeExpr(PostgreSQLSQLStatementParser.RangeExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#itemDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitItemDeclaration(PostgreSQLSQLStatementParser.ItemDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(PostgreSQLSQLStatementParser.BodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#bodyItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBodyItem(PostgreSQLSQLStatementParser.BodyItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#labelDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabelDeclaration(PostgreSQLSQLStatementParser.LabelDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#bodyItemStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBodyItemStatement(PostgreSQLSQLStatementParser.BodyItemStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#procedureCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedureCall(PostgreSQLSQLStatementParser.ProcedureCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code javaDeclaration}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#callSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJavaDeclaration(PostgreSQLSQLStatementParser.JavaDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cDeclaration}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#callSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCDeclaration(PostgreSQLSQLStatementParser.CDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code languageCName}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#cDeclarationName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLanguageCName(PostgreSQLSQLStatementParser.LanguageCNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code languageClibraryName}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#cDeclarationName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLanguageClibraryName(PostgreSQLSQLStatementParser.LanguageClibraryNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#withContext}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithContext(PostgreSQLSQLStatementParser.WithContextContext ctx);
	/**
	 * Visit a parse tree produced by the {@code contextExternalParameter}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#externalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContextExternalParameter(PostgreSQLSQLStatementParser.ContextExternalParameterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code selfExternalParameter}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#externalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelfExternalParameter(PostgreSQLSQLStatementParser.SelfExternalParameterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code returnExternalParameter}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#externalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnExternalParameter(PostgreSQLSQLStatementParser.ReturnExternalParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#externalParameterProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExternalParameterProperty(PostgreSQLSQLStatementParser.ExternalParameterPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#byReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitByReference(PostgreSQLSQLStatementParser.ByReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#caseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseStatement(PostgreSQLSQLStatementParser.CaseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#caseStatementWhenItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseStatementWhenItem(PostgreSQLSQLStatementParser.CaseStatementWhenItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#caseStatementElseClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseStatementElseClause(PostgreSQLSQLStatementParser.CaseStatementElseClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#closeStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCloseStatement(PostgreSQLSQLStatementParser.CloseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#collectionMethodCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCollectionMethodCall(PostgreSQLSQLStatementParser.CollectionMethodCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#collectionMethod}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCollectionMethod(PostgreSQLSQLStatementParser.CollectionMethodContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#collectionTypeDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCollectionTypeDefinition(PostgreSQLSQLStatementParser.CollectionTypeDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#compileClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompileClause(PostgreSQLSQLStatementParser.CompileClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#constantDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantDeclaration(PostgreSQLSQLStatementParser.ConstantDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#continueStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueStatement(PostgreSQLSQLStatementParser.ContinueStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#coveragePragma}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCoveragePragma(PostgreSQLSQLStatementParser.CoveragePragmaContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#refCursorTypeDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRefCursorTypeDefinition(PostgreSQLSQLStatementParser.RefCursorTypeDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#collationExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCollationExpr(PostgreSQLSQLStatementParser.CollationExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#collateExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCollateExpr(PostgreSQLSQLStatementParser.CollateExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#deprecatePragma}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeprecatePragma(PostgreSQLSQLStatementParser.DeprecatePragmaContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#deterministicClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeterministicClause(PostgreSQLSQLStatementParser.DeterministicClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#elementSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementSpec(PostgreSQLSQLStatementParser.ElementSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#elementSpecItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementSpecItem(PostgreSQLSQLStatementParser.ElementSpecItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#inheritanceClauses}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInheritanceClauses(PostgreSQLSQLStatementParser.InheritanceClausesContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#subProgramDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubProgramDeclaration(PostgreSQLSQLStatementParser.SubProgramDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#subProgramExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubProgramExpr(PostgreSQLSQLStatementParser.SubProgramExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#constructorDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorDeclaration(PostgreSQLSQLStatementParser.ConstructorDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#constructorDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorDefinition(PostgreSQLSQLStatementParser.ConstructorDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#mapOrderFunctionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMapOrderFunctionDeclaration(PostgreSQLSQLStatementParser.MapOrderFunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#mapOrderFunctionDeclarationItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMapOrderFunctionDeclarationItem(PostgreSQLSQLStatementParser.MapOrderFunctionDeclarationItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code externalNameClause}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iExternalNameClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExternalNameClause(PostgreSQLSQLStatementParser.ExternalNameClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code externalVariableNameClause}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iExternalNameClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExternalVariableNameClause(PostgreSQLSQLStatementParser.ExternalVariableNameClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#exceptionInitPragma}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExceptionInitPragma(PostgreSQLSQLStatementParser.ExceptionInitPragmaContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#exceptionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExceptionDeclaration(PostgreSQLSQLStatementParser.ExceptionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#exceptionHandler}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExceptionHandler(PostgreSQLSQLStatementParser.ExceptionHandlerContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#executeImmediateStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExecuteImmediateStatement(PostgreSQLSQLStatementParser.ExecuteImmediateStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#exitStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExitStatement(PostgreSQLSQLStatementParser.ExitStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#cursorDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCursorDeclaration(PostgreSQLSQLStatementParser.CursorDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#cursorDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCursorDefinition(PostgreSQLSQLStatementParser.CursorDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#fetchStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFetchStatement(PostgreSQLSQLStatementParser.FetchStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#forLoopStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForLoopStatement(PostgreSQLSQLStatementParser.ForLoopStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#forLoopStatementCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForLoopStatementCondition(PostgreSQLSQLStatementParser.ForLoopStatementConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#forallStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForallStatement(PostgreSQLSQLStatementParser.ForallStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boundsClause}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iBoundsClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoundsClause(PostgreSQLSQLStatementParser.BoundsClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boundsClauseByIndicesOf}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iBoundsClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoundsClauseByIndicesOf(PostgreSQLSQLStatementParser.BoundsClauseByIndicesOfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boundsClauseByValuesOf}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iBoundsClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoundsClauseByValuesOf(PostgreSQLSQLStatementParser.BoundsClauseByValuesOfContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#parameterDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterDeclaration(PostgreSQLSQLStatementParser.ParameterDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#parameterModel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterModel(PostgreSQLSQLStatementParser.ParameterModelContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#functionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(PostgreSQLSQLStatementParser.FunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#functionDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDefinition(PostgreSQLSQLStatementParser.FunctionDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#functionProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionProperty(PostgreSQLSQLStatementParser.FunctionPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#functionHeading}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionHeading(PostgreSQLSQLStatementParser.FunctionHeadingContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#gotoStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGotoStatement(PostgreSQLSQLStatementParser.GotoStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(PostgreSQLSQLStatementParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#ifStatementElsIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatementElsIf(PostgreSQLSQLStatementParser.IfStatementElsIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#inlinePragma}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInlinePragma(PostgreSQLSQLStatementParser.InlinePragmaContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#invokerRightsClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInvokerRightsClause(PostgreSQLSQLStatementParser.InvokerRightsClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#nullStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullStatement(PostgreSQLSQLStatementParser.NullStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#openStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpenStatement(PostgreSQLSQLStatementParser.OpenStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#openForStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpenForStatement(PostgreSQLSQLStatementParser.OpenForStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parallelEnableClause}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iParallelEnableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParallelEnableClause(PostgreSQLSQLStatementParser.ParallelEnableClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parallelEnableByAnyClause}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iParallelEnableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParallelEnableByAnyClause(PostgreSQLSQLStatementParser.ParallelEnableByAnyClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parallelEnableByHashClause}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iParallelEnableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParallelEnableByHashClause(PostgreSQLSQLStatementParser.ParallelEnableByHashClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parallelEnableByRangeClause}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iParallelEnableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParallelEnableByRangeClause(PostgreSQLSQLStatementParser.ParallelEnableByRangeClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parallelEnableByValueClause}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iParallelEnableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParallelEnableByValueClause(PostgreSQLSQLStatementParser.ParallelEnableByValueClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#streamingClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStreamingClause(PostgreSQLSQLStatementParser.StreamingClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#pipeRowStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPipeRowStatement(PostgreSQLSQLStatementParser.PipeRowStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pipelinedClause}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iPipelinedClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPipelinedClause(PostgreSQLSQLStatementParser.PipelinedClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pipelinedByUsingClause}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iPipelinedClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPipelinedByUsingClause(PostgreSQLSQLStatementParser.PipelinedByUsingClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pipelinedByRowClause}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iPipelinedClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPipelinedByRowClause(PostgreSQLSQLStatementParser.PipelinedByRowClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pipelinedByTableClause}
	 * labeled alternative in {@link PostgreSQLSQLStatementParser#iPipelinedClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPipelinedByTableClause(PostgreSQLSQLStatementParser.PipelinedByTableClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#procedureDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedureDeclaration(PostgreSQLSQLStatementParser.ProcedureDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#procedureDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedureDefinition(PostgreSQLSQLStatementParser.ProcedureDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#procedureHeading}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedureHeading(PostgreSQLSQLStatementParser.ProcedureHeadingContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#procedureProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedureProperty(PostgreSQLSQLStatementParser.ProcedurePropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#raiseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRaiseStatement(PostgreSQLSQLStatementParser.RaiseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#recordTypeDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordTypeDefinition(PostgreSQLSQLStatementParser.RecordTypeDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#restrictReferencesPragma}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRestrictReferencesPragma(PostgreSQLSQLStatementParser.RestrictReferencesPragmaContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(PostgreSQLSQLStatementParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#returningIntoClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturningIntoClause(PostgreSQLSQLStatementParser.ReturningIntoClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#resultCacheClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResultCacheClause(PostgreSQLSQLStatementParser.ResultCacheClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(PostgreSQLSQLStatementParser.VariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#selectIntoStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectIntoStatement(PostgreSQLSQLStatementParser.SelectIntoStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#selectTargetItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectTargetItem(PostgreSQLSQLStatementParser.SelectTargetItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#seriallyReusablePragma}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSeriallyReusablePragma(PostgreSQLSQLStatementParser.SeriallyReusablePragmaContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#udfPragma}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUdfPragma(PostgreSQLSQLStatementParser.UdfPragmaContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#whileLoopStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileLoopStatement(PostgreSQLSQLStatementParser.WhileLoopStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#orReplace}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrReplace(PostgreSQLSQLStatementParser.OrReplaceContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#ifNotExists}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfNotExists(PostgreSQLSQLStatementParser.IfNotExistsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#notNull}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotNull(PostgreSQLSQLStatementParser.NotNullContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#bulkCollect}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBulkCollect(PostgreSQLSQLStatementParser.BulkCollectContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#errorLoggingClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitErrorLoggingClause(PostgreSQLSQLStatementParser.ErrorLoggingClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#saveExceptions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSaveExceptions(PostgreSQLSQLStatementParser.SaveExceptionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#editionableType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEditionableType(PostgreSQLSQLStatementParser.EditionableTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#asType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsType(PostgreSQLSQLStatementParser.AsTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#visibleType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVisibleType(PostgreSQLSQLStatementParser.VisibleTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#generatedAlways}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGeneratedAlways(PostgreSQLSQLStatementParser.GeneratedAlwaysContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#forUpdate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForUpdate(PostgreSQLSQLStatementParser.ForUpdateContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#partitionsAuto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionsAuto(PostgreSQLSQLStatementParser.PartitionsAutoContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#enableType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnableType(PostgreSQLSQLStatementParser.EnableTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#cacheType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCacheType(PostgreSQLSQLStatementParser.CacheTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#basicFileType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicFileType(PostgreSQLSQLStatementParser.BasicFileTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#invalidationType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInvalidationType(PostgreSQLSQLStatementParser.InvalidationTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#validateType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValidateType(PostgreSQLSQLStatementParser.ValidateTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#forceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForceType(PostgreSQLSQLStatementParser.ForceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#keepIndexType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeepIndexType(PostgreSQLSQLStatementParser.KeepIndexTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostgreSQLSQLStatementParser#yesType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitYesType(PostgreSQLSQLStatementParser.YesTypeContext ctx);
}