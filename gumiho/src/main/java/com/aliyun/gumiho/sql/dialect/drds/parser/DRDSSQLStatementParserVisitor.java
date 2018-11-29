// Generated from /Users/kongtong.ouyang/IdeaProjects/gumiho/gumiho/src/main/resources/grammars/sql/dialect/drds/DRDSSQLStatementParser.g4 by ANTLR 4.7
package com.aliyun.gumiho.sql.dialect.drds.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link DRDSSQLStatementParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface DRDSSQLStatementParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#parse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParse(DRDSSQLStatementParser.ParseContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(DRDSSQLStatementParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#ddlStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDdlStatement(DRDSSQLStatementParser.DdlStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#dmlStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDmlStatement(DRDSSQLStatementParser.DmlStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#transactionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTransactionStatement(DRDSSQLStatementParser.TransactionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#replicationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReplicationStatement(DRDSSQLStatementParser.ReplicationStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#preparedStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreparedStatement(DRDSSQLStatementParser.PreparedStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#compoundStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompoundStatement(DRDSSQLStatementParser.CompoundStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#administrationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdministrationStatement(DRDSSQLStatementParser.AdministrationStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#utilityStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUtilityStatement(DRDSSQLStatementParser.UtilityStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#createDatabaseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateDatabaseStatement(DRDSSQLStatementParser.CreateDatabaseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#createSchemaStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateSchemaStatement(DRDSSQLStatementParser.CreateSchemaStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#createEventStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateEventStatement(DRDSSQLStatementParser.CreateEventStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#createIndexStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateIndexStatement(DRDSSQLStatementParser.CreateIndexStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#createIndexStatementColumn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateIndexStatementColumn(DRDSSQLStatementParser.CreateIndexStatementColumnContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#createIndexStatementOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateIndexStatementOption(DRDSSQLStatementParser.CreateIndexStatementOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#algorithmOptionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlgorithmOptionExpr(DRDSSQLStatementParser.AlgorithmOptionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#lockOptionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLockOptionExpr(DRDSSQLStatementParser.LockOptionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#createLogfileGroupStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateLogfileGroupStatement(DRDSSQLStatementParser.CreateLogfileGroupStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#createProcedureStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateProcedureStatement(DRDSSQLStatementParser.CreateProcedureStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#createFunctionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateFunctionStatement(DRDSSQLStatementParser.CreateFunctionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#createServerStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateServerStatement(DRDSSQLStatementParser.CreateServerStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code serverHostOption}
	 * labeled alternative in {@link DRDSSQLStatementParser#serverOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitServerHostOption(DRDSSQLStatementParser.ServerHostOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code serverDatabaseOption}
	 * labeled alternative in {@link DRDSSQLStatementParser#serverOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitServerDatabaseOption(DRDSSQLStatementParser.ServerDatabaseOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code serverUserOption}
	 * labeled alternative in {@link DRDSSQLStatementParser#serverOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitServerUserOption(DRDSSQLStatementParser.ServerUserOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code serverPasswordOption}
	 * labeled alternative in {@link DRDSSQLStatementParser#serverOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitServerPasswordOption(DRDSSQLStatementParser.ServerPasswordOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code serverSocketOption}
	 * labeled alternative in {@link DRDSSQLStatementParser#serverOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitServerSocketOption(DRDSSQLStatementParser.ServerSocketOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code serverOwnerOption}
	 * labeled alternative in {@link DRDSSQLStatementParser#serverOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitServerOwnerOption(DRDSSQLStatementParser.ServerOwnerOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code serverPortOption}
	 * labeled alternative in {@link DRDSSQLStatementParser#serverOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitServerPortOption(DRDSSQLStatementParser.ServerPortOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#createTableStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTableStatement(DRDSSQLStatementParser.CreateTableStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#tableElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableElement(DRDSSQLStatementParser.TableElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#columnDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnDefinition(DRDSSQLStatementParser.ColumnDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#likeClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLikeClause(DRDSSQLStatementParser.LikeClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nullColumnConstraint}
	 * labeled alternative in {@link DRDSSQLStatementParser#columnConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullColumnConstraint(DRDSSQLStatementParser.NullColumnConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notNullColumnConstraint}
	 * labeled alternative in {@link DRDSSQLStatementParser#columnConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotNullColumnConstraint(DRDSSQLStatementParser.NotNullColumnConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code defaultColumnConstraint}
	 * labeled alternative in {@link DRDSSQLStatementParser#columnConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultColumnConstraint(DRDSSQLStatementParser.DefaultColumnConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code autoIncrementColumnConstraint}
	 * labeled alternative in {@link DRDSSQLStatementParser#columnConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAutoIncrementColumnConstraint(DRDSSQLStatementParser.AutoIncrementColumnConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryKeyColumnConstraint}
	 * labeled alternative in {@link DRDSSQLStatementParser#columnConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryKeyColumnConstraint(DRDSSQLStatementParser.PrimaryKeyColumnConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code uniqueColumnConstraint}
	 * labeled alternative in {@link DRDSSQLStatementParser#columnConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUniqueColumnConstraint(DRDSSQLStatementParser.UniqueColumnConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code commentClause}
	 * labeled alternative in {@link DRDSSQLStatementParser#columnConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommentClause(DRDSSQLStatementParser.CommentClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code formatColumnConstraint}
	 * labeled alternative in {@link DRDSSQLStatementParser#columnConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormatColumnConstraint(DRDSSQLStatementParser.FormatColumnConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code storageColumnConstraint}
	 * labeled alternative in {@link DRDSSQLStatementParser#columnConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStorageColumnConstraint(DRDSSQLStatementParser.StorageColumnConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code referencesColumnConstraint}
	 * labeled alternative in {@link DRDSSQLStatementParser#columnConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReferencesColumnConstraint(DRDSSQLStatementParser.ReferencesColumnConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryKeyTableConstraint}
	 * labeled alternative in {@link DRDSSQLStatementParser#tableConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryKeyTableConstraint(DRDSSQLStatementParser.PrimaryKeyTableConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code indexTableConstraint}
	 * labeled alternative in {@link DRDSSQLStatementParser#tableConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexTableConstraint(DRDSSQLStatementParser.IndexTableConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code keyTableConstraint}
	 * labeled alternative in {@link DRDSSQLStatementParser#tableConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyTableConstraint(DRDSSQLStatementParser.KeyTableConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code uniqueTableConstraint}
	 * labeled alternative in {@link DRDSSQLStatementParser#tableConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUniqueTableConstraint(DRDSSQLStatementParser.UniqueTableConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fullTextTableConstraint}
	 * labeled alternative in {@link DRDSSQLStatementParser#tableConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFullTextTableConstraint(DRDSSQLStatementParser.FullTextTableConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code spatialTableConstraint}
	 * labeled alternative in {@link DRDSSQLStatementParser#tableConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpatialTableConstraint(DRDSSQLStatementParser.SpatialTableConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code foreignKeyTableConstraint}
	 * labeled alternative in {@link DRDSSQLStatementParser#tableConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForeignKeyTableConstraint(DRDSSQLStatementParser.ForeignKeyTableConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code checkTableConstraint}
	 * labeled alternative in {@link DRDSSQLStatementParser#tableConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCheckTableConstraint(DRDSSQLStatementParser.CheckTableConstraintContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#constraintColumn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstraintColumn(DRDSSQLStatementParser.ConstraintColumnContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#matchType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatchType(DRDSSQLStatementParser.MatchTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code onDeleteAction}
	 * labeled alternative in {@link DRDSSQLStatementParser#referenceTriggerAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOnDeleteAction(DRDSSQLStatementParser.OnDeleteActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code onUpdateAction}
	 * labeled alternative in {@link DRDSSQLStatementParser#referenceTriggerAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOnUpdateAction(DRDSSQLStatementParser.OnUpdateActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#referenceControlType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReferenceControlType(DRDSSQLStatementParser.ReferenceControlTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#tableOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableOption(DRDSSQLStatementParser.TableOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dBPartitionByHash}
	 * labeled alternative in {@link DRDSSQLStatementParser#iDBPartitionBy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDBPartitionByHash(DRDSSQLStatementParser.DBPartitionByHashContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dBPartitionByRangeHash}
	 * labeled alternative in {@link DRDSSQLStatementParser#iDBPartitionBy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDBPartitionByRangeHash(DRDSSQLStatementParser.DBPartitionByRangeHashContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tBPartitionByHash}
	 * labeled alternative in {@link DRDSSQLStatementParser#iTBPartitionBy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTBPartitionByHash(DRDSSQLStatementParser.TBPartitionByHashContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tBPartitionByRangeHash}
	 * labeled alternative in {@link DRDSSQLStatementParser#iTBPartitionBy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTBPartitionByRangeHash(DRDSSQLStatementParser.TBPartitionByRangeHashContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tBPartitionByMM}
	 * labeled alternative in {@link DRDSSQLStatementParser#iTBPartitionBy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTBPartitionByMM(DRDSSQLStatementParser.TBPartitionByMMContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tBPartitionByDD}
	 * labeled alternative in {@link DRDSSQLStatementParser#iTBPartitionBy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTBPartitionByDD(DRDSSQLStatementParser.TBPartitionByDDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tBPartitionByWeek}
	 * labeled alternative in {@link DRDSSQLStatementParser#iTBPartitionBy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTBPartitionByWeek(DRDSSQLStatementParser.TBPartitionByWeekContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tBPartitionByMMDD}
	 * labeled alternative in {@link DRDSSQLStatementParser#iTBPartitionBy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTBPartitionByMMDD(DRDSSQLStatementParser.TBPartitionByMMDDContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#createTablespaceStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTablespaceStatement(DRDSSQLStatementParser.CreateTablespaceStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#createTablespaceInnodb}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTablespaceInnodb(DRDSSQLStatementParser.CreateTablespaceInnodbContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#createTablespaceNdb}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTablespaceNdb(DRDSSQLStatementParser.CreateTablespaceNdbContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#createTriggerStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTriggerStatement(DRDSSQLStatementParser.CreateTriggerStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#definerOptionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefinerOptionExpr(DRDSSQLStatementParser.DefinerOptionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#triggerOrderingClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTriggerOrderingClause(DRDSSQLStatementParser.TriggerOrderingClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#createViewStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateViewStatement(DRDSSQLStatementParser.CreateViewStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#withCheckOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithCheckOption(DRDSSQLStatementParser.WithCheckOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#createDatabaseOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateDatabaseOption(DRDSSQLStatementParser.CreateDatabaseOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code preciseSchedule}
	 * labeled alternative in {@link DRDSSQLStatementParser#scheduleexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreciseSchedule(DRDSSQLStatementParser.PreciseScheduleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intervalSchedule}
	 * labeled alternative in {@link DRDSSQLStatementParser#scheduleexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntervalSchedule(DRDSSQLStatementParser.IntervalScheduleContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#timestampValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimestampValue(DRDSSQLStatementParser.TimestampValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#enableType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnableType(DRDSSQLStatementParser.EnableTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#indexOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexOption(DRDSSQLStatementParser.IndexOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#indexOptionKeyBlockSize}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexOptionKeyBlockSize(DRDSSQLStatementParser.IndexOptionKeyBlockSizeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#indexOptionUsingBtree}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexOptionUsingBtree(DRDSSQLStatementParser.IndexOptionUsingBtreeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#indexOptionUsingHash}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexOptionUsingHash(DRDSSQLStatementParser.IndexOptionUsingHashContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#indexOptionWithParser}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexOptionWithParser(DRDSSQLStatementParser.IndexOptionWithParserContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#indexAttributeVisible}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexAttributeVisible(DRDSSQLStatementParser.IndexAttributeVisibleContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#indexAttributeInvisible}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexAttributeInvisible(DRDSSQLStatementParser.IndexAttributeInvisibleContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#indexOptionCommentOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexOptionCommentOption(DRDSSQLStatementParser.IndexOptionCommentOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#parameterDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterDeclaration(DRDSSQLStatementParser.ParameterDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code routineComment}
	 * labeled alternative in {@link DRDSSQLStatementParser#routineOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoutineComment(DRDSSQLStatementParser.RoutineCommentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code routineLanguage}
	 * labeled alternative in {@link DRDSSQLStatementParser#routineOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoutineLanguage(DRDSSQLStatementParser.RoutineLanguageContext ctx);
	/**
	 * Visit a parse tree produced by the {@code routineBehavior}
	 * labeled alternative in {@link DRDSSQLStatementParser#routineOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoutineBehavior(DRDSSQLStatementParser.RoutineBehaviorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code routineData}
	 * labeled alternative in {@link DRDSSQLStatementParser#routineOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoutineData(DRDSSQLStatementParser.RoutineDataContext ctx);
	/**
	 * Visit a parse tree produced by the {@code routineSecurity}
	 * labeled alternative in {@link DRDSSQLStatementParser#routineOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoutineSecurity(DRDSSQLStatementParser.RoutineSecurityContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterSimpleDatabase}
	 * labeled alternative in {@link DRDSSQLStatementParser#alterDatabaseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterSimpleDatabase(DRDSSQLStatementParser.AlterSimpleDatabaseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterUpgradeName}
	 * labeled alternative in {@link DRDSSQLStatementParser#alterDatabaseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterUpgradeName(DRDSSQLStatementParser.AlterUpgradeNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterSimpleSchema}
	 * labeled alternative in {@link DRDSSQLStatementParser#alterSchemaStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterSimpleSchema(DRDSSQLStatementParser.AlterSimpleSchemaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterSchemaUpgradeName}
	 * labeled alternative in {@link DRDSSQLStatementParser#alterSchemaStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterSchemaUpgradeName(DRDSSQLStatementParser.AlterSchemaUpgradeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#alterEventStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterEventStatement(DRDSSQLStatementParser.AlterEventStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#alterFunctionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterFunctionStatement(DRDSSQLStatementParser.AlterFunctionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#alterInstanceStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterInstanceStatement(DRDSSQLStatementParser.AlterInstanceStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#alterLogfileGroupStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterLogfileGroupStatement(DRDSSQLStatementParser.AlterLogfileGroupStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#alterProcedureStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterProcedureStatement(DRDSSQLStatementParser.AlterProcedureStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#alterServerStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterServerStatement(DRDSSQLStatementParser.AlterServerStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#alterTableStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableStatement(DRDSSQLStatementParser.AlterTableStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterByTableOption}
	 * labeled alternative in {@link DRDSSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterByTableOption(DRDSSQLStatementParser.AlterByTableOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableAddColumnAction}
	 * labeled alternative in {@link DRDSSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableAddColumnAction(DRDSSQLStatementParser.AlterTableAddColumnActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableAddTableConstraintAction}
	 * labeled alternative in {@link DRDSSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableAddTableConstraintAction(DRDSSQLStatementParser.AlterTableAddTableConstraintActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableAlgorithmAction}
	 * labeled alternative in {@link DRDSSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableAlgorithmAction(DRDSSQLStatementParser.AlterTableAlgorithmActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableAlterColumnAction}
	 * labeled alternative in {@link DRDSSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableAlterColumnAction(DRDSSQLStatementParser.AlterTableAlterColumnActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableAlterIndexConstraintAction}
	 * labeled alternative in {@link DRDSSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableAlterIndexConstraintAction(DRDSSQLStatementParser.AlterTableAlterIndexConstraintActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableChangeColumnAction}
	 * labeled alternative in {@link DRDSSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableChangeColumnAction(DRDSSQLStatementParser.AlterTableChangeColumnActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableDefaultCharsetAction}
	 * labeled alternative in {@link DRDSSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableDefaultCharsetAction(DRDSSQLStatementParser.AlterTableDefaultCharsetActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableConvertCharsetAction}
	 * labeled alternative in {@link DRDSSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableConvertCharsetAction(DRDSSQLStatementParser.AlterTableConvertCharsetActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableDisableKeysAction}
	 * labeled alternative in {@link DRDSSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableDisableKeysAction(DRDSSQLStatementParser.AlterTableDisableKeysActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableEnableKeysAction}
	 * labeled alternative in {@link DRDSSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableEnableKeysAction(DRDSSQLStatementParser.AlterTableEnableKeysActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableDiscardTablespaceAction}
	 * labeled alternative in {@link DRDSSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableDiscardTablespaceAction(DRDSSQLStatementParser.AlterTableDiscardTablespaceActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableImportTablespaceAction}
	 * labeled alternative in {@link DRDSSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableImportTablespaceAction(DRDSSQLStatementParser.AlterTableImportTablespaceActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableDropColumnAction}
	 * labeled alternative in {@link DRDSSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableDropColumnAction(DRDSSQLStatementParser.AlterTableDropColumnActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableDropIndexConstraintAction}
	 * labeled alternative in {@link DRDSSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableDropIndexConstraintAction(DRDSSQLStatementParser.AlterTableDropIndexConstraintActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableDropKeyConstraintAction}
	 * labeled alternative in {@link DRDSSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableDropKeyConstraintAction(DRDSSQLStatementParser.AlterTableDropKeyConstraintActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableDropPrimaryKeyConstraintAction}
	 * labeled alternative in {@link DRDSSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableDropPrimaryKeyConstraintAction(DRDSSQLStatementParser.AlterTableDropPrimaryKeyConstraintActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableDropForeignKeyConstraintAction}
	 * labeled alternative in {@link DRDSSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableDropForeignKeyConstraintAction(DRDSSQLStatementParser.AlterTableDropForeignKeyConstraintActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableForceAction}
	 * labeled alternative in {@link DRDSSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableForceAction(DRDSSQLStatementParser.AlterTableForceActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableLockAction}
	 * labeled alternative in {@link DRDSSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableLockAction(DRDSSQLStatementParser.AlterTableLockActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableModifyColumnAction}
	 * labeled alternative in {@link DRDSSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableModifyColumnAction(DRDSSQLStatementParser.AlterTableModifyColumnActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableOrderByColumnAction}
	 * labeled alternative in {@link DRDSSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableOrderByColumnAction(DRDSSQLStatementParser.AlterTableOrderByColumnActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableRenameColumnAction}
	 * labeled alternative in {@link DRDSSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableRenameColumnAction(DRDSSQLStatementParser.AlterTableRenameColumnActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableRenameIndexConstraintAction}
	 * labeled alternative in {@link DRDSSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableRenameIndexConstraintAction(DRDSSQLStatementParser.AlterTableRenameIndexConstraintActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableRenameKeyConstraintAction}
	 * labeled alternative in {@link DRDSSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableRenameKeyConstraintAction(DRDSSQLStatementParser.AlterTableRenameKeyConstraintActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableRenameTableAction}
	 * labeled alternative in {@link DRDSSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableRenameTableAction(DRDSSQLStatementParser.AlterTableRenameTableActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableWithoutValidateAction}
	 * labeled alternative in {@link DRDSSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableWithoutValidateAction(DRDSSQLStatementParser.AlterTableWithoutValidateActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableWithValidateAction}
	 * labeled alternative in {@link DRDSSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableWithValidateAction(DRDSSQLStatementParser.AlterTableWithValidateActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableDropPartitionAction}
	 * labeled alternative in {@link DRDSSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableDropPartitionAction(DRDSSQLStatementParser.AlterTableDropPartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableDiscardPartitionAction}
	 * labeled alternative in {@link DRDSSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableDiscardPartitionAction(DRDSSQLStatementParser.AlterTableDiscardPartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableImportPartitionAction}
	 * labeled alternative in {@link DRDSSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableImportPartitionAction(DRDSSQLStatementParser.AlterTableImportPartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableTruncatePartitionAction}
	 * labeled alternative in {@link DRDSSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableTruncatePartitionAction(DRDSSQLStatementParser.AlterTableTruncatePartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableCoalescePartitionAction}
	 * labeled alternative in {@link DRDSSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableCoalescePartitionAction(DRDSSQLStatementParser.AlterTableCoalescePartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableExchangePartitionAction}
	 * labeled alternative in {@link DRDSSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableExchangePartitionAction(DRDSSQLStatementParser.AlterTableExchangePartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableAnalyzePartitiionAction}
	 * labeled alternative in {@link DRDSSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableAnalyzePartitiionAction(DRDSSQLStatementParser.AlterTableAnalyzePartitiionActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableCheckPartitionAction}
	 * labeled alternative in {@link DRDSSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableCheckPartitionAction(DRDSSQLStatementParser.AlterTableCheckPartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableOptimizePartitionAction}
	 * labeled alternative in {@link DRDSSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableOptimizePartitionAction(DRDSSQLStatementParser.AlterTableOptimizePartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableRebuildPartitionAction}
	 * labeled alternative in {@link DRDSSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableRebuildPartitionAction(DRDSSQLStatementParser.AlterTableRebuildPartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableRepairPartitionAction}
	 * labeled alternative in {@link DRDSSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableRepairPartitionAction(DRDSSQLStatementParser.AlterTableRepairPartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableRemovePartitioningAction}
	 * labeled alternative in {@link DRDSSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableRemovePartitioningAction(DRDSSQLStatementParser.AlterTableRemovePartitioningActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableUpgradePartitioningAction}
	 * labeled alternative in {@link DRDSSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableUpgradePartitioningAction(DRDSSQLStatementParser.AlterTableUpgradePartitioningActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterColumnSetDefaultAction}
	 * labeled alternative in {@link DRDSSQLStatementParser#alterColumnAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterColumnSetDefaultAction(DRDSSQLStatementParser.AlterColumnSetDefaultActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterColumnDropDefaultAction}
	 * labeled alternative in {@link DRDSSQLStatementParser#alterColumnAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterColumnDropDefaultAction(DRDSSQLStatementParser.AlterColumnDropDefaultActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#alterTablePartitionItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTablePartitionItem(DRDSSQLStatementParser.AlterTablePartitionItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#alterTablespaceStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTablespaceStatement(DRDSSQLStatementParser.AlterTablespaceStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#alterViewStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterViewStatement(DRDSSQLStatementParser.AlterViewStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#dropDatabaseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropDatabaseStatement(DRDSSQLStatementParser.DropDatabaseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#dropSchemaStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropSchemaStatement(DRDSSQLStatementParser.DropSchemaStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#dropEventStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropEventStatement(DRDSSQLStatementParser.DropEventStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#dropIndexStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropIndexStatement(DRDSSQLStatementParser.DropIndexStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#dropIndexStatementOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropIndexStatementOption(DRDSSQLStatementParser.DropIndexStatementOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#dropLogfileGroupStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropLogfileGroupStatement(DRDSSQLStatementParser.DropLogfileGroupStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#dropProcedureStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropProcedureStatement(DRDSSQLStatementParser.DropProcedureStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#dropFunctionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropFunctionStatement(DRDSSQLStatementParser.DropFunctionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#dropServerStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropServerStatement(DRDSSQLStatementParser.DropServerStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#dropTableStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropTableStatement(DRDSSQLStatementParser.DropTableStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#dropTablespaceStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropTablespaceStatement(DRDSSQLStatementParser.DropTablespaceStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#dropTriggerStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropTriggerStatement(DRDSSQLStatementParser.DropTriggerStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#dropViewStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropViewStatement(DRDSSQLStatementParser.DropViewStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#renameTableStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRenameTableStatement(DRDSSQLStatementParser.RenameTableStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#renameTableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRenameTableClause(DRDSSQLStatementParser.RenameTableClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#truncateTableStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTruncateTableStatement(DRDSSQLStatementParser.TruncateTableStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#selectStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectStatement(DRDSSQLStatementParser.SelectStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#iSelectQuery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitISelectQuery(DRDSSQLStatementParser.ISelectQueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#selectQueryBasic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectQueryBasic(DRDSSQLStatementParser.SelectQueryBasicContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#selectQuery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectQuery(DRDSSQLStatementParser.SelectQueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#selectQueryCache}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectQueryCache(DRDSSQLStatementParser.SelectQueryCacheContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#selectParenQuery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectParenQuery(DRDSSQLStatementParser.SelectParenQueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#selectUnionQuery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectUnionQuery(DRDSSQLStatementParser.SelectUnionQueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#setQuantifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetQuantifier(DRDSSQLStatementParser.SetQuantifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#unionOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnionOperator(DRDSSQLStatementParser.UnionOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#selectItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectItem(DRDSSQLStatementParser.SelectItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#selectItemAlias}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectItemAlias(DRDSSQLStatementParser.SelectItemAliasContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#fromClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFromClause(DRDSSQLStatementParser.FromClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#iTableReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitITableReference(DRDSSQLStatementParser.ITableReferenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code objectNameTableReference}
	 * labeled alternative in {@link DRDSSQLStatementParser#tableReferenceBasic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectNameTableReference(DRDSSQLStatementParser.ObjectNameTableReferenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code subQueryTableReference}
	 * labeled alternative in {@link DRDSSQLStatementParser#tableReferenceBasic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubQueryTableReference(DRDSSQLStatementParser.SubQueryTableReferenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ojTableReference}
	 * labeled alternative in {@link DRDSSQLStatementParser#tableReferenceBasic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOjTableReference(DRDSSQLStatementParser.OjTableReferenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenTableReference}
	 * labeled alternative in {@link DRDSSQLStatementParser#tableReferenceBasic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenTableReference(DRDSSQLStatementParser.ParenTableReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#joinTableReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoinTableReference(DRDSSQLStatementParser.JoinTableReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#partitionClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionClause(DRDSSQLStatementParser.PartitionClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code useIndexHint}
	 * labeled alternative in {@link DRDSSQLStatementParser#iIndexHint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUseIndexHint(DRDSSQLStatementParser.UseIndexHintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code useKeyHint}
	 * labeled alternative in {@link DRDSSQLStatementParser#iIndexHint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUseKeyHint(DRDSSQLStatementParser.UseKeyHintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ignoreIndexHint}
	 * labeled alternative in {@link DRDSSQLStatementParser#iIndexHint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIgnoreIndexHint(DRDSSQLStatementParser.IgnoreIndexHintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ignoreKeyHint}
	 * labeled alternative in {@link DRDSSQLStatementParser#iIndexHint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIgnoreKeyHint(DRDSSQLStatementParser.IgnoreKeyHintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forceIndexHint}
	 * labeled alternative in {@link DRDSSQLStatementParser#iIndexHint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForceIndexHint(DRDSSQLStatementParser.ForceIndexHintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forceKeyHint}
	 * labeled alternative in {@link DRDSSQLStatementParser#iIndexHint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForceKeyHint(DRDSSQLStatementParser.ForceKeyHintContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#indexHintType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexHintType(DRDSSQLStatementParser.IndexHintTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#joinType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoinType(DRDSSQLStatementParser.JoinTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#rightJoinClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRightJoinClause(DRDSSQLStatementParser.RightJoinClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code joinOnCondition}
	 * labeled alternative in {@link DRDSSQLStatementParser#iJoinCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoinOnCondition(DRDSSQLStatementParser.JoinOnConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code joinUsingCondition}
	 * labeled alternative in {@link DRDSSQLStatementParser#iJoinCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoinUsingCondition(DRDSSQLStatementParser.JoinUsingConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#whereClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhereClause(DRDSSQLStatementParser.WhereClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#groupByClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroupByClause(DRDSSQLStatementParser.GroupByClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#havingClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHavingClause(DRDSSQLStatementParser.HavingClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#groupByItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroupByItem(DRDSSQLStatementParser.GroupByItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#orderByClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrderByClause(DRDSSQLStatementParser.OrderByClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#orderByItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrderByItem(DRDSSQLStatementParser.OrderByItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#limitOffsetClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLimitOffsetClause(DRDSSQLStatementParser.LimitOffsetClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code selectQueryIntoClause}
	 * labeled alternative in {@link DRDSSQLStatementParser#iSelectQueryIntoClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectQueryIntoClause(DRDSSQLStatementParser.SelectQueryIntoClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code selectQueryIntoDumpFileClause}
	 * labeled alternative in {@link DRDSSQLStatementParser#iSelectQueryIntoClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectQueryIntoDumpFileClause(DRDSSQLStatementParser.SelectQueryIntoDumpFileClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code selectIntoTextFile}
	 * labeled alternative in {@link DRDSSQLStatementParser#iSelectQueryIntoClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectIntoTextFile(DRDSSQLStatementParser.SelectIntoTextFileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forUpdateClause}
	 * labeled alternative in {@link DRDSSQLStatementParser#iLockClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForUpdateClause(DRDSSQLStatementParser.ForUpdateClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lockInShareModeClause}
	 * labeled alternative in {@link DRDSSQLStatementParser#iLockClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLockInShareModeClause(DRDSSQLStatementParser.LockInShareModeClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forUpdateSkipLockedOption}
	 * labeled alternative in {@link DRDSSQLStatementParser#forUpdateOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForUpdateSkipLockedOption(DRDSSQLStatementParser.ForUpdateSkipLockedOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forUpdateNoWaitOption}
	 * labeled alternative in {@link DRDSSQLStatementParser#forUpdateOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForUpdateNoWaitOption(DRDSSQLStatementParser.ForUpdateNoWaitOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#selectIntoStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectIntoStatement(DRDSSQLStatementParser.SelectIntoStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#selectTargetItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectTargetItem(DRDSSQLStatementParser.SelectTargetItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#insertStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsertStatement(DRDSSQLStatementParser.InsertStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#iValueClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIValueClause(DRDSSQLStatementParser.IValueClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#valuesClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValuesClause(DRDSSQLStatementParser.ValuesClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#valuesClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValuesClauseItem(DRDSSQLStatementParser.ValuesClauseItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#onDuplicateKeyUpdateClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOnDuplicateKeyUpdateClause(DRDSSQLStatementParser.OnDuplicateKeyUpdateClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#updateStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdateStatement(DRDSSQLStatementParser.UpdateStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#updateSetClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdateSetClause(DRDSSQLStatementParser.UpdateSetClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#updateSetItemClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdateSetItemClause(DRDSSQLStatementParser.UpdateSetItemClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#deleteStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeleteStatement(DRDSSQLStatementParser.DeleteStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#deleteStatementUsingClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeleteStatementUsingClause(DRDSSQLStatementParser.DeleteStatementUsingClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#replaceStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReplaceStatement(DRDSSQLStatementParser.ReplaceStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#replaceStatementValuseClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReplaceStatementValuseClause(DRDSSQLStatementParser.ReplaceStatementValuseClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#callStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallStatement(DRDSSQLStatementParser.CallStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#loadDataInfileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoadDataInfileStatement(DRDSSQLStatementParser.LoadDataInfileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#loadXmlStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoadXmlStatement(DRDSSQLStatementParser.LoadXmlStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#doStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoStatement(DRDSSQLStatementParser.DoStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#handlerStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHandlerStatement(DRDSSQLStatementParser.HandlerStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#handlerOpenStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHandlerOpenStatement(DRDSSQLStatementParser.HandlerOpenStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#handlerReadStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHandlerReadStatement(DRDSSQLStatementParser.HandlerReadStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#handlerCloseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHandlerCloseStatement(DRDSSQLStatementParser.HandlerCloseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#selectFieldsInto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectFieldsInto(DRDSSQLStatementParser.SelectFieldsIntoContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#selectLinesInto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectLinesInto(DRDSSQLStatementParser.SelectLinesIntoContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#startTransaction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStartTransaction(DRDSSQLStatementParser.StartTransactionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#transactionMode}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTransactionMode(DRDSSQLStatementParser.TransactionModeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#beginWork}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBeginWork(DRDSSQLStatementParser.BeginWorkContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#commitWork}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommitWork(DRDSSQLStatementParser.CommitWorkContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#rollbackWork}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRollbackWork(DRDSSQLStatementParser.RollbackWorkContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#savepointStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSavepointStatement(DRDSSQLStatementParser.SavepointStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#rollbackStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRollbackStatement(DRDSSQLStatementParser.RollbackStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#releaseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReleaseStatement(DRDSSQLStatementParser.ReleaseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#lockTablesStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLockTablesStatement(DRDSSQLStatementParser.LockTablesStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#lockTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLockTableItem(DRDSSQLStatementParser.LockTableItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#lockAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLockAction(DRDSSQLStatementParser.LockActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#unlockTablesStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnlockTablesStatement(DRDSSQLStatementParser.UnlockTablesStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#setAutoCommitStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetAutoCommitStatement(DRDSSQLStatementParser.SetAutoCommitStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#transactionOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTransactionOption(DRDSSQLStatementParser.TransactionOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#transactionLevel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTransactionLevel(DRDSSQLStatementParser.TransactionLevelContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#changeMaster}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChangeMaster(DRDSSQLStatementParser.ChangeMasterContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#changeReplicationFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChangeReplicationFilter(DRDSSQLStatementParser.ChangeReplicationFilterContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#purgeBinaryLogs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPurgeBinaryLogs(DRDSSQLStatementParser.PurgeBinaryLogsContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#resetMaster}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResetMaster(DRDSSQLStatementParser.ResetMasterContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#resetSlave}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResetSlave(DRDSSQLStatementParser.ResetSlaveContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#startSlave}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStartSlave(DRDSSQLStatementParser.StartSlaveContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#stopSlave}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStopSlave(DRDSSQLStatementParser.StopSlaveContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#startGroupReplication}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStartGroupReplication(DRDSSQLStatementParser.StartGroupReplicationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#stopGroupReplication}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStopGroupReplication(DRDSSQLStatementParser.StopGroupReplicationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code masterStringOption}
	 * labeled alternative in {@link DRDSSQLStatementParser#masterOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMasterStringOption(DRDSSQLStatementParser.MasterStringOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code masterDecimalOption}
	 * labeled alternative in {@link DRDSSQLStatementParser#masterOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMasterDecimalOption(DRDSSQLStatementParser.MasterDecimalOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code masterBoolOption}
	 * labeled alternative in {@link DRDSSQLStatementParser#masterOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMasterBoolOption(DRDSSQLStatementParser.MasterBoolOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code masterRealOption}
	 * labeled alternative in {@link DRDSSQLStatementParser#masterOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMasterRealOption(DRDSSQLStatementParser.MasterRealOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code master}
	 * labeled alternative in {@link DRDSSQLStatementParser#masterOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMaster(DRDSSQLStatementParser.MasterContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#stringMasterOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringMasterOption(DRDSSQLStatementParser.StringMasterOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#decimalMasterOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecimalMasterOption(DRDSSQLStatementParser.DecimalMasterOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#boolMasterOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolMasterOption(DRDSSQLStatementParser.BoolMasterOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#channelOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChannelOption(DRDSSQLStatementParser.ChannelOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code doDbReplication}
	 * labeled alternative in {@link DRDSSQLStatementParser#replicationFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoDbReplication(DRDSSQLStatementParser.DoDbReplicationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ignoreDbReplication}
	 * labeled alternative in {@link DRDSSQLStatementParser#replicationFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIgnoreDbReplication(DRDSSQLStatementParser.IgnoreDbReplicationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code doTableReplication}
	 * labeled alternative in {@link DRDSSQLStatementParser#replicationFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoTableReplication(DRDSSQLStatementParser.DoTableReplicationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ignoreTableReplication}
	 * labeled alternative in {@link DRDSSQLStatementParser#replicationFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIgnoreTableReplication(DRDSSQLStatementParser.IgnoreTableReplicationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code wildDoTableReplication}
	 * labeled alternative in {@link DRDSSQLStatementParser#replicationFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWildDoTableReplication(DRDSSQLStatementParser.WildDoTableReplicationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code wildIgnoreTableReplication}
	 * labeled alternative in {@link DRDSSQLStatementParser#replicationFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWildIgnoreTableReplication(DRDSSQLStatementParser.WildIgnoreTableReplicationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rewriteDbReplication}
	 * labeled alternative in {@link DRDSSQLStatementParser#replicationFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRewriteDbReplication(DRDSSQLStatementParser.RewriteDbReplicationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#tablePair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTablePair(DRDSSQLStatementParser.TablePairContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#threadType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThreadType(DRDSSQLStatementParser.ThreadTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code gtidsUntilOption}
	 * labeled alternative in {@link DRDSSQLStatementParser#untilOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGtidsUntilOption(DRDSSQLStatementParser.GtidsUntilOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code masterLogUntilOption}
	 * labeled alternative in {@link DRDSSQLStatementParser#untilOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMasterLogUntilOption(DRDSSQLStatementParser.MasterLogUntilOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code relayLogUntilOption}
	 * labeled alternative in {@link DRDSSQLStatementParser#untilOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelayLogUntilOption(DRDSSQLStatementParser.RelayLogUntilOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sqlGapsUntilOption}
	 * labeled alternative in {@link DRDSSQLStatementParser#untilOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSqlGapsUntilOption(DRDSSQLStatementParser.SqlGapsUntilOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code userConnectionOption}
	 * labeled alternative in {@link DRDSSQLStatementParser#connectionOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUserConnectionOption(DRDSSQLStatementParser.UserConnectionOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code passwordConnectionOption}
	 * labeled alternative in {@link DRDSSQLStatementParser#connectionOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPasswordConnectionOption(DRDSSQLStatementParser.PasswordConnectionOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code defaultAuthConnectionOption}
	 * labeled alternative in {@link DRDSSQLStatementParser#connectionOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultAuthConnectionOption(DRDSSQLStatementParser.DefaultAuthConnectionOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pluginDirConnectionOption}
	 * labeled alternative in {@link DRDSSQLStatementParser#connectionOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPluginDirConnectionOption(DRDSSQLStatementParser.PluginDirConnectionOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#gtnameIdentifierSet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGtnameIdentifierSet(DRDSSQLStatementParser.GtnameIdentifierSetContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#xaStartTransaction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXaStartTransaction(DRDSSQLStatementParser.XaStartTransactionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#xaEndTransaction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXaEndTransaction(DRDSSQLStatementParser.XaEndTransactionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#xaPrepareStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXaPrepareStatement(DRDSSQLStatementParser.XaPrepareStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#xaCommitWork}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXaCommitWork(DRDSSQLStatementParser.XaCommitWorkContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#xaRollbackWork}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXaRollbackWork(DRDSSQLStatementParser.XaRollbackWorkContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#xaRecoverWork}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXaRecoverWork(DRDSSQLStatementParser.XaRecoverWorkContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#prepareStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrepareStatement(DRDSSQLStatementParser.PrepareStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#executeStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExecuteStatement(DRDSSQLStatementParser.ExecuteStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#deallocatePrepare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeallocatePrepare(DRDSSQLStatementParser.DeallocatePrepareContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#statementItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementItem(DRDSSQLStatementParser.StatementItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(DRDSSQLStatementParser.BodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#bodyItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBodyItem(DRDSSQLStatementParser.BodyItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#bodyItemStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBodyItemStatement(DRDSSQLStatementParser.BodyItemStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#caseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseStatement(DRDSSQLStatementParser.CaseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#caseStatementWhenItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseStatementWhenItem(DRDSSQLStatementParser.CaseStatementWhenItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#caseStatementElseClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseStatementElseClause(DRDSSQLStatementParser.CaseStatementElseClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(DRDSSQLStatementParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#elseIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseIf(DRDSSQLStatementParser.ElseIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#iterateStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIterateStatement(DRDSSQLStatementParser.IterateStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#leaveStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeaveStatement(DRDSSQLStatementParser.LeaveStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#loopStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopStatement(DRDSSQLStatementParser.LoopStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#repeatStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeatStatement(DRDSSQLStatementParser.RepeatStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(DRDSSQLStatementParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(DRDSSQLStatementParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CloseCursor}
	 * labeled alternative in {@link DRDSSQLStatementParser#cursorStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCloseCursor(DRDSSQLStatementParser.CloseCursorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FetchCursor}
	 * labeled alternative in {@link DRDSSQLStatementParser#cursorStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFetchCursor(DRDSSQLStatementParser.FetchCursorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OpenCursor}
	 * labeled alternative in {@link DRDSSQLStatementParser#cursorStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpenCursor(DRDSSQLStatementParser.OpenCursorContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#conditionHandling}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionHandling(DRDSSQLStatementParser.ConditionHandlingContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#declareVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclareVariable(DRDSSQLStatementParser.DeclareVariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#declareCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclareCondition(DRDSSQLStatementParser.DeclareConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#declareCursor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclareCursor(DRDSSQLStatementParser.DeclareCursorContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#declareHandler}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclareHandler(DRDSSQLStatementParser.DeclareHandlerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code handlerConditionCode}
	 * labeled alternative in {@link DRDSSQLStatementParser#handlerConditionValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHandlerConditionCode(DRDSSQLStatementParser.HandlerConditionCodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code handlerConditionState}
	 * labeled alternative in {@link DRDSSQLStatementParser#handlerConditionValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHandlerConditionState(DRDSSQLStatementParser.HandlerConditionStateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code handlerConditionName}
	 * labeled alternative in {@link DRDSSQLStatementParser#handlerConditionValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHandlerConditionName(DRDSSQLStatementParser.HandlerConditionNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code handlerConditionWarning}
	 * labeled alternative in {@link DRDSSQLStatementParser#handlerConditionValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHandlerConditionWarning(DRDSSQLStatementParser.HandlerConditionWarningContext ctx);
	/**
	 * Visit a parse tree produced by the {@code handlerConditionNotfound}
	 * labeled alternative in {@link DRDSSQLStatementParser#handlerConditionValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHandlerConditionNotfound(DRDSSQLStatementParser.HandlerConditionNotfoundContext ctx);
	/**
	 * Visit a parse tree produced by the {@code handlerConditionException}
	 * labeled alternative in {@link DRDSSQLStatementParser#handlerConditionValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHandlerConditionException(DRDSSQLStatementParser.HandlerConditionExceptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterUserMysqlV56}
	 * labeled alternative in {@link DRDSSQLStatementParser#alterUserStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterUserMysqlV56(DRDSSQLStatementParser.AlterUserMysqlV56Context ctx);
	/**
	 * Visit a parse tree produced by the {@code alterUserMysqlV57}
	 * labeled alternative in {@link DRDSSQLStatementParser#alterUserStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterUserMysqlV57(DRDSSQLStatementParser.AlterUserMysqlV57Context ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#createUserStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateUserStatement(DRDSSQLStatementParser.CreateUserStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#dropUserStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropUserStatement(DRDSSQLStatementParser.DropUserStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#grantStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGrantStatement(DRDSSQLStatementParser.GrantStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#grantProxy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGrantProxy(DRDSSQLStatementParser.GrantProxyContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#renameUser}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRenameUser(DRDSSQLStatementParser.RenameUserContext ctx);
	/**
	 * Visit a parse tree produced by the {@code detailRevoke}
	 * labeled alternative in {@link DRDSSQLStatementParser#revokeStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDetailRevoke(DRDSSQLStatementParser.DetailRevokeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code shortRevoke}
	 * labeled alternative in {@link DRDSSQLStatementParser#revokeStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShortRevoke(DRDSSQLStatementParser.ShortRevokeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#revokeProxy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRevokeProxy(DRDSSQLStatementParser.RevokeProxyContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#userSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUserSpecification(DRDSSQLStatementParser.UserSpecificationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code passwordAuthOption}
	 * labeled alternative in {@link DRDSSQLStatementParser#userAuthOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPasswordAuthOption(DRDSSQLStatementParser.PasswordAuthOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringAuthOption}
	 * labeled alternative in {@link DRDSSQLStatementParser#userAuthOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringAuthOption(DRDSSQLStatementParser.StringAuthOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code hashAuthOption}
	 * labeled alternative in {@link DRDSSQLStatementParser#userAuthOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHashAuthOption(DRDSSQLStatementParser.HashAuthOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code simpleAuthOption}
	 * labeled alternative in {@link DRDSSQLStatementParser#userAuthOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleAuthOption(DRDSSQLStatementParser.SimpleAuthOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#tlsOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTlsOption(DRDSSQLStatementParser.TlsOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#userResourceOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUserResourceOption(DRDSSQLStatementParser.UserResourceOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#userPasswordOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUserPasswordOption(DRDSSQLStatementParser.UserPasswordOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#userLockOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUserLockOption(DRDSSQLStatementParser.UserLockOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#privelegeClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrivelegeClause(DRDSSQLStatementParser.PrivelegeClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#privilege}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrivilege(DRDSSQLStatementParser.PrivilegeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code currentSchemaPriviLevel}
	 * labeled alternative in {@link DRDSSQLStatementParser#privilegeLevel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCurrentSchemaPriviLevel(DRDSSQLStatementParser.CurrentSchemaPriviLevelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code globalPrivLevel}
	 * labeled alternative in {@link DRDSSQLStatementParser#privilegeLevel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobalPrivLevel(DRDSSQLStatementParser.GlobalPrivLevelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code definiteSchemaPrivLevel}
	 * labeled alternative in {@link DRDSSQLStatementParser#privilegeLevel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefiniteSchemaPrivLevel(DRDSSQLStatementParser.DefiniteSchemaPrivLevelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code definiteFullTablePrivLevel}
	 * labeled alternative in {@link DRDSSQLStatementParser#privilegeLevel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefiniteFullTablePrivLevel(DRDSSQLStatementParser.DefiniteFullTablePrivLevelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code definiteTablePrivLevel}
	 * labeled alternative in {@link DRDSSQLStatementParser#privilegeLevel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefiniteTablePrivLevel(DRDSSQLStatementParser.DefiniteTablePrivLevelContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#renameUserClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRenameUserClause(DRDSSQLStatementParser.RenameUserClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#analyzeTable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnalyzeTable(DRDSSQLStatementParser.AnalyzeTableContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#checkTable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCheckTable(DRDSSQLStatementParser.CheckTableContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#checksumTable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChecksumTable(DRDSSQLStatementParser.ChecksumTableContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#optimizeTable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptimizeTable(DRDSSQLStatementParser.OptimizeTableContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#repairTable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepairTable(DRDSSQLStatementParser.RepairTableContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#checkTableOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCheckTableOption(DRDSSQLStatementParser.CheckTableOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#createUdfunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateUdfunction(DRDSSQLStatementParser.CreateUdfunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#installPlugin}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstallPlugin(DRDSSQLStatementParser.InstallPluginContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#uninstallPlugin}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUninstallPlugin(DRDSSQLStatementParser.UninstallPluginContext ctx);
	/**
	 * Visit a parse tree produced by the {@code setDefaultRoleStatement}
	 * labeled alternative in {@link DRDSSQLStatementParser#setStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetDefaultRoleStatement(DRDSSQLStatementParser.SetDefaultRoleStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code setPasswordStatement}
	 * labeled alternative in {@link DRDSSQLStatementParser#setStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetPasswordStatement(DRDSSQLStatementParser.SetPasswordStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code setVariableStatement}
	 * labeled alternative in {@link DRDSSQLStatementParser#setStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetVariableStatement(DRDSSQLStatementParser.SetVariableStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code setCharacterSetStatement}
	 * labeled alternative in {@link DRDSSQLStatementParser#setStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetCharacterSetStatement(DRDSSQLStatementParser.SetCharacterSetStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code setCharsetStatement}
	 * labeled alternative in {@link DRDSSQLStatementParser#setStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetCharsetStatement(DRDSSQLStatementParser.SetCharsetStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code setNamesStatement}
	 * labeled alternative in {@link DRDSSQLStatementParser#setStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetNamesStatement(DRDSSQLStatementParser.SetNamesStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code setTransactionStatement}
	 * labeled alternative in {@link DRDSSQLStatementParser#setStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetTransactionStatement(DRDSSQLStatementParser.SetTransactionStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code setAutocommit}
	 * labeled alternative in {@link DRDSSQLStatementParser#setStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetAutocommit(DRDSSQLStatementParser.SetAutocommitContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#setDefaultRole}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetDefaultRole(DRDSSQLStatementParser.SetDefaultRoleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code showMasterLogs}
	 * labeled alternative in {@link DRDSSQLStatementParser#showStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowMasterLogs(DRDSSQLStatementParser.ShowMasterLogsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code showLogEvents}
	 * labeled alternative in {@link DRDSSQLStatementParser#showStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowLogEvents(DRDSSQLStatementParser.ShowLogEventsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code showObjectFilter}
	 * labeled alternative in {@link DRDSSQLStatementParser#showStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowObjectFilter(DRDSSQLStatementParser.ShowObjectFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code showColumns}
	 * labeled alternative in {@link DRDSSQLStatementParser#showStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowColumns(DRDSSQLStatementParser.ShowColumnsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code showCreateDb}
	 * labeled alternative in {@link DRDSSQLStatementParser#showStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowCreateDb(DRDSSQLStatementParser.ShowCreateDbContext ctx);
	/**
	 * Visit a parse tree produced by the {@code showCreatenameIdentifierObject}
	 * labeled alternative in {@link DRDSSQLStatementParser#showStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowCreatenameIdentifierObject(DRDSSQLStatementParser.ShowCreatenameIdentifierObjectContext ctx);
	/**
	 * Visit a parse tree produced by the {@code showCreateUser}
	 * labeled alternative in {@link DRDSSQLStatementParser#showStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowCreateUser(DRDSSQLStatementParser.ShowCreateUserContext ctx);
	/**
	 * Visit a parse tree produced by the {@code showEngine}
	 * labeled alternative in {@link DRDSSQLStatementParser#showStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowEngine(DRDSSQLStatementParser.ShowEngineContext ctx);
	/**
	 * Visit a parse tree produced by the {@code showGlobalInfo}
	 * labeled alternative in {@link DRDSSQLStatementParser#showStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowGlobalInfo(DRDSSQLStatementParser.ShowGlobalInfoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code showErrors}
	 * labeled alternative in {@link DRDSSQLStatementParser#showStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowErrors(DRDSSQLStatementParser.ShowErrorsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code showCountErrors}
	 * labeled alternative in {@link DRDSSQLStatementParser#showStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowCountErrors(DRDSSQLStatementParser.ShowCountErrorsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code showSchemaFilter}
	 * labeled alternative in {@link DRDSSQLStatementParser#showStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowSchemaFilter(DRDSSQLStatementParser.ShowSchemaFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code showRoutine}
	 * labeled alternative in {@link DRDSSQLStatementParser#showStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowRoutine(DRDSSQLStatementParser.ShowRoutineContext ctx);
	/**
	 * Visit a parse tree produced by the {@code showGrants}
	 * labeled alternative in {@link DRDSSQLStatementParser#showStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowGrants(DRDSSQLStatementParser.ShowGrantsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code showIndexes}
	 * labeled alternative in {@link DRDSSQLStatementParser#showStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowIndexes(DRDSSQLStatementParser.ShowIndexesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code showOpenTables}
	 * labeled alternative in {@link DRDSSQLStatementParser#showStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowOpenTables(DRDSSQLStatementParser.ShowOpenTablesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code showProfile}
	 * labeled alternative in {@link DRDSSQLStatementParser#showStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowProfile(DRDSSQLStatementParser.ShowProfileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code showSlaveStatus}
	 * labeled alternative in {@link DRDSSQLStatementParser#showStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowSlaveStatus(DRDSSQLStatementParser.ShowSlaveStatusContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#showCommonEntity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowCommonEntity(DRDSSQLStatementParser.ShowCommonEntityContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#showFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowFilter(DRDSSQLStatementParser.ShowFilterContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#showGlobalInfoClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowGlobalInfoClause(DRDSSQLStatementParser.ShowGlobalInfoClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#showSchemaEntity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowSchemaEntity(DRDSSQLStatementParser.ShowSchemaEntityContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#showProfileType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowProfileType(DRDSSQLStatementParser.ShowProfileTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#binlogStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinlogStatement(DRDSSQLStatementParser.BinlogStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#cacheIndexStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCacheIndexStatement(DRDSSQLStatementParser.CacheIndexStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#flushStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlushStatement(DRDSSQLStatementParser.FlushStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#killStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKillStatement(DRDSSQLStatementParser.KillStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#loadIndexIntoCache}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoadIndexIntoCache(DRDSSQLStatementParser.LoadIndexIntoCacheContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#resetStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResetStatement(DRDSSQLStatementParser.ResetStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#shutdownStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShutdownStatement(DRDSSQLStatementParser.ShutdownStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#tableIndexes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableIndexes(DRDSSQLStatementParser.TableIndexesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code simpleFlushOption}
	 * labeled alternative in {@link DRDSSQLStatementParser#flushOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleFlushOption(DRDSSQLStatementParser.SimpleFlushOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code channelFlushOption}
	 * labeled alternative in {@link DRDSSQLStatementParser#flushOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChannelFlushOption(DRDSSQLStatementParser.ChannelFlushOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tableFlushOption}
	 * labeled alternative in {@link DRDSSQLStatementParser#flushOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableFlushOption(DRDSSQLStatementParser.TableFlushOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#flushTableOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlushTableOption(DRDSSQLStatementParser.FlushTableOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#loadedTableIndexes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoadedTableIndexes(DRDSSQLStatementParser.LoadedTableIndexesContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#simpleDescribeStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleDescribeStatement(DRDSSQLStatementParser.SimpleDescribeStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#fullDescribeStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFullDescribeStatement(DRDSSQLStatementParser.FullDescribeStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#helpStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHelpStatement(DRDSSQLStatementParser.HelpStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#useStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUseStatement(DRDSSQLStatementParser.UseStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code describeStatements}
	 * labeled alternative in {@link DRDSSQLStatementParser#describeObjectClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDescribeStatements(DRDSSQLStatementParser.DescribeStatementsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code describeConnection}
	 * labeled alternative in {@link DRDSSQLStatementParser#describeObjectClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDescribeConnection(DRDSSQLStatementParser.DescribeConnectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#engineName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEngineName(DRDSSQLStatementParser.EngineNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#unameIdentifierSet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnameIdentifierSet(DRDSSQLStatementParser.UnameIdentifierSetContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#xid}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXid(DRDSSQLStatementParser.XidContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#xnameIdentifierStringId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXnameIdentifierStringId(DRDSSQLStatementParser.XnameIdentifierStringIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#authPlugin}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAuthPlugin(DRDSSQLStatementParser.AuthPluginContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#null_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNull_(DRDSSQLStatementParser.Null_Context ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#notNull}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotNull(DRDSSQLStatementParser.NotNullContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#convertedDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConvertedDataType(DRDSSQLStatementParser.ConvertedDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#lengthOneDimension}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLengthOneDimension(DRDSSQLStatementParser.LengthOneDimensionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#lengthTwoDimension}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLengthTwoDimension(DRDSSQLStatementParser.LengthTwoDimensionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#lengthTwoOptionalDimension}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLengthTwoOptionalDimension(DRDSSQLStatementParser.LengthTwoOptionalDimensionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#simpleStrings}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleStrings(DRDSSQLStatementParser.SimpleStringsContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#userVariables}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUserVariables(DRDSSQLStatementParser.UserVariablesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code levelWeightList}
	 * labeled alternative in {@link DRDSSQLStatementParser#levelsInWeightString}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLevelWeightList(DRDSSQLStatementParser.LevelWeightListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code levelWeightRange}
	 * labeled alternative in {@link DRDSSQLStatementParser#levelsInWeightString}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLevelWeightRange(DRDSSQLStatementParser.LevelWeightRangeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#levelInWeightListElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLevelInWeightListElement(DRDSSQLStatementParser.LevelInWeightListElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#aggregateWindowedFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAggregateWindowedFunction(DRDSSQLStatementParser.AggregateWindowedFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#charsetNameBase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharsetNameBase(DRDSSQLStatementParser.CharsetNameBaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#transactionLevelBase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTransactionLevelBase(DRDSSQLStatementParser.TransactionLevelBaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#privilegesBase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrivilegesBase(DRDSSQLStatementParser.PrivilegesBaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#dataTypeBase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataTypeBase(DRDSSQLStatementParser.DataTypeBaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#keywordsCanBeId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeywordsCanBeId(DRDSSQLStatementParser.KeywordsCanBeIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#allTokens}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAllTokens(DRDSSQLStatementParser.AllTokensContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataType(DRDSSQLStatementParser.DataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bitDataType}
	 * labeled alternative in {@link DRDSSQLStatementParser#iNumericDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitDataType(DRDSSQLStatementParser.BitDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tinyintDataType}
	 * labeled alternative in {@link DRDSSQLStatementParser#iNumericDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTinyintDataType(DRDSSQLStatementParser.TinyintDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code smallintDataType}
	 * labeled alternative in {@link DRDSSQLStatementParser#iNumericDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSmallintDataType(DRDSSQLStatementParser.SmallintDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mediumintDataType}
	 * labeled alternative in {@link DRDSSQLStatementParser#iNumericDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMediumintDataType(DRDSSQLStatementParser.MediumintDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intDataType}
	 * labeled alternative in {@link DRDSSQLStatementParser#iNumericDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntDataType(DRDSSQLStatementParser.IntDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code integerDataType}
	 * labeled alternative in {@link DRDSSQLStatementParser#iNumericDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerDataType(DRDSSQLStatementParser.IntegerDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bigintDataType}
	 * labeled alternative in {@link DRDSSQLStatementParser#iNumericDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBigintDataType(DRDSSQLStatementParser.BigintDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code decimalDataType}
	 * labeled alternative in {@link DRDSSQLStatementParser#iNumericDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecimalDataType(DRDSSQLStatementParser.DecimalDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code decDataType}
	 * labeled alternative in {@link DRDSSQLStatementParser#iNumericDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecDataType(DRDSSQLStatementParser.DecDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numericDataType}
	 * labeled alternative in {@link DRDSSQLStatementParser#iNumericDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumericDataType(DRDSSQLStatementParser.NumericDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fixedDataType}
	 * labeled alternative in {@link DRDSSQLStatementParser#iNumericDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFixedDataType(DRDSSQLStatementParser.FixedDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code floatDataType}
	 * labeled alternative in {@link DRDSSQLStatementParser#iNumericDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatDataType(DRDSSQLStatementParser.FloatDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code doubleDataType}
	 * labeled alternative in {@link DRDSSQLStatementParser#iNumericDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleDataType(DRDSSQLStatementParser.DoubleDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code doublePrecisionDataType}
	 * labeled alternative in {@link DRDSSQLStatementParser#iNumericDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoublePrecisionDataType(DRDSSQLStatementParser.DoublePrecisionDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code realDataType}
	 * labeled alternative in {@link DRDSSQLStatementParser#iNumericDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRealDataType(DRDSSQLStatementParser.RealDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code charDataType}
	 * labeled alternative in {@link DRDSSQLStatementParser#iStringDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharDataType(DRDSSQLStatementParser.CharDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nationalCharDataType}
	 * labeled alternative in {@link DRDSSQLStatementParser#iStringDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNationalCharDataType(DRDSSQLStatementParser.NationalCharDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varcharDataType}
	 * labeled alternative in {@link DRDSSQLStatementParser#iStringDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarcharDataType(DRDSSQLStatementParser.VarcharDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nationalVarcharDataType}
	 * labeled alternative in {@link DRDSSQLStatementParser#iStringDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNationalVarcharDataType(DRDSSQLStatementParser.NationalVarcharDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryDataType}
	 * labeled alternative in {@link DRDSSQLStatementParser#iStringDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryDataType(DRDSSQLStatementParser.BinaryDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varBinaryDataType}
	 * labeled alternative in {@link DRDSSQLStatementParser#iStringDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarBinaryDataType(DRDSSQLStatementParser.VarBinaryDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tinyBlobDataType}
	 * labeled alternative in {@link DRDSSQLStatementParser#iStringDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTinyBlobDataType(DRDSSQLStatementParser.TinyBlobDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tinyTextDataType}
	 * labeled alternative in {@link DRDSSQLStatementParser#iStringDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTinyTextDataType(DRDSSQLStatementParser.TinyTextDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code blobDataType}
	 * labeled alternative in {@link DRDSSQLStatementParser#iStringDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlobDataType(DRDSSQLStatementParser.BlobDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code textDataType}
	 * labeled alternative in {@link DRDSSQLStatementParser#iStringDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTextDataType(DRDSSQLStatementParser.TextDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mediumBlobDataType}
	 * labeled alternative in {@link DRDSSQLStatementParser#iStringDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMediumBlobDataType(DRDSSQLStatementParser.MediumBlobDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mediumTextDataType}
	 * labeled alternative in {@link DRDSSQLStatementParser#iStringDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMediumTextDataType(DRDSSQLStatementParser.MediumTextDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code longBlobDataType}
	 * labeled alternative in {@link DRDSSQLStatementParser#iStringDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLongBlobDataType(DRDSSQLStatementParser.LongBlobDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code longTextDataType}
	 * labeled alternative in {@link DRDSSQLStatementParser#iStringDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLongTextDataType(DRDSSQLStatementParser.LongTextDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code enumDataType}
	 * labeled alternative in {@link DRDSSQLStatementParser#iStringDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumDataType(DRDSSQLStatementParser.EnumDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code setDataType}
	 * labeled alternative in {@link DRDSSQLStatementParser#iStringDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetDataType(DRDSSQLStatementParser.SetDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dateDataType}
	 * labeled alternative in {@link DRDSSQLStatementParser#iDateTimeDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDateDataType(DRDSSQLStatementParser.DateDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code datetimeDataType}
	 * labeled alternative in {@link DRDSSQLStatementParser#iDateTimeDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDatetimeDataType(DRDSSQLStatementParser.DatetimeDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code timestampDataType}
	 * labeled alternative in {@link DRDSSQLStatementParser#iDateTimeDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimestampDataType(DRDSSQLStatementParser.TimestampDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code timeDataType}
	 * labeled alternative in {@link DRDSSQLStatementParser#iDateTimeDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimeDataType(DRDSSQLStatementParser.TimeDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code yearDataType}
	 * labeled alternative in {@link DRDSSQLStatementParser#iDateTimeDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitYearDataType(DRDSSQLStatementParser.YearDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code geometryDataType}
	 * labeled alternative in {@link DRDSSQLStatementParser#spatialDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGeometryDataType(DRDSSQLStatementParser.GeometryDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pointDataType}
	 * labeled alternative in {@link DRDSSQLStatementParser#spatialDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPointDataType(DRDSSQLStatementParser.PointDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lineStringDataType}
	 * labeled alternative in {@link DRDSSQLStatementParser#spatialDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLineStringDataType(DRDSSQLStatementParser.LineStringDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code polygonDataType}
	 * labeled alternative in {@link DRDSSQLStatementParser#spatialDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPolygonDataType(DRDSSQLStatementParser.PolygonDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiPointDataType}
	 * labeled alternative in {@link DRDSSQLStatementParser#spatialDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiPointDataType(DRDSSQLStatementParser.MultiPointDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiLineStringDataType}
	 * labeled alternative in {@link DRDSSQLStatementParser#spatialDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiLineStringDataType(DRDSSQLStatementParser.MultiLineStringDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiPolygonDataType}
	 * labeled alternative in {@link DRDSSQLStatementParser#spatialDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiPolygonDataType(DRDSSQLStatementParser.MultiPolygonDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code geometryCollectionDataType}
	 * labeled alternative in {@link DRDSSQLStatementParser#spatialDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGeometryCollectionDataType(DRDSSQLStatementParser.GeometryCollectionDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolDataType}
	 * labeled alternative in {@link DRDSSQLStatementParser#iBoolDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolDataType(DRDSSQLStatementParser.BoolDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code booleanDataType}
	 * labeled alternative in {@link DRDSSQLStatementParser#iBoolDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanDataType(DRDSSQLStatementParser.BooleanDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jsonDataType}
	 * labeled alternative in {@link DRDSSQLStatementParser#iJsonDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonDataType(DRDSSQLStatementParser.JsonDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#otherDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOtherDataType(DRDSSQLStatementParser.OtherDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code asteriskIdentifier}
	 * labeled alternative in {@link DRDSSQLStatementParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsteriskIdentifier(DRDSSQLStatementParser.AsteriskIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code normalIdentifier}
	 * labeled alternative in {@link DRDSSQLStatementParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalIdentifier(DRDSSQLStatementParser.NormalIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code reverseQuoteIdentifier}
	 * labeled alternative in {@link DRDSSQLStatementParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReverseQuoteIdentifier(DRDSSQLStatementParser.ReverseQuoteIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code doubleQuoteIdentifier1}
	 * labeled alternative in {@link DRDSSQLStatementParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleQuoteIdentifier1(DRDSSQLStatementParser.DoubleQuoteIdentifier1Context ctx);
	/**
	 * Visit a parse tree produced by the {@code identifier1}
	 * labeled alternative in {@link DRDSSQLStatementParser#nameIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier1(DRDSSQLStatementParser.Identifier1Context ctx);
	/**
	 * Visit a parse tree produced by the {@code propertyIdentifier1}
	 * labeled alternative in {@link DRDSSQLStatementParser#nameIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertyIdentifier1(DRDSSQLStatementParser.PropertyIdentifier1Context ctx);
	/**
	 * Visit a parse tree produced by the {@code nCharLiteral}
	 * labeled alternative in {@link DRDSSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNCharLiteral(DRDSSQLStatementParser.NCharLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code charLiteral}
	 * labeled alternative in {@link DRDSSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharLiteral(DRDSSQLStatementParser.CharLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code doubleQuoteIdentifier2}
	 * labeled alternative in {@link DRDSSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleQuoteIdentifier2(DRDSSQLStatementParser.DoubleQuoteIdentifier2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code charsetNamChareLiteral}
	 * labeled alternative in {@link DRDSSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharsetNamChareLiteral(DRDSSQLStatementParser.CharsetNamChareLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code integerLiteral}
	 * labeled alternative in {@link DRDSSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerLiteral(DRDSSQLStatementParser.IntegerLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numberLiteral}
	 * labeled alternative in {@link DRDSSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberLiteral(DRDSSQLStatementParser.NumberLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dateLiteral}
	 * labeled alternative in {@link DRDSSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDateLiteral(DRDSSQLStatementParser.DateLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code timeLiteral}
	 * labeled alternative in {@link DRDSSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimeLiteral(DRDSSQLStatementParser.TimeLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code timestampLiteral}
	 * labeled alternative in {@link DRDSSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimestampLiteral(DRDSSQLStatementParser.TimestampLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intervalLiteral}
	 * labeled alternative in {@link DRDSSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntervalLiteral(DRDSSQLStatementParser.IntervalLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code hexadecimalLiteral}
	 * labeled alternative in {@link DRDSSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHexadecimalLiteral(DRDSSQLStatementParser.HexadecimalLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bitLiteral}
	 * labeled alternative in {@link DRDSSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitLiteral(DRDSSQLStatementParser.BitLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code falseLiteral}
	 * labeled alternative in {@link DRDSSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalseLiteral(DRDSSQLStatementParser.FalseLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code trueLiteral}
	 * labeled alternative in {@link DRDSSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueLiteral(DRDSSQLStatementParser.TrueLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nullLiteral}
	 * labeled alternative in {@link DRDSSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullLiteral(DRDSSQLStatementParser.NullLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#intervalType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntervalType(DRDSSQLStatementParser.IntervalTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#unaryOperatorExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryOperatorExpr(DRDSSQLStatementParser.UnaryOperatorExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#unaryOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryOperator(DRDSSQLStatementParser.UnaryOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#variableExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableExpr(DRDSSQLStatementParser.VariableExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#localVariableExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVariableExpr(DRDSSQLStatementParser.LocalVariableExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#globalVariableExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobalVariableExpr(DRDSSQLStatementParser.GlobalVariableExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#globalGlobalVariableExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobalGlobalVariableExpr(DRDSSQLStatementParser.GlobalGlobalVariableExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#sessionGlobalVariableExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSessionGlobalVariableExpr(DRDSSQLStatementParser.SessionGlobalVariableExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#persistGlobalVariableExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPersistGlobalVariableExpr(DRDSSQLStatementParser.PersistGlobalVariableExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#persistOnlyGlobalVariableExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPersistOnlyGlobalVariableExpr(DRDSSQLStatementParser.PersistOnlyGlobalVariableExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#rowExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowExpr(DRDSSQLStatementParser.RowExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#selectQueryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectQueryExpr(DRDSSQLStatementParser.SelectQueryExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#matchExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatchExpr(DRDSSQLStatementParser.MatchExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#searchModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSearchModifier(DRDSSQLStatementParser.SearchModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#caseExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseExpr(DRDSSQLStatementParser.CaseExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#caseExprWhenItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseExprWhenItem(DRDSSQLStatementParser.CaseExprWhenItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#caseExprElseClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseExprElseClause(DRDSSQLStatementParser.CaseExprElseClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#listExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListExpr(DRDSSQLStatementParser.ListExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#exprBasic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprBasic(DRDSSQLStatementParser.ExprBasicContext ctx);
	/**
	 * Visit a parse tree produced by the {@code soundsLikeCondition}
	 * labeled alternative in {@link DRDSSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSoundsLikeCondition(DRDSSQLStatementParser.SoundsLikeConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rlikeCondition}
	 * labeled alternative in {@link DRDSSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRlikeCondition(DRDSSQLStatementParser.RlikeConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inCondition}
	 * labeled alternative in {@link DRDSSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInCondition(DRDSSQLStatementParser.InConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code someExpr}
	 * labeled alternative in {@link DRDSSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSomeExpr(DRDSSQLStatementParser.SomeExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newVariableRefExpr}
	 * labeled alternative in {@link DRDSSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewVariableRefExpr(DRDSSQLStatementParser.NewVariableRefExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code isNullCondition}
	 * labeled alternative in {@link DRDSSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsNullCondition(DRDSSQLStatementParser.IsNullConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code regexpCondition}
	 * labeled alternative in {@link DRDSSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegexpCondition(DRDSSQLStatementParser.RegexpConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code iCondition}
	 * labeled alternative in {@link DRDSSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitICondition(DRDSSQLStatementParser.IConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryOperatorExpr}
	 * labeled alternative in {@link DRDSSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryOperatorExpr(DRDSSQLStatementParser.BinaryOperatorExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code likeCondition}
	 * labeled alternative in {@link DRDSSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLikeCondition(DRDSSQLStatementParser.LikeConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code allExpr}
	 * labeled alternative in {@link DRDSSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAllExpr(DRDSSQLStatementParser.AllExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code oldVariableRefExpr}
	 * labeled alternative in {@link DRDSSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOldVariableRefExpr(DRDSSQLStatementParser.OldVariableRefExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code propertyIdentifier2}
	 * labeled alternative in {@link DRDSSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertyIdentifier2(DRDSSQLStatementParser.PropertyIdentifier2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code methodInvocation1}
	 * labeled alternative in {@link DRDSSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodInvocation1(DRDSSQLStatementParser.MethodInvocation1Context ctx);
	/**
	 * Visit a parse tree produced by the {@code basicExpr}
	 * labeled alternative in {@link DRDSSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicExpr(DRDSSQLStatementParser.BasicExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code methodInvocation2}
	 * labeled alternative in {@link DRDSSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodInvocation2(DRDSSQLStatementParser.MethodInvocation2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code betweenCondition}
	 * labeled alternative in {@link DRDSSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBetweenCondition(DRDSSQLStatementParser.BetweenConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cursorExpr}
	 * labeled alternative in {@link DRDSSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCursorExpr(DRDSSQLStatementParser.CursorExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code anyExpr}
	 * labeled alternative in {@link DRDSSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnyExpr(DRDSSQLStatementParser.AnyExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code comparisonBinaryOperatorExpr}
	 * labeled alternative in {@link DRDSSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonBinaryOperatorExpr(DRDSSQLStatementParser.ComparisonBinaryOperatorExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprToExprExpr}
	 * labeled alternative in {@link DRDSSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprToExprExpr(DRDSSQLStatementParser.ExprToExprExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code isBooleanLiteralCondition}
	 * labeled alternative in {@link DRDSSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsBooleanLiteralCondition(DRDSSQLStatementParser.IsBooleanLiteralConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#comparisonOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonOp(DRDSSQLStatementParser.ComparisonOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#defaultClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultClause(DRDSSQLStatementParser.DefaultClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#autoIncrementOptionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAutoIncrementOptionExpr(DRDSSQLStatementParser.AutoIncrementOptionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#avgRowLengthOptionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAvgRowLengthOptionExpr(DRDSSQLStatementParser.AvgRowLengthOptionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#characterSetOptionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharacterSetOptionExpr(DRDSSQLStatementParser.CharacterSetOptionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#charsetOptionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharsetOptionExpr(DRDSSQLStatementParser.CharsetOptionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#checksumOptionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChecksumOptionExpr(DRDSSQLStatementParser.ChecksumOptionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#collateOptionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCollateOptionExpr(DRDSSQLStatementParser.CollateOptionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#commentOptionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommentOptionExpr(DRDSSQLStatementParser.CommentOptionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#compressionOptionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompressionOptionExpr(DRDSSQLStatementParser.CompressionOptionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#connectionOptionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConnectionOptionExpr(DRDSSQLStatementParser.ConnectionOptionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#dataDirectoryOptionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataDirectoryOptionExpr(DRDSSQLStatementParser.DataDirectoryOptionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#indexDirectoryOptionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexDirectoryOptionExpr(DRDSSQLStatementParser.IndexDirectoryOptionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#delayKeyWriteOptionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDelayKeyWriteOptionExpr(DRDSSQLStatementParser.DelayKeyWriteOptionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#encryptionOptionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEncryptionOptionExpr(DRDSSQLStatementParser.EncryptionOptionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#engineOptionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEngineOptionExpr(DRDSSQLStatementParser.EngineOptionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#insertMethodOptionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsertMethodOptionExpr(DRDSSQLStatementParser.InsertMethodOptionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#keyBlockSizeOptionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyBlockSizeOptionExpr(DRDSSQLStatementParser.KeyBlockSizeOptionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#maxRowsOptionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMaxRowsOptionExpr(DRDSSQLStatementParser.MaxRowsOptionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#minRowsOptionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinRowsOptionExpr(DRDSSQLStatementParser.MinRowsOptionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#packKeysOptionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackKeysOptionExpr(DRDSSQLStatementParser.PackKeysOptionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#passwordOptionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPasswordOptionExpr(DRDSSQLStatementParser.PasswordOptionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#rowFormatOptionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowFormatOptionExpr(DRDSSQLStatementParser.RowFormatOptionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#statsAutoRecalcOptionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatsAutoRecalcOptionExpr(DRDSSQLStatementParser.StatsAutoRecalcOptionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#statsPersistentOptionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatsPersistentOptionExpr(DRDSSQLStatementParser.StatsPersistentOptionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#statsSamplePageOptionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatsSamplePageOptionExpr(DRDSSQLStatementParser.StatsSamplePageOptionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#tablespaceOptionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTablespaceOptionExpr(DRDSSQLStatementParser.TablespaceOptionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#unionOptionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnionOptionExpr(DRDSSQLStatementParser.UnionOptionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#broadcastExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBroadcastExpr(DRDSSQLStatementParser.BroadcastExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#assignmentExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentExpr(DRDSSQLStatementParser.AssignmentExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#defaultLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultLiteral(DRDSSQLStatementParser.DefaultLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#allLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAllLiteral(DRDSSQLStatementParser.AllLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#noneLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoneLiteral(DRDSSQLStatementParser.NoneLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#maxValueLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMaxValueLiteral(DRDSSQLStatementParser.MaxValueLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(DRDSSQLStatementParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#notCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotCondition(DRDSSQLStatementParser.NotConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#formatJson}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormatJson(DRDSSQLStatementParser.FormatJsonContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#exprAsObjectExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAsObjectExpr(DRDSSQLStatementParser.ExprAsObjectExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#existsCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExistsCondition(DRDSSQLStatementParser.ExistsConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code castFunction}
	 * labeled alternative in {@link DRDSSQLStatementParser#specificFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCastFunction(DRDSSQLStatementParser.CastFunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code charFunction}
	 * labeled alternative in {@link DRDSSQLStatementParser#specificFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharFunction(DRDSSQLStatementParser.CharFunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dataTypeFunctionCall}
	 * labeled alternative in {@link DRDSSQLStatementParser#specificFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataTypeFunctionCall(DRDSSQLStatementParser.DataTypeFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code valuesFunctionCall}
	 * labeled alternative in {@link DRDSSQLStatementParser#specificFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValuesFunctionCall(DRDSSQLStatementParser.ValuesFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code positionFunctionCall}
	 * labeled alternative in {@link DRDSSQLStatementParser#specificFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPositionFunctionCall(DRDSSQLStatementParser.PositionFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code substrFunctionCall}
	 * labeled alternative in {@link DRDSSQLStatementParser#specificFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubstrFunctionCall(DRDSSQLStatementParser.SubstrFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code trimFunctionCall}
	 * labeled alternative in {@link DRDSSQLStatementParser#specificFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrimFunctionCall(DRDSSQLStatementParser.TrimFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code weightFunctionCall}
	 * labeled alternative in {@link DRDSSQLStatementParser#specificFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWeightFunctionCall(DRDSSQLStatementParser.WeightFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code getFormatFunctionCall}
	 * labeled alternative in {@link DRDSSQLStatementParser#specificFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGetFormatFunctionCall(DRDSSQLStatementParser.GetFormatFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(DRDSSQLStatementParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#noArgumentFunctionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoArgumentFunctionName(DRDSSQLStatementParser.NoArgumentFunctionNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#positionFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPositionFunction(DRDSSQLStatementParser.PositionFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#subStrFromFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubStrFromFunction(DRDSSQLStatementParser.SubStrFromFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#subStringFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubStringFunction(DRDSSQLStatementParser.SubStringFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#trimFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrimFunction(DRDSSQLStatementParser.TrimFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#weightStringFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWeightStringFunction(DRDSSQLStatementParser.WeightStringFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#extractFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtractFunction(DRDSSQLStatementParser.ExtractFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#treatFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTreatFunction(DRDSSQLStatementParser.TreatFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#convertUsingFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConvertUsingFunction(DRDSSQLStatementParser.ConvertUsingFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#costMatrixClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCostMatrixClause(DRDSSQLStatementParser.CostMatrixClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#jsonFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonFunction(DRDSSQLStatementParser.JsonFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#jsonFunctionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonFunctionName(DRDSSQLStatementParser.JsonFunctionNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#jsonFunctionArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonFunctionArgument(DRDSSQLStatementParser.JsonFunctionArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#jsonFormatJsonArgumentExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonFormatJsonArgumentExpr(DRDSSQLStatementParser.JsonFormatJsonArgumentExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#jsonKeyValueArgumentExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonKeyValueArgumentExpr(DRDSSQLStatementParser.JsonKeyValueArgumentExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#jsonOnNullClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonOnNullClause(DRDSSQLStatementParser.JsonOnNullClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#jsonReturningClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonReturningClause(DRDSSQLStatementParser.JsonReturningClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#withUniqueKeys}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithUniqueKeys(DRDSSQLStatementParser.WithUniqueKeysContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#jsonWrapperClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonWrapperClause(DRDSSQLStatementParser.JsonWrapperClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#jsonOnErrorClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonOnErrorClause(DRDSSQLStatementParser.JsonOnErrorClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#jsonOnEmptyClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonOnEmptyClause(DRDSSQLStatementParser.JsonOnEmptyClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#jsonColumnsClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonColumnsClause(DRDSSQLStatementParser.JsonColumnsClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jsonExistsColumn}
	 * labeled alternative in {@link DRDSSQLStatementParser#jsonColumnDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonExistsColumn(DRDSSQLStatementParser.JsonExistsColumnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jsonQueryColumn}
	 * labeled alternative in {@link DRDSSQLStatementParser#jsonColumnDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonQueryColumn(DRDSSQLStatementParser.JsonQueryColumnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jsonValueColumn}
	 * labeled alternative in {@link DRDSSQLStatementParser#jsonColumnDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonValueColumn(DRDSSQLStatementParser.JsonValueColumnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jsonNestedPathColumn}
	 * labeled alternative in {@link DRDSSQLStatementParser#jsonColumnDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonNestedPathColumn(DRDSSQLStatementParser.JsonNestedPathColumnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jsonOrdinalityColumn}
	 * labeled alternative in {@link DRDSSQLStatementParser#jsonColumnDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonOrdinalityColumn(DRDSSQLStatementParser.JsonOrdinalityColumnContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#aggregateFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAggregateFunction(DRDSSQLStatementParser.AggregateFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#aggregateFunctionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAggregateFunctionName(DRDSSQLStatementParser.AggregateFunctionNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#withinGroupSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithinGroupSpecification(DRDSSQLStatementParser.WithinGroupSpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#firstFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFirstFunction(DRDSSQLStatementParser.FirstFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#lastFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLastFunction(DRDSSQLStatementParser.LastFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#listAggFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListAggFunction(DRDSSQLStatementParser.ListAggFunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code onOverflowErrorClause}
	 * labeled alternative in {@link DRDSSQLStatementParser#listaggOverflowClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOnOverflowErrorClause(DRDSSQLStatementParser.OnOverflowErrorClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code onOverflowTruncateClause}
	 * labeled alternative in {@link DRDSSQLStatementParser#listaggOverflowClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOnOverflowTruncateClause(DRDSSQLStatementParser.OnOverflowTruncateClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#windowFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWindowFunction(DRDSSQLStatementParser.WindowFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#windowFunctionNullsOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWindowFunctionNullsOption(DRDSSQLStatementParser.WindowFunctionNullsOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#windowFunctionFromOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWindowFunctionFromOption(DRDSSQLStatementParser.WindowFunctionFromOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#overClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOverClause(DRDSSQLStatementParser.OverClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#analyticClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnalyticClause(DRDSSQLStatementParser.AnalyticClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#partitionByClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionByClause(DRDSSQLStatementParser.PartitionByClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#windowFrameClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWindowFrameClause(DRDSSQLStatementParser.WindowFrameClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#windowFrameUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWindowFrameUnit(DRDSSQLStatementParser.WindowFrameUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#windowFrameExtent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWindowFrameExtent(DRDSSQLStatementParser.WindowFrameExtentContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#windowFrameExtentItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWindowFrameExtentItem(DRDSSQLStatementParser.WindowFrameExtentItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#cubeTableFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCubeTableFunction(DRDSSQLStatementParser.CubeTableFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#cubeTableOptionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCubeTableOptionExpr(DRDSSQLStatementParser.CubeTableOptionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#orReplace}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrReplace(DRDSSQLStatementParser.OrReplaceContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#ifExists}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfExists(DRDSSQLStatementParser.IfExistsContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#ifNotExists}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfNotExists(DRDSSQLStatementParser.IfNotExistsContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#withRollup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithRollup(DRDSSQLStatementParser.WithRollupContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#orderingSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrderingSpecification(DRDSSQLStatementParser.OrderingSpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#intimeAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntimeAction(DRDSSQLStatementParser.IntimeActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#indexCategory}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexCategory(DRDSSQLStatementParser.IndexCategoryContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#indexFormat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexFormat(DRDSSQLStatementParser.IndexFormatContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#indexType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexType(DRDSSQLStatementParser.IndexTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#withType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithType(DRDSSQLStatementParser.WithTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#visibleType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVisibleType(DRDSSQLStatementParser.VisibleTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRDSSQLStatementParser#priority}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPriority(DRDSSQLStatementParser.PriorityContext ctx);
}