// Generated from /Users/kongtong.ouyang/IdeaProjects/gumiho/gumiho/src/main/resources/grammars/sql/dialect/oracle/OracleSQLStatementParser.g4 by ANTLR 4.7
package grammars.sql.dialect.oracle;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link OracleSQLStatementParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface OracleSQLStatementParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#parse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParse(OracleSQLStatementParser.ParseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#swallow_to_semi}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwallow_to_semi(OracleSQLStatementParser.Swallow_to_semiContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#emptyStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyStatement(OracleSQLStatementParser.EmptyStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(OracleSQLStatementParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#ddlStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDdlStatement(OracleSQLStatementParser.DdlStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#dmlStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDmlStatement(OracleSQLStatementParser.DmlStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#fclStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFclStatement(OracleSQLStatementParser.FclStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#tclStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTclStatement(OracleSQLStatementParser.TclStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#sclStatment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSclStatment(OracleSQLStatementParser.SclStatmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommand(OracleSQLStatementParser.CommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#createDatabaseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateDatabaseStatement(OracleSQLStatementParser.CreateDatabaseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterDatabaseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterDatabaseStatement(OracleSQLStatementParser.AlterDatabaseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#dropDatabaseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropDatabaseStatement(OracleSQLStatementParser.DropDatabaseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#createDatabaseStatementItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateDatabaseStatementItem(OracleSQLStatementParser.CreateDatabaseStatementItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#userSysClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUserSysClause(OracleSQLStatementParser.UserSysClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#userSystemClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUserSystemClause(OracleSQLStatementParser.UserSystemClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#controlfileReuseClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitControlfileReuseClause(OracleSQLStatementParser.ControlfileReuseClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#maxDataFilesClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMaxDataFilesClause(OracleSQLStatementParser.MaxDataFilesClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#maxInstancesClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMaxInstancesClause(OracleSQLStatementParser.MaxInstancesClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#characterSetOptionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharacterSetOptionExpr(OracleSQLStatementParser.CharacterSetOptionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#nationalCharacterSet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNationalCharacterSet(OracleSQLStatementParser.NationalCharacterSetContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#setDefaultTablespaceClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetDefaultTablespaceClause(OracleSQLStatementParser.SetDefaultTablespaceClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logFileClause}
	 * labeled alternative in {@link OracleSQLStatementParser#databaseLoggingClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogFileClause(OracleSQLStatementParser.LogFileClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code maxLogFilesClause}
	 * labeled alternative in {@link OracleSQLStatementParser#databaseLoggingClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMaxLogFilesClause(OracleSQLStatementParser.MaxLogFilesClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code maxLogMembersClause}
	 * labeled alternative in {@link OracleSQLStatementParser#databaseLoggingClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMaxLogMembersClause(OracleSQLStatementParser.MaxLogMembersClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code maxLogHistoryClause}
	 * labeled alternative in {@link OracleSQLStatementParser#databaseLoggingClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMaxLogHistoryClause(OracleSQLStatementParser.MaxLogHistoryClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code archiveLogExpr}
	 * labeled alternative in {@link OracleSQLStatementParser#databaseLoggingClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArchiveLogExpr(OracleSQLStatementParser.ArchiveLogExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code noArchiveLogExpr}
	 * labeled alternative in {@link OracleSQLStatementParser#databaseLoggingClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoArchiveLogExpr(OracleSQLStatementParser.NoArchiveLogExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code databaseForceLoggingClause}
	 * labeled alternative in {@link OracleSQLStatementParser#databaseLoggingClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDatabaseForceLoggingClause(OracleSQLStatementParser.DatabaseForceLoggingClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code setStandbyNologgingForClause}
	 * labeled alternative in {@link OracleSQLStatementParser#databaseLoggingClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetStandbyNologgingForClause(OracleSQLStatementParser.SetStandbyNologgingForClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#logFileClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogFileClauseItem(OracleSQLStatementParser.LogFileClauseItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#extentManagementClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtentManagementClause(OracleSQLStatementParser.ExtentManagementClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#extentManagementLocalClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtentManagementLocalClause(OracleSQLStatementParser.ExtentManagementLocalClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#extentManagementLocalAutoAllocateClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtentManagementLocalAutoAllocateClause(OracleSQLStatementParser.ExtentManagementLocalAutoAllocateClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#extentManagementLocalUniformClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtentManagementLocalUniformClause(OracleSQLStatementParser.ExtentManagementLocalUniformClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#dataFileClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataFileClause(OracleSQLStatementParser.DataFileClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#sysauxClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSysauxClause(OracleSQLStatementParser.SysauxClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#defaultTablespace}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultTablespace(OracleSQLStatementParser.DefaultTablespaceContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#defaultTempTablespace}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultTempTablespace(OracleSQLStatementParser.DefaultTempTablespaceContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#undoTablespace}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUndoTablespace(OracleSQLStatementParser.UndoTablespaceContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#setTimeZoneClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetTimeZoneClause(OracleSQLStatementParser.SetTimeZoneClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#userDataTablespaceClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUserDataTablespaceClause(OracleSQLStatementParser.UserDataTablespaceClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#enablePluggableDatabase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnablePluggableDatabase(OracleSQLStatementParser.EnablePluggableDatabaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#fileNameConvert}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFileNameConvert(OracleSQLStatementParser.FileNameConvertContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#fileNameConvertFile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFileNameConvertFile(OracleSQLStatementParser.FileNameConvertFileContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#fileNameConvertNone}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFileNameConvertNone(OracleSQLStatementParser.FileNameConvertNoneContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#tablespaceDatafileClauses}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTablespaceDatafileClauses(OracleSQLStatementParser.TablespaceDatafileClausesContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterDatabaseStatementItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterDatabaseStatementItem(OracleSQLStatementParser.AlterDatabaseStatementItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code startUpClauseMount}
	 * labeled alternative in {@link OracleSQLStatementParser#startUpClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStartUpClauseMount(OracleSQLStatementParser.StartUpClauseMountContext ctx);
	/**
	 * Visit a parse tree produced by the {@code startUpClauseOpen}
	 * labeled alternative in {@link OracleSQLStatementParser#startUpClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStartUpClauseOpen(OracleSQLStatementParser.StartUpClauseOpenContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#recoveryClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecoveryClause(OracleSQLStatementParser.RecoveryClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#generalRecovery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGeneralRecovery(OracleSQLStatementParser.GeneralRecoveryContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#fullDatabaseRecovery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFullDatabaseRecovery(OracleSQLStatementParser.FullDatabaseRecoveryContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#partialDatabaseRecovery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartialDatabaseRecovery(OracleSQLStatementParser.PartialDatabaseRecoveryContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#managedStandByRecovery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitManagedStandByRecovery(OracleSQLStatementParser.ManagedStandByRecoveryContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#database_file_clauses}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDatabase_file_clauses(OracleSQLStatementParser.Database_file_clausesContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#createDataFileClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateDataFileClause(OracleSQLStatementParser.CreateDataFileClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alter_datafile_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_datafile_clause(OracleSQLStatementParser.Alter_datafile_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alter_tempfile_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_tempfile_clause(OracleSQLStatementParser.Alter_tempfile_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#moveDataFileAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoveDataFileAction(OracleSQLStatementParser.MoveDataFileActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#iLogFileClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitILogFileClause(OracleSQLStatementParser.ILogFileClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#addLogFileClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddLogFileClause(OracleSQLStatementParser.AddLogFileClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#addLogFileMemberClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddLogFileMemberClauseItem(OracleSQLStatementParser.AddLogFileMemberClauseItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#dropLogFileClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropLogFileClause(OracleSQLStatementParser.DropLogFileClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#switchLogFileClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchLogFileClause(OracleSQLStatementParser.SwitchLogFileClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#addSupplementalLog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSupplementalLog(OracleSQLStatementParser.AddSupplementalLogContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#dropSupplementalLog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropSupplementalLog(OracleSQLStatementParser.DropSupplementalLogContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#logFileDescriptor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogFileDescriptor(OracleSQLStatementParser.LogFileDescriptorContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#controlFileClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitControlFileClause(OracleSQLStatementParser.ControlFileClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#traceFileClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTraceFileClause(OracleSQLStatementParser.TraceFileClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#standbyDatabaseClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStandbyDatabaseClause(OracleSQLStatementParser.StandbyDatabaseClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#activateStandbyDBClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitActivateStandbyDBClause(OracleSQLStatementParser.ActivateStandbyDBClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#maximizeStandbyDBClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMaximizeStandbyDBClause(OracleSQLStatementParser.MaximizeStandbyDBClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#registerLogFileClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegisterLogFileClause(OracleSQLStatementParser.RegisterLogFileClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#switchoverClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchoverClause(OracleSQLStatementParser.SwitchoverClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#failoverClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFailoverClause(OracleSQLStatementParser.FailoverClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#commitSwitchOverClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommitSwitchOverClause(OracleSQLStatementParser.CommitSwitchOverClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#startStandByClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStartStandByClause(OracleSQLStatementParser.StartStandByClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#stopStandbyClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStopStandbyClause(OracleSQLStatementParser.StopStandbyClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#convertDatabaseClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConvertDatabaseClause(OracleSQLStatementParser.ConvertDatabaseClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#defaultSettingsClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultSettingsClause(OracleSQLStatementParser.DefaultSettingsClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#flashbackModeClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlashbackModeClause(OracleSQLStatementParser.FlashbackModeClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#undoModeClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUndoModeClause(OracleSQLStatementParser.UndoModeClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#instanceClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstanceClause(OracleSQLStatementParser.InstanceClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#securityClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSecurityClause(OracleSQLStatementParser.SecurityClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#prepareClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrepareClause(OracleSQLStatementParser.PrepareClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#dropMirrorCopy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropMirrorCopy(OracleSQLStatementParser.DropMirrorCopyContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#lostWriteProtection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLostWriteProtection(OracleSQLStatementParser.LostWriteProtectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#cdbFleetClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCdbFleetClause(OracleSQLStatementParser.CdbFleetClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#leadCdbClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeadCdbClause(OracleSQLStatementParser.LeadCdbClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#leadCdbUriClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeadCdbUriClause(OracleSQLStatementParser.LeadCdbUriClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#createDatabaseLinkStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateDatabaseLinkStatement(OracleSQLStatementParser.CreateDatabaseLinkStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterDatabaseLinkStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterDatabaseLinkStatement(OracleSQLStatementParser.AlterDatabaseLinkStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#dropDatabaseLinkStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropDatabaseLinkStatement(OracleSQLStatementParser.DropDatabaseLinkStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#createDatabaseLinkStatementItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateDatabaseLinkStatementItem(OracleSQLStatementParser.CreateDatabaseLinkStatementItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#connectToCurrentUser}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConnectToCurrentUser(OracleSQLStatementParser.ConnectToCurrentUserContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#connectToIdentifiedBy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConnectToIdentifiedBy(OracleSQLStatementParser.ConnectToIdentifiedByContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#dblinkAuthentication}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDblinkAuthentication(OracleSQLStatementParser.DblinkAuthenticationContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#createFunctionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateFunctionStatement(OracleSQLStatementParser.CreateFunctionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterFunctionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterFunctionStatement(OracleSQLStatementParser.AlterFunctionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#dropFunctionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropFunctionStatement(OracleSQLStatementParser.DropFunctionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#functionOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionOption(OracleSQLStatementParser.FunctionOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterFunctionOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterFunctionOption(OracleSQLStatementParser.AlterFunctionOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#createIndexStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateIndexStatement(OracleSQLStatementParser.CreateIndexStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterIndexStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexStatement(OracleSQLStatementParser.AlterIndexStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#dropIndexStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropIndexStatement(OracleSQLStatementParser.DropIndexStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#createIndexStatementColumn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateIndexStatementColumn(OracleSQLStatementParser.CreateIndexStatementColumnContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#createIndexStatementOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateIndexStatementOption(OracleSQLStatementParser.CreateIndexStatementOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#indexProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexProperty(OracleSQLStatementParser.IndexPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#indexTypeIsIndexTypeClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexTypeIsIndexTypeClause(OracleSQLStatementParser.IndexTypeIsIndexTypeClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#indexAttribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexAttribute(OracleSQLStatementParser.IndexAttributeContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#indexAttributeOnline}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexAttributeOnline(OracleSQLStatementParser.IndexAttributeOnlineContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#indexAttributeComputeStatistics}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexAttributeComputeStatistics(OracleSQLStatementParser.IndexAttributeComputeStatisticsContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#indexAttributeSort}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexAttributeSort(OracleSQLStatementParser.IndexAttributeSortContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#indexAttributeNoSort}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexAttributeNoSort(OracleSQLStatementParser.IndexAttributeNoSortContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#indexAttributeReverse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexAttributeReverse(OracleSQLStatementParser.IndexAttributeReverseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#indexAttributeVisible}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexAttributeVisible(OracleSQLStatementParser.IndexAttributeVisibleContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#indexAttributeInvisible}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexAttributeInvisible(OracleSQLStatementParser.IndexAttributeInvisibleContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#partialIndexClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartialIndexClause(OracleSQLStatementParser.PartialIndexClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#parametersClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametersClause(OracleSQLStatementParser.ParametersClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code globalPartitionByRange}
	 * labeled alternative in {@link OracleSQLStatementParser#iGlobalPartitionBy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobalPartitionByRange(OracleSQLStatementParser.GlobalPartitionByRangeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code globalPartitionByHash}
	 * labeled alternative in {@link OracleSQLStatementParser#iGlobalPartitionBy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobalPartitionByHash(OracleSQLStatementParser.GlobalPartitionByHashContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#localPartitionIndex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalPartitionIndex(OracleSQLStatementParser.LocalPartitionIndexContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterIndexStatementItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexStatementItem(OracleSQLStatementParser.AlterIndexStatementItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#shrinkClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShrinkClause(OracleSQLStatementParser.ShrinkClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#rebuildClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRebuildClause(OracleSQLStatementParser.RebuildClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rebuildClausePartitionItem}
	 * labeled alternative in {@link OracleSQLStatementParser#rebuildClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRebuildClausePartitionItem(OracleSQLStatementParser.RebuildClausePartitionItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rebuildClauseSubPartitionItem}
	 * labeled alternative in {@link OracleSQLStatementParser#rebuildClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRebuildClauseSubPartitionItem(OracleSQLStatementParser.RebuildClauseSubPartitionItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rebuildClauseReverseItem}
	 * labeled alternative in {@link OracleSQLStatementParser#rebuildClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRebuildClauseReverseItem(OracleSQLStatementParser.RebuildClauseReverseItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rebuildClauseNoReverseItem}
	 * labeled alternative in {@link OracleSQLStatementParser#rebuildClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRebuildClauseNoReverseItem(OracleSQLStatementParser.RebuildClauseNoReverseItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#rebuildClauseProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRebuildClauseProperty(OracleSQLStatementParser.RebuildClausePropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#rebuildClauseOnlineProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRebuildClauseOnlineProperty(OracleSQLStatementParser.RebuildClauseOnlinePropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterIndexRebuildAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexRebuildAction(OracleSQLStatementParser.AlterIndexRebuildActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterIndexCompileAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexCompileAction(OracleSQLStatementParser.AlterIndexCompileActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterIndexEnableAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexEnableAction(OracleSQLStatementParser.AlterIndexEnableActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterIndexDisableAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexDisableAction(OracleSQLStatementParser.AlterIndexDisableActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterIndexUnusableAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexUnusableAction(OracleSQLStatementParser.AlterIndexUnusableActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterIndexVisibleAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexVisibleAction(OracleSQLStatementParser.AlterIndexVisibleActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterIndexInvisibleAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexInvisibleAction(OracleSQLStatementParser.AlterIndexInvisibleActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterIndexRenameAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexRenameAction(OracleSQLStatementParser.AlterIndexRenameActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterIndexMonitoringUsageAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexMonitoringUsageAction(OracleSQLStatementParser.AlterIndexMonitoringUsageActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterIndexCoalesceAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexCoalesceAction(OracleSQLStatementParser.AlterIndexCoalesceActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterIndexNoMonitoringUsageAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexNoMonitoringUsageAction(OracleSQLStatementParser.AlterIndexNoMonitoringUsageActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterIndexUpdateBlockReferencesAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexUpdateBlockReferencesAction(OracleSQLStatementParser.AlterIndexUpdateBlockReferencesActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterIndexPartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexPartitionAction(OracleSQLStatementParser.AlterIndexPartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterIndexModifyDefaultAttrsAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexModifyDefaultAttrsAction(OracleSQLStatementParser.AlterIndexModifyDefaultAttrsActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#modifyDefaultAttrItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModifyDefaultAttrItem(OracleSQLStatementParser.ModifyDefaultAttrItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterIndexAddPartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexAddPartitionAction(OracleSQLStatementParser.AlterIndexAddPartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterIndexCoalescePartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexCoalescePartitionAction(OracleSQLStatementParser.AlterIndexCoalescePartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterIndexModifyPartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexModifyPartitionAction(OracleSQLStatementParser.AlterIndexModifyPartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterIndexModifyPartitionActionItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexModifyPartitionActionItem(OracleSQLStatementParser.AlterIndexModifyPartitionActionItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterIndexModifyPartitionActionCoalesceItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexModifyPartitionActionCoalesceItem(OracleSQLStatementParser.AlterIndexModifyPartitionActionCoalesceItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterIndexModifyPartitionActionUpdateBlockReferencesItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexModifyPartitionActionUpdateBlockReferencesItem(OracleSQLStatementParser.AlterIndexModifyPartitionActionUpdateBlockReferencesItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterIndexModifyPartitionActionUnusableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexModifyPartitionActionUnusableItem(OracleSQLStatementParser.AlterIndexModifyPartitionActionUnusableItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterIndexRenamePartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexRenamePartitionAction(OracleSQLStatementParser.AlterIndexRenamePartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterIndexRenameSubPartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexRenameSubPartitionAction(OracleSQLStatementParser.AlterIndexRenameSubPartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterIndexDropPartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexDropPartitionAction(OracleSQLStatementParser.AlterIndexDropPartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterIndexSplitPartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexSplitPartitionAction(OracleSQLStatementParser.AlterIndexSplitPartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterIndexModifySubPartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexModifySubPartitionAction(OracleSQLStatementParser.AlterIndexModifySubPartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterIndexModifySubpartitionOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndexModifySubpartitionOption(OracleSQLStatementParser.AlterIndexModifySubpartitionOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#modifySubpartitionUnusableOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModifySubpartitionUnusableOption(OracleSQLStatementParser.ModifySubpartitionUnusableOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#createPackageStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreatePackageStatement(OracleSQLStatementParser.CreatePackageStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterPackageStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterPackageStatement(OracleSQLStatementParser.AlterPackageStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#dropPackageStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropPackageStatement(OracleSQLStatementParser.DropPackageStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#createPackageBodyStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreatePackageBodyStatement(OracleSQLStatementParser.CreatePackageBodyStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#dropPackageBodyStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropPackageBodyStatement(OracleSQLStatementParser.DropPackageBodyStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#createPackageStatementOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreatePackageStatementOption(OracleSQLStatementParser.CreatePackageStatementOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#createPackageStatementItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreatePackageStatementItem(OracleSQLStatementParser.CreatePackageStatementItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#createPackageBodyStatementItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreatePackageBodyStatementItem(OracleSQLStatementParser.CreatePackageBodyStatementItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterPackageStatementOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterPackageStatementOption(OracleSQLStatementParser.AlterPackageStatementOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#createPluggableDatabaseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreatePluggableDatabaseStatement(OracleSQLStatementParser.CreatePluggableDatabaseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterPluggableDatabaseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterPluggableDatabaseStatement(OracleSQLStatementParser.AlterPluggableDatabaseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#dropPluggableDatabaseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropPluggableDatabaseStatement(OracleSQLStatementParser.DropPluggableDatabaseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#createProcedureStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateProcedureStatement(OracleSQLStatementParser.CreateProcedureStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterProcedureStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterProcedureStatement(OracleSQLStatementParser.AlterProcedureStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#dropProcedureStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropProcedureStatement(OracleSQLStatementParser.DropProcedureStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#createProcedureStatementOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateProcedureStatementOption(OracleSQLStatementParser.CreateProcedureStatementOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterProcedureStatementOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterProcedureStatementOption(OracleSQLStatementParser.AlterProcedureStatementOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#createSequenceStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateSequenceStatement(OracleSQLStatementParser.CreateSequenceStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterSequenceStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterSequenceStatement(OracleSQLStatementParser.AlterSequenceStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#dropSequenceStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropSequenceStatement(OracleSQLStatementParser.DropSequenceStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#createSequenceOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateSequenceOption(OracleSQLStatementParser.CreateSequenceOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterSequenceOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterSequenceOption(OracleSQLStatementParser.AlterSequenceOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#startWithSequenceOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStartWithSequenceOption(OracleSQLStatementParser.StartWithSequenceOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#incrementBySequenceOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncrementBySequenceOption(OracleSQLStatementParser.IncrementBySequenceOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#maxValueSequenceOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMaxValueSequenceOption(OracleSQLStatementParser.MaxValueSequenceOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#noMaxValueSequenceOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoMaxValueSequenceOption(OracleSQLStatementParser.NoMaxValueSequenceOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#minValueSequenceOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinValueSequenceOption(OracleSQLStatementParser.MinValueSequenceOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#noMinValueSequenceOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoMinValueSequenceOption(OracleSQLStatementParser.NoMinValueSequenceOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#cycleSequenceOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCycleSequenceOption(OracleSQLStatementParser.CycleSequenceOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#noCycleSequenceOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoCycleSequenceOption(OracleSQLStatementParser.NoCycleSequenceOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#cacheSequenceOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCacheSequenceOption(OracleSQLStatementParser.CacheSequenceOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#noCacheSequenceOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoCacheSequenceOption(OracleSQLStatementParser.NoCacheSequenceOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#orderSequenceOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrderSequenceOption(OracleSQLStatementParser.OrderSequenceOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#noOrderSequenceOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoOrderSequenceOption(OracleSQLStatementParser.NoOrderSequenceOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#keepSequenceOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeepSequenceOption(OracleSQLStatementParser.KeepSequenceOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#noKeepSequenceOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoKeepSequenceOption(OracleSQLStatementParser.NoKeepSequenceOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#scaleOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScaleOption(OracleSQLStatementParser.ScaleOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#noScaleOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoScaleOption(OracleSQLStatementParser.NoScaleOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#sessionSequenceOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSessionSequenceOption(OracleSQLStatementParser.SessionSequenceOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#globalSequenceOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobalSequenceOption(OracleSQLStatementParser.GlobalSequenceOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#createSynonymStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateSynonymStatement(OracleSQLStatementParser.CreateSynonymStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterSynonymStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterSynonymStatement(OracleSQLStatementParser.AlterSynonymStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#dropSynonymStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropSynonymStatement(OracleSQLStatementParser.DropSynonymStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#createTableStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTableStatement(OracleSQLStatementParser.CreateTableStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTableStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableStatement(OracleSQLStatementParser.AlterTableStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#dropTableStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropTableStatement(OracleSQLStatementParser.DropTableStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#truncateTableStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTruncateTableStatement(OracleSQLStatementParser.TruncateTableStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#tableScope}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableScope(OracleSQLStatementParser.TableScopeContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#tableElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableElement(OracleSQLStatementParser.TableElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#iColumnDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIColumnDefinition(OracleSQLStatementParser.IColumnDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#memoptimizeForRead}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemoptimizeForRead(OracleSQLStatementParser.MemoptimizeForReadContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#columnDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnDefinition(OracleSQLStatementParser.ColumnDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#columnDefinitionDefaultValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnDefinitionDefaultValue(OracleSQLStatementParser.ColumnDefinitionDefaultValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#identityClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentityClause(OracleSQLStatementParser.IdentityClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#onNull}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOnNull(OracleSQLStatementParser.OnNullContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#identityOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentityOption(OracleSQLStatementParser.IdentityOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#identityStartWithOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentityStartWithOption(OracleSQLStatementParser.IdentityStartWithOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#identityIncrementByOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentityIncrementByOption(OracleSQLStatementParser.IdentityIncrementByOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#identityMaxValueOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentityMaxValueOption(OracleSQLStatementParser.IdentityMaxValueOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#identityNoMaxValueOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentityNoMaxValueOption(OracleSQLStatementParser.IdentityNoMaxValueOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#identityMinValueOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentityMinValueOption(OracleSQLStatementParser.IdentityMinValueOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#identityNoMinValueOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentityNoMinValueOption(OracleSQLStatementParser.IdentityNoMinValueOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#identityCycleOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentityCycleOption(OracleSQLStatementParser.IdentityCycleOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#identityNoCycleOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentityNoCycleOption(OracleSQLStatementParser.IdentityNoCycleOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#identityCacheOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentityCacheOption(OracleSQLStatementParser.IdentityCacheOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#identityNoCacheOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentityNoCacheOption(OracleSQLStatementParser.IdentityNoCacheOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#identityOrderOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentityOrderOption(OracleSQLStatementParser.IdentityOrderOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#identityNoOrderOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentityNoOrderOption(OracleSQLStatementParser.IdentityNoOrderOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#virtualColumnDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVirtualColumnDefinition(OracleSQLStatementParser.VirtualColumnDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#evaluationEditionClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEvaluationEditionClause(OracleSQLStatementParser.EvaluationEditionClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code evaluationEditionCurrentEditionAction}
	 * labeled alternative in {@link OracleSQLStatementParser#evaluationEditionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEvaluationEditionCurrentEditionAction(OracleSQLStatementParser.EvaluationEditionCurrentEditionActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code evaluationEditionEditionAction}
	 * labeled alternative in {@link OracleSQLStatementParser#evaluationEditionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEvaluationEditionEditionAction(OracleSQLStatementParser.EvaluationEditionEditionActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code evaluationEditionNullEditionAction}
	 * labeled alternative in {@link OracleSQLStatementParser#evaluationEditionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEvaluationEditionNullEditionAction(OracleSQLStatementParser.EvaluationEditionNullEditionActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#unusableEditionsClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnusableEditionsClause(OracleSQLStatementParser.UnusableEditionsClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unusableBeforeCurrentEditionAction}
	 * labeled alternative in {@link OracleSQLStatementParser#unusableBeforeAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnusableBeforeCurrentEditionAction(OracleSQLStatementParser.UnusableBeforeCurrentEditionActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unusableBeforeEditionAction}
	 * labeled alternative in {@link OracleSQLStatementParser#unusableBeforeAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnusableBeforeEditionAction(OracleSQLStatementParser.UnusableBeforeEditionActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unusableBeginningWithCurrentEditionAction}
	 * labeled alternative in {@link OracleSQLStatementParser#unusableBeginningWithAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnusableBeginningWithCurrentEditionAction(OracleSQLStatementParser.UnusableBeginningWithCurrentEditionActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unusableBeginningWithEditionAction}
	 * labeled alternative in {@link OracleSQLStatementParser#unusableBeginningWithAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnusableBeginningWithEditionAction(OracleSQLStatementParser.UnusableBeginningWithEditionActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unusableBeginningWithNullEditionAction}
	 * labeled alternative in {@link OracleSQLStatementParser#unusableBeginningWithAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnusableBeginningWithNullEditionAction(OracleSQLStatementParser.UnusableBeginningWithNullEditionActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#periodDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPeriodDefinition(OracleSQLStatementParser.PeriodDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#decryptClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecryptClause(OracleSQLStatementParser.DecryptClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#encryptClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEncryptClause(OracleSQLStatementParser.EncryptClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#encryptionSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEncryptionSpec(OracleSQLStatementParser.EncryptionSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#objectTableSubstitution}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectTableSubstitution(OracleSQLStatementParser.ObjectTableSubstitutionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#objectProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectProperty(OracleSQLStatementParser.ObjectPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#commitActionDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommitActionDefinition(OracleSQLStatementParser.CommitActionDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#commitActionRows}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommitActionRows(OracleSQLStatementParser.CommitActionRowsContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#oidClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOidClause(OracleSQLStatementParser.OidClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#oidIndexClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOidIndexClause(OracleSQLStatementParser.OidIndexClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#oidIndexClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOidIndexClauseItem(OracleSQLStatementParser.OidIndexClauseItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#heapOrgTableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHeapOrgTableClause(OracleSQLStatementParser.HeapOrgTableClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#indexOrgTableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexOrgTableClause(OracleSQLStatementParser.IndexOrgTableClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#pctthresholdClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPctthresholdClause(OracleSQLStatementParser.PctthresholdClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mappingTableClause}
	 * labeled alternative in {@link OracleSQLStatementParser#iMappingTableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMappingTableClause(OracleSQLStatementParser.MappingTableClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code noMappingTableClause}
	 * labeled alternative in {@link OracleSQLStatementParser#iMappingTableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoMappingTableClause(OracleSQLStatementParser.NoMappingTableClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#indexCompression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexCompression(OracleSQLStatementParser.IndexCompressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code prefixCompression}
	 * labeled alternative in {@link OracleSQLStatementParser#iPrefixCompression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixCompression(OracleSQLStatementParser.PrefixCompressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code prefixNoCompression}
	 * labeled alternative in {@link OracleSQLStatementParser#iPrefixCompression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixNoCompression(OracleSQLStatementParser.PrefixNoCompressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code advancedIndexCompression}
	 * labeled alternative in {@link OracleSQLStatementParser#iAdvancedIndexCompression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdvancedIndexCompression(OracleSQLStatementParser.AdvancedIndexCompressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code advancedIndexNoCompression}
	 * labeled alternative in {@link OracleSQLStatementParser#iAdvancedIndexCompression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdvancedIndexNoCompression(OracleSQLStatementParser.AdvancedIndexNoCompressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#indexOrgOverflowClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexOrgOverflowClause(OracleSQLStatementParser.IndexOrgOverflowClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#indexOrgOverflowClauseIncludingClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexOrgOverflowClauseIncludingClause(OracleSQLStatementParser.IndexOrgOverflowClauseIncludingClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#indexOrgOverflowClauseOverflowExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexOrgOverflowClauseOverflowExpr(OracleSQLStatementParser.IndexOrgOverflowClauseOverflowExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code supplementalLogGrpClause}
	 * labeled alternative in {@link OracleSQLStatementParser#iSupplementalLog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSupplementalLogGrpClause(OracleSQLStatementParser.SupplementalLogGrpClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code supplementalIdKeyClause}
	 * labeled alternative in {@link OracleSQLStatementParser#iSupplementalLog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSupplementalIdKeyClause(OracleSQLStatementParser.SupplementalIdKeyClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#supplementalLogGrpClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSupplementalLogGrpClauseItem(OracleSQLStatementParser.SupplementalLogGrpClauseItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#supplementalIdKeyClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSupplementalIdKeyClauseItem(OracleSQLStatementParser.SupplementalIdKeyClauseItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#columnProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnProperty(OracleSQLStatementParser.ColumnPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#opaqueTypeColumnProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpaqueTypeColumnProperty(OracleSQLStatementParser.OpaqueTypeColumnPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#vArrayColPropertyColumnProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVArrayColPropertyColumnProperty(OracleSQLStatementParser.VArrayColPropertyColumnPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#lobStorageClauseColumnProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobStorageClauseColumnProperty(OracleSQLStatementParser.LobStorageClauseColumnPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#objectTypeColProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectTypeColProperty(OracleSQLStatementParser.ObjectTypeColPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#buildClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuildClause(OracleSQLStatementParser.BuildClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#attributeClusteringClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributeClusteringClause(OracleSQLStatementParser.AttributeClusteringClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#clusteringJoin}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClusteringJoin(OracleSQLStatementParser.ClusteringJoinContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#clusteringJoinItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClusteringJoinItem(OracleSQLStatementParser.ClusteringJoinItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#clusterClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClusterClause(OracleSQLStatementParser.ClusterClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#clusteringWhen}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClusteringWhen(OracleSQLStatementParser.ClusteringWhenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code withMaterializedZonemapClause}
	 * labeled alternative in {@link OracleSQLStatementParser#zonemapClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithMaterializedZonemapClause(OracleSQLStatementParser.WithMaterializedZonemapClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code withoutMaterializedZonemapClause}
	 * labeled alternative in {@link OracleSQLStatementParser#zonemapClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithoutMaterializedZonemapClause(OracleSQLStatementParser.WithoutMaterializedZonemapClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#memoptimizeReadClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemoptimizeReadClause(OracleSQLStatementParser.MemoptimizeReadClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableItem(OracleSQLStatementParser.AlterTableItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTableEnableDisable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableEnableDisable(OracleSQLStatementParser.AlterTableEnableDisableContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTableProerty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableProerty(OracleSQLStatementParser.AlterTableProertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTableReadOnlyAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableReadOnlyAction(OracleSQLStatementParser.AlterTableReadOnlyActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTableReadWriteAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableReadWriteAction(OracleSQLStatementParser.AlterTableReadWriteActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableAddSupplementalLoggingAction}
	 * labeled alternative in {@link OracleSQLStatementParser#iAlterTableSupplementalLoggingAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableAddSupplementalLoggingAction(OracleSQLStatementParser.AlterTableAddSupplementalLoggingActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code iAlterTableDropSupplementalLoggingAction}
	 * labeled alternative in {@link OracleSQLStatementParser#iAlterTableSupplementalLoggingAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIAlterTableDropSupplementalLoggingAction(OracleSQLStatementParser.IAlterTableDropSupplementalLoggingActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTableUpgradeTableAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableUpgradeTableAction(OracleSQLStatementParser.AlterTableUpgradeTableActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#records_per_block_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecords_per_block_clause(OracleSQLStatementParser.Records_per_block_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#rowMovementClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowMovementClause(OracleSQLStatementParser.RowMovementClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTableRenameTableAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableRenameTableAction(OracleSQLStatementParser.AlterTableRenameTableActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTableIotAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableIotAction(OracleSQLStatementParser.AlterTableIotActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTableCoalesceIotAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableCoalesceIotAction(OracleSQLStatementParser.AlterTableCoalesceIotActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTableAlterOverflowIotAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableAlterOverflowIotAction(OracleSQLStatementParser.AlterTableAlterOverflowIotActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterOverflowClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterOverflowClauseItem(OracleSQLStatementParser.AlterOverflowClauseItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTableAddOverflowIotAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableAddOverflowIotAction(OracleSQLStatementParser.AlterTableAddOverflowIotActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTableMappingTableIotAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableMappingTableIotAction(OracleSQLStatementParser.AlterTableMappingTableIotActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterMappingTableClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterMappingTableClauseItem(OracleSQLStatementParser.AlterMappingTableClauseItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTableColumnAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableColumnAction(OracleSQLStatementParser.AlterTableColumnActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTableAddColumnAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableAddColumnAction(OracleSQLStatementParser.AlterTableAddColumnActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTableModifyColumnsAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableModifyColumnsAction(OracleSQLStatementParser.AlterTableModifyColumnsActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTableModifyColumnAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableModifyColumnAction(OracleSQLStatementParser.AlterTableModifyColumnActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableSetUnusedColumnAction}
	 * labeled alternative in {@link OracleSQLStatementParser#iAlterTableDropColumnAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableSetUnusedColumnAction(OracleSQLStatementParser.AlterTableSetUnusedColumnActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableDropColumnAction}
	 * labeled alternative in {@link OracleSQLStatementParser#iAlterTableDropColumnAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableDropColumnAction(OracleSQLStatementParser.AlterTableDropColumnActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableDropUnusedColumnsAction}
	 * labeled alternative in {@link OracleSQLStatementParser#iAlterTableDropColumnAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableDropUnusedColumnsAction(OracleSQLStatementParser.AlterTableDropUnusedColumnsActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableDropColumnsContinueAction}
	 * labeled alternative in {@link OracleSQLStatementParser#iAlterTableDropColumnAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableDropColumnsContinueAction(OracleSQLStatementParser.AlterTableDropColumnsContinueActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#iAlterTableDropColumnActionOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIAlterTableDropColumnActionOption(OracleSQLStatementParser.IAlterTableDropColumnActionOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTableDropPeriodAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableDropPeriodAction(OracleSQLStatementParser.AlterTableDropPeriodActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTableRenameColumnAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableRenameColumnAction(OracleSQLStatementParser.AlterTableRenameColumnActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTableModifyCollectionRetrievalAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableModifyCollectionRetrievalAction(OracleSQLStatementParser.AlterTableModifyCollectionRetrievalActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTableModifyLobStorageAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableModifyLobStorageAction(OracleSQLStatementParser.AlterTableModifyLobStorageActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#modifyLobParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModifyLobParameter(OracleSQLStatementParser.ModifyLobParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTableAlterVarrayColPropertyAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableAlterVarrayColPropertyAction(OracleSQLStatementParser.AlterTableAlterVarrayColPropertyActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableAddTableConstraintAction}
	 * labeled alternative in {@link OracleSQLStatementParser#iAlterTableConstraintAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableAddTableConstraintAction(OracleSQLStatementParser.AlterTableAddTableConstraintActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableModifyTableConstraintAction}
	 * labeled alternative in {@link OracleSQLStatementParser#iAlterTableConstraintAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableModifyTableConstraintAction(OracleSQLStatementParser.AlterTableModifyTableConstraintActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableModifyPrimaryKeyConstraintAction}
	 * labeled alternative in {@link OracleSQLStatementParser#iAlterTableConstraintAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableModifyPrimaryKeyConstraintAction(OracleSQLStatementParser.AlterTableModifyPrimaryKeyConstraintActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableModifyUniqueConstraintAction}
	 * labeled alternative in {@link OracleSQLStatementParser#iAlterTableConstraintAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableModifyUniqueConstraintAction(OracleSQLStatementParser.AlterTableModifyUniqueConstraintActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableRenameTableConstraintAction}
	 * labeled alternative in {@link OracleSQLStatementParser#iAlterTableConstraintAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableRenameTableConstraintAction(OracleSQLStatementParser.AlterTableRenameTableConstraintActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableDropPrimaryKeyConstraintAction}
	 * labeled alternative in {@link OracleSQLStatementParser#iAlterTableConstraintAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableDropPrimaryKeyConstraintAction(OracleSQLStatementParser.AlterTableDropPrimaryKeyConstraintActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableDropUniqueConstraintAction}
	 * labeled alternative in {@link OracleSQLStatementParser#iAlterTableConstraintAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableDropUniqueConstraintAction(OracleSQLStatementParser.AlterTableDropUniqueConstraintActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableDropTableConstraintAction}
	 * labeled alternative in {@link OracleSQLStatementParser#iAlterTableConstraintAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableDropTableConstraintAction(OracleSQLStatementParser.AlterTableDropTableConstraintActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterXmlSchemaClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterXmlSchemaClause(OracleSQLStatementParser.AlterXmlSchemaClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#iAlterTablePartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIAlterTablePartitionAction(OracleSQLStatementParser.IAlterTablePartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTablePartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTablePartitionAction(OracleSQLStatementParser.AlterTablePartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTablePartitionActionForItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTablePartitionActionForItem(OracleSQLStatementParser.AlterTablePartitionActionForItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTableModifyDefaultAttrsAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableModifyDefaultAttrsAction(OracleSQLStatementParser.AlterTableModifyDefaultAttrsActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forPartition}
	 * labeled alternative in {@link OracleSQLStatementParser#iForPartition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForPartition(OracleSQLStatementParser.ForPartitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forPartitionFor}
	 * labeled alternative in {@link OracleSQLStatementParser#iForPartition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForPartitionFor(OracleSQLStatementParser.ForPartitionForContext ctx);
	/**
	 * Visit a parse tree produced by the {@code modifyTableDefaultAttrsActionLobItem}
	 * labeled alternative in {@link OracleSQLStatementParser#modifyTableDefaultAttrsActionItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModifyTableDefaultAttrsActionLobItem(OracleSQLStatementParser.ModifyTableDefaultAttrsActionLobItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code modifyTableDefaultAttrsActionVarrayItem}
	 * labeled alternative in {@link OracleSQLStatementParser#modifyTableDefaultAttrsActionItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModifyTableDefaultAttrsActionVarrayItem(OracleSQLStatementParser.ModifyTableDefaultAttrsActionVarrayItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTableSetPartitioningAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableSetPartitioningAction(OracleSQLStatementParser.AlterTableSetPartitioningActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTableSetStoreInAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableSetStoreInAction(OracleSQLStatementParser.AlterTableSetStoreInActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTableSetIntervalAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableSetIntervalAction(OracleSQLStatementParser.AlterTableSetIntervalActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTableSetSubpartitionTemplateAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableSetSubpartitionTemplateAction(OracleSQLStatementParser.AlterTableSetSubpartitionTemplateActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTableModifyPartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableModifyPartitionAction(OracleSQLStatementParser.AlterTableModifyPartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTableModifyPartitionForAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableModifyPartitionForAction(OracleSQLStatementParser.AlterTableModifyPartitionForActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTableModifySubPartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableModifySubPartitionAction(OracleSQLStatementParser.AlterTableModifySubPartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTableModifySubPartitionForAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableModifySubPartitionForAction(OracleSQLStatementParser.AlterTableModifySubPartitionForActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTableModifyPartitionActionItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableModifyPartitionActionItem(OracleSQLStatementParser.AlterTableModifyPartitionActionItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#modifyPartitionAddValues}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModifyPartitionAddValues(OracleSQLStatementParser.ModifyPartitionAddValuesContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#modifyPartitionDropValues}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModifyPartitionDropValues(OracleSQLStatementParser.ModifyPartitionDropValuesContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#modifyPartitionUnusableLocalIndexes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModifyPartitionUnusableLocalIndexes(OracleSQLStatementParser.ModifyPartitionUnusableLocalIndexesContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#partitionAttribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionAttribute(OracleSQLStatementParser.PartitionAttributeContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#partitionAttributeLobClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionAttributeLobClause(OracleSQLStatementParser.PartitionAttributeLobClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#partitionAttributeVarrayClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionAttributeVarrayClause(OracleSQLStatementParser.PartitionAttributeVarrayClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTableMovePartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableMovePartitionAction(OracleSQLStatementParser.AlterTableMovePartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTableMovePartitionForAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableMovePartitionForAction(OracleSQLStatementParser.AlterTableMovePartitionForActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTableMovePartitionActionProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableMovePartitionActionProperty(OracleSQLStatementParser.AlterTableMovePartitionActionPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#filterCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilterCondition(OracleSQLStatementParser.FilterConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#allowDisallowClustering}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAllowDisallowClustering(OracleSQLStatementParser.AllowDisallowClusteringContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTableMoveSubPartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableMoveSubPartitionAction(OracleSQLStatementParser.AlterTableMoveSubPartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTableMoveSubPartitionForAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableMoveSubPartitionForAction(OracleSQLStatementParser.AlterTableMoveSubPartitionForActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTableAddPartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableAddPartitionAction(OracleSQLStatementParser.AlterTableAddPartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#modifyPartitionAddSubPartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModifyPartitionAddSubPartitionAction(OracleSQLStatementParser.ModifyPartitionAddSubPartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#dependentTablesClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDependentTablesClause(OracleSQLStatementParser.DependentTablesClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#dependentTablesClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDependentTablesClauseItem(OracleSQLStatementParser.DependentTablesClauseItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTableCoalesceTablePartition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableCoalesceTablePartition(OracleSQLStatementParser.AlterTableCoalesceTablePartitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#coalesceTableSubpartition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCoalesceTableSubpartition(OracleSQLStatementParser.CoalesceTableSubpartitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTableDropPartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableDropPartitionAction(OracleSQLStatementParser.AlterTableDropPartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#dropPartitionActionItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropPartitionActionItem(OracleSQLStatementParser.DropPartitionActionItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTableDropSubpartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableDropSubpartitionAction(OracleSQLStatementParser.AlterTableDropSubpartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTableRenamePartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableRenamePartitionAction(OracleSQLStatementParser.AlterTableRenamePartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTableRenamePartitionForAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableRenamePartitionForAction(OracleSQLStatementParser.AlterTableRenamePartitionForActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTableRenameSubPartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableRenameSubPartitionAction(OracleSQLStatementParser.AlterTableRenameSubPartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTableRenameSubPartitionForAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableRenameSubPartitionForAction(OracleSQLStatementParser.AlterTableRenameSubPartitionForActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTableTruncatePartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableTruncatePartitionAction(OracleSQLStatementParser.AlterTableTruncatePartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTableTruncateSubPartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableTruncateSubPartitionAction(OracleSQLStatementParser.AlterTableTruncateSubPartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTablePartitionItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTablePartitionItem(OracleSQLStatementParser.AlterTablePartitionItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableSplitPartitionAction}
	 * labeled alternative in {@link OracleSQLStatementParser#iAlterTableSplitPartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableSplitPartitionAction(OracleSQLStatementParser.AlterTableSplitPartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableSplitPartitionForAction}
	 * labeled alternative in {@link OracleSQLStatementParser#iAlterTableSplitPartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableSplitPartitionForAction(OracleSQLStatementParser.AlterTableSplitPartitionForActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code splitPartitionAtItem}
	 * labeled alternative in {@link OracleSQLStatementParser#iAlterTableSplitPartitionActionItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSplitPartitionAtItem(OracleSQLStatementParser.SplitPartitionAtItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code splitPartitionValuesItem}
	 * labeled alternative in {@link OracleSQLStatementParser#iAlterTableSplitPartitionActionItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSplitPartitionValuesItem(OracleSQLStatementParser.SplitPartitionValuesItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code splitPartitionIntoItem}
	 * labeled alternative in {@link OracleSQLStatementParser#iAlterTableSplitPartitionActionItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSplitPartitionIntoItem(OracleSQLStatementParser.SplitPartitionIntoItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#splitNestedTablePart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSplitNestedTablePart(OracleSQLStatementParser.SplitNestedTablePartContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableSplitSubPartitionAction}
	 * labeled alternative in {@link OracleSQLStatementParser#iAlterTableSubSplitPartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableSplitSubPartitionAction(OracleSQLStatementParser.AlterTableSplitSubPartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableSplitSubPartitionForAction}
	 * labeled alternative in {@link OracleSQLStatementParser#iAlterTableSubSplitPartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableSplitSubPartitionForAction(OracleSQLStatementParser.AlterTableSplitSubPartitionForActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableMergePartitionsAction}
	 * labeled alternative in {@link OracleSQLStatementParser#iAlterTableMergePartitionsAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableMergePartitionsAction(OracleSQLStatementParser.AlterTableMergePartitionsActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableMergePartitionsToAction}
	 * labeled alternative in {@link OracleSQLStatementParser#iAlterTableMergePartitionsAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableMergePartitionsToAction(OracleSQLStatementParser.AlterTableMergePartitionsToActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableMergeSubPartitionsAction}
	 * labeled alternative in {@link OracleSQLStatementParser#iAlterTableMergeSubPartitionsAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableMergeSubPartitionsAction(OracleSQLStatementParser.AlterTableMergeSubPartitionsActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableMergeSubPartitionsToAction}
	 * labeled alternative in {@link OracleSQLStatementParser#iAlterTableMergeSubPartitionsAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableMergeSubPartitionsToAction(OracleSQLStatementParser.AlterTableMergeSubPartitionsToActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableExchangePartitionAction}
	 * labeled alternative in {@link OracleSQLStatementParser#iAlterTableExchangePartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableExchangePartitionAction(OracleSQLStatementParser.AlterTableExchangePartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableExchangePartitionForAction}
	 * labeled alternative in {@link OracleSQLStatementParser#iAlterTableExchangePartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableExchangePartitionForAction(OracleSQLStatementParser.AlterTableExchangePartitionForActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableExchangeSubPartitionAction}
	 * labeled alternative in {@link OracleSQLStatementParser#iAlterTableExchangeSubPartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableExchangeSubPartitionAction(OracleSQLStatementParser.AlterTableExchangeSubPartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableExchangeSubPartitionForAction}
	 * labeled alternative in {@link OracleSQLStatementParser#iAlterTableExchangeSubPartitionAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableExchangeSubPartitionForAction(OracleSQLStatementParser.AlterTableExchangeSubPartitionForActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#updateIndexClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdateIndexClause(OracleSQLStatementParser.UpdateIndexClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#updateGlobalIndexClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdateGlobalIndexClause(OracleSQLStatementParser.UpdateGlobalIndexClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#updateIndexesClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdateIndexesClause(OracleSQLStatementParser.UpdateIndexesClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#updateIndexesClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdateIndexesClauseItem(OracleSQLStatementParser.UpdateIndexesClauseItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#updateIndexesClauseItemItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdateIndexesClauseItemItem(OracleSQLStatementParser.UpdateIndexesClauseItemItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTableMoveTableAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableMoveTableAction(OracleSQLStatementParser.AlterTableMoveTableActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTableMoveTableActionProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableMoveTableActionProperty(OracleSQLStatementParser.AlterTableMoveTableActionPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTableModifyToPartitionedAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableModifyToPartitionedAction(OracleSQLStatementParser.AlterTableModifyToPartitionedActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTableModifyToPartitionedActionUpdateIndexesItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableModifyToPartitionedActionUpdateIndexesItem(OracleSQLStatementParser.AlterTableModifyToPartitionedActionUpdateIndexesItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTableModifyOpaqueTypeAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableModifyOpaqueTypeAction(OracleSQLStatementParser.AlterTableModifyOpaqueTypeActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code enableUniqueClause}
	 * labeled alternative in {@link OracleSQLStatementParser#iEnableDisableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnableUniqueClause(OracleSQLStatementParser.EnableUniqueClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code enablePrimaryKeyClause}
	 * labeled alternative in {@link OracleSQLStatementParser#iEnableDisableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnablePrimaryKeyClause(OracleSQLStatementParser.EnablePrimaryKeyClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code enableConstraintClause}
	 * labeled alternative in {@link OracleSQLStatementParser#iEnableDisableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnableConstraintClause(OracleSQLStatementParser.EnableConstraintClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code disableUniqueClause}
	 * labeled alternative in {@link OracleSQLStatementParser#iEnableDisableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDisableUniqueClause(OracleSQLStatementParser.DisableUniqueClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code disablePrimaryKeyClause}
	 * labeled alternative in {@link OracleSQLStatementParser#iEnableDisableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDisablePrimaryKeyClause(OracleSQLStatementParser.DisablePrimaryKeyClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code disableConstraintClause}
	 * labeled alternative in {@link OracleSQLStatementParser#iEnableDisableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDisableConstraintClause(OracleSQLStatementParser.DisableConstraintClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTableEnableTableLockAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableEnableTableLockAction(OracleSQLStatementParser.AlterTableEnableTableLockActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTableEnableAllTriggersAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableEnableAllTriggersAction(OracleSQLStatementParser.AlterTableEnableAllTriggersActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTableEnableContainerMapAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableEnableContainerMapAction(OracleSQLStatementParser.AlterTableEnableContainerMapActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTableEnableContainersDefaultAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableEnableContainersDefaultAction(OracleSQLStatementParser.AlterTableEnableContainersDefaultActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTableDisableTableLockAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableDisableTableLockAction(OracleSQLStatementParser.AlterTableDisableTableLockActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTableDisableAllTriggersAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableDisableAllTriggersAction(OracleSQLStatementParser.AlterTableDisableAllTriggersActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTableDisableContainerMapAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableDisableContainerMapAction(OracleSQLStatementParser.AlterTableDisableContainerMapActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTableDisableContainersDefaultAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableDisableContainersDefaultAction(OracleSQLStatementParser.AlterTableDisableContainersDefaultActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#createTriggerStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTriggerStatement(OracleSQLStatementParser.CreateTriggerStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTriggerStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTriggerStatement(OracleSQLStatementParser.AlterTriggerStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#dropTriggerStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropTriggerStatement(OracleSQLStatementParser.DropTriggerStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#createTriggerActionTime}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTriggerActionTime(OracleSQLStatementParser.CreateTriggerActionTimeContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#createTriggerEvent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTriggerEvent(OracleSQLStatementParser.CreateTriggerEventContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#triggerDmlEvent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTriggerDmlEvent(OracleSQLStatementParser.TriggerDmlEventContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#triggerDDLEvent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTriggerDDLEvent(OracleSQLStatementParser.TriggerDDLEventContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#triggerDatabaseEvent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTriggerDatabaseEvent(OracleSQLStatementParser.TriggerDatabaseEventContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#createTriggerOnExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTriggerOnExpr(OracleSQLStatementParser.CreateTriggerOnExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#createTriggerOnSchemaExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTriggerOnSchemaExpr(OracleSQLStatementParser.CreateTriggerOnSchemaExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#createTriggerOnDatabaseExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTriggerOnDatabaseExpr(OracleSQLStatementParser.CreateTriggerOnDatabaseExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#forEachRow}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForEachRow(OracleSQLStatementParser.ForEachRowContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#referencingOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReferencingOption(OracleSQLStatementParser.ReferencingOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#triggerEditionClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTriggerEditionClause(OracleSQLStatementParser.TriggerEditionClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#triggerOrderingClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTriggerOrderingClause(OracleSQLStatementParser.TriggerOrderingClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#compoundTriggerBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompoundTriggerBlock(OracleSQLStatementParser.CompoundTriggerBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#timingPointSection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimingPointSection(OracleSQLStatementParser.TimingPointSectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#timingPoint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimingPoint(OracleSQLStatementParser.TimingPointContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#triggerBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTriggerBody(OracleSQLStatementParser.TriggerBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTriggerStatementOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTriggerStatementOption(OracleSQLStatementParser.AlterTriggerStatementOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#createTypeStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTypeStatement(OracleSQLStatementParser.CreateTypeStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTypeStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTypeStatement(OracleSQLStatementParser.AlterTypeStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#dropTypeStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropTypeStatement(OracleSQLStatementParser.DropTypeStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#createTypeStatementProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTypeStatementProperty(OracleSQLStatementParser.CreateTypeStatementPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#createTypeExternalNameClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTypeExternalNameClause(OracleSQLStatementParser.CreateTypeExternalNameClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#createTypeStatementOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTypeStatementOption(OracleSQLStatementParser.CreateTypeStatementOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTypeItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTypeItem(OracleSQLStatementParser.AlterTypeItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#replaceClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReplaceClause(OracleSQLStatementParser.ReplaceClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#replaceClauseOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReplaceClauseOption(OracleSQLStatementParser.ReplaceClauseOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#replaceClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReplaceClauseItem(OracleSQLStatementParser.ReplaceClauseItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTypeAddMethodsAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTypeAddMethodsAction(OracleSQLStatementParser.AlterTypeAddMethodsActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTypeAddMethodsActionItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTypeAddMethodsActionItem(OracleSQLStatementParser.AlterTypeAddMethodsActionItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTypeDropMethodsAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTypeDropMethodsAction(OracleSQLStatementParser.AlterTypeDropMethodsActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTypeDropMethodsActionItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTypeDropMethodsActionItem(OracleSQLStatementParser.AlterTypeDropMethodsActionItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTypeAddAttributeAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTypeAddAttributeAction(OracleSQLStatementParser.AlterTypeAddAttributeActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTypeModifyAttributeAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTypeModifyAttributeAction(OracleSQLStatementParser.AlterTypeModifyAttributeActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTypeDropAttributeAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTypeDropAttributeAction(OracleSQLStatementParser.AlterTypeDropAttributeActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTypeModifyLimitAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTypeModifyLimitAction(OracleSQLStatementParser.AlterTypeModifyLimitActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterTypeElementTypeAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTypeElementTypeAction(OracleSQLStatementParser.AlterTypeElementTypeActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dependentHandlingClauseInvalidate}
	 * labeled alternative in {@link OracleSQLStatementParser#dependentHandlingClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDependentHandlingClauseInvalidate(OracleSQLStatementParser.DependentHandlingClauseInvalidateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dependentHandlingClauseCascade}
	 * labeled alternative in {@link OracleSQLStatementParser#dependentHandlingClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDependentHandlingClauseCascade(OracleSQLStatementParser.DependentHandlingClauseCascadeContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#createTypeBodyStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTypeBodyStatement(OracleSQLStatementParser.CreateTypeBodyStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#dropTypeBodyStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropTypeBodyStatement(OracleSQLStatementParser.DropTypeBodyStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#createTypeBodyStatementItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTypeBodyStatementItem(OracleSQLStatementParser.CreateTypeBodyStatementItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#createViewStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateViewStatement(OracleSQLStatementParser.CreateViewStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterViewStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterViewStatement(OracleSQLStatementParser.AlterViewStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#dropViewStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropViewStatement(OracleSQLStatementParser.DropViewStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#createViewSubView}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateViewSubView(OracleSQLStatementParser.CreateViewSubViewContext ctx);
	/**
	 * Visit a parse tree produced by the {@code withObjectIdentifierClause}
	 * labeled alternative in {@link OracleSQLStatementParser#iWithObjectIdClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithObjectIdentifierClause(OracleSQLStatementParser.WithObjectIdentifierClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code withObjectIdClause}
	 * labeled alternative in {@link OracleSQLStatementParser#iWithObjectIdClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithObjectIdClause(OracleSQLStatementParser.WithObjectIdClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#subViewClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubViewClause(OracleSQLStatementParser.SubViewClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterViewAddTableConstraintAction}
	 * labeled alternative in {@link OracleSQLStatementParser#alterViewAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterViewAddTableConstraintAction(OracleSQLStatementParser.AlterViewAddTableConstraintActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterViewModifyConstraintAction}
	 * labeled alternative in {@link OracleSQLStatementParser#alterViewAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterViewModifyConstraintAction(OracleSQLStatementParser.AlterViewModifyConstraintActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterViewDropConstraintAction}
	 * labeled alternative in {@link OracleSQLStatementParser#alterViewAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterViewDropConstraintAction(OracleSQLStatementParser.AlterViewDropConstraintActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterViewDropPrimaryKeyConstraintAction}
	 * labeled alternative in {@link OracleSQLStatementParser#alterViewAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterViewDropPrimaryKeyConstraintAction(OracleSQLStatementParser.AlterViewDropPrimaryKeyConstraintActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterViewDropUniqueConstraintAction}
	 * labeled alternative in {@link OracleSQLStatementParser#alterViewAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterViewDropUniqueConstraintAction(OracleSQLStatementParser.AlterViewDropUniqueConstraintActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterViewCompileAction}
	 * labeled alternative in {@link OracleSQLStatementParser#alterViewAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterViewCompileAction(OracleSQLStatementParser.AlterViewCompileActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterViewReadOnlyAction}
	 * labeled alternative in {@link OracleSQLStatementParser#alterViewAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterViewReadOnlyAction(OracleSQLStatementParser.AlterViewReadOnlyActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterViewReadWriteAction}
	 * labeled alternative in {@link OracleSQLStatementParser#alterViewAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterViewReadWriteAction(OracleSQLStatementParser.AlterViewReadWriteActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterViewEditionableAction}
	 * labeled alternative in {@link OracleSQLStatementParser#alterViewAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterViewEditionableAction(OracleSQLStatementParser.AlterViewEditionableActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterViewNonEditionableAction}
	 * labeled alternative in {@link OracleSQLStatementParser#alterViewAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterViewNonEditionableAction(OracleSQLStatementParser.AlterViewNonEditionableActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#createMaterializedViewStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateMaterializedViewStatement(OracleSQLStatementParser.CreateMaterializedViewStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterMaterializedViewStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterMaterializedViewStatement(OracleSQLStatementParser.AlterMaterializedViewStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#dropMaterializedViewStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropMaterializedViewStatement(OracleSQLStatementParser.DropMaterializedViewStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#iCreateMaterializedViewStatementColumn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitICreateMaterializedViewStatementColumn(OracleSQLStatementParser.ICreateMaterializedViewStatementColumnContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#createMaterializedViewStatementColumn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateMaterializedViewStatementColumn(OracleSQLStatementParser.CreateMaterializedViewStatementColumnContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#createMaterializedViewStatementProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateMaterializedViewStatementProperty(OracleSQLStatementParser.CreateMaterializedViewStatementPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#onPrebuiltTableProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOnPrebuiltTableProperty(OracleSQLStatementParser.OnPrebuiltTablePropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#materializedViewProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMaterializedViewProperty(OracleSQLStatementParser.MaterializedViewPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#materializedViewPropertyCacheClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMaterializedViewPropertyCacheClause(OracleSQLStatementParser.MaterializedViewPropertyCacheClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#materializedViewPropertyNoCacheClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMaterializedViewPropertyNoCacheClause(OracleSQLStatementParser.MaterializedViewPropertyNoCacheClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code usingIndexClause}
	 * labeled alternative in {@link OracleSQLStatementParser#iUsingIndexClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUsingIndexClause(OracleSQLStatementParser.UsingIndexClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code usingNoIndexClause}
	 * labeled alternative in {@link OracleSQLStatementParser#iUsingIndexClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUsingNoIndexClause(OracleSQLStatementParser.UsingNoIndexClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#usingIndexItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUsingIndexItem(OracleSQLStatementParser.UsingIndexItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#usingIndexCreateIndexStatementItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUsingIndexCreateIndexStatementItem(OracleSQLStatementParser.UsingIndexCreateIndexStatementItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code createMVRefresh}
	 * labeled alternative in {@link OracleSQLStatementParser#iCreateMVRefresh}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateMVRefresh(OracleSQLStatementParser.CreateMVRefreshContext ctx);
	/**
	 * Visit a parse tree produced by the {@code createMVNeverRefresh}
	 * labeled alternative in {@link OracleSQLStatementParser#iCreateMVRefresh}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateMVNeverRefresh(OracleSQLStatementParser.CreateMVNeverRefreshContext ctx);
	/**
	 * Visit a parse tree produced by the {@code createMVRefreshFastItem}
	 * labeled alternative in {@link OracleSQLStatementParser#createMVRefreshItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateMVRefreshFastItem(OracleSQLStatementParser.CreateMVRefreshFastItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code createMVRefreshCompleteItem}
	 * labeled alternative in {@link OracleSQLStatementParser#createMVRefreshItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateMVRefreshCompleteItem(OracleSQLStatementParser.CreateMVRefreshCompleteItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code createMVRefreshForceItem}
	 * labeled alternative in {@link OracleSQLStatementParser#createMVRefreshItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateMVRefreshForceItem(OracleSQLStatementParser.CreateMVRefreshForceItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code createMVRefreshOnDemandItem}
	 * labeled alternative in {@link OracleSQLStatementParser#createMVRefreshItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateMVRefreshOnDemandItem(OracleSQLStatementParser.CreateMVRefreshOnDemandItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code createMVRefreshOnCommitItem}
	 * labeled alternative in {@link OracleSQLStatementParser#createMVRefreshItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateMVRefreshOnCommitItem(OracleSQLStatementParser.CreateMVRefreshOnCommitItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code createMVRefreshOnStatementItem}
	 * labeled alternative in {@link OracleSQLStatementParser#createMVRefreshItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateMVRefreshOnStatementItem(OracleSQLStatementParser.CreateMVRefreshOnStatementItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code createMVRefreshStartWithItem}
	 * labeled alternative in {@link OracleSQLStatementParser#createMVRefreshItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateMVRefreshStartWithItem(OracleSQLStatementParser.CreateMVRefreshStartWithItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code createMVRefreshNextItem}
	 * labeled alternative in {@link OracleSQLStatementParser#createMVRefreshItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateMVRefreshNextItem(OracleSQLStatementParser.CreateMVRefreshNextItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code createMVRefreshWithPrimaryKeyItem}
	 * labeled alternative in {@link OracleSQLStatementParser#createMVRefreshItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateMVRefreshWithPrimaryKeyItem(OracleSQLStatementParser.CreateMVRefreshWithPrimaryKeyItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code createMVRefreshWithRowidItem}
	 * labeled alternative in {@link OracleSQLStatementParser#createMVRefreshItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateMVRefreshWithRowidItem(OracleSQLStatementParser.CreateMVRefreshWithRowidItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code createMVRefreshUsingRollbackSegmentItem}
	 * labeled alternative in {@link OracleSQLStatementParser#createMVRefreshItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateMVRefreshUsingRollbackSegmentItem(OracleSQLStatementParser.CreateMVRefreshUsingRollbackSegmentItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code createMVRefreshUsingEnforcedConstraintsItem}
	 * labeled alternative in {@link OracleSQLStatementParser#createMVRefreshItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateMVRefreshUsingEnforcedConstraintsItem(OracleSQLStatementParser.CreateMVRefreshUsingEnforcedConstraintsItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code createMVRefreshUsingTrustedConstraintsItem}
	 * labeled alternative in {@link OracleSQLStatementParser#createMVRefreshItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateMVRefreshUsingTrustedConstraintsItem(OracleSQLStatementParser.CreateMVRefreshUsingTrustedConstraintsItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code usingRollbackSegmentByDefaultItem}
	 * labeled alternative in {@link OracleSQLStatementParser#usingRollbackSegmentItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUsingRollbackSegmentByDefaultItem(OracleSQLStatementParser.UsingRollbackSegmentByDefaultItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code usingRollbackSegmentByNoDefaultItem}
	 * labeled alternative in {@link OracleSQLStatementParser#usingRollbackSegmentItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUsingRollbackSegmentByNoDefaultItem(OracleSQLStatementParser.UsingRollbackSegmentByNoDefaultItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#usingRollbackSegmentOptionType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUsingRollbackSegmentOptionType(OracleSQLStatementParser.UsingRollbackSegmentOptionTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#onQueryComputationClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOnQueryComputationClause(OracleSQLStatementParser.OnQueryComputationClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#queryRewriteClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQueryRewriteClause(OracleSQLStatementParser.QueryRewriteClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterMaterializedViewStatementProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterMaterializedViewStatementProperty(OracleSQLStatementParser.AlterMaterializedViewStatementPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#commentOnAuditPolicyStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommentOnAuditPolicyStatement(OracleSQLStatementParser.CommentOnAuditPolicyStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#commentOnColumnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommentOnColumnStatement(OracleSQLStatementParser.CommentOnColumnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#commentOnEditionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommentOnEditionStatement(OracleSQLStatementParser.CommentOnEditionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#commentOnIndexTypeStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommentOnIndexTypeStatement(OracleSQLStatementParser.CommentOnIndexTypeStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#commentOnMaterializedViewStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommentOnMaterializedViewStatement(OracleSQLStatementParser.CommentOnMaterializedViewStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#commentOnMiningModelStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommentOnMiningModelStatement(OracleSQLStatementParser.CommentOnMiningModelStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#commentOnOperatorStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommentOnOperatorStatement(OracleSQLStatementParser.CommentOnOperatorStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#commentOnTableStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommentOnTableStatement(OracleSQLStatementParser.CommentOnTableStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#table_indexed_by_part}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable_indexed_by_part(OracleSQLStatementParser.Table_indexed_by_partContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_call(OracleSQLStatementParser.Function_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#sqlStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSqlStatement(OracleSQLStatementParser.SqlStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#execute_immediate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExecute_immediate(OracleSQLStatementParser.Execute_immediateContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#cursor_manipulation_statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCursor_manipulation_statements(OracleSQLStatementParser.Cursor_manipulation_statementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#callStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallStatement(OracleSQLStatementParser.CallStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#explainStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExplainStatement(OracleSQLStatementParser.ExplainStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#insertStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsertStatement(OracleSQLStatementParser.InsertStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#multiInsertStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiInsertStatement(OracleSQLStatementParser.MultiInsertStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#iValueClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIValueClause(OracleSQLStatementParser.IValueClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#multiInsertClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiInsertClause(OracleSQLStatementParser.MultiInsertClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#multiInsertIntoClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiInsertIntoClause(OracleSQLStatementParser.MultiInsertIntoClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#multiConditionalInsertIntoClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiConditionalInsertIntoClause(OracleSQLStatementParser.MultiConditionalInsertIntoClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#multiInsertIntoClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiInsertIntoClauseItem(OracleSQLStatementParser.MultiInsertIntoClauseItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#multiConditionalInsertWhenClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiConditionalInsertWhenClause(OracleSQLStatementParser.MultiConditionalInsertWhenClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#valuesClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValuesClause(OracleSQLStatementParser.ValuesClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#valuesClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValuesClauseItem(OracleSQLStatementParser.ValuesClauseItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#mergeStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMergeStatement(OracleSQLStatementParser.MergeStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#merge_update_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMerge_update_clause(OracleSQLStatementParser.Merge_update_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#merge_element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMerge_element(OracleSQLStatementParser.Merge_elementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#merge_update_delete_part}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMerge_update_delete_part(OracleSQLStatementParser.Merge_update_delete_partContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#merge_insert_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMerge_insert_clause(OracleSQLStatementParser.Merge_insert_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#selected_tableview}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelected_tableview(OracleSQLStatementParser.Selected_tableviewContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#lockTableStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLockTableStatement(OracleSQLStatementParser.LockTableStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#lockTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLockTableItem(OracleSQLStatementParser.LockTableItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#lockMode}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLockMode(OracleSQLStatementParser.LockModeContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#deleteStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeleteStatement(OracleSQLStatementParser.DeleteStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#selectStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectStatement(OracleSQLStatementParser.SelectStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#iSelectQuery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitISelectQuery(OracleSQLStatementParser.ISelectQueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#selectQueryBasic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectQueryBasic(OracleSQLStatementParser.SelectQueryBasicContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#selectQuery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectQuery(OracleSQLStatementParser.SelectQueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#selectParenQuery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectParenQuery(OracleSQLStatementParser.SelectParenQueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#selectUnionQuery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectUnionQuery(OracleSQLStatementParser.SelectUnionQueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#setQuantifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetQuantifier(OracleSQLStatementParser.SetQuantifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#unionOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnionOperator(OracleSQLStatementParser.UnionOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#withClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithClause(OracleSQLStatementParser.WithClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#plsqlDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlsqlDeclaration(OracleSQLStatementParser.PlsqlDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#withElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithElement(OracleSQLStatementParser.WithElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#subQueryFactoringClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubQueryFactoringClause(OracleSQLStatementParser.SubQueryFactoringClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#searchClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSearchClause(OracleSQLStatementParser.SearchClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#cycleClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCycleClause(OracleSQLStatementParser.CycleClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#subAvFactoringClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubAvFactoringClause(OracleSQLStatementParser.SubAvFactoringClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#subAvClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubAvClause(OracleSQLStatementParser.SubAvClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#hierarchiesClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHierarchiesClause(OracleSQLStatementParser.HierarchiesClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#subAvClauseFilterClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubAvClauseFilterClause(OracleSQLStatementParser.SubAvClauseFilterClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#calcMeasClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCalcMeasClause(OracleSQLStatementParser.CalcMeasClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#selectItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectItem(OracleSQLStatementParser.SelectItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#selectItemAlias}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectItemAlias(OracleSQLStatementParser.SelectItemAliasContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#fromClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFromClause(OracleSQLStatementParser.FromClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#iTableReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitITableReference(OracleSQLStatementParser.ITableReferenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code objectNameTableReference}
	 * labeled alternative in {@link OracleSQLStatementParser#tableReferenceBasic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectNameTableReference(OracleSQLStatementParser.ObjectNameTableReferenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lateralSubQueryTableReference}
	 * labeled alternative in {@link OracleSQLStatementParser#tableReferenceBasic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLateralSubQueryTableReference(OracleSQLStatementParser.LateralSubQueryTableReferenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tableFunctionTableReference}
	 * labeled alternative in {@link OracleSQLStatementParser#tableReferenceBasic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableFunctionTableReference(OracleSQLStatementParser.TableFunctionTableReferenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code containersFunctionTableReference}
	 * labeled alternative in {@link OracleSQLStatementParser#tableReferenceBasic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContainersFunctionTableReference(OracleSQLStatementParser.ContainersFunctionTableReferenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code shardsFunctionTableReference}
	 * labeled alternative in {@link OracleSQLStatementParser#tableReferenceBasic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShardsFunctionTableReference(OracleSQLStatementParser.ShardsFunctionTableReferenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inlineAnalyticViewTableReference}
	 * labeled alternative in {@link OracleSQLStatementParser#tableReferenceBasic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInlineAnalyticViewTableReference(OracleSQLStatementParser.InlineAnalyticViewTableReferenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenJoinTableReference}
	 * labeled alternative in {@link OracleSQLStatementParser#tableReferenceBasic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenJoinTableReference(OracleSQLStatementParser.ParenJoinTableReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#joinTableReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoinTableReference(OracleSQLStatementParser.JoinTableReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#objectNameTableReferenceOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectNameTableReferenceOption(OracleSQLStatementParser.ObjectNameTableReferenceOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#joinType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoinType(OracleSQLStatementParser.JoinTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#rightJoinClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRightJoinClause(OracleSQLStatementParser.RightJoinClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code joinCondition}
	 * labeled alternative in {@link OracleSQLStatementParser#joinSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoinCondition(OracleSQLStatementParser.JoinConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code namedColumnsJoin}
	 * labeled alternative in {@link OracleSQLStatementParser#joinSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNamedColumnsJoin(OracleSQLStatementParser.NamedColumnsJoinContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#locationClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocationClause(OracleSQLStatementParser.LocationClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#locationClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocationClauseItem(OracleSQLStatementParser.LocationClauseItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#modifiedExternalTableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModifiedExternalTableClause(OracleSQLStatementParser.ModifiedExternalTableClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code flashbackQueryByVersionsBetweenClause}
	 * labeled alternative in {@link OracleSQLStatementParser#flashbackQueryClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlashbackQueryByVersionsBetweenClause(OracleSQLStatementParser.FlashbackQueryByVersionsBetweenClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code flashbackQueryByVersionsPeriodForClause}
	 * labeled alternative in {@link OracleSQLStatementParser#flashbackQueryClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlashbackQueryByVersionsPeriodForClause(OracleSQLStatementParser.FlashbackQueryByVersionsPeriodForClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code flashbackQueryByAsOfClause}
	 * labeled alternative in {@link OracleSQLStatementParser#flashbackQueryClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlashbackQueryByAsOfClause(OracleSQLStatementParser.FlashbackQueryByAsOfClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code flashbackQueryByAsOfPeriodForClause}
	 * labeled alternative in {@link OracleSQLStatementParser#flashbackQueryClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlashbackQueryByAsOfPeriodForClause(OracleSQLStatementParser.FlashbackQueryByAsOfPeriodForClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#inlineExternalTable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInlineExternalTable(OracleSQLStatementParser.InlineExternalTableContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#iPivotClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIPivotClause(OracleSQLStatementParser.IPivotClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#pivotClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPivotClause(OracleSQLStatementParser.PivotClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#pivotItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPivotItem(OracleSQLStatementParser.PivotItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#unpivotClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnpivotClause(OracleSQLStatementParser.UnpivotClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#sampleClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSampleClause(OracleSQLStatementParser.SampleClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code partitionClause}
	 * labeled alternative in {@link OracleSQLStatementParser#iPartitionClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionClause(OracleSQLStatementParser.PartitionClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code partitionForClause}
	 * labeled alternative in {@link OracleSQLStatementParser#iPartitionClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionForClause(OracleSQLStatementParser.PartitionForClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code subPartitionClause}
	 * labeled alternative in {@link OracleSQLStatementParser#iPartitionClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubPartitionClause(OracleSQLStatementParser.SubPartitionClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code subPartitionForClause}
	 * labeled alternative in {@link OracleSQLStatementParser#iPartitionClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubPartitionForClause(OracleSQLStatementParser.SubPartitionForClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code withReadOnly}
	 * labeled alternative in {@link OracleSQLStatementParser#iSubQueryRestrictionClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithReadOnly(OracleSQLStatementParser.WithReadOnlyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code withCheckOption}
	 * labeled alternative in {@link OracleSQLStatementParser#iSubQueryRestrictionClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithCheckOption(OracleSQLStatementParser.WithCheckOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#whereClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhereClause(OracleSQLStatementParser.WhereClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#currentOfClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCurrentOfClause(OracleSQLStatementParser.CurrentOfClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code hierarchicalQueryConnectByToStartWithClause}
	 * labeled alternative in {@link OracleSQLStatementParser#hierarchicalQueryClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHierarchicalQueryConnectByToStartWithClause(OracleSQLStatementParser.HierarchicalQueryConnectByToStartWithClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code hierarchicalQueryStartWithToConnectByClause}
	 * labeled alternative in {@link OracleSQLStatementParser#hierarchicalQueryClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHierarchicalQueryStartWithToConnectByClause(OracleSQLStatementParser.HierarchicalQueryStartWithToConnectByClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code groupByHavingClause}
	 * labeled alternative in {@link OracleSQLStatementParser#groupByClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroupByHavingClause(OracleSQLStatementParser.GroupByHavingClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code havingGroupByClause}
	 * labeled alternative in {@link OracleSQLStatementParser#groupByClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHavingGroupByClause(OracleSQLStatementParser.HavingGroupByClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#havingClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHavingClause(OracleSQLStatementParser.HavingClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#groupByItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroupByItem(OracleSQLStatementParser.GroupByItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#rollupCubeClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRollupCubeClause(OracleSQLStatementParser.RollupCubeClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#groupingSetsClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroupingSetsClause(OracleSQLStatementParser.GroupingSetsClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#groupingSetsClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroupingSetsClauseItem(OracleSQLStatementParser.GroupingSetsClauseItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#modelClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModelClause(OracleSQLStatementParser.ModelClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#cellReferenceOptions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCellReferenceOptions(OracleSQLStatementParser.CellReferenceOptionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#returnRowsClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnRowsClause(OracleSQLStatementParser.ReturnRowsClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#referenceModel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReferenceModel(OracleSQLStatementParser.ReferenceModelContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#mainModel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMainModel(OracleSQLStatementParser.MainModelContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#modelColumnClauses}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModelColumnClauses(OracleSQLStatementParser.ModelColumnClausesContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#modelColumnClausesItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModelColumnClausesItem(OracleSQLStatementParser.ModelColumnClausesItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#modelRulesClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModelRulesClause(OracleSQLStatementParser.ModelRulesClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#modelRulesClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModelRulesClauseItem(OracleSQLStatementParser.ModelRulesClauseItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#modelIterateClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModelIterateClause(OracleSQLStatementParser.ModelIterateClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#cellAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCellAssignment(OracleSQLStatementParser.CellAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#cellAssignmentItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCellAssignmentItem(OracleSQLStatementParser.CellAssignmentItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#singleColumnForLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleColumnForLoop(OracleSQLStatementParser.SingleColumnForLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#multiColumnForLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiColumnForLoop(OracleSQLStatementParser.MultiColumnForLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#orderByClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrderByClause(OracleSQLStatementParser.OrderByClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#orderByItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrderByItem(OracleSQLStatementParser.OrderByItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#rowLimitingClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowLimitingClause(OracleSQLStatementParser.RowLimitingClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#forUpdateClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForUpdateClause(OracleSQLStatementParser.ForUpdateClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forUpdateSkipLockedOption}
	 * labeled alternative in {@link OracleSQLStatementParser#forUpdateOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForUpdateSkipLockedOption(OracleSQLStatementParser.ForUpdateSkipLockedOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forUpdateNoWaitOption}
	 * labeled alternative in {@link OracleSQLStatementParser#forUpdateOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForUpdateNoWaitOption(OracleSQLStatementParser.ForUpdateNoWaitOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forUpdateWaitOption}
	 * labeled alternative in {@link OracleSQLStatementParser#forUpdateOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForUpdateWaitOption(OracleSQLStatementParser.ForUpdateWaitOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#rowPatternClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowPatternClause(OracleSQLStatementParser.RowPatternClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#rowPatternRowsPerMatch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowPatternRowsPerMatch(OracleSQLStatementParser.RowPatternRowsPerMatchContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rowPatternSkipToNextRow}
	 * labeled alternative in {@link OracleSQLStatementParser#rowPatternSkipTo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowPatternSkipToNextRow(OracleSQLStatementParser.RowPatternSkipToNextRowContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rowPatternSkipPastLastRow}
	 * labeled alternative in {@link OracleSQLStatementParser#rowPatternSkipTo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowPatternSkipPastLastRow(OracleSQLStatementParser.RowPatternSkipPastLastRowContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rowPatternSkipToFirstVar}
	 * labeled alternative in {@link OracleSQLStatementParser#rowPatternSkipTo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowPatternSkipToFirstVar(OracleSQLStatementParser.RowPatternSkipToFirstVarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rowPatternSkipToLastVart}
	 * labeled alternative in {@link OracleSQLStatementParser#rowPatternSkipTo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowPatternSkipToLastVart(OracleSQLStatementParser.RowPatternSkipToLastVartContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rowPatternSkipToVar}
	 * labeled alternative in {@link OracleSQLStatementParser#rowPatternSkipTo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowPatternSkipToVar(OracleSQLStatementParser.RowPatternSkipToVarContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#rowPattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowPattern(OracleSQLStatementParser.RowPatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#rowPatternTerm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowPatternTerm(OracleSQLStatementParser.RowPatternTermContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#rowPatternFactor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowPatternFactor(OracleSQLStatementParser.RowPatternFactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#rowPatternPrimary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowPatternPrimary(OracleSQLStatementParser.RowPatternPrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#rowPatternPermute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowPatternPermute(OracleSQLStatementParser.RowPatternPermuteContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#rowPatternQuantifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowPatternQuantifier(OracleSQLStatementParser.RowPatternQuantifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#rowPatternSubsetClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowPatternSubsetClause(OracleSQLStatementParser.RowPatternSubsetClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#row_pattern_subset_item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRow_pattern_subset_item(OracleSQLStatementParser.Row_pattern_subset_itemContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#row_pattern_rec_func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRow_pattern_rec_func(OracleSQLStatementParser.Row_pattern_rec_funcContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#row_pattern_classifier_func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRow_pattern_classifier_func(OracleSQLStatementParser.Row_pattern_classifier_funcContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#row_pattern_match_num_func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRow_pattern_match_num_func(OracleSQLStatementParser.Row_pattern_match_num_funcContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#row_pattern_navigation_func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRow_pattern_navigation_func(OracleSQLStatementParser.Row_pattern_navigation_funcContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#rowPatternNavLogical}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowPatternNavLogical(OracleSQLStatementParser.RowPatternNavLogicalContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#rowPatternNavPhysical}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowPatternNavPhysical(OracleSQLStatementParser.RowPatternNavPhysicalContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#rowPatternNavCompound}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowPatternNavCompound(OracleSQLStatementParser.RowPatternNavCompoundContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#rowPatternAggregateFunc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowPatternAggregateFunc(OracleSQLStatementParser.RowPatternAggregateFuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#updateStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdateStatement(OracleSQLStatementParser.UpdateStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code updateSetClause}
	 * labeled alternative in {@link OracleSQLStatementParser#iUpdateSetClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdateSetClause(OracleSQLStatementParser.UpdateSetClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code updateSetByValueClause}
	 * labeled alternative in {@link OracleSQLStatementParser#iUpdateSetClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdateSetByValueClause(OracleSQLStatementParser.UpdateSetByValueClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#updateSetItemClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdateSetItemClause(OracleSQLStatementParser.UpdateSetItemClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#commitStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommitStatement(OracleSQLStatementParser.CommitStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#commitStatementOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommitStatementOption(OracleSQLStatementParser.CommitStatementOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#commitStatementCommentOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommitStatementCommentOption(OracleSQLStatementParser.CommitStatementCommentOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#commitStatementWriteOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommitStatementWriteOption(OracleSQLStatementParser.CommitStatementWriteOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#commitStatementForceOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommitStatementForceOption(OracleSQLStatementParser.CommitStatementForceOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#rollbackStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRollbackStatement(OracleSQLStatementParser.RollbackStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#rollbackStatementOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRollbackStatementOption(OracleSQLStatementParser.RollbackStatementOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#rollbackStatementToSavepointOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRollbackStatementToSavepointOption(OracleSQLStatementParser.RollbackStatementToSavepointOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#rollbackStatementForceOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRollbackStatementForceOption(OracleSQLStatementParser.RollbackStatementForceOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#savepointStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSavepointStatement(OracleSQLStatementParser.SavepointStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#setTransactionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetTransactionStatement(OracleSQLStatementParser.SetTransactionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#setTransactionStatementOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetTransactionStatementOption(OracleSQLStatementParser.SetTransactionStatementOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#setTransactionStatementReadOnlyOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetTransactionStatementReadOnlyOption(OracleSQLStatementParser.SetTransactionStatementReadOnlyOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#setTransactionStatementReadWriteOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetTransactionStatementReadWriteOption(OracleSQLStatementParser.SetTransactionStatementReadWriteOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#setTransactionStatementIsolationLevelOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetTransactionStatementIsolationLevelOption(OracleSQLStatementParser.SetTransactionStatementIsolationLevelOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#setTransactionStatementUseRollbackSegmentOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetTransactionStatementUseRollbackSegmentOption(OracleSQLStatementParser.SetTransactionStatementUseRollbackSegmentOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#setTransactionStatementNameOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetTransactionStatementNameOption(OracleSQLStatementParser.SetTransactionStatementNameOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#setConstraintStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetConstraintStatement(OracleSQLStatementParser.SetConstraintStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#setConstraintsStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetConstraintsStatement(OracleSQLStatementParser.SetConstraintsStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#alterSessionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterSessionStatement(OracleSQLStatementParser.AlterSessionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#setRoleStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetRoleStatement(OracleSQLStatementParser.SetRoleStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#whenever_command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhenever_command(OracleSQLStatementParser.Whenever_commandContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#set_command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSet_command(OracleSQLStatementParser.Set_commandContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#exit_command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExit_command(OracleSQLStatementParser.Exit_commandContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#prompt_command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrompt_command(OracleSQLStatementParser.Prompt_commandContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#show_errors_command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShow_errors_command(OracleSQLStatementParser.Show_errors_commandContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#start_command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart_command(OracleSQLStatementParser.Start_commandContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#native_datatype_element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNative_datatype_element(OracleSQLStatementParser.Native_datatype_elementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#allTokens}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAllTokens(OracleSQLStatementParser.AllTokensContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataType(OracleSQLStatementParser.DataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code charDataType}
	 * labeled alternative in {@link OracleSQLStatementParser#iCharacterDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharDataType(OracleSQLStatementParser.CharDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varchar2DataType}
	 * labeled alternative in {@link OracleSQLStatementParser#iCharacterDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarchar2DataType(OracleSQLStatementParser.Varchar2DataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ncharDataType}
	 * labeled alternative in {@link OracleSQLStatementParser#iCharacterDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNcharDataType(OracleSQLStatementParser.NcharDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nvarchar2DataType}
	 * labeled alternative in {@link OracleSQLStatementParser#iCharacterDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNvarchar2DataType(OracleSQLStatementParser.Nvarchar2DataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numberDataType}
	 * labeled alternative in {@link OracleSQLStatementParser#iNumericDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberDataType(OracleSQLStatementParser.NumberDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code floatDataType}
	 * labeled alternative in {@link OracleSQLStatementParser#iNumericDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatDataType(OracleSQLStatementParser.FloatDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryFloatDataType}
	 * labeled alternative in {@link OracleSQLStatementParser#iNumericDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryFloatDataType(OracleSQLStatementParser.BinaryFloatDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryDoubleDataType}
	 * labeled alternative in {@link OracleSQLStatementParser#iNumericDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryDoubleDataType(OracleSQLStatementParser.BinaryDoubleDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code longDataType}
	 * labeled alternative in {@link OracleSQLStatementParser#longAndRawDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLongDataType(OracleSQLStatementParser.LongDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code longRawDataType}
	 * labeled alternative in {@link OracleSQLStatementParser#longAndRawDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLongRawDataType(OracleSQLStatementParser.LongRawDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rawDataType}
	 * labeled alternative in {@link OracleSQLStatementParser#longAndRawDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRawDataType(OracleSQLStatementParser.RawDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dateDataType}
	 * labeled alternative in {@link OracleSQLStatementParser#dateTimeDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDateDataType(OracleSQLStatementParser.DateDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code timestampDataType}
	 * labeled alternative in {@link OracleSQLStatementParser#dateTimeDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimestampDataType(OracleSQLStatementParser.TimestampDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intervalDataType}
	 * labeled alternative in {@link OracleSQLStatementParser#dateTimeDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntervalDataType(OracleSQLStatementParser.IntervalDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code blobDataType}
	 * labeled alternative in {@link OracleSQLStatementParser#largeObjectDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlobDataType(OracleSQLStatementParser.BlobDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code clobDataType}
	 * labeled alternative in {@link OracleSQLStatementParser#largeObjectDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClobDataType(OracleSQLStatementParser.ClobDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nclobDataType}
	 * labeled alternative in {@link OracleSQLStatementParser#largeObjectDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNclobDataType(OracleSQLStatementParser.NclobDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bfileDataType}
	 * labeled alternative in {@link OracleSQLStatementParser#largeObjectDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBfileDataType(OracleSQLStatementParser.BfileDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rowidDataType}
	 * labeled alternative in {@link OracleSQLStatementParser#iRowidDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowidDataType(OracleSQLStatementParser.RowidDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code urowidDataType}
	 * labeled alternative in {@link OracleSQLStatementParser#iRowidDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUrowidDataType(OracleSQLStatementParser.UrowidDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#booleanDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanDataType(OracleSQLStatementParser.BooleanDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code characterDataType}
	 * labeled alternative in {@link OracleSQLStatementParser#ansiSupportedDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharacterDataType(OracleSQLStatementParser.CharacterDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code characterVaryingDataType}
	 * labeled alternative in {@link OracleSQLStatementParser#ansiSupportedDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharacterVaryingDataType(OracleSQLStatementParser.CharacterVaryingDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code charVaryingDataType}
	 * labeled alternative in {@link OracleSQLStatementParser#ansiSupportedDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharVaryingDataType(OracleSQLStatementParser.CharVaryingDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ncharVaryingDataType}
	 * labeled alternative in {@link OracleSQLStatementParser#ansiSupportedDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNcharVaryingDataType(OracleSQLStatementParser.NcharVaryingDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varcharDataType}
	 * labeled alternative in {@link OracleSQLStatementParser#ansiSupportedDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarcharDataType(OracleSQLStatementParser.VarcharDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nationalCharacterDataType}
	 * labeled alternative in {@link OracleSQLStatementParser#ansiSupportedDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNationalCharacterDataType(OracleSQLStatementParser.NationalCharacterDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nationalCharDataType}
	 * labeled alternative in {@link OracleSQLStatementParser#ansiSupportedDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNationalCharDataType(OracleSQLStatementParser.NationalCharDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nationalCharacterVaryingDataType}
	 * labeled alternative in {@link OracleSQLStatementParser#ansiSupportedDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNationalCharacterVaryingDataType(OracleSQLStatementParser.NationalCharacterVaryingDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nationalCharVaryingDataType}
	 * labeled alternative in {@link OracleSQLStatementParser#ansiSupportedDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNationalCharVaryingDataType(OracleSQLStatementParser.NationalCharVaryingDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numericDataType}
	 * labeled alternative in {@link OracleSQLStatementParser#ansiSupportedDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumericDataType(OracleSQLStatementParser.NumericDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code decimalDataType}
	 * labeled alternative in {@link OracleSQLStatementParser#ansiSupportedDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecimalDataType(OracleSQLStatementParser.DecimalDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code decDataType}
	 * labeled alternative in {@link OracleSQLStatementParser#ansiSupportedDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecDataType(OracleSQLStatementParser.DecDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code integerDataType}
	 * labeled alternative in {@link OracleSQLStatementParser#ansiSupportedDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerDataType(OracleSQLStatementParser.IntegerDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intDataType}
	 * labeled alternative in {@link OracleSQLStatementParser#ansiSupportedDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntDataType(OracleSQLStatementParser.IntDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code smallintDataType}
	 * labeled alternative in {@link OracleSQLStatementParser#ansiSupportedDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSmallintDataType(OracleSQLStatementParser.SmallintDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code doublePrecisionDataType}
	 * labeled alternative in {@link OracleSQLStatementParser#ansiSupportedDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoublePrecisionDataType(OracleSQLStatementParser.DoublePrecisionDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code realDataType}
	 * labeled alternative in {@link OracleSQLStatementParser#ansiSupportedDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRealDataType(OracleSQLStatementParser.RealDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code anyDataDataType}
	 * labeled alternative in {@link OracleSQLStatementParser#anyDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnyDataDataType(OracleSQLStatementParser.AnyDataDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code anyTypeDataType}
	 * labeled alternative in {@link OracleSQLStatementParser#anyDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnyTypeDataType(OracleSQLStatementParser.AnyTypeDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code anyDataSetDataType}
	 * labeled alternative in {@link OracleSQLStatementParser#anyDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnyDataSetDataType(OracleSQLStatementParser.AnyDataSetDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code xmlTypeDataType}
	 * labeled alternative in {@link OracleSQLStatementParser#xmlDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlTypeDataType(OracleSQLStatementParser.XmlTypeDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code uriTypeDataType}
	 * labeled alternative in {@link OracleSQLStatementParser#xmlDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUriTypeDataType(OracleSQLStatementParser.UriTypeDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jsonDataType}
	 * labeled alternative in {@link OracleSQLStatementParser#iJsonDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonDataType(OracleSQLStatementParser.JsonDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sdoGeometryDataType}
	 * labeled alternative in {@link OracleSQLStatementParser#spatialDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSdoGeometryDataType(OracleSQLStatementParser.SdoGeometryDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sdoTopoGeometryDataType}
	 * labeled alternative in {@link OracleSQLStatementParser#spatialDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSdoTopoGeometryDataType(OracleSQLStatementParser.SdoTopoGeometryDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sdoGeorasterDataType}
	 * labeled alternative in {@link OracleSQLStatementParser#spatialDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSdoGeorasterDataType(OracleSQLStatementParser.SdoGeorasterDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code oRDAUDIODataType}
	 * labeled alternative in {@link OracleSQLStatementParser#mediaDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitORDAUDIODataType(OracleSQLStatementParser.ORDAUDIODataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code oRDIMAGEDataType}
	 * labeled alternative in {@link OracleSQLStatementParser#mediaDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitORDIMAGEDataType(OracleSQLStatementParser.ORDIMAGEDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code oRDVIDEODataType}
	 * labeled alternative in {@link OracleSQLStatementParser#mediaDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitORDVIDEODataType(OracleSQLStatementParser.ORDVIDEODataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code oRDDOCDataType}
	 * labeled alternative in {@link OracleSQLStatementParser#mediaDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitORDDOCDataType(OracleSQLStatementParser.ORDDOCDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code oRDDICOMDataType}
	 * labeled alternative in {@link OracleSQLStatementParser#mediaDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitORDDICOMDataType(OracleSQLStatementParser.ORDDICOMDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code siStillimageDataType}
	 * labeled alternative in {@link OracleSQLStatementParser#mediaDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSiStillimageDataType(OracleSQLStatementParser.SiStillimageDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code siAveragecolorDataType}
	 * labeled alternative in {@link OracleSQLStatementParser#mediaDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSiAveragecolorDataType(OracleSQLStatementParser.SiAveragecolorDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code siPositionalcolorDataType}
	 * labeled alternative in {@link OracleSQLStatementParser#mediaDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSiPositionalcolorDataType(OracleSQLStatementParser.SiPositionalcolorDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code siColorhistogramDataType}
	 * labeled alternative in {@link OracleSQLStatementParser#mediaDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSiColorhistogramDataType(OracleSQLStatementParser.SiColorhistogramDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code siTextureDataType}
	 * labeled alternative in {@link OracleSQLStatementParser#mediaDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSiTextureDataType(OracleSQLStatementParser.SiTextureDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code siFeaturelistDataType}
	 * labeled alternative in {@link OracleSQLStatementParser#mediaDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSiFeaturelistDataType(OracleSQLStatementParser.SiFeaturelistDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code siColorDataType}
	 * labeled alternative in {@link OracleSQLStatementParser#mediaDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSiColorDataType(OracleSQLStatementParser.SiColorDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#plsIntegerDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlsIntegerDataType(OracleSQLStatementParser.PlsIntegerDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#naturalDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNaturalDataType(OracleSQLStatementParser.NaturalDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#naturalnDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNaturalnDataType(OracleSQLStatementParser.NaturalnDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#positiveDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPositiveDataType(OracleSQLStatementParser.PositiveDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#positivenDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPositivenDataType(OracleSQLStatementParser.PositivenDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#signtypeDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSigntypeDataType(OracleSQLStatementParser.SigntypeDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#simpleIntegerDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleIntegerDataType(OracleSQLStatementParser.SimpleIntegerDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#binaryIntegerDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryIntegerDataType(OracleSQLStatementParser.BinaryIntegerDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#collectionDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCollectionDataType(OracleSQLStatementParser.CollectionDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#refDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRefDataType(OracleSQLStatementParser.RefDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#otherDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOtherDataType(OracleSQLStatementParser.OtherDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#refCursorDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRefCursorDataType(OracleSQLStatementParser.RefCursorDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#typeDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDataType(OracleSQLStatementParser.TypeDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#rowtypeDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowtypeDataType(OracleSQLStatementParser.RowtypeDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#assocArrayDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssocArrayDataType(OracleSQLStatementParser.AssocArrayDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#varrayDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarrayDataType(OracleSQLStatementParser.VarrayDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#varyingArrayDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVaryingArrayDataType(OracleSQLStatementParser.VaryingArrayDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#nestedTableDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNestedTableDataType(OracleSQLStatementParser.NestedTableDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#objectSubDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectSubDataType(OracleSQLStatementParser.ObjectSubDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#objectDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectDataType(OracleSQLStatementParser.ObjectDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#selfAsResultDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelfAsResultDataType(OracleSQLStatementParser.SelfAsResultDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code asteriskIdentifier}
	 * labeled alternative in {@link OracleSQLStatementParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsteriskIdentifier(OracleSQLStatementParser.AsteriskIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code normalIdentifier}
	 * labeled alternative in {@link OracleSQLStatementParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalIdentifier(OracleSQLStatementParser.NormalIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code doubleQuoteIdentifier}
	 * labeled alternative in {@link OracleSQLStatementParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleQuoteIdentifier(OracleSQLStatementParser.DoubleQuoteIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code identifier1}
	 * labeled alternative in {@link OracleSQLStatementParser#nameIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier1(OracleSQLStatementParser.Identifier1Context ctx);
	/**
	 * Visit a parse tree produced by the {@code propertyIdentifier1}
	 * labeled alternative in {@link OracleSQLStatementParser#nameIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertyIdentifier1(OracleSQLStatementParser.PropertyIdentifier1Context ctx);
	/**
	 * Visit a parse tree produced by the {@code dbLinkNameIdentifier}
	 * labeled alternative in {@link OracleSQLStatementParser#nameIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDbLinkNameIdentifier(OracleSQLStatementParser.DbLinkNameIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dateLiteral}
	 * labeled alternative in {@link OracleSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDateLiteral(OracleSQLStatementParser.DateLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code timestampLiteral}
	 * labeled alternative in {@link OracleSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimestampLiteral(OracleSQLStatementParser.TimestampLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intervalLiteral}
	 * labeled alternative in {@link OracleSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntervalLiteral(OracleSQLStatementParser.IntervalLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nQCharLiteral}
	 * labeled alternative in {@link OracleSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNQCharLiteral(OracleSQLStatementParser.NQCharLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nCharLiteral}
	 * labeled alternative in {@link OracleSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNCharLiteral(OracleSQLStatementParser.NCharLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code qCharLiteral}
	 * labeled alternative in {@link OracleSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQCharLiteral(OracleSQLStatementParser.QCharLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code charLiteral}
	 * labeled alternative in {@link OracleSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharLiteral(OracleSQLStatementParser.CharLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code integerLiteral}
	 * labeled alternative in {@link OracleSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerLiteral(OracleSQLStatementParser.IntegerLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numberLiteral}
	 * labeled alternative in {@link OracleSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberLiteral(OracleSQLStatementParser.NumberLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryFloatLiteral}
	 * labeled alternative in {@link OracleSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryFloatLiteral(OracleSQLStatementParser.BinaryFloatLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryDoubleLiteral}
	 * labeled alternative in {@link OracleSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryDoubleLiteral(OracleSQLStatementParser.BinaryDoubleLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code defaultLiteral}
	 * labeled alternative in {@link OracleSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultLiteral(OracleSQLStatementParser.DefaultLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code anyLiteral}
	 * labeled alternative in {@link OracleSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnyLiteral(OracleSQLStatementParser.AnyLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code minValueLiteral}
	 * labeled alternative in {@link OracleSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinValueLiteral(OracleSQLStatementParser.MinValueLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code maxValueLiteral}
	 * labeled alternative in {@link OracleSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMaxValueLiteral(OracleSQLStatementParser.MaxValueLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unlimitedLiteral}
	 * labeled alternative in {@link OracleSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnlimitedLiteral(OracleSQLStatementParser.UnlimitedLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code falseLiteral}
	 * labeled alternative in {@link OracleSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalseLiteral(OracleSQLStatementParser.FalseLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code trueLiteral}
	 * labeled alternative in {@link OracleSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueLiteral(OracleSQLStatementParser.TrueLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code columnValueExpr}
	 * labeled alternative in {@link OracleSQLStatementParser#pseudoColumn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnValueExpr(OracleSQLStatementParser.ColumnValueExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code connectByIsCycleExpr}
	 * labeled alternative in {@link OracleSQLStatementParser#pseudoColumn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConnectByIsCycleExpr(OracleSQLStatementParser.ConnectByIsCycleExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code connectByIsLeafExpr}
	 * labeled alternative in {@link OracleSQLStatementParser#pseudoColumn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConnectByIsLeafExpr(OracleSQLStatementParser.ConnectByIsLeafExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code levelExpr}
	 * labeled alternative in {@link OracleSQLStatementParser#pseudoColumn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLevelExpr(OracleSQLStatementParser.LevelExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code objectIdExpr}
	 * labeled alternative in {@link OracleSQLStatementParser#pseudoColumn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectIdExpr(OracleSQLStatementParser.ObjectIdExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code objectValueExpr}
	 * labeled alternative in {@link OracleSQLStatementParser#pseudoColumn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectValueExpr(OracleSQLStatementParser.ObjectValueExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code oraRowScnExpr}
	 * labeled alternative in {@link OracleSQLStatementParser#pseudoColumn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOraRowScnExpr(OracleSQLStatementParser.OraRowScnExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rowNumExpr}
	 * labeled alternative in {@link OracleSQLStatementParser#pseudoColumn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowNumExpr(OracleSQLStatementParser.RowNumExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rowIdExpr}
	 * labeled alternative in {@link OracleSQLStatementParser#pseudoColumn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowIdExpr(OracleSQLStatementParser.RowIdExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sequenceExpr}
	 * labeled alternative in {@link OracleSQLStatementParser#pseudoColumn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSequenceExpr(OracleSQLStatementParser.SequenceExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code versionsEndScnExpr}
	 * labeled alternative in {@link OracleSQLStatementParser#pseudoColumn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVersionsEndScnExpr(OracleSQLStatementParser.VersionsEndScnExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code versionsEndTimeExpr}
	 * labeled alternative in {@link OracleSQLStatementParser#pseudoColumn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVersionsEndTimeExpr(OracleSQLStatementParser.VersionsEndTimeExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code versionsOperationExpr}
	 * labeled alternative in {@link OracleSQLStatementParser#pseudoColumn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVersionsOperationExpr(OracleSQLStatementParser.VersionsOperationExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code versionsStartScnExpr}
	 * labeled alternative in {@link OracleSQLStatementParser#pseudoColumn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVersionsStartScnExpr(OracleSQLStatementParser.VersionsStartScnExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code versionsStartTimeExpr}
	 * labeled alternative in {@link OracleSQLStatementParser#pseudoColumn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVersionsStartTimeExpr(OracleSQLStatementParser.VersionsStartTimeExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code versionsXidExpr}
	 * labeled alternative in {@link OracleSQLStatementParser#pseudoColumn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVersionsXidExpr(OracleSQLStatementParser.VersionsXidExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code xmlDataExpr}
	 * labeled alternative in {@link OracleSQLStatementParser#pseudoColumn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlDataExpr(OracleSQLStatementParser.XmlDataExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#unaryOperatorExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryOperatorExpr(OracleSQLStatementParser.UnaryOperatorExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#unaryOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryOperator(OracleSQLStatementParser.UnaryOperatorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multisetExceptOperatorExpr}
	 * labeled alternative in {@link OracleSQLStatementParser#multisetOperatorExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultisetExceptOperatorExpr(OracleSQLStatementParser.MultisetExceptOperatorExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multisetIntersectOperatorExpr}
	 * labeled alternative in {@link OracleSQLStatementParser#multisetOperatorExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultisetIntersectOperatorExpr(OracleSQLStatementParser.MultisetIntersectOperatorExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multisetUnionOperatorExpr}
	 * labeled alternative in {@link OracleSQLStatementParser#multisetOperatorExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultisetUnionOperatorExpr(OracleSQLStatementParser.MultisetUnionOperatorExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#variableExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableExpr(OracleSQLStatementParser.VariableExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#bindVariableExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBindVariableExpr(OracleSQLStatementParser.BindVariableExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#newVariableRefExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewVariableRefExpr(OracleSQLStatementParser.NewVariableRefExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#oldVariableRefExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOldVariableRefExpr(OracleSQLStatementParser.OldVariableRefExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#caseExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseExpr(OracleSQLStatementParser.CaseExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#caseExprWhenItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseExprWhenItem(OracleSQLStatementParser.CaseExprWhenItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#caseExprElseClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseExprElseClause(OracleSQLStatementParser.CaseExprElseClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#intervalExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntervalExpr(OracleSQLStatementParser.IntervalExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#placeholderExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlaceholderExpr(OracleSQLStatementParser.PlaceholderExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#typeConstructorExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeConstructorExpr(OracleSQLStatementParser.TypeConstructorExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#listExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListExpr(OracleSQLStatementParser.ListExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#exprBasic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprBasic(OracleSQLStatementParser.ExprBasicContext ctx);
	/**
	 * Visit a parse tree produced by the {@code literal2}
	 * labeled alternative in {@link OracleSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral2(OracleSQLStatementParser.Literal2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code inCondition}
	 * labeled alternative in {@link OracleSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInCondition(OracleSQLStatementParser.InConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nullExpr}
	 * labeled alternative in {@link OracleSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullExpr(OracleSQLStatementParser.NullExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code isNullCondition}
	 * labeled alternative in {@link OracleSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsNullCondition(OracleSQLStatementParser.IsNullConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code iCondition}
	 * labeled alternative in {@link OracleSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitICondition(OracleSQLStatementParser.IConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code callArgumentExpr}
	 * labeled alternative in {@link OracleSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallArgumentExpr(OracleSQLStatementParser.CallArgumentExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryOperatorExpr}
	 * labeled alternative in {@link OracleSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryOperatorExpr(OracleSQLStatementParser.BinaryOperatorExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code likeCondition}
	 * labeled alternative in {@link OracleSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLikeCondition(OracleSQLStatementParser.LikeConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code propertyIdentifier2}
	 * labeled alternative in {@link OracleSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertyIdentifier2(OracleSQLStatementParser.PropertyIdentifier2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code isNanCondition}
	 * labeled alternative in {@link OracleSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsNanCondition(OracleSQLStatementParser.IsNanConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code isInfiniteCondition}
	 * labeled alternative in {@link OracleSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsInfiniteCondition(OracleSQLStatementParser.IsInfiniteConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dateTimeAtTimeZoneExpr}
	 * labeled alternative in {@link OracleSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDateTimeAtTimeZoneExpr(OracleSQLStatementParser.DateTimeAtTimeZoneExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cursorExpr}
	 * labeled alternative in {@link OracleSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCursorExpr(OracleSQLStatementParser.CursorExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code concatenationBinaryOperatorExpr}
	 * labeled alternative in {@link OracleSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConcatenationBinaryOperatorExpr(OracleSQLStatementParser.ConcatenationBinaryOperatorExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code selectQueryExpr}
	 * labeled alternative in {@link OracleSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectQueryExpr(OracleSQLStatementParser.SelectQueryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprToExprExpr}
	 * labeled alternative in {@link OracleSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprToExprExpr(OracleSQLStatementParser.ExprToExprExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code someExpr}
	 * labeled alternative in {@link OracleSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSomeExpr(OracleSQLStatementParser.SomeExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code isPresentCondition}
	 * labeled alternative in {@link OracleSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsPresentCondition(OracleSQLStatementParser.IsPresentConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code memberCondition}
	 * labeled alternative in {@link OracleSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberCondition(OracleSQLStatementParser.MemberConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayExpr}
	 * labeled alternative in {@link OracleSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayExpr(OracleSQLStatementParser.ArrayExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code isJsonCondition}
	 * labeled alternative in {@link OracleSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsJsonCondition(OracleSQLStatementParser.IsJsonConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code allExpr}
	 * labeled alternative in {@link OracleSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAllExpr(OracleSQLStatementParser.AllExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dateTimeAtLocalExpr}
	 * labeled alternative in {@link OracleSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDateTimeAtLocalExpr(OracleSQLStatementParser.DateTimeAtLocalExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code methodInvocation1}
	 * labeled alternative in {@link OracleSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodInvocation1(OracleSQLStatementParser.MethodInvocation1Context ctx);
	/**
	 * Visit a parse tree produced by the {@code basicExpr}
	 * labeled alternative in {@link OracleSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicExpr(OracleSQLStatementParser.BasicExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code methodInvocation2}
	 * labeled alternative in {@link OracleSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodInvocation2(OracleSQLStatementParser.MethodInvocation2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code relationalBinaryOperatorExpr}
	 * labeled alternative in {@link OracleSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalBinaryOperatorExpr(OracleSQLStatementParser.RelationalBinaryOperatorExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code outerExpr}
	 * labeled alternative in {@link OracleSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOuterExpr(OracleSQLStatementParser.OuterExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code betweenCondition}
	 * labeled alternative in {@link OracleSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBetweenCondition(OracleSQLStatementParser.BetweenConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code anyExpr}
	 * labeled alternative in {@link OracleSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnyExpr(OracleSQLStatementParser.AnyExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code isOfTypeCondition}
	 * labeled alternative in {@link OracleSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsOfTypeCondition(OracleSQLStatementParser.IsOfTypeConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#concatenationOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConcatenationOp(OracleSQLStatementParser.ConcatenationOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#comparisonOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonOp(OracleSQLStatementParser.ComparisonOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#defaultOnConversionErrorExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultOnConversionErrorExpr(OracleSQLStatementParser.DefaultOnConversionErrorExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#defaultClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultClause(OracleSQLStatementParser.DefaultClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#defaultOnNullClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultOnNullClause(OracleSQLStatementParser.DefaultOnNullClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#assignmentExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentExpr(OracleSQLStatementParser.AssignmentExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#editionableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEditionableClause(OracleSQLStatementParser.EditionableClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#nonEditionableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonEditionableClause(OracleSQLStatementParser.NonEditionableClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#enableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnableClause(OracleSQLStatementParser.EnableClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#disableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDisableClause(OracleSQLStatementParser.DisableClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#renameToClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRenameToClause(OracleSQLStatementParser.RenameToClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#exceptionClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExceptionClause(OracleSQLStatementParser.ExceptionClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#usingClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUsingClause(OracleSQLStatementParser.UsingClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#usingArgumentClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUsingArgumentClause(OracleSQLStatementParser.UsingArgumentClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#attributeDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributeDefinition(OracleSQLStatementParser.AttributeDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#finalClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFinalClause(OracleSQLStatementParser.FinalClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#notFinalClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotFinalClause(OracleSQLStatementParser.NotFinalClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#instantiableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstantiableClause(OracleSQLStatementParser.InstantiableClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#notInstantiableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotInstantiableClause(OracleSQLStatementParser.NotInstantiableClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#persistableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPersistableClause(OracleSQLStatementParser.PersistableClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#notPersistableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotPersistableClause(OracleSQLStatementParser.NotPersistableClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#secureFileClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSecureFileClause(OracleSQLStatementParser.SecureFileClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#basicFileClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicFileClause(OracleSQLStatementParser.BasicFileClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#resetClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResetClause(OracleSQLStatementParser.ResetClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code isOpenImplicitCursorExpr}
	 * labeled alternative in {@link OracleSQLStatementParser#implicitCursorExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsOpenImplicitCursorExpr(OracleSQLStatementParser.IsOpenImplicitCursorExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code foundImplicitCursorExpr}
	 * labeled alternative in {@link OracleSQLStatementParser#implicitCursorExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFoundImplicitCursorExpr(OracleSQLStatementParser.FoundImplicitCursorExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notFoundImplicitCursorExpr}
	 * labeled alternative in {@link OracleSQLStatementParser#implicitCursorExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotFoundImplicitCursorExpr(OracleSQLStatementParser.NotFoundImplicitCursorExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rowcountImplicitCursorExpr}
	 * labeled alternative in {@link OracleSQLStatementParser#implicitCursorExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowcountImplicitCursorExpr(OracleSQLStatementParser.RowcountImplicitCursorExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bulkRowcountImplicitCursorExpr}
	 * labeled alternative in {@link OracleSQLStatementParser#implicitCursorExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBulkRowcountImplicitCursorExpr(OracleSQLStatementParser.BulkRowcountImplicitCursorExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bulkExceptionsCountImplicitCursorExpr}
	 * labeled alternative in {@link OracleSQLStatementParser#implicitCursorExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBulkExceptionsCountImplicitCursorExpr(OracleSQLStatementParser.BulkExceptionsCountImplicitCursorExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bulkExceptionImplicitCursorExpr}
	 * labeled alternative in {@link OracleSQLStatementParser#implicitCursorExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBulkExceptionImplicitCursorExpr(OracleSQLStatementParser.BulkExceptionImplicitCursorExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code isOpenNameCursorExpr}
	 * labeled alternative in {@link OracleSQLStatementParser#namedCursorExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsOpenNameCursorExpr(OracleSQLStatementParser.IsOpenNameCursorExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code foundNameCursorExpr}
	 * labeled alternative in {@link OracleSQLStatementParser#namedCursorExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFoundNameCursorExpr(OracleSQLStatementParser.FoundNameCursorExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notFoundNameCursorExpr}
	 * labeled alternative in {@link OracleSQLStatementParser#namedCursorExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotFoundNameCursorExpr(OracleSQLStatementParser.NotFoundNameCursorExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rowcountNameCursorExpr}
	 * labeled alternative in {@link OracleSQLStatementParser#namedCursorExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowcountNameCursorExpr(OracleSQLStatementParser.RowcountNameCursorExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#namedCursorName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNamedCursorName(OracleSQLStatementParser.NamedCursorNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(OracleSQLStatementParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#notCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotCondition(OracleSQLStatementParser.NotConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#isAnyCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsAnyCondition(OracleSQLStatementParser.IsAnyConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#isASetCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsASetCondition(OracleSQLStatementParser.IsASetConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#isEmptyCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsEmptyCondition(OracleSQLStatementParser.IsEmptyConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#submultisetCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubmultisetCondition(OracleSQLStatementParser.SubmultisetConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#regexpLikeCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegexpLikeCondition(OracleSQLStatementParser.RegexpLikeConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#formatJson}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormatJson(OracleSQLStatementParser.FormatJsonContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#jsonExistsCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonExistsCondition(OracleSQLStatementParser.JsonExistsConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#exprAsObjectExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAsObjectExpr(OracleSQLStatementParser.ExprAsObjectExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#jsonExistsOnErrorClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonExistsOnErrorClause(OracleSQLStatementParser.JsonExistsOnErrorClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#existsCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExistsCondition(OracleSQLStatementParser.ExistsConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#isOfTypeConditionItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsOfTypeConditionItem(OracleSQLStatementParser.IsOfTypeConditionItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#insertingCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsertingCondition(OracleSQLStatementParser.InsertingConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#updatingCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdatingCondition(OracleSQLStatementParser.UpdatingConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#deletingCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeletingCondition(OracleSQLStatementParser.DeletingConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(OracleSQLStatementParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#noArgumentFunctionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoArgumentFunctionName(OracleSQLStatementParser.NoArgumentFunctionNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#chrFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChrFunction(OracleSQLStatementParser.ChrFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#usingNCharCS}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUsingNCharCS(OracleSQLStatementParser.UsingNCharCSContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#translateUsingFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTranslateUsingFunction(OracleSQLStatementParser.TranslateUsingFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#trimFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrimFunction(OracleSQLStatementParser.TrimFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#extractFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtractFunction(OracleSQLStatementParser.ExtractFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#castFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCastFunction(OracleSQLStatementParser.CastFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#castFunctionArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCastFunctionArgument(OracleSQLStatementParser.CastFunctionArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#multisetExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultisetExpr(OracleSQLStatementParser.MultisetExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#treatFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTreatFunction(OracleSQLStatementParser.TreatFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#validateConversionFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValidateConversionFunction(OracleSQLStatementParser.ValidateConversionFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#dataMiningFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataMiningFunction(OracleSQLStatementParser.DataMiningFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#dataMiningFunctionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataMiningFunctionName(OracleSQLStatementParser.DataMiningFunctionNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#dataMiningFunctionArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataMiningFunctionArgument(OracleSQLStatementParser.DataMiningFunctionArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#costMatrixClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCostMatrixClause(OracleSQLStatementParser.CostMatrixClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#miningAttributeClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMiningAttributeClause(OracleSQLStatementParser.MiningAttributeClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#xmlCastFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlCastFunction(OracleSQLStatementParser.XmlCastFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#xmlColAttValFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlColAttValFunction(OracleSQLStatementParser.XmlColAttValFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#xmlElementFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlElementFunction(OracleSQLStatementParser.XmlElementFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#xmlExistsFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlExistsFunction(OracleSQLStatementParser.XmlExistsFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#xmlForestFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlForestFunction(OracleSQLStatementParser.XmlForestFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#xmlParseFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlParseFunction(OracleSQLStatementParser.XmlParseFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#xmlPiFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlPiFunction(OracleSQLStatementParser.XmlPiFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#xmlQueryFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlQueryFunction(OracleSQLStatementParser.XmlQueryFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#xmlRootFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlRootFunction(OracleSQLStatementParser.XmlRootFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#xmlSerializeFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlSerializeFunction(OracleSQLStatementParser.XmlSerializeFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#xmlTableFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlTableFunction(OracleSQLStatementParser.XmlTableFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#xmlRootFunctionVersionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlRootFunctionVersionExpr(OracleSQLStatementParser.XmlRootFunctionVersionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#xmlColAttValFunctionArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlColAttValFunctionArgument(OracleSQLStatementParser.XmlColAttValFunctionArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#xmlFunctionEvalNameArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlFunctionEvalNameArgument(OracleSQLStatementParser.XmlFunctionEvalNameArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#xmlAttributesClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlAttributesClause(OracleSQLStatementParser.XmlAttributesClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#exprOrExprAsAliasArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprOrExprAsAliasArgument(OracleSQLStatementParser.ExprOrExprAsAliasArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#xmlNamespacesClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlNamespacesClause(OracleSQLStatementParser.XmlNamespacesClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#xmlNamespacesClauseArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlNamespacesClauseArgument(OracleSQLStatementParser.XmlNamespacesClauseArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#xmlTableOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlTableOption(OracleSQLStatementParser.XmlTableOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#xmlPassingClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlPassingClause(OracleSQLStatementParser.XmlPassingClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#byValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitByValue(OracleSQLStatementParser.ByValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#returningSequenceByRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturningSequenceByRef(OracleSQLStatementParser.ReturningSequenceByRefContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#xmlTableColumn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlTableColumn(OracleSQLStatementParser.XmlTableColumnContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#sequenceByRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSequenceByRef(OracleSQLStatementParser.SequenceByRefContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#jsonFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonFunction(OracleSQLStatementParser.JsonFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#jsonFunctionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonFunctionName(OracleSQLStatementParser.JsonFunctionNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#jsonFunctionArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonFunctionArgument(OracleSQLStatementParser.JsonFunctionArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#jsonFormatJsonArgumentExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonFormatJsonArgumentExpr(OracleSQLStatementParser.JsonFormatJsonArgumentExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#jsonKeyValueArgumentExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonKeyValueArgumentExpr(OracleSQLStatementParser.JsonKeyValueArgumentExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#jsonOnNullClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonOnNullClause(OracleSQLStatementParser.JsonOnNullClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#jsonReturningClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonReturningClause(OracleSQLStatementParser.JsonReturningClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#withUniqueKeys}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithUniqueKeys(OracleSQLStatementParser.WithUniqueKeysContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#jsonWrapperClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonWrapperClause(OracleSQLStatementParser.JsonWrapperClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#jsonOnErrorClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonOnErrorClause(OracleSQLStatementParser.JsonOnErrorClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#jsonOnEmptyClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonOnEmptyClause(OracleSQLStatementParser.JsonOnEmptyClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#jsonColumnsClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonColumnsClause(OracleSQLStatementParser.JsonColumnsClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jsonExistsColumn}
	 * labeled alternative in {@link OracleSQLStatementParser#jsonColumnDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonExistsColumn(OracleSQLStatementParser.JsonExistsColumnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jsonQueryColumn}
	 * labeled alternative in {@link OracleSQLStatementParser#jsonColumnDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonQueryColumn(OracleSQLStatementParser.JsonQueryColumnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jsonValueColumn}
	 * labeled alternative in {@link OracleSQLStatementParser#jsonColumnDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonValueColumn(OracleSQLStatementParser.JsonValueColumnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jsonNestedPathColumn}
	 * labeled alternative in {@link OracleSQLStatementParser#jsonColumnDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonNestedPathColumn(OracleSQLStatementParser.JsonNestedPathColumnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jsonOrdinalityColumn}
	 * labeled alternative in {@link OracleSQLStatementParser#jsonColumnDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonOrdinalityColumn(OracleSQLStatementParser.JsonOrdinalityColumnContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#aggregateFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAggregateFunction(OracleSQLStatementParser.AggregateFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#aggregateFunctionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAggregateFunctionName(OracleSQLStatementParser.AggregateFunctionNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#withinGroupSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithinGroupSpecification(OracleSQLStatementParser.WithinGroupSpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#firstFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFirstFunction(OracleSQLStatementParser.FirstFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#lastFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLastFunction(OracleSQLStatementParser.LastFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#listAggFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListAggFunction(OracleSQLStatementParser.ListAggFunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code onOverflowErrorClause}
	 * labeled alternative in {@link OracleSQLStatementParser#listaggOverflowClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOnOverflowErrorClause(OracleSQLStatementParser.OnOverflowErrorClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code onOverflowTruncateClause}
	 * labeled alternative in {@link OracleSQLStatementParser#listaggOverflowClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOnOverflowTruncateClause(OracleSQLStatementParser.OnOverflowTruncateClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#windowFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWindowFunction(OracleSQLStatementParser.WindowFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#windowFunctionNullsOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWindowFunctionNullsOption(OracleSQLStatementParser.WindowFunctionNullsOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#windowFunctionFromOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWindowFunctionFromOption(OracleSQLStatementParser.WindowFunctionFromOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#overClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOverClause(OracleSQLStatementParser.OverClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#analyticClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnalyticClause(OracleSQLStatementParser.AnalyticClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#partitionByClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionByClause(OracleSQLStatementParser.PartitionByClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#windowFrameClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWindowFrameClause(OracleSQLStatementParser.WindowFrameClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#windowFrameUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWindowFrameUnit(OracleSQLStatementParser.WindowFrameUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#windowFrameExtent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWindowFrameExtent(OracleSQLStatementParser.WindowFrameExtentContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#windowFrameExtentItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWindowFrameExtentItem(OracleSQLStatementParser.WindowFrameExtentItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#cubeTableFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCubeTableFunction(OracleSQLStatementParser.CubeTableFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#cubeTableOptionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCubeTableOptionExpr(OracleSQLStatementParser.CubeTableOptionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#allocateExtentClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAllocateExtentClause(OracleSQLStatementParser.AllocateExtentClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#allocateExtentItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAllocateExtentItem(OracleSQLStatementParser.AllocateExtentItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#constraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstraint(OracleSQLStatementParser.ConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nullColumnConstraint}
	 * labeled alternative in {@link OracleSQLStatementParser#columnConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullColumnConstraint(OracleSQLStatementParser.NullColumnConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notNullColumnConstraint}
	 * labeled alternative in {@link OracleSQLStatementParser#columnConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotNullColumnConstraint(OracleSQLStatementParser.NotNullColumnConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code uniqueColumnConstraint}
	 * labeled alternative in {@link OracleSQLStatementParser#columnConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUniqueColumnConstraint(OracleSQLStatementParser.UniqueColumnConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryKeyColumnConstraint}
	 * labeled alternative in {@link OracleSQLStatementParser#columnConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryKeyColumnConstraint(OracleSQLStatementParser.PrimaryKeyColumnConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code referencesColumnConstraint}
	 * labeled alternative in {@link OracleSQLStatementParser#columnConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReferencesColumnConstraint(OracleSQLStatementParser.ReferencesColumnConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code checkColumnConstraint}
	 * labeled alternative in {@link OracleSQLStatementParser#columnConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCheckColumnConstraint(OracleSQLStatementParser.CheckColumnConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code scopeIsColumnConstraint}
	 * labeled alternative in {@link OracleSQLStatementParser#columnConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScopeIsColumnConstraint(OracleSQLStatementParser.ScopeIsColumnConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code withRowIdColumnConstraint}
	 * labeled alternative in {@link OracleSQLStatementParser#columnConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithRowIdColumnConstraint(OracleSQLStatementParser.WithRowIdColumnConstraintContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#onDeleteAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOnDeleteAction(OracleSQLStatementParser.OnDeleteActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code uniqueTableConstraint}
	 * labeled alternative in {@link OracleSQLStatementParser#tableConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUniqueTableConstraint(OracleSQLStatementParser.UniqueTableConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryKeyTableConstraint}
	 * labeled alternative in {@link OracleSQLStatementParser#tableConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryKeyTableConstraint(OracleSQLStatementParser.PrimaryKeyTableConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code foreignKeyTableConstraint}
	 * labeled alternative in {@link OracleSQLStatementParser#tableConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForeignKeyTableConstraint(OracleSQLStatementParser.ForeignKeyTableConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code checkTableConstraint}
	 * labeled alternative in {@link OracleSQLStatementParser#tableConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCheckTableConstraint(OracleSQLStatementParser.CheckTableConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code scopeForTableConstraint}
	 * labeled alternative in {@link OracleSQLStatementParser#tableConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScopeForTableConstraint(OracleSQLStatementParser.ScopeForTableConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code refWithRowIdTableConstraint}
	 * labeled alternative in {@link OracleSQLStatementParser#tableConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRefWithRowIdTableConstraint(OracleSQLStatementParser.RefWithRowIdTableConstraintContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#iConstraintState}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIConstraintState(OracleSQLStatementParser.IConstraintStateContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#deferrableConstraintState}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeferrableConstraintState(OracleSQLStatementParser.DeferrableConstraintStateContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#notDeferrableConstraintState}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotDeferrableConstraintState(OracleSQLStatementParser.NotDeferrableConstraintStateContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#initiallyImmediateConstraintState}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitiallyImmediateConstraintState(OracleSQLStatementParser.InitiallyImmediateConstraintStateContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#initiallyDeferredConstraintState}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitiallyDeferredConstraintState(OracleSQLStatementParser.InitiallyDeferredConstraintStateContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#relyConstraintState}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelyConstraintState(OracleSQLStatementParser.RelyConstraintStateContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#noRelyConstraintState}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoRelyConstraintState(OracleSQLStatementParser.NoRelyConstraintStateContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#enableConstraintState}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnableConstraintState(OracleSQLStatementParser.EnableConstraintStateContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#disableConstraintState}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDisableConstraintState(OracleSQLStatementParser.DisableConstraintStateContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#validateConstraintState}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValidateConstraintState(OracleSQLStatementParser.ValidateConstraintStateContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#novalidateConstraintState}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNovalidateConstraintState(OracleSQLStatementParser.NovalidateConstraintStateContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#exceptionsClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExceptionsClause(OracleSQLStatementParser.ExceptionsClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#deallocateUnusedClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeallocateUnusedClause(OracleSQLStatementParser.DeallocateUnusedClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#fileSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFileSpecification(OracleSQLStatementParser.FileSpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#dataFileTempFileSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataFileTempFileSpec(OracleSQLStatementParser.DataFileTempFileSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#redoLogFileSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRedoLogFileSpec(OracleSQLStatementParser.RedoLogFileSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#autoExtendClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAutoExtendClause(OracleSQLStatementParser.AutoExtendClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#maxSizeClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMaxSizeClause(OracleSQLStatementParser.MaxSizeClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#loggingClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoggingClause(OracleSQLStatementParser.LoggingClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#parallelClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParallelClause(OracleSQLStatementParser.ParallelClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#physicalAttributesClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPhysicalAttributesClause(OracleSQLStatementParser.PhysicalAttributesClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#usageQueueClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUsageQueueClause(OracleSQLStatementParser.UsageQueueClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#pctfreeClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPctfreeClause(OracleSQLStatementParser.PctfreeClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#pctusedClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPctusedClause(OracleSQLStatementParser.PctusedClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#initransClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitransClause(OracleSQLStatementParser.InitransClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#maxtransClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMaxtransClause(OracleSQLStatementParser.MaxtransClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#sizeClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSizeClause(OracleSQLStatementParser.SizeClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#sizeType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSizeType(OracleSQLStatementParser.SizeTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#storageClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStorageClause(OracleSQLStatementParser.StorageClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code storageClauseInitialItem}
	 * labeled alternative in {@link OracleSQLStatementParser#storageClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStorageClauseInitialItem(OracleSQLStatementParser.StorageClauseInitialItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code storageClauseNextItem}
	 * labeled alternative in {@link OracleSQLStatementParser#storageClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStorageClauseNextItem(OracleSQLStatementParser.StorageClauseNextItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code storageClauseMinextentsItem}
	 * labeled alternative in {@link OracleSQLStatementParser#storageClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStorageClauseMinextentsItem(OracleSQLStatementParser.StorageClauseMinextentsItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code storageClauseMaxextentsItem}
	 * labeled alternative in {@link OracleSQLStatementParser#storageClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStorageClauseMaxextentsItem(OracleSQLStatementParser.StorageClauseMaxextentsItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code storageClauseMaxsizeItem}
	 * labeled alternative in {@link OracleSQLStatementParser#storageClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStorageClauseMaxsizeItem(OracleSQLStatementParser.StorageClauseMaxsizeItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code storageClausePctincreaseItem}
	 * labeled alternative in {@link OracleSQLStatementParser#storageClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStorageClausePctincreaseItem(OracleSQLStatementParser.StorageClausePctincreaseItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code storageClauseFreelistsItem}
	 * labeled alternative in {@link OracleSQLStatementParser#storageClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStorageClauseFreelistsItem(OracleSQLStatementParser.StorageClauseFreelistsItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code storageClauseFreelistGroupsItem}
	 * labeled alternative in {@link OracleSQLStatementParser#storageClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStorageClauseFreelistGroupsItem(OracleSQLStatementParser.StorageClauseFreelistGroupsItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code storageClauseOptimalItem}
	 * labeled alternative in {@link OracleSQLStatementParser#storageClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStorageClauseOptimalItem(OracleSQLStatementParser.StorageClauseOptimalItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code storageClauseBufferPoolItem}
	 * labeled alternative in {@link OracleSQLStatementParser#storageClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStorageClauseBufferPoolItem(OracleSQLStatementParser.StorageClauseBufferPoolItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code storageClauseFlashCacheItem}
	 * labeled alternative in {@link OracleSQLStatementParser#storageClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStorageClauseFlashCacheItem(OracleSQLStatementParser.StorageClauseFlashCacheItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code storageClauseCellFlashCacheItem}
	 * labeled alternative in {@link OracleSQLStatementParser#storageClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStorageClauseCellFlashCacheItem(OracleSQLStatementParser.StorageClauseCellFlashCacheItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code storageClauseEncryptItem}
	 * labeled alternative in {@link OracleSQLStatementParser#storageClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStorageClauseEncryptItem(OracleSQLStatementParser.StorageClauseEncryptItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#physicalProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPhysicalProperty(OracleSQLStatementParser.PhysicalPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#physicalPropertyOrganizationHeapClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPhysicalPropertyOrganizationHeapClause(OracleSQLStatementParser.PhysicalPropertyOrganizationHeapClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#physicalPropertyOrganizationIndexClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPhysicalPropertyOrganizationIndexClause(OracleSQLStatementParser.PhysicalPropertyOrganizationIndexClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#physicalPropertyOrganizationIndexClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPhysicalPropertyOrganizationIndexClauseItem(OracleSQLStatementParser.PhysicalPropertyOrganizationIndexClauseItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#physicalPropertyOrganizationExternalClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPhysicalPropertyOrganizationExternalClause(OracleSQLStatementParser.PhysicalPropertyOrganizationExternalClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#physicalPropertyClusterClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPhysicalPropertyClusterClause(OracleSQLStatementParser.PhysicalPropertyClusterClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#externalTableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExternalTableClause(OracleSQLStatementParser.ExternalTableClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#externalTableDataProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExternalTableDataProperty(OracleSQLStatementParser.ExternalTableDataPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#accessParametersClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccessParametersClause(OracleSQLStatementParser.AccessParametersClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#accessParametersItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccessParametersItem(OracleSQLStatementParser.AccessParametersItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#readOnlyClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadOnlyClause(OracleSQLStatementParser.ReadOnlyClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#indexingClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexingClause(OracleSQLStatementParser.IndexingClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#deferredSegmentCreation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeferredSegmentCreation(OracleSQLStatementParser.DeferredSegmentCreationContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#segmentAttributesClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSegmentAttributesClause(OracleSQLStatementParser.SegmentAttributesClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#tableSpaceClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableSpaceClause(OracleSQLStatementParser.TableSpaceClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#tableSpaceSetClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableSpaceSetClause(OracleSQLStatementParser.TableSpaceSetClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tableCompressionByCompress}
	 * labeled alternative in {@link OracleSQLStatementParser#tableCompression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableCompressionByCompress(OracleSQLStatementParser.TableCompressionByCompressContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tableCompressionByRowStoreCompress}
	 * labeled alternative in {@link OracleSQLStatementParser#tableCompression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableCompressionByRowStoreCompress(OracleSQLStatementParser.TableCompressionByRowStoreCompressContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tableCompressionByColumnStoreCompress}
	 * labeled alternative in {@link OracleSQLStatementParser#tableCompression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableCompressionByColumnStoreCompress(OracleSQLStatementParser.TableCompressionByColumnStoreCompressContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tableCompressionByNoCompress}
	 * labeled alternative in {@link OracleSQLStatementParser#tableCompression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableCompressionByNoCompress(OracleSQLStatementParser.TableCompressionByNoCompressContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#inMemoryTableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInMemoryTableClause(OracleSQLStatementParser.InMemoryTableClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#inMemoryAttributes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInMemoryAttributes(OracleSQLStatementParser.InMemoryAttributesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inMemoryMemCompressClause}
	 * labeled alternative in {@link OracleSQLStatementParser#iInMemoryMemcompress}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInMemoryMemCompressClause(OracleSQLStatementParser.InMemoryMemCompressClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inMemoryNoMemCompressClause}
	 * labeled alternative in {@link OracleSQLStatementParser#iInMemoryMemcompress}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInMemoryNoMemCompressClause(OracleSQLStatementParser.InMemoryNoMemCompressClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#inMemoryPriority}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInMemoryPriority(OracleSQLStatementParser.InMemoryPriorityContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#inMemoryDistribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInMemoryDistribute(OracleSQLStatementParser.InMemoryDistributeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inMemoryDuplicate}
	 * labeled alternative in {@link OracleSQLStatementParser#iInMemoryDuplicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInMemoryDuplicate(OracleSQLStatementParser.InMemoryDuplicateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inMemoryDuplicateAll}
	 * labeled alternative in {@link OracleSQLStatementParser#iInMemoryDuplicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInMemoryDuplicateAll(OracleSQLStatementParser.InMemoryDuplicateAllContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inMemoryNoDuplicate}
	 * labeled alternative in {@link OracleSQLStatementParser#iInMemoryDuplicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInMemoryNoDuplicate(OracleSQLStatementParser.InMemoryNoDuplicateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inMemoryColumnClause}
	 * labeled alternative in {@link OracleSQLStatementParser#iInMemoryColumnClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInMemoryColumnClause(OracleSQLStatementParser.InMemoryColumnClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code noInMemoryColumnClause}
	 * labeled alternative in {@link OracleSQLStatementParser#iInMemoryColumnClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoInMemoryColumnClause(OracleSQLStatementParser.NoInMemoryColumnClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ilmClauseAddPolicy}
	 * labeled alternative in {@link OracleSQLStatementParser#ilmClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIlmClauseAddPolicy(OracleSQLStatementParser.IlmClauseAddPolicyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ilmClauseDeleteAll}
	 * labeled alternative in {@link OracleSQLStatementParser#ilmClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIlmClauseDeleteAll(OracleSQLStatementParser.IlmClauseDeleteAllContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ilmClauseEnableAll}
	 * labeled alternative in {@link OracleSQLStatementParser#ilmClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIlmClauseEnableAll(OracleSQLStatementParser.IlmClauseEnableAllContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ilmClauseDisableAll}
	 * labeled alternative in {@link OracleSQLStatementParser#ilmClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIlmClauseDisableAll(OracleSQLStatementParser.IlmClauseDisableAllContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#ilmPolicyClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIlmPolicyClause(OracleSQLStatementParser.IlmPolicyClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#ilmCompressionPolicy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIlmCompressionPolicy(OracleSQLStatementParser.IlmCompressionPolicyContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#ilmTieringPolicy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIlmTieringPolicy(OracleSQLStatementParser.IlmTieringPolicyContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#ilmInMemoryPolicy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIlmInMemoryPolicy(OracleSQLStatementParser.IlmInMemoryPolicyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ilmInMemoryPolicyBySetInMemory}
	 * labeled alternative in {@link OracleSQLStatementParser#ilmInMemoryPolicyAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIlmInMemoryPolicyBySetInMemory(OracleSQLStatementParser.IlmInMemoryPolicyBySetInMemoryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ilmInMemoryPolicyByModifyInMemory}
	 * labeled alternative in {@link OracleSQLStatementParser#ilmInMemoryPolicyAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIlmInMemoryPolicyByModifyInMemory(OracleSQLStatementParser.IlmInMemoryPolicyByModifyInMemoryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ilmInMemoryPolicyByNoInMemory}
	 * labeled alternative in {@link OracleSQLStatementParser#ilmInMemoryPolicyAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIlmInMemoryPolicyByNoInMemory(OracleSQLStatementParser.IlmInMemoryPolicyByNoInMemoryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ilmAfterOfClause}
	 * labeled alternative in {@link OracleSQLStatementParser#ilmPolicyOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIlmAfterOfClause(OracleSQLStatementParser.IlmAfterOfClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ilmOnClause}
	 * labeled alternative in {@link OracleSQLStatementParser#ilmPolicyOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIlmOnClause(OracleSQLStatementParser.IlmOnClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#ilmTimePeriod}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIlmTimePeriod(OracleSQLStatementParser.IlmTimePeriodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code substitutableColumnIsOfClause}
	 * labeled alternative in {@link OracleSQLStatementParser#substitutableColumnClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubstitutableColumnIsOfClause(OracleSQLStatementParser.SubstitutableColumnIsOfClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code substitutableColumnAtAllLevelsClause}
	 * labeled alternative in {@link OracleSQLStatementParser#substitutableColumnClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubstitutableColumnAtAllLevelsClause(OracleSQLStatementParser.SubstitutableColumnAtAllLevelsClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#nestedTableColProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNestedTableColProperty(OracleSQLStatementParser.NestedTableColPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#nestedTableColPropertyStoreAsItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNestedTableColPropertyStoreAsItem(OracleSQLStatementParser.NestedTableColPropertyStoreAsItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#varrayColProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarrayColProperty(OracleSQLStatementParser.VarrayColPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#varrayStorageClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarrayStorageClause(OracleSQLStatementParser.VarrayStorageClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#lobStorageClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobStorageClause(OracleSQLStatementParser.LobStorageClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#lobStorageClauseStoreAsItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobStorageClauseStoreAsItem(OracleSQLStatementParser.LobStorageClauseStoreAsItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#lobStorageParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobStorageParameters(OracleSQLStatementParser.LobStorageParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#lobStorageParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobStorageParameter(OracleSQLStatementParser.LobStorageParameterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lobParameterEnable}
	 * labeled alternative in {@link OracleSQLStatementParser#lobParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobParameterEnable(OracleSQLStatementParser.LobParameterEnableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lobParameterDisable}
	 * labeled alternative in {@link OracleSQLStatementParser#lobParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobParameterDisable(OracleSQLStatementParser.LobParameterDisableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lobParameterChunk}
	 * labeled alternative in {@link OracleSQLStatementParser#lobParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobParameterChunk(OracleSQLStatementParser.LobParameterChunkContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lobParameterPctversion}
	 * labeled alternative in {@link OracleSQLStatementParser#lobParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobParameterPctversion(OracleSQLStatementParser.LobParameterPctversionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lobParameterFreepools}
	 * labeled alternative in {@link OracleSQLStatementParser#lobParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobParameterFreepools(OracleSQLStatementParser.LobParameterFreepoolsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lobRetentionClause}
	 * labeled alternative in {@link OracleSQLStatementParser#lobParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobRetentionClause(OracleSQLStatementParser.LobRetentionClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lobDeduplicate}
	 * labeled alternative in {@link OracleSQLStatementParser#lobParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobDeduplicate(OracleSQLStatementParser.LobDeduplicateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lobKeepDuplicates}
	 * labeled alternative in {@link OracleSQLStatementParser#lobParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobKeepDuplicates(OracleSQLStatementParser.LobKeepDuplicatesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lobCompressionClause}
	 * labeled alternative in {@link OracleSQLStatementParser#lobParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobCompressionClause(OracleSQLStatementParser.LobCompressionClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lobNoCompressionClause}
	 * labeled alternative in {@link OracleSQLStatementParser#lobParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobNoCompressionClause(OracleSQLStatementParser.LobNoCompressionClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lobParameterEncrypt}
	 * labeled alternative in {@link OracleSQLStatementParser#lobParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobParameterEncrypt(OracleSQLStatementParser.LobParameterEncryptContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lobParameterDecrypt}
	 * labeled alternative in {@link OracleSQLStatementParser#lobParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobParameterDecrypt(OracleSQLStatementParser.LobParameterDecryptContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lobParameterCache}
	 * labeled alternative in {@link OracleSQLStatementParser#lobParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobParameterCache(OracleSQLStatementParser.LobParameterCacheContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lobParameterNoCache}
	 * labeled alternative in {@link OracleSQLStatementParser#lobParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobParameterNoCache(OracleSQLStatementParser.LobParameterNoCacheContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lobParameterCacheReads}
	 * labeled alternative in {@link OracleSQLStatementParser#lobParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobParameterCacheReads(OracleSQLStatementParser.LobParameterCacheReadsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lobParameterRebuildFreepools}
	 * labeled alternative in {@link OracleSQLStatementParser#lobParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobParameterRebuildFreepools(OracleSQLStatementParser.LobParameterRebuildFreepoolsContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#lobPartitionStorage}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobPartitionStorage(OracleSQLStatementParser.LobPartitionStorageContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#lobPartitionStoragePartitionItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobPartitionStoragePartitionItem(OracleSQLStatementParser.LobPartitionStoragePartitionItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#lobPartitionStorageSubpartitionItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobPartitionStorageSubpartitionItem(OracleSQLStatementParser.LobPartitionStorageSubpartitionItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#lobPartitioningStorage}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobPartitioningStorage(OracleSQLStatementParser.LobPartitioningStorageContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#xmlTypeColumnProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlTypeColumnProperty(OracleSQLStatementParser.XmlTypeColumnPropertyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code xmlTypeStorageAsObjectRelational}
	 * labeled alternative in {@link OracleSQLStatementParser#xmlTypeStorage}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlTypeStorageAsObjectRelational(OracleSQLStatementParser.XmlTypeStorageAsObjectRelationalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code xmlTypeStorageAsClob}
	 * labeled alternative in {@link OracleSQLStatementParser#xmlTypeStorage}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlTypeStorageAsClob(OracleSQLStatementParser.XmlTypeStorageAsClobContext ctx);
	/**
	 * Visit a parse tree produced by the {@code xmlTypeStorageAsBinaryXml}
	 * labeled alternative in {@link OracleSQLStatementParser#xmlTypeStorage}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlTypeStorageAsBinaryXml(OracleSQLStatementParser.XmlTypeStorageAsBinaryXmlContext ctx);
	/**
	 * Visit a parse tree produced by the {@code xmlTypeStorageAsAllVarrays}
	 * labeled alternative in {@link OracleSQLStatementParser#xmlTypeStorage}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlTypeStorageAsAllVarrays(OracleSQLStatementParser.XmlTypeStorageAsAllVarraysContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#xmlSchemaSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlSchemaSpec(OracleSQLStatementParser.XmlSchemaSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#xmlTypeVirtualColumns}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlTypeVirtualColumns(OracleSQLStatementParser.XmlTypeVirtualColumnsContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#xmlTypeVirtualColumnsItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlTypeVirtualColumnsItem(OracleSQLStatementParser.XmlTypeVirtualColumnsItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code flashbackArchiveClause}
	 * labeled alternative in {@link OracleSQLStatementParser#iFlashbackArchiveClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlashbackArchiveClause(OracleSQLStatementParser.FlashbackArchiveClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code noFlashbackArchiveClause}
	 * labeled alternative in {@link OracleSQLStatementParser#iFlashbackArchiveClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoFlashbackArchiveClause(OracleSQLStatementParser.NoFlashbackArchiveClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#storeInClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStoreInClause(OracleSQLStatementParser.StoreInClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#overflowStoreInClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOverflowStoreInClause(OracleSQLStatementParser.OverflowStoreInClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#subPartitionsetStoreInClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubPartitionsetStoreInClause(OracleSQLStatementParser.SubPartitionsetStoreInClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#tablePartitioningClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTablePartitioningClause(OracleSQLStatementParser.TablePartitioningClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#iPartitionBy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIPartitionBy(OracleSQLStatementParser.IPartitionByContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#partitionByRange}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionByRange(OracleSQLStatementParser.PartitionByRangeContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#partitionByHash}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionByHash(OracleSQLStatementParser.PartitionByHashContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#partitionByList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionByList(OracleSQLStatementParser.PartitionByListContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#partitionByReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionByReference(OracleSQLStatementParser.PartitionByReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#partitionBySystem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionBySystem(OracleSQLStatementParser.PartitionBySystemContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#partitionByConsistentHash}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionByConsistentHash(OracleSQLStatementParser.PartitionByConsistentHashContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#partitionDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionDefinition(OracleSQLStatementParser.PartitionDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#partitionDefinitionOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionDefinitionOption(OracleSQLStatementParser.PartitionDefinitionOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#ipartitionsetBy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIpartitionsetBy(OracleSQLStatementParser.IpartitionsetByContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#partitionsetByRange}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionsetByRange(OracleSQLStatementParser.PartitionsetByRangeContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#partitionsetByList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionsetByList(OracleSQLStatementParser.PartitionsetByListContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#partitionsetDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionsetDefinition(OracleSQLStatementParser.PartitionsetDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#partitionsetDefinitionOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionsetDefinitionOption(OracleSQLStatementParser.PartitionsetDefinitionOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#directoryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDirectoryExpr(OracleSQLStatementParser.DirectoryExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#iCompression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitICompression(OracleSQLStatementParser.ICompressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code partitionValuesLessThan}
	 * labeled alternative in {@link OracleSQLStatementParser#iPartitionValues}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionValuesLessThan(OracleSQLStatementParser.PartitionValuesLessThanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code partitionValues}
	 * labeled alternative in {@link OracleSQLStatementParser#iPartitionValues}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionValues(OracleSQLStatementParser.PartitionValuesContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#iSubPartitionBy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitISubPartitionBy(OracleSQLStatementParser.ISubPartitionByContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#subpartitionTemplate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubpartitionTemplate(OracleSQLStatementParser.SubpartitionTemplateContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#subpartitionByRange}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubpartitionByRange(OracleSQLStatementParser.SubpartitionByRangeContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#subpartitionByList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubpartitionByList(OracleSQLStatementParser.SubpartitionByListContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#subpartitionByHash}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubpartitionByHash(OracleSQLStatementParser.SubpartitionByHashContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#subPartitionDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubPartitionDefinition(OracleSQLStatementParser.SubPartitionDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#subPartitionDefinitionOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubPartitionDefinitionOption(OracleSQLStatementParser.SubPartitionDefinitionOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#partitioningStorageClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitioningStorageClause(OracleSQLStatementParser.PartitioningStorageClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#overflowClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOverflowClause(OracleSQLStatementParser.OverflowClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#overflowClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOverflowClauseItem(OracleSQLStatementParser.OverflowClauseItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#varrayStorageAsClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarrayStorageAsClause(OracleSQLStatementParser.VarrayStorageAsClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inMemoryClause}
	 * labeled alternative in {@link OracleSQLStatementParser#iInMemoryClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInMemoryClause(OracleSQLStatementParser.InMemoryClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code noInMemoryClause}
	 * labeled alternative in {@link OracleSQLStatementParser#iInMemoryClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoInMemoryClause(OracleSQLStatementParser.NoInMemoryClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#accessibleByClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccessibleByClause(OracleSQLStatementParser.AccessibleByClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#accessor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccessor(OracleSQLStatementParser.AccessorContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#unitKind}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnitKind(OracleSQLStatementParser.UnitKindContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#aggregateClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAggregateClause(OracleSQLStatementParser.AggregateClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#assignmentStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentStatement(OracleSQLStatementParser.AssignmentStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#autonomousTransPragma}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAutonomousTransPragma(OracleSQLStatementParser.AutonomousTransPragmaContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#basicLoopStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicLoopStatement(OracleSQLStatementParser.BasicLoopStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#plsqlBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlsqlBlock(OracleSQLStatementParser.PlsqlBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#declareSection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclareSection(OracleSQLStatementParser.DeclareSectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#declareSectionItem1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclareSectionItem1(OracleSQLStatementParser.DeclareSectionItem1Context ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#declareSectionItem2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclareSectionItem2(OracleSQLStatementParser.DeclareSectionItem2Context ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#typeDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDefinition(OracleSQLStatementParser.TypeDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#subTypeDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubTypeDefinition(OracleSQLStatementParser.SubTypeDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#subTypeDefinitionConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubTypeDefinitionConstraint(OracleSQLStatementParser.SubTypeDefinitionConstraintContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#rangeExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRangeExpr(OracleSQLStatementParser.RangeExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#itemDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitItemDeclaration(OracleSQLStatementParser.ItemDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(OracleSQLStatementParser.BodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#bodyItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBodyItem(OracleSQLStatementParser.BodyItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#labelDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabelDeclaration(OracleSQLStatementParser.LabelDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#bodyItemStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBodyItemStatement(OracleSQLStatementParser.BodyItemStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#procedureCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedureCall(OracleSQLStatementParser.ProcedureCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code javaDeclaration}
	 * labeled alternative in {@link OracleSQLStatementParser#callSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJavaDeclaration(OracleSQLStatementParser.JavaDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cDeclaration}
	 * labeled alternative in {@link OracleSQLStatementParser#callSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCDeclaration(OracleSQLStatementParser.CDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code languageCName}
	 * labeled alternative in {@link OracleSQLStatementParser#cDeclarationName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLanguageCName(OracleSQLStatementParser.LanguageCNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code languageClibraryName}
	 * labeled alternative in {@link OracleSQLStatementParser#cDeclarationName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLanguageClibraryName(OracleSQLStatementParser.LanguageClibraryNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#withContext}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithContext(OracleSQLStatementParser.WithContextContext ctx);
	/**
	 * Visit a parse tree produced by the {@code contextExternalParameter}
	 * labeled alternative in {@link OracleSQLStatementParser#externalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContextExternalParameter(OracleSQLStatementParser.ContextExternalParameterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code selfExternalParameter}
	 * labeled alternative in {@link OracleSQLStatementParser#externalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelfExternalParameter(OracleSQLStatementParser.SelfExternalParameterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code returnExternalParameter}
	 * labeled alternative in {@link OracleSQLStatementParser#externalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnExternalParameter(OracleSQLStatementParser.ReturnExternalParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#externalParameterProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExternalParameterProperty(OracleSQLStatementParser.ExternalParameterPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#byReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitByReference(OracleSQLStatementParser.ByReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#caseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseStatement(OracleSQLStatementParser.CaseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#caseStatementWhenItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseStatementWhenItem(OracleSQLStatementParser.CaseStatementWhenItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#caseStatementElseClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseStatementElseClause(OracleSQLStatementParser.CaseStatementElseClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#closeStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCloseStatement(OracleSQLStatementParser.CloseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#collectionMethodCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCollectionMethodCall(OracleSQLStatementParser.CollectionMethodCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#collectionMethod}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCollectionMethod(OracleSQLStatementParser.CollectionMethodContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#collectionTypeDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCollectionTypeDefinition(OracleSQLStatementParser.CollectionTypeDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#compileClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompileClause(OracleSQLStatementParser.CompileClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#constantDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantDeclaration(OracleSQLStatementParser.ConstantDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#continueStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueStatement(OracleSQLStatementParser.ContinueStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#coveragePragma}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCoveragePragma(OracleSQLStatementParser.CoveragePragmaContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#refCursorTypeDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRefCursorTypeDefinition(OracleSQLStatementParser.RefCursorTypeDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#collationExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCollationExpr(OracleSQLStatementParser.CollationExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#collateExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCollateExpr(OracleSQLStatementParser.CollateExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#deprecatePragma}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeprecatePragma(OracleSQLStatementParser.DeprecatePragmaContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#deterministicClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeterministicClause(OracleSQLStatementParser.DeterministicClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#elementSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementSpec(OracleSQLStatementParser.ElementSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#elementSpecItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementSpecItem(OracleSQLStatementParser.ElementSpecItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#inheritanceClauses}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInheritanceClauses(OracleSQLStatementParser.InheritanceClausesContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#subProgramDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubProgramDeclaration(OracleSQLStatementParser.SubProgramDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#subProgramExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubProgramExpr(OracleSQLStatementParser.SubProgramExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#constructorDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorDeclaration(OracleSQLStatementParser.ConstructorDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#constructorDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorDefinition(OracleSQLStatementParser.ConstructorDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#mapOrderFunctionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMapOrderFunctionDeclaration(OracleSQLStatementParser.MapOrderFunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#mapOrderFunctionDeclarationItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMapOrderFunctionDeclarationItem(OracleSQLStatementParser.MapOrderFunctionDeclarationItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code externalNameClause}
	 * labeled alternative in {@link OracleSQLStatementParser#iExternalNameClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExternalNameClause(OracleSQLStatementParser.ExternalNameClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code externalVariableNameClause}
	 * labeled alternative in {@link OracleSQLStatementParser#iExternalNameClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExternalVariableNameClause(OracleSQLStatementParser.ExternalVariableNameClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#exceptionInitPragma}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExceptionInitPragma(OracleSQLStatementParser.ExceptionInitPragmaContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#exceptionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExceptionDeclaration(OracleSQLStatementParser.ExceptionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#exceptionHandler}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExceptionHandler(OracleSQLStatementParser.ExceptionHandlerContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#executeImmediateStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExecuteImmediateStatement(OracleSQLStatementParser.ExecuteImmediateStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#exitStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExitStatement(OracleSQLStatementParser.ExitStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#cursorDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCursorDeclaration(OracleSQLStatementParser.CursorDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#cursorDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCursorDefinition(OracleSQLStatementParser.CursorDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#fetchStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFetchStatement(OracleSQLStatementParser.FetchStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#forLoopStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForLoopStatement(OracleSQLStatementParser.ForLoopStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#forLoopStatementCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForLoopStatementCondition(OracleSQLStatementParser.ForLoopStatementConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#forallStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForallStatement(OracleSQLStatementParser.ForallStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boundsClause}
	 * labeled alternative in {@link OracleSQLStatementParser#iBoundsClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoundsClause(OracleSQLStatementParser.BoundsClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boundsClauseByIndicesOf}
	 * labeled alternative in {@link OracleSQLStatementParser#iBoundsClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoundsClauseByIndicesOf(OracleSQLStatementParser.BoundsClauseByIndicesOfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boundsClauseByValuesOf}
	 * labeled alternative in {@link OracleSQLStatementParser#iBoundsClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoundsClauseByValuesOf(OracleSQLStatementParser.BoundsClauseByValuesOfContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#parameterDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterDeclaration(OracleSQLStatementParser.ParameterDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#parameterModel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterModel(OracleSQLStatementParser.ParameterModelContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#functionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(OracleSQLStatementParser.FunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#functionDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDefinition(OracleSQLStatementParser.FunctionDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#functionProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionProperty(OracleSQLStatementParser.FunctionPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#functionHeading}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionHeading(OracleSQLStatementParser.FunctionHeadingContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#gotoStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGotoStatement(OracleSQLStatementParser.GotoStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(OracleSQLStatementParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#ifStatementElsIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatementElsIf(OracleSQLStatementParser.IfStatementElsIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#inlinePragma}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInlinePragma(OracleSQLStatementParser.InlinePragmaContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#invokerRightsClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInvokerRightsClause(OracleSQLStatementParser.InvokerRightsClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#nullStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullStatement(OracleSQLStatementParser.NullStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#openStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpenStatement(OracleSQLStatementParser.OpenStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#openForStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpenForStatement(OracleSQLStatementParser.OpenForStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parallelEnableClause}
	 * labeled alternative in {@link OracleSQLStatementParser#iParallelEnableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParallelEnableClause(OracleSQLStatementParser.ParallelEnableClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parallelEnableByAnyClause}
	 * labeled alternative in {@link OracleSQLStatementParser#iParallelEnableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParallelEnableByAnyClause(OracleSQLStatementParser.ParallelEnableByAnyClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parallelEnableByHashClause}
	 * labeled alternative in {@link OracleSQLStatementParser#iParallelEnableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParallelEnableByHashClause(OracleSQLStatementParser.ParallelEnableByHashClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parallelEnableByRangeClause}
	 * labeled alternative in {@link OracleSQLStatementParser#iParallelEnableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParallelEnableByRangeClause(OracleSQLStatementParser.ParallelEnableByRangeClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parallelEnableByValueClause}
	 * labeled alternative in {@link OracleSQLStatementParser#iParallelEnableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParallelEnableByValueClause(OracleSQLStatementParser.ParallelEnableByValueClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#streamingClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStreamingClause(OracleSQLStatementParser.StreamingClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#pipeRowStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPipeRowStatement(OracleSQLStatementParser.PipeRowStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pipelinedClause}
	 * labeled alternative in {@link OracleSQLStatementParser#iPipelinedClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPipelinedClause(OracleSQLStatementParser.PipelinedClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pipelinedByUsingClause}
	 * labeled alternative in {@link OracleSQLStatementParser#iPipelinedClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPipelinedByUsingClause(OracleSQLStatementParser.PipelinedByUsingClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pipelinedByRowClause}
	 * labeled alternative in {@link OracleSQLStatementParser#iPipelinedClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPipelinedByRowClause(OracleSQLStatementParser.PipelinedByRowClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pipelinedByTableClause}
	 * labeled alternative in {@link OracleSQLStatementParser#iPipelinedClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPipelinedByTableClause(OracleSQLStatementParser.PipelinedByTableClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#procedureDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedureDeclaration(OracleSQLStatementParser.ProcedureDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#procedureDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedureDefinition(OracleSQLStatementParser.ProcedureDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#procedureHeading}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedureHeading(OracleSQLStatementParser.ProcedureHeadingContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#procedureProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedureProperty(OracleSQLStatementParser.ProcedurePropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#raiseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRaiseStatement(OracleSQLStatementParser.RaiseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#recordTypeDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordTypeDefinition(OracleSQLStatementParser.RecordTypeDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#restrictReferencesPragma}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRestrictReferencesPragma(OracleSQLStatementParser.RestrictReferencesPragmaContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(OracleSQLStatementParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#returningIntoClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturningIntoClause(OracleSQLStatementParser.ReturningIntoClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#resultCacheClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResultCacheClause(OracleSQLStatementParser.ResultCacheClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(OracleSQLStatementParser.VariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#selectIntoStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectIntoStatement(OracleSQLStatementParser.SelectIntoStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#selectTargetItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectTargetItem(OracleSQLStatementParser.SelectTargetItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#seriallyReusablePragma}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSeriallyReusablePragma(OracleSQLStatementParser.SeriallyReusablePragmaContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#sharingClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSharingClause(OracleSQLStatementParser.SharingClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#udfPragma}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUdfPragma(OracleSQLStatementParser.UdfPragmaContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#whileLoopStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileLoopStatement(OracleSQLStatementParser.WhileLoopStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#orReplace}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrReplace(OracleSQLStatementParser.OrReplaceContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#notNull}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotNull(OracleSQLStatementParser.NotNullContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#bulkCollect}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBulkCollect(OracleSQLStatementParser.BulkCollectContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#errorLoggingClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitErrorLoggingClause(OracleSQLStatementParser.ErrorLoggingClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#saveExceptions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSaveExceptions(OracleSQLStatementParser.SaveExceptionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#editionableType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEditionableType(OracleSQLStatementParser.EditionableTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#asType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsType(OracleSQLStatementParser.AsTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#visibleType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVisibleType(OracleSQLStatementParser.VisibleTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#forUpdate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForUpdate(OracleSQLStatementParser.ForUpdateContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#partitionsAuto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionsAuto(OracleSQLStatementParser.PartitionsAutoContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#enableType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnableType(OracleSQLStatementParser.EnableTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#cacheType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCacheType(OracleSQLStatementParser.CacheTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#basicFileType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicFileType(OracleSQLStatementParser.BasicFileTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#invalidationType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInvalidationType(OracleSQLStatementParser.InvalidationTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#validateType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValidateType(OracleSQLStatementParser.ValidateTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#forceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForceType(OracleSQLStatementParser.ForceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#keepIndexType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeepIndexType(OracleSQLStatementParser.KeepIndexTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link OracleSQLStatementParser#yesType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitYesType(OracleSQLStatementParser.YesTypeContext ctx);
}