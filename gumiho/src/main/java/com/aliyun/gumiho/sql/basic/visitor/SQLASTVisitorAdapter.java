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
import com.aliyun.gumiho.sql.translate.SQLTransformConfig;
import com.aliyun.gumiho.sql.translate.result.SQLTransformChange;
import com.aliyun.gumiho.sql.translate.result.SQLTransformError;
import com.aliyun.gumiho.sql.translate.result.SQLTransformWarnning;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author kongtong.ouyang on 2018/1/30.
 */
public class SQLASTVisitorAdapter implements SQLASTVisitor {

    protected final SQLTransformConfig config;

    protected final Set<SQLTransformChange> changes = new LinkedHashSet<>();
    protected final Set<SQLTransformWarnning> warnnings = new LinkedHashSet<>();
    protected final Set<SQLTransformError> errors = new LinkedHashSet<>();


    public SQLASTVisitorAdapter() {
        this.config = new SQLTransformConfig();
    }

    public SQLASTVisitorAdapter(SQLTransformConfig config) {
        if (config == null) {
            config = new SQLTransformConfig();
        }
        this.config = config;
    }


    @Override
    public boolean preVisit(SQLObject x) {
        return true;
    }

    @Override
    public boolean visit(SQLSetCharacterSetStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLSetCharSetStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLSetDefaultRoleStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLSetNameStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLSetPasswordStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLSetVariableStatement x) {
        return true;
    }


    @Override
    public boolean visit(SQLCreateAnalyticStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterAnalyticStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLDropAnalyticStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLCommentOnAuditPolicyStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLCommentOnColumnStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLCommentOnDatabaseStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLCommentOnEditionStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLCommentOnIndexStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLCommentOnIndexTypeStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLCommentOnMaterializedViewStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLCommentOnMiningModelStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLCommentOnOperatorStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLCommentOnRoleStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLCommentOnSequenceStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLCommentOnServerStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLCommentOnTablespaceStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLCommentOnTableStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLCommentOnTypeStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLCommentOnViewStatement x) {
        return true;
    }


    @Override
    public boolean visit(SQLCreateDatabaseStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterDatabaseStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLDropDatabaseStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLCreateDatabaseLinkStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterDatabaseLinkStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLDropDatabaseLinkStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLCreateDomainStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterDomainStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLDropDomainStatement x) {
        return true;
    }


    @Override
    public boolean visit(SQLCreateEventStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterEventStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLDropEventStatement x) {
        return true;
    }


    @Override
    public boolean visit(SQLCreateFunctionStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterFunctionStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLDropFunctionStatement x) {
        return true;
    }


    @Override
    public boolean visit(SQLCreateIndexStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterIndexStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLDropIndexStatement x) {
        return true;
    }


    @Override
    public boolean visit(SQLCreateMaterializedViewStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLCreateMaterializedViewStatement.SQLColumn x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterMaterializedViewStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLDropMaterializedViewStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLCreateMaterializedViewLogStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterMaterializedViewLogStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLDropMaterializedViewLogStatement x) {
        return true;
    }


    @Override
    public boolean visit(SQLCreatePackageStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterPackageStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLDropPackageStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLCreatePackageBodyStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterPackageBodyStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLDropPackageBodyStatement x) {
        return true;
    }


    @Override
    public boolean visit(SQLCreatePluggableDatabaseStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterPluggableDatabaseStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLDropPluggableDatabaseStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLCreateProcedureStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterProcedureStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLDropProcedureStatement x) {
        return true;
    }


    @Override
    public boolean visit(SQLCreateRoleStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterRoleStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLDropRoleStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLCreateRollbackSegmentStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLDropRollbackSegmentStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLCreateSchemaStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterSchemaStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLDropSchemaStatement x) {
        return true;
    }


    @Override
    public boolean visit(SQLCreateSequenceStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterSequenceStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLDropSequenceStatement x) {
        return true;
    }


    @Override
    public boolean visit(SQLCreateServerStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterServerStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLDropServerStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLCreateSynonymStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterSynonymStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLDropSynonymStatement x) {
        return true;
    }


    @Override
    public boolean visit(SQLCreateTableStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLDropTableStatement x) {
        return true;
    }


    @Override
    public boolean visit(SQLCreateTriggerStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTriggerStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLDropTriggerStatement x) {
        return true;
    }


    @Override
    public boolean visit(SQLCreateTypeStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLCreateTypeStatement.SQLExternalNameClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTypeStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLDropTypeStatement x) {
        return true;
    }


    @Override
    public boolean visit(SQLCreateTypeBodyStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLCreateTypeBodyStatement.SQLCreateBodyItem x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTypeBodyStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLDropTypeBodyStatement x) {
        return true;
    }


    @Override
    public boolean visit(SQLCreateUserStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterUserStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLDropUserStatement x) {
        return true;
    }


    @Override
    public boolean visit(SQLCreateViewStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterViewStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLDropViewStatement x) {
        return true;
    }


    @Override
    public boolean visit(SQLOpenStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLCloseStatement x) {
        return true;
    }


    @Override
    public boolean visit(SQLCallStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLLoadDataStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLLoadXmlStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLInsertStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLMultiInsertStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLMultiInsertStatement.SQLInsertIntoClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLMultiInsertStatement.SQLConditionalInsertIntoClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLMultiInsertStatement.SQLInsertIntoClauseItem x) {
        return true;
    }

    @Override
    public boolean visit(SQLMultiInsertStatement.SQLConditionalInsertWhenClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLRenameTableStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLRenameTableStatement.Item x) {
        return true;
    }

    @Override
    public boolean visit(SQLTruncateTableStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLReplaceStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLDoStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLHandlerOpenStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLHandlerReadStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLHandlerCloseStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLDeleteStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLDeleteStatement.SQLUsingClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLUpdateStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLExplainStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLSelectStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLSelectIntoStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLLockTableStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLLockTableStatement.SQLLockTableItem x) {
        return true;
    }

    @Override
    public boolean visit(SQLUnLockTablesStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLContinueStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLExitStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLFetchStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLGotoStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLMergeStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLPipeRowStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLRaiseStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLIfStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLIfStatement.SQLElseIf x) {
        return true;
    }

    @Override
    public boolean visit(SQLIterateStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLLeaveStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLLoopStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLNullStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLOpenForStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLRepeatStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLReturnStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLCaseStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLCaseStatement.SQLCaseStatementWhenItem x) {
        return true;
    }

    @Override
    public boolean visit(SQLCaseStatement.SQLCaseStatementElseClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLForAllStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLForLoopStatement x) {
        return true;
    }


    @Override
    public boolean visit(SQLWhileLoopStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLWhileStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLCommitStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLRollbackStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLSavepointStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLReleaseSavepointStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLSetConstraintStatement x) {
        return true;
    }

    @Override
    public boolean visit(SQLSetConstraintsStatement x) {
        return true;
    }

    @Override
    public boolean visit(ISQLSetConstraintsStatement.SQLAllItem x) {
        return true;
    }

    @Override
    public boolean visit(SQLSetTransactionStatement x) {
        return true;
    }


    @Override
    public boolean visit(SQLUseStatement x) {
        return true;
    }

    // ------------------------- Data Types Start ----------------------------------------
    @Override
    public boolean visit(SQLAnyDataDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLAnyDataSetDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLAnyTypeDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLBoolDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLBooleanDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLArrayDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLAssocArrayDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLMultisetDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLNestedTableDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLVarrayDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLVaryingArrayDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLDateDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLTimeDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLDateTimeDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLTimestampDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLYearDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLIntervalDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLJsonDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLORDAudioDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLORDDicomDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLORDDocDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLORDImageDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLORDVideoDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLSIAverageColorDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLSIColorDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLSIColorHistogramDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLSIFeatureListDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLSIPositionalColorDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLSIStillImageDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLSITextureDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLMoneyDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLBigintDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLBinaryDoubleDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLBinaryFloatDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLBinaryIntegerDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLBitDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLDecDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLDecimalDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLDoubleDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLDoublePrecisionDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLFixedDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLFloatDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLInt1DataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLInt2DataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLInt3DataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLInt4DataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLInt8DataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLIntDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLIntegerDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLMediumintDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLNaturalDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLNaturalnDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLPositiveDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLPositivenDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLSigntypeDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLSimpleDoubleDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLSimpleFloatDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLSimpleIntegerDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLNumberDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLNumericDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLPlsIntegerDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLRealDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLSmallintDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLTinyintDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLObjectDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLRecordDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLRefCursorDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLRefDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLRowDataTypeImpl x) {
        return true;
    }

    @Override
    public boolean visit(SQLGeometryCollectionDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLGeometryDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLLineStringDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLMultiLineStringDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLMultiPointDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLMultiPolygonDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLPointDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLPolygonDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLSDOGeometryDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLSDOGeoRasterDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLSDOTopoGeometryDataType x) {
        return true;
    }


    @Override
    public boolean visit(SQLObjectSubDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLBFileDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLBinaryDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLBlobDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLCharacterDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLCharacterLargeObjectDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLCharacterVaryingDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLCharDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLCharLargeObjectDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLCharVaryingDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLClobDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLLongBlobDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLLongDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLLongRawDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLLongTextDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLMediumBlobDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLMediumTextDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLNationalCharacterDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLNationalCharacterLargeObjectDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLNationalCharacterVaryingDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLNationalCharDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLNationalCharVaryingDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLNationalVarcharDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLNCharDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLNCharLargeObjectDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLNCharVaryingDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLNClobDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLNVarcharDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLNVarchar2DataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLRawDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLRowIdDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLSetDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLStringDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLTextDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLTinyBlobDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLTinyTextDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLURowIdDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLVarBinaryDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLVarchar2DataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLVarcharDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLUriTypeDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLXmlTypeDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLEnumDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLPercentRowTypeDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLTableDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLPercentTypeDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLSelfAsResultDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLDataTypeImpl x) {
        return true;
    }


    // ------------------------- Data Types End ----------------------------------------


    // ------------------------- Identifier Start ----------------------------------------
    @Override
    public boolean visit(SQLIdentifierImpl x) {
        return true;
    }

    @Override
    public boolean visit(SQLAllColumnExpr x) {
        return true;
    }

    @Override
    public boolean visit(SQLDoubleQuoteIdentifier x) {
        return true;
    }

    @Override
    public boolean visit(SQLReverseQuoteIdentifier x) {
        return true;
    }

    @Override
    public boolean visit(SQLPropertyExpr x) {
        return true;
    }

    @Override
    public boolean visit(SQLDBLinkExpr x) {
        return true;
    }

    // ------------------------- Identifier End ----------------------------------------


    // ------------------------- Literal Start ----------------------------------------

    @Override
    public boolean visit(SQLDateLiteral x) {
        return true;
    }

    @Override
    public boolean visit(SQLTimeLiteral x) {
        return true;
    }

    @Override
    public boolean visit(SQLTimestampLiteral x) {
        return true;
    }

    @Override
    public boolean visit(SQLIntervalLiteral x) {
        return true;
    }

    @Override
    public boolean visit(SQLBinaryDoubleLiteral x) {
        return true;
    }

    @Override
    public boolean visit(SQLBinaryFloatLiteral x) {
        return true;
    }

    @Override
    public boolean visit(SQLIntegerLiteral x) {
        return true;
    }

    @Override
    public boolean visit(SQLNumberLiteral x) {
        return true;
    }

    @Override
    public boolean visit(SQLCharLiteral x) {
        return true;
    }

    @Override
    public boolean visit(SQLNCharLiteral x) {
        return true;
    }

    @Override
    public boolean visit(SQLQCharLiteral x) {
        return true;
    }

    @Override
    public boolean visit(SQLNQCharLiteral x) {
        return true;
    }

    @Override
    public boolean visit(SQLUCharLiteral x) {
        return true;
    }

    @Override
    public boolean visit(SQLAllLiteral x) {
        return true;
    }

    @Override
    public boolean visit(SQLAnyLiteral x) {
        return true;
    }

    @Override
    public boolean visit(SQLBitLiteral x) {
        return true;
    }

    @Override
    public boolean visit(SQLBooleanLiteral x) {
        return true;
    }

    @Override
    public boolean visit(SQLHexadecimalLiteral x) {
        return true;
    }

    @Override
    public boolean visit(SQLMaxValueLiteral x) {
        return true;
    }

    @Override
    public boolean visit(SQLMinValueLiteral x) {
        return true;
    }

    @Override
    public boolean visit(SQLNoneLiteral x) {
        return true;
    }

    @Override
    public boolean visit(SQLNullExpr x) {
        return true;
    }

    @Override
    public boolean visit(SQLUnLimitedLiteral x) {
        return true;
    }

    // ------------------------- Literal End ----------------------------------------



    // ------------------------- Pseudo Column Start ----------------------------------------

    @Override
    public boolean visit(SQLColumnValueExpr x) {
        return true;
    }

    @Override
    public boolean visit(SQLConnectByIsCycleExpr x) {
        return true;
    }

    @Override
    public boolean visit(SQLConnectByIsLeafExpr x) {
        return true;
    }

    @Override
    public boolean visit(SQLLevelExpr x) {
        return true;
    }

    @Override
    public boolean visit(SQLObjectIdExpr x) {
        return true;
    }

    @Override
    public boolean visit(SQLObjectValueExpr x) {
        return true;
    }

    @Override
    public boolean visit(SQLOraRowScnExpr x) {
        return true;
    }

    @Override
    public boolean visit(SQLRowIdExpr x) {
        return true;
    }

    @Override
    public boolean visit(SQLRowNumExpr x) {
        return true;
    }

    @Override
    public boolean visit(SQLSequenceExpr x) {
        return true;
    }

    @Override
    public boolean visit(SQLVersionsEndScnExpr x) {
        return true;
    }

    @Override
    public boolean visit(SQLVersionsEndTimeExpr x) {
        return true;
    }

    @Override
    public boolean visit(SQLVersionsOperationExpr x) {
        return true;
    }

    @Override
    public boolean visit(SQLVersionsStartScnExpr x) {
        return true;
    }

    @Override
    public boolean visit(SQLVersionsStartTimeExpr x) {
        return true;
    }

    @Override
    public boolean visit(SQLVersionsXidExpr x) {
        return true;
    }

    @Override
    public boolean visit(SQLXmlDataExpr x) {
        return true;
    }
    // ------------------------- Pseudo Column End ----------------------------------------


    // ------------------------- Comment Start ----------------------------------------

    // ------------------------- Comment End ----------------------------------------

    // ------------------------- Hint Start ----------------------------------------

    @Override
    public boolean visit(SQLUseIndexHint x) {
        return true;
    }

    @Override
    public boolean visit(SQLUseKeyHint x) {
        return true;
    }

    @Override
    public boolean visit(SQLIgnoreIndexHint x) {
        return true;
    }

    @Override
    public boolean visit(SQLIgnoreKeyHint x) {
        return true;
    }

    @Override
    public boolean visit(SQLForceIndexHint x) {
        return true;
    }

    @Override
    public boolean visit(SQLForceKeyHint x) {
        return true;
    }


    // ------------------------- Hint End ----------------------------------------

    // ------------------------- Operators Start ----------------------------------------

    @Override
    public boolean visit(SQLBinaryOperatorExpr x) {
        return true;
    }

    @Override
    public boolean visit(SQLBinaryOperatorGroupExpr x) {
        return true;
    }

    @Override
    public boolean visit(SQLUnaryOperatorExpr x) {
        return true;
    }

    // ------------------------- Operators Start ----------------------------------------


    // ------------------------- Expressions Start ----------------------------------------

    @Override
    public boolean visit(SQLAllClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLAnyClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLCallArgumentExpr x) {
        return true;
    }

    @Override
    public boolean visit(SQLArrayExpr x) {
        return true;
    }

    @Override
    public boolean visit(SQLAssignmentExpr x) {
        return true;
    }

    @Override
    public boolean visit(SQLAttributeDefinition x) {
        return true;
    }

    @Override
    public boolean visit(SQLRegexpCondition x) {
        return true;
    }

    @Override
    public boolean visit(SQLRlikeCondition x) {
        return true;
    }

    @Override
    public boolean visit(SQLSoundsLikeCondition x) {
        return true;
    }

    @Override
    public boolean visit(SQLReturningClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLReturningIntoClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLRowExpr x) {
        return true;
    }

    @Override
    public boolean visit(SQLScopeClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLCaseExpr x) {
        return true;
    }

    @Override
    public boolean visit(SQLCaseExpr.SQLCaseExprWhenItem x) {
        return true;
    }

    @Override
    public boolean visit(SQLCaseExpr.SQLCaseExprElseClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLCursorExpr x) {
        return true;
    }

    @Override
    public boolean visit(SQLDateTimeAtLocalExpr x) {
        return true;
    }

    @Override
    public boolean visit(SQLDateTimeAtTimeZoneExpr x) {
        return true;
    }

    @Override
    public boolean visit(SQLIntervalExpr x) {
        return true;
    }

    @Override
    public boolean visit(SQLDefaultLiteral x) {
        return true;
    }

    @Override
    public boolean visit(SQLExprAsObjectExpr x) {
        return true;
    }

    @Override
    public boolean visit(SQLExprToExprExpr x) {
        return true;
    }

    @Override
    public boolean visit(SQLListExpr x) {
        return true;
    }

    @Override
    public boolean visit(SQLMultisetExpr x) {
        return true;
    }

    @Override
    public boolean visit(SQLOuterJoinExpr x) {
        return true;
    }

    @Override
    public boolean visit(SQLParameterDeclaration x) {
        return true;
    }

    @Override
    public boolean visit(SQLUsingClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLUsingClause.SQLUsingArgumentClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLSomeClause x) {
        return true;
    }


    @Override
    public boolean visit(SQLTypeConstructorExpr x) {
        return true;
    }

    @Override
    public boolean visit(SQLParenExpr x) {
        return true;
    }

    @Override
    public boolean visit(SQLPlaceholderExpr x) {
        return true;
    }

    @Override
    public boolean visit(SQLRangeExpr x) {
        return true;
    }

    @Override
    public boolean visit(SQLBindVariableExpr x) {
        return true;
    }

    @Override
    public boolean visit(SQLVariableExpr x) {
        return true;
    }

    @Override
    public boolean visit(SQLColonNewVariableRefExpr x) {
        return true;
    }

    @Override
    public boolean visit(SQLColonOldVariableRefExpr x) {
        return true;
    }

    @Override
    public boolean visit(SQLNewVariableRefExpr x) {
        return true;
    }

    @Override
    public boolean visit(SQLOldVariableRefExpr x) {
        return true;
    }

    @Override
    public boolean visit(SQLVariableDeclaration x) {
        return true;
    }

    @Override
    public boolean visit(SQLUnusableEditionsClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLUnusableEditionsClause.SQLUnusableBeforeCurrentEditionAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLUnusableEditionsClause.SQLUnusableBeforeEditionAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLUnusableEditionsClause.SQLUnusableBeginningWithCurrentEditionAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLUnusableEditionsClause.SQLUnusableBeginningWithEditionAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLUnusableEditionsClause.SQLUnusableBeginningWithNullEditionAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLBuildClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLEvaluationEditionClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLEvaluationEditionClause.SQLCurrentEditionAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLEvaluationEditionClause.SQLEditionAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLEvaluationEditionClause.SQLNullEditionAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLTablespaceOptionExpr x) {
        return true;
    }

    @Override
    public boolean visit(SQLTableSpaceSetClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLEncryptClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLEncryptionSpec x) {
        return true;
    }

    @Override
    public boolean visit(SQLDecryptClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLStoreInClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLOverflowClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLOverflowStoreInClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLSubPartitionsetStoreInClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLParametersClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLVarrayStorageAsClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLParallelClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLNoParallelClause x) {
        return true;
    }

    @Override
    public boolean visit(ISQLSubqueryRestrictionClause.SQLWithCheckOption x) {
        return true;
    }

    @Override
    public boolean visit(ISQLSubqueryRestrictionClause.SQLWithReadOnly x) {
        return true;
    }

    @Override
    public boolean visit(SQLSubViewClause x) {
        return true;
    }

    @Override
    public boolean visit(ISQLAlterIotClause.SQLCoalesceClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLXmlSchemaSpec x) {
        return true;
    }

    @Override
    public boolean visit(ISQLWithObjectIdClause.SQLWithObjectIdClause x) {
        return true;
    }

    @Override
    public boolean visit(ISQLWithObjectIdClause.SQLWithObjectIdentifierClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLLocalVariableExpr x) {
        return true;
    }

    @Override
    public boolean visit(SQLGlobalVariableExpr x) {
        return true;
    }

    @Override
    public boolean visit(SQLGlobalGlobalVariableExpr x) {
        return true;
    }

    @Override
    public boolean visit(SQLSessionGlobalVariableExpr x) {
        return true;
    }

    @Override
    public boolean visit(SQLPersistGlobalVariableExpr x) {
        return true;
    }

    @Override
    public boolean visit(SQLPersistOnlyGlobalVariableExpr x) {
        return true;
    }

    @Override
    public boolean visit(SQLRebuildClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLRebuildClause.SQLPartitionItem x) {
        return true;
    }

    @Override
    public boolean visit(SQLRebuildClause.SQLSubPartitionItem x) {
        return true;
    }

    @Override
    public boolean visit(SQLRebuildClause.SQLReverseItem x) {
        return true;
    }

    @Override
    public boolean visit(SQLRebuildClause.SQLNoReverseItem x) {
        return true;
    }

    // ------------------------- Expressions End ----------------------------------------


    // ------------------------- Conditions Start ----------------------------------------

    @Override
    public boolean visit(SQLBetweenCondition x) {
        return true;
    }

    @Override
    public boolean visit(SQLExistsCondition x) {
        return true;
    }

    @Override
    public boolean visit(SQLInCondition x) {
        return true;
    }

    @Override
    public boolean visit(SQLIsAnyCondition x) {
        return true;
    }

    @Override
    public boolean visit(SQLIsASetCondition x) {
        return true;
    }

    @Override
    public boolean visit(SQLIsBooleanLiteralCondition x) {
        return true;
    }

    @Override
    public boolean visit(SQLIsEmptyCondition x) {
        return true;
    }

    @Override
    public boolean visit(SQLIsInfiniteCondition x) {
        return true;
    }

    @Override
    public boolean visit(SQLIsJsonCondition x) {
        return true;
    }

    @Override
    public boolean visit(SQLIsNanCondition x) {
        return true;
    }

    @Override
    public boolean visit(SQLIsNullCondition x) {
        return true;
    }

    @Override
    public boolean visit(SQLIsOfTypeCondition x) {
        return true;
    }

    @Override
    public boolean visit(SQLIsOfTypeCondition.Item x) {
        return true;
    }

    @Override
    public boolean visit(SQLIsPresentCondition x) {
        return true;
    }

    @Override
    public boolean visit(SQLJsonExistsCondition x) {
        return true;
    }

    @Override
    public boolean visit(SQLLikeCondition x) {
        return true;
    }

    @Override
    public boolean visit(SQLMemberCondition x) {
        return true;
    }

    @Override
    public boolean visit(SQLNotCondition x) {
        return true;
    }

    @Override
    public boolean visit(SQLParenCondition x) {
        return true;
    }

    @Override
    public boolean visit(SQLRegexpLikeCondition x) {
        return true;
    }

    @Override
    public boolean visit(SQLSubMultisetCondition x) {
        return true;
    }

    @Override
    public boolean visit(SQLDeletingCondition x) {
        return true;
    }

    @Override
    public boolean visit(SQLInsertingCondition x) {
        return true;
    }

    @Override
    public boolean visit(SQLUpdatingCondition x) {
        return true;
    }

    @Override
    public boolean visit(SQLFilterCondition x) {
        return true;
    }

    // ------------------------- Conditions End ----------------------------------------


    // ------------------------- Functions Start ----------------------------------------

    @Override
    public boolean visit(SQLAggregateFunction x) {
        return true;
    }

    @Override
    public boolean visit(AbstractSQLAggregateFunction.SQLWithinGroupSpecification x) {
        return true;
    }

    @Override
    public boolean visit(AbstractSQLAggregateFunction.SQLFilterClause x) {
        return true;
    }


    @Override
    public boolean visit(SQLDataMiningFunction x) {
        return true;
    }

    @Override
    public boolean visit(AbstractSQLDataMiningFunction.SQLIntoArgumentExpr x) {
        return true;
    }

    @Override
    public boolean visit(AbstractSQLDataMiningFunction.SQLForArgumentExpr x) {
        return true;
    }

    @Override
    public boolean visit(AbstractSQLDataMiningFunction.SQLCostMatrixClause x) {
        return true;
    }

    @Override
    public boolean visit(AbstractSQLDataMiningFunction.SQLMiningAttributeClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLJsonFunction x) {
        return true;
    }

    @Override
    public boolean visit(AbstractSQLJsonFunction.SQLFormatJsonArgumentExpr x) {
        return true;
    }

    @Override
    public boolean visit(AbstractSQLJsonFunction.SQLKeyValueArgumentExpr x) {
        return true;
    }

    @Override
    public boolean visit(AbstractSQLJsonFunction.SQLJsonReturningClause x) {
        return true;
    }

    @Override
    public boolean visit(AbstractSQLJsonFunction.SQLDefaultOnErrorExpr x) {
        return true;
    }

    @Override
    public boolean visit(AbstractSQLJsonFunction.SQLDefaultOnEmptyExpr x) {
        return true;
    }

    @Override
    public boolean visit(AbstractSQLJsonFunction.SQLJsonColumnsClause x) {
        return true;
    }

    @Override
    public boolean visit(AbstractSQLJsonFunction.SQLJsonExistsColumn x) {
        return true;
    }

    @Override
    public boolean visit(AbstractSQLJsonFunction.SQLJsonQueryColumn x) {
        return true;
    }

    @Override
    public boolean visit(AbstractSQLJsonFunction.SQLJsonValueColumn x) {
        return true;
    }

    @Override
    public boolean visit(AbstractSQLJsonFunction.SQLJsonNestedPathColumn x) {
        return true;
    }

    @Override
    public boolean visit(AbstractSQLJsonFunction.SQLJsonOrdinalityColumn x) {
        return true;
    }

    @Override
    public boolean visit(SQLCastFunction x) {
        return true;
    }

    @Override
    public boolean visit(SQLCharFunction x) {
        return true;
    }

    @Override
    public boolean visit(SQLExtractFunction x) {
        return true;
    }

    @Override
    public boolean visit(SQLFirstFunction x) {
        return true;
    }

    @Override
    public boolean visit(SQLLastFunction x) {
        return true;
    }

    @Override
    public boolean visit(SQLListAggFunction x) {
        return true;
    }

    @Override
    public boolean visit(SQLListAggFunction.SQLOnOverflowTruncateClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLCubeTableFunction x) {
        return true;
    }

    @Override
    public boolean visit(SQLCubeTableFunction.SQLArgumentExpr x) {
        return true;
    }

    @Override
    public boolean visit(SQLCubeTableFunction.SQLCubeTableOptionExpr x) {
        return true;
    }

    @Override
    public boolean visit(SQLChrFunction x) {
        return true;
    }

    @Override
    public boolean visit(SQLCollectionMethodInvocation x) {
        return true;
    }

    @Override
    public boolean visit(SQLConvertUsingFunction x) {
        return true;
    }

    @Override
    public boolean visit(SQLTreatFunction x) {
        return true;
    }

    @Override
    public boolean visit(SQLTrimFunction x) {
        return true;
    }

    @Override
    public boolean visit(SQLValidateConversionFunction x) {
        return true;
    }

    @Override
    public boolean visit(SQLTranslateUsingFunction x) {
        return true;
    }

    @Override
    public boolean visit(SQLWindowFunction x) {
        return true;
    }

    @Override
    public boolean visit(SQLOverClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLOverWindowNameClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLWindowSpecification x) {
        return true;
    }

    @Override
    public boolean visit(SQLWindowFrameClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLWindowFrameClause.SQLWindowFrameBetween x) {
        return true;
    }

    @Override
    public boolean visit(SQLWindowFrameClause.SQLWindowFramePreceding x) {
        return true;
    }

    @Override
    public boolean visit(SQLWindowFrameClause.SQLWindowFrameFollowing x) {
        return true;
    }


    @Override
    public boolean visit(SQLXmlNameExprArgument x) {
        return true;
    }

    @Override
    public boolean visit(SQLXmlEvalNameExprArgument x) {
        return true;
    }

    @Override
    public boolean visit(SQLXmlPassingClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLXmlCastFunction x) {
        return true;
    }

    @Override
    public boolean visit(SQLXmlColAttValFunction x) {
        return true;
    }

    @Override
    public boolean visit(SQLXmlParseFunction x) {
        return true;
    }

    @Override
    public boolean visit(SQLXmlTableFunction x) {
        return true;
    }

    @Override
    public boolean visit(SQLXmlTableFunction.SQLXmlNamespacesClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLXmlTableFunction.SQLXmlTableOption x) {
        return true;
    }

    @Override
    public boolean visit(SQLXmlTableFunction.SQLXmlTableColumnByForOrdinality x) {
        return true;
    }

    @Override
    public boolean visit(SQLXmlTableFunction.SQLXmlTableColumnByDataType x) {
        return true;
    }

    @Override
    public boolean visit(SQLXmlElementFunction x) {
        return true;
    }

    @Override
    public boolean visit(SQLXmlElementFunction.SQLXmlAttributesClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLXmlExistsFunction x) {
        return true;
    }

    @Override
    public boolean visit(SQLXmlForestFunction x) {
        return true;
    }

    @Override
    public boolean visit(SQLXmlPiFunction x) {
        return true;
    }

    @Override
    public boolean visit(SQLXmlQueryFunction x) {
        return true;
    }

    @Override
    public boolean visit(SQLXmlRootFunction x) {
        return true;
    }

    @Override
    public boolean visit(SQLXmlRootFunction.SQLVersionArgument x) {
        return true;
    }

    @Override
    public boolean visit(SQLXmlSerializeFunction x) {
        return true;
    }

    @Override
    public boolean visit(SQLPositionFunction x) {
        return true;
    }

    @Override
    public boolean visit(SQLSubStrFromFunction x) {
        return true;
    }

    @Override
    public boolean visit(SQLSubStringFromFunction x) {
        return true;
    }

    @Override
    public boolean visit(SQLWeightStringFunction x) {
        return true;
    }

    @Override
    public boolean visit(SQLMethodInvocation x) {
        return true;
    }

    @Override
    public boolean visit(AbstractSQLFunction.SQLDefaultOnConversionError x) {
        return true;
    }

    @Override
    public boolean visit(SQLStaticMethodInvocation x) {
        return true;
    }

    // ------------------------- Functions Start ----------------------------------------


    // ------------------------- Commons Expr Start ----------------------------------------

    @Override
    public boolean visit(SQLFromClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLHierarchicalQueryConnectByStartWithClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLHierarchicalQueryStartWithConnectByClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLObjectNameTableReference x) {
        return true;
    }

    @Override
    public boolean visit(SQLPartitionClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLPartitionForClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLSubPartitionClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLSubPartitionForClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLJoinTableReference x) {
        return true;
    }

    @Override
    public boolean visit(SQLJoinTableReference.SQLJoinOnCondition x) {
        return true;
    }

    @Override
    public boolean visit(SQLJoinTableReference.SQLJoinUsingCondition x) {
        return true;
    }

    @Override
    public boolean visit(SQLSubQueryTableReference x) {
        return true;
    }

    @Override
    public boolean visit(SQLUnNestFunctionTableReference x) {
        return true;
    }

    @Override
    public boolean visit(SQLTableFunctionTableReference x) {
        return true;
    }


    @Override
    public boolean visit(SQLCompileClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLCubeClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLCurrentOfClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLDefaultClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLDefaultOnNullClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLDeterministicClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLErrorLoggingClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLExceptionClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLPartitionByClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLProcedureInvocation x) {
        return true;
    }

    @Override
    public boolean visit(SQLSampleClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLRollupClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLSelectQueryExpr x) {
        return true;
    }

    @Override
    public boolean visit(SQLValuesClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLValuesClause.SQLValuesItem x) {
        return true;
    }

    @Override
    public boolean visit(SQLWhereClause x) {
        return true;
    }


    @Override
    public boolean visit(SQLCharacterSetOptionExpr x) {
        return true;
    }

    @Override
    public boolean visit(SQLCollationExpr x) {
        return true;
    }

    @Override
    public boolean visit(SQLDefinerOptionExpr x) {
        return true;
    }

    @Override
    public boolean visit(SQLSetOptionExpr x) {
        return true;
    }

    @Override
    public boolean visit(SQLReservedIdentifier x) {
        return true;
    }


    @Override
    public boolean visit(SQLBody x) {
        return true;
    }

    @Override
    public boolean visit(SQLBody.SQLBodyItem x) {
        return true;
    }

    @Override
    public boolean visit(SQLLabel x) {
        return true;
    }

    @Override
    public boolean visit(SQLBoundsClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLBoundsByIndicesOfClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLBoundsByValuesOfClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLBroadcastExpr x) {
        return true;
    }

    // ------------------------- Commons Expr End ----------------------------------------


    // ------------------------- column constraint Start ----------------------------------------
    @Override
    public boolean visit(SQLAutoIncrementColumnConstraint x) {
        return true;
    }

    @Override
    public boolean visit(SQLCheckColumnConstraint x) {
        return true;
    }

    @Override
    public boolean visit(SQLNotNullColumnConstraint x) {
        return true;
    }

    @Override
    public boolean visit(SQLNullColumnConstraint x) {
        return true;
    }

    @Override
    public boolean visit(SQLPrimaryKeyColumnConstraint x) {
        return true;
    }

    @Override
    public boolean visit(SQLReferencesColumnConstraint x) {
        return true;
    }

    @Override
    public boolean visit(SQLReferencesColumnConstraint.SQLOnUpdateAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLReferencesColumnConstraint.SQLOnDeleteAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLUniqueColumnConstraint x) {
        return true;
    }

    @Override
    public boolean visit(SQLScopeIsColumnConstraint x) {
        return true;
    }

    @Override
    public boolean visit(SQLWithRowIdColumnConstraint x) {
        return true;
    }

    @Override
    public boolean visit(SQLFormatColumnConstraint x) {
        return true;
    }

    @Override
    public boolean visit(SQLStorageColumnConstraint x) {
        return true;
    }

    // ------------------------- column constraint End ----------------------------------------


    // ------------------------- table constraint Start ----------------------------------------

    @Override
    public boolean visit(SQLCheckTableConstraint x) {
        return true;
    }

    @Override
    public boolean visit(SQLForeignKeyTableConstraint x) {
        return true;
    }

    @Override
    public boolean visit(SQLPrimaryKeyTableConstraint x) {
        return true;
    }

    @Override
    public boolean visit(SQLUniqueTableConstraint x) {
        return true;
    }

    @Override
    public boolean visit(SQLIndexTableConstraint x) {
        return true;
    }

    @Override
    public boolean visit(SQLKeyTableConstraint x) {
        return true;
    }

    @Override
    public boolean visit(SQLFullTextTableConstraint x) {
        return true;
    }

    @Override
    public boolean visit(SQLSpatialTableConstraint x) {
        return true;
    }

    @Override
    public boolean visit(SQLScopeForTableConstraint x) {
        return true;
    }

    @Override
    public boolean visit(SQLRefWithRowIdTableConstraint x) {
        return true;
    }

    @Override
    public boolean visit(SQLConstraint.SQLColumn x) {
        return true;
    }

    // ------------------------- table constraint End ----------------------------------------

    // ------------------------- constraint option Start ----------------------------------------

    @Override
    public boolean visit(SQExceptionsClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLDeferrableConstraintState x) {
        return true;
    }

    @Override
    public boolean visit(SQLDisableConstraintState x) {
        return true;
    }

    @Override
    public boolean visit(SQLEnableConstraintState x) {
        return true;
    }

    @Override
    public boolean visit(SQLInitiallyDeferredConstraintState x) {
        return true;
    }

    @Override
    public boolean visit(SQLInitiallyImmediateConstraintState x) {
        return true;
    }

    @Override
    public boolean visit(SQLNoRelyConstraintState x) {
        return true;
    }

    @Override
    public boolean visit(SQLNotDeferrableConstraintState x) {
        return true;
    }

    @Override
    public boolean visit(SQLRelyConstraintState x) {
        return true;
    }

    @Override
    public boolean visit(SQNoValidateConstraintState x) {
        return true;
    }

    @Override
    public boolean visit(SQValidateConstraintState x) {
        return true;
    }


    // ------------------------- constraint option  End ----------------------------------------


    // ------------------ details -----------------------------------------

    // ------------------ analytic Details Start ----------------------

    @Override
    public boolean visit(SQLAlterAnalyticRenameToAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterAnalyticCompileAction x) {
        return true;
    }

    // ------------------ analytic Details Start ----------------------


    // ------------------ Index Details Start ----------------------

    @Override
    public boolean visit(SQLIndexColumn x) {
        return true;
    }

    @Override
    public boolean visit(SQLLocalPartitionIndex x) {
        return true;
    }

    @Override
    public boolean visit(SQLGlobalPartitionByHash x) {
        return true;
    }

    @Override
    public boolean visit(SQLGlobalPartitionByRange x) {
        return true;
    }

    @Override
    public boolean visit(SQLIndexTypeIsIndexTypeClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLPartialIndexByFullClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLPartialIndexByPartialClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLIndexAttributeComputeStatistics x) {
        return true;
    }

    @Override
    public boolean visit(SQLIndexAttributeInvisible x) {
        return true;
    }

    @Override
    public boolean visit(SQLIndexAttributeNoSort x) {
        return true;
    }

    @Override
    public boolean visit(SQLIndexAttributeOnline x) {
        return true;
    }

    @Override
    public boolean visit(SQLIndexAttributeReverse x) {
        return true;
    }

    @Override
    public boolean visit(SQLIndexAttributeSort x) {
        return true;
    }

    @Override
    public boolean visit(SQLIndexAttributeVisible x) {
        return true;
    }


    @Override
    public boolean visit(SQLShrinkClause x) {
        return true;
    }


    @Override
    public boolean visit(SQLAlterIndexCoalesceAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterIndexCompileAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterIndexDisableAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterIndexEnableAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterIndexInvisibleAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterIndexMonitoringUsageAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterIndexNoMonitoringUsageAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterIndexRebuildAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterIndexRenameAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterIndexUnusableAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterIndexUpdateBlockReferencesAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterIndexVisibleAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterIndexModifyDefaultAttributesAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterIndexAddPartitionAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterIndexModifyPartitionAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterIndexModifyPartitionAction.SQLCoalesceOption x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterIndexModifyPartitionAction.SQLUpdateBlockReferencesOption x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterIndexModifyPartitionAction.SQLUnusableOption x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterIndexRenamePartitionAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterIndexSplitPartitionAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterIndexRenameSubPartitionAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterIndexDropPartitionAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterIndexCoalescePartitionAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterIndexModifySubPartitionAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterIndexModifySubPartitionAction.SQLUnusableOption x) {
        return true;
    }
    // ------------------ Index Details End ----------------------


    // ------------------ Materialized View Details Start ----------------------

    @Override
    public boolean visit(SQLMaterializedViewColumn x) {
        return true;
    }

    @Override
    public boolean visit(SQLOnPrebuiltTableProperty x) {
        return true;
    }

    @Override
    public boolean visit(SQLMaterializedViewPropertyCacheClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLMaterializedViewPropertyNoCacheClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLUsingIndexClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLUsingIndexClause.SQLCreateIndexStatementItem x) {
        return true;
    }

    @Override
    public boolean visit(SQLUsingNoIndexClause x) {
        return true;
    }


    @Override
    public boolean visit(SQLCreateMVNeverRefresh x) {
        return true;
    }

    @Override
    public boolean visit(SQLCreateMVRefresh x) {
        return true;
    }

    @Override
    public boolean visit(SQLCreateMVRefresh.SQLCreateMVRefreshFastItem x) {
        return true;
    }

    @Override
    public boolean visit(SQLCreateMVRefresh.SQLCreateMVRefreshCompleteItem x) {
        return true;
    }

    @Override
    public boolean visit(SQLCreateMVRefresh.SQLCreateMVRefreshForceItem x) {
        return true;
    }

    @Override
    public boolean visit(SQLCreateMVRefresh.SQLCreateMVRefreshOnDemandItem x) {
        return true;
    }

    @Override
    public boolean visit(SQLCreateMVRefresh.SQLCreateMVRefreshOnCommitItem x) {
        return true;
    }

    @Override
    public boolean visit(SQLCreateMVRefresh.SQLCreateMVRefreshOnStatementItem x) {
        return true;
    }

    @Override
    public boolean visit(SQLCreateMVRefresh.SQLCreateMVRefreshStartWithItem x) {
        return true;
    }

    @Override
    public boolean visit(SQLCreateMVRefresh.SQLCreateMVRefreshNextItem x) {
        return true;
    }

    @Override
    public boolean visit(SQLCreateMVRefresh.SQLCreateMVRefreshWithPrimaryKeyItem x) {
        return true;
    }

    @Override
    public boolean visit(SQLCreateMVRefresh.SQLCreateMVRefreshWithRowidItem x) {
        return true;
    }

    @Override
    public boolean visit(SQLCreateMVRefresh.SQLCreateMVRefreshUsingRollbackSegmentItem x) {
        return true;
    }

    @Override
    public boolean visit(SQLCreateMVRefresh.SQLUsingRollbackSegmentByDefaultItem x) {
        return true;
    }

    @Override
    public boolean visit(SQLCreateMVRefresh.SQLUsingRollbackSegmentByNoDefaultItem x) {
        return true;
    }

    @Override
    public boolean visit(SQLCreateMVRefresh.SQLCreateMVRefreshUsingEnforcedConstraintsItem x) {
        return true;
    }

    @Override
    public boolean visit(SQLCreateMVRefresh.SQLCreateMVRefreshUsingTrustedConstraintsItem x) {
        return true;
    }

    @Override
    public boolean visit(SQLOnQueryComputationClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLQueryRewriteClause x) {
        return true;
    }
    // ------------------ Materialized View Details End ----------------------


    // ------------------ Select Details Start ----------------------

    @Override
    public boolean visit(SQLGroupByClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLGroupByClause.SQLGroupByItem x) {
        return true;
    }

    @Override
    public boolean visit(SQLGroupingSetsClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLHavingClause x) {
        return true;
    }


    @Override
    public boolean visit(SQLLimitOffsetClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLOffsetFetchClause x) {
        return true;
    }


    @Override
    public boolean visit(SQLOrderByClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLOrderByItem x) {
        return true;
    }


    @Override
    public boolean visit(SQLForUpdateClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLForUpdateClause.SQLForSkipLockedOption x) {
        return true;
    }

    @Override
    public boolean visit(SQLForUpdateClause.SQLForNoWaitOption x) {
        return true;
    }

    @Override
    public boolean visit(SQLForUpdateClause.SQLForWaitOption x) {
        return true;
    }

    @Override
    public boolean visit(SQLLockInShareModeClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLParenSelectQuery x) {
        return true;
    }

    @Override
    public boolean visit(SQLSelectQuery x) {
        return true;
    }


    @Override
    public boolean visit(SQLSelectItem x) {
        return true;
    }

    @Override
    public boolean visit(SQLSelectTargetItem x) {
        return true;
    }

    @Override
    public boolean visit(SQLSelectUnionQuery x) {
        return true;
    }

    @Override
    public boolean visit(SQLWithClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLWithClause.SQLSubQueryFactoringClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLWithClause.SQLSearchClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLWithClause.SQLCycleClause x) {
        return true;
    }
    // ------------------ Select Details End ----------------------


    // ------------------ Sequence Details Start ----------------------
    @Override
    public boolean visit(SQLAsDataTypeOption x) {
        return true;
    }

    @Override
    public boolean visit(SQLSequenceCacheOption x) {
        return true;
    }

    @Override
    public boolean visit(SQLSequenceCycleOption x) {
        return true;
    }

    @Override
    public boolean visit(SQLSequenceGlobalOption x) {
        return true;
    }

    @Override
    public boolean visit(SQLSequenceIncrementByOption x) {
        return true;
    }

    @Override
    public boolean visit(SQLSequenceKeepOption x) {
        return true;
    }

    @Override
    public boolean visit(SQLSequenceMaxValueOption x) {
        return true;
    }

    @Override
    public boolean visit(SQLSequenceMinValueOption x) {
        return true;
    }

    @Override
    public boolean visit(SQLSequenceNoCacheOption x) {
        return true;
    }

    @Override
    public boolean visit(SQLSequenceNoCycleOption x) {
        return true;
    }

    @Override
    public boolean visit(SQLSequenceNoKeepOption x) {
        return true;
    }

    @Override
    public boolean visit(SQLSequenceNoMaxValueOption x) {
        return true;
    }

    @Override
    public boolean visit(SQLSequenceNoMinValueOption x) {
        return true;
    }

    @Override
    public boolean visit(SQLNoneOption x) {
        return true;
    }

    @Override
    public boolean visit(SQLSequenceNoOrderOption x) {
        return true;
    }

    @Override
    public boolean visit(SQLSequenceOrderOption x) {
        return true;
    }

    @Override
    public boolean visit(SQLOwnedByOption x) {
        return true;
    }

    @Override
    public boolean visit(SQLOwnedToOption x) {
        return true;
    }

    @Override
    public boolean visit(SQLRenameToClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLReStartWithOption x) {
        return true;
    }

    @Override
    public boolean visit(SQLNoScaleOption x) {
        return true;
    }

    @Override
    public boolean visit(SQLScaleOption x) {
        return true;
    }

    @Override
    public boolean visit(SQLSequenceSessionOption x) {
        return true;
    }

    @Override
    public boolean visit(SQLSetSchemaOption x) {
        return true;
    }

    @Override
    public boolean visit(SQLSequenceStartWithOption x) {
        return true;
    }

    // ------------------ Sequence Details End ----------------------


    // ------------------ Table Details Start ----------------------

    @Override
    public boolean visit(SQLColumnDefinition x) {
        return true;
    }

    @Override
    public boolean visit(SQLVirtualColumnDefinition x) {
        return true;
    }

    @Override
    public boolean visit(SQLLikeClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLPartitionByConsistentHash x) {
        return true;
    }

    @Override
    public boolean visit(SQLPartitionByHash x) {
        return true;
    }

    @Override
    public boolean visit(SQLPartitionByKey x) {
        return true;
    }

    @Override
    public boolean visit(SQLPartitionByList x) {
        return true;
    }

    @Override
    public boolean visit(SQLPartitionByListColumns x) {
        return true;
    }

    @Override
    public boolean visit(SQLPartitionByRange x) {
        return true;
    }

    @Override
    public boolean visit(SQLPartitionByRangeColumns x) {
        return true;
    }

    @Override
    public boolean visit(SQLPartitionByReference x) {
        return true;
    }

    @Override
    public boolean visit(SQLPartitionBySystem x) {
        return true;
    }

    @Override
    public boolean visit(SQLPartitionDefinition x) {
        return true;
    }

    @Override
    public boolean visit(SQLPartitionsetByList x) {
        return true;
    }

    @Override
    public boolean visit(SQLPartitionsetByRange x) {
        return true;
    }

    @Override
    public boolean visit(SQLPartitionsetDefinition x) {
        return true;
    }

    @Override
    public boolean visit(SQLSubPartitionByHash x) {
        return true;
    }

    @Override
    public boolean visit(SQLSubPartitionByKey x) {
        return true;
    }

    @Override
    public boolean visit(SQLSubPartitionByList x) {
        return true;
    }

    @Override
    public boolean visit(SQLSubPartitionByRange x) {
        return true;
    }

    @Override
    public boolean visit(SQLSubpartitionTemplate x) {
        return true;
    }

    @Override
    public boolean visit(SQLSubPartitionDefinition x) {
        return true;
    }

    @Override
    public boolean visit(SQLPartitionValuesLessThan x) {
        return true;
    }

    @Override
    public boolean visit(SQLPartitionValuesLessThanMaxValue x) {
        return true;
    }

    @Override
    public boolean visit(SQLPartitionValuesIn x) {
        return true;
    }

    @Override
    public boolean visit(SQLPartitionValues x) {
        return true;
    }


    @Override
    public boolean visit(SQLIdentityClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLIdentityStartWithOption x) {
        return true;
    }

    @Override
    public boolean visit(SQLIdentityIncrementByOption x) {
        return true;
    }

    @Override
    public boolean visit(SQLIdentityMaxValueOption x) {
        return true;
    }

    @Override
    public boolean visit(SQLIdentityNoMaxValueOption x) {
        return true;
    }

    @Override
    public boolean visit(SQLIdentityMinValueOption x) {
        return true;
    }

    @Override
    public boolean visit(SQLIdentityNoMinValueOption x) {
        return true;
    }

    @Override
    public boolean visit(SQLIdentityCycleOption x) {
        return true;
    }

    @Override
    public boolean visit(SQLIdentityNoCycleOption x) {
        return true;
    }

    @Override
    public boolean visit(SQLIdentityCacheOption x) {
        return true;
    }

    @Override
    public boolean visit(SQLIdentityNoCacheOption x) {
        return true;
    }

    @Override
    public boolean visit(SQLIdentityOrderOption x) {
        return true;
    }

    @Override
    public boolean visit(SQLIdentityNoOrderOption x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableRenameTableAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableAddColumnAction x) {
        return true;
    }

    @Override
    public boolean visit(ISQLAlterTableColumnAction.SQLFirstPropertyExpr x) {
        return true;
    }

    @Override
    public boolean visit(ISQLAlterTableColumnAction.SQLAfterPropertyExpr x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableAlterColumnAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableAlterColumnAction.SQLSetColumnDefaultClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableAlterColumnAction.SQLDropColumnDefaultClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableAlterColumnAction.SQLAddColumnScopeClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableAlterColumnAction.SQLDropColumnScopeClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableRenameColumnAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableSetUnusedColumnAction x) {
        return true;
    }


    @Override
    public boolean visit(SQLAlterTableChangeColumnAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableDropColumnAction x) {
        return true;
    }


    @Override
    public boolean visit(SQLAlterTableDropColumnsContinueAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableDropUnusedColumnsAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableModifyCollectionRetrievalAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableModifyColumnsAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableModifyColumnAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableModifyLobStorageAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableOrderByColumnAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableAlterVarrayColPropertyAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableAddTableConstraintAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableAlterIndexConstraintAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableConstraintAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableRenameTableConstraintAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableDropIndexConstraintAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableDropKeyConstraintAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableDropPrimaryKeyConstraintAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableDropTableConstraintAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableDropUniqueConstraintAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableModifyPrimaryKeyConstraintAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableModifyTableConstraintAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableModifyUniqueConstraintAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableRenameIndexConstraintAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableRenameKeyConstraintAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableValidateTableConstraintAction x) {
        return true;
    }


    @Override
    public boolean visit(ISQLAlterTableIotAction.SQLAlterTableCoalesceIotAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableAddOverflowIotAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableAlterOverflowIotAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableMappingTableIotAction x) {
        return true;
    }

    @Override
    public boolean visit(ISQLAlterTablePartitionAction.SQLForItem x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableAddPartitionAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableCoalescePartitionAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLCoalesceSubPartitionAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableDropPartitionAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableDropSubPartitionAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableExchangePartitionAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableExchangePartitionForAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableExchangeSubPartitionAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableExchangeSubPartitionForAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableMergePartitionsAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableMergePartitionsToAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableMergeSubPartitionsAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableMergeSubPartitionsToAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableModifyPartitionAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableModifyPartitionForAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableModifySubPartitionAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableModifySubPartitionForAction x) {
        return true;
    }

    @Override
    public boolean visit(AbstractSQLAlterTableModifyPartitionAction.SQLModifyPartitionAddValuesAction x) {
        return true;
    }

    @Override
    public boolean visit(AbstractSQLAlterTableModifyPartitionAction.SQLModifyPartitionDropValuesAction x) {
        return true;
    }

    @Override
    public boolean visit(AbstractSQLAlterTableModifyPartitionAction.SQLModifyPartitionUnusableLocalIndexesAction x) {
        return true;
    }

    @Override
    public boolean visit(AbstractSQLAlterTableModifyPartitionAction.SQLModifyPartitionAddSubPartitionAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableRenamePartitionAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableRenamePartitionForAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableRenameSubPartitionAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableRenameSubPartitionForAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableSetIntervalAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableSetPartitioningAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableSetStoreInAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableSetSubPartitionTemplateAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableSplitPartitionAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableSplitPartitionForAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableSplitSubPartitionAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableSplitSubPartitionForAction x) {
        return true;
    }

    @Override
    public boolean visit(AbstractSQLAlterTableSplitPartitionAction.SQLAt x) {
        return true;
    }

    @Override
    public boolean visit(AbstractSQLAlterTableSplitPartitionAction.SQLValues x) {
        return true;
    }

    @Override
    public boolean visit(AbstractSQLAlterTableSplitPartitionAction.SQLInto x) {
        return true;
    }

    @Override
    public boolean visit(AbstractSQLAlterTableSplitPartitionAction.SQLSplitNestedTablePart x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableTruncatePartitionAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableTruncateSubPartitionAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAnalyzePartitionDefinition x) {
        return true;
    }

    @Override
    public boolean visit(SQLCheckPartitionDefinition x) {
        return true;
    }

    @Override
    public boolean visit(SQLCoalescePartitionDefinition x) {
        return true;
    }

    @Override
    public boolean visit(SQLDiscardPartitionDefinition x) {
        return true;
    }

    @Override
    public boolean visit(SQLExchangePartitionDefinition x) {
        return true;
    }

    @Override
    public boolean visit(SQLImportPartitionDefinition x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableMovePartitionAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableMovePartitionForAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableMoveSubPartitionAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableMoveSubPartitionForAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableOptimizePartitionAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableRebuildPartitionAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableRemovePartitioningAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableReorganizePartitionAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableRepairPartitionAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableUpgradePartitioningAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableDisableTriggerAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableEnableTriggerAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableCacheAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableDisableAllTriggersAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableDisableContainerMapAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableDisableContainersDefaultAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableDisableTableLockAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableEnableAllTriggersAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableEnableContainerMapAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableEnableContainersDefaultAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableEnableTableLockAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableForceAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableModifyOpaqueTypeAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableMoveTableAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableNoCacheAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableReadOnlyAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableReadWriteAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableRowArchivalAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableUpgradeTableAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableWithoutValidationAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTableWithValidationAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterXmlSchemaClause.SQLAlterXmlSchemaAllowAnySchemaClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterXmlSchemaClause.SQLAlterXmlSchemaAllowNonSchemaClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterXmlSchemaClause.SQLAlterXmlSchemaDisallowNonSchemaClause x) {
        return true;
    }

    @Override
    public boolean visit(ISQLEnableDisableClause.SQLEnableUniqueClause x) {
        return true;
    }

    @Override
    public boolean visit(ISQLEnableDisableClause.SQLEnablePrimaryKeyClause x) {
        return true;
    }

    @Override
    public boolean visit(ISQLEnableDisableClause.SQLEnableConstraintClause x) {
        return true;
    }

    @Override
    public boolean visit(ISQLEnableDisableClause.SQLDisableUniqueClause x) {
        return true;
    }

    @Override
    public boolean visit(ISQLEnableDisableClause.SQLDisablePrimaryKeyClause x) {
        return true;
    }

    @Override
    public boolean visit(ISQLEnableDisableClause.SQLDisableConstraintClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLAttributeClusteringClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLAttributeClusteringClause.SQLClusteringJoin x) {
        return true;
    }

    @Override
    public boolean visit(SQLAttributeClusteringClause.SQLClusteringJoinItem x) {
        return true;
    }

    @Override
    public boolean visit(SQLAttributeClusteringClause.SQLClusterClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLAttributeClusteringClause.SQLClusteringWhen x) {
        return true;
    }

    @Override
    public boolean visit(SQLAttributeClusteringClause.SQLWithMaterializedZoneMapClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLAttributeClusteringClause.SQLWithoutMaterializedZoneMapClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLDependentTablesClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLDependentTablesClause.Item x) {
        return true;
    }

    @Override
    public boolean visit(SQLFlashbackArchiveClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLForExchangeWithTableClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLInvalidateGlobalIndexClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLNoFlashbackArchiveClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLObjectTableSubstitution x) {
        return true;
    }

    @Override
    public boolean visit(SQLOidClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLOidIndexClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLPartitionAttribute.SQLLobClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLPartitionAttribute.SQLVarrayClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLRowMovementClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLTablePropertyResultCache x) {
        return true;
    }

    @Override
    public boolean visit(SQLUpdateGlobalIndexClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLUpdateIndexesClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLUpdateIndexesClause.Item x) {
        return true;
    }

    // ------------------ Table Details End ----------------------

    // ------------------ Trigger Details Start ----------------------

    @Override
    public boolean visit(SQLTriggerDMLEvent x) {
        return true;
    }

    @Override
    public boolean visit(SQLTriggerDDLEvent x) {
        return true;
    }

    @Override
    public boolean visit(SQLTriggerDatabaseEvent x) {
        return true;
    }

    @Override
    public boolean visit(SQLCreateTriggerStatement.SQLOnSchemaExpr x) {
        return true;
    }

    @Override
    public boolean visit(SQLCreateTriggerStatement.SQLOnDatabaseExpr x) {
        return true;
    }

    @Override
    public boolean visit(SQLTriggerReferencingNewOption x) {
        return true;
    }

    @Override
    public boolean visit(SQLTriggerReferencingOldOption x) {
        return true;
    }

    @Override
    public boolean visit(SQLTriggerReferencingParentOption x) {
        return true;
    }

    @Override
    public boolean visit(SQLTriggerOrderingClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLTriggerCompoundTriggerBlock x) {
        return true;
    }

    @Override
    public boolean visit(SQLTriggerCompoundTriggerBlock.SQLTimingPointSection x) {
        return true;
    }

    // ------------------ Trigger Details End ----------------------



    // ------------------ Type Details Start ----------------------

    @Override
    public boolean visit(SQLAlterTypeAddMethodsAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTypeAddMethodsAction.SQLItem x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTypeDropMethodsAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTypeDropMethodsAction.SQLItem x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTypeAddAttributeAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTypeModifyAttributeAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTypeAlterAttributeAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTypeDropAttributeAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTypeModifyLimitAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterTypeModifyElementTypeAction x) {
        return true;
    }
    // ------------------ Type Details End ----------------------



    // ------------------ Merge Details Start ----------------------
    @Override
    public boolean visit(SQLMergeStatement.SQLMergeWhenMatchClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLMergeStatement.SQLMergeWhenNotMatchClause x) {
        return true;
    }
    // ------------------ Merge Details End ----------------------


    // ------------------ Update Details Start ----------------------

    @Override
    public boolean visit(SQLUpdateSetClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLUpdateSetByValueClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLUpdateSetClause.SQLUpdateSetItemClause x) {
        return true;
    }

    // ------------------ Update Details End ----------------------


    // ------------------ User/Role Details End ----------------------

    @Override
    public boolean visit(SQLIdentifiedByClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLIdentifiedByPasswordClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLIdentifiedExternallyClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLIdentifiedGloballyClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLIdentifiedUsingClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLIdentifiedWithAsClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLIdentifiedWithByClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLIdentifiedWithClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLNoAuthenticationClause x) {
        return true;
    }

    @Override
    public boolean visit(SQLNoIdentifiedClause x) {
        return true;
    }

    // ------------------ User/Role Details End ----------------------


    // ------------------ Commit Details End ----------------------

    @Override
    public boolean visit(SQLCommitCommentOption x) {
        return true;
    }

    @Override
    public boolean visit(SQLCommitWriteOption x) {
        return true;
    }

    @Override
    public boolean visit(SQLCommitForceOption x) {
        return true;
    }

    @Override
    public boolean visit(SQLCommitChainOption x) {
        return true;
    }

    @Override
    public boolean visit(SQLCommitReleaseOption x) {
        return true;
    }

    // ------------------ Commit Details End ----------------------

    // ------------------ Rollback Details End ----------------------

    @Override
    public boolean visit(SQLRollbackToSavepointOption x) {
        return true;
    }

    @Override
    public boolean visit(SQLRollbackForceOption x) {
        return true;
    }

    @Override
    public boolean visit(SQLRollbackChainOption x) {
        return true;
    }

    @Override
    public boolean visit(SQLRollbackReleaseOption x) {
        return true;
    }

    // ------------------ Rollback Details End ----------------------


    // ------------------ SET TRANSACTION Details Start ----------------------

    @Override
    public boolean visit(SQLSetTransactionReadOnlyOption x) {
        return true;
    }

    @Override
    public boolean visit(SQLSetTransactionReadWriteOption x) {
        return true;
    }

    @Override
    public boolean visit(SQLSetTransactionIsolationLevelOption x) {
        return true;
    }

    @Override
    public boolean visit(SQLSetTransactionUseRollbackSegmentOption x) {
        return true;
    }

    @Override
    public boolean visit(SQLSetTransactionSnapshotOption x) {
        return true;
    }

    @Override
    public boolean visit(SQLSetTransactionDeferrableOption x) {
        return true;
    }

    @Override
    public boolean visit(SQLSetTransactionNameOption x) {
        return true;
    }

    // ------------------ SET TRANSACTION Details End ----------------------


    // ------------------ View Details Start ----------------------

    @Override
    public boolean visit(SQLAlterViewAddTableConstraintAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterViewCompileAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterViewDropConstraintAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterViewDropPrimaryKeyConstraintAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterViewDropUniqueConstraintAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterViewEditionableAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterViewModifyConstraintAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterViewNonEditionableAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterViewReadOnlyAction x) {
        return true;
    }

    @Override
    public boolean visit(SQLAlterViewReadWriteAction x) {
        return true;
    }


    // ------------------ View Details Start ----------------------

    @Override
    public void postVisit(SQLObject x) {

    }
}
