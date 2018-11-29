// Generated from /Users/kongtong.ouyang/IdeaProjects/gumiho/gumiho/src/main/resources/grammars/sql/dialect/ppas/PPASSQLStatementParser.g4 by ANTLR 4.7
package grammars.sql.dialect.ppas;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PPASSQLStatementParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PPASSQLStatementParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#parse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParse(PPASSQLStatementParser.ParseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#swallow_to_semi}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwallow_to_semi(PPASSQLStatementParser.Swallow_to_semiContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#emptyStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyStatement(PPASSQLStatementParser.EmptyStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(PPASSQLStatementParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#ddlStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDdlStatement(PPASSQLStatementParser.DdlStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#dmlStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDmlStatement(PPASSQLStatementParser.DmlStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#fclStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFclStatement(PPASSQLStatementParser.FclStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#tclStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTclStatement(PPASSQLStatementParser.TclStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#sclStatment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSclStatment(PPASSQLStatementParser.SclStatmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommand(PPASSQLStatementParser.CommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#createDatabaseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateDatabaseStatement(PPASSQLStatementParser.CreateDatabaseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#userSysClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUserSysClause(PPASSQLStatementParser.UserSysClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#userSystemClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUserSystemClause(PPASSQLStatementParser.UserSystemClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#controlfileReuseClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitControlfileReuseClause(PPASSQLStatementParser.ControlfileReuseClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#maxdatafilesClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMaxdatafilesClause(PPASSQLStatementParser.MaxdatafilesClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#maxinstancesClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMaxinstancesClause(PPASSQLStatementParser.MaxinstancesClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#characterSet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharacterSet(PPASSQLStatementParser.CharacterSetContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#nationalCharacterSet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNationalCharacterSet(PPASSQLStatementParser.NationalCharacterSetContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#setDefaultTablespaceClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetDefaultTablespaceClause(PPASSQLStatementParser.SetDefaultTablespaceClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#extentManagementClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtentManagementClause(PPASSQLStatementParser.ExtentManagementClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#extentManagementLocalClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtentManagementLocalClause(PPASSQLStatementParser.ExtentManagementLocalClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#extentManagementLocalAutoAllocateClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtentManagementLocalAutoAllocateClause(PPASSQLStatementParser.ExtentManagementLocalAutoAllocateClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#extentManagementLocalUniformClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtentManagementLocalUniformClause(PPASSQLStatementParser.ExtentManagementLocalUniformClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#dataFileClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataFileClause(PPASSQLStatementParser.DataFileClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#sysauxClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSysauxClause(PPASSQLStatementParser.SysauxClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#defaultTablespace}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultTablespace(PPASSQLStatementParser.DefaultTablespaceContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#defaultTempTablespace}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultTempTablespace(PPASSQLStatementParser.DefaultTempTablespaceContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#undoTablespace}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUndoTablespace(PPASSQLStatementParser.UndoTablespaceContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#setTimeZoneClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetTimeZoneClause(PPASSQLStatementParser.SetTimeZoneClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#userDataTablespaceClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUserDataTablespaceClause(PPASSQLStatementParser.UserDataTablespaceClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#enablePluggableDatabase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnablePluggableDatabase(PPASSQLStatementParser.EnablePluggableDatabaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#fileNameConvert}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFileNameConvert(PPASSQLStatementParser.FileNameConvertContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#fileNameConvertFile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFileNameConvertFile(PPASSQLStatementParser.FileNameConvertFileContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#fileNameConvertNone}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFileNameConvertNone(PPASSQLStatementParser.FileNameConvertNoneContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#tablespaceDatafileClauses}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTablespaceDatafileClauses(PPASSQLStatementParser.TablespaceDatafileClausesContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#databaseLogFileClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDatabaseLogFileClause(PPASSQLStatementParser.DatabaseLogFileClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#databaseMaxLogFilesClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDatabaseMaxLogFilesClause(PPASSQLStatementParser.DatabaseMaxLogFilesClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#databaseMaxLogMembersClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDatabaseMaxLogMembersClause(PPASSQLStatementParser.DatabaseMaxLogMembersClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#databaseMaxLogHistoryClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDatabaseMaxLogHistoryClause(PPASSQLStatementParser.DatabaseMaxLogHistoryClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#databaseArchiveLogTypeClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDatabaseArchiveLogTypeClause(PPASSQLStatementParser.DatabaseArchiveLogTypeClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#databaseForceLoggingClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDatabaseForceLoggingClause(PPASSQLStatementParser.DatabaseForceLoggingClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#createDatabaseLinkStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateDatabaseLinkStatement(PPASSQLStatementParser.CreateDatabaseLinkStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#connectToCurrentUser}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConnectToCurrentUser(PPASSQLStatementParser.ConnectToCurrentUserContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#connectToIdentifiedBy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConnectToIdentifiedBy(PPASSQLStatementParser.ConnectToIdentifiedByContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#dblinkAuthentication}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDblinkAuthentication(PPASSQLStatementParser.DblinkAuthenticationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#dblinkUsing}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDblinkUsing(PPASSQLStatementParser.DblinkUsingContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#createFunctionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateFunctionStatement(PPASSQLStatementParser.CreateFunctionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterFunctionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterFunctionStatement(PPASSQLStatementParser.AlterFunctionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#dropFunctionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropFunctionStatement(PPASSQLStatementParser.DropFunctionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#functionOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionOption(PPASSQLStatementParser.FunctionOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterFunctionOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterFunctionOption(PPASSQLStatementParser.AlterFunctionOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#createIndexStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateIndexStatement(PPASSQLStatementParser.CreateIndexStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterIndexStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexStatement(PPASSQLStatementParser.AlterIndexStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#dropIndexStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropIndexStatement(PPASSQLStatementParser.DropIndexStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#createIndexStatementColumn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateIndexStatementColumn(PPASSQLStatementParser.CreateIndexStatementColumnContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#createIndexStatementOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateIndexStatementOption(PPASSQLStatementParser.CreateIndexStatementOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#indexProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexProperty(PPASSQLStatementParser.IndexPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#indexTypeIsIndexTypeClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexTypeIsIndexTypeClause(PPASSQLStatementParser.IndexTypeIsIndexTypeClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#indexAttribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexAttribute(PPASSQLStatementParser.IndexAttributeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#indexAttributeOnline}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexAttributeOnline(PPASSQLStatementParser.IndexAttributeOnlineContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#indexAttributeComputeStatistics}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexAttributeComputeStatistics(PPASSQLStatementParser.IndexAttributeComputeStatisticsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#indexAttributeSort}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexAttributeSort(PPASSQLStatementParser.IndexAttributeSortContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#indexAttributeNoSort}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexAttributeNoSort(PPASSQLStatementParser.IndexAttributeNoSortContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#indexAttributeReverse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexAttributeReverse(PPASSQLStatementParser.IndexAttributeReverseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#indexAttributeVisible}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexAttributeVisible(PPASSQLStatementParser.IndexAttributeVisibleContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#indexAttributeInvisible}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexAttributeInvisible(PPASSQLStatementParser.IndexAttributeInvisibleContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#partialIndexClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartialIndexClause(PPASSQLStatementParser.PartialIndexClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#parametersClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametersClause(PPASSQLStatementParser.ParametersClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code globalPartitionByRange}
	 * labeled alternative in {@link PPASSQLStatementParser#iGlobalPartitionBy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobalPartitionByRange(PPASSQLStatementParser.GlobalPartitionByRangeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code globalPartitionByHash}
	 * labeled alternative in {@link PPASSQLStatementParser#iGlobalPartitionBy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobalPartitionByHash(PPASSQLStatementParser.GlobalPartitionByHashContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#localPartitionIndex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalPartitionIndex(PPASSQLStatementParser.LocalPartitionIndexContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterIndexStatementOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexStatementOption(PPASSQLStatementParser.AlterIndexStatementOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterIndexStatementProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexStatementProperty(PPASSQLStatementParser.AlterIndexStatementPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#shrinkClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShrinkClause(PPASSQLStatementParser.ShrinkClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#rebuildClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRebuildClause(PPASSQLStatementParser.RebuildClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterIndexCompileOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexCompileOption(PPASSQLStatementParser.AlterIndexCompileOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterIndexEnableOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexEnableOption(PPASSQLStatementParser.AlterIndexEnableOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterIndexDisableOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexDisableOption(PPASSQLStatementParser.AlterIndexDisableOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterIndexUnusableOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexUnusableOption(PPASSQLStatementParser.AlterIndexUnusableOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterIndexVisibleOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexVisibleOption(PPASSQLStatementParser.AlterIndexVisibleOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterIndexInvisibleOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexInvisibleOption(PPASSQLStatementParser.AlterIndexInvisibleOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterIndexMonitoringUsageOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexMonitoringUsageOption(PPASSQLStatementParser.AlterIndexMonitoringUsageOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterIndexCoalesceOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexCoalesceOption(PPASSQLStatementParser.AlterIndexCoalesceOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterIndexNoMonitoringUsageOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexNoMonitoringUsageOption(PPASSQLStatementParser.AlterIndexNoMonitoringUsageOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterIndexUpdateBlockReferencesOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexUpdateBlockReferencesOption(PPASSQLStatementParser.AlterIndexUpdateBlockReferencesOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterIndexPartitioning}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexPartitioning(PPASSQLStatementParser.AlterIndexPartitioningContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterIndexModifyDefaultAttrsAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexModifyDefaultAttrsAction(PPASSQLStatementParser.AlterIndexModifyDefaultAttrsActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#modifyDefaultAttrItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModifyDefaultAttrItem(PPASSQLStatementParser.ModifyDefaultAttrItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterIndexAddPartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexAddPartitionAction(PPASSQLStatementParser.AlterIndexAddPartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterIndexCoalescePartition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexCoalescePartition(PPASSQLStatementParser.AlterIndexCoalescePartitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterIndexModifyPartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexModifyPartitionAction(PPASSQLStatementParser.AlterIndexModifyPartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterIndexRenamePartition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexRenamePartition(PPASSQLStatementParser.AlterIndexRenamePartitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterIndexRenameSubPartition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexRenameSubPartition(PPASSQLStatementParser.AlterIndexRenameSubPartitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterIndexDropPartition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexDropPartition(PPASSQLStatementParser.AlterIndexDropPartitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterIndexSplitPartition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexSplitPartition(PPASSQLStatementParser.AlterIndexSplitPartitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterIndexModifySubpartition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexModifySubpartition(PPASSQLStatementParser.AlterIndexModifySubpartitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterIndexModifySubpartitionOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexModifySubpartitionOption(PPASSQLStatementParser.AlterIndexModifySubpartitionOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#modifySubpartitionUnusableOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModifySubpartitionUnusableOption(PPASSQLStatementParser.ModifySubpartitionUnusableOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#createPackageStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreatePackageStatement(PPASSQLStatementParser.CreatePackageStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterPackageStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterPackageStatement(PPASSQLStatementParser.AlterPackageStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#dropPackageStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropPackageStatement(PPASSQLStatementParser.DropPackageStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#createPackageBodyStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreatePackageBodyStatement(PPASSQLStatementParser.CreatePackageBodyStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#dropPackageBodyStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropPackageBodyStatement(PPASSQLStatementParser.DropPackageBodyStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#createPackageStatementOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreatePackageStatementOption(PPASSQLStatementParser.CreatePackageStatementOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#createPackageStatementItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreatePackageStatementItem(PPASSQLStatementParser.CreatePackageStatementItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#createPackageBodyStatementItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreatePackageBodyStatementItem(PPASSQLStatementParser.CreatePackageBodyStatementItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterPackageStatementOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterPackageStatementOption(PPASSQLStatementParser.AlterPackageStatementOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#createProcedureStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateProcedureStatement(PPASSQLStatementParser.CreateProcedureStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterProcedureStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterProcedureStatement(PPASSQLStatementParser.AlterProcedureStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#dropProcedureStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropProcedureStatement(PPASSQLStatementParser.DropProcedureStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#createProcedureStatementOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateProcedureStatementOption(PPASSQLStatementParser.CreateProcedureStatementOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterProcedureStatementOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterProcedureStatementOption(PPASSQLStatementParser.AlterProcedureStatementOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#createSequenceStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateSequenceStatement(PPASSQLStatementParser.CreateSequenceStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterSequenceStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterSequenceStatement(PPASSQLStatementParser.AlterSequenceStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#dropSequenceStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropSequenceStatement(PPASSQLStatementParser.DropSequenceStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#createSequenceOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateSequenceOption(PPASSQLStatementParser.CreateSequenceOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterSequenceOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterSequenceOption(PPASSQLStatementParser.AlterSequenceOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#startWithSequenceOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStartWithSequenceOption(PPASSQLStatementParser.StartWithSequenceOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#incrementBySequenceOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncrementBySequenceOption(PPASSQLStatementParser.IncrementBySequenceOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#maxValueSequenceOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMaxValueSequenceOption(PPASSQLStatementParser.MaxValueSequenceOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#noMaxValueSequenceOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoMaxValueSequenceOption(PPASSQLStatementParser.NoMaxValueSequenceOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#minValueSequenceOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinValueSequenceOption(PPASSQLStatementParser.MinValueSequenceOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#noMinValueSequenceOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoMinValueSequenceOption(PPASSQLStatementParser.NoMinValueSequenceOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#cycleSequenceOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCycleSequenceOption(PPASSQLStatementParser.CycleSequenceOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#noCycleSequenceOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoCycleSequenceOption(PPASSQLStatementParser.NoCycleSequenceOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#cacheSequenceOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCacheSequenceOption(PPASSQLStatementParser.CacheSequenceOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#noCacheSequenceOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoCacheSequenceOption(PPASSQLStatementParser.NoCacheSequenceOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#orderSequenceOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrderSequenceOption(PPASSQLStatementParser.OrderSequenceOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#noOrderSequenceOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoOrderSequenceOption(PPASSQLStatementParser.NoOrderSequenceOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#keepSequenceOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeepSequenceOption(PPASSQLStatementParser.KeepSequenceOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#noKeepSequenceOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoKeepSequenceOption(PPASSQLStatementParser.NoKeepSequenceOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#scaleOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScaleOption(PPASSQLStatementParser.ScaleOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#noScaleOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoScaleOption(PPASSQLStatementParser.NoScaleOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#sessionSequenceOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSessionSequenceOption(PPASSQLStatementParser.SessionSequenceOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#globalSequenceOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobalSequenceOption(PPASSQLStatementParser.GlobalSequenceOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#createSynonymStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateSynonymStatement(PPASSQLStatementParser.CreateSynonymStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterSynonymStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterSynonymStatement(PPASSQLStatementParser.AlterSynonymStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#dropSynonymStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropSynonymStatement(PPASSQLStatementParser.DropSynonymStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#createTableStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTableStatement(PPASSQLStatementParser.CreateTableStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterTableStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableStatement(PPASSQLStatementParser.AlterTableStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#dropTableStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropTableStatement(PPASSQLStatementParser.DropTableStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#tableScope}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableScope(PPASSQLStatementParser.TableScopeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#tableElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableElement(PPASSQLStatementParser.TableElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#iColumnDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIColumnDefinition(PPASSQLStatementParser.IColumnDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#memoptimizeForRead}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemoptimizeForRead(PPASSQLStatementParser.MemoptimizeForReadContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#columnDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnDefinition(PPASSQLStatementParser.ColumnDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#identityClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentityClause(PPASSQLStatementParser.IdentityClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#onNull}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOnNull(PPASSQLStatementParser.OnNullContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#identityOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentityOption(PPASSQLStatementParser.IdentityOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#identityStartWithOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentityStartWithOption(PPASSQLStatementParser.IdentityStartWithOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#identityIncrementByOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentityIncrementByOption(PPASSQLStatementParser.IdentityIncrementByOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#identityMaxValueOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentityMaxValueOption(PPASSQLStatementParser.IdentityMaxValueOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#identityNoMaxValueOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentityNoMaxValueOption(PPASSQLStatementParser.IdentityNoMaxValueOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#identityMinValueOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentityMinValueOption(PPASSQLStatementParser.IdentityMinValueOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#identityNoMinValueOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentityNoMinValueOption(PPASSQLStatementParser.IdentityNoMinValueOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#identityCycleOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentityCycleOption(PPASSQLStatementParser.IdentityCycleOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#identityNoCycleOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentityNoCycleOption(PPASSQLStatementParser.IdentityNoCycleOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#identityCacheOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentityCacheOption(PPASSQLStatementParser.IdentityCacheOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#identityNoCacheOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentityNoCacheOption(PPASSQLStatementParser.IdentityNoCacheOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#identityOrderOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentityOrderOption(PPASSQLStatementParser.IdentityOrderOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#identityNoOrderOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentityNoOrderOption(PPASSQLStatementParser.IdentityNoOrderOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#virtualColumnDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVirtualColumnDefinition(PPASSQLStatementParser.VirtualColumnDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#evaluationEditionClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEvaluationEditionClause(PPASSQLStatementParser.EvaluationEditionClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code evaluationEditionCurrentEditionAction}
	 * labeled alternative in {@link PPASSQLStatementParser#evaluationEditionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEvaluationEditionCurrentEditionAction(PPASSQLStatementParser.EvaluationEditionCurrentEditionActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code evaluationEditionEditionAction}
	 * labeled alternative in {@link PPASSQLStatementParser#evaluationEditionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEvaluationEditionEditionAction(PPASSQLStatementParser.EvaluationEditionEditionActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code evaluationEditionNullEditionAction}
	 * labeled alternative in {@link PPASSQLStatementParser#evaluationEditionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEvaluationEditionNullEditionAction(PPASSQLStatementParser.EvaluationEditionNullEditionActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#unusableEditionsClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnusableEditionsClause(PPASSQLStatementParser.UnusableEditionsClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unusableBeforeCurrentEditionAction}
	 * labeled alternative in {@link PPASSQLStatementParser#unusableBeforeAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnusableBeforeCurrentEditionAction(PPASSQLStatementParser.UnusableBeforeCurrentEditionActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unusableBeforeEditionAction}
	 * labeled alternative in {@link PPASSQLStatementParser#unusableBeforeAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnusableBeforeEditionAction(PPASSQLStatementParser.UnusableBeforeEditionActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unusableBeginningWithCurrentEditionAction}
	 * labeled alternative in {@link PPASSQLStatementParser#unusableBeginningWithAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnusableBeginningWithCurrentEditionAction(PPASSQLStatementParser.UnusableBeginningWithCurrentEditionActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unusableBeginningWithEditionAction}
	 * labeled alternative in {@link PPASSQLStatementParser#unusableBeginningWithAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnusableBeginningWithEditionAction(PPASSQLStatementParser.UnusableBeginningWithEditionActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unusableBeginningWithNullEditionAction}
	 * labeled alternative in {@link PPASSQLStatementParser#unusableBeginningWithAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnusableBeginningWithNullEditionAction(PPASSQLStatementParser.UnusableBeginningWithNullEditionActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#periodDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPeriodDefinition(PPASSQLStatementParser.PeriodDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#encryptClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEncryptClause(PPASSQLStatementParser.EncryptClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#encryptionSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEncryptionSpec(PPASSQLStatementParser.EncryptionSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#objectTableSubstitution}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectTableSubstitution(PPASSQLStatementParser.ObjectTableSubstitutionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#objectProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectProperty(PPASSQLStatementParser.ObjectPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#commitActionDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommitActionDefinition(PPASSQLStatementParser.CommitActionDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#commitActionRows}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommitActionRows(PPASSQLStatementParser.CommitActionRowsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#oidClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOidClause(PPASSQLStatementParser.OidClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#oidIndexClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOidIndexClause(PPASSQLStatementParser.OidIndexClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#oidIndexClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOidIndexClauseItem(PPASSQLStatementParser.OidIndexClauseItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#heapOrgTableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHeapOrgTableClause(PPASSQLStatementParser.HeapOrgTableClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#indexOrgTableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexOrgTableClause(PPASSQLStatementParser.IndexOrgTableClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#indexOrgTableClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexOrgTableClauseItem(PPASSQLStatementParser.IndexOrgTableClauseItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#pctthresholdClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPctthresholdClause(PPASSQLStatementParser.PctthresholdClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mappingTableClause}
	 * labeled alternative in {@link PPASSQLStatementParser#iMappingTableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMappingTableClause(PPASSQLStatementParser.MappingTableClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code noMappingTableClause}
	 * labeled alternative in {@link PPASSQLStatementParser#iMappingTableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoMappingTableClause(PPASSQLStatementParser.NoMappingTableClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#indexCompression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexCompression(PPASSQLStatementParser.IndexCompressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code prefixCompression}
	 * labeled alternative in {@link PPASSQLStatementParser#iPrefixCompression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixCompression(PPASSQLStatementParser.PrefixCompressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code prefixNoCompression}
	 * labeled alternative in {@link PPASSQLStatementParser#iPrefixCompression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixNoCompression(PPASSQLStatementParser.PrefixNoCompressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code advancedIndexCompression}
	 * labeled alternative in {@link PPASSQLStatementParser#iAdvancedIndexCompression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdvancedIndexCompression(PPASSQLStatementParser.AdvancedIndexCompressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code advancedIndexNoCompression}
	 * labeled alternative in {@link PPASSQLStatementParser#iAdvancedIndexCompression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdvancedIndexNoCompression(PPASSQLStatementParser.AdvancedIndexNoCompressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#indexOrgOverflowClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexOrgOverflowClause(PPASSQLStatementParser.IndexOrgOverflowClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code supplementalLogGrpClause}
	 * labeled alternative in {@link PPASSQLStatementParser#iSupplementalLog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSupplementalLogGrpClause(PPASSQLStatementParser.SupplementalLogGrpClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code supplementalIdKeyClause}
	 * labeled alternative in {@link PPASSQLStatementParser#iSupplementalLog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSupplementalIdKeyClause(PPASSQLStatementParser.SupplementalIdKeyClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#supplementalLogGrpClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSupplementalLogGrpClauseItem(PPASSQLStatementParser.SupplementalLogGrpClauseItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#supplementalIdKeyClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSupplementalIdKeyClauseItem(PPASSQLStatementParser.SupplementalIdKeyClauseItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#columnProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnProperty(PPASSQLStatementParser.ColumnPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#opaqueTypeColumnProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpaqueTypeColumnProperty(PPASSQLStatementParser.OpaqueTypeColumnPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#vArrayColPropertyColumnProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVArrayColPropertyColumnProperty(PPASSQLStatementParser.VArrayColPropertyColumnPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#lobStorageClauseColumnProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobStorageClauseColumnProperty(PPASSQLStatementParser.LobStorageClauseColumnPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#objectTypeColProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectTypeColProperty(PPASSQLStatementParser.ObjectTypeColPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#buildClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuildClause(PPASSQLStatementParser.BuildClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#attributeClusteringClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributeClusteringClause(PPASSQLStatementParser.AttributeClusteringClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#clusteringJoin}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClusteringJoin(PPASSQLStatementParser.ClusteringJoinContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#clusteringJoinItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClusteringJoinItem(PPASSQLStatementParser.ClusteringJoinItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#clusterClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClusterClause(PPASSQLStatementParser.ClusterClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#clusteringWhen}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClusteringWhen(PPASSQLStatementParser.ClusteringWhenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code withMaterializedZonemapClause}
	 * labeled alternative in {@link PPASSQLStatementParser#zonemapClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithMaterializedZonemapClause(PPASSQLStatementParser.WithMaterializedZonemapClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code withoutMaterializedZonemapClause}
	 * labeled alternative in {@link PPASSQLStatementParser#zonemapClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithoutMaterializedZonemapClause(PPASSQLStatementParser.WithoutMaterializedZonemapClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#memoptimizeReadClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemoptimizeReadClause(PPASSQLStatementParser.MemoptimizeReadClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableItem(PPASSQLStatementParser.AlterTableItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterTableEnableDisable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableEnableDisable(PPASSQLStatementParser.AlterTableEnableDisableContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterTableProerty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableProerty(PPASSQLStatementParser.AlterTableProertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterTableReadOnlyAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableReadOnlyAction(PPASSQLStatementParser.AlterTableReadOnlyActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterTableReadWriteAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableReadWriteAction(PPASSQLStatementParser.AlterTableReadWriteActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableAddSupplementalLoggingAction}
	 * labeled alternative in {@link PPASSQLStatementParser#iAlterTableSupplementalLoggingAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableAddSupplementalLoggingAction(PPASSQLStatementParser.AlterTableAddSupplementalLoggingActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code iAlterTableDropSupplementalLoggingAction}
	 * labeled alternative in {@link PPASSQLStatementParser#iAlterTableSupplementalLoggingAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIAlterTableDropSupplementalLoggingAction(PPASSQLStatementParser.IAlterTableDropSupplementalLoggingActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterTableUpgradeTableAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableUpgradeTableAction(PPASSQLStatementParser.AlterTableUpgradeTableActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#records_per_block_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecords_per_block_clause(PPASSQLStatementParser.Records_per_block_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#rowMovementClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowMovementClause(PPASSQLStatementParser.RowMovementClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterTalbeRenameTableAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTalbeRenameTableAction(PPASSQLStatementParser.AlterTalbeRenameTableActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterIotClauses}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIotClauses(PPASSQLStatementParser.AlterIotClausesContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#iAlterOverflowClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIAlterOverflowClause(PPASSQLStatementParser.IAlterOverflowClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterOverflowClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterOverflowClause(PPASSQLStatementParser.AlterOverflowClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterOverflowClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterOverflowClauseItem(PPASSQLStatementParser.AlterOverflowClauseItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#addOverflowClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddOverflowClause(PPASSQLStatementParser.AddOverflowClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterMappingTableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterMappingTableClause(PPASSQLStatementParser.AlterMappingTableClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterMappingTableClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterMappingTableClauseItem(PPASSQLStatementParser.AlterMappingTableClauseItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterTableColumnAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableColumnAction(PPASSQLStatementParser.AlterTableColumnActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterTableAddColumnAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableAddColumnAction(PPASSQLStatementParser.AlterTableAddColumnActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterTableModifyColumnAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableModifyColumnAction(PPASSQLStatementParser.AlterTableModifyColumnActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#modifyColSubstitutable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModifyColSubstitutable(PPASSQLStatementParser.ModifyColSubstitutableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableSetUnusedColumnAction}
	 * labeled alternative in {@link PPASSQLStatementParser#iAlterTableDropColumnAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableSetUnusedColumnAction(PPASSQLStatementParser.AlterTableSetUnusedColumnActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableDropColumnAction}
	 * labeled alternative in {@link PPASSQLStatementParser#iAlterTableDropColumnAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableDropColumnAction(PPASSQLStatementParser.AlterTableDropColumnActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableDropUnusedColumnsAction}
	 * labeled alternative in {@link PPASSQLStatementParser#iAlterTableDropColumnAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableDropUnusedColumnsAction(PPASSQLStatementParser.AlterTableDropUnusedColumnsActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableDropColumnsContinueAction}
	 * labeled alternative in {@link PPASSQLStatementParser#iAlterTableDropColumnAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableDropColumnsContinueAction(PPASSQLStatementParser.AlterTableDropColumnsContinueActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#iAlterTableDropColumnActionOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIAlterTableDropColumnActionOption(PPASSQLStatementParser.IAlterTableDropColumnActionOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterTableDropPeriodAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableDropPeriodAction(PPASSQLStatementParser.AlterTableDropPeriodActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterTableRenameColumnAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableRenameColumnAction(PPASSQLStatementParser.AlterTableRenameColumnActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterTalbeModifyCollectionRetrievalAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTalbeModifyCollectionRetrievalAction(PPASSQLStatementParser.AlterTalbeModifyCollectionRetrievalActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterTableModifyLobStorageAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableModifyLobStorageAction(PPASSQLStatementParser.AlterTableModifyLobStorageActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#modifyLobParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModifyLobParameter(PPASSQLStatementParser.ModifyLobParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterTableAlterVarrayColPropertyAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableAlterVarrayColPropertyAction(PPASSQLStatementParser.AlterTableAlterVarrayColPropertyActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableAddTableConstraintAction}
	 * labeled alternative in {@link PPASSQLStatementParser#iAlterTableConstraintAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableAddTableConstraintAction(PPASSQLStatementParser.AlterTableAddTableConstraintActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableModifyTableConstraintAction}
	 * labeled alternative in {@link PPASSQLStatementParser#iAlterTableConstraintAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableModifyTableConstraintAction(PPASSQLStatementParser.AlterTableModifyTableConstraintActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableModifyPrimaryKeyConstraintAction}
	 * labeled alternative in {@link PPASSQLStatementParser#iAlterTableConstraintAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableModifyPrimaryKeyConstraintAction(PPASSQLStatementParser.AlterTableModifyPrimaryKeyConstraintActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableModifyUniqueConstraintAction}
	 * labeled alternative in {@link PPASSQLStatementParser#iAlterTableConstraintAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableModifyUniqueConstraintAction(PPASSQLStatementParser.AlterTableModifyUniqueConstraintActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableRenameTableConstraintAction}
	 * labeled alternative in {@link PPASSQLStatementParser#iAlterTableConstraintAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableRenameTableConstraintAction(PPASSQLStatementParser.AlterTableRenameTableConstraintActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableDropPrimaryKeyConstraintAction}
	 * labeled alternative in {@link PPASSQLStatementParser#iAlterTableConstraintAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableDropPrimaryKeyConstraintAction(PPASSQLStatementParser.AlterTableDropPrimaryKeyConstraintActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableDropUniqueConstraintAction}
	 * labeled alternative in {@link PPASSQLStatementParser#iAlterTableConstraintAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableDropUniqueConstraintAction(PPASSQLStatementParser.AlterTableDropUniqueConstraintActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableDropTableConstraintAction}
	 * labeled alternative in {@link PPASSQLStatementParser#iAlterTableConstraintAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableDropTableConstraintAction(PPASSQLStatementParser.AlterTableDropTableConstraintActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterXmlSchemaClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterXmlSchemaClause(PPASSQLStatementParser.AlterXmlSchemaClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#iAlterTablePartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIAlterTablePartitionAction(PPASSQLStatementParser.IAlterTablePartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterTablePartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTablePartitionAction(PPASSQLStatementParser.AlterTablePartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterTablePartitionActionForItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTablePartitionActionForItem(PPASSQLStatementParser.AlterTablePartitionActionForItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterTableModifyDefaultAttrsAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableModifyDefaultAttrsAction(PPASSQLStatementParser.AlterTableModifyDefaultAttrsActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forPartition}
	 * labeled alternative in {@link PPASSQLStatementParser#iForPartition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForPartition(PPASSQLStatementParser.ForPartitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forPartitionFor}
	 * labeled alternative in {@link PPASSQLStatementParser#iForPartition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForPartitionFor(PPASSQLStatementParser.ForPartitionForContext ctx);
	/**
	 * Visit a parse tree produced by the {@code modifyTableDefaultAttrsActionLobItem}
	 * labeled alternative in {@link PPASSQLStatementParser#modifyTableDefaultAttrsActionItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModifyTableDefaultAttrsActionLobItem(PPASSQLStatementParser.ModifyTableDefaultAttrsActionLobItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code modifyTableDefaultAttrsActionVarrayItem}
	 * labeled alternative in {@link PPASSQLStatementParser#modifyTableDefaultAttrsActionItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModifyTableDefaultAttrsActionVarrayItem(PPASSQLStatementParser.ModifyTableDefaultAttrsActionVarrayItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterTableSetPartitioningAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableSetPartitioningAction(PPASSQLStatementParser.AlterTableSetPartitioningActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterTableSetStoreInAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableSetStoreInAction(PPASSQLStatementParser.AlterTableSetStoreInActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterTableSetIntervalAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableSetIntervalAction(PPASSQLStatementParser.AlterTableSetIntervalActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterTableSetSubpartitionTemplateAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableSetSubpartitionTemplateAction(PPASSQLStatementParser.AlterTableSetSubpartitionTemplateActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterTableModifyPartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableModifyPartitionAction(PPASSQLStatementParser.AlterTableModifyPartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterTableModifyPartitionForAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableModifyPartitionForAction(PPASSQLStatementParser.AlterTableModifyPartitionForActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterTableModifySubPartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableModifySubPartitionAction(PPASSQLStatementParser.AlterTableModifySubPartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterTableModifySubPartitionForAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableModifySubPartitionForAction(PPASSQLStatementParser.AlterTableModifySubPartitionForActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterTableMovePartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableMovePartitionAction(PPASSQLStatementParser.AlterTableMovePartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterTableMovePartitionForAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableMovePartitionForAction(PPASSQLStatementParser.AlterTableMovePartitionForActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#filterCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilterCondition(PPASSQLStatementParser.FilterConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#allowDisallowClustering}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAllowDisallowClustering(PPASSQLStatementParser.AllowDisallowClusteringContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterTablemoveSubpartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTablemoveSubpartitionAction(PPASSQLStatementParser.AlterTablemoveSubpartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterTablemoveSubpartitionForAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTablemoveSubpartitionForAction(PPASSQLStatementParser.AlterTablemoveSubpartitionForActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterTableAddPartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableAddPartitionAction(PPASSQLStatementParser.AlterTableAddPartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterTableAddSubPartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableAddSubPartitionAction(PPASSQLStatementParser.AlterTableAddSubPartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#dependentTablesClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDependentTablesClause(PPASSQLStatementParser.DependentTablesClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#dependentTablesClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDependentTablesClauseItem(PPASSQLStatementParser.DependentTablesClauseItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterTableCoalesceTablePartition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableCoalesceTablePartition(PPASSQLStatementParser.AlterTableCoalesceTablePartitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterTableCoalesceTableSubpartition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableCoalesceTableSubpartition(PPASSQLStatementParser.AlterTableCoalesceTableSubpartitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterTableDropPartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableDropPartitionAction(PPASSQLStatementParser.AlterTableDropPartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#dropPartitionActionItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropPartitionActionItem(PPASSQLStatementParser.DropPartitionActionItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterTableDropSubpartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableDropSubpartitionAction(PPASSQLStatementParser.AlterTableDropSubpartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#dropSubpartitionActionItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropSubpartitionActionItem(PPASSQLStatementParser.DropSubpartitionActionItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterTableRenamePartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableRenamePartitionAction(PPASSQLStatementParser.AlterTableRenamePartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterTableRenamePartitionForAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableRenamePartitionForAction(PPASSQLStatementParser.AlterTableRenamePartitionForActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterTableRenameSubPartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableRenameSubPartitionAction(PPASSQLStatementParser.AlterTableRenameSubPartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterTableRenameSubPartitionForAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableRenameSubPartitionForAction(PPASSQLStatementParser.AlterTableRenameSubPartitionForActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterTableTruncatePartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableTruncatePartitionAction(PPASSQLStatementParser.AlterTableTruncatePartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterTableTruncateSubPartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableTruncateSubPartitionAction(PPASSQLStatementParser.AlterTableTruncateSubPartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterTablePartitionItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTablePartitionItem(PPASSQLStatementParser.AlterTablePartitionItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableSplitPartitionaAtAction}
	 * labeled alternative in {@link PPASSQLStatementParser#iAlterTableSplitPartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableSplitPartitionaAtAction(PPASSQLStatementParser.AlterTableSplitPartitionaAtActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableSplitPartitionaValuesAction}
	 * labeled alternative in {@link PPASSQLStatementParser#iAlterTableSplitPartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableSplitPartitionaValuesAction(PPASSQLStatementParser.AlterTableSplitPartitionaValuesActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableSplitPartitionaIntoAction}
	 * labeled alternative in {@link PPASSQLStatementParser#iAlterTableSplitPartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableSplitPartitionaIntoAction(PPASSQLStatementParser.AlterTableSplitPartitionaIntoActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableSplitPartitionaForAtAction}
	 * labeled alternative in {@link PPASSQLStatementParser#iAlterTableSplitPartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableSplitPartitionaForAtAction(PPASSQLStatementParser.AlterTableSplitPartitionaForAtActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableSplitPartitionaForValuesAction}
	 * labeled alternative in {@link PPASSQLStatementParser#iAlterTableSplitPartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableSplitPartitionaForValuesAction(PPASSQLStatementParser.AlterTableSplitPartitionaForValuesActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableSplitPartitionaForIntoAction}
	 * labeled alternative in {@link PPASSQLStatementParser#iAlterTableSplitPartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableSplitPartitionaForIntoAction(PPASSQLStatementParser.AlterTableSplitPartitionaForIntoActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#splitNestedTablePart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSplitNestedTablePart(PPASSQLStatementParser.SplitNestedTablePartContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableSplitSubPartitionaAtAction}
	 * labeled alternative in {@link PPASSQLStatementParser#iAlterTableSubSplitPartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableSplitSubPartitionaAtAction(PPASSQLStatementParser.AlterTableSplitSubPartitionaAtActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableSplitSubPartitionaValuesAction}
	 * labeled alternative in {@link PPASSQLStatementParser#iAlterTableSubSplitPartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableSplitSubPartitionaValuesAction(PPASSQLStatementParser.AlterTableSplitSubPartitionaValuesActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableSplitSubPartitionaIntoAction}
	 * labeled alternative in {@link PPASSQLStatementParser#iAlterTableSubSplitPartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableSplitSubPartitionaIntoAction(PPASSQLStatementParser.AlterTableSplitSubPartitionaIntoActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableSplitSubPartitionaForAtAction}
	 * labeled alternative in {@link PPASSQLStatementParser#iAlterTableSubSplitPartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableSplitSubPartitionaForAtAction(PPASSQLStatementParser.AlterTableSplitSubPartitionaForAtActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableSplitSubPartitionaForValuesAction}
	 * labeled alternative in {@link PPASSQLStatementParser#iAlterTableSubSplitPartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableSplitSubPartitionaForValuesAction(PPASSQLStatementParser.AlterTableSplitSubPartitionaForValuesActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableSplitSubPartitionaForIntoAction}
	 * labeled alternative in {@link PPASSQLStatementParser#iAlterTableSubSplitPartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableSplitSubPartitionaForIntoAction(PPASSQLStatementParser.AlterTableSplitSubPartitionaForIntoActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableMergePartitionsAction}
	 * labeled alternative in {@link PPASSQLStatementParser#iAlterTableMergePartitionsAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableMergePartitionsAction(PPASSQLStatementParser.AlterTableMergePartitionsActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableMergePartitionsToAction}
	 * labeled alternative in {@link PPASSQLStatementParser#iAlterTableMergePartitionsAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableMergePartitionsToAction(PPASSQLStatementParser.AlterTableMergePartitionsToActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableMergeSubPartitionsAction}
	 * labeled alternative in {@link PPASSQLStatementParser#iAlterTableMergeSubPartitionsAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableMergeSubPartitionsAction(PPASSQLStatementParser.AlterTableMergeSubPartitionsActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableMergeSubPartitionsToAction}
	 * labeled alternative in {@link PPASSQLStatementParser#iAlterTableMergeSubPartitionsAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableMergeSubPartitionsToAction(PPASSQLStatementParser.AlterTableMergeSubPartitionsToActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableExchangePartitionAction}
	 * labeled alternative in {@link PPASSQLStatementParser#iAlterTableExchangePartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableExchangePartitionAction(PPASSQLStatementParser.AlterTableExchangePartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableExchangePartitionForAction}
	 * labeled alternative in {@link PPASSQLStatementParser#iAlterTableExchangePartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableExchangePartitionForAction(PPASSQLStatementParser.AlterTableExchangePartitionForActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableExchangeSubPartitionAction}
	 * labeled alternative in {@link PPASSQLStatementParser#iAlterTableExchangeSubPartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableExchangeSubPartitionAction(PPASSQLStatementParser.AlterTableExchangeSubPartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableExchangeSubPartitionForAction}
	 * labeled alternative in {@link PPASSQLStatementParser#iAlterTableExchangeSubPartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableExchangeSubPartitionForAction(PPASSQLStatementParser.AlterTableExchangeSubPartitionForActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#updateIndexClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdateIndexClause(PPASSQLStatementParser.UpdateIndexClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#updateGlobalIndexClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdateGlobalIndexClause(PPASSQLStatementParser.UpdateGlobalIndexClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#updateIndexesClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdateIndexesClause(PPASSQLStatementParser.UpdateIndexesClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#updateIndexesClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdateIndexesClauseItem(PPASSQLStatementParser.UpdateIndexesClauseItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterTableMoveTableAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableMoveTableAction(PPASSQLStatementParser.AlterTableMoveTableActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterTableMoveTableActionUpdateIndexesItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableMoveTableActionUpdateIndexesItem(PPASSQLStatementParser.AlterTableMoveTableActionUpdateIndexesItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterTableModifyToPartitionedAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableModifyToPartitionedAction(PPASSQLStatementParser.AlterTableModifyToPartitionedActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterTableModifyToPartitionedActionUpdateIndexesItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableModifyToPartitionedActionUpdateIndexesItem(PPASSQLStatementParser.AlterTableModifyToPartitionedActionUpdateIndexesItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterTableModifyOpaqueTypeAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableModifyOpaqueTypeAction(PPASSQLStatementParser.AlterTableModifyOpaqueTypeActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code enableUniqueClause}
	 * labeled alternative in {@link PPASSQLStatementParser#iEnableDisableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnableUniqueClause(PPASSQLStatementParser.EnableUniqueClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code enablePrimaryKeyClause}
	 * labeled alternative in {@link PPASSQLStatementParser#iEnableDisableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnablePrimaryKeyClause(PPASSQLStatementParser.EnablePrimaryKeyClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code enableConstraintClause}
	 * labeled alternative in {@link PPASSQLStatementParser#iEnableDisableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnableConstraintClause(PPASSQLStatementParser.EnableConstraintClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code disableUniqueClause}
	 * labeled alternative in {@link PPASSQLStatementParser#iEnableDisableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDisableUniqueClause(PPASSQLStatementParser.DisableUniqueClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code disablePrimaryKeyClause}
	 * labeled alternative in {@link PPASSQLStatementParser#iEnableDisableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDisablePrimaryKeyClause(PPASSQLStatementParser.DisablePrimaryKeyClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code disableConstraintClause}
	 * labeled alternative in {@link PPASSQLStatementParser#iEnableDisableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDisableConstraintClause(PPASSQLStatementParser.DisableConstraintClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterTableEnableTableLockAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableEnableTableLockAction(PPASSQLStatementParser.AlterTableEnableTableLockActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterTableEnableAllTriggersAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableEnableAllTriggersAction(PPASSQLStatementParser.AlterTableEnableAllTriggersActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterTableEnableContainerMapAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableEnableContainerMapAction(PPASSQLStatementParser.AlterTableEnableContainerMapActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterTableEnableContainersDefaultAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableEnableContainersDefaultAction(PPASSQLStatementParser.AlterTableEnableContainersDefaultActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterTableDisableTableLockAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableDisableTableLockAction(PPASSQLStatementParser.AlterTableDisableTableLockActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterTableDisableAllTriggersAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableDisableAllTriggersAction(PPASSQLStatementParser.AlterTableDisableAllTriggersActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterTableDisableContainerMapAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableDisableContainerMapAction(PPASSQLStatementParser.AlterTableDisableContainerMapActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterTableDisableContainersDefaultAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableDisableContainersDefaultAction(PPASSQLStatementParser.AlterTableDisableContainersDefaultActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#createTriggerStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTriggerStatement(PPASSQLStatementParser.CreateTriggerStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterTriggerStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTriggerStatement(PPASSQLStatementParser.AlterTriggerStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#dropTriggerStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropTriggerStatement(PPASSQLStatementParser.DropTriggerStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#createTriggerActionTime}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTriggerActionTime(PPASSQLStatementParser.CreateTriggerActionTimeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#createTriggerEvent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTriggerEvent(PPASSQLStatementParser.CreateTriggerEventContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#triggerDmlEvent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTriggerDmlEvent(PPASSQLStatementParser.TriggerDmlEventContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#triggerDDLEvent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTriggerDDLEvent(PPASSQLStatementParser.TriggerDDLEventContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#triggerDatabaseEvent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTriggerDatabaseEvent(PPASSQLStatementParser.TriggerDatabaseEventContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#createTriggerOnExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTriggerOnExpr(PPASSQLStatementParser.CreateTriggerOnExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#createTriggerOnSchemaExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTriggerOnSchemaExpr(PPASSQLStatementParser.CreateTriggerOnSchemaExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#createTriggerOnDatabaseExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTriggerOnDatabaseExpr(PPASSQLStatementParser.CreateTriggerOnDatabaseExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#forEachRow}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForEachRow(PPASSQLStatementParser.ForEachRowContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#referencingOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReferencingOption(PPASSQLStatementParser.ReferencingOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#triggerEditionClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTriggerEditionClause(PPASSQLStatementParser.TriggerEditionClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#triggerOrderingClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTriggerOrderingClause(PPASSQLStatementParser.TriggerOrderingClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#compoundTriggerBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompoundTriggerBlock(PPASSQLStatementParser.CompoundTriggerBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#timingPointSection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimingPointSection(PPASSQLStatementParser.TimingPointSectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#timingPoint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimingPoint(PPASSQLStatementParser.TimingPointContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#triggerBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTriggerBody(PPASSQLStatementParser.TriggerBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterTriggerStatementOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTriggerStatementOption(PPASSQLStatementParser.AlterTriggerStatementOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#createTypeStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTypeStatement(PPASSQLStatementParser.CreateTypeStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterTypeStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTypeStatement(PPASSQLStatementParser.AlterTypeStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#dropTypeStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropTypeStatement(PPASSQLStatementParser.DropTypeStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#createTypeStatementProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTypeStatementProperty(PPASSQLStatementParser.CreateTypeStatementPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#createTypeExternalNameClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTypeExternalNameClause(PPASSQLStatementParser.CreateTypeExternalNameClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#createTypeStatementOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTypeStatementOption(PPASSQLStatementParser.CreateTypeStatementOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterTypeAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTypeAction(PPASSQLStatementParser.AlterTypeActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#replaceTypeClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReplaceTypeClause(PPASSQLStatementParser.ReplaceTypeClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alter_method_spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_method_spec(PPASSQLStatementParser.Alter_method_specContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alter_method_element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_method_element(PPASSQLStatementParser.Alter_method_elementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alter_attribute_definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_attribute_definition(PPASSQLStatementParser.Alter_attribute_definitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alter_collection_clauses}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_collection_clauses(PPASSQLStatementParser.Alter_collection_clausesContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#dependent_handling_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDependent_handling_clause(PPASSQLStatementParser.Dependent_handling_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#dependent_exceptions_part}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDependent_exceptions_part(PPASSQLStatementParser.Dependent_exceptions_partContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#createTypeBodyStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTypeBodyStatement(PPASSQLStatementParser.CreateTypeBodyStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#dropTypeBodyStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropTypeBodyStatement(PPASSQLStatementParser.DropTypeBodyStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#createTypeBodyStatementItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTypeBodyStatementItem(PPASSQLStatementParser.CreateTypeBodyStatementItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#createViewStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateViewStatement(PPASSQLStatementParser.CreateViewStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterViewStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterViewStatement(PPASSQLStatementParser.AlterViewStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#dropViewStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropViewStatement(PPASSQLStatementParser.DropViewStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#createViewSubView}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateViewSubView(PPASSQLStatementParser.CreateViewSubViewContext ctx);
	/**
	 * Visit a parse tree produced by the {@code withObjectIdentifierClause}
	 * labeled alternative in {@link PPASSQLStatementParser#iWithObjectIdClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithObjectIdentifierClause(PPASSQLStatementParser.WithObjectIdentifierClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code withObjectIdClause}
	 * labeled alternative in {@link PPASSQLStatementParser#iWithObjectIdClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithObjectIdClause(PPASSQLStatementParser.WithObjectIdClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#subViewClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubViewClause(PPASSQLStatementParser.SubViewClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterViewAddTableConstraintAction}
	 * labeled alternative in {@link PPASSQLStatementParser#alterViewAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterViewAddTableConstraintAction(PPASSQLStatementParser.AlterViewAddTableConstraintActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterViewModifyConstraintAction}
	 * labeled alternative in {@link PPASSQLStatementParser#alterViewAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterViewModifyConstraintAction(PPASSQLStatementParser.AlterViewModifyConstraintActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterViewDropConstraintAction}
	 * labeled alternative in {@link PPASSQLStatementParser#alterViewAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterViewDropConstraintAction(PPASSQLStatementParser.AlterViewDropConstraintActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterViewDropPrimaryKeyConstraintAction}
	 * labeled alternative in {@link PPASSQLStatementParser#alterViewAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterViewDropPrimaryKeyConstraintAction(PPASSQLStatementParser.AlterViewDropPrimaryKeyConstraintActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterViewCompileAction}
	 * labeled alternative in {@link PPASSQLStatementParser#alterViewAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterViewCompileAction(PPASSQLStatementParser.AlterViewCompileActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterViewAddTableAction}
	 * labeled alternative in {@link PPASSQLStatementParser#alterViewAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterViewAddTableAction(PPASSQLStatementParser.AlterViewAddTableActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterViewReadOnlyAction}
	 * labeled alternative in {@link PPASSQLStatementParser#alterViewAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterViewReadOnlyAction(PPASSQLStatementParser.AlterViewReadOnlyActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterViewReadWriteAction}
	 * labeled alternative in {@link PPASSQLStatementParser#alterViewAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterViewReadWriteAction(PPASSQLStatementParser.AlterViewReadWriteActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterViewEditionableAction}
	 * labeled alternative in {@link PPASSQLStatementParser#alterViewAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterViewEditionableAction(PPASSQLStatementParser.AlterViewEditionableActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterViewNonEditionableAction}
	 * labeled alternative in {@link PPASSQLStatementParser#alterViewAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterViewNonEditionableAction(PPASSQLStatementParser.AlterViewNonEditionableActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#createMaterializedViewStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateMaterializedViewStatement(PPASSQLStatementParser.CreateMaterializedViewStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterMaterializedViewStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterMaterializedViewStatement(PPASSQLStatementParser.AlterMaterializedViewStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#dropMaterializedViewStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropMaterializedViewStatement(PPASSQLStatementParser.DropMaterializedViewStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#iCreateMaterializedViewStatementColumn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitICreateMaterializedViewStatementColumn(PPASSQLStatementParser.ICreateMaterializedViewStatementColumnContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#createMaterializedViewStatementColumn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateMaterializedViewStatementColumn(PPASSQLStatementParser.CreateMaterializedViewStatementColumnContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#createMaterializedViewStatementProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateMaterializedViewStatementProperty(PPASSQLStatementParser.CreateMaterializedViewStatementPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#onPrebuiltTableProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOnPrebuiltTableProperty(PPASSQLStatementParser.OnPrebuiltTablePropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#materializedViewProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMaterializedViewProperty(PPASSQLStatementParser.MaterializedViewPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#materializedViewPropertyCacheClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMaterializedViewPropertyCacheClause(PPASSQLStatementParser.MaterializedViewPropertyCacheClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#materializedViewPropertyNoCacheClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMaterializedViewPropertyNoCacheClause(PPASSQLStatementParser.MaterializedViewPropertyNoCacheClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code usingIndexClause}
	 * labeled alternative in {@link PPASSQLStatementParser#iUsingIndexClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUsingIndexClause(PPASSQLStatementParser.UsingIndexClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code usingNoIndexClause}
	 * labeled alternative in {@link PPASSQLStatementParser#iUsingIndexClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUsingNoIndexClause(PPASSQLStatementParser.UsingNoIndexClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#usingIndexItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUsingIndexItem(PPASSQLStatementParser.UsingIndexItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#usingIndexCreateIndexStatementItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUsingIndexCreateIndexStatementItem(PPASSQLStatementParser.UsingIndexCreateIndexStatementItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code createMVRefresh}
	 * labeled alternative in {@link PPASSQLStatementParser#iCreateMVRefresh}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateMVRefresh(PPASSQLStatementParser.CreateMVRefreshContext ctx);
	/**
	 * Visit a parse tree produced by the {@code createMVNeverRefresh}
	 * labeled alternative in {@link PPASSQLStatementParser#iCreateMVRefresh}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateMVNeverRefresh(PPASSQLStatementParser.CreateMVNeverRefreshContext ctx);
	/**
	 * Visit a parse tree produced by the {@code createMVRefreshFastItem}
	 * labeled alternative in {@link PPASSQLStatementParser#createMVRefreshItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateMVRefreshFastItem(PPASSQLStatementParser.CreateMVRefreshFastItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code createMVRefreshCompleteItem}
	 * labeled alternative in {@link PPASSQLStatementParser#createMVRefreshItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateMVRefreshCompleteItem(PPASSQLStatementParser.CreateMVRefreshCompleteItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code createMVRefreshForceItem}
	 * labeled alternative in {@link PPASSQLStatementParser#createMVRefreshItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateMVRefreshForceItem(PPASSQLStatementParser.CreateMVRefreshForceItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code createMVRefreshOnDemandItem}
	 * labeled alternative in {@link PPASSQLStatementParser#createMVRefreshItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateMVRefreshOnDemandItem(PPASSQLStatementParser.CreateMVRefreshOnDemandItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code createMVRefreshOnCommitItem}
	 * labeled alternative in {@link PPASSQLStatementParser#createMVRefreshItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateMVRefreshOnCommitItem(PPASSQLStatementParser.CreateMVRefreshOnCommitItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code createMVRefreshOnStatementItem}
	 * labeled alternative in {@link PPASSQLStatementParser#createMVRefreshItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateMVRefreshOnStatementItem(PPASSQLStatementParser.CreateMVRefreshOnStatementItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code createMVRefreshStartWithItem}
	 * labeled alternative in {@link PPASSQLStatementParser#createMVRefreshItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateMVRefreshStartWithItem(PPASSQLStatementParser.CreateMVRefreshStartWithItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code createMVRefreshNextItem}
	 * labeled alternative in {@link PPASSQLStatementParser#createMVRefreshItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateMVRefreshNextItem(PPASSQLStatementParser.CreateMVRefreshNextItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code createMVRefreshWithPrimaryKeyItem}
	 * labeled alternative in {@link PPASSQLStatementParser#createMVRefreshItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateMVRefreshWithPrimaryKeyItem(PPASSQLStatementParser.CreateMVRefreshWithPrimaryKeyItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code createMVRefreshWithRowidItem}
	 * labeled alternative in {@link PPASSQLStatementParser#createMVRefreshItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateMVRefreshWithRowidItem(PPASSQLStatementParser.CreateMVRefreshWithRowidItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code createMVRefreshUsingRollbackSegmentItem}
	 * labeled alternative in {@link PPASSQLStatementParser#createMVRefreshItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateMVRefreshUsingRollbackSegmentItem(PPASSQLStatementParser.CreateMVRefreshUsingRollbackSegmentItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code createMVRefreshUsingEnforcedConstraintsItem}
	 * labeled alternative in {@link PPASSQLStatementParser#createMVRefreshItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateMVRefreshUsingEnforcedConstraintsItem(PPASSQLStatementParser.CreateMVRefreshUsingEnforcedConstraintsItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code createMVRefreshUsingTrustedConstraintsItem}
	 * labeled alternative in {@link PPASSQLStatementParser#createMVRefreshItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateMVRefreshUsingTrustedConstraintsItem(PPASSQLStatementParser.CreateMVRefreshUsingTrustedConstraintsItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code usingRollbackSegmentByDefaultItem}
	 * labeled alternative in {@link PPASSQLStatementParser#usingRollbackSegmentItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUsingRollbackSegmentByDefaultItem(PPASSQLStatementParser.UsingRollbackSegmentByDefaultItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code usingRollbackSegmentByNoDefaultItem}
	 * labeled alternative in {@link PPASSQLStatementParser#usingRollbackSegmentItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUsingRollbackSegmentByNoDefaultItem(PPASSQLStatementParser.UsingRollbackSegmentByNoDefaultItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#usingRollbackSegmentOptionType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUsingRollbackSegmentOptionType(PPASSQLStatementParser.UsingRollbackSegmentOptionTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#onQueryComputationClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOnQueryComputationClause(PPASSQLStatementParser.OnQueryComputationClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#queryRewriteClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQueryRewriteClause(PPASSQLStatementParser.QueryRewriteClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterMaterializedViewStatementProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterMaterializedViewStatementProperty(PPASSQLStatementParser.AlterMaterializedViewStatementPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#commentOnAuditPolicyStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommentOnAuditPolicyStatement(PPASSQLStatementParser.CommentOnAuditPolicyStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#commentOnColumnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommentOnColumnStatement(PPASSQLStatementParser.CommentOnColumnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#commentOnEditionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommentOnEditionStatement(PPASSQLStatementParser.CommentOnEditionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#commentOnIndexTypeStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommentOnIndexTypeStatement(PPASSQLStatementParser.CommentOnIndexTypeStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#commentOnMaterializedViewStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommentOnMaterializedViewStatement(PPASSQLStatementParser.CommentOnMaterializedViewStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#commentOnMiningModelStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommentOnMiningModelStatement(PPASSQLStatementParser.CommentOnMiningModelStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#commentOnOperatorStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommentOnOperatorStatement(PPASSQLStatementParser.CommentOnOperatorStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#commentOnTableStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommentOnTableStatement(PPASSQLStatementParser.CommentOnTableStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#table_indexed_by_part}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable_indexed_by_part(PPASSQLStatementParser.Table_indexed_by_partContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_call(PPASSQLStatementParser.Function_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#sqlStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSqlStatement(PPASSQLStatementParser.SqlStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#execute_immediate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExecute_immediate(PPASSQLStatementParser.Execute_immediateContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#cursor_manipulation_statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCursor_manipulation_statements(PPASSQLStatementParser.Cursor_manipulation_statementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#callStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallStatement(PPASSQLStatementParser.CallStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#explainStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExplainStatement(PPASSQLStatementParser.ExplainStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#insertStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsertStatement(PPASSQLStatementParser.InsertStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#multiInsertStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiInsertStatement(PPASSQLStatementParser.MultiInsertStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#iValueClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIValueClause(PPASSQLStatementParser.IValueClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#multiInsertClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiInsertClause(PPASSQLStatementParser.MultiInsertClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#multiInsertIntoClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiInsertIntoClause(PPASSQLStatementParser.MultiInsertIntoClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#multiConditionalInsertIntoClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiConditionalInsertIntoClause(PPASSQLStatementParser.MultiConditionalInsertIntoClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#multiInsertIntoClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiInsertIntoClauseItem(PPASSQLStatementParser.MultiInsertIntoClauseItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#multiConditionalInsertWhenClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiConditionalInsertWhenClause(PPASSQLStatementParser.MultiConditionalInsertWhenClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#valuesClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValuesClause(PPASSQLStatementParser.ValuesClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#valuesClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValuesClauseItem(PPASSQLStatementParser.ValuesClauseItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#mergeStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMergeStatement(PPASSQLStatementParser.MergeStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#merge_update_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMerge_update_clause(PPASSQLStatementParser.Merge_update_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#merge_element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMerge_element(PPASSQLStatementParser.Merge_elementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#merge_update_delete_part}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMerge_update_delete_part(PPASSQLStatementParser.Merge_update_delete_partContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#merge_insert_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMerge_insert_clause(PPASSQLStatementParser.Merge_insert_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#selected_tableview}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelected_tableview(PPASSQLStatementParser.Selected_tableviewContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#lockTableStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLockTableStatement(PPASSQLStatementParser.LockTableStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#lockTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLockTableItem(PPASSQLStatementParser.LockTableItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#lockMode}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLockMode(PPASSQLStatementParser.LockModeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#deleteStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeleteStatement(PPASSQLStatementParser.DeleteStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#selectStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectStatement(PPASSQLStatementParser.SelectStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#iSelectQuery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitISelectQuery(PPASSQLStatementParser.ISelectQueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#selectQueryBasic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectQueryBasic(PPASSQLStatementParser.SelectQueryBasicContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#selectQuery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectQuery(PPASSQLStatementParser.SelectQueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#selectParenQuery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectParenQuery(PPASSQLStatementParser.SelectParenQueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#selectUnionQuery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectUnionQuery(PPASSQLStatementParser.SelectUnionQueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#setQuantifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetQuantifier(PPASSQLStatementParser.SetQuantifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#unionOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnionOperator(PPASSQLStatementParser.UnionOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#withClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithClause(PPASSQLStatementParser.WithClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#plsqlDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlsqlDeclaration(PPASSQLStatementParser.PlsqlDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#withElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithElement(PPASSQLStatementParser.WithElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#subQueryFactoringClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubQueryFactoringClause(PPASSQLStatementParser.SubQueryFactoringClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#searchClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSearchClause(PPASSQLStatementParser.SearchClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#cycleClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCycleClause(PPASSQLStatementParser.CycleClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#subAvFactoringClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubAvFactoringClause(PPASSQLStatementParser.SubAvFactoringClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#subAvClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubAvClause(PPASSQLStatementParser.SubAvClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#hierarchiesClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHierarchiesClause(PPASSQLStatementParser.HierarchiesClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#subAvClauseFilterClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubAvClauseFilterClause(PPASSQLStatementParser.SubAvClauseFilterClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#calcMeasClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCalcMeasClause(PPASSQLStatementParser.CalcMeasClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#selectItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectItem(PPASSQLStatementParser.SelectItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#selectItemAlias}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectItemAlias(PPASSQLStatementParser.SelectItemAliasContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#fromClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFromClause(PPASSQLStatementParser.FromClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#iTableReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitITableReference(PPASSQLStatementParser.ITableReferenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code objectNameTableReference}
	 * labeled alternative in {@link PPASSQLStatementParser#tableReferenceBasic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectNameTableReference(PPASSQLStatementParser.ObjectNameTableReferenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lateralSubQueryTableReference}
	 * labeled alternative in {@link PPASSQLStatementParser#tableReferenceBasic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLateralSubQueryTableReference(PPASSQLStatementParser.LateralSubQueryTableReferenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tableFunctionTableReference}
	 * labeled alternative in {@link PPASSQLStatementParser#tableReferenceBasic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableFunctionTableReference(PPASSQLStatementParser.TableFunctionTableReferenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code containersFunctionTableReference}
	 * labeled alternative in {@link PPASSQLStatementParser#tableReferenceBasic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContainersFunctionTableReference(PPASSQLStatementParser.ContainersFunctionTableReferenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code shardsFunctionTableReference}
	 * labeled alternative in {@link PPASSQLStatementParser#tableReferenceBasic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShardsFunctionTableReference(PPASSQLStatementParser.ShardsFunctionTableReferenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inlineAnalyticViewTableReference}
	 * labeled alternative in {@link PPASSQLStatementParser#tableReferenceBasic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInlineAnalyticViewTableReference(PPASSQLStatementParser.InlineAnalyticViewTableReferenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenJoinTableReference}
	 * labeled alternative in {@link PPASSQLStatementParser#tableReferenceBasic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenJoinTableReference(PPASSQLStatementParser.ParenJoinTableReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#joinTableReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoinTableReference(PPASSQLStatementParser.JoinTableReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#objectNameTableReferenceOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectNameTableReferenceOption(PPASSQLStatementParser.ObjectNameTableReferenceOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#joinType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoinType(PPASSQLStatementParser.JoinTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#rightJoinClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRightJoinClause(PPASSQLStatementParser.RightJoinClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code joinCondition}
	 * labeled alternative in {@link PPASSQLStatementParser#joinSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoinCondition(PPASSQLStatementParser.JoinConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code namedColumnsJoin}
	 * labeled alternative in {@link PPASSQLStatementParser#joinSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNamedColumnsJoin(PPASSQLStatementParser.NamedColumnsJoinContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#locationClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocationClause(PPASSQLStatementParser.LocationClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#locationClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocationClauseItem(PPASSQLStatementParser.LocationClauseItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#modifiedExternalTableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModifiedExternalTableClause(PPASSQLStatementParser.ModifiedExternalTableClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code flashbackQueryByVersionsBetweenClause}
	 * labeled alternative in {@link PPASSQLStatementParser#flashbackQueryClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlashbackQueryByVersionsBetweenClause(PPASSQLStatementParser.FlashbackQueryByVersionsBetweenClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code flashbackQueryByVersionsPeriodForClause}
	 * labeled alternative in {@link PPASSQLStatementParser#flashbackQueryClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlashbackQueryByVersionsPeriodForClause(PPASSQLStatementParser.FlashbackQueryByVersionsPeriodForClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code flashbackQueryByAsOfClause}
	 * labeled alternative in {@link PPASSQLStatementParser#flashbackQueryClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlashbackQueryByAsOfClause(PPASSQLStatementParser.FlashbackQueryByAsOfClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code flashbackQueryByAsOfPeriodForClause}
	 * labeled alternative in {@link PPASSQLStatementParser#flashbackQueryClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlashbackQueryByAsOfPeriodForClause(PPASSQLStatementParser.FlashbackQueryByAsOfPeriodForClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#inlineExternalTable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInlineExternalTable(PPASSQLStatementParser.InlineExternalTableContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#iPivotClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIPivotClause(PPASSQLStatementParser.IPivotClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#pivotClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPivotClause(PPASSQLStatementParser.PivotClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#pivotItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPivotItem(PPASSQLStatementParser.PivotItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#unpivotClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnpivotClause(PPASSQLStatementParser.UnpivotClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#sampleClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSampleClause(PPASSQLStatementParser.SampleClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code partitionClause}
	 * labeled alternative in {@link PPASSQLStatementParser#iPartitionClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionClause(PPASSQLStatementParser.PartitionClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code partitionForClause}
	 * labeled alternative in {@link PPASSQLStatementParser#iPartitionClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionForClause(PPASSQLStatementParser.PartitionForClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code subPartitionClause}
	 * labeled alternative in {@link PPASSQLStatementParser#iPartitionClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubPartitionClause(PPASSQLStatementParser.SubPartitionClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code subPartitionForClause}
	 * labeled alternative in {@link PPASSQLStatementParser#iPartitionClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubPartitionForClause(PPASSQLStatementParser.SubPartitionForClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code withReadOnly}
	 * labeled alternative in {@link PPASSQLStatementParser#iSubQueryRestrictionClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithReadOnly(PPASSQLStatementParser.WithReadOnlyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code withCheckOption}
	 * labeled alternative in {@link PPASSQLStatementParser#iSubQueryRestrictionClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithCheckOption(PPASSQLStatementParser.WithCheckOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#whereClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhereClause(PPASSQLStatementParser.WhereClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#currentOfClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCurrentOfClause(PPASSQLStatementParser.CurrentOfClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code hierarchicalQueryConnectByToStartWithClause}
	 * labeled alternative in {@link PPASSQLStatementParser#hierarchicalQueryClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHierarchicalQueryConnectByToStartWithClause(PPASSQLStatementParser.HierarchicalQueryConnectByToStartWithClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code hierarchicalQueryStartWithToConnectByClause}
	 * labeled alternative in {@link PPASSQLStatementParser#hierarchicalQueryClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHierarchicalQueryStartWithToConnectByClause(PPASSQLStatementParser.HierarchicalQueryStartWithToConnectByClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code groupByHavingClause}
	 * labeled alternative in {@link PPASSQLStatementParser#groupByClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroupByHavingClause(PPASSQLStatementParser.GroupByHavingClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code havingGroupByClause}
	 * labeled alternative in {@link PPASSQLStatementParser#groupByClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHavingGroupByClause(PPASSQLStatementParser.HavingGroupByClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#havingClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHavingClause(PPASSQLStatementParser.HavingClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#groupByItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroupByItem(PPASSQLStatementParser.GroupByItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#rollupCubeClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRollupCubeClause(PPASSQLStatementParser.RollupCubeClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#groupingSetsClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroupingSetsClause(PPASSQLStatementParser.GroupingSetsClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#groupingSetsClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroupingSetsClauseItem(PPASSQLStatementParser.GroupingSetsClauseItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#modelClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModelClause(PPASSQLStatementParser.ModelClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#cellReferenceOptions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCellReferenceOptions(PPASSQLStatementParser.CellReferenceOptionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#returnRowsClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnRowsClause(PPASSQLStatementParser.ReturnRowsClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#referenceModel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReferenceModel(PPASSQLStatementParser.ReferenceModelContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#mainModel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMainModel(PPASSQLStatementParser.MainModelContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#modelColumnClauses}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModelColumnClauses(PPASSQLStatementParser.ModelColumnClausesContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#modelColumnClausesItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModelColumnClausesItem(PPASSQLStatementParser.ModelColumnClausesItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#modelRulesClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModelRulesClause(PPASSQLStatementParser.ModelRulesClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#modelRulesClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModelRulesClauseItem(PPASSQLStatementParser.ModelRulesClauseItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#modelIterateClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModelIterateClause(PPASSQLStatementParser.ModelIterateClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#cellAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCellAssignment(PPASSQLStatementParser.CellAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#cellAssignmentItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCellAssignmentItem(PPASSQLStatementParser.CellAssignmentItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#singleColumnForLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleColumnForLoop(PPASSQLStatementParser.SingleColumnForLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#multiColumnForLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiColumnForLoop(PPASSQLStatementParser.MultiColumnForLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#orderByClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrderByClause(PPASSQLStatementParser.OrderByClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#orderByItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrderByItem(PPASSQLStatementParser.OrderByItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#rowLimitingClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowLimitingClause(PPASSQLStatementParser.RowLimitingClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#forUpdateClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForUpdateClause(PPASSQLStatementParser.ForUpdateClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forUpdateSkipLockedOption}
	 * labeled alternative in {@link PPASSQLStatementParser#forUpdateOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForUpdateSkipLockedOption(PPASSQLStatementParser.ForUpdateSkipLockedOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forUpdateNoWaitOption}
	 * labeled alternative in {@link PPASSQLStatementParser#forUpdateOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForUpdateNoWaitOption(PPASSQLStatementParser.ForUpdateNoWaitOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forUpdateWaitOption}
	 * labeled alternative in {@link PPASSQLStatementParser#forUpdateOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForUpdateWaitOption(PPASSQLStatementParser.ForUpdateWaitOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#rowPatternClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowPatternClause(PPASSQLStatementParser.RowPatternClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#rowPatternRowsPerMatch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowPatternRowsPerMatch(PPASSQLStatementParser.RowPatternRowsPerMatchContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rowPatternSkipToNextRow}
	 * labeled alternative in {@link PPASSQLStatementParser#rowPatternSkipTo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowPatternSkipToNextRow(PPASSQLStatementParser.RowPatternSkipToNextRowContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rowPatternSkipPastLastRow}
	 * labeled alternative in {@link PPASSQLStatementParser#rowPatternSkipTo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowPatternSkipPastLastRow(PPASSQLStatementParser.RowPatternSkipPastLastRowContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rowPatternSkipToFirstVar}
	 * labeled alternative in {@link PPASSQLStatementParser#rowPatternSkipTo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowPatternSkipToFirstVar(PPASSQLStatementParser.RowPatternSkipToFirstVarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rowPatternSkipToLastVart}
	 * labeled alternative in {@link PPASSQLStatementParser#rowPatternSkipTo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowPatternSkipToLastVart(PPASSQLStatementParser.RowPatternSkipToLastVartContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rowPatternSkipToVar}
	 * labeled alternative in {@link PPASSQLStatementParser#rowPatternSkipTo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowPatternSkipToVar(PPASSQLStatementParser.RowPatternSkipToVarContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#rowPattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowPattern(PPASSQLStatementParser.RowPatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#rowPatternTerm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowPatternTerm(PPASSQLStatementParser.RowPatternTermContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#rowPatternFactor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowPatternFactor(PPASSQLStatementParser.RowPatternFactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#rowPatternPrimary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowPatternPrimary(PPASSQLStatementParser.RowPatternPrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#rowPatternPermute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowPatternPermute(PPASSQLStatementParser.RowPatternPermuteContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#rowPatternQuantifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowPatternQuantifier(PPASSQLStatementParser.RowPatternQuantifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#rowPatternSubsetClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowPatternSubsetClause(PPASSQLStatementParser.RowPatternSubsetClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#row_pattern_subset_item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRow_pattern_subset_item(PPASSQLStatementParser.Row_pattern_subset_itemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#row_pattern_rec_func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRow_pattern_rec_func(PPASSQLStatementParser.Row_pattern_rec_funcContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#row_pattern_classifier_func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRow_pattern_classifier_func(PPASSQLStatementParser.Row_pattern_classifier_funcContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#row_pattern_match_num_func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRow_pattern_match_num_func(PPASSQLStatementParser.Row_pattern_match_num_funcContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#row_pattern_navigation_func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRow_pattern_navigation_func(PPASSQLStatementParser.Row_pattern_navigation_funcContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#rowPatternNavLogical}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowPatternNavLogical(PPASSQLStatementParser.RowPatternNavLogicalContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#rowPatternNavPhysical}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowPatternNavPhysical(PPASSQLStatementParser.RowPatternNavPhysicalContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#rowPatternNavCompound}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowPatternNavCompound(PPASSQLStatementParser.RowPatternNavCompoundContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#rowPatternAggregateFunc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowPatternAggregateFunc(PPASSQLStatementParser.RowPatternAggregateFuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#updateStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdateStatement(PPASSQLStatementParser.UpdateStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code updateSetClause}
	 * labeled alternative in {@link PPASSQLStatementParser#iUpdateSetClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdateSetClause(PPASSQLStatementParser.UpdateSetClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code updateSetByValueClause}
	 * labeled alternative in {@link PPASSQLStatementParser#iUpdateSetClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdateSetByValueClause(PPASSQLStatementParser.UpdateSetByValueClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#updateSetItemClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdateSetItemClause(PPASSQLStatementParser.UpdateSetItemClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#commitStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommitStatement(PPASSQLStatementParser.CommitStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#commitStatementOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommitStatementOption(PPASSQLStatementParser.CommitStatementOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#commitStatementCommentOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommitStatementCommentOption(PPASSQLStatementParser.CommitStatementCommentOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#commitStatementWriteOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommitStatementWriteOption(PPASSQLStatementParser.CommitStatementWriteOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#commitStatementForceOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommitStatementForceOption(PPASSQLStatementParser.CommitStatementForceOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#rollbackStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRollbackStatement(PPASSQLStatementParser.RollbackStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#rollbackStatementOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRollbackStatementOption(PPASSQLStatementParser.RollbackStatementOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#rollbackStatementToSavepointOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRollbackStatementToSavepointOption(PPASSQLStatementParser.RollbackStatementToSavepointOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#rollbackStatementForceOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRollbackStatementForceOption(PPASSQLStatementParser.RollbackStatementForceOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#savepointStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSavepointStatement(PPASSQLStatementParser.SavepointStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#setTransactionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetTransactionStatement(PPASSQLStatementParser.SetTransactionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#setTransactionStatementOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetTransactionStatementOption(PPASSQLStatementParser.SetTransactionStatementOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#setTransactionStatementReadOnlyOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetTransactionStatementReadOnlyOption(PPASSQLStatementParser.SetTransactionStatementReadOnlyOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#setTransactionStatementReadWriteOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetTransactionStatementReadWriteOption(PPASSQLStatementParser.SetTransactionStatementReadWriteOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#setTransactionStatementIsolationLevelOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetTransactionStatementIsolationLevelOption(PPASSQLStatementParser.SetTransactionStatementIsolationLevelOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#setTransactionStatementUseRollbackSegmentOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetTransactionStatementUseRollbackSegmentOption(PPASSQLStatementParser.SetTransactionStatementUseRollbackSegmentOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#setTransactionStatementNameOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetTransactionStatementNameOption(PPASSQLStatementParser.SetTransactionStatementNameOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#setConstraintStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetConstraintStatement(PPASSQLStatementParser.SetConstraintStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#setConstraintsStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetConstraintsStatement(PPASSQLStatementParser.SetConstraintsStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#alterSessionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterSessionStatement(PPASSQLStatementParser.AlterSessionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#setRoleStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetRoleStatement(PPASSQLStatementParser.SetRoleStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#whenever_command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhenever_command(PPASSQLStatementParser.Whenever_commandContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#set_command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSet_command(PPASSQLStatementParser.Set_commandContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#exit_command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExit_command(PPASSQLStatementParser.Exit_commandContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#prompt_command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrompt_command(PPASSQLStatementParser.Prompt_commandContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#show_errors_command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShow_errors_command(PPASSQLStatementParser.Show_errors_commandContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#start_command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart_command(PPASSQLStatementParser.Start_commandContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#native_datatype_element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNative_datatype_element(PPASSQLStatementParser.Native_datatype_elementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#allTokens}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAllTokens(PPASSQLStatementParser.AllTokensContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataType(PPASSQLStatementParser.DataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code charDataType}
	 * labeled alternative in {@link PPASSQLStatementParser#iCharacterDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharDataType(PPASSQLStatementParser.CharDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varchar2DataType}
	 * labeled alternative in {@link PPASSQLStatementParser#iCharacterDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarchar2DataType(PPASSQLStatementParser.Varchar2DataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ncharDataType}
	 * labeled alternative in {@link PPASSQLStatementParser#iCharacterDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNcharDataType(PPASSQLStatementParser.NcharDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nvarchar2DataType}
	 * labeled alternative in {@link PPASSQLStatementParser#iCharacterDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNvarchar2DataType(PPASSQLStatementParser.Nvarchar2DataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numberDataType}
	 * labeled alternative in {@link PPASSQLStatementParser#iNumericDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberDataType(PPASSQLStatementParser.NumberDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code floatDataType}
	 * labeled alternative in {@link PPASSQLStatementParser#iNumericDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatDataType(PPASSQLStatementParser.FloatDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryFloatDataType}
	 * labeled alternative in {@link PPASSQLStatementParser#iNumericDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryFloatDataType(PPASSQLStatementParser.BinaryFloatDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryDoubleDataType}
	 * labeled alternative in {@link PPASSQLStatementParser#iNumericDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryDoubleDataType(PPASSQLStatementParser.BinaryDoubleDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code longDataType}
	 * labeled alternative in {@link PPASSQLStatementParser#longAndRawDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLongDataType(PPASSQLStatementParser.LongDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code longRawDataType}
	 * labeled alternative in {@link PPASSQLStatementParser#longAndRawDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLongRawDataType(PPASSQLStatementParser.LongRawDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rawDataType}
	 * labeled alternative in {@link PPASSQLStatementParser#longAndRawDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRawDataType(PPASSQLStatementParser.RawDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dateDataType}
	 * labeled alternative in {@link PPASSQLStatementParser#dateTimeDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDateDataType(PPASSQLStatementParser.DateDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code timestampDataType}
	 * labeled alternative in {@link PPASSQLStatementParser#dateTimeDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimestampDataType(PPASSQLStatementParser.TimestampDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intervalDataType}
	 * labeled alternative in {@link PPASSQLStatementParser#dateTimeDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntervalDataType(PPASSQLStatementParser.IntervalDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code blobDataType}
	 * labeled alternative in {@link PPASSQLStatementParser#largeObjectDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlobDataType(PPASSQLStatementParser.BlobDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code clobDataType}
	 * labeled alternative in {@link PPASSQLStatementParser#largeObjectDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClobDataType(PPASSQLStatementParser.ClobDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nclobDataType}
	 * labeled alternative in {@link PPASSQLStatementParser#largeObjectDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNclobDataType(PPASSQLStatementParser.NclobDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bfileDataType}
	 * labeled alternative in {@link PPASSQLStatementParser#largeObjectDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBfileDataType(PPASSQLStatementParser.BfileDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rowidDataType}
	 * labeled alternative in {@link PPASSQLStatementParser#iRowidDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowidDataType(PPASSQLStatementParser.RowidDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code urowidDataType}
	 * labeled alternative in {@link PPASSQLStatementParser#iRowidDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUrowidDataType(PPASSQLStatementParser.UrowidDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#booleanDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanDataType(PPASSQLStatementParser.BooleanDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code characterDataType}
	 * labeled alternative in {@link PPASSQLStatementParser#ansiSupportedDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharacterDataType(PPASSQLStatementParser.CharacterDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code characterVaryingDataType}
	 * labeled alternative in {@link PPASSQLStatementParser#ansiSupportedDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharacterVaryingDataType(PPASSQLStatementParser.CharacterVaryingDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code charVaryingDataType}
	 * labeled alternative in {@link PPASSQLStatementParser#ansiSupportedDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharVaryingDataType(PPASSQLStatementParser.CharVaryingDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ncharVaryingDataType}
	 * labeled alternative in {@link PPASSQLStatementParser#ansiSupportedDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNcharVaryingDataType(PPASSQLStatementParser.NcharVaryingDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varcharDataType}
	 * labeled alternative in {@link PPASSQLStatementParser#ansiSupportedDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarcharDataType(PPASSQLStatementParser.VarcharDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nationalCharacterDataType}
	 * labeled alternative in {@link PPASSQLStatementParser#ansiSupportedDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNationalCharacterDataType(PPASSQLStatementParser.NationalCharacterDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nationalCharDataType}
	 * labeled alternative in {@link PPASSQLStatementParser#ansiSupportedDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNationalCharDataType(PPASSQLStatementParser.NationalCharDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nationalCharacterVaryingDataType}
	 * labeled alternative in {@link PPASSQLStatementParser#ansiSupportedDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNationalCharacterVaryingDataType(PPASSQLStatementParser.NationalCharacterVaryingDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nationalCharVaryingDataType}
	 * labeled alternative in {@link PPASSQLStatementParser#ansiSupportedDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNationalCharVaryingDataType(PPASSQLStatementParser.NationalCharVaryingDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numericDataType}
	 * labeled alternative in {@link PPASSQLStatementParser#ansiSupportedDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumericDataType(PPASSQLStatementParser.NumericDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code decimalDataType}
	 * labeled alternative in {@link PPASSQLStatementParser#ansiSupportedDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecimalDataType(PPASSQLStatementParser.DecimalDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code decDataType}
	 * labeled alternative in {@link PPASSQLStatementParser#ansiSupportedDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecDataType(PPASSQLStatementParser.DecDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code integerDataType}
	 * labeled alternative in {@link PPASSQLStatementParser#ansiSupportedDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerDataType(PPASSQLStatementParser.IntegerDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intDataType}
	 * labeled alternative in {@link PPASSQLStatementParser#ansiSupportedDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntDataType(PPASSQLStatementParser.IntDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code smallintDataType}
	 * labeled alternative in {@link PPASSQLStatementParser#ansiSupportedDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSmallintDataType(PPASSQLStatementParser.SmallintDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code doublePrecisionDataType}
	 * labeled alternative in {@link PPASSQLStatementParser#ansiSupportedDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoublePrecisionDataType(PPASSQLStatementParser.DoublePrecisionDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code realDataType}
	 * labeled alternative in {@link PPASSQLStatementParser#ansiSupportedDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRealDataType(PPASSQLStatementParser.RealDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sysAnyDataDataType}
	 * labeled alternative in {@link PPASSQLStatementParser#anyDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSysAnyDataDataType(PPASSQLStatementParser.SysAnyDataDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sysAnyTypeDataType}
	 * labeled alternative in {@link PPASSQLStatementParser#anyDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSysAnyTypeDataType(PPASSQLStatementParser.SysAnyTypeDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sysAnyDataSetDataType}
	 * labeled alternative in {@link PPASSQLStatementParser#anyDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSysAnyDataSetDataType(PPASSQLStatementParser.SysAnyDataSetDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code xmlTypeDataType}
	 * labeled alternative in {@link PPASSQLStatementParser#xmlDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlTypeDataType(PPASSQLStatementParser.XmlTypeDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code uriTypeDataType}
	 * labeled alternative in {@link PPASSQLStatementParser#xmlDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUriTypeDataType(PPASSQLStatementParser.UriTypeDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jsonDataType}
	 * labeled alternative in {@link PPASSQLStatementParser#iJsonDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonDataType(PPASSQLStatementParser.JsonDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sdoGeometryDataType}
	 * labeled alternative in {@link PPASSQLStatementParser#spatialDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSdoGeometryDataType(PPASSQLStatementParser.SdoGeometryDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sdoTopoGeometryDataType}
	 * labeled alternative in {@link PPASSQLStatementParser#spatialDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSdoTopoGeometryDataType(PPASSQLStatementParser.SdoTopoGeometryDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sdoGeorasterDataType}
	 * labeled alternative in {@link PPASSQLStatementParser#spatialDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSdoGeorasterDataType(PPASSQLStatementParser.SdoGeorasterDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code oRDAUDIODataType}
	 * labeled alternative in {@link PPASSQLStatementParser#mediaDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitORDAUDIODataType(PPASSQLStatementParser.ORDAUDIODataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code oRDIMAGEDataType}
	 * labeled alternative in {@link PPASSQLStatementParser#mediaDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitORDIMAGEDataType(PPASSQLStatementParser.ORDIMAGEDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code oRDVIDEODataType}
	 * labeled alternative in {@link PPASSQLStatementParser#mediaDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitORDVIDEODataType(PPASSQLStatementParser.ORDVIDEODataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code oRDDOCDataType}
	 * labeled alternative in {@link PPASSQLStatementParser#mediaDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitORDDOCDataType(PPASSQLStatementParser.ORDDOCDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code oRDDICOMDataType}
	 * labeled alternative in {@link PPASSQLStatementParser#mediaDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitORDDICOMDataType(PPASSQLStatementParser.ORDDICOMDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code siStillimageDataType}
	 * labeled alternative in {@link PPASSQLStatementParser#mediaDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSiStillimageDataType(PPASSQLStatementParser.SiStillimageDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code siAveragecolorDataType}
	 * labeled alternative in {@link PPASSQLStatementParser#mediaDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSiAveragecolorDataType(PPASSQLStatementParser.SiAveragecolorDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code siPositionalcolorDataType}
	 * labeled alternative in {@link PPASSQLStatementParser#mediaDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSiPositionalcolorDataType(PPASSQLStatementParser.SiPositionalcolorDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code siColorhistogramDataType}
	 * labeled alternative in {@link PPASSQLStatementParser#mediaDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSiColorhistogramDataType(PPASSQLStatementParser.SiColorhistogramDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code siTextureDataType}
	 * labeled alternative in {@link PPASSQLStatementParser#mediaDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSiTextureDataType(PPASSQLStatementParser.SiTextureDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code siFeaturelistDataType}
	 * labeled alternative in {@link PPASSQLStatementParser#mediaDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSiFeaturelistDataType(PPASSQLStatementParser.SiFeaturelistDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code siColorDataType}
	 * labeled alternative in {@link PPASSQLStatementParser#mediaDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSiColorDataType(PPASSQLStatementParser.SiColorDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#plsIntegerDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlsIntegerDataType(PPASSQLStatementParser.PlsIntegerDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#naturalDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNaturalDataType(PPASSQLStatementParser.NaturalDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#naturalnDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNaturalnDataType(PPASSQLStatementParser.NaturalnDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#positiveDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPositiveDataType(PPASSQLStatementParser.PositiveDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#positivenDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPositivenDataType(PPASSQLStatementParser.PositivenDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#signtypeDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSigntypeDataType(PPASSQLStatementParser.SigntypeDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#simpleIntegerDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleIntegerDataType(PPASSQLStatementParser.SimpleIntegerDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#binaryIntegerDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryIntegerDataType(PPASSQLStatementParser.BinaryIntegerDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#collectionDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCollectionDataType(PPASSQLStatementParser.CollectionDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#refDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRefDataType(PPASSQLStatementParser.RefDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#otherDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOtherDataType(PPASSQLStatementParser.OtherDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#refCursorDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRefCursorDataType(PPASSQLStatementParser.RefCursorDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#typeDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDataType(PPASSQLStatementParser.TypeDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#rowtypeDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowtypeDataType(PPASSQLStatementParser.RowtypeDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#assocArrayDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssocArrayDataType(PPASSQLStatementParser.AssocArrayDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#varrayDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarrayDataType(PPASSQLStatementParser.VarrayDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#varyingArrayDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVaryingArrayDataType(PPASSQLStatementParser.VaryingArrayDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#nestedTableDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNestedTableDataType(PPASSQLStatementParser.NestedTableDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#objectSubDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectSubDataType(PPASSQLStatementParser.ObjectSubDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#objectDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectDataType(PPASSQLStatementParser.ObjectDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#selfAsResultDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelfAsResultDataType(PPASSQLStatementParser.SelfAsResultDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code asteriskIdentifier}
	 * labeled alternative in {@link PPASSQLStatementParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsteriskIdentifier(PPASSQLStatementParser.AsteriskIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rowNumExpr}
	 * labeled alternative in {@link PPASSQLStatementParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowNumExpr(PPASSQLStatementParser.RowNumExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rowIdExpr}
	 * labeled alternative in {@link PPASSQLStatementParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowIdExpr(PPASSQLStatementParser.RowIdExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code normalIdentifier}
	 * labeled alternative in {@link PPASSQLStatementParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalIdentifier(PPASSQLStatementParser.NormalIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code doubleQuoteIdentifier}
	 * labeled alternative in {@link PPASSQLStatementParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleQuoteIdentifier(PPASSQLStatementParser.DoubleQuoteIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code identifier1}
	 * labeled alternative in {@link PPASSQLStatementParser#nameIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier1(PPASSQLStatementParser.Identifier1Context ctx);
	/**
	 * Visit a parse tree produced by the {@code propertyIdentifier1}
	 * labeled alternative in {@link PPASSQLStatementParser#nameIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertyIdentifier1(PPASSQLStatementParser.PropertyIdentifier1Context ctx);
	/**
	 * Visit a parse tree produced by the {@code dbLinkNameIdentifier}
	 * labeled alternative in {@link PPASSQLStatementParser#nameIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDbLinkNameIdentifier(PPASSQLStatementParser.DbLinkNameIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nQCharLiteral}
	 * labeled alternative in {@link PPASSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNQCharLiteral(PPASSQLStatementParser.NQCharLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nCharLiteral}
	 * labeled alternative in {@link PPASSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNCharLiteral(PPASSQLStatementParser.NCharLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code qCharLiteral}
	 * labeled alternative in {@link PPASSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQCharLiteral(PPASSQLStatementParser.QCharLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code charLiteral}
	 * labeled alternative in {@link PPASSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharLiteral(PPASSQLStatementParser.CharLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code integerLiteral}
	 * labeled alternative in {@link PPASSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerLiteral(PPASSQLStatementParser.IntegerLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numberLiteral}
	 * labeled alternative in {@link PPASSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberLiteral(PPASSQLStatementParser.NumberLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryFloatLiteral}
	 * labeled alternative in {@link PPASSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryFloatLiteral(PPASSQLStatementParser.BinaryFloatLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryDoubleLiteral}
	 * labeled alternative in {@link PPASSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryDoubleLiteral(PPASSQLStatementParser.BinaryDoubleLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dateLiteral}
	 * labeled alternative in {@link PPASSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDateLiteral(PPASSQLStatementParser.DateLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code timestampLiteral}
	 * labeled alternative in {@link PPASSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimestampLiteral(PPASSQLStatementParser.TimestampLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intervalLiteral}
	 * labeled alternative in {@link PPASSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntervalLiteral(PPASSQLStatementParser.IntervalLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code defaultLiteral}
	 * labeled alternative in {@link PPASSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultLiteral(PPASSQLStatementParser.DefaultLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code anyLiteral}
	 * labeled alternative in {@link PPASSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnyLiteral(PPASSQLStatementParser.AnyLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code minValueLiteral}
	 * labeled alternative in {@link PPASSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinValueLiteral(PPASSQLStatementParser.MinValueLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code maxValueLiteral}
	 * labeled alternative in {@link PPASSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMaxValueLiteral(PPASSQLStatementParser.MaxValueLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unlimitedLiteral}
	 * labeled alternative in {@link PPASSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnlimitedLiteral(PPASSQLStatementParser.UnlimitedLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code falseLiteral}
	 * labeled alternative in {@link PPASSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalseLiteral(PPASSQLStatementParser.FalseLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code trueLiteral}
	 * labeled alternative in {@link PPASSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueLiteral(PPASSQLStatementParser.TrueLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#unaryOperatorExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryOperatorExpr(PPASSQLStatementParser.UnaryOperatorExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#unaryOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryOperator(PPASSQLStatementParser.UnaryOperatorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multisetExceptOperatorExpr}
	 * labeled alternative in {@link PPASSQLStatementParser#multisetOperatorExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultisetExceptOperatorExpr(PPASSQLStatementParser.MultisetExceptOperatorExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multisetIntersectOperatorExpr}
	 * labeled alternative in {@link PPASSQLStatementParser#multisetOperatorExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultisetIntersectOperatorExpr(PPASSQLStatementParser.MultisetIntersectOperatorExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multisetUnionOperatorExpr}
	 * labeled alternative in {@link PPASSQLStatementParser#multisetOperatorExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultisetUnionOperatorExpr(PPASSQLStatementParser.MultisetUnionOperatorExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#variableExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableExpr(PPASSQLStatementParser.VariableExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#bindVariableExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBindVariableExpr(PPASSQLStatementParser.BindVariableExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#newVariableRefExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewVariableRefExpr(PPASSQLStatementParser.NewVariableRefExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#oldVariableRefExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOldVariableRefExpr(PPASSQLStatementParser.OldVariableRefExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#selectQueryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectQueryExpr(PPASSQLStatementParser.SelectQueryExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#nullExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullExpr(PPASSQLStatementParser.NullExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#sequenceExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSequenceExpr(PPASSQLStatementParser.SequenceExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#caseExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseExpr(PPASSQLStatementParser.CaseExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#caseExprWhenItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseExprWhenItem(PPASSQLStatementParser.CaseExprWhenItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#caseExprElseClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseExprElseClause(PPASSQLStatementParser.CaseExprElseClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#intervalExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntervalExpr(PPASSQLStatementParser.IntervalExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#placeholderExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlaceholderExpr(PPASSQLStatementParser.PlaceholderExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#typeConstructorExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeConstructorExpr(PPASSQLStatementParser.TypeConstructorExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#listExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListExpr(PPASSQLStatementParser.ListExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#exprBasic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprBasic(PPASSQLStatementParser.ExprBasicContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inCondition}
	 * labeled alternative in {@link PPASSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInCondition(PPASSQLStatementParser.InConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code isNullCondition}
	 * labeled alternative in {@link PPASSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsNullCondition(PPASSQLStatementParser.IsNullConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code iCondition}
	 * labeled alternative in {@link PPASSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitICondition(PPASSQLStatementParser.IConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code callArgumentExpr}
	 * labeled alternative in {@link PPASSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallArgumentExpr(PPASSQLStatementParser.CallArgumentExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryOperatorExpr}
	 * labeled alternative in {@link PPASSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryOperatorExpr(PPASSQLStatementParser.BinaryOperatorExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code likeCondition}
	 * labeled alternative in {@link PPASSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLikeCondition(PPASSQLStatementParser.LikeConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code propertyIdentifier2}
	 * labeled alternative in {@link PPASSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertyIdentifier2(PPASSQLStatementParser.PropertyIdentifier2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code isNanCondition}
	 * labeled alternative in {@link PPASSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsNanCondition(PPASSQLStatementParser.IsNanConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code isInfiniteCondition}
	 * labeled alternative in {@link PPASSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsInfiniteCondition(PPASSQLStatementParser.IsInfiniteConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dateTimeAtTimeZoneExpr}
	 * labeled alternative in {@link PPASSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDateTimeAtTimeZoneExpr(PPASSQLStatementParser.DateTimeAtTimeZoneExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cursorExpr}
	 * labeled alternative in {@link PPASSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCursorExpr(PPASSQLStatementParser.CursorExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code concatenationBinaryOperatorExpr}
	 * labeled alternative in {@link PPASSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConcatenationBinaryOperatorExpr(PPASSQLStatementParser.ConcatenationBinaryOperatorExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprToExprExpr}
	 * labeled alternative in {@link PPASSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprToExprExpr(PPASSQLStatementParser.ExprToExprExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code someExpr}
	 * labeled alternative in {@link PPASSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSomeExpr(PPASSQLStatementParser.SomeExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code isPresentCondition}
	 * labeled alternative in {@link PPASSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsPresentCondition(PPASSQLStatementParser.IsPresentConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code memberCondition}
	 * labeled alternative in {@link PPASSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberCondition(PPASSQLStatementParser.MemberConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayExpr}
	 * labeled alternative in {@link PPASSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayExpr(PPASSQLStatementParser.ArrayExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code isJsonCondition}
	 * labeled alternative in {@link PPASSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsJsonCondition(PPASSQLStatementParser.IsJsonConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code allExpr}
	 * labeled alternative in {@link PPASSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAllExpr(PPASSQLStatementParser.AllExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dateTimeAtLocalExpr}
	 * labeled alternative in {@link PPASSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDateTimeAtLocalExpr(PPASSQLStatementParser.DateTimeAtLocalExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code methodInvocation1}
	 * labeled alternative in {@link PPASSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodInvocation1(PPASSQLStatementParser.MethodInvocation1Context ctx);
	/**
	 * Visit a parse tree produced by the {@code basicExpr}
	 * labeled alternative in {@link PPASSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicExpr(PPASSQLStatementParser.BasicExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code methodInvocation2}
	 * labeled alternative in {@link PPASSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodInvocation2(PPASSQLStatementParser.MethodInvocation2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code relationalBinaryOperatorExpr}
	 * labeled alternative in {@link PPASSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalBinaryOperatorExpr(PPASSQLStatementParser.RelationalBinaryOperatorExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code outerExpr}
	 * labeled alternative in {@link PPASSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOuterExpr(PPASSQLStatementParser.OuterExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code betweenCondition}
	 * labeled alternative in {@link PPASSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBetweenCondition(PPASSQLStatementParser.BetweenConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code anyExpr}
	 * labeled alternative in {@link PPASSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnyExpr(PPASSQLStatementParser.AnyExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code isOfTypeCondition}
	 * labeled alternative in {@link PPASSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsOfTypeCondition(PPASSQLStatementParser.IsOfTypeConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#concatenationOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConcatenationOp(PPASSQLStatementParser.ConcatenationOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#comparisonOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonOp(PPASSQLStatementParser.ComparisonOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#defaultOnConversionErrorExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultOnConversionErrorExpr(PPASSQLStatementParser.DefaultOnConversionErrorExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#defaultClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultClause(PPASSQLStatementParser.DefaultClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#assignmentExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentExpr(PPASSQLStatementParser.AssignmentExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#editionableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEditionableClause(PPASSQLStatementParser.EditionableClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#nonEditionableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonEditionableClause(PPASSQLStatementParser.NonEditionableClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#enableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnableClause(PPASSQLStatementParser.EnableClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#disableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDisableClause(PPASSQLStatementParser.DisableClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#renameToClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRenameToClause(PPASSQLStatementParser.RenameToClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#exceptionClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExceptionClause(PPASSQLStatementParser.ExceptionClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#usingClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUsingClause(PPASSQLStatementParser.UsingClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#usingArgumentClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUsingArgumentClause(PPASSQLStatementParser.UsingArgumentClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#attributeDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributeDefinition(PPASSQLStatementParser.AttributeDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#finalClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFinalClause(PPASSQLStatementParser.FinalClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#notFinalClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotFinalClause(PPASSQLStatementParser.NotFinalClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#instantiableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstantiableClause(PPASSQLStatementParser.InstantiableClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#notInstantiableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotInstantiableClause(PPASSQLStatementParser.NotInstantiableClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#persistableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPersistableClause(PPASSQLStatementParser.PersistableClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#notPersistableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotPersistableClause(PPASSQLStatementParser.NotPersistableClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#secureFileClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSecureFileClause(PPASSQLStatementParser.SecureFileClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#basicFileClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicFileClause(PPASSQLStatementParser.BasicFileClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code isOpenImplicitCursorExpr}
	 * labeled alternative in {@link PPASSQLStatementParser#implicitCursorExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsOpenImplicitCursorExpr(PPASSQLStatementParser.IsOpenImplicitCursorExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code foundImplicitCursorExpr}
	 * labeled alternative in {@link PPASSQLStatementParser#implicitCursorExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFoundImplicitCursorExpr(PPASSQLStatementParser.FoundImplicitCursorExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notFoundImplicitCursorExpr}
	 * labeled alternative in {@link PPASSQLStatementParser#implicitCursorExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotFoundImplicitCursorExpr(PPASSQLStatementParser.NotFoundImplicitCursorExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rowcountImplicitCursorExpr}
	 * labeled alternative in {@link PPASSQLStatementParser#implicitCursorExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowcountImplicitCursorExpr(PPASSQLStatementParser.RowcountImplicitCursorExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bulkRowcountImplicitCursorExpr}
	 * labeled alternative in {@link PPASSQLStatementParser#implicitCursorExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBulkRowcountImplicitCursorExpr(PPASSQLStatementParser.BulkRowcountImplicitCursorExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bulkExceptionsCountImplicitCursorExpr}
	 * labeled alternative in {@link PPASSQLStatementParser#implicitCursorExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBulkExceptionsCountImplicitCursorExpr(PPASSQLStatementParser.BulkExceptionsCountImplicitCursorExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bulkExceptionImplicitCursorExpr}
	 * labeled alternative in {@link PPASSQLStatementParser#implicitCursorExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBulkExceptionImplicitCursorExpr(PPASSQLStatementParser.BulkExceptionImplicitCursorExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code isOpenNameCursorExpr}
	 * labeled alternative in {@link PPASSQLStatementParser#namedCursorExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsOpenNameCursorExpr(PPASSQLStatementParser.IsOpenNameCursorExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code foundNameCursorExpr}
	 * labeled alternative in {@link PPASSQLStatementParser#namedCursorExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFoundNameCursorExpr(PPASSQLStatementParser.FoundNameCursorExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notFoundNameCursorExpr}
	 * labeled alternative in {@link PPASSQLStatementParser#namedCursorExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotFoundNameCursorExpr(PPASSQLStatementParser.NotFoundNameCursorExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rowcountNameCursorExpr}
	 * labeled alternative in {@link PPASSQLStatementParser#namedCursorExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowcountNameCursorExpr(PPASSQLStatementParser.RowcountNameCursorExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#namedCursorName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNamedCursorName(PPASSQLStatementParser.NamedCursorNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(PPASSQLStatementParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#notCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotCondition(PPASSQLStatementParser.NotConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#isAnyCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsAnyCondition(PPASSQLStatementParser.IsAnyConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#isASetCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsASetCondition(PPASSQLStatementParser.IsASetConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#isEmptyCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsEmptyCondition(PPASSQLStatementParser.IsEmptyConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#submultisetCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubmultisetCondition(PPASSQLStatementParser.SubmultisetConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#regexpLikeCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegexpLikeCondition(PPASSQLStatementParser.RegexpLikeConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#formatJson}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormatJson(PPASSQLStatementParser.FormatJsonContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#jsonExistsCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonExistsCondition(PPASSQLStatementParser.JsonExistsConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#exprAsObjectExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAsObjectExpr(PPASSQLStatementParser.ExprAsObjectExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#jsonExistsOnErrorClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonExistsOnErrorClause(PPASSQLStatementParser.JsonExistsOnErrorClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#existsCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExistsCondition(PPASSQLStatementParser.ExistsConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#isOfTypeConditionItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsOfTypeConditionItem(PPASSQLStatementParser.IsOfTypeConditionItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#insertingCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsertingCondition(PPASSQLStatementParser.InsertingConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#updatingCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdatingCondition(PPASSQLStatementParser.UpdatingConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#deletingCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeletingCondition(PPASSQLStatementParser.DeletingConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(PPASSQLStatementParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#noArgumentFunctionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoArgumentFunctionName(PPASSQLStatementParser.NoArgumentFunctionNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#chrFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChrFunction(PPASSQLStatementParser.ChrFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#usingNCharCS}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUsingNCharCS(PPASSQLStatementParser.UsingNCharCSContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#translateUsingFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTranslateUsingFunction(PPASSQLStatementParser.TranslateUsingFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#trimFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrimFunction(PPASSQLStatementParser.TrimFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#extractFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtractFunction(PPASSQLStatementParser.ExtractFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#castFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCastFunction(PPASSQLStatementParser.CastFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#castFunctionArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCastFunctionArgument(PPASSQLStatementParser.CastFunctionArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#multisetExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultisetExpr(PPASSQLStatementParser.MultisetExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#treatFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTreatFunction(PPASSQLStatementParser.TreatFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#validateConversionFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValidateConversionFunction(PPASSQLStatementParser.ValidateConversionFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#dataMiningFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataMiningFunction(PPASSQLStatementParser.DataMiningFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#dataMiningFunctionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataMiningFunctionName(PPASSQLStatementParser.DataMiningFunctionNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#dataMiningFunctionArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataMiningFunctionArgument(PPASSQLStatementParser.DataMiningFunctionArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#costMatrixClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCostMatrixClause(PPASSQLStatementParser.CostMatrixClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#miningAttributeClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMiningAttributeClause(PPASSQLStatementParser.MiningAttributeClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#xmlCastFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlCastFunction(PPASSQLStatementParser.XmlCastFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#xmlColAttValFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlColAttValFunction(PPASSQLStatementParser.XmlColAttValFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#xmlElementFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlElementFunction(PPASSQLStatementParser.XmlElementFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#xmlExistsFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlExistsFunction(PPASSQLStatementParser.XmlExistsFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#xmlForestFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlForestFunction(PPASSQLStatementParser.XmlForestFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#xmlParseFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlParseFunction(PPASSQLStatementParser.XmlParseFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#xmlPiFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlPiFunction(PPASSQLStatementParser.XmlPiFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#xmlQueryFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlQueryFunction(PPASSQLStatementParser.XmlQueryFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#xmlRootFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlRootFunction(PPASSQLStatementParser.XmlRootFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#xmlSerializeFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlSerializeFunction(PPASSQLStatementParser.XmlSerializeFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#xmlTableFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlTableFunction(PPASSQLStatementParser.XmlTableFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#xmlRootFunctionVersionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlRootFunctionVersionExpr(PPASSQLStatementParser.XmlRootFunctionVersionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#xmlColAttValFunctionArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlColAttValFunctionArgument(PPASSQLStatementParser.XmlColAttValFunctionArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#xmlFunctionEvalNameArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlFunctionEvalNameArgument(PPASSQLStatementParser.XmlFunctionEvalNameArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#xmlAttributesClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlAttributesClause(PPASSQLStatementParser.XmlAttributesClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#exprOrExprAsAliasArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprOrExprAsAliasArgument(PPASSQLStatementParser.ExprOrExprAsAliasArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#xmlNamespacesClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlNamespacesClause(PPASSQLStatementParser.XmlNamespacesClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#xmlNamespacesClauseArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlNamespacesClauseArgument(PPASSQLStatementParser.XmlNamespacesClauseArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#xmlTableOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlTableOption(PPASSQLStatementParser.XmlTableOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#xmlPassingClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlPassingClause(PPASSQLStatementParser.XmlPassingClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#byValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitByValue(PPASSQLStatementParser.ByValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#returningSequenceByRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturningSequenceByRef(PPASSQLStatementParser.ReturningSequenceByRefContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#xmlTableColumn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlTableColumn(PPASSQLStatementParser.XmlTableColumnContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#sequenceByRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSequenceByRef(PPASSQLStatementParser.SequenceByRefContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#jsonFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonFunction(PPASSQLStatementParser.JsonFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#jsonFunctionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonFunctionName(PPASSQLStatementParser.JsonFunctionNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#jsonFunctionArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonFunctionArgument(PPASSQLStatementParser.JsonFunctionArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#jsonFormatJsonArgumentExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonFormatJsonArgumentExpr(PPASSQLStatementParser.JsonFormatJsonArgumentExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#jsonKeyValueArgumentExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonKeyValueArgumentExpr(PPASSQLStatementParser.JsonKeyValueArgumentExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#jsonOnNullClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonOnNullClause(PPASSQLStatementParser.JsonOnNullClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#jsonReturningClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonReturningClause(PPASSQLStatementParser.JsonReturningClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#withUniqueKeys}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithUniqueKeys(PPASSQLStatementParser.WithUniqueKeysContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#jsonWrapperClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonWrapperClause(PPASSQLStatementParser.JsonWrapperClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#jsonOnErrorClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonOnErrorClause(PPASSQLStatementParser.JsonOnErrorClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#jsonOnEmptyClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonOnEmptyClause(PPASSQLStatementParser.JsonOnEmptyClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#jsonColumnsClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonColumnsClause(PPASSQLStatementParser.JsonColumnsClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jsonExistsColumn}
	 * labeled alternative in {@link PPASSQLStatementParser#jsonColumnDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonExistsColumn(PPASSQLStatementParser.JsonExistsColumnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jsonQueryColumn}
	 * labeled alternative in {@link PPASSQLStatementParser#jsonColumnDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonQueryColumn(PPASSQLStatementParser.JsonQueryColumnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jsonValueColumn}
	 * labeled alternative in {@link PPASSQLStatementParser#jsonColumnDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonValueColumn(PPASSQLStatementParser.JsonValueColumnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jsonNestedPathColumn}
	 * labeled alternative in {@link PPASSQLStatementParser#jsonColumnDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonNestedPathColumn(PPASSQLStatementParser.JsonNestedPathColumnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jsonOrdinalityColumn}
	 * labeled alternative in {@link PPASSQLStatementParser#jsonColumnDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonOrdinalityColumn(PPASSQLStatementParser.JsonOrdinalityColumnContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#aggregateFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAggregateFunction(PPASSQLStatementParser.AggregateFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#aggregateFunctionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAggregateFunctionName(PPASSQLStatementParser.AggregateFunctionNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#withinGroupSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithinGroupSpecification(PPASSQLStatementParser.WithinGroupSpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#firstFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFirstFunction(PPASSQLStatementParser.FirstFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#lastFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLastFunction(PPASSQLStatementParser.LastFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#listAggFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListAggFunction(PPASSQLStatementParser.ListAggFunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code onOverflowErrorClause}
	 * labeled alternative in {@link PPASSQLStatementParser#listaggOverflowClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOnOverflowErrorClause(PPASSQLStatementParser.OnOverflowErrorClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code onOverflowTruncateClause}
	 * labeled alternative in {@link PPASSQLStatementParser#listaggOverflowClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOnOverflowTruncateClause(PPASSQLStatementParser.OnOverflowTruncateClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#windowFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWindowFunction(PPASSQLStatementParser.WindowFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#windowFunctionNullsOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWindowFunctionNullsOption(PPASSQLStatementParser.WindowFunctionNullsOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#windowFunctionFromOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWindowFunctionFromOption(PPASSQLStatementParser.WindowFunctionFromOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#overClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOverClause(PPASSQLStatementParser.OverClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#analyticClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnalyticClause(PPASSQLStatementParser.AnalyticClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#partitionByClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionByClause(PPASSQLStatementParser.PartitionByClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#windowFrameClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWindowFrameClause(PPASSQLStatementParser.WindowFrameClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#windowFrameUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWindowFrameUnit(PPASSQLStatementParser.WindowFrameUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#windowFrameExtent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWindowFrameExtent(PPASSQLStatementParser.WindowFrameExtentContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#windowFrameExtentItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWindowFrameExtentItem(PPASSQLStatementParser.WindowFrameExtentItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#cubeTableFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCubeTableFunction(PPASSQLStatementParser.CubeTableFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#cubeTableOptionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCubeTableOptionExpr(PPASSQLStatementParser.CubeTableOptionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#allocateExtentClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAllocateExtentClause(PPASSQLStatementParser.AllocateExtentClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#allocateExtentItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAllocateExtentItem(PPASSQLStatementParser.AllocateExtentItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#constraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstraint(PPASSQLStatementParser.ConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nullColumnConstraint}
	 * labeled alternative in {@link PPASSQLStatementParser#columnConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullColumnConstraint(PPASSQLStatementParser.NullColumnConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notNullColumnConstraint}
	 * labeled alternative in {@link PPASSQLStatementParser#columnConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotNullColumnConstraint(PPASSQLStatementParser.NotNullColumnConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code uniqueColumnConstraint}
	 * labeled alternative in {@link PPASSQLStatementParser#columnConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUniqueColumnConstraint(PPASSQLStatementParser.UniqueColumnConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryKeyColumnConstraint}
	 * labeled alternative in {@link PPASSQLStatementParser#columnConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryKeyColumnConstraint(PPASSQLStatementParser.PrimaryKeyColumnConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code referencesColumnConstraint}
	 * labeled alternative in {@link PPASSQLStatementParser#columnConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReferencesColumnConstraint(PPASSQLStatementParser.ReferencesColumnConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code checkColumnConstraint}
	 * labeled alternative in {@link PPASSQLStatementParser#columnConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCheckColumnConstraint(PPASSQLStatementParser.CheckColumnConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code scopeIsColumnConstraint}
	 * labeled alternative in {@link PPASSQLStatementParser#columnConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScopeIsColumnConstraint(PPASSQLStatementParser.ScopeIsColumnConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code withRowIdColumnConstraint}
	 * labeled alternative in {@link PPASSQLStatementParser#columnConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithRowIdColumnConstraint(PPASSQLStatementParser.WithRowIdColumnConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code uniqueTableConstraint}
	 * labeled alternative in {@link PPASSQLStatementParser#tableConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUniqueTableConstraint(PPASSQLStatementParser.UniqueTableConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryKeyTableConstraint}
	 * labeled alternative in {@link PPASSQLStatementParser#tableConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryKeyTableConstraint(PPASSQLStatementParser.PrimaryKeyTableConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code foreignKeyTableConstraint}
	 * labeled alternative in {@link PPASSQLStatementParser#tableConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForeignKeyTableConstraint(PPASSQLStatementParser.ForeignKeyTableConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code checkTableConstraint}
	 * labeled alternative in {@link PPASSQLStatementParser#tableConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCheckTableConstraint(PPASSQLStatementParser.CheckTableConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code scopeForTableConstraint}
	 * labeled alternative in {@link PPASSQLStatementParser#tableConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScopeForTableConstraint(PPASSQLStatementParser.ScopeForTableConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code refWithRowIdTableConstraint}
	 * labeled alternative in {@link PPASSQLStatementParser#tableConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRefWithRowIdTableConstraint(PPASSQLStatementParser.RefWithRowIdTableConstraintContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#iConstraintState}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIConstraintState(PPASSQLStatementParser.IConstraintStateContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#deferrableConstraintState}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeferrableConstraintState(PPASSQLStatementParser.DeferrableConstraintStateContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#notDeferrableConstraintState}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotDeferrableConstraintState(PPASSQLStatementParser.NotDeferrableConstraintStateContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#initiallyImmediateConstraintState}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitiallyImmediateConstraintState(PPASSQLStatementParser.InitiallyImmediateConstraintStateContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#initiallyDeferredConstraintState}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitiallyDeferredConstraintState(PPASSQLStatementParser.InitiallyDeferredConstraintStateContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#relyConstraintState}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelyConstraintState(PPASSQLStatementParser.RelyConstraintStateContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#noRelyConstraintState}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoRelyConstraintState(PPASSQLStatementParser.NoRelyConstraintStateContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#enableConstraintState}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnableConstraintState(PPASSQLStatementParser.EnableConstraintStateContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#disableConstraintState}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDisableConstraintState(PPASSQLStatementParser.DisableConstraintStateContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#validateConstraintState}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValidateConstraintState(PPASSQLStatementParser.ValidateConstraintStateContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#novalidateConstraintState}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNovalidateConstraintState(PPASSQLStatementParser.NovalidateConstraintStateContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#exceptionsClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExceptionsClause(PPASSQLStatementParser.ExceptionsClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#deallocateUnusedClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeallocateUnusedClause(PPASSQLStatementParser.DeallocateUnusedClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#fileSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFileSpecification(PPASSQLStatementParser.FileSpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#dataFileTempFileSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataFileTempFileSpec(PPASSQLStatementParser.DataFileTempFileSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#redoLogFileSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRedoLogFileSpec(PPASSQLStatementParser.RedoLogFileSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#autoExtendClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAutoExtendClause(PPASSQLStatementParser.AutoExtendClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#maxSizeClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMaxSizeClause(PPASSQLStatementParser.MaxSizeClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#loggingClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoggingClause(PPASSQLStatementParser.LoggingClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#parallelClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParallelClause(PPASSQLStatementParser.ParallelClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#physicalAttributesClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPhysicalAttributesClause(PPASSQLStatementParser.PhysicalAttributesClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#usageQueueClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUsageQueueClause(PPASSQLStatementParser.UsageQueueClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#pctfreeClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPctfreeClause(PPASSQLStatementParser.PctfreeClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#pctusedClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPctusedClause(PPASSQLStatementParser.PctusedClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#initransClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitransClause(PPASSQLStatementParser.InitransClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#maxtransClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMaxtransClause(PPASSQLStatementParser.MaxtransClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#sizeClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSizeClause(PPASSQLStatementParser.SizeClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#sizeType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSizeType(PPASSQLStatementParser.SizeTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#storageClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStorageClause(PPASSQLStatementParser.StorageClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code storageClauseInitialItem}
	 * labeled alternative in {@link PPASSQLStatementParser#storageClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStorageClauseInitialItem(PPASSQLStatementParser.StorageClauseInitialItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code storageClauseNextItem}
	 * labeled alternative in {@link PPASSQLStatementParser#storageClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStorageClauseNextItem(PPASSQLStatementParser.StorageClauseNextItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code storageClauseMinextentsItem}
	 * labeled alternative in {@link PPASSQLStatementParser#storageClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStorageClauseMinextentsItem(PPASSQLStatementParser.StorageClauseMinextentsItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code storageClauseMaxextentsItem}
	 * labeled alternative in {@link PPASSQLStatementParser#storageClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStorageClauseMaxextentsItem(PPASSQLStatementParser.StorageClauseMaxextentsItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code storageClauseMaxsizeItem}
	 * labeled alternative in {@link PPASSQLStatementParser#storageClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStorageClauseMaxsizeItem(PPASSQLStatementParser.StorageClauseMaxsizeItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code storageClausePctincreaseItem}
	 * labeled alternative in {@link PPASSQLStatementParser#storageClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStorageClausePctincreaseItem(PPASSQLStatementParser.StorageClausePctincreaseItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code storageClauseFreelistsItem}
	 * labeled alternative in {@link PPASSQLStatementParser#storageClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStorageClauseFreelistsItem(PPASSQLStatementParser.StorageClauseFreelistsItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code storageClauseFreelistGroupsItem}
	 * labeled alternative in {@link PPASSQLStatementParser#storageClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStorageClauseFreelistGroupsItem(PPASSQLStatementParser.StorageClauseFreelistGroupsItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code storageClauseOptimalItem}
	 * labeled alternative in {@link PPASSQLStatementParser#storageClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStorageClauseOptimalItem(PPASSQLStatementParser.StorageClauseOptimalItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code storageClauseBufferPoolItem}
	 * labeled alternative in {@link PPASSQLStatementParser#storageClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStorageClauseBufferPoolItem(PPASSQLStatementParser.StorageClauseBufferPoolItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code storageClauseFlashCacheItem}
	 * labeled alternative in {@link PPASSQLStatementParser#storageClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStorageClauseFlashCacheItem(PPASSQLStatementParser.StorageClauseFlashCacheItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code storageClauseCellFlashCacheItem}
	 * labeled alternative in {@link PPASSQLStatementParser#storageClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStorageClauseCellFlashCacheItem(PPASSQLStatementParser.StorageClauseCellFlashCacheItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code storageClauseEncryptItem}
	 * labeled alternative in {@link PPASSQLStatementParser#storageClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStorageClauseEncryptItem(PPASSQLStatementParser.StorageClauseEncryptItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code physicalPropertySegmentAttributesClause}
	 * labeled alternative in {@link PPASSQLStatementParser#physicalProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPhysicalPropertySegmentAttributesClause(PPASSQLStatementParser.PhysicalPropertySegmentAttributesClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code physicalPropertyOrganizationHeapClause}
	 * labeled alternative in {@link PPASSQLStatementParser#physicalProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPhysicalPropertyOrganizationHeapClause(PPASSQLStatementParser.PhysicalPropertyOrganizationHeapClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code physicalPropertyOrganizationIndexClause}
	 * labeled alternative in {@link PPASSQLStatementParser#physicalProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPhysicalPropertyOrganizationIndexClause(PPASSQLStatementParser.PhysicalPropertyOrganizationIndexClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code physicalPropertyOrganizationExternalClause}
	 * labeled alternative in {@link PPASSQLStatementParser#physicalProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPhysicalPropertyOrganizationExternalClause(PPASSQLStatementParser.PhysicalPropertyOrganizationExternalClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code physicalPropertyClusterClause}
	 * labeled alternative in {@link PPASSQLStatementParser#physicalProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPhysicalPropertyClusterClause(PPASSQLStatementParser.PhysicalPropertyClusterClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#externalTableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExternalTableClause(PPASSQLStatementParser.ExternalTableClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#externalTableDataProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExternalTableDataProperty(PPASSQLStatementParser.ExternalTableDataPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#accessParametersClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccessParametersClause(PPASSQLStatementParser.AccessParametersClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#accessParametersItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccessParametersItem(PPASSQLStatementParser.AccessParametersItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#readOnlyClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadOnlyClause(PPASSQLStatementParser.ReadOnlyClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#indexingClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexingClause(PPASSQLStatementParser.IndexingClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#deferredSegmentCreation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeferredSegmentCreation(PPASSQLStatementParser.DeferredSegmentCreationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#segmentAttributesClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSegmentAttributesClause(PPASSQLStatementParser.SegmentAttributesClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#tableSpaceClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableSpaceClause(PPASSQLStatementParser.TableSpaceClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#tableSpaceSetClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableSpaceSetClause(PPASSQLStatementParser.TableSpaceSetClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tableCompressionByCompress}
	 * labeled alternative in {@link PPASSQLStatementParser#tableCompression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableCompressionByCompress(PPASSQLStatementParser.TableCompressionByCompressContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tableCompressionByRowStoreCompress}
	 * labeled alternative in {@link PPASSQLStatementParser#tableCompression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableCompressionByRowStoreCompress(PPASSQLStatementParser.TableCompressionByRowStoreCompressContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tableCompressionByColumnStoreCompress}
	 * labeled alternative in {@link PPASSQLStatementParser#tableCompression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableCompressionByColumnStoreCompress(PPASSQLStatementParser.TableCompressionByColumnStoreCompressContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tableCompressionByNoCompress}
	 * labeled alternative in {@link PPASSQLStatementParser#tableCompression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableCompressionByNoCompress(PPASSQLStatementParser.TableCompressionByNoCompressContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#inMemoryTableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInMemoryTableClause(PPASSQLStatementParser.InMemoryTableClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#inMemoryAttributes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInMemoryAttributes(PPASSQLStatementParser.InMemoryAttributesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inMemoryMemCompressClause}
	 * labeled alternative in {@link PPASSQLStatementParser#iInMemoryMemcompress}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInMemoryMemCompressClause(PPASSQLStatementParser.InMemoryMemCompressClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inMemoryNoMemCompressClause}
	 * labeled alternative in {@link PPASSQLStatementParser#iInMemoryMemcompress}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInMemoryNoMemCompressClause(PPASSQLStatementParser.InMemoryNoMemCompressClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#inMemoryPriority}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInMemoryPriority(PPASSQLStatementParser.InMemoryPriorityContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#inMemoryDistribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInMemoryDistribute(PPASSQLStatementParser.InMemoryDistributeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inMemoryDuplicate}
	 * labeled alternative in {@link PPASSQLStatementParser#iInMemoryDuplicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInMemoryDuplicate(PPASSQLStatementParser.InMemoryDuplicateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inMemoryDuplicateAll}
	 * labeled alternative in {@link PPASSQLStatementParser#iInMemoryDuplicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInMemoryDuplicateAll(PPASSQLStatementParser.InMemoryDuplicateAllContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inMemoryNoDuplicate}
	 * labeled alternative in {@link PPASSQLStatementParser#iInMemoryDuplicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInMemoryNoDuplicate(PPASSQLStatementParser.InMemoryNoDuplicateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inMemoryColumnClause}
	 * labeled alternative in {@link PPASSQLStatementParser#iInMemoryColumnClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInMemoryColumnClause(PPASSQLStatementParser.InMemoryColumnClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code noInMemoryColumnClause}
	 * labeled alternative in {@link PPASSQLStatementParser#iInMemoryColumnClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoInMemoryColumnClause(PPASSQLStatementParser.NoInMemoryColumnClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ilmClauseAddPolicy}
	 * labeled alternative in {@link PPASSQLStatementParser#ilmClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIlmClauseAddPolicy(PPASSQLStatementParser.IlmClauseAddPolicyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ilmClauseDeleteAll}
	 * labeled alternative in {@link PPASSQLStatementParser#ilmClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIlmClauseDeleteAll(PPASSQLStatementParser.IlmClauseDeleteAllContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ilmClauseEnableAll}
	 * labeled alternative in {@link PPASSQLStatementParser#ilmClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIlmClauseEnableAll(PPASSQLStatementParser.IlmClauseEnableAllContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ilmClauseDisableAll}
	 * labeled alternative in {@link PPASSQLStatementParser#ilmClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIlmClauseDisableAll(PPASSQLStatementParser.IlmClauseDisableAllContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#ilmPolicyClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIlmPolicyClause(PPASSQLStatementParser.IlmPolicyClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#ilmCompressionPolicy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIlmCompressionPolicy(PPASSQLStatementParser.IlmCompressionPolicyContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#ilmTieringPolicy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIlmTieringPolicy(PPASSQLStatementParser.IlmTieringPolicyContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#ilmInMemoryPolicy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIlmInMemoryPolicy(PPASSQLStatementParser.IlmInMemoryPolicyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ilmInMemoryPolicyBySetInMemory}
	 * labeled alternative in {@link PPASSQLStatementParser#ilmInMemoryPolicyAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIlmInMemoryPolicyBySetInMemory(PPASSQLStatementParser.IlmInMemoryPolicyBySetInMemoryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ilmInMemoryPolicyByModifyInMemory}
	 * labeled alternative in {@link PPASSQLStatementParser#ilmInMemoryPolicyAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIlmInMemoryPolicyByModifyInMemory(PPASSQLStatementParser.IlmInMemoryPolicyByModifyInMemoryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ilmInMemoryPolicyByNoInMemory}
	 * labeled alternative in {@link PPASSQLStatementParser#ilmInMemoryPolicyAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIlmInMemoryPolicyByNoInMemory(PPASSQLStatementParser.IlmInMemoryPolicyByNoInMemoryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ilmAfterOfClause}
	 * labeled alternative in {@link PPASSQLStatementParser#ilmPolicyOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIlmAfterOfClause(PPASSQLStatementParser.IlmAfterOfClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ilmOnClause}
	 * labeled alternative in {@link PPASSQLStatementParser#ilmPolicyOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIlmOnClause(PPASSQLStatementParser.IlmOnClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#ilmTimePeriod}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIlmTimePeriod(PPASSQLStatementParser.IlmTimePeriodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code substitutableColumnIsOfClause}
	 * labeled alternative in {@link PPASSQLStatementParser#substitutableColumnClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubstitutableColumnIsOfClause(PPASSQLStatementParser.SubstitutableColumnIsOfClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code substitutableColumnAtAllLevelsClause}
	 * labeled alternative in {@link PPASSQLStatementParser#substitutableColumnClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubstitutableColumnAtAllLevelsClause(PPASSQLStatementParser.SubstitutableColumnAtAllLevelsClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#nestedTableColProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNestedTableColProperty(PPASSQLStatementParser.NestedTableColPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#nestedTableColPropertyStoreAsItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNestedTableColPropertyStoreAsItem(PPASSQLStatementParser.NestedTableColPropertyStoreAsItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#varrayColProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarrayColProperty(PPASSQLStatementParser.VarrayColPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#varrayStorageClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarrayStorageClause(PPASSQLStatementParser.VarrayStorageClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#lobStorageClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobStorageClause(PPASSQLStatementParser.LobStorageClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#lobStorageClauseStoreAsItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobStorageClauseStoreAsItem(PPASSQLStatementParser.LobStorageClauseStoreAsItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#lobStorageParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobStorageParameters(PPASSQLStatementParser.LobStorageParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#lobStorageParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobStorageParameter(PPASSQLStatementParser.LobStorageParameterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lobParameterEnable}
	 * labeled alternative in {@link PPASSQLStatementParser#lobParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobParameterEnable(PPASSQLStatementParser.LobParameterEnableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lobParameterDisable}
	 * labeled alternative in {@link PPASSQLStatementParser#lobParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobParameterDisable(PPASSQLStatementParser.LobParameterDisableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lobParameterChunk}
	 * labeled alternative in {@link PPASSQLStatementParser#lobParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobParameterChunk(PPASSQLStatementParser.LobParameterChunkContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lobParameterPctversion}
	 * labeled alternative in {@link PPASSQLStatementParser#lobParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobParameterPctversion(PPASSQLStatementParser.LobParameterPctversionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lobParameterFreepools}
	 * labeled alternative in {@link PPASSQLStatementParser#lobParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobParameterFreepools(PPASSQLStatementParser.LobParameterFreepoolsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lobRetentionClause}
	 * labeled alternative in {@link PPASSQLStatementParser#lobParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobRetentionClause(PPASSQLStatementParser.LobRetentionClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lobDeduplicate}
	 * labeled alternative in {@link PPASSQLStatementParser#lobParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobDeduplicate(PPASSQLStatementParser.LobDeduplicateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lobKeepDuplicates}
	 * labeled alternative in {@link PPASSQLStatementParser#lobParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobKeepDuplicates(PPASSQLStatementParser.LobKeepDuplicatesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lobCompressionClause}
	 * labeled alternative in {@link PPASSQLStatementParser#lobParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobCompressionClause(PPASSQLStatementParser.LobCompressionClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lobNoCompressionClause}
	 * labeled alternative in {@link PPASSQLStatementParser#lobParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobNoCompressionClause(PPASSQLStatementParser.LobNoCompressionClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lobParameterEncrypt}
	 * labeled alternative in {@link PPASSQLStatementParser#lobParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobParameterEncrypt(PPASSQLStatementParser.LobParameterEncryptContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lobParameterDecrypt}
	 * labeled alternative in {@link PPASSQLStatementParser#lobParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobParameterDecrypt(PPASSQLStatementParser.LobParameterDecryptContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lobParameterCache}
	 * labeled alternative in {@link PPASSQLStatementParser#lobParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobParameterCache(PPASSQLStatementParser.LobParameterCacheContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lobParameterNoCache}
	 * labeled alternative in {@link PPASSQLStatementParser#lobParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobParameterNoCache(PPASSQLStatementParser.LobParameterNoCacheContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lobParameterCacheReads}
	 * labeled alternative in {@link PPASSQLStatementParser#lobParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobParameterCacheReads(PPASSQLStatementParser.LobParameterCacheReadsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lobParameterRebuildFreepools}
	 * labeled alternative in {@link PPASSQLStatementParser#lobParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobParameterRebuildFreepools(PPASSQLStatementParser.LobParameterRebuildFreepoolsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#lobPartitionStorage}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobPartitionStorage(PPASSQLStatementParser.LobPartitionStorageContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#lobPartitionStoragePartitionItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobPartitionStoragePartitionItem(PPASSQLStatementParser.LobPartitionStoragePartitionItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#lobPartitionStorageSubpartitionItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobPartitionStorageSubpartitionItem(PPASSQLStatementParser.LobPartitionStorageSubpartitionItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#lobPartitioningStorage}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobPartitioningStorage(PPASSQLStatementParser.LobPartitioningStorageContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#xmlTypeColumnProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlTypeColumnProperty(PPASSQLStatementParser.XmlTypeColumnPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#xmlTypeStorage}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlTypeStorage(PPASSQLStatementParser.XmlTypeStorageContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#xmlSchemaSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlSchemaSpec(PPASSQLStatementParser.XmlSchemaSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#xmlTypeVirtualColumns}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlTypeVirtualColumns(PPASSQLStatementParser.XmlTypeVirtualColumnsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#xmlTypeVirtualColumnsItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlTypeVirtualColumnsItem(PPASSQLStatementParser.XmlTypeVirtualColumnsItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code flashbackArchiveClause}
	 * labeled alternative in {@link PPASSQLStatementParser#iFlashbackArchiveClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlashbackArchiveClause(PPASSQLStatementParser.FlashbackArchiveClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code noFlashbackArchiveClause}
	 * labeled alternative in {@link PPASSQLStatementParser#iFlashbackArchiveClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoFlashbackArchiveClause(PPASSQLStatementParser.NoFlashbackArchiveClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#storeInClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStoreInClause(PPASSQLStatementParser.StoreInClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#overflowStoreInClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOverflowStoreInClause(PPASSQLStatementParser.OverflowStoreInClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#subPartitionsetStoreInClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubPartitionsetStoreInClause(PPASSQLStatementParser.SubPartitionsetStoreInClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#tablePartitioningClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTablePartitioningClause(PPASSQLStatementParser.TablePartitioningClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#iPartitionBy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIPartitionBy(PPASSQLStatementParser.IPartitionByContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#partitionByRange}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionByRange(PPASSQLStatementParser.PartitionByRangeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#partitionByHash}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionByHash(PPASSQLStatementParser.PartitionByHashContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#partitionByList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionByList(PPASSQLStatementParser.PartitionByListContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#partitionByReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionByReference(PPASSQLStatementParser.PartitionByReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#partitionBySystem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionBySystem(PPASSQLStatementParser.PartitionBySystemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#partitionByConsistentHash}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionByConsistentHash(PPASSQLStatementParser.PartitionByConsistentHashContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#partitionDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionDefinition(PPASSQLStatementParser.PartitionDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#partitionDefinitionOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionDefinitionOption(PPASSQLStatementParser.PartitionDefinitionOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#ipartitionsetBy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIpartitionsetBy(PPASSQLStatementParser.IpartitionsetByContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#partitionsetByRange}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionsetByRange(PPASSQLStatementParser.PartitionsetByRangeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#partitionsetByList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionsetByList(PPASSQLStatementParser.PartitionsetByListContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#partitionsetDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionsetDefinition(PPASSQLStatementParser.PartitionsetDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#partitionsetDefinitionOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionsetDefinitionOption(PPASSQLStatementParser.PartitionsetDefinitionOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#directoryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDirectoryExpr(PPASSQLStatementParser.DirectoryExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#iCompression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitICompression(PPASSQLStatementParser.ICompressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code partitionValuesLessThan}
	 * labeled alternative in {@link PPASSQLStatementParser#iPartitionValues}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionValuesLessThan(PPASSQLStatementParser.PartitionValuesLessThanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code partitionValues}
	 * labeled alternative in {@link PPASSQLStatementParser#iPartitionValues}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionValues(PPASSQLStatementParser.PartitionValuesContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#iSubPartitionBy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitISubPartitionBy(PPASSQLStatementParser.ISubPartitionByContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#subpartitionTemplate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubpartitionTemplate(PPASSQLStatementParser.SubpartitionTemplateContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#subpartitionByRange}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubpartitionByRange(PPASSQLStatementParser.SubpartitionByRangeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#subpartitionByList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubpartitionByList(PPASSQLStatementParser.SubpartitionByListContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#subpartitionByHash}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubpartitionByHash(PPASSQLStatementParser.SubpartitionByHashContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#subPartitionDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubPartitionDefinition(PPASSQLStatementParser.SubPartitionDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#subPartitionDefinitionOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubPartitionDefinitionOption(PPASSQLStatementParser.SubPartitionDefinitionOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#partitioningStorageClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitioningStorageClause(PPASSQLStatementParser.PartitioningStorageClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#overflowClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOverflowClause(PPASSQLStatementParser.OverflowClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#overflowClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOverflowClauseItem(PPASSQLStatementParser.OverflowClauseItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#varrayStorageAsClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarrayStorageAsClause(PPASSQLStatementParser.VarrayStorageAsClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inMemoryClause}
	 * labeled alternative in {@link PPASSQLStatementParser#iInMemoryClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInMemoryClause(PPASSQLStatementParser.InMemoryClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code noInMemoryClause}
	 * labeled alternative in {@link PPASSQLStatementParser#iInMemoryClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoInMemoryClause(PPASSQLStatementParser.NoInMemoryClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#accessibleByClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccessibleByClause(PPASSQLStatementParser.AccessibleByClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#accessor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccessor(PPASSQLStatementParser.AccessorContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#unitKind}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnitKind(PPASSQLStatementParser.UnitKindContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#aggregateClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAggregateClause(PPASSQLStatementParser.AggregateClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#assignmentStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentStatement(PPASSQLStatementParser.AssignmentStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#autonomousTransPragma}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAutonomousTransPragma(PPASSQLStatementParser.AutonomousTransPragmaContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#basicLoopStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicLoopStatement(PPASSQLStatementParser.BasicLoopStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#plsqlBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlsqlBlock(PPASSQLStatementParser.PlsqlBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#declareSection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclareSection(PPASSQLStatementParser.DeclareSectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#declareSectionItem1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclareSectionItem1(PPASSQLStatementParser.DeclareSectionItem1Context ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#declareSectionItem2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclareSectionItem2(PPASSQLStatementParser.DeclareSectionItem2Context ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#typeDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDefinition(PPASSQLStatementParser.TypeDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#subTypeDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubTypeDefinition(PPASSQLStatementParser.SubTypeDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#subTypeDefinitionConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubTypeDefinitionConstraint(PPASSQLStatementParser.SubTypeDefinitionConstraintContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#rangeExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRangeExpr(PPASSQLStatementParser.RangeExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#itemDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitItemDeclaration(PPASSQLStatementParser.ItemDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(PPASSQLStatementParser.BodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#bodyItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBodyItem(PPASSQLStatementParser.BodyItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#labelDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabelDeclaration(PPASSQLStatementParser.LabelDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#bodyItemStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBodyItemStatement(PPASSQLStatementParser.BodyItemStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#procedureCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedureCall(PPASSQLStatementParser.ProcedureCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code javaDeclaration}
	 * labeled alternative in {@link PPASSQLStatementParser#callSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJavaDeclaration(PPASSQLStatementParser.JavaDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cDeclaration}
	 * labeled alternative in {@link PPASSQLStatementParser#callSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCDeclaration(PPASSQLStatementParser.CDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code languageCName}
	 * labeled alternative in {@link PPASSQLStatementParser#cDeclarationName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLanguageCName(PPASSQLStatementParser.LanguageCNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code languageClibraryName}
	 * labeled alternative in {@link PPASSQLStatementParser#cDeclarationName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLanguageClibraryName(PPASSQLStatementParser.LanguageClibraryNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#withContext}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithContext(PPASSQLStatementParser.WithContextContext ctx);
	/**
	 * Visit a parse tree produced by the {@code contextExternalParameter}
	 * labeled alternative in {@link PPASSQLStatementParser#externalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContextExternalParameter(PPASSQLStatementParser.ContextExternalParameterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code selfExternalParameter}
	 * labeled alternative in {@link PPASSQLStatementParser#externalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelfExternalParameter(PPASSQLStatementParser.SelfExternalParameterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code returnExternalParameter}
	 * labeled alternative in {@link PPASSQLStatementParser#externalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnExternalParameter(PPASSQLStatementParser.ReturnExternalParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#externalParameterProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExternalParameterProperty(PPASSQLStatementParser.ExternalParameterPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#byReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitByReference(PPASSQLStatementParser.ByReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#caseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseStatement(PPASSQLStatementParser.CaseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#caseStatementWhenItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseStatementWhenItem(PPASSQLStatementParser.CaseStatementWhenItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#caseStatementElseClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseStatementElseClause(PPASSQLStatementParser.CaseStatementElseClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#closeStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCloseStatement(PPASSQLStatementParser.CloseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#collectionMethodCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCollectionMethodCall(PPASSQLStatementParser.CollectionMethodCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#collectionMethod}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCollectionMethod(PPASSQLStatementParser.CollectionMethodContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#collectionTypeDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCollectionTypeDefinition(PPASSQLStatementParser.CollectionTypeDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#compileClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompileClause(PPASSQLStatementParser.CompileClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#constantDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantDeclaration(PPASSQLStatementParser.ConstantDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#continueStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueStatement(PPASSQLStatementParser.ContinueStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#coveragePragma}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCoveragePragma(PPASSQLStatementParser.CoveragePragmaContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#refCursorTypeDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRefCursorTypeDefinition(PPASSQLStatementParser.RefCursorTypeDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#collationExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCollationExpr(PPASSQLStatementParser.CollationExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#collateExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCollateExpr(PPASSQLStatementParser.CollateExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#deprecatePragma}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeprecatePragma(PPASSQLStatementParser.DeprecatePragmaContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#deterministicClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeterministicClause(PPASSQLStatementParser.DeterministicClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#elementSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementSpec(PPASSQLStatementParser.ElementSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#elementSpecItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementSpecItem(PPASSQLStatementParser.ElementSpecItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#inheritanceClauses}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInheritanceClauses(PPASSQLStatementParser.InheritanceClausesContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#subProgramDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubProgramDeclaration(PPASSQLStatementParser.SubProgramDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#subProgramExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubProgramExpr(PPASSQLStatementParser.SubProgramExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#constructorDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorDeclaration(PPASSQLStatementParser.ConstructorDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#constructorDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorDefinition(PPASSQLStatementParser.ConstructorDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#mapOrderFunctionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMapOrderFunctionDeclaration(PPASSQLStatementParser.MapOrderFunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#mapOrderFunctionDeclarationItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMapOrderFunctionDeclarationItem(PPASSQLStatementParser.MapOrderFunctionDeclarationItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code externalNameClause}
	 * labeled alternative in {@link PPASSQLStatementParser#iExternalNameClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExternalNameClause(PPASSQLStatementParser.ExternalNameClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code externalVariableNameClause}
	 * labeled alternative in {@link PPASSQLStatementParser#iExternalNameClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExternalVariableNameClause(PPASSQLStatementParser.ExternalVariableNameClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#exceptionInitPragma}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExceptionInitPragma(PPASSQLStatementParser.ExceptionInitPragmaContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#exceptionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExceptionDeclaration(PPASSQLStatementParser.ExceptionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#exceptionHandler}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExceptionHandler(PPASSQLStatementParser.ExceptionHandlerContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#executeImmediateStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExecuteImmediateStatement(PPASSQLStatementParser.ExecuteImmediateStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#exitStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExitStatement(PPASSQLStatementParser.ExitStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#cursorDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCursorDeclaration(PPASSQLStatementParser.CursorDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#cursorDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCursorDefinition(PPASSQLStatementParser.CursorDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#fetchStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFetchStatement(PPASSQLStatementParser.FetchStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#forLoopStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForLoopStatement(PPASSQLStatementParser.ForLoopStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#forLoopStatementCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForLoopStatementCondition(PPASSQLStatementParser.ForLoopStatementConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#forallStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForallStatement(PPASSQLStatementParser.ForallStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boundsClause}
	 * labeled alternative in {@link PPASSQLStatementParser#iBoundsClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoundsClause(PPASSQLStatementParser.BoundsClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boundsClauseByIndicesOf}
	 * labeled alternative in {@link PPASSQLStatementParser#iBoundsClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoundsClauseByIndicesOf(PPASSQLStatementParser.BoundsClauseByIndicesOfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boundsClauseByValuesOf}
	 * labeled alternative in {@link PPASSQLStatementParser#iBoundsClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoundsClauseByValuesOf(PPASSQLStatementParser.BoundsClauseByValuesOfContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#parameterDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterDeclaration(PPASSQLStatementParser.ParameterDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#parameterModel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterModel(PPASSQLStatementParser.ParameterModelContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#functionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(PPASSQLStatementParser.FunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#functionDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDefinition(PPASSQLStatementParser.FunctionDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#functionProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionProperty(PPASSQLStatementParser.FunctionPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#functionHeading}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionHeading(PPASSQLStatementParser.FunctionHeadingContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#gotoStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGotoStatement(PPASSQLStatementParser.GotoStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(PPASSQLStatementParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#ifStatementElsIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatementElsIf(PPASSQLStatementParser.IfStatementElsIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#inlinePragma}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInlinePragma(PPASSQLStatementParser.InlinePragmaContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#invokerRightsClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInvokerRightsClause(PPASSQLStatementParser.InvokerRightsClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#nullStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullStatement(PPASSQLStatementParser.NullStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#openStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpenStatement(PPASSQLStatementParser.OpenStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#openForStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpenForStatement(PPASSQLStatementParser.OpenForStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parallelEnableClause}
	 * labeled alternative in {@link PPASSQLStatementParser#iParallelEnableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParallelEnableClause(PPASSQLStatementParser.ParallelEnableClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parallelEnableByAnyClause}
	 * labeled alternative in {@link PPASSQLStatementParser#iParallelEnableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParallelEnableByAnyClause(PPASSQLStatementParser.ParallelEnableByAnyClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parallelEnableByHashClause}
	 * labeled alternative in {@link PPASSQLStatementParser#iParallelEnableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParallelEnableByHashClause(PPASSQLStatementParser.ParallelEnableByHashClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parallelEnableByRangeClause}
	 * labeled alternative in {@link PPASSQLStatementParser#iParallelEnableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParallelEnableByRangeClause(PPASSQLStatementParser.ParallelEnableByRangeClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parallelEnableByValueClause}
	 * labeled alternative in {@link PPASSQLStatementParser#iParallelEnableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParallelEnableByValueClause(PPASSQLStatementParser.ParallelEnableByValueClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#streamingClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStreamingClause(PPASSQLStatementParser.StreamingClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#pipeRowStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPipeRowStatement(PPASSQLStatementParser.PipeRowStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pipelinedClause}
	 * labeled alternative in {@link PPASSQLStatementParser#iPipelinedClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPipelinedClause(PPASSQLStatementParser.PipelinedClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pipelinedByUsingClause}
	 * labeled alternative in {@link PPASSQLStatementParser#iPipelinedClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPipelinedByUsingClause(PPASSQLStatementParser.PipelinedByUsingClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pipelinedByRowClause}
	 * labeled alternative in {@link PPASSQLStatementParser#iPipelinedClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPipelinedByRowClause(PPASSQLStatementParser.PipelinedByRowClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pipelinedByTableClause}
	 * labeled alternative in {@link PPASSQLStatementParser#iPipelinedClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPipelinedByTableClause(PPASSQLStatementParser.PipelinedByTableClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#procedureDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedureDeclaration(PPASSQLStatementParser.ProcedureDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#procedureDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedureDefinition(PPASSQLStatementParser.ProcedureDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#procedureHeading}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedureHeading(PPASSQLStatementParser.ProcedureHeadingContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#procedureProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedureProperty(PPASSQLStatementParser.ProcedurePropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#raiseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRaiseStatement(PPASSQLStatementParser.RaiseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#recordTypeDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordTypeDefinition(PPASSQLStatementParser.RecordTypeDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#restrictReferencesPragma}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRestrictReferencesPragma(PPASSQLStatementParser.RestrictReferencesPragmaContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(PPASSQLStatementParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#returningIntoClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturningIntoClause(PPASSQLStatementParser.ReturningIntoClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#resultCacheClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResultCacheClause(PPASSQLStatementParser.ResultCacheClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(PPASSQLStatementParser.VariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#selectIntoStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectIntoStatement(PPASSQLStatementParser.SelectIntoStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#selectTargetItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectTargetItem(PPASSQLStatementParser.SelectTargetItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#seriallyReusablePragma}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSeriallyReusablePragma(PPASSQLStatementParser.SeriallyReusablePragmaContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#sharingClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSharingClause(PPASSQLStatementParser.SharingClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#udfPragma}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUdfPragma(PPASSQLStatementParser.UdfPragmaContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#whileLoopStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileLoopStatement(PPASSQLStatementParser.WhileLoopStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#orReplace}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrReplace(PPASSQLStatementParser.OrReplaceContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#notNull}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotNull(PPASSQLStatementParser.NotNullContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#bulkCollect}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBulkCollect(PPASSQLStatementParser.BulkCollectContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#errorLoggingClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitErrorLoggingClause(PPASSQLStatementParser.ErrorLoggingClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#saveExceptions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSaveExceptions(PPASSQLStatementParser.SaveExceptionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#editionableType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEditionableType(PPASSQLStatementParser.EditionableTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#asType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsType(PPASSQLStatementParser.AsTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#visibleType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVisibleType(PPASSQLStatementParser.VisibleTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#generatedAlways}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGeneratedAlways(PPASSQLStatementParser.GeneratedAlwaysContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#forUpdate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForUpdate(PPASSQLStatementParser.ForUpdateContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#partitionsAuto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionsAuto(PPASSQLStatementParser.PartitionsAutoContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#enableType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnableType(PPASSQLStatementParser.EnableTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#cacheType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCacheType(PPASSQLStatementParser.CacheTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#basicFileType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicFileType(PPASSQLStatementParser.BasicFileTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#invalidationType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInvalidationType(PPASSQLStatementParser.InvalidationTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#validateType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValidateType(PPASSQLStatementParser.ValidateTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#forceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForceType(PPASSQLStatementParser.ForceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#keepIndexType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeepIndexType(PPASSQLStatementParser.KeepIndexTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PPASSQLStatementParser#yesType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitYesType(PPASSQLStatementParser.YesTypeContext ctx);
}