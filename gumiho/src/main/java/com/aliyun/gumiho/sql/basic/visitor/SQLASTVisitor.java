package com.aliyun.gumiho.sql.basic.visitor;

import com.aliyun.gumiho.sql.basic.ast.SQLObject;
import com.aliyun.gumiho.sql.basic.ast.element.datatype.*;
import com.aliyun.gumiho.sql.basic.ast.element.datatype.any.SQLAnyDataDataType;
import com.aliyun.gumiho.sql.basic.ast.element.datatype.any.SQLAnyDataSetDataType;
import com.aliyun.gumiho.sql.basic.ast.element.datatype.any.SQLAnyTypeDataType;
import com.aliyun.gumiho.sql.basic.ast.element.datatype.bool.SQLBoolDataType;
import com.aliyun.gumiho.sql.basic.ast.element.datatype.bool.SQLBooleanDataType;
import com.aliyun.gumiho.sql.basic.ast.element.datatype.collection.*;
import com.aliyun.gumiho.sql.basic.ast.element.datatype.datetime.*;
import com.aliyun.gumiho.sql.basic.ast.element.datatype.interval.SQLIntervalDataType;
import com.aliyun.gumiho.sql.basic.ast.element.datatype.json.SQLJsonDataType;
import com.aliyun.gumiho.sql.basic.ast.element.datatype.media.*;
import com.aliyun.gumiho.sql.basic.ast.element.datatype.money.SQLMoneyDataType;
import com.aliyun.gumiho.sql.basic.ast.element.datatype.numeric.*;
import com.aliyun.gumiho.sql.basic.ast.element.datatype.object.SQLObjectDataType;
import com.aliyun.gumiho.sql.basic.ast.element.datatype.record.SQLRecordDataType;
import com.aliyun.gumiho.sql.basic.ast.element.datatype.reference.SQLRefCursorDataType;
import com.aliyun.gumiho.sql.basic.ast.element.datatype.reference.SQLRefDataType;
import com.aliyun.gumiho.sql.basic.ast.element.datatype.row.SQLRowDataTypeImpl;
import com.aliyun.gumiho.sql.basic.ast.element.datatype.spatial.*;
import com.aliyun.gumiho.sql.basic.ast.element.datatype.string.*;
import com.aliyun.gumiho.sql.basic.ast.element.datatype.sub.SQLObjectSubDataType;
import com.aliyun.gumiho.sql.basic.ast.element.datatype.xml.SQLUriTypeDataType;
import com.aliyun.gumiho.sql.basic.ast.element.datatype.xml.SQLXmlTypeDataType;
import com.aliyun.gumiho.sql.basic.ast.element.expr.*;
import com.aliyun.gumiho.sql.basic.ast.element.expr.analytic.SQLAlterAnalyticCompileAction;
import com.aliyun.gumiho.sql.basic.ast.element.expr.analytic.SQLAlterAnalyticRenameToAction;
import com.aliyun.gumiho.sql.basic.ast.element.expr.clause.*;
import com.aliyun.gumiho.sql.basic.ast.element.expr.commit.*;
import com.aliyun.gumiho.sql.basic.ast.element.expr.condition.*;
import com.aliyun.gumiho.sql.basic.ast.element.expr.index.*;
import com.aliyun.gumiho.sql.basic.ast.element.expr.index.alter.*;
import com.aliyun.gumiho.sql.basic.ast.element.expr.index.alter.partition.*;
import com.aliyun.gumiho.sql.basic.ast.element.expr.index.attribute.*;
import com.aliyun.gumiho.sql.basic.ast.element.expr.index.partition.global.SQLGlobalPartitionByHash;
import com.aliyun.gumiho.sql.basic.ast.element.expr.index.partition.global.SQLGlobalPartitionByRange;
import com.aliyun.gumiho.sql.basic.ast.element.expr.index.property.SQLIndexTypeIsIndexTypeClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.materializedview.*;
import com.aliyun.gumiho.sql.basic.ast.element.expr.operator.SQLBinaryOperatorExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.operator.SQLBinaryOperatorGroupExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.operator.SQLUnaryOperatorExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.parallel.SQLNoParallelClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.parallel.SQLParallelClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.rollback.SQLRollbackChainOption;
import com.aliyun.gumiho.sql.basic.ast.element.expr.rollback.SQLRollbackForceOption;
import com.aliyun.gumiho.sql.basic.ast.element.expr.rollback.SQLRollbackReleaseOption;
import com.aliyun.gumiho.sql.basic.ast.element.expr.rollback.SQLRollbackToSavepointOption;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.*;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.group.SQLGroupByClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.group.SQLGroupingSetsClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.group.SQLHavingClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.limit.SQLLimitOffsetClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.limit.SQLOffsetFetchClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.order.SQLOrderByClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.order.SQLOrderByItem;
import com.aliyun.gumiho.sql.basic.ast.element.expr.sequence.*;
import com.aliyun.gumiho.sql.basic.ast.element.expr.settransaction.*;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.*;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.*;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.column.*;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.constraint.*;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.iot.ISQLAlterTableIotAction;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.iot.SQLAlterTableAddOverflowIotAction;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.iot.SQLAlterTableAlterOverflowIotAction;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.iot.SQLAlterTableMappingTableIotAction;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.partition.*;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.trigger.SQLAlterTableDisableTriggerAction;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.trigger.SQLAlterTableEnableTriggerAction;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.SQLColumnDefinition;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.SQLLikeClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.SQLVirtualColumnDefinition;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.constraint.SQLConstraint;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.constraint.column.*;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.constraint.option.*;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.constraint.table.*;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.partition.*;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.partition.sub.*;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.partition.values.SQLPartitionValues;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.partition.values.SQLPartitionValuesIn;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.partition.values.SQLPartitionValuesLessThan;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.partition.values.SQLPartitionValuesLessThanMaxValue;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.partitionset.SQLPartitionsetByList;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.partitionset.SQLPartitionsetByRange;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.partitionset.SQLPartitionsetDefinition;
import com.aliyun.gumiho.sql.basic.ast.element.expr.trigger.*;
import com.aliyun.gumiho.sql.basic.ast.element.expr.type.alter.*;
import com.aliyun.gumiho.sql.basic.ast.element.expr.update.SQLUpdateSetByValueClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.update.SQLUpdateSetClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.user.*;
import com.aliyun.gumiho.sql.basic.ast.element.expr.view.alter.*;
import com.aliyun.gumiho.sql.basic.ast.element.function.*;
import com.aliyun.gumiho.sql.basic.ast.element.function.aggreate.AbstractSQLAggregateFunction;
import com.aliyun.gumiho.sql.basic.ast.element.function.aggreate.SQLAggregateFunction;
import com.aliyun.gumiho.sql.basic.ast.element.function.datamining.AbstractSQLDataMiningFunction;
import com.aliyun.gumiho.sql.basic.ast.element.function.datamining.SQLDataMiningFunction;
import com.aliyun.gumiho.sql.basic.ast.element.function.json.AbstractSQLJsonFunction;
import com.aliyun.gumiho.sql.basic.ast.element.function.json.SQLJsonFunction;
import com.aliyun.gumiho.sql.basic.ast.element.function.window.*;
import com.aliyun.gumiho.sql.basic.ast.element.function.xml.*;
import com.aliyun.gumiho.sql.basic.ast.element.hint.*;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.*;
import com.aliyun.gumiho.sql.basic.ast.element.literal.*;
import com.aliyun.gumiho.sql.basic.ast.element.literal.datetime.SQLDateLiteral;
import com.aliyun.gumiho.sql.basic.ast.element.literal.datetime.SQLTimeLiteral;
import com.aliyun.gumiho.sql.basic.ast.element.literal.datetime.SQLTimestampLiteral;
import com.aliyun.gumiho.sql.basic.ast.element.literal.interval.SQLIntervalLiteral;
import com.aliyun.gumiho.sql.basic.ast.element.literal.numeric.SQLBinaryDoubleLiteral;
import com.aliyun.gumiho.sql.basic.ast.element.literal.numeric.SQLBinaryFloatLiteral;
import com.aliyun.gumiho.sql.basic.ast.element.literal.numeric.SQLIntegerLiteral;
import com.aliyun.gumiho.sql.basic.ast.element.literal.numeric.SQLNumberLiteral;
import com.aliyun.gumiho.sql.basic.ast.element.literal.text.*;
import com.aliyun.gumiho.sql.basic.ast.element.pseudocolumn.*;
import com.aliyun.gumiho.sql.basic.ast.statement.dal.*;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.analytic.SQLAlterAnalyticStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.analytic.SQLCreateAnalyticStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.analytic.SQLDropAnalyticStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.comment.*;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.database.SQLAlterDatabaseStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.database.SQLCreateDatabaseStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.database.SQLDropDatabaseStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.databaselink.SQLAlterDatabaseLinkStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.databaselink.SQLCreateDatabaseLinkStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.databaselink.SQLDropDatabaseLinkStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.domain.SQLAlterDomainStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.domain.SQLCreateDomainStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.domain.SQLDropDomainStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.event.SQLAlterEventStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.event.SQLCreateEventStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.event.SQLDropEventStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.function.SQLAlterFunctionStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.function.SQLCreateFunctionStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.function.SQLDropFunctionStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.index.SQLAlterIndexStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.index.SQLCreateIndexStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.index.SQLDropIndexStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.materializedview.SQLAlterMaterializedViewStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.materializedview.SQLCreateMaterializedViewStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.materializedview.SQLDropMaterializedViewStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.materializedviewlog.SQLAlterMaterializedViewLogStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.materializedviewlog.SQLCreateMaterializedViewLogStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.materializedviewlog.SQLDropMaterializedViewLogStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.packagebody.SQLAlterPackageBodyStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.packagebody.SQLCreatePackageBodyStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.packagebody.SQLDropPackageBodyStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.packages.SQLAlterPackageStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.packages.SQLCreatePackageStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.packages.SQLDropPackageStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.pluggabledatabase.SQLAlterPluggableDatabaseStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.pluggabledatabase.SQLCreatePluggableDatabaseStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.pluggabledatabase.SQLDropPluggableDatabaseStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.procedure.SQLAlterProcedureStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.procedure.SQLCreateProcedureStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.procedure.SQLDropProcedureStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.role.SQLAlterRoleStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.role.SQLCreateRoleStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.role.SQLDropRoleStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.rollbacksegment.SQLCreateRollbackSegmentStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.rollbacksegment.SQLDropRollbackSegmentStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.schema.SQLAlterSchemaStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.schema.SQLCreateSchemaStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.schema.SQLDropSchemaStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.sequence.SQLAlterSequenceStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.sequence.SQLCreateSequenceStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.sequence.SQLDropSequenceStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.server.SQLAlterServerStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.server.SQLCreateServerStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.server.SQLDropServerStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.synonym.SQLAlterSynonymStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.synonym.SQLCreateSynonymStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.synonym.SQLDropSynonymStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.table.*;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.trigger.SQLAlterTriggerStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.trigger.SQLCreateTriggerStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.trigger.SQLDropTriggerStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.type.SQLAlterTypeStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.type.SQLCreateTypeStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.type.SQLDropTypeStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.typebody.SQLAlterTypeBodyStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.typebody.SQLCreateTypeBodyStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.typebody.SQLDropTypeBodyStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.user.SQLAlterUserStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.user.SQLCreateUserStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.user.SQLDropUserStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.view.SQLAlterViewStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.view.SQLCreateViewStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.view.SQLDropViewStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.dml.*;
import com.aliyun.gumiho.sql.basic.ast.statement.fcl.*;
import com.aliyun.gumiho.sql.basic.ast.statement.tcl.*;
import com.aliyun.gumiho.sql.basic.ast.statement.utility.SQLExplainStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.utility.SQLUseStatement;

/**
 * @author kongtong.ouyang on 2018/1/30.
 */
public interface SQLASTVisitor {

    boolean preVisit(SQLObject x);

    boolean visit(SQLSetCharacterSetStatement x);

    boolean visit(SQLSetCharSetStatement x);

    boolean visit(SQLSetDefaultRoleStatement x);

    boolean visit(SQLSetNameStatement x);

    boolean visit(SQLSetPasswordStatement x);

    boolean visit(SQLSetVariableStatement x);



    boolean visit(SQLCreateAnalyticStatement x);
    boolean visit(SQLAlterAnalyticStatement x);
    boolean visit(SQLDropAnalyticStatement x);


    boolean visit(SQLCommentOnAuditPolicyStatement x);

    boolean visit(SQLCommentOnColumnStatement x);

    boolean visit(SQLCommentOnDatabaseStatement x);

    boolean visit(SQLCommentOnEditionStatement x);

    boolean visit(SQLCommentOnIndexStatement x);

    boolean visit(SQLCommentOnIndexTypeStatement x);

    boolean visit(SQLCommentOnMaterializedViewStatement x);

    boolean visit(SQLCommentOnMiningModelStatement x);

    boolean visit(SQLCommentOnOperatorStatement x);

    boolean visit(SQLCommentOnRoleStatement x);

    boolean visit(SQLCommentOnSequenceStatement x);

    boolean visit(SQLCommentOnServerStatement x);

    boolean visit(SQLCommentOnTablespaceStatement x);

    boolean visit(SQLCommentOnTableStatement x);

    boolean visit(SQLCommentOnTypeStatement x);

    boolean visit(SQLCommentOnViewStatement x);


    boolean visit(SQLCreateDatabaseStatement x);

    boolean visit(SQLAlterDatabaseStatement x);

    boolean visit(SQLDropDatabaseStatement x);


    boolean visit(SQLCreateDatabaseLinkStatement x);

    boolean visit(SQLAlterDatabaseLinkStatement x);

    boolean visit(SQLDropDatabaseLinkStatement x);


    boolean visit(SQLCreateDomainStatement x);

    boolean visit(SQLAlterDomainStatement x);

    boolean visit(SQLDropDomainStatement x);


    boolean visit(SQLCreateEventStatement x);

    boolean visit(SQLAlterEventStatement x);

    boolean visit(SQLDropEventStatement x);


    boolean visit(SQLCreateFunctionStatement x);

    boolean visit(SQLAlterFunctionStatement x);

    boolean visit(SQLDropFunctionStatement x);


    boolean visit(SQLCreateIndexStatement x);

    boolean visit(SQLAlterIndexStatement x);

    boolean visit(SQLDropIndexStatement x);


    boolean visit(SQLCreateMaterializedViewStatement x);

    boolean visit(SQLCreateMaterializedViewStatement.SQLColumn x);

    boolean visit(SQLAlterMaterializedViewStatement x);

    boolean visit(SQLDropMaterializedViewStatement x);


    boolean visit(SQLCreateMaterializedViewLogStatement x);
    boolean visit(SQLAlterMaterializedViewLogStatement x);
    boolean visit(SQLDropMaterializedViewLogStatement x);


    boolean visit(SQLCreatePackageStatement x);

    boolean visit(SQLAlterPackageStatement x);

    boolean visit(SQLDropPackageStatement x);


    boolean visit(SQLCreatePackageBodyStatement x);

    boolean visit(SQLAlterPackageBodyStatement x);

    boolean visit(SQLDropPackageBodyStatement x);


    boolean visit(SQLCreatePluggableDatabaseStatement x);

    boolean visit(SQLAlterPluggableDatabaseStatement x);

    boolean visit(SQLDropPluggableDatabaseStatement x);


    boolean visit(SQLCreateProcedureStatement x);

    boolean visit(SQLAlterProcedureStatement x);

    boolean visit(SQLDropProcedureStatement x);


    boolean visit(SQLCreateRoleStatement x);

    boolean visit(SQLAlterRoleStatement x);

    boolean visit(SQLDropRoleStatement x);


    boolean visit(SQLCreateRollbackSegmentStatement x);

    boolean visit(SQLDropRollbackSegmentStatement x);


    boolean visit(SQLCreateSchemaStatement x);

    boolean visit(SQLAlterSchemaStatement x);

    boolean visit(SQLDropSchemaStatement x);


    boolean visit(SQLCreateSequenceStatement x);

    boolean visit(SQLAlterSequenceStatement x);

    boolean visit(SQLDropSequenceStatement x);


    boolean visit(SQLCreateServerStatement x);

    boolean visit(SQLAlterServerStatement x);

    boolean visit(SQLDropServerStatement x);


    boolean visit(SQLCreateSynonymStatement x);

    boolean visit(SQLAlterSynonymStatement x);

    boolean visit(SQLDropSynonymStatement x);


    boolean visit(SQLCreateTableStatement x);

    boolean visit(SQLAlterTableStatement x);

    boolean visit(SQLDropTableStatement x);


    boolean visit(SQLCreateTriggerStatement x);

    boolean visit(SQLAlterTriggerStatement x);

    boolean visit(SQLDropTriggerStatement x);


    boolean visit(SQLCreateTypeStatement x);

    boolean visit(SQLCreateTypeStatement.SQLExternalNameClause x);

    boolean visit(SQLAlterTypeStatement x);

    boolean visit(SQLDropTypeStatement x);


    boolean visit(SQLCreateTypeBodyStatement x);

    boolean visit(SQLCreateTypeBodyStatement.SQLCreateBodyItem x);

    boolean visit(SQLAlterTypeBodyStatement x);

    boolean visit(SQLDropTypeBodyStatement x);


    boolean visit(SQLCreateUserStatement x);

    boolean visit(SQLAlterUserStatement x);

    boolean visit(SQLDropUserStatement x);


    boolean visit(SQLCreateViewStatement x);

    boolean visit(SQLAlterViewStatement x);

    boolean visit(SQLDropViewStatement x);


    boolean visit(SQLOpenStatement x);

    boolean visit(SQLCloseStatement x);

    boolean visit(SQLCallStatement x);

    boolean visit(SQLLoadDataStatement x);

    boolean visit(SQLLoadXmlStatement x);

    boolean visit(SQLInsertStatement x);

    boolean visit(SQLMultiInsertStatement x);
    boolean visit(SQLMultiInsertStatement.SQLInsertIntoClause x);
    boolean visit(SQLMultiInsertStatement.SQLConditionalInsertIntoClause x);
    boolean visit(SQLMultiInsertStatement.SQLInsertIntoClauseItem x);
    boolean visit(SQLMultiInsertStatement.SQLConditionalInsertWhenClause x);

    boolean visit(SQLRenameTableStatement x);

    boolean visit(SQLRenameTableStatement.Item x);

    boolean visit(SQLTruncateTableStatement x);

    boolean visit(SQLReplaceStatement x);

    boolean visit(SQLDoStatement x);

    boolean visit(SQLHandlerOpenStatement x);
    boolean visit(SQLHandlerReadStatement x);
    boolean visit(SQLHandlerCloseStatement x);


    boolean visit(SQLDeleteStatement x);

    boolean visit(SQLDeleteStatement.SQLUsingClause x);

    boolean visit(SQLUpdateStatement x);

    boolean visit(SQLSelectStatement x);

    boolean visit(SQLSelectIntoStatement x);

    boolean visit(SQLLockTableStatement x);

    boolean visit(SQLLockTableStatement.SQLLockTableItem x);

    boolean visit(SQLUnLockTablesStatement x);



    boolean visit(SQLContinueStatement x);

    boolean visit(SQLExitStatement x);

    boolean visit(SQLFetchStatement x);

    boolean visit(SQLGotoStatement x);

    boolean visit(SQLMergeStatement x);

    boolean visit(SQLPipeRowStatement x);

    boolean visit(SQLRaiseStatement x);


    boolean visit(SQLIfStatement x);

    boolean visit(SQLIfStatement.SQLElseIf x);


    boolean visit(SQLIterateStatement x);

    boolean visit(SQLLeaveStatement x);

    boolean visit(SQLLoopStatement x);

    boolean visit(SQLNullStatement x);

    boolean visit(SQLOpenForStatement x);


    boolean visit(SQLRepeatStatement x);

    boolean visit(SQLReturnStatement x);

    boolean visit(SQLCaseStatement x);


    boolean visit(SQLCaseStatement.SQLCaseStatementWhenItem x);

    boolean visit(SQLCaseStatement.SQLCaseStatementElseClause x);

    boolean visit(SQLForAllStatement x);

    boolean visit(SQLForLoopStatement x);

    boolean visit(SQLWhileLoopStatement x);

    boolean visit(SQLWhileStatement x);


    boolean visit(SQLCommitStatement x);

    boolean visit(SQLRollbackStatement x);

    boolean visit(SQLSavepointStatement x);

    boolean visit(SQLReleaseSavepointStatement x);

    boolean visit(SQLSetConstraintStatement x);

    boolean visit(SQLSetConstraintsStatement x);

    boolean visit(ISQLSetConstraintsStatement.SQLAllItem x);

    boolean visit(SQLSetTransactionStatement x);


    boolean visit(SQLExplainStatement x);

    boolean visit(SQLUseStatement x);


    // ------------------------- Data Types Start ----------------------------------------
    boolean visit(SQLAnyDataDataType x);
    boolean visit(SQLAnyDataSetDataType x);
    boolean visit(SQLAnyTypeDataType x);

    boolean visit(SQLBoolDataType x);

    boolean visit(SQLBooleanDataType x);

    boolean visit(SQLArrayDataType x);

    boolean visit(SQLAssocArrayDataType x);

    boolean visit(SQLMultisetDataType x);

    boolean visit(SQLNestedTableDataType x);

    boolean visit(SQLVarrayDataType x);

    boolean visit(SQLVaryingArrayDataType x);


    boolean visit(SQLDateDataType x);

    boolean visit(SQLTimeDataType x);

    boolean visit(SQLDateTimeDataType x);

    boolean visit(SQLTimestampDataType x);

    boolean visit(SQLYearDataType x);


    boolean visit(SQLIntervalDataType x);

    boolean visit(SQLJsonDataType x);


    boolean visit(SQLORDAudioDataType x);
    boolean visit(SQLORDDicomDataType x);
    boolean visit(SQLORDDocDataType x);
    boolean visit(SQLORDImageDataType x);
    boolean visit(SQLORDVideoDataType x);
    boolean visit(SQLSIAverageColorDataType x);
    boolean visit(SQLSIColorDataType x);
    boolean visit(SQLSIColorHistogramDataType x);
    boolean visit(SQLSIFeatureListDataType x);
    boolean visit(SQLSIPositionalColorDataType x);
    boolean visit(SQLSIStillImageDataType x);
    boolean visit(SQLSITextureDataType x);


    boolean visit(SQLMoneyDataType x);


    boolean visit(SQLBigintDataType x);

    boolean visit(SQLBinaryDoubleDataType x);

    boolean visit(SQLBinaryFloatDataType x);

    boolean visit(SQLBinaryIntegerDataType x);

    boolean visit(SQLBitDataType x);

    boolean visit(SQLDecDataType x);

    boolean visit(SQLDecimalDataType x);

    boolean visit(SQLDoubleDataType x);

    boolean visit(SQLDoublePrecisionDataType x);

    boolean visit(SQLFixedDataType x);

    boolean visit(SQLFloatDataType x);

    boolean visit(SQLInt1DataType x);

    boolean visit(SQLInt2DataType x);

    boolean visit(SQLInt3DataType x);

    boolean visit(SQLInt4DataType x);

    boolean visit(SQLInt8DataType x);

    boolean visit(SQLIntDataType x);

    boolean visit(SQLIntegerDataType x);

    boolean visit(SQLMediumintDataType x);

    boolean visit(SQLNaturalDataType x);

    boolean visit(SQLNaturalnDataType x);

    boolean visit(SQLNumberDataType x);

    boolean visit(SQLNumericDataType x);

    boolean visit(SQLPlsIntegerDataType x);

    boolean visit(SQLPositiveDataType x);

    boolean visit(SQLPositivenDataType x);

    boolean visit(SQLRealDataType x);

    boolean visit(SQLSigntypeDataType x);

    boolean visit(SQLSimpleDoubleDataType x);

    boolean visit(SQLSimpleFloatDataType x);

    boolean visit(SQLSimpleIntegerDataType x);


    boolean visit(SQLSmallintDataType x);

    boolean visit(SQLTinyintDataType x);


    boolean visit(SQLObjectDataType x);


    boolean visit(SQLRecordDataType x);


    boolean visit(SQLRefCursorDataType x);

    boolean visit(SQLRefDataType x);


    boolean visit(SQLRowDataTypeImpl x);


    boolean visit(SQLGeometryCollectionDataType x);

    boolean visit(SQLGeometryDataType x);

    boolean visit(SQLLineStringDataType x);

    boolean visit(SQLMultiLineStringDataType x);

    boolean visit(SQLMultiPointDataType x);

    boolean visit(SQLMultiPolygonDataType x);

    boolean visit(SQLPointDataType x);

    boolean visit(SQLPolygonDataType x);

    boolean visit(SQLSDOGeometryDataType x);

    boolean visit(SQLSDOGeoRasterDataType x);

    boolean visit(SQLSDOTopoGeometryDataType x);

    boolean visit(SQLObjectSubDataType x);


    boolean visit(SQLBFileDataType x);

    boolean visit(SQLBinaryDataType x);

    boolean visit(SQLBlobDataType x);

    boolean visit(SQLCharacterDataType x);

    boolean visit(SQLCharacterLargeObjectDataType x);

    boolean visit(SQLCharacterVaryingDataType x);

    boolean visit(SQLCharDataType x);

    boolean visit(SQLCharLargeObjectDataType x);

    boolean visit(SQLCharVaryingDataType x);

    boolean visit(SQLClobDataType x);

    boolean visit(SQLLongBlobDataType x);

    boolean visit(SQLLongDataType x);

    boolean visit(SQLLongRawDataType x);

    boolean visit(SQLLongTextDataType x);

    boolean visit(SQLMediumBlobDataType x);

    boolean visit(SQLMediumTextDataType x);

    boolean visit(SQLNationalCharacterDataType x);

    boolean visit(SQLNationalCharacterLargeObjectDataType x);

    boolean visit(SQLNationalCharacterVaryingDataType x);

    boolean visit(SQLNationalCharDataType x);

    boolean visit(SQLNationalCharVaryingDataType x);

    boolean visit(SQLNationalVarcharDataType x);

    boolean visit(SQLNCharDataType x);

    boolean visit(SQLNCharLargeObjectDataType x);

    boolean visit(SQLNCharVaryingDataType x);

    boolean visit(SQLNClobDataType x);

    boolean visit(SQLNVarcharDataType x);

    boolean visit(SQLNVarchar2DataType x);

    boolean visit(SQLRawDataType x);

    boolean visit(SQLRowIdDataType x);

    boolean visit(SQLSetDataType x);

    boolean visit(SQLStringDataType x);

    boolean visit(SQLTextDataType x);

    boolean visit(SQLTinyBlobDataType x);

    boolean visit(SQLTinyTextDataType x);

    boolean visit(SQLURowIdDataType x);

    boolean visit(SQLVarBinaryDataType x);

    boolean visit(SQLVarchar2DataType x);

    boolean visit(SQLVarcharDataType x);


    boolean visit(SQLUriTypeDataType x);

    boolean visit(SQLXmlTypeDataType x);

    boolean visit(SQLEnumDataType x);

    boolean visit(SQLPercentRowTypeDataType x);

    boolean visit(SQLTableDataType x);

    boolean visit(SQLPercentTypeDataType x);

    boolean visit(SQLSelfAsResultDataType x);

    boolean visit(SQLDataTypeImpl x);


    // ------------------------- Data Types End ----------------------------------------


    // ------------------------- Identifier Start ----------------------------------------
    boolean visit(SQLIdentifierImpl x);

    boolean visit(SQLAllColumnExpr x);

    boolean visit(SQLDoubleQuoteIdentifier x);

    boolean visit(SQLReverseQuoteIdentifier x);

    boolean visit(SQLPropertyExpr x);


    boolean visit(SQLDBLinkExpr x);

    // ------------------------- Identifier End ----------------------------------------



    // ------------------------- Literal Start ----------------------------------------

    boolean visit(SQLDateLiteral x);

    boolean visit(SQLTimeLiteral x);

    boolean visit(SQLTimestampLiteral x);

    boolean visit(SQLIntervalLiteral x);

    boolean visit(SQLBinaryDoubleLiteral x);

    boolean visit(SQLBinaryFloatLiteral x);

    boolean visit(SQLIntegerLiteral x);

    boolean visit(SQLNumberLiteral x);

    boolean visit(SQLCharLiteral x);

    boolean visit(SQLNCharLiteral x);

    boolean visit(SQLQCharLiteral x);

    boolean visit(SQLNQCharLiteral x);

    boolean visit(SQLUCharLiteral x);

    boolean visit(SQLAllLiteral x);

    boolean visit(SQLAnyLiteral x);

    boolean visit(SQLBitLiteral x);

    boolean visit(SQLDefaultLiteral x);

    boolean visit(SQLBooleanLiteral x);

    boolean visit(SQLHexadecimalLiteral x);

    boolean visit(SQLMaxValueLiteral x);

    boolean visit(SQLMinValueLiteral x);

    boolean visit(SQLNoneLiteral x);

    boolean visit(SQLNullExpr x);

    boolean visit(SQLUnLimitedLiteral x);

    // ------------------------- Literal End ----------------------------------------


    // ------------------------- Pseudo Column Start ----------------------------------------
    boolean visit(SQLColumnValueExpr x);

    boolean visit(SQLConnectByIsCycleExpr x);
    boolean visit(SQLConnectByIsLeafExpr x);
    boolean visit(SQLLevelExpr x);

    boolean visit(SQLObjectIdExpr x);
    boolean visit(SQLObjectValueExpr x);

    boolean visit(SQLOraRowScnExpr x);

    boolean visit(SQLRowIdExpr x);
    boolean visit(SQLRowNumExpr x);

    boolean visit(SQLSequenceExpr x);

    boolean visit(SQLVersionsEndScnExpr x);
    boolean visit(SQLVersionsEndTimeExpr x);
    boolean visit(SQLVersionsOperationExpr x);
    boolean visit(SQLVersionsStartScnExpr x);
    boolean visit(SQLVersionsStartTimeExpr x);
    boolean visit(SQLVersionsXidExpr x);
    boolean visit(SQLXmlDataExpr x);
    // ------------------------- Pseudo Column End ----------------------------------------



    // ------------------------- Comment Start ----------------------------------------

    // ------------------------- Comment End ----------------------------------------

    // ------------------------- Hint Start ----------------------------------------
    boolean visit(SQLUseIndexHint x);
    boolean visit(SQLUseKeyHint x);

    boolean visit(SQLIgnoreIndexHint x);
    boolean visit(SQLIgnoreKeyHint x);

    boolean visit(SQLForceIndexHint x);
    boolean visit(SQLForceKeyHint x);

    // ------------------------- Hint End ----------------------------------------


    // ------------------------- Operators Start ----------------------------------------
    boolean visit(SQLBinaryOperatorExpr x);

    boolean visit(SQLBinaryOperatorGroupExpr x);

    boolean visit(SQLUnaryOperatorExpr x);
    // ------------------------- Operators Start ----------------------------------------


    // ------------------------- Expressions Start ----------------------------------------

    boolean visit(SQLAllClause x);

    boolean visit(SQLAnyClause x);

    boolean visit(SQLCallArgumentExpr x);

    boolean visit(SQLArrayExpr x);

    boolean visit(SQLAssignmentExpr x);

    boolean visit(SQLAttributeDefinition x);


    boolean visit(SQLRegexpCondition x);

    boolean visit(SQLRlikeCondition x);

    boolean visit(SQLSoundsLikeCondition x);

    boolean visit(SQLReturningClause x);

    boolean visit(SQLReturningIntoClause x);

    boolean visit(SQLRowExpr x);

    boolean visit(SQLScopeClause x);

    boolean visit(SQLCaseExpr x);

    boolean visit(SQLCaseExpr.SQLCaseExprWhenItem x);

    boolean visit(SQLCaseExpr.SQLCaseExprElseClause x);


    boolean visit(SQLCursorExpr x);

    boolean visit(SQLDateTimeAtLocalExpr x);

    boolean visit(SQLDateTimeAtTimeZoneExpr x);

    boolean visit(SQLIntervalExpr x);

    boolean visit(SQLExprAsObjectExpr x);

    boolean visit(SQLExprToExprExpr x);

    boolean visit(SQLListExpr x);

    boolean visit(SQLMultisetExpr x);

    boolean visit(SQLOuterJoinExpr x);

    boolean visit(SQLParameterDeclaration x);

    boolean visit(SQLSomeClause x);

    boolean visit(SQLTypeConstructorExpr x);

    boolean visit(SQLParenExpr x);

    boolean visit(SQLPlaceholderExpr x);

    boolean visit(SQLRangeExpr x);

    boolean visit(SQLBindVariableExpr x);

    boolean visit(SQLVariableExpr x);

    boolean visit(SQLColonNewVariableRefExpr x);

    boolean visit(SQLColonOldVariableRefExpr x);

    boolean visit(SQLNewVariableRefExpr x);

    boolean visit(SQLOldVariableRefExpr x);

    boolean visit(SQLVariableDeclaration x);

    boolean visit(SQLUnusableEditionsClause x);

    boolean visit(SQLUnusableEditionsClause.SQLUnusableBeforeCurrentEditionAction x);

    boolean visit(SQLUnusableEditionsClause.SQLUnusableBeforeEditionAction x);

    boolean visit(SQLUnusableEditionsClause.SQLUnusableBeginningWithCurrentEditionAction x);

    boolean visit(SQLUnusableEditionsClause.SQLUnusableBeginningWithEditionAction x);

    boolean visit(SQLUnusableEditionsClause.SQLUnusableBeginningWithNullEditionAction x);


    boolean visit(SQLBuildClause x);

    boolean visit(SQLEvaluationEditionClause x);

    boolean visit(SQLEvaluationEditionClause.SQLCurrentEditionAction x);

    boolean visit(SQLEvaluationEditionClause.SQLEditionAction x);

    boolean visit(SQLEvaluationEditionClause.SQLNullEditionAction x);

    boolean visit(SQLTablespaceOptionExpr x);

    boolean visit(SQLTableSpaceSetClause x);


    boolean visit(SQLEncryptClause x);
    boolean visit(SQLEncryptionSpec x);
    boolean visit(SQLDecryptClause x);

    boolean visit(SQLStoreInClause x);

    boolean visit(SQLOverflowClause x);

    boolean visit(SQLOverflowStoreInClause x);

    boolean visit(SQLSubPartitionsetStoreInClause x);

    boolean visit(SQLParametersClause x);

    boolean visit(SQLVarrayStorageAsClause x);

    boolean visit(SQLParallelClause x);

    boolean visit(SQLNoParallelClause x);


    boolean visit(ISQLSubqueryRestrictionClause.SQLWithCheckOption x);

    boolean visit(ISQLSubqueryRestrictionClause.SQLWithReadOnly x);

    boolean visit(SQLSubViewClause x);

    boolean visit(ISQLAlterIotClause.SQLCoalesceClause x);

    boolean visit(SQLXmlSchemaSpec x);

    boolean visit(ISQLWithObjectIdClause.SQLWithObjectIdClause x);

    boolean visit(ISQLWithObjectIdClause.SQLWithObjectIdentifierClause x);

    boolean visit(SQLLocalVariableExpr x);

    boolean visit(SQLGlobalVariableExpr x);

    boolean visit(SQLGlobalGlobalVariableExpr x);

    boolean visit(SQLSessionGlobalVariableExpr x);

    boolean visit(SQLPersistGlobalVariableExpr x);

    boolean visit(SQLPersistOnlyGlobalVariableExpr x);


    boolean visit(SQLRebuildClause x);
    boolean visit(SQLRebuildClause.SQLPartitionItem x);
    boolean visit(SQLRebuildClause.SQLSubPartitionItem x);
    boolean visit(SQLRebuildClause.SQLReverseItem x);
    boolean visit(SQLRebuildClause.SQLNoReverseItem x);


    // ------------------------- Expressions End ----------------------------------------


    // ------------------------- Conditions Start ----------------------------------------
    boolean visit(SQLBetweenCondition x);


    boolean visit(SQLExistsCondition x);

    boolean visit(SQLInCondition x);

    boolean visit(SQLIsAnyCondition x);

    boolean visit(SQLIsASetCondition x);

    boolean visit(SQLIsBooleanLiteralCondition x);

    boolean visit(SQLIsEmptyCondition x);

    boolean visit(SQLIsInfiniteCondition x);

    boolean visit(SQLIsJsonCondition x);

    boolean visit(SQLIsNanCondition x);

    boolean visit(SQLIsNullCondition x);

    boolean visit(SQLIsOfTypeCondition x);

    boolean visit(SQLIsOfTypeCondition.Item x);


    boolean visit(SQLIsPresentCondition x);

    boolean visit(SQLJsonExistsCondition x);


    boolean visit(SQLLikeCondition x);

    boolean visit(SQLMemberCondition x);

    boolean visit(SQLNotCondition x);

    boolean visit(SQLParenCondition x);

    boolean visit(SQLRegexpLikeCondition x);


    boolean visit(SQLSubMultisetCondition x);


    boolean visit(SQLDeletingCondition x);

    boolean visit(SQLInsertingCondition x);

    boolean visit(SQLUpdatingCondition x);

    boolean visit(SQLFilterCondition x);

    // ------------------------- Conditions Start ----------------------------------------


    // ------------------------- Functions Start ----------------------------------------

    boolean visit(SQLAggregateFunction x);

    boolean visit(AbstractSQLAggregateFunction.SQLWithinGroupSpecification x);

    boolean visit(AbstractSQLAggregateFunction.SQLFilterClause x);


    boolean visit(SQLDataMiningFunction x);

    boolean visit(AbstractSQLDataMiningFunction.SQLIntoArgumentExpr x);

    boolean visit(AbstractSQLDataMiningFunction.SQLForArgumentExpr x);

    boolean visit(AbstractSQLDataMiningFunction.SQLCostMatrixClause x);

    boolean visit(AbstractSQLDataMiningFunction.SQLMiningAttributeClause x);


    boolean visit(SQLJsonFunction x);

    boolean visit(AbstractSQLJsonFunction.SQLFormatJsonArgumentExpr x);

    boolean visit(AbstractSQLJsonFunction.SQLKeyValueArgumentExpr x);

    boolean visit(AbstractSQLJsonFunction.SQLJsonReturningClause x);

    boolean visit(AbstractSQLJsonFunction.SQLDefaultOnErrorExpr x);

    boolean visit(AbstractSQLJsonFunction.SQLDefaultOnEmptyExpr x);

    boolean visit(AbstractSQLJsonFunction.SQLJsonColumnsClause x);

    boolean visit(AbstractSQLJsonFunction.SQLJsonExistsColumn x);

    boolean visit(AbstractSQLJsonFunction.SQLJsonQueryColumn x);

    boolean visit(AbstractSQLJsonFunction.SQLJsonValueColumn x);

    boolean visit(AbstractSQLJsonFunction.SQLJsonNestedPathColumn x);

    boolean visit(AbstractSQLJsonFunction.SQLJsonOrdinalityColumn x);


    boolean visit(SQLCastFunction x);

    boolean visit(SQLCharFunction x);

    boolean visit(SQLExtractFunction x);

    boolean visit(SQLFirstFunction x);

    boolean visit(SQLLastFunction x);

    boolean visit(SQLListAggFunction x);

    boolean visit(SQLListAggFunction.SQLOnOverflowTruncateClause x);

    boolean visit(SQLCubeTableFunction x);

    boolean visit(SQLCubeTableFunction.SQLArgumentExpr x);

    boolean visit(SQLCubeTableFunction.SQLCubeTableOptionExpr x);


    boolean visit(SQLChrFunction x);

    boolean visit(SQLCollectionMethodInvocation x);

    boolean visit(SQLConvertUsingFunction x);

    boolean visit(SQLTreatFunction x);

    boolean visit(SQLTrimFunction x);

    boolean visit(SQLValidateConversionFunction x);

    boolean visit(SQLTranslateUsingFunction x);


    boolean visit(SQLWindowFunction x);

    boolean visit(SQLOverClause x);

    boolean visit(SQLOverWindowNameClause x);

    boolean visit(SQLWindowSpecification x);

    boolean visit(SQLWindowFrameClause x);

    boolean visit(SQLWindowFrameClause.SQLWindowFrameBetween x);

    boolean visit(SQLWindowFrameClause.SQLWindowFramePreceding x);

    boolean visit(SQLWindowFrameClause.SQLWindowFrameFollowing x);


    boolean visit(SQLXmlNameExprArgument x);

    boolean visit(SQLXmlEvalNameExprArgument x);

    boolean visit(SQLXmlPassingClause x);

    boolean visit(SQLXmlCastFunction x);

    boolean visit(SQLXmlColAttValFunction x);

    boolean visit(SQLXmlParseFunction x);

    boolean visit(SQLXmlTableFunction x);

    boolean visit(SQLXmlTableFunction.SQLXmlNamespacesClause x);

    boolean visit(SQLXmlTableFunction.SQLXmlTableOption x);

    boolean visit(SQLXmlTableFunction.SQLXmlTableColumnByForOrdinality x);

    boolean visit(SQLXmlTableFunction.SQLXmlTableColumnByDataType x);

    boolean visit(SQLXmlElementFunction x);

    boolean visit(SQLXmlElementFunction.SQLXmlAttributesClause x);

    boolean visit(SQLXmlExistsFunction x);

    boolean visit(SQLXmlForestFunction x);

    boolean visit(SQLXmlPiFunction x);

    boolean visit(SQLXmlQueryFunction x);

    boolean visit(SQLXmlRootFunction x);

    boolean visit(SQLXmlRootFunction.SQLVersionArgument x);

    boolean visit(SQLXmlSerializeFunction x);

    boolean visit(SQLPositionFunction x);

    boolean visit(SQLSubStrFromFunction x);

    boolean visit(SQLSubStringFromFunction x);

    boolean visit(SQLWeightStringFunction x);


    boolean visit(SQLMethodInvocation x);

    boolean visit(AbstractSQLFunction.SQLDefaultOnConversionError x);


    boolean visit(SQLStaticMethodInvocation x);


    // ------------------------- Functions End ----------------------------------------


    // ------------------------- Commons Expr Start ----------------------------------------

    boolean visit(SQLFromClause x);

    boolean visit(SQLHierarchicalQueryConnectByStartWithClause x);

    boolean visit(SQLHierarchicalQueryStartWithConnectByClause x);

    boolean visit(SQLObjectNameTableReference x);

    boolean visit(SQLPartitionClause x);

    boolean visit(SQLPartitionForClause x);

    boolean visit(SQLSubPartitionClause x);

    boolean visit(SQLSubPartitionForClause x);

    boolean visit(SQLSubQueryTableReference x);

    boolean visit(SQLUnNestFunctionTableReference x);

    boolean visit(SQLTableFunctionTableReference x);

    boolean visit(SQLJoinTableReference x);

    boolean visit(SQLJoinTableReference.SQLJoinOnCondition x);

    boolean visit(SQLJoinTableReference.SQLJoinUsingCondition x);


    boolean visit(SQLCompileClause x);

    boolean visit(SQLCubeClause x);

    boolean visit(SQLCurrentOfClause x);

    boolean visit(SQLDefaultClause x);

    boolean visit(SQLDefaultOnNullClause x);

    boolean visit(SQLDeterministicClause x);


    boolean visit(SQLErrorLoggingClause x);


    boolean visit(SQLExceptionClause x);


    boolean visit(SQLPartitionByClause x);

    boolean visit(SQLProcedureInvocation x);


    boolean visit(SQLSampleClause x);

    boolean visit(SQLRollupClause x);

    boolean visit(SQLSelectQueryExpr x);

    boolean visit(SQLUsingClause x);

    boolean visit(SQLUsingClause.SQLUsingArgumentClause x);


    boolean visit(SQLValuesClause x);

    boolean visit(SQLValuesClause.SQLValuesItem x);

    boolean visit(SQLWhereClause x);


    boolean visit(SQLCharacterSetOptionExpr x);

    boolean visit(SQLCollationExpr x);

    boolean visit(SQLDefinerOptionExpr x);


    boolean visit(SQLSetOptionExpr x);

    boolean visit(SQLReservedIdentifier x);


    boolean visit(SQLBody x);

    boolean visit(SQLBody.SQLBodyItem x);

    boolean visit(SQLLabel x);


    boolean visit(SQLBoundsClause x);

    boolean visit(SQLBoundsByIndicesOfClause x);

    boolean visit(SQLBoundsByValuesOfClause x);

    boolean visit(SQLBroadcastExpr x);

    // ------------------------- column constraint Start ----------------------------------------
    boolean visit(SQLAutoIncrementColumnConstraint x);

    boolean visit(SQLCheckColumnConstraint x);

    boolean visit(SQLNotNullColumnConstraint x);

    boolean visit(SQLNullColumnConstraint x);

    boolean visit(SQLPrimaryKeyColumnConstraint x);

    boolean visit(SQLReferencesColumnConstraint x);
    boolean visit(SQLReferencesColumnConstraint.SQLOnUpdateAction x);
    boolean visit(SQLReferencesColumnConstraint.SQLOnDeleteAction x);

    boolean visit(SQLUniqueColumnConstraint x);

    boolean visit(SQLScopeIsColumnConstraint x);

    boolean visit(SQLWithRowIdColumnConstraint x);

    boolean visit(SQLFormatColumnConstraint x);
    boolean visit(SQLStorageColumnConstraint x);

    // ------------------------- column constraint End ----------------------------------------


    // ------------------------- table constraint Start ----------------------------------------

    boolean visit(SQLCheckTableConstraint x);

    boolean visit(SQLForeignKeyTableConstraint x);

    boolean visit(SQLPrimaryKeyTableConstraint x);

    boolean visit(SQLUniqueTableConstraint x);

    boolean visit(SQLIndexTableConstraint x);

    boolean visit(SQLKeyTableConstraint x);

    boolean visit(SQLFullTextTableConstraint x);

    boolean visit(SQLSpatialTableConstraint x);

    boolean visit(SQLScopeForTableConstraint x);

    boolean visit(SQLRefWithRowIdTableConstraint x);

    boolean visit(SQLConstraint.SQLColumn x);

    // ------------------------- table constraint End ----------------------------------------


    // ------------------------- constraint option Start ----------------------------------------

    boolean visit(SQExceptionsClause x);

    boolean visit(SQLDeferrableConstraintState x);

    boolean visit(SQLDisableConstraintState x);

    boolean visit(SQLEnableConstraintState x);

    boolean visit(SQLInitiallyDeferredConstraintState x);

    boolean visit(SQLInitiallyImmediateConstraintState x);

    boolean visit(SQLNoRelyConstraintState x);

    boolean visit(SQLNotDeferrableConstraintState x);

    boolean visit(SQLRelyConstraintState x);

    boolean visit(SQNoValidateConstraintState x);

    boolean visit(SQValidateConstraintState x);
    // ------------------------- constraint option  End ----------------------------------------

// ------------------------- Commons Expr End ----------------------------------------


    // ------------------ details -----------------------------------------

    // ------------------ analytic Details Start ----------------------
    boolean visit(SQLAlterAnalyticRenameToAction x);
    boolean visit(SQLAlterAnalyticCompileAction x);
    // ------------------ analytic Details Start ----------------------

    // ------------------ Index Details Start ----------------------
    boolean visit(SQLIndexColumn x);

    boolean visit(SQLLocalPartitionIndex x);

    boolean visit(SQLGlobalPartitionByHash x);

    boolean visit(SQLGlobalPartitionByRange x);

    boolean visit(SQLIndexTypeIsIndexTypeClause x);

    boolean visit(SQLPartialIndexByFullClause x);

    boolean visit(SQLPartialIndexByPartialClause x);


    boolean visit(SQLIndexAttributeComputeStatistics x);

    boolean visit(SQLIndexAttributeInvisible x);

    boolean visit(SQLIndexAttributeNoSort x);

    boolean visit(SQLIndexAttributeOnline x);

    boolean visit(SQLIndexAttributeReverse x);

    boolean visit(SQLIndexAttributeSort x);

    boolean visit(SQLIndexAttributeVisible x);


    boolean visit(SQLShrinkClause x);


    boolean visit(SQLAlterIndexCoalesceAction x);

    boolean visit(SQLAlterIndexCompileAction x);

    boolean visit(SQLAlterIndexDisableAction x);

    boolean visit(SQLAlterIndexEnableAction x);

    boolean visit(SQLAlterIndexInvisibleAction x);

    boolean visit(SQLAlterIndexMonitoringUsageAction x);

    boolean visit(SQLAlterIndexNoMonitoringUsageAction x);

    boolean visit(SQLAlterIndexRebuildAction x);

    boolean visit(SQLAlterIndexRenameAction x);

    boolean visit(SQLAlterIndexUnusableAction x);

    boolean visit(SQLAlterIndexUpdateBlockReferencesAction x);

    boolean visit(SQLAlterIndexVisibleAction x);

    boolean visit(SQLAlterIndexModifyDefaultAttributesAction x);

    boolean visit(SQLAlterIndexAddPartitionAction x);

    boolean visit(SQLAlterIndexModifyPartitionAction x);
    boolean visit(SQLAlterIndexModifyPartitionAction.SQLCoalesceOption x);
    boolean visit(SQLAlterIndexModifyPartitionAction.SQLUpdateBlockReferencesOption x);
    boolean visit(SQLAlterIndexModifyPartitionAction.SQLUnusableOption x);

    boolean visit(SQLAlterIndexRenamePartitionAction x);

    boolean visit(SQLAlterIndexRenameSubPartitionAction x);

    boolean visit(SQLAlterIndexSplitPartitionAction x);

    boolean visit(SQLAlterIndexDropPartitionAction x);

    boolean visit(SQLAlterIndexCoalescePartitionAction x);

    boolean visit(SQLAlterIndexModifySubPartitionAction x);

    boolean visit(SQLAlterIndexModifySubPartitionAction.SQLUnusableOption x);
    // ------------------ Index Details End ----------------------

    // ------------------ Materialized View Details Start ----------------------
    boolean visit(SQLMaterializedViewColumn x);

    boolean visit(SQLOnPrebuiltTableProperty x);

    boolean visit(SQLMaterializedViewPropertyCacheClause x);

    boolean visit(SQLMaterializedViewPropertyNoCacheClause x);

    boolean visit(SQLUsingIndexClause x);

    boolean visit(SQLUsingIndexClause.SQLCreateIndexStatementItem x);

    boolean visit(SQLUsingNoIndexClause x);

    boolean visit(SQLCreateMVNeverRefresh x);

    boolean visit(SQLCreateMVRefresh x);

    boolean visit(SQLCreateMVRefresh.SQLCreateMVRefreshFastItem x);

    boolean visit(SQLCreateMVRefresh.SQLCreateMVRefreshCompleteItem x);

    boolean visit(SQLCreateMVRefresh.SQLCreateMVRefreshForceItem x);

    boolean visit(SQLCreateMVRefresh.SQLCreateMVRefreshOnDemandItem x);

    boolean visit(SQLCreateMVRefresh.SQLCreateMVRefreshOnCommitItem x);

    boolean visit(SQLCreateMVRefresh.SQLCreateMVRefreshOnStatementItem x);

    boolean visit(SQLCreateMVRefresh.SQLCreateMVRefreshStartWithItem x);

    boolean visit(SQLCreateMVRefresh.SQLCreateMVRefreshNextItem x);

    boolean visit(SQLCreateMVRefresh.SQLCreateMVRefreshWithPrimaryKeyItem x);

    boolean visit(SQLCreateMVRefresh.SQLCreateMVRefreshWithRowidItem x);

    boolean visit(SQLCreateMVRefresh.SQLCreateMVRefreshUsingRollbackSegmentItem x);

    boolean visit(SQLCreateMVRefresh.SQLUsingRollbackSegmentByDefaultItem x);

    boolean visit(SQLCreateMVRefresh.SQLUsingRollbackSegmentByNoDefaultItem x);

    boolean visit(SQLCreateMVRefresh.SQLCreateMVRefreshUsingEnforcedConstraintsItem x);

    boolean visit(SQLCreateMVRefresh.SQLCreateMVRefreshUsingTrustedConstraintsItem x);

    boolean visit(SQLOnQueryComputationClause x);

    boolean visit(SQLQueryRewriteClause x);
    // ------------------ Materialized View Details End ----------------------


    // ------------------ Select Details Start ----------------------
    boolean visit(SQLGroupByClause x);

    boolean visit(SQLGroupByClause.SQLGroupByItem x);

    boolean visit(SQLGroupingSetsClause x);

    boolean visit(SQLHavingClause x);


    boolean visit(SQLLimitOffsetClause x);

    boolean visit(SQLOffsetFetchClause x);


    boolean visit(SQLOrderByClause x);

    boolean visit(SQLOrderByItem x);


    boolean visit(SQLForUpdateClause x);

    boolean visit(SQLForUpdateClause.SQLForSkipLockedOption x);

    boolean visit(SQLForUpdateClause.SQLForNoWaitOption x);

    boolean visit(SQLForUpdateClause.SQLForWaitOption x);

    boolean visit(SQLLockInShareModeClause x);


    boolean visit(SQLParenSelectQuery x);

    boolean visit(SQLSelectQuery x);

    boolean visit(SQLSelectItem x);

    boolean visit(SQLSelectTargetItem x);

    boolean visit(SQLSelectUnionQuery x);


    boolean visit(SQLWithClause x);

    boolean visit(SQLWithClause.SQLSubQueryFactoringClause x);

    boolean visit(SQLWithClause.SQLSearchClause x);

    boolean visit(SQLWithClause.SQLCycleClause x);


    // ------------------ Select Details End ----------------------


    // ------------------ sequence
    boolean visit(SQLAsDataTypeOption x);

    boolean visit(SQLSequenceCacheOption x);

    boolean visit(SQLSequenceCycleOption x);

    boolean visit(SQLSequenceGlobalOption x);

    boolean visit(SQLSequenceIncrementByOption x);

    boolean visit(SQLSequenceKeepOption x);

    boolean visit(SQLSequenceMaxValueOption x);

    boolean visit(SQLSequenceMinValueOption x);

    boolean visit(SQLSequenceNoCacheOption x);

    boolean visit(SQLSequenceNoCycleOption x);

    boolean visit(SQLSequenceNoKeepOption x);

    boolean visit(SQLSequenceNoMaxValueOption x);

    boolean visit(SQLSequenceNoMinValueOption x);

    boolean visit(SQLNoneOption x);

    boolean visit(SQLSequenceNoOrderOption x);

    boolean visit(SQLSequenceOrderOption x);

    boolean visit(SQLOwnedByOption x);

    boolean visit(SQLOwnedToOption x);

    boolean visit(SQLRenameToClause x);

    boolean visit(SQLReStartWithOption x);

    boolean visit(SQLNoScaleOption x);

    boolean visit(SQLScaleOption x);


    boolean visit(SQLSequenceSessionOption x);

    boolean visit(SQLSetSchemaOption x);

    boolean visit(SQLSequenceStartWithOption x);
    // ------------------ sequence end ---------------------------

    // ------------------ Table Details Start ----------------------
    boolean visit(SQLColumnDefinition x);

    boolean visit(SQLVirtualColumnDefinition x);

    boolean visit(SQLLikeClause x);


    boolean visit(SQLPartitionByConsistentHash x);

    boolean visit(SQLPartitionByHash x);

    boolean visit(SQLPartitionByKey x);

    boolean visit(SQLPartitionByList x);

    boolean visit(SQLPartitionByListColumns x);

    boolean visit(SQLPartitionByRange x);

    boolean visit(SQLPartitionByRangeColumns x);

    boolean visit(SQLPartitionByReference x);

    boolean visit(SQLPartitionBySystem x);

    boolean visit(SQLPartitionDefinition x);

    boolean visit(SQLPartitionsetByList x);

    boolean visit(SQLPartitionsetByRange x);

    boolean visit(SQLPartitionsetDefinition x);

    boolean visit(SQLSubPartitionByHash x);

    boolean visit(SQLSubPartitionByKey x);

    boolean visit(SQLSubPartitionByList x);

    boolean visit(SQLSubPartitionByRange x);

    boolean visit(SQLSubpartitionTemplate x);

    boolean visit(SQLSubPartitionDefinition x);


    boolean visit(SQLPartitionValuesLessThan x);

    boolean visit(SQLPartitionValuesLessThanMaxValue x);

    boolean visit(SQLPartitionValuesIn x);

    boolean visit(SQLPartitionValues x);

    boolean visit(SQLIdentityClause x);

    boolean visit(SQLIdentityStartWithOption x);

    boolean visit(SQLIdentityIncrementByOption x);

    boolean visit(SQLIdentityMaxValueOption x);

    boolean visit(SQLIdentityNoMaxValueOption x);

    boolean visit(SQLIdentityMinValueOption x);

    boolean visit(SQLIdentityNoMinValueOption x);

    boolean visit(SQLIdentityCycleOption x);

    boolean visit(SQLIdentityNoCycleOption x);

    boolean visit(SQLIdentityCacheOption x);

    boolean visit(SQLIdentityNoCacheOption x);

    boolean visit(SQLIdentityOrderOption x);

    boolean visit(SQLIdentityNoOrderOption x);


    boolean visit(SQLAlterTableRenameTableAction x);


    boolean visit(ISQLAlterTableColumnAction.SQLFirstPropertyExpr x);

    boolean visit(ISQLAlterTableColumnAction.SQLAfterPropertyExpr x);

    boolean visit(SQLAlterTableAddColumnAction x);

    boolean visit(SQLAlterTableChangeColumnAction x);

    boolean visit(SQLAlterTableDropColumnAction x);

    boolean visit(SQLAlterTableDropColumnsContinueAction x);

    boolean visit(SQLAlterTableDropUnusedColumnsAction x);

    boolean visit(SQLAlterTableModifyCollectionRetrievalAction x);

    boolean visit(SQLAlterTableModifyColumnsAction x);

    boolean visit(SQLAlterTableModifyColumnAction x);


    boolean visit(SQLAlterTableAlterColumnAction x);
    boolean visit(SQLAlterTableAlterColumnAction.SQLSetColumnDefaultClause x);
    boolean visit(SQLAlterTableAlterColumnAction.SQLDropColumnDefaultClause x);
    boolean visit(SQLAlterTableAlterColumnAction.SQLAddColumnScopeClause x);
    boolean visit(SQLAlterTableAlterColumnAction.SQLDropColumnScopeClause x);

    boolean visit(SQLAlterTableRenameColumnAction x);

    boolean visit(SQLAlterTableSetUnusedColumnAction x);


    boolean visit(SQLAlterTableModifyLobStorageAction x);

    boolean visit(SQLAlterTableOrderByColumnAction x);

    boolean visit(SQLAlterTableAlterVarrayColPropertyAction x);


    boolean visit(SQLAlterTableAddTableConstraintAction x);

    boolean visit(SQLAlterTableAlterIndexConstraintAction x);

    boolean visit(SQLAlterTableConstraintAction x);

    boolean visit(SQLAlterTableDropIndexConstraintAction x);

    boolean visit(SQLAlterTableDropKeyConstraintAction x);

    boolean visit(SQLAlterTableDropPrimaryKeyConstraintAction x);

    boolean visit(SQLAlterTableDropTableConstraintAction x);

    boolean visit(SQLAlterTableDropUniqueConstraintAction x);

    boolean visit(SQLAlterTableModifyPrimaryKeyConstraintAction x);

    boolean visit(SQLAlterTableModifyTableConstraintAction x);

    boolean visit(SQLAlterTableModifyUniqueConstraintAction x);

    boolean visit(SQLAlterTableRenameTableConstraintAction x);

    boolean visit(SQLAlterTableRenameIndexConstraintAction x);

    boolean visit(SQLAlterTableRenameKeyConstraintAction x);

    boolean visit(SQLAlterTableValidateTableConstraintAction x);


    boolean visit(ISQLAlterTableIotAction.SQLAlterTableCoalesceIotAction x);
    boolean visit(SQLAlterTableAddOverflowIotAction x);
    boolean visit(SQLAlterTableAlterOverflowIotAction x);
    boolean visit(SQLAlterTableMappingTableIotAction x);


    boolean visit(ISQLAlterTablePartitionAction.SQLForItem x);

    boolean visit(SQLAlterTableAddPartitionAction x);

    boolean visit(SQLAlterTableCoalescePartitionAction x);
    boolean visit(SQLCoalesceSubPartitionAction x);

    boolean visit(SQLAlterTableDropPartitionAction x);
    boolean visit(SQLAlterTableDropSubPartitionAction x);


    boolean visit(SQLAlterTableExchangePartitionAction x);
    boolean visit(SQLAlterTableExchangePartitionForAction x);
    boolean visit(SQLAlterTableExchangeSubPartitionAction x);
    boolean visit(SQLAlterTableExchangeSubPartitionForAction x);

    boolean visit(SQLAlterTableMergePartitionsAction x);
    boolean visit(SQLAlterTableMergePartitionsToAction x);

    boolean visit(SQLAlterTableMergeSubPartitionsAction x);
    boolean visit(SQLAlterTableMergeSubPartitionsToAction x);

    boolean visit(SQLAlterTableModifyPartitionAction x);
    boolean visit(SQLAlterTableModifyPartitionForAction x);
    boolean visit(SQLAlterTableModifySubPartitionAction x);
    boolean visit(SQLAlterTableModifySubPartitionForAction x);

    boolean visit(AbstractSQLAlterTableModifyPartitionAction.SQLModifyPartitionAddValuesAction x);
    boolean visit(AbstractSQLAlterTableModifyPartitionAction.SQLModifyPartitionDropValuesAction x);
    boolean visit(AbstractSQLAlterTableModifyPartitionAction.SQLModifyPartitionUnusableLocalIndexesAction x);
    boolean visit(AbstractSQLAlterTableModifyPartitionAction.SQLModifyPartitionAddSubPartitionAction x);


    boolean visit(SQLAlterTableRenamePartitionAction x);

    boolean visit(SQLAlterTableRenamePartitionForAction x);

    boolean visit(SQLAlterTableRenameSubPartitionAction x);

    boolean visit(SQLAlterTableRenameSubPartitionForAction x);

    boolean visit(SQLAlterTableSetIntervalAction x);

    boolean visit(SQLAlterTableSetPartitioningAction x);

    boolean visit(SQLAlterTableSetStoreInAction x);

    boolean visit(SQLAlterTableSetSubPartitionTemplateAction x);

    boolean visit(SQLAlterTableSplitPartitionAction x);
    boolean visit(SQLAlterTableSplitPartitionForAction x);
    boolean visit(SQLAlterTableSplitSubPartitionAction x);
    boolean visit(SQLAlterTableSplitSubPartitionForAction x);
    boolean visit(AbstractSQLAlterTableSplitPartitionAction.SQLAt x);
    boolean visit(AbstractSQLAlterTableSplitPartitionAction.SQLValues x);
    boolean visit(AbstractSQLAlterTableSplitPartitionAction.SQLInto x);
    boolean visit(AbstractSQLAlterTableSplitPartitionAction.SQLSplitNestedTablePart x);


    boolean visit(SQLAlterTableTruncatePartitionAction x);

    boolean visit(SQLAlterTableTruncateSubPartitionAction x);

    boolean visit(SQLAnalyzePartitionDefinition x);

    boolean visit(SQLCheckPartitionDefinition x);

    boolean visit(SQLCoalescePartitionDefinition x);

    boolean visit(SQLDiscardPartitionDefinition x);

    boolean visit(SQLExchangePartitionDefinition x);

    boolean visit(SQLImportPartitionDefinition x);

    boolean visit(SQLAlterTableMovePartitionAction x);

    boolean visit(SQLAlterTableMovePartitionForAction x);

    boolean visit(SQLAlterTableMoveSubPartitionAction x);
    boolean visit(SQLAlterTableMoveSubPartitionForAction x);

    boolean visit(SQLAlterTableOptimizePartitionAction x);

    boolean visit(SQLAlterTableRebuildPartitionAction x);

    boolean visit(SQLAlterTableRemovePartitioningAction x);

    boolean visit(SQLAlterTableReorganizePartitionAction x);

    boolean visit(SQLAlterTableRepairPartitionAction x);

    boolean visit(SQLAlterTableUpgradePartitioningAction x);


    boolean visit(SQLAlterTableDisableTriggerAction x);

    boolean visit(SQLAlterTableEnableTriggerAction x);


    boolean visit(SQLAlterTableCacheAction x);

    boolean visit(SQLAlterTableDisableAllTriggersAction x);

    boolean visit(SQLAlterTableDisableContainerMapAction x);

    boolean visit(SQLAlterTableDisableContainersDefaultAction x);

    boolean visit(SQLAlterTableDisableTableLockAction x);

    boolean visit(SQLAlterTableEnableAllTriggersAction x);

    boolean visit(SQLAlterTableEnableContainerMapAction x);

    boolean visit(SQLAlterTableEnableContainersDefaultAction x);

    boolean visit(SQLAlterTableEnableTableLockAction x);

    boolean visit(SQLAlterTableForceAction x);

    boolean visit(SQLAlterTableModifyOpaqueTypeAction x);

    boolean visit(SQLAlterTableMoveTableAction x);

    boolean visit(SQLAlterTableNoCacheAction x);

    boolean visit(SQLAlterTableReadOnlyAction x);

    boolean visit(SQLAlterTableReadWriteAction x);

    boolean visit(SQLAlterTableRowArchivalAction x);

    boolean visit(SQLAlterTableUpgradeTableAction x);

    boolean visit(SQLAlterTableWithoutValidationAction x);

    boolean visit(SQLAlterTableWithValidationAction x);



    boolean visit(SQLAlterXmlSchemaClause.SQLAlterXmlSchemaAllowAnySchemaClause x);

    boolean visit(SQLAlterXmlSchemaClause.SQLAlterXmlSchemaAllowNonSchemaClause x);

    boolean visit(SQLAlterXmlSchemaClause.SQLAlterXmlSchemaDisallowNonSchemaClause x);


    boolean visit(ISQLEnableDisableClause.SQLEnableUniqueClause x);

    boolean visit(ISQLEnableDisableClause.SQLEnablePrimaryKeyClause x);

    boolean visit(ISQLEnableDisableClause.SQLEnableConstraintClause x);

    boolean visit(ISQLEnableDisableClause.SQLDisableUniqueClause x);

    boolean visit(ISQLEnableDisableClause.SQLDisablePrimaryKeyClause x);

    boolean visit(ISQLEnableDisableClause.SQLDisableConstraintClause x);

    boolean visit(SQLAttributeClusteringClause x);
    boolean visit(SQLAttributeClusteringClause.SQLClusteringJoin x);
    boolean visit(SQLAttributeClusteringClause.SQLClusteringJoinItem x);
    boolean visit(SQLAttributeClusteringClause.SQLClusterClause x);
    boolean visit(SQLAttributeClusteringClause.SQLClusteringWhen x);
    boolean visit(SQLAttributeClusteringClause.SQLWithMaterializedZoneMapClause x);
    boolean visit(SQLAttributeClusteringClause.SQLWithoutMaterializedZoneMapClause x);

    boolean visit(SQLDependentTablesClause x);

    boolean visit(SQLDependentTablesClause.Item x);

    boolean visit(SQLFlashbackArchiveClause x);

    boolean visit(SQLForExchangeWithTableClause x);

    boolean visit(SQLInvalidateGlobalIndexClause x);

    boolean visit(SQLNoFlashbackArchiveClause x);

    boolean visit(SQLObjectTableSubstitution x);

    boolean visit(SQLOidClause x);

    boolean visit(SQLOidIndexClause x);

    boolean visit(SQLPartitionAttribute.SQLLobClause x);
    boolean visit(SQLPartitionAttribute.SQLVarrayClause x);

    boolean visit(SQLRowMovementClause x);

    boolean visit(SQLTablePropertyResultCache x);

    boolean visit(SQLUpdateGlobalIndexClause x);

    boolean visit(SQLUpdateIndexesClause x);

    boolean visit(SQLUpdateIndexesClause.Item x);
    // ------------------ Table Details End ----------------------


    // ------------------ Trigger Details Start ----------------------

    boolean visit(SQLTriggerDMLEvent x);

    boolean visit(SQLTriggerDDLEvent x);

    boolean visit(SQLTriggerDatabaseEvent x);

    boolean visit(SQLCreateTriggerStatement.SQLOnSchemaExpr x);

    boolean visit(SQLCreateTriggerStatement.SQLOnDatabaseExpr x);

    boolean visit(SQLTriggerReferencingNewOption x);

    boolean visit(SQLTriggerReferencingOldOption x);

    boolean visit(SQLTriggerReferencingParentOption x);

    boolean visit(SQLTriggerOrderingClause x);

    boolean visit(SQLTriggerCompoundTriggerBlock x);

    boolean visit(SQLTriggerCompoundTriggerBlock.SQLTimingPointSection x);

    // ------------------ Trigger Details End ----------------------


    // ------------------ Type Details Start ----------------------
    boolean visit(SQLAlterTypeAddMethodsAction x);
    boolean visit(SQLAlterTypeAddMethodsAction.SQLItem x);

    boolean visit(SQLAlterTypeDropMethodsAction x);
    boolean visit(SQLAlterTypeDropMethodsAction.SQLItem x);

    boolean visit(SQLAlterTypeAddAttributeAction x);
    boolean visit(SQLAlterTypeModifyAttributeAction x);
    boolean visit(SQLAlterTypeAlterAttributeAction x);
    boolean visit(SQLAlterTypeDropAttributeAction x);

    boolean visit(SQLAlterTypeModifyLimitAction x);
    boolean visit(SQLAlterTypeModifyElementTypeAction x);

    // ------------------ Type Details End ----------------------



    // ------------------ Merge Details Start ----------------------

    boolean visit(SQLMergeStatement.SQLMergeWhenMatchClause x);

    boolean visit(SQLMergeStatement.SQLMergeWhenNotMatchClause x);

    // ------------------ Merge Details End ----------------------


    // ------------------ Update Details Start ----------------------

    boolean visit(SQLUpdateSetClause x);

    boolean visit(SQLUpdateSetByValueClause x);

    boolean visit(SQLUpdateSetClause.SQLUpdateSetItemClause x);

    // ------------------ Update Details End ----------------------


    // ------------------ User/Role Details End ----------------------
    boolean visit(SQLIdentifiedByClause x);

    boolean visit(SQLIdentifiedByPasswordClause x);

    boolean visit(SQLIdentifiedExternallyClause x);

    boolean visit(SQLIdentifiedGloballyClause x);

    boolean visit(SQLIdentifiedUsingClause x);

    boolean visit(SQLIdentifiedWithAsClause x);

    boolean visit(SQLIdentifiedWithByClause x);

    boolean visit(SQLIdentifiedWithClause x);

    boolean visit(SQLNoAuthenticationClause x);

    boolean visit(SQLNoIdentifiedClause x);
    // ------------------ User/Role Details End ----------------------


    // ------------------ Commit Details End ----------------------
    boolean visit(SQLCommitCommentOption x);

    boolean visit(SQLCommitWriteOption x);

    boolean visit(SQLCommitForceOption x);

    boolean visit(SQLCommitChainOption x);

    boolean visit(SQLCommitReleaseOption x);
    // ------------------ Commit Details End ----------------------


    // ------------------ Rollback Details End ----------------------
    boolean visit(SQLRollbackToSavepointOption x);

    boolean visit(SQLRollbackForceOption x);

    boolean visit(SQLRollbackChainOption x);

    boolean visit(SQLRollbackReleaseOption x);
    // ------------------ Rollback Details End ----------------------

    // ------------------ SET TRANSACTION Details Start ----------------------
    boolean visit(SQLSetTransactionReadOnlyOption x);

    boolean visit(SQLSetTransactionReadWriteOption x);

    boolean visit(SQLSetTransactionIsolationLevelOption x);

    boolean visit(SQLSetTransactionUseRollbackSegmentOption x);

    boolean visit(SQLSetTransactionSnapshotOption x);

    boolean visit(SQLSetTransactionDeferrableOption x);

    boolean visit(SQLSetTransactionNameOption x);
    // ------------------ SET TRANSACTION Details End ----------------------


    // ------------------ View Details Start ----------------------

    boolean visit(SQLAlterViewAddTableConstraintAction x);

    boolean visit(SQLAlterViewCompileAction x);

    boolean visit(SQLAlterViewDropConstraintAction x);

    boolean visit(SQLAlterViewDropPrimaryKeyConstraintAction x);

    boolean visit(SQLAlterViewDropUniqueConstraintAction x);

    boolean visit(SQLAlterViewEditionableAction x);

    boolean visit(SQLAlterViewModifyConstraintAction x);

    boolean visit(SQLAlterViewNonEditionableAction x);

    boolean visit(SQLAlterViewReadOnlyAction x);

    boolean visit(SQLAlterViewReadWriteAction x);
    // ------------------ View Details Start ----------------------

    void postVisit(SQLObject x);

}
