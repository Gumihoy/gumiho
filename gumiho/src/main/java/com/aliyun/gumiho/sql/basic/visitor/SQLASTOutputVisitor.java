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
package com.aliyun.gumiho.sql.basic.visitor;


import static com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved.AS;

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
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.limit.ISQLLimitClause;
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
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.SQLTableElement;
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
import com.aliyun.gumiho.sql.basic.ast.enums.*;
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
import com.aliyun.gumiho.sql.config.SQLOutputConfig;
import com.aliyun.gumiho.sql.print.SQLPrintable;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SQLASTOutputVisitor extends SQLASTVisitorAdapter implements SQLPrintable {

    private final StringBuilder appender;
    protected SQLOutputConfig config;


    public SQLASTOutputVisitor(StringBuilder appender) {
        this.appender = appender;
        this.config = new SQLOutputConfig();
    }

    public SQLASTOutputVisitor(StringBuilder appender, SQLOutputConfig config) {
        this.appender = appender;
        this.config = config;
    }

    public StringBuilder getAppender() {
        return appender;
    }

    public int getIndentCount() {
        return config.indentCount;
    }

    public void setIndentCount(int indentCount) {
        config.indentCount = indentCount;
    }

    public int getLines() {
        return config.lines;
    }

    public void setLines(int lines) {
        config.lines = lines;
    }

    @Override
    public boolean isLowerCase() {
        return config.lowerCase;
    }

    public void setLowerCase(boolean lowerCase) {
        config.lowerCase = lowerCase;
    }

    public Boolean isPrintAfterSemi() {
        return config.printAfterSemi;
    }

    public void setPrintAfterSemi(Boolean printAfterSemi) {
        config.printAfterSemi = printAfterSemi;
    }

    public int getLineMaxLength() {
        return config.lineMaxLength;
    }

    public void setLineMaxLength(int lineMaxLength) {
        config.lineMaxLength = lineMaxLength;
    }

    public void incrementLines() {
        config.lines++;
    }

    public void decrementIndent() {
        config.indentCount--;
    }

    public void incrementIndent() {
        config.indentCount++;
    }


    @Override
    public void print(char value) {
        getAppender().append(value);
    }

    @Override
    public void print(int value) {
        getAppender().append(value);
    }

    @Override
    public void print(long value) {
        getAppender().append(value);
    }

    @Override
    public void print(float value) {
        getAppender().append(value);
    }

    @Override
    public void print(double value) {
        getAppender().append(value);
    }

    @Override
    public void print(Date value) {
        getAppender().append(value);
    }

    @Override
    public void print(CharSequence text) {
        getAppender().append(text);
    }

    @Override
    public void print(SQLReserved value) {
        if (value == null) {
            return;
        }
        print(isLowerCase() ? value.lower : value.upper);
    }

    @Override
    public void print(ISQLEnum value) {
        if (value == null) {
            return;
        }
        print(value.getName());
    }

    @Override
    public void print(List<? extends ISQLEnum> values, String separator) {
        if (values == null
                || values.size() == 0) {
            return;
        }

        for (int i = 0, size = values.size(); i < size; ++i) {
            if (i != 0) {
                print(separator);
            }
            print(values.get(i));
        }
    }

    @Override
    public void print(SQLObject node) {
        if (node == null) {
            return;
        }
        node.accept(this);
    }


    public void printParen(SQLObject node) {
        if (node == null) {
            return;
        }
        print(SQLReserved.LEFT_PAREN);
        node.accept(this);
        print(SQLReserved.RIGHT_PAREN);
    }

    @Override
    public void printAccept(List<? extends SQLObject> values, String separator) {
        printAccept(values, separator, false);
    }

    @Override
    public void printAccept(List<? extends SQLObject> nodes, String separator, boolean paren) {
        if (nodes == null
                || nodes.size() == 0) {
            return;
        }

        if (paren) {
            print("(");
        }

        for (int i = 0, size = nodes.size(); i < size; ++i) {
            if (i != 0) {
                print(separator);
            }
            nodes.get(i).accept(this);
        }

        if (paren) {
            print(")");
        }
    }


    @Override
    public void printSpace() {
        getAppender().append(' ');
    }

    @Override
    public void printSpaceAfterValue(CharSequence text) {
        if (text == null) {
            return;
        }
        printSpace();
        print(text);
    }

    @Override
    public void printSpaceAfterValue(SQLReserved text) {
        if (text == null) {
            return;
        }
        printSpace();
        print(text);
    }

    @Override
    public void printSpaceAfterValue(ISQLEnum text) {
        if (text == null) {
            return;
        }
        printSpace();
        print(text);
    }

    @Override
    public void printSpaceAfterValue(List<? extends ISQLEnum> values, String separator) {
        if (values == null
                || values.size() == 0) {
            return;
        }
        printSpace();
        print(values, separator);
    }

    @Override
    public void printSpaceAfterAccept(SQLObject node) {
        if (node == null) {
            return;
        }
        printSpace();
        node.accept(this);
    }

    @Override
    public void printSpaceAfterAccept(List<? extends SQLObject> nodes, String separator) {
        printSpaceAfterAccept(nodes, separator, false);
    }

    public void printSpaceAfterAccept(List<? extends SQLObject> nodes, String separator, boolean paren) {
        if (nodes == null
                || nodes.size() == 0) {
            return;
        }
        printSpace();
        printAccept(nodes, separator, paren);
    }


    @Override
    public void println() {
        this.getAppender().append("\n");
        this.incrementLines();
        printIndent();
    }

    @Override
    public void printlnAfterValue(CharSequence text) {
        println();
        print(text);
    }

    @Override
    public void printlnAfterValue(SQLReserved value) {
        if (value == null) {
            return;
        }
        println();
        print(value);
    }


    @Override
    public void printlnAfterValue(ISQLEnum value) {
        if (value == null) {
            return;
        }
        printlnAfterValue(value.getName());
    }

    @Override
    public void printlnAfterValue(List<? extends ISQLEnum> values) {
        if (values == null
                || values.size() == 0) {
            return;
        }
        for (int i = 0, size = values.size(); i < size; ++i) {
            if (i != 0) {
                println();
            }
            print(values.get(i).getName());
        }
    }

    @Override
    public void printlnAfterValue(List<? extends ISQLEnum> values, String separator, boolean paren) {
        if (values == null
                || values.size() == 0) {
            return;
        }

        if (paren) {
            print(SQLReserved.LEFT_PAREN);
            this.incrementIndent();
            println();
        }

        for (int i = 0, size = values.size(); i < size; ++i) {
            if (i != 0) {
                print(separator);
                println();
            }
            print(values.get(i).getName());
        }

        if (paren) {
            this.decrementIndent();
            println();
            print(SQLReserved.RIGHT_PAREN);
        }
    }

    @Override
    public void printlnAndAccept(SQLObject node) {
        if (node == null) {
            return;
        }
        println();
        node.accept(this);
    }

    @Override
    public void printlnAndAccept(List<? extends SQLObject> nodes) {
        if (nodes == null
                || nodes.size() == 0) {
            return;
        }

        for (int i = 0, size = nodes.size(); i < size; ++i) {
            if (i != 0) {
                println();
            }
            nodes.get(i).accept(this);
        }
    }

    @Override
    public void printlnAndAccept(List<? extends SQLObject> nodes, String separator) {
        if (nodes == null
                || nodes.size() == 0) {
            return;
        }
        printlnAndAccept(nodes, separator, false);
    }

    @Override
    public void printlnAndAccept(List<? extends SQLObject> nodes, String separator, boolean paren) {
        if (nodes == null
                || nodes.size() == 0) {
            return;
        }

        if (paren) {
            print(SQLReserved.LEFT_PAREN);
            this.incrementIndent();
            println();
        }

        for (int i = 0, size = nodes.size(); i < size; ++i) {
            if (i != 0) {
                print(separator);
                println();
            }
            nodes.get(i).accept(this);
        }

        if (paren) {
            this.decrementIndent();
            println();
            print(SQLReserved.RIGHT_PAREN);
        }
    }


    @Override
    public void printSpaceAndLnAfterValue(List<? extends ISQLEnum> values, String separator, boolean paren) {
        if (values == null
                || values.size() == 0) {
            return;
        }
        printSpace();
        printlnAfterValue(values, separator, paren);
    }

    public void printSpaceAndLnAndAccept(List<? extends SQLObject> nodes, String separator, boolean paren) {
        if (nodes == null
                || nodes.size() == 0) {
            return;
        }
        printSpace();
        printlnAndAccept(nodes, separator, paren);
    }


    public void printIndentLnAndAccept(SQLObject node) {
        if (node == null) {
            return;
        }
        this.incrementIndent();
        println();
        node.accept(this);
        this.decrementIndent();
    }

    public void printIndentAndLnAndAccept(List<? extends SQLObject> nodes) {
        if (nodes == null
                || nodes.size() == 0) {
            return;
        }
        this.incrementIndent();
        println();
        printlnAndAccept(nodes);
        this.decrementIndent();
    }

    public void printIndentAndLnAndAccept(List<? extends SQLObject> nodes, String separator) {
        if (nodes == null
                || nodes.size() == 0) {
            return;
        }
        this.incrementIndent();
        println();
        printlnAndAccept(nodes, separator);
        this.decrementIndent();
    }

    public void printlnAndPrintReserved(List<? extends SQLReserved> expConstants) {
        if (expConstants == null
                || expConstants.size() == 0) {
            return;
        }

        for (int i = 0, size = expConstants.size(); i < size; ++i) {
            if (i != 0) {
                println();
            }
            print(expConstants.get(i));
        }
    }

    public void printlnAndPrintEnum(List<? extends Enum> enums) {
        if (enums == null
                || enums.size() == 0) {
            return;
        }

        for (int i = 0, size = enums.size(); i < size; ++i) {
            if (i != 0) {
                println();
            }
            print(enums.get(i).name());
        }
    }

    public void printlnAndPrintEnum(List<? extends Enum> enums, String separator) {
        if (enums == null
                || enums.size() == 0) {
            return;
        }

        for (int i = 0, size = enums.size(); i < size; ++i) {
            if (i != 0) {
                print(separator);
                println();
            }
            print(enums.get(i).name());
        }
    }

    @Override
    public void printIndent() {
        for (int i = 0; i < this.getIndentCount(); ++i) {
            getAppender().append('\t');
        }
    }

    @Override
    public boolean preVisit(SQLObject x) {
        return false;
    }

    @Override
    public boolean visit(SQLSetCharacterSetStatement x) {
        return false;
    }

    @Override
    public boolean visit(SQLSetCharSetStatement x) {
        return false;
    }

    @Override
    public boolean visit(SQLSetDefaultRoleStatement x) {
        return false;
    }

    @Override
    public boolean visit(SQLSetNameStatement x) {
        return false;
    }

    @Override
    public boolean visit(SQLSetPasswordStatement x) {
        return false;
    }

    @Override
    public boolean visit(SQLSetVariableStatement x) {
        print(SQLReserved.SET);
        printSpaceAfterAccept(x.getItems(), ", ");
        return false;
    }


    @Override
    public boolean visit(SQLCreateAnalyticStatement x) {
        return false;
    }

    @Override
    public boolean visit(SQLAlterAnalyticStatement x) {
        return false;
    }

    @Override
    public boolean visit(SQLDropAnalyticStatement x) {
        return false;
    }

    @Override
    public boolean visit(SQLCommentOnAuditPolicyStatement x) {
        print(SQLReserved.COMMENT_ON);

        printSpaceAfterValue(SQLReserved.AUDIT_POLICY);

        printSpaceAfterAccept(x.getName());

        printSpaceAfterValue(SQLReserved.IS);

        printSpaceAfterAccept(x.getComment());
        return false;
    }

    @Override
    public boolean visit(SQLCommentOnColumnStatement x) {

        print(SQLReserved.COMMENT_ON);

        printSpaceAfterValue(SQLReserved.COLUMN);

        printSpaceAfterAccept(x.getName());

        printSpaceAfterValue(SQLReserved.IS);

        printSpaceAfterAccept(x.getComment());
        return false;
    }

    @Override
    public boolean visit(SQLCommentOnDatabaseStatement x) {
        print(SQLReserved.COMMENT_ON);

        printSpaceAfterValue(SQLReserved.DATABASE);

        printSpaceAfterAccept(x.getName());

        printSpaceAfterValue(SQLReserved.IS);

        printSpaceAfterAccept(x.getComment());
        return false;
    }

    @Override
    public boolean visit(SQLCommentOnEditionStatement x) {
        print(SQLReserved.COMMENT_ON);

        printSpaceAfterValue(SQLReserved.EDITION);

        printSpaceAfterAccept(x.getName());

        printSpaceAfterValue(SQLReserved.IS);

        printSpaceAfterAccept(x.getComment());
        return false;
    }

    @Override
    public boolean visit(SQLCommentOnIndexStatement x) {
        print(SQLReserved.COMMENT_ON);

        printSpaceAfterValue(SQLReserved.INDEX);

        printSpaceAfterAccept(x.getName());

        printSpaceAfterValue(SQLReserved.IS);

        printSpaceAfterAccept(x.getComment());
        return false;
    }

    @Override
    public boolean visit(SQLCommentOnIndexTypeStatement x) {
        print(SQLReserved.COMMENT_ON);

        printSpaceAfterValue(SQLReserved.INDEXTYPE);

        printSpaceAfterAccept(x.getName());

        printSpaceAfterValue(SQLReserved.IS);

        printSpaceAfterAccept(x.getComment());
        return false;
    }

    @Override
    public boolean visit(SQLCommentOnMaterializedViewStatement x) {
        print(SQLReserved.COMMENT_ON);

        printSpaceAfterValue(SQLReserved.MATERIALIZED_VIEW);

        printSpaceAfterAccept(x.getName());

        printSpaceAfterValue(SQLReserved.IS);

        printSpaceAfterAccept(x.getComment());
        return false;
    }

    @Override
    public boolean visit(SQLCommentOnMiningModelStatement x) {
        print(SQLReserved.COMMENT_ON);

        printSpaceAfterValue(SQLReserved.MINING_MODEL);

        printSpaceAfterAccept(x.getName());

        printSpaceAfterValue(SQLReserved.IS);

        printSpaceAfterAccept(x.getComment());
        return false;
    }

    @Override
    public boolean visit(SQLCommentOnOperatorStatement x) {
        print(SQLReserved.COMMENT_ON);

        printSpaceAfterValue(SQLReserved.OPERATOR);

        printSpaceAfterAccept(x.getName());

        printSpaceAfterValue(SQLReserved.IS);

        printSpaceAfterAccept(x.getComment());
        return false;
    }

    @Override
    public boolean visit(SQLCommentOnRoleStatement x) {
        print(SQLReserved.COMMENT_ON);

        printSpaceAfterValue(SQLReserved.ROLE);

        printSpaceAfterAccept(x.getName());

        printSpaceAfterValue(SQLReserved.IS);

        printSpaceAfterAccept(x.getComment());
        return false;
    }

    @Override
    public boolean visit(SQLCommentOnSequenceStatement x) {
        print(SQLReserved.COMMENT_ON);

        printSpaceAfterValue(SQLReserved.SEQUENCE);

        printSpaceAfterAccept(x.getName());

        printSpaceAfterValue(SQLReserved.IS);

        printSpaceAfterAccept(x.getComment());
        return false;
    }

    @Override
    public boolean visit(SQLCommentOnServerStatement x) {
        print(SQLReserved.COMMENT_ON);

        printSpaceAfterValue(SQLReserved.SERVER);

        printSpaceAfterAccept(x.getName());

        printSpaceAfterValue(SQLReserved.IS);

        printSpaceAfterAccept(x.getComment());
        return false;
    }

    @Override
    public boolean visit(SQLCommentOnTablespaceStatement x) {
        print(SQLReserved.COMMENT_ON);

        printSpaceAfterValue(SQLReserved.TABLESPACE);

        printSpaceAfterAccept(x.getName());

        printSpaceAfterValue(SQLReserved.IS);

        printSpaceAfterAccept(x.getComment());
        return false;

    }

    @Override
    public boolean visit(SQLCommentOnTableStatement x) {
        print(SQLReserved.COMMENT_ON);

        printSpaceAfterValue(SQLReserved.TABLE);

        printSpaceAfterAccept(x.getName());

        printSpaceAfterValue(SQLReserved.IS);

        printSpaceAfterAccept(x.getComment());
        return false;
    }

    @Override
    public boolean visit(SQLCommentOnTypeStatement x) {
        print(SQLReserved.COMMENT_ON);

        printSpaceAfterValue(SQLReserved.TYPE);

        printSpaceAfterAccept(x.getName());

        printSpaceAfterValue(SQLReserved.IS);

        printSpaceAfterAccept(x.getComment());
        return false;
    }

    @Override
    public boolean visit(SQLCommentOnViewStatement x) {
        print(SQLReserved.COMMENT_ON);

        printSpaceAfterValue(SQLReserved.VIEW);

        printSpaceAfterAccept(x.getName());

        printSpaceAfterValue(SQLReserved.IS);

        printSpaceAfterAccept(x.getComment());
        return false;
    }

    @Override
    public boolean visit(SQLCreateDatabaseStatement x) {
        print(SQLReserved.CREATE);
        printSpaceAfterValue(SQLReserved.DATABASE);
        printSpaceAfterAccept(x.getName());

        printIndentAndLnAndAccept(x.getItems());

        return false;
    }

    @Override
    public boolean visit(SQLAlterDatabaseStatement x) {
        print(SQLReserved.ALTER);
        printSpaceAfterValue(SQLReserved.DATABASE);
        printSpaceAfterAccept(x.getName());

        printIndentAndLnAndAccept(x.getItems());
        return false;
    }

    @Override
    public boolean visit(SQLDropDatabaseStatement x) {
        print(SQLReserved.DROP);
        printSpaceAfterValue(SQLReserved.DATABASE);

        if (x.isIfExists()) {
            printSpaceAfterValue(SQLReserved.IF_EXISTS);
        }

        printSpaceAfterAccept(x.getName());

        return false;
    }


    @Override
    public boolean visit(SQLCreateDatabaseLinkStatement x) {

        print(SQLReserved.CREATE);

        if (x.isShared()) {
            printSpaceAfterValue(SQLReserved.SHARED);
        }

        if (x.isPublic_()) {
            printSpaceAfterValue(SQLReserved.PUBLIC);
        }
        printSpaceAfterValue(SQLReserved.DATABASE_LINK);

        printSpaceAfterAccept(x.getName());

        printIndentAndLnAndAccept(x.getItems());

        SQLExpr using = x.getUsing();
        if (using != null) {
            this.incrementIndent();
            printlnAfterValue(SQLReserved.USING);
            printSpaceAfterAccept(using);
            this.decrementIndent();
        }
        return false;
    }

    @Override
    public boolean visit(SQLAlterDatabaseLinkStatement x) {
        print(SQLReserved.ALTER);
        if (x.isShared()) {
            printSpaceAfterValue(SQLReserved.SHARED);
        }

        if (x.isPublic_()) {
            printSpaceAfterValue(SQLReserved.PUBLIC);
        }
        printSpaceAfterValue(SQLReserved.DATABASE_LINK);

        printSpaceAfterAccept(x.getName());
        printIndentLnAndAccept(x.getAction());
        return false;
    }

    @Override
    public boolean visit(SQLDropDatabaseLinkStatement x) {
        print(SQLReserved.DROP);
        if (x.isPublic_()) {
            printSpaceAfterValue(SQLReserved.PUBLIC);
        }
        printSpaceAfterValue(SQLReserved.DATABASE_LINK);
        printSpaceAfterAccept(x.getName());
        return false;
    }

    /**
     * @param x SQLCreateDomainStatement
     * @return true:父类继续执行 false: 父类不执行
     * @see SQLCreateDomainStatement
     */
    @Override
    public boolean visit(SQLCreateDomainStatement x) {

        print(isLowerCase() ? "create domain " : "CREATE DOMAIN ");

        x.name.accept(this);

        if (x.as) {
            print(isLowerCase() ? " as" : " AS");
        }

        printSpace();
        x.dataType.accept(this);

        SQLExpr defaultExpr = x.defaultExpr;
        if (defaultExpr != null) {
            print(isLowerCase() ? " public " : " public ");
            defaultExpr.accept(this);
        }

        List<SQLConstraint> constraints = x.constraints;
        if (constraints != null) {
            printlnAndAccept(constraints);
        }


        SQLName collateName = x.collateName;
        if (collateName != null) {
            print(isLowerCase() ? " collate " : " COLLATE ");
            collateName.accept(this);
        }

        return false;
    }

    @Override
    public boolean visit(SQLAlterDomainStatement x) {
        return false;
    }

    @Override
    public boolean visit(SQLDropDomainStatement x) {
        return false;
    }


    @Override
    public boolean visit(SQLCreateEventStatement x) {
        return false;
    }

    @Override
    public boolean visit(SQLAlterEventStatement x) {
        return false;
    }

    @Override
    public boolean visit(SQLDropEventStatement x) {
        return false;
    }


    @Override
    public boolean visit(SQLCreateFunctionStatement x) {
        print(SQLReserved.CREATE);
        printSpaceAfterValue(x.getOrReplace());
        printSpaceAfterValue(x.getEditionAbleType());

        if (x.isAggregate()) {
            printSpaceAfterValue(SQLReserved.AGGREGATE);
        }

        printSpaceAfterAccept(x.getDefinerOptionExpr());

        printSpaceAfterValue(SQLReserved.FUNCTION);

        printSpaceAfterAccept(x.getName());

        printSpaceAndLnAndAccept(x.getParameters(), ",", true);

        SQLDataType returnDataType = x.getReturnDataType();
        if (returnDataType != null) {
            printSpaceAfterValue(SQLReserved.RETURN);
            printSpaceAfterAccept(returnDataType);
        }

        List<SQLExpr> options = x.getOptions();
        if (options != null
                && options.size() > 0) {
            println();
            printlnAndAccept(options);
        }

        SQLASType as = x.getAs();
        if (as != null) {
            printlnAfterValue(as.name);
        }

        this.incrementIndent();
        List<SQLExpr> declareSections = x.getDeclareSections();
        if (declareSections != null
                && declareSections.size() > 0) {
            println();
            printlnAndAccept(declareSections);
        }

        SQLExpr asExpr = x.getAsExpr();
        if (asExpr != null) {
            printlnAndAccept(asExpr);
        }
        this.decrementIndent();

        return false;
    }

    @Override
    public boolean visit(SQLAlterFunctionStatement x) {
        print(SQLReserved.ALTER);
        printSpaceAfterValue(SQLReserved.FUNCTION);
        printSpaceAfterAccept(x.getName());
        printSpaceAfterAccept(x.getOption());
        return false;
    }

    @Override
    public boolean visit(SQLDropFunctionStatement x) {
        print(SQLReserved.DROP);

        printSpaceAfterValue(SQLReserved.FUNCTION);

        if (x.isIfExists()) {
            printSpaceAfterValue(SQLReserved.IF_EXISTS);
        }

        printSpaceAfterAccept(x.getName());

        printSpaceAfterAccept(x.getParameters(), ", ", true);

        if (x.getOption() != null) {
            printSpaceAfterValue(x.getOption().name);
        }

        return false;
    }


    @Override
    public boolean visit(SQLCreateIndexStatement x) {
        print(SQLReserved.CREATE);

        printSpaceAfterValue(x.getCategory());

        printSpaceAfterValue(SQLReserved.INDEX);

        if (x.isConcurrently()) {
            printSpaceAfterValue(SQLReserved.CONCURRENTLY);
        }

        if (x.isIfNotExists()) {
            printSpaceAfterValue(SQLReserved.IF_NOT_EXISTS);
        }

        printSpaceAfterAccept(x.getName());

        printSpaceAfterValue(SQLReserved.ON);

        if (x.isCluster()) {
            printSpaceAfterValue(SQLReserved.CLUSTER);
        }

        printSpaceAfterAccept(x.getTableReference());

        printSpaceAfterAccept(x.getColumns(), ", ", true);

        printlnAndAccept(x.getFromClause());
        printlnAndAccept(x.getWhereClause());


        List<SQLExpr> properties = x.getProperties();
        if (properties != null
                && properties.size() > 0) {
            println();
            printlnAndAccept(properties);
        }

        printlnAfterValue(x.getUsable());
        printlnAfterValue(x.getInvalidation());

        return false;
    }

    @Override
    public boolean visit(SQLAlterIndexStatement x) {
        print(SQLReserved.ALTER);
        printSpaceAfterValue(SQLReserved.INDEX);

        if (x.isIfExists()) {
            printSpaceAfterValue(SQLReserved.IF_EXISTS);
        }

        printSpaceAfterAccept(x.getName());

        SQLName onName = x.getOnName();
        if (onName != null) {
            printSpaceAfterValue(SQLReserved.ON);
            printSpaceAfterAccept(onName);
        }

        printIndentAndLnAndAccept(x.getItems());
        return false;
    }

    @Override
    public boolean visit(SQLDropIndexStatement x) {
        print(SQLReserved.DROP);
        printSpaceAfterValue(SQLReserved.INDEX);

        if (x.isConcurrently()) {
            printSpaceAfterValue(SQLReserved.CONCURRENTLY);
        }

        if (x.isIfExists()) {
            printSpaceAfterValue(SQLReserved.IF_EXISTS);
        }

        printSpaceAfterAccept(x.getNames(), ", ");

        SQLExpr table = x.getTable();
        if (table != null) {
            printSpaceAfterValue(SQLReserved.ON);
            printSpaceAfterAccept(x.getTable());
        }

        if (x.isOnline()) {
            printSpaceAfterValue(SQLReserved.ONLINE);
        }

        if (x.isForce()) {
            printSpaceAfterValue(SQLReserved.FORCE);
        }

        printSpaceAfterValue(x.getInvalidation());

        printSpaceAfterValue(x.getCascade());

        printSpaceAfterAccept(x.getOptions(), " ");

        return false;
    }


    @Override
    public boolean visit(SQLCreateMaterializedViewStatement x) {
        print(SQLReserved.CREATE);
        printSpaceAfterValue(SQLReserved.MATERIALIZED_VIEW);
        printSpaceAfterAccept(x.getName());

        printSpaceAndLnAndAccept(x.getColumns(), ",", true);

        SQLDataType ofDataType = x.getOfDataType();
        if (ofDataType != null) {
            printSpaceAfterValue(SQLReserved.OF);
            printSpaceAfterAccept(ofDataType);
        }

        printSpaceAndLnAndAccept(x.getColumnConstraints(), ",", true);

        printlnAndAccept(x.getCollationExpr());

        List<SQLExpr> properties = x.getProperties();
        if (properties != null
                && properties.size() > 0) {
            println();
            printlnAndAccept(properties);
        }


        printlnAndAccept(x.getUsingIndex());
        printlnAndAccept(x.getCreateMVRefresh());
        printlnAndAccept(x.getEvaluationEditionClause());
        printlnAndAccept(x.getOnQueryComputationClause());
        printlnAndAccept(x.getQueryRewriteClause());

        printlnAfterValue(SQLReserved.AS);
        printIndentLnAndAccept(x.getAsSubQuery());

        return false;
    }

    @Override
    public boolean visit(SQLCreateMaterializedViewStatement.SQLColumn x) {
        print(x.getName());
        printSpaceAfterAccept(x.getEncryptClause());
        return false;
    }

    @Override
    public boolean visit(SQLAlterMaterializedViewStatement x) {
        print(SQLReserved.ALTER);
        printSpaceAfterValue(SQLReserved.MATERIALIZED_VIEW);
        printSpaceAfterAccept(x.getName());
        return false;
    }

    @Override
    public boolean visit(SQLDropMaterializedViewStatement x) {
        print(SQLReserved.DROP);
        printSpaceAfterValue(SQLReserved.MATERIALIZED_VIEW);

        if (x.isIfExists()) {
            printSpaceAfterValue(SQLReserved.IF_EXISTS);
        }

        printSpaceAfterAccept(x.getNames(), ", ");

        SQLDropMaterializedViewStatement.SQLOption option = x.getOption();
        if (option != null) {
            printSpaceAfterValue(option.name);
        }
        return false;
    }


    @Override
    public boolean visit(SQLCreateMaterializedViewLogStatement x) {
        return false;
    }

    @Override
    public boolean visit(SQLAlterMaterializedViewLogStatement x) {
        return false;
    }

    @Override
    public boolean visit(SQLDropMaterializedViewLogStatement x) {
        return false;
    }

    @Override
    public boolean visit(SQLCreatePackageStatement x) {
        print(SQLReserved.CREATE);

        if (x.isOrReplace()) {
            printSpaceAfterValue(SQLReserved.OR_REPLACE);
        }

        SQLEditionAbleType editionAbleType = x.getEditionAbleType();
        if (editionAbleType != null) {
            printSpaceAfterValue(editionAbleType.name);
        }

        printSpaceAfterValue(SQLReserved.PACKAGE);

        printSpaceAfterAccept(x.getName());

        printlnAndAccept(x.getOptions());

        println();
        print(x.getAs().name);

        this.incrementIndent();
        println();
        printlnAndAccept(x.getItems());

        this.decrementIndent();
        println();

        print(SQLReserved.END);
        printSpaceAfterAccept(x.getEndName());


        return false;
    }

    @Override
    public boolean visit(SQLAlterPackageStatement x) {
        print(SQLReserved.ALTER);
        printSpaceAfterValue(SQLReserved.PACKAGE);
        printSpaceAfterAccept(x.getName());
        printSpaceAfterAccept(x.getOption());
        return false;
    }

    @Override
    public boolean visit(SQLDropPackageStatement x) {
        print(SQLReserved.DROP);
        printSpaceAfterValue(SQLReserved.PACKAGE);
        printSpaceAfterAccept(x.getName());
        return false;
    }

    @Override
    public boolean visit(SQLCreatePackageBodyStatement x) {
        print(SQLReserved.CREATE);

        if (x.isOrReplace()) {
            printSpaceAfterValue(SQLReserved.OR_REPLACE);
        }

        SQLEditionAbleType editionAbleType = x.getEditionAbleType();
        if (editionAbleType != null) {
            printSpaceAfterValue(editionAbleType.name);
        }

        printSpaceAfterValue(SQLReserved.PACKAGE_BODY);

        printSpaceAfterAccept(x.getName());

        printlnAfterValue(x.getAs().name);

        this.incrementIndent();
        println();
        printlnAndAccept(x.getItems());


        List<SQLBody.SQLBodyItem> bodyItems = x.getBodyItems();
        if (bodyItems != null
                && bodyItems.size() > 0) {
            printlnAfterValue(SQLReserved.BEGIN);
            printlnAndAccept(bodyItems);


            printlnAndAccept(x.getExceptionClause());
        }

        this.decrementIndent();
        println();

        print(SQLReserved.END);
        printSpaceAfterAccept(x.getEndName());

        return false;
    }

    @Override
    public boolean visit(SQLAlterPackageBodyStatement x) {
        print(SQLReserved.ALTER);
        printSpaceAfterValue(SQLReserved.PACKAGE_BODY);

        return false;
    }

    @Override
    public boolean visit(SQLDropPackageBodyStatement x) {
        print(SQLReserved.DROP);
        printSpaceAfterValue(SQLReserved.PACKAGE_BODY);
        printSpaceAfterAccept(x.getName());
        return false;
    }


    @Override
    public boolean visit(SQLCreatePluggableDatabaseStatement x) {
        print(SQLReserved.CREATE);
        printSpaceAfterValue(SQLReserved.PLUGGABLE_DATABASE);
        printSpaceAfterAccept(x.getName());
        return false;
    }

    @Override
    public boolean visit(SQLAlterPluggableDatabaseStatement x) {
        print(SQLReserved.ALTER);
        printSpaceAfterValue(SQLReserved.PLUGGABLE_DATABASE);
        printSpaceAfterAccept(x.getName());
        return false;
    }

    @Override
    public boolean visit(SQLDropPluggableDatabaseStatement x) {
        print(SQLReserved.DROP);
        printSpaceAfterValue(SQLReserved.PLUGGABLE_DATABASE);
        printSpaceAfterAccept(x.getName());
        printSpaceAfterValue(x.getOption());
        return false;
    }

    @Override
    public boolean visit(SQLCreateProcedureStatement x) {
        print(SQLReserved.CREATE);

        SQLOrReplaceType orReplace = x.getOrReplace();
        if (orReplace != null) {
            printSpaceAfterValue(orReplace.name);
        }

        SQLEditionAbleType editionAbleType = x.getEditionAbleType();
        if (editionAbleType != null) {
            printSpaceAfterValue(editionAbleType.name);
        }

        printSpaceAfterValue(SQLReserved.PROCEDURE);
        printSpaceAfterAccept(x.getName());

        printSpaceProcedureParameterList(x.getParameters());


        printlnAndAccept(x.getSharingClause());

        List<SQLExpr> options = x.getOptions();
        if (options != null
                && options.size() > 0) {
            printlnAndAccept(options);
        }

        SQLASType as = x.getAs();
        if (as != null) {
            printlnAfterValue(as.name);
        }

        this.incrementIndent();

        List<SQLExpr> declareSections = x.getDeclareSections();
        if (declareSections != null
                && declareSections.size() > 0) {
            println();
            printlnAndAccept(declareSections);
        }

        printlnAndAccept(x.getAsExpr());

        this.decrementIndent();

        return false;
    }

    public void printSpaceProcedureParameterList(List<SQLParameterDeclaration> x) {
        printSpaceAfterValue(SQLReserved.LEFT_PAREN);

        if (x != null
                && x.size() > 0) {
            this.incrementIndent();
            println();
            printlnAndAccept(x, ",");
            this.decrementIndent();
            println();
        }

        print(SQLReserved.RIGHT_PAREN);
    }


    @Override
    public boolean visit(SQLAlterProcedureStatement x) {

        return false;
    }

    @Override
    public boolean visit(SQLDropProcedureStatement x) {
        print(SQLReserved.DROP);
        printSpaceAfterValue(SQLReserved.PROCEDURE);

        if (x.isIfExists()) {
            printSpaceAfterValue(SQLReserved.IF_EXISTS);
        }
        printSpaceAfterAccept(x.getName());
        return false;
    }


    @Override
    public boolean visit(SQLCreateRoleStatement x) {
        print(SQLReserved.CREATE);
        printSpaceAfterValue(SQLReserved.ROLE);


        return false;
    }

    @Override
    public boolean visit(SQLAlterRoleStatement x) {
        print(SQLReserved.ALTER);
        printSpaceAfterValue(SQLReserved.ROLE);
        return false;
    }

    @Override
    public boolean visit(SQLDropRoleStatement x) {
        print(SQLReserved.DROP);
        printSpaceAfterValue(SQLReserved.ROLE);

        if (x.isIfExists()) {
            printSpaceAfterValue(SQLReserved.IF_EXISTS);
        }

        printSpaceAfterAccept(x.getNames(), ", ");

        return false;
    }

    @Override
    public boolean visit(SQLCreateRollbackSegmentStatement x) {
        print(SQLReserved.CREATE);

        if (x.isPublic_()) {
            printSpaceAfterValue(SQLReserved.PUBLIC);
        }
        printSpaceAfterValue(SQLReserved.ROLLBACK_SEGMENT);
        printSpaceAfterAccept(x.getName());

        printlnAndAccept(x.getSegmentAttributes());

        return false;
    }

    @Override
    public boolean visit(SQLDropRollbackSegmentStatement x) {
        print(SQLReserved.DROP);
        printSpaceAfterValue(SQLReserved.ROLLBACK_SEGMENT);
        printSpaceAfterAccept(x.getName());
        return false;
    }

    @Override
    public boolean visit(SQLCreateSchemaStatement x) {
        print(SQLReserved.CREATE);
        printSpaceAfterValue(SQLReserved.SCHEMA);
        printSpaceAfterAccept(x.getName());
        return false;
    }

    @Override
    public boolean visit(SQLAlterSchemaStatement x) {
        return false;
    }

    @Override
    public boolean visit(SQLDropSchemaStatement x) {
        print(SQLReserved.DROP);
        printSpaceAfterValue(SQLReserved.SCHEMA);
        printSpaceAfterAccept(x.getNames(), ", ");

        SQLCascadeType option = x.getOption();
        if (option != null) {
            printSpaceAfterValue(option.name);
        }

        return false;
    }


    @Override
    public boolean visit(SQLCreateSequenceStatement x) {

        print(SQLReserved.CREATE);

        SQLCreateSequenceStatement.SQLScope scope = x.getScope();
        if (scope != null) {
            printSpaceAfterValue(scope.name);
        }

        printSpace();
        print(SQLReserved.SEQUENCE);

        printSpace();
        x.getName().accept(this);

        printSpaceAfterAccept(x.getSharingClause());

        printSpace();
        this.printAccept(x.getOptions(), " ");

        return false;
    }

    @Override
    public boolean visit(SQLAlterSequenceStatement x) {

        print(SQLReserved.ALTER);

        printSpace();
        print(SQLReserved.SEQUENCE);

        boolean ifExists = x.isIfExists();
        if (ifExists) {
            printSpace();
            print(SQLReserved.IF_EXISTS);
        }

        printSpace();
        x.getName().accept(this);

        printSpace();
        this.printAccept(x.getOptions(), " ");

        return false;
    }

    @Override
    public boolean visit(SQLDropSequenceStatement x) {

        print(SQLReserved.DROP);
        printSpaceAfterValue(SQLReserved.SEQUENCE);

        if (x.isIfExists()) {
            printSpace();
            print(SQLReserved.IF_EXISTS);
        }

        printSpaceAfterAccept(x.getNames(), ", ");

        SQLCascadeType dropBehavior = x.getDropBehavior();
        if (dropBehavior != null) {
            printSpaceAfterValue(dropBehavior.name);
        }

        return false;
    }


    @Override
    public boolean visit(SQLCreateServerStatement x) {
        print(SQLReserved.CREATE);
        printSpaceAfterValue(SQLReserved.SERVER);
        printSpaceAfterAccept(x.getName());

        printSpaceAfterValue(SQLReserved.FOREIGN_DATA_WRAPPER);
        printSpaceAfterAccept(x.getWrapper());

        List<SQLExpr> options = x.getOptions();
        if (options != null
                && options.size() > 0) {
            printSpaceAfterValue(SQLReserved.OPTIONS);
            printSpaceAfterAccept(options, ", ", true);
        }

        return false;
    }

    @Override
    public boolean visit(SQLAlterServerStatement x) {
        return false;
    }

    @Override
    public boolean visit(SQLDropServerStatement x) {
        print(SQLReserved.DROP);
        printSpaceAfterValue(SQLReserved.SERVER);

        if (x.isIfExists()) {
            printSpaceAfterValue(SQLReserved.IF_EXISTS);
        }

        printSpaceAfterAccept(x.getName());
        return false;
    }


    @Override
    public boolean visit(SQLCreateSynonymStatement x) {
        print(SQLReserved.CREATE);

        if (x.isOrReplace()) {
            printSpaceAfterValue(SQLReserved.OR_REPLACE);
        }

        if (x.isPublic_()) {
            printSpaceAfterValue(SQLReserved.PUBLIC);
        }

        printSpaceAfterValue(SQLReserved.SYNONYM);

        printSpaceAfterAccept(x.getName());

        printSpaceAfterValue(SQLReserved.FOR);
        printSpaceAfterAccept(x.getForName());

        return false;
    }

    @Override
    public boolean visit(SQLAlterSynonymStatement x) {
        print(SQLReserved.ALTER);

        if (x.isPublic_()) {
            printSpaceAfterValue(SQLReserved.PUBLIC);
        }

        printSpaceAfterValue(SQLReserved.SYNONYM);

        printSpaceAfterAccept(x.getName());

        SQLAlterSynonymStatement.SQLOption option = x.getOption();
        if (option != null) {
            printSpaceAfterValue(option.name);
        }


        return false;
    }

    @Override
    public boolean visit(SQLDropSynonymStatement x) {
        print(SQLReserved.DROP);

        if (x.isPublic_()) {
            printSpaceAfterValue(SQLReserved.PUBLIC);
        }

        printSpaceAfterValue(SQLReserved.SYNONYM);

        if (x.isIfExists()) {
            printSpaceAfterValue(SQLReserved.IF_EXISTS);
        }

        printSpaceAfterAccept(x.getName());

        if (x.isForce()) {
            printSpaceAfterValue(SQLReserved.FORCE);
        }

        return false;
    }


    @Override
    public boolean visit(SQLCreateTableStatement x) {
        print(SQLReserved.CREATE);

        printSpaceAfterValue(x.getScope());

        printSpaceAfterValue(SQLReserved.TABLE);

        if (x.isIfNotExists()) {
            printSpaceAfterValue(SQLReserved.IF_NOT_EXISTS);
        }

        printSpaceAfterAccept(x.getName());
        printSpaceAfterAccept(x.getSharingClause());

        SQLDataType ofDataType = x.getOfDataType();
        if (ofDataType != null) {
            printSpaceAfterValue(SQLReserved.OF);
            printSpaceAfterAccept(ofDataType);
        }

        printlnAndAccept(x.getObjectTableSubstitution());

        printTableElements(x.getTableElements(), x.isTableElementsParen());

        printlnAndAccept(x.getCollationExpr());

        // todo
//        OracleSQLXmlTypeStorage xmlTypeStorage = x.getXmlTypeStorage();
//        if (xmlTypeStorage != null) {
//            printlnAfterValue(SQLReserved.XMLTYPE);
//            printSpaceAfterAccept(x.getXmlTypeStorage());
//        }

        printlnAndAccept(x.getXmlSchemaSpec());
        // todo
//        printlnAndAccept(x.getXmlTypeVirtualColumn());

        printlnAfterValue(x.getCommitActionDefinition());
        printlnAfterValue(x.getCommitActionRows());

        printlnAndAccept(x.getOidClause());
        printlnAndAccept(x.getOidIndexClause());

        List<SQLExpr> properties = x.getProperties();
        if (properties != null
                && properties.size() > 0) {
            println();
            printlnAndAccept(properties);
        }


        printlnAfterValue(x.getReadOnly());
        printlnAfterValue(x.getIndexingOn());

        printlnAndAccept(x.getPartitionBy());

        printlnAfterValue(x.getCache());
        printlnAndAccept(x.getResultCache());
        printlnAndAccept(x.getParallelClause());
        printlnAfterValue(x.getRowDependencies());

        List<ISQLEnableDisableClause> enableDisableClauses = x.getEnableDisableClauses();
        if (enableDisableClauses != null
                && enableDisableClauses.size() > 0) {
            println();
            printlnAndAccept(enableDisableClauses);
        }
        printlnAndAccept(x.getRowMovementClause());
        printlnAndAccept(x.getFlashbackArchiveClause());
        if (x.isRowArchival()) {
            printlnAfterValue(SQLReserved.ROW_ARCHIVAL);
        }
        printlnAndAccept(x.getForExchangeWithTableClause());

        ISQLSelectQuery subQuery = x.getSubQuery();
        if (subQuery != null) {
            if (x.isAs()) {
                printlnAfterValue(SQLReserved.AS);
            }
            printIndentLnAndAccept(x.getSubQuery());
        }


        if (x.isMemOptimizeForRead()) {
            printlnAfterValue(SQLReserved.MEMOPTIMIZE_FOR_READ);
        }

        SQLExpr parentTable = x.getParentTable();
        if (parentTable != null) {
            printlnAfterValue(SQLReserved.PARENT);
            printSpaceAfterAccept(parentTable);

        }
        return false;
    }

    public void printTableElements(List<SQLTableElement> tableElements, boolean paren) {
        int size = tableElements.size();
        if (size == 0) {
            return;
        }

        printSpace();

        if (paren) {
            print(SQLReserved.LEFT_PAREN);
            this.incrementIndent();
            println();
        }

        for (int i = 0; i < size; ++i) {
            SQLTableElement element = tableElements.get(i);

            if (i > 0) {
                print(',');
                println();
            }

            element.accept(this);
        }

        if (paren) {
            this.decrementIndent();
            println();
            print(SQLReserved.RIGHT_PAREN);
        }
    }


    @Override
    public boolean visit(SQLAlterTableStatement x) {
        print(SQLReserved.ALTER);
        printSpaceAfterValue(SQLReserved.TABLE);
        printSpaceAfterAccept(x.getTableReference());

        printIndentAndLnAndAccept(x.getItems());

        printSpaceAfterAccept(x.getPartitionBy());
        return false;
    }

    @Override
    public boolean visit(SQLDropTableStatement x) {
        print(SQLReserved.DROP);

        if (x.isTemporary()) {
            printSpaceAfterValue(SQLReserved.TEMPORARY);
        }

        printSpaceAfterValue(SQLReserved.TABLE);

        if (x.isIfExists()) {
            printSpaceAfterValue(SQLReserved.IF_EXISTS);
        }

        printSpaceAfterAccept(x.getNames(), ", ");

        printSpaceAfterValue(x.getDropBehavior());

        if (x.isPurge()) {
            printSpaceAfterValue(SQLReserved.PURGE);
        }

        return false;
    }


    @Override
    public boolean visit(SQLCreateTriggerStatement x) {
        print(SQLReserved.CREATE);

        if (x.isOrReplace()) {
            printSpace();
            print(SQLReserved.OR_REPLACE);
        }

        SQLEditionAbleType editionAbleType = x.getEditionAbleType();
        if (editionAbleType != null) {
            printSpaceAfterValue(editionAbleType.name);
        }

        printSpaceAfterAccept(x.getDefinerExpr());

        printSpace();
        print(SQLReserved.TRIGGER);

        printSpaceAfterAccept(x.getName());

        this.incrementIndent();

        printlnAfterValue(x.getActionTime().name);
        printIndentAndLnAndAccept(x.getEvents(), " OR");

        SQLExpr onExpr = x.getOnExpr();
        if (onExpr != null) {
            printlnAfterValue(SQLReserved.ON);

            SQLExpr nestedTableColumn = x.getNestedTableColumn();
            if (nestedTableColumn != null) {
                printSpaceAfterValue(SQLReserved.NESTED);
                printSpaceAfterValue(SQLReserved.TABLE);
                printSpaceAfterAccept(nestedTableColumn);
                printSpaceAfterValue(SQLReserved.OF);
            }

            printSpaceAfterAccept(onExpr);
        }

        List<SQLTriggerReferencingOption> referencingOptions = x.getReferencingOptions();
        if (referencingOptions != null
                && referencingOptions.size() > 0) {
            printlnAfterValue(SQLReserved.REFERENCING);
            printSpace();
            this.incrementIndent();
            printlnAndAccept(referencingOptions);
            this.decrementIndent();
        }

        printlnAfterValue(x.getForEachType());
        printlnAfterValue(x.getEditionType());

        printlnAndAccept(x.getOrderingClause());

        SQLExpr whenCondition = x.getWhenCondition();
        if (whenCondition != null) {
            printlnAfterValue(SQLReserved.WHEN);
            printSpaceAfterValue(SQLReserved.LEFT_PAREN);
            whenCondition.accept(this);
            print(SQLReserved.RIGHT_PAREN);
        }

        printlnAndAccept(x.getTriggerBody());

        this.decrementIndent();

        return false;
    }

    @Override
    public boolean visit(SQLAlterTriggerStatement x) {
        print(SQLReserved.ALTER);
        printSpaceAfterValue(SQLReserved.TRIGGER);
        printSpaceAfterAccept(x.getName());

        SQLName onTableName = x.getOnTableName();
        if (onTableName != null) {
            printSpaceAfterValue(SQLReserved.ON);
            printSpaceAfterAccept(onTableName);
        }

        printSpaceAfterAccept(x.getOption());

        return false;
    }

    @Override
    public boolean visit(SQLDropTriggerStatement x) {
        print(SQLReserved.DROP);
        printSpaceAfterValue(SQLReserved.TRIGGER);

        if (x.isIfExists()) {
            printSpaceAfterValue(SQLReserved.IF_EXISTS);
        }

        printSpaceAfterAccept(x.getName());

        SQLName onTableName = x.getOnTableName();
        if (onTableName != null) {
            printSpaceAfterValue(SQLReserved.ON);
            printSpaceAfterAccept(onTableName);
        }

        SQLCascadeType option = x.getOption();
        if (option != null) {
            printSpaceAfterValue(option.name);
        }

        return false;
    }


    @Override
    public boolean visit(SQLCreateTypeStatement x) {
        print(SQLReserved.CREATE);

        if (x.isOrReplace()) {
            printSpaceAfterValue(SQLReserved.OR_REPLACE);
        }

        SQLEditionAbleType editionAbleType = x.getEditionAbleType();
        if (editionAbleType != null) {
            printSpaceAfterValue(editionAbleType.name);
        }

        printSpaceAfterValue(SQLReserved.TYPE);

        printSpaceAfterAccept(x.getName());


        if (x.isForce()) {
            printSpaceAfterValue(SQLReserved.FORCE);
        }

        SQLExpr oIdLiteral = x.getOidLiteral();
        if (oIdLiteral != null) {
            printSpaceAfterValue(SQLReserved.OID);
            printSpaceAfterAccept(oIdLiteral);
        }

        printIndentLnAndAccept(x.getSharingClause());

        List<SQLExpr> beforeOptions = x.getProperties();
        if (beforeOptions != null
                && beforeOptions.size() > 0) {
            printSpaceAfterAccept(beforeOptions, " ");
        }

        printSpaceAfterAccept(x.getObjectSubDataType());

        SQLASType as = x.getAs();
        if (as != null) {
            printSpaceAfterValue(as.name);
        }

        printSpaceAfterAccept(x.getAsDataType());

        printlnAndAccept(x.getExternalNameClause());

        printSpaceAndLnAndAccept(x.getAttributeDefinitions(), ",", true);

        List<SQLExpr> afterOptions = x.getOptions();
        if (afterOptions != null
                && afterOptions.size() > 0) {
            println();
            printlnAndAccept(afterOptions);
        }

        return false;
    }

    @Override
    public boolean visit(SQLCreateTypeStatement.SQLExternalNameClause x) {
        print(SQLReserved.EXTERNAL_NAME);
        printSpaceAfterAccept(x.getName());
        printSpaceAfterValue(SQLReserved.LANGUAGE_JAVA_USING);
        printSpaceAfterValue(x.getUsingType());
        return false;
    }

    @Override
    public boolean visit(SQLAlterTypeStatement x) {
        print(SQLReserved.ALTER);

        printSpaceAfterValue(SQLReserved.TYPE);
        printSpaceAfterAccept(x.getName());

        printIndentAndLnAndAccept(x.getActions(), ", ");
        return false;
    }

    @Override
    public boolean visit(SQLDropTypeStatement x) {

        print(SQLReserved.DROP);
        printSpaceAfterValue(SQLReserved.TYPE);

        printSpaceAfterAccept(x.getNames(), ", ");

        SQLDropTypeStatement.SQLDropTypeOption option = x.getOption();
        if (option != null) {
            printSpaceAfterValue(option.name);
        }
        return false;
    }


    @Override
    public boolean visit(SQLCreateTypeBodyStatement x) {
        print(SQLReserved.CREATE);

        if (x.isOrReplace()) {
            printSpaceAfterValue(SQLReserved.OR_REPLACE);
        }

        SQLEditionAbleType editionAbleType = x.getEditionAbleType();
        if (editionAbleType != null) {
            printSpaceAfterValue(editionAbleType.name);
        }

        printSpaceAfterValue(SQLReserved.TYPE_BODY);

        printSpaceAfterAccept(x.getName());

        SQLASType as = x.getAs();
        if (as != null) {
            printSpaceAfterValue(as.name);
        }

        printIndentAndLnAndAccept(x.getItems());

        printlnAfterValue(SQLReserved.END);
        return false;
    }

    @Override
    public boolean visit(SQLCreateTypeBodyStatement.SQLCreateBodyItem x) {
        print(x.getAction());
        return false;
    }

    @Override
    public boolean visit(SQLAlterTypeBodyStatement x) {
        print(SQLReserved.ALTER);
        printSpaceAfterValue(SQLReserved.TYPE_BODY);
        printSpaceAfterAccept(x.getName());
        return false;
    }

    @Override
    public boolean visit(SQLDropTypeBodyStatement x) {
        print(SQLReserved.DROP);
        printSpaceAfterValue(SQLReserved.TYPE_BODY);
        printSpaceAfterAccept(x.getName());
        return false;
    }


    @Override
    public boolean visit(SQLCreateUserStatement x) {
        print(SQLReserved.CREATE);
        printSpaceAfterValue(SQLReserved.USER);
//        printSpaceAfterAccept(x.getName());
        return false;
    }

    @Override
    public boolean visit(SQLAlterUserStatement x) {
        print(SQLReserved.ALTER);
        printSpaceAfterValue(SQLReserved.USER);
//        printSpaceAfterAccept(x.getName());
        return false;
    }

    @Override
    public boolean visit(SQLDropUserStatement x) {
        print(SQLReserved.DROP);
        printSpaceAfterValue(SQLReserved.USER);
//        printSpaceAfterAccept(x.getName());
        return false;
    }


    @Override
    public boolean visit(SQLCreateViewStatement x) {
        print(SQLReserved.CREATE);
        if (x.isOrReplace()) {
            printSpaceAfterValue(SQLReserved.OR_REPLACE);
        }

        printSpaceAfterValue(x.getForce());
        printSpaceAfterValue(x.getEditionAble());

        printSpaceAfterAccept(x.getAlgorithmSetOptionExpr());
        printSpaceAfterAccept(x.getDefinerSetOptionExpr());
        printSpaceAfterValue(x.getSecurityType());

        printSpaceAfterValue(SQLReserved.VIEW);
        printSpaceAfterAccept(x.getName());

        printSpaceAfterAccept(x.getSharingClause());

        SQLDataType ofDataType = x.getOfDataType();
        if (ofDataType != null) {
            printSpaceAfterValue(SQLReserved.OF);
            printSpaceAfterAccept(ofDataType);
        }

        printlnAndAccept(x.getXmlSchemaSpec());
        printlnAndAccept(x.getSubView());

        printSpaceAndLnAndAccept(x.getColumns(), ",", true);

        printlnAndAccept(x.getCollationExpr());
        printlnAfterValue(x.getBequeath());

        printlnAfterValue(SQLReserved.AS);

        this.incrementIndent();
        printlnAndAccept(x.getSubQuery());
        this.decrementIndent();
        printlnAndAccept(x.getSubqueryRestriction());

        printlnAfterValue(x.getContainer());


        return false;
    }

    @Override
    public boolean visit(SQLAlterViewStatement x) {
        print(SQLReserved.ALTER);
        printSpaceAfterValue(SQLReserved.VIEW);

        if (x.isIfExists()) {
            printSpaceAfterValue(SQLReserved.IF_EXISTS);
        }
        printSpaceAfterAccept(x.getName());
        printIndentLnAndAccept(x.getAction());

        return false;
    }

    @Override
    public boolean visit(SQLDropViewStatement x) {
        print(SQLReserved.DROP);
        printSpaceAfterValue(SQLReserved.VIEW);

        if (x.isIfExists()) {
            printSpaceAfterValue(SQLReserved.IF_EXISTS);
        }

        printSpaceAfterAccept(x.getNames(), ", ");

        printSpaceAfterValue(x.getBehavior());
        return false;
    }


    @Override
    public boolean visit(SQLCloseStatement x) {

        print(SQLReserved.CLOSE);

        printSpaceAfterAccept(x.getName());

        return false;
    }


    @Override
    public boolean visit(SQLOpenStatement x) {
        print(SQLReserved.OPEN);
        printSpaceAfterAccept(x.getName());
        printSpaceAndLnAndAccept(x.getParameters(), ",", true);
        return false;
    }

    @Override
    public boolean visit(SQLCallStatement x) {
        print(SQLReserved.CALL);
        printSpaceAfterAccept(x.getExpr());

        SQLExpr into = x.getInto();
        if (into != null) {
            printSpaceAfterValue(SQLReserved.INTO);
            printSpaceAfterAccept(into);
        }

        return false;
    }


    @Override
    public boolean visit(SQLLoadDataStatement x) {
        print(SQLReserved.LOAD_DATA);

        printSpaceAfterValue(x.getPriority());

        boolean local = x.isLocal();
        if (local) {
            printSpaceAfterValue(SQLReserved.LOCAL);
        }

        printSpaceAfterValue(SQLReserved.INFILE);

        printSpace();
        x.getName().accept(this);

        SQLReserved option = x.getOption();
        if (option != null) {
            printSpaceAfterValue(option);
        }

        printSpaceAfterValue(SQLReserved.INTO_TABLE);

        printSpace();
        x.getTableName().accept(this);

        if (x.getPartitionNames().size() > 0) {
            println();
            print(SQLReserved.PARTITION);

            printSpace();
            printAccept(x.getPartitionNames(), ", ");
        }

        SQLCharacterSetOptionExpr characterSetExpr = x.getCharacterSetExpr();
        if (characterSetExpr != null) {
            println();
            characterSetExpr.accept(this);
        }

        SQLReserved fieldsType = x.getFieldsType();
        if (fieldsType != null) {
            println();
            print(fieldsType);

            SQLCharLiteral terminatedBy = x.getTerminatedBy();
            if (terminatedBy != null) {
                printSpace();
                print(SQLReserved.TERMINATED_BY);

                printSpace();
                terminatedBy.accept(this);
            }

            SQLCharLiteral enclosedBy = x.getEnclosedBy();
            boolean optionally = x.isOptionally();
            if (enclosedBy != null) {
                printSpace();
                print(SQLReserved.ENCLOSED_BY);

                if (optionally) {
                    printSpace();
                    print(SQLReserved.OPTIONALLY);
                }
                printSpace();
                enclosedBy.accept(this);
            }

            SQLCharLiteral escapedBy = x.getEscapedBy();
            if (escapedBy != null) {
                printSpace();
                print(SQLReserved.ESCAPED_BY);

                printSpace();
                escapedBy.accept(this);
            }
        }


        boolean lines = x.isLines();
        if (lines) {
            println();
            print(SQLReserved.LINES);

            SQLCharLiteral linesStartingBy = x.getLinesStartingBy();
            if (linesStartingBy != null) {
                printSpace();
                print(SQLReserved.STARTING_BY);

                printSpace();
                linesStartingBy.accept(this);
            }

            SQLCharLiteral terminatedBy = x.getTerminatedBy();
            if (terminatedBy != null) {
                printSpace();
                print(SQLReserved.TERMINATED_BY);

                printSpace();
                terminatedBy.accept(this);
            }

        }

        SQLIntegerLiteral ignoreCount = x.getIgnoreCount();
        if (ignoreCount != null) {
            println();
            print(SQLReserved.IGNORE);

            printSpace();
            ignoreCount.accept(this);

            SQLReserved ignoreType = x.getIgnoreType();
            if (ignoreType != null) {
                printSpace();
                print(ignoreType);
            }
        }

        if (x.getColNameOrUserVar().size() > 0) {
            println();
            printAccept(x.getColNameOrUserVar(), ", ");
        }

        List<SQLSetOptionExpr> setElements = x.getSetElements();
        if (setElements.size() > 0) {
            println();
            print(SQLReserved.SET);

            printSpace();
            printAccept(setElements, ", ");
        }
        return false;
    }

    @Override
    public boolean visit(SQLLoadXmlStatement x) {
        print(SQLReserved.LOAD_DATA);
        return false;
    }

    @Override
    public boolean visit(SQLInsertStatement x) {
        SQLWithClause withClause = x.getWithClause();
        if (withClause != null) {
            print(withClause);
            println();
        }

        print(SQLReserved.INSERT);

        SQLInsertStatement.SQLPriority priority = x.getPriority();
        if (priority != null) {
            printSpaceAfterValue(priority.name);
        }

        if (x.isIgnore()) {
            printSpaceAfterValue(SQLReserved.IGNORE);
        }

        if (x.isInto()) {
            printSpaceAfterValue(SQLReserved.INTO);
        }


        printSpaceAfterAccept(x.getTableReference());

        printSpaceAfterAccept(x.getColumns(), ", ", true);

        printlnAndAccept(x.getValuesClause());

        printlnAndAccept(x.getReturningClause());

        printlnAndAccept(x.getErrorLoggingClause());

        return false;
    }


    @Override
    public boolean visit(SQLMultiInsertStatement x) {
        print(SQLReserved.INSERT);
        printSpaceAfterValue(x.getOption());

        printIndentLnAndAccept(x.getExpr());

        printlnAndAccept(x.getSubQuery());

        return false;
    }

    @Override
    public boolean visit(SQLMultiInsertStatement.SQLInsertIntoClause x) {
        printlnAndAccept(x.getItems());
        return false;
    }

    @Override
    public boolean visit(SQLMultiInsertStatement.SQLConditionalInsertIntoClause x) {
        printlnAndAccept(x.getWhenClauses());

        List<SQLMultiInsertStatement.SQLInsertIntoClauseItem> elseItems = x.getElseItems();
        if (elseItems != null
                && elseItems.size() > 0) {
            println();
            print(SQLReserved.ELSE);
            printIndentAndLnAndAccept(x.getElseItems());
        }

        return false;
    }

    @Override
    public boolean visit(SQLMultiInsertStatement.SQLInsertIntoClauseItem x) {
        print(SQLReserved.INTO);
        printSpaceAfterAccept(x.getTableReference());
        printSpaceAfterAccept(x.getColumns(), ", ", true);

        printlnAndAccept(x.getValuesClause());
        printlnAndAccept(x.getErrorLoggingClause());
        return false;
    }

    @Override
    public boolean visit(SQLMultiInsertStatement.SQLConditionalInsertWhenClause x) {
        print(SQLReserved.WHEN);
        printSpaceAfterAccept(x.getCondition());

        printSpaceAfterValue(SQLReserved.THEN);

        printIndentAndLnAndAccept(x.getThenItems());

        return false;
    }



    @Override
    public boolean visit(SQLRenameTableStatement x) {
        print(SQLReserved.RENAME_TABLE);

        printSpaceAfterAccept(x.getItems(), ", ");
        return false;
    }

    @Override
    public boolean visit(SQLRenameTableStatement.Item x) {
        x.getOldName().accept(this);

        printSpaceAfterValue(SQLReserved.TO);
        printSpace();
        x.getNewName().accept(this);
        return false;
    }

    @Override
    public boolean visit(SQLTruncateTableStatement x) {
        print(SQLReserved.TRUNCATE);
        if (x.isTable()) {
            printSpaceAfterValue(SQLReserved.TABLE);
        }
        if (x.isOnly()) {
            printSpaceAfterValue(SQLReserved.ONLY);
        }
        printSpaceAfterAccept(x.getNames(), ", ");

        printSpaceAfterValue(x.getMaterializedViewLog());
        printSpaceAfterValue(x.getStorage());
        printSpaceAfterValue(x.getCascade());

        return false;
    }

    @Override
    public boolean visit(SQLReplaceStatement x) {
        print(SQLReserved.REPLACE);
        printSpaceAfterValue(x.getPriority());

        if (x.isInto()) {
            printSpaceAfterValue(SQLReserved.INTO);
        }

        printSpaceAfterAccept(x.getTableReference());

        printSpaceAndLnAndAccept(x.getColumns(), ",", true);

        printlnAndAccept(x.getValuesClause());

        return false;
    }

    @Override
    public boolean visit(SQLDoStatement x) {
        print(SQLReserved.DO);
        printSpaceAfterAccept(x.getItems(), ", ");
        return false;
    }

    @Override
    public boolean visit(SQLHandlerOpenStatement x) {
        print(SQLReserved.HANDLER);
        printSpaceAfterAccept(x.getName());
        printSpaceAfterValue(SQLReserved.OPEN);

        if (x.isAs()) {
            printSpaceAfterValue(SQLReserved.AS);
        }

        printSpaceAfterAccept(x.getAlias());
        return false;
    }

    @Override
    public boolean visit(SQLHandlerReadStatement x) {
        print(SQLReserved.HANDLER);
        printSpaceAfterAccept(x.getName());

        printSpaceAfterValue(SQLReserved.READ);
        return false;
    }

    @Override
    public boolean visit(SQLHandlerCloseStatement x) {
        print(SQLReserved.HANDLER);
        printSpaceAfterAccept(x.getName());
        printSpaceAfterValue(SQLReserved.CLOSE);
        return false;
    }

    @Override
    public boolean visit(SQLDeleteStatement x) {

        SQLWithClause withClause = x.getWithClause();
        if (withClause != null) {
            print(withClause);
            println();
        }

        print(SQLReserved.DELETE);

        if (x.isLowPriority()) {
            printSpaceAfterValue(SQLReserved.LOW_PRIORITY);
        }

        if (x.isQuick()) {
            printSpaceAfterValue(SQLReserved.QUICK);
        }

        if (x.isIgnore()) {
            printSpaceAfterValue(SQLReserved.IGNORE);
        }

        if (x.isFrom()) {
            printSpaceAfterValue(SQLReserved.FROM);
        }

        printSpaceAfterAccept(x.getTableReference());

        printlnAndAccept(x.getUsingClause());

        printlnAndAccept(x.getWhereClause());

        printlnAndAccept(x.getOrderByClause());

        printlnAndAccept(x.getLimitClause());

        printlnAndAccept(x.getReturningClause());

        printlnAndAccept(x.getErrorLoggingClause());

        return false;
    }

    @Override
    public boolean visit(SQLDeleteStatement.SQLUsingClause x) {
        print(SQLReserved.USING);
        printSpaceAfterAccept(x.getTableReference());
        return false;
    }

    @Override
    public boolean visit(SQLUpdateStatement x) {
        SQLWithClause withClause = x.getWithClause();
        if (withClause != null) {
            print(withClause);
            println();
        }

        print(SQLReserved.UPDATE);

        if (x.isLowPriority()) {
            printSpaceAfterValue(SQLReserved.LOW_PRIORITY);
        }

        if (x.isIgnore()) {
            printSpaceAfterValue(SQLReserved.IGNORE);
        }

        printSpaceAfterAccept(x.getTableReference());

        printlnAndAccept(x.getUpdateSetClause());

        printlnAndAccept(x.getWhereClause());

        printlnAndAccept(x.getOrderByClause());

        printlnAndAccept(x.getLimitClause());

        printlnAndAccept(x.getReturningClause());

        printlnAndAccept(x.getErrorLoggingClause());

        return false;
    }

    @Override
    public boolean visit(SQLSelectStatement x) {
        x.getQuery().accept(this);
        return false;
    }

    @Override
    public boolean visit(SQLSelectIntoStatement x) {
        print(SQLReserved.SELECT);

        SQLSetQuantifier setQuantifier = x.getSetQuantifier();
        if (setQuantifier != null) {
            printSpaceAfterValue(setQuantifier.name);
        }

        printSpace();
        printSelectItems(x.getSelectItems());

        println();
        if (x.isBulkCollect()) {
            print(SQLReserved.BULK_COLLECT);
            printSpace();
        }
        print(SQLReserved.INTO);
        printSpaceAfterAccept(x.getSelectTargetItems(), ", ");


        printlnAndAccept(x.getFromClause());

        printlnAndAccept(x.getWhereClause());

        printlnAndAccept(x.getGroupByClause());

        printlnAndAccept(x.getOrderByClause());

        printlnAndAccept(x.getLimitClause());


        return false;
    }

    @Override
    public boolean visit(SQLLockTableStatement x) {
        print(SQLReserved.LOCK);

        printSpaceAfterValue(x.getType());

        if (x.isOnly()) {
            printSpaceAfterValue(SQLReserved.ONLY);
        }
        printSpaceAfterAccept(x.getItems(), ", ");


        this.incrementIndent();

        SQLLockTableStatement.SQLLockMode lockMode = x.getLockMode();
        if (lockMode != null) {
            printlnAfterValue(SQLReserved.IN);
            printSpaceAfterValue(lockMode);
            printSpaceAfterValue(SQLReserved.MODE);
        }

        printlnAndAccept(x.getOption());
        this.decrementIndent();

        return false;
    }

    @Override
    public boolean visit(SQLLockTableStatement.SQLLockTableItem x) {
        print(x.getName());
        if (x.isAs()) {
            printSpaceAfterValue(SQLReserved.AS);
        }
        printSpaceAfterAccept(x.getAlias());
        printSpaceAfterAccept(x.getPartitionClause());
        printSpaceAfterValue(x.getLockType());
        return false;
    }

    @Override
    public boolean visit(SQLUnLockTablesStatement x) {
        print(SQLReserved.UNLOCK);
        printSpaceAfterValue(SQLReserved.TABLES);
        return false;
    }

    @Override
    public boolean visit(SQLContinueStatement x) {
        print(SQLReserved.CONTINUE);
        printSpaceAfterAccept(x.getName());

        SQLExpr condition = x.getCondition();
        if (condition != null) {
            printSpaceAfterValue(SQLReserved.WHEN);
            printSpaceAfterAccept(condition);
        }

        return false;
    }

    @Override
    public boolean visit(SQLExitStatement x) {
        print(SQLReserved.EXIT);
        printSpaceAfterAccept(x.getName());

        SQLExpr condition = x.getCondition();
        if (condition != null) {
            printSpaceAfterValue(SQLReserved.WHEN);
            printSpaceAfterAccept(condition);
        }
        return false;
    }

    @Override
    public boolean visit(SQLFetchStatement x) {
        print(SQLReserved.FETCH);
        printSpaceAfterAccept(x.getDirection());
        printSpaceAfterValue(x.getFromType());
        printSpaceAfterAccept(x.getName());

        if (x.isBulkCollect()) {
            printSpaceAfterValue(SQLReserved.BULK_COLLECT);
        }

        printSpaceAfterValue(SQLReserved.INTO);
        printSpaceAfterAccept(x.getIntoItems(), ", ");

        SQLExpr limitExpr = x.getLimitExpr();
        if (limitExpr != null) {
            printSpaceAfterValue(SQLReserved.LIMIT);
            printSpaceAfterAccept(limitExpr);
        }
        return false;
    }

    @Override
    public boolean visit(SQLGotoStatement x) {
        print(SQLReserved.GOTO);
        printSpaceAfterAccept(x.getName());
        return false;
    }

    @Override
    public boolean visit(SQLMergeStatement x) {

        print(SQLReserved.MERGE_INTO);

        printSpace();
        x.getInto().accept(this);

        println();
        x.getUsing().accept(this);

        println();
        x.getOnCondition().accept(this);

        println();
        printlnAndAccept(x.getMergeWhenClauses());

        return false;
    }

    @Override
    public boolean visit(SQLPipeRowStatement x) {
        print(SQLReserved.PIPE_ROW);
        printlnAfterValue(SQLReserved.LEFT_PAREN);
        print(x.getRow());
        print(SQLReserved.RIGHT_PAREN);
        return false;
    }

    @Override
    public boolean visit(SQLRaiseStatement x) {
        print(SQLReserved.RAISE);
        printSpaceAfterAccept(x.getException());
        return false;
    }

    @Override
    public boolean visit(SQLIfStatement x) {
        print(SQLReserved.IF);
        printSpaceAfterAccept(x.getCondition());

        printSpaceAfterValue(SQLReserved.THEN);
        incrementIndent();
        println();
        printlnAndAccept(x.getStatements());
        decrementIndent();


        List<SQLIfStatement.SQLElseIf> elseIfs = x.getElseIfs();
        if (elseIfs.size() > 0) {
            println();
            printlnAndAccept(elseIfs);
        }

        List<SQLObject> elseStatements = x.getElseStatements();
        if (elseStatements != null
                && elseStatements.size() > 0) {
            printlnAfterValue(SQLReserved.ELSE);
            printIndentAndLnAndAccept(elseStatements);
        }

        println();
        print(SQLReserved.END_IF);
        return false;
    }

    @Override
    public boolean visit(SQLIfStatement.SQLElseIf x) {
        print(SQLReserved.ELSEIF);
        printSpaceAfterAccept(x.getCondition());

        printSpaceAfterValue(SQLReserved.THEN);
        incrementIndent();
        println();
        printlnAndAccept(x.getStatements());
        decrementIndent();

        return false;
    }

    @Override
    public boolean visit(SQLIterateStatement x) {
        return false;
    }

    @Override
    public boolean visit(SQLLeaveStatement x) {
        return false;
    }

    @Override
    public boolean visit(SQLLoopStatement x) {
        SQLName beginLabel = x.getBeginLabel();
        if (beginLabel != null) {
            print(beginLabel);
            printSpace();
        }

        print(SQLReserved.LOOP);

        printIndentAndLnAndAccept(x.getStatements());

        println();
        print(SQLReserved.END_LOOP);
        printSpaceAfterAccept(x.getEndLabel());

        return false;
    }

    @Override
    public boolean visit(SQLNullStatement x) {
        print(SQLReserved.NULL);
        return false;
    }

    @Override
    public boolean visit(SQLOpenForStatement x) {
        print(SQLReserved.OPEN);
        printSpaceAfterAccept(x.getOpen());
        printSpaceAfterValue(SQLReserved.FOR);

        SQLExpr forExpr = x.getFor_();
        if (forExpr instanceof SQLSelectQueryExpr) {
            printIndentLnAndAccept(forExpr);
        } else {
            printSpaceAfterAccept(forExpr);
        }

        printSpaceAfterAccept(x.getUsingClause());
        return false;
    }

    @Override
    public boolean visit(SQLRepeatStatement x) {

        return false;
    }

    @Override
    public boolean visit(SQLReturnStatement x) {
        print(SQLReserved.RETURN);
        printSpaceAfterAccept(x.getExpr());
        return false;
    }


    @Override
    public boolean visit(SQLCaseStatement x) {
        print(SQLReserved.CASE);
        printSpaceAfterAccept(x.getSelector());

        this.incrementIndent();
        println();
        printlnAndAccept(x.getWhenItems());
        printlnAndAccept(x.getElseClause());

        this.decrementIndent();
        println();
        print(SQLReserved.END_CASE);
        printSpaceAfterAccept(x.getEndLabel());

        return false;
    }

    @Override
    public boolean visit(SQLCaseStatement.SQLCaseStatementWhenItem x) {
        print(SQLReserved.WHEN);
        printSpaceAfterAccept(x.getExpr());

        printSpaceAfterValue(SQLReserved.THEN);
        printIndentLnAndAccept(x.getStatement());
        return false;
    }

    @Override
    public boolean visit(SQLCaseStatement.SQLCaseStatementElseClause x) {
        print(SQLReserved.ELSE);
        printIndentAndLnAndAccept(x.getStatements());
        return false;
    }

    @Override
    public boolean visit(SQLForAllStatement x) {
        print(SQLReserved.FORALL);
        printSpaceAfterAccept(x.getIndex());
        printSpaceAfterValue(SQLReserved.IN);

        printSpaceAfterAccept(x.getBoundsClause());

        if (x.isBeforeSaveExceptions()) {
            printSpaceAfterValue(SQLReserved.SAVE_EXCEPTIONS);
        }

        printIndentLnAndAccept(x.getStatement());

        if (x.isBeforeSaveExceptions()) {
            printSpaceAfterValue(SQLReserved.SAVE_EXCEPTIONS);
        }

        return false;
    }

    @Override
    public boolean visit(SQLForLoopStatement x) {
        print(SQLReserved.FOR);
        printSpaceAfterAccept(x.getIndex());
        printSpaceAfterValue(SQLReserved.IN);

        if (x.isReverse()) {
            printSpaceAfterValue(SQLReserved.REVERSE);
        }

        printSpaceAfterAccept(x.getInExpr());

        printSpaceAfterValue(SQLReserved.LOOP);

        printIndentAndLnAndAccept(x.getStatements());

        printlnAfterValue(SQLReserved.END_LOOP);
        printSpaceAfterAccept(x.getEndLabel());

        return false;
    }

    @Override
    public boolean visit(SQLWhileLoopStatement x) {
        print(SQLReserved.WHILE);
        printSpaceAfterAccept(x.getCondition());
        printSpaceAfterValue(SQLReserved.LOOP);

        printIndentAndLnAndAccept(x.getStatements());

        printlnAfterValue(SQLReserved.END_LOOP);
        printSpaceAfterAccept(x.getEndLabel());
        return false;
    }

    @Override
    public boolean visit(SQLWhileStatement x) {
        print(SQLReserved.WHILE);
        printSpaceAfterAccept(x.getCondition());
        printSpaceAfterValue(SQLReserved.DO);

        printIndentAndLnAndAccept(x.getStatements());

        printlnAfterValue(SQLReserved.END_WHILE);
        printSpaceAfterAccept(x.getEndLabel());
        return false;
    }

    @Override
    public boolean visit(SQLExplainStatement x) {
        print(SQLReserved.EXPLAIN);


        return false;
    }

    @Override
    public boolean visit(SQLUseStatement x) {
        print(SQLReserved.USE);
        printSpaceAfterAccept(x.getDatabase());
        return false;
    }


    @Override
    public boolean visit(SQLCommitStatement x) {
        print(SQLReserved.COMMIT);
        printSpaceAfterValue(x.getAction());
        printSpaceAfterAccept(x.getOptions(), " ");
        return false;
    }

    @Override
    public boolean visit(SQLRollbackStatement x) {
        print(SQLReserved.ROLLBACK);
        printSpaceAfterValue(x.action);
        printSpaceAfterAccept(x.getOptions(), " ");
        return false;
    }

    @Override
    public boolean visit(SQLSavepointStatement x) {
        print(SQLReserved.SAVEPOINT);
        printSpaceAfterAccept(x.getName());
        return false;
    }

    @Override
    public boolean visit(SQLReleaseSavepointStatement x) {
        return false;
    }

    @Override
    public boolean visit(SQLSetConstraintStatement x) {
        print(SQLReserved.SET_CONSTRAINT);
        printSpaceAfterAccept(x.getItems(), ", ");
        printSpaceAfterValue(x.getOption());
        return false;
    }

    @Override
    public boolean visit(SQLSetConstraintsStatement x) {
        print(SQLReserved.SET_CONSTRAINTS);
        printSpaceAfterAccept(x.getItems(), ", ");
        printSpaceAfterValue(x.getOption());
        return false;
    }

    @Override
    public boolean visit(ISQLSetConstraintsStatement.SQLAllItem x) {
        print(SQLReserved.ALL);
        return false;
    }

    @Override
    public boolean visit(SQLSetTransactionStatement x) {
        print(SQLReserved.SET);
        printSpaceAfterValue(x.getScope());
        printSpaceAfterValue(SQLReserved.TRANSACTION);
        printSpaceAfterAccept(x.getOptions(), ", ");
        return false;
    }

    // ------------------------- Data Types Start ----------------------------------------
    @Override
    public boolean visit(SQLAnyDataDataType x) {
        print(SQLReserved.AnyData);
        return false;
    }

    @Override
    public boolean visit(SQLAnyDataSetDataType x) {
        print(SQLReserved.AnyDataSet);
        return false;
    }

    @Override
    public boolean visit(SQLAnyTypeDataType x) {
        print(SQLReserved.AnyType);
        return false;
    }

    @Override
    public boolean visit(SQLBoolDataType x) {
        print(SQLReserved.BOOL);
        return false;
    }

    @Override
    public boolean visit(SQLBooleanDataType x) {
        print(SQLReserved.BOOLEAN);
        return false;
    }

    @Override
    public boolean visit(SQLArrayDataType x) {
        print(SQLReserved.BOOLEAN);
        return false;
    }

    @Override
    public boolean visit(SQLAssocArrayDataType x) {
        print(SQLReserved.TABLE_OF);

        printSpace();
        x.getOfDataType().accept(this);

        if (x.isNotNull()) {
            printSpaceAfterValue(SQLReserved.NOT_NULL);
        }

        printSpaceAfterValue(SQLReserved.INDEX_BY);

        printSpace();
        x.getIndexByDataType().accept(this);
        return false;
    }

    @Override
    public boolean visit(SQLMultisetDataType x) {
        x.getDataType().accept(this);

        printSpace();
        print(SQLReserved.MULTISET);
        return false;
    }

    @Override
    public boolean visit(SQLNestedTableDataType x) {
        print(SQLReserved.TABLE);
        printSpaceAfterValue(SQLReserved.OF);
        if (x.isParen()) {
            printSpaceAfterValue(SQLReserved.LEFT_PAREN);
        }
        printSpaceAfterAccept(x.getDataType());
        if (x.isNotNull()) {
            printSpaceAfterValue(SQLReserved.NOT_NULL);
        }

        if (x.isParen()) {
            printSpaceAfterValue(SQLReserved.LEFT_PAREN);
        }
        return false;
    }

    @Override
    public boolean visit(SQLVarrayDataType x) {
        print(SQLReserved.VARRAY);

        print(SQLReserved.LEFT_PAREN);
        x.getSize().accept(this);
        print(SQLReserved.RIGHT_PAREN);

        printSpaceAfterValue(SQLReserved.OF);

        if (x.isParen()) {
            printSpaceAfterValue(SQLReserved.LEFT_PAREN);
        }

        printSpaceAfterAccept(x.getDataType());
        if (x.isNotNull()) {
            printSpaceAfterValue(SQLReserved.NOT_NULL);
        }

        if (x.isParen()) {
            printSpaceAfterValue(SQLReserved.LEFT_PAREN);
        }
        return false;
    }

    @Override
    public boolean visit(SQLVaryingArrayDataType x) {
        print(SQLReserved.VARYING_ARRAY);

        print(SQLReserved.LEFT_PAREN);
        x.getSize().accept(this);
        print(SQLReserved.RIGHT_PAREN);

        printSpaceAfterValue(SQLReserved.OF);

        if (x.isParen()) {
            printSpaceAfterValue(SQLReserved.LEFT_PAREN);
        }
        printSpaceAfterAccept(x.getDataType());

        if (x.isNotNull()) {
            printSpaceAfterValue(SQLReserved.NOT_NULL);
        }

        if (x.isParen()) {
            printSpaceAfterValue(SQLReserved.RIGHT_PAREN);
        }
        return false;
    }

    @Override
    public boolean visit(SQLDateDataType x) {
        print(SQLReserved.DATE);
        return false;
    }

    @Override
    public boolean visit(SQLTimeDataType x) {
        print(SQLReserved.TIME);
        printAccept(x.getArguments(), ", ");
        printSpaceAfterValue(x.getWithTimeZoneType());
        return false;
    }

    @Override
    public boolean visit(SQLDateTimeDataType x) {
        print(SQLReserved.DATETIME);
        printAccept(x.getArguments(), ", ", true);

        printSpaceAfterValue(x.getWithTimeZoneType());
        return false;
    }

    @Override
    public boolean visit(SQLTimestampDataType x) {
        print(SQLReserved.TIMESTAMP);
        printAccept(x.getArguments(), ", ", true);

        printSpaceAfterValue(x.getWithTimeZoneType());

        return false;
    }

    @Override
    public boolean visit(SQLYearDataType x) {
        print(SQLReserved.YEAR);
        printAccept(x.getArguments(), ", ", true);
        return false;
    }

    @Override
    public boolean visit(SQLIntervalDataType x) {
        x.getNameExpr().accept(this);

        List<SQLExpr> arguments = x.getArguments();
        if (arguments.size() > 0) {
            printSpace();
            printAccept(x.getArguments(), ", ", true);
        }

        SQLIntervalUnit toUnit = x.getToUnit();
        if (toUnit != null) {
            printSpaceAfterValue(SQLReserved.TO);
            printSpaceAfterValue(toUnit);

            List<SQLExpr> toPrecisions = x.getToPrecisions();
            if (toPrecisions != null
                    && toPrecisions.size() > 0) {
                printSpace();
                printAccept(toPrecisions, ", ", true);
            }
        }


        return false;
    }

    @Override
    public boolean visit(SQLJsonDataType x) {
        print(SQLReserved.JSON);
        return false;
    }

    @Override
    public boolean visit(SQLORDAudioDataType x) {
        print(SQLReserved.ORDAudio);
        return false;
    }

    @Override
    public boolean visit(SQLORDDicomDataType x) {
        print(SQLReserved.ORDDicom);
        return false;
    }

    @Override
    public boolean visit(SQLORDDocDataType x) {
        print(SQLReserved.ORDDoc);
        return false;
    }

    @Override
    public boolean visit(SQLORDImageDataType x) {
        print(SQLReserved.ORDImage);
        return false;
    }

    @Override
    public boolean visit(SQLORDVideoDataType x) {
        print(SQLReserved.ORDVideo);
        return false;
    }

    @Override
    public boolean visit(SQLSIAverageColorDataType x) {
        print(SQLReserved.SI_AverageColor);
        return false;
    }

    @Override
    public boolean visit(SQLSIColorDataType x) {
        print(SQLReserved.SI_Color);
        return false;
    }

    @Override
    public boolean visit(SQLSIColorHistogramDataType x) {
        print(SQLReserved.SI_ColorHistogram);
        return false;
    }

    @Override
    public boolean visit(SQLSIFeatureListDataType x) {
        print(SQLReserved.SI_FeatureList);
        return false;
    }

    @Override
    public boolean visit(SQLSIPositionalColorDataType x) {
        print(SQLReserved.SI_PositionalColor);
        return false;
    }

    @Override
    public boolean visit(SQLSIStillImageDataType x) {
        print(SQLReserved.SI_StillImage);
        return false;
    }

    @Override
    public boolean visit(SQLSITextureDataType x) {
        print(SQLReserved.SI_Texture);
        return false;
    }

    @Override
    public boolean visit(SQLMoneyDataType x) {
        print(SQLReserved.MONEY);
        return false;
    }


    @Override
    public boolean visit(SQLBigintDataType x) {
        print(SQLReserved.BIGINT);
        printAccept(x.getArguments(), ", ", true);
        printNumericDataType(x);
        return false;
    }

    @Override
    public boolean visit(SQLBinaryDoubleDataType x) {
        print(SQLReserved.BINARY_DOUBLE);
        return false;
    }

    @Override
    public boolean visit(SQLBinaryFloatDataType x) {
        print(SQLReserved.BINARY_FLOAT);
        return false;
    }

    @Override
    public boolean visit(SQLBinaryIntegerDataType x) {
        print(SQLReserved.BINARY_INTEGER);
        printAccept(x.getArguments(), ", ", true);
        return false;
    }

    @Override
    public boolean visit(SQLBitDataType x) {
        print(SQLReserved.BIT);
        printAccept(x.getArguments(), ", ", true);
        return false;
    }

    @Override
    public boolean visit(SQLDecDataType x) {
        print(SQLReserved.DEC);
        printAccept(x.getArguments(), ", ", true);
        printNumericDataType(x);
        return false;
    }

    @Override
    public boolean visit(SQLDecimalDataType x) {
        print(SQLReserved.DECIMAL);
        printAccept(x.getArguments(), ", ", true);
        printNumericDataType(x);
        return false;
    }

    @Override
    public boolean visit(SQLDoubleDataType x) {
        print(SQLReserved.DOUBLE);
        printAccept(x.getArguments(), ", ", true);
        printNumericDataType(x);
        return false;
    }

    @Override
    public boolean visit(SQLDoublePrecisionDataType x) {
        print(SQLReserved.DOUBLE_PRECISION);
        printAccept(x.getArguments(), ", ", true);
        printNumericDataType(x);
        return false;
    }

    @Override
    public boolean visit(SQLFixedDataType x) {
        print(SQLReserved.FIXED);
        printAccept(x.getArguments(), ", ", true);
        printNumericDataType(x);
        return false;
    }

    @Override
    public boolean visit(SQLFloatDataType x) {
        print(SQLReserved.FLOAT);
        printAccept(x.getArguments(), ", ", true);
        printNumericDataType(x);
        return false;
    }

    @Override
    public boolean visit(SQLInt1DataType x) {
        print(SQLReserved.INT1);
        printAccept(x.getArguments(), ", ", true);
        printNumericDataType(x);
        return false;
    }

    @Override
    public boolean visit(SQLInt2DataType x) {
        print(SQLReserved.INT2);
        printAccept(x.getArguments(), ", ", true);
        printNumericDataType(x);
        return false;
    }

    @Override
    public boolean visit(SQLInt3DataType x) {
        print(SQLReserved.INT3);
        printAccept(x.getArguments(), ", ", true);
        printNumericDataType(x);
        return false;
    }

    @Override
    public boolean visit(SQLInt4DataType x) {
        print(SQLReserved.INT4);
        printAccept(x.getArguments(), ", ", true);
        printNumericDataType(x);
        return false;
    }

    @Override
    public boolean visit(SQLInt8DataType x) {
        print(SQLReserved.INT8);
        printAccept(x.getArguments(), ", ", true);
        printNumericDataType(x);
        return false;
    }

    @Override
    public boolean visit(SQLIntDataType x) {
        print(SQLReserved.INT);
        printAccept(x.getArguments(), ", ", true);
        printNumericDataType(x);
        return false;
    }

    @Override
    public boolean visit(SQLIntegerDataType x) {
        print(SQLReserved.INTEGER);
        printAccept(x.getArguments(), ", ", true);
        printNumericDataType(x);
        return false;
    }

    @Override
    public boolean visit(SQLMediumintDataType x) {
        print(SQLReserved.MEDIUMINT);
        printAccept(x.getArguments(), ", ", true);
        printNumericDataType(x);
        return false;
    }

    @Override
    public boolean visit(SQLNaturalDataType x) {
        print(SQLReserved.NATURAL);
        return false;
    }

    @Override
    public boolean visit(SQLNaturalnDataType x) {
        print(SQLReserved.NATURALN);
        return false;
    }

    @Override
    public boolean visit(SQLPositiveDataType x) {
        print(SQLReserved.POSITIVE);
        return false;
    }

    @Override
    public boolean visit(SQLPositivenDataType x) {
        print(SQLReserved.POSITIVEN);
        return false;
    }

    @Override
    public boolean visit(SQLSigntypeDataType x) {
        print(SQLReserved.SIGNTYPE);
        return false;
    }

    @Override
    public boolean visit(SQLSimpleDoubleDataType x) {
        print(SQLReserved.SIMPLE_DOUBLE);
        return false;
    }

    @Override
    public boolean visit(SQLSimpleFloatDataType x) {
        print(SQLReserved.SIMPLE_FLOAT);
        return false;
    }

    @Override
    public boolean visit(SQLSimpleIntegerDataType x) {
        print(SQLReserved.SIMPLE_INTEGER);
        return false;
    }

    @Override
    public boolean visit(SQLNumberDataType x) {
        print(SQLReserved.NUMBER);
        printAccept(x.getArguments(), ", ", true);
        printNumericDataType(x);
        return false;
    }

    @Override
    public boolean visit(SQLNumericDataType x) {
        print(SQLReserved.NUMERIC);
        printAccept(x.getArguments(), ", ", true);
        printNumericDataType(x);
        return false;
    }

    @Override
    public boolean visit(SQLPlsIntegerDataType x) {
        print(SQLReserved.PLS_INTEGER);
        return false;
    }

    @Override
    public boolean visit(SQLRealDataType x) {
        print(SQLReserved.REAL);
        printAccept(x.getArguments(), ", ", true);
        printNumericDataType(x);
        return false;
    }

    @Override
    public boolean visit(SQLSmallintDataType x) {
        print(SQLReserved.SMALLINT);
        printAccept(x.getArguments(), ", ", true);
        printNumericDataType(x);
        return false;
    }

    @Override
    public boolean visit(SQLTinyintDataType x) {
        print(SQLReserved.TINYINT);
        printAccept(x.getArguments(), ", ", true);
        printNumericDataType(x);
        return false;
    }

    public void printNumericDataType(ISQLNumericDataType x) {
        if (x.isUnsigned()) {
            printSpaceAfterValue(SQLReserved.UNSIGNED);
        }

        if (x.isZerofill()) {
            printSpaceAfterValue(SQLReserved.ZEROFILL);
        }
    }

    @Override
    public boolean visit(SQLObjectDataType x) {
        print(SQLReserved.OBJECT);
        return false;
    }

    @Override
    public boolean visit(SQLRecordDataType x) {
        return false;
    }

    @Override
    public boolean visit(SQLRefCursorDataType x) {
        return false;
    }

    @Override
    public boolean visit(SQLRefDataType x) {
        print(SQLReserved.REF);
        printSpaceAfterAccept(x.getArguments(), ", ", x.isParen());

        SQLName tableName = x.getTableName();
        if (tableName != null) {
            printSpaceAfterValue(SQLReserved.SCOPE);
            printSpaceAfterAccept(tableName);
        }

        return false;
    }

    @Override
    public boolean visit(SQLRowDataTypeImpl x) {
        print(SQLReserved.ROW);
        return false;
    }

    @Override
    public boolean visit(SQLGeometryCollectionDataType x) {
        print(SQLReserved.GEOMETRYCOLLECTION);
        return false;
    }

    @Override
    public boolean visit(SQLGeometryDataType x) {
        print(SQLReserved.GEOMETRY);
        return false;
    }

    @Override
    public boolean visit(SQLLineStringDataType x) {
        print(SQLReserved.LINESTRING);
        return false;
    }

    @Override
    public boolean visit(SQLMultiLineStringDataType x) {
        print(SQLReserved.MULTILINESTRING);
        return false;
    }

    @Override
    public boolean visit(SQLMultiPointDataType x) {
        print(SQLReserved.MULTIPOINT);
        return false;
    }

    @Override
    public boolean visit(SQLMultiPolygonDataType x) {
        print(SQLReserved.MULTIPOLYGON);
        return false;
    }

    @Override
    public boolean visit(SQLPointDataType x) {
        print(SQLReserved.POINT);
        return false;
    }

    @Override
    public boolean visit(SQLPolygonDataType x) {
        print(SQLReserved.POLYGON);
        return false;
    }

    @Override
    public boolean visit(SQLSDOGeometryDataType x) {
        print(SQLReserved.SDO_Geometry);
        return false;
    }

    @Override
    public boolean visit(SQLSDOGeoRasterDataType x) {
        print(SQLReserved.SDO_GeoRaster);
        return false;
    }

    @Override
    public boolean visit(SQLSDOTopoGeometryDataType x) {
        print(SQLReserved.SDO_Topo_Geometry);
        return false;
    }

    @Override
    public boolean visit(SQLBFileDataType x) {
        print(SQLReserved.BFILE);
        printAccept(x.getArguments(), ", ", true);
        return false;
    }

    @Override
    public boolean visit(SQLBinaryDataType x) {
        print(SQLReserved.BINARY);
        printAccept(x.getArguments(), ", ", true);
        return false;
    }

    @Override
    public boolean visit(SQLBlobDataType x) {
        print(SQLReserved.BLOB);
        printAccept(x.getArguments(), ", ", true);
        return false;
    }

    @Override
    public boolean visit(SQLCharacterDataType x) {
        print(SQLReserved.CHARACTER);
        printAccept(x.getArguments(), ", ", true);
        return false;
    }

    @Override
    public boolean visit(SQLCharacterLargeObjectDataType x) {
        print(SQLReserved.CHARACTER_LARGE_OBJECT);
        printAccept(x.getArguments(), ", ", true);
        return false;
    }

    @Override
    public boolean visit(SQLCharacterVaryingDataType x) {
        print(SQLReserved.CHARACTER_VARYING);
        printAccept(x.getArguments(), ", ", true);
        return false;
    }

    @Override
    public boolean visit(SQLCharDataType x) {
        print(SQLReserved.CHAR);

        List<SQLExpr> arguments = x.getArguments();
        if (arguments.size() > 0) {
            print(SQLReserved.LEFT_PAREN);
            printAccept(arguments, ", ");

            SQLCharSizeUnit sizeUnit = x.getCharSizeUnit();
            if (sizeUnit != null) {
                printSpaceAfterValue(sizeUnit.name);
            }
            print(SQLReserved.RIGHT_PAREN);
        }

        printSpaceAfterAccept(x.getCharacterSetExpr());
        printSpaceAfterAccept(x.getCollateClause());

        return false;
    }

    @Override
    public boolean visit(SQLCharLargeObjectDataType x) {
        print(SQLReserved.CHAR_LARGE_OBJECT);
        printAccept(x.getArguments(), ", ", true);
        return false;
    }

    @Override
    public boolean visit(SQLCharVaryingDataType x) {
        print(SQLReserved.CHAR_VARYING);
        printAccept(x.getArguments(), ", ", true);
        return false;
    }

    @Override
    public boolean visit(SQLClobDataType x) {
        print(SQLReserved.CLOB);
        printAccept(x.getArguments(), ", ", true);
        return false;
    }

    @Override
    public boolean visit(SQLLongBlobDataType x) {
        print(SQLReserved.LONGBLOB);
        return false;
    }

    @Override
    public boolean visit(SQLLongDataType x) {
        print(SQLReserved.LONG);
        return false;
    }

    @Override
    public boolean visit(SQLLongRawDataType x) {
        print(SQLReserved.LONG_RAW);
        return false;
    }

    @Override
    public boolean visit(SQLLongTextDataType x) {
        print(SQLReserved.LONGTEXT);
        printSpaceAfterAccept(x.getCharacterSetExpr());
        printSpaceAfterAccept(x.getCollateClause());
        return false;
    }

    @Override
    public boolean visit(SQLMediumBlobDataType x) {
        print(SQLReserved.MEDIUMBLOB);
        return false;
    }

    @Override
    public boolean visit(SQLMediumTextDataType x) {
        print(SQLReserved.MEDIUMTEXT);
        printSpaceAfterAccept(x.getCharacterSetExpr());
        printSpaceAfterAccept(x.getCollateClause());
        return false;
    }

    @Override
    public boolean visit(SQLNationalCharacterDataType x) {
        print(SQLReserved.NATIONAL_CHARACTER);
        return false;
    }

    @Override
    public boolean visit(SQLNationalCharacterLargeObjectDataType x) {
        print(SQLReserved.NATIONAL_CHARACTER_LARGE_OBJECT);
        printAccept(x.getArguments(), ", ", true);
        return false;
    }

    @Override
    public boolean visit(SQLNationalCharacterVaryingDataType x) {
        print(SQLReserved.NATIONAL_CHARACTER_VARYING);
        printAccept(x.getArguments(), ", ", true);
        return false;
    }

    @Override
    public boolean visit(SQLNationalCharDataType x) {
        print(SQLReserved.NATIONAL_CHAR);
        printAccept(x.getArguments(), ", ", true);
        printSpaceAfterAccept(x.getCharacterSetExpr());
        printSpaceAfterAccept(x.getCollateClause());
        return false;
    }

    @Override
    public boolean visit(SQLNationalCharVaryingDataType x) {
        print(SQLReserved.NATIONAL_CHAR_VARYING);
        printAccept(x.getArguments(), ", ", true);
        return false;
    }

    @Override
    public boolean visit(SQLNationalVarcharDataType x) {
        print(SQLReserved.NATIONAL_VARCHAR);
        printAccept(x.getArguments(), ", ", true);
        printSpaceAfterAccept(x.getCharacterSetExpr());
        printSpaceAfterAccept(x.getCollateClause());
        return false;
    }

    @Override
    public boolean visit(SQLNCharDataType x) {
        print(SQLReserved.NCHAR);
        printAccept(x.getArguments(), ", ", true);
        return false;
    }

    @Override
    public boolean visit(SQLNCharLargeObjectDataType x) {
        print(SQLReserved.NCHAR_LARGE_OBJECT);
        printAccept(x.getArguments(), ", ", true);
        return false;
    }

    @Override
    public boolean visit(SQLNCharVaryingDataType x) {
        print(SQLReserved.NCHAR_VARYING);
        printAccept(x.getArguments(), ", ", true);
        return false;
    }

    @Override
    public boolean visit(SQLNClobDataType x) {
        print(SQLReserved.NCLOB);
        printAccept(x.getArguments(), ", ", true);
        return false;
    }

    @Override
    public boolean visit(SQLNVarcharDataType x) {
        print(SQLReserved.NVARCHAR);
        printAccept(x.getArguments(), ", ", true);
        return false;
    }

    @Override
    public boolean visit(SQLNVarchar2DataType x) {
        print(SQLReserved.NVARCHAR2);
        printAccept(x.getArguments(), ", ", true);
        return false;
    }

    @Override
    public boolean visit(SQLRawDataType x) {
        print(SQLReserved.RAW);
        printAccept(x.getArguments(), ", ", true);
        return false;
    }

    @Override
    public boolean visit(SQLRowIdDataType x) {
        print(SQLReserved.ROWID);
        printAccept(x.getArguments(), ", ", true);
        return false;
    }

    @Override
    public boolean visit(SQLSetDataType x) {
        print(SQLReserved.SET);
        printAccept(x.getArguments(), ", ", true);
        printSpaceAfterAccept(x.getCharacterSetExpr());
        printSpaceAfterAccept(x.getCollateClause());
        return false;
    }

    @Override
    public boolean visit(SQLStringDataType x) {
        print(SQLReserved.STRING);
        printAccept(x.getArguments(), ", ", true);
        return false;
    }

    @Override
    public boolean visit(SQLTextDataType x) {
        print(SQLReserved.TEXT);
        printAccept(x.getArguments(), ", ", true);
        printSpaceAfterAccept(x.getCharacterSetExpr());
        printSpaceAfterAccept(x.getCollateClause());
        return false;
    }

    @Override
    public boolean visit(SQLTinyBlobDataType x) {
        print(SQLReserved.TINYBLOB);
        return false;
    }

    @Override
    public boolean visit(SQLTinyTextDataType x) {
        print(SQLReserved.TINYTEXT);
        printSpaceAfterAccept(x.getCharacterSetExpr());
        printSpaceAfterAccept(x.getCollateClause());
        return false;
    }

    @Override
    public boolean visit(SQLURowIdDataType x) {
        print(SQLReserved.UROWID);
        printAccept(x.getArguments(), ", ", true);
        return false;
    }

    @Override
    public boolean visit(SQLVarBinaryDataType x) {
        print(SQLReserved.VARBINARY);
        printAccept(x.getArguments(), ", ", true);
        return false;
    }

    @Override
    public boolean visit(SQLVarchar2DataType x) {
        print(SQLReserved.VARCHAR2);

        List<SQLExpr> arguments = x.getArguments();
        if (arguments.size() > 0) {
            print(SQLReserved.LEFT_PAREN);
            printAccept(arguments, ", ");

            SQLCharSizeUnit sizeUnit = x.getCharSizeUnit();
            if (sizeUnit != null) {
                printSpaceAfterValue(sizeUnit.name);
            }
            print(SQLReserved.RIGHT_PAREN);
        }

        return false;
    }

    @Override
    public boolean visit(SQLVarcharDataType x) {
        print(SQLReserved.VARCHAR);
        printAccept(x.getArguments(), ", ", true);
        printSpaceAfterAccept(x.getCharacterSetExpr());
        printSpaceAfterAccept(x.getCollateClause());
        return false;
    }


    @Override
    public boolean visit(SQLObjectSubDataType x) {
        print(SQLReserved.UNDER);
        printSpaceAfterAccept(x.getSuperDataType());
        return false;
    }

    @Override
    public boolean visit(SQLUriTypeDataType x) {
        print(SQLReserved.URIType);
        printAccept(x.getArguments(), ", ", true);
        return false;
    }

    @Override
    public boolean visit(SQLXmlTypeDataType x) {
        print(SQLReserved.XMLTYPE);
        printAccept(x.getArguments(), ", ", true);
        return false;
    }

    @Override
    public boolean visit(SQLEnumDataType x) {
        print(SQLReserved.ENUM);
        printAccept(x.getArguments(), ", ", true);
        printSpaceAfterAccept(x.getCharacterSetExpr());
        printSpaceAfterAccept(x.getCollateClause());
        return false;
    }

    @Override
    public boolean visit(SQLPercentRowTypeDataType x) {
        x.getNameExpr().accept(this);
        print(SQLReserved.PERCENT_ROWTYPE);
        return false;
    }

    @Override
    public boolean visit(SQLTableDataType x) {
        print(SQLReserved.TABLE);
        printSpaceAfterAccept(x.getArguments(), ", ", x.isParen());
        return false;
    }

    @Override
    public boolean visit(SQLPercentTypeDataType x) {
        x.getNameExpr().accept(this);
        print(SQLReserved.PERCENT_TYPE);
        return false;
    }

    @Override
    public boolean visit(SQLSelfAsResultDataType x) {
        print(SQLReserved.SELF_AS_RESULT);
        return false;
    }

    @Override
    public boolean visit(SQLDataTypeImpl x) {
        x.getNameExpr().accept(this);

        if (x.isParen()) {
            print(SQLReserved.LEFT_PAREN);
        }
        printAccept(x.getArguments(), ", ");
        if (x.isParen()) {
            print(SQLReserved.RIGHT_PAREN);
        }
        return false;
    }


    // ------------------------- Data Types End ----------------------------------------

    // ------------------------- identifier Start ----------------------------------------

    @Override
    public boolean visit(SQLIdentifierImpl x) {
        print(x.getName());
        return false;
    }

    @Override
    public boolean visit(SQLAllColumnExpr x) {
        print(SQLReserved.ASTERISK);
        return false;
    }

    @Override
    public boolean visit(SQLDoubleQuoteIdentifier x) {
        print('"');
        print(x.getName());
        print('"');
        return false;
    }

    @Override
    public boolean visit(SQLReverseQuoteIdentifier x) {
        print('`');
        print(x.getName());
        print('`');
        return false;
    }

    @Override
    public boolean visit(SQLPropertyExpr x) {

        SQLExpr owner = x.getOwner();
        owner.accept(this);

        print('.');

        SQLName name = x.getNameExpr();
        name.accept(this);

        return false;
    }

    @Override
    public boolean visit(SQLDBLinkExpr x) {

        x.getNameExpr().accept(this);
        print("@");
        x.getDbLink().accept(this);

        return false;
    }

    // ------------------------- identifier End ----------------------------------------

    // ------------------------- Literal Start ----------------------------------------


    @Override
    public boolean visit(SQLDateLiteral x) {
        print(SQLReserved.DATE);

        printSpace();
        x.getValue().accept(this);
        return false;
    }

    @Override
    public boolean visit(SQLTimeLiteral x) {
        print(SQLReserved.TIME);

        printSpace();
        x.getValue().accept(this);
        return false;
    }

    @Override
    public boolean visit(SQLTimestampLiteral x) {
        print(SQLReserved.TIMESTAMP);
        printSpaceAfterAccept(x.getValue());
        return false;
    }

    @Override
    public boolean visit(SQLIntervalLiteral x) {
        print(SQLReserved.INTERVAL);

        printSpaceAfterAccept(x.getValue());

        SQLIntervalUnit unit = x.getUnit();
        if (unit != null) {
            printSpaceAfterValue(unit.name);
            printAccept(x.getPrecisions(), ", ", true);
        }

        SQLIntervalUnit toUnit = x.getToUnit();
        if (toUnit != null) {
            printSpaceAfterValue(SQLReserved.TO);
            printSpaceAfterValue(toUnit.name);
            printAccept(x.getToPrecisions(), ", ", true);
        }

        return false;
    }


    @Override
    public boolean visit(SQLBinaryDoubleLiteral x) {
        print(x.getValue());
        print(SQLReserved.D);
        return false;
    }

    @Override
    public boolean visit(SQLBinaryFloatLiteral x) {
        print(x.getValue());
        print(SQLReserved.F);
        return false;
    }

    @Override
    public boolean visit(SQLIntegerLiteral x) {
        print(x.getSource());
        return false;
    }

    @Override
    public boolean visit(SQLNumberLiteral x) {
        print(x.getSource());
        return false;
    }

    @Override
    public boolean visit(SQLCharLiteral x) {
        print('\'');
        print(x.getValue());
        print('\'');

        return false;
    }

    @Override
    public boolean visit(SQLNCharLiteral x) {
        print(SQLReserved.N);
        print('\'');
        print(x.getValue());
        print('\'');

        return false;
    }

    @Override
    public boolean visit(SQLQCharLiteral x) {
        print(SQLReserved.Q);
        print('\'');
        print(x.getValue());
        print("'");
        return false;
    }

    @Override
    public boolean visit(SQLNQCharLiteral x) {
        print(SQLReserved.NQ);
        print('\'');
        print(x.getValue());
        print('\'');
        return false;
    }

    @Override
    public boolean visit(SQLUCharLiteral x) {
        print("U\'");
        print(x.getValue());
        print('\'');

        return false;
    }

    @Override
    public boolean visit(SQLAllLiteral x) {
        print(SQLReserved.ALL);
        return false;
    }

    @Override
    public boolean visit(SQLAnyLiteral x) {
        print(SQLReserved.ANY);
        return false;
    }

    @Override
    public boolean visit(SQLBitLiteral x) {

        SQLBitLiteral.SQLPrefix prefix = x.getPrefix();
        print(x.getPrefix());

        if (prefix == SQLBitLiteral.SQLPrefix.B) {
            print(SQLReserved.QUOTE);
        }
        print(x.getValue());
        if (prefix == SQLBitLiteral.SQLPrefix.B) {
            print(SQLReserved.QUOTE);
        }
        return false;
    }

    @Override
    public boolean visit(SQLBooleanLiteral x) {
        Boolean value = x.value;
        if (value == null) {
            print(SQLReserved.UNKNOWN);
            return false;
        }

        if (value) {
            print(SQLReserved.TRUE);
        } else {
            print(SQLReserved.FALSE);
        }

        return false;
    }

    @Override
    public boolean visit(SQLHexadecimalLiteral x) {
        SQLHexadecimalLiteral.SQLPrefix prefix = x.getPrefix();
        print(prefix);

        if (prefix == SQLHexadecimalLiteral.SQLPrefix.X) {
            print(SQLReserved.QUOTE);
        }
        print(x.getValue());
        if (prefix == SQLHexadecimalLiteral.SQLPrefix.X) {
            print(SQLReserved.QUOTE);
        }
        return false;
    }

    @Override
    public boolean visit(SQLMaxValueLiteral x) {
        print(SQLReserved.MAXVALUE);
        return false;
    }

    @Override
    public boolean visit(SQLMinValueLiteral x) {
        print(SQLReserved.MINVALUE);
        return false;
    }

    @Override
    public boolean visit(SQLNoneLiteral x) {
        print(SQLReserved.NONE);
        return false;
    }

    @Override
    public boolean visit(SQLNullExpr x) {
        print(SQLReserved.NULL);
        return false;
    }

    @Override
    public boolean visit(SQLUnLimitedLiteral x) {
        print(SQLReserved.UNLIMITED);
        return false;
    }

    // ------------------------- Literal End ----------------------------------------


    // ------------------------- Pseudo Column Start ----------------------------------------

    @Override
    public boolean visit(SQLColumnValueExpr x) {
        print(SQLReserved.COLUMN_VALUE);
        return false;
    }

    @Override
    public boolean visit(SQLConnectByIsCycleExpr x) {
        print(SQLReserved.CONNECT_BY_ISCYCLE);
        return false;
    }

    @Override
    public boolean visit(SQLConnectByIsLeafExpr x) {
        print(SQLReserved.CONNECT_BY_ISLEAF);
        return false;
    }

    @Override
    public boolean visit(SQLLevelExpr x) {
        print(SQLReserved.LEVEL);
        return false;
    }

    @Override
    public boolean visit(SQLObjectIdExpr x) {
        print(SQLReserved.OBJECT_ID);
        return false;
    }

    @Override
    public boolean visit(SQLObjectValueExpr x) {
        print(SQLReserved.OBJECT_VALUE);
        return false;
    }

    @Override
    public boolean visit(SQLOraRowScnExpr x) {
        print(SQLReserved.ORA_ROWSCN);
        return false;
    }

    @Override
    public boolean visit(SQLRowIdExpr x) {
        print(SQLReserved.ROWID);
        return false;
    }

    @Override
    public boolean visit(SQLRowNumExpr x) {
        print(SQLReserved.ROWNUM);
        return false;
    }

    @Override
    public boolean visit(SQLSequenceExpr x) {
        x.getSequence().accept(this);
        print(SQLReserved.PERIOD);
        print(x.getName().name);
        return false;
    }

    @Override
    public boolean visit(SQLVersionsEndScnExpr x) {
        print(SQLReserved.VERSIONS_ENDSCN);
        return false;
    }

    @Override
    public boolean visit(SQLVersionsEndTimeExpr x) {
        print(SQLReserved.VERSIONS_ENDTIME);
        return false;
    }

    @Override
    public boolean visit(SQLVersionsOperationExpr x) {
        print(SQLReserved.VERSIONS_OPERATION);
        return false;
    }

    @Override
    public boolean visit(SQLVersionsStartScnExpr x) {
        print(SQLReserved.VERSIONS_STARTSCN);
        return false;
    }

    @Override
    public boolean visit(SQLVersionsStartTimeExpr x) {
        print(SQLReserved.VERSIONS_STARTTIME);
        return false;
    }

    @Override
    public boolean visit(SQLVersionsXidExpr x) {
        print(SQLReserved.VERSIONS_XID);
        return false;
    }

    @Override
    public boolean visit(SQLXmlDataExpr x) {
        print(SQLReserved.XMLDATA);
        return false;
    }

    // ------------------------- Pseudo Column End ----------------------------------------


    // ------------------------- Comment Start ----------------------------------------

    // ------------------------- Comment End ----------------------------------------

    // ------------------------- Hint Start ----------------------------------------

    @Override
    public boolean visit(SQLUseIndexHint x) {
        print(SQLReserved.USE);
        printSpaceAfterValue(SQLReserved.INDEX);

        AbstractSQLIndexHint.SQLForType forType = x.getForType();
        if (forType != null) {
            printSpaceAfterValue(SQLReserved.FOR);
            printSpaceAfterValue(forType);
        }

        printSpaceAndLnAndAccept(x.getNames(), ",", true);

        return false;
    }

    @Override
    public boolean visit(SQLUseKeyHint x) {
        print(SQLReserved.USE);
        printSpaceAfterValue(SQLReserved.KEY);

        AbstractSQLIndexHint.SQLForType forType = x.getForType();
        if (forType != null) {
            printSpaceAfterValue(SQLReserved.FOR);
            printSpaceAfterValue(forType);
        }

        printSpaceAndLnAndAccept(x.getNames(), ",", true);

        return false;
    }

    @Override
    public boolean visit(SQLIgnoreIndexHint x) {
        print(SQLReserved.IGNORE);
        printSpaceAfterValue(SQLReserved.INDEX);

        AbstractSQLIndexHint.SQLForType forType = x.getForType();
        if (forType != null) {
            printSpaceAfterValue(SQLReserved.FOR);
            printSpaceAfterValue(forType);
        }

        printSpaceAndLnAndAccept(x.getNames(), ",", true);
        return false;
    }

    @Override
    public boolean visit(SQLIgnoreKeyHint x) {
        print(SQLReserved.IGNORE);
        printSpaceAfterValue(SQLReserved.KEY);

        AbstractSQLIndexHint.SQLForType forType = x.getForType();
        if (forType != null) {
            printSpaceAfterValue(SQLReserved.FOR);
            printSpaceAfterValue(forType);
        }

        printSpaceAndLnAndAccept(x.getNames(), ",", true);
        return false;
    }

    @Override
    public boolean visit(SQLForceIndexHint x) {
        print(SQLReserved.FORCE);
        printSpaceAfterValue(SQLReserved.INDEX);

        AbstractSQLIndexHint.SQLForType forType = x.getForType();
        if (forType != null) {
            printSpaceAfterValue(SQLReserved.FOR);
            printSpaceAfterValue(forType);
        }

        printSpaceAndLnAndAccept(x.getNames(), ",", true);

        return false;
    }

    @Override
    public boolean visit(SQLForceKeyHint x) {
        print(SQLReserved.FORCE);
        printSpaceAfterValue(SQLReserved.KEY);

        AbstractSQLIndexHint.SQLForType forType = x.getForType();
        if (forType != null) {
            printSpaceAfterValue(SQLReserved.FOR);
            printSpaceAfterValue(forType);
        }

        printSpaceAndLnAndAccept(x.getNames(), ",", true);
        return false;
    }


    // ------------------------- Hint End ----------------------------------------


    // ------------------------- Operators Start ----------------------------------------

    @Override
    public boolean visit(SQLBinaryOperatorExpr x) {
        boolean paren = x.isParen();
        if (paren) {
            print(SQLReserved.LEFT_PAREN);
        }

        print(x.getLeft());

        printSpaceAfterValue(x.getOperator());

        printSpaceAfterAccept(x.getRight());

        if (paren) {
            print(SQLReserved.RIGHT_PAREN);
        }

        return false;
    }

    @Override
    public boolean visit(SQLBinaryOperatorGroupExpr x) {
        for (int i = 0; i < x.getItems().size(); i++) {
            if (i != 0) {
                printSpace();
                print(x.getOperator().name);
                printSpace();
            }
            print(x.getItems().get(i));
        }
        return false;
    }

    @Override
    public boolean visit(SQLUnaryOperatorExpr x) {

        if (x.isParen()) {
            print(SQLReserved.LEFT_PAREN);
        }

        print(x.getOperator().name);

        SQLExpr operand = x.getOperand();

        switch (x.getOperator()) {
            case PRIOR:
            case CONNECT_BY_ROOT:
            case COLLATE:
            case BINARY:
                printSpace();
            default:
                break;
        }

        operand.accept(this);

        if (x.isParen()) {
            print(SQLReserved.RIGHT_PAREN);
        }
        return false;
    }

    // ------------------------- Operators Start ----------------------------------------


    // ------------------------- Expressions Start ----------------------------------------


    @Override
    public boolean visit(SQLAllClause x) {
        print(SQLReserved.ALL);
        printSpaceAfterAccept(x.getExpr());
        return false;
    }

    @Override
    public boolean visit(SQLAnyClause x) {
        print(SQLReserved.ANY);
        printSpaceAfterAccept(x.getExpr());
        return false;
    }

    @Override
    public boolean visit(SQLCallArgumentExpr x) {
        x.getName().accept(this);
        printSpaceAfterValue(SQLReserved.EQUALS_GREATER_THAN_OP);
        printSpaceAfterAccept(x.getValue());
        return false;
    }

    @Override
    public boolean visit(SQLArrayExpr x) {
        x.getName().accept(this);
        print(SQLReserved.LEFT_BRACKET);
        printAccept(x.getArguments(), ", ");
        print(SQLReserved.RIGHT_BRACKET);
        return false;
    }

    @Override
    public boolean visit(SQLAssignmentExpr x) {
        print(x.getColumn());
        printSpaceAfterValue(SQLReserved.EQUALS_OP);
        printSpaceAfterAccept(x.getValue());
        return false;
    }

    @Override
    public boolean visit(SQLAttributeDefinition x) {
        print(x.getName());
        printSpaceAfterAccept(x.getDataType());

        printSpaceAfterAccept(x.getDefaultExpr());

        printSpaceAfterAccept(x.getCollate());

        SQLExpr externalName = x.getExternalName();
        if (externalName != null) {
            printSpaceAfterValue(SQLReserved.EXTERNAL_NAME);
            printSpaceAfterAccept(externalName);
        }

        return false;
    }

    @Override
    public boolean visit(SQLRegexpCondition x) {
        x.getExpr().accept(this);

        if (x.isNot()) {
            printSpaceAfterValue(SQLReserved.NOT);
        }
        printSpaceAfterValue(SQLReserved.REGEXP);
        printSpaceAfterAccept(x.getPattern());
        return false;
    }

    @Override
    public boolean visit(SQLRlikeCondition x) {
        x.getExpr().accept(this);
        printSpaceAfterValue(SQLReserved.RLIKE);
        printSpaceAfterAccept(x.getPattern());
        return false;
    }

    @Override
    public boolean visit(SQLSoundsLikeCondition x) {
        print(x.getExpr());
        printSpaceAfterValue(SQLReserved.SOUNDS_LIKE);
        printSpaceAfterAccept(x.getPattern());
        return false;
    }

    @Override
    public boolean visit(SQLReturningClause x) {
        print(x.getReturning().name);
        printSpaceAfterAccept(x.getReturningItems(), ", ");
        return false;
    }

    @Override
    public boolean visit(SQLReturningIntoClause x) {
        print(x.getReturning().name);
        printSpaceAfterAccept(x.getReturningItems(), ", ");

        if (x.isBulkCollect()) {
            printSpaceAfterValue(SQLReserved.BULK_COLLECT);
        }

        printSpaceAfterValue(SQLReserved.INTO);
        printSpaceAfterAccept(x.getIntoItems(), ", ");
        return false;
    }

    @Override
    public boolean visit(SQLRowExpr x) {
        print(SQLReserved.ROW);
        printSpaceAfterAccept(x.getItems(), ", ", true);
        return false;
    }

    @Override
    public boolean visit(SQLScopeClause x) {
        print(SQLReserved.SCOPE);
        printSpaceAfterAccept(x.getName());
        return false;
    }

    @Override
    public boolean visit(SQLCaseExpr x) {
        print(SQLReserved.CASE);

        printSpaceAfterAccept(x.getExpr());

        this.incrementIndent();
        println();
        printlnAndAccept(x.getWhenItems());

        SQLCaseExpr.SQLCaseExprElseClause elseClause = x.getElseClause();
        if (elseClause != null) {
            printlnAndAccept(elseClause);
        }

        this.decrementIndent();
        println();

        print(SQLReserved.END);
        return false;
    }

    @Override
    public boolean visit(SQLCaseExpr.SQLCaseExprWhenItem x) {
        print(SQLReserved.WHEN);
        printSpaceAfterAccept(x.getWhen());

        printSpaceAfterValue(SQLReserved.THEN);
        printSpaceAfterAccept(x.getThen());
        return false;
    }

    @Override
    public boolean visit(SQLCaseExpr.SQLCaseExprElseClause x) {
        print(SQLReserved.ELSE);
        printSpaceAfterAccept(x.getExpr());
        return false;
    }

    @Override
    public boolean visit(SQLCursorExpr x) {
        print(SQLReserved.CURSOR);
        print(SQLReserved.LEFT_PAREN);

        this.incrementIndent();
        println();
        x.getSubQuery().accept(this);
        this.decrementIndent();
        println();

        print(SQLReserved.RIGHT_PAREN);

        return false;
    }

    @Override
    public boolean visit(SQLDateTimeAtLocalExpr x) {
        x.getExpr().accept(this);
        printSpaceAfterValue(SQLReserved.AT_LOCAL);
        return false;
    }

    @Override
    public boolean visit(SQLDateTimeAtTimeZoneExpr x) {
        x.getExpr().accept(this);
        printSpaceAfterValue(SQLReserved.AT_TIME_ZONE);
        printSpaceAfterAccept(x.getTimeZone());
        return false;
    }

    @Override
    public boolean visit(SQLIntervalExpr x) {
        print(SQLReserved.LEFT_PAREN);
        print(x.getValue1());
        printSpaceAfterValue(SQLReserved.MINUS_SIGN);
        printSpaceAfterAccept(x.getValue2());
        print(SQLReserved.RIGHT_PAREN);

        printSpaceAfterValue(x.getUnit());
        SQLExpr precision = x.getPrecision();
        if (precision != null) {
            printSpaceAfterValue(SQLReserved.LEFT_PAREN);
            print(precision);
            print(SQLReserved.RIGHT_PAREN);
        }

        printSpaceAfterValue(SQLReserved.TO);
        printSpaceAfterValue(x.getToUnit());
        SQLExpr toPrecision = x.getToPrecision();
        if (toPrecision != null) {
            printSpaceAfterValue(SQLReserved.LEFT_PAREN);
            print(toPrecision);
            print(SQLReserved.RIGHT_PAREN);
        }

        return false;
    }

    @Override
    public boolean visit(SQLDefaultLiteral x) {
        print(SQLReserved.DEFAULT);
        return false;
    }

    @Override
    public boolean visit(SQLExprAsObjectExpr x) {
        x.getExpr().accept(this);

        if (x.isAs()) {
            printSpaceAfterValue(AS);
        }

        printSpace();
        x.getAsObject().accept(this);
        return false;
    }

    @Override
    public boolean visit(SQLExprToExprExpr x) {
        x.getExpr().accept(this);

        printSpaceAfterValue(SQLReserved.TO);

        printSpaceAfterAccept(x.getToExpr());

        return false;
    }

    @Override
    public boolean visit(SQLListExpr x) {
        print(SQLReserved.LEFT_PAREN);
        printAccept(x.getItems(), ", ");
        print(SQLReserved.RIGHT_PAREN);
        return false;
    }

    @Override
    public boolean visit(SQLMultisetExpr x) {
        print(SQLReserved.MULTISET);
        print(SQLReserved.LEFT_PAREN);
        this.incrementIndent();
        println();
        x.getSubQuery().accept(this);
        this.decrementIndent();
        println();
        print(SQLReserved.RIGHT_PAREN);
        return false;
    }

    @Override
    public boolean visit(SQLOuterJoinExpr x) {
        x.getName().accept(this);
        print(SQLReserved.LEFT_PAREN);
        print(SQLReserved.PLUS_SIGN);
        print(SQLReserved.RIGHT_PAREN);
        return false;
    }

    @Override
    public boolean visit(SQLParameterDeclaration x) {
        boolean print = false;
        SQLParameterModel parameterModel = x.getParameterModel();
        if (parameterModel != null) {
            print(parameterModel.name);
            print = true;
        }

        SQLName name = x.getName();
        if (name != null) {
            if (print) {
                printSpace();
            }
            name.accept(this);
            print = true;
        }

        SQLDataType dataType = x.getDataType();
        if (dataType != null) {
            if (print) {
                printSpace();
            }
            dataType.accept(this);
            print = true;
        }

        if (x.isResult()) {
            if (print) {
                printSpace();
            }
            print(SQLReserved.RESULT);
        }

        return false;
    }

    @Override
    public boolean visit(SQLSomeClause x) {
        print(SQLReserved.SOME);
        printSpaceAfterAccept(x.getExpr());
        return false;
    }

    @Override
    public boolean visit(SQLTypeConstructorExpr x) {
        print(SQLReserved.NEW);
        printSpaceAfterAccept(x.getName());
        print(SQLReserved.LEFT_PAREN);
        printAccept(x.getArguments(), ", ");
        print(SQLReserved.RIGHT_PAREN);
        return false;
    }

    @Override
    public boolean visit(SQLParenExpr x) {
        print(SQLReserved.LEFT_PAREN);
        x.getExpr().accept(this);
        print(SQLReserved.RIGHT_PAREN);
        return false;
    }

    @Override
    public boolean visit(SQLPlaceholderExpr x) {
        x.getHostExpr().accept(this);

        if (x.isIndicator()) {
            printSpaceAfterValue(SQLReserved.INDICATOR);
        }

        printSpace();
        x.getIndicatorExpr().accept(this);

        return false;
    }

    @Override
    public boolean visit(SQLRangeExpr x) {
        print(SQLReserved.RANGE);
        printSpaceAfterAccept(x.getLowValue());
        printSpaceAfterValue(SQLReserved.DOUBLE_PERIOD);
        printSpaceAfterAccept(x.getHighValue());

        return false;
    }

    @Override
    public boolean visit(SQLBindVariableExpr x) {
        print(":");
        print(x.getName());
        return false;
    }

    @Override
    public boolean visit(SQLVariableExpr x) {
        print(SQLReserved.QUESTION_MARK);
        return false;
    }

    @Override
    public boolean visit(SQLColonNewVariableRefExpr x) {
        print(SQLReserved.COLON_NEW);
        print(".");
        x.getName().accept(this);
        return false;
    }

    @Override
    public boolean visit(SQLColonOldVariableRefExpr x) {
        print(SQLReserved.COLON_OLD);
        print(".");
        x.getName().accept(this);
        return false;
    }

    @Override
    public boolean visit(SQLNewVariableRefExpr x) {
        print(SQLReserved.NEW);
        print(".");
        x.getName().accept(this);
        return false;
    }

    @Override
    public boolean visit(SQLOldVariableRefExpr x) {
        print(SQLReserved.OLD);
        print(".");
        x.getName().accept(this);
        return false;
    }

    @Override
    public boolean visit(SQLVariableDeclaration x) {
        x.getName().accept(this);

        printSpace();
        x.getDataType().accept(this);

        if (x.isNotNull()) {
            printSpaceAfterValue(SQLReserved.NOT_NULL);
        }

        printSpaceAfterAccept(x.getDefaultClause());

        return false;
    }

    @Override
    public boolean visit(SQLUnusableEditionsClause x) {
        boolean print = false;
        SQLExpr unusableBeforeAction = x.getUnusableBeforeAction();
        if (unusableBeforeAction != null) {
            print(SQLReserved.UNUSABLE_BEFORE);
            printSpaceAfterAccept(unusableBeforeAction);
            print = true;
        }

        SQLExpr unusableBeginningWithAction = x.getUnusableBeginningWithAction();
        if (unusableBeginningWithAction != null) {
            if (print) {
                printSpace();
            }
            print(SQLReserved.UNUSABLE_BEGINNING_WITH);
            printSpaceAfterAccept(x.getUnusableBeginningWithAction());
            print = true;
        }

        return false;
    }

    @Override
    public boolean visit(SQLUnusableEditionsClause.SQLUnusableBeforeCurrentEditionAction x) {
        print(SQLReserved.CURRENT_EDITION);
        return false;
    }

    @Override
    public boolean visit(SQLUnusableEditionsClause.SQLUnusableBeforeEditionAction x) {
        print(SQLReserved.EDITION);
        printSpaceAfterAccept(x.getExpr());
        return false;
    }

    @Override
    public boolean visit(SQLUnusableEditionsClause.SQLUnusableBeginningWithCurrentEditionAction x) {
        print(SQLReserved.CURRENT_EDITION);
        return false;
    }

    @Override
    public boolean visit(SQLUnusableEditionsClause.SQLUnusableBeginningWithEditionAction x) {
        print(SQLReserved.EDITION);
        printSpaceAfterAccept(x.getExpr());
        return false;
    }

    @Override
    public boolean visit(SQLUnusableEditionsClause.SQLUnusableBeginningWithNullEditionAction x) {
        print(SQLReserved.NULL_EDITION);
        return false;
    }

    @Override
    public boolean visit(SQLBuildClause x) {
        print(SQLReserved.BUILD);
        printSpaceAfterValue(x.getType().name);
        return false;
    }

    @Override
    public boolean visit(SQLEvaluationEditionClause x) {
        print(SQLReserved.EVALUATE_USING);
        printSpaceAfterAccept(x.getAction());
        return false;
    }

    @Override
    public boolean visit(SQLEvaluationEditionClause.SQLCurrentEditionAction x) {
        print(SQLReserved.CURRENT_EDITION);
        return false;
    }

    @Override
    public boolean visit(SQLEvaluationEditionClause.SQLEditionAction x) {
        print(SQLReserved.EDITION);
        printSpaceAfterAccept(x.getEdition());
        return false;
    }

    @Override
    public boolean visit(SQLEvaluationEditionClause.SQLNullEditionAction x) {
        print(SQLReserved.NULL_EDITION);
        return false;
    }

    @Override
    public boolean visit(SQLTablespaceOptionExpr x) {
        print(SQLReserved.TABLESPACE);
        printSpaceAfterAccept(x.getValue());
        printSpaceAfterValue(x.getStorage());
        return false;
    }

    @Override
    public boolean visit(SQLTableSpaceSetClause x) {
        print(SQLReserved.TABLESPACE_SET);
        printSpaceAfterAccept(x.getTablespace());
        return false;
    }

    @Override
    public boolean visit(SQLEncryptClause x) {
        print(SQLReserved.ENCRYPT);
        printSpaceAfterAccept(x.getEncryptionSpec());
        return false;
    }

    @Override
    public boolean visit(SQLEncryptionSpec x) {

        boolean print = false;

        SQLExpr encrypt = x.getEncrypt();
        if (encrypt != null) {
            print(SQLReserved.USING);
            printSpaceAfterAccept(encrypt);
            print = true;
        }

        SQLExpr password = x.getPassword();
        if (password != null) {
            if (print) {
                printSpace();
            }
            print(SQLReserved.IDENTIFIED_BY);
            printSpaceAfterAccept(password);
            print = true;
        }

        SQLExpr integrity = x.getIntegrity();
        if (integrity != null) {
            if (print) {
                printSpace();
            }
            print(integrity);
            print = true;
        }

        SQLEncryptionSpec.SQLSaltType saltType = x.getSaltType();
        if (saltType != null) {
            if (print) {
                printSpace();
            }
            print(saltType.name);
            print = true;
        }

        return false;
    }

    @Override
    public boolean visit(SQLDecryptClause x) {
        print(SQLReserved.DECRYPT);
        return false;
    }

    @Override
    public boolean visit(SQLStoreInClause x) {
        print(SQLReserved.STORE_IN);
        printSpaceAndLnAndAccept(x.getItems(), ",", true);
        return false;
    }

    @Override
    public boolean visit(SQLOverflowClause x) {
        print(SQLReserved.OVERFLOW);
        printSpaceAfterAccept(x.getExpr());
        return false;
    }

    @Override
    public boolean visit(SQLOverflowStoreInClause x) {
        print(SQLReserved.OVERFLOW_STORE_IN);
        printSpaceAndLnAndAccept(x.getItems(), ",", true);
        return false;
    }

    @Override
    public boolean visit(SQLSubPartitionsetStoreInClause x) {
        print(SQLReserved.SUBPARTITIONSET_STORE_IN);
        printSpaceAndLnAndAccept(x.getItems(), ",", true);
        return false;
    }

    @Override
    public boolean visit(SQLParametersClause x) {
        print(SQLReserved.PARAMETERS);
        printSpaceAfterValue(SQLReserved.LEFT_PAREN);
        print(x.getExpr());
        printSpaceAfterValue(SQLReserved.RIGHT_PAREN);
        return false;
    }

    @Override
    public boolean visit(SQLVarrayStorageAsClause x) {
        print(SQLReserved.VARRAY);
        printSpaceAfterAccept(x.getItem());

        printSpaceAfterValue(SQLReserved.STORE_AS);
        printSpaceAfterValue(x.getFileType());

        printSpaceAfterValue(SQLReserved.LOB);
        printSpaceAfterAccept(x.getLobName());
        return false;
    }


    @Override
    public boolean visit(SQLParallelClause x) {
        print(SQLReserved.PARALLEL);

        SQLExpr value = x.getValue();
        if (value != null) {
            printSpaceAfterAccept(value);
        }

        return false;
    }

    @Override
    public boolean visit(SQLNoParallelClause x) {
        print(SQLReserved.NOPARALLEL);
        return false;
    }


    @Override
    public boolean visit(ISQLSubqueryRestrictionClause.SQLWithCheckOption x) {
        print(SQLReserved.WITH_CHECK_OPTION);

        printSpaceAfterValue(x.getLevels());

        SQLName constraint = x.getConstraint();
        if (constraint != null) {
            printSpaceAfterValue(SQLReserved.CONSTRAINT);
            printSpaceAfterAccept(constraint);
        }

        return false;
    }

    @Override
    public boolean visit(ISQLSubqueryRestrictionClause.SQLWithReadOnly x) {
        print(SQLReserved.WITH_READ_ONLY);
        SQLName constraint = x.getConstraint();
        if (constraint != null) {
            printSpaceAfterValue(SQLReserved.CONSTRAINT);
            printSpaceAfterAccept(constraint);
        }
        return false;
    }

    @Override
    public boolean visit(SQLSubViewClause x) {
        return false;
    }

    @Override
    public boolean visit(ISQLAlterIotClause.SQLCoalesceClause x) {
        return false;
    }

    @Override
    public boolean visit(SQLXmlSchemaSpec x) {
        SQLExpr xmlSchemaUrl = x.getXmlSchemaUrl();
        if (xmlSchemaUrl != null) {
            print(SQLReserved.XMLSCHEMA);
            printSpaceAfterAccept(xmlSchemaUrl);
            println();
        }

        print(SQLReserved.ELEMENT);
        SQLExpr elementXmlSchemaUrl = x.getElementXmlSchemaUrl();
        if (elementXmlSchemaUrl != null) {
            printSpaceAfterAccept(elementXmlSchemaUrl);
            printSpaceAfterValue(SQLReserved.SHARP);
        }

        printSpaceAfterAccept(x.getElement());

        // todo
//        OracleSQLStoreAllVarraysAsType storeAllVarraysAsType = x.getStoreAllVarraysAsType();
//        if (storeAllVarraysAsType != null) {
//            printlnAfterValue(SQLReserved.STORE_ALL_VARRAYS_AS);
//            printSpaceAfterValue(storeAllVarraysAsType);
//        }

        SQLXmlSchemaSpec.SQLAllowType nonschemaType = x.getNonschemaType();
        if (nonschemaType != null) {
            printlnAfterValue(nonschemaType);
            printSpaceAfterValue(SQLReserved.NONSCHEMA);
        }

        SQLXmlSchemaSpec.SQLAllowType anyschemaType = x.getAnyschemaType();
        if (nonschemaType != null) {
            printlnAfterValue(anyschemaType);
            printSpaceAfterValue(SQLReserved.ANYSCHEMA);
        }

        return false;
    }

    @Override
    public boolean visit(ISQLWithObjectIdClause.SQLWithObjectIdClause x) {
        print(SQLReserved.WITH_OBJECT_ID);
        printSpaceAfterAccept(x.getExpr());
        return false;
    }

    @Override
    public boolean visit(ISQLWithObjectIdClause.SQLWithObjectIdentifierClause x) {
        print(SQLReserved.WITH_OBJECT_IDENTIFIER);
        printSpaceAfterAccept(x.getExpr());
        return false;
    }

    @Override
    public boolean visit(SQLLocalVariableExpr x) {
        print(SQLReserved.AT_SIGN);
        print(x.getName());
        return false;
    }

    @Override
    public boolean visit(SQLGlobalVariableExpr x) {
        print(SQLReserved.AT_SIGN_AT_SIGN);
        print(x.getName());
        return false;
    }

    @Override
    public boolean visit(SQLGlobalGlobalVariableExpr x) {
        SQLGlobalGlobalVariableExpr.SQLPrefix prefix = x.getPrefix();
        print(prefix);

        if (prefix == SQLGlobalGlobalVariableExpr.SQLPrefix.AT_SIGN_AT_SIGN_GLOBAL) {
            print(SQLReserved.PERIOD);
        } else {
            printSpace();
        }

        print(x.getName());
        return false;
    }

    @Override
    public boolean visit(SQLSessionGlobalVariableExpr x) {
        SQLSessionGlobalVariableExpr.SQLPrefix prefix = x.getPrefix();
        print(prefix);

        if (prefix == SQLSessionGlobalVariableExpr.SQLPrefix.AT_SIGN_AT_SIGN_SESSION) {
            print(SQLReserved.PERIOD);
        } else {
            printSpace();
        }

        print(x.getName());
        return false;
    }

    @Override
    public boolean visit(SQLPersistGlobalVariableExpr x) {
        SQLPersistGlobalVariableExpr.SQLPrefix prefix = x.getPrefix();
        print(prefix);

        if (prefix == SQLPersistGlobalVariableExpr.SQLPrefix.AT_SIGN_AT_SIGN_PERSIST) {
            print(SQLReserved.PERIOD);
        } else {
            printSpace();
        }

        print(x.getName());
        return false;
    }

    @Override
    public boolean visit(SQLPersistOnlyGlobalVariableExpr x) {
        SQLPersistOnlyGlobalVariableExpr.SQLPrefix prefix = x.getPrefix();
        print(prefix);

        if (prefix == SQLPersistOnlyGlobalVariableExpr.SQLPrefix.AT_SIGN_AT_SIGN_PERSIST_ONLY) {
            print(SQLReserved.PERIOD);
        } else {
            printSpace();
        }

        print(x.getName());
        return false;
    }

    @Override
    public boolean visit(SQLRebuildClause x) {
        print(SQLReserved.REBUILD);
        printSpaceAfterAccept(x.getExpr());
        printSpaceAfterAccept(x.getProperties(), " ");
        return false;
    }

    @Override
    public boolean visit(SQLRebuildClause.SQLPartitionItem x) {
        print(SQLReserved.PARTITION);
        printSpaceAfterAccept(x.getName());
        return false;
    }

    @Override
    public boolean visit(SQLRebuildClause.SQLSubPartitionItem x) {
        print(SQLReserved.SUBPARTITION);
        printSpaceAfterAccept(x.getName());
        return false;
    }

    @Override
    public boolean visit(SQLRebuildClause.SQLReverseItem x) {
        print(SQLReserved.REVERSE);
        return false;
    }

    @Override
    public boolean visit(SQLRebuildClause.SQLNoReverseItem x) {
        print(SQLReserved.NOREVERSE);
        return false;
    }

    // ------------------------- Expressions End ----------------------------------------


    // ------------------------- Conditions Start ----------------------------------------

    @Override
    public boolean visit(SQLBetweenCondition x) {
        x.getExpr().accept(this);

        if (x.isNot()) {
            printSpaceAfterValue(SQLReserved.NOT);
        }

        printSpaceAfterValue(SQLReserved.BETWEEN);
        printSpace();
        x.getBetween().accept(this);

        printSpaceAfterValue(SQLReserved.AND);
        printSpace();
        x.getAnd().accept(this);

        return false;
    }

    @Override
    public boolean visit(SQLExistsCondition x) {
        print(SQLReserved.EXISTS);
        printSpaceAfterValue(SQLReserved.LEFT_PAREN);

        this.incrementIndent();
        println();
        x.getSubQuery().accept(this);
        this.decrementIndent();
        println();

        print(SQLReserved.RIGHT_PAREN);

        return false;
    }

    @Override
    public boolean visit(SQLInCondition x) {
        x.getExpr().accept(this);

        if (x.isNot()) {
            printSpaceAfterValue(SQLReserved.NOT);
        }

        printSpaceAfterValue(SQLReserved.IN);

        printSpace();
        printAccept(x.getValues(), ", ", true);

        return false;
    }

    @Override
    public boolean visit(SQLIsAnyCondition x) {
        SQLExpr column = x.getColumn();
        if (column != null) {
            column.accept(this);

            printSpace();
            print(SQLReserved.IS);
            printSpace();
        }

        print(SQLReserved.ANY);

        return false;
    }

    @Override
    public boolean visit(SQLIsASetCondition x) {
        x.getNestedTable().accept(this);

        printSpaceAfterValue(SQLReserved.IS);

        if (x.isNot()) {
            printSpaceAfterValue(SQLReserved.NOT);
        }

        printSpaceAfterValue(SQLReserved.A);
        printSpaceAfterValue(SQLReserved.SET);

        return false;
    }

    @Override
    public boolean visit(SQLIsBooleanLiteralCondition x) {
        print(x.getExpr());
        printSpaceAfterValue(SQLReserved.IS);
        if (x.isNot()) {
            printSpaceAfterValue(SQLReserved.NOT);
        }
        printSpaceAfterValue(x.getValue());
        return false;
    }

    @Override
    public boolean visit(SQLIsEmptyCondition x) {

        x.getNestedTable().accept(this);

        printSpaceAfterValue(SQLReserved.IS);

        if (x.isNot()) {
            printSpaceAfterValue(SQLReserved.NOT);
        }

        printSpaceAfterValue(SQLReserved.EMPTY);

        return false;
    }

    @Override
    public boolean visit(SQLIsInfiniteCondition x) {
        x.getExpr().accept(this);

        printSpaceAfterValue(SQLReserved.IS);

        if (x.isNot()) {
            printSpaceAfterValue(SQLReserved.NOT);
        }

        printSpaceAfterValue(SQLReserved.INFINITE);
        return false;
    }

    @Override
    public boolean visit(SQLIsJsonCondition x) {
        x.getExpr().accept(this);

        printSpaceAfterValue(SQLReserved.IS);
        if (x.isNot()) {
            printSpaceAfterValue(SQLReserved.NOT);
        }

        printSpaceAfterValue(SQLReserved.JSON);

        if (x.isFormatJson()) {
            printSpaceAfterValue(SQLReserved.FORMAT_JSON);
        }

        SQLReserved option = x.getOption();
        if (option != null) {
            printSpaceAfterValue(option);
        }

        printSpaceAfterValue(x.getUniqueKeys());

        return false;
    }

    @Override
    public boolean visit(SQLIsNanCondition x) {
        x.getExpr().accept(this);

        printSpaceAfterValue(SQLReserved.IS);

        if (x.isNot()) {
            printSpaceAfterValue(SQLReserved.NOT);
        }
        printSpaceAfterValue(SQLReserved.NAN);

        return false;
    }

    @Override
    public boolean visit(SQLIsNullCondition x) {
        print(x.getExpr());

        printSpaceAfterValue(SQLReserved.IS);

        if (x.isNot()) {
            printSpaceAfterValue(SQLReserved.NOT);
        }
        printSpaceAfterValue(SQLReserved.NULL);

        return false;
    }

    @Override
    public boolean visit(SQLIsPresentCondition x) {
        x.getCellReference().accept(this);

        printSpaceAfterValue(SQLReserved.IS);

        printSpaceAfterValue(SQLReserved.PRESENT);
        return false;
    }


    @Override
    public boolean visit(SQLIsOfTypeCondition x) {
        x.getExpr().accept(this);

        printSpaceAfterValue(SQLReserved.IS);
        if (x.isNot()) {
            printSpaceAfterValue(SQLReserved.NOT);
        }

        printSpaceAfterValue(SQLReserved.OF);
        if (x.isType()) {
            printSpaceAfterValue(SQLReserved.TYPE);
        }

        printSpace();
        printAccept(x.getItems(), ", ", true);

        return false;
    }

    @Override
    public boolean visit(SQLIsOfTypeCondition.Item x) {
        if (x.isOnly()) {
            print(SQLReserved.ONLY);
            printSpace();
        }

        x.getName().accept(this);

        return false;
    }

    @Override
    public boolean visit(SQLJsonExistsCondition x) {

        print(SQLReserved.JSON_UNDERLINE_EXISTS);
        print(SQLReserved.LEFT_PAREN);

        x.getExpr().accept(this);
        if (x.isFormatJson()) {
            printSpaceAfterValue(SQLReserved.FORMAT_JSON);
        }
        print(SQLReserved.COMMA);

        printSpace();
        x.getPathExpr().accept(this);

        List<SQLExprAsObjectExpr> jsonPassingClauseItems = x.getJsonPassingClauseItems();
        if (jsonPassingClauseItems.size() > 0) {
            printSpaceAfterValue(SQLReserved.PASSING);

            printSpace();
            printAccept(jsonPassingClauseItems, ", ");
        }

        printSpaceAfterAccept(x.getOnErrorClause());

        print(SQLReserved.RIGHT_PAREN);

        return false;
    }

    @Override
    public boolean visit(SQLLikeCondition x) {
        x.getExpr().accept(this);

        if (x.isNot()) {
            printSpaceAfterValue(SQLReserved.NOT);
        }

        printSpaceAfterValue(x.getOperator().name);

        printSpaceAfterAccept(x.getPattern());

        SQLExpr escape = x.getEscape();
        if (escape != null) {
            printSpaceAfterValue(SQLReserved.ESCAPE);
            printSpaceAfterAccept(x.getEscape());
        }

        return false;
    }

    @Override
    public boolean visit(SQLMemberCondition x) {
        x.getExpr().accept(this);

        if (x.isNot()) {
            printSpaceAfterValue(SQLReserved.NOT);
        }

        printSpaceAfterValue(SQLReserved.MEMBER);

        if (x.isOf()) {
            printSpaceAfterValue(SQLReserved.OF);
        }

        printSpace();
        x.getNestedTable().accept(this);
        return false;
    }

    @Override
    public boolean visit(SQLNotCondition x) {
        print(SQLReserved.NOT);
        printSpaceAfterAccept(x.getCondition());
        return false;
    }

    @Override
    public boolean visit(SQLParenCondition x) {
        print(SQLReserved.LEFT_PAREN);
        x.getCondition().accept(this);
        print(SQLReserved.RIGHT_PAREN);
        return false;
    }

    @Override
    public boolean visit(SQLRegexpLikeCondition x) {
        print(SQLReserved.REGEXP_LIKE);
        printAccept(x.getArguments(), ", ", true);
        return false;
    }

    @Override
    public boolean visit(SQLSubMultisetCondition x) {

        x.getNestedTable1().accept(this);

        if (x.isNot()) {
            printSpaceAfterValue(SQLReserved.NOT);
        }

        printSpaceAfterValue(SQLReserved.SUBMULTISET);

        if (x.isOf()) {
            printSpaceAfterValue(SQLReserved.OF);
        }

        printSpaceAfterAccept(x.getNestedTable2());

        return false;
    }

    @Override
    public boolean visit(SQLDeletingCondition x) {
        print(SQLReserved.DELETING);
        return false;
    }

    @Override
    public boolean visit(SQLInsertingCondition x) {
        print(SQLReserved.INSERTING);
        return false;
    }

    @Override
    public boolean visit(SQLUpdatingCondition x) {
        print(SQLReserved.UPDATING);
        SQLExpr column = x.getColumn();
        if (column != null) {
            print(SQLReserved.LEFT_PAREN);
            column.accept(this);
            print(SQLReserved.RIGHT_PAREN);
        }
        return false;
    }

    @Override
    public boolean visit(SQLFilterCondition x) {
        return false;
    }

    // ------------------------- Conditions Start ----------------------------------------


    // ------------------------- Functions Start ----------------------------------------
    @Override
    public boolean visit(SQLAggregateFunction x) {
        print(x.getName());

        print(SQLReserved.LEFT_PAREN);

        List<SQLExpr> arguments = x.getArguments();
        for (int i = 0; i < arguments.size(); i++) {
            SQLExpr argument = arguments.get(i);

            if (i != 0) {
                print(", ");
            }

            if (i == 0) {
                SQLSetQuantifier setQuantifier = x.getSetQuantifier();
                if (setQuantifier != null) {
                    print(setQuantifier.name);
                    printSpace();
                }
                argument.accept(this);
                if (x.isDeterministic()) {
                    printSpaceAfterValue(SQLReserved.DETERMINISTIC);
                }
                printSpaceAfterAccept(x.getPartitionClause());
                printSpaceAfterAccept(x.getOrderByClause());

                continue;
            }

            argument.accept(this);
        }
        print(SQLReserved.RIGHT_PAREN);

        printSpaceAfterAccept(x.getWithinGroup());
        printSpaceAfterAccept(x.getFilterClause());
        printSpaceAfterAccept(x.getOverClause());

        return false;
    }


    @Override
    public boolean visit(AbstractSQLAggregateFunction.SQLWithinGroupSpecification x) {
        print(SQLReserved.WITHIN_GROUP);
        printSpaceAfterValue(SQLReserved.LEFT_PAREN);
        x.getOrderByClause().accept(this);
        print(SQLReserved.RIGHT_PAREN);
        return false;
    }

    @Override
    public boolean visit(AbstractSQLAggregateFunction.SQLFilterClause x) {
        print(SQLReserved.FILTER);
        print(SQLReserved.LEFT_PAREN);
        x.getWhereClause().accept(this);
        print(SQLReserved.RIGHT_PAREN);
        return false;
    }


    @Override
    public boolean visit(SQLDataMiningFunction x) {
        print(x.getName());
        print(SQLReserved.LEFT_PAREN);
        printAccept(x.getArguments(), ", ");


        printSpaceAfterValue(x.getOrderedByWeight());

        printSpaceAfterAccept(x.getCostMatrixClause());

        printSpaceAfterAccept(x.getMiningAttributeClause());

        AbstractSQLDataMiningFunction.SQLMiningAttributeClause andMiningAttributeClause = x.getAndMiningAttributeClause();
        if (andMiningAttributeClause != null) {
            printSpaceAfterValue(SQLReserved.AND);
            printSpaceAfterAccept(andMiningAttributeClause);
        }

        print(SQLReserved.RIGHT_PAREN);

        printSpaceAfterAccept(x.getOverClause());

        return false;
    }

    @Override
    public boolean visit(AbstractSQLDataMiningFunction.SQLIntoArgumentExpr x) {
        print(SQLReserved.INTO);
        printSpaceAfterAccept(x.getExpr());
        return false;
    }

    @Override
    public boolean visit(AbstractSQLDataMiningFunction.SQLForArgumentExpr x) {
        print(SQLReserved.FOR);
        printSpaceAfterAccept(x.getExpr());
        return false;
    }

    @Override
    public boolean visit(AbstractSQLDataMiningFunction.SQLCostMatrixClause x) {
        print(SQLReserved.COST);
        printSpaceAfterAccept(x.getClassValues(), ", ", true);

        printSpaceAfterValue(SQLReserved.VALUES);
        printSpaceAfterAccept(x.getCostValues(), ", ", true);

        return false;
    }

    @Override
    public boolean visit(AbstractSQLDataMiningFunction.SQLMiningAttributeClause x) {
        print(SQLReserved.USING);
        printSpaceAfterAccept(x.getItems(), ", ");
        return false;
    }

    @Override
    public boolean visit(SQLJsonFunction x) {
        x.getNameExpr().accept(this);
        print(SQLReserved.LEFT_PAREN);
        printAccept(x.getArguments(), ", ");

        printSpaceAfterAccept(x.getOrderByClause());

        printSpaceAfterValue(x.getOnNullClause());

        printSpaceAfterAccept(x.getReturningClause());

        if (x.isStrict()) {
            printSpaceAfterValue(SQLReserved.STRICT);
        }
        if (x.isWithUniqueKeys()) {
            printSpaceAfterValue(SQLReserved.WITH_UNIQUE_KEYS);
        }
        printSpaceAfterValue(x.getWrapperClause());

        printSpaceAfterAccept(x.getOnErrorClause());
        printSpaceAfterAccept(x.getOnEmptyClause());
        printSpaceAfterAccept(x.getJsonColumnsClause());

        print(SQLReserved.RIGHT_PAREN);

        return false;
    }

    @Override
    public boolean visit(AbstractSQLJsonFunction.SQLFormatJsonArgumentExpr x) {
        x.getExpr().accept(this);
        printSpaceAfterValue(SQLReserved.FORMAT_JSON);
        return false;
    }

    @Override
    public boolean visit(AbstractSQLJsonFunction.SQLKeyValueArgumentExpr x) {
        if (x.isKey()) {
            print(SQLReserved.KEY);
            printSpace();
        }

        x.getKeyExpr().accept(this);

        printSpaceAfterValue(SQLReserved.VALUE);
        printSpaceAfterAccept(x.getValueExpr());
        return false;
    }

    @Override
    public boolean visit(AbstractSQLJsonFunction.SQLJsonReturningClause x) {

        boolean print = false;

        SQLDataType returnType = x.getReturnType();
        if (returnType != null) {
            print(SQLReserved.RETURNING);
            printSpaceAfterAccept(returnType);
            print = true;
        }

        if (x.isPretty()) {
            if (print) {
                printSpace();
            }
            print(SQLReserved.PRETTY);
            print = true;
        }
        if (x.isAscii()) {
            if (print) {
                printSpace();
            }
            print(SQLReserved.ASCII);
            print = true;
        }

        return false;
    }

    @Override
    public boolean visit(AbstractSQLJsonFunction.SQLDefaultOnErrorExpr x) {
        print(SQLReserved.DEFAULT);
        printSpaceAfterAccept(x.getLiteral());
        printSpaceAfterValue(SQLReserved.ON_ERROR);
        return false;
    }

    @Override
    public boolean visit(AbstractSQLJsonFunction.SQLDefaultOnEmptyExpr x) {
        print(SQLReserved.DEFAULT);
        printSpaceAfterAccept(x.getLiteral());
        printSpaceAfterValue(SQLReserved.ON_EMPTY);
        return false;
    }

    @Override
    public boolean visit(AbstractSQLJsonFunction.SQLJsonColumnsClause x) {
        print(SQLReserved.COLUMNS);
        printSpaceAfterAccept(x.getColumns(), ", ", true);
        return false;
    }

    @Override
    public boolean visit(AbstractSQLJsonFunction.SQLJsonExistsColumn x) {
        x.getColumn().accept(this);
        printSpaceAfterAccept(x.getDataType());
        printSpaceAfterValue(SQLReserved.EXISTS);

        SQLExpr pathExpr = x.getPathExpr();
        if (pathExpr != null) {
            printSpaceAfterValue(SQLReserved.PATH);
            printSpaceAfterAccept(pathExpr);
        }

        printSpaceAfterAccept(x.getOnErrorClause());
        return false;
    }

    @Override
    public boolean visit(AbstractSQLJsonFunction.SQLJsonQueryColumn x) {
        x.getColumn().accept(this);
        printSpaceAfterAccept(x.getDataType());
        printSpaceAfterValue(SQLReserved.FORMAT_JSON);

        printSpaceAfterValue(x.getWrapperClause());

        SQLExpr pathExpr = x.getPathExpr();
        if (pathExpr != null) {
            printSpaceAfterValue(SQLReserved.PATH);
            printSpaceAfterAccept(pathExpr);
        }

        printSpaceAfterAccept(x.getOnErrorClause());

        return false;
    }

    @Override
    public boolean visit(AbstractSQLJsonFunction.SQLJsonValueColumn x) {
        x.getColumn().accept(this);
        printSpaceAfterAccept(x.getDataType());

        SQLExpr pathExpr = x.getPathExpr();
        if (pathExpr != null) {
            printSpaceAfterValue(SQLReserved.PATH);
            printSpaceAfterAccept(pathExpr);
        }

        printSpaceAfterAccept(x.getOnErrorClause());
        return false;
    }

    @Override
    public boolean visit(AbstractSQLJsonFunction.SQLJsonNestedPathColumn x) {
        print(SQLReserved.NESTED);

        if (x.isPath()) {
            printSpaceAfterValue(SQLReserved.PATH);
        }

        printSpaceAfterAccept(x.getPathExpr());

        printSpaceAfterAccept(x.getJsonColumnsClause());

        return false;
    }

    @Override
    public boolean visit(AbstractSQLJsonFunction.SQLJsonOrdinalityColumn x) {
        x.getColumn().accept(this);
        printSpaceAfterValue(SQLReserved.FOR_ORDINALITY);
        return false;
    }

    @Override
    public boolean visit(SQLCastFunction x) {
        print(x.getName());
        print(SQLReserved.LEFT_PAREN);

        for (int i = 0; i < x.getArguments().size(); i++) {
            SQLExpr argument = x.getArguments().get(i);
            if (i != 0) {
                print(", ");
            }

            if (i == 0) {
                argument.accept(this);
                printSpaceAfterValue(SQLReserved.AS);
                printSpaceAfterAccept(x.getDataType());
                printSpaceAfterAccept(x.getDefaultOnConversionError());
                continue;
            }

            argument.accept(this);
        }
        print(SQLReserved.RIGHT_PAREN);

        return false;
    }

    @Override
    public boolean visit(SQLCharFunction x) {
        print(SQLReserved.CHAR);
        print(SQLReserved.LEFT_PAREN);
        printlnAndAccept(x.getArguments(), ", ");

        SQLCharsetNameType charsetName = x.getCharsetName();
        if (charsetName != null) {
            printSpaceAfterValue(SQLReserved.USING);
            printSpaceAfterValue(charsetName);
        }
        print(SQLReserved.RIGHT_PAREN);
        return false;
    }

    @Override
    public boolean visit(SQLExtractFunction x) {
        print(SQLReserved.EXTRACT);
        print(SQLReserved.LEFT_PAREN);

        print(x.getUnit().name);

        printSpaceAfterValue(SQLReserved.FROM);

        printSpaceAfterAccept(x.getArguments().get(0));

        print(SQLReserved.RIGHT_PAREN);
        return false;
    }

    @Override
    public boolean visit(SQLFirstFunction x) {
        x.getNameExpr().accept(this);
        printSpaceAfterValue(SQLReserved.KEEP);

        printSpaceAfterValue(SQLReserved.LEFT_PAREN);
        print(SQLReserved.DENSE_RANK);
        printSpaceAfterValue(SQLReserved.FIRST);

        printSpaceAfterAccept(x.getOrderByClause());
        print(SQLReserved.RIGHT_PAREN);

        printSpaceAfterAccept(x.getOverClause());
        return false;
    }

    @Override
    public boolean visit(SQLLastFunction x) {
        x.getNameExpr().accept(this);
        printSpaceAfterValue(SQLReserved.KEEP);

        printSpaceAfterValue(SQLReserved.LEFT_PAREN);
        print(SQLReserved.DENSE_RANK);
        printSpaceAfterValue(SQLReserved.LAST);

        printSpaceAfterAccept(x.getOrderByClause());
        print(SQLReserved.RIGHT_PAREN);

        printSpaceAfterAccept(x.getOverClause());
        return false;
    }

    @Override
    public boolean visit(SQLListAggFunction x) {
        print(SQLReserved.LISTAGG);
        print(SQLReserved.LEFT_PAREN);

        List<SQLExpr> arguments = x.getArguments();
        for (int i = 0; i < arguments.size(); i++) {
            SQLExpr argument = arguments.get(i);
            if (i == 0) {
                SQLSetQuantifier setQuantifier = x.getSetQuantifier();
                if (setQuantifier != null) {
                    print(setQuantifier.name);
                    printSpace();
                }
            }

            if (i != 0) {
                print(", ");
            }

            argument.accept(this);
        }

        printSpaceAfterAccept(x.getListAggOverflowClause());
        print(SQLReserved.RIGHT_PAREN);

        printSpaceAfterAccept(x.getWithinGroup());
        printSpaceAfterAccept(x.getOverClause());
        return false;
    }

    @Override
    public boolean visit(SQLListAggFunction.SQLOnOverflowTruncateClause x) {
        print(SQLReserved.ON_OVERFLOW_TRUNCATE);
        printSpaceAfterAccept(x.getIndicator());

        printSpaceAfterValue(x.getWithCount());
        return false;
    }

    @Override
    public boolean visit(SQLCubeTableFunction x) {
        print(x.getName());
        printAccept(x.getArguments(), ", ", true);
        return false;
    }

    @Override
    public boolean visit(SQLCubeTableFunction.SQLArgumentExpr x) {

        return false;
    }

    @Override
    public boolean visit(SQLCubeTableFunction.SQLCubeTableOptionExpr x) {
        return false;
    }

    @Override
    public boolean visit(SQLChrFunction x) {
        print(x.getName());

        print(SQLReserved.LEFT_PAREN);
        printAccept(x.getArguments(), ", ");

        if (x.getUsingType() != null) {
            printSpace();
            print(SQLReserved.USING);

            printSpace();
            print(x.getUsingType());
        }
        print(SQLReserved.RIGHT_PAREN);

        return false;
    }

    @Override
    public boolean visit(SQLCollectionMethodInvocation x) {
        print(x.getCollection());
        print(SQLReserved.PERIOD);
        print(x.getName().name);
        printAccept(x.getArguments(), ", ", true);
        return false;
    }

    @Override
    public boolean visit(SQLConvertUsingFunction x) {
        return false;
    }

    @Override
    public boolean visit(SQLTreatFunction x) {
        print(SQLReserved.TREAT);
        print(SQLReserved.LEFT_PAREN);

        x.getArguments().get(0).accept(this);
        printSpaceAfterValue(SQLReserved.AS);

        if (x.isRef()) {
            printSpaceAfterValue(SQLReserved.REF);
        }

        printSpaceAfterAccept(x.getDataType());

        print(SQLReserved.RIGHT_PAREN);
        return false;
    }

    @Override
    public boolean visit(SQLTrimFunction x) {
        print(SQLReserved.TRIM);
        print(SQLReserved.LEFT_PAREN);

        boolean from = false;
        SQLTrimFunction.SQLTrimSpecification specification = x.getSpecification();
        if (specification != null) {
            from = true;
            print(specification);
            printSpace();
        }

        SQLExpr character = x.getCharacter();
        if (character != null) {
            from = true;
            character.accept(this);
            printSpace();
        }

        if (from) {
            print(SQLReserved.FROM);
        }

        print(SQLReserved.RIGHT_PAREN);

        return false;
    }

    @Override
    public boolean visit(SQLValidateConversionFunction x) {
        print(SQLReserved.VALIDATE_CONVERSION);
        printAccept(x.getArguments(), ", ");
        return false;
    }

    @Override
    public boolean visit(SQLTranslateUsingFunction x) {
        print(x.getName());

        print(SQLReserved.LEFT_PAREN);
        printAccept(x.getArguments(), ", ");

        printSpaceAfterValue(SQLReserved.USING);
        printSpaceAfterValue(x.getUsingType());
        print(SQLReserved.RIGHT_PAREN);
        return false;
    }

    @Override
    public boolean visit(SQLWindowFunction x) {
        x.getNameExpr().accept(this);
        print(SQLReserved.LEFT_PAREN);
        List<SQLExpr> arguments = x.getArguments();
        for (int i = 0; i < arguments.size(); i++) {
            SQLExpr argument = x.getArguments().get(i);
            if (i != 0) {
                print(", ");
            }
            if (i == 0) {
                argument.accept(this);
                AbstractSQLWindowFunction.OracleSQLNullsOption insideNullsOption = x.getInsideNullsOption();
                if (insideNullsOption != null) {
                    printSpaceAfterValue(insideNullsOption.name);
                }
                continue;
            }

            argument.accept(this);

            AbstractSQLWindowFunction.OracleSQLFromOption fromOption = x.getFromOption();
            if (fromOption != null) {
                printSpaceAfterValue(fromOption.name);
            }

            AbstractSQLWindowFunction.OracleSQLNullsOption outsideNullsOption = x.getOutsideNullsOption();
            if (outsideNullsOption != null) {
                printSpaceAfterValue(outsideNullsOption.name);
            }
        }

        print(SQLReserved.RIGHT_PAREN);

        printSpace();
        x.getOverClause().accept(this);
        return false;
    }

    @Override
    public boolean visit(SQLOverClause x) {
        print(SQLReserved.OVER);
        printSpaceAfterValue(SQLReserved.LEFT_PAREN);

        print(x.getExpr());

        print(SQLReserved.RIGHT_PAREN);
        return false;
    }

    @Override
    public boolean visit(SQLOverWindowNameClause x) {
        print(SQLReserved.OVER);
        printSpaceAfterAccept(x.getName());
        return false;
    }

    @Override
    public boolean visit(SQLWindowSpecification x) {
        boolean print = false;

        SQLName name = x.getName();
        if (name != null) {
            name.accept(this);
            print = true;
        }

        SQLPartitionByClause partitionClause = x.getPartitionClause();
        if (partitionClause != null) {
            if (print) {
                printSpace();
            }
            partitionClause.accept(this);
            print = true;
        }

        SQLOrderByClause orderByClause = x.getOrderByClause();
        if (orderByClause != null) {
            if (print) {
                printSpace();
            }
            orderByClause.accept(this);
            print = true;
        }

        SQLWindowFrameClause windowFrameClause = x.getWindowFrameClause();
        if (windowFrameClause != null) {
            if (print) {
                printSpace();
            }
            windowFrameClause.accept(this);
            print = true;
        }

        return false;
    }

    @Override
    public boolean visit(SQLWindowFrameClause x) {
        print(x.getUnit().name);

        printSpaceAfterAccept(x.getExtent());

        printSpaceAfterValue(x.getExclusion());

        return false;
    }

    @Override
    public boolean visit(SQLWindowFrameClause.SQLWindowFrameBetween x) {
        print(SQLReserved.BETWEEN);
        printSpaceAfterAccept(x.getBetween());

        printSpaceAfterValue(SQLReserved.AND);
        printSpaceAfterAccept(x.getAnd());
        return false;
    }

    @Override
    public boolean visit(SQLWindowFrameClause.SQLWindowFramePreceding x) {
        x.getValue().accept(this);

        printSpaceAfterValue(SQLReserved.PRECEDING);
        return false;
    }

    @Override
    public boolean visit(SQLWindowFrameClause.SQLWindowFrameFollowing x) {
        x.getValue().accept(this);

        printSpaceAfterValue(SQLReserved.FOLLOWING);
        return false;
    }


    @Override
    public boolean visit(SQLXmlNameExprArgument x) {
        return false;
    }

    @Override
    public boolean visit(SQLXmlEvalNameExprArgument x) {
        return false;
    }

    @Override
    public boolean visit(SQLXmlPassingClause x) {
        print(SQLReserved.PASSING);

        if (x.isByValue()) {
            printSpaceAfterValue(SQLReserved.BY_VALUE);
        }
        printSpaceAfterAccept(x.getItems(), ", ");
        return false;
    }

    @Override
    public boolean visit(SQLXmlCastFunction x) {
        print(SQLReserved.XMLCAST);
        printAccept(x.getArguments(), ", ", true);
        return false;
    }

    @Override
    public boolean visit(SQLXmlColAttValFunction x) {
        print(SQLReserved.XMLCOLATTVAL);
        printAccept(x.getArguments(), ", ", true);
        return false;
    }


    @Override
    public boolean visit(SQLXmlElementFunction x) {
        print(SQLReserved.XMLELEMENT);
        print(SQLReserved.LEFT_PAREN);

        SQLReserved entityEscaping = x.getEntityEscaping();
        if (entityEscaping != null) {
            print(entityEscaping);
            printSpace();
        }

        SQLReserved evalName = x.getEvalName();
        if (evalName != null) {
            print(entityEscaping);
            printSpace();
        }

        printAccept(x.getArguments(), ", ");

        print(SQLReserved.RIGHT_PAREN);
        return false;
    }

    @Override
    public boolean visit(SQLXmlElementFunction.SQLXmlAttributesClause x) {
        print(SQLReserved.XMLATTRIBUTES);
        print(SQLReserved.LEFT_PAREN);

        SQLReserved entityEscaping = x.getEntityEscaping();
        if (entityEscaping != null) {
            print(entityEscaping);
            printSpace();
        }

        SQLReserved schemaCheck = x.getSchemaCheck();
        if (schemaCheck != null) {
            print(schemaCheck);
            printSpace();
        }

        printAccept(x.getItems(), ", ");

        print(SQLReserved.RIGHT_PAREN);
        return false;
    }

    @Override
    public boolean visit(SQLXmlExistsFunction x) {
        print(SQLReserved.XMLEXISTS);
        print(SQLReserved.LEFT_PAREN);

        printAccept(x.getArguments(), ", ");

        printSpaceAfterAccept(x.getPassingClause());

        print(SQLReserved.RIGHT_PAREN);
        return false;
    }


    @Override
    public boolean visit(SQLXmlForestFunction x) {
        print(SQLReserved.XMLFOREST);
        printAccept(x.getArguments(), ", ", true);
        return false;
    }

    @Override
    public boolean visit(SQLXmlParseFunction x) {
        print(SQLReserved.XMLPARSE);
        print(SQLReserved.LEFT_PAREN);

        SQLReserved content = x.getContent();
        if (content != null) {
            print(content);
            printSpace();
        }

        printAccept(x.getArguments(), ", ");

        if (x.isWellFormed()) {
            printSpaceAfterValue(SQLReserved.WELLFORMED);
        }

        print(SQLReserved.RIGHT_PAREN);
        return false;
    }

    @Override
    public boolean visit(SQLXmlPiFunction x) {
        print(SQLReserved.XMLPI);
        print(SQLReserved.LEFT_PAREN);

        SQLReserved evalName = x.getEvalName();
        if (evalName != null) {
            print(evalName);
            printSpace();
        }

        printAccept(x.getArguments(), ", ");

        print(SQLReserved.RIGHT_PAREN);
        return false;
    }

    @Override
    public boolean visit(SQLXmlQueryFunction x) {
        print(SQLReserved.XMLQUERY);
        print(SQLReserved.LEFT_PAREN);

        for (int i = 0; i < x.getArguments().size(); i++) {
            SQLExpr argument = x.getArguments().get(i);
            if (i != 0) {
                print(", ");
            }
            if (i == 0) {
                argument.accept(this);

                printSpaceAfterAccept(x.getPassingClause());
                printSpaceAfterValue(SQLReserved.RETURNING_CONTENT);

                if (x.isNullOnEmpty()) {
                    printSpaceAfterValue(SQLReserved.NULL_ON_EMPTY);
                }

                continue;
            }

            argument.accept(this);
        }

        print(SQLReserved.RIGHT_PAREN);
        return false;
    }

    @Override
    public boolean visit(SQLXmlRootFunction x) {
        print(SQLReserved.XMLROOT);
        printAccept(x.getArguments(), ", ", true);
        return false;
    }

    @Override
    public boolean visit(SQLXmlRootFunction.SQLVersionArgument x) {
        print(SQLReserved.VERSION);
        printSpaceAfterAccept(x.getValue());
        return false;
    }

    @Override
    public boolean visit(SQLXmlSerializeFunction x) {
        print(SQLReserved.XMLSERIALIZE);
        print(SQLReserved.LEFT_PAREN);

        SQLReserved content = x.getContent();
        if (content != null) {
            print(content);
            printSpace();
        }

        printAccept(x.getArguments(), ", ");


        SQLExpr encoding = x.getEncoding();
        if (encoding != null) {
            printSpaceAfterValue(SQLReserved.ENCODING);
            printSpaceAfterAccept(encoding);
        }

        SQLExpr version = x.getVersion();
        if (version != null) {
            printSpaceAfterValue(SQLReserved.VERSION);
            printSpaceAfterAccept(version);
        }

        SQLReserved indent = x.getIndent();
        if (indent != null) {
            print(indent);
            printSpace();
        }

        SQLExpr size = x.getSize();
        if (version != null) {
            printSpaceAfterValue(SQLReserved.SIZE);
            printSpaceAfterValue(SQLReserved.EQUALS_OP);
            printSpaceAfterAccept(size);
        }


        SQLReserved defaults = x.getDefaults();
        if (defaults != null) {
            printSpaceAfterValue(defaults);
        }

        print(SQLReserved.RIGHT_PAREN);
        return false;
    }

    @Override
    public boolean visit(SQLXmlTableFunction x) {
        print(SQLReserved.XMLTABLE);
        print(SQLReserved.LEFT_PAREN);

        printAccept(x.getArguments(), ", ");

        printSpaceAfterAccept(x.getOption());

        print(SQLReserved.RIGHT_PAREN);

        return false;
    }

    @Override
    public boolean visit(SQLXmlTableFunction.SQLXmlNamespacesClause x) {
        print(SQLReserved.XMLNAMESPACES);
        printAccept(x.getItems(), ", ", true);
        return false;
    }

    @Override
    public boolean visit(SQLXmlTableFunction.SQLXmlTableOption x) {
        boolean print = false;

        SQLXmlPassingClause passingClause = x.getPassingClause();
        if (passingClause != null) {
            passingClause.accept(this);
            print = true;
        }


        if (x.isReturningSequenceByRef()) {
            if (print) {
                printSpace();
            }
            print(SQLReserved.RETURNING_SEQUENCE_BY_REF);
            print = true;
        }

        List<SQLXmlTableFunction.SQLXmlTableColumn> columns = x.getColumns();
        if (columns.size() > 0) {
            if (print) {
                printSpace();
            }
            print(SQLReserved.COLUMNS);
            printSpaceAfterAccept(columns, ", ");
            print = true;
        }

        return false;
    }

    @Override
    public boolean visit(SQLXmlTableFunction.SQLXmlTableColumnByForOrdinality x) {
        x.getColumn().accept(this);
        printSpaceAfterValue(SQLReserved.FOR_ORDINALITY);
        return false;
    }

    @Override
    public boolean visit(SQLXmlTableFunction.SQLXmlTableColumnByDataType x) {
        x.getColumn().accept(this);
        printSpaceAfterAccept(x.getDataType());

        if (x.isSequenceByRef()) {
            printSpaceAfterValue(SQLReserved.LEFT_PAREN);
            printSpaceAfterValue(SQLReserved.SEQUENCE);
            printSpaceAfterValue(SQLReserved.RIGHT_PAREN);
            printSpaceAfterValue(SQLReserved.BY);
            printSpaceAfterValue(SQLReserved.REF);
        }

        SQLExpr path = x.getPath();
        if (path != null) {
            printSpaceAfterValue(SQLReserved.PATH);
            printSpaceAfterAccept(path);
        }

        SQLExpr default_ = x.getDefault_();
        if (default_ != null) {
            printSpaceAfterValue(SQLReserved.DEFAULT);
            printSpaceAfterAccept(default_);
        }

        return false;
    }

    @Override
    public boolean visit(SQLPositionFunction x) {
        print(SQLReserved.POSITION);
        print(SQLReserved.LEFT_PAREN);
        print(x.getArguments().get(0));
        printSpaceAfterValue(SQLReserved.IN);
        printSpaceAfterAccept(x.getArguments().get(1));
        print(SQLReserved.RIGHT_PAREN);
        return false;
    }

    @Override
    public boolean visit(SQLSubStrFromFunction x) {
        print(SQLReserved.SUBSTR);
        print(SQLReserved.LEFT_PAREN);

        print(x.getArguments().get(0));
        printSpaceAfterValue(SQLReserved.FROM);
        printSpaceAfterAccept(x.getArguments().get(1));

        if (x.getArguments().size() == 3) {
            printSpaceAfterValue(SQLReserved.FOR);
            printSpaceAfterAccept(x.getArguments().get(2));
        }

        print(SQLReserved.RIGHT_PAREN);
        return false;
    }

    @Override
    public boolean visit(SQLSubStringFromFunction x) {
        print(SQLReserved.SUBSTRING);
        print(SQLReserved.LEFT_PAREN);

        print(x.getArguments().get(0));
        printSpaceAfterValue(SQLReserved.FROM);
        printSpaceAfterAccept(x.getArguments().get(1));

        if (x.getArguments().size() == 3) {
            printSpaceAfterValue(SQLReserved.FOR);
            printSpaceAfterAccept(x.getArguments().get(2));
        }

        print(SQLReserved.RIGHT_PAREN);
        return false;
    }

    @Override
    public boolean visit(SQLWeightStringFunction x) {
        print(SQLReserved.WEIGHT_STRING);
        print(SQLReserved.LEFT_PAREN);
        print(x.getArguments().get(0));

        SQLDataType dataType = x.getDataType();
        if (dataType != null) {
            printSpaceAfterValue(SQLReserved.AS);
            printSpaceAfterAccept(dataType);
        }
        print(SQLReserved.RIGHT_PAREN);
        return false;
    }

    @Override
    public boolean visit(SQLMethodInvocation x) {
        x.getNameExpr().accept(this);

        boolean paren = x.isParen();
        if (!paren) {
            return false;
        }

        print(SQLReserved.LEFT_PAREN);

        List<SQLExpr> arguments = x.getArguments();
        for (int i = 0; i < arguments.size(); i++) {
            SQLExpr argument = arguments.get(i);

            if (i != 0) {
                print(", ");
            }

            if (i == 0) {
                SQLSetQuantifier setQuantifier = x.getSetQuantifier();
                if (setQuantifier != null) {
                    print(setQuantifier.name);
                    printSpace();
                }
                argument.accept(this);

                printSpaceAfterAccept(x.getDefaultOnConversionError());

                continue;
            }

            argument.accept(this);
        }

        print(SQLReserved.RIGHT_PAREN);
        return false;
    }

    @Override
    public boolean visit(AbstractSQLFunction.SQLDefaultOnConversionError x) {
        print(SQLReserved.DEFAULT);
        printSpaceAfterAccept(x.getValue());
        printSpaceAfterValue(SQLReserved.ON_CONVERSION_ERROR);
        return false;
    }

    @Override
    public boolean visit(SQLStaticMethodInvocation x) {
        x.getOwner().accept(this);
        print(SQLReserved.DOUBLE_COLON);
        x.getNameExpr().accept(this);
        printAccept(x.getArguments(), ", ", true);
        return false;
    }
    // ------------------------- Functions Start ----------------------------------------


    // ------------------------- Commons Expr Start ----------------------------------------
    @Override
    public boolean visit(SQLFromClause x) {
        print(SQLReserved.FROM);
        printSpaceAfterAccept(x.getTableReference());
        return false;
    }

    @Override
    public boolean visit(SQLHierarchicalQueryConnectByStartWithClause x) {
        print(SQLReserved.CONNECT_BY);

        if (x.isNoCycle()) {
            printSpace();
            print(SQLReserved.NOCYCLE);
        }

        printSpace();
        x.getConnectByCondition().accept(this);

        SQLExpr startWithCondition = x.getStartWithCondition();
        if (startWithCondition != null) {
            println();
            print(SQLReserved.START_WITH);
            printSpace();
            startWithCondition.accept(this);
        }

        return false;
    }

    @Override
    public boolean visit(SQLHierarchicalQueryStartWithConnectByClause x) {
        print(SQLReserved.START_WITH);
        printSpace();
        x.getStartWithCondition().accept(this);

        println();
        print(SQLReserved.CONNECT_BY);

        if (x.isNoCycle()) {
            printSpace();
            print(SQLReserved.NOCYCLE);
        }

        printSpace();
        x.getConnectByCondition().accept(this);

        return false;
    }

    @Override
    public boolean visit(SQLObjectNameTableReference x) {

        if (x.isOnly()) {
            print(SQLReserved.ONLY);
            print(SQLReserved.LEFT_PAREN);
        }

        x.getName().accept(this);

        if (x.isOnly()) {
            print(SQLReserved.LEFT_PAREN);
        }

        if (x.isAs()) {
            printSpace();
            print(AS);
        }

        SQLIdentifier alias = x.getAlias();
        if (alias != null) {
            printSpace();
            alias.accept(this);
        }

        if (x.getColumns().size() > 0) {
            printSpace();
            printAccept(x.getColumns(), ", ", true);
        }

        SQLSampleClause sampleClause = x.getSampleClause();
        if (sampleClause != null) {
            printSpace();
            sampleClause.accept(this);
        }

        return false;
    }

    @Override
    public boolean visit(SQLPartitionClause x) {
        print(SQLReserved.PARTITION);
        printSpaceAfterAccept(x.getItems(), ", ", true);
        return false;
    }

    @Override
    public boolean visit(SQLPartitionForClause x) {
        print(SQLReserved.PARTITION);
        printSpaceAfterValue(SQLReserved.FOR);
        printSpaceAfterAccept(x.getItems(), ", ", true);
        return false;
    }

    @Override
    public boolean visit(SQLSubPartitionClause x) {
        print(SQLReserved.SUBPARTITION);
        printSpaceAfterAccept(x.getItems(), ", ", true);
        return false;
    }

    @Override
    public boolean visit(SQLSubPartitionForClause x) {
        print(SQLReserved.SUBPARTITION);
        printSpaceAfterValue(SQLReserved.FOR);
        printSpaceAfterAccept(x.getItems(), ", ", true);
        return false;
    }

    @Override
    public boolean visit(SQLJoinTableReference x) {
        if (x.isParen()) {
            print(SQLReserved.LEFT_PAREN);
        }

        x.getLeft().accept(this);

        printSpaceAfterAccept(x.getLeftPartitionByClause());

        boolean isComma = x.getJoinType() == SQLJoinTableReference.SQLJoinType.COMMA;
        if (isComma) {
            print(SQLReserved.COMMA);
        } else {
            this.incrementIndent();
            println();
            print(x.getJoinType().name);
        }

        printSpaceAfterAccept(x.getRight());

        printSpaceAfterAccept(x.getRightPartitionByClause());

        printSpaceAfterAccept(x.getConditions(), " ");

        if (!isComma) {
            this.decrementIndent();
        }

        if (x.isParen()) {
            print(SQLReserved.RIGHT_PAREN);
        }
        return false;
    }

    @Override
    public boolean visit(SQLJoinTableReference.SQLJoinOnCondition x) {
        if (x.getCondition() == null) {
            return false;
        }
        print(SQLReserved.ON);
        printSpaceAfterAccept(x.getCondition());
        return false;
    }

    @Override
    public boolean visit(SQLJoinTableReference.SQLJoinUsingCondition x) {
        print(SQLReserved.USING);
        printSpaceAfterAccept(x.getColumns(), ", ", true);
        return false;
    }


    @Override
    public boolean visit(SQLSubQueryTableReference x) {
        if (x.isOnly()) {
            print(SQLReserved.ONLY);
            printSpace();
        }

        if (x.isLateral()) {
            print(SQLReserved.LATERAL);
            printSpace();
        }

        print(SQLReserved.LEFT_PAREN);
        this.incrementIndent();
        println();

        x.getSubQuery().accept(this);

        this.decrementIndent();
        println();
        print(SQLReserved.RIGHT_PAREN);

        if (x.isAs()) {
            printSpace();
            print(AS);
        }

        SQLIdentifier alias = x.getAlias();
        if (alias != null) {
            printSpace();
            alias.accept(this);
        }

        if (x.getColumns().size() > 0) {
            printSpace();
            printAccept(x.getColumns(), ", ", true);
        }

        SQLSampleClause sampleClause = x.getSampleClause();
        if (sampleClause != null) {
            printSpace();
            sampleClause.accept(this);
        }

        return false;
    }

    @Override
    public boolean visit(SQLUnNestFunctionTableReference x) {
        print(SQLReserved.UNNEST);
        print(SQLReserved.LEFT_PAREN);
        x.getExpr().accept(this);
        print(SQLReserved.RIGHT_PAREN);

        if (x.isWithOrdinality()) {
            printSpaceAfterValue(SQLReserved.WITH_ORDINALITY);
        }

        if (x.isAs()) {
            printSpaceAfterValue(SQLReserved.AS);
        }

        printSpaceAfterAccept(x.getAlias());

        return false;
    }

    @Override
    public boolean visit(SQLTableFunctionTableReference x) {
        if (x.isOnly()) {
            print(SQLReserved.ONLY);
            printSpaceAfterValue(SQLReserved.LEFT_PAREN);
            printSpace();
        }

        print(SQLReserved.TABLE);
        print(SQLReserved.LEFT_PAREN);
        x.getExpr().accept(this);
        print(SQLReserved.RIGHT_PAREN);

        if (x.isOuterJoin()) {
            printSpaceAfterValue(SQLReserved.OUTER_JOIN_OP);
        }

        if (x.isOnly()) {
            print(SQLReserved.RIGHT_PAREN);
        }


        if (x.isAs()) {
            printSpaceAfterValue(SQLReserved.AS);
        }

        printSpaceAfterAccept(x.getAlias());

        return false;
    }


    @Override
    public boolean visit(SQLCompileClause x) {
        print(SQLReserved.COMPILE);
        if (x.isDebug()) {
            printSpaceAfterValue(SQLReserved.DEBUG);
        }

        SQLCompileClause.SQLCompiler compiler = x.getCompiler();
        if (compiler != null) {
            printSpaceAfterValue(compiler.name);
        }

        printlnAndAccept(x.getParameters());

        if (x.isReuseSettings()) {
            printSpaceAfterValue(SQLReserved.REUSE_SETTINGS);
        }

        return false;
    }

    @Override
    public boolean visit(SQLCubeClause x) {
        print(SQLReserved.CUBE);
        printSpaceAfterAccept(x.getItems(), ", ", true);
        return false;
    }

    @Override
    public boolean visit(SQLCurrentOfClause x) {
        print(SQLReserved.CURRENT_OF);

        printSpace();
        x.getName().accept(this);
        return false;
    }


    @Override
    public boolean visit(SQLDefaultClause x) {
        print(x.getOp().name);
        printSpaceAfterAccept(x.getExpr());
        return false;
    }

    @Override
    public boolean visit(SQLDefaultOnNullClause x) {
        print(SQLReserved.DEFAULT);
        printSpaceAfterValue(SQLReserved.ON_NULL);
        printSpaceAfterAccept(x.getExpr());
        return false;
    }

    @Override
    public boolean visit(SQLDeterministicClause x) {
        if (x.isNot()) {
            print(SQLReserved.NOT);
            printSpace();
        }
        print(SQLReserved.DETERMINISTIC);
        return false;
    }

    @Override
    public boolean visit(SQLErrorLoggingClause x) {
        print(SQLReserved.LOG_ERRORS);

        SQLName into = x.getInto();
        if (into != null) {
            printSpaceAfterValue(SQLReserved.INTO);
            printSpaceAfterAccept(into);
        }

        SQLExpr expr = x.getExpr();
        if (expr != null) {
            printSpaceAfterValue(SQLReserved.LEFT_PAREN);
            expr.accept(this);
            print(SQLReserved.RIGHT_PAREN);
        }


        SQLExpr rejectLimit = x.getRejectLimit();
        if (rejectLimit != null) {
            printSpaceAfterValue(SQLReserved.REJECT_LIMIT);
            printSpaceAfterAccept(rejectLimit);
        }

        return false;
    }

    @Override
    public boolean visit(SQLExceptionClause x) {
        print(SQLReserved.EXCEPTION);
        printIndentAndLnAndAccept(x.getExceptionHandlers());
        return false;
    }

    @Override
    public boolean visit(SQLPartitionByClause x) {
        print(SQLReserved.PARTITION_BY);
        printSpaceAfterAccept(x.getItems(), ", ");
        return false;
    }

    @Override
    public boolean visit(SQLProcedureInvocation x) {
        print(x.getName());
        printAccept(x.getArguments(), ", ", true);
        return false;
    }

    @Override
    public boolean visit(SQLRollupClause x) {
        print(SQLReserved.ROLLUP);
        printSpaceAfterAccept(x.getItems(), ", ", true);
        return false;
    }

    @Override
    public boolean visit(SQLSampleClause x) {
        print(SQLReserved.TABLESAMPLE);

        SQLSampleClause.SampleMethodType methodType = x.getSampleMethod();
        if (methodType != null) {
            printSpace();
            print(methodType.name());
            printSpace();
        }

        print(SQLReserved.LEFT_PAREN);
        x.getPercent().accept(this);
        print(SQLReserved.RIGHT_PAREN);

        SQLExpr repeatArgument = x.getRepeatArgument();
        if (repeatArgument != null) {
            printSpace();
            print(SQLReserved.REPEATABLE);
            print(SQLReserved.LEFT_PAREN);
            repeatArgument.accept(this);
            print(SQLReserved.RIGHT_PAREN);
        }

        return false;
    }

    @Override
    public boolean visit(SQLSelectQueryExpr x) {
        boolean indent = false;
        if (x.isParen()) {
            print(SQLReserved.LEFT_PAREN);
            indent = true;
        }

        if (!indent) {
            indent = x.getParent() instanceof SQLInCondition
                    || x.getParent() instanceof SQLAnyClause
                    || x.getParent() instanceof SQLSomeClause
                    || x.getParent() instanceof SQLAllClause;
        }

        if (indent) {
            this.incrementIndent();
            println();
        }

        x.getSubQuery().accept(this);

        if (indent) {
            this.decrementIndent();
            println();
        }

        if (x.isParen()) {
            print(SQLReserved.RIGHT_PAREN);
        }

        return false;
    }


    @Override
    public boolean visit(SQLUsingClause x) {
        print(SQLReserved.USING);
        printSpaceAfterAccept(x.getArguments(), ", ");
        return false;
    }


    @Override
    public boolean visit(SQLUsingClause.SQLUsingArgumentClause x) {
        SQLParameterModel model = x.getModel();
        if (model != null) {
            print(model.name);
        }

        printSpaceAfterAccept(x.getExpr());
        return false;
    }


    @Override
    public boolean visit(SQLValuesClause x) {
        print(x.getValues());

        this.incrementIndent();
        printSpaceAndLnAndAccept(x.getItems(), ",", false);
        this.decrementIndent();
        return false;
    }

    @Override
    public boolean visit(SQLValuesClause.SQLValuesItem x) {
        printAccept(x.getColumns(), ", ", true);
        return false;
    }

    @Override
    public boolean visit(SQLWhereClause x) {
        SQLExpr condition = x.getCondition();
        if (condition == null) {
            return false;
        }

        print(SQLReserved.WHERE);

        printSpace();
        printWhereCondition(condition);
        return false;
    }

    public void printWhereCondition(SQLExpr x) {
        if (x == null) {
            return;
        }

        SQLExpr left = x;
        List<Pair<SQLBinaryOperator, SQLExpr>> groupList = new ArrayList<>();
        for (; ; ) {
            if (left instanceof SQLBinaryOperatorExpr
                    && ((SQLBinaryOperatorExpr) left).getOperator().isLogical()) {

                Pair<SQLBinaryOperator, SQLExpr> pair = new Pair<>(((SQLBinaryOperatorExpr) left).getOperator(), ((SQLBinaryOperatorExpr) left).getRight());
                groupList.add(pair);

                left = ((SQLBinaryOperatorExpr) left).getLeft();
                continue;
            } else {
                Pair<SQLBinaryOperator, SQLExpr> pair = new Pair<>(null, left);
                groupList.add(pair);
            }
            break;
        }


        int lineLength = 0;
        this.incrementIndent();
        for (int i = groupList.size() - 1; i >= 0; i--) {
            Pair<SQLBinaryOperator, SQLExpr> pair = groupList.get(i);
            SQLBinaryOperator operator = pair.getKey();
            SQLExpr expr = pair.getValue();
            int conditionLength = expr.toString().length();
            lineLength += conditionLength;
            if (i != groupList.size() - 1) {
                if (lineLength > getLineMaxLength()) {
                    println();
                    lineLength = conditionLength;
                } else {
                    printSpace();
                }
            }

            if (operator != null) {
                print(operator.name);
                printSpace();
            }

            expr.accept(this);
        }
//        for (; ; ) {
//

//            lineLength += conditionLength;
//
//
//
//            if (count != 0) {
//
//                printSpace();
//            }
//            left.accept(this);
//
//            if (left == x) {
//                break;
//            }
//
//            left = ((SQLBinaryOperatorExpr) left.getParent()).getRight();
//
//            count++;
//        }
        this.decrementIndent();

    }


    @Override
    public boolean visit(SQLCharacterSetOptionExpr x) {

        if (x.isDefault_()) {
            print(SQLReserved.DEFAULT);
            printSpace();
        }
        print(SQLReserved.CHARACTER_SET);

        if (x.isEqualSign()) {
            printSpaceAfterValue(SQLReserved.EQUALS_OP);
        }

        printSpaceAfterAccept(x.getValue());
        return false;
    }

    @Override
    public boolean visit(SQLCollationExpr x) {
        if (x.isDefault_()) {
            print(SQLReserved.DEFAULT);
            printSpace();
        }
        print(SQLReserved.COLLATION);

        if (x.isEqualSign()) {
            printSpaceAfterValue(SQLReserved.EQUALS_OP);
        }

        printSpaceAfterAccept(x.getValue());
        return false;
    }

    @Override
    public boolean visit(SQLDefinerOptionExpr x) {
        print(SQLReserved.DEFINER);

        if (x.isEqualSign()) {
            printSpaceAfterValue(SQLReserved.EQUALS_OP);
        }

        printSpaceAfterAccept(x.getValue());
        return false;
    }

    @Override
    public boolean visit(SQLSetOptionExpr x) {
        if (x.isDefault_()) {
            print(SQLReserved.DEFAULT);
            printSpace();
        }
        print(x.getName());

        if (x.isEqualSign()) {
            printSpaceAfterValue(SQLReserved.EQUALS_OP);
        }

        printSpaceAfterAccept(x.getValue());
        return false;
    }


    @Override
    public boolean visit(SQLReservedIdentifier x) {

        print(isLowerCase() ? x.lower() : x.upper());

        return false;
    }


    @Override
    public boolean visit(SQLBody x) {
        SQLName beginLabel = x.getBeginLabel();
        if (beginLabel != null) {
            print(beginLabel);
            printSpaceAfterValue(SQLReserved.COLON);
            printSpace();
        }

        print(SQLReserved.BEGIN);

        this.incrementIndent();
        println();

        printlnAndAccept(x.getBodyItems());

        printlnAndAccept(x.getExceptionClause());

        this.decrementIndent();

        printlnAfterValue(SQLReserved.END);

        printSpaceAfterAccept(x.getEndName());

        return false;
    }

    @Override
    public boolean visit(SQLBody.SQLBodyItem x) {
        List<SQLLabel> labels = x.getLabels();
        if (labels != null
                && labels.size() > 0) {
            printlnAndAccept(x.getLabels());
            println();
        }
        print(x.getStatement());

        return false;
    }

    @Override
    public boolean visit(SQLLabel x) {
        print(SQLReserved.LESS_THAN_LESS_THAN_OP);
        x.getLabel().accept(this);
        print(SQLReserved.GREATER_THAN_GREATER_THAN_OP);
        return false;
    }

    @Override
    public boolean visit(SQLBoundsClause x) {
        print(x.getLower());
        printSpaceAfterValue(SQLReserved.DOUBLE_PERIOD);
        printSpaceAfterAccept(x.getUpper());
        return false;
    }

    @Override
    public boolean visit(SQLBoundsByIndicesOfClause x) {
        print(SQLReserved.INDICES_OF);
        printSpaceAfterAccept(x.getCollection());

        SQLExpr lower = x.getLower();
        SQLExpr upper = x.getUpper();
        if (lower != null
                && upper != null) {
            printSpaceAfterValue(SQLReserved.BETWEEN);
            printSpaceAfterAccept(lower);

            printSpaceAfterValue(SQLReserved.AND);
            printSpaceAfterAccept(upper);
        }
        return false;
    }

    @Override
    public boolean visit(SQLBoundsByValuesOfClause x) {
        print(SQLReserved.VALUES_OF);
        printSpaceAfterAccept(x.getCollection());
        return false;
    }

    @Override
    public boolean visit(SQLBroadcastExpr x) {
        print(SQLReserved.BROADCAST);
        return false;
    }

    // ------------------------- Commons Expr End ----------------------------------------


    // ------------------------- column constraint Start ----------------------------------------
    @Override
    public boolean visit(SQLAutoIncrementColumnConstraint x) {
        print(SQLReserved.AUTO_INCREMENT);
        return false;
    }

    @Override
    public boolean visit(SQLCheckColumnConstraint x) {
        SQLName name = x.getName();
        if (name != null) {
            print(SQLReserved.CONSTRAINT);
            printSpaceAfterAccept(name);
            printSpace();
        }

        print(SQLReserved.CHECK);
        printSpaceAfterValue(SQLReserved.LEFT_PAREN);
        print(x.getCondition());
        print(SQLReserved.RIGHT_PAREN);

        printSpaceAfterAccept(x.getOptions(), " ");
        return false;
    }

    @Override
    public boolean visit(SQLNotNullColumnConstraint x) {
        SQLName name = x.getName();
        if (name != null) {
            print(SQLReserved.CONSTRAINT);
            printSpaceAfterAccept(name);
            printSpace();
        }

        print(SQLReserved.NOT_NULL);

        printSpaceAfterAccept(x.getOptions(), " ");
        return false;
    }

    @Override
    public boolean visit(SQLNullColumnConstraint x) {
        SQLName name = x.getName();
        if (name != null) {
            print(SQLReserved.CONSTRAINT);
            printSpaceAfterAccept(name);
            printSpace();
        }

        print(SQLReserved.NULL);

        printSpaceAfterAccept(x.getOptions(), " ");
        return false;
    }

    @Override
    public boolean visit(SQLPrimaryKeyColumnConstraint x) {
        SQLName name = x.getName();
        if (name != null) {
            print(SQLReserved.CONSTRAINT);
            printSpaceAfterAccept(name);
            printSpace();
        }

        if (x.isPrimary()) {
            print(SQLReserved.PRIMARY);
            printSpace();
        }
        print(SQLReserved.KEY);

        printSpaceAfterAccept(x.getOptions(), " ");
        return false;
    }

    @Override
    public boolean visit(SQLReferencesColumnConstraint x) {
        SQLName name = x.getName();
        if (name != null) {
            print(SQLReserved.CONSTRAINT);
            printSpaceAfterAccept(name);
            printSpace();
        }

        print(SQLReserved.REFERENCES);

        printSpaceAfterAccept(x.getReferencedTable());

        printAccept(x.getReferencedColumns(), ", ", true);

        printSpaceAfterAccept(x.getActions(), " ");

        printSpaceAfterAccept(x.getOptions(), " ");
        return false;
    }

    @Override
    public boolean visit(SQLReferencesColumnConstraint.SQLOnUpdateAction x) {
        print(SQLReserved.ON);
        printSpaceAfterValue(SQLReserved.UPDATE);
        printSpaceAfterValue(x.getAction());
        return false;
    }

    @Override
    public boolean visit(SQLReferencesColumnConstraint.SQLOnDeleteAction x) {
        print(SQLReserved.ON);
        printSpaceAfterValue(SQLReserved.DELETE);
        printSpaceAfterValue(x.getAction());
        return false;
    }

    @Override
    public boolean visit(SQLUniqueColumnConstraint x) {
        SQLName name = x.getName();
        if (name != null) {
            print(SQLReserved.CONSTRAINT);
            printSpaceAfterAccept(name);
            printSpace();
        }

        print(SQLReserved.UNIQUE);
        if (x.isKey()) {
            printSpaceAfterValue(SQLReserved.KEY);
        }

        printSpaceAfterAccept(x.getOptions(), " ");
        return false;
    }

    @Override
    public boolean visit(SQLScopeIsColumnConstraint x) {
        print(SQLReserved.SCOPE_IS);
        printSpaceAfterAccept(x.getScopeTable());

        return false;
    }

    @Override
    public boolean visit(SQLWithRowIdColumnConstraint x) {
        print(SQLReserved.WITH_ROWID);
        return false;
    }

    @Override
    public boolean visit(SQLFormatColumnConstraint x) {
        print(SQLReserved.COLUMN_FORMAT);
        printSpaceAfterValue(x.getFormatType());
        return false;
    }

    @Override
    public boolean visit(SQLStorageColumnConstraint x) {
        print(SQLReserved.STORAGE);
        printSpaceAfterValue(x.getStorageType());
        return false;
    }

    // ------------------------- column constraint End ----------------------------------------


    // ------------------------- table constraint Start ----------------------------------------

    @Override
    public boolean visit(SQLCheckTableConstraint x) {
        SQLName name = x.getName();
        if (name != null) {
            print(SQLReserved.CONSTRAINT);
            printSpaceAfterAccept(name);
            printSpace();
        }

        print(SQLReserved.CHECK);
        printSpaceAfterValue(SQLReserved.LEFT_PAREN);
        print(x.getCondition());
        print(SQLReserved.RIGHT_PAREN);

        printIndentAndLnAndAccept(x.getOptions());
        return false;
    }

    @Override
    public boolean visit(SQLForeignKeyTableConstraint x) {
        SQLName name = x.getName();
        if (name != null) {
            print(SQLReserved.CONSTRAINT);
            printSpaceAfterAccept(name);
            printSpace();
        }

        print(SQLReserved.FOREIGN_KEY);
        printSpaceAfterAccept(x.getIndexName());
        printSpaceAfterAccept(x.getReferencingColumns(), ", ", true);

        printSpaceAfterValue(SQLReserved.REFERENCES);

        printSpaceAfterAccept(x.getReferencedTable());

        printAccept(x.getReferencedColumns(), ", ", true);

        printIndentAndLnAndAccept(x.getOptions());
        return false;
    }

    @Override
    public boolean visit(SQLPrimaryKeyTableConstraint x) {
        SQLName name = x.getName();
        if (name != null) {
            print(SQLReserved.CONSTRAINT);
            printSpaceAfterAccept(name);
            printSpace();
        }

        print(SQLReserved.PRIMARY_KEY);
        printSpaceAfterValue(x.getIndexType());
        printSpaceAfterAccept(x.getColumns(), ", ", true);

        printSpaceAfterAccept(x.getOptions(), " ");
        return false;
    }

    @Override
    public boolean visit(SQLUniqueTableConstraint x) {
        SQLName name = x.getName();
        if (name != null) {
            print(SQLReserved.CONSTRAINT);
            printSpaceAfterAccept(name);
            printSpace();
        }

        print(SQLReserved.UNIQUE);
        printSpaceAfterValue(x.getIndexType());
        printSpaceAfterAccept(x.getIndexName());
        printSpaceAfterValue(x.getIndexType());

        printSpaceAfterAccept(x.getColumns(), ", ", true);

        printIndentAndLnAndAccept(x.getOptions());
        return false;
    }

    @Override
    public boolean visit(SQLIndexTableConstraint x) {
        return false;
    }

    @Override
    public boolean visit(SQLKeyTableConstraint x) {
        return false;
    }

    @Override
    public boolean visit(SQLFullTextTableConstraint x) {
        return false;
    }

    @Override
    public boolean visit(SQLSpatialTableConstraint x) {
        return false;
    }

    @Override
    public boolean visit(SQLScopeForTableConstraint x) {
        print(SQLReserved.SCOPE_FOR);
        print(SQLReserved.LEFT_PAREN);
        print(x.getRef());
        print(SQLReserved.RIGHT_PAREN);

        printSpaceAfterValue(SQLReserved.IS);
        printSpaceAfterAccept(x.getScopeTale());
        return false;
    }

    @Override
    public boolean visit(SQLRefWithRowIdTableConstraint x) {
        print(SQLReserved.REF);
        print(SQLReserved.LEFT_PAREN);
        print(x.getRef());
        print(SQLReserved.RIGHT_PAREN);

        printSpaceAfterValue(SQLReserved.WITH_ROWID);
        return false;
    }

    @Override
    public boolean visit(SQLConstraint.SQLColumn x) {
        print(x.getName());
        SQLExpr length = x.getLength();
        if (length != null) {
            print(SQLReserved.LEFT_PAREN);
            print(length);
            print(SQLReserved.RIGHT_PAREN);
        }
        printSpaceAfterValue(x.getOrdering());
        return false;
    }

    // ------------------------- table constraint End ----------------------------------------

    // ------------------------- constraint option Start ----------------------------------------

    @Override
    public boolean visit(SQExceptionsClause x) {
        print(SQLReserved.EXCEPTIONS_INTO);
        printSpaceAfterAccept(x.getName());
        return false;
    }

    @Override
    public boolean visit(SQLDeferrableConstraintState x) {
        print(SQLReserved.DEFERRABLE);
        return false;
    }

    @Override
    public boolean visit(SQLDisableConstraintState x) {
        print(SQLReserved.DISABLE);
        return false;
    }

    @Override
    public boolean visit(SQLEnableConstraintState x) {
        print(SQLReserved.ENABLE);
        return false;
    }

    @Override
    public boolean visit(SQLInitiallyDeferredConstraintState x) {
        print(SQLReserved.INITIALLY_DEFERRED);
        return false;
    }

    @Override
    public boolean visit(SQLInitiallyImmediateConstraintState x) {
        print(SQLReserved.INITIALLY_IMMEDIATE);
        return false;
    }

    @Override
    public boolean visit(SQLNoRelyConstraintState x) {
        print(SQLReserved.NORELY);
        return false;
    }

    @Override
    public boolean visit(SQLNotDeferrableConstraintState x) {
        print(SQLReserved.NOT_DEFERRABLE);
        return false;
    }

    @Override
    public boolean visit(SQLRelyConstraintState x) {
        print(SQLReserved.RELY);
        return false;
    }

    @Override
    public boolean visit(SQNoValidateConstraintState x) {
        print(SQLReserved.NOVALIDATE);
        return false;
    }

    @Override
    public boolean visit(SQValidateConstraintState x) {
        print(SQLReserved.VALIDATE);
        return false;
    }

    // ------------------------- constraint option  End ----------------------------------------

    // ------------------------- Details ----------------------------------------
    // ------------------ analytic Details Start ----------------------

    @Override
    public boolean visit(SQLAlterAnalyticRenameToAction x) {
        return false;
    }

    @Override
    public boolean visit(SQLAlterAnalyticCompileAction x) {
        return false;
    }

    // ------------------ analytic Details Start ----------------------


    // ------------------ Index Details Start ----------------------

    @Override
    public boolean visit(SQLIndexColumn x) {
        print(x.getName());

        SQLExpr length = x.getLength();
        if (length != null) {
            print(SQLReserved.LEFT_PAREN);
            print(length);
            print(SQLReserved.RIGHT_PAREN);
        }

        printSpaceAfterValue(x.getOrderingSpecification());
        printSpaceAfterValue(x.getNullOrdering());
        return false;
    }

    @Override
    public boolean visit(SQLLocalPartitionIndex x) {
        print(SQLReserved.LOCAL);
        printSpaceAfterAccept(x.getStoreInClause());
        printSpaceAndLnAndAccept(x.getItems(), ",", true);
        return false;
    }

    @Override
    public boolean visit(SQLGlobalPartitionByHash x) {
        print(SQLReserved.GLOBAL);
        printSpaceAfterValue(SQLReserved.PARTITION_BY);
        printSpaceAfterValue(SQLReserved.HASH);
        printSpaceAndLnAndAccept(x.getColumns(), ",", true);

        printSpaceAndLnAndAccept(x.getPartitions(), ",", true);


        SQLExpr partitionsQuantity = x.getPartitionsNum();
        if (partitionsQuantity != null) {
            printlnAfterValue(SQLReserved.PARTITIONS);
            printSpaceAfterAccept(partitionsQuantity);
        }

        printlnAndAccept(x.getStoreInClause());
        printlnAndAccept(x.getCompression());
        printlnAndAccept(x.getOverflowStoreInClause());

        printSpaceAndLnAndAccept(x.getPartitions(), ",", true);
        return false;
    }

    @Override
    public boolean visit(SQLGlobalPartitionByRange x) {
        print(SQLReserved.GLOBAL);
        printSpaceAfterValue(SQLReserved.PARTITION_BY);
        printSpaceAfterValue(SQLReserved.RANGE);
        printSpaceAndLnAndAccept(x.getColumns(), ",", true);
        printSpaceAndLnAndAccept(x.getPartitions(), ",", true);
        return false;
    }

    @Override
    public boolean visit(SQLIndexTypeIsIndexTypeClause x) {

        return false;
    }

    @Override
    public boolean visit(SQLPartialIndexByFullClause x) {
        print(SQLReserved.INDEXING_FULL);
        return false;
    }

    @Override
    public boolean visit(SQLPartialIndexByPartialClause x) {
        print(SQLReserved.INDEXING_PARTIAL);
        return false;
    }


    @Override
    public boolean visit(SQLIndexAttributeComputeStatistics x) {
        print(SQLReserved.COMPUTE_STATISTICS);
        return false;
    }

    @Override
    public boolean visit(SQLIndexAttributeInvisible x) {
        print(SQLReserved.INVISIBLE);
        return false;
    }

    @Override
    public boolean visit(SQLIndexAttributeNoSort x) {
        print(SQLReserved.NOSORT);
        return false;
    }

    @Override
    public boolean visit(SQLIndexAttributeOnline x) {
        print(SQLReserved.ONLINE);
        return false;
    }

    @Override
    public boolean visit(SQLIndexAttributeReverse x) {
        print(SQLReserved.REVERSE);
        return false;
    }

    @Override
    public boolean visit(SQLIndexAttributeSort x) {
        print(SQLReserved.SORT);
        return false;
    }

    @Override
    public boolean visit(SQLIndexAttributeVisible x) {
        print(SQLReserved.VISIBLE);
        return false;
    }

    @Override
    public boolean visit(SQLShrinkClause x) {
        print(SQLReserved.SHRINK_SPACE);

        if (x.isCompact()) {
            printSpaceAfterValue(SQLReserved.COMPACT);
        }

        if (x.isCascade()) {
            printSpaceAfterValue(SQLReserved.CASCADE);
        }
        return false;
    }

    @Override
    public boolean visit(SQLAlterIndexCoalesceAction x) {
        print(SQLReserved.COALESCE);
        if (x.isCleanup()) {
            printSpaceAfterValue(SQLReserved.CLEANUP);
        }
        printSpaceAfterAccept(x.getParallelClause());
        return false;
    }

    @Override
    public boolean visit(SQLAlterIndexCompileAction x) {
        print(SQLReserved.COMPILE);
        return false;
    }

    @Override
    public boolean visit(SQLAlterIndexDisableAction x) {
        print(SQLReserved.DISABLE);
        return false;
    }

    @Override
    public boolean visit(SQLAlterIndexEnableAction x) {
        print(SQLReserved.ENABLE);
        return false;
    }

    @Override
    public boolean visit(SQLAlterIndexInvisibleAction x) {
        print(SQLReserved.INVISIBLE);
        return false;
    }

    @Override
    public boolean visit(SQLAlterIndexMonitoringUsageAction x) {
        print(SQLReserved.MONITORING_USAGE);
        return false;
    }

    @Override
    public boolean visit(SQLAlterIndexNoMonitoringUsageAction x) {
        print(SQLReserved.NOMONITORING_USAGE);
        return false;
    }

    @Override
    public boolean visit(SQLAlterIndexRebuildAction x) {
        print(x.getRebuildClause());
        printSpaceAfterValue(x.getInvalidation());
        return false;
    }

    @Override
    public boolean visit(SQLAlterIndexRenameAction x) {
        print(SQLReserved.RENAME_TO);
        printSpaceAfterAccept(x.getNewName());
        return false;
    }

    @Override
    public boolean visit(SQLAlterIndexUnusableAction x) {
        print(SQLReserved.UNUSABLE);
        if (x.isOnline()) {
            printSpaceAfterValue(SQLReserved.ONLINE);
        }
        printSpaceAfterValue(x.getInvalidation());
        return false;
    }

    @Override
    public boolean visit(SQLAlterIndexUpdateBlockReferencesAction x) {
        print(SQLReserved.UPDATE_BLOCK_REFERENCES);
        return false;
    }

    @Override
    public boolean visit(SQLAlterIndexVisibleAction x) {
        print(SQLReserved.VISIBLE);
        return false;
    }


    @Override
    public boolean visit(SQLAlterIndexModifyDefaultAttributesAction x) {
        print(SQLReserved.MODIFY_DEFAULT_ATTRIBUTES);

        SQLExpr partition = x.getPartition();
        if (partition != null) {
            printSpaceAfterValue(SQLReserved.FOR_PARTITION);
            printSpaceAfterAccept(partition);
        }

        printSpaceAfterAccept(x.getItems(), " ");
        return false;
    }

    @Override
    public boolean visit(SQLAlterIndexAddPartitionAction x) {
        print(SQLReserved.ADD);
        printSpaceAfterValue(SQLReserved.PARTITION);

        printSpaceAfterAccept(x.getName());
        printSpaceAfterAccept(x.getTableSpaceClause());
        // todo
//        printSpaceAfterAccept(x.getIndexCompression());
        printSpaceAfterAccept(x.getParallelClause());
        return false;
    }

    @Override
    public boolean visit(SQLAlterIndexModifyPartitionAction x) {
        print(SQLReserved.MODIFY);
        printSpaceAfterValue(SQLReserved.PARTITION);
        printSpaceAfterAccept(x.getName());
        printSpaceAfterAccept(x.getItems(), " ");
        return false;
    }

    @Override
    public boolean visit(SQLAlterIndexModifyPartitionAction.SQLCoalesceOption x) {
        print(SQLReserved.COALESCE);
        if (x.isCleanup()) {
            printSpaceAfterValue(SQLReserved.CLEANUP);
        }
        return false;
    }

    @Override
    public boolean visit(SQLAlterIndexModifyPartitionAction.SQLUpdateBlockReferencesOption x) {
        print(SQLReserved.UPDATE_BLOCK_REFERENCES);
        return false;
    }

    @Override
    public boolean visit(SQLAlterIndexModifyPartitionAction.SQLUnusableOption x) {
        print(SQLReserved.UNUSABLE);
        return false;
    }

    @Override
    public boolean visit(SQLAlterIndexRenamePartitionAction x) {
        print(SQLReserved.RENAME);
        printSpaceAfterValue(SQLReserved.PARTITION);
        printSpaceAfterAccept(x.getName());
        printSpaceAfterValue(SQLReserved.TO);
        printSpaceAfterAccept(x.getNewName());
        return false;
    }

    @Override
    public boolean visit(SQLAlterIndexRenameSubPartitionAction x) {
        print(SQLReserved.RENAME);
        printSpaceAfterValue(SQLReserved.SUBPARTITION);
        printSpaceAfterAccept(x.getName());
        printSpaceAfterValue(SQLReserved.TO);
        printSpaceAfterAccept(x.getNewName());
        return false;
    }

    @Override
    public boolean visit(SQLAlterIndexSplitPartitionAction x) {
        print(SQLReserved.SPLIT);
        printSpaceAfterValue(SQLReserved.PARTITION);
        printSpaceAfterAccept(x.getName());

        printSpaceAfterValue(SQLReserved.AT);
        printSpaceAfterAccept(x.getAtItems(), ", ", true);

        List<SQLPartitionDefinition> partitions = x.getPartitions();
        if (partitions != null
                && partitions.size() > 0) {
            printlnAfterValue(SQLReserved.INTO);
            printSpaceAndLnAndAccept(partitions, ",", true);
        }

        printlnAndAccept(x.getParallelClause());
        return false;
    }

    @Override
    public boolean visit(SQLAlterIndexDropPartitionAction x) {
        print(SQLReserved.DROP);
        printSpaceAfterValue(SQLReserved.PARTITION);
        printSpaceAfterAccept(x.getName());
        return false;
    }

    @Override
    public boolean visit(SQLAlterIndexCoalescePartitionAction x) {
        print(SQLReserved.COALESCE);
        printSpaceAfterValue(SQLReserved.PARTITION);
        printSpaceAfterAccept(x.getParallelClause());
        return false;
    }

    @Override
    public boolean visit(SQLAlterIndexModifySubPartitionAction x) {
        print(SQLReserved.MODIFY);
        printSpaceAfterValue(SQLReserved.SUBPARTITION);
        printSpaceAfterAccept(x.getName());
        printSpaceAfterAccept(x.getOption());
        return false;
    }

    @Override
    public boolean visit(SQLAlterIndexModifySubPartitionAction.SQLUnusableOption x) {
        print(SQLReserved.UNUSABLE);
        return false;
    }

    // ------------------ Index Details End ----------------------


    // ------------------ Materialized View Details Start ----------------------
    @Override
    public boolean visit(SQLMaterializedViewColumn x) {
        print(x.getColumn());
        printSpaceAfterAccept(x.getEncryptClause());
        return false;
    }

    @Override
    public boolean visit(SQLOnPrebuiltTableProperty x) {
        print(SQLReserved.ON_PREBUILT_TABLE);

        SQLWithType reducedPrecisionAction = x.getReducedPrecisionAction();
        if (reducedPrecisionAction != null) {
            printSpaceAfterValue(reducedPrecisionAction.name);
            printSpaceAfterValue(SQLReserved.REDUCED_PRECISION);
        }
        return false;
    }

    @Override
    public boolean visit(SQLMaterializedViewPropertyCacheClause x) {
        print(SQLReserved.CACHE);
        return false;
    }

    @Override
    public boolean visit(SQLMaterializedViewPropertyNoCacheClause x) {
        print(SQLReserved.NOCACHE);
        return false;
    }

    @Override
    public boolean visit(SQLUsingIndexClause x) {
        print(SQLReserved.USING);
        printSpaceAfterValue(SQLReserved.INDEX);
        printSpaceAfterAccept(x.getItems(), " ");
        return false;
    }

    @Override
    public boolean visit(SQLUsingIndexClause.SQLCreateIndexStatementItem x) {
        print(SQLReserved.LEFT_PAREN);
        printIndentLnAndAccept(x.getCreateIndexStatement());
        printlnAfterValue(SQLReserved.RIGHT_PAREN);
        return false;
    }

    @Override
    public boolean visit(SQLUsingNoIndexClause x) {
        print(SQLReserved.USING);
        printSpaceAfterValue(SQLReserved.NO);
        printSpaceAfterValue(SQLReserved.INDEX);
        return false;
    }

    @Override
    public boolean visit(SQLCreateMVNeverRefresh x) {
        print(SQLReserved.NEVER_REFRESH);
        return false;
    }

    @Override
    public boolean visit(SQLCreateMVRefresh x) {
        print(SQLReserved.REFRESH);
        printCreateMVRefreshItems(x.getItems());
        return false;
    }

    public void printCreateMVRefreshItems(List<SQLCreateMVRefresh.SQLCreateMVRefreshItem> createMVRefreshItems) {
        int lineLength = 0;

        incrementIndent();
        for (int i = 0; i < createMVRefreshItems.size(); i++) {
            SQLCreateMVRefresh.SQLCreateMVRefreshItem createMVRefreshItem = createMVRefreshItems.get(i);
            int createMVRefreshItemLength = createMVRefreshItem.toString().length();
            lineLength += createMVRefreshItemLength;

            printSpace();

            if (i != 0
                    && lineLength > getLineMaxLength()) {
                println();
                lineLength = createMVRefreshItemLength;
            }
            createMVRefreshItem.accept(this);
        }
        decrementIndent();
    }

    @Override
    public boolean visit(SQLCreateMVRefresh.SQLCreateMVRefreshFastItem x) {
        print(SQLReserved.FAST);
        return false;
    }

    @Override
    public boolean visit(SQLCreateMVRefresh.SQLCreateMVRefreshCompleteItem x) {
        print(SQLReserved.COMPLETE);
        return false;
    }

    @Override
    public boolean visit(SQLCreateMVRefresh.SQLCreateMVRefreshForceItem x) {
        print(SQLReserved.FORCE);
        return false;
    }

    @Override
    public boolean visit(SQLCreateMVRefresh.SQLCreateMVRefreshOnDemandItem x) {
        print(SQLReserved.ON_DEMAND);
        return false;
    }

    @Override
    public boolean visit(SQLCreateMVRefresh.SQLCreateMVRefreshOnCommitItem x) {
        print(SQLReserved.ON_COMMIT);
        return false;
    }

    @Override
    public boolean visit(SQLCreateMVRefresh.SQLCreateMVRefreshOnStatementItem x) {
        print(SQLReserved.ON_STATEMENT);
        return false;
    }

    @Override
    public boolean visit(SQLCreateMVRefresh.SQLCreateMVRefreshStartWithItem x) {
        print(SQLReserved.START_WITH);
        printSpaceAfterAccept(x.getValue());
        return false;
    }

    @Override
    public boolean visit(SQLCreateMVRefresh.SQLCreateMVRefreshNextItem x) {
        print(SQLReserved.NEXT);
        printSpaceAfterAccept(x.getValue());
        return false;
    }

    @Override
    public boolean visit(SQLCreateMVRefresh.SQLCreateMVRefreshWithPrimaryKeyItem x) {
        print(SQLReserved.WITH_PRIMARY_KEY);
        return false;
    }

    @Override
    public boolean visit(SQLCreateMVRefresh.SQLCreateMVRefreshWithRowidItem x) {
        print(SQLReserved.WITH_ROWID);
        return false;
    }

    @Override
    public boolean visit(SQLCreateMVRefresh.SQLCreateMVRefreshUsingRollbackSegmentItem x) {
        print(SQLReserved.USING);
        printSpaceAfterAccept(x.getItems(), " ");
        return false;
    }

    @Override
    public boolean visit(SQLCreateMVRefresh.SQLUsingRollbackSegmentByDefaultItem x) {
        print(SQLReserved.DEFAULT);
        printSpaceAfterValue(x.getOptionType());

        printSpaceAfterValue(SQLReserved.ROLLBACK_SEGMENT);
        return false;
    }

    @Override
    public boolean visit(SQLCreateMVRefresh.SQLUsingRollbackSegmentByNoDefaultItem x) {
        SQLCreateMVRefresh.SQLUsingRollbackSegmentOptionType optionType = x.getOptionType();
        if (optionType != null) {
            print(optionType);
            printSpace();
        }

        print(SQLReserved.ROLLBACK_SEGMENT);
        printSpaceAfterAccept(x.getName());
        return false;
    }

    @Override
    public boolean visit(SQLCreateMVRefresh.SQLCreateMVRefreshUsingEnforcedConstraintsItem x) {
        print(SQLReserved.USING_ENFORCED_CONSTRAINTS);
        return false;
    }

    @Override
    public boolean visit(SQLCreateMVRefresh.SQLCreateMVRefreshUsingTrustedConstraintsItem x) {
        print(SQLReserved.USING_TRUSTED_CONSTRAINTS);
        return false;
    }

    @Override
    public boolean visit(SQLOnQueryComputationClause x) {
        print(x.getAction());
        printSpaceAfterValue(SQLReserved.ON_QUERY_COMPUTATION);
        return false;
    }

    @Override
    public boolean visit(SQLQueryRewriteClause x) {
        print(x.getAction().name);
        printSpaceAfterValue(SQLReserved.QUERY_REWRITE);
        printSpaceAfterAccept(x.getUnusableEditionsClause());
        return false;
    }

    // ------------------ Materialized View Details End ----------------------


    // ------------------ Select Details Start ----------------------

    @Override
    public boolean visit(SQLGroupByClause x) {
        boolean print = false;

        List<SQLGroupByClause.SQLGroupByItem> items = x.getItems();
        SQLHavingClause havingClause = x.getHavingClause();

        if (x.isOrder()) {

            if (items.size() > 0) {
                printGroupByList(items);
                if (x.isWithRollup()) {
                    printSpaceAfterValue(SQLReserved.WITH_ROLLUP);
                }
                print = true;
            }

            if (havingClause != null) {
                if (print) {
                    println();
                }
                havingClause.accept(this);
            }

        } else {

            if (havingClause != null) {
                havingClause.accept(this);
                print = true;
            }

            if (items.size() > 0) {
                if (print) {
                    println();
                }
                printGroupByList(items);
            }
        }
        return false;
    }

    public void printGroupByList(List<SQLGroupByClause.SQLGroupByItem> items) {
        if (items == null
                || items.size() == 0) {
            return;
        }
        print(SQLReserved.GROUP_BY);
        printSpace();
        printAccept(items, ", ");
    }


    @Override
    public boolean visit(SQLGroupByClause.SQLGroupByItem x) {
        x.getExpr().accept(this);
        return false;
    }

    @Override
    public boolean visit(SQLGroupingSetsClause x) {
        print(SQLReserved.GROUPING_SETS);
        printSpaceAndLnAndAccept(x.getArguments(), ",", true);
        return false;
    }

    @Override
    public boolean visit(SQLHavingClause x) {
        print(SQLReserved.HAVING);

        printSpace();
        x.getCondition().accept(this);
        return false;
    }


    @Override
    public boolean visit(SQLLimitOffsetClause x) {
        print(SQLReserved.LIMIT);

        boolean isOffset = x.isOffset();
        SQLExpr offset = x.getOffsetExpr();
        if (offset != null
                && !isOffset) {
            printSpace();
            offset.accept(this);
            print(",");
        }

        printSpaceAfterAccept(x.getRowCountExpr());

        if (offset != null
                && isOffset) {
            printSpace();
            print(SQLReserved.OFFSET);

            printSpaceAfterAccept(offset);

            SQLRowType offSetRowType = x.getOffSetRowType();
            if (offSetRowType != null) {
                printSpace();
                print(offSetRowType.name);
            }

        }
        return false;
    }

    @Override
    public boolean visit(SQLOffsetFetchClause x) {

        boolean print = false;

        SQLExpr offsetExpr = x.getOffsetExpr();
        if (offsetExpr != null) {
            print = true;

            print(SQLReserved.OFFSET);

            printSpace();
            x.getOffsetExpr().accept(this);

            printSpace();
            print(x.getOffSetRowType().name);
        }


        SQLOffsetFetchClause.SQLFetchType fetchType = x.getFetchType();
        if (fetchType != null) {
            if (print) {
                printSpace();
            }

            print(SQLReserved.FETCH);
            printSpace();
            print(fetchType.name());

            printSpace();
            x.getRowCountExpr().accept(this);

            if (x.isPercent()) {
                printSpace();
                print(SQLReserved.PERCENT_KEYWORD);
            }

            printSpace();
            print(x.getFetchRowType().name);

            printSpace();
            print(x.getOnlyType().name);
        }

        return false;
    }

    @Override
    public boolean visit(SQLForUpdateClause x) {
        print(SQLReserved.FOR);

        printSpaceAfterValue(x.getForType().name);

        List<SQLExpr> columns = x.getColumns();
        if (columns.size() > 0) {
            printSpaceAfterValue(SQLReserved.OF);
            printSpaceAfterAccept(columns, ", ");
        }

        printSpaceAfterAccept(x.getForOption());
        return false;
    }

    @Override
    public boolean visit(SQLForUpdateClause.SQLForSkipLockedOption x) {
        print(SQLReserved.SKIP_LOCKED);
        return false;
    }

    @Override
    public boolean visit(SQLForUpdateClause.SQLForNoWaitOption x) {
        print(SQLReserved.NOWAIT);
        return false;
    }

    @Override
    public boolean visit(SQLForUpdateClause.SQLForWaitOption x) {
        print(SQLReserved.WAIT);
        printSpaceAfterAccept(x.getExpr());
        return false;
    }

    @Override
    public boolean visit(SQLLockInShareModeClause x) {
        print(SQLReserved.LOCK_IN_SHARE_MODE);
        return false;
    }

    @Override
    public boolean visit(SQLParenSelectQuery x) {

        print(SQLReserved.LEFT_PAREN);
        this.incrementIndent();
        println();

        x.getQuery().accept(this);

        this.decrementIndent();
        println();
        print(SQLReserved.RIGHT_PAREN);

        SQLOrderByClause orderByClause = x.getOrderByClause();
        if (orderByClause != null) {
            println();
            orderByClause.accept(this);
        }

        ISQLLimitClause limitClause = x.getLimitClause();
        if (limitClause != null) {
            println();
            limitClause.accept(this);
        }

        return false;
    }

    @Override
    public boolean visit(SQLSelectItem x) {
        print(x.getExpr());

        SQLExpr alias = x.getAlias();
        if (alias != null) {
            printSpace();

            if (x.isAs()) {
                print(AS);
                printSpace();
            }

            alias.accept(this);
        }

        return false;
    }

    @Override
    public boolean visit(SQLSelectTargetItem x) {
        x.getExpr().accept(this);
        return false;
    }

    @Override
    public boolean visit(SQLSelectQuery x) {
        ISQLWithClause withClause = x.getWithClause();
        if (withClause != null) {
            withClause.accept(this);
            println();
        }

        print(SQLReserved.SELECT);

        SQLSetQuantifier setQuantifier = x.getSetQuantifier();
        if (setQuantifier != null) {
            printSpace();
            print(setQuantifier.name);
        }

        printSpace();
        printSelectItems(x.getSelectItems());

        printlnAndAccept(x.getFromClause());

        printlnAndAccept(x.getWhereClause());

        printlnAndAccept(x.getGroupByClause());

        printlnAndAccept(x.getWindowClause());

        printlnAndAccept(x.getOrderByClause());

        printlnAndAccept(x.getLimitClause());

        return false;
    }

    public void printSelectItems(List<SQLSelectItem> selectList) {
        int lineLength = 0;

        incrementIndent();
        for (int i = 0; i < selectList.size(); i++) {
            SQLSelectItem selectItem = selectList.get(i);
            int selectItemLength = selectItem.toString().length();
            lineLength += selectItemLength;
            if (i != 0) {
                print(",");
            }
            if (i != 0
                    && lineLength > getLineMaxLength()) {
                println();
                lineLength = selectItemLength;
            } else if (i != 0) {
                printSpace();
            }
            selectItem.accept(this);
        }
        decrementIndent();
    }

    @Override
    public boolean visit(SQLSelectUnionQuery x) {
        x.getLeft().accept(this);

        println();
        print(x.getOperator().name);
        println();

        x.getRight().accept(this);

        SQLOrderByClause orderByClause = x.getOrderByClause();
        if (orderByClause != null) {
            println();
            orderByClause.accept(this);
        }

        ISQLLimitClause limitClause = x.getLimitClause();
        if (orderByClause != null) {
            println();
            limitClause.accept(this);
        }

        return false;
    }

    @Override
    public boolean visit(SQLWithClause x) {
        print(SQLReserved.WITH);

        if (x.isRecursive()) {
            printSpace();
            print(SQLReserved.RECURSIVE);
        }

        List<SQLWithClause.SQLWithElement> withElements = x.getWithElements();
        if (withElements.size() > 0) {
            printSpace();
            printAccept(withElements, ", ");
        }

        return false;
    }

    @Override
    public boolean visit(SQLWithClause.SQLSubQueryFactoringClause x) {

        x.getQueryName().accept(this);

        printSpaceAfterAccept(x.getColumns(), ", ", true);

        printSpaceAfterValue(AS);

        printSpaceAfterValue(SQLReserved.LEFT_PAREN);

        this.incrementIndent();
        println();

        x.getStatement().accept(this);

        this.decrementIndent();
        println();
        print(SQLReserved.RIGHT_PAREN);

        printlnAndAccept(x.getSearchClause());
        printlnAndAccept(x.getCycleClause());

        return false;
    }

    @Override
    public boolean visit(SQLWithClause.SQLSearchClause x) {
        print(SQLReserved.SEARCH);

        printSpaceAfterValue(x.getType());
        printSpaceAfterValue(SQLReserved.FIRST_BY);

        printSpaceAfterAccept(x.getOrderByItems(), ", ");


        printSpaceAfterValue(SQLReserved.SET);
        printSpace();
        x.getColumn().accept(this);

        return false;
    }

    @Override
    public boolean visit(SQLWithClause.SQLCycleClause x) {
        print(SQLReserved.CYCLE);

        printSpaceAfterAccept(x.getCycleColumns(), ", ");

        printSpaceAfterValue(SQLReserved.SET);
        printSpace();
        x.getCycleMarkColumn().accept(this);

        printSpaceAfterValue(SQLReserved.TO);
        printSpace();
        x.getCycleMarkValue().accept(this);

        printSpaceAfterValue(SQLReserved.DEFAULT);
        printSpace();
        x.getNonCycleMarkValue().accept(this);

        return false;
    }

    // ------------------ Select Details End ----------------------


    // ------------------ Sequence Details Start ----------------------
    @Override
    public boolean visit(SQLAsDataTypeOption x) {
        print(AS);

        printSpace();
        x.getDataType().accept(this);

        return false;
    }

    @Override
    public boolean visit(SQLSequenceCacheOption x) {

        print(SQLReserved.CACHE);

        printSpace();
        x.getCache().accept(this);

        return false;
    }

    @Override
    public boolean visit(SQLSequenceCycleOption x) {
        print(SQLReserved.CYCLE);
        return false;
    }

    @Override
    public boolean visit(SQLSequenceGlobalOption x) {
        print(SQLReserved.GLOBAL);
        return false;
    }

    @Override
    public boolean visit(SQLSequenceIncrementByOption x) {
        print(SQLReserved.INCREMENT);

        if (x.isBy()) {
            printSpace();
            print(SQLReserved.BY);
        }


        printSpace();
        x.getIncrementBy().accept(this);

        return false;
    }

    @Override
    public boolean visit(SQLSequenceKeepOption x) {
        print(SQLReserved.KEEP);
        return false;
    }

    @Override
    public boolean visit(SQLSequenceMaxValueOption x) {
        print(SQLReserved.MAXVALUE);

        printSpaceAfterAccept(x.getMaxValue());
        return false;
    }

    @Override
    public boolean visit(SQLSequenceMinValueOption x) {
        print(SQLReserved.MINVALUE);

        printSpaceAfterAccept(x.getMinValue());
        return false;
    }

    @Override
    public boolean visit(SQLSequenceNoCacheOption x) {
        print(SQLReserved.NOCACHE);
        return false;
    }

    @Override
    public boolean visit(SQLSequenceNoCycleOption x) {
        print(SQLReserved.NO_CYCLE);
        return false;
    }

    @Override
    public boolean visit(SQLSequenceNoKeepOption x) {
        print(SQLReserved.NOKEEP);
        return false;
    }

    @Override
    public boolean visit(SQLSequenceNoMaxValueOption x) {
        print(SQLReserved.NO_MAXVALUE);
        return false;
    }

    @Override
    public boolean visit(SQLSequenceNoMinValueOption x) {
        print(SQLReserved.NO_MINVALUE);
        return false;
    }

    @Override
    public boolean visit(SQLNoneOption x) {
        print(SQLReserved.NONE);
        return false;
    }

    @Override
    public boolean visit(SQLSequenceNoOrderOption x) {
        print(SQLReserved.NOORDER);
        return false;
    }

    @Override
    public boolean visit(SQLSequenceOrderOption x) {
        print(SQLReserved.ORDER);
        return false;
    }

    @Override
    public boolean visit(SQLOwnedByOption x) {
        print(SQLReserved.OWNED_BY);
        printSpaceAfterAccept(x.getOwnedBy());
        return false;
    }

    @Override
    public boolean visit(SQLOwnedToOption x) {
        print(SQLReserved.OWNED_TO);
        printSpaceAfterAccept(x.getNewName());
        return false;
    }

    @Override
    public boolean visit(SQLRenameToClause x) {
        print(SQLReserved.RENAME_TO);
        printSpaceAfterAccept(x.getNewName());
        return false;
    }

    @Override
    public boolean visit(SQLReStartWithOption x) {
        print(SQLReserved.RESTART);

        if (x.isWith()) {
            printSpace();
            print(SQLReserved.WITH);
        }

        printSpace();
        x.getRestartWith().accept(this);
        return false;
    }

    @Override
    public boolean visit(SQLNoScaleOption x) {
        print(SQLReserved.NOSCALE);
        return false;
    }

    @Override
    public boolean visit(SQLScaleOption x) {
        print(SQLReserved.SCALE);
        printSpaceAfterValue(x.getType().name);
        return false;
    }

    @Override
    public boolean visit(SQLSequenceSessionOption x) {
        print(SQLReserved.SESSION);
        return false;
    }

    @Override
    public boolean visit(SQLSetSchemaOption x) {
        print(SQLReserved.SET_SCHEMA);

        printSpace();
        x.getSetSchema().accept(this);
        return false;
    }

    @Override
    public boolean visit(SQLSequenceStartWithOption x) {

        print(SQLReserved.START);

        if (x.isWith()) {
            printSpaceAfterValue(SQLReserved.WITH);
        }

        printSpace();
        x.getStartWith().accept(this);
        return false;
    }
    // ------------------ Sequence Details End ----------------------


    // ------------------ Table Details Start ----------------------

    @Override
    public boolean visit(SQLColumnDefinition x) {
        print(x.getName());
        printSpaceAfterAccept(x.getDataType());
        printSpaceAfterAccept(x.getReferenceScopeCheck());

        printSpaceAfterAccept(x.getDefaultExpr());

        printColumnConstraints(x.getColumnConstraints());
        printSpaceAfterAccept(x.getCollateClause());
        printSpaceAfterAccept(x.getCommentClause());
        return false;
    }

    public void printColumnConstraints(List<ISQLColumnConstraint> columnConstraints) {
        printSpaceAfterAccept(columnConstraints, " ");
    }


    @Override
    public boolean visit(SQLVirtualColumnDefinition x) {
        print(x.getColumn());
        printSpaceAfterAccept(x.getDataType());
        printSpaceAfterAccept(x.getCollateClause());
        printSpaceAfterValue(x.getVisible());

        if (x.isGeneratedAlways()) {
            printSpaceAfterValue(SQLReserved.GENERATED);
            printSpaceAfterValue(SQLReserved.ALWAYS);
        }
        printSpaceAfterValue(SQLReserved.AS);
        printSpaceAfterValue(SQLReserved.LEFT_PAREN);
        print(x.getExpr());
        print(SQLReserved.RIGHT_PAREN);

        printSpaceAfterValue(x.getVirtual());

        printSpaceAfterAccept(x.getEvaluationEditionClause());
        printSpaceAfterAccept(x.getUnusableEditionsClause());

        printSpaceAfterAccept(x.getColumnConstraints(), " ");
        return false;
    }

    @Override
    public boolean visit(SQLLikeClause x) {
        print(SQLReserved.LIKE);
        printSpaceAfterAccept(x.getName());
        printlnAfterValue(x.getOptions());
        return false;
    }

    @Override
    public boolean visit(SQLPartitionByConsistentHash x) {
        print(SQLReserved.PARTITION_BY);

        if (x.isLinear()) {
            printSpaceAfterValue(SQLReserved.LINEAR);
        }

        printSpaceAfterValue(SQLReserved.CONSISTENT_HASH);
        printSpaceAfterAccept(x.getColumns(), ", ", true);

        SQLExpr partitionsQuantity = x.getPartitionsNum();
        if (partitionsQuantity != null) {
            printlnAfterValue(SQLReserved.PARTITIONS);
            printSpaceAfterAccept(partitionsQuantity);
        }

        printlnAndAccept(x.getSubPartitionBy());

        printSpaceAndLnAndAccept(x.getPartitions(), ",", true);
        return false;
    }

    @Override
    public boolean visit(SQLPartitionByHash x) {
        print(SQLReserved.PARTITION_BY);

        if (x.isLinear()) {
            printSpaceAfterValue(SQLReserved.LINEAR);
        }

        printSpaceAfterValue(SQLReserved.HASH);
        printSpaceAfterAccept(x.getColumns(), ", ", true);

        SQLExpr partitionsNum = x.getPartitionsNum();
        if (partitionsNum != null) {
            printSpace();
            printPartitionsNum(partitionsNum);
        }

        printlnAndAccept(x.getSubPartitionBy());

        printSpaceAndLnAndAccept(x.getPartitions(), ",", true);
        return false;
    }

    @Override
    public boolean visit(SQLPartitionByKey x) {
        print(SQLReserved.PARTITION_BY);

        if (x.isLinear()) {
            printSpaceAfterValue(SQLReserved.LINEAR);
        }

        printSpaceAfterValue(SQLReserved.KEY);
        printSpaceAfterAccept(x.getColumns(), ", ", true);

        SQLExpr partitionsNum = x.getPartitionsNum();
        if (partitionsNum != null) {
            printSpace();
            printPartitionsNum(partitionsNum);
        }

        printlnAndAccept(x.getSubPartitionBy());

        printSpaceAndLnAndAccept(x.getPartitions(), ",", true);

        return false;
    }

    @Override
    public boolean visit(SQLPartitionByList x) {
        print(SQLReserved.PARTITION_BY);

        if (x.isLinear()) {
            printSpaceAfterValue(SQLReserved.LINEAR);
        }

        printSpaceAfterValue(SQLReserved.LIST);
        printSpaceAfterAccept(x.getColumns(), ", ", true);

        SQLExpr partitionsNum = x.getPartitionsNum();
        if (partitionsNum != null) {
            printSpace();
            printPartitionsNum(partitionsNum);
        }

        printlnAndAccept(x.getSubPartitionBy());

        printSpaceAndLnAndAccept(x.getPartitions(), ",", true);

        return false;
    }

    @Override
    public boolean visit(SQLPartitionByListColumns x) {
        print(SQLReserved.PARTITION_BY);

        if (x.isLinear()) {
            printSpaceAfterValue(SQLReserved.LINEAR);
        }

        printSpaceAfterValue(SQLReserved.LIST_COLUMNS);
        printSpaceAfterAccept(x.getColumns(), ", ", true);

        SQLExpr partitionsNum = x.getPartitionsNum();
        if (partitionsNum != null) {
            printSpace();
            printPartitionsNum(partitionsNum);
        }

        printlnAndAccept(x.getSubPartitionBy());

        printSpaceAndLnAndAccept(x.getPartitions(), ",", true);

        return false;
    }

    @Override
    public boolean visit(SQLPartitionByRange x) {
        print(SQLReserved.PARTITION_BY);

        if (x.isLinear()) {
            printSpaceAfterValue(SQLReserved.LINEAR);
        }

        printSpaceAfterValue(SQLReserved.RANGE);
        printSpaceAfterAccept(x.getColumns(), ", ", true);

        SQLExpr interval = x.getInterval();
        if (interval != null) {
            printSpaceAfterValue(SQLReserved.INTERVAL);
            printSpaceAfterAccept(x.getInterval());
        }


        SQLExpr partitionsNum = x.getPartitionsNum();
        if (partitionsNum != null) {
            printSpace();
            printPartitionsNum(partitionsNum);
        }

        printlnAndAccept(x.getSubPartitionBy());

        printSpaceAndLnAndAccept(x.getPartitions(), ",", true);

        return false;
    }

    @Override
    public boolean visit(SQLPartitionByRangeColumns x) {
        print(SQLReserved.PARTITION_BY);

        if (x.isLinear()) {
            printSpaceAfterValue(SQLReserved.LINEAR);
        }

        printSpaceAfterValue(SQLReserved.RANGE_COLUMNS);
        printSpaceAfterAccept(x.getColumns(), ", ", true);

        SQLExpr partitionsNum = x.getPartitionsNum();
        if (partitionsNum != null) {
            printSpace();
            printPartitionsNum(partitionsNum);
        }

        printlnAndAccept(x.getSubPartitionBy());

        printSpaceAndLnAndAccept(x.getPartitions(), ",", true);

        return false;
    }

    @Override
    public boolean visit(SQLPartitionByReference x) {
        print(SQLReserved.PARTITION_BY);

        if (x.isLinear()) {
            printSpaceAfterValue(SQLReserved.LINEAR);
        }

        printSpaceAfterValue(SQLReserved.REFERENCE);
        printSpaceAfterAccept(x.getColumns(), ", ", true);

        SQLExpr partitionsNum = x.getPartitionsNum();
        if (partitionsNum != null) {
            printSpace();
            printPartitionsNum(partitionsNum);
        }

        printlnAndAccept(x.getSubPartitionBy());

        printSpaceAndLnAndAccept(x.getPartitions(), ",", true);
        return false;
    }

    @Override
    public boolean visit(SQLPartitionBySystem x) {
        print(SQLReserved.PARTITION_BY);

        if (x.isLinear()) {
            printSpaceAfterValue(SQLReserved.LINEAR);
        }

        printSpaceAfterValue(SQLReserved.SYSTEM);
        printSpaceAfterAccept(x.getColumns(), ", ", true);

        SQLExpr partitionsNum = x.getPartitionsNum();
        if (partitionsNum != null) {
            printSpace();
            printPartitionsNum(partitionsNum);
        }

        printlnAndAccept(x.getSubPartitionBy());

        printSpaceAndLnAndAccept(x.getPartitions(), ",", true);
        return false;
    }

    public void printPartitionsNum(SQLExpr partitionsNum) {
        if (partitionsNum != null) {
            print(SQLReserved.PARTITIONS);
            printSpaceAfterAccept(partitionsNum);
        }
    }

    @Override
    public boolean visit(SQLPartitionDefinition x) {
        print(SQLReserved.PARTITION);
        printSpaceAfterAccept(x.getName());
        printSpaceAfterAccept(x.getValues());


        this.incrementIndent();

        List<SQLExpr> option = x.getOptions();
        if (option != null
                && option.size() > 0) {
            println();
            printlnAndAccept(x.getOptions());
        }

        SQLExpr subpartitionsQuantity = x.getSubpartitionsNum();
        if (subpartitionsQuantity != null) {
            printlnAfterValue(SQLReserved.SUBPARTITIONS);
            printSpaceAfterAccept(subpartitionsQuantity);

        }
        printlnAndAccept(x.getStoreInClause());
        this.decrementIndent();

        printSpaceAndLnAndAccept(x.getSubPartitions(), ",", true);
        return false;
    }


    @Override
    public boolean visit(SQLPartitionsetByList x) {
        print(SQLReserved.PARTITIONSET_BY);
        printSpaceAfterValue(SQLReserved.LIST);

        printSpaceAfterAccept(x.getColumns(), ", ", true);

        printlnAndAccept(x.getPartitionBy());

        printlnAndAccept(x.getSubPartitionBy());

        printlnAfterValue(SQLReserved.PARTITIONS_AUTO);
        printSpaceAndLnAndAccept(x.getPartitionsets(), ",", true);

        return false;
    }

    @Override
    public boolean visit(SQLPartitionsetByRange x) {
        print(SQLReserved.PARTITIONSET_BY);
        printSpaceAfterValue(SQLReserved.RANGE);

        printSpaceAfterAccept(x.getColumns(), ", ", true);

        printlnAndAccept(x.getPartitionBy());

        printlnAndAccept(x.getSubPartitionBy());

        printlnAfterValue(SQLReserved.PARTITIONS_AUTO);
        printSpaceAndLnAndAccept(x.getPartitionsets(), ",", true);

        return false;
    }

    @Override
    public boolean visit(SQLPartitionsetDefinition x) {
        print(SQLReserved.PARTITIONSET);
        printSpaceAfterAccept(x.getName());
        printSpaceAfterAccept(x.getValues());

        printIndentAndLnAndAccept(x.getOptions());
        return false;
    }


    @Override
    public boolean visit(SQLSubPartitionByHash x) {
        print(SQLReserved.SUBPARTITION_BY);

        if (x.isLinear()) {
            printSpaceAfterValue(SQLReserved.LINEAR);
        }

        printSpaceAfterValue(SQLReserved.HASH);

        printSpaceAfterAccept(x.getColumns(), ", ", true);

        SQLExpr subpartitionsQuantity = x.getSubpartitionsNum();
        if (subpartitionsQuantity != null) {
            printlnAfterValue(SQLReserved.SUBPARTITIONS);
            printSpaceAfterAccept(subpartitionsQuantity);
        }

        printlnAndAccept(x.getSubpartitionTemplate());

        return false;
    }

    @Override
    public boolean visit(SQLSubPartitionByKey x) {
        print(SQLReserved.SUBPARTITION_BY);

        if (x.isLinear()) {
            printSpaceAfterValue(SQLReserved.LINEAR);
        }

        printSpaceAfterValue(SQLReserved.KEY);

        SQLExpr algorithm = x.getAlgorithm();
        if (algorithm != null) {
            printSpaceAfterValue(SQLReserved.ALGORITHM);
            printSpaceAfterValue(SQLReserved.EQUALS_OP);
            printSpaceAfterAccept(algorithm);
        }

        printSpaceAfterAccept(x.getColumns(), ", ", true);

        SQLExpr subpartitionsQuantity = x.getSubpartitionsNum();
        if (subpartitionsQuantity != null) {
            printlnAfterValue(SQLReserved.SUBPARTITIONS);
            printSpaceAfterAccept(subpartitionsQuantity);
        }

        printlnAndAccept(x.getSubpartitionTemplate());
        return false;
    }

    @Override
    public boolean visit(SQLSubPartitionByList x) {
        print(SQLReserved.SUBPARTITION_BY);

        if (x.isLinear()) {
            printSpaceAfterValue(SQLReserved.LINEAR);
        }

        printSpaceAfterValue(SQLReserved.LIST);
        printSpaceAfterAccept(x.getColumns(), ", ", true);


        SQLExpr subpartitionsQuantity = x.getSubpartitionsNum();
        if (subpartitionsQuantity != null) {
            printlnAfterValue(SQLReserved.SUBPARTITIONS);
            printSpaceAfterAccept(subpartitionsQuantity);
        }

        printlnAndAccept(x.getSubpartitionTemplate());
        return false;
    }

    @Override
    public boolean visit(SQLSubPartitionByRange x) {
        print(SQLReserved.SUBPARTITION_BY);

        if (x.isLinear()) {
            printSpaceAfterValue(SQLReserved.LINEAR);
        }

        printSpaceAfterValue(SQLReserved.RANGE);
        printSpaceAfterAccept(x.getColumns(), ", ", true);

        SQLExpr subpartitionsQuantity = x.getSubpartitionsNum();
        if (subpartitionsQuantity != null) {
            printlnAfterValue(SQLReserved.SUBPARTITIONS);
            printSpaceAfterAccept(subpartitionsQuantity);
        }

        printlnAndAccept(x.getSubpartitionTemplate());
        return false;
    }

    @Override
    public boolean visit(SQLSubpartitionTemplate x) {
        print(SQLReserved.SUBPARTITION_TEMPLATE);
        printSpaceAndLnAndAccept(x.getSubPartitions(), ",", true);
        return false;
    }

    @Override
    public boolean visit(SQLSubPartitionDefinition x) {
        print(SQLReserved.SUBPARTITION);
        printSpaceAfterAccept(x.getName());
        printSpaceAfterAccept(x.getValues());

        printIndentAndLnAndAccept(x.getOptions());
        return false;
    }

    @Override
    public boolean visit(SQLPartitionValuesLessThan x) {
        print(SQLReserved.VALUES_LESS_THAN);
        printSpaceAfterAccept(x.getValues(), ", ", true);
        return false;
    }

    @Override
    public boolean visit(SQLPartitionValuesLessThanMaxValue x) {
        print(SQLReserved.VALUES_LESS_THAN);
        printSpaceAfterValue(SQLReserved.MAXVALUE);
        return false;
    }

    @Override
    public boolean visit(SQLPartitionValuesIn x) {
        print(SQLReserved.VALUES_IN);
        printSpaceAfterAccept(x.getValues(), ", ", true);
        return false;
    }

    @Override
    public boolean visit(SQLPartitionValues x) {
        print(SQLReserved.VALUES);
        printSpaceAfterAccept(x.getValues(), ", ", true);
        return false;
    }


    @Override
    public boolean visit(SQLIdentityClause x) {
        print(SQLReserved.GENERATED);

        SQLIdentityClause.IdentityAction action = x.getAction();
        if (action != null) {
            printSpaceAfterValue(action.name);
        }

        printSpaceAfterValue(SQLReserved.AS_IDENTITY);
        printSpaceAndLnAndAccept(x.getOptions(), "", true);
        return false;
    }

    @Override
    public boolean visit(SQLIdentityStartWithOption x) {
        print(SQLReserved.START_WITH);
        printSpaceAfterAccept(x.getValue());
        return false;
    }

    @Override
    public boolean visit(SQLIdentityIncrementByOption x) {
        print(SQLReserved.INCREMENT_BY);
        printSpaceAfterAccept(x.getValue());
        return false;
    }

    @Override
    public boolean visit(SQLIdentityMaxValueOption x) {
        print(SQLReserved.MAXVALUE);
        printSpaceAfterAccept(x.getValue());
        return false;
    }

    @Override
    public boolean visit(SQLIdentityNoMaxValueOption x) {
        print(SQLReserved.NOMAXVALUE);
        return false;
    }

    @Override
    public boolean visit(SQLIdentityMinValueOption x) {
        print(SQLReserved.MINVALUE);
        printSpaceAfterAccept(x.getValue());
        return false;
    }

    @Override
    public boolean visit(SQLIdentityNoMinValueOption x) {
        print(SQLReserved.NOMINVALUE);
        return false;
    }

    @Override
    public boolean visit(SQLIdentityCycleOption x) {
        print(SQLReserved.CYCLE);
        return false;
    }

    @Override
    public boolean visit(SQLIdentityNoCycleOption x) {
        print(SQLReserved.NOCYCLE);
        return false;
    }

    @Override
    public boolean visit(SQLIdentityCacheOption x) {
        print(SQLReserved.CACHE);
        printSpaceAfterAccept(x.getValue());
        return false;
    }

    @Override
    public boolean visit(SQLIdentityNoCacheOption x) {
        print(SQLReserved.NOCACHE);
        return false;
    }

    @Override
    public boolean visit(SQLIdentityOrderOption x) {
        print(SQLReserved.ORDER);
        return false;
    }

    @Override
    public boolean visit(SQLIdentityNoOrderOption x) {
        print(SQLReserved.NOORDER);
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableRenameTableAction x) {
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableAddColumnAction x) {
        print(SQLReserved.ADD);

        if (x.isColumn()) {
            printSpaceAfterValue(SQLReserved.COLUMN);
        }

        if (x.isIfNotExists()) {
            printSpaceAfterValue(SQLReserved.IF_NOT_EXISTS);
        }

        printSpaceAfterAccept(x.getColumns(), ", ", x.isParen());

        List<SQLExpr> properties = x.getProperties();
        if (properties != null
                && properties.size() > 0) {
            println();
            printlnAndAccept(x.getProperties());
        }

        printlnAndAccept(x.getPartitions(), ",", true);

        return false;
    }

    @Override
    public boolean visit(SQLAlterTableAddColumnAction.SQLFirstPropertyExpr x) {
        print(SQLReserved.FIRST);
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableAddColumnAction.SQLAfterPropertyExpr x) {
        print(SQLReserved.AFTER);

        printSpace();
        x.getName().accept(this);
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableChangeColumnAction x) {
        print(SQLReserved.CHANGE);
        if (x.isColumn()) {
            printSpaceAfterValue(SQLReserved.COLUMN);
        }
        printSpaceAfterAccept(x.getName());
        printSpaceAfterAccept(x.getColumnDefinition());
        printSpaceAfterAccept(x.getProperty());
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableAlterColumnAction x) {
        print(SQLReserved.ALTER);
        if (x.isColumn()) {
            printSpaceAfterValue(SQLReserved.COLUMN);
        }

        printSpaceAfterAccept(x.getAction());

        return false;
    }


    @Override
    public boolean visit(SQLAlterTableAlterColumnAction.SQLSetColumnDefaultClause x) {
        print(SQLReserved.SET);
        printSpaceAfterValue(SQLReserved.DEFAULT);
        printSpaceAfterAccept(x.getValue());
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableAlterColumnAction.SQLDropColumnDefaultClause x) {
        print(SQLReserved.DROP);
        printSpaceAfterValue(SQLReserved.DEFAULT);
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableAlterColumnAction.SQLAddColumnScopeClause x) {
        print(SQLReserved.ADD);
        printSpaceAfterAccept(x.getScopeClause());
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableAlterColumnAction.SQLDropColumnScopeClause x) {
        print(SQLReserved.DROP);
        printSpaceAfterValue(SQLReserved.SCOPE);
        printSpaceAfterValue(x.getAction());
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableRenameColumnAction x) {
        print(SQLReserved.RENAME);
        if (x.isColumn()) {
            printSpaceAfterValue(SQLReserved.COLUMN);
        }

        printSpaceAfterAccept(x.getName());
        printSpaceAfterValue(SQLReserved.TO);
        printSpaceAfterAccept(x.getNewName());
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableSetUnusedColumnAction x) {
        print(SQLReserved.SET);
        printSpaceAfterValue(SQLReserved.UNUSED);
        if (x.isColumn()) {
            printSpaceAfterValue(SQLReserved.COLUMN);
        }


        if (x.isParen()) {
            printSpaceAfterValue(SQLReserved.LEFT_PAREN);
        }
        printSpaceAfterAccept(x.getColumns(), ", ");
        if (x.isParen()) {
            print(SQLReserved.RIGHT_PAREN);
        }

        printlnAfterValue(x.getOptions());

        if (x.isOnline()) {
            printSpaceAfterValue(SQLReserved.ONLINE);
        }
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableDropColumnAction x) {
        print(SQLReserved.DROP);
        if (x.isColumn()) {
            printSpaceAfterValue(SQLReserved.COLUMN);
        }

        if (x.isIfExists()) {
            printSpaceAfterValue(SQLReserved.IF_EXISTS);
        }

        printSpaceAfterAccept(x.getNames(), ", ", x.isParen());

        printSpaceAfterValue(x.getOptions(), " ");
        printSpaceAfterValue(x.getBehavior());

        return false;
    }

    @Override
    public boolean visit(SQLAlterTableDropColumnsContinueAction x) {
        print(SQLReserved.DROP);
        printSpaceAfterValue(SQLReserved.COLUMNS);
        printSpaceAfterValue(SQLReserved.CONTINUE);

        SQLExpr checkPoint = x.getCheckPoint();
        if (checkPoint != null) {
            printSpaceAfterValue(SQLReserved.CHECKPOINT);
            printSpaceAfterAccept(checkPoint);
        }
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableDropUnusedColumnsAction x) {
        print(SQLReserved.DROP);
        printSpaceAfterValue(SQLReserved.UNUSED);
        printSpaceAfterValue(SQLReserved.COLUMNS);

        SQLExpr checkPoint = x.getCheckPoint();
        if (checkPoint != null) {
            printSpaceAfterValue(SQLReserved.CHECKPOINT);
            printSpaceAfterAccept(checkPoint);
        }
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableModifyCollectionRetrievalAction x) {
        print(SQLReserved.MODIFY);
        printSpaceAfterValue(SQLReserved.NESTED_TABLE);
        printSpaceAfterAccept(x.getName());
        printSpaceAfterValue(SQLReserved.RETURN);
        printSpaceAfterValue(SQLReserved.AS);
        printSpaceAfterValue(x.getOption());
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableModifyColumnsAction x) {
        print(SQLReserved.MODIFY);
        printSpaceAfterAccept(x.getColumns(), ", ", true);
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableModifyColumnAction x) {
        print(SQLReserved.MODIFY);
        printSpaceAfterValue(SQLReserved.COLUMN);
        printSpaceAfterAccept(x.getColumn());
        printSpaceAfterAccept(x.getSubstitution());
        if (x.isForce()) {
            printSpaceAfterValue(SQLReserved.FORCE);
        }
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableModifyLobStorageAction x) {
        print(SQLReserved.MODIFY);
        printSpaceAfterValue(SQLReserved.LOB);

        printSpaceAfterValue(SQLReserved.LEFT_PAREN);
        print(x.getName());
        print(SQLReserved.RIGHT_PAREN);

        printSpaceAndLnAndAccept(x.getParameters(), "", true);
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableOrderByColumnAction x) {
        print(SQLReserved.ORDER_BY);
        printSpaceAfterAccept(x.getNames(), ", ");
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableAlterVarrayColPropertyAction x) {
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableAddTableConstraintAction x) {
        print(SQLReserved.ADD);

        printSpace();
        if (x.isParen()) {
            print(SQLReserved.LEFT_PAREN);
        }

        printAccept(x.getConstraints(), " ");

        if (x.isParen()) {
            print(SQLReserved.RIGHT_PAREN);
        }

        if (x.isNotValid()) {
            printSpaceAfterValue(SQLReserved.NOT_VALID);
        }
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableAlterIndexConstraintAction x) {
        print(SQLReserved.ALTER);
        printSpaceAfterValue(SQLReserved.INDEX);
        printSpaceAfterAccept(x.getName());
        printSpaceAfterValue(x.getVisible());
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableConstraintAction x) {
        print(SQLReserved.ALTER);
        printSpaceAfterValue(SQLReserved.CONSTRAINT);
        printSpaceAfterAccept(x.getName());
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableDropIndexConstraintAction x) {
        print(SQLReserved.DROP);
        printSpaceAfterValue(SQLReserved.INDEX);
        printSpaceAfterAccept(x.getName());
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableDropKeyConstraintAction x) {
        print(SQLReserved.DROP);
        printSpaceAfterValue(SQLReserved.KEY);
        printSpaceAfterAccept(x.getName());
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableDropPrimaryKeyConstraintAction x) {
        print(SQLReserved.DROP);
        printSpaceAfterValue(SQLReserved.PRIMARY_KEY);

        printSpaceAfterValue(x.getCascade());
        printSpaceAfterValue(x.getIndex());
        if (x.isOnline()) {
            printSpaceAfterValue(SQLReserved.ONLINE);
        }
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableDropTableConstraintAction x) {
        print(SQLReserved.DROP);
        printSpaceAfterValue(SQLReserved.CONSTRAINT);
        if (x.isIfExists()) {
            printSpaceAfterValue(SQLReserved.IF_EXISTS);
        }
        printSpaceAfterAccept(x.getName());

        printSpaceAfterValue(x.getCascade());
        if (x.isOnline()) {
            printSpaceAfterValue(SQLReserved.ONLINE);
        }
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableDropUniqueConstraintAction x) {
        print(SQLReserved.DROP);
        printSpaceAfterValue(SQLReserved.UNIQUE);

        printSpaceAfterAccept(x.getColumns(), ", ", true);

        printSpaceAfterValue(x.getCascade());
        printSpaceAfterValue(x.getIndex());
        if (x.isOnline()) {
            printSpaceAfterValue(SQLReserved.ONLINE);
        }
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableModifyPrimaryKeyConstraintAction x) {
        print(SQLReserved.MODIFY);
        printSpaceAfterValue(SQLReserved.PRIMARY_KEY);

        printSpaceAfterAccept(x.getOptions(), " ");

        if (x.isCascade()) {
            printSpaceAfterValue(SQLReserved.CASCADE);
        }
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableModifyTableConstraintAction x) {
        print(SQLReserved.MODIFY);
        printSpaceAfterValue(SQLReserved.CONSTRAINT);
        printSpaceAfterAccept(x.getName());

        printSpaceAfterAccept(x.getOptions(), " ");

        if (x.isCascade()) {
            printSpaceAfterValue(SQLReserved.CASCADE);
        }
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableModifyUniqueConstraintAction x) {
        print(SQLReserved.MODIFY);
        printSpaceAfterValue(SQLReserved.UNIQUE);
        printSpaceAfterAccept(x.getColumns(), ", ", true);

        printSpaceAfterAccept(x.getOptions(), " ");

        if (x.isCascade()) {
            printSpaceAfterValue(SQLReserved.CASCADE);
        }
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableRenameIndexConstraintAction x) {
        print(SQLReserved.RENAME);
        printSpaceAfterValue(SQLReserved.INDEX);
        printSpaceAfterAccept(x.getName());
        printSpaceAfterValue(SQLReserved.TO);
        printSpaceAfterAccept(x.getNewName());
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableRenameKeyConstraintAction x) {
        print(SQLReserved.RENAME);
        printSpaceAfterValue(SQLReserved.KEY);
        printSpaceAfterAccept(x.getName());
        printSpaceAfterValue(SQLReserved.TO);
        printSpaceAfterAccept(x.getNewName());
        return false;
    }


    @Override
    public boolean visit(SQLAlterTableRenameTableConstraintAction x) {
        print(SQLReserved.RENAME);
        printSpaceAfterValue(SQLReserved.CONSTRAINT);
        printSpaceAfterAccept(x.getName());
        printSpaceAfterValue(SQLReserved.TO);
        printSpaceAfterAccept(x.getNewName());
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableValidateTableConstraintAction x) {
        print(SQLReserved.VALIDATE);
        printSpaceAfterValue(SQLReserved.CONSTRAINT);
        printSpaceAfterAccept(x.getName());
        return false;
    }


    @Override
    public boolean visit(ISQLAlterTableIotAction.SQLAlterTableCoalesceIotAction x) {
        print(SQLReserved.COALESCE);
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableAddOverflowIotAction x) {
        print(SQLReserved.ADD);
        printSpaceAfterValue(SQLReserved.OVERFLOW);

        printSpaceAfterAccept(x.getPartitions(), " ");
        printSpaceAndLnAndAccept(x.getPartitions(), ",", true);
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableAlterOverflowIotAction x) {
        print(SQLReserved.OVERFLOW);
        printSpaceAfterAccept(x.getItems(), " ");
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableMappingTableIotAction x) {
        print(SQLReserved.MAPPING);
        printSpaceAfterValue(SQLReserved.TABLE);
        printSpaceAfterAccept(x.getExpr());
        return false;
    }

    @Override
    public boolean visit(ISQLAlterTablePartitionAction.SQLForItem x) {
        printSpaceAfterValue(SQLReserved.FOR);
        printSpaceAfterAccept(x.getNames(), ", ", true);
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableAddPartitionAction x) {
        print(SQLReserved.ADD);

        this.incrementIndent();
        println();
        printlnAndAccept(x.getPartitions(), ", ");

        SQLExpr before = x.getBefore();
        if (before != null) {
            printlnAfterValue(SQLReserved.BEFORE);
            printSpaceAfterAccept(before);
        }

        printlnAndAccept(x.getDependentTablesClause());
        this.decrementIndent();
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableCoalescePartitionAction x) {
        print(SQLReserved.COALESCE);
        printSpaceAfterValue(SQLReserved.PARTITION);
        printSpaceAfterAccept(x.getExpr());

        printSpaceAfterAccept(x.getUpdateIndex());
        printSpaceAfterAccept(x.getParallel());
        printSpaceAfterValue(x.getAllowDisallowClustering());
        return false;
    }

    @Override
    public boolean visit(SQLCoalesceSubPartitionAction x) {
        print(SQLReserved.COALESCE);
        printSpaceAfterValue(SQLReserved.SUBPARTITION);
        printSpaceAfterAccept(x.getExpr());

        printSpaceAfterAccept(x.getUpdateIndex());
        printSpaceAfterAccept(x.getParallel());
        printSpaceAfterValue(x.getAllowDisallowClustering());
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableDropPartitionAction x) {
        print(SQLReserved.DROP);
        printSpaceAfterValue(x.getType());
        printSpaceAfterAccept(x.getItems(), ", ");
        printSpaceAfterAccept(x.getParallel());
        return false;
    }


    @Override
    public boolean visit(SQLAlterTableDropSubPartitionAction x) {
        print(SQLReserved.DROP);
        printSpaceAfterValue(x.getType());
        printSpaceAfterAccept(x.getItems(), ", ");
        printSpaceAfterAccept(x.getParallel());
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableExchangePartitionAction x) {
        print(SQLReserved.EXCHANGE);
        printSpaceAfterValue(SQLReserved.PARTITION);
        printSpaceAfterAccept(x.getName());

        printSpaceAfterValue(SQLReserved.WITH);
        printSpaceAfterValue(SQLReserved.TABLE);
        printSpaceAfterAccept(x.getTable());

        SQLIncludingType indexes = x.getIndexes();
        if (indexes != null) {
            printSpaceAfterValue(indexes);
            printSpaceAfterValue(SQLReserved.INDEXES);
        }

        SQLWithType validation = x.getValidation();
        if (validation != null) {
            printSpaceAfterValue(validation);
            printSpaceAfterValue(SQLReserved.VALIDATION);
        }

        printSpaceAfterAccept(x.getExceptionsClause());
        printSpaceAfterAccept(x.getUpdateIndexClause());
        printSpaceAfterAccept(x.getParallelClause());

        if (x.isCascade()) {
            printSpaceAfterValue(SQLReserved.CASCADE);
        }
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableExchangePartitionForAction x) {
        print(SQLReserved.EXCHANGE);
        printSpaceAfterValue(SQLReserved.PARTITION);
        printSpaceAfterValue(SQLReserved.FOR);
        printSpaceAfterAccept(x.getNames(), ", ", true);

        printSpaceAfterValue(SQLReserved.WITH);
        printSpaceAfterValue(SQLReserved.TABLE);
        printSpaceAfterAccept(x.getTable());

        SQLIncludingType indexes = x.getIndexes();
        if (indexes != null) {
            printSpaceAfterValue(indexes);
            printSpaceAfterValue(SQLReserved.INDEXES);
        }

        SQLWithType validation = x.getValidation();
        if (validation != null) {
            printSpaceAfterValue(validation);
            printSpaceAfterValue(SQLReserved.VALIDATION);
        }

        printSpaceAfterAccept(x.getExceptionsClause());
        printSpaceAfterAccept(x.getUpdateIndexClause());
        printSpaceAfterAccept(x.getParallelClause());

        if (x.isCascade()) {
            printSpaceAfterValue(SQLReserved.CASCADE);
        }
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableExchangeSubPartitionAction x) {
        print(SQLReserved.EXCHANGE);
        printSpaceAfterValue(SQLReserved.SUBPARTITION);
        printSpaceAfterAccept(x.getName());

        printSpaceAfterValue(SQLReserved.WITH);
        printSpaceAfterValue(SQLReserved.TABLE);
        printSpaceAfterAccept(x.getTable());

        SQLIncludingType indexes = x.getIndexes();
        if (indexes != null) {
            printSpaceAfterValue(indexes);
            printSpaceAfterValue(SQLReserved.INDEXES);
        }

        SQLWithType validation = x.getValidation();
        if (validation != null) {
            printSpaceAfterValue(validation);
            printSpaceAfterValue(SQLReserved.VALIDATION);
        }

        printSpaceAfterAccept(x.getExceptionsClause());
        printSpaceAfterAccept(x.getUpdateIndexClause());
        printSpaceAfterAccept(x.getParallelClause());

        if (x.isCascade()) {
            printSpaceAfterValue(SQLReserved.CASCADE);
        }
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableExchangeSubPartitionForAction x) {
        print(SQLReserved.EXCHANGE);
        printSpaceAfterValue(SQLReserved.SUBPARTITION);
        printSpaceAfterValue(SQLReserved.FOR);
        printSpaceAfterAccept(x.getNames(), ", ", true);

        printSpaceAfterValue(SQLReserved.WITH);
        printSpaceAfterValue(SQLReserved.TABLE);
        printSpaceAfterAccept(x.getTable());

        SQLIncludingType indexes = x.getIndexes();
        if (indexes != null) {
            printSpaceAfterValue(indexes);
            printSpaceAfterValue(SQLReserved.INDEXES);
        }

        SQLWithType validation = x.getValidation();
        if (validation != null) {
            printSpaceAfterValue(validation);
            printSpaceAfterValue(SQLReserved.VALIDATION);
        }

        printSpaceAfterAccept(x.getExceptionsClause());
        printSpaceAfterAccept(x.getUpdateIndexClause());
        printSpaceAfterAccept(x.getParallelClause());

        if (x.isCascade()) {
            printSpaceAfterValue(SQLReserved.CASCADE);
        }
        return false;
    }


    @Override
    public boolean visit(SQLAlterTableMergePartitionsAction x) {
        print(SQLReserved.MERGE);
        printSpaceAfterValue(SQLReserved.PARTITIONS);
        printSpaceAfterAccept(x.getItems(), ", ");

        SQLPartitionDefinition partition = x.getPartition();
        if (partition != null) {
            printlnAfterValue(SQLReserved.INTO);
            printSpaceAfterAccept(partition);
        }

        printlnAndAccept(x.getFilterCondition());
        printlnAndAccept(x.getDependentTables());
        printlnAndAccept(x.getUpdateIndex());
        printlnAndAccept(x.getParallel());

        if (x.isOnline()) {
            printlnAfterValue(SQLReserved.ONLINE);
        }
        printlnAfterValue(x.getAllowDisallowClustering());

        return false;
    }

    @Override
    public boolean visit(SQLAlterTableMergePartitionsToAction x) {
        print(SQLReserved.MERGE);
        printSpaceAfterValue(SQLReserved.PARTITIONS);
        printSpaceAfterAccept(x.getItems(), " TO ");

        SQLPartitionDefinition partition = x.getPartition();
        if (partition != null) {
            printlnAfterValue(SQLReserved.INTO);
            printSpaceAfterAccept(partition);
        }

        printlnAndAccept(x.getFilterCondition());
        printlnAndAccept(x.getDependentTables());
        printlnAndAccept(x.getUpdateIndex());
        printlnAndAccept(x.getParallel());

        if (x.isOnline()) {
            printlnAfterValue(SQLReserved.ONLINE);
        }
        printlnAfterValue(x.getAllowDisallowClustering());

        return false;
    }

    @Override
    public boolean visit(SQLAlterTableMergeSubPartitionsAction x) {
        print(SQLReserved.MERGE);
        printSpaceAfterValue(SQLReserved.PARTITIONS);
        printSpaceAfterAccept(x.getItems(), ", ");

        SQLSubPartitionDefinition subPartition = x.getSubPartition();
        if (subPartition != null) {
            printlnAfterValue(SQLReserved.INTO);
            printSpaceAfterAccept(subPartition);
        }

        printlnAndAccept(x.getFilterCondition());
        printlnAndAccept(x.getDependentTables());
        printlnAndAccept(x.getUpdateIndex());
        printlnAndAccept(x.getParallel());

        if (x.isOnline()) {
            printlnAfterValue(SQLReserved.ONLINE);
        }
        printlnAfterValue(x.getAllowDisallowClustering());

        return false;
    }

    @Override
    public boolean visit(SQLAlterTableMergeSubPartitionsToAction x) {
        print(SQLReserved.MERGE);
        printSpaceAfterValue(SQLReserved.SUBPARTITIONS);
        printSpaceAfterAccept(x.getItems(), " TO ");

        SQLSubPartitionDefinition subPartition = x.getSubPartition();
        if (subPartition != null) {
            printlnAfterValue(SQLReserved.INTO);
            printSpaceAfterAccept(subPartition);
        }

        printlnAndAccept(x.getFilterCondition());
        printlnAndAccept(x.getDependentTables());
        printlnAndAccept(x.getUpdateIndex());
        printlnAndAccept(x.getParallel());

        if (x.isOnline()) {
            printlnAfterValue(SQLReserved.ONLINE);
        }
        printlnAfterValue(x.getAllowDisallowClustering());

        return false;
    }

    @Override
    public boolean visit(SQLAlterTableModifyPartitionAction x) {
        print(SQLReserved.MODIFY);
        printSpaceAfterValue(SQLReserved.PARTITION);
        printSpaceAfterAccept(x.getName());
        printSpaceAfterAccept(x.getItems(), " ");
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableModifyPartitionForAction x) {
        print(SQLReserved.MODIFY);
        printSpaceAfterValue(SQLReserved.PARTITION);
        printSpaceAfterValue(SQLReserved.FOR);
        printSpaceAfterAccept(x.getNames(), ", ", true);
        printSpaceAfterAccept(x.getItems(), " ");
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableModifySubPartitionAction x) {
        print(SQLReserved.MODIFY);
        printlnAfterValue(SQLReserved.SUBPARTITION);
        printSpaceAfterAccept(x.getName());
        printSpaceAfterAccept(x.getItems(), " ");
        return false;
    }


    @Override
    public boolean visit(AbstractSQLAlterTableModifyPartitionAction.SQLModifyPartitionAddValuesAction x) {
        print(SQLReserved.ADD);
        printSpaceAfterValue(SQLReserved.PARTITION);
        printSpaceAfterAccept(x.getItems(), ", ", true);
        return true;
    }

    @Override
    public boolean visit(AbstractSQLAlterTableModifyPartitionAction.SQLModifyPartitionDropValuesAction x) {
        print(SQLReserved.DROP);
        printSpaceAfterValue(SQLReserved.PARTITION);
        printSpaceAfterAccept(x.getItems(), ", ", true);
        return true;
    }

    @Override
    public boolean visit(AbstractSQLAlterTableModifyPartitionAction.SQLModifyPartitionUnusableLocalIndexesAction x) {
        if (x.isRebuild()) {
            print(SQLReserved.REBUILD);
            printSpace();
        }
        print(SQLReserved.UNUSABLE_LOCAL_INDEXES);
        return true;
    }

    @Override
    public boolean visit(AbstractSQLAlterTableModifyPartitionAction.SQLModifyPartitionAddSubPartitionAction x) {
        print(SQLReserved.ADD);

        this.incrementIndent();
        println();
        printlnAndAccept(x.getSubPartitions(), ",");
        printlnAndAccept(x.getDependentTables());
        printlnAndAccept(x.getUpdateIndex());
        printlnAndAccept(x.getParallel());
        this.decrementIndent();
        return true;
    }


    @Override
    public boolean visit(SQLAlterTableModifySubPartitionForAction x) {
        print(SQLReserved.MODIFY);
        printSpaceAfterValue(SQLReserved.SUBPARTITION);
        printSpaceAfterValue(SQLReserved.FOR);
        printSpaceAfterAccept(x.getNames(), ", ", true);
        printSpaceAfterAccept(x.getItems(), " ");
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableRenamePartitionAction x) {
        print(SQLReserved.RENAME);
        printSpaceAfterValue(SQLReserved.PARTITION);
        printSpaceAfterAccept(x.getName());
        printSpaceAfterValue(SQLReserved.TO);
        printSpaceAfterAccept(x.getNewName());
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableRenamePartitionForAction x) {
        print(SQLReserved.RENAME);
        printSpaceAfterValue(SQLReserved.PARTITION);
        printSpaceAfterValue(SQLReserved.FOR);
        printSpaceAfterAccept(x.getNames(), ", ", true);
        printlnAfterValue(SQLReserved.TO);
        printSpaceAfterAccept(x.getNewName());
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableRenameSubPartitionAction x) {
        print(SQLReserved.RENAME);
        printSpaceAfterValue(SQLReserved.SUBPARTITION);
        printSpaceAfterAccept(x.getName());
        printSpaceAfterValue(SQLReserved.TO);
        printSpaceAfterAccept(x.getNewName());
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableRenameSubPartitionForAction x) {
        print(SQLReserved.RENAME);
        printSpaceAfterValue(SQLReserved.SUBPARTITION);
        printSpaceAfterAccept(x.getNames(), ", ", true);
        printSpaceAfterValue(SQLReserved.TO);
        printSpaceAfterAccept(x.getNewName());
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableSetIntervalAction x) {
        print(SQLReserved.SET);
        printSpaceAfterValue(SQLReserved.INTERVAL);
        printSpaceAfterValue(SQLReserved.LEFT_PAREN);
        print(x.getExpr());
        print(SQLReserved.RIGHT_PAREN);
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableSetPartitioningAction x) {
        print(SQLReserved.SET);
        printSpaceAfterValue(SQLReserved.PARTITIONING);
        printSpaceAfterValue(x.getSetPartition());
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableSetStoreInAction x) {
        print(SQLReserved.SET);
        printSpaceAfterValue(SQLReserved.STORE_IN);
        printSpaceAfterAccept(x.getItems(), ", ", true);
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableSetSubPartitionTemplateAction x) {
        print(SQLReserved.SET);
        printSpaceAfterValue(SQLReserved.SUBPARTITION);
        printSpaceAfterValue(SQLReserved.TEMPLATE);

        printSpaceAndLnAndAccept(x.getSubPartitions(), ",", true);
        return false;
    }


    @Override
    public boolean visit(SQLAlterTableSplitPartitionAction x) {
        print(SQLReserved.SPLIT);
        printSpaceAfterValue(SQLReserved.PARTITION);
        printSpaceAfterAccept(x.getName());
        printSpaceAfterAccept(x.getItem());

        printlnAndAccept(x.getSplitNestedTablePart());
        printlnAndAccept(x.getFilterCondition());
        printlnAndAccept(x.getDependentTables());
        printlnAndAccept(x.getUpdateIndex());
        printlnAndAccept(x.getParallel());
        printlnAfterValue(x.getAllowDisallowClustering());
        if (x.isOnline()) {
            printlnAfterValue(SQLReserved.ONLINE);
        }
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableSplitPartitionForAction x) {
        print(SQLReserved.SPLIT);
        printSpaceAfterValue(SQLReserved.PARTITION);
        printSpaceAfterValue(SQLReserved.FOR);
        printSpaceAndLnAndAccept(x.getNames(), ",", true);
        printSpaceAfterAccept(x.getItem());

        printlnAndAccept(x.getSplitNestedTablePart());
        printlnAndAccept(x.getFilterCondition());
        printlnAndAccept(x.getDependentTables());
        printlnAndAccept(x.getUpdateIndex());
        printlnAndAccept(x.getParallel());
        printlnAfterValue(x.getAllowDisallowClustering());
        if (x.isOnline()) {
            printlnAfterValue(SQLReserved.ONLINE);
        }
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableSplitSubPartitionAction x) {
        print(SQLReserved.SPLIT);
        printSpaceAfterValue(SQLReserved.SUBPARTITION);
        printSpaceAfterAccept(x.getName());
        printSpaceAfterAccept(x.getItem());

        printlnAndAccept(x.getSplitNestedTablePart());
        printlnAndAccept(x.getFilterCondition());
        printlnAndAccept(x.getDependentTables());
        printlnAndAccept(x.getUpdateIndex());
        printlnAndAccept(x.getParallel());
        printlnAfterValue(x.getAllowDisallowClustering());
        if (x.isOnline()) {
            printlnAfterValue(SQLReserved.ONLINE);
        }
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableSplitSubPartitionForAction x) {
        print(SQLReserved.SPLIT);
        printSpaceAfterValue(SQLReserved.SUBPARTITION);
        printSpaceAfterValue(SQLReserved.FOR);
        printSpaceAndLnAndAccept(x.getNames(), ",", true);
        printSpaceAfterAccept(x.getItem());

        printlnAndAccept(x.getSplitNestedTablePart());
        printlnAndAccept(x.getFilterCondition());
        printlnAndAccept(x.getDependentTables());
        printlnAndAccept(x.getUpdateIndex());
        printlnAndAccept(x.getParallel());
        printlnAfterValue(x.getAllowDisallowClustering());
        if (x.isOnline()) {
            printlnAfterValue(SQLReserved.ONLINE);
        }
        return false;
    }

    @Override
    public boolean visit(AbstractSQLAlterTableSplitPartitionAction.SQLAt x) {
        print(SQLReserved.AT);
        printSpaceAndLnAndAccept(x.getItems(), ",", true);
        List<SQLPartitionDefinition> partitions = x.getPartitions();
        if (partitions != null
                && partitions.size() > 0) {
            printlnAfterValue(SQLReserved.INTO);
            printSpaceAndLnAndAccept(partitions, ",", true);
        }
        return false;
    }

    @Override
    public boolean visit(AbstractSQLAlterTableSplitPartitionAction.SQLValues x) {
        print(SQLReserved.VALUES);
        printSpaceAndLnAndAccept(x.getItems(), ",", true);
        List<SQLPartitionDefinition> partitions = x.getPartitions();
        if (partitions != null
                && partitions.size() > 0) {
            printlnAfterValue(SQLReserved.INTO);
            printSpaceAndLnAndAccept(partitions, ",", true);
        }
        return false;
    }

    @Override
    public boolean visit(AbstractSQLAlterTableSplitPartitionAction.SQLInto x) {
        printlnAfterValue(SQLReserved.INTO);
        printSpaceAndLnAndAccept(x.getPartitions(), ",", true);

        return false;
    }

    @Override
    public boolean visit(AbstractSQLAlterTableSplitPartitionAction.SQLSplitNestedTablePart x) {
        print(SQLReserved.NESTED_TABLE);
        printSpaceAfterAccept(x.getColumn());
        printSpaceAfterValue(SQLReserved.INTO);

        printSpaceAndLnAndAccept(x.getItems(), ",", true);

        printlnAndAccept(x.getSplitNestedTablePart());
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableTruncatePartitionAction x) {
        print(SQLReserved.TRUNCATE);
        printSpaceAfterValue(x.getType());
        printSpaceAfterAccept(x.getItems(), ", ");

        printSpaceAfterValue(x.getStorageType());
        if (x.isCascade()) {
            printSpaceAfterValue(SQLReserved.CASCADE);
        }

        printSpaceAfterAccept(x.getUpdateIndexClause());
        printSpaceAfterAccept(x.getParallelClause());

        return false;
    }

    @Override
    public boolean visit(SQLAlterTableTruncateSubPartitionAction x) {
        print(SQLReserved.TRUNCATE);
        printSpaceAfterValue(x.getType());
        printSpaceAfterAccept(x.getItems(), ", ");

        printSpaceAfterValue(x.getStorageType());
        if (x.isCascade()) {
            printSpaceAfterValue(SQLReserved.CASCADE);
        }

        printSpaceAfterAccept(x.getUpdateIndexClause());
        printSpaceAfterAccept(x.getParallelClause());
        return false;
    }

    @Override
    public boolean visit(SQLAnalyzePartitionDefinition x) {

        return false;
    }

    @Override
    public boolean visit(SQLCheckPartitionDefinition x) {

        return false;
    }

    @Override
    public boolean visit(SQLCoalescePartitionDefinition x) {

        return false;
    }

    @Override
    public boolean visit(SQLDiscardPartitionDefinition x) {
        return false;
    }

    @Override
    public boolean visit(SQLExchangePartitionDefinition x) {
        return false;
    }

    @Override
    public boolean visit(SQLImportPartitionDefinition x) {

        return false;
    }

    @Override
    public boolean visit(SQLAlterTableMovePartitionAction x) {
        print(SQLReserved.MOVE);
        printSpaceAfterValue(SQLReserved.PARTITION);
        printSpaceAfterAccept(x.getName());

        if (x.isMappingTable()) {
            printSpaceAfterValue(SQLReserved.MAPPING_TABLE);
        }

        List<SQLExpr> properties = x.getProperties();
        if (properties != null
                && properties.size() > 0) {
            println();
            printlnAndAccept(x.getProperties());
        }

        printlnAndAccept(x.getFilterCondition());
        printlnAndAccept(x.getUpdateIndexClause());
        printlnAndAccept(x.getParallelClause());
        printlnAfterValue(x.getAllowDisallowClustering());
        if (x.isOnline()) {
            printSpaceAfterValue(SQLReserved.ONLINE);
        }
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableMovePartitionForAction x) {
        print(SQLReserved.MOVE);
        printSpaceAfterValue(SQLReserved.PARTITION);
        printSpaceAfterValue(SQLReserved.FOR);
        printSpaceAfterAccept(x.getNames(), ", ", true);

        if (x.isMappingTable()) {
            printSpaceAfterValue(SQLReserved.MAPPING_TABLE);
        }

        List<SQLExpr> properties = x.getProperties();
        if (properties != null
                && properties.size() > 0) {
            println();
            printlnAndAccept(x.getProperties());
        }

        printlnAndAccept(x.getFilterCondition());
        printlnAndAccept(x.getUpdateIndexClause());
        printlnAndAccept(x.getParallelClause());
        printlnAfterValue(x.getAllowDisallowClustering());
        if (x.isOnline()) {
            printSpaceAfterValue(SQLReserved.ONLINE);
        }
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableMoveSubPartitionAction x) {
        print(SQLReserved.MOVE);
        printSpaceAfterValue(SQLReserved.SUBPARTITION);
        printSpaceAfterAccept(x.getName());

        printSpaceAfterValue(x.getIndexing());
        printlnAndAccept(x.getPartitioningStorage());
        printlnAndAccept(x.getUpdateIndex());
        printlnAndAccept(x.getFilterCondition());
        printlnAndAccept(x.getParallel());
        printlnAfterValue(x.getAllowDisallowClustering());
        if (x.isOnline()) {
            printSpaceAfterValue(SQLReserved.ONLINE);
        }
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableMoveSubPartitionForAction x) {
        print(SQLReserved.MOVE);
        printSpaceAfterValue(SQLReserved.SUBPARTITION);
        printSpaceAfterValue(SQLReserved.FOR);
        printSpaceAfterAccept(x.getNames(), ", ", true);

        printSpaceAfterValue(x.getIndexing());
        printlnAndAccept(x.getPartitioningStorage());
        printlnAndAccept(x.getUpdateIndex());
        printlnAndAccept(x.getFilterCondition());
        printlnAndAccept(x.getParallel());
        printlnAfterValue(x.getAllowDisallowClustering());
        if (x.isOnline()) {
            printSpaceAfterValue(SQLReserved.ONLINE);
        }
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableOptimizePartitionAction x) {

        return false;
    }

    @Override
    public boolean visit(SQLAlterTableRebuildPartitionAction x) {
        print(SQLReserved.REBUILD);
        printSpaceAfterValue(SQLReserved.PARTITION);
        printSpaceAfterAccept(x.getNames(), " ");
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableRemovePartitioningAction x) {
        print(SQLReserved.REMOVE);
        printSpaceAfterValue(SQLReserved.PARTITIONING);
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableReorganizePartitionAction x) {
        print(SQLReserved.REORGANIZE);
        printSpaceAfterValue(SQLReserved.PARTITION);
        printSpaceAfterAccept(x.getNames(), " ");
        printSpaceAfterValue(SQLReserved.INTO);

        printSpaceAndLnAndAccept(x.getPartitions(), ",", true);
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableRepairPartitionAction x) {
        print(SQLReserved.REPAIR);
        printSpaceAfterValue(SQLReserved.PARTITION);
        printSpaceAfterAccept(x.getNames(), ", ");
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableUpgradePartitioningAction x) {
        print(SQLReserved.UPGRADE);
        printSpaceAfterValue(SQLReserved.PARTITIONING);
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableDisableTriggerAction x) {
        print(SQLReserved.DISABLE);
        printSpaceAfterValue(SQLReserved.TRIGGER);
        printSpaceAfterAccept(x.getName());
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableEnableTriggerAction x) {
        print(SQLReserved.ENABLE);
        printSpaceAfterValue(SQLReserved.TRIGGER);
        printSpaceAfterAccept(x.getName());
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableCacheAction x) {
        print(SQLReserved.CACHE);
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableDisableAllTriggersAction x) {
        print(SQLReserved.DISABLE);
        printSpaceAfterValue(SQLReserved.ALL);
        printSpaceAfterValue(SQLReserved.TRIGGERS);
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableDisableContainerMapAction x) {
        print(SQLReserved.DISABLE);
        printSpaceAfterValue(SQLReserved.CONTAINER_MAP);
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableDisableContainersDefaultAction x) {
        print(SQLReserved.DISABLE);
        printSpaceAfterValue(SQLReserved.CONTAINERS_DEFAULT);
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableDisableTableLockAction x) {
        print(SQLReserved.DISABLE);
        printSpaceAfterValue(SQLReserved.TABLE);
        printSpaceAfterValue(SQLReserved.LOCK);
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableEnableAllTriggersAction x) {
        print(SQLReserved.ENABLE);
        printSpaceAfterValue(SQLReserved.ALL);
        printSpaceAfterValue(SQLReserved.TRIGGERS);
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableEnableContainerMapAction x) {
        print(SQLReserved.ENABLE);
        printSpaceAfterValue(SQLReserved.CONTAINER_MAP);
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableEnableContainersDefaultAction x) {
        print(SQLReserved.ENABLE);
        printSpaceAfterValue(SQLReserved.CONTAINERS_DEFAULT);
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableEnableTableLockAction x) {
        print(SQLReserved.ENABLE);
        printSpaceAfterValue(SQLReserved.TABLE);
        printSpaceAfterValue(SQLReserved.LOCK);
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableForceAction x) {
        print(SQLReserved.FORCE);
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableModifyOpaqueTypeAction x) {
        print(SQLReserved.MODIFY);
        printSpaceAfterValue(SQLReserved.OPAQUE);
        printSpaceAfterValue(SQLReserved.TYPE);
        printSpaceAfterAccept(x.getColumn());

        printSpaceAfterValue(SQLReserved.STORE);
        printSpaceAfterAccept(x.getNames(), ", ", true);
        printSpaceAfterValue(SQLReserved.UNPACKED);
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableMoveTableAction x) {
        print(SQLReserved.MOVE);
        printSpaceAfterAccept(x.getFilterCondition());
        if (x.isOnline()) {
            printSpaceAfterValue(SQLReserved.ONLINE);
        }
        printSpaceAfterAccept(x.getProperties(), " ");
        printSpaceAfterAccept(x.getUpdateIndexes());
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableNoCacheAction x) {
        print(SQLReserved.NOCACHE);
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableReadOnlyAction x) {
        print(SQLReserved.READ_ONLY);
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableReadWriteAction x) {
        print(SQLReserved.READ_WRITE);
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableRowArchivalAction x) {
        print(SQLReserved.ROW_ARCHIVAL);
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableUpgradeTableAction x) {
        print(SQLReserved.UPGRADE);
        printSpaceAfterValue(x.getOption());
        printSpaceAfterAccept(x.getProperties(), " ");
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableWithoutValidationAction x) {
        print(SQLReserved.WITHOUT);
        printSpaceAfterValue(SQLReserved.VALIDATION);
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableWithValidationAction x) {
        print(SQLReserved.WITH);
        printSpaceAfterValue(SQLReserved.VALIDATION);
        return false;
    }

    @Override
    public boolean visit(SQLAlterXmlSchemaClause.SQLAlterXmlSchemaAllowAnySchemaClause x) {
        print(SQLReserved.ALLOW);
        printSpaceAfterValue(SQLReserved.ANYSCHEMA);
        return false;
    }

    @Override
    public boolean visit(SQLAlterXmlSchemaClause.SQLAlterXmlSchemaAllowNonSchemaClause x) {
        print(SQLReserved.ALLOW);
        printSpaceAfterValue(SQLReserved.NONSCHEMA);
        return false;
    }

    @Override
    public boolean visit(SQLAlterXmlSchemaClause.SQLAlterXmlSchemaDisallowNonSchemaClause x) {
        print(SQLReserved.DISALLOW);
        printSpaceAfterValue(SQLReserved.NONSCHEMA);
        return false;
    }

    @Override
    public boolean visit(ISQLEnableDisableClause.SQLEnableUniqueClause x) {
        print(SQLReserved.ENABLE);
        printSpaceAfterValue(x.getValidate());
        printSpaceAfterValue(SQLReserved.UNIQUE);
        printSpaceAfterAccept(x.getColumns(), ", ", true);

        printlnAndAccept(x.getUsingIndexClause());
        printlnAndAccept(x.getExceptionsClause());
        if (x.isCascade()) {
            printlnAfterValue(SQLReserved.CASCADE);
        }
        printlnAfterValue(x.getKeepIndex());
        return false;
    }

    @Override
    public boolean visit(ISQLEnableDisableClause.SQLEnablePrimaryKeyClause x) {
        print(SQLReserved.ENABLE);
        printSpaceAfterValue(x.getValidate());
        printSpaceAfterValue(SQLReserved.PRIMARY_KEY);

        printlnAndAccept(x.getUsingIndexClause());
        printlnAndAccept(x.getExceptionsClause());
        if (x.isCascade()) {
            printlnAfterValue(SQLReserved.CASCADE);
        }
        printlnAfterValue(x.getKeepIndex());
        return false;
    }

    @Override
    public boolean visit(ISQLEnableDisableClause.SQLEnableConstraintClause x) {
        print(SQLReserved.ENABLE);
        printSpaceAfterValue(x.getValidate());
        printSpaceAfterValue(SQLReserved.CONSTRAINT);
        printSpaceAfterAccept(x.getName());

        printlnAndAccept(x.getUsingIndexClause());
        printlnAndAccept(x.getExceptionsClause());
        if (x.isCascade()) {
            printlnAfterValue(SQLReserved.CASCADE);
        }
        printlnAfterValue(x.getKeepIndex());
        return false;
    }

    @Override
    public boolean visit(ISQLEnableDisableClause.SQLDisableUniqueClause x) {
        print(SQLReserved.DISABLE);
        printSpaceAfterValue(x.getValidate());
        printSpaceAfterValue(SQLReserved.UNIQUE);
        printSpaceAfterAccept(x.getColumns(), ", ", true);

        printlnAndAccept(x.getUsingIndexClause());
        printlnAndAccept(x.getExceptionsClause());
        if (x.isCascade()) {
            printlnAfterValue(SQLReserved.CASCADE);
        }
        printlnAfterValue(x.getKeepIndex());
        return false;
    }

    @Override
    public boolean visit(ISQLEnableDisableClause.SQLDisablePrimaryKeyClause x) {
        print(SQLReserved.DISABLE);
        printSpaceAfterValue(x.getValidate());
        printSpaceAfterValue(SQLReserved.PRIMARY_KEY);

        printlnAndAccept(x.getUsingIndexClause());
        printlnAndAccept(x.getExceptionsClause());
        if (x.isCascade()) {
            printlnAfterValue(SQLReserved.CASCADE);
        }
        printlnAfterValue(x.getKeepIndex());
        return false;
    }

    @Override
    public boolean visit(ISQLEnableDisableClause.SQLDisableConstraintClause x) {
        print(SQLReserved.DISABLE);
        printSpaceAfterValue(x.getValidate());
        printSpaceAfterValue(SQLReserved.CONSTRAINT);
        printSpaceAfterAccept(x.getName());

        printlnAndAccept(x.getUsingIndexClause());
        printlnAndAccept(x.getExceptionsClause());
        if (x.isCascade()) {
            printlnAfterValue(SQLReserved.CASCADE);
        }
        printlnAfterValue(x.getKeepIndex());
        return false;
    }

    @Override
    public boolean visit(SQLAttributeClusteringClause x) {
        print(SQLReserved.CLUSTERING);
        printSpaceAfterAccept(x.getClusteringJoin());
        printSpaceAfterAccept(x.getClusterClause());
        printSpaceAfterAccept(x.getClusteringWhen());
        printSpaceAfterAccept(x.getZoneMapClause());
        return false;
    }

    @Override
    public boolean visit(SQLAttributeClusteringClause.SQLClusteringJoin x) {
        print(x.getName());
        printSpaceAfterAccept(x.getItems(), ", ");
        return false;
    }

    @Override
    public boolean visit(SQLAttributeClusteringClause.SQLClusteringJoinItem x) {
        print(SQLReserved.JOIN);
        printSpaceAfterAccept(x.getName());

        printSpaceAfterValue(SQLReserved.ON);
        printSpaceAfterValue(SQLReserved.LEFT_PAREN);
        printSpaceAfterAccept(x.getCondition());
        printSpaceAfterValue(SQLReserved.RIGHT_PAREN);
        return false;
    }

    @Override
    public boolean visit(SQLAttributeClusteringClause.SQLClusterClause x) {
        print(SQLReserved.BY);
        printSpaceAfterValue(x.getLinear());
        printSpaceAfterValue(SQLReserved.ORDER);
        printSpaceAndLnAndAccept(x.getColumns(), ",", true);
        return false;
    }

    @Override
    public boolean visit(SQLAttributeClusteringClause.SQLClusteringWhen x) {
        SQLYesType onLoad = x.getOnLoad();
        SQLYesType onDataMovement = x.getOnDataMovement();

        boolean print = false;
        if (onLoad != null) {
            print(onLoad);
            printSpaceAfterValue(SQLReserved.ON_LOAD);
            print = true;
        }

        if (onLoad != null) {
            if (print) {
                printSpace();
            }
            print(onDataMovement);
            printSpaceAfterValue(SQLReserved.ON_DATA_MOVEMENT);
        }

        return false;
    }

    @Override
    public boolean visit(SQLAttributeClusteringClause.SQLWithMaterializedZoneMapClause x) {
        print(SQLReserved.WITH_MATERIALIZED_ZONEMAP);
        SQLName name = x.getName();
        if (name != null) {
            printSpaceAfterValue(SQLReserved.LEFT_PAREN);
            print(name);
            print(SQLReserved.RIGHT_PAREN);
        }

        return false;
    }

    @Override
    public boolean visit(SQLAttributeClusteringClause.SQLWithoutMaterializedZoneMapClause x) {
        print(SQLReserved.WITHOUT_MATERIALIZED_ZONEMAP);
        return false;
    }

    @Override
    public boolean visit(SQLDependentTablesClause x) {
        return false;
    }

    @Override
    public boolean visit(SQLDependentTablesClause.Item x) {
        return false;
    }

    @Override
    public boolean visit(SQLFlashbackArchiveClause x) {
        return false;
    }

    @Override
    public boolean visit(SQLForExchangeWithTableClause x) {
        return false;
    }

    @Override
    public boolean visit(SQLInvalidateGlobalIndexClause x) {
        return false;
    }

    @Override
    public boolean visit(SQLNoFlashbackArchiveClause x) {
        return false;
    }

    @Override
    public boolean visit(SQLObjectTableSubstitution x) {
        return false;
    }

    @Override
    public boolean visit(SQLOidClause x) {
        print(SQLReserved.OBJECT);
        printSpaceAfterValue(SQLReserved.IDENTIFIER);
        printSpaceAfterValue(SQLReserved.IS);
        printSpaceAfterValue(x.getType());
        return false;
    }

    @Override
    public boolean visit(SQLOidIndexClause x) {
        print(SQLReserved.OIDINDEX);
        printSpaceAfterAccept(x.getName());
        printSpaceAfterValue(SQLReserved.LEFT_PAREN);
        printIndentAndLnAndAccept(x.getItems());
        print(SQLReserved.RIGHT_PAREN);
        return false;
    }

    @Override
    public boolean visit(SQLPartitionAttribute.SQLLobClause x) {
        print(SQLReserved.LOB);
        printSpaceAfterAccept(x.getName());
        printSpaceAndLnAndAccept(x.getParameters(), ",", true);
        return false;
    }

    @Override
    public boolean visit(SQLPartitionAttribute.SQLVarrayClause x) {
        print(SQLReserved.VARRAY);
        printSpaceAfterAccept(x.getName());
        printSpaceAndLnAndAccept(x.getParameters(), ",", true);
        return false;
    }

    @Override
    public boolean visit(SQLRowMovementClause x) {

        return false;
    }

    @Override
    public boolean visit(SQLTablePropertyResultCache x) {
        return false;
    }

    @Override
    public boolean visit(SQLUpdateGlobalIndexClause x) {
        print(SQLReserved.UPDATE);
        printSpaceAfterValue(SQLReserved.GLOBAL);
        printSpaceAfterValue(SQLReserved.INDEXES);
        return false;
    }

    @Override
    public boolean visit(SQLUpdateIndexesClause x) {
        print(SQLReserved.UPDATE);
        printSpaceAfterValue(SQLReserved.INDEXES);

        printSpaceAndLnAndAccept(x.getItems(), ",", true);
        return false;
    }

    @Override
    public boolean visit(SQLUpdateIndexesClause.Item x) {
        print(x.getName());
        printSpaceAndLnAndAccept(x.getItems(), ",", true);
        return false;
    }

    // ------------------ Table Details End ----------------------


    // ------------------ Trigger Details Start ----------------------
    @Override
    public boolean visit(SQLTriggerDMLEvent x) {
        print(x.getType().name);

        List<SQLExpr> ofColumns = x.getOfColumns();
        if (ofColumns != null
                && ofColumns.size() > 0) {
            printSpaceAfterValue(SQLReserved.OF);
            printSpaceAfterAccept(ofColumns, ", ");
        }
        return false;
    }

    @Override
    public boolean visit(SQLTriggerDDLEvent x) {
        print(x.getType().name);
        return false;
    }

    @Override
    public boolean visit(SQLTriggerDatabaseEvent x) {
        print(x.getType().name);
        return false;
    }

    @Override
    public boolean visit(SQLCreateTriggerStatement.SQLOnSchemaExpr x) {
        SQLName owner = x.getOwner();
        if (owner != null) {
            print(owner);
            print(SQLReserved.PERIOD);
        }
        print(SQLReserved.SCHEMA);
        return false;
    }

    @Override
    public boolean visit(SQLCreateTriggerStatement.SQLOnDatabaseExpr x) {
        if (x.isPluggable()) {
            print(SQLReserved.PLUGGABLE);
            printSpace();
        }
        print(SQLReserved.DATABASE);
        return false;
    }

    @Override
    public boolean visit(SQLTriggerReferencingNewOption x) {
        print(SQLReserved.NEW);

        AbstractSQLTriggerReferencingOption.SQLTriggerReferencingType referencingType = x.getReferencingType();
        if (referencingType != null) {
            printSpaceAfterValue(referencingType.name);
        }

        if (x.isAs()) {
            printSpaceAfterValue(SQLReserved.AS);
        }

        printSpaceAfterAccept(x.getName());
        return false;
    }

    @Override
    public boolean visit(SQLTriggerReferencingOldOption x) {
        print(SQLReserved.OLD);

        AbstractSQLTriggerReferencingOption.SQLTriggerReferencingType referencingType = x.getReferencingType();
        if (referencingType != null) {
            printSpaceAfterValue(referencingType.name);
        }

        if (x.isAs()) {
            printSpaceAfterValue(SQLReserved.AS);
        }

        printSpaceAfterAccept(x.getName());
        return false;
    }

    @Override
    public boolean visit(SQLTriggerReferencingParentOption x) {
        print(SQLReserved.PARENT);

        AbstractSQLTriggerReferencingOption.SQLTriggerReferencingType referencingType = x.getReferencingType();
        if (referencingType != null) {
            printSpaceAfterValue(referencingType.name);
        }

        if (x.isAs()) {
            printSpaceAfterValue(SQLReserved.AS);
        }

        printSpaceAfterAccept(x.getName());
        return false;
    }

    @Override
    public boolean visit(SQLTriggerOrderingClause x) {
        SQLTriggerOrderingClause.Type type = x.getType();
        if (type != null) {
            print(type.name);
        }

        printSpaceAfterAccept(x.getNames(), ", ");
        return false;
    }

    @Override
    public boolean visit(SQLTriggerCompoundTriggerBlock x) {
        print(SQLReserved.COMPOUND_TRIGGER);

        this.incrementIndent();
        println();
        printlnAndAccept(x.getDeclareSections());

        printlnAndAccept(x.getItems());

        this.decrementIndent();
        println();

        print(SQLReserved.END);
        printSpaceAfterAccept(x.getEndName());

        return false;
    }

    @Override
    public boolean visit(SQLTriggerCompoundTriggerBlock.SQLTimingPointSection x) {
        print(x.getBeforeTimingPoint().name);
        printSpaceAfterValue(SQLReserved.IS);
        printlnAndAccept(x.getBody());
        printSpaceAfterValue(x.getAfterTimingPoint().name);
        return false;
    }

    // ------------------ Trigger Details End ----------------------


    // ------------------ Type Details Start ----------------------

    @Override
    public boolean visit(SQLAlterTypeAddMethodsAction x) {
        printlnAndAccept(x.getItems(), ",");
        return false;
    }

    @Override
    public boolean visit(SQLAlterTypeAddMethodsAction.SQLItem x) {
        print(SQLReserved.ADD);
        printSpaceAfterAccept(x.getMethod());
        return false;
    }

    @Override
    public boolean visit(SQLAlterTypeDropMethodsAction x) {
        printlnAndAccept(x.getItems(), ",");
        return false;
    }

    @Override
    public boolean visit(SQLAlterTypeDropMethodsAction.SQLItem x) {
        print(SQLReserved.DROP);
        printSpaceAfterAccept(x.getMethod());
        return false;
    }

    @Override
    public boolean visit(SQLAlterTypeAddAttributeAction x) {
        print(SQLReserved.ADD);
        printSpaceAfterValue(SQLReserved.ATTRIBUTE);
        printSpaceAfterAccept(x.getItems(), ", ", x.isParen());
        return false;
    }

    @Override
    public boolean visit(SQLAlterTypeModifyAttributeAction x) {
        print(SQLReserved.MODIFY);
        printSpaceAfterValue(SQLReserved.ATTRIBUTE);
        printSpaceAfterAccept(x.getItems(), ", ", x.isParen());
        return false;
    }

    @Override
    public boolean visit(SQLAlterTypeAlterAttributeAction x) {
        print(SQLReserved.ALTER);
        printSpaceAfterValue(SQLReserved.ATTRIBUTE);
        printSpaceAfterAccept(x.getItems(), ", ", x.isParen());
        return false;
    }

    @Override
    public boolean visit(SQLAlterTypeDropAttributeAction x) {
        print(SQLReserved.DROP);
        printSpaceAfterValue(SQLReserved.ATTRIBUTE);
        printSpaceAfterAccept(x.getItems(), ", ", x.isParen());
        return false;
    }

    @Override
    public boolean visit(SQLAlterTypeModifyLimitAction x) {
        print(SQLReserved.MODIFY);
        printSpaceAfterValue(SQLReserved.LIMIT);
        printSpaceAfterAccept(x.getLimit());
        return false;
    }

    @Override
    public boolean visit(SQLAlterTypeModifyElementTypeAction x) {
        print(SQLReserved.MODIFY);
        printSpaceAfterValue(SQLReserved.ELEMENT);
        printSpaceAfterValue(SQLReserved.TYPE);
        printSpaceAfterAccept(x.getDataType());
        return false;
    }

    // ------------------ Type Details End ----------------------


    // ------------------ Order By Details Start ----------------------
    @Override
    public boolean visit(SQLOrderByClause x) {
        print(SQLReserved.ORDER);

        if (x.isSiblings()) {
            printSpaceAfterValue(SQLReserved.SIBLINGS);
        }

        printSpaceAfterValue(SQLReserved.BY);

        printSpace();
        printAccept(x.getItems(), ", ");

        return false;
    }

    @Override
    public boolean visit(SQLOrderByItem x) {

        x.getSortKey().accept(this);

        printSpaceAfterAccept(x.getOrderingSpecification());

        printSpaceAfterValue(x.getNullOrdering());

        return false;
    }
    // ------------------ Order By Details End ----------------------


    // ------------------ Merge Details Start ----------------------
    @Override
    public boolean visit(SQLMergeStatement.SQLMergeWhenMatchClause x) {
        print(SQLReserved.WHEN_MATCHED_THEN);

        this.incrementIndent();
        println();
        x.getMatchThen().accept(this);
        this.decrementIndent();

        return false;
    }

    @Override
    public boolean visit(SQLMergeStatement.SQLMergeWhenNotMatchClause x) {
        print(SQLReserved.WHEN_NOT_MATCHED_THEN);

        this.incrementIndent();
        println();
        x.getNotMatchThen().accept(this);
        this.decrementIndent();

        return false;
    }
    // ------------------ Merge Details End ----------------------


    // ------------------ Update Details Start ----------------------

    @Override
    public boolean visit(SQLUpdateSetClause x) {
        print(SQLReserved.SET);

        printSpace();
        printUpdateSetItems(x.getItems());
        return false;
    }

    @Override
    public boolean visit(SQLUpdateSetByValueClause x) {
        print(SQLReserved.SET);
        printSpaceAfterValue(SQLReserved.VALUE);
        printSpaceAfterAccept(x.getColumn());
        printSpaceAfterValue(SQLReserved.EQUALS_OP);
        printSpaceAfterAccept(x.getValue());
        return false;
    }

    @Override
    public boolean visit(SQLUpdateSetClause.SQLUpdateSetItemClause x) {
        print(x.getColumn());
        printSpaceAfterValue(SQLReserved.EQUALS_OP);
        printSpaceAfterAccept(x.getValue());
        return false;
    }

    public void printUpdateSetItems(List<SQLUpdateSetClause.SQLUpdateSetItemClause> items) {
        int lineLength = 0;

        incrementIndent();
        for (int i = 0; i < items.size(); i++) {
            SQLUpdateSetClause.SQLUpdateSetItemClause updateSetItem = items.get(i);
            int updateSetItemLength = updateSetItem.toString().length();
            lineLength += updateSetItemLength;
            if (i != 0) {
                print(",");
            }
            if (i != 0) {
                if (lineLength > getLineMaxLength()) {
                    println();
                    lineLength = updateSetItemLength;
                } else {
                    printSpace();
                }
            }

            updateSetItem.accept(this);
        }
        decrementIndent();
    }

    // ------------------ Update Details End ----------------------


    // ------------------ User/Role Details End ----------------------
    @Override
    public boolean visit(SQLIdentifiedByClause x) {
        print(SQLReserved.IDENTIFIED_BY);
        printSpaceAfterAccept(x.getPassword());
        return false;
    }

    @Override
    public boolean visit(SQLIdentifiedByPasswordClause x) {
        print(SQLReserved.IDENTIFIED_BY);
        printSpaceAfterValue(SQLReserved.PASSWORD);
        printSpaceAfterAccept(x.getPassword());
        return false;
    }

    @Override
    public boolean visit(SQLIdentifiedExternallyClause x) {
        print(SQLReserved.IDENTIFIED);
        printSpaceAfterValue(SQLReserved.EXTERNALLY);

        SQLExpr asExpr = x.getAsExpr();
        if (asExpr != null) {
            printSpaceAfterValue(SQLReserved.AS);
            printSpaceAfterAccept(asExpr);
        }

        return false;
    }

    @Override
    public boolean visit(SQLIdentifiedGloballyClause x) {
        print(SQLReserved.IDENTIFIED);
        printSpaceAfterValue(SQLReserved.GLOBALLY);

        SQLExpr asExpr = x.getAsExpr();
        if (asExpr != null) {
            printSpaceAfterValue(SQLReserved.AS);
            printSpaceAfterAccept(asExpr);
        }
        return false;
    }

    @Override
    public boolean visit(SQLIdentifiedUsingClause x) {
        print(SQLReserved.IDENTIFIED);
        printSpaceAfterValue(SQLReserved.USING);

        printSpaceAfterAccept(x.getName());
        return false;
    }

    @Override
    public boolean visit(SQLIdentifiedWithAsClause x) {
        print(SQLReserved.IDENTIFIED);
        printSpaceAfterValue(SQLReserved.WITH);
        printSpaceAfterAccept(x.getAuthPlugin());

        printSpaceAfterValue(SQLReserved.AS);
        printSpaceAfterAccept(x.getPassword());
        return false;
    }

    @Override
    public boolean visit(SQLIdentifiedWithByClause x) {
        print(SQLReserved.IDENTIFIED);
        printSpaceAfterValue(SQLReserved.WITH);
        printSpaceAfterAccept(x.getAuthPlugin());

        printSpaceAfterValue(SQLReserved.BY);
        printSpaceAfterAccept(x.getPassword());
        return false;
    }

    @Override
    public boolean visit(SQLIdentifiedWithClause x) {
        print(SQLReserved.IDENTIFIED);
        printSpaceAfterValue(SQLReserved.WITH);
        printSpaceAfterAccept(x.getAuthPlugin());
        return false;
    }

    @Override
    public boolean visit(SQLNoAuthenticationClause x) {
        print(SQLReserved.NO_AUTHENTICATION);
        return false;
    }

    @Override
    public boolean visit(SQLNoIdentifiedClause x) {
        print(SQLReserved.NO_IDENTIFIED);
        return false;
    }


    // ------------------ User/Role Details End ----------------------


    // ------------------ Commit Details End ----------------------
    @Override
    public boolean visit(SQLCommitCommentOption x) {
        print(SQLReserved.COMMENT);
        printSpaceAfterAccept(x.getValue());
        return false;
    }

    @Override
    public boolean visit(SQLCommitWriteOption x) {
        print(SQLReserved.WRITE);
        printSpaceAfterValue(x.getWait());
        printSpaceAfterValue(x.getImmediate());
        return false;
    }

    @Override
    public boolean visit(SQLCommitForceOption x) {
        print(SQLReserved.FORCE);
        printSpaceAfterAccept(x.getId());

        SQLExpr scn = x.getScn();
        if (scn != null) {
            print(SQLReserved.COMMA);
            printSpaceAfterAccept(scn);
        }
        return false;
    }

    @Override
    public boolean visit(SQLCommitChainOption x) {
        print(SQLReserved.AND);
        printSpaceAfterValue(SQLReserved.NO);
        printSpaceAfterValue(SQLReserved.CHAIN);
        return false;
    }

    @Override
    public boolean visit(SQLCommitReleaseOption x) {
        if (x.isNo()) {
            print(SQLReserved.NO);
            printSpace();
        }
        print(SQLReserved.RELEASE);
        return false;
    }

    // ------------------ Commit Details End ----------------------

    // ------------------ Rollback Details End ----------------------

    @Override
    public boolean visit(SQLRollbackToSavepointOption x) {
        print(SQLReserved.TO);
        if (x.isSavepoint()) {
            printSpaceAfterValue(SQLReserved.SAVEPOINT);
        }
        printSpaceAfterAccept(x.getName());
        return false;
    }

    @Override
    public boolean visit(SQLRollbackForceOption x) {
        print(SQLReserved.FORCE);
        printSpaceAfterAccept(x.getId());
        return false;
    }

    @Override
    public boolean visit(SQLRollbackChainOption x) {
        print(SQLReserved.AND);
        if (x.isNo()) {
            printSpaceAfterValue(SQLReserved.NO);
        }
        printSpaceAfterValue(SQLReserved.CHAIN);
        return false;
    }

    @Override
    public boolean visit(SQLRollbackReleaseOption x) {
        if (x.isNo()) {
            print(SQLReserved.NO);
            printSpace();
        }
        print(SQLReserved.RELEASE);
        return false;
    }

    // ------------------ Rollback Details End ----------------------


    // ------------------ SET TRANSACTION Details Start ----------------------

    @Override
    public boolean visit(SQLSetTransactionReadOnlyOption x) {
        print(SQLReserved.READ_ONLY);
        return false;
    }

    @Override
    public boolean visit(SQLSetTransactionReadWriteOption x) {
        print(SQLReserved.READ_WRITE);
        return false;
    }

    @Override
    public boolean visit(SQLSetTransactionIsolationLevelOption x) {
        print(SQLReserved.ISOLATION_LEVEL);
        printSpaceAfterValue(x.getLevel());
        return false;
    }

    @Override
    public boolean visit(SQLSetTransactionUseRollbackSegmentOption x) {
        print(SQLReserved.USE_ROLLBACK_SEGMENT);
        printSpaceAfterAccept(x.getName());
        return false;
    }

    @Override
    public boolean visit(SQLSetTransactionSnapshotOption x) {
        print(SQLReserved.SNAPSHOT);
        printSpaceAfterAccept(x.getId());
        return false;
    }

    @Override
    public boolean visit(SQLSetTransactionDeferrableOption x) {
        if (x.isNot()) {
            print(SQLReserved.NOT);
        }
        print(SQLReserved.DEFERRABLE);
        return false;
    }

    @Override
    public boolean visit(SQLSetTransactionNameOption x) {
        print(SQLReserved.NAME);
        printSpaceAfterAccept(x.getName());
        return false;
    }

    // ------------------ SET TRANSACTION Details End ----------------------


    // ------------------ View Details Start ----------------------

    @Override
    public boolean visit(SQLAlterViewAddTableConstraintAction x) {
        print(SQLReserved.ADD);
        printSpaceAfterAccept(x.getConstraint());
        return false;
    }

    @Override
    public boolean visit(SQLAlterViewCompileAction x) {
        print(SQLReserved.COMPILE);
        return false;
    }

    @Override
    public boolean visit(SQLAlterViewDropConstraintAction x) {
        print(SQLReserved.DROP);
        printSpaceAfterValue(SQLReserved.CONSTRAINT);
        printSpaceAfterAccept(x.getConstraint());
        return false;
    }

    @Override
    public boolean visit(SQLAlterViewDropPrimaryKeyConstraintAction x) {
        print(SQLReserved.DROP);
        printSpaceAfterValue(SQLReserved.PRIMARY_KEY);
        return false;
    }

    @Override
    public boolean visit(SQLAlterViewDropUniqueConstraintAction x) {
        print(SQLReserved.DROP);
        printSpaceAfterValue(SQLReserved.UNIQUE);
        printSpaceAfterAccept(x.getColumns(), ", ", true);
        return false;
    }

    @Override
    public boolean visit(SQLAlterViewEditionableAction x) {
        print(SQLReserved.EDITIONABLE);
        return false;
    }

    @Override
    public boolean visit(SQLAlterViewModifyConstraintAction x) {
        print(SQLReserved.MODIFY);
        printSpaceAfterValue(SQLReserved.CONSTRAINT);
        printSpaceAfterAccept(x.getConstraint());
        printSpaceAfterValue(x.getOption());
        return false;
    }

    @Override
    public boolean visit(SQLAlterViewNonEditionableAction x) {
        print(SQLReserved.NONEDITIONABLE);
        return false;
    }

    @Override
    public boolean visit(SQLAlterViewReadOnlyAction x) {
        print(SQLReserved.READ_ONLY);
        return false;
    }

    @Override
    public boolean visit(SQLAlterViewReadWriteAction x) {
        print(SQLReserved.READ_WRITE);
        return false;
    }


    // ------------------ View Details Start ----------------------
    @Override
    public void postVisit(SQLObject x) {
        boolean printSemi = isPrintAfterSemi() == null ? x.isAfterSemi() : isPrintAfterSemi();
        if (printSemi) {
            print(';');
        }

    }


}
