// Generated from /Users/kongtong.ouyang/IdeaProjects/gumiho/gumiho/src/main/resources/grammars/sql/dialect/mysql/MySQLSQLStatementParser.g4 by ANTLR 4.7
package com.aliyun.gumiho.sql.dialect.mysql.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MySQLSQLStatementParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MySQLSQLStatementParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#parse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParse(MySQLSQLStatementParser.ParseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(MySQLSQLStatementParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#ddlStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDdlStatement(MySQLSQLStatementParser.DdlStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#dmlStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDmlStatement(MySQLSQLStatementParser.DmlStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#transactionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTransactionStatement(MySQLSQLStatementParser.TransactionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#replicationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReplicationStatement(MySQLSQLStatementParser.ReplicationStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#preparedStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreparedStatement(MySQLSQLStatementParser.PreparedStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#compoundStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompoundStatement(MySQLSQLStatementParser.CompoundStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#administrationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdministrationStatement(MySQLSQLStatementParser.AdministrationStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#utilityStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUtilityStatement(MySQLSQLStatementParser.UtilityStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#createDatabaseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateDatabaseStatement(MySQLSQLStatementParser.CreateDatabaseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#createSchemaStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateSchemaStatement(MySQLSQLStatementParser.CreateSchemaStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#createEventStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateEventStatement(MySQLSQLStatementParser.CreateEventStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#createIndexStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateIndexStatement(MySQLSQLStatementParser.CreateIndexStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#createIndexStatementColumn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateIndexStatementColumn(MySQLSQLStatementParser.CreateIndexStatementColumnContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#createIndexStatementOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateIndexStatementOption(MySQLSQLStatementParser.CreateIndexStatementOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#algorithmOptionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlgorithmOptionExpr(MySQLSQLStatementParser.AlgorithmOptionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#lockOptionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLockOptionExpr(MySQLSQLStatementParser.LockOptionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#createLogfileGroupStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateLogfileGroupStatement(MySQLSQLStatementParser.CreateLogfileGroupStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#createProcedureStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateProcedureStatement(MySQLSQLStatementParser.CreateProcedureStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#createFunctionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateFunctionStatement(MySQLSQLStatementParser.CreateFunctionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#createServerStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateServerStatement(MySQLSQLStatementParser.CreateServerStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code serverHostOption}
	 * labeled alternative in {@link MySQLSQLStatementParser#serverOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitServerHostOption(MySQLSQLStatementParser.ServerHostOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code serverDatabaseOption}
	 * labeled alternative in {@link MySQLSQLStatementParser#serverOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitServerDatabaseOption(MySQLSQLStatementParser.ServerDatabaseOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code serverUserOption}
	 * labeled alternative in {@link MySQLSQLStatementParser#serverOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitServerUserOption(MySQLSQLStatementParser.ServerUserOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code serverPasswordOption}
	 * labeled alternative in {@link MySQLSQLStatementParser#serverOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitServerPasswordOption(MySQLSQLStatementParser.ServerPasswordOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code serverSocketOption}
	 * labeled alternative in {@link MySQLSQLStatementParser#serverOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitServerSocketOption(MySQLSQLStatementParser.ServerSocketOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code serverOwnerOption}
	 * labeled alternative in {@link MySQLSQLStatementParser#serverOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitServerOwnerOption(MySQLSQLStatementParser.ServerOwnerOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code serverPortOption}
	 * labeled alternative in {@link MySQLSQLStatementParser#serverOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitServerPortOption(MySQLSQLStatementParser.ServerPortOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#createTableStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTableStatement(MySQLSQLStatementParser.CreateTableStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#tableElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableElement(MySQLSQLStatementParser.TableElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#columnDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnDefinition(MySQLSQLStatementParser.ColumnDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#likeClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLikeClause(MySQLSQLStatementParser.LikeClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nullColumnConstraint}
	 * labeled alternative in {@link MySQLSQLStatementParser#columnConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullColumnConstraint(MySQLSQLStatementParser.NullColumnConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notNullColumnConstraint}
	 * labeled alternative in {@link MySQLSQLStatementParser#columnConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotNullColumnConstraint(MySQLSQLStatementParser.NotNullColumnConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code defaultColumnConstraint}
	 * labeled alternative in {@link MySQLSQLStatementParser#columnConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultColumnConstraint(MySQLSQLStatementParser.DefaultColumnConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code autoIncrementColumnConstraint}
	 * labeled alternative in {@link MySQLSQLStatementParser#columnConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAutoIncrementColumnConstraint(MySQLSQLStatementParser.AutoIncrementColumnConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryKeyColumnConstraint}
	 * labeled alternative in {@link MySQLSQLStatementParser#columnConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryKeyColumnConstraint(MySQLSQLStatementParser.PrimaryKeyColumnConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code uniqueColumnConstraint}
	 * labeled alternative in {@link MySQLSQLStatementParser#columnConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUniqueColumnConstraint(MySQLSQLStatementParser.UniqueColumnConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code commentClause}
	 * labeled alternative in {@link MySQLSQLStatementParser#columnConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommentClause(MySQLSQLStatementParser.CommentClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code formatColumnConstraint}
	 * labeled alternative in {@link MySQLSQLStatementParser#columnConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormatColumnConstraint(MySQLSQLStatementParser.FormatColumnConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code storageColumnConstraint}
	 * labeled alternative in {@link MySQLSQLStatementParser#columnConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStorageColumnConstraint(MySQLSQLStatementParser.StorageColumnConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code referencesColumnConstraint}
	 * labeled alternative in {@link MySQLSQLStatementParser#columnConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReferencesColumnConstraint(MySQLSQLStatementParser.ReferencesColumnConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryKeyTableConstraint}
	 * labeled alternative in {@link MySQLSQLStatementParser#tableConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryKeyTableConstraint(MySQLSQLStatementParser.PrimaryKeyTableConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code indexTableConstraint}
	 * labeled alternative in {@link MySQLSQLStatementParser#tableConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexTableConstraint(MySQLSQLStatementParser.IndexTableConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code keyTableConstraint}
	 * labeled alternative in {@link MySQLSQLStatementParser#tableConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyTableConstraint(MySQLSQLStatementParser.KeyTableConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code uniqueTableConstraint}
	 * labeled alternative in {@link MySQLSQLStatementParser#tableConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUniqueTableConstraint(MySQLSQLStatementParser.UniqueTableConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fullTextTableConstraint}
	 * labeled alternative in {@link MySQLSQLStatementParser#tableConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFullTextTableConstraint(MySQLSQLStatementParser.FullTextTableConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code spatialTableConstraint}
	 * labeled alternative in {@link MySQLSQLStatementParser#tableConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpatialTableConstraint(MySQLSQLStatementParser.SpatialTableConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code foreignKeyTableConstraint}
	 * labeled alternative in {@link MySQLSQLStatementParser#tableConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForeignKeyTableConstraint(MySQLSQLStatementParser.ForeignKeyTableConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code checkTableConstraint}
	 * labeled alternative in {@link MySQLSQLStatementParser#tableConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCheckTableConstraint(MySQLSQLStatementParser.CheckTableConstraintContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#constraintColumn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstraintColumn(MySQLSQLStatementParser.ConstraintColumnContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#matchType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatchType(MySQLSQLStatementParser.MatchTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code onDeleteAction}
	 * labeled alternative in {@link MySQLSQLStatementParser#referenceTriggerAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOnDeleteAction(MySQLSQLStatementParser.OnDeleteActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code onUpdateAction}
	 * labeled alternative in {@link MySQLSQLStatementParser#referenceTriggerAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOnUpdateAction(MySQLSQLStatementParser.OnUpdateActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#referenceControlType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReferenceControlType(MySQLSQLStatementParser.ReferenceControlTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#tableOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableOption(MySQLSQLStatementParser.TableOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code partitionByHash}
	 * labeled alternative in {@link MySQLSQLStatementParser#iPartitionBy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionByHash(MySQLSQLStatementParser.PartitionByHashContext ctx);
	/**
	 * Visit a parse tree produced by the {@code partitionByKey}
	 * labeled alternative in {@link MySQLSQLStatementParser#iPartitionBy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionByKey(MySQLSQLStatementParser.PartitionByKeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code partitionByRange}
	 * labeled alternative in {@link MySQLSQLStatementParser#iPartitionBy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionByRange(MySQLSQLStatementParser.PartitionByRangeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code partitionByRangeColumns}
	 * labeled alternative in {@link MySQLSQLStatementParser#iPartitionBy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionByRangeColumns(MySQLSQLStatementParser.PartitionByRangeColumnsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code partitionByList}
	 * labeled alternative in {@link MySQLSQLStatementParser#iPartitionBy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionByList(MySQLSQLStatementParser.PartitionByListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code partitionByListColumns}
	 * labeled alternative in {@link MySQLSQLStatementParser#iPartitionBy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionByListColumns(MySQLSQLStatementParser.PartitionByListColumnsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code subPartitionByHash}
	 * labeled alternative in {@link MySQLSQLStatementParser#iSubPartitionBy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubPartitionByHash(MySQLSQLStatementParser.SubPartitionByHashContext ctx);
	/**
	 * Visit a parse tree produced by the {@code subPartitionByKey}
	 * labeled alternative in {@link MySQLSQLStatementParser#iSubPartitionBy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubPartitionByKey(MySQLSQLStatementParser.SubPartitionByKeyContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#partitionDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionDefinition(MySQLSQLStatementParser.PartitionDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code partitionValuesLessThan}
	 * labeled alternative in {@link MySQLSQLStatementParser#iPartitionValues}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionValuesLessThan(MySQLSQLStatementParser.PartitionValuesLessThanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code partitionValuesLessThanMaxValue}
	 * labeled alternative in {@link MySQLSQLStatementParser#iPartitionValues}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionValuesLessThanMaxValue(MySQLSQLStatementParser.PartitionValuesLessThanMaxValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code partitionValuesIn}
	 * labeled alternative in {@link MySQLSQLStatementParser#iPartitionValues}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionValuesIn(MySQLSQLStatementParser.PartitionValuesInContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#subPartitionDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubPartitionDefinition(MySQLSQLStatementParser.SubPartitionDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code partitionOptionEngine}
	 * labeled alternative in {@link MySQLSQLStatementParser#partitionOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionOptionEngine(MySQLSQLStatementParser.PartitionOptionEngineContext ctx);
	/**
	 * Visit a parse tree produced by the {@code partitionOptionComment}
	 * labeled alternative in {@link MySQLSQLStatementParser#partitionOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionOptionComment(MySQLSQLStatementParser.PartitionOptionCommentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code partitionOptionDataDirectory}
	 * labeled alternative in {@link MySQLSQLStatementParser#partitionOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionOptionDataDirectory(MySQLSQLStatementParser.PartitionOptionDataDirectoryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code partitionOptionIndexDirectory}
	 * labeled alternative in {@link MySQLSQLStatementParser#partitionOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionOptionIndexDirectory(MySQLSQLStatementParser.PartitionOptionIndexDirectoryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code partitionOptionMaxRows}
	 * labeled alternative in {@link MySQLSQLStatementParser#partitionOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionOptionMaxRows(MySQLSQLStatementParser.PartitionOptionMaxRowsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code partitionOptionMinRows}
	 * labeled alternative in {@link MySQLSQLStatementParser#partitionOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionOptionMinRows(MySQLSQLStatementParser.PartitionOptionMinRowsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code partitionOptionTablespace}
	 * labeled alternative in {@link MySQLSQLStatementParser#partitionOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionOptionTablespace(MySQLSQLStatementParser.PartitionOptionTablespaceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code partitionOptionNodeGroup}
	 * labeled alternative in {@link MySQLSQLStatementParser#partitionOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionOptionNodeGroup(MySQLSQLStatementParser.PartitionOptionNodeGroupContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#createTablespaceStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTablespaceStatement(MySQLSQLStatementParser.CreateTablespaceStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#createTablespaceInnodb}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTablespaceInnodb(MySQLSQLStatementParser.CreateTablespaceInnodbContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#createTablespaceNdb}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTablespaceNdb(MySQLSQLStatementParser.CreateTablespaceNdbContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#createTriggerStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTriggerStatement(MySQLSQLStatementParser.CreateTriggerStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#definerOptionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefinerOptionExpr(MySQLSQLStatementParser.DefinerOptionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#triggerOrderingClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTriggerOrderingClause(MySQLSQLStatementParser.TriggerOrderingClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#createViewStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateViewStatement(MySQLSQLStatementParser.CreateViewStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#withCheckOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithCheckOption(MySQLSQLStatementParser.WithCheckOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#createDatabaseOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateDatabaseOption(MySQLSQLStatementParser.CreateDatabaseOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code preciseSchedule}
	 * labeled alternative in {@link MySQLSQLStatementParser#scheduleexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreciseSchedule(MySQLSQLStatementParser.PreciseScheduleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intervalSchedule}
	 * labeled alternative in {@link MySQLSQLStatementParser#scheduleexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntervalSchedule(MySQLSQLStatementParser.IntervalScheduleContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#timestampValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimestampValue(MySQLSQLStatementParser.TimestampValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#enableType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnableType(MySQLSQLStatementParser.EnableTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#indexOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexOption(MySQLSQLStatementParser.IndexOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#indexOptionKeyBlockSize}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexOptionKeyBlockSize(MySQLSQLStatementParser.IndexOptionKeyBlockSizeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#indexOptionUsingBtree}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexOptionUsingBtree(MySQLSQLStatementParser.IndexOptionUsingBtreeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#indexOptionUsingHash}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexOptionUsingHash(MySQLSQLStatementParser.IndexOptionUsingHashContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#indexOptionWithParser}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexOptionWithParser(MySQLSQLStatementParser.IndexOptionWithParserContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#indexAttributeVisible}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexAttributeVisible(MySQLSQLStatementParser.IndexAttributeVisibleContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#indexAttributeInvisible}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexAttributeInvisible(MySQLSQLStatementParser.IndexAttributeInvisibleContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#indexOptionCommentOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexOptionCommentOption(MySQLSQLStatementParser.IndexOptionCommentOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#parameterDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterDeclaration(MySQLSQLStatementParser.ParameterDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code routineComment}
	 * labeled alternative in {@link MySQLSQLStatementParser#routineOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoutineComment(MySQLSQLStatementParser.RoutineCommentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code routineLanguage}
	 * labeled alternative in {@link MySQLSQLStatementParser#routineOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoutineLanguage(MySQLSQLStatementParser.RoutineLanguageContext ctx);
	/**
	 * Visit a parse tree produced by the {@code routineBehavior}
	 * labeled alternative in {@link MySQLSQLStatementParser#routineOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoutineBehavior(MySQLSQLStatementParser.RoutineBehaviorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code routineData}
	 * labeled alternative in {@link MySQLSQLStatementParser#routineOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoutineData(MySQLSQLStatementParser.RoutineDataContext ctx);
	/**
	 * Visit a parse tree produced by the {@code routineSecurity}
	 * labeled alternative in {@link MySQLSQLStatementParser#routineOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoutineSecurity(MySQLSQLStatementParser.RoutineSecurityContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterSimpleDatabase}
	 * labeled alternative in {@link MySQLSQLStatementParser#alterDatabaseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterSimpleDatabase(MySQLSQLStatementParser.AlterSimpleDatabaseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterUpgradeName}
	 * labeled alternative in {@link MySQLSQLStatementParser#alterDatabaseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterUpgradeName(MySQLSQLStatementParser.AlterUpgradeNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterSimpleSchema}
	 * labeled alternative in {@link MySQLSQLStatementParser#alterSchemaStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterSimpleSchema(MySQLSQLStatementParser.AlterSimpleSchemaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterSchemaUpgradeName}
	 * labeled alternative in {@link MySQLSQLStatementParser#alterSchemaStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterSchemaUpgradeName(MySQLSQLStatementParser.AlterSchemaUpgradeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#alterEventStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterEventStatement(MySQLSQLStatementParser.AlterEventStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#alterFunctionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterFunctionStatement(MySQLSQLStatementParser.AlterFunctionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#alterInstanceStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterInstanceStatement(MySQLSQLStatementParser.AlterInstanceStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#alterLogfileGroupStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterLogfileGroupStatement(MySQLSQLStatementParser.AlterLogfileGroupStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#alterProcedureStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterProcedureStatement(MySQLSQLStatementParser.AlterProcedureStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#alterServerStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterServerStatement(MySQLSQLStatementParser.AlterServerStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#alterTableStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableStatement(MySQLSQLStatementParser.AlterTableStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterByTableOption}
	 * labeled alternative in {@link MySQLSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterByTableOption(MySQLSQLStatementParser.AlterByTableOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableAddColumnAction}
	 * labeled alternative in {@link MySQLSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableAddColumnAction(MySQLSQLStatementParser.AlterTableAddColumnActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableAddTableConstraintAction}
	 * labeled alternative in {@link MySQLSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableAddTableConstraintAction(MySQLSQLStatementParser.AlterTableAddTableConstraintActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableAlgorithmAction}
	 * labeled alternative in {@link MySQLSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableAlgorithmAction(MySQLSQLStatementParser.AlterTableAlgorithmActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableAlterColumnAction}
	 * labeled alternative in {@link MySQLSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableAlterColumnAction(MySQLSQLStatementParser.AlterTableAlterColumnActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableAlterIndexConstraintAction}
	 * labeled alternative in {@link MySQLSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableAlterIndexConstraintAction(MySQLSQLStatementParser.AlterTableAlterIndexConstraintActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableChangeColumnAction}
	 * labeled alternative in {@link MySQLSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableChangeColumnAction(MySQLSQLStatementParser.AlterTableChangeColumnActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableDefaultCharsetAction}
	 * labeled alternative in {@link MySQLSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableDefaultCharsetAction(MySQLSQLStatementParser.AlterTableDefaultCharsetActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableConvertCharsetAction}
	 * labeled alternative in {@link MySQLSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableConvertCharsetAction(MySQLSQLStatementParser.AlterTableConvertCharsetActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableDisableKeysAction}
	 * labeled alternative in {@link MySQLSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableDisableKeysAction(MySQLSQLStatementParser.AlterTableDisableKeysActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableEnableKeysAction}
	 * labeled alternative in {@link MySQLSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableEnableKeysAction(MySQLSQLStatementParser.AlterTableEnableKeysActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableDiscardTablespaceAction}
	 * labeled alternative in {@link MySQLSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableDiscardTablespaceAction(MySQLSQLStatementParser.AlterTableDiscardTablespaceActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableImportTablespaceAction}
	 * labeled alternative in {@link MySQLSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableImportTablespaceAction(MySQLSQLStatementParser.AlterTableImportTablespaceActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableDropColumnAction}
	 * labeled alternative in {@link MySQLSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableDropColumnAction(MySQLSQLStatementParser.AlterTableDropColumnActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableDropIndexConstraintAction}
	 * labeled alternative in {@link MySQLSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableDropIndexConstraintAction(MySQLSQLStatementParser.AlterTableDropIndexConstraintActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableDropKeyConstraintAction}
	 * labeled alternative in {@link MySQLSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableDropKeyConstraintAction(MySQLSQLStatementParser.AlterTableDropKeyConstraintActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableDropPrimaryKeyConstraintAction}
	 * labeled alternative in {@link MySQLSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableDropPrimaryKeyConstraintAction(MySQLSQLStatementParser.AlterTableDropPrimaryKeyConstraintActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableDropForeignKeyConstraintAction}
	 * labeled alternative in {@link MySQLSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableDropForeignKeyConstraintAction(MySQLSQLStatementParser.AlterTableDropForeignKeyConstraintActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableForceAction}
	 * labeled alternative in {@link MySQLSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableForceAction(MySQLSQLStatementParser.AlterTableForceActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableLockAction}
	 * labeled alternative in {@link MySQLSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableLockAction(MySQLSQLStatementParser.AlterTableLockActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableModifyColumnAction}
	 * labeled alternative in {@link MySQLSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableModifyColumnAction(MySQLSQLStatementParser.AlterTableModifyColumnActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableOrderByColumnAction}
	 * labeled alternative in {@link MySQLSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableOrderByColumnAction(MySQLSQLStatementParser.AlterTableOrderByColumnActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableRenameColumnAction}
	 * labeled alternative in {@link MySQLSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableRenameColumnAction(MySQLSQLStatementParser.AlterTableRenameColumnActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableRenameIndexConstraintAction}
	 * labeled alternative in {@link MySQLSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableRenameIndexConstraintAction(MySQLSQLStatementParser.AlterTableRenameIndexConstraintActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableRenameKeyConstraintAction}
	 * labeled alternative in {@link MySQLSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableRenameKeyConstraintAction(MySQLSQLStatementParser.AlterTableRenameKeyConstraintActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableRenameTableAction}
	 * labeled alternative in {@link MySQLSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableRenameTableAction(MySQLSQLStatementParser.AlterTableRenameTableActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableWithoutValidateAction}
	 * labeled alternative in {@link MySQLSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableWithoutValidateAction(MySQLSQLStatementParser.AlterTableWithoutValidateActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableWithValidateAction}
	 * labeled alternative in {@link MySQLSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableWithValidateAction(MySQLSQLStatementParser.AlterTableWithValidateActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableAddPartitionAction}
	 * labeled alternative in {@link MySQLSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableAddPartitionAction(MySQLSQLStatementParser.AlterTableAddPartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableDropPartitionAction}
	 * labeled alternative in {@link MySQLSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableDropPartitionAction(MySQLSQLStatementParser.AlterTableDropPartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableDiscardPartitionAction}
	 * labeled alternative in {@link MySQLSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableDiscardPartitionAction(MySQLSQLStatementParser.AlterTableDiscardPartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableImportPartitionAction}
	 * labeled alternative in {@link MySQLSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableImportPartitionAction(MySQLSQLStatementParser.AlterTableImportPartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableTruncatePartitionAction}
	 * labeled alternative in {@link MySQLSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableTruncatePartitionAction(MySQLSQLStatementParser.AlterTableTruncatePartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableCoalescePartitionAction}
	 * labeled alternative in {@link MySQLSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableCoalescePartitionAction(MySQLSQLStatementParser.AlterTableCoalescePartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableReorganizePartitionAction}
	 * labeled alternative in {@link MySQLSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableReorganizePartitionAction(MySQLSQLStatementParser.AlterTableReorganizePartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableExchangePartitionAction}
	 * labeled alternative in {@link MySQLSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableExchangePartitionAction(MySQLSQLStatementParser.AlterTableExchangePartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableAnalyzePartitiionAction}
	 * labeled alternative in {@link MySQLSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableAnalyzePartitiionAction(MySQLSQLStatementParser.AlterTableAnalyzePartitiionActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableCheckPartitionAction}
	 * labeled alternative in {@link MySQLSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableCheckPartitionAction(MySQLSQLStatementParser.AlterTableCheckPartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableOptimizePartitionAction}
	 * labeled alternative in {@link MySQLSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableOptimizePartitionAction(MySQLSQLStatementParser.AlterTableOptimizePartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableRebuildPartitionAction}
	 * labeled alternative in {@link MySQLSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableRebuildPartitionAction(MySQLSQLStatementParser.AlterTableRebuildPartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableRepairPartitionAction}
	 * labeled alternative in {@link MySQLSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableRepairPartitionAction(MySQLSQLStatementParser.AlterTableRepairPartitionActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableRemovePartitioningAction}
	 * labeled alternative in {@link MySQLSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableRemovePartitioningAction(MySQLSQLStatementParser.AlterTableRemovePartitioningActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableUpgradePartitioningAction}
	 * labeled alternative in {@link MySQLSQLStatementParser#alterTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableUpgradePartitioningAction(MySQLSQLStatementParser.AlterTableUpgradePartitioningActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#alterTableColumnActionProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableColumnActionProperty(MySQLSQLStatementParser.AlterTableColumnActionPropertyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterColumnSetDefaultAction}
	 * labeled alternative in {@link MySQLSQLStatementParser#alterColumnAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterColumnSetDefaultAction(MySQLSQLStatementParser.AlterColumnSetDefaultActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterColumnDropDefaultAction}
	 * labeled alternative in {@link MySQLSQLStatementParser#alterColumnAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterColumnDropDefaultAction(MySQLSQLStatementParser.AlterColumnDropDefaultActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#alterTablePartitionItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTablePartitionItem(MySQLSQLStatementParser.AlterTablePartitionItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#alterTablespaceStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTablespaceStatement(MySQLSQLStatementParser.AlterTablespaceStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#alterViewStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterViewStatement(MySQLSQLStatementParser.AlterViewStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#dropDatabaseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropDatabaseStatement(MySQLSQLStatementParser.DropDatabaseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#dropSchemaStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropSchemaStatement(MySQLSQLStatementParser.DropSchemaStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#dropEventStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropEventStatement(MySQLSQLStatementParser.DropEventStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#dropIndexStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropIndexStatement(MySQLSQLStatementParser.DropIndexStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#dropIndexStatementOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropIndexStatementOption(MySQLSQLStatementParser.DropIndexStatementOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#dropLogfileGroupStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropLogfileGroupStatement(MySQLSQLStatementParser.DropLogfileGroupStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#dropProcedureStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropProcedureStatement(MySQLSQLStatementParser.DropProcedureStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#dropFunctionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropFunctionStatement(MySQLSQLStatementParser.DropFunctionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#dropServerStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropServerStatement(MySQLSQLStatementParser.DropServerStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#dropTableStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropTableStatement(MySQLSQLStatementParser.DropTableStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#dropTablespaceStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropTablespaceStatement(MySQLSQLStatementParser.DropTablespaceStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#dropTriggerStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropTriggerStatement(MySQLSQLStatementParser.DropTriggerStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#dropViewStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropViewStatement(MySQLSQLStatementParser.DropViewStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#renameTableStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRenameTableStatement(MySQLSQLStatementParser.RenameTableStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#renameTableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRenameTableClause(MySQLSQLStatementParser.RenameTableClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#truncateTableStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTruncateTableStatement(MySQLSQLStatementParser.TruncateTableStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#selectStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectStatement(MySQLSQLStatementParser.SelectStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#iSelectQuery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitISelectQuery(MySQLSQLStatementParser.ISelectQueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#selectQueryBasic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectQueryBasic(MySQLSQLStatementParser.SelectQueryBasicContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#selectQuery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectQuery(MySQLSQLStatementParser.SelectQueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#selectQueryCache}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectQueryCache(MySQLSQLStatementParser.SelectQueryCacheContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#selectParenQuery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectParenQuery(MySQLSQLStatementParser.SelectParenQueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#selectUnionQuery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectUnionQuery(MySQLSQLStatementParser.SelectUnionQueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#setQuantifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetQuantifier(MySQLSQLStatementParser.SetQuantifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#unionOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnionOperator(MySQLSQLStatementParser.UnionOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#selectItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectItem(MySQLSQLStatementParser.SelectItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#selectItemAlias}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectItemAlias(MySQLSQLStatementParser.SelectItemAliasContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#fromClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFromClause(MySQLSQLStatementParser.FromClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#iTableReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitITableReference(MySQLSQLStatementParser.ITableReferenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code objectNameTableReference}
	 * labeled alternative in {@link MySQLSQLStatementParser#tableReferenceBasic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectNameTableReference(MySQLSQLStatementParser.ObjectNameTableReferenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code subQueryTableReference}
	 * labeled alternative in {@link MySQLSQLStatementParser#tableReferenceBasic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubQueryTableReference(MySQLSQLStatementParser.SubQueryTableReferenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ojTableReference}
	 * labeled alternative in {@link MySQLSQLStatementParser#tableReferenceBasic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOjTableReference(MySQLSQLStatementParser.OjTableReferenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenTableReference}
	 * labeled alternative in {@link MySQLSQLStatementParser#tableReferenceBasic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenTableReference(MySQLSQLStatementParser.ParenTableReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#joinTableReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoinTableReference(MySQLSQLStatementParser.JoinTableReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#partitionClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionClause(MySQLSQLStatementParser.PartitionClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code useIndexHint}
	 * labeled alternative in {@link MySQLSQLStatementParser#iIndexHint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUseIndexHint(MySQLSQLStatementParser.UseIndexHintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code useKeyHint}
	 * labeled alternative in {@link MySQLSQLStatementParser#iIndexHint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUseKeyHint(MySQLSQLStatementParser.UseKeyHintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ignoreIndexHint}
	 * labeled alternative in {@link MySQLSQLStatementParser#iIndexHint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIgnoreIndexHint(MySQLSQLStatementParser.IgnoreIndexHintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ignoreKeyHint}
	 * labeled alternative in {@link MySQLSQLStatementParser#iIndexHint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIgnoreKeyHint(MySQLSQLStatementParser.IgnoreKeyHintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forceIndexHint}
	 * labeled alternative in {@link MySQLSQLStatementParser#iIndexHint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForceIndexHint(MySQLSQLStatementParser.ForceIndexHintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forceKeyHint}
	 * labeled alternative in {@link MySQLSQLStatementParser#iIndexHint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForceKeyHint(MySQLSQLStatementParser.ForceKeyHintContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#indexHintType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexHintType(MySQLSQLStatementParser.IndexHintTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#joinType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoinType(MySQLSQLStatementParser.JoinTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#rightJoinClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRightJoinClause(MySQLSQLStatementParser.RightJoinClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code joinOnCondition}
	 * labeled alternative in {@link MySQLSQLStatementParser#iJoinCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoinOnCondition(MySQLSQLStatementParser.JoinOnConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code joinUsingCondition}
	 * labeled alternative in {@link MySQLSQLStatementParser#iJoinCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoinUsingCondition(MySQLSQLStatementParser.JoinUsingConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#whereClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhereClause(MySQLSQLStatementParser.WhereClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#groupByClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroupByClause(MySQLSQLStatementParser.GroupByClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#havingClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHavingClause(MySQLSQLStatementParser.HavingClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#groupByItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroupByItem(MySQLSQLStatementParser.GroupByItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#orderByClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrderByClause(MySQLSQLStatementParser.OrderByClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#orderByItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrderByItem(MySQLSQLStatementParser.OrderByItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#limitOffsetClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLimitOffsetClause(MySQLSQLStatementParser.LimitOffsetClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code selectQueryIntoClause}
	 * labeled alternative in {@link MySQLSQLStatementParser#iSelectQueryIntoClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectQueryIntoClause(MySQLSQLStatementParser.SelectQueryIntoClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code selectQueryIntoDumpFileClause}
	 * labeled alternative in {@link MySQLSQLStatementParser#iSelectQueryIntoClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectQueryIntoDumpFileClause(MySQLSQLStatementParser.SelectQueryIntoDumpFileClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code selectIntoTextFile}
	 * labeled alternative in {@link MySQLSQLStatementParser#iSelectQueryIntoClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectIntoTextFile(MySQLSQLStatementParser.SelectIntoTextFileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forUpdateClause}
	 * labeled alternative in {@link MySQLSQLStatementParser#iLockClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForUpdateClause(MySQLSQLStatementParser.ForUpdateClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lockInShareModeClause}
	 * labeled alternative in {@link MySQLSQLStatementParser#iLockClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLockInShareModeClause(MySQLSQLStatementParser.LockInShareModeClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forUpdateSkipLockedOption}
	 * labeled alternative in {@link MySQLSQLStatementParser#forUpdateOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForUpdateSkipLockedOption(MySQLSQLStatementParser.ForUpdateSkipLockedOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forUpdateNoWaitOption}
	 * labeled alternative in {@link MySQLSQLStatementParser#forUpdateOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForUpdateNoWaitOption(MySQLSQLStatementParser.ForUpdateNoWaitOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#selectIntoStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectIntoStatement(MySQLSQLStatementParser.SelectIntoStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#selectTargetItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectTargetItem(MySQLSQLStatementParser.SelectTargetItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#insertStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsertStatement(MySQLSQLStatementParser.InsertStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#iValueClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIValueClause(MySQLSQLStatementParser.IValueClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#valuesClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValuesClause(MySQLSQLStatementParser.ValuesClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#valuesClauseItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValuesClauseItem(MySQLSQLStatementParser.ValuesClauseItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#onDuplicateKeyUpdateClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOnDuplicateKeyUpdateClause(MySQLSQLStatementParser.OnDuplicateKeyUpdateClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#updateStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdateStatement(MySQLSQLStatementParser.UpdateStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#updateSetClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdateSetClause(MySQLSQLStatementParser.UpdateSetClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#updateSetItemClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdateSetItemClause(MySQLSQLStatementParser.UpdateSetItemClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#deleteStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeleteStatement(MySQLSQLStatementParser.DeleteStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#deleteStatementUsingClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeleteStatementUsingClause(MySQLSQLStatementParser.DeleteStatementUsingClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#replaceStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReplaceStatement(MySQLSQLStatementParser.ReplaceStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#replaceStatementValuseClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReplaceStatementValuseClause(MySQLSQLStatementParser.ReplaceStatementValuseClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#callStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallStatement(MySQLSQLStatementParser.CallStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#loadDataInfileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoadDataInfileStatement(MySQLSQLStatementParser.LoadDataInfileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#loadXmlStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoadXmlStatement(MySQLSQLStatementParser.LoadXmlStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#doStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoStatement(MySQLSQLStatementParser.DoStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#handlerStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHandlerStatement(MySQLSQLStatementParser.HandlerStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#handlerOpenStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHandlerOpenStatement(MySQLSQLStatementParser.HandlerOpenStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#handlerReadStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHandlerReadStatement(MySQLSQLStatementParser.HandlerReadStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#handlerCloseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHandlerCloseStatement(MySQLSQLStatementParser.HandlerCloseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#selectFieldsInto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectFieldsInto(MySQLSQLStatementParser.SelectFieldsIntoContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#selectLinesInto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectLinesInto(MySQLSQLStatementParser.SelectLinesIntoContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#startTransaction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStartTransaction(MySQLSQLStatementParser.StartTransactionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#transactionMode}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTransactionMode(MySQLSQLStatementParser.TransactionModeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#beginWork}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBeginWork(MySQLSQLStatementParser.BeginWorkContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#commitWork}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommitWork(MySQLSQLStatementParser.CommitWorkContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#rollbackWork}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRollbackWork(MySQLSQLStatementParser.RollbackWorkContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#savepointStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSavepointStatement(MySQLSQLStatementParser.SavepointStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#rollbackStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRollbackStatement(MySQLSQLStatementParser.RollbackStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#releaseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReleaseStatement(MySQLSQLStatementParser.ReleaseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#lockTablesStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLockTablesStatement(MySQLSQLStatementParser.LockTablesStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#lockTableItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLockTableItem(MySQLSQLStatementParser.LockTableItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#lockAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLockAction(MySQLSQLStatementParser.LockActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#unlockTablesStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnlockTablesStatement(MySQLSQLStatementParser.UnlockTablesStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#setAutoCommitStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetAutoCommitStatement(MySQLSQLStatementParser.SetAutoCommitStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#transactionOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTransactionOption(MySQLSQLStatementParser.TransactionOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#transactionLevel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTransactionLevel(MySQLSQLStatementParser.TransactionLevelContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#changeMaster}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChangeMaster(MySQLSQLStatementParser.ChangeMasterContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#changeReplicationFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChangeReplicationFilter(MySQLSQLStatementParser.ChangeReplicationFilterContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#purgeBinaryLogs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPurgeBinaryLogs(MySQLSQLStatementParser.PurgeBinaryLogsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#resetMaster}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResetMaster(MySQLSQLStatementParser.ResetMasterContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#resetSlave}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResetSlave(MySQLSQLStatementParser.ResetSlaveContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#startSlave}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStartSlave(MySQLSQLStatementParser.StartSlaveContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#stopSlave}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStopSlave(MySQLSQLStatementParser.StopSlaveContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#startGroupReplication}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStartGroupReplication(MySQLSQLStatementParser.StartGroupReplicationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#stopGroupReplication}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStopGroupReplication(MySQLSQLStatementParser.StopGroupReplicationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code masterStringOption}
	 * labeled alternative in {@link MySQLSQLStatementParser#masterOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMasterStringOption(MySQLSQLStatementParser.MasterStringOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code masterDecimalOption}
	 * labeled alternative in {@link MySQLSQLStatementParser#masterOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMasterDecimalOption(MySQLSQLStatementParser.MasterDecimalOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code masterBoolOption}
	 * labeled alternative in {@link MySQLSQLStatementParser#masterOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMasterBoolOption(MySQLSQLStatementParser.MasterBoolOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code masterRealOption}
	 * labeled alternative in {@link MySQLSQLStatementParser#masterOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMasterRealOption(MySQLSQLStatementParser.MasterRealOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code master}
	 * labeled alternative in {@link MySQLSQLStatementParser#masterOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMaster(MySQLSQLStatementParser.MasterContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#stringMasterOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringMasterOption(MySQLSQLStatementParser.StringMasterOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#decimalMasterOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecimalMasterOption(MySQLSQLStatementParser.DecimalMasterOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#boolMasterOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolMasterOption(MySQLSQLStatementParser.BoolMasterOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#channelOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChannelOption(MySQLSQLStatementParser.ChannelOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code doDbReplication}
	 * labeled alternative in {@link MySQLSQLStatementParser#replicationFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoDbReplication(MySQLSQLStatementParser.DoDbReplicationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ignoreDbReplication}
	 * labeled alternative in {@link MySQLSQLStatementParser#replicationFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIgnoreDbReplication(MySQLSQLStatementParser.IgnoreDbReplicationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code doTableReplication}
	 * labeled alternative in {@link MySQLSQLStatementParser#replicationFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoTableReplication(MySQLSQLStatementParser.DoTableReplicationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ignoreTableReplication}
	 * labeled alternative in {@link MySQLSQLStatementParser#replicationFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIgnoreTableReplication(MySQLSQLStatementParser.IgnoreTableReplicationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code wildDoTableReplication}
	 * labeled alternative in {@link MySQLSQLStatementParser#replicationFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWildDoTableReplication(MySQLSQLStatementParser.WildDoTableReplicationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code wildIgnoreTableReplication}
	 * labeled alternative in {@link MySQLSQLStatementParser#replicationFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWildIgnoreTableReplication(MySQLSQLStatementParser.WildIgnoreTableReplicationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rewriteDbReplication}
	 * labeled alternative in {@link MySQLSQLStatementParser#replicationFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRewriteDbReplication(MySQLSQLStatementParser.RewriteDbReplicationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#tablePair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTablePair(MySQLSQLStatementParser.TablePairContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#threadType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThreadType(MySQLSQLStatementParser.ThreadTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code gtidsUntilOption}
	 * labeled alternative in {@link MySQLSQLStatementParser#untilOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGtidsUntilOption(MySQLSQLStatementParser.GtidsUntilOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code masterLogUntilOption}
	 * labeled alternative in {@link MySQLSQLStatementParser#untilOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMasterLogUntilOption(MySQLSQLStatementParser.MasterLogUntilOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code relayLogUntilOption}
	 * labeled alternative in {@link MySQLSQLStatementParser#untilOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelayLogUntilOption(MySQLSQLStatementParser.RelayLogUntilOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sqlGapsUntilOption}
	 * labeled alternative in {@link MySQLSQLStatementParser#untilOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSqlGapsUntilOption(MySQLSQLStatementParser.SqlGapsUntilOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code userConnectionOption}
	 * labeled alternative in {@link MySQLSQLStatementParser#connectionOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUserConnectionOption(MySQLSQLStatementParser.UserConnectionOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code passwordConnectionOption}
	 * labeled alternative in {@link MySQLSQLStatementParser#connectionOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPasswordConnectionOption(MySQLSQLStatementParser.PasswordConnectionOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code defaultAuthConnectionOption}
	 * labeled alternative in {@link MySQLSQLStatementParser#connectionOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultAuthConnectionOption(MySQLSQLStatementParser.DefaultAuthConnectionOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pluginDirConnectionOption}
	 * labeled alternative in {@link MySQLSQLStatementParser#connectionOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPluginDirConnectionOption(MySQLSQLStatementParser.PluginDirConnectionOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#gtnameIdentifierSet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGtnameIdentifierSet(MySQLSQLStatementParser.GtnameIdentifierSetContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#xaStartTransaction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXaStartTransaction(MySQLSQLStatementParser.XaStartTransactionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#xaEndTransaction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXaEndTransaction(MySQLSQLStatementParser.XaEndTransactionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#xaPrepareStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXaPrepareStatement(MySQLSQLStatementParser.XaPrepareStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#xaCommitWork}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXaCommitWork(MySQLSQLStatementParser.XaCommitWorkContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#xaRollbackWork}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXaRollbackWork(MySQLSQLStatementParser.XaRollbackWorkContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#xaRecoverWork}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXaRecoverWork(MySQLSQLStatementParser.XaRecoverWorkContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#prepareStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrepareStatement(MySQLSQLStatementParser.PrepareStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#executeStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExecuteStatement(MySQLSQLStatementParser.ExecuteStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#deallocatePrepare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeallocatePrepare(MySQLSQLStatementParser.DeallocatePrepareContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#statementItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementItem(MySQLSQLStatementParser.StatementItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(MySQLSQLStatementParser.BodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#bodyItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBodyItem(MySQLSQLStatementParser.BodyItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#bodyItemStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBodyItemStatement(MySQLSQLStatementParser.BodyItemStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#caseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseStatement(MySQLSQLStatementParser.CaseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#caseStatementWhenItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseStatementWhenItem(MySQLSQLStatementParser.CaseStatementWhenItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#caseStatementElseClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseStatementElseClause(MySQLSQLStatementParser.CaseStatementElseClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(MySQLSQLStatementParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#elseIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseIf(MySQLSQLStatementParser.ElseIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#iterateStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIterateStatement(MySQLSQLStatementParser.IterateStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#leaveStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeaveStatement(MySQLSQLStatementParser.LeaveStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#loopStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopStatement(MySQLSQLStatementParser.LoopStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#repeatStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeatStatement(MySQLSQLStatementParser.RepeatStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(MySQLSQLStatementParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(MySQLSQLStatementParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CloseCursor}
	 * labeled alternative in {@link MySQLSQLStatementParser#cursorStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCloseCursor(MySQLSQLStatementParser.CloseCursorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FetchCursor}
	 * labeled alternative in {@link MySQLSQLStatementParser#cursorStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFetchCursor(MySQLSQLStatementParser.FetchCursorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OpenCursor}
	 * labeled alternative in {@link MySQLSQLStatementParser#cursorStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpenCursor(MySQLSQLStatementParser.OpenCursorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#conditionHandling}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionHandling(MySQLSQLStatementParser.ConditionHandlingContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#declareVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclareVariable(MySQLSQLStatementParser.DeclareVariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#declareCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclareCondition(MySQLSQLStatementParser.DeclareConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#declareCursor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclareCursor(MySQLSQLStatementParser.DeclareCursorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#declareHandler}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclareHandler(MySQLSQLStatementParser.DeclareHandlerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code handlerConditionCode}
	 * labeled alternative in {@link MySQLSQLStatementParser#handlerConditionValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHandlerConditionCode(MySQLSQLStatementParser.HandlerConditionCodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code handlerConditionState}
	 * labeled alternative in {@link MySQLSQLStatementParser#handlerConditionValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHandlerConditionState(MySQLSQLStatementParser.HandlerConditionStateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code handlerConditionName}
	 * labeled alternative in {@link MySQLSQLStatementParser#handlerConditionValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHandlerConditionName(MySQLSQLStatementParser.HandlerConditionNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code handlerConditionWarning}
	 * labeled alternative in {@link MySQLSQLStatementParser#handlerConditionValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHandlerConditionWarning(MySQLSQLStatementParser.HandlerConditionWarningContext ctx);
	/**
	 * Visit a parse tree produced by the {@code handlerConditionNotfound}
	 * labeled alternative in {@link MySQLSQLStatementParser#handlerConditionValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHandlerConditionNotfound(MySQLSQLStatementParser.HandlerConditionNotfoundContext ctx);
	/**
	 * Visit a parse tree produced by the {@code handlerConditionException}
	 * labeled alternative in {@link MySQLSQLStatementParser#handlerConditionValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHandlerConditionException(MySQLSQLStatementParser.HandlerConditionExceptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterUserMysqlV56}
	 * labeled alternative in {@link MySQLSQLStatementParser#alterUserStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterUserMysqlV56(MySQLSQLStatementParser.AlterUserMysqlV56Context ctx);
	/**
	 * Visit a parse tree produced by the {@code alterUserMysqlV57}
	 * labeled alternative in {@link MySQLSQLStatementParser#alterUserStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterUserMysqlV57(MySQLSQLStatementParser.AlterUserMysqlV57Context ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#createUserStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateUserStatement(MySQLSQLStatementParser.CreateUserStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#dropUserStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropUserStatement(MySQLSQLStatementParser.DropUserStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#grantStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGrantStatement(MySQLSQLStatementParser.GrantStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#grantProxy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGrantProxy(MySQLSQLStatementParser.GrantProxyContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#renameUser}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRenameUser(MySQLSQLStatementParser.RenameUserContext ctx);
	/**
	 * Visit a parse tree produced by the {@code detailRevoke}
	 * labeled alternative in {@link MySQLSQLStatementParser#revokeStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDetailRevoke(MySQLSQLStatementParser.DetailRevokeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code shortRevoke}
	 * labeled alternative in {@link MySQLSQLStatementParser#revokeStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShortRevoke(MySQLSQLStatementParser.ShortRevokeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#revokeProxy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRevokeProxy(MySQLSQLStatementParser.RevokeProxyContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#userSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUserSpecification(MySQLSQLStatementParser.UserSpecificationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code passwordAuthOption}
	 * labeled alternative in {@link MySQLSQLStatementParser#userAuthOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPasswordAuthOption(MySQLSQLStatementParser.PasswordAuthOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringAuthOption}
	 * labeled alternative in {@link MySQLSQLStatementParser#userAuthOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringAuthOption(MySQLSQLStatementParser.StringAuthOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code hashAuthOption}
	 * labeled alternative in {@link MySQLSQLStatementParser#userAuthOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHashAuthOption(MySQLSQLStatementParser.HashAuthOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code simpleAuthOption}
	 * labeled alternative in {@link MySQLSQLStatementParser#userAuthOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleAuthOption(MySQLSQLStatementParser.SimpleAuthOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#tlsOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTlsOption(MySQLSQLStatementParser.TlsOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#userResourceOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUserResourceOption(MySQLSQLStatementParser.UserResourceOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#userPasswordOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUserPasswordOption(MySQLSQLStatementParser.UserPasswordOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#userLockOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUserLockOption(MySQLSQLStatementParser.UserLockOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#privelegeClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrivelegeClause(MySQLSQLStatementParser.PrivelegeClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#privilege}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrivilege(MySQLSQLStatementParser.PrivilegeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code currentSchemaPriviLevel}
	 * labeled alternative in {@link MySQLSQLStatementParser#privilegeLevel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCurrentSchemaPriviLevel(MySQLSQLStatementParser.CurrentSchemaPriviLevelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code globalPrivLevel}
	 * labeled alternative in {@link MySQLSQLStatementParser#privilegeLevel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobalPrivLevel(MySQLSQLStatementParser.GlobalPrivLevelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code definiteSchemaPrivLevel}
	 * labeled alternative in {@link MySQLSQLStatementParser#privilegeLevel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefiniteSchemaPrivLevel(MySQLSQLStatementParser.DefiniteSchemaPrivLevelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code definiteFullTablePrivLevel}
	 * labeled alternative in {@link MySQLSQLStatementParser#privilegeLevel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefiniteFullTablePrivLevel(MySQLSQLStatementParser.DefiniteFullTablePrivLevelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code definiteTablePrivLevel}
	 * labeled alternative in {@link MySQLSQLStatementParser#privilegeLevel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefiniteTablePrivLevel(MySQLSQLStatementParser.DefiniteTablePrivLevelContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#renameUserClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRenameUserClause(MySQLSQLStatementParser.RenameUserClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#analyzeTable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnalyzeTable(MySQLSQLStatementParser.AnalyzeTableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#checkTable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCheckTable(MySQLSQLStatementParser.CheckTableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#checksumTable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChecksumTable(MySQLSQLStatementParser.ChecksumTableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#optimizeTable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptimizeTable(MySQLSQLStatementParser.OptimizeTableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#repairTable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepairTable(MySQLSQLStatementParser.RepairTableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#checkTableOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCheckTableOption(MySQLSQLStatementParser.CheckTableOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#createUdfunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateUdfunction(MySQLSQLStatementParser.CreateUdfunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#installPlugin}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstallPlugin(MySQLSQLStatementParser.InstallPluginContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#uninstallPlugin}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUninstallPlugin(MySQLSQLStatementParser.UninstallPluginContext ctx);
	/**
	 * Visit a parse tree produced by the {@code setDefaultRoleStatement}
	 * labeled alternative in {@link MySQLSQLStatementParser#setStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetDefaultRoleStatement(MySQLSQLStatementParser.SetDefaultRoleStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code setPasswordStatement}
	 * labeled alternative in {@link MySQLSQLStatementParser#setStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetPasswordStatement(MySQLSQLStatementParser.SetPasswordStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code setVariableStatement}
	 * labeled alternative in {@link MySQLSQLStatementParser#setStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetVariableStatement(MySQLSQLStatementParser.SetVariableStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code setCharacterSetStatement}
	 * labeled alternative in {@link MySQLSQLStatementParser#setStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetCharacterSetStatement(MySQLSQLStatementParser.SetCharacterSetStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code setCharsetStatement}
	 * labeled alternative in {@link MySQLSQLStatementParser#setStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetCharsetStatement(MySQLSQLStatementParser.SetCharsetStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code setNamesStatement}
	 * labeled alternative in {@link MySQLSQLStatementParser#setStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetNamesStatement(MySQLSQLStatementParser.SetNamesStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code setTransactionStatement}
	 * labeled alternative in {@link MySQLSQLStatementParser#setStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetTransactionStatement(MySQLSQLStatementParser.SetTransactionStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code setAutocommit}
	 * labeled alternative in {@link MySQLSQLStatementParser#setStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetAutocommit(MySQLSQLStatementParser.SetAutocommitContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#setDefaultRole}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetDefaultRole(MySQLSQLStatementParser.SetDefaultRoleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code showMasterLogs}
	 * labeled alternative in {@link MySQLSQLStatementParser#showStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowMasterLogs(MySQLSQLStatementParser.ShowMasterLogsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code showLogEvents}
	 * labeled alternative in {@link MySQLSQLStatementParser#showStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowLogEvents(MySQLSQLStatementParser.ShowLogEventsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code showObjectFilter}
	 * labeled alternative in {@link MySQLSQLStatementParser#showStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowObjectFilter(MySQLSQLStatementParser.ShowObjectFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code showColumns}
	 * labeled alternative in {@link MySQLSQLStatementParser#showStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowColumns(MySQLSQLStatementParser.ShowColumnsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code showCreateDb}
	 * labeled alternative in {@link MySQLSQLStatementParser#showStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowCreateDb(MySQLSQLStatementParser.ShowCreateDbContext ctx);
	/**
	 * Visit a parse tree produced by the {@code showCreatenameIdentifierObject}
	 * labeled alternative in {@link MySQLSQLStatementParser#showStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowCreatenameIdentifierObject(MySQLSQLStatementParser.ShowCreatenameIdentifierObjectContext ctx);
	/**
	 * Visit a parse tree produced by the {@code showCreateUser}
	 * labeled alternative in {@link MySQLSQLStatementParser#showStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowCreateUser(MySQLSQLStatementParser.ShowCreateUserContext ctx);
	/**
	 * Visit a parse tree produced by the {@code showEngine}
	 * labeled alternative in {@link MySQLSQLStatementParser#showStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowEngine(MySQLSQLStatementParser.ShowEngineContext ctx);
	/**
	 * Visit a parse tree produced by the {@code showGlobalInfo}
	 * labeled alternative in {@link MySQLSQLStatementParser#showStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowGlobalInfo(MySQLSQLStatementParser.ShowGlobalInfoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code showErrors}
	 * labeled alternative in {@link MySQLSQLStatementParser#showStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowErrors(MySQLSQLStatementParser.ShowErrorsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code showCountErrors}
	 * labeled alternative in {@link MySQLSQLStatementParser#showStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowCountErrors(MySQLSQLStatementParser.ShowCountErrorsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code showSchemaFilter}
	 * labeled alternative in {@link MySQLSQLStatementParser#showStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowSchemaFilter(MySQLSQLStatementParser.ShowSchemaFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code showRoutine}
	 * labeled alternative in {@link MySQLSQLStatementParser#showStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowRoutine(MySQLSQLStatementParser.ShowRoutineContext ctx);
	/**
	 * Visit a parse tree produced by the {@code showGrants}
	 * labeled alternative in {@link MySQLSQLStatementParser#showStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowGrants(MySQLSQLStatementParser.ShowGrantsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code showIndexes}
	 * labeled alternative in {@link MySQLSQLStatementParser#showStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowIndexes(MySQLSQLStatementParser.ShowIndexesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code showOpenTables}
	 * labeled alternative in {@link MySQLSQLStatementParser#showStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowOpenTables(MySQLSQLStatementParser.ShowOpenTablesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code showProfile}
	 * labeled alternative in {@link MySQLSQLStatementParser#showStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowProfile(MySQLSQLStatementParser.ShowProfileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code showSlaveStatus}
	 * labeled alternative in {@link MySQLSQLStatementParser#showStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowSlaveStatus(MySQLSQLStatementParser.ShowSlaveStatusContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#showCommonEntity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowCommonEntity(MySQLSQLStatementParser.ShowCommonEntityContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#showFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowFilter(MySQLSQLStatementParser.ShowFilterContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#showGlobalInfoClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowGlobalInfoClause(MySQLSQLStatementParser.ShowGlobalInfoClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#showSchemaEntity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowSchemaEntity(MySQLSQLStatementParser.ShowSchemaEntityContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#showProfileType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowProfileType(MySQLSQLStatementParser.ShowProfileTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#binlogStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinlogStatement(MySQLSQLStatementParser.BinlogStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#cacheIndexStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCacheIndexStatement(MySQLSQLStatementParser.CacheIndexStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#flushStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlushStatement(MySQLSQLStatementParser.FlushStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#killStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKillStatement(MySQLSQLStatementParser.KillStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#loadIndexIntoCache}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoadIndexIntoCache(MySQLSQLStatementParser.LoadIndexIntoCacheContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#resetStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResetStatement(MySQLSQLStatementParser.ResetStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#shutdownStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShutdownStatement(MySQLSQLStatementParser.ShutdownStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#tableIndexes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableIndexes(MySQLSQLStatementParser.TableIndexesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code simpleFlushOption}
	 * labeled alternative in {@link MySQLSQLStatementParser#flushOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleFlushOption(MySQLSQLStatementParser.SimpleFlushOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code channelFlushOption}
	 * labeled alternative in {@link MySQLSQLStatementParser#flushOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChannelFlushOption(MySQLSQLStatementParser.ChannelFlushOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tableFlushOption}
	 * labeled alternative in {@link MySQLSQLStatementParser#flushOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableFlushOption(MySQLSQLStatementParser.TableFlushOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#flushTableOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlushTableOption(MySQLSQLStatementParser.FlushTableOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#loadedTableIndexes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoadedTableIndexes(MySQLSQLStatementParser.LoadedTableIndexesContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#simpleDescribeStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleDescribeStatement(MySQLSQLStatementParser.SimpleDescribeStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#fullDescribeStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFullDescribeStatement(MySQLSQLStatementParser.FullDescribeStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#helpStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHelpStatement(MySQLSQLStatementParser.HelpStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#useStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUseStatement(MySQLSQLStatementParser.UseStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code describeStatements}
	 * labeled alternative in {@link MySQLSQLStatementParser#describeObjectClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDescribeStatements(MySQLSQLStatementParser.DescribeStatementsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code describeConnection}
	 * labeled alternative in {@link MySQLSQLStatementParser#describeObjectClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDescribeConnection(MySQLSQLStatementParser.DescribeConnectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#engineName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEngineName(MySQLSQLStatementParser.EngineNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#unameIdentifierSet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnameIdentifierSet(MySQLSQLStatementParser.UnameIdentifierSetContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#xid}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXid(MySQLSQLStatementParser.XidContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#xnameIdentifierStringId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXnameIdentifierStringId(MySQLSQLStatementParser.XnameIdentifierStringIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#authPlugin}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAuthPlugin(MySQLSQLStatementParser.AuthPluginContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#null_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNull_(MySQLSQLStatementParser.Null_Context ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#notNull}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotNull(MySQLSQLStatementParser.NotNullContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#convertedDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConvertedDataType(MySQLSQLStatementParser.ConvertedDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#lengthOneDimension}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLengthOneDimension(MySQLSQLStatementParser.LengthOneDimensionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#lengthTwoDimension}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLengthTwoDimension(MySQLSQLStatementParser.LengthTwoDimensionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#lengthTwoOptionalDimension}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLengthTwoOptionalDimension(MySQLSQLStatementParser.LengthTwoOptionalDimensionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#simpleStrings}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleStrings(MySQLSQLStatementParser.SimpleStringsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#userVariables}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUserVariables(MySQLSQLStatementParser.UserVariablesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code levelWeightList}
	 * labeled alternative in {@link MySQLSQLStatementParser#levelsInWeightString}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLevelWeightList(MySQLSQLStatementParser.LevelWeightListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code levelWeightRange}
	 * labeled alternative in {@link MySQLSQLStatementParser#levelsInWeightString}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLevelWeightRange(MySQLSQLStatementParser.LevelWeightRangeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#levelInWeightListElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLevelInWeightListElement(MySQLSQLStatementParser.LevelInWeightListElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#aggregateWindowedFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAggregateWindowedFunction(MySQLSQLStatementParser.AggregateWindowedFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#charsetNameBase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharsetNameBase(MySQLSQLStatementParser.CharsetNameBaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#transactionLevelBase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTransactionLevelBase(MySQLSQLStatementParser.TransactionLevelBaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#privilegesBase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrivilegesBase(MySQLSQLStatementParser.PrivilegesBaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#dataTypeBase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataTypeBase(MySQLSQLStatementParser.DataTypeBaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#keywordsCanBeId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeywordsCanBeId(MySQLSQLStatementParser.KeywordsCanBeIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#allTokens}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAllTokens(MySQLSQLStatementParser.AllTokensContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataType(MySQLSQLStatementParser.DataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bitDataType}
	 * labeled alternative in {@link MySQLSQLStatementParser#iNumericDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitDataType(MySQLSQLStatementParser.BitDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tinyintDataType}
	 * labeled alternative in {@link MySQLSQLStatementParser#iNumericDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTinyintDataType(MySQLSQLStatementParser.TinyintDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code smallintDataType}
	 * labeled alternative in {@link MySQLSQLStatementParser#iNumericDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSmallintDataType(MySQLSQLStatementParser.SmallintDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mediumintDataType}
	 * labeled alternative in {@link MySQLSQLStatementParser#iNumericDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMediumintDataType(MySQLSQLStatementParser.MediumintDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intDataType}
	 * labeled alternative in {@link MySQLSQLStatementParser#iNumericDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntDataType(MySQLSQLStatementParser.IntDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code integerDataType}
	 * labeled alternative in {@link MySQLSQLStatementParser#iNumericDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerDataType(MySQLSQLStatementParser.IntegerDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bigintDataType}
	 * labeled alternative in {@link MySQLSQLStatementParser#iNumericDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBigintDataType(MySQLSQLStatementParser.BigintDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code decimalDataType}
	 * labeled alternative in {@link MySQLSQLStatementParser#iNumericDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecimalDataType(MySQLSQLStatementParser.DecimalDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code decDataType}
	 * labeled alternative in {@link MySQLSQLStatementParser#iNumericDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecDataType(MySQLSQLStatementParser.DecDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numericDataType}
	 * labeled alternative in {@link MySQLSQLStatementParser#iNumericDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumericDataType(MySQLSQLStatementParser.NumericDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fixedDataType}
	 * labeled alternative in {@link MySQLSQLStatementParser#iNumericDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFixedDataType(MySQLSQLStatementParser.FixedDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code floatDataType}
	 * labeled alternative in {@link MySQLSQLStatementParser#iNumericDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatDataType(MySQLSQLStatementParser.FloatDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code doubleDataType}
	 * labeled alternative in {@link MySQLSQLStatementParser#iNumericDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleDataType(MySQLSQLStatementParser.DoubleDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code doublePrecisionDataType}
	 * labeled alternative in {@link MySQLSQLStatementParser#iNumericDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoublePrecisionDataType(MySQLSQLStatementParser.DoublePrecisionDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code realDataType}
	 * labeled alternative in {@link MySQLSQLStatementParser#iNumericDatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRealDataType(MySQLSQLStatementParser.RealDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code charDataType}
	 * labeled alternative in {@link MySQLSQLStatementParser#iStringDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharDataType(MySQLSQLStatementParser.CharDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nationalCharDataType}
	 * labeled alternative in {@link MySQLSQLStatementParser#iStringDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNationalCharDataType(MySQLSQLStatementParser.NationalCharDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varcharDataType}
	 * labeled alternative in {@link MySQLSQLStatementParser#iStringDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarcharDataType(MySQLSQLStatementParser.VarcharDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nationalVarcharDataType}
	 * labeled alternative in {@link MySQLSQLStatementParser#iStringDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNationalVarcharDataType(MySQLSQLStatementParser.NationalVarcharDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryDataType}
	 * labeled alternative in {@link MySQLSQLStatementParser#iStringDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryDataType(MySQLSQLStatementParser.BinaryDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varBinaryDataType}
	 * labeled alternative in {@link MySQLSQLStatementParser#iStringDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarBinaryDataType(MySQLSQLStatementParser.VarBinaryDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tinyBlobDataType}
	 * labeled alternative in {@link MySQLSQLStatementParser#iStringDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTinyBlobDataType(MySQLSQLStatementParser.TinyBlobDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tinyTextDataType}
	 * labeled alternative in {@link MySQLSQLStatementParser#iStringDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTinyTextDataType(MySQLSQLStatementParser.TinyTextDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code blobDataType}
	 * labeled alternative in {@link MySQLSQLStatementParser#iStringDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlobDataType(MySQLSQLStatementParser.BlobDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code textDataType}
	 * labeled alternative in {@link MySQLSQLStatementParser#iStringDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTextDataType(MySQLSQLStatementParser.TextDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mediumBlobDataType}
	 * labeled alternative in {@link MySQLSQLStatementParser#iStringDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMediumBlobDataType(MySQLSQLStatementParser.MediumBlobDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mediumTextDataType}
	 * labeled alternative in {@link MySQLSQLStatementParser#iStringDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMediumTextDataType(MySQLSQLStatementParser.MediumTextDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code longBlobDataType}
	 * labeled alternative in {@link MySQLSQLStatementParser#iStringDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLongBlobDataType(MySQLSQLStatementParser.LongBlobDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code longTextDataType}
	 * labeled alternative in {@link MySQLSQLStatementParser#iStringDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLongTextDataType(MySQLSQLStatementParser.LongTextDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code enumDataType}
	 * labeled alternative in {@link MySQLSQLStatementParser#iStringDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumDataType(MySQLSQLStatementParser.EnumDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code setDataType}
	 * labeled alternative in {@link MySQLSQLStatementParser#iStringDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetDataType(MySQLSQLStatementParser.SetDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dateDataType}
	 * labeled alternative in {@link MySQLSQLStatementParser#iDateTimeDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDateDataType(MySQLSQLStatementParser.DateDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code datetimeDataType}
	 * labeled alternative in {@link MySQLSQLStatementParser#iDateTimeDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDatetimeDataType(MySQLSQLStatementParser.DatetimeDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code timestampDataType}
	 * labeled alternative in {@link MySQLSQLStatementParser#iDateTimeDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimestampDataType(MySQLSQLStatementParser.TimestampDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code timeDataType}
	 * labeled alternative in {@link MySQLSQLStatementParser#iDateTimeDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimeDataType(MySQLSQLStatementParser.TimeDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code yearDataType}
	 * labeled alternative in {@link MySQLSQLStatementParser#iDateTimeDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitYearDataType(MySQLSQLStatementParser.YearDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code geometryDataType}
	 * labeled alternative in {@link MySQLSQLStatementParser#spatialDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGeometryDataType(MySQLSQLStatementParser.GeometryDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pointDataType}
	 * labeled alternative in {@link MySQLSQLStatementParser#spatialDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPointDataType(MySQLSQLStatementParser.PointDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lineStringDataType}
	 * labeled alternative in {@link MySQLSQLStatementParser#spatialDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLineStringDataType(MySQLSQLStatementParser.LineStringDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code polygonDataType}
	 * labeled alternative in {@link MySQLSQLStatementParser#spatialDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPolygonDataType(MySQLSQLStatementParser.PolygonDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiPointDataType}
	 * labeled alternative in {@link MySQLSQLStatementParser#spatialDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiPointDataType(MySQLSQLStatementParser.MultiPointDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiLineStringDataType}
	 * labeled alternative in {@link MySQLSQLStatementParser#spatialDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiLineStringDataType(MySQLSQLStatementParser.MultiLineStringDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiPolygonDataType}
	 * labeled alternative in {@link MySQLSQLStatementParser#spatialDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiPolygonDataType(MySQLSQLStatementParser.MultiPolygonDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code geometryCollectionDataType}
	 * labeled alternative in {@link MySQLSQLStatementParser#spatialDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGeometryCollectionDataType(MySQLSQLStatementParser.GeometryCollectionDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolDataType}
	 * labeled alternative in {@link MySQLSQLStatementParser#iBoolDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolDataType(MySQLSQLStatementParser.BoolDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code booleanDataType}
	 * labeled alternative in {@link MySQLSQLStatementParser#iBoolDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanDataType(MySQLSQLStatementParser.BooleanDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jsonDataType}
	 * labeled alternative in {@link MySQLSQLStatementParser#iJsonDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonDataType(MySQLSQLStatementParser.JsonDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#otherDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOtherDataType(MySQLSQLStatementParser.OtherDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code asteriskIdentifier}
	 * labeled alternative in {@link MySQLSQLStatementParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsteriskIdentifier(MySQLSQLStatementParser.AsteriskIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code normalIdentifier}
	 * labeled alternative in {@link MySQLSQLStatementParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalIdentifier(MySQLSQLStatementParser.NormalIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code reverseQuoteIdentifier}
	 * labeled alternative in {@link MySQLSQLStatementParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReverseQuoteIdentifier(MySQLSQLStatementParser.ReverseQuoteIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code doubleQuoteIdentifier1}
	 * labeled alternative in {@link MySQLSQLStatementParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleQuoteIdentifier1(MySQLSQLStatementParser.DoubleQuoteIdentifier1Context ctx);
	/**
	 * Visit a parse tree produced by the {@code identifier1}
	 * labeled alternative in {@link MySQLSQLStatementParser#nameIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier1(MySQLSQLStatementParser.Identifier1Context ctx);
	/**
	 * Visit a parse tree produced by the {@code propertyIdentifier1}
	 * labeled alternative in {@link MySQLSQLStatementParser#nameIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertyIdentifier1(MySQLSQLStatementParser.PropertyIdentifier1Context ctx);
	/**
	 * Visit a parse tree produced by the {@code nCharLiteral}
	 * labeled alternative in {@link MySQLSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNCharLiteral(MySQLSQLStatementParser.NCharLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code charLiteral}
	 * labeled alternative in {@link MySQLSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharLiteral(MySQLSQLStatementParser.CharLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code doubleQuoteIdentifier2}
	 * labeled alternative in {@link MySQLSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleQuoteIdentifier2(MySQLSQLStatementParser.DoubleQuoteIdentifier2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code charsetNamChareLiteral}
	 * labeled alternative in {@link MySQLSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharsetNamChareLiteral(MySQLSQLStatementParser.CharsetNamChareLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code integerLiteral}
	 * labeled alternative in {@link MySQLSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerLiteral(MySQLSQLStatementParser.IntegerLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numberLiteral}
	 * labeled alternative in {@link MySQLSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberLiteral(MySQLSQLStatementParser.NumberLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dateLiteral}
	 * labeled alternative in {@link MySQLSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDateLiteral(MySQLSQLStatementParser.DateLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code timeLiteral}
	 * labeled alternative in {@link MySQLSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimeLiteral(MySQLSQLStatementParser.TimeLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code timestampLiteral}
	 * labeled alternative in {@link MySQLSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimestampLiteral(MySQLSQLStatementParser.TimestampLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intervalLiteral}
	 * labeled alternative in {@link MySQLSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntervalLiteral(MySQLSQLStatementParser.IntervalLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code hexadecimalLiteral}
	 * labeled alternative in {@link MySQLSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHexadecimalLiteral(MySQLSQLStatementParser.HexadecimalLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bitLiteral}
	 * labeled alternative in {@link MySQLSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitLiteral(MySQLSQLStatementParser.BitLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code falseLiteral}
	 * labeled alternative in {@link MySQLSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalseLiteral(MySQLSQLStatementParser.FalseLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code trueLiteral}
	 * labeled alternative in {@link MySQLSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueLiteral(MySQLSQLStatementParser.TrueLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nullLiteral}
	 * labeled alternative in {@link MySQLSQLStatementParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullLiteral(MySQLSQLStatementParser.NullLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#intervalType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntervalType(MySQLSQLStatementParser.IntervalTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#unaryOperatorExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryOperatorExpr(MySQLSQLStatementParser.UnaryOperatorExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#unaryOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryOperator(MySQLSQLStatementParser.UnaryOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#variableExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableExpr(MySQLSQLStatementParser.VariableExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#localVariableExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVariableExpr(MySQLSQLStatementParser.LocalVariableExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#globalVariableExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobalVariableExpr(MySQLSQLStatementParser.GlobalVariableExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#globalGlobalVariableExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobalGlobalVariableExpr(MySQLSQLStatementParser.GlobalGlobalVariableExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#sessionGlobalVariableExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSessionGlobalVariableExpr(MySQLSQLStatementParser.SessionGlobalVariableExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#persistGlobalVariableExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPersistGlobalVariableExpr(MySQLSQLStatementParser.PersistGlobalVariableExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#persistOnlyGlobalVariableExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPersistOnlyGlobalVariableExpr(MySQLSQLStatementParser.PersistOnlyGlobalVariableExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#rowExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowExpr(MySQLSQLStatementParser.RowExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#selectQueryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectQueryExpr(MySQLSQLStatementParser.SelectQueryExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#matchExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatchExpr(MySQLSQLStatementParser.MatchExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#searchModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSearchModifier(MySQLSQLStatementParser.SearchModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#caseExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseExpr(MySQLSQLStatementParser.CaseExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#caseExprWhenItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseExprWhenItem(MySQLSQLStatementParser.CaseExprWhenItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#caseExprElseClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseExprElseClause(MySQLSQLStatementParser.CaseExprElseClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#listExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListExpr(MySQLSQLStatementParser.ListExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#exprBasic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprBasic(MySQLSQLStatementParser.ExprBasicContext ctx);
	/**
	 * Visit a parse tree produced by the {@code soundsLikeCondition}
	 * labeled alternative in {@link MySQLSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSoundsLikeCondition(MySQLSQLStatementParser.SoundsLikeConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rlikeCondition}
	 * labeled alternative in {@link MySQLSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRlikeCondition(MySQLSQLStatementParser.RlikeConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inCondition}
	 * labeled alternative in {@link MySQLSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInCondition(MySQLSQLStatementParser.InConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code someExpr}
	 * labeled alternative in {@link MySQLSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSomeExpr(MySQLSQLStatementParser.SomeExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newVariableRefExpr}
	 * labeled alternative in {@link MySQLSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewVariableRefExpr(MySQLSQLStatementParser.NewVariableRefExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code isNullCondition}
	 * labeled alternative in {@link MySQLSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsNullCondition(MySQLSQLStatementParser.IsNullConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code regexpCondition}
	 * labeled alternative in {@link MySQLSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegexpCondition(MySQLSQLStatementParser.RegexpConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code iCondition}
	 * labeled alternative in {@link MySQLSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitICondition(MySQLSQLStatementParser.IConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryOperatorExpr}
	 * labeled alternative in {@link MySQLSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryOperatorExpr(MySQLSQLStatementParser.BinaryOperatorExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code likeCondition}
	 * labeled alternative in {@link MySQLSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLikeCondition(MySQLSQLStatementParser.LikeConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code allExpr}
	 * labeled alternative in {@link MySQLSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAllExpr(MySQLSQLStatementParser.AllExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code oldVariableRefExpr}
	 * labeled alternative in {@link MySQLSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOldVariableRefExpr(MySQLSQLStatementParser.OldVariableRefExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code propertyIdentifier2}
	 * labeled alternative in {@link MySQLSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertyIdentifier2(MySQLSQLStatementParser.PropertyIdentifier2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code methodInvocation1}
	 * labeled alternative in {@link MySQLSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodInvocation1(MySQLSQLStatementParser.MethodInvocation1Context ctx);
	/**
	 * Visit a parse tree produced by the {@code basicExpr}
	 * labeled alternative in {@link MySQLSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicExpr(MySQLSQLStatementParser.BasicExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code methodInvocation2}
	 * labeled alternative in {@link MySQLSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodInvocation2(MySQLSQLStatementParser.MethodInvocation2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code betweenCondition}
	 * labeled alternative in {@link MySQLSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBetweenCondition(MySQLSQLStatementParser.BetweenConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cursorExpr}
	 * labeled alternative in {@link MySQLSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCursorExpr(MySQLSQLStatementParser.CursorExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code anyExpr}
	 * labeled alternative in {@link MySQLSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnyExpr(MySQLSQLStatementParser.AnyExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code comparisonBinaryOperatorExpr}
	 * labeled alternative in {@link MySQLSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonBinaryOperatorExpr(MySQLSQLStatementParser.ComparisonBinaryOperatorExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprToExprExpr}
	 * labeled alternative in {@link MySQLSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprToExprExpr(MySQLSQLStatementParser.ExprToExprExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code isBooleanLiteralCondition}
	 * labeled alternative in {@link MySQLSQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsBooleanLiteralCondition(MySQLSQLStatementParser.IsBooleanLiteralConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#comparisonOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonOp(MySQLSQLStatementParser.ComparisonOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#defaultClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultClause(MySQLSQLStatementParser.DefaultClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#autoIncrementOptionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAutoIncrementOptionExpr(MySQLSQLStatementParser.AutoIncrementOptionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#avgRowLengthOptionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAvgRowLengthOptionExpr(MySQLSQLStatementParser.AvgRowLengthOptionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#characterSetOptionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharacterSetOptionExpr(MySQLSQLStatementParser.CharacterSetOptionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#charsetOptionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharsetOptionExpr(MySQLSQLStatementParser.CharsetOptionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#checksumOptionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChecksumOptionExpr(MySQLSQLStatementParser.ChecksumOptionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#collateOptionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCollateOptionExpr(MySQLSQLStatementParser.CollateOptionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#commentOptionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommentOptionExpr(MySQLSQLStatementParser.CommentOptionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#compressionOptionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompressionOptionExpr(MySQLSQLStatementParser.CompressionOptionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#connectionOptionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConnectionOptionExpr(MySQLSQLStatementParser.ConnectionOptionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#dataDirectoryOptionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataDirectoryOptionExpr(MySQLSQLStatementParser.DataDirectoryOptionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#indexDirectoryOptionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexDirectoryOptionExpr(MySQLSQLStatementParser.IndexDirectoryOptionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#delayKeyWriteOptionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDelayKeyWriteOptionExpr(MySQLSQLStatementParser.DelayKeyWriteOptionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#encryptionOptionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEncryptionOptionExpr(MySQLSQLStatementParser.EncryptionOptionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#engineOptionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEngineOptionExpr(MySQLSQLStatementParser.EngineOptionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#insertMethodOptionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsertMethodOptionExpr(MySQLSQLStatementParser.InsertMethodOptionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#keyBlockSizeOptionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyBlockSizeOptionExpr(MySQLSQLStatementParser.KeyBlockSizeOptionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#maxRowsOptionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMaxRowsOptionExpr(MySQLSQLStatementParser.MaxRowsOptionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#minRowsOptionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinRowsOptionExpr(MySQLSQLStatementParser.MinRowsOptionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#packKeysOptionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackKeysOptionExpr(MySQLSQLStatementParser.PackKeysOptionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#passwordOptionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPasswordOptionExpr(MySQLSQLStatementParser.PasswordOptionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#rowFormatOptionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowFormatOptionExpr(MySQLSQLStatementParser.RowFormatOptionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#statsAutoRecalcOptionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatsAutoRecalcOptionExpr(MySQLSQLStatementParser.StatsAutoRecalcOptionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#statsPersistentOptionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatsPersistentOptionExpr(MySQLSQLStatementParser.StatsPersistentOptionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#statsSamplePageOptionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatsSamplePageOptionExpr(MySQLSQLStatementParser.StatsSamplePageOptionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#tablespaceOptionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTablespaceOptionExpr(MySQLSQLStatementParser.TablespaceOptionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#unionOptionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnionOptionExpr(MySQLSQLStatementParser.UnionOptionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#assignmentExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentExpr(MySQLSQLStatementParser.AssignmentExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#defaultLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultLiteral(MySQLSQLStatementParser.DefaultLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#allLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAllLiteral(MySQLSQLStatementParser.AllLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#noneLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoneLiteral(MySQLSQLStatementParser.NoneLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#maxValueLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMaxValueLiteral(MySQLSQLStatementParser.MaxValueLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(MySQLSQLStatementParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#notCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotCondition(MySQLSQLStatementParser.NotConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#formatJson}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormatJson(MySQLSQLStatementParser.FormatJsonContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#exprAsObjectExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAsObjectExpr(MySQLSQLStatementParser.ExprAsObjectExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#existsCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExistsCondition(MySQLSQLStatementParser.ExistsConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code castFunction}
	 * labeled alternative in {@link MySQLSQLStatementParser#specificFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCastFunction(MySQLSQLStatementParser.CastFunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code charFunction}
	 * labeled alternative in {@link MySQLSQLStatementParser#specificFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharFunction(MySQLSQLStatementParser.CharFunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dataTypeFunctionCall}
	 * labeled alternative in {@link MySQLSQLStatementParser#specificFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataTypeFunctionCall(MySQLSQLStatementParser.DataTypeFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code valuesFunctionCall}
	 * labeled alternative in {@link MySQLSQLStatementParser#specificFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValuesFunctionCall(MySQLSQLStatementParser.ValuesFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code positionFunctionCall}
	 * labeled alternative in {@link MySQLSQLStatementParser#specificFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPositionFunctionCall(MySQLSQLStatementParser.PositionFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code substrFunctionCall}
	 * labeled alternative in {@link MySQLSQLStatementParser#specificFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubstrFunctionCall(MySQLSQLStatementParser.SubstrFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code trimFunctionCall}
	 * labeled alternative in {@link MySQLSQLStatementParser#specificFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrimFunctionCall(MySQLSQLStatementParser.TrimFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code weightFunctionCall}
	 * labeled alternative in {@link MySQLSQLStatementParser#specificFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWeightFunctionCall(MySQLSQLStatementParser.WeightFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code getFormatFunctionCall}
	 * labeled alternative in {@link MySQLSQLStatementParser#specificFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGetFormatFunctionCall(MySQLSQLStatementParser.GetFormatFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(MySQLSQLStatementParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#noArgumentFunctionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoArgumentFunctionName(MySQLSQLStatementParser.NoArgumentFunctionNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#positionFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPositionFunction(MySQLSQLStatementParser.PositionFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#subStrFromFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubStrFromFunction(MySQLSQLStatementParser.SubStrFromFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#subStringFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubStringFunction(MySQLSQLStatementParser.SubStringFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#trimFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrimFunction(MySQLSQLStatementParser.TrimFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#weightStringFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWeightStringFunction(MySQLSQLStatementParser.WeightStringFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#extractFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtractFunction(MySQLSQLStatementParser.ExtractFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#treatFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTreatFunction(MySQLSQLStatementParser.TreatFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#convertUsingFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConvertUsingFunction(MySQLSQLStatementParser.ConvertUsingFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#costMatrixClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCostMatrixClause(MySQLSQLStatementParser.CostMatrixClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#jsonFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonFunction(MySQLSQLStatementParser.JsonFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#jsonFunctionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonFunctionName(MySQLSQLStatementParser.JsonFunctionNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#jsonFunctionArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonFunctionArgument(MySQLSQLStatementParser.JsonFunctionArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#jsonFormatJsonArgumentExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonFormatJsonArgumentExpr(MySQLSQLStatementParser.JsonFormatJsonArgumentExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#jsonKeyValueArgumentExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonKeyValueArgumentExpr(MySQLSQLStatementParser.JsonKeyValueArgumentExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#jsonOnNullClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonOnNullClause(MySQLSQLStatementParser.JsonOnNullClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#jsonReturningClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonReturningClause(MySQLSQLStatementParser.JsonReturningClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#withUniqueKeys}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithUniqueKeys(MySQLSQLStatementParser.WithUniqueKeysContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#jsonWrapperClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonWrapperClause(MySQLSQLStatementParser.JsonWrapperClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#jsonOnErrorClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonOnErrorClause(MySQLSQLStatementParser.JsonOnErrorClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#jsonOnEmptyClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonOnEmptyClause(MySQLSQLStatementParser.JsonOnEmptyClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#jsonColumnsClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonColumnsClause(MySQLSQLStatementParser.JsonColumnsClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jsonExistsColumn}
	 * labeled alternative in {@link MySQLSQLStatementParser#jsonColumnDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonExistsColumn(MySQLSQLStatementParser.JsonExistsColumnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jsonQueryColumn}
	 * labeled alternative in {@link MySQLSQLStatementParser#jsonColumnDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonQueryColumn(MySQLSQLStatementParser.JsonQueryColumnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jsonValueColumn}
	 * labeled alternative in {@link MySQLSQLStatementParser#jsonColumnDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonValueColumn(MySQLSQLStatementParser.JsonValueColumnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jsonNestedPathColumn}
	 * labeled alternative in {@link MySQLSQLStatementParser#jsonColumnDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonNestedPathColumn(MySQLSQLStatementParser.JsonNestedPathColumnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jsonOrdinalityColumn}
	 * labeled alternative in {@link MySQLSQLStatementParser#jsonColumnDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonOrdinalityColumn(MySQLSQLStatementParser.JsonOrdinalityColumnContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#aggregateFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAggregateFunction(MySQLSQLStatementParser.AggregateFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#aggregateFunctionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAggregateFunctionName(MySQLSQLStatementParser.AggregateFunctionNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#withinGroupSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithinGroupSpecification(MySQLSQLStatementParser.WithinGroupSpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#firstFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFirstFunction(MySQLSQLStatementParser.FirstFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#lastFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLastFunction(MySQLSQLStatementParser.LastFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#listAggFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListAggFunction(MySQLSQLStatementParser.ListAggFunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code onOverflowErrorClause}
	 * labeled alternative in {@link MySQLSQLStatementParser#listaggOverflowClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOnOverflowErrorClause(MySQLSQLStatementParser.OnOverflowErrorClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code onOverflowTruncateClause}
	 * labeled alternative in {@link MySQLSQLStatementParser#listaggOverflowClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOnOverflowTruncateClause(MySQLSQLStatementParser.OnOverflowTruncateClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#windowFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWindowFunction(MySQLSQLStatementParser.WindowFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#windowFunctionNullsOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWindowFunctionNullsOption(MySQLSQLStatementParser.WindowFunctionNullsOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#windowFunctionFromOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWindowFunctionFromOption(MySQLSQLStatementParser.WindowFunctionFromOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#overClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOverClause(MySQLSQLStatementParser.OverClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#analyticClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnalyticClause(MySQLSQLStatementParser.AnalyticClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#partitionByClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionByClause(MySQLSQLStatementParser.PartitionByClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#windowFrameClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWindowFrameClause(MySQLSQLStatementParser.WindowFrameClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#windowFrameUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWindowFrameUnit(MySQLSQLStatementParser.WindowFrameUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#windowFrameExtent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWindowFrameExtent(MySQLSQLStatementParser.WindowFrameExtentContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#windowFrameExtentItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWindowFrameExtentItem(MySQLSQLStatementParser.WindowFrameExtentItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#cubeTableFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCubeTableFunction(MySQLSQLStatementParser.CubeTableFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#cubeTableOptionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCubeTableOptionExpr(MySQLSQLStatementParser.CubeTableOptionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#orReplace}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrReplace(MySQLSQLStatementParser.OrReplaceContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#ifExists}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfExists(MySQLSQLStatementParser.IfExistsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#ifNotExists}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfNotExists(MySQLSQLStatementParser.IfNotExistsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#withRollup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithRollup(MySQLSQLStatementParser.WithRollupContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#orderingSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrderingSpecification(MySQLSQLStatementParser.OrderingSpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#intimeAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntimeAction(MySQLSQLStatementParser.IntimeActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#indexCategory}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexCategory(MySQLSQLStatementParser.IndexCategoryContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#keyViolate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyViolate(MySQLSQLStatementParser.KeyViolateContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#indexFormat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexFormat(MySQLSQLStatementParser.IndexFormatContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#indexType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexType(MySQLSQLStatementParser.IndexTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#withType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithType(MySQLSQLStatementParser.WithTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#visibleType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVisibleType(MySQLSQLStatementParser.VisibleTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLSQLStatementParser#priority}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPriority(MySQLSQLStatementParser.PriorityContext ctx);
}