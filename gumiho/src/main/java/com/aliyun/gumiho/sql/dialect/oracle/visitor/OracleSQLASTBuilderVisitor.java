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
package com.aliyun.gumiho.sql.dialect.oracle.visitor;

import static com.aliyun.gumiho.sql.dialect.oracle.parser.OracleSQLStatementParser.*;

import com.aliyun.gumiho.sql.basic.ast.SQLObject;
import com.aliyun.gumiho.sql.basic.ast.element.datatype.*;
import com.aliyun.gumiho.sql.basic.ast.element.datatype.any.SQLAnyDataDataType;
import com.aliyun.gumiho.sql.basic.ast.element.datatype.any.SQLAnyDataSetDataType;
import com.aliyun.gumiho.sql.basic.ast.element.datatype.any.SQLAnyTypeDataType;
import com.aliyun.gumiho.sql.basic.ast.element.datatype.bool.SQLBooleanDataType;
import com.aliyun.gumiho.sql.basic.ast.element.datatype.collection.SQLAssocArrayDataType;
import com.aliyun.gumiho.sql.basic.ast.element.datatype.collection.SQLNestedTableDataType;
import com.aliyun.gumiho.sql.basic.ast.element.datatype.collection.SQLVarrayDataType;
import com.aliyun.gumiho.sql.basic.ast.element.datatype.collection.SQLVaryingArrayDataType;
import com.aliyun.gumiho.sql.basic.ast.element.datatype.datetime.SQLDateDataType;
import com.aliyun.gumiho.sql.basic.ast.element.datatype.datetime.SQLTimestampDataType;
import com.aliyun.gumiho.sql.basic.ast.element.datatype.interval.SQLIntervalDataType;
import com.aliyun.gumiho.sql.basic.ast.element.datatype.json.SQLJsonDataType;
import com.aliyun.gumiho.sql.basic.ast.element.datatype.media.*;
import com.aliyun.gumiho.sql.basic.ast.element.datatype.numeric.*;
import com.aliyun.gumiho.sql.basic.ast.element.datatype.object.SQLObjectDataType;
import com.aliyun.gumiho.sql.basic.ast.element.datatype.reference.SQLRefDataType;
import com.aliyun.gumiho.sql.basic.ast.element.datatype.spatial.SQLSDOGeoRasterDataType;
import com.aliyun.gumiho.sql.basic.ast.element.datatype.spatial.SQLSDOGeometryDataType;
import com.aliyun.gumiho.sql.basic.ast.element.datatype.spatial.SQLSDOTopoGeometryDataType;
import com.aliyun.gumiho.sql.basic.ast.element.datatype.string.*;
import com.aliyun.gumiho.sql.basic.ast.element.datatype.sub.SQLObjectSubDataType;
import com.aliyun.gumiho.sql.basic.ast.element.datatype.xml.SQLUriTypeDataType;
import com.aliyun.gumiho.sql.basic.ast.element.datatype.xml.SQLXmlTypeDataType;
import com.aliyun.gumiho.sql.basic.ast.element.expr.*;
import com.aliyun.gumiho.sql.basic.ast.element.expr.clause.*;
import com.aliyun.gumiho.sql.basic.ast.element.expr.commit.SQLCommitCommentOption;
import com.aliyun.gumiho.sql.basic.ast.element.expr.commit.SQLCommitForceOption;
import com.aliyun.gumiho.sql.basic.ast.element.expr.commit.SQLCommitOption;
import com.aliyun.gumiho.sql.basic.ast.element.expr.commit.SQLCommitWriteOption;
import com.aliyun.gumiho.sql.basic.ast.element.expr.condition.*;
import com.aliyun.gumiho.sql.basic.ast.element.expr.index.*;
import com.aliyun.gumiho.sql.basic.ast.element.expr.index.alter.*;
import com.aliyun.gumiho.sql.basic.ast.element.expr.index.alter.partition.*;
import com.aliyun.gumiho.sql.basic.ast.element.expr.index.attribute.*;
import com.aliyun.gumiho.sql.basic.ast.element.expr.index.partition.global.SQLGlobalPartitionByHash;
import com.aliyun.gumiho.sql.basic.ast.element.expr.index.partition.global.SQLGlobalPartitionByRange;
import com.aliyun.gumiho.sql.basic.ast.element.expr.index.property.ISQLIndexProperty;
import com.aliyun.gumiho.sql.basic.ast.element.expr.materializedview.*;
import com.aliyun.gumiho.sql.basic.ast.element.expr.operator.SQLBinaryOperatorExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.operator.SQLUnaryOperatorExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.parallel.ISQLParallelClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.parallel.SQLNoParallelClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.parallel.SQLParallelClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.rollback.SQLRollbackForceOption;
import com.aliyun.gumiho.sql.basic.ast.element.expr.rollback.SQLRollbackOption;
import com.aliyun.gumiho.sql.basic.ast.element.expr.rollback.SQLRollbackToSavepointOption;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.*;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.group.SQLGroupByClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.group.SQLGroupingSetsClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.group.SQLHavingClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.limit.ISQLLimitClause;
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
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.*;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.constraint.SQLConstraint;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.constraint.column.*;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.constraint.option.*;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.constraint.table.*;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.partition.*;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.partition.sub.*;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.partition.values.ISQLPartitionValues;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.partition.values.SQLPartitionValues;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.partition.values.SQLPartitionValuesLessThan;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.partitionset.ISQLPartitionsetBy;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.partitionset.SQLPartitionsetByList;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.partitionset.SQLPartitionsetByRange;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.partitionset.SQLPartitionsetDefinition;
import com.aliyun.gumiho.sql.basic.ast.element.expr.trigger.*;
import com.aliyun.gumiho.sql.basic.ast.element.expr.type.alter.*;
import com.aliyun.gumiho.sql.basic.ast.element.expr.update.ISQLUpdateSetClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.update.SQLUpdateSetByValueClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.update.SQLUpdateSetClause;
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
import com.aliyun.gumiho.sql.basic.ast.element.identifier.*;
import com.aliyun.gumiho.sql.basic.ast.element.literal.*;
import com.aliyun.gumiho.sql.basic.ast.element.literal.datetime.SQLDateLiteral;
import com.aliyun.gumiho.sql.basic.ast.element.literal.datetime.SQLTimestampLiteral;
import com.aliyun.gumiho.sql.basic.ast.element.literal.interval.SQLIntervalLiteral;
import com.aliyun.gumiho.sql.basic.ast.element.literal.numeric.SQLBinaryDoubleLiteral;
import com.aliyun.gumiho.sql.basic.ast.element.literal.numeric.SQLBinaryFloatLiteral;
import com.aliyun.gumiho.sql.basic.ast.element.literal.numeric.SQLIntegerLiteral;
import com.aliyun.gumiho.sql.basic.ast.element.literal.numeric.SQLNumberLiteral;
import com.aliyun.gumiho.sql.basic.ast.element.literal.text.SQLCharLiteral;
import com.aliyun.gumiho.sql.basic.ast.element.literal.text.SQLNCharLiteral;
import com.aliyun.gumiho.sql.basic.ast.element.literal.text.SQLNQCharLiteral;
import com.aliyun.gumiho.sql.basic.ast.element.literal.text.SQLQCharLiteral;
import com.aliyun.gumiho.sql.basic.ast.element.pseudocolumn.*;
import com.aliyun.gumiho.sql.basic.ast.enums.*;
import com.aliyun.gumiho.sql.basic.ast.statement.SQLStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.comment.*;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.database.SQLAlterDatabaseStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.database.SQLCreateDatabaseStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.database.SQLDropDatabaseStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.databaselink.SQLAlterDatabaseLinkStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.databaselink.SQLCreateDatabaseLinkStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.databaselink.SQLDropDatabaseLinkStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.function.SQLAlterFunctionStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.function.SQLCreateFunctionStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.function.SQLDropFunctionStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.index.SQLAlterIndexStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.index.SQLCreateIndexStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.index.SQLDropIndexStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.materializedview.SQLAlterMaterializedViewStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.materializedview.SQLCreateMaterializedViewStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.materializedview.SQLDropMaterializedViewStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.packagebody.SQLCreatePackageBodyStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.packagebody.SQLDropPackageBodyStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.packages.SQLAlterPackageStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.packages.SQLCreatePackageStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.packages.SQLDropPackageStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.procedure.SQLAlterProcedureStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.procedure.SQLCreateProcedureStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.procedure.SQLDropProcedureStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.sequence.SQLAlterSequenceStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.sequence.SQLCreateSequenceStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.sequence.SQLDropSequenceStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.synonym.SQLAlterSynonymStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.synonym.SQLCreateSynonymStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.synonym.SQLDropSynonymStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.table.SQLAlterTableStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.table.SQLCreateTableStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.table.SQLDropTableStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.table.SQLTruncateTableStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.trigger.SQLAlterTriggerStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.trigger.SQLCreateTriggerStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.trigger.SQLDropTriggerStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.type.SQLAlterTypeStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.type.SQLCreateTypeStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.type.SQLDropTypeStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.typebody.SQLCreateTypeBodyStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.typebody.SQLDropTypeBodyStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.view.SQLAlterViewStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.view.SQLCreateViewStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.view.SQLDropViewStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.dml.*;
import com.aliyun.gumiho.sql.basic.ast.statement.fcl.*;
import com.aliyun.gumiho.sql.basic.ast.statement.tcl.*;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common.*;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common.allocateextent.OracleSQLAllocateExtentClause;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common.filespecification.*;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common.implicitcursor.*;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common.logging.IOracleSQLLoggingClause;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common.logging.OracleSQLFilesystemLikeLogging;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common.logging.OracleSQLLoggingClause;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common.logging.OracleSQLNoLoggingClause;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common.namecursor.OracleSQLFoundNameCursorExpr;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common.namecursor.OracleSQLIsOpenNameCursorExpr;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common.namecursor.OracleSQLNotFoundNameCursorExpr;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common.namecursor.OracleSQLRowcountNameCursorExpr;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common.storage.OracleSQLStorageClause;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.database.create.OracleSQLEnablePluggableDatabase;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.database.create.OracleSQLUserSysClause;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.database.create.OracleSQLUserSystemClause;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.databaselink.create.OracleSQLConnectToCurrentUserClause;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.databaselink.create.OracleSQLConnectToIdentifiedByClause;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.databaselink.create.OracleSQLDBLinkAuthenticationClause;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.select.*;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.table.OracleSQLXMLTypeVirtualColumns;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.table.OracleSQLXmlTypeStorage;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.table.alter.column.OracleSQLAlterTableDropPeriodAction;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.table.alter.supplementallog.OracleSQLAlterTableAddSupplementalLogAction;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.table.alter.supplementallog.OracleSQLAlterTableDropSupplementalLogAction;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.table.element.IOracleSQLSupplementLog;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.table.element.OracleSQLPeriodDefinition;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.table.element.OracleSQLSupplementalIdKeyClause;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.table.element.OracleSQLSupplementalLogGrpClause;
import com.aliyun.gumiho.sql.dialect.oracle.ast.enums.OracleSQLStoreAllVarraysAsType;
import com.aliyun.gumiho.sql.dialect.oracle.parser.OracleSQLStatementParser;
import com.aliyun.gumiho.sql.dialect.oracle.parser.OracleSQLStatementParserBaseVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author kongtong.ouyang onCondition 2018/3/6.
 */
public class OracleSQLASTBuilderVisitor extends OracleSQLStatementParserBaseVisitor<SQLObject> {


    private List<SQLObject> sqlObjects;

    public OracleSQLASTBuilderVisitor() {
    }

    public OracleSQLASTBuilderVisitor(List<SQLObject> sqlObjects) {
        this.sqlObjects = sqlObjects;
    }

    @Override
    public SQLObject visitParse(OracleSQLStatementParser.ParseContext ctx) {

        int childCount = ctx.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ParseTree parseTree = ctx.getChild(i);

            if (parseTree instanceof TerminalNode
                    && (
                    ((TerminalNode) parseTree).getSymbol().getType() == Token.EOF
                            || ((TerminalNode) parseTree).getSymbol().getType() == OracleSQLStatementParser.SEMI)
                    ) {
                continue;
            }

            SQLObject sqlObject = visit(parseTree);
            if (sqlObject == null) {
                continue;
            }
            if (i < childCount - 2) {
                ParseTree nextParseTree = ctx.getChild(i + 1);
                if (nextParseTree instanceof TerminalNode
                        && ((TerminalNode) nextParseTree).getSymbol().getType() == OracleSQLStatementParser.SEMI
                        ) {
                    sqlObject.setAfterSemi(true);
                }
            }


            sqlObjects.add(sqlObject);
        }


        return null;
    }

    @Override
    public SQLObject visitCommand(CommandContext ctx) {
        return null;
    }

    // --------------------------------------- DataType Start ----------------------------------------------------------------

    @Override
    public SQLDataType visitDataType(OracleSQLStatementParser.DataTypeContext ctx) {
        if (ctx == null) {
            return null;
        }
        return (SQLDataType) super.visitDataType(ctx);
    }

    @Override
    public SQLCharDataType visitCharDataType(CharDataTypeContext ctx) {
        SQLCharDataType x = new SQLCharDataType();

        if (ctx.size != null) {
            SQLExpr size = visitExpr(ctx.size);
            x.addArgument(size);
        }

        if (ctx.sizeUnit != null) {
            int sizeUnitType = ctx.sizeUnit.getType();
            SQLCharSizeUnit sizeUnit = null;
            if (OracleSQLStatementParser.BYTE == sizeUnitType) {
                sizeUnit = SQLCharSizeUnit.BYTE;
            } else if (OracleSQLStatementParser.CHAR == sizeUnitType) {
                sizeUnit = SQLCharSizeUnit.CHAR;
            }
            x.setCharSizeUnit(sizeUnit);
        }

        return x;
    }

    @Override
    public SQLDataType visitVarchar2DataType(Varchar2DataTypeContext ctx) {
        SQLVarchar2DataType x = new SQLVarchar2DataType();

        if (ctx.size != null) {
            SQLExpr size = visitExpr(ctx.size);
            x.addArgument(size);
        }

        if (ctx.sizeUnit != null) {
            int sizeUnitType = ctx.sizeUnit.getType();
            SQLCharSizeUnit sizeUnit = null;
            if (OracleSQLStatementParser.BYTE == sizeUnitType) {
                sizeUnit = SQLCharSizeUnit.BYTE;
            } else if (OracleSQLStatementParser.CHAR == sizeUnitType) {
                sizeUnit = SQLCharSizeUnit.CHAR;
            }
            x.setCharSizeUnit(sizeUnit);
        }

        return x;
    }

    @Override
    public SQLDataType visitNcharDataType(NcharDataTypeContext ctx) {
        SQLNCharDataType x = new SQLNCharDataType();

        if (ctx.size != null) {
            SQLExpr size = visitExpr(ctx.size);
            x.addArgument(size);
        }
        return x;
    }

    @Override
    public SQLNVarchar2DataType visitNvarchar2DataType(Nvarchar2DataTypeContext ctx) {
        SQLNVarchar2DataType x = new SQLNVarchar2DataType();

        if (ctx.size != null) {
            SQLExpr size = visitExpr(ctx.size);
            x.addArgument(size);
        }
        return x;
    }

    @Override
    public SQLNumberDataType visitNumberDataType(NumberDataTypeContext ctx) {
        SQLNumberDataType x = new SQLNumberDataType();

        if (ctx.precision != null) {
            SQLExpr precision = visitExpr(ctx.precision);
            x.addArgument(precision);
        }

        if (ctx.scale != null) {
            SQLExpr scale = visitExpr(ctx.scale);
            x.addArgument(scale);
        }
        return x;
    }

    @Override
    public SQLFloatDataType visitFloatDataType(FloatDataTypeContext ctx) {
        SQLFloatDataType x = new SQLFloatDataType();

        if (ctx.precision != null) {
            SQLExpr precision = visitExpr(ctx.precision);
            x.addArgument(precision);
        }

        return x;
    }

    @Override
    public SQLBinaryFloatDataType visitBinaryFloatDataType(BinaryFloatDataTypeContext ctx) {
        return new SQLBinaryFloatDataType();
    }

    @Override
    public SQLBinaryDoubleDataType visitBinaryDoubleDataType(BinaryDoubleDataTypeContext ctx) {
        return new SQLBinaryDoubleDataType();
    }

    @Override
    public SQLLongDataType visitLongDataType(LongDataTypeContext ctx) {
        return new SQLLongDataType();
    }

    @Override
    public SQLLongRawDataType visitLongRawDataType(LongRawDataTypeContext ctx) {
        return new SQLLongRawDataType();
    }

    @Override
    public SQLRawDataType visitRawDataType(RawDataTypeContext ctx) {
        SQLRawDataType x = new SQLRawDataType();

        if (ctx.size != null) {
            SQLExpr size = visitExpr(ctx.size);
            x.addArgument(size);
        }

        return x;
    }

    @Override
    public SQLDateDataType visitDateDataType(DateDataTypeContext ctx) {
        return new SQLDateDataType();
    }

    @Override
    public SQLTimestampDataType visitTimestampDataType(TimestampDataTypeContext ctx) {
        SQLTimestampDataType x = new SQLTimestampDataType();

        if (ctx.precision != null) {
            SQLExpr precision = visitExpr(ctx.precision);
            x.addArgument(precision);
        }

        if (ctx.WITH() != null) {
            SQLWithTimeZoneType zoneType = SQLWithTimeZoneType.WITH_TIME_ZONE;

            if (ctx.LOCAL() != null) {
                zoneType = SQLWithTimeZoneType.WITH_LOCAL_TIME_ZONE;
            }
            x.setWithTimeZoneType(zoneType);
        }

        return x;
    }

    @Override
    public SQLIntervalDataType visitIntervalDataType(IntervalDataTypeContext ctx) {
        SQLIntervalDataType x = new SQLIntervalDataType();

        SQLName name = SQLReserved.INTERVAL.ofExpr();
        int unitType = ctx.unit.getType();
        if (unitType == OracleSQLStatementParser.YEAR) {
            name = SQLReserved.INTERVAL_YEAR.ofExpr();
        } else if (unitType == OracleSQLStatementParser.DAY) {
            name = SQLReserved.INTERVAL_DAY.ofExpr();
        }
        x.setName(name);

        if (ctx.precision != null) {
            SQLExpr precision = visitExpr(ctx.precision);
            x.addArgument(precision);
        }


        int toUnitType = ctx.toUnit.getType();
        SQLIntervalUnit toIntervalUnit = null;
        if (toUnitType == OracleSQLStatementParser.MONTH) {
            toIntervalUnit = SQLIntervalUnit.MONTH;
        } else if (toUnitType == OracleSQLStatementParser.SECOND) {
            toIntervalUnit = SQLIntervalUnit.SECOND;
        }
        x.setToUnit(toIntervalUnit);


        if (ctx.toPrecision != null) {
            SQLExpr toPrecision = visitExpr(ctx.toPrecision);
            x.addToPrecision(toPrecision);
        }

        return x;
    }

    @Override
    public SQLBlobDataType visitBlobDataType(BlobDataTypeContext ctx) {
        return new SQLBlobDataType();
    }

    @Override
    public SQLClobDataType visitClobDataType(ClobDataTypeContext ctx) {
        return new SQLClobDataType();
    }

    @Override
    public SQLNClobDataType visitNclobDataType(NclobDataTypeContext ctx) {
        return new SQLNClobDataType();
    }

    @Override
    public SQLBFileDataType visitBfileDataType(BfileDataTypeContext ctx) {
        return new SQLBFileDataType();
    }

    @Override
    public SQLRowIdDataType visitRowidDataType(RowidDataTypeContext ctx) {
        return new SQLRowIdDataType();
    }

    @Override
    public SQLURowIdDataType visitUrowidDataType(UrowidDataTypeContext ctx) {
        SQLURowIdDataType x = new SQLURowIdDataType();
        if (ctx.size != null) {
            SQLExpr size = visitExpr(ctx.size);
            x.addArgument(size);
        }
        return x;
    }

    @Override
    public SQLBooleanDataType visitBooleanDataType(BooleanDataTypeContext ctx) {
        return new SQLBooleanDataType();
    }

    @Override
    public SQLCharacterDataType visitCharacterDataType(CharacterDataTypeContext ctx) {
        SQLCharacterDataType x = new SQLCharacterDataType();
        if (ctx.size != null) {
            SQLExpr size = visitExpr(ctx.size);
            x.addArgument(size);
        }
        return x;
    }

    @Override
    public SQLCharacterVaryingDataType visitCharacterVaryingDataType(CharacterVaryingDataTypeContext ctx) {
        SQLCharacterVaryingDataType x = new SQLCharacterVaryingDataType();
        if (ctx.size != null) {
            SQLExpr size = visitExpr(ctx.size);
            x.addArgument(size);
        }
        return x;
    }

    @Override
    public SQLCharVaryingDataType visitCharVaryingDataType(CharVaryingDataTypeContext ctx) {
        SQLCharVaryingDataType x = new SQLCharVaryingDataType();
        if (ctx.size != null) {
            SQLExpr size = visitExpr(ctx.size);
            x.addArgument(size);
        }
        return x;
    }

    @Override
    public SQLNCharVaryingDataType visitNcharVaryingDataType(NcharVaryingDataTypeContext ctx) {
        SQLNCharVaryingDataType x = new SQLNCharVaryingDataType();

        if (ctx.size != null) {
            SQLExpr size = visitExpr(ctx.size);
            x.addArgument(size);
        }
        return x;
    }

    @Override
    public SQLVarcharDataType visitVarcharDataType(VarcharDataTypeContext ctx) {
        SQLVarcharDataType x = new SQLVarcharDataType();
        if (ctx.size != null) {
            SQLExpr size = visitExpr(ctx.size);
            x.addArgument(size);
        }
        return x;
    }

    @Override
    public SQLNationalCharacterDataType visitNationalCharacterDataType(NationalCharacterDataTypeContext ctx) {
        SQLNationalCharacterDataType x = new SQLNationalCharacterDataType();
        if (ctx.size != null) {
            SQLExpr size = visitExpr(ctx.size);
            x.addArgument(size);
        }
        return x;
    }

    @Override
    public SQLNationalCharDataType visitNationalCharDataType(NationalCharDataTypeContext ctx) {
        SQLNationalCharDataType x = new SQLNationalCharDataType();
        if (ctx.size != null) {
            SQLExpr size = visitExpr(ctx.size);
            x.addArgument(size);
        }
        return x;
    }

    @Override
    public SQLNationalCharacterVaryingDataType visitNationalCharacterVaryingDataType(NationalCharacterVaryingDataTypeContext ctx) {
        SQLNationalCharacterVaryingDataType x = new SQLNationalCharacterVaryingDataType();
        if (ctx.size != null) {
            SQLExpr size = visitExpr(ctx.size);
            x.addArgument(size);
        }
        return x;
    }

    @Override
    public SQLNationalCharVaryingDataType visitNationalCharVaryingDataType(NationalCharVaryingDataTypeContext ctx) {
        SQLNationalCharVaryingDataType x = new SQLNationalCharVaryingDataType();
        if (ctx.size != null) {
            SQLExpr size = visitExpr(ctx.size);
            x.addArgument(size);
        }
        return x;
    }

    @Override
    public SQLNumericDataType visitNumericDataType(NumericDataTypeContext ctx) {
        SQLNumericDataType x = new SQLNumericDataType();

        if (ctx.precision != null) {
            SQLExpr precision = visitExpr(ctx.precision);
            x.addArgument(precision);
        }
        if (ctx.scale != null) {
            SQLExpr scale = visitExpr(ctx.scale);
            x.addArgument(scale);
        }
        return x;
    }

    @Override
    public SQLDecimalDataType visitDecimalDataType(DecimalDataTypeContext ctx) {
        SQLDecimalDataType x = new SQLDecimalDataType();

        if (ctx.precision != null) {
            SQLExpr precision = visitExpr(ctx.precision);
            x.addArgument(precision);
        }
        if (ctx.scale != null) {
            SQLExpr scale = visitExpr(ctx.scale);
            x.addArgument(scale);
        }
        return x;
    }

    @Override
    public SQLDecDataType visitDecDataType(DecDataTypeContext ctx) {
        SQLDecDataType x = new SQLDecDataType();
        if (ctx.precision != null) {
            SQLExpr precision = visitExpr(ctx.precision);
            x.addArgument(precision);
        }
        if (ctx.scale != null) {
            SQLExpr scale = visitExpr(ctx.scale);
            x.addArgument(scale);
        }
        return x;
    }

    @Override
    public SQLIntegerDataType visitIntegerDataType(IntegerDataTypeContext ctx) {
        return new SQLIntegerDataType();
    }

    @Override
    public SQLIntDataType visitIntDataType(IntDataTypeContext ctx) {
        return new SQLIntDataType();
    }

    @Override
    public SQLSmallintDataType visitSmallintDataType(SmallintDataTypeContext ctx) {
        return new SQLSmallintDataType();
    }

    @Override
    public SQLDoublePrecisionDataType visitDoublePrecisionDataType(DoublePrecisionDataTypeContext ctx) {
        return new SQLDoublePrecisionDataType();
    }

    @Override
    public SQLRealDataType visitRealDataType(RealDataTypeContext ctx) {
        return new SQLRealDataType();
    }

    @Override
    public SQLAnyDataDataType visitAnyDataDataType(AnyDataDataTypeContext ctx) {
        boolean sysOwner = ctx.SYS() != null;
        return new SQLAnyDataDataType(sysOwner);
    }

    @Override
    public SQLAnyTypeDataType visitAnyTypeDataType(AnyTypeDataTypeContext ctx) {
        boolean sysOwner = ctx.SYS() != null;
        return new SQLAnyTypeDataType(sysOwner);
    }

    @Override
    public SQLAnyDataSetDataType visitAnyDataSetDataType(AnyDataSetDataTypeContext ctx) {
        boolean sysOwner = ctx.SYS() != null;
        return new SQLAnyDataSetDataType(sysOwner);
    }

    @Override
    public SQLXmlTypeDataType visitXmlTypeDataType(XmlTypeDataTypeContext ctx) {
        boolean sysOwner = ctx.SYS() != null;
        return new SQLXmlTypeDataType(sysOwner);
    }

    @Override
    public SQLUriTypeDataType visitUriTypeDataType(UriTypeDataTypeContext ctx) {
        boolean sysOwner = ctx.SYS() != null;
        return new SQLUriTypeDataType(sysOwner);
    }

    @Override
    public SQLJsonDataType visitJsonDataType(JsonDataTypeContext ctx) {
        return new SQLJsonDataType();
    }

    @Override
    public SQLSDOGeometryDataType visitSdoGeometryDataType(SdoGeometryDataTypeContext ctx) {
        boolean sysOwner = ctx.SYS() != null;
        return new SQLSDOGeometryDataType(sysOwner);
    }

    @Override
    public SQLSDOTopoGeometryDataType visitSdoTopoGeometryDataType(SdoTopoGeometryDataTypeContext ctx) {
        boolean sysOwner = ctx.SYS() != null;
        return new SQLSDOTopoGeometryDataType(sysOwner);
    }

    @Override
    public SQLSDOGeoRasterDataType visitSdoGeorasterDataType(SdoGeorasterDataTypeContext ctx) {
        boolean sysOwner = ctx.SYS() != null;
        return new SQLSDOGeoRasterDataType(sysOwner);
    }

    @Override
    public SQLORDAudioDataType visitORDAUDIODataType(ORDAUDIODataTypeContext ctx) {
        boolean sysOwner = ctx.SYS() != null;
        return new SQLORDAudioDataType(sysOwner);
    }

    @Override
    public SQLORDImageDataType visitORDIMAGEDataType(ORDIMAGEDataTypeContext ctx) {
        boolean sysOwner = ctx.SYS() != null;
        return new SQLORDImageDataType(sysOwner);
    }

    @Override
    public SQLORDVideoDataType visitORDVIDEODataType(ORDVIDEODataTypeContext ctx) {
        boolean sysOwner = ctx.SYS() != null;
        return new SQLORDVideoDataType(sysOwner);
    }

    @Override
    public SQLORDDocDataType visitORDDOCDataType(ORDDOCDataTypeContext ctx) {
        boolean sysOwner = ctx.SYS() != null;
        return new SQLORDDocDataType(sysOwner);
    }

    @Override
    public SQLORDDicomDataType visitORDDICOMDataType(ORDDICOMDataTypeContext ctx) {
        boolean sysOwner = ctx.SYS() != null;
        return new SQLORDDicomDataType(sysOwner);
    }

    @Override
    public SQLSIStillImageDataType visitSiStillimageDataType(SiStillimageDataTypeContext ctx) {
        boolean sysOwner = ctx.SYS() != null;
        return new SQLSIStillImageDataType(sysOwner);
    }

    @Override
    public SQLSIAverageColorDataType visitSiAveragecolorDataType(SiAveragecolorDataTypeContext ctx) {
        boolean sysOwner = ctx.SYS() != null;
        return new SQLSIAverageColorDataType(sysOwner);
    }

    @Override
    public SQLSIPositionalColorDataType visitSiPositionalcolorDataType(SiPositionalcolorDataTypeContext ctx) {
        boolean sysOwner = ctx.SYS() != null;
        return new SQLSIPositionalColorDataType(sysOwner);
    }

    @Override
    public SQLSIColorHistogramDataType visitSiColorhistogramDataType(SiColorhistogramDataTypeContext ctx) {
        boolean sysOwner = ctx.SYS() != null;
        return new SQLSIColorHistogramDataType(sysOwner);
    }

    @Override
    public SQLSITextureDataType visitSiTextureDataType(SiTextureDataTypeContext ctx) {
        boolean sysOwner = ctx.SYS() != null;
        return new SQLSITextureDataType(sysOwner);
    }

    @Override
    public SQLSIFeatureListDataType visitSiFeaturelistDataType(SiFeaturelistDataTypeContext ctx) {
        boolean sysOwner = ctx.SYS() != null;
        return new SQLSIFeatureListDataType(sysOwner);
    }

    @Override
    public SQLSIColorDataType visitSiColorDataType(SiColorDataTypeContext ctx) {
        boolean sysOwner = ctx.SYS() != null;
        return new SQLSIColorDataType(sysOwner);
    }

    @Override
    public SQLPlsIntegerDataType visitPlsIntegerDataType(PlsIntegerDataTypeContext ctx) {
        return new SQLPlsIntegerDataType();
    }

    @Override
    public SQLNaturalDataType visitNaturalDataType(NaturalDataTypeContext ctx) {
        return new SQLNaturalDataType();
    }

    @Override
    public SQLNaturalnDataType visitNaturalnDataType(NaturalnDataTypeContext ctx) {
        return new SQLNaturalnDataType();
    }

    @Override
    public SQLPositiveDataType visitPositiveDataType(PositiveDataTypeContext ctx) {
        return new SQLPositiveDataType();
    }

    @Override
    public SQLPositivenDataType visitPositivenDataType(PositivenDataTypeContext ctx) {
        return new SQLPositivenDataType();
    }

    @Override
    public SQLSigntypeDataType visitSigntypeDataType(SigntypeDataTypeContext ctx) {
        return new SQLSigntypeDataType();
    }

    @Override
    public SQLSimpleIntegerDataType visitSimpleIntegerDataType(SimpleIntegerDataTypeContext ctx) {
        return new SQLSimpleIntegerDataType();
    }

    @Override
    public SQLBinaryIntegerDataType visitBinaryIntegerDataType(BinaryIntegerDataTypeContext ctx) {
        return new SQLBinaryIntegerDataType();
    }


    @Override
    public SQLRefDataType visitRefDataType(RefDataTypeContext ctx) {
        SQLRefDataType x = new SQLRefDataType();
        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.addArgument(name);
        return x;
    }

    @Override
    public SQLDataTypeImpl visitOtherDataType(OtherDataTypeContext ctx) {
        SQLName name = visitNameIdentifier(ctx.name);

        SQLDataTypeImpl x = new SQLDataTypeImpl(name);

        if (ctx.LEFT_PAREN() != null) {
            x.setParen(true);
        }

        for (ExprContext exprContext : ctx.expr()) {
            SQLExpr argument = visitExpr(exprContext);
            x.addArgument(argument);
        }

        return x;
    }

    @Override
    public SQLObject visitRefCursorDataType(RefCursorDataTypeContext ctx) {
        return super.visitRefCursorDataType(ctx);
    }

    @Override
    public SQLPercentTypeDataType visitTypeDataType(TypeDataTypeContext ctx) {
        SQLPercentTypeDataType x = new SQLPercentTypeDataType();

        SQLName name = visitNameIdentifier(ctx.name);
        x.setName(name);

        return x;
    }

    @Override
    public SQLPercentRowTypeDataType visitRowtypeDataType(RowtypeDataTypeContext ctx) {
        SQLPercentRowTypeDataType x = new SQLPercentRowTypeDataType();
        SQLName name = visitNameIdentifier(ctx.name);
        x.setName(name);
        return x;
    }

    @Override
    public SQLAssocArrayDataType visitAssocArrayDataType(AssocArrayDataTypeContext ctx) {
        SQLAssocArrayDataType x = new SQLAssocArrayDataType();

        SQLDataType of = visitDataType(ctx.of);
        x.setOfDataType(of);

        if (ctx.notNull() != null) {
            x.setNotNull(true);
        }

        SQLDataType indexBy = visitDataType(ctx.indexBy);
        x.setIndexByDataType(indexBy);

        return x;
    }

    @Override
    public SQLVarrayDataType visitVarrayDataType(VarrayDataTypeContext ctx) {
        SQLVarrayDataType x = new SQLVarrayDataType();

        SQLExpr size = visitExpr(ctx.expr());
        x.setSize(size);

        if (ctx.argumentParen != null) {
            x.setParen(true);
        }
        SQLDataType dataType = visitDataType(ctx.dataType());
        x.setDataType(dataType);

        if (ctx.notNull() != null) {
            x.setNotNull(true);
        }

        return x;
    }

    @Override
    public SQLVaryingArrayDataType visitVaryingArrayDataType(VaryingArrayDataTypeContext ctx) {
        SQLVaryingArrayDataType x = new SQLVaryingArrayDataType();

        SQLExpr size = visitExpr(ctx.expr());
        x.setSize(size);

        if (ctx.argumentParen != null) {
            x.setParen(true);
        }

        SQLDataType dataType = visitDataType(ctx.dataType());
        x.setDataType(dataType);

        if (ctx.notNull() != null) {
            x.setNotNull(true);
        }

        return x;
    }

    @Override
    public SQLNestedTableDataType visitNestedTableDataType(NestedTableDataTypeContext ctx) {
        SQLNestedTableDataType x = new SQLNestedTableDataType();

        if (ctx.argumentParen != null) {
            x.setParen(true);
        }
        SQLDataType dataType = visitDataType(ctx.dataType());
        x.setDataType(dataType);
        if (ctx.notNull() != null) {
            x.setNotNull(true);
        }

        return x;
    }

    @Override
    public SQLObjectSubDataType visitObjectSubDataType(ObjectSubDataTypeContext ctx) {
        if (ctx == null) {
            return null;
        }
        SQLObjectSubDataType x = new SQLObjectSubDataType();
        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setSuperDataType(name);
        return x;
    }

    @Override
    public SQLObjectDataType visitObjectDataType(ObjectDataTypeContext ctx) {
        if (ctx == null) {
            return null;
        }
        return new SQLObjectDataType();
    }

    @Override
    public SQLSelfAsResultDataType visitSelfAsResultDataType(SelfAsResultDataTypeContext ctx) {
        if (ctx == null) {
            return null;
        }
        return new SQLSelfAsResultDataType();
    }

    // --------------------------------------- DataType End ----------------------------------------------------------------


    // --------------------------------------- Identifier Start ----------------------------------------------------------------

    public SQLIdentifier visitIdentifier(IdentifierContext ctx) {
        return (SQLIdentifier) super.visit(ctx);
    }

    @Override
    public SQLAllColumnExpr visitAsteriskIdentifier(AsteriskIdentifierContext ctx) {
        return new SQLAllColumnExpr();
    }

    @Override
    public SQLIdentifierImpl visitNormalIdentifier(NormalIdentifierContext ctx) {
        return new SQLIdentifierImpl(ctx.getText());
    }

    @Override
    public SQLDoubleQuoteIdentifier visitDoubleQuoteIdentifier(DoubleQuoteIdentifierContext ctx) {
        return new SQLDoubleQuoteIdentifier(ctx.getText());
    }


    public SQLName visitNameIdentifier(NameIdentifierContext ctx) {
        if (ctx == null) {
            return null;
        }
        return (SQLName) super.visit(ctx);
    }

    @Override
    public SQLName visitPropertyIdentifier1(PropertyIdentifier1Context ctx) {

        SQLName owner = visitIdentifier(ctx.identifier(0));
        SQLIdentifier name = (SQLIdentifier) visit(ctx.identifier(1));

        SQLPropertyExpr x = new SQLPropertyExpr(owner, name);

        for (int i = 2; i < ctx.identifier().size(); i++) {
            SQLIdentifier nextName = visitIdentifier(ctx.identifier(i));
            x = new SQLPropertyExpr(x, nextName);
        }

        return x;
    }


    @Override
    public SQLPropertyExpr visitPropertyIdentifier2(PropertyIdentifier2Context ctx) {
        SQLExpr owner = visitExpr(ctx.expr());
        SQLName name = (SQLName) visit(ctx.nameIdentifier());
        return new SQLPropertyExpr(owner, name);
    }

    @Override
    public SQLName visitDbLinkNameIdentifier(DbLinkNameIdentifierContext ctx) {
        SQLName name = visitNameIdentifier(ctx.queryName);
        SQLName dbLink = visitNameIdentifier(ctx.dbLink);

        return new SQLDBLinkExpr(name, dbLink);
    }
    // --------------------------------------- Identifier End ----------------------------------------------------------------


    // --------------------------------------- Literals Start ----------------------------------------------------------------
    public SQLLiteral visitLiteral(LiteralContext ctx) {
        if (ctx == null) {
            return null;
        }
        return (SQLLiteral) super.visit(ctx);
    }

    @Override
    public SQLCharLiteral visitCharLiteral(CharLiteralContext ctx) {
        return new SQLCharLiteral(ctx.getText());
    }

    @Override
    public SQLNCharLiteral visitNCharLiteral(NCharLiteralContext ctx) {
        String value = SQLNCharLiteral.removeQChar(ctx.getText());
        return new SQLNCharLiteral(value);
    }

    @Override
    public SQLQCharLiteral visitQCharLiteral(QCharLiteralContext ctx) {
        String value = SQLQCharLiteral.removeNQChar(ctx.getText());
        return new SQLQCharLiteral(value);
    }

    @Override
    public SQLNQCharLiteral visitNQCharLiteral(NQCharLiteralContext ctx) {
        String value = SQLNQCharLiteral.removeNQChar(ctx.getText());
        return new SQLNQCharLiteral(value);
    }

    @Override
    public SQLIntegerLiteral visitIntegerLiteral(IntegerLiteralContext ctx) {
        return new SQLIntegerLiteral(ctx.getText());
    }

    @Override
    public SQLNumberLiteral visitNumberLiteral(NumberLiteralContext ctx) {
        return new SQLNumberLiteral(ctx.getText());
    }

    @Override
    public SQLBinaryFloatLiteral visitBinaryFloatLiteral(BinaryFloatLiteralContext ctx) {
        return new SQLBinaryFloatLiteral(ctx.getText());
    }

    @Override
    public SQLBinaryDoubleLiteral visitBinaryDoubleLiteral(BinaryDoubleLiteralContext ctx) {
        return new SQLBinaryDoubleLiteral(ctx.getText());
    }

    @Override
    public SQLDateLiteral visitDateLiteral(DateLiteralContext ctx) {
        SQLExpr value = visitExpr(ctx.expr());
        return new SQLDateLiteral(value);
    }

    @Override
    public SQLTimestampLiteral visitTimestampLiteral(TimestampLiteralContext ctx) {
        SQLExpr value = visitExpr(ctx.value);
        return new SQLTimestampLiteral(value);
    }

//    @Override
//    public SQLDatetimeLiteral visitDateTimeLiteral(DateTimeLiteralContext ctx) {


//        return (SQLDatetimeLiteral) super.visitDateTimeLiteral(ctx);
//    }

    @Override
    public SQLIntervalLiteral visitIntervalLiteral(IntervalLiteralContext ctx) {
        SQLIntervalLiteral x = new SQLIntervalLiteral();

        SQLExpr value = (SQLExpr) visitChildren(ctx.value);
        x.setValue(value);

        SQLIntervalUnit unit = SQLIntervalUnit.valueOf(ctx.unit.getText());
        x.setUnit(unit);

        for (ExprContext precision : ctx.precisions) {
            SQLExpr precisionExpr = (SQLExpr) visitChildren(precision);
            x.addPrecisions(precisionExpr);
        }

        if (ctx.toUnit != null) {
            SQLIntervalUnit toUnit = SQLIntervalUnit.valueOf(ctx.toUnit.getText());
            x.setToUnit(toUnit);

            for (ExprContext toPrecision : ctx.toPrecisions) {
                SQLExpr toPrecisionExpr = (SQLExpr) visitChildren(toPrecision);
                x.addToPrecision(toPrecisionExpr);
            }
        }

        return x;
    }


    @Override
    public SQLNullExpr visitNullExpr(NullExprContext ctx) {
        return new SQLNullExpr();
    }

    @Override
    public SQLDefaultLiteral visitDefaultLiteral(DefaultLiteralContext ctx) {
        return new SQLDefaultLiteral();
    }

    @Override
    public SQLAnyLiteral visitAnyLiteral(AnyLiteralContext ctx) {
        return new SQLAnyLiteral();
    }

    @Override
    public SQLMinValueLiteral visitMinValueLiteral(MinValueLiteralContext ctx) {
        return new SQLMinValueLiteral();
    }

    @Override
    public SQLMaxValueLiteral visitMaxValueLiteral(MaxValueLiteralContext ctx) {
        return new SQLMaxValueLiteral();
    }

    @Override
    public SQLUnLimitedLiteral visitUnlimitedLiteral(UnlimitedLiteralContext ctx) {
        return new SQLUnLimitedLiteral();
    }

    @Override
    public SQLBooleanLiteral visitFalseLiteral(FalseLiteralContext ctx) {
        return new SQLBooleanLiteral(false);
    }

    @Override
    public SQLBooleanLiteral visitTrueLiteral(TrueLiteralContext ctx) {
        return new SQLBooleanLiteral(true);
    }

    // --------------------------------------- Literals End ----------------------------------------------------------------


    // --------------------------------------- Pseudo Column Start ----------------------------------------------------------------

    @Override
    public SQLColumnValueExpr visitColumnValueExpr(ColumnValueExprContext ctx) {
        return new SQLColumnValueExpr();
    }

    @Override
    public SQLConnectByIsCycleExpr visitConnectByIsCycleExpr(ConnectByIsCycleExprContext ctx) {
        return new SQLConnectByIsCycleExpr();
    }

    @Override
    public SQLConnectByIsLeafExpr visitConnectByIsLeafExpr(ConnectByIsLeafExprContext ctx) {
        return new SQLConnectByIsLeafExpr();
    }

    @Override
    public SQLLevelExpr visitLevelExpr(LevelExprContext ctx) {
        return new SQLLevelExpr();
    }

    @Override
    public SQLObjectIdExpr visitObjectIdExpr(ObjectIdExprContext ctx) {
        return new SQLObjectIdExpr();
    }

    @Override
    public SQLObjectValueExpr visitObjectValueExpr(ObjectValueExprContext ctx) {
        return new SQLObjectValueExpr();
    }

    @Override
    public SQLOraRowScnExpr visitOraRowScnExpr(OraRowScnExprContext ctx) {
        return new SQLOraRowScnExpr();
    }

    @Override
    public SQLRowIdExpr visitRowIdExpr(RowIdExprContext ctx) {
        return new SQLRowIdExpr();
    }

    @Override
    public SQLRowNumExpr visitRowNumExpr(RowNumExprContext ctx) {
        return new SQLRowNumExpr();
    }

    @Override
    public SQLSequenceExpr visitSequenceExpr(SequenceExprContext ctx) {
        SQLName sequence = visitNameIdentifier(ctx.sequence);

        SQLSequenceExpr.SQLSequenceFunction name = null;
        if (ctx.CURRVAL() != null) {
            name = SQLSequenceExpr.SQLSequenceFunction.CURRVAL;
        } else if (ctx.NEXTVAL() != null) {
            name = SQLSequenceExpr.SQLSequenceFunction.NEXTVAL;
        }
        return new SQLSequenceExpr(sequence, name);
    }

    @Override
    public SQLVersionsEndScnExpr visitVersionsEndScnExpr(VersionsEndScnExprContext ctx) {
        return new SQLVersionsEndScnExpr();
    }

    @Override
    public SQLObject visitVersionsEndTimeExpr(VersionsEndTimeExprContext ctx) {
        return new SQLVersionsEndScnExpr();
    }

    @Override
    public SQLVersionsOperationExpr visitVersionsOperationExpr(VersionsOperationExprContext ctx) {
        return new SQLVersionsOperationExpr();
    }

    @Override
    public SQLVersionsStartScnExpr visitVersionsStartScnExpr(VersionsStartScnExprContext ctx) {
        return new SQLVersionsStartScnExpr();
    }

    @Override
    public SQLVersionsStartTimeExpr visitVersionsStartTimeExpr(VersionsStartTimeExprContext ctx) {
        return new SQLVersionsStartTimeExpr();
    }

    @Override
    public SQLVersionsXidExpr visitVersionsXidExpr(VersionsXidExprContext ctx) {
        return new SQLVersionsXidExpr();
    }

    @Override
    public SQLXmlDataExpr visitXmlDataExpr(XmlDataExprContext ctx) {
        return new SQLXmlDataExpr();
    }

    // --------------------------------------- Pseudo Column End ----------------------------------------------------------------


    // --------------------------------------- Operators Start ----------------------------------------------------------------

    // --------------------------------------- Operators End ----------------------------------------------------------------


    // --------------------------------------- expr Start ----------------------------------------------------------------
    public SQLExpr visitExpr(ExprContext ctx) {
        if (ctx == null) {
            return null;
        }
        return (SQLExpr) super.visit(ctx);
    }

    @Override
    public SQLUnaryOperatorExpr visitUnaryOperatorExpr(UnaryOperatorExprContext ctx) {
        boolean paren = ctx.LEFT_PAREN() != null;
        SQLUnaryOperator operator = SQLUnaryOperator.of(ctx.unaryOperator().getText());
        SQLExpr expr = visitExpr(ctx.expr());
        SQLUnaryOperatorExpr x = new SQLUnaryOperatorExpr(paren, operator, expr);
        return x;
    }

    @Override
    public SQLBinaryOperatorExpr visitMultisetExceptOperatorExpr(MultisetExceptOperatorExprContext ctx) {
        boolean paren = ctx.LEFT_PAREN() != null;
        SQLName nestedTable1 = visitNameIdentifier(ctx.nestedTable1);
        SQLName nestedTable2 = visitNameIdentifier(ctx.nestedTable2);
        SQLBinaryOperator operator = SQLBinaryOperator.MULTISET_EXCEPT;
        if (ctx.ALL() != null) {
            operator = SQLBinaryOperator.MULTISET_EXCEPT_ALL;
        } else if (ctx.DISTINCT() != null) {
            operator = SQLBinaryOperator.MULTISET_EXCEPT_DISTINCT;
        }
        return new SQLBinaryOperatorExpr(paren, nestedTable1, operator, nestedTable2);
    }

    @Override
    public SQLBinaryOperatorExpr visitMultisetIntersectOperatorExpr(MultisetIntersectOperatorExprContext ctx) {
        boolean paren = ctx.LEFT_PAREN() != null;
        SQLName nestedTable1 = visitNameIdentifier(ctx.nestedTable1);
        SQLName nestedTable2 = visitNameIdentifier(ctx.nestedTable2);
        SQLBinaryOperator operator = SQLBinaryOperator.MULTISET_INTERSECT;
        if (ctx.ALL() != null) {
            operator = SQLBinaryOperator.MULTISET_INTERSECT_ALL;
        } else if (ctx.DISTINCT() != null) {
            operator = SQLBinaryOperator.MULTISET_INTERSECT_DISTINCT;
        }
        return new SQLBinaryOperatorExpr(paren, nestedTable1, operator, nestedTable2);
    }

    @Override
    public SQLBinaryOperatorExpr visitMultisetUnionOperatorExpr(MultisetUnionOperatorExprContext ctx) {
        boolean paren = ctx.LEFT_PAREN() != null;
        SQLName nestedTable1 = visitNameIdentifier(ctx.nestedTable1);
        SQLName nestedTable2 = visitNameIdentifier(ctx.nestedTable2);
        SQLBinaryOperator operator = SQLBinaryOperator.MULTISET_UNION;
        if (ctx.ALL() != null) {
            operator = SQLBinaryOperator.MULTISET_UNION_ALL;
        } else if (ctx.DISTINCT() != null) {
            operator = SQLBinaryOperator.MULTISET_UNION_DISTINCT;
        }
        return new SQLBinaryOperatorExpr(paren, nestedTable1, operator, nestedTable2);
    }

    @Override
    public SQLVariableExpr visitVariableExpr(VariableExprContext ctx) {
        return new SQLVariableExpr();
    }

    @Override
    public SQLBindVariableExpr visitBindVariableExpr(BindVariableExprContext ctx) {
        return new SQLBindVariableExpr(ctx.getText());
    }

    @Override
    public SQLColonNewVariableRefExpr visitNewVariableRefExpr(NewVariableRefExprContext ctx) {
        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        return new SQLColonNewVariableRefExpr(name);
    }

    @Override
    public SQLColonOldVariableRefExpr visitOldVariableRefExpr(OldVariableRefExprContext ctx) {
        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        return new SQLColonOldVariableRefExpr(name);
    }

    @Override
    public SQLSelectQueryExpr visitSelectQueryExpr(SelectQueryExprContext ctx) {
        ISQLSelectQuery subQuery = visitISelectQuery(ctx.iSelectQuery());
        SQLSelectQueryExpr x = new SQLSelectQueryExpr(subQuery);

        if (ctx.LEFT_PAREN() != null
                && ctx.RIGHT_PAREN() != null) {
            x.setParen(true);
        }
        return x;
    }

    @Override
    public SQLAnyClause visitAnyExpr(AnyExprContext ctx) {
        SQLExpr expr = visitExpr(ctx.expr());
        return new SQLAnyClause(expr);
    }

    @Override
    public SQLAllClause visitAllExpr(AllExprContext ctx) {
        SQLExpr expr = visitExpr(ctx.expr());
        return new SQLAllClause(expr);
    }

    @Override
    public SQLSomeClause visitSomeExpr(SomeExprContext ctx) {
        SQLExpr expr = visitExpr(ctx.expr());
        return new SQLSomeClause(expr);
    }

    @Override
    public SQLCaseExpr visitCaseExpr(CaseExprContext ctx) {
        SQLCaseExpr x = new SQLCaseExpr();

        if (ctx.expr() != null) {
            SQLExpr expr = visitExpr(ctx.expr());
            x.setExpr(expr);
        }

        for (CaseExprWhenItemContext caseExprWhenItemContext : ctx.caseExprWhenItem()) {
            SQLCaseExpr.SQLCaseExprWhenItem whenItem = visitCaseExprWhenItem(caseExprWhenItemContext);
            x.addWhenItem(whenItem);
        }

        if (ctx.caseExprElseClause() != null) {
            SQLCaseExpr.SQLCaseExprElseClause elseClause = visitCaseExprElseClause(ctx.caseExprElseClause());
            x.setElseClause(elseClause);
        }

        return x;
    }

    @Override
    public SQLCaseExpr.SQLCaseExprWhenItem visitCaseExprWhenItem(CaseExprWhenItemContext ctx) {

        SQLExpr when = visitExpr(ctx.when);
        SQLExpr then = visitExpr(ctx.then);

        return new SQLCaseExpr.SQLCaseExprWhenItem(when, then);
    }

    @Override
    public SQLCaseExpr.SQLCaseExprElseClause visitCaseExprElseClause(CaseExprElseClauseContext ctx) {
        SQLExpr expr = visitExpr(ctx.expr());
        return new SQLCaseExpr.SQLCaseExprElseClause(expr);
    }

    @Override
    public SQLCursorExpr visitCursorExpr(CursorExprContext ctx) {
        ISQLSelectQuery subQuery = visitISelectQuery(ctx.iSelectQuery());
        SQLCursorExpr x = new SQLCursorExpr(subQuery);
        return x;
    }

    @Override
    public SQLPlaceholderExpr visitPlaceholderExpr(PlaceholderExprContext ctx) {

        SQLBindVariableExpr hostVar = visitBindVariableExpr(ctx.hostVar);
        boolean indicator = ctx.INDICATOR() != null;
        SQLBindVariableExpr indicatorVar = visitBindVariableExpr(ctx.indicatorVar);

        return new SQLPlaceholderExpr(hostVar, indicator, indicatorVar);
    }

    @Override
    public SQLTypeConstructorExpr visitTypeConstructorExpr(TypeConstructorExprContext ctx) {
        SQLName name = visitNameIdentifier(ctx.name);

        SQLTypeConstructorExpr x = new SQLTypeConstructorExpr(name);

        for (ExprContext exprContext : ctx.expr()) {
            SQLExpr argument = visitExpr(exprContext);
            x.addArgument(argument);
        }
        return x;
    }

    @Override
    public SQLListExpr visitListExpr(ListExprContext ctx) {
        SQLListExpr x = new SQLListExpr();
        for (ExprContext exprContext : ctx.expr()) {
            SQLExpr item = visitExpr(exprContext);
            x.addItem(item);
        }
        return x;
    }

    @Override
    public SQLOuterJoinExpr visitOuterExpr(OuterExprContext ctx) {
        SQLName name = visitNameIdentifier(ctx.name);
        return new SQLOuterJoinExpr(name);
    }

    @Override
    public SQLExpr visitExprBasic(ExprBasicContext ctx) {
        return (SQLExpr) super.visitExprBasic(ctx);
    }

    @Override
    public SQLObject visitBasicExpr(BasicExprContext ctx) {
        return super.visitBasicExpr(ctx);
    }

    @Override
    public SQLArrayExpr visitArrayExpr(ArrayExprContext ctx) {
        SQLExpr name = visitExpr(ctx.name);

        SQLArrayExpr x = new SQLArrayExpr();
        x.setName(name);
        for (CellAssignmentItemContext cellAssignmentItemContext : ctx.arguments) {
            SQLExpr argument = (SQLExpr) visitChildren(cellAssignmentItemContext);
            x.addArgument(argument);
        }
        return x;
    }

    @Override
    public AbstractSQLFunction.SQLDefaultOnConversionError visitDefaultOnConversionErrorExpr(DefaultOnConversionErrorExprContext ctx) {
        SQLExpr value = visitExpr(ctx.expr());
        return new AbstractSQLFunction.SQLDefaultOnConversionError(value);
    }

    @Override
    public SQLDefaultClause visitDefaultClause(DefaultClauseContext ctx) {
        SQLDefaultClause x = new SQLDefaultClause();

        if (ctx.ASSIGN_OP() != null) {
            x.setOp(SQLDefaultClause.OpType.VAR_ASSIGN_OP);
        }

        SQLExpr expr = visitExpr(ctx.expr());
        x.setExpr(expr);

        return x;
    }

    @Override
    public SQLDefaultOnNullClause visitDefaultOnNullClause(DefaultOnNullClauseContext ctx) {
        SQLDefaultOnNullClause x = new SQLDefaultOnNullClause();
        SQLExpr expr = visitExpr(ctx.expr());
        x.setExpr(expr);
        return x;
    }

    @Override
    public SQLAssignmentExpr visitAssignmentExpr(AssignmentExprContext ctx) {
        SQLExpr column = visitExpr(ctx.column);
        SQLExpr value = visitExpr(ctx.value);
        return new SQLAssignmentExpr(column, value);
    }

    @Override
    public SQLReservedIdentifier visitEditionableClause(EditionableClauseContext ctx) {
        return SQLReserved.EDITIONABLE.ofExpr();
    }

    @Override
    public SQLReservedIdentifier visitNonEditionableClause(NonEditionableClauseContext ctx) {
        return SQLReserved.NONEDITIONABLE.ofExpr();
    }

    @Override
    public SQLReservedIdentifier visitEnableClause(EnableClauseContext ctx) {
        return SQLReserved.ENABLE.ofExpr();
    }

    @Override
    public SQLReservedIdentifier visitDisableClause(DisableClauseContext ctx) {
        return SQLReserved.DISABLE.ofExpr();
    }

    @Override
    public SQLRenameToClause visitRenameToClause(RenameToClauseContext ctx) {
        SQLRenameToClause x = new SQLRenameToClause();
        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setNewName(name);
        return x;
    }

    @Override
    public SQLExceptionClause visitExceptionClause(ExceptionClauseContext ctx) {
        SQLExceptionClause x = new SQLExceptionClause();
        for (ExceptionHandlerContext exceptionHandlerContext : ctx.exceptionHandler()) {
            OracleSQLExceptionHandler exceptionHandler = visitExceptionHandler(exceptionHandlerContext);
            x.addexceptionHandler(exceptionHandler);
        }
        return x;
    }

    @Override
    public SQLUsingClause visitUsingClause(UsingClauseContext ctx) {
        SQLUsingClause x = new SQLUsingClause();
        for (UsingArgumentClauseContext usingArgumentClauseContext : ctx.usingArgumentClause()) {
            SQLUsingClause.SQLUsingArgumentClause argument = visitUsingArgumentClause(usingArgumentClauseContext);
            x.addArgument(argument);
        }
        return x;
    }

    @Override
    public SQLUsingClause.SQLUsingArgumentClause visitUsingArgumentClause(UsingArgumentClauseContext ctx) {
        SQLUsingClause.SQLUsingArgumentClause x = new SQLUsingClause.SQLUsingArgumentClause();

        if (ctx.parameterModel() != null) {
            SQLParameterModel parameterModel = of(ctx.parameterModel());
            x.setModel(parameterModel);
        }

        SQLExpr expr = visitExpr(ctx.expr());
        x.setExpr(expr);
        return x;
    }

    @Override
    public SQLAttributeDefinition visitAttributeDefinition(AttributeDefinitionContext ctx) {
        SQLAttributeDefinition x = new SQLAttributeDefinition();
        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);

        SQLDataType dataType = visitDataType(ctx.dataType());
        x.setDataType(dataType);

        if (ctx.externalName != null) {
            SQLExpr externalName = visitExpr(ctx.externalName);
            x.setExternalName(externalName);
        }
        return x;
    }

    @Override
    public SQLReservedIdentifier visitFinalClause(FinalClauseContext ctx) {
        return SQLReserved.FINAL.ofExpr();
    }

    @Override
    public SQLReservedIdentifier visitNotFinalClause(NotFinalClauseContext ctx) {
        return SQLReserved.NOT_FINAL.ofExpr();
    }

    @Override
    public SQLReservedIdentifier visitInstantiableClause(InstantiableClauseContext ctx) {
        return SQLReserved.INSTANTIABLE.ofExpr();
    }

    @Override
    public SQLReservedIdentifier visitNotInstantiableClause(NotInstantiableClauseContext ctx) {
        return SQLReserved.NOT_INSTANTIABLE.ofExpr();
    }

    @Override
    public SQLReservedIdentifier visitPersistableClause(PersistableClauseContext ctx) {
        return SQLReserved.PERSISTABLE.ofExpr();
    }

    @Override
    public SQLReservedIdentifier visitNotPersistableClause(NotPersistableClauseContext ctx) {
        return SQLReserved.NOT_PERSISTABLE.ofExpr();
    }

    @Override
    public SQLReservedIdentifier visitSecureFileClause(SecureFileClauseContext ctx) {
        return SQLReserved.SECUREFILE.ofExpr();
    }

    @Override
    public SQLReservedIdentifier visitBasicFileClause(BasicFileClauseContext ctx) {
        return SQLReserved.BASICFILE.ofExpr();
    }

    @Override
    public SQLReservedIdentifier visitResetClause(ResetClauseContext ctx) {
        return SQLReserved.RESET.ofExpr();
    }

    @Override
    public OracleSQLIsOpenImplicitCursorExpr visitIsOpenImplicitCursorExpr(IsOpenImplicitCursorExprContext ctx) {
        return new OracleSQLIsOpenImplicitCursorExpr();
    }

    @Override
    public OracleSQLFoundImplicitCursorExpr visitFoundImplicitCursorExpr(FoundImplicitCursorExprContext ctx) {
        return new OracleSQLFoundImplicitCursorExpr();
    }

    @Override
    public OracleSQLNotFoundImplicitCursorExpr visitNotFoundImplicitCursorExpr(NotFoundImplicitCursorExprContext ctx) {
        return new OracleSQLNotFoundImplicitCursorExpr();
    }

    @Override
    public OracleSQLRowcountImplicitCursorExpr visitRowcountImplicitCursorExpr(RowcountImplicitCursorExprContext ctx) {
        return new OracleSQLRowcountImplicitCursorExpr();
    }

    @Override
    public OracleSQLBulkRowcountImplicitCursorExpr visitBulkRowcountImplicitCursorExpr(BulkRowcountImplicitCursorExprContext ctx) {
        OracleSQLBulkRowcountImplicitCursorExpr x = new OracleSQLBulkRowcountImplicitCursorExpr();
        SQLExpr index = visitExpr(ctx.expr());
        x.setIndex(index);
        return x;
    }

    @Override
    public OracleSQLBulkExceptionsCountImplicitCursorExpr visitBulkExceptionsCountImplicitCursorExpr(BulkExceptionsCountImplicitCursorExprContext ctx) {
        return new OracleSQLBulkExceptionsCountImplicitCursorExpr();
    }

    @Override
    public OracleSQLBulkExceptionImplicitCursorExpr visitBulkExceptionImplicitCursorExpr(BulkExceptionImplicitCursorExprContext ctx) {
        OracleSQLBulkExceptionImplicitCursorExpr x = new OracleSQLBulkExceptionImplicitCursorExpr();
        SQLExpr index = visitExpr(ctx.expr());
        x.setIndex(index);
        return x;
    }

    @Override
    public OracleSQLIsOpenNameCursorExpr visitIsOpenNameCursorExpr(IsOpenNameCursorExprContext ctx) {
        OracleSQLIsOpenNameCursorExpr x = new OracleSQLIsOpenNameCursorExpr();
        SQLExpr name = (SQLExpr) visitChildren(ctx.namedCursorName());
        x.setName(name);
        return x;
    }

    @Override
    public OracleSQLFoundNameCursorExpr visitFoundNameCursorExpr(FoundNameCursorExprContext ctx) {
        OracleSQLFoundNameCursorExpr x = new OracleSQLFoundNameCursorExpr();
        SQLExpr name = (SQLExpr) visitChildren(ctx.namedCursorName());
        x.setName(name);
        return x;
    }

    @Override
    public OracleSQLNotFoundNameCursorExpr visitNotFoundNameCursorExpr(NotFoundNameCursorExprContext ctx) {
        OracleSQLNotFoundNameCursorExpr x = new OracleSQLNotFoundNameCursorExpr();
        SQLExpr name = (SQLExpr) visitChildren(ctx.namedCursorName());
        x.setName(name);
        return x;
    }

    @Override
    public OracleSQLRowcountNameCursorExpr visitRowcountNameCursorExpr(RowcountNameCursorExprContext ctx) {
        OracleSQLRowcountNameCursorExpr x = new OracleSQLRowcountNameCursorExpr();
        SQLExpr name = (SQLExpr) visitChildren(ctx.namedCursorName());
        x.setName(name);
        return x;
    }

    // --------------------------------------- expr End ----------------------------------------------------------------


    // --------------------------------------- condition Start ----------------------------------------------------------------

    // --------------------------------------- condition End ----------------------------------------------------------------


    // --------------------------------------- function Start ----------------------------------------------------------------
    @Override
    public SQLMethodInvocation visitMethodInvocation1(MethodInvocation1Context ctx) {
        String name = ctx.noArgumentFunctionName().getText();

        SQLMethodInvocation x = new SQLMethodInvocation(name);

        boolean paren = ctx.LEFT_PAREN() != null;
        x.setParen(paren);

        SQLSetQuantifier setQuantifier = of(ctx.setQuantifier());
        x.setSetQuantifier(setQuantifier);

        for (ExprContext argumentContext : ctx.arguments) {
            SQLExpr argument = visitExpr(argumentContext);
            x.addArgument(argument);
        }
        return x;
    }

    @Override
    public SQLMethodInvocation visitMethodInvocation2(MethodInvocation2Context ctx) {
        SQLExpr name = visitExpr(ctx.name);

        SQLMethodInvocation x = new SQLMethodInvocation(name);

        SQLSetQuantifier setQuantifier = of(ctx.setQuantifier());
        x.setSetQuantifier(setQuantifier);

        for (ExprContext argumentContext : ctx.arguments) {
            SQLExpr argument = visitExpr(argumentContext);
            x.addArgument(argument);
        }
        return x;
    }

    @Override
    public SQLChrFunction visitChrFunction(ChrFunctionContext ctx) {
        SQLChrFunction x = new SQLChrFunction();

        SQLExpr expr = visitExpr(ctx.expr());
        x.addArgument(expr);

        boolean usingNCharCS = ctx.usingNCharCS() != null;
        if (usingNCharCS) {
            x.setUsingType(SQLReserved.NCHAR_CS);
        }

        return x;
    }

    @Override
    public SQLTranslateUsingFunction visitTranslateUsingFunction(TranslateUsingFunctionContext ctx) {

        SQLTranslateUsingFunction x = new SQLTranslateUsingFunction();

        SQLExpr expr = visitExpr(ctx.expr());
        SQLReserved usingType = null;
        if (ctx.CHAR_CS() != null) {
            usingType = SQLReserved.CHAR_CS;
        } else if (ctx.NCHAR_CS() != null) {
            usingType = SQLReserved.NCHAR_CS;
        }

        x.addArgument(expr);
        x.setUsingType(usingType);

        return x;
    }

    @Override
    public SQLTrimFunction visitTrimFunction(TrimFunctionContext ctx) {
        SQLTrimFunction x = new SQLTrimFunction();

        SQLTrimFunction.SQLTrimSpecification specification = null;
        if (ctx.LEADING() != null) {
            specification = SQLTrimFunction.SQLTrimSpecification.LEADING;
        } else if (ctx.TRAILING() != null) {
            specification = SQLTrimFunction.SQLTrimSpecification.TRAILING;
        } else if (ctx.BOTH() != null) {
            specification = SQLTrimFunction.SQLTrimSpecification.BOTH;
        }
        SQLExpr character = visitExpr(ctx.character);

        x.setSpecification(specification);
        x.setCharacter(character);

        SQLExpr source = visitExpr(ctx.source);
        x.addArgument(source);

        return x;
    }


    @Override
    public SQLExtractFunction visitExtractFunction(ExtractFunctionContext ctx) {
        String unitText = ctx.unit.getText();
        SQLExtractFunction.SQLUnit unit = SQLExtractFunction.SQLUnit.of(unitText);

        SQLExpr expr = visitExpr(ctx.expr());

        return new SQLExtractFunction(unit, expr);
    }

    @Override
    public SQLCastFunction visitCastFunction(CastFunctionContext ctx) {
        SQLCastFunction x = new SQLCastFunction();
        SQLExpr argument = visitCastFunctionArgument(ctx.castFunctionArgument());
        x.addArgument(argument);

        for (ExprContext exprContext : ctx.expr()) {
            argument = visitExpr(exprContext);
            x.addArgument(argument);
        }

        SQLDataType dataType = visitDataType(ctx.dataType());
        x.setDataType(dataType);

        if (ctx.defaultOnConversionErrorExpr() != null) {
            AbstractSQLFunction.SQLDefaultOnConversionError defaultOnConversionError = visitDefaultOnConversionErrorExpr(ctx.defaultOnConversionErrorExpr());
            x.setDefaultOnConversionError(defaultOnConversionError);
        }

        return x;
    }

    @Override
    public SQLExpr visitCastFunctionArgument(CastFunctionArgumentContext ctx) {
        return (SQLExpr) super.visitCastFunctionArgument(ctx);
    }

    @Override
    public SQLMultisetExpr visitMultisetExpr(MultisetExprContext ctx) {
        ISQLSelectQuery subQuery = visitISelectQuery(ctx.iSelectQuery());
        return new SQLMultisetExpr(subQuery);
    }

    @Override
    public SQLTreatFunction visitTreatFunction(TreatFunctionContext ctx) {
        SQLExpr expr = visitExpr(ctx.expr());
        boolean ref = ctx.REF() != null;
        SQLDataType dataType = visitDataType(ctx.dataType());

        return new SQLTreatFunction(expr, ref, dataType);
    }

    @Override
    public SQLValidateConversionFunction visitValidateConversionFunction(ValidateConversionFunctionContext ctx) {
        return new SQLValidateConversionFunction();
    }

    @Override
    public SQLDataMiningFunction visitDataMiningFunction(DataMiningFunctionContext ctx) {
        String name = ctx.dataMiningFunctionName().getText();
        SQLDataMiningFunction x = new SQLDataMiningFunction(name);


        if (ctx.dataMiningFunctionArgument() != null) {
            SQLExpr argument = visitDataMiningFunctionArgument(ctx.dataMiningFunctionArgument());
            x.addArgument(argument);
        }

        for (ExprContext exprContext : ctx.expr()) {
            SQLExpr argument = visitExpr(exprContext);
            x.addArgument(argument);
        }

        SQLReserved orderedByWeight = null;
        if (ctx.DESC() != null) {
            orderedByWeight = SQLReserved.DESC;
        } else if (ctx.ASC() != null) {
            orderedByWeight = SQLReserved.ASC;
        } else if (ctx.ABS() != null) {
            orderedByWeight = SQLReserved.ABS;
        }
        x.setOrderedByWeight(orderedByWeight);

        if (ctx.costMatrixClause() != null) {
            SQLExpr costMatrixClause = visitCostMatrixClause(ctx.costMatrixClause());
            x.setCostMatrixClause(costMatrixClause);
        }

        if (ctx.minAtrr1 != null) {
            AbstractSQLDataMiningFunction.SQLMiningAttributeClause minAtrr = visitMiningAttributeClause(ctx.minAtrr1);
            x.setMiningAttributeClause(minAtrr);
        }

        if (ctx.andMinAttr != null) {
            AbstractSQLDataMiningFunction.SQLMiningAttributeClause andMinAttr = visitMiningAttributeClause(ctx.andMinAttr);
            x.setAndMiningAttributeClause(andMinAttr);
        }


        if (ctx.overClause() != null) {
            SQLOverClause overClause = visitOverClause(ctx.overClause());
            x.setOverClause(overClause);
        }

        return x;
    }

    @Override
    public SQLExpr visitDataMiningFunctionArgument(DataMiningFunctionArgumentContext ctx) {
        SQLExpr x;

        SQLExpr expr = null;
        if (ctx.expr() != null) {
            expr = visitExpr(ctx.expr());
        }

        if (ctx.INTO() != null) {
            x = new AbstractSQLDataMiningFunction.SQLIntoArgumentExpr(expr);

        } else if (ctx.FOR() != null) {
            x = new AbstractSQLDataMiningFunction.SQLForArgumentExpr(expr);

        } else if (ctx.OF() != null) {
            x = SQLReserved.OF_ANOMALY.ofExpr();
        } else {
            x = expr;
        }
        return x;
    }

    @Override
    public SQLExpr visitCostMatrixClause(CostMatrixClauseContext ctx) {
        SQLExpr x;

        if (ctx.MODEL() != null) {
            x = SQLReserved.COST_MODEL.ofExpr();
            if (ctx.AUTO() != null) {
                x = SQLReserved.COST_MODEL_AUTO.ofExpr();
            }
        } else {

            AbstractSQLDataMiningFunction.SQLCostMatrixClause costMatrixClause = new AbstractSQLDataMiningFunction.SQLCostMatrixClause();
            for (ExprContext classValueContext : ctx.classValues) {
                SQLExpr classValue = visitExpr(classValueContext);
                costMatrixClause.addClassValue(classValue);
            }
            for (ExprContext costValueContext : ctx.costValues) {
                SQLExpr costValue = visitExpr(costValueContext);
                costMatrixClause.addCostValue(costValue);
            }

            x = costMatrixClause;
        }


        return x;
    }

    @Override
    public AbstractSQLDataMiningFunction.SQLMiningAttributeClause visitMiningAttributeClause(MiningAttributeClauseContext ctx) {
        AbstractSQLDataMiningFunction.SQLMiningAttributeClause x = new AbstractSQLDataMiningFunction.SQLMiningAttributeClause();
        for (ExprOrExprAsAliasArgumentContext exprOrExprAsAliasArgumentContext : ctx.exprOrExprAsAliasArgument()) {
            SQLExpr argument = (SQLExpr) visitChildren(exprOrExprAsAliasArgumentContext);
            x.addItem(argument);
        }
        return x;
    }

    @Override
    public SQLXmlCastFunction visitXmlCastFunction(XmlCastFunctionContext ctx) {
        SQLExprAsObjectExpr exprAsObjectExpr = visitExprAsObjectExpr(ctx.exprAsObjectExpr());
        return new SQLXmlCastFunction(exprAsObjectExpr);
    }

    @Override
    public SQLXmlColAttValFunction visitXmlColAttValFunction(XmlColAttValFunctionContext ctx) {
        SQLXmlColAttValFunction x = new SQLXmlColAttValFunction();
        for (XmlColAttValFunctionArgumentContext xmlColAttValFunctionArgumentContext : ctx.xmlColAttValFunctionArgument()) {
            SQLExpr argument = (SQLExpr) visitChildren(xmlColAttValFunctionArgumentContext);
            x.addArgument(argument);
        }
        return x;
    }

    @Override
    public SQLXmlElementFunction visitXmlElementFunction(XmlElementFunctionContext ctx) {
        SQLXmlElementFunction x = new SQLXmlElementFunction();

        SQLReserved entityEscaping = null;
        if (ctx.ENTITYESCAPING() != null) {
            entityEscaping = SQLReserved.ENTITYESCAPING;
        } else if (ctx.NOENTITYESCAPING() != null) {
            entityEscaping = SQLReserved.NOENTITYESCAPING;
        }
        x.setEntityEscaping(entityEscaping);


        SQLReserved evalName = null;
        if (ctx.NAME() != null) {
            evalName = SQLReserved.NAME;
        } else if (ctx.EVALNAME() != null) {
            evalName = SQLReserved.EVALNAME;
        }
        x.setEvalName(evalName);

        SQLExpr argument0 = visitExpr(ctx.expr());
        x.addArgument(argument0);

        if (ctx.xmlAttributesClause() != null) {
            SQLExpr xmlAttributesClause = visitXmlAttributesClause(ctx.xmlAttributesClause());
            x.addArgument(xmlAttributesClause);
        }

        for (ExprOrExprAsAliasArgumentContext exprOrExprAsAliasArgumentContext : ctx.exprOrExprAsAliasArgument()) {
            SQLExpr argument = (SQLExpr) visitChildren(exprOrExprAsAliasArgumentContext);
            x.addArgument(argument);
        }
        return x;
    }

    @Override
    public SQLXmlExistsFunction visitXmlExistsFunction(XmlExistsFunctionContext ctx) {
        SQLXmlExistsFunction x = new SQLXmlExistsFunction();

        SQLExpr expr = visitExpr(ctx.expr());
        x.addArgument(expr);

        if (ctx.xmlPassingClause() != null) {
            SQLXmlPassingClause passingClause = visitXmlPassingClause(ctx.xmlPassingClause());
            x.setPassingClause(passingClause);
        }

        return x;
    }

    @Override
    public SQLXmlForestFunction visitXmlForestFunction(XmlForestFunctionContext ctx) {
        SQLXmlForestFunction x = new SQLXmlForestFunction();

        for (XmlColAttValFunctionArgumentContext xmlColAttValFunctionArgumentContext : ctx.xmlColAttValFunctionArgument()) {
            SQLExpr argument = (SQLExpr) visitChildren(xmlColAttValFunctionArgumentContext);
            x.addArgument(argument);
        }

        return x;
    }

    @Override
    public SQLXmlParseFunction visitXmlParseFunction(XmlParseFunctionContext ctx) {
        SQLXmlParseFunction x = new SQLXmlParseFunction();
        SQLReserved content = null;
        if (ctx.DOCUMENT() != null) {
            content = SQLReserved.DOCUMENT;
        } else if (ctx.CONTENT() != null) {
            content = SQLReserved.CONTENT;
        }
        x.setContent(content);

        SQLExpr expr = visitExpr(ctx.expr());
        x.addArgument(expr);

        if (ctx.WELLFORMED() != null) {
            x.setWellFormed(true);
        }

        return x;
    }

    @Override
    public SQLXmlPiFunction visitXmlPiFunction(XmlPiFunctionContext ctx) {
        SQLXmlPiFunction x = new SQLXmlPiFunction();

        SQLReserved evalName = null;
        if (ctx.NAME() != null) {
            evalName = SQLReserved.NAME;
        } else if (ctx.EVALNAME() != null) {
            evalName = SQLReserved.EVALNAME;
        }
        x.setEvalName(evalName);

        for (ExprContext exprContext : ctx.expr()) {
            SQLExpr argument = visitExpr(exprContext);
            x.addArgument(argument);
        }

        return x;
    }

    @Override
    public SQLXmlQueryFunction visitXmlQueryFunction(XmlQueryFunctionContext ctx) {
        SQLXmlQueryFunction x = new SQLXmlQueryFunction();

        SQLExpr expr = visitExpr(ctx.expr());
        x.addArgument(expr);

        if (ctx.xmlPassingClause() != null) {
            SQLXmlPassingClause passingClause = visitXmlPassingClause(ctx.xmlPassingClause());
            x.setPassingClause(passingClause);
        }

        if (ctx.NULL() != null
                && ctx.ON() != null
                && ctx.EMPTY() != null) {
            x.setNullOnEmpty(true);
        }
        return x;
    }

    @Override
    public SQLXmlRootFunction visitXmlRootFunction(XmlRootFunctionContext ctx) {
        SQLXmlRootFunction x = new SQLXmlRootFunction();

        SQLExpr expr = visitExpr(ctx.expr());
        x.addArgument(expr);

        SQLXmlRootFunction.SQLVersionArgument versionArgument = visitXmlRootFunctionVersionExpr(ctx.xmlRootFunctionVersionExpr());
        x.addArgument(versionArgument);

        if (ctx.STANDALONE() != null) {
            SQLReservedIdentifier standalone = null;
            if (ctx.YES() != null) {
                standalone = SQLReserved.STANDALONE_YES.ofExpr();
            } else if (ctx.NO() != null) {
                standalone = SQLReserved.STANDALONE_NO.ofExpr();
                if (ctx.VALUE() != null) {
                    standalone = SQLReserved.STANDALONE_NO_VALUE.ofExpr();
                }
            }
            x.addArgument(standalone);
        }

        return x;
    }

    @Override
    public SQLXmlSerializeFunction visitXmlSerializeFunction(XmlSerializeFunctionContext ctx) {
        SQLXmlSerializeFunction x = new SQLXmlSerializeFunction();

        SQLReserved content = null;
        if (ctx.DOCUMENT() != null) {
            content = SQLReserved.DOCUMENT;
        } else if (ctx.CONTENT() != null) {
            content = SQLReserved.CONTENT;
        }
        x.setContent(content);

        SQLExpr value = visitExpr(ctx.value);
        if (ctx.dataType() != null) {
            boolean as = ctx.AS() != null;
            SQLDataType dataType = visitDataType(ctx.dataType());
            SQLExprAsObjectExpr exprAsObjectExpr = new SQLExprAsObjectExpr(value, as, dataType);

            x.addArgument(exprAsObjectExpr);
        } else {
            x.addArgument(value);
        }

        if (ctx.encoding != null) {
            SQLExpr encoding = visitExpr(ctx.encoding);
            x.setEncoding(encoding);
        }
        if (ctx.version != null) {
            SQLExpr version = visitExpr(ctx.version);
            x.setVersion(version);
        }


        if (ctx.INDENT() != null) {
            SQLReserved indent;
            if (ctx.NO() != null) {
                indent = SQLReserved.NO_INDENT;

            } else {
                indent = SQLReserved.INDENT;
            }
            x.setIndent(indent);

            if (ctx.size != null) {
                SQLExpr size = visitExpr(ctx.size);
                x.setSize(size);
            }
        }

        if (ctx.DEFAULTS() != null) {
            SQLReserved defaults = SQLReserved.HIDE;
            if (ctx.SHOW() != null) {
                defaults = SQLReserved.SHOW;
            }
            x.setDefaults(defaults);
        }

        return x;
    }

    @Override
    public SQLXmlTableFunction visitXmlTableFunction(XmlTableFunctionContext ctx) {
        SQLXmlTableFunction x = new SQLXmlTableFunction();

        if (ctx.xmlNamespacesClause() != null) {
            SQLXmlTableFunction.SQLXmlNamespacesClause namespacesClause = visitXmlNamespacesClause(ctx.xmlNamespacesClause());
            x.addArgument(namespacesClause);
        }

        SQLExpr expr = visitExpr(ctx.expr());
        x.addArgument(expr);

        SQLXmlTableFunction.SQLXmlTableOption option = visitXmlTableOption(ctx.xmlTableOption());
        x.setOption(option);

        return x;
    }


    @Override
    public SQLXmlRootFunction.SQLVersionArgument visitXmlRootFunctionVersionExpr(XmlRootFunctionVersionExprContext ctx) {
        SQLExpr expr;
        if (ctx.expr() != null) {
            expr = visitExpr(ctx.expr());
        } else {
            expr = SQLReserved.NO_VALUE.ofExpr();
        }
        return new SQLXmlRootFunction.SQLVersionArgument(expr);
    }

    @Override
    public SQLXmlEvalNameExprArgument visitXmlFunctionEvalNameArgument(XmlFunctionEvalNameArgumentContext ctx) {
        SQLExpr value = visitExpr(ctx.value);
        SQLExpr alias = visitExpr(ctx.alias);
        return new SQLXmlEvalNameExprArgument(value, alias);
    }

    @Override
    public SQLXmlElementFunction.SQLXmlAttributesClause visitXmlAttributesClause(XmlAttributesClauseContext ctx) {
        SQLXmlElementFunction.SQLXmlAttributesClause x = new SQLXmlElementFunction.SQLXmlAttributesClause();

        SQLReserved entityEscaping = null;
        if (ctx.ENTITYESCAPING() != null) {
            entityEscaping = SQLReserved.ENTITYESCAPING;
        } else if (ctx.NOENTITYESCAPING() != null) {
            entityEscaping = SQLReserved.NOENTITYESCAPING;
        }
        x.setEntityEscaping(entityEscaping);


        SQLReserved schemaCheck = null;
        if (ctx.SCHEMACHECK() != null) {
            schemaCheck = SQLReserved.SCHEMACHECK;
        } else if (ctx.NOSCHEMACHECK() != null) {
            schemaCheck = SQLReserved.NOSCHEMACHECK;
        }
        x.setSchemaCheck(schemaCheck);

        for (XmlColAttValFunctionArgumentContext xmlColAttValFunctionArgumentContext : ctx.xmlColAttValFunctionArgument()) {
            SQLExpr item = (SQLExpr) visitChildren(xmlColAttValFunctionArgumentContext);
            x.addItem(item);
        }

        return x;
    }


    @Override
    public SQLXmlTableFunction.SQLXmlNamespacesClause visitXmlNamespacesClause(XmlNamespacesClauseContext ctx) {
        SQLXmlTableFunction.SQLXmlNamespacesClause x = new SQLXmlTableFunction.SQLXmlNamespacesClause();

        for (XmlNamespacesClauseArgumentContext xmlNamespacesClauseArgumentContext : ctx.xmlNamespacesClauseArgument()) {
            SQLExpr item = (SQLExpr) visitChildren(xmlNamespacesClauseArgumentContext);
            x.addItem(item);
        }
        return x;
    }

    @Override
    public SQLXmlTableFunction.SQLXmlTableOption visitXmlTableOption(XmlTableOptionContext ctx) {

        if (ctx.xmlPassingClause() == null
                && ctx.returningSequenceByRef() == null
                && (ctx.xmlTableColumn() == null || ctx.xmlTableColumn().size() == 1)) {
            return null;
        }

        SQLXmlTableFunction.SQLXmlTableOption x = new SQLXmlTableFunction.SQLXmlTableOption();

        if (ctx.xmlPassingClause() != null) {
            SQLXmlPassingClause passingClause = visitXmlPassingClause(ctx.xmlPassingClause());
            x.setPassingClause(passingClause);
        }

        if (ctx.returningSequenceByRef() != null) {
            x.setReturningSequenceByRef(true);
        }

        for (XmlTableColumnContext xmlTableColumnContext : ctx.xmlTableColumn()) {
            SQLXmlTableFunction.SQLXmlTableColumn tableColumn = visitXmlTableColumn(xmlTableColumnContext);
            x.addColumn(tableColumn);
        }

        return x;
    }

    @Override
    public SQLXmlPassingClause visitXmlPassingClause(XmlPassingClauseContext ctx) {
        SQLXmlPassingClause x = new SQLXmlPassingClause();

        if (ctx.byValue() != null) {
            x.setByValue(true);
        }

        for (ExprOrExprAsAliasArgumentContext exprOrExprAsAliasArgumentContext : ctx.exprOrExprAsAliasArgument()) {
            SQLExpr item = (SQLExpr) visitChildren(exprOrExprAsAliasArgumentContext);
            x.addItem(item);
        }

        return x;
    }

    @Override
    public SQLXmlTableFunction.SQLXmlTableColumn visitXmlTableColumn(XmlTableColumnContext ctx) {
        SQLXmlTableFunction.SQLXmlTableColumn x = null;

        SQLName column = visitNameIdentifier(ctx.nameIdentifier());

        if (ctx.FOR() != null
                && ctx.ORDINALITY() != null) {
            x = new SQLXmlTableFunction.SQLXmlTableColumnByForOrdinality(column);

        } else if (ctx.dataType() != null) {
            SQLXmlTableFunction.SQLXmlTableColumnByDataType columnByDataType = new SQLXmlTableFunction.SQLXmlTableColumnByDataType(column);

            SQLDataType dataType = visitDataType(ctx.dataType());
            columnByDataType.setDataType(dataType);

            if (ctx.sequenceByRef() != null) {
                columnByDataType.setSequenceByRef(true);
            }

            if (ctx.path != null) {
                SQLExpr path = visitExpr(ctx.path);
                columnByDataType.setPath(path);
            }

            if (ctx.default_ != null) {
                SQLExpr default_ = visitExpr(ctx.default_);
                columnByDataType.setDefault_(default_);
            }
            x = columnByDataType;
        }


        return x;
    }

    @Override
    public SQLJsonFunction visitJsonFunction(JsonFunctionContext ctx) {
        SQLJsonFunction x = new SQLJsonFunction(ctx.jsonFunctionName().getText());

        for (JsonFunctionArgumentContext jsonFunctionArgumentContext : ctx.jsonFunctionArgument()) {
            SQLExpr argument = (SQLExpr) visitChildren(jsonFunctionArgumentContext);
            x.addArgument(argument);
        }

        if (ctx.orderByClause() != null) {
            SQLOrderByClause orderByClause = visitOrderByClause(ctx.orderByClause());
            x.setOrderByClause(orderByClause);
        }

        if (ctx.jsonOnNullClause() != null) {
            SQLReserved onNullClause = SQLReserved.NULL_ON_NULL;
            if (ctx.jsonOnNullClause().ABSENT() != null) {
                onNullClause = SQLReserved.ABSENT_ON_NULL;
            }
            x.setOnNullClause(onNullClause);
        }

        if (ctx.jsonReturningClause() != null) {
            AbstractSQLJsonFunction.SQLJsonReturningClause returningClause = visitJsonReturningClause(ctx.jsonReturningClause());
            x.setReturningClause(returningClause);
        }

        if (ctx.STRICT() != null) {
            x.setStrict(true);
        }
        if (ctx.withUniqueKeys() != null) {
            x.setWithUniqueKeys(true);
        }

        if (ctx.jsonWrapperClause() != null) {
            SQLReserved wrapperClause = of(ctx.jsonWrapperClause());
            x.setWrapperClause(wrapperClause);
        }

        if (ctx.jsonOnErrorClause() != null) {
            SQLExpr onErrorClause = visitJsonOnErrorClause(ctx.jsonOnErrorClause());
            x.setOnErrorClause(onErrorClause);
        }

        if (ctx.jsonOnEmptyClause() != null) {
            SQLExpr onEmptyClause = visitJsonOnEmptyClause(ctx.jsonOnEmptyClause());
            x.setOnEmptyClause(onEmptyClause);
        }

        if (ctx.jsonColumnsClause() != null) {
            AbstractSQLJsonFunction.SQLJsonColumnsClause jsonColumnsClause = visitJsonColumnsClause(ctx.jsonColumnsClause());
            x.setJsonColumnsClause(jsonColumnsClause);
        }

        return x;
    }

    @Override
    public AbstractSQLJsonFunction.SQLFormatJsonArgumentExpr visitJsonFormatJsonArgumentExpr(JsonFormatJsonArgumentExprContext ctx) {
        if (ctx == null) {
            return null;
        }
        AbstractSQLJsonFunction.SQLFormatJsonArgumentExpr x = new AbstractSQLJsonFunction.SQLFormatJsonArgumentExpr();

        SQLExpr expr = visitExpr(ctx.expr());
        x.setExpr(expr);

        return x;
    }

    @Override
    public AbstractSQLJsonFunction.SQLKeyValueArgumentExpr visitJsonKeyValueArgumentExpr(JsonKeyValueArgumentExprContext ctx) {
        AbstractSQLJsonFunction.SQLKeyValueArgumentExpr x = new AbstractSQLJsonFunction.SQLKeyValueArgumentExpr();

        if (ctx.KEY() != null) {
            x.setKey(true);
        }

        SQLExpr keyExpr = visitExpr(ctx.key);
        SQLExpr valueExpr = visitExpr(ctx.val);

        x.setKeyExpr(keyExpr);
        x.setValueExpr(valueExpr);
        return x;
    }

    @Override
    public AbstractSQLJsonFunction.SQLJsonReturningClause visitJsonReturningClause(JsonReturningClauseContext ctx) {
        if (ctx.dataType() == null
                && ctx.PRETTY() == null
                && ctx.ASCII() == null) {
            return null;
        }

        AbstractSQLJsonFunction.SQLJsonReturningClause x = new AbstractSQLJsonFunction.SQLJsonReturningClause();

        if (ctx.dataType() != null) {
            SQLDataType returnType = visitDataType(ctx.dataType());
            x.setReturnType(returnType);
        }

        if (ctx.PRETTY() != null) {
            x.setPretty(true);
        }

        if (ctx.ASCII() != null) {
            x.setAscii(true);
        }

        return x;
    }


    public SQLReserved of(JsonWrapperClauseContext ctx) {
        SQLReserved x;
        if (ctx.WITH() != null) {
            x = SQLReserved.WITH_WRAPPER;
            if (ctx.ARRAY() == null) {
                if (ctx.UNCONDITIONAL() != null) {
                    x = SQLReserved.WITH_UNCONDITIONAL_WRAPPER;
                } else if (ctx.CONDITIONAL() != null) {
                    x = SQLReserved.WITH_CONDITIONAL_WRAPPER;
                }
            } else {
                if (ctx.UNCONDITIONAL() != null) {
                    x = SQLReserved.WITH_UNCONDITIONAL_ARRAY_WRAPPER;
                } else if (ctx.CONDITIONAL() != null) {
                    x = SQLReserved.WITH_CONDITIONAL_ARRAY_WRAPPER;
                }
            }
        } else {
            x = SQLReserved.WITHOUT_WRAPPER;
            if (ctx.ARRAY() != null) {
                x = SQLReserved.WITH_ARRAY_WRAPPER;
            }
        }
        return x;
    }

    @Override
    public SQLExpr visitJsonOnErrorClause(JsonOnErrorClauseContext ctx) {
        SQLExpr x = null;
        if (ctx.NULL() != null) {
            x = SQLReserved.NULL_ON_ERROR.ofExpr();
        } else if (ctx.EMPTY() != null) {
            x = SQLReserved.EMPTY_ON_ERROR.ofExpr();
            if (ctx.ARRAY() != null) {
                x = SQLReserved.EMPTY_ARRAY_ON_ERROR.ofExpr();
            } else if (ctx.OBJECT() != null) {
                x = SQLReserved.EMPTY_OBJECT_ON_ERROR.ofExpr();
            }
        } else if (ctx.DEFAULT() != null) {
            SQLExpr expr = visitExpr(ctx.expr());
            x = new AbstractSQLJsonFunction.SQLDefaultOnErrorExpr(expr);
        } else {
            x = SQLReserved.ERROR_ON_ERROR.ofExpr();
        }

        return x;
    }

    @Override
    public SQLExpr visitJsonOnEmptyClause(JsonOnEmptyClauseContext ctx) {
        SQLExpr x = null;
        if (ctx.ERROR() != null) {
            x = SQLReserved.ERROR_ON_EMPTY.ofExpr();

        } else if (ctx.NULL() != null) {
            x = SQLReserved.NULL_ON_EMPTY.ofExpr();

        } else if (ctx.DEFAULT() != null) {
            SQLExpr expr = visitExpr(ctx.expr());
            x = new AbstractSQLJsonFunction.SQLDefaultOnErrorExpr(expr);

        } else {
            x = SQLReserved.EMPTY_ON_ERROR.ofExpr();
            if (ctx.ARRAY() != null) {
                x = SQLReserved.EMPTY_ARRAY_ON_ERROR.ofExpr();
            } else if (ctx.OBJECT() != null) {
                x = SQLReserved.EMPTY_OBJECT_ON_ERROR.ofExpr();
            }
        }

        return x;
    }

    @Override
    public AbstractSQLJsonFunction.SQLJsonColumnsClause visitJsonColumnsClause(JsonColumnsClauseContext ctx) {
        AbstractSQLJsonFunction.SQLJsonColumnsClause x = new AbstractSQLJsonFunction.SQLJsonColumnsClause();
        for (JsonColumnDefinitionContext jsonColumnDefinitionContext : ctx.jsonColumnDefinition()) {
            SQLExpr column = (SQLExpr) visit(jsonColumnDefinitionContext);
            x.addColumn(column);
        }
        return x;
    }

    @Override
    public AbstractSQLJsonFunction.SQLJsonExistsColumn visitJsonExistsColumn(JsonExistsColumnContext ctx) {

        AbstractSQLJsonFunction.SQLJsonExistsColumn x = new AbstractSQLJsonFunction.SQLJsonExistsColumn();

        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setColumn(name);

        SQLDataType returnType = visitDataType(ctx.dataType());
        x.setDataType(returnType);

        if (ctx.path != null) {
            SQLExpr pathExpr = visitExpr(ctx.path);
            x.setPathExpr(pathExpr);
        }

        if (ctx.jsonOnErrorClause() != null) {
            SQLExpr onErrorClause = visitJsonOnErrorClause(ctx.jsonOnErrorClause());
            x.setOnErrorClause(onErrorClause);
        }

        return x;
    }

    @Override
    public AbstractSQLJsonFunction.SQLJsonQueryColumn visitJsonQueryColumn(JsonQueryColumnContext ctx) {
        AbstractSQLJsonFunction.SQLJsonQueryColumn x = new AbstractSQLJsonFunction.SQLJsonQueryColumn();

        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setColumn(name);

        SQLDataType returnType = visitDataType(ctx.dataType());
        x.setDataType(returnType);

        if (ctx.jsonWrapperClause() != null) {
            JsonWrapperClauseContext jsonWrapperClauseContext = ctx.jsonWrapperClause();
            SQLReserved wrapperClause = of(jsonWrapperClauseContext);

            x.setWrapperClause(wrapperClause);
        }

        if (ctx.path != null) {
            SQLExpr pathExpr = visitExpr(ctx.path);
            x.setPathExpr(pathExpr);
        }

        if (ctx.jsonOnErrorClause() != null) {
            SQLExpr onErrorClause = visitJsonOnErrorClause(ctx.jsonOnErrorClause());
            x.setOnErrorClause(onErrorClause);
        }

        return x;
    }

    @Override
    public AbstractSQLJsonFunction.SQLJsonValueColumn visitJsonValueColumn(JsonValueColumnContext ctx) {
        AbstractSQLJsonFunction.SQLJsonValueColumn x = new AbstractSQLJsonFunction.SQLJsonValueColumn();

        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setColumn(name);

        SQLDataType returnType = visitDataType(ctx.dataType());
        x.setDataType(returnType);

        if (ctx.path != null) {
            SQLExpr pathExpr = visitExpr(ctx.path);
            x.setPathExpr(pathExpr);
        }

        if (ctx.jsonOnErrorClause() != null) {
            SQLExpr onErrorClause = visitJsonOnErrorClause(ctx.jsonOnErrorClause());
            x.setOnErrorClause(onErrorClause);
        }

        return x;
    }

    @Override
    public AbstractSQLJsonFunction.SQLJsonNestedPathColumn visitJsonNestedPathColumn(JsonNestedPathColumnContext ctx) {
        AbstractSQLJsonFunction.SQLJsonNestedPathColumn x = new AbstractSQLJsonFunction.SQLJsonNestedPathColumn();

        if (ctx.PATH() != null) {
            x.setPath(true);
        }

        SQLExpr pathExpr = visitExpr(ctx.path);
        x.setPathExpr(pathExpr);

        AbstractSQLJsonFunction.SQLJsonColumnsClause columnsClause = visitJsonColumnsClause(ctx.jsonColumnsClause());
        x.setJsonColumnsClause(columnsClause);

        return x;
    }

    @Override
    public AbstractSQLJsonFunction.SQLJsonOrdinalityColumn visitJsonOrdinalityColumn(JsonOrdinalityColumnContext ctx) {
        AbstractSQLJsonFunction.SQLJsonOrdinalityColumn x = new AbstractSQLJsonFunction.SQLJsonOrdinalityColumn();
        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setColumn(name);
        return x;
    }

    @Override
    public SQLAggregateFunction visitAggregateFunction(AggregateFunctionContext ctx) {
        String name = ctx.aggregateFunctionName().getText();

        SQLAggregateFunction x = new SQLAggregateFunction(name);

        SQLSetQuantifier setQuantifier = of(ctx.setQuantifier());
        x.setSetQuantifier(setQuantifier);

        for (ExprContext exprContext : ctx.expr()) {
            SQLExpr expr = visitExpr(exprContext);
            x.addArgument(expr);
        }


        boolean deterministic = ctx.DETERMINISTIC() != null;
        x.setDeterministic(deterministic);

        if (ctx.partitionByClause() != null) {
            SQLPartitionByClause partitionClause = visitPartitionByClause(ctx.partitionByClause());
            x.setPartitionClause(partitionClause);
        }

        if (ctx.orderByClause() != null) {
            SQLOrderByClause orderByClause = visitOrderByClause(ctx.orderByClause());
            x.setOrderByClause(orderByClause);
        }

        if (ctx.withinGroupSpecification() != null) {
            AbstractSQLAggregateFunction.SQLWithinGroupSpecification withinGroup = visitWithinGroupSpecification(ctx.withinGroupSpecification());
            x.setWithinGroup(withinGroup);
        }

        if (ctx.overClause() != null) {
            SQLOverClause overClause = visitOverClause(ctx.overClause());
            x.setOverClause(overClause);
        }

        return x;
    }

    @Override
    public AbstractSQLAggregateFunction.SQLWithinGroupSpecification visitWithinGroupSpecification(WithinGroupSpecificationContext ctx) {
        SQLOrderByClause orderByClause = visitOrderByClause(ctx.orderByClause());
        return new AbstractSQLAggregateFunction.SQLWithinGroupSpecification(orderByClause);
    }

    @Override
    public SQLFirstFunction visitFirstFunction(FirstFunctionContext ctx) {
        SQLAggregateFunction aggregateFunction = visitAggregateFunction(ctx.aggregateFunction());

        SQLFirstFunction x = new SQLFirstFunction(aggregateFunction);

        SQLOrderByClause orderByClause = visitOrderByClause(ctx.orderByClause());
        x.setOrderByClause(orderByClause);

        if (ctx.overClause() != null) {
            SQLOverClause overClause = visitOverClause(ctx.overClause());
            x.setOverClause(overClause);
        }

        return x;
    }

    @Override
    public SQLLastFunction visitLastFunction(LastFunctionContext ctx) {
        SQLAggregateFunction aggregateFunction = visitAggregateFunction(ctx.aggregateFunction());

        SQLLastFunction x = new SQLLastFunction(aggregateFunction);

        SQLOrderByClause orderByClause = visitOrderByClause(ctx.orderByClause());
        x.setOrderByClause(orderByClause);

        if (ctx.overClause() != null) {
            SQLOverClause overClause = visitOverClause(ctx.overClause());
            x.setOverClause(overClause);
        }

        return x;
    }

    @Override
    public SQLListAggFunction visitListAggFunction(ListAggFunctionContext ctx) {
        SQLListAggFunction x = new SQLListAggFunction();

        SQLSetQuantifier setQuantifier = of(ctx.setQuantifier());
        x.setSetQuantifier(setQuantifier);

        for (ExprContext exprContext : ctx.expr()) {
            SQLExpr expr = visitExpr(exprContext);
            x.addArgument(expr);
        }

        if (ctx.listaggOverflowClause() != null) {
            SQLExpr listAggOverflowClause = (SQLExpr) visit(ctx.listaggOverflowClause());
            x.setListAggOverflowClause(listAggOverflowClause);
        }

        AbstractSQLAggregateFunction.SQLWithinGroupSpecification withinGroup = visitWithinGroupSpecification(ctx.withinGroupSpecification());
        x.setWithinGroup(withinGroup);

        if (ctx.overClause() != null) {
            SQLOverClause overClause = visitOverClause(ctx.overClause());
            x.setOverClause(overClause);
        }

        return x;
    }


    @Override
    public SQLExpr visitOnOverflowErrorClause(OnOverflowErrorClauseContext ctx) {
        return SQLReserved.ON_OVERFLOW_ERROR.ofExpr();

    }

    @Override
    public SQLExpr visitOnOverflowTruncateClause(OnOverflowTruncateClauseContext ctx) {

        SQLListAggFunction.SQLOnOverflowTruncateClause x = new SQLListAggFunction.SQLOnOverflowTruncateClause();

        if (ctx.expr() != null) {
            SQLExpr indicator = visitExpr(ctx.expr());
            x.setIndicator(indicator);
        }

        if (ctx.WITH() != null) {
            x.setWithCount(SQLReserved.WITH_COUNT);
        } else if (ctx.WITHOUT() != null) {
            x.setWithCount(SQLReserved.WITHOUT_COUNT);
        }
        return x;
    }

    @Override
    public SQLWindowFunction visitWindowFunction(WindowFunctionContext ctx) {
        SQLName name = visitNameIdentifier(ctx.name);
        SQLWindowFunction x = new SQLWindowFunction(name);

        SQLSetQuantifier setQuantifier = of(ctx.setQuantifier());
        x.setSetQuantifier(setQuantifier);

        AbstractSQLWindowFunction.OracleSQLNullsOption insideNullsOption = of(ctx.inside);
        x.setInsideNullsOption(insideNullsOption);

        for (ExprContext exprContext : ctx.expr()) {
            SQLExpr argument = visitExpr(exprContext);
            x.addArgument(argument);
        }

        AbstractSQLWindowFunction.OracleSQLFromOption fromOption = of(ctx.windowFunctionFromOption());
        x.setFromOption(fromOption);

        AbstractSQLWindowFunction.OracleSQLNullsOption outsideNullsOption = of(ctx.outside);
        x.setOutsideNullsOption(outsideNullsOption);

        SQLOverClause overClause = visitOverClause(ctx.overClause());
        x.setOverClause(overClause);

        return x;
    }

    public AbstractSQLWindowFunction.OracleSQLNullsOption of(WindowFunctionNullsOptionContext ctx) {
        if (ctx == null) {
            return null;
        }

        AbstractSQLWindowFunction.OracleSQLNullsOption x = null;
        if (ctx.RESPECT() != null) {
            x = AbstractSQLWindowFunction.OracleSQLNullsOption.RESPECT_NULLS;

        } else if (ctx.IGNORE() != null) {
            x = AbstractSQLWindowFunction.OracleSQLNullsOption.IGNORE_NULLS;
        }


        return x;
    }

    public AbstractSQLWindowFunction.OracleSQLFromOption of(WindowFunctionFromOptionContext ctx) {
        if (ctx == null) {
            return null;
        }

        AbstractSQLWindowFunction.OracleSQLFromOption x = null;
        if (ctx.FIRST() != null) {
            x = AbstractSQLWindowFunction.OracleSQLFromOption.FROM_FIRST;

        } else if (ctx.LAST() != null) {
            x = AbstractSQLWindowFunction.OracleSQLFromOption.FROM_LAST;
        }

        return x;
    }


    @Override
    public SQLOverClause visitOverClause(OverClauseContext ctx) {
        SQLOverClause x = new SQLOverClause();
        SQLWindowSpecification windowSpecification = visitAnalyticClause(ctx.analyticClause());
        x.setExpr(windowSpecification);

        return x;
    }

    @Override
    public SQLWindowSpecification visitAnalyticClause(AnalyticClauseContext ctx) {
        SQLWindowSpecification x = new SQLWindowSpecification();

        if (ctx.partitionByClause() != null) {
            SQLPartitionByClause partitionClause = visitPartitionByClause(ctx.partitionByClause());
            x.setPartitionClause(partitionClause);
        }

        if (ctx.orderByClause() != null) {
            SQLOrderByClause orderByClause = visitOrderByClause(ctx.orderByClause());
            x.setOrderByClause(orderByClause);
        }

        if (ctx.windowFrameClause() != null) {
            SQLWindowFrameClause windowFrameClause = visitWindowFrameClause(ctx.windowFrameClause());
            x.setWindowFrameClause(windowFrameClause);
        }

        return x;
    }

    @Override
    public SQLPartitionByClause visitPartitionByClause(PartitionByClauseContext ctx) {
        SQLPartitionByClause x = new SQLPartitionByClause();
        for (ExprContext exprContext : ctx.expr()) {
            SQLExpr item = visitExpr(exprContext);
            x.addItem(item);
        }
        return x;
    }


    @Override
    public SQLWindowFrameClause visitWindowFrameClause(WindowFrameClauseContext ctx) {
        SQLWindowFrameClause x = new SQLWindowFrameClause();

        SQLWindowFrameClause.SQLWindowFrameUnit unit = SQLWindowFrameClause.SQLWindowFrameUnit.ROWS;
        if (ctx.windowFrameUnit().RANGE() != null) {
            unit = SQLWindowFrameClause.SQLWindowFrameUnit.RANGE;
        }
        x.setUnit(unit);

        SQLExpr extent = visitWindowFrameExtent(ctx.windowFrameExtent());
        x.setExtent(extent);

        return x;
    }

    @Override
    public SQLExpr visitWindowFrameExtent(WindowFrameExtentContext ctx) {
        SQLExpr x = null;

        if (ctx.BETWEEN() != null) {
            SQLExpr between = visitWindowFrameExtentItem(ctx.between);
            SQLExpr and = visitWindowFrameExtentItem(ctx.and);

            x = new SQLWindowFrameClause.SQLWindowFrameBetween(between, and);

        } else {
            x = visitWindowFrameExtentItem(ctx.extent);
        }

        return x;
    }

    @Override
    public SQLExpr visitWindowFrameExtentItem(WindowFrameExtentItemContext ctx) {
        SQLExpr x = null;

        if (ctx.UNBOUNDED() != null) {
            x = SQLReserved.UNBOUNDED_PRECEDING.ofExpr();

        } else if (ctx.CURRENT() != null) {
            x = SQLReserved.CURRENT_ROW.ofExpr();

        } else {
            SQLExpr expr = visitExpr(ctx.expr());

            if (ctx.PRECEDING() != null) {
                x = new SQLWindowFrameClause.SQLWindowFramePreceding(expr);
            } else {
                x = new SQLWindowFrameClause.SQLWindowFrameFollowing(expr);
            }
        }

        return x;
    }

    @Override
    public SQLCubeTableFunction visitCubeTableFunction(CubeTableFunctionContext ctx) {
        SQLCubeTableFunction x = new SQLCubeTableFunction();

        SQLCubeTableFunction.SQLArgumentExpr argumentExpr = new SQLCubeTableFunction.SQLArgumentExpr();

        SQLName cube = visitNameIdentifier(ctx.cube);
        argumentExpr.setExpr(cube);

        for (CubeTableOptionExprContext cubeTableOptionExprContext : ctx.cubeTableOptionExpr()) {
            SQLCubeTableFunction.SQLCubeTableOptionExpr cubeTableOptionExpr = visitCubeTableOptionExpr(cubeTableOptionExprContext);
            argumentExpr.addOptionExpr(cubeTableOptionExpr);
        }

        x.addArgument(argumentExpr);

        return x;
    }

    @Override
    public SQLCubeTableFunction.SQLCubeTableOptionExpr visitCubeTableOptionExpr(CubeTableOptionExprContext ctx) {
        SQLCubeTableFunction.SQLCubeTableOptionExpr x = new SQLCubeTableFunction.SQLCubeTableOptionExpr();

        SQLReserved hrr = SQLReserved.HRR;
        if (ctx.HIERARCHY() != null) {
            hrr = SQLReserved.HIERARCHY;
        }
        x.setHrr(hrr);

        if (ctx.dimension != null) {
            SQLName dimension = visitNameIdentifier(ctx.dimension);
            x.setDimension(dimension);
        }

        if (ctx.hierarchy != null) {
            SQLName hierarchy = visitNameIdentifier(ctx.hierarchy);
            x.setHierarchy(hierarchy);
        }

        return x;
    }

    // --------------------------------------- function End ----------------------------------------------------------------


    // --------------------------------------- DDL Start ----------------------------------------------------------------


    // ------  Database Start ---------------

    // ------  Database End ---------------


    // ------  Databaselink Start ---------------

    @Override
    public SQLCreateDatabaseLinkStatement visitCreateDatabaseLinkStatement(CreateDatabaseLinkStatementContext ctx) {
        SQLCreateDatabaseLinkStatement x = new SQLCreateDatabaseLinkStatement(DBType.Oracle);

        if (ctx.SHARED() != null) {
            x.setShared(true);
        }
        if (ctx.PUBLIC() != null) {
            x.setPublic_(true);
        }
        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);

        for (CreateDatabaseLinkStatementItemContext createDatabaseLinkStatementItemContext : ctx.createDatabaseLinkStatementItem()) {
            SQLExpr item = (SQLExpr) visitChildren(createDatabaseLinkStatementItemContext);
            x.addItem(item);
        }

        if (ctx.expr() != null) {
            SQLExpr using = visitExpr(ctx.expr());
            x.setUsing(using);
        }

        return x;
    }

    @Override
    public SQLAlterDatabaseLinkStatement visitAlterDatabaseLinkStatement(AlterDatabaseLinkStatementContext ctx) {
        SQLAlterDatabaseLinkStatement x = new SQLAlterDatabaseLinkStatement(DBType.Oracle);

        if (ctx.SHARED() != null) {
            x.setShared(true);
        }
        if (ctx.PUBLIC() != null) {
            x.setPublic_(true);
        }

        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);

        SQLExpr item = (SQLExpr) visitChildren(ctx.createDatabaseLinkStatementItem());
        x.setAction(item);
        return x;
    }

    @Override
    public SQLDropDatabaseLinkStatement visitDropDatabaseLinkStatement(DropDatabaseLinkStatementContext ctx) {
        SQLDropDatabaseLinkStatement x = new SQLDropDatabaseLinkStatement(DBType.Oracle);

        if (ctx.PUBLIC() != null) {
            x.setPublic_(true);
        }

        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);

        return x;
    }

    @Override
    public OracleSQLConnectToCurrentUserClause visitConnectToCurrentUser(ConnectToCurrentUserContext ctx) {
        return new OracleSQLConnectToCurrentUserClause();
    }

    @Override
    public OracleSQLConnectToIdentifiedByClause visitConnectToIdentifiedBy(ConnectToIdentifiedByContext ctx) {
        OracleSQLConnectToIdentifiedByClause x = new OracleSQLConnectToIdentifiedByClause();

        SQLExpr user = visitExpr(ctx.user);
        SQLExpr password = visitExpr(ctx.password);

        x.setUser(user);
        x.setPassword(password);

        if (ctx.dblinkAuthentication() != null) {
            OracleSQLDBLinkAuthenticationClause dblinkAuthentication = visitDblinkAuthentication(ctx.dblinkAuthentication());
            x.setDbLinkAuthentication(dblinkAuthentication);
        }

        return x;
    }

    @Override
    public OracleSQLDBLinkAuthenticationClause visitDblinkAuthentication(DblinkAuthenticationContext ctx) {
        OracleSQLDBLinkAuthenticationClause x = new OracleSQLDBLinkAuthenticationClause();

        SQLExpr user = visitExpr(ctx.user);
        SQLExpr password = visitExpr(ctx.password);

        x.setUser(user);
        x.setPassword(password);

        return x;
    }

    // ------  Databaselink End ---------------


    // ------  Function Start ---------------

    @Override
    public SQLCreateFunctionStatement visitCreateFunctionStatement(CreateFunctionStatementContext ctx) {
        SQLCreateFunctionStatement x = new SQLCreateFunctionStatement(DBType.Oracle);

        if (ctx.orReplace() != null) {
            x.setOrReplace(SQLOrReplaceType.OR_REPLACE);
        }

        SQLEditionAbleType editionAbleType = of(ctx.editionableType());
        x.setEditionAbleType(editionAbleType);

        SQLName name = visitNameIdentifier(ctx.name);
        x.setName(name);

        for (ParameterDeclarationContext parameterDeclarationContext : ctx.parameterDeclaration()) {
            SQLParameterDeclaration parameter = visitParameterDeclaration(parameterDeclarationContext);
            x.addParameter(parameter);
        }

        SQLDataType dataType = visitDataType(ctx.dataType());
        x.setReturnDataType(dataType);

        SQLSharingClause sharingClause = visitSharingClause(ctx.sharingClause());
        x.setSharingClause(sharingClause);

        for (FunctionOptionContext functionOptionContext : ctx.functionOption()) {
            SQLExpr option = (SQLExpr) visitChildren(functionOptionContext);
            x.addOption(option);
        }

        SQLASType as = of(ctx.asType());
        x.setAs(as);

        for (DeclareSectionContext declareSectionContext : ctx.declareSection()) {
            SQLExpr declareSection = (SQLExpr) visitChildren(declareSectionContext);
            x.addDeclareSection(declareSection);
        }

        SQLExpr asExpr = null;
        if (ctx.body() != null) {
            asExpr = visitBody(ctx.body());
        } else if (ctx.callSpec() != null) {
            asExpr = (SQLExpr) visit(ctx.callSpec());
        }
        x.setAsExpr(asExpr);

        if (ctx.SEMI() != null) {
            x.setAfterSemi(true);
        }
        return x;
    }

    @Override
    public SQLAlterFunctionStatement visitAlterFunctionStatement(AlterFunctionStatementContext ctx) {
        SQLAlterFunctionStatement x = new SQLAlterFunctionStatement(DBType.Oracle);


        return x;
    }

    @Override
    public SQLDropFunctionStatement visitDropFunctionStatement(DropFunctionStatementContext ctx) {
        SQLDropFunctionStatement x = new SQLDropFunctionStatement(DBType.Oracle);

        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);

        return x;
    }

    // ------  Function End ---------------


    // ------  Index End ---------------
    @Override
    public SQLCreateIndexStatement visitCreateIndexStatement(CreateIndexStatementContext ctx) {
        SQLCreateIndexStatement x = new SQLCreateIndexStatement(DBType.Oracle);

        SQLIndexCategory category = null;
        if (ctx.UNIQUE() != null) {
            category = SQLIndexCategory.UNIQUE;
        } else if (ctx.BITMAP() != null) {
            category = SQLIndexCategory.BITMAP;
        }
        x.setCategory(category);

        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);

        if (ctx.CLUSTER() != null) {
            x.setCluster(true);
        }


        SQLObjectNameTableReference tableReference = (SQLObjectNameTableReference) visit(ctx.iTableReference());
        x.setTableReference(tableReference);

        for (CreateIndexStatementColumnContext createIndexStatementColumnContext : ctx.createIndexStatementColumn()) {
            SQLIndexColumn column = visitCreateIndexStatementColumn(createIndexStatementColumnContext);
            x.addColumn(column);
        }

        if (ctx.fromClause() != null) {
            SQLFromClause fromClause = visitFromClause(ctx.fromClause());
            x.setFromClause(fromClause);
        }

        if (ctx.whereClause() != null) {
            SQLWhereClause whereClause = visitWhereClause(ctx.whereClause());
            x.setWhereClause(whereClause);
        }

        for (CreateIndexStatementOptionContext createIndexStatementOptionContext : ctx.createIndexStatementOption()) {
            SQLExpr option = (SQLExpr) visitChildren(createIndexStatementOptionContext);
            x.addProperty(option);
        }

        SQLUsableType usable = null;
        if (ctx.USABLE() != null) {
            usable = SQLUsableType.USABLE;
        } else if (ctx.UNUSABLE() != null) {
            usable = SQLUsableType.UNUSABLE;
        }
        x.setUsable(usable);

        if (ctx.invalidationType() != null) {
            SQLInvalidationType invalidation = of(ctx.invalidationType());
            x.setInvalidation(invalidation);
        }

        return x;
    }

    @Override
    public SQLAlterIndexStatement visitAlterIndexStatement(AlterIndexStatementContext ctx) {
        SQLAlterIndexStatement x = new SQLAlterIndexStatement(DBType.Oracle);

        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);

        for (AlterIndexStatementItemContext alterIndexStatementItemContext : ctx.alterIndexStatementItem()) {
            SQLExpr item = (SQLExpr) visitChildren(alterIndexStatementItemContext);
            x.addItem(item);
        }
        return x;
    }

    @Override
    public SQLDropIndexStatement visitDropIndexStatement(DropIndexStatementContext ctx) {
        SQLDropIndexStatement x = new SQLDropIndexStatement(DBType.Oracle);

        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.addName(name);

        if (ctx.ONLINE() != null) {
            x.setOnline(true);
        }

        if (ctx.FORCE() != null) {
            x.setForce(true);
        }

        if (ctx.invalidationType() != null) {
            SQLInvalidationType invalidation = of(ctx.invalidationType());
            x.setInvalidation(invalidation);
        }
        return x;
    }

    @Override
    public SQLIndexColumn visitCreateIndexStatementColumn(CreateIndexStatementColumnContext ctx) {
        SQLIndexColumn x = new SQLIndexColumn();

        SQLExpr expr = visitExpr(ctx.expr());
        x.setName(expr);

        SQLOrderingSpecification orderingSpecification = null;
        if (ctx.ASC() != null) {
            orderingSpecification = SQLOrderingSpecification.ASC;
        } else if (ctx.DESC() != null) {
            orderingSpecification = SQLOrderingSpecification.DESC;
        }
        x.setOrderingSpecification(orderingSpecification);

        return x;
    }

    @Override
    public ISQLIndexProperty visitIndexProperty(IndexPropertyContext ctx) {
        return (ISQLIndexProperty) super.visitChildren(ctx);
    }

    @Override
    public SQLObject visitIndexTypeIsIndexTypeClause(IndexTypeIsIndexTypeClauseContext ctx) {
        return super.visitIndexTypeIsIndexTypeClause(ctx);
    }

    @Override
    public ISQLIndexAttribute visitIndexAttribute(IndexAttributeContext ctx) {
        return (ISQLIndexAttribute) super.visitChildren(ctx);
    }

    @Override
    public SQLIndexAttributeOnline visitIndexAttributeOnline(IndexAttributeOnlineContext ctx) {
        return new SQLIndexAttributeOnline();
    }

    @Override
    public SQLIndexAttributeComputeStatistics visitIndexAttributeComputeStatistics(IndexAttributeComputeStatisticsContext ctx) {
        return new SQLIndexAttributeComputeStatistics();
    }

    @Override
    public SQLIndexAttributeSort visitIndexAttributeSort(IndexAttributeSortContext ctx) {
        return new SQLIndexAttributeSort();
    }

    @Override
    public SQLIndexAttributeNoSort visitIndexAttributeNoSort(IndexAttributeNoSortContext ctx) {
        return new SQLIndexAttributeNoSort();
    }

    @Override
    public SQLIndexAttributeReverse visitIndexAttributeReverse(IndexAttributeReverseContext ctx) {
        return new SQLIndexAttributeReverse();
    }

    @Override
    public SQLIndexAttributeVisible visitIndexAttributeVisible(IndexAttributeVisibleContext ctx) {
        return new SQLIndexAttributeVisible();
    }

    @Override
    public SQLIndexAttributeInvisible visitIndexAttributeInvisible(IndexAttributeInvisibleContext ctx) {
        return new SQLIndexAttributeInvisible();
    }

    @Override
    public ISQLPartialIndexClause visitPartialIndexClause(PartialIndexClauseContext ctx) {
        ISQLPartialIndexClause x = new SQLPartialIndexByPartialClause();
        if (ctx.FULL() != null) {
            x = new SQLPartialIndexByFullClause();
        }
        return x;
    }

    @Override
    public SQLParametersClause visitParametersClause(ParametersClauseContext ctx) {
        SQLParametersClause x = new SQLParametersClause();
        SQLExpr expr = visitExpr(ctx.expr());
        x.setExpr(expr);

        return x;
    }

    @Override
    public SQLGlobalPartitionByRange visitGlobalPartitionByRange(GlobalPartitionByRangeContext ctx) {
        SQLGlobalPartitionByRange x = new SQLGlobalPartitionByRange();
        for (ExprContext columnContext : ctx.columns) {
            SQLExpr column = visitExpr(columnContext);
            x.addColumn(column);
        }

        for (PartitionDefinitionContext partitionDefinitionContext : ctx.partitionDefinition()) {
            SQLPartitionDefinition partitionDefinition = visitPartitionDefinition(partitionDefinitionContext);
            x.addPartition(partitionDefinition);
        }
        return x;
    }

    @Override
    public SQLGlobalPartitionByHash visitGlobalPartitionByHash(GlobalPartitionByHashContext ctx) {
        SQLGlobalPartitionByHash x = new SQLGlobalPartitionByHash();
        for (ExprContext columnContext : ctx.columns) {
            SQLExpr column = visitExpr(columnContext);
            x.addColumn(column);
        }

        if (ctx.partitionsNum != null) {
            SQLExpr partitionsNum = visitExpr(ctx.partitionsNum);
            x.setPartitionsNum(partitionsNum);
        }

        if (ctx.storeInClause() != null) {
            SQLStoreInClause storeInClause = visitStoreInClause(ctx.storeInClause());
            x.setStoreInClause(storeInClause);
        }

        if (ctx.iCompression() != null) {
            ISQLCompression compression = (ISQLCompression) visitChildren(ctx.iCompression());
            x.setCompression(compression);
        }

        if (ctx.overflowStoreInClause() != null) {
            SQLOverflowStoreInClause overflowStoreInClause = visitOverflowStoreInClause(ctx.overflowStoreInClause());
            x.setOverflowStoreInClause(overflowStoreInClause);
        }

        for (PartitionDefinitionContext partitionDefinitionContext : ctx.partitionDefinition()) {
            SQLPartitionDefinition partitionDefinition = visitPartitionDefinition(partitionDefinitionContext);
            x.addPartition(partitionDefinition);
        }
        return x;
    }

    @Override
    public SQLLocalPartitionIndex visitLocalPartitionIndex(LocalPartitionIndexContext ctx) {

        SQLLocalPartitionIndex x = new SQLLocalPartitionIndex();

        if (ctx.storeInClause() != null) {
            SQLStoreInClause storeInClause = visitStoreInClause(ctx.storeInClause());
            x.setStoreInClause(storeInClause);
        }


        for (PartitionDefinitionContext partitionDefinitionContext : ctx.partitionDefinition()) {
            SQLPartitionDefinition partitionDefinition = visitPartitionDefinition(partitionDefinitionContext);
            x.addItem(partitionDefinition);
        }

        return x;
    }

    @Override
    public SQLShrinkClause visitShrinkClause(ShrinkClauseContext ctx) {
        if (ctx == null) {
            return null;
        }
        SQLShrinkClause x = new SQLShrinkClause();
        if (ctx.COMPACT() != null) {
            x.setCompact(true);
        }

        if (ctx.CASCADE() != null) {
            x.setCascade(true);
        }
        return x;
    }

    @Override
    public SQLRebuildClause visitRebuildClause(RebuildClauseContext ctx) {
        SQLRebuildClause x = new SQLRebuildClause();

        if (ctx.rebuildClauseItem() != null) {
            SQLExpr item = (SQLExpr) visit(ctx.rebuildClauseItem());
            x.setExpr(item);
        }
        for (RebuildClausePropertyContext rebuildClausePropertyContext : ctx.rebuildClauseProperty()) {
            SQLExpr property = (SQLExpr) visitChildren(rebuildClausePropertyContext);
            x.addProperty(property);
        }
        return x;
    }

    @Override
    public SQLRebuildClause.SQLPartitionItem visitRebuildClausePartitionItem(RebuildClausePartitionItemContext ctx) {
        SQLRebuildClause.SQLPartitionItem x = new SQLRebuildClause.SQLPartitionItem();
        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);
        return x;
    }

    @Override
    public SQLRebuildClause.SQLSubPartitionItem visitRebuildClauseSubPartitionItem(RebuildClauseSubPartitionItemContext ctx) {
        SQLRebuildClause.SQLSubPartitionItem x = new SQLRebuildClause.SQLSubPartitionItem();
        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);
        return x;
    }

    @Override
    public SQLRebuildClause.SQLReverseItem visitRebuildClauseReverseItem(RebuildClauseReverseItemContext ctx) {
        return new SQLRebuildClause.SQLReverseItem();
    }

    @Override
    public SQLRebuildClause.SQLNoReverseItem visitRebuildClauseNoReverseItem(RebuildClauseNoReverseItemContext ctx) {
        return new SQLRebuildClause.SQLNoReverseItem();
    }

    @Override
    public SQLObject visitRebuildClauseOnlineProperty(RebuildClauseOnlinePropertyContext ctx) {
        return super.visitRebuildClauseOnlineProperty(ctx);
    }

    @Override
    public SQLAlterIndexRebuildAction visitAlterIndexRebuildAction(AlterIndexRebuildActionContext ctx) {
        SQLAlterIndexRebuildAction x = new SQLAlterIndexRebuildAction();

        SQLRebuildClause rebuildClause = visitRebuildClause(ctx.rebuildClause());
        x.setRebuildClause(rebuildClause);

        if (ctx.invalidationType() != null) {
            SQLInvalidationType invalidationType = of(ctx.invalidationType());
            x.setInvalidation(invalidationType);
        }

        return x;
    }

    @Override
    public SQLAlterIndexCompileAction visitAlterIndexCompileAction(AlterIndexCompileActionContext ctx) {
        return new SQLAlterIndexCompileAction();
    }

    @Override
    public SQLAlterIndexEnableAction visitAlterIndexEnableAction(AlterIndexEnableActionContext ctx) {
        return new SQLAlterIndexEnableAction();
    }

    @Override
    public SQLAlterIndexDisableAction visitAlterIndexDisableAction(AlterIndexDisableActionContext ctx) {
        return new SQLAlterIndexDisableAction();
    }

    @Override
    public SQLAlterIndexUnusableAction visitAlterIndexUnusableAction(AlterIndexUnusableActionContext ctx) {
        SQLAlterIndexUnusableAction x = new SQLAlterIndexUnusableAction();

        if (ctx.ONLINE() != null) {
            x.setOnline(true);
        }

        if (ctx.invalidationType() != null) {
            SQLInvalidationType invalidationType = of(ctx.invalidationType());
            x.setInvalidation(invalidationType);
        }

        return x;
    }

    @Override
    public SQLAlterIndexVisibleAction visitAlterIndexVisibleAction(AlterIndexVisibleActionContext ctx) {
        return new SQLAlterIndexVisibleAction();
    }

    @Override
    public SQLAlterIndexInvisibleAction visitAlterIndexInvisibleAction(AlterIndexInvisibleActionContext ctx) {
        return new SQLAlterIndexInvisibleAction();
    }

    @Override
    public SQLAlterIndexRenameAction visitAlterIndexRenameAction(AlterIndexRenameActionContext ctx) {
        SQLAlterIndexRenameAction x = new SQLAlterIndexRenameAction();
        SQLName newName = visitNameIdentifier(ctx.nameIdentifier());
        x.setNewName(newName);
        return x;
    }

    @Override
    public SQLAlterIndexMonitoringUsageAction visitAlterIndexMonitoringUsageAction(AlterIndexMonitoringUsageActionContext ctx) {
        return new SQLAlterIndexMonitoringUsageAction();
    }

    @Override
    public SQLAlterIndexCoalesceAction visitAlterIndexCoalesceAction(AlterIndexCoalesceActionContext ctx) {
        SQLAlterIndexCoalesceAction x = new SQLAlterIndexCoalesceAction();
        if (ctx.CLEANUP() != null) {
            x.setCleanup(true);
        }

        if (ctx.parallelClause() != null) {
            ISQLParallelClause parallelClause = visitParallelClause(ctx.parallelClause());
            x.setParallelClause(parallelClause);
        }
        return x;
    }

    @Override
    public SQLAlterIndexNoMonitoringUsageAction visitAlterIndexNoMonitoringUsageAction(AlterIndexNoMonitoringUsageActionContext ctx) {
        return new SQLAlterIndexNoMonitoringUsageAction();
    }

    @Override
    public SQLAlterIndexUpdateBlockReferencesAction visitAlterIndexUpdateBlockReferencesAction(AlterIndexUpdateBlockReferencesActionContext ctx) {
        return new SQLAlterIndexUpdateBlockReferencesAction();
    }


    @Override
    public SQLAlterIndexModifyDefaultAttributesAction visitAlterIndexModifyDefaultAttrsAction(AlterIndexModifyDefaultAttrsActionContext ctx) {
        SQLAlterIndexModifyDefaultAttributesAction x = new SQLAlterIndexModifyDefaultAttributesAction();

        if (ctx.expr() != null) {
            SQLExpr partition = visitExpr(ctx.expr());
            x.setPartition(partition);
        }

        for (ModifyDefaultAttrItemContext modifyDefaultAttrItemContext : ctx.modifyDefaultAttrItem()) {
            SQLExpr item = (SQLExpr) visitChildren(modifyDefaultAttrItemContext);
            x.addItem(item);
        }

        return x;
    }

    @Override
    public SQLAlterIndexAddPartitionAction visitAlterIndexAddPartitionAction(AlterIndexAddPartitionActionContext
                                                                                     ctx) {
        SQLAlterIndexAddPartitionAction x = new SQLAlterIndexAddPartitionAction();

        if (ctx.nameIdentifier() != null) {
            SQLName name = visitNameIdentifier(ctx.nameIdentifier());
            x.setName(name);
        }

        if (ctx.tableSpaceClause() != null) {
            SQLTablespaceOptionExpr tableSpaceClause = visitTableSpaceClause(ctx.tableSpaceClause());
            x.setTableSpaceClause(tableSpaceClause);
        }

        if (ctx.indexCompression() != null) {
            IOracleSQLIndexCompression indexCompression = visitIndexCompression(ctx.indexCompression());
            // todo
            // x.setIndexCompression(indexCompression);
        }

        if (ctx.parallelClause() != null) {
            ISQLParallelClause parallelClause = visitParallelClause(ctx.parallelClause());
            x.setParallelClause(parallelClause);
        }

        return x;
    }

    @Override
    public SQLAlterIndexCoalescePartitionAction visitAlterIndexCoalescePartitionAction
            (AlterIndexCoalescePartitionActionContext ctx) {
        SQLAlterIndexCoalescePartitionAction x = new SQLAlterIndexCoalescePartitionAction();

        if (ctx.parallelClause() != null) {
            ISQLParallelClause parallelClause = visitParallelClause(ctx.parallelClause());
            x.setParallelClause(parallelClause);
        }

        return x;
    }

    @Override
    public SQLAlterIndexModifyPartitionAction visitAlterIndexModifyPartitionAction(AlterIndexModifyPartitionActionContext ctx) {
        SQLAlterIndexModifyPartitionAction x = new SQLAlterIndexModifyPartitionAction();

        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);

        for (AlterIndexModifyPartitionActionItemContext alterIndexModifyPartitionActionItemContext : ctx.alterIndexModifyPartitionActionItem()) {
            SQLExpr item = (SQLExpr) visitChildren(alterIndexModifyPartitionActionItemContext);
            x.addItem(item);
        }
        return x;
    }

    @Override
    public SQLAlterIndexModifyPartitionAction.SQLCoalesceOption visitAlterIndexModifyPartitionActionCoalesceItem(AlterIndexModifyPartitionActionCoalesceItemContext ctx) {
        SQLAlterIndexModifyPartitionAction.SQLCoalesceOption x = new SQLAlterIndexModifyPartitionAction.SQLCoalesceOption();
        if (ctx.CLEANUP() != null) {
            x.setCleanup(true);
        }
        return x;
    }

    @Override
    public SQLAlterIndexModifyPartitionAction.SQLUpdateBlockReferencesOption visitAlterIndexModifyPartitionActionUpdateBlockReferencesItem(AlterIndexModifyPartitionActionUpdateBlockReferencesItemContext ctx) {
        return new SQLAlterIndexModifyPartitionAction.SQLUpdateBlockReferencesOption();
    }

    @Override
    public SQLAlterIndexModifyPartitionAction.SQLUnusableOption visitAlterIndexModifyPartitionActionUnusableItem(AlterIndexModifyPartitionActionUnusableItemContext ctx) {
        return new SQLAlterIndexModifyPartitionAction.SQLUnusableOption();
    }

    @Override
    public SQLAlterIndexRenamePartitionAction visitAlterIndexRenamePartitionAction(AlterIndexRenamePartitionActionContext ctx) {
        SQLAlterIndexRenamePartitionAction x = new SQLAlterIndexRenamePartitionAction();
        SQLName name = visitNameIdentifier(ctx.name);
        SQLName newName = visitNameIdentifier(ctx.toName);
        x.setName(name);
        x.setNewName(newName);
        return x;
    }

    @Override
    public SQLAlterIndexRenameSubPartitionAction visitAlterIndexRenameSubPartitionAction(AlterIndexRenameSubPartitionActionContext ctx) {
        SQLAlterIndexRenameSubPartitionAction x = new SQLAlterIndexRenameSubPartitionAction();
        SQLName name = visitNameIdentifier(ctx.name);
        SQLName newName = visitNameIdentifier(ctx.toName);
        x.setName(name);
        x.setNewName(newName);
        return x;
    }

    @Override
    public SQLAlterIndexDropPartitionAction visitAlterIndexDropPartitionAction(AlterIndexDropPartitionActionContext
                                                                                       ctx) {
        SQLAlterIndexDropPartitionAction x = new SQLAlterIndexDropPartitionAction();
        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);
        return x;
    }

    @Override
    public SQLAlterIndexSplitPartitionAction visitAlterIndexSplitPartitionAction
            (AlterIndexSplitPartitionActionContext ctx) {
        SQLAlterIndexSplitPartitionAction x = new SQLAlterIndexSplitPartitionAction();

        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);

        for (ExprContext exprContext : ctx.expr()) {
            SQLExpr item = visitExpr(exprContext);
            x.addItem(item);
        }

        for (PartitionDefinitionContext partitionDefinitionContext : ctx.partitionDefinition()) {
            SQLPartitionDefinition partition = visitPartitionDefinition(partitionDefinitionContext);
            x.addPartition(partition);
        }

        if (ctx.parallelClause() != null) {
            ISQLParallelClause parallelClause = visitParallelClause(ctx.parallelClause());
            x.setParallelClause(parallelClause);
        }

        return x;
    }

    @Override
    public SQLAlterIndexModifySubPartitionAction visitAlterIndexModifySubPartitionAction
            (AlterIndexModifySubPartitionActionContext ctx) {
        SQLAlterIndexModifySubPartitionAction x = new SQLAlterIndexModifySubPartitionAction();

        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);

        SQLExpr option = (SQLExpr) visitChildren(ctx.alterIndexModifySubpartitionOption());
        x.setOption(option);

        return x;
    }

    @Override
    public SQLObject visitAlterIndexModifySubpartitionOption(AlterIndexModifySubpartitionOptionContext ctx) {
        return super.visitAlterIndexModifySubpartitionOption(ctx);
    }

    @Override
    public SQLAlterIndexModifySubPartitionAction.SQLUnusableOption visitModifySubpartitionUnusableOption(ModifySubpartitionUnusableOptionContext ctx) {
        return new SQLAlterIndexModifySubPartitionAction.SQLUnusableOption();
    }

    // ------  Index End ---------------


    // ------  Package Start ---------------

    @Override
    public SQLCreatePackageStatement visitCreatePackageStatement(CreatePackageStatementContext ctx) {
        SQLCreatePackageStatement x = new SQLCreatePackageStatement(DBType.Oracle);

        if (ctx.orReplace() != null) {
            x.setOrReplace(true);
        }

        SQLName packageName = visitNameIdentifier(ctx.packageName);
        x.setName(packageName);

        for (CreatePackageStatementOptionContext createPackageStatementOptionContext : ctx.createPackageStatementOption()) {
            SQLExpr option = (SQLExpr) visitChildren(createPackageStatementOptionContext);
            x.addOption(option);
        }

        if (ctx.IS() != null) {
            x.setAs(SQLASType.IS);
        }

        for (CreatePackageStatementItemContext packageItemContext : ctx.createPackageStatementItem()) {
            SQLExpr item = visitCreatePackageStatementItem(packageItemContext);
            x.addItem(item);
        }

        if (ctx.endName != null) {
            SQLName endName = visitNameIdentifier(ctx.endName);
            x.setEndName(endName);
        }

        return x;
    }

    @Override
    public SQLAlterPackageStatement visitAlterPackageStatement(AlterPackageStatementContext ctx) {
        SQLAlterPackageStatement x = new SQLAlterPackageStatement(DBType.Oracle);

        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);

        SQLExpr option = (SQLExpr) visitChildren(ctx.alterPackageStatementOption());
        x.setOption(option);

        return x;
    }

    @Override
    public SQLDropPackageStatement visitDropPackageStatement(DropPackageStatementContext ctx) {
        SQLDropPackageStatement x = new SQLDropPackageStatement(DBType.Oracle);
        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);
        return x;
    }

    @Override
    public SQLCreatePackageBodyStatement visitCreatePackageBodyStatement(CreatePackageBodyStatementContext ctx) {
        SQLCreatePackageBodyStatement x = new SQLCreatePackageBodyStatement(DBType.Oracle);

        if (ctx.orReplace() != null) {
            x.setOrReplace(true);
        }

        SQLName name = visitNameIdentifier(ctx.packageName);
        x.setName(name);

        SQLASType as = null;
        if (ctx.IS() != null) {
            as = SQLASType.IS;
        } else if (ctx.AS() != null) {
            as = SQLASType.AS;
        }
        x.setAs(as);

        for (CreatePackageBodyStatementItemContext createPackageBodyStatementItemContext : ctx.createPackageBodyStatementItem()) {
            SQLExpr item = visitCreatePackageBodyStatementItem(createPackageBodyStatementItemContext);
            x.addItem(item);
        }

        for (BodyItemContext bodyItemContext : ctx.bodyItem()) {
            SQLBody.SQLBodyItem bodyItem = visitBodyItem(bodyItemContext);
            x.addBodyItem(bodyItem);
        }

        if (ctx.exceptionClause() != null) {
            SQLExceptionClause exceptionClause = visitExceptionClause(ctx.exceptionClause());
            x.setExceptionClause(exceptionClause);
        }

        if (ctx.endName != null) {
            SQLName endName = visitNameIdentifier(ctx.endName);
            x.setEndName(endName);
        }

        return x;
    }

    @Override
    public SQLDropPackageBodyStatement visitDropPackageBodyStatement(DropPackageBodyStatementContext ctx) {
        SQLDropPackageBodyStatement x = new SQLDropPackageBodyStatement(DBType.Oracle);
        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);
        return x;
    }


    @Override
    public SQLExpr visitCreatePackageStatementItem(CreatePackageStatementItemContext ctx) {
        return (SQLExpr) visitChildren(ctx);
    }

    @Override
    public SQLExpr visitCreatePackageBodyStatementItem(CreatePackageBodyStatementItemContext ctx) {
        return (SQLExpr) visitChildren(ctx);
    }

    // ------  Package End ---------------


    // ------  Procedure End ---------------
    @Override
    public SQLCreateProcedureStatement visitCreateProcedureStatement(CreateProcedureStatementContext ctx) {
        SQLCreateProcedureStatement x = new SQLCreateProcedureStatement(DBType.Oracle);

        if (ctx.orReplace() != null) {
            x.setOrReplace(SQLOrReplaceType.OR_REPLACE);
        }

        if (ctx.editionableType() != null) {
            SQLEditionAbleType editionAbleType = of(ctx.editionableType());
            x.setEditionAbleType(editionAbleType);
        }

        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);

        for (ParameterDeclarationContext parameterDeclarationContext : ctx.parameterDeclaration()) {
            SQLParameterDeclaration parameter = visitParameterDeclaration(parameterDeclarationContext);
            x.addParameter(parameter);
        }

        if (ctx.sharingClause() != null) {
            SQLSharingClause sharingClause = visitSharingClause(ctx.sharingClause());
            x.setSharingClause(sharingClause);
        }

        for (CreateProcedureStatementOptionContext createProcedureStatementOptionContext : ctx.createProcedureStatementOption()) {
            SQLExpr option = (SQLExpr) visitChildren(createProcedureStatementOptionContext);
            x.addOption(option);
        }

        SQLASType as = of(ctx.asType());
        x.setAs(as);

        for (DeclareSectionContext declareSectionContext : ctx.declareSection()) {
            SQLExpr declareSection = (SQLExpr) visitChildren(declareSectionContext);
            x.addDeclareSection(declareSection);
        }

        SQLExpr asExpr = null;
        if (ctx.body() != null) {
            asExpr = visitBody(ctx.body());
        } else if (ctx.callSpec() != null) {
            asExpr = (SQLExpr) visit(ctx.callSpec());
        }
        x.setAsExpr(asExpr);

        if (ctx.SEMI() != null) {
            x.setAfterSemi(true);
        }

        return x;
    }

    @Override
    public SQLAlterProcedureStatement visitAlterProcedureStatement(AlterProcedureStatementContext ctx) {
        SQLAlterProcedureStatement x = new SQLAlterProcedureStatement(DBType.Oracle);

        SQLName name = visitNameIdentifier(ctx.nameIdentifier());

        SQLExpr option = (SQLExpr) visitChildren(ctx.alterProcedureStatementOption());

        return x;
    }

    @Override
    public SQLDropProcedureStatement visitDropProcedureStatement(DropProcedureStatementContext ctx) {
        SQLDropProcedureStatement x = new SQLDropProcedureStatement(DBType.Oracle);

        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);

        return x;
    }
    // ------  Procedure End ---------------


    // ------  Sequence Start ---------------
    @Override
    public SQLCreateSequenceStatement visitCreateSequenceStatement
    (OracleSQLStatementParser.CreateSequenceStatementContext ctx) {
        SQLCreateSequenceStatement x = new SQLCreateSequenceStatement(DBType.Oracle);

        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);

        if (ctx.sharingClause() != null) {
            SQLSharingClause sharingClause = visitSharingClause(ctx.sharingClause());
            x.setSharingClause(sharingClause);
        }

        List<CreateSequenceOptionContext> createSequenceOptionContexts = ctx.createSequenceOption();
        for (CreateSequenceOptionContext sequenceOptionContext : createSequenceOptionContexts) {
            SQLExpr option = (SQLExpr) visitChildren(sequenceOptionContext);
            x.addOption(option);
        }

        return x;
    }

    @Override
    public SQLAlterSequenceStatement visitAlterSequenceStatement
            (OracleSQLStatementParser.AlterSequenceStatementContext ctx) {
        SQLAlterSequenceStatement x = new SQLAlterSequenceStatement(DBType.Oracle);

        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);

        List<AlterSequenceOptionContext> sequenceOptionContexts = ctx.alterSequenceOption();
        for (AlterSequenceOptionContext sequenceOptionContext : sequenceOptionContexts) {
            SQLObject option = visit(sequenceOptionContext);
            x.addOption(option);
        }
        return x;
    }

    @Override
    public SQLDropSequenceStatement visitDropSequenceStatement
            (OracleSQLStatementParser.DropSequenceStatementContext ctx) {
        SQLDropSequenceStatement x = new SQLDropSequenceStatement(DBType.Oracle);

        SQLName sequenceName = visitNameIdentifier(ctx.sequenceName);
        x.addName(sequenceName);
        return x;
    }

    @Override
    public SQLSequenceStartWithOption visitStartWithSequenceOption(StartWithSequenceOptionContext ctx) {
        SQLSequenceStartWithOption x = new SQLSequenceStartWithOption();

        SQLIntegerLiteral startWith = (SQLIntegerLiteral) visitLiteral(ctx.literal());
        x.setStartWith(startWith);
        return x;
    }

    @Override
    public SQLSequenceIncrementByOption visitIncrementBySequenceOption(IncrementBySequenceOptionContext ctx) {
        SQLSequenceIncrementByOption x = new SQLSequenceIncrementByOption();

        SQLIntegerLiteral incrementBy = (SQLIntegerLiteral) visitLiteral(ctx.literal());
        x.setIncrementBy(incrementBy);

        return x;
    }

    @Override
    public SQLSequenceMaxValueOption visitMaxValueSequenceOption(MaxValueSequenceOptionContext ctx) {
        SQLSequenceMaxValueOption x = new SQLSequenceMaxValueOption();
        SQLIntegerLiteral maxValue = (SQLIntegerLiteral) visitLiteral(ctx.literal());
        x.setMaxValue(maxValue);
        return x;
    }

    @Override
    public SQLSequenceNoMaxValueOption visitNoMaxValueSequenceOption(NoMaxValueSequenceOptionContext ctx) {
        SQLSequenceNoMaxValueOption x = new SQLSequenceNoMaxValueOption();
        return x;
    }

    @Override
    public SQLSequenceMinValueOption visitMinValueSequenceOption(MinValueSequenceOptionContext ctx) {
        SQLSequenceMinValueOption x = new SQLSequenceMinValueOption();
        SQLIntegerLiteral incrementBy = (SQLIntegerLiteral) visitLiteral(ctx.literal());
        x.setMinValue(incrementBy);
        return x;
    }

    @Override
    public SQLSequenceNoMinValueOption visitNoMinValueSequenceOption(NoMinValueSequenceOptionContext ctx) {
        SQLSequenceNoMinValueOption x = new SQLSequenceNoMinValueOption();
        return x;
    }

    @Override
    public SQLSequenceCycleOption visitCycleSequenceOption(CycleSequenceOptionContext ctx) {
        SQLSequenceCycleOption x = new SQLSequenceCycleOption();
        return x;
    }

    @Override
    public SQLSequenceNoCycleOption visitNoCycleSequenceOption(NoCycleSequenceOptionContext ctx) {
        SQLSequenceNoCycleOption x = new SQLSequenceNoCycleOption();
        return x;
    }

    @Override
    public SQLSequenceCacheOption visitCacheSequenceOption(CacheSequenceOptionContext ctx) {
        SQLSequenceCacheOption x = new SQLSequenceCacheOption();
        SQLIntegerLiteral cache = (SQLIntegerLiteral) visitLiteral(ctx.literal());
        x.setCache(cache);
        return x;
    }

    @Override
    public SQLSequenceNoCacheOption visitNoCacheSequenceOption(NoCacheSequenceOptionContext ctx) {
        SQLSequenceNoCacheOption x = new SQLSequenceNoCacheOption();
        return x;
    }

    @Override
    public SQLSequenceOrderOption visitOrderSequenceOption(OrderSequenceOptionContext ctx) {
        SQLSequenceOrderOption x = new SQLSequenceOrderOption();
        return x;
    }

    @Override
    public SQLSequenceNoOrderOption visitNoOrderSequenceOption(NoOrderSequenceOptionContext ctx) {
        SQLSequenceNoOrderOption x = new SQLSequenceNoOrderOption();
        return x;
    }

    @Override
    public SQLSequenceKeepOption visitKeepSequenceOption(KeepSequenceOptionContext ctx) {
        SQLSequenceKeepOption x = new SQLSequenceKeepOption();
        return x;
    }

    @Override
    public SQLSequenceNoKeepOption visitNoKeepSequenceOption(NoKeepSequenceOptionContext ctx) {
        SQLSequenceNoKeepOption x = new SQLSequenceNoKeepOption();
        return x;
    }

    @Override
    public SQLScaleOption visitScaleOption(ScaleOptionContext ctx) {
        SQLScaleOption x = new SQLScaleOption();

        SQLScaleOption.SQLScaleOptionType type = SQLScaleOption.SQLScaleOptionType.EXTEND;
        if (ctx.NOEXTEND() != null) {
            type = SQLScaleOption.SQLScaleOptionType.NOEXTEND;
        }
        x.setType(type);

        return x;
    }

    @Override
    public SQLNoScaleOption visitNoScaleOption(NoScaleOptionContext ctx) {
        return new SQLNoScaleOption();
    }

    @Override
    public SQLSequenceSessionOption visitSessionSequenceOption(SessionSequenceOptionContext ctx) {
        SQLSequenceSessionOption x = new SQLSequenceSessionOption();
        return x;
    }

    @Override
    public SQLSequenceGlobalOption visitGlobalSequenceOption(GlobalSequenceOptionContext ctx) {
        SQLSequenceGlobalOption x = new SQLSequenceGlobalOption();
        return x;
    }
    // ------  Sequence End -----------------


    // ------  Synonym Start -----------------
    @Override
    public SQLCreateSynonymStatement visitCreateSynonymStatement
    (OracleSQLStatementParser.CreateSynonymStatementContext ctx) {
        SQLCreateSynonymStatement x = new SQLCreateSynonymStatement(DBType.Oracle);

        OrReplaceContext orReplaceContext = ctx.orReplace();
        if (orReplaceContext != null) {
            x.setOrReplace(true);
        }


        if (orReplaceContext != null) {
            x.setOrReplace(true);
        }

        if (ctx.PUBLIC() != null) {
            x.setPublic_(true);
        }

        SQLName name = visitNameIdentifier(ctx.synonymName);
        x.setName(name);

        SQLName forName = visitNameIdentifier(ctx.forName);
        x.setForName(forName);

        return x;
    }

    @Override
    public SQLAlterSynonymStatement visitAlterSynonymStatement(AlterSynonymStatementContext ctx) {
        SQLAlterSynonymStatement x = new SQLAlterSynonymStatement(DBType.Oracle);

        if (ctx.PUBLIC() != null) {
            x.setPublic_(true);
        }

        SQLName name = visitNameIdentifier(ctx.synonymName);
        x.setName(name);

        SQLAlterSynonymStatement.SQLOption option = null;
        if (ctx.EDITIONABLE() != null) {
            option = SQLAlterSynonymStatement.SQLOption.EDITIONABLE;

        } else if (ctx.NONEDITIONABLE() != null) {
            option = SQLAlterSynonymStatement.SQLOption.NONEDITIONABLE;

        } else if (ctx.COMPILE() != null) {
            option = SQLAlterSynonymStatement.SQLOption.COMPILE;
        }
        x.setOption(option);

        return x;
    }

    @Override
    public SQLDropSynonymStatement visitDropSynonymStatement(DropSynonymStatementContext ctx) {
        SQLDropSynonymStatement x = new SQLDropSynonymStatement(DBType.Oracle);

        if (ctx.PUBLIC() != null) {
            x.setPublic_(true);
        }

        SQLName name = visitNameIdentifier(ctx.synonymName);
        x.setName(name);

        if (ctx.FORCE() != null) {
            x.setForce(true);
        }
        return x;
    }
    // ------  Synonym End -----------------


    // ------  Table Start -----------------
    @Override
    public SQLCreateTableStatement visitCreateTableStatement(OracleSQLStatementParser.CreateTableStatementContext
                                                                     ctx) {
        SQLCreateTableStatement x = new SQLCreateTableStatement(DBType.Oracle);

        TableScopeContext tableScopeContext = ctx.tableScope();
        if (tableScopeContext != null) {
            SQLTableScope tableScope = null;
            if (tableScopeContext.GLOBAL() != null) {
                tableScope = SQLTableScope.GLOBAL_TEMPORARY;
            } else if (tableScopeContext.SHARDED() != null) {
                tableScope = SQLTableScope.SHARDED;
            } else if (tableScopeContext.DUPLICATED() != null) {
                tableScope = SQLTableScope.DUPLICATED;
            }
            x.setScope(tableScope);
        }


        SQLName tableName = visitNameIdentifier(ctx.tableName);
        x.setName(tableName);

        if (ctx.sharingClause() != null) {
            SQLSharingClause sharingClause = visitSharingClause(ctx.sharingClause());
            x.setSharingClause(sharingClause);
        }

        if (ctx.ofDataType != null) {
            SQLDataType ofDataType = visitDataType(ctx.ofDataType);
            x.setOfDataType(ofDataType);
        }

        if (ctx.objectTableSubstitution() != null) {
            SQLObjectTableSubstitution objectTableSubstitution = visitObjectTableSubstitution(ctx.objectTableSubstitution());
            x.setObjectTableSubstitution(objectTableSubstitution);
        }

        for (TableElementContext tableElementContext : ctx.tableElement()) {
            SQLTableElement tableElement = (SQLTableElement) visitChildren(tableElementContext);
            x.addTableElement(tableElement);
        }

        if (ctx.collationExpr() != null) {
            SQLCollationExpr collationExpr = visitCollationExpr(ctx.collationExpr());
            x.setCollationExpr(collationExpr);
        }

        if (ctx.xmlTypeStorage() != null) {
            OracleSQLXmlTypeStorage xmlTypeStorage = (OracleSQLXmlTypeStorage) visit(ctx.xmlTypeStorage());
            // todo
          //  x.setXmlTypeStorage(xmlTypeStorage);
        }

        if (ctx.xmlSchemaSpec() != null) {
            SQLXmlSchemaSpec xmlSchemaSpec = visitXmlSchemaSpec(ctx.xmlSchemaSpec());
            x.setXmlSchemaSpec(xmlSchemaSpec);
        }

        if (ctx.xmlTypeVirtualColumns() != null) {
            visitXmlTypeVirtualColumns(ctx.xmlTypeVirtualColumns());

        }

        if (ctx.commitActionDefinition() != null) {
            SQLOnCommitActionDefinitionType commitActionDefinition = SQLOnCommitActionDefinitionType.ON_COMMIT_DROP_DEFINITION;
            if (ctx.commitActionDefinition().PRESERVE() != null) {
                commitActionDefinition = SQLOnCommitActionDefinitionType.ON_COMMIT_PRESERVE_DEFINITION;
            }
            x.setCommitActionDefinition(commitActionDefinition);
        }

        if (ctx.commitActionRows() != null) {
            SQLOnCommitActionRowsType commitActionRows = SQLOnCommitActionRowsType.ON_COMMIT_PRESERVE_ROWS;
            if (ctx.commitActionRows().DELETE() != null) {
                commitActionRows = SQLOnCommitActionRowsType.ON_COMMIT_DELETE_ROWS;
            }
            x.setCommitActionRows(commitActionRows);
        }

        if (ctx.oidClause() != null) {
            SQLOidClause oidClause = visitOidClause(ctx.oidClause());
            x.setOidClause(oidClause);
        }
        if (ctx.oidIndexClause() != null) {
            SQLOidIndexClause oidIndexClause = visitOidIndexClause(ctx.oidIndexClause());
            x.setOidIndexClause(oidIndexClause);
        }
//
        for (PhysicalPropertyContext physicalPropertyContext : ctx.physicalProperty()) {
            SQLExpr property = (SQLExpr) visitChildren(physicalPropertyContext);
            x.addProperty(property);
        }


        for (ColumnPropertyContext columnPropertyContext : ctx.columnProperty()) {
            SQLExpr property = visitColumnProperty(columnPropertyContext);
            x.addProperty(property);
        }

        if (ctx.tablePartitioningClause() != null) {
            ISQLPartitionBy partitionBy = (ISQLPartitionBy) visitChildren(ctx.tablePartitioningClause());
            x.setPartitionBy(partitionBy);
        }

        if (ctx.attributeClusteringClause() != null) {
            SQLAttributeClusteringClause attributeClusteringClause = visitAttributeClusteringClause(ctx.attributeClusteringClause());
            x.setAttributeClusteringClause(attributeClusteringClause);
        }
        if (ctx.cacheType() != null) {
            SQLCacheType cacheType = of(ctx.cacheType());
            x.setCache(cacheType);
        }
        if (ctx.parallelClause() != null) {
            ISQLParallelClause parallelClause = visitParallelClause(ctx.parallelClause());
            x.setParallelClause(parallelClause);
        }

        SQLRowDependenciesType rowDependencies = null;
        if (ctx.ROWDEPENDENCIES() != null) {
            rowDependencies = SQLRowDependenciesType.ROWDEPENDENCIES;
        } else if (ctx.NOROWDEPENDENCIES() != null) {
            rowDependencies = SQLRowDependenciesType.NOROWDEPENDENCIES;
        }
        x.setRowDependencies(rowDependencies);

        for (IEnableDisableClauseContext iEnableDisableClauseContext : ctx.iEnableDisableClause()) {
            ISQLEnableDisableClause enableDisableClause = (ISQLEnableDisableClause) visit(iEnableDisableClauseContext);
            x.addEnableDisableClause(enableDisableClause);
        }

        if (ctx.rowMovementClause() != null) {
//            ISQLFlashbackArchiveClause flashbackArchiveClause = (ISQLFlashbackArchiveClause)visit(ctx.iFlashbackArchiveClause());
//            x.setRowMovementClause(flashbackArchiveClause);
        }

        if (ctx.iFlashbackArchiveClause() != null) {
            ISQLFlashbackArchiveClause flashbackArchiveClause = (ISQLFlashbackArchiveClause) visit(ctx.iFlashbackArchiveClause());
            x.setFlashbackArchiveClause(flashbackArchiveClause);
        }

        if (ctx.ROW() != null
                && ctx.ARCHIVAL() != null) {
            x.setRowArchival(true);
        }

        if (ctx.withTable != null) {
            SQLExpr withTable = visitExpr(ctx.withTable);
            x.setForExchangeWithTableClause(SQLForExchangeWithTableClause.of(withTable));
        }

        if (ctx.iSelectQuery() != null) {
            x.setAs(true);
            ISQLSelectQuery subQuery = visitISelectQuery(ctx.iSelectQuery());
            x.setSubQuery(subQuery);
        }

        if (ctx.memoptimizeForRead() != null) {
            x.setMemOptimizeForRead(true);
        }

        if (ctx.parent != null) {
            SQLName parentTable = visitNameIdentifier(ctx.parent);
            x.setParentTable(parentTable);
        }

        return x;
    }

    @Override
    public SQLAlterTableStatement visitAlterTableStatement(OracleSQLStatementParser.AlterTableStatementContext ctx) {
        SQLAlterTableStatement x = new SQLAlterTableStatement(DBType.Oracle);

        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        SQLObjectNameTableReference tableReference = new SQLObjectNameTableReference(name);
        x.setTableReference(tableReference);

        for (AlterTableItemContext alterTableItemContext : ctx.alterTableItem()) {
            SQLExpr item = (SQLExpr) visit(alterTableItemContext);
            x.addItem(item);
        }

        return x;
    }

    @Override
    public SQLDropTableStatement visitDropTableStatement(OracleSQLStatementParser.DropTableStatementContext ctx) {
        SQLDropTableStatement x = new SQLDropTableStatement(DBType.Oracle);
        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.addName(name);

        if (ctx.CASCADE() != null
                && ctx.CONSTRAINTS() != null) {
            x.setDropBehavior(SQLCascadeType.CASCADE_CONSTRAINTS);
        }

        if (ctx.PURGE() != null) {
            x.setPurge(true);
        }
        return x;
    }

    @Override
    public SQLTruncateTableStatement visitTruncateTableStatement(TruncateTableStatementContext ctx) {
        SQLTruncateTableStatement x = new SQLTruncateTableStatement(DBType.Oracle);

        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.addName(name);

        SQLTruncateTableStatement.SQLMaterializedViewLogType materializedViewLog = null;
        if (ctx.PRESERVE() != null) {
            materializedViewLog = SQLTruncateTableStatement.SQLMaterializedViewLogType.PRESERVE_MATERIALIZED_VIEW_LOG;
        } else if (ctx.PURGE() != null) {
            materializedViewLog = SQLTruncateTableStatement.SQLMaterializedViewLogType.PURGE_MATERIALIZED_VIEW_LOG;
        }
        x.setMaterializedViewLog(materializedViewLog);


        SQLTruncateTableStatement.SQLStorageType storage = null;
        if (ctx.DROP() != null) {
            storage = SQLTruncateTableStatement.SQLStorageType.DROP_STORAGE;
            if (ctx.ALL() != null) {
                storage = SQLTruncateTableStatement.SQLStorageType.DROP_ALL_STORAGE;
            }
        } else if (ctx.REUSE() != null) {
            storage = SQLTruncateTableStatement.SQLStorageType.REUSE_STORAGE;
        }
        x.setStorage(storage);


        if (ctx.CASCADE() != null) {
            x.setCascade(SQLCascadeType.CASCADE);
        }

        return x;
    }

    @Override
    public ISQLColumnDefinition visitIColumnDefinition(IColumnDefinitionContext ctx) {
        return (ISQLColumnDefinition) visitChildren(ctx);
    }

    @Override
    public SQLColumnDefinition visitColumnDefinition(ColumnDefinitionContext ctx) {
        SQLColumnDefinition x = new SQLColumnDefinition();
        SQLName name = visitNameIdentifier(ctx.columnName);
        x.setName(name);

        if (ctx.dataType() != null) {
            SQLDataType dataType = visitDataType(ctx.dataType());
            x.setDataType(dataType);
        }

        if (ctx.collateExpr() != null) {
            SQLCollateOptionExpr collateClause = visitCollateExpr(ctx.collateExpr());
            x.setCollateClause(collateClause);
        }

        if (ctx.SORT() != null) {
            x.setSort(true);
        }

        if (ctx.visibleType() != null) {
            SQLVisibleType visible = of(ctx.visibleType());
            x.setVisible(visible);
        }

        if (ctx.columnDefinitionDefaultValue() != null) {
            SQLExpr defaultExpr = (SQLExpr) visitChildren(ctx.columnDefinitionDefaultValue());
            x.setDefaultExpr(defaultExpr);
        }

        if (ctx.encryptClause() != null) {
            SQLEncryptClause encryptClause = visitEncryptClause(ctx.encryptClause());
            x.setCryptClause(encryptClause);
        } else if (ctx.decryptClause() != null) {
            x.setCryptClause(new SQLDecryptClause());
        }

        for (ColumnConstraintContext columnConstraintContext : ctx.columnConstraint()) {
            ISQLColumnConstraint columnConstraint = (ISQLColumnConstraint) visit(columnConstraintContext);
            x.addColumnConstraint(columnConstraint);
        }
        return x;
    }

    @Override
    public SQLIdentityClause visitIdentityClause(IdentityClauseContext ctx) {
        SQLIdentityClause x = new SQLIdentityClause();

        SQLIdentityClause.IdentityAction action = null;
        if (ctx.ALWAYS() != null) {
            action = SQLIdentityClause.IdentityAction.ALWAYS;
        } else if (ctx.BY() != null
                && ctx.DEFAULT() != null) {
            action = SQLIdentityClause.IdentityAction.BY_DEFAULT;
            if (ctx.onNull() != null) {
                action = SQLIdentityClause.IdentityAction.BY_DEFAULT_ON_NULL;
            }
        }
        x.setAction(action);

        for (IdentityOptionContext identityOptionContext : ctx.identityOption()) {
            SQLIdentityOption option = visitIdentityOption(identityOptionContext);
            x.addOption(option);
        }

        return x;
    }

    @Override
    public SQLIdentityOption visitIdentityOption(IdentityOptionContext ctx) {
        return (SQLIdentityOption) super.visitChildren(ctx);
    }

    @Override
    public SQLIdentityStartWithOption visitIdentityStartWithOption(IdentityStartWithOptionContext ctx) {
        SQLIdentityStartWithOption x = new SQLIdentityStartWithOption();

        SQLExpr value = SQLReserved.LIMIT_VALUE.ofExpr();
        if (ctx.expr() != null) {
            value = visitExpr(ctx.expr());
        }
        x.setValue(value);

        return x;
    }

    @Override
    public SQLIdentityIncrementByOption visitIdentityIncrementByOption(IdentityIncrementByOptionContext ctx) {
        SQLIdentityIncrementByOption x = new SQLIdentityIncrementByOption();
        SQLExpr value = visitExpr(ctx.expr());
        x.setValue(value);
        return x;
    }

    @Override
    public SQLIdentityMaxValueOption visitIdentityMaxValueOption(IdentityMaxValueOptionContext ctx) {
        SQLIdentityMaxValueOption x = new SQLIdentityMaxValueOption();
        SQLExpr value = visitExpr(ctx.expr());
        x.setValue(value);
        return x;
    }

    @Override
    public SQLIdentityNoMaxValueOption visitIdentityNoMaxValueOption(IdentityNoMaxValueOptionContext ctx) {
        SQLIdentityNoMaxValueOption x = new SQLIdentityNoMaxValueOption();
        return x;
    }

    @Override
    public SQLIdentityMinValueOption visitIdentityMinValueOption(IdentityMinValueOptionContext ctx) {
        SQLIdentityMinValueOption x = new SQLIdentityMinValueOption();
        SQLExpr value = visitExpr(ctx.expr());
        x.setValue(value);
        return x;
    }

    @Override
    public SQLIdentityNoMinValueOption visitIdentityNoMinValueOption(IdentityNoMinValueOptionContext ctx) {
        SQLIdentityNoMinValueOption x = new SQLIdentityNoMinValueOption();
        return x;
    }

    @Override
    public SQLIdentityCycleOption visitIdentityCycleOption(IdentityCycleOptionContext ctx) {
        SQLIdentityCycleOption x = new SQLIdentityCycleOption();
        return x;
    }

    @Override
    public SQLIdentityNoCycleOption visitIdentityNoCycleOption(IdentityNoCycleOptionContext ctx) {
        SQLIdentityNoCycleOption x = new SQLIdentityNoCycleOption();
        return x;
    }

    @Override
    public SQLIdentityCacheOption visitIdentityCacheOption(IdentityCacheOptionContext ctx) {
        SQLIdentityCacheOption x = new SQLIdentityCacheOption();
        SQLExpr value = visitExpr(ctx.expr());
        x.setValue(value);
        return x;
    }

    @Override
    public SQLIdentityNoCacheOption visitIdentityNoCacheOption(IdentityNoCacheOptionContext ctx) {
        SQLIdentityNoCacheOption x = new SQLIdentityNoCacheOption();
        return x;
    }

    @Override
    public SQLIdentityOrderOption visitIdentityOrderOption(IdentityOrderOptionContext ctx) {
        SQLIdentityOrderOption x = new SQLIdentityOrderOption();
        return x;
    }

    @Override
    public SQLIdentityNoOrderOption visitIdentityNoOrderOption(IdentityNoOrderOptionContext ctx) {
        SQLIdentityNoOrderOption x = new SQLIdentityNoOrderOption();
        return x;
    }

    @Override
    public SQLVirtualColumnDefinition visitVirtualColumnDefinition(VirtualColumnDefinitionContext ctx) {
        SQLVirtualColumnDefinition x = new SQLVirtualColumnDefinition();

        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setColumn(name);

        if (ctx.dataType() != null) {
            SQLDataType dataType = visitDataType(ctx.dataType());
            x.setDataType(dataType);
        }

        if (ctx.collateExpr() != null) {
            SQLCollateOptionExpr collateOptionExpr = visitCollateExpr(ctx.collateExpr());
            x.setCollateClause(collateOptionExpr);
        }

        if (ctx.visibleType() != null) {
            SQLVisibleType visibleType = of(ctx.visibleType());
            x.setVisible(visibleType);
        }

        if (ctx.GENERATED() != null
                && ctx.ALWAYS() != null) {
            x.setGeneratedAlways(true);
        }

        SQLExpr expr = visitExpr(ctx.expr());
        x.setExpr(expr);

        if (ctx.VIRTUAL() != null) {
            x.setVirtual(SQLVirtualType.VIRTUAL);
        }

        if (ctx.evaluationEditionClause() != null) {
            SQLEvaluationEditionClause evaluationEditionClause = visitEvaluationEditionClause(ctx.evaluationEditionClause());
            x.setEvaluationEditionClause(evaluationEditionClause);
        }

        if (ctx.unusableEditionsClause() != null) {
            SQLUnusableEditionsClause unusableEditionsClause = visitUnusableEditionsClause(ctx.unusableEditionsClause());
            x.setUnusableEditionsClause(unusableEditionsClause);
        }

        for (ColumnConstraintContext columnConstraintContext : ctx.columnConstraint()) {
            ISQLColumnConstraint columnConstraint = (ISQLColumnConstraint) visit(columnConstraintContext);
            x.addColumnConstraint(columnConstraint);
        }

        return x;
    }

    @Override
    public SQLEvaluationEditionClause visitEvaluationEditionClause(EvaluationEditionClauseContext ctx) {
        SQLEvaluationEditionClause x = new SQLEvaluationEditionClause();
        SQLExpr action = (SQLExpr) visit(ctx.evaluationEditionAction());
        x.setAction(action);
        return x;
    }

    @Override
    public SQLEvaluationEditionClause.SQLCurrentEditionAction visitEvaluationEditionCurrentEditionAction
            (EvaluationEditionCurrentEditionActionContext ctx) {
        return new SQLEvaluationEditionClause.SQLCurrentEditionAction();
    }

    @Override
    public SQLEvaluationEditionClause.SQLEditionAction visitEvaluationEditionEditionAction
            (EvaluationEditionEditionActionContext ctx) {
        SQLEvaluationEditionClause.SQLEditionAction x = new SQLEvaluationEditionClause.SQLEditionAction();
        SQLExpr edition = visitExpr(ctx.expr());
        x.setEdition(edition);
        return x;
    }

    @Override
    public SQLEvaluationEditionClause.SQLNullEditionAction visitEvaluationEditionNullEditionAction
            (EvaluationEditionNullEditionActionContext ctx) {
        return new SQLEvaluationEditionClause.SQLNullEditionAction();
    }

    @Override
    public SQLUnusableEditionsClause visitUnusableEditionsClause(UnusableEditionsClauseContext ctx) {
        if (ctx.unusableBeforeAction() == null
                || ctx.unusableBeginningWithAction() == null) {
            return null;
        }

        SQLUnusableEditionsClause x = new SQLUnusableEditionsClause();

        if (ctx.unusableBeforeAction() != null) {
            SQLExpr unusableBeforeAction = (SQLExpr) visit(ctx.unusableBeforeAction());
            x.setUnusableBeforeAction(unusableBeforeAction);
        }

        if (ctx.unusableBeginningWithAction() != null) {
            SQLExpr unusableBeginningWithAction = (SQLExpr) visit(ctx.unusableBeforeAction());
            x.setUnusableBeginningWithAction(unusableBeginningWithAction);
        }
        return x;
    }

    @Override
    public SQLUnusableEditionsClause.SQLUnusableBeforeCurrentEditionAction visitUnusableBeforeCurrentEditionAction
            (UnusableBeforeCurrentEditionActionContext ctx) {
        return new SQLUnusableEditionsClause.SQLUnusableBeforeCurrentEditionAction();
    }

    @Override
    public SQLUnusableEditionsClause.SQLUnusableBeforeEditionAction visitUnusableBeforeEditionAction
            (UnusableBeforeEditionActionContext ctx) {
        SQLUnusableEditionsClause.SQLUnusableBeforeEditionAction x = new SQLUnusableEditionsClause.SQLUnusableBeforeEditionAction();
        SQLExpr expr = visitExpr(ctx.expr());
        x.setExpr(expr);
        return x;
    }

    @Override
    public SQLUnusableEditionsClause.SQLUnusableBeginningWithCurrentEditionAction visitUnusableBeginningWithCurrentEditionAction
            (UnusableBeginningWithCurrentEditionActionContext ctx) {
        return new SQLUnusableEditionsClause.SQLUnusableBeginningWithCurrentEditionAction();
    }

    @Override
    public SQLUnusableEditionsClause.SQLUnusableBeginningWithEditionAction visitUnusableBeginningWithEditionAction
            (UnusableBeginningWithEditionActionContext ctx) {
        SQLUnusableEditionsClause.SQLUnusableBeginningWithEditionAction x = new SQLUnusableEditionsClause.SQLUnusableBeginningWithEditionAction();
        SQLExpr expr = visitExpr(ctx.expr());
        x.setExpr(expr);
        return x;
    }

    @Override
    public SQLUnusableEditionsClause.SQLUnusableBeginningWithNullEditionAction visitUnusableBeginningWithNullEditionAction
            (UnusableBeginningWithNullEditionActionContext ctx) {
        return new SQLUnusableEditionsClause.SQLUnusableBeginningWithNullEditionAction();
    }

    @Override
    public OracleSQLPeriodDefinition visitPeriodDefinition(PeriodDefinitionContext ctx) {
        OracleSQLPeriodDefinition x = new OracleSQLPeriodDefinition();

        if (ctx.validTimeColumn != null) {
            SQLName validTimeColumn = visitNameIdentifier(ctx.validTimeColumn);
            x.setValidTimeColumn(validTimeColumn);
        }

        if (ctx.startTimeColumn != null) {
            SQLName startTimeColumn = visitNameIdentifier(ctx.startTimeColumn);
            x.setStartTimeColumn(startTimeColumn);
        }

        if (ctx.endTimeColumn != null) {
            SQLName endTimeColumn = visitNameIdentifier(ctx.endTimeColumn);
            x.setEndTimeColumn(endTimeColumn);
        }
        return x;
    }

    @Override
    public SQLEncryptClause visitEncryptClause(EncryptClauseContext ctx) {
        SQLEncryptClause x = new SQLEncryptClause();

        if (ctx.encryptionSpec() != null) {
            SQLEncryptionSpec encryptionSpec = visitEncryptionSpec(ctx.encryptionSpec());
            x.setEncryptionSpec(encryptionSpec);
        }
        return x;
    }

    @Override
    public SQLEncryptionSpec visitEncryptionSpec(EncryptionSpecContext ctx) {
        if (ctx.encrypt == null
                && ctx.password == null
                && ctx.integrity == null
                && ctx.SALT() == null) {
            return null;
        }

        SQLEncryptionSpec x = new SQLEncryptionSpec();

        if (ctx.encrypt != null) {
            SQLExpr encrypt = visitExpr(ctx.encrypt);
            x.setEncrypt(encrypt);
        }

        if (ctx.password != null) {
            SQLExpr password = visitExpr(ctx.password);
            x.setPassword(password);
        }

        if (ctx.integrity != null) {
            SQLExpr integrity = visitExpr(ctx.integrity);
            x.setIntegrity(integrity);
        }

        if (ctx.SALT() != null) {
            SQLEncryptionSpec.SQLSaltType saltType = SQLEncryptionSpec.SQLSaltType.SALT;
            if (ctx.NO() != null) {
                saltType = SQLEncryptionSpec.SQLSaltType.NO_SALT;
            }
            x.setSaltType(saltType);
        }
        return x;
    }

    @Override
    public SQLObjectTableSubstitution visitObjectTableSubstitution(ObjectTableSubstitutionContext ctx) {
        SQLObjectTableSubstitution x = new SQLObjectTableSubstitution();
        if (ctx.NOT() != null) {
            x.setNot(true);
        }
        return x;
    }

    @Override
    public SQLObject visitCommitActionRows(CommitActionRowsContext ctx) {
        return super.visitCommitActionRows(ctx);
    }

    @Override
    public SQLOidClause visitOidClause(OidClauseContext ctx) {
        if (ctx == null) {
            return null;
        }
        SQLOidClause x = new SQLOidClause();
        SQLOidClause.SQLType type = SQLOidClause.SQLType.SYSTEM_GENERATED;
        if (ctx.PRIMARY() != null
                && ctx.KEY() != null) {
            type = SQLOidClause.SQLType.PRIMARY_KEY;
        }
        x.setType(type);
        return x;
    }

    @Override
    public SQLOidIndexClause visitOidIndexClause(OidIndexClauseContext ctx) {
        if (ctx == null) {
            return null;
        }
        SQLOidIndexClause x = new SQLOidIndexClause();
        SQLName name = visitNameIdentifier(ctx.index);
        x.setName(name);

        for (OidIndexClauseItemContext oidIndexClauseItemContext : ctx.oidIndexClauseItem()) {
            SQLExpr item = (SQLExpr) visitChildren(oidIndexClauseItemContext);
            x.addItem(item);
        }
        return x;
    }

    @Override
    public SQLMaterializedViewPropertyCacheClause visitMaterializedViewPropertyCacheClause
            (MaterializedViewPropertyCacheClauseContext ctx) {
        return new SQLMaterializedViewPropertyCacheClause();
    }

    @Override
    public SQLMaterializedViewPropertyNoCacheClause visitMaterializedViewPropertyNoCacheClause
            (MaterializedViewPropertyNoCacheClauseContext ctx) {
        return new SQLMaterializedViewPropertyNoCacheClause();
    }

    @Override
    public OracleSQLHeapOrgTableClause visitHeapOrgTableClause(HeapOrgTableClauseContext ctx) {
        if (ctx.tableCompression() == null
                && ctx.inMemoryTableClause() == null
                && ctx.ilmClause() == null) {
            return null;
        }

        OracleSQLHeapOrgTableClause x = new OracleSQLHeapOrgTableClause();

        if (ctx.tableCompression() != null) {
            IOracleSQLTableCompression tableCompression = (IOracleSQLTableCompression) visit(ctx.tableCompression());
            x.setTableCompression(tableCompression);
        }

        if (ctx.inMemoryTableClause() != null) {
            OracleSQLInMemoryTableClause inMemoryTableClause = visitInMemoryTableClause(ctx.inMemoryTableClause());
            x.setInMemoryTableClause(inMemoryTableClause);
        }

        if (ctx.ilmClause() != null) {
            IOracleSQLIlmClause ilmClause = (IOracleSQLIlmClause) visit(ctx.ilmClause());
            x.setIlmClause(ilmClause);
        }
        return x;
    }

    @Override
    public SQLExpr visitIndexOrgTableClause(IndexOrgTableClauseContext ctx) {
        return (SQLExpr) super.visitChildren(ctx);
    }

    @Override
    public OracleSQLPctthresholdClause visitPctthresholdClause(PctthresholdClauseContext ctx) {
        OracleSQLPctthresholdClause x = new OracleSQLPctthresholdClause();
        SQLExpr value = visitExpr(ctx.expr());
        x.setValue(value);
        return x;
    }

    @Override
    public OracleSQLMappingTableClause visitMappingTableClause(MappingTableClauseContext ctx) {
        return new OracleSQLMappingTableClause();
    }

    @Override
    public OracleSQLNoMappingTableClause visitNoMappingTableClause(NoMappingTableClauseContext ctx) {
        return new OracleSQLNoMappingTableClause();
    }

    @Override
    public IOracleSQLIndexCompression visitIndexCompression(IndexCompressionContext ctx) {
        return (IOracleSQLIndexCompression) super.visitChildren(ctx);
    }

    @Override
    public OracleSQLPrefixCompression visitPrefixCompression(PrefixCompressionContext ctx) {
        OracleSQLPrefixCompression x = new OracleSQLPrefixCompression();
        if (ctx.expr() != null) {
            SQLExpr expr = visitExpr(ctx.expr());
            x.setValue(expr);
        }
        return x;
    }

    @Override
    public OracleSQLPrefixNoCompression visitPrefixNoCompression(PrefixNoCompressionContext ctx) {
        return new OracleSQLPrefixNoCompression();
    }

    @Override
    public OracleSQLAdvancedIndexCompression visitAdvancedIndexCompression(AdvancedIndexCompressionContext ctx) {
        OracleSQLAdvancedIndexCompression x = new OracleSQLAdvancedIndexCompression();

        OracleSQLAdvancedIndexCompression.AdvancedType advancedType = null;
        if (ctx.LOW() != null) {
            advancedType = OracleSQLAdvancedIndexCompression.AdvancedType.LOW;
        } else if (ctx.HIGH() != null) {
            advancedType = OracleSQLAdvancedIndexCompression.AdvancedType.HIGH;
        }
        x.setAdvancedType(advancedType);

        return x;
    }

    @Override
    public OracleSQLAdvancedIndexNoCompression visitAdvancedIndexNoCompression(AdvancedIndexNoCompressionContext
                                                                                       ctx) {
        return new OracleSQLAdvancedIndexNoCompression();
    }

    @Override
    public SQLExpr visitIndexOrgOverflowClause(IndexOrgOverflowClauseContext ctx) {
        return (SQLExpr) super.visitChildren(ctx);
    }

    @Override
    public IOracleSQLIndexOrgOverflowClause.OracleSQLIncludeClause visitIndexOrgOverflowClauseIncludingClause
            (IndexOrgOverflowClauseIncludingClauseContext ctx) {
        IOracleSQLIndexOrgOverflowClause.OracleSQLIncludeClause x = new IOracleSQLIndexOrgOverflowClause.OracleSQLIncludeClause();
        SQLExpr name = visitExpr(ctx.expr());
        x.setName(name);
        return x;
    }

    @Override
    public IOracleSQLIndexOrgOverflowClause.OracleSQLOverflowExpr visitIndexOrgOverflowClauseOverflowExpr
            (IndexOrgOverflowClauseOverflowExprContext ctx) {
        return new IOracleSQLIndexOrgOverflowClause.OracleSQLOverflowExpr();
    }

    @Override
    public OracleSQLSupplementalLogGrpClause visitSupplementalLogGrpClause(SupplementalLogGrpClauseContext ctx) {
        OracleSQLSupplementalLogGrpClause x = new OracleSQLSupplementalLogGrpClause();
        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);

        for (SupplementalLogGrpClauseItemContext supplementalLogGrpClauseItemContext : ctx.supplementalLogGrpClauseItem()) {
            OracleSQLSupplementalLogGrpClause.GroupItem item = visitSupplementalLogGrpClauseItem(supplementalLogGrpClauseItemContext);
            x.addItem(item);
        }

        if (ctx.ALWAYS() != null) {
            x.setAlways(true);
        }
        return x;
    }

    @Override
    public OracleSQLSupplementalIdKeyClause visitSupplementalIdKeyClause(SupplementalIdKeyClauseContext ctx) {
        OracleSQLSupplementalIdKeyClause x = new OracleSQLSupplementalIdKeyClause();

        for (SupplementalIdKeyClauseItemContext supplementalIdKeyClauseItemContext : ctx.supplementalIdKeyClauseItem()) {
            OracleSQLSupplementalIdKeyClause.IdKeyItem item = of(supplementalIdKeyClauseItemContext);
            x.addItem(item);
        }
        return x;
    }

    @Override
    public OracleSQLSupplementalLogGrpClause.GroupItem visitSupplementalLogGrpClauseItem
            (SupplementalLogGrpClauseItemContext ctx) {
        OracleSQLSupplementalLogGrpClause.GroupItem x = new OracleSQLSupplementalLogGrpClause.GroupItem();

        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setColumn(name);

        if (ctx.NO() != null
                && ctx.LOG() != null) {
            x.setNotLog(true);
        }
        return x;
    }


    public OracleSQLSupplementalIdKeyClause.IdKeyItem of(SupplementalIdKeyClauseItemContext ctx) {
        if (ctx == null) {
            return null;
        }
        OracleSQLSupplementalIdKeyClause.IdKeyItem x = OracleSQLSupplementalIdKeyClause.IdKeyItem.ALL;
        if (ctx.PRIMARY() != null
                && ctx.KEY() != null) {
            x = OracleSQLSupplementalIdKeyClause.IdKeyItem.PRIMARY_KEY;

        } else if (ctx.UNIQUE() != null) {
            x = OracleSQLSupplementalIdKeyClause.IdKeyItem.UNIQUE;
        } else if (ctx.FOREIGN() != null
                && ctx.KEY() != null) {
            x = OracleSQLSupplementalIdKeyClause.IdKeyItem.FOREIGN_KEY;
        }
        return x;
    }

    @Override
    public SQLColumnProperty visitColumnProperty(ColumnPropertyContext ctx) {
        return (SQLColumnProperty) super.visitChildren(ctx);
    }


    @Override
    public OracleSQLOpaqueTypeColumnProperty visitOpaqueTypeColumnProperty(OpaqueTypeColumnPropertyContext ctx) {
        OracleSQLOpaqueTypeColumnProperty x = new OracleSQLOpaqueTypeColumnProperty();
        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);

        if (ctx.varrayStorageClause() != null) {
            OracleSQLVarrayStorageClause varrayStorageClause = visitVarrayStorageClause(ctx.varrayStorageClause());
            x.setVarrayStorageClause(varrayStorageClause);
        }

        return x;
    }

    @Override
    public OracleSQLVarrayColPropertyColumnProperty visitVArrayColPropertyColumnProperty(VArrayColPropertyColumnPropertyContext ctx) {
        OracleSQLVarrayColPropertyColumnProperty x = new OracleSQLVarrayColPropertyColumnProperty();

        OracleSQLVarrayColProperty varrayColProperty = visitVarrayColProperty(ctx.varrayColProperty());
        x.setVarrayColProperty(varrayColProperty);

        for (LobPartitionStorageContext lobPartitionStorageContext : ctx.lobPartitionStorage()) {
            OracleSQLLobPartitionStorage lobPartitionStorage = visitLobPartitionStorage(lobPartitionStorageContext);
            x.addLobPartitionStorage(lobPartitionStorage);
        }

        return x;
    }

    @Override
    public OracleSQLLobStorageClauseColumnProperty visitLobStorageClauseColumnProperty(LobStorageClauseColumnPropertyContext ctx) {
        OracleSQLLobStorageClauseColumnProperty x = new OracleSQLLobStorageClauseColumnProperty();

        OracleSQLLobStorageClause lobStorageClause = visitLobStorageClause(ctx.lobStorageClause());
        x.setLobStorageClause(lobStorageClause);

        for (LobPartitionStorageContext lobPartitionStorageContext : ctx.lobPartitionStorage()) {
            OracleSQLLobPartitionStorage lobPartitionStorage = visitLobPartitionStorage(lobPartitionStorageContext);
            x.addLobPartitionStorage(lobPartitionStorage);
        }
        return x;
    }

    @Override
    public OracleSQLObjectTypeColProperty visitObjectTypeColProperty(ObjectTypeColPropertyContext ctx) {
        OracleSQLObjectTypeColProperty x = new OracleSQLObjectTypeColProperty();

        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setColumn(name);

        IOracleSQLSubstitutableColumnClause substitutableColumnClause = (IOracleSQLSubstitutableColumnClause) visit(ctx.substitutableColumnClause());
        x.setSubstitutableColumnClause(substitutableColumnClause);

        return x;
    }

    @Override
    public SQLBuildClause visitBuildClause(BuildClauseContext ctx) {
        SQLBuildClause x = new SQLBuildClause();
        SQLBuildClause.SQLBuildType type = SQLBuildClause.SQLBuildType.IMMEDIATE;
        if (ctx.DEFERRED() != null) {
            type = SQLBuildClause.SQLBuildType.DEFERRED;
        }
        x.setType(type);
        return x;
    }


    @Override
    public SQLAttributeClusteringClause visitAttributeClusteringClause(AttributeClusteringClauseContext ctx) {
        if (ctx == null) {
            return null;
        }
        SQLAttributeClusteringClause x = new SQLAttributeClusteringClause();
        if (ctx.clusteringJoin() != null) {
            SQLAttributeClusteringClause.SQLClusteringJoin clusteringJoin = visitClusteringJoin(ctx.clusteringJoin());
            x.setClusteringJoin(clusteringJoin);
        }

        SQLAttributeClusteringClause.SQLClusterClause clusterClause = visitClusterClause(ctx.clusterClause());
        x.setClusterClause(clusterClause);

        if (ctx.clusteringWhen() != null) {
            SQLAttributeClusteringClause.SQLClusteringWhen clusteringWhen = visitClusteringWhen(ctx.clusteringWhen());
            x.setClusteringWhen(clusteringWhen);
        }

        if (ctx.zonemapClause() != null) {
            SQLAttributeClusteringClause.SQLZoneMapClause zoneMapClause = (SQLAttributeClusteringClause.SQLZoneMapClause) visit(ctx.zonemapClause());
            x.setZoneMapClause(zoneMapClause);
        }
        return x;
    }


    @Override
    public SQLAttributeClusteringClause.SQLClusteringJoin visitClusteringJoin(ClusteringJoinContext ctx) {
        SQLAttributeClusteringClause.SQLClusteringJoin x = new SQLAttributeClusteringClause.SQLClusteringJoin();
        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);

        for (ClusteringJoinItemContext clusteringJoinItemContext : ctx.clusteringJoinItem()) {
            SQLAttributeClusteringClause.SQLClusteringJoinItem item = visitClusteringJoinItem(clusteringJoinItemContext);
            x.addItem(item);
        }
        return x;
    }

    @Override
    public SQLAttributeClusteringClause.SQLClusteringJoinItem visitClusteringJoinItem(ClusteringJoinItemContext ctx) {
        SQLAttributeClusteringClause.SQLClusteringJoinItem x = new SQLAttributeClusteringClause.SQLClusteringJoinItem();

        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);

        SQLExpr condition = visitExpr(ctx.expr());
        x.setCondition(condition);
        return x;
    }

    @Override
    public SQLAttributeClusteringClause.SQLClusterClause visitClusterClause(ClusterClauseContext ctx) {
        SQLAttributeClusteringClause.SQLClusterClause x = new SQLAttributeClusteringClause.SQLClusterClause();

        SQLAttributeClusteringClause.SQLLinearType linear = null;
        if (ctx.LINEAR() != null) {
            linear = SQLAttributeClusteringClause.SQLLinearType.LINEAR;
        } else if (ctx.INTERLEAVED() != null) {
            linear = SQLAttributeClusteringClause.SQLLinearType.INTERLEAVED;
        }
        x.setLinear(linear);

        for (ExprContext exprContext : ctx.expr()) {
            SQLExpr column = visitExpr(exprContext);
            x.addColumn(column);
        }
        return x;
    }

    @Override
    public SQLAttributeClusteringClause.SQLClusteringWhen visitClusteringWhen(ClusteringWhenContext ctx) {
        if (ctx.onLoad == null
                && ctx.onDataMovement == null) {
            return null;
        }
        SQLAttributeClusteringClause.SQLClusteringWhen x = new SQLAttributeClusteringClause.SQLClusteringWhen();
        if (ctx.onLoad != null) {
            SQLYesType onLoad = of(ctx.onLoad);
            x.setOnLoad(onLoad);
        }

        if (ctx.onDataMovement != null) {
            SQLYesType onDataMovement = of(ctx.onDataMovement);
            x.setOnDataMovement(onDataMovement);
        }

        return x;
    }

    @Override
    public SQLAttributeClusteringClause.SQLWithMaterializedZoneMapClause visitWithMaterializedZonemapClause(WithMaterializedZonemapClauseContext ctx) {
        SQLAttributeClusteringClause.SQLWithMaterializedZoneMapClause x = new SQLAttributeClusteringClause.SQLWithMaterializedZoneMapClause();

        if (ctx.nameIdentifier() != null) {
            SQLName name = visitNameIdentifier(ctx.nameIdentifier());
            x.setName(name);
        }

        return x;
    }

    @Override
    public SQLAttributeClusteringClause.SQLWithoutMaterializedZoneMapClause visitWithoutMaterializedZonemapClause(WithoutMaterializedZonemapClauseContext ctx) {
        return new SQLAttributeClusteringClause.SQLWithoutMaterializedZoneMapClause();
    }

    @Override
    public SQLExpr visitAlterTableItem(AlterTableItemContext ctx) {
        return (SQLExpr) super.visitAlterTableItem(ctx);
    }

    @Override
    public SQLObject visitAlterTableEnableDisable(AlterTableEnableDisableContext ctx) {
        return super.visitAlterTableEnableDisable(ctx);
    }

    @Override
    public SQLObject visitAlterTableProerty(AlterTableProertyContext ctx) {
        return super.visitAlterTableProerty(ctx);
    }

    @Override
    public SQLAlterTableReadOnlyAction visitAlterTableReadOnlyAction(AlterTableReadOnlyActionContext ctx) {
        return new SQLAlterTableReadOnlyAction();
    }

    @Override
    public SQLAlterTableReadWriteAction visitAlterTableReadWriteAction(AlterTableReadWriteActionContext ctx) {
        return new SQLAlterTableReadWriteAction();
    }

    @Override
    public OracleSQLAlterTableAddSupplementalLogAction visitAlterTableAddSupplementalLoggingAction(AlterTableAddSupplementalLoggingActionContext ctx) {
        OracleSQLAlterTableAddSupplementalLogAction x = new OracleSQLAlterTableAddSupplementalLogAction();
        for (ISupplementalLogContext iSupplementalLogContext : ctx.iSupplementalLog()) {
            IOracleSQLSupplementLog item = (IOracleSQLSupplementLog) visit(iSupplementalLogContext);
            x.addItem(item);
        }

        return x;
    }

    @Override
    public OracleSQLAlterTableDropSupplementalLogAction visitIAlterTableDropSupplementalLoggingAction(IAlterTableDropSupplementalLoggingActionContext ctx) {
        OracleSQLAlterTableDropSupplementalLogAction x = new OracleSQLAlterTableDropSupplementalLogAction();
        for (ISupplementalLogContext iSupplementalLogContext : ctx.iSupplementalLog()) {
            IOracleSQLSupplementLog item = (IOracleSQLSupplementLog) visit(iSupplementalLogContext);
            x.addItem(item);
        }
        return x;
    }

    @Override
    public SQLAlterTableUpgradeTableAction visitAlterTableUpgradeTableAction(AlterTableUpgradeTableActionContext ctx) {
        SQLAlterTableUpgradeTableAction x = new SQLAlterTableUpgradeTableAction();

        if (ctx.INCLUDING() != null
                && ctx.DATA() != null) {
            SQLAlterTableUpgradeTableAction.SQLOption option = SQLAlterTableUpgradeTableAction.SQLOption.INCLUDING_DATA;
            if (ctx.NOT() != null) {
                option = SQLAlterTableUpgradeTableAction.SQLOption.NOT_INCLUDING_DATA;
            }
            x.setOption(option);
        }

        for (ColumnPropertyContext columnPropertyContext : ctx.columnProperty()) {
            SQLExpr property = (SQLExpr) visit(columnPropertyContext);
            x.addProperty(property);
        }
        return x;
    }

    @Override
    public SQLObject visitRecords_per_block_clause(Records_per_block_clauseContext ctx) {
        return super.visitRecords_per_block_clause(ctx);
    }

    @Override
    public SQLObject visitRowMovementClause(RowMovementClauseContext ctx) {
        return super.visitRowMovementClause(ctx);
    }

    @Override
    public SQLAlterTableRenameTableAction visitAlterTableRenameTableAction(AlterTableRenameTableActionContext ctx) {
        SQLAlterTableRenameTableAction x = new SQLAlterTableRenameTableAction();

        SQLName name = visitNameIdentifier(ctx.name);
        x.setName(name);

        SQLName newName = visitNameIdentifier(ctx.newName);
        x.setNewName(newName);
        return x;
    }

    @Override
    public ISQLAlterTableIotAction visitAlterTableIotAction(AlterTableIotActionContext ctx) {
        return (ISQLAlterTableIotAction) super.visitChildren(ctx);
    }

    @Override
    public ISQLAlterTableIotAction.SQLAlterTableCoalesceIotAction visitAlterTableCoalesceIotAction(AlterTableCoalesceIotActionContext ctx) {
        return new ISQLAlterTableIotAction.SQLAlterTableCoalesceIotAction();
    }

    @Override
    public SQLAlterTableAlterOverflowIotAction visitAlterTableAlterOverflowIotAction(AlterTableAlterOverflowIotActionContext ctx) {
        SQLAlterTableAlterOverflowIotAction x = new SQLAlterTableAlterOverflowIotAction();
        for (AlterOverflowClauseItemContext alterOverflowClauseItemContext : ctx.alterOverflowClauseItem()) {
            SQLExpr item = (SQLExpr) visitChildren(alterOverflowClauseItemContext);
            x.addItem(item);
        }
        return x;
    }

    @Override
    public SQLAlterTableAddOverflowIotAction visitAlterTableAddOverflowIotAction(AlterTableAddOverflowIotActionContext ctx) {
        SQLAlterTableAddOverflowIotAction x = new SQLAlterTableAddOverflowIotAction();
        for (SegmentAttributesClauseContext segmentAttributesClauseContext : ctx.segmentAttributesClause()) {
            SQLExpr property = (SQLExpr) visitChildren(segmentAttributesClauseContext);
            x.addProperty(property);
        }

        for (PartitionDefinitionContext partitionDefinitionContext : ctx.partitionDefinition()) {
            SQLPartitionDefinition partition = visitPartitionDefinition(partitionDefinitionContext);
            x.addPartition(partition);
        }
        return x;
    }

    @Override
    public SQLAlterTableMappingTableIotAction visitAlterTableMappingTableIotAction(AlterTableMappingTableIotActionContext ctx) {
        SQLAlterTableMappingTableIotAction x = new SQLAlterTableMappingTableIotAction();
        SQLExpr expr = (SQLExpr) visitChildren(ctx.alterMappingTableClauseItem());
        x.setExpr(expr);
        return x;
    }


    @Override
    public SQLAlterTableAddColumnAction visitAlterTableAddColumnAction(AlterTableAddColumnActionContext ctx) {
        SQLAlterTableAddColumnAction x = new SQLAlterTableAddColumnAction();

        for (IColumnDefinitionContext iColumnDefinitionContext : ctx.iColumnDefinition()) {
            ISQLColumnDefinition column = visitIColumnDefinition(iColumnDefinitionContext);
            x.addColumn(column);
        }

        for (ColumnPropertyContext columnPropertyContext : ctx.columnProperty()) {
            SQLExpr property = visitColumnProperty(columnPropertyContext);
            x.addProperty(property);
        }

        for (PartitionDefinitionContext partitionDefinitionContext : ctx.partitionDefinition()) {
            SQLPartitionDefinition partition = visitPartitionDefinition(partitionDefinitionContext);
            x.addPartition(partition);
        }

        return x;
    }

    @Override
    public SQLAlterTableModifyColumnsAction visitAlterTableModifyColumnsAction(AlterTableModifyColumnsActionContext ctx) {
        SQLAlterTableModifyColumnsAction x = new SQLAlterTableModifyColumnsAction();
        for (IColumnDefinitionContext iColumnDefinitionContext : ctx.iColumnDefinition()) {
            ISQLColumnDefinition column = visitIColumnDefinition(iColumnDefinitionContext);
            x.addColumn(column);
        }


        return x;
    }

    @Override
    public SQLAlterTableModifyColumnAction visitAlterTableModifyColumnAction(AlterTableModifyColumnActionContext ctx) {
        SQLAlterTableModifyColumnAction x = new SQLAlterTableModifyColumnAction();

        x.setColumn_(true);

        SQLColumnDefinition column = visitColumnDefinition(ctx.columnDefinition());
        x.setColumn(column);

        SQLObjectTableSubstitution substitution = visitObjectTableSubstitution(ctx.objectTableSubstitution());
        x.setSubstitution(substitution);

        if (ctx.FORCE() != null) {
            x.setForce(true);
        }

        return x;
    }

    @Override
    public SQLAlterTableSetUnusedColumnAction visitAlterTableSetUnusedColumnAction(AlterTableSetUnusedColumnActionContext ctx) {
        SQLAlterTableSetUnusedColumnAction x = new SQLAlterTableSetUnusedColumnAction();

        if (ctx.LEFT_PAREN() != null) {
            x.setParen(true);
        }
        for (ExprContext expr : ctx.columns) {
            SQLExpr column = visitExpr(expr);
            x.addColumn(column);
        }

        for (IAlterTableDropColumnActionOptionContext iAlterTableDropColumnActionOptionContext : ctx.iAlterTableDropColumnActionOption()) {
            AbstractSQLAlterTableDropColumnAction.SQLOption option = of(iAlterTableDropColumnActionOptionContext);
            x.addOption(option);
        }

        if (ctx.ONLINE() != null) {
            x.setOnline(true);
        }
        return x;
    }

    @Override
    public SQLAlterTableDropColumnAction visitAlterTableDropColumnAction(AlterTableDropColumnActionContext ctx) {
        SQLAlterTableDropColumnAction x = new SQLAlterTableDropColumnAction();
        if (ctx.COLUMN() != null) {
            x.setColumn(true);
        }

        if (ctx.LEFT_PAREN() != null) {
            x.setParen(true);
        }
        for (ExprContext exprContext : ctx.columns) {
            SQLExpr column = visitExpr(exprContext);
            x.addName(column);
        }

        for (IAlterTableDropColumnActionOptionContext iAlterTableDropColumnActionOptionContext : ctx.iAlterTableDropColumnActionOption()) {
            AbstractSQLAlterTableDropColumnAction.SQLOption option = of(iAlterTableDropColumnActionOptionContext);
            x.addOption(option);
        }

        if (ctx.checkPoint != null) {
            SQLExpr checkPoint = visitExpr(ctx.checkPoint);
            x.setCheckPoint(checkPoint);
        }
        return x;
    }

    @Override
    public SQLAlterTableDropUnusedColumnsAction visitAlterTableDropUnusedColumnsAction(AlterTableDropUnusedColumnsActionContext ctx) {
        SQLAlterTableDropUnusedColumnsAction x = new SQLAlterTableDropUnusedColumnsAction();
        if (ctx.checkPoint != null) {
            SQLExpr checkPoint = visitExpr(ctx.checkPoint);
            x.setCheckPoint(checkPoint);
        }
        return x;
    }

    @Override
    public SQLAlterTableDropColumnsContinueAction visitAlterTableDropColumnsContinueAction(AlterTableDropColumnsContinueActionContext ctx) {
        SQLAlterTableDropColumnsContinueAction x = new SQLAlterTableDropColumnsContinueAction();
        if (ctx.checkPoint != null) {
            SQLExpr checkPoint = visitExpr(ctx.checkPoint);
            x.setCheckPoint(checkPoint);
        }
        return x;
    }

    public AbstractSQLAlterTableDropColumnAction.SQLOption of(IAlterTableDropColumnActionOptionContext ctx) {
        if (ctx == null) {
            return null;
        }
        AbstractSQLAlterTableDropColumnAction.SQLOption x = AbstractSQLAlterTableDropColumnAction.SQLOption.CASCADE_CONSTRAINTS;

        if (ctx.INVALIDATE() != null) {
            x = AbstractSQLAlterTableDropColumnAction.SQLOption.INVALIDATE;
        }

        return x;
    }

    @Override
    public OracleSQLAlterTableDropPeriodAction visitAlterTableDropPeriodAction(AlterTableDropPeriodActionContext ctx) {
        OracleSQLAlterTableDropPeriodAction x = new OracleSQLAlterTableDropPeriodAction();
        SQLExpr expr = visitExpr(ctx.expr());
        x.setPeriodDefinition(OracleSQLPeriodDefinition.of(expr));
        return x;
    }

    @Override
    public SQLAlterTableRenameColumnAction visitAlterTableRenameColumnAction(AlterTableRenameColumnActionContext ctx) {
        SQLAlterTableRenameColumnAction x = new SQLAlterTableRenameColumnAction();

        SQLName name = visitNameIdentifier(ctx.name);
        x.setName(name);
        SQLName newName = visitNameIdentifier(ctx.newName);
        x.setNewName(newName);
        return x;
    }

    @Override
    public SQLAlterTableModifyCollectionRetrievalAction visitAlterTableModifyCollectionRetrievalAction(AlterTableModifyCollectionRetrievalActionContext ctx) {
        SQLAlterTableModifyCollectionRetrievalAction x = new SQLAlterTableModifyCollectionRetrievalAction();
        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);

        SQLAlterTableModifyCollectionRetrievalAction.SQLOption option = SQLAlterTableModifyCollectionRetrievalAction.SQLOption.LOCATOR;
        if (ctx.VALUE() != null) {
            option = SQLAlterTableModifyCollectionRetrievalAction.SQLOption.VALUE;
        }
        x.setOption(option);

        return x;
    }

    @Override
    public SQLAlterTableModifyLobStorageAction visitAlterTableModifyLobStorageAction(AlterTableModifyLobStorageActionContext ctx) {
        SQLAlterTableModifyLobStorageAction x = new SQLAlterTableModifyLobStorageAction();

        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);

        for (ModifyLobParameterContext modifyLobParameterContext : ctx.modifyLobParameter()) {
            SQLExpr parameter = (SQLExpr) visitChildren(modifyLobParameterContext);
            x.addParameter(parameter);
        }

        return x;
    }

    @Override
    public SQLObject visitAlterTableAlterVarrayColPropertyAction(AlterTableAlterVarrayColPropertyActionContext ctx) {
        return super.visitAlterTableAlterVarrayColPropertyAction(ctx);
    }

    @Override
    public SQLAlterTableAddTableConstraintAction visitAlterTableAddTableConstraintAction(AlterTableAddTableConstraintActionContext ctx) {
        SQLAlterTableAddTableConstraintAction x = new SQLAlterTableAddTableConstraintAction();

        if (ctx.LEFT_PAREN() != null) {
            x.setParen(true);
        }
        for (TableConstraintContext tableConstraintContext : ctx.tableConstraint()) {
            ISQLTableConstraint tableConstraint = (ISQLTableConstraint) visit(tableConstraintContext);
            x.addConstraint(tableConstraint);
        }
        return x;
    }

    @Override
    public SQLAlterTableModifyTableConstraintAction visitAlterTableModifyTableConstraintAction(AlterTableModifyTableConstraintActionContext ctx) {
        SQLAlterTableModifyTableConstraintAction x = new SQLAlterTableModifyTableConstraintAction();
        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);
        return x;
    }

    @Override
    public SQLAlterTableModifyPrimaryKeyConstraintAction visitAlterTableModifyPrimaryKeyConstraintAction(AlterTableModifyPrimaryKeyConstraintActionContext ctx) {
        SQLAlterTableModifyPrimaryKeyConstraintAction x = new SQLAlterTableModifyPrimaryKeyConstraintAction();

        for (IConstraintStateContext iConstraintStateContext : ctx.iConstraintState()) {
            ISQLConstraintOption option = visitIConstraintState(iConstraintStateContext);
            x.addOption(option);
        }

        if (ctx.CASCADE() != null) {
            x.setCascade(true);
        }
        return x;
    }

    @Override
    public SQLAlterTableModifyUniqueConstraintAction visitAlterTableModifyUniqueConstraintAction(AlterTableModifyUniqueConstraintActionContext ctx) {
        SQLAlterTableModifyUniqueConstraintAction x = new SQLAlterTableModifyUniqueConstraintAction();

        for (ExprContext exprContext : ctx.columns) {
            SQLExpr column = visitExpr(exprContext);
            x.addColumn(column);
        }

        for (IConstraintStateContext iConstraintStateContext : ctx.iConstraintState()) {
            ISQLConstraintOption option = visitIConstraintState(iConstraintStateContext);
            x.addOption(option);
        }

        if (ctx.CASCADE() != null) {
            x.setCascade(true);
        }
        return x;
    }

    @Override
    public SQLAlterTableRenameTableConstraintAction visitAlterTableRenameTableConstraintAction(AlterTableRenameTableConstraintActionContext ctx) {
        SQLAlterTableRenameTableConstraintAction x = new SQLAlterTableRenameTableConstraintAction();

        SQLName name = visitNameIdentifier(ctx.name);
        SQLName newName = visitNameIdentifier(ctx.newName);
        x.setName(name);
        x.setNewName(newName);
        return x;
    }

    @Override
    public SQLAlterTableDropPrimaryKeyConstraintAction visitAlterTableDropPrimaryKeyConstraintAction(AlterTableDropPrimaryKeyConstraintActionContext ctx) {
        SQLAlterTableDropPrimaryKeyConstraintAction x = new SQLAlterTableDropPrimaryKeyConstraintAction();

        if (ctx.CASCADE() != null) {
            x.setCascade(SQLCascadeType.CASCADE);
        }

        SQLKeepIndexType keepIndex = of(ctx.keepIndexType());
        x.setIndex(keepIndex);

        if (ctx.ONLINE() != null) {
            x.setOnline(true);
        }
        return x;
    }

    @Override
    public SQLAlterTableDropUniqueConstraintAction visitAlterTableDropUniqueConstraintAction(AlterTableDropUniqueConstraintActionContext ctx) {
        SQLAlterTableDropUniqueConstraintAction x = new SQLAlterTableDropUniqueConstraintAction();

        for (ExprContext exprContext : ctx.expr()) {
            SQLExpr column = visitExpr(exprContext);
            x.addColumn(column);
        }
        if (ctx.CASCADE() != null) {
            x.setCascade(SQLCascadeType.CASCADE);
        }

        SQLKeepIndexType keepIndex = of(ctx.keepIndexType());
        x.setIndex(keepIndex);

        if (ctx.ONLINE() != null) {
            x.setOnline(true);
        }
        return x;
    }

    @Override
    public SQLAlterTableDropTableConstraintAction visitAlterTableDropTableConstraintAction(AlterTableDropTableConstraintActionContext ctx) {
        SQLAlterTableDropTableConstraintAction x = new SQLAlterTableDropTableConstraintAction();

        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);

        if (ctx.CASCADE() != null) {
            x.setCascade(SQLCascadeType.CASCADE);
        }
        if (ctx.ONLINE() != null) {
            x.setOnline(true);
        }
        return x;
    }

    @Override
    public SQLObject visitAlterXmlSchemaClause(AlterXmlSchemaClauseContext ctx) {

        return super.visitAlterXmlSchemaClause(ctx);
    }

    @Override
    public SQLObject visitIAlterTablePartitionAction(IAlterTablePartitionActionContext ctx) {
        return super.visitIAlterTablePartitionAction(ctx);
    }

    @Override
    public SQLObject visitAlterTablePartitionAction(AlterTablePartitionActionContext ctx) {
        return super.visitAlterTablePartitionAction(ctx);
    }

    @Override
    public SQLObject visitAlterTablePartitionActionForItem(AlterTablePartitionActionForItemContext ctx) {
        return super.visitAlterTablePartitionActionForItem(ctx);
    }

    @Override
    public SQLObject visitAlterTableModifyDefaultAttrsAction(AlterTableModifyDefaultAttrsActionContext ctx) {
        return super.visitAlterTableModifyDefaultAttrsAction(ctx);
    }

    @Override
    public SQLObject visitForPartition(ForPartitionContext ctx) {
        return super.visitForPartition(ctx);
    }

    @Override
    public SQLObject visitForPartitionFor(ForPartitionForContext ctx) {
        return super.visitForPartitionFor(ctx);
    }

    @Override
    public SQLObject visitModifyTableDefaultAttrsActionLobItem(ModifyTableDefaultAttrsActionLobItemContext ctx) {
        return super.visitModifyTableDefaultAttrsActionLobItem(ctx);
    }

    @Override
    public SQLObject visitModifyTableDefaultAttrsActionVarrayItem(ModifyTableDefaultAttrsActionVarrayItemContext ctx) {
        return super.visitModifyTableDefaultAttrsActionVarrayItem(ctx);
    }

    @Override
    public SQLAlterTableSetPartitioningAction visitAlterTableSetPartitioningAction(AlterTableSetPartitioningActionContext ctx) {
        SQLAlterTableSetPartitioningAction x = new SQLAlterTableSetPartitioningAction();

        SQLAlterTableSetPartitioningAction.SQLType setPartition = SQLAlterTableSetPartitioningAction.SQLType.AUTOMATIC;
        if (ctx.MANUAL() != null) {
            setPartition = SQLAlterTableSetPartitioningAction.SQLType.MANUAL;
        }
        x.setSetPartition(setPartition);
        return x;
    }

    @Override
    public SQLAlterTableSetStoreInAction visitAlterTableSetStoreInAction(AlterTableSetStoreInActionContext ctx) {
        SQLAlterTableSetStoreInAction x = new SQLAlterTableSetStoreInAction();

        for (ExprContext exprContext : ctx.expr()) {
            SQLExpr item = visitExpr(exprContext);
            x.addItem(item);
        }

        return x;
    }

    @Override
    public SQLAlterTableSetIntervalAction visitAlterTableSetIntervalAction(AlterTableSetIntervalActionContext ctx) {
        SQLAlterTableSetIntervalAction x = new SQLAlterTableSetIntervalAction();

        if (ctx.expr() != null) {
            SQLExpr expr = visitExpr(ctx.expr());
            x.setExpr(expr);
        }

        return x;
    }

    @Override
    public SQLAlterTableSetSubPartitionTemplateAction visitAlterTableSetSubpartitionTemplateAction(AlterTableSetSubpartitionTemplateActionContext ctx) {
        SQLAlterTableSetSubPartitionTemplateAction x = new SQLAlterTableSetSubPartitionTemplateAction();

        for (SubPartitionDefinitionContext subPartitionDefinitionContext : ctx.subPartitionDefinition()) {
            SQLSubPartitionDefinition subPartition = visitSubPartitionDefinition(subPartitionDefinitionContext);
            x.addSubPartition(subPartition);
        }


        return x;
    }

    @Override
    public SQLAlterTableModifyPartitionAction visitAlterTableModifyPartitionAction(AlterTableModifyPartitionActionContext ctx) {
        SQLAlterTableModifyPartitionAction x = new SQLAlterTableModifyPartitionAction();

        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);

        for (AlterTableModifyPartitionActionItemContext alterTableModifyPartitionActionItemContext : ctx.alterTableModifyPartitionActionItem()) {
            SQLExpr item = (SQLExpr) visitChildren(alterTableModifyPartitionActionItemContext);
            x.addItem(item);
        }
        return x;
    }

    @Override
    public SQLAlterTableModifyPartitionForAction visitAlterTableModifyPartitionForAction(AlterTableModifyPartitionForActionContext ctx) {
        SQLAlterTableModifyPartitionForAction x = new SQLAlterTableModifyPartitionForAction();

        for (NameIdentifierContext nameIdentifierContext : ctx.nameIdentifier()) {
            SQLName name = visitNameIdentifier(nameIdentifierContext);
            x.addName(name);
        }

        for (AlterTableModifyPartitionActionItemContext alterTableModifyPartitionActionItemContext : ctx.alterTableModifyPartitionActionItem()) {
            SQLExpr item = (SQLExpr) visitChildren(alterTableModifyPartitionActionItemContext);
            x.addItem(item);
        }

        return x;
    }

    @Override
    public SQLAlterTableModifySubPartitionAction visitAlterTableModifySubPartitionAction(AlterTableModifySubPartitionActionContext ctx) {
        SQLAlterTableModifySubPartitionAction x = new SQLAlterTableModifySubPartitionAction();

        for (AlterTableModifyPartitionActionItemContext alterTableModifyPartitionActionItemContext : ctx.alterTableModifyPartitionActionItem()) {
            SQLExpr item = (SQLExpr) visitChildren(alterTableModifyPartitionActionItemContext);
            x.addItem(item);
        }
        return x;
    }

    @Override
    public SQLAlterTableModifySubPartitionForAction visitAlterTableModifySubPartitionForAction(AlterTableModifySubPartitionForActionContext ctx) {
        SQLAlterTableModifySubPartitionForAction x = new SQLAlterTableModifySubPartitionForAction();

        for (NameIdentifierContext nameIdentifierContext : ctx.nameIdentifier()) {
            SQLName name = visitNameIdentifier(nameIdentifierContext);
            x.addName(name);
        }

        for (AlterTableModifyPartitionActionItemContext alterTableModifyPartitionActionItemContext : ctx.alterTableModifyPartitionActionItem()) {
            SQLExpr item = (SQLExpr) visitChildren(alterTableModifyPartitionActionItemContext);
            x.addItem(item);
        }
        return x;
    }

    @Override
    public AbstractSQLAlterTableModifyPartitionAction.SQLModifyPartitionAddValuesAction visitModifyPartitionAddValues(ModifyPartitionAddValuesContext ctx) {
        AbstractSQLAlterTableModifyPartitionAction.SQLModifyPartitionAddValuesAction x = new AbstractSQLAlterTableModifyPartitionAction.SQLModifyPartitionAddValuesAction();

        for (ExprContext exprContext : ctx.expr()) {
            SQLExpr item = visitExpr(exprContext);
            x.addItem(item);
        }
        return x;
    }

    @Override
    public AbstractSQLAlterTableModifyPartitionAction.SQLModifyPartitionDropValuesAction visitModifyPartitionDropValues(ModifyPartitionDropValuesContext ctx) {
        AbstractSQLAlterTableModifyPartitionAction.SQLModifyPartitionDropValuesAction x = new AbstractSQLAlterTableModifyPartitionAction.SQLModifyPartitionDropValuesAction();
        for (ExprContext exprContext : ctx.expr()) {
            SQLExpr item = visitExpr(exprContext);
            x.addItem(item);
        }
        return x;
    }

    @Override
    public AbstractSQLAlterTableModifyPartitionAction.SQLModifyPartitionUnusableLocalIndexesAction visitModifyPartitionUnusableLocalIndexes(ModifyPartitionUnusableLocalIndexesContext ctx) {
        AbstractSQLAlterTableModifyPartitionAction.SQLModifyPartitionUnusableLocalIndexesAction x = new AbstractSQLAlterTableModifyPartitionAction.SQLModifyPartitionUnusableLocalIndexesAction();
        if (ctx.REBUILD() != null) {
            x.setRebuild(true);
        }
        return x;
    }

    @Override
    public SQLAlterTableMovePartitionAction visitAlterTableMovePartitionAction(AlterTableMovePartitionActionContext ctx) {
        SQLAlterTableMovePartitionAction x = new SQLAlterTableMovePartitionAction();

        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);

        if (ctx.MAPPING() != null
                && ctx.TABLE() != null) {
            x.setMappingTable(true);
        }

        for (AlterTableMovePartitionActionPropertyContext alterTableMovePartitionActionPropertyContext : ctx.alterTableMovePartitionActionProperty()) {
            SQLExpr property = (SQLExpr) visitChildren(alterTableMovePartitionActionPropertyContext);
            x.addProperty(property);
        }

        if (ctx.filterCondition() != null) {
            SQLFilterCondition filterCondition = visitFilterCondition(ctx.filterCondition());
            x.setFilterCondition(filterCondition);
        }

        if (ctx.updateIndexClause() != null) {
            ISQLUpdateIndexClause updateIndexClause = visitUpdateIndexClause(ctx.updateIndexClause());
            x.setUpdateIndexClause(updateIndexClause);
        }

        if (ctx.parallelClause() != null) {
            ISQLParallelClause parallelClause = visitParallelClause(ctx.parallelClause());
            x.setParallelClause(parallelClause);
        }

        if (ctx.allowDisallowClustering() != null) {
            SQLAllowDisallowClusteringType allowDisallowClustering = of(ctx.allowDisallowClustering());
            x.setAllowDisallowClustering(allowDisallowClustering);
        }

        if (ctx.ONLINE() != null) {
            x.setOnline(true);
        }

        return x;
    }

    @Override
    public SQLAlterTableMovePartitionForAction visitAlterTableMovePartitionForAction(AlterTableMovePartitionForActionContext ctx) {
        SQLAlterTableMovePartitionForAction x = new SQLAlterTableMovePartitionForAction();

        for (NameIdentifierContext nameIdentifierContext : ctx.nameIdentifier()) {
            SQLName name = visitNameIdentifier(nameIdentifierContext);
            x.addName(name);
        }

        if (ctx.MAPPING() != null
                && ctx.TABLE() != null) {
            x.setMappingTable(true);
        }

        for (AlterTableMovePartitionActionPropertyContext alterTableMovePartitionActionPropertyContext : ctx.alterTableMovePartitionActionProperty()) {
            SQLExpr property = (SQLExpr) visitChildren(alterTableMovePartitionActionPropertyContext);
            x.addProperty(property);
        }

        if (ctx.filterCondition() != null) {
            SQLFilterCondition filterCondition = visitFilterCondition(ctx.filterCondition());
            x.setFilterCondition(filterCondition);
        }

        if (ctx.updateIndexClause() != null) {
            ISQLUpdateIndexClause updateIndexClause = visitUpdateIndexClause(ctx.updateIndexClause());
            x.setUpdateIndexClause(updateIndexClause);
        }

        if (ctx.parallelClause() != null) {
            ISQLParallelClause parallelClause = visitParallelClause(ctx.parallelClause());
            x.setParallelClause(parallelClause);
        }

        if (ctx.allowDisallowClustering() != null) {
            SQLAllowDisallowClusteringType allowDisallowClustering = of(ctx.allowDisallowClustering());
            x.setAllowDisallowClustering(allowDisallowClustering);
        }

        if (ctx.ONLINE() != null) {
            x.setOnline(true);
        }
        return x;
    }

    @Override
    public SQLFilterCondition visitFilterCondition(FilterConditionContext ctx) {
        if (ctx == null) {
            return null;
        }
        SQLFilterCondition x = new SQLFilterCondition();
        SQLWhereClause whereClause = visitWhereClause(ctx.whereClause());
        x.setWhereClause(whereClause);
        return x;
    }

    public SQLAllowDisallowClusteringType of(AllowDisallowClusteringContext ctx) {
        if (ctx == null) {
            return null;
        }
        SQLAllowDisallowClusteringType x = null;

        if (ctx.ALLOW() != null) {
            x = SQLAllowDisallowClusteringType.ALLOW_CLUSTERING;
        } else if (ctx.DISALLOW() != null) {
            x = SQLAllowDisallowClusteringType.DISALLOW_CLUSTERING;
        }

        return x;
    }

    @Override
    public SQLAlterTableMoveSubPartitionAction visitAlterTableMoveSubPartitionAction(AlterTableMoveSubPartitionActionContext ctx) {
        SQLAlterTableMoveSubPartitionAction x = new SQLAlterTableMoveSubPartitionAction();

        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);

        if (ctx.indexingClause() != null) {
            SQLIndexingOnType indexing = of(ctx.indexingClause());
            x.setIndexing(indexing);
        }

        if (ctx.partitioningStorageClause() != null) {
            visitPartitioningStorageClause(ctx.partitioningStorageClause());
        }

        if (ctx.updateIndexClause() != null) {
            ISQLUpdateIndexClause updateIndexClause = visitUpdateIndexClause(ctx.updateIndexClause());
            x.setUpdateIndex(updateIndexClause);
        }

        if (ctx.filterCondition() != null) {
            SQLFilterCondition filterCondition = visitFilterCondition(ctx.filterCondition());
            x.setFilterCondition(filterCondition);
        }

        if (ctx.parallelClause() != null) {
            ISQLParallelClause parallelClause = visitParallelClause(ctx.parallelClause());
            x.setParallel(parallelClause);
        }

        if (ctx.allowDisallowClustering() != null) {
            SQLAllowDisallowClusteringType allowDisallowClustering = of(ctx.allowDisallowClustering());
            x.setAllowDisallowClustering(allowDisallowClustering);
        }

        if (ctx.ONLINE() != null) {
            x.setOnline(true);
        }

        return x;
    }

    @Override
    public SQLAlterTableMoveSubPartitionForAction visitAlterTableMoveSubPartitionForAction(AlterTableMoveSubPartitionForActionContext ctx) {
        SQLAlterTableMoveSubPartitionForAction x = new SQLAlterTableMoveSubPartitionForAction();

        for (NameIdentifierContext nameIdentifierContext : ctx.nameIdentifier()) {
            SQLName name = visitNameIdentifier(nameIdentifierContext);
            x.addName(name);
        }

        if (ctx.indexingClause() != null) {
            SQLIndexingOnType indexing = of(ctx.indexingClause());
            x.setIndexing(indexing);
        }

        if (ctx.partitioningStorageClause() != null) {
            visitPartitioningStorageClause(ctx.partitioningStorageClause());
        }

        if (ctx.updateIndexClause() != null) {
            ISQLUpdateIndexClause updateIndexClause = visitUpdateIndexClause(ctx.updateIndexClause());
            x.setUpdateIndex(updateIndexClause);
        }

        if (ctx.filterCondition() != null) {
            SQLFilterCondition filterCondition = visitFilterCondition(ctx.filterCondition());
            x.setFilterCondition(filterCondition);
        }

        if (ctx.parallelClause() != null) {
            ISQLParallelClause parallelClause = visitParallelClause(ctx.parallelClause());
            x.setParallel(parallelClause);
        }

        if (ctx.allowDisallowClustering() != null) {
            SQLAllowDisallowClusteringType allowDisallowClustering = of(ctx.allowDisallowClustering());
            x.setAllowDisallowClustering(allowDisallowClustering);
        }

        if (ctx.ONLINE() != null) {
            x.setOnline(true);
        }

        return x;
    }

    @Override
    public SQLAlterTableAddPartitionAction visitAlterTableAddPartitionAction(AlterTableAddPartitionActionContext ctx) {
        SQLAlterTableAddPartitionAction x = new SQLAlterTableAddPartitionAction();
        for (PartitionDefinitionContext partitionDefinitionContext : ctx.partitionDefinition()) {
            SQLPartitionDefinition partition = visitPartitionDefinition(partitionDefinitionContext);
            x.addPartition(partition);
        }

        if (ctx.expr() != null) {
            SQLExpr before = visitExpr(ctx.expr());
            x.setBefore(before);
        }

        if (ctx.dependentTablesClause() != null) {
            SQLDependentTablesClause dependentTablesClause = visitDependentTablesClause(ctx.dependentTablesClause());
            x.setDependentTablesClause(dependentTablesClause);
        }
        return x;
    }

    @Override
    public AbstractSQLAlterTableModifyPartitionAction.SQLModifyPartitionAddSubPartitionAction visitModifyPartitionAddSubPartitionAction(ModifyPartitionAddSubPartitionActionContext ctx) {
        AbstractSQLAlterTableModifyPartitionAction.SQLModifyPartitionAddSubPartitionAction x = new AbstractSQLAlterTableModifyPartitionAction.SQLModifyPartitionAddSubPartitionAction();

        for (SubPartitionDefinitionContext subPartitionDefinitionContext : ctx.subPartitionDefinition()) {
            SQLSubPartitionDefinition subPartition = visitSubPartitionDefinition(subPartitionDefinitionContext);
            x.addSubSubPartition(subPartition);
        }

        if (ctx.dependentTablesClause() != null) {
            SQLDependentTablesClause dependentTables = visitDependentTablesClause(ctx.dependentTablesClause());
            x.setDependentTables(dependentTables);
        }

        if (ctx.updateIndexClause() != null) {
            ISQLUpdateIndexClause updateIndex = visitUpdateIndexClause(ctx.updateIndexClause());
            x.setUpdateIndex(updateIndex);
        }

        return x;
    }

    @Override
    public SQLDependentTablesClause visitDependentTablesClause(DependentTablesClauseContext ctx) {
        SQLDependentTablesClause x = new SQLDependentTablesClause();
        for (DependentTablesClauseItemContext dependentTablesClauseItemContext : ctx.dependentTablesClauseItem()) {
            SQLDependentTablesClause.Item item = visitDependentTablesClauseItem(dependentTablesClauseItemContext);
            x.addItem(item);
        }
        return x;
    }

    @Override
    public SQLDependentTablesClause.Item visitDependentTablesClauseItem(DependentTablesClauseItemContext ctx) {
        SQLDependentTablesClause.Item x = new SQLDependentTablesClause.Item();
        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);

        for (PartitionDefinitionContext partitionDefinitionContext : ctx.partitionDefinition()) {
            SQLPartitionDefinition partition = visitPartitionDefinition(partitionDefinitionContext);
            x.addPartition(partition);
        }
        return x;
    }

    @Override
    public SQLAlterTableCoalescePartitionAction visitAlterTableCoalesceTablePartition(AlterTableCoalesceTablePartitionContext ctx) {
        SQLAlterTableCoalescePartitionAction x = new SQLAlterTableCoalescePartitionAction();

        return x;
    }

    @Override
    public SQLCoalesceSubPartitionAction visitCoalesceTableSubpartition(CoalesceTableSubpartitionContext ctx) {
        SQLCoalesceSubPartitionAction x = new SQLCoalesceSubPartitionAction();
        return x;
    }

    @Override
    public SQLAlterTableDropPartitionAction visitAlterTableDropPartitionAction(AlterTableDropPartitionActionContext ctx) {
        SQLAlterTableDropPartitionAction x = new SQLAlterTableDropPartitionAction();

        if (ctx.PARTITIONS() != null) {
            x.setType(SQLPartitionType.PARTITIONS);
        }

        for (DropPartitionActionItemContext dropPartitionActionItemContext : ctx.dropPartitionActionItem()) {
            SQLExpr item = (SQLExpr) visit(dropPartitionActionItemContext);
            x.addItem(item);
        }
        return x;
    }

    @Override
    public SQLObject visitDropPartitionActionItem(DropPartitionActionItemContext ctx) {
        return super.visitDropPartitionActionItem(ctx);
    }

    @Override
    public SQLAlterTableDropSubPartitionAction visitAlterTableDropSubpartitionAction(AlterTableDropSubpartitionActionContext ctx) {
        SQLAlterTableDropSubPartitionAction x = new SQLAlterTableDropSubPartitionAction();

        if (ctx.SUBPARTITIONS() != null) {
            x.setType(SQLSubPartitionType.SUBPARTITIONS);
        }

//        for (DropPartitionActionItemContext dropPartitionActionItemContext : ctx.dropSubpartitionActionItem()) {
//            SQLExpr item = (SQLExpr)visit(dropPartitionActionItemContext);
//            x.addItem(item);
//        }
        return x;
    }

    @Override
    public SQLAlterTableRenamePartitionAction visitAlterTableRenamePartitionAction(AlterTableRenamePartitionActionContext ctx) {
        SQLAlterTableRenamePartitionAction x = new SQLAlterTableRenamePartitionAction();

        SQLName name = visitNameIdentifier(ctx.name);
        x.setName(name);

        SQLName newName = visitNameIdentifier(ctx.newName);
        x.setNewName(newName);
        return x;
    }

    @Override
    public SQLAlterTableRenamePartitionForAction visitAlterTableRenamePartitionForAction(AlterTableRenamePartitionForActionContext ctx) {
        SQLAlterTableRenamePartitionForAction x = new SQLAlterTableRenamePartitionForAction();

        for (NameIdentifierContext context : ctx.names) {
            SQLName name = visitNameIdentifier(context);
            x.addName(name);
        }

        SQLName newName = visitNameIdentifier(ctx.newName);
        x.setNewName(newName);
        return x;
    }

    @Override
    public SQLAlterTableRenameSubPartitionAction visitAlterTableRenameSubPartitionAction(AlterTableRenameSubPartitionActionContext ctx) {
        SQLAlterTableRenameSubPartitionAction x = new SQLAlterTableRenameSubPartitionAction();

        SQLName name = visitNameIdentifier(ctx.name);
        x.setName(name);

        SQLName newName = visitNameIdentifier(ctx.newName);
        x.setNewName(newName);
        return x;
    }

    @Override
    public SQLAlterTableRenameSubPartitionForAction visitAlterTableRenameSubPartitionForAction(AlterTableRenameSubPartitionForActionContext ctx) {
        SQLAlterTableRenameSubPartitionForAction x = new SQLAlterTableRenameSubPartitionForAction();

        for (NameIdentifierContext context : ctx.names) {
            SQLName name = visitNameIdentifier(context);
            x.addName(name);
        }

        SQLName newName = visitNameIdentifier(ctx.newName);
        x.setNewName(newName);
        return x;
    }

    @Override
    public SQLAlterTableTruncatePartitionAction visitAlterTableTruncatePartitionAction(AlterTableTruncatePartitionActionContext ctx) {
        SQLAlterTableTruncatePartitionAction x = new SQLAlterTableTruncatePartitionAction();

        if (ctx.PARTITIONS() != null) {
            x.setType(SQLPartitionType.PARTITIONS);
        }
        for (AlterTablePartitionItemContext alterTablePartitionItemContext : ctx.alterTablePartitionItem()) {
            SQLExpr item = (SQLExpr) visitChildren(alterTablePartitionItemContext);
            x.addItem(item);
        }


        AbstractSQLAlterTableTruncatePartitionAction.SQLStorageType storageType = null;
        if (ctx.STORAGE() != null) {
            if (ctx.DROP() != null) {
                storageType = AbstractSQLAlterTableTruncatePartitionAction.SQLStorageType.DROP_STORAGE;
                if (ctx.ALL() != null) {
                    storageType = AbstractSQLAlterTableTruncatePartitionAction.SQLStorageType.DROP_ALL_STORAGE;
                }
            } else if (ctx.REUSE() != null) {
                storageType = AbstractSQLAlterTableTruncatePartitionAction.SQLStorageType.REUSE_STORAGE;
            }
        }
        x.setStorageType(storageType);

        if (ctx.updateIndexClause() != null) {
            ISQLUpdateIndexClause updateIndexClause = visitUpdateIndexClause(ctx.updateIndexClause());
            x.setUpdateIndexClause(updateIndexClause);
        }

        if (ctx.parallelClause() != null) {
            ISQLParallelClause parallelClause = visitParallelClause(ctx.parallelClause());
            x.setParallelClause(parallelClause);
        }

        if (ctx.CASCADE() != null) {
            x.setCascade(true);
        }

        return x;
    }

    @Override
    public SQLAlterTableTruncateSubPartitionAction visitAlterTableTruncateSubPartitionAction(AlterTableTruncateSubPartitionActionContext ctx) {
        SQLAlterTableTruncateSubPartitionAction x = new SQLAlterTableTruncateSubPartitionAction();

        if (ctx.SUBPARTITIONS() != null) {
            x.setType(SQLSubPartitionType.SUBPARTITIONS);
        }

        for (AlterTablePartitionItemContext alterTablePartitionItemContext : ctx.alterTablePartitionItem()) {
            SQLExpr item = (SQLExpr) visitChildren(alterTablePartitionItemContext);
            x.addItem(item);
        }

        if (ctx.updateIndexClause() != null) {
            ISQLUpdateIndexClause updateIndexClause = visitUpdateIndexClause(ctx.updateIndexClause());
            x.setUpdateIndexClause(updateIndexClause);
        }

        if (ctx.parallelClause() != null) {
            ISQLParallelClause parallelClause = visitParallelClause(ctx.parallelClause());
            x.setParallelClause(parallelClause);
        }

        if (ctx.CASCADE() != null) {
            x.setCascade(true);
        }
        return x;
    }

    @Override
    public SQLObject visitAlterTablePartitionItem(AlterTablePartitionItemContext ctx) {
        return super.visitAlterTablePartitionItem(ctx);
    }

    @Override
    public SQLAlterTableSplitPartitionAction visitAlterTableSplitPartitionAction(AlterTableSplitPartitionActionContext ctx) {
        SQLAlterTableSplitPartitionAction x = new SQLAlterTableSplitPartitionAction();

        SQLName name = visitNameIdentifier(ctx.name);
        x.setName(name);

        AbstractSQLAlterTableSplitPartitionAction.SQLItem item = (AbstractSQLAlterTableSplitPartitionAction.SQLItem) visit(ctx.iAlterTableSplitPartitionActionItem());
        x.setItem(item);

        if (ctx.splitNestedTablePart() != null) {
            AbstractSQLAlterTableSplitPartitionAction.SQLSplitNestedTablePart splitNestedTablePart = visitSplitNestedTablePart(ctx.splitNestedTablePart());
            x.setSplitNestedTablePart(splitNestedTablePart);
        }

        if (ctx.filterCondition() != null) {
            SQLFilterCondition filterCondition = visitFilterCondition(ctx.filterCondition());
            x.setFilterCondition(filterCondition);
        }

        if (ctx.dependentTablesClause() != null) {
            SQLDependentTablesClause dependentTablesClause = visitDependentTablesClause(ctx.dependentTablesClause());
            x.setDependentTables(dependentTablesClause);
        }

        if (ctx.updateIndexClause() != null) {
            ISQLUpdateIndexClause updateIndexClause = visitUpdateIndexClause(ctx.updateIndexClause());
            x.setUpdateIndex(updateIndexClause);
        }

        if (ctx.parallelClause() != null) {
            ISQLParallelClause parallelClause = visitParallelClause(ctx.parallelClause());
            x.setParallel(parallelClause);
        }

        if (ctx.allowDisallowClustering() != null) {
            SQLAllowDisallowClusteringType allowDisallowClustering = of(ctx.allowDisallowClustering());
            x.setAllowDisallowClustering(allowDisallowClustering);
        }

        if (ctx.ONLINE() != null) {
            x.setOnline(true);
        }

        return x;
    }

    @Override
    public SQLAlterTableSplitPartitionForAction visitAlterTableSplitPartitionForAction(AlterTableSplitPartitionForActionContext ctx) {
        SQLAlterTableSplitPartitionForAction x = new SQLAlterTableSplitPartitionForAction();

        for (NameIdentifierContext nameIdentifierContext : ctx.nameIdentifier()) {
            SQLName name = visitNameIdentifier(nameIdentifierContext);
            x.addName(name);
        }

        AbstractSQLAlterTableSplitPartitionAction.SQLItem item = (AbstractSQLAlterTableSplitPartitionAction.SQLItem) visit(ctx.iAlterTableSplitPartitionActionItem());
        x.setItem(item);

        if (ctx.splitNestedTablePart() != null) {
            AbstractSQLAlterTableSplitPartitionAction.SQLSplitNestedTablePart splitNestedTablePart = visitSplitNestedTablePart(ctx.splitNestedTablePart());
            x.setSplitNestedTablePart(splitNestedTablePart);
        }

        if (ctx.filterCondition() != null) {
            SQLFilterCondition filterCondition = visitFilterCondition(ctx.filterCondition());
            x.setFilterCondition(filterCondition);
        }

        if (ctx.dependentTablesClause() != null) {
            SQLDependentTablesClause dependentTablesClause = visitDependentTablesClause(ctx.dependentTablesClause());
            x.setDependentTables(dependentTablesClause);
        }

        if (ctx.updateIndexClause() != null) {
            ISQLUpdateIndexClause updateIndexClause = visitUpdateIndexClause(ctx.updateIndexClause());
            x.setUpdateIndex(updateIndexClause);
        }

        if (ctx.parallelClause() != null) {
            ISQLParallelClause parallelClause = visitParallelClause(ctx.parallelClause());
            x.setParallel(parallelClause);
        }

        if (ctx.allowDisallowClustering() != null) {
            SQLAllowDisallowClusteringType allowDisallowClustering = of(ctx.allowDisallowClustering());
            x.setAllowDisallowClustering(allowDisallowClustering);
        }

        if (ctx.ONLINE() != null) {
            x.setOnline(true);
        }
        return x;
    }

    @Override
    public AbstractSQLAlterTableSplitPartitionAction.SQLAt visitSplitPartitionAtItem(SplitPartitionAtItemContext ctx) {
        AbstractSQLAlterTableSplitPartitionAction.SQLAt x = new AbstractSQLAlterTableSplitPartitionAction.SQLAt();

        for (ExprContext exprContext : ctx.atItems) {
            SQLExpr item = visitExpr(exprContext);
            x.addItem(item);
        }

        for (PartitionDefinitionContext partitionDefinitionContext : ctx.partitionDefinition()) {
            SQLPartitionDefinition partition = visitPartitionDefinition(partitionDefinitionContext);
            x.addPartition(partition);
        }
        return x;
    }

    @Override
    public AbstractSQLAlterTableSplitPartitionAction.SQLValues visitSplitPartitionValuesItem(SplitPartitionValuesItemContext ctx) {
        AbstractSQLAlterTableSplitPartitionAction.SQLValues x = new AbstractSQLAlterTableSplitPartitionAction.SQLValues();

        for (ExprContext exprContext : ctx.values) {
            SQLExpr item = visitExpr(exprContext);
            x.addItem(item);
        }

        for (PartitionDefinitionContext partitionDefinitionContext : ctx.partitionDefinition()) {
            SQLPartitionDefinition partition = visitPartitionDefinition(partitionDefinitionContext);
            x.addPartition(partition);
        }
        return x;
    }

    @Override
    public AbstractSQLAlterTableSplitPartitionAction.SQLInto visitSplitPartitionIntoItem(SplitPartitionIntoItemContext ctx) {
        AbstractSQLAlterTableSplitPartitionAction.SQLInto x = new AbstractSQLAlterTableSplitPartitionAction.SQLInto();

        for (PartitionDefinitionContext partitionDefinitionContext : ctx.partitionDefinition()) {
            SQLPartitionDefinition partition = visitPartitionDefinition(partitionDefinitionContext);
            x.addPartition(partition);
        }
        return x;
    }

    @Override
    public AbstractSQLAlterTableSplitPartitionAction.SQLSplitNestedTablePart visitSplitNestedTablePart(SplitNestedTablePartContext ctx) {
        AbstractSQLAlterTableSplitPartitionAction.SQLSplitNestedTablePart x = new AbstractSQLAlterTableSplitPartitionAction.SQLSplitNestedTablePart();

        SQLExpr column = visitExpr(ctx.expr());
        x.setColumn(column);

        for (PartitionDefinitionContext partitionDefinitionContext : ctx.partitionDefinition()) {
            SQLPartitionDefinition partition = visitPartitionDefinition(partitionDefinitionContext);
            x.addItem(partition);
        }

        if (ctx.sp1 != null) {
            AbstractSQLAlterTableSplitPartitionAction.SQLSplitNestedTablePart sp1 = visitSplitNestedTablePart(ctx.sp1);
            x.addItem(sp1);
        }

        if (ctx.sp2 != null) {
            AbstractSQLAlterTableSplitPartitionAction.SQLSplitNestedTablePart sp2 = visitSplitNestedTablePart(ctx.sp2);
            x.setSplitNestedTablePart(sp2);
        }

        return x;
    }

    @Override
    public SQLAlterTableSplitSubPartitionAction visitAlterTableSplitSubPartitionAction(AlterTableSplitSubPartitionActionContext ctx) {
        SQLAlterTableSplitSubPartitionAction x = new SQLAlterTableSplitSubPartitionAction();

        SQLName name = visitNameIdentifier(ctx.name);
        x.setName(name);


        AbstractSQLAlterTableSplitPartitionAction.SQLItem item = (AbstractSQLAlterTableSplitPartitionAction.SQLItem) visit(ctx.iAlterTableSplitPartitionActionItem());
        x.setItem(item);

        if (ctx.splitNestedTablePart() != null) {
            AbstractSQLAlterTableSplitPartitionAction.SQLSplitNestedTablePart splitNestedTablePart = visitSplitNestedTablePart(ctx.splitNestedTablePart());
            x.setSplitNestedTablePart(splitNestedTablePart);
        }

        if (ctx.updateIndexClause() != null) {
            SQLFilterCondition filterCondition = visitFilterCondition(ctx.filterCondition());
            x.setFilterCondition(filterCondition);
        }

        if (ctx.updateIndexClause() != null) {
            SQLDependentTablesClause dependentTablesClause = visitDependentTablesClause(ctx.dependentTablesClause());
            x.setDependentTables(dependentTablesClause);
        }

        if (ctx.updateIndexClause() != null) {
            ISQLUpdateIndexClause updateIndexClause = visitUpdateIndexClause(ctx.updateIndexClause());
            x.setUpdateIndex(updateIndexClause);
        }

        if (ctx.updateIndexClause() != null) {
            ISQLParallelClause parallelClause = visitParallelClause(ctx.parallelClause());
            x.setParallel(parallelClause);
        }

        if (ctx.allowDisallowClustering() != null) {
            SQLAllowDisallowClusteringType allowDisallowClustering = of(ctx.allowDisallowClustering());
            x.setAllowDisallowClustering(allowDisallowClustering);
        }

        if (ctx.ONLINE() != null) {
            x.setOnline(true);
        }

        return x;
    }


    @Override
    public SQLAlterTableSplitSubPartitionForAction visitAlterTableSplitSubPartitionForAction(AlterTableSplitSubPartitionForActionContext ctx) {
        SQLAlterTableSplitSubPartitionForAction x = new SQLAlterTableSplitSubPartitionForAction();

        for (NameIdentifierContext nameIdentifierContext : ctx.nameIdentifier()) {
            SQLName name = visitNameIdentifier(nameIdentifierContext);
            x.addName(name);
        }

        AbstractSQLAlterTableSplitPartitionAction.SQLItem item = (AbstractSQLAlterTableSplitPartitionAction.SQLItem) visit(ctx.iAlterTableSplitPartitionActionItem());
        x.setItem(item);

        if (ctx.splitNestedTablePart() != null) {
            AbstractSQLAlterTableSplitPartitionAction.SQLSplitNestedTablePart splitNestedTablePart = visitSplitNestedTablePart(ctx.splitNestedTablePart());
            x.setSplitNestedTablePart(splitNestedTablePart);
        }

        if (ctx.updateIndexClause() != null) {
            SQLFilterCondition filterCondition = visitFilterCondition(ctx.filterCondition());
            x.setFilterCondition(filterCondition);
        }

        if (ctx.updateIndexClause() != null) {
            SQLDependentTablesClause dependentTablesClause = visitDependentTablesClause(ctx.dependentTablesClause());
            x.setDependentTables(dependentTablesClause);
        }

        if (ctx.updateIndexClause() != null) {
            ISQLUpdateIndexClause updateIndexClause = visitUpdateIndexClause(ctx.updateIndexClause());
            x.setUpdateIndex(updateIndexClause);
        }

        if (ctx.updateIndexClause() != null) {
            ISQLParallelClause parallelClause = visitParallelClause(ctx.parallelClause());
            x.setParallel(parallelClause);
        }

        if (ctx.allowDisallowClustering() != null) {
            SQLAllowDisallowClusteringType allowDisallowClustering = of(ctx.allowDisallowClustering());
            x.setAllowDisallowClustering(allowDisallowClustering);
        }

        if (ctx.ONLINE() != null) {
            x.setOnline(true);
        }

        return x;
    }

    @Override
    public SQLAlterTableMergePartitionsAction visitAlterTableMergePartitionsAction(AlterTableMergePartitionsActionContext ctx) {
        SQLAlterTableMergePartitionsAction x = new SQLAlterTableMergePartitionsAction();

        for (AlterTablePartitionItemContext alterTablePartitionItemContext : ctx.alterTablePartitionItem()) {
            SQLExpr item = (SQLExpr) visitChildren(alterTablePartitionItemContext);
            x.addItem(item);
        }

        if (ctx.partitionDefinition() != null) {
            SQLPartitionDefinition partition = visitPartitionDefinition(ctx.partitionDefinition());
            x.setPartition(partition);
        }

        if (ctx.filterCondition() != null) {
            SQLFilterCondition filterCondition = visitFilterCondition(ctx.filterCondition());
            x.setFilterCondition(filterCondition);
        }

        if (ctx.dependentTablesClause() != null) {
            SQLDependentTablesClause dependentTables = visitDependentTablesClause(ctx.dependentTablesClause());
            x.setDependentTables(dependentTables);
        }

        if (ctx.updateIndexClause() != null) {
            ISQLUpdateIndexClause updateIndex = visitUpdateIndexClause(ctx.updateIndexClause());
            x.setUpdateIndex(updateIndex);
        }

        if (ctx.parallelClause() != null) {
            ISQLParallelClause parallel = visitParallelClause(ctx.parallelClause());
            x.setParallel(parallel);
        }

        if (ctx.ONLINE() != null) {
            x.setOnline(true);
        }

        if (ctx.parallelClause() != null) {
            ISQLParallelClause parallel = visitParallelClause(ctx.parallelClause());
            x.setParallel(parallel);
        }

        SQLAllowDisallowClusteringType allowDisallowClustering = of(ctx.allowDisallowClustering());
        x.setAllowDisallowClustering(allowDisallowClustering);

        return x;
    }

    @Override
    public SQLAlterTableMergePartitionsToAction visitAlterTableMergePartitionsToAction(AlterTableMergePartitionsToActionContext ctx) {
        SQLAlterTableMergePartitionsToAction x = new SQLAlterTableMergePartitionsToAction();

        for (AlterTablePartitionItemContext alterTablePartitionItemContext : ctx.alterTablePartitionItem()) {
            SQLExpr item = (SQLExpr) visitChildren(alterTablePartitionItemContext);
            x.addItem(item);
        }

        if (ctx.partitionDefinition() != null) {
            SQLPartitionDefinition partition = visitPartitionDefinition(ctx.partitionDefinition());
            x.setPartition(partition);
        }

        if (ctx.filterCondition() != null) {
            SQLFilterCondition filterCondition = visitFilterCondition(ctx.filterCondition());
            x.setFilterCondition(filterCondition);
        }

        if (ctx.dependentTablesClause() != null) {
            SQLDependentTablesClause dependentTables = visitDependentTablesClause(ctx.dependentTablesClause());
            x.setDependentTables(dependentTables);
        }

        if (ctx.updateIndexClause() != null) {
            ISQLUpdateIndexClause updateIndex = visitUpdateIndexClause(ctx.updateIndexClause());
            x.setUpdateIndex(updateIndex);
        }

        if (ctx.parallelClause() != null) {
            ISQLParallelClause parallel = visitParallelClause(ctx.parallelClause());
            x.setParallel(parallel);
        }

        if (ctx.ONLINE() != null) {
            x.setOnline(true);
        }

        if (ctx.parallelClause() != null) {
            ISQLParallelClause parallel = visitParallelClause(ctx.parallelClause());
            x.setParallel(parallel);
        }

        SQLAllowDisallowClusteringType allowDisallowClustering = of(ctx.allowDisallowClustering());
        x.setAllowDisallowClustering(allowDisallowClustering);

        return x;
    }

    @Override
    public SQLAlterTableMergeSubPartitionsAction visitAlterTableMergeSubPartitionsAction(AlterTableMergeSubPartitionsActionContext ctx) {
        SQLAlterTableMergeSubPartitionsAction x = new SQLAlterTableMergeSubPartitionsAction();

        for (AlterTablePartitionItemContext alterTablePartitionItemContext : ctx.alterTablePartitionItem()) {
            SQLExpr item = (SQLExpr) visitChildren(alterTablePartitionItemContext);
            x.addItem(item);
        }

        if (ctx.subPartitionDefinition() != null) {
            SQLSubPartitionDefinition subPartition = visitSubPartitionDefinition(ctx.subPartitionDefinition());
            x.setSubPartition(subPartition);
        }

        if (ctx.filterCondition() != null) {
            SQLFilterCondition filterCondition = visitFilterCondition(ctx.filterCondition());
            x.setFilterCondition(filterCondition);
        }

        if (ctx.dependentTablesClause() != null) {
            SQLDependentTablesClause dependentTables = visitDependentTablesClause(ctx.dependentTablesClause());
            x.setDependentTables(dependentTables);
        }

        if (ctx.updateIndexClause() != null) {
            ISQLUpdateIndexClause updateIndex = visitUpdateIndexClause(ctx.updateIndexClause());
            x.setUpdateIndex(updateIndex);
        }

        if (ctx.parallelClause() != null) {
            ISQLParallelClause parallel = visitParallelClause(ctx.parallelClause());
            x.setParallel(parallel);
        }

//        if (ctx.ONLINE()!=null) {
//            x.setOnline(true);
//        }

        if (ctx.parallelClause() != null) {
            ISQLParallelClause parallel = visitParallelClause(ctx.parallelClause());
            x.setParallel(parallel);
        }

        SQLAllowDisallowClusteringType allowDisallowClustering = of(ctx.allowDisallowClustering());
        x.setAllowDisallowClustering(allowDisallowClustering);


        return x;
    }

    @Override
    public SQLAlterTableMergeSubPartitionsToAction visitAlterTableMergeSubPartitionsToAction(AlterTableMergeSubPartitionsToActionContext ctx) {
        SQLAlterTableMergeSubPartitionsToAction x = new SQLAlterTableMergeSubPartitionsToAction();

        for (AlterTablePartitionItemContext alterTablePartitionItemContext : ctx.alterTablePartitionItem()) {
            SQLExpr item = (SQLExpr) visitChildren(alterTablePartitionItemContext);
            x.addItem(item);
        }

        if (ctx.subPartitionDefinition() != null) {
            SQLSubPartitionDefinition subPartition = visitSubPartitionDefinition(ctx.subPartitionDefinition());
            x.setSubPartition(subPartition);
        }

        if (ctx.filterCondition() != null) {
            SQLFilterCondition filterCondition = visitFilterCondition(ctx.filterCondition());
            x.setFilterCondition(filterCondition);
        }

        if (ctx.dependentTablesClause() != null) {
            SQLDependentTablesClause dependentTables = visitDependentTablesClause(ctx.dependentTablesClause());
            x.setDependentTables(dependentTables);
        }

        if (ctx.updateIndexClause() != null) {
            ISQLUpdateIndexClause updateIndex = visitUpdateIndexClause(ctx.updateIndexClause());
            x.setUpdateIndex(updateIndex);
        }

        if (ctx.parallelClause() != null) {
            ISQLParallelClause parallel = visitParallelClause(ctx.parallelClause());
            x.setParallel(parallel);
        }

//        if (ctx.ONLINE()!=null) {
//            x.setOnline(true);
//        }

        if (ctx.parallelClause() != null) {
            ISQLParallelClause parallel = visitParallelClause(ctx.parallelClause());
            x.setParallel(parallel);
        }

        SQLAllowDisallowClusteringType allowDisallowClustering = of(ctx.allowDisallowClustering());
        x.setAllowDisallowClustering(allowDisallowClustering);

        return x;
    }

    @Override
    public SQLAlterTableExchangePartitionAction visitAlterTableExchangePartitionAction(AlterTableExchangePartitionActionContext ctx) {
        SQLAlterTableExchangePartitionAction x = new SQLAlterTableExchangePartitionAction();

        SQLName name = visitNameIdentifier(ctx.name);
        x.setName(name);

        SQLName withTable = visitNameIdentifier(ctx.withTable);
        x.setTable(withTable);

        if (ctx.INDEXES() != null) {
            SQLIncludingType indexes = SQLIncludingType.INCLUDING;
            if (ctx.EXCLUDING() != null) {
                indexes = SQLIncludingType.EXCLUDING;
            }
            x.setIndexes(indexes);
        }

        if (ctx.VALIDATION() != null) {
            SQLWithType validation = SQLWithType.WITH;
            if (ctx.WITHOUT() != null) {
                validation = SQLWithType.WITHOUT;
            }
            x.setValidation(validation);
        }

        if (ctx.exceptionsClause() != null) {
            SQExceptionsClause exceptionsClause = visitExceptionsClause(ctx.exceptionsClause());
            x.setExceptionsClause(exceptionsClause);
        }

        if (ctx.updateIndexClause() != null) {
            ISQLUpdateIndexClause updateIndexClause = visitUpdateIndexClause(ctx.updateIndexClause());
            x.setUpdateIndexClause(updateIndexClause);
        }

        if (ctx.parallelClause() != null) {
            ISQLParallelClause parallelClause = visitParallelClause(ctx.parallelClause());
            x.setParallelClause(parallelClause);
        }

        if (ctx.CASCADE() != null) {
            x.setCascade(true);
        }
        return x;

    }

    @Override
    public SQLAlterTableExchangePartitionForAction visitAlterTableExchangePartitionForAction(AlterTableExchangePartitionForActionContext ctx) {
        SQLAlterTableExchangePartitionForAction x = new SQLAlterTableExchangePartitionForAction();

        for (ExprContext exprContext : ctx.expr()) {
            SQLExpr name = visitExpr(exprContext);
            x.addName(name);
        }
        SQLName withTable = visitNameIdentifier(ctx.withTable);
        x.setTable(withTable);

        if (ctx.INDEXES() != null) {
            SQLIncludingType indexes = SQLIncludingType.INCLUDING;
            if (ctx.EXCLUDING() != null) {
                indexes = SQLIncludingType.EXCLUDING;
            }
            x.setIndexes(indexes);
        }

        if (ctx.VALIDATION() != null) {
            SQLWithType validation = SQLWithType.WITH;
            if (ctx.WITHOUT() != null) {
                validation = SQLWithType.WITHOUT;
            }
            x.setValidation(validation);
        }

        if (ctx.exceptionsClause() != null) {
            SQExceptionsClause exceptionsClause = visitExceptionsClause(ctx.exceptionsClause());
            x.setExceptionsClause(exceptionsClause);
        }

        if (ctx.updateIndexClause() != null) {
            ISQLUpdateIndexClause updateIndexClause = visitUpdateIndexClause(ctx.updateIndexClause());
            x.setUpdateIndexClause(updateIndexClause);
        }

        if (ctx.parallelClause() != null) {
            ISQLParallelClause parallelClause = visitParallelClause(ctx.parallelClause());
            x.setParallelClause(parallelClause);
        }

        if (ctx.CASCADE() != null) {
            x.setCascade(true);
        }
        return x;
    }

    @Override
    public SQLAlterTableExchangeSubPartitionAction visitAlterTableExchangeSubPartitionAction(AlterTableExchangeSubPartitionActionContext ctx) {
        SQLAlterTableExchangeSubPartitionAction x = new SQLAlterTableExchangeSubPartitionAction();
        SQLName name = visitNameIdentifier(ctx.name);
        x.setName(name);

        SQLName withTable = visitNameIdentifier(ctx.withTable);
        x.setTable(withTable);

        if (ctx.INDEXES() != null) {
            SQLIncludingType indexes = SQLIncludingType.INCLUDING;
            if (ctx.EXCLUDING() != null) {
                indexes = SQLIncludingType.EXCLUDING;
            }
            x.setIndexes(indexes);
        }

        if (ctx.VALIDATION() != null) {
            SQLWithType validation = SQLWithType.WITH;
            if (ctx.WITHOUT() != null) {
                validation = SQLWithType.WITHOUT;
            }
            x.setValidation(validation);
        }

        if (ctx.exceptionsClause() != null) {
            SQExceptionsClause exceptionsClause = visitExceptionsClause(ctx.exceptionsClause());
            x.setExceptionsClause(exceptionsClause);
        }

        if (ctx.updateIndexClause() != null) {
            ISQLUpdateIndexClause updateIndexClause = visitUpdateIndexClause(ctx.updateIndexClause());
            x.setUpdateIndexClause(updateIndexClause);
        }

        if (ctx.parallelClause() != null) {
            ISQLParallelClause parallelClause = visitParallelClause(ctx.parallelClause());
            x.setParallelClause(parallelClause);
        }

        if (ctx.CASCADE() != null) {
            x.setCascade(true);
        }
        return x;
    }

    @Override
    public SQLAlterTableExchangeSubPartitionForAction visitAlterTableExchangeSubPartitionForAction(AlterTableExchangeSubPartitionForActionContext ctx) {
        SQLAlterTableExchangeSubPartitionForAction x = new SQLAlterTableExchangeSubPartitionForAction();

        for (ExprContext exprContext : ctx.expr()) {
            SQLExpr name = visitExpr(exprContext);
            x.addName(name);
        }
        SQLName withTable = visitNameIdentifier(ctx.withTable);
        x.setTable(withTable);

        if (ctx.INDEXES() != null) {
            SQLIncludingType indexes = SQLIncludingType.INCLUDING;
            if (ctx.EXCLUDING() != null) {
                indexes = SQLIncludingType.EXCLUDING;
            }
            x.setIndexes(indexes);
        }

        if (ctx.VALIDATION() != null) {
            SQLWithType validation = SQLWithType.WITH;
            if (ctx.WITHOUT() != null) {
                validation = SQLWithType.WITHOUT;
            }
            x.setValidation(validation);
        }

        if (ctx.exceptionsClause() != null) {
            SQExceptionsClause exceptionsClause = visitExceptionsClause(ctx.exceptionsClause());
            x.setExceptionsClause(exceptionsClause);
        }

        if (ctx.updateIndexClause() != null) {
            ISQLUpdateIndexClause updateIndexClause = visitUpdateIndexClause(ctx.updateIndexClause());
            x.setUpdateIndexClause(updateIndexClause);
        }

        if (ctx.parallelClause() != null) {
            ISQLParallelClause parallelClause = visitParallelClause(ctx.parallelClause());
            x.setParallelClause(parallelClause);
        }

        if (ctx.CASCADE() != null) {
            x.setCascade(true);
        }
        return x;
    }

    @Override
    public ISQLUpdateIndexClause visitUpdateIndexClause(UpdateIndexClauseContext ctx) {
        return (ISQLUpdateIndexClause) super.visitChildren(ctx);
    }

    @Override
    public ISQLUpdateIndexClause visitUpdateGlobalIndexClause(UpdateGlobalIndexClauseContext ctx) {
        if (ctx == null) {
            return null;
        }
        ISQLUpdateIndexClause x = new SQLUpdateGlobalIndexClause();
        if (ctx.INVALIDATE() != null) {
            x = new SQLInvalidateGlobalIndexClause();
        }
        return x;
    }

    @Override
    public SQLUpdateIndexesClause visitUpdateIndexesClause(UpdateIndexesClauseContext ctx) {
        SQLUpdateIndexesClause x = new SQLUpdateIndexesClause();
        for (UpdateIndexesClauseItemContext updateIndexesClauseItemContext : ctx.updateIndexesClauseItem()) {
            SQLUpdateIndexesClause.Item item = visitUpdateIndexesClauseItem(updateIndexesClauseItemContext);
            x.addItem(item);
        }
        return x;
    }

    @Override
    public SQLUpdateIndexesClause.Item visitUpdateIndexesClauseItem(UpdateIndexesClauseItemContext ctx) {
        SQLUpdateIndexesClause.Item x = new SQLUpdateIndexesClause.Item();

        SQLExpr name = visitExpr(ctx.expr());
        x.setName(name);

        for (UpdateIndexesClauseItemItemContext updateIndexesClauseItemItemContext : ctx.updateIndexesClauseItemItem()) {
            SQLExpr item = (SQLExpr) visitChildren(updateIndexesClauseItemItemContext);
            x.addItem(item);
        }

        return x;
    }

    @Override
    public SQLAlterTableMoveTableAction visitAlterTableMoveTableAction(AlterTableMoveTableActionContext ctx) {
        SQLAlterTableMoveTableAction x = new SQLAlterTableMoveTableAction();

        for (AlterTableMoveTableActionPropertyContext alterTableMoveTableActionPropertyContext : ctx.alterTableMoveTableActionProperty()) {
            SQLExpr property = (SQLExpr) visitChildren(alterTableMoveTableActionPropertyContext);
            x.addProperty(property);
        }

        if (ctx.updateIndexesClause() != null) {
            visitUpdateIndexesClause(ctx.updateIndexesClause());
        }
        return x;
    }

    @Override
    public SQLObject visitAlterTableModifyToPartitionedAction(AlterTableModifyToPartitionedActionContext ctx) {
        return super.visitAlterTableModifyToPartitionedAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableModifyToPartitionedActionUpdateIndexesItem(AlterTableModifyToPartitionedActionUpdateIndexesItemContext ctx) {
        return super.visitAlterTableModifyToPartitionedActionUpdateIndexesItem(ctx);
    }

    @Override
    public SQLAlterTableModifyOpaqueTypeAction visitAlterTableModifyOpaqueTypeAction(AlterTableModifyOpaqueTypeActionContext ctx) {
        SQLAlterTableModifyOpaqueTypeAction x = new SQLAlterTableModifyOpaqueTypeAction();

        SQLExpr column = visitExpr(ctx.column);
        x.setColumn(column);

        for (ExprContext exprContext : ctx.names) {
            SQLExpr name = visitExpr(exprContext);
            x.addName(name);
        }

        return x;
    }

    @Override
    public ISQLEnableDisableClause.SQLEnableUniqueClause visitEnableUniqueClause(EnableUniqueClauseContext ctx) {
        ISQLEnableDisableClause.SQLEnableUniqueClause x = new ISQLEnableDisableClause.SQLEnableUniqueClause();

        SQLValidateType validate = of(ctx.validateType());
        x.setValidate(validate);

        for (ExprContext exprContext : ctx.expr()) {
            SQLExpr column = visitExpr(exprContext);
            x.addColumn(column);
        }

        if (ctx.iUsingIndexClause() != null) {
            ISQLUsingIndexClause usingIndexClause = (ISQLUsingIndexClause) visit(ctx.iUsingIndexClause());
            x.setUsingIndexClause(usingIndexClause);
        }

        if (ctx.exceptionsClause() != null) {
            SQExceptionsClause exceptionsClause = visitExceptionsClause(ctx.exceptionsClause());
            x.setExceptionsClause(exceptionsClause);
        }

        if (ctx.CASCADE() != null) {
            x.setCascade(true);
        }

        SQLKeepIndexType keepIndex = of(ctx.keepIndexType());
        x.setKeepIndex(keepIndex);
        return x;
    }

    @Override
    public ISQLEnableDisableClause.SQLEnablePrimaryKeyClause visitEnablePrimaryKeyClause(EnablePrimaryKeyClauseContext ctx) {
        ISQLEnableDisableClause.SQLEnablePrimaryKeyClause x = new ISQLEnableDisableClause.SQLEnablePrimaryKeyClause();

        SQLValidateType validate = of(ctx.validateType());
        x.setValidate(validate);

        if (ctx.iUsingIndexClause() != null) {
            ISQLUsingIndexClause usingIndexClause = (ISQLUsingIndexClause) visit(ctx.iUsingIndexClause());
            x.setUsingIndexClause(usingIndexClause);
        }

        if (ctx.exceptionsClause() != null) {
            SQExceptionsClause exceptionsClause = visitExceptionsClause(ctx.exceptionsClause());
            x.setExceptionsClause(exceptionsClause);
        }

        if (ctx.CASCADE() != null) {
            x.setCascade(true);
        }

        SQLKeepIndexType keepIndex = of(ctx.keepIndexType());
        x.setKeepIndex(keepIndex);
        return x;
    }

    @Override
    public ISQLEnableDisableClause.SQLEnableConstraintClause visitEnableConstraintClause(EnableConstraintClauseContext ctx) {
        ISQLEnableDisableClause.SQLEnableConstraintClause x = new ISQLEnableDisableClause.SQLEnableConstraintClause();

        SQLValidateType validate = of(ctx.validateType());
        x.setValidate(validate);

        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);

        if (ctx.iUsingIndexClause() != null) {
            ISQLUsingIndexClause usingIndexClause = (ISQLUsingIndexClause) visit(ctx.iUsingIndexClause());
            x.setUsingIndexClause(usingIndexClause);
        }

        if (ctx.exceptionsClause() != null) {
            SQExceptionsClause exceptionsClause = visitExceptionsClause(ctx.exceptionsClause());
            x.setExceptionsClause(exceptionsClause);
        }

        if (ctx.CASCADE() != null) {
            x.setCascade(true);
        }

        SQLKeepIndexType keepIndex = of(ctx.keepIndexType());
        x.setKeepIndex(keepIndex);
        return x;
    }

    @Override
    public ISQLEnableDisableClause.SQLDisableUniqueClause visitDisableUniqueClause(DisableUniqueClauseContext ctx) {
        ISQLEnableDisableClause.SQLDisableUniqueClause x = new ISQLEnableDisableClause.SQLDisableUniqueClause();

        SQLValidateType validate = of(ctx.validateType());
        x.setValidate(validate);

        for (ExprContext exprContext : ctx.expr()) {
            SQLExpr column = visitExpr(exprContext);
            x.addColumn(column);
        }

        if (ctx.iUsingIndexClause() != null) {
            ISQLUsingIndexClause usingIndexClause = (ISQLUsingIndexClause) visit(ctx.iUsingIndexClause());
            x.setUsingIndexClause(usingIndexClause);
        }

        if (ctx.exceptionsClause() != null) {
            SQExceptionsClause exceptionsClause = visitExceptionsClause(ctx.exceptionsClause());
            x.setExceptionsClause(exceptionsClause);
        }

        if (ctx.CASCADE() != null) {
            x.setCascade(true);
        }

        SQLKeepIndexType keepIndex = of(ctx.keepIndexType());
        x.setKeepIndex(keepIndex);
        return x;
    }

    @Override
    public SQLObject visitDisablePrimaryKeyClause(DisablePrimaryKeyClauseContext ctx) {
        ISQLEnableDisableClause.SQLEnableUniqueClause x = new ISQLEnableDisableClause.SQLEnableUniqueClause();

        SQLValidateType validate = of(ctx.validateType());
        x.setValidate(validate);

        if (ctx.iUsingIndexClause() != null) {
            ISQLUsingIndexClause usingIndexClause = (ISQLUsingIndexClause) visit(ctx.iUsingIndexClause());
            x.setUsingIndexClause(usingIndexClause);
        }

        if (ctx.exceptionsClause() != null) {
            SQExceptionsClause exceptionsClause = visitExceptionsClause(ctx.exceptionsClause());
            x.setExceptionsClause(exceptionsClause);
        }

        if (ctx.CASCADE() != null) {
            x.setCascade(true);
        }

        SQLKeepIndexType keepIndex = of(ctx.keepIndexType());
        x.setKeepIndex(keepIndex);
        return x;
    }

    @Override
    public ISQLEnableDisableClause.SQLDisableConstraintClause visitDisableConstraintClause(DisableConstraintClauseContext ctx) {
        ISQLEnableDisableClause.SQLDisableConstraintClause x = new ISQLEnableDisableClause.SQLDisableConstraintClause();
        SQLValidateType validate = of(ctx.validateType());
        x.setValidate(validate);

        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);

        if (ctx.iUsingIndexClause() != null) {
            ISQLUsingIndexClause usingIndexClause = (ISQLUsingIndexClause) visit(ctx.iUsingIndexClause());
            x.setUsingIndexClause(usingIndexClause);
        }

        if (ctx.exceptionsClause() != null) {
            SQExceptionsClause exceptionsClause = visitExceptionsClause(ctx.exceptionsClause());
            x.setExceptionsClause(exceptionsClause);
        }

        if (ctx.CASCADE() != null) {
            x.setCascade(true);
        }

        SQLKeepIndexType keepIndex = of(ctx.keepIndexType());
        x.setKeepIndex(keepIndex);
        return x;
    }

    @Override
    public SQLAlterTableEnableTableLockAction visitAlterTableEnableTableLockAction(AlterTableEnableTableLockActionContext ctx) {
        return new SQLAlterTableEnableTableLockAction();
    }

    @Override
    public SQLAlterTableEnableAllTriggersAction visitAlterTableEnableAllTriggersAction(AlterTableEnableAllTriggersActionContext ctx) {
        return new SQLAlterTableEnableAllTriggersAction();
    }

    @Override
    public SQLAlterTableEnableContainerMapAction visitAlterTableEnableContainerMapAction(AlterTableEnableContainerMapActionContext ctx) {
        return new SQLAlterTableEnableContainerMapAction();
    }

    @Override
    public SQLAlterTableEnableContainersDefaultAction visitAlterTableEnableContainersDefaultAction(AlterTableEnableContainersDefaultActionContext ctx) {
        SQLAlterTableEnableContainersDefaultAction x = new SQLAlterTableEnableContainersDefaultAction();
        return x;
    }

    @Override
    public SQLAlterTableDisableTableLockAction visitAlterTableDisableTableLockAction(AlterTableDisableTableLockActionContext ctx) {
        SQLAlterTableDisableTableLockAction x = new SQLAlterTableDisableTableLockAction();

        return x;
    }

    @Override
    public SQLAlterTableDisableAllTriggersAction visitAlterTableDisableAllTriggersAction(AlterTableDisableAllTriggersActionContext ctx) {
        SQLAlterTableDisableAllTriggersAction x = new SQLAlterTableDisableAllTriggersAction();

        return x;
    }

    @Override
    public SQLAlterTableDisableContainerMapAction visitAlterTableDisableContainerMapAction(AlterTableDisableContainerMapActionContext ctx) {
        SQLAlterTableDisableContainerMapAction x = new SQLAlterTableDisableContainerMapAction();

        return x;
    }

    @Override
    public SQLAlterTableDisableContainersDefaultAction visitAlterTableDisableContainersDefaultAction(AlterTableDisableContainersDefaultActionContext ctx) {
        SQLAlterTableDisableContainersDefaultAction x = new SQLAlterTableDisableContainersDefaultAction();

        return x;
    }


    // ------  Table End -----------------


    // -------------------------------- Trigger DDLs Start

    @Override
    public SQLCreateTriggerStatement visitCreateTriggerStatement(CreateTriggerStatementContext ctx) {
        SQLCreateTriggerStatement x = new SQLCreateTriggerStatement(DBType.Oracle);

        if (ctx.orReplace() != null) {
            x.setOrReplace(true);
        }

        SQLEditionAbleType editionAbleType = of(ctx.editionableType());
        x.setEditionAbleType(editionAbleType);

        SQLName name = visitNameIdentifier(ctx.triggerName);
        x.setName(name);

        if (ctx.collationExpr() != null) {
            SQLCollationExpr collationExpr = visitCollationExpr(ctx.collationExpr());
            x.setCollationExpr(collationExpr);
        }

        SQLCreateTriggerStatement.SQLTriggerActionTime actionTime = of(ctx.createTriggerActionTime());
        x.setActionTime(actionTime);

        for (CreateTriggerEventContext createTriggerEventContext : ctx.createTriggerEvent()) {
            SQLTriggerEvent triggerEvent = (SQLTriggerEvent) visitChildren(createTriggerEventContext);
            x.addEvent(triggerEvent);
        }

        if (ctx.nestedTable != null) {
            SQLExpr nestedTableColumn = visitNameIdentifier(ctx.nestedTable);
            x.setNestedTableColumn(nestedTableColumn);
        }

        if (ctx.createTriggerOnExpr() != null) {
            SQLExpr createTriggerOnExpr = (SQLExpr) visitChildren(ctx.createTriggerOnExpr());
            x.setOnExpr(createTriggerOnExpr);
        }

        for (ReferencingOptionContext referencingOptionContext : ctx.referencingOption()) {
            SQLTriggerReferencingOption referencingOption = visitReferencingOption(referencingOptionContext);
            x.addReferencingOption(referencingOption);
        }

        if (ctx.forEachRow() != null) {
            x.setForEachType(SQLCreateTriggerStatement.SQLTriggerForEachType.FOR_EACH_ROW);
        }

        SQLCreateTriggerStatement.SQLTriggerEditionType editionType = of(ctx.triggerEditionClause());
        x.setEditionType(editionType);

        if (ctx.triggerOrderingClause() != null) {
            SQLTriggerOrderingClause orderingClause = visitTriggerOrderingClause(ctx.triggerOrderingClause());
            x.setOrderingClause(orderingClause);
        }

        if (ctx.whenCondition != null) {
            SQLExpr whenCondition = visitExpr(ctx.whenCondition);
            x.setWhenCondition(whenCondition);
        }

        SQLObject triggerBody = (SQLObject) visitChildren(ctx.triggerBody());
        x.setTriggerBody(triggerBody);

        return x;
    }

    @Override
    public SQLAlterTriggerStatement visitAlterTriggerStatement(AlterTriggerStatementContext ctx) {
        SQLAlterTriggerStatement x = new SQLAlterTriggerStatement(DBType.Oracle);
        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);

        SQLExpr option = (SQLExpr) visitChildren(ctx.alterTriggerStatementOption());
        x.setOption(option);

        return x;
    }

    @Override
    public SQLDropTriggerStatement visitDropTriggerStatement(DropTriggerStatementContext ctx) {
        SQLDropTriggerStatement x = new SQLDropTriggerStatement(DBType.Oracle);
        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);
        return x;
    }


    public SQLCreateTriggerStatement.SQLTriggerActionTime of(CreateTriggerActionTimeContext ctx) {
        SQLCreateTriggerStatement.SQLTriggerActionTime x = null;
        if (ctx.BEFORE() != null) {
            x = SQLCreateTriggerStatement.SQLTriggerActionTime.BEFORE;

        } else if (ctx.AFTER() != null) {
            x = SQLCreateTriggerStatement.SQLTriggerActionTime.AFTER;

        } else if (ctx.INSTEAD() != null
                && ctx.OF() != null) {
            x = SQLCreateTriggerStatement.SQLTriggerActionTime.INSTEAD_OF;

        } else if (ctx.FOR() != null) {

            x = SQLCreateTriggerStatement.SQLTriggerActionTime.FOR;
        }

        return x;
    }

    @Override
    public SQLTriggerDMLEvent visitTriggerDmlEvent(TriggerDmlEventContext ctx) {
        SQLTriggerDMLEvent.SQLTriggerDMLEventType type = of(ctx);
        SQLTriggerDMLEvent x = new SQLTriggerDMLEvent(type);

        for (NameIdentifierContext nameIdentifierContext : ctx.nameIdentifier()) {
            SQLName ofColumn = visitNameIdentifier(nameIdentifierContext);
            x.addOfColumn(ofColumn);
        }
        return x;
    }

    public SQLTriggerDMLEvent.SQLTriggerDMLEventType of(TriggerDmlEventContext ctx) {
        if (ctx == null) {
            return null;
        }
        SQLTriggerDMLEvent.SQLTriggerDMLEventType x = null;
        if (ctx.DELETE() != null) {
            x = SQLTriggerDMLEvent.SQLTriggerDMLEventType.DELETE;
        } else if (ctx.INSERT() != null) {
            x = SQLTriggerDMLEvent.SQLTriggerDMLEventType.INSERT;
        } else if (ctx.UPDATE() != null) {
            x = SQLTriggerDMLEvent.SQLTriggerDMLEventType.UPDATE;
        }
        return x;
    }

    @Override
    public SQLTriggerDDLEvent visitTriggerDDLEvent(TriggerDDLEventContext ctx) {
        SQLTriggerDDLEvent.SQLTriggerDDLEventType type = of(ctx);
        return new SQLTriggerDDLEvent(type);
    }

    public SQLTriggerDDLEvent.SQLTriggerDDLEventType of(TriggerDDLEventContext ctx) {
        if (ctx == null) {
            return null;
        }
        String name = getText(ctx.children);
        SQLTriggerDDLEvent.SQLTriggerDDLEventType x = SQLTriggerDDLEvent.SQLTriggerDDLEventType.of(name);

        return x;
    }

    @Override
    public SQLTriggerDatabaseEvent visitTriggerDatabaseEvent(TriggerDatabaseEventContext ctx) {
        SQLTriggerDatabaseEvent.SQLTriggerDatabaseEventType type = of(ctx);
        return new SQLTriggerDatabaseEvent(type);
    }

    public SQLTriggerDatabaseEvent.SQLTriggerDatabaseEventType of(TriggerDatabaseEventContext ctx) {
        if (ctx == null) {
            return null;
        }
        String name = getText(ctx.children);
        SQLTriggerDatabaseEvent.SQLTriggerDatabaseEventType x = SQLTriggerDatabaseEvent.SQLTriggerDatabaseEventType.of(name);

        return x;
    }

    @Override
    public SQLCreateTriggerStatement.SQLOnSchemaExpr visitCreateTriggerOnSchemaExpr(CreateTriggerOnSchemaExprContext ctx) {
        SQLCreateTriggerStatement.SQLOnSchemaExpr x = new SQLCreateTriggerStatement.SQLOnSchemaExpr();

        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setOwner(name);
        return x;
    }

    @Override
    public SQLCreateTriggerStatement.SQLOnDatabaseExpr visitCreateTriggerOnDatabaseExpr(CreateTriggerOnDatabaseExprContext ctx) {
        SQLCreateTriggerStatement.SQLOnDatabaseExpr x = new SQLCreateTriggerStatement.SQLOnDatabaseExpr();

        if (ctx.PLUGGABLE() != null) {
            x.setPluggable(true);
        }
        return x;
    }

    @Override
    public AbstractSQLTriggerReferencingOption visitReferencingOption(ReferencingOptionContext ctx) {
        AbstractSQLTriggerReferencingOption x = null;

        AbstractSQLTriggerReferencingOption.SQLTriggerReferencingType referencingType = null;
        if (ctx.NEW() != null) {
            x = new SQLTriggerReferencingNewOption();

        } else if (ctx.OLD() != null) {
            x = new SQLTriggerReferencingOldOption();

        } else if (ctx.PARENT() != null) {
            x = new SQLTriggerReferencingParentOption();
        }


        if (ctx.AS() != null) {
            x.setAs(true);
        }

        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);

        return x;
    }

    public SQLCreateTriggerStatement.SQLTriggerEditionType of(TriggerEditionClauseContext ctx) {
        if (ctx == null) {
            return null;
        }
        SQLCreateTriggerStatement.SQLTriggerEditionType x = SQLCreateTriggerStatement.SQLTriggerEditionType.CROSSEDITION;
        if (ctx.FORWARD() != null) {
            x = SQLCreateTriggerStatement.SQLTriggerEditionType.FORWARD_CROSSEDITION;
        } else if (ctx.REVERSE() != null) {
            x = SQLCreateTriggerStatement.SQLTriggerEditionType.REVERSE_CROSSEDITION;
        }
        return x;
    }

    @Override
    public SQLTriggerOrderingClause visitTriggerOrderingClause(TriggerOrderingClauseContext ctx) {
        if (ctx == null) {
            return null;
        }

        SQLTriggerOrderingClause x = new SQLTriggerOrderingClause();

        SQLTriggerOrderingClause.Type type = null;
        if (ctx.FOLLOWS() != null) {
            type = SQLTriggerOrderingClause.Type.FOLLOWS;
        } else if (ctx.PRECEDES() != null) {
            type = SQLTriggerOrderingClause.Type.PRECEDES;
        }
        x.setType(type);

        for (NameIdentifierContext nameIdentifierContext : ctx.nameIdentifier()) {
            SQLName name = visitNameIdentifier(nameIdentifierContext);
            x.addName(name);
        }

        return x;
    }

    @Override
    public SQLTriggerCompoundTriggerBlock visitCompoundTriggerBlock(CompoundTriggerBlockContext ctx) {
        SQLTriggerCompoundTriggerBlock x = new SQLTriggerCompoundTriggerBlock();

        for (DeclareSectionContext declareSectionContext : ctx.declareSection()) {
            SQLExpr declareSection = (SQLExpr) visitChildren(declareSectionContext);
            x.addDeclareSection(declareSection);
        }

        for (TimingPointSectionContext timingPointSectionContext : ctx.timingPointSection()) {
            SQLTriggerCompoundTriggerBlock.SQLTimingPointSection item = visitTimingPointSection(timingPointSectionContext);
            x.addItem(item);
        }

        SQLName endName = visitNameIdentifier(ctx.nameIdentifier());
        x.setEndName(endName);

        if (ctx.SEMI() != null) {
            x.setAfterSemi(true);
        }
        return x;
    }

    @Override
    public SQLTriggerCompoundTriggerBlock.SQLTimingPointSection visitTimingPointSection(TimingPointSectionContext ctx) {
        SQLTriggerCompoundTriggerBlock.SQLTimingPointSection x = new SQLTriggerCompoundTriggerBlock.SQLTimingPointSection();

        SQLTriggerCompoundTriggerBlock.SQLTimingPoint before = of(ctx.before);
        x.setBeforeTimingPoint(before);

        SQLBody body = visitBody(ctx.body());
        x.setBody(body);

        SQLTriggerCompoundTriggerBlock.SQLTimingPoint after = of(ctx.after);
        x.setAfterTimingPoint(after);

        if (ctx.SEMI() != null) {
            x.setAfterSemi(true);
        }

        return x;
    }

    public SQLTriggerCompoundTriggerBlock.SQLTimingPoint of(TimingPointContext ctx) {
        SQLTriggerCompoundTriggerBlock.SQLTimingPoint x = null;

        if (ctx.BEFORE() != null) {
            if (ctx.STATEMENT() != null) {
                x = SQLTriggerCompoundTriggerBlock.SQLTimingPoint.BEFORE_STATEMENT;
            } else if (ctx.EACH() != null
                    && ctx.ROW() != null) {
                x = SQLTriggerCompoundTriggerBlock.SQLTimingPoint.BEFORE_EACH_ROW;
            }
        } else if (ctx.AFTER() != null) {
            if (ctx.STATEMENT() != null) {
                x = SQLTriggerCompoundTriggerBlock.SQLTimingPoint.AFTER_STATEMENT;
            } else if (ctx.EACH() != null
                    && ctx.ROW() != null) {
                x = SQLTriggerCompoundTriggerBlock.SQLTimingPoint.AFTER_EACH_ROW;
            }
        } else if (ctx.INSTEAD() != null
                && ctx.OF() != null) {
            x = SQLTriggerCompoundTriggerBlock.SQLTimingPoint.INSTEAD_OF_EACH_ROW;
        }

        return x;
    }

    @Override
    public SQLObject visitAlterTriggerStatementOption(AlterTriggerStatementOptionContext ctx) {
        return super.visitAlterTriggerStatementOption(ctx);
    }

    // -------------------------------- Trigger DDLs End


    // -------------------------------- Type DDLs Start

    @Override
    public SQLCreateTypeStatement visitCreateTypeStatement(CreateTypeStatementContext ctx) {
        SQLCreateTypeStatement x = new SQLCreateTypeStatement(DBType.Oracle);

        if (ctx.orReplace() != null) {
            x.setOrReplace(true);
        }

        SQLEditionAbleType editionAbleType = of(ctx.editionableType());
        x.setEditionAbleType(editionAbleType);

        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);


        if (ctx.literal() != null) {
            SQLLiteral literal = visitLiteral(ctx.literal());
            x.setOidLiteral(literal);
        }

        if (ctx.sharingClause() != null) {
            SQLSharingClause sharingClause = visitSharingClause(ctx.sharingClause());
            x.setSharingClause(sharingClause);
        }

        SQLCollationExpr collationExpr = visitCollationExpr(ctx.collationExpr());
        x.setCollationExpr(collationExpr);

        for (CreateTypeStatementPropertyContext createTypeStatementPropertyContext : ctx.createTypeStatementProperty()) {
            SQLExpr property = (SQLExpr) visitChildren(createTypeStatementPropertyContext);
            x.addProperty(property);
        }

        SQLObjectSubDataType objectSubDataType = visitObjectSubDataType(ctx.objectSubDataType());
        x.setObjectSubDataType(objectSubDataType);

        SQLASType as = of(ctx.asType());
        x.setAs(as);
        SQLDataType dataType = visitDataType(ctx.dataType());
        x.setAsDataType(dataType);

        if (ctx.createTypeExternalNameClause() != null) {
            SQLCreateTypeStatement.SQLExternalNameClause externalNameClause = visitCreateTypeExternalNameClause(ctx.createTypeExternalNameClause());
            x.setExternalNameClause(externalNameClause);
        }

        for (AttributeDefinitionContext attributeDefinitionContext : ctx.attributeDefinition()) {
            SQLAttributeDefinition attributeDefinition = visitAttributeDefinition(attributeDefinitionContext);
            x.addAttributeDefinition(attributeDefinition);
        }

        for (ElementSpecContext elementSpecContext : ctx.elementSpec()) {
            OracleSQLElementSpec elementSpec = visitElementSpec(elementSpecContext);
            x.addAttributeDefinition(elementSpec);
        }


        for (CreateTypeStatementOptionContext createTypeStatementOptionContext : ctx.createTypeStatementOption()) {
            SQLExpr option = (SQLExpr) visitChildren(createTypeStatementOptionContext);
            x.addOption(option);
        }

        return x;
    }

    @Override
    public SQLAlterTypeStatement visitAlterTypeStatement(AlterTypeStatementContext ctx) {
        SQLAlterTypeStatement x = new SQLAlterTypeStatement(DBType.Oracle);

        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);

        for (AlterTypeItemContext alterTypeItemContext : ctx.alterTypeItem()) {
            SQLExpr item = (SQLExpr) visitChildren(alterTypeItemContext);
            x.addAction(item);
        }

        return x;
    }

    @Override
    public SQLDropTypeStatement visitDropTypeStatement(DropTypeStatementContext ctx) {
        SQLDropTypeStatement x = new SQLDropTypeStatement(DBType.Oracle);

        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.addName(name);

        SQLDropTypeStatement.SQLDropTypeOption option = null;
        if (ctx.FORCE() != null) {
            option = SQLDropTypeStatement.SQLDropTypeOption.FORCE;
        } else if (ctx.VALIDATE() != null) {
            option = SQLDropTypeStatement.SQLDropTypeOption.VALIDATE;
        }
        x.setOption(option);
        return x;
    }

    @Override
    public SQLCreateTypeStatement.SQLExternalNameClause visitCreateTypeExternalNameClause(CreateTypeExternalNameClauseContext ctx) {
        SQLCreateTypeStatement.SQLExternalNameClause x = new SQLCreateTypeStatement.SQLExternalNameClause();
        SQLExpr externalName = visitExpr(ctx.expr());
        x.setName(externalName);

        SQLCreateTypeStatement.SQLLanguageJavaUsingType languageJavaUsingType = null;
        if (ctx.SQLDATA() != null) {
            languageJavaUsingType = SQLCreateTypeStatement.SQLLanguageJavaUsingType.SQLData;
        } else if (ctx.CUSTOMDATUM() != null) {
            languageJavaUsingType = SQLCreateTypeStatement.SQLLanguageJavaUsingType.CustomDatum;
        } else if (ctx.ORADATA() != null) {
            languageJavaUsingType = SQLCreateTypeStatement.SQLLanguageJavaUsingType.OraData;
        }
        x.setUsingType(languageJavaUsingType);
        return x;
    }

    @Override
    public SQLObject visitAlterTypeItem(AlterTypeItemContext ctx) {
        return super.visitAlterTypeItem(ctx);
    }

    @Override
    public OracleSQLReplaceClause visitReplaceClause(ReplaceClauseContext ctx) {
        OracleSQLReplaceClause x = new OracleSQLReplaceClause();

        for (ReplaceClauseOptionContext replaceClauseOptionContext : ctx.replaceClauseOption()) {
            SQLExpr option = (SQLExpr) visitChildren(replaceClauseOptionContext);
            x.addOption(option);
        }

        for (ReplaceClauseItemContext replaceClauseItemContext : ctx.replaceClauseItem()) {
            SQLExpr item = (SQLExpr) visitChildren(replaceClauseItemContext);
            x.addItem(item);
        }
        return x;
    }

    @Override
    public SQLAlterTypeAddMethodsAction visitAlterTypeAddMethodsAction(AlterTypeAddMethodsActionContext ctx) {
        SQLAlterTypeAddMethodsAction x = new SQLAlterTypeAddMethodsAction();

        for (AlterTypeAddMethodsActionItemContext alterTypeAddMethodsActionContext : ctx.alterTypeAddMethodsActionItem()) {
            SQLAlterTypeAddMethodsAction.SQLItem item = visitAlterTypeAddMethodsActionItem(alterTypeAddMethodsActionContext);
            x.addItem(item);
        }
        return x;
    }

    @Override
    public SQLAlterTypeAddMethodsAction.SQLItem visitAlterTypeAddMethodsActionItem(AlterTypeAddMethodsActionItemContext ctx) {
        SQLAlterTypeAddMethodsAction.SQLItem x = new SQLAlterTypeAddMethodsAction.SQLItem();
        SQLExpr method = (SQLExpr) visitChildren(ctx.elementSpecItem());
        x.setMethod(method);
        return x;
    }

    @Override
    public SQLAlterTypeDropMethodsAction visitAlterTypeDropMethodsAction(AlterTypeDropMethodsActionContext ctx) {
        SQLAlterTypeDropMethodsAction x = new SQLAlterTypeDropMethodsAction();

        for (AlterTypeDropMethodsActionItemContext alterTypeDropMethodsActionItemContext : ctx.alterTypeDropMethodsActionItem()) {
            SQLAlterTypeDropMethodsAction.SQLItem item = visitAlterTypeDropMethodsActionItem(alterTypeDropMethodsActionItemContext);
            x.addItem(item);
        }
        return x;
    }

    @Override
    public SQLAlterTypeDropMethodsAction.SQLItem visitAlterTypeDropMethodsActionItem(AlterTypeDropMethodsActionItemContext ctx) {
        SQLAlterTypeDropMethodsAction.SQLItem x = new SQLAlterTypeDropMethodsAction.SQLItem();
        SQLExpr method = (SQLExpr) visitChildren(ctx.elementSpecItem());
        x.setMethod(method);
        return x;
    }

    @Override
    public SQLAlterTypeAddAttributeAction visitAlterTypeAddAttributeAction(AlterTypeAddAttributeActionContext ctx) {
        SQLAlterTypeAddAttributeAction x = new SQLAlterTypeAddAttributeAction();

        boolean paren = ctx.LEFT_PAREN() != null;
        x.setParen(paren);
        for (AttributeDefinitionContext attributeDefinitionContext : ctx.attributeDefinition()) {
            SQLAttributeDefinition attribute = visitAttributeDefinition(attributeDefinitionContext);
            x.addItem(attribute);
        }
        return x;
    }

    @Override
    public SQLAlterTypeModifyAttributeAction visitAlterTypeModifyAttributeAction(AlterTypeModifyAttributeActionContext ctx) {
        SQLAlterTypeModifyAttributeAction x = new SQLAlterTypeModifyAttributeAction();

        boolean paren = ctx.LEFT_PAREN() != null;
        x.setParen(paren);
        for (AttributeDefinitionContext attributeDefinitionContext : ctx.attributeDefinition()) {
            SQLAttributeDefinition attribute = visitAttributeDefinition(attributeDefinitionContext);
            x.addItem(attribute);
        }
        return x;
    }

    @Override
    public SQLAlterTypeDropAttributeAction visitAlterTypeDropAttributeAction(AlterTypeDropAttributeActionContext ctx) {
        SQLAlterTypeDropAttributeAction x = new SQLAlterTypeDropAttributeAction();

        boolean paren = ctx.LEFT_PAREN() != null;
        x.setParen(paren);

        for (ExprContext exprContext : ctx.expr()) {
            SQLExpr item = visitExpr(exprContext);
            x.addItem(item);
        }
        return x;
    }

    @Override
    public SQLAlterTypeModifyLimitAction visitAlterTypeModifyLimitAction(AlterTypeModifyLimitActionContext ctx) {
        SQLAlterTypeModifyLimitAction x = new SQLAlterTypeModifyLimitAction();
        SQLExpr limit = visitExpr(ctx.expr());
        x.setLimit(limit);
        return x;
    }

    @Override
    public SQLAlterTypeModifyElementTypeAction visitAlterTypeElementTypeAction(AlterTypeElementTypeActionContext ctx) {
        SQLAlterTypeModifyElementTypeAction x = new SQLAlterTypeModifyElementTypeAction();
        SQLDataType dataType = visitDataType(ctx.dataType());
        x.setDataType(dataType);
        return x;
    }

    @Override
    public OracleSQLDependenthandlingClause.OracleSQLInvalidate visitDependentHandlingClauseInvalidate(DependentHandlingClauseInvalidateContext ctx) {
        return new OracleSQLDependenthandlingClause.OracleSQLInvalidate();
    }

    @Override
    public OracleSQLDependenthandlingClause.OracleSQLCascade visitDependentHandlingClauseCascade(DependentHandlingClauseCascadeContext ctx) {
        OracleSQLDependenthandlingClause.OracleSQLCascade x = new OracleSQLDependenthandlingClause.OracleSQLCascade();

        OracleSQLDependenthandlingClause.SQLCascadeOption option = null;
        if (ctx.CONVERT() != null
                && ctx.TO() != null
                && ctx.SUBSTITUTABLE() != null) {
            option = OracleSQLDependenthandlingClause.SQLCascadeOption.CONVERT_TO_SUBSTITUTABLE;

        } else if (ctx.INCLUDING() != null
                && ctx.TABLE() != null
                && ctx.DATA() != null) {
            option = OracleSQLDependenthandlingClause.SQLCascadeOption.INCLUDING_TABLE_DATA;
            if (ctx.NOT() != null) {
                option = OracleSQLDependenthandlingClause.SQLCascadeOption.NOT_INCLUDING_TABLE_DATA;
            }
        }
        x.setOption(option);

        if (ctx.FORCE() != null) {
            x.setForce(true);
        }

        if (ctx.exceptionsClause() != null) {
            SQExceptionsClause exceptionsClause = visitExceptionsClause(ctx.exceptionsClause());
            x.setExceptionsClause(exceptionsClause);
        }
        return x;
    }

    // -------------------------------- Type DDLs End

    // -------------------------------- Type Body DDLs Start

    @Override
    public SQLCreateTypeBodyStatement visitCreateTypeBodyStatement(CreateTypeBodyStatementContext ctx) {
        SQLCreateTypeBodyStatement x = new SQLCreateTypeBodyStatement(DBType.Oracle);

        if (ctx.orReplace() != null) {
            x.setOrReplace(true);
        }

        SQLEditionAbleType editionAbleType = of(ctx.editionableType());
        x.setEditionAbleType(editionAbleType);


        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);

        SQLASType as = of(ctx.asType());
        x.setAs(as);

        for (CreateTypeBodyStatementItemContext createTypeBodyStatementItemContext : ctx.createTypeBodyStatementItem()) {
            SQLExpr item = (SQLExpr) visitChildren(createTypeBodyStatementItemContext);
            x.addItem(item);
        }

        return x;
    }

    @Override
    public SQLDropTypeBodyStatement visitDropTypeBodyStatement(DropTypeBodyStatementContext ctx) {
        SQLDropTypeBodyStatement x = new SQLDropTypeBodyStatement(DBType.Oracle);
        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);
        return x;
    }
    // -------------------------------- Type Body DDLs End


    // -------------------------------- View DDLs Start
    @Override
    public SQLCreateViewStatement visitCreateViewStatement(CreateViewStatementContext ctx) {
        SQLCreateViewStatement x = new SQLCreateViewStatement(DBType.Oracle);

        if (ctx.orReplace() != null) {
            x.setOrReplace(true);
        }

        if (ctx.forceType() != null) {
            SQLForceType force = of(ctx.forceType());
            x.setForce(force);
        }

        if (ctx.editionableType() != null) {
            SQLEditionAbleType editionAble = of(ctx.editionableType());
            x.setEditionAble(editionAble);
        }

        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);

        if (ctx.sharingClause() != null) {
            SQLSharingClause sharingClause = visitSharingClause(ctx.sharingClause());
            x.setSharingClause(sharingClause);
        }

        if (ctx.dataType() != null) {
            SQLDataType ofDataType = visitDataType(ctx.dataType());
            x.setOfDataType(ofDataType);
        }

        if (ctx.xmlSchemaSpec() != null) {
            SQLXmlSchemaSpec xmlSchemaSpec = visitXmlSchemaSpec(ctx.xmlSchemaSpec());
            x.setXmlSchemaSpec(xmlSchemaSpec);
        }

        if (ctx.createViewSubView() != null) {
            SQLExpr subView = (SQLExpr) visit(ctx.createViewSubView());
            x.setSubView(subView);
        }

        for (TableElementContext tableElementContext : ctx.tableElement()) {
            SQLTableElement column = (SQLTableElement) visitChildren(tableElementContext);
            x.addColumn(column);
        }

        if (ctx.collationExpr() != null) {
            SQLCollationExpr collationExpr = visitCollationExpr(ctx.collationExpr());
            x.setCollationExpr(collationExpr);
        }

        ISQLSelectQuery subQuery = visitISelectQuery(ctx.iSelectQuery());
        x.setSubQuery(subQuery);

        if (ctx.iSubQueryRestrictionClause() != null) {
            ISQLSubqueryRestrictionClause subqueryRestriction = (ISQLSubqueryRestrictionClause) visit(ctx.iSubQueryRestrictionClause());
            x.setSubqueryRestriction(subqueryRestriction);
        }

        SQLCreateViewStatement.SQLContainerType container = null;
        if (ctx.CONTAINER_MAP() != null) {
            container = SQLCreateViewStatement.SQLContainerType.CONTAINER_MAP;
        } else if (ctx.CONTAINERS_DEFAULT() != null) {
            container = SQLCreateViewStatement.SQLContainerType.CONTAINERS_DEFAULT;
        }
        x.setContainer(container);

        return x;
    }

    @Override
    public SQLAlterViewStatement visitAlterViewStatement(AlterViewStatementContext ctx) {
        SQLAlterViewStatement x = new SQLAlterViewStatement(DBType.Oracle);

        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);

        SQLExpr item = (SQLExpr) visit(ctx.alterViewAction());
        x.setAction(item);

        return x;
    }

    @Override
    public SQLDropViewStatement visitDropViewStatement(OracleSQLStatementParser.DropViewStatementContext ctx) {
        SQLDropViewStatement x = new SQLDropViewStatement(DBType.Oracle);

        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.addName(name);

        if (ctx.CASCADE() != null
                && ctx.CONSTRAINTS() != null) {
            x.setBehavior(SQLCascadeType.CASCADE_CONSTRAINTS);
        }
        return x;
    }

    @Override
    public ISQLWithObjectIdClause.SQLWithObjectIdentifierClause visitWithObjectIdentifierClause(WithObjectIdentifierClauseContext ctx) {
        ISQLWithObjectIdClause.SQLWithObjectIdentifierClause x = new ISQLWithObjectIdClause.SQLWithObjectIdentifierClause();
        SQLExpr expr = visitExpr(ctx.expr());
        x.setExpr(expr);
        return x;
    }

    @Override
    public ISQLWithObjectIdClause.SQLWithObjectIdClause visitWithObjectIdClause(WithObjectIdClauseContext ctx) {
        ISQLWithObjectIdClause.SQLWithObjectIdClause x = new ISQLWithObjectIdClause.SQLWithObjectIdClause();
        SQLExpr expr = visitExpr(ctx.expr());
        x.setExpr(expr);
        return x;
    }

    @Override
    public SQLObject visitSubViewClause(SubViewClauseContext ctx) {
        return super.visitSubViewClause(ctx);
    }

    @Override
    public SQLAlterViewAddTableConstraintAction visitAlterViewAddTableConstraintAction(AlterViewAddTableConstraintActionContext ctx) {
        SQLAlterViewAddTableConstraintAction x = new SQLAlterViewAddTableConstraintAction();

        ISQLTableConstraint constraint = (ISQLTableConstraint) visit(ctx.tableConstraint());
        x.setConstraint(constraint);
        return x;
    }

    @Override
    public SQLAlterViewModifyConstraintAction visitAlterViewModifyConstraintAction(AlterViewModifyConstraintActionContext ctx) {
        SQLAlterViewModifyConstraintAction x = new SQLAlterViewModifyConstraintAction();

        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setConstraint(name);

        SQLAlterViewModifyConstraintAction.SQLOption option = null;
        if (ctx.RELY() != null) {
            option = SQLAlterViewModifyConstraintAction.SQLOption.RELY;
        } else if (ctx.NORELY() != null) {
            option = SQLAlterViewModifyConstraintAction.SQLOption.NORELY;
        }
        x.setOption(option);
        return x;
    }

    @Override
    public SQLAlterViewDropConstraintAction visitAlterViewDropConstraintAction(AlterViewDropConstraintActionContext ctx) {
        SQLAlterViewDropConstraintAction x = new SQLAlterViewDropConstraintAction();
        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setConstraint(name);
        return x;
    }

    @Override
    public SQLAlterViewDropPrimaryKeyConstraintAction visitAlterViewDropPrimaryKeyConstraintAction(AlterViewDropPrimaryKeyConstraintActionContext ctx) {
        return new SQLAlterViewDropPrimaryKeyConstraintAction();
    }

    @Override
    public SQLAlterViewDropUniqueConstraintAction visitAlterViewDropUniqueConstraintAction(AlterViewDropUniqueConstraintActionContext ctx) {
        SQLAlterViewDropUniqueConstraintAction x = new SQLAlterViewDropUniqueConstraintAction();
        for (ExprContext exprContext : ctx.expr()) {
            SQLExpr column = visitExpr(exprContext);
            x.addColumn(column);
        }
        return x;
    }


    @Override
    public SQLAlterViewCompileAction visitAlterViewCompileAction(AlterViewCompileActionContext ctx) {
        return new SQLAlterViewCompileAction();
    }

    @Override
    public SQLAlterViewReadOnlyAction visitAlterViewReadOnlyAction(AlterViewReadOnlyActionContext ctx) {
        return new SQLAlterViewReadOnlyAction();
    }

    @Override
    public SQLAlterViewReadWriteAction visitAlterViewReadWriteAction(AlterViewReadWriteActionContext ctx) {
        return new SQLAlterViewReadWriteAction();
    }

    @Override
    public SQLAlterViewEditionableAction visitAlterViewEditionableAction(AlterViewEditionableActionContext ctx) {
        return new SQLAlterViewEditionableAction();
    }

    @Override
    public SQLAlterViewNonEditionableAction visitAlterViewNonEditionableAction(AlterViewNonEditionableActionContext ctx) {
        return new SQLAlterViewNonEditionableAction();
    }
    // -------------------------------- View DDLs End


    // -------------------------------- Materialized View DDLs Start
    @Override
    public SQLCreateMaterializedViewStatement visitCreateMaterializedViewStatement(CreateMaterializedViewStatementContext ctx) {
        SQLCreateMaterializedViewStatement x = new SQLCreateMaterializedViewStatement(DBType.Oracle);

        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);

        for (CreateMaterializedViewStatementColumnContext createMaterializedViewStatementColumnContext : ctx.columns) {
            SQLCreateMaterializedViewStatement.SQLColumn column = visitCreateMaterializedViewStatementColumn(createMaterializedViewStatementColumnContext);
            x.addColumn(column);
        }

        if (ctx.ofDataType != null) {
            SQLDataType dataType = visitDataType(ctx.ofDataType);
            x.setOfDataType(dataType);
        }

        for (ICreateMaterializedViewStatementColumnContext createMaterializedViewStatementColumnContext : ctx.columnConstraints) {
            SQLExpr columnConstraint = (SQLExpr) visitChildren(createMaterializedViewStatementColumnContext);
            x.addColumnConstraint(columnConstraint);
        }

        if (ctx.collationExpr() != null) {
            SQLCollationExpr collationExpr = visitCollationExpr(ctx.collationExpr());
            x.setCollationExpr(collationExpr);
        }

        for (CreateMaterializedViewStatementPropertyContext createMaterializedViewStatementPropertyContext : ctx.createMaterializedViewStatementProperty()) {
            SQLExpr property = (SQLExpr) visit(createMaterializedViewStatementPropertyContext);
            x.addProperty(property);
        }

        if (ctx.iUsingIndexClause() != null) {
            ISQLUsingIndexClause usingIndex = (ISQLUsingIndexClause) visit(ctx.iUsingIndexClause());
            x.setUsingIndex(usingIndex);
        }

        if (ctx.iCreateMVRefresh() != null) {
            ISQLCreateMVRefresh createMVRefresh = (ISQLCreateMVRefresh) visit(ctx.iCreateMVRefresh());
            x.setCreateMVRefresh(createMVRefresh);
        }

        if (ctx.evaluationEditionClause() != null) {
            SQLEvaluationEditionClause evaluationEditionClause = visitEvaluationEditionClause(ctx.evaluationEditionClause());
            x.setEvaluationEditionClause(evaluationEditionClause);
        }

        if (ctx.forUpdate() != null) {
            x.setForUpdate(true);
        }

        if (ctx.onQueryComputationClause() != null) {
            SQLOnQueryComputationClause onQueryComputationClause = visitOnQueryComputationClause(ctx.onQueryComputationClause());
            x.setOnQueryComputationClause(onQueryComputationClause);
        }

        if (ctx.queryRewriteClause() != null) {
            SQLQueryRewriteClause queryRewriteClause = visitQueryRewriteClause(ctx.queryRewriteClause());
            x.setQueryRewriteClause(queryRewriteClause);
        }

        ISQLSelectQuery subQuery = visitISelectQuery(ctx.iSelectQuery());
        x.setAsSubQuery(subQuery);

        return x;
    }

    @Override
    public SQLAlterMaterializedViewStatement visitAlterMaterializedViewStatement(AlterMaterializedViewStatementContext ctx) {
        SQLAlterMaterializedViewStatement x = new SQLAlterMaterializedViewStatement(DBType.Oracle);

        return x;
    }

    @Override
    public SQLDropMaterializedViewStatement visitDropMaterializedViewStatement(DropMaterializedViewStatementContext ctx) {
        SQLDropMaterializedViewStatement x = new SQLDropMaterializedViewStatement(DBType.Oracle);

        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.addName(name);

        if (ctx.PRESERVE() != null
                && ctx.TABLE() != null) {
            x.setOption(SQLDropMaterializedViewStatement.SQLOption.PRESERVE_TABLE);
        }

        return x;
    }

    // Materialized View - Specific Clauses
    @Override
    public SQLCreateMaterializedViewStatement.SQLColumn visitCreateMaterializedViewStatementColumn(CreateMaterializedViewStatementColumnContext ctx) {
        SQLCreateMaterializedViewStatement.SQLColumn x = new SQLCreateMaterializedViewStatement.SQLColumn();
        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);

        if (ctx.encryptClause() != null) {
            SQLEncryptClause encryptClause = visitEncryptClause(ctx.encryptClause());
            x.setEncryptClause(encryptClause);
        }

        return x;
    }

    @Override
    public SQLOnPrebuiltTableProperty visitOnPrebuiltTableProperty(OnPrebuiltTablePropertyContext ctx) {
        SQLOnPrebuiltTableProperty x = new SQLOnPrebuiltTableProperty();

        SQLWithType reducedPrecisionAction = null;
        if (ctx.WITH() != null) {
            reducedPrecisionAction = SQLWithType.WITH;
        } else if (ctx.WITHOUT() != null) {
            reducedPrecisionAction = SQLWithType.WITHOUT;
        }
        x.setReducedPrecisionAction(reducedPrecisionAction);
        return x;
    }

    @Override
    public SQLUsingIndexClause visitUsingIndexClause(UsingIndexClauseContext ctx) {
        SQLUsingIndexClause x = new SQLUsingIndexClause();
        for (UsingIndexItemContext usingIndexItemContext : ctx.usingIndexItem()) {
            SQLExpr item = (SQLExpr) visitChildren(usingIndexItemContext);
            x.addItem(item);
        }

        return x;
    }

    @Override
    public SQLUsingNoIndexClause visitUsingNoIndexClause(UsingNoIndexClauseContext ctx) {
        return new SQLUsingNoIndexClause();
    }

    @Override
    public SQLUsingIndexClause.SQLCreateIndexStatementItem visitUsingIndexCreateIndexStatementItem(UsingIndexCreateIndexStatementItemContext ctx) {
        SQLUsingIndexClause.SQLCreateIndexStatementItem x = new SQLUsingIndexClause.SQLCreateIndexStatementItem();
        SQLCreateIndexStatement createIndexStatement = visitCreateIndexStatement(ctx.createIndexStatement());
        x.setCreateIndexStatement(createIndexStatement);

        return x;
    }

    @Override
    public SQLCreateMVRefresh visitCreateMVRefresh(CreateMVRefreshContext ctx) {
        SQLCreateMVRefresh x = new SQLCreateMVRefresh();
        for (CreateMVRefreshItemContext createMVRefreshItemContext : ctx.createMVRefreshItem()) {
            SQLCreateMVRefresh.SQLCreateMVRefreshItem item = (SQLCreateMVRefresh.SQLCreateMVRefreshItem) visit(createMVRefreshItemContext);
            x.addItem(item);
        }
        return x;
    }

    @Override
    public SQLCreateMVNeverRefresh visitCreateMVNeverRefresh(CreateMVNeverRefreshContext ctx) {
        return new SQLCreateMVNeverRefresh();
    }

    @Override
    public SQLCreateMVRefresh.SQLCreateMVRefreshFastItem visitCreateMVRefreshFastItem(CreateMVRefreshFastItemContext ctx) {
        return new SQLCreateMVRefresh.SQLCreateMVRefreshFastItem();
    }

    @Override
    public SQLCreateMVRefresh.SQLCreateMVRefreshCompleteItem visitCreateMVRefreshCompleteItem(CreateMVRefreshCompleteItemContext ctx) {
        return new SQLCreateMVRefresh.SQLCreateMVRefreshCompleteItem();
    }

    @Override
    public SQLCreateMVRefresh.SQLCreateMVRefreshForceItem visitCreateMVRefreshForceItem(CreateMVRefreshForceItemContext ctx) {
        return new SQLCreateMVRefresh.SQLCreateMVRefreshForceItem();
    }

    @Override
    public SQLCreateMVRefresh.SQLCreateMVRefreshOnDemandItem visitCreateMVRefreshOnDemandItem(CreateMVRefreshOnDemandItemContext ctx) {
        return new SQLCreateMVRefresh.SQLCreateMVRefreshOnDemandItem();
    }

    @Override
    public SQLCreateMVRefresh.SQLCreateMVRefreshOnCommitItem visitCreateMVRefreshOnCommitItem(CreateMVRefreshOnCommitItemContext ctx) {
        return new SQLCreateMVRefresh.SQLCreateMVRefreshOnCommitItem();
    }

    @Override
    public SQLCreateMVRefresh.SQLCreateMVRefreshOnStatementItem visitCreateMVRefreshOnStatementItem(CreateMVRefreshOnStatementItemContext ctx) {
        return new SQLCreateMVRefresh.SQLCreateMVRefreshOnStatementItem();
    }

    @Override
    public SQLCreateMVRefresh.SQLCreateMVRefreshStartWithItem visitCreateMVRefreshStartWithItem(CreateMVRefreshStartWithItemContext ctx) {
        SQLCreateMVRefresh.SQLCreateMVRefreshStartWithItem x = new SQLCreateMVRefresh.SQLCreateMVRefreshStartWithItem();
        SQLExpr expr = visitExpr(ctx.expr());
        x.setValue(expr);
        return x;
    }

    @Override
    public SQLCreateMVRefresh.SQLCreateMVRefreshNextItem visitCreateMVRefreshNextItem(CreateMVRefreshNextItemContext ctx) {
        SQLCreateMVRefresh.SQLCreateMVRefreshNextItem x = new SQLCreateMVRefresh.SQLCreateMVRefreshNextItem();
        SQLExpr expr = visitExpr(ctx.expr());
        x.setValue(expr);
        return x;
    }

    @Override
    public SQLCreateMVRefresh.SQLCreateMVRefreshWithPrimaryKeyItem visitCreateMVRefreshWithPrimaryKeyItem(CreateMVRefreshWithPrimaryKeyItemContext ctx) {
        return new SQLCreateMVRefresh.SQLCreateMVRefreshWithPrimaryKeyItem();
    }

    @Override
    public SQLCreateMVRefresh.SQLCreateMVRefreshWithRowidItem visitCreateMVRefreshWithRowidItem(CreateMVRefreshWithRowidItemContext ctx) {
        return new SQLCreateMVRefresh.SQLCreateMVRefreshWithRowidItem();
    }

    @Override
    public SQLCreateMVRefresh.SQLCreateMVRefreshUsingRollbackSegmentItem visitCreateMVRefreshUsingRollbackSegmentItem(CreateMVRefreshUsingRollbackSegmentItemContext ctx) {
        SQLCreateMVRefresh.SQLCreateMVRefreshUsingRollbackSegmentItem x = new SQLCreateMVRefresh.SQLCreateMVRefreshUsingRollbackSegmentItem();

        for (UsingRollbackSegmentItemContext usingRollbackSegmentItemContext : ctx.usingRollbackSegmentItem()) {
            SQLExpr item = (SQLExpr) visit(usingRollbackSegmentItemContext);
            x.addItem(item);
        }
        return x;
    }

    @Override
    public SQLCreateMVRefresh.SQLCreateMVRefreshUsingEnforcedConstraintsItem visitCreateMVRefreshUsingEnforcedConstraintsItem(CreateMVRefreshUsingEnforcedConstraintsItemContext ctx) {
        return new SQLCreateMVRefresh.SQLCreateMVRefreshUsingEnforcedConstraintsItem();
    }

    @Override
    public SQLCreateMVRefresh.SQLCreateMVRefreshUsingTrustedConstraintsItem visitCreateMVRefreshUsingTrustedConstraintsItem(CreateMVRefreshUsingTrustedConstraintsItemContext ctx) {
        return new SQLCreateMVRefresh.SQLCreateMVRefreshUsingTrustedConstraintsItem();
    }

    @Override
    public SQLCreateMVRefresh.SQLUsingRollbackSegmentByDefaultItem visitUsingRollbackSegmentByDefaultItem(UsingRollbackSegmentByDefaultItemContext ctx) {
        SQLCreateMVRefresh.SQLUsingRollbackSegmentByDefaultItem x = new SQLCreateMVRefresh.SQLUsingRollbackSegmentByDefaultItem();

        if (ctx.usingRollbackSegmentOptionType() != null) {
            SQLCreateMVRefresh.SQLUsingRollbackSegmentOptionType optionType = of(ctx.usingRollbackSegmentOptionType());
            x.setOptionType(optionType);
        }
        return x;
    }

    @Override
    public SQLCreateMVRefresh.SQLUsingRollbackSegmentByNoDefaultItem visitUsingRollbackSegmentByNoDefaultItem(UsingRollbackSegmentByNoDefaultItemContext ctx) {
        SQLCreateMVRefresh.SQLUsingRollbackSegmentByNoDefaultItem x = new SQLCreateMVRefresh.SQLUsingRollbackSegmentByNoDefaultItem();

        if (ctx.usingRollbackSegmentOptionType() != null) {
            SQLCreateMVRefresh.SQLUsingRollbackSegmentOptionType optionType = of(ctx.usingRollbackSegmentOptionType());
            x.setOptionType(optionType);
        }

        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);
        return x;
    }

    public SQLCreateMVRefresh.SQLUsingRollbackSegmentOptionType of(UsingRollbackSegmentOptionTypeContext ctx) {
        if (ctx == null) {
            return null;
        }

        SQLCreateMVRefresh.SQLUsingRollbackSegmentOptionType x = SQLCreateMVRefresh.SQLUsingRollbackSegmentOptionType.LOCAL;
        if (ctx.MASTER() != null) {
            x = SQLCreateMVRefresh.SQLUsingRollbackSegmentOptionType.MASTER;
        }
        return x;
    }

    @Override
    public SQLOnQueryComputationClause visitOnQueryComputationClause(OnQueryComputationClauseContext ctx) {
        SQLOnQueryComputationClause x = new SQLOnQueryComputationClause();
        SQLEnableType enableType = of(ctx.enableType());
        x.setAction(enableType);
        return x;
    }

    @Override
    public SQLQueryRewriteClause visitQueryRewriteClause(QueryRewriteClauseContext ctx) {
        SQLQueryRewriteClause x = new SQLQueryRewriteClause();
        SQLEnableType enableType = of(ctx.enableType());
        x.setAction(enableType);

        if (ctx.unusableEditionsClause() != null) {
            SQLUnusableEditionsClause unusableEditionsClause = visitUnusableEditionsClause(ctx.unusableEditionsClause());
            x.setUnusableEditionsClause(unusableEditionsClause);
        }
        return x;
    }

    @Override
    public SQLObject visitAlterMaterializedViewStatementProperty(AlterMaterializedViewStatementPropertyContext ctx) {
        return super.visitAlterMaterializedViewStatementProperty(ctx);
    }


    // -------------------------------- Materialized View DDLs End

    // --------------------------------------- DDL End ----------------------------------------------------------------


    // --------------------------------------- DML Start ----------------------------------------------------------------

    @Override
    public SQLCallStatement visitCallStatement(CallStatementContext ctx) {
        SQLCallStatement x = new SQLCallStatement(DBType.Oracle);

        SQLExpr expr = visitExpr(ctx.call);
        x.setExpr(expr);

        SQLExpr into = visitExpr(ctx.into);
        x.setInto(into);

        return x;
    }

    @Override
    public SQLSelectIntoStatement visitSelectIntoStatement(SelectIntoStatementContext ctx) {
        SQLSelectIntoStatement x = new SQLSelectIntoStatement(DBType.Oracle);

        SQLSetQuantifier setQuantifier = of(ctx.setQuantifier());
        x.setSetQuantifier(setQuantifier);

        for (SelectItemContext selectItemContext : ctx.selectItem()) {
            SQLSelectItem selectItem = visitSelectItem(selectItemContext);
            x.addSelectItem(selectItem);
        }

        if (ctx.bulkCollect() != null) {
            x.setBulkCollect(true);
        }

        for (SelectTargetItemContext selectTargetItemContext : ctx.selectTargetItem()) {
            SQLSelectTargetItem selectTargetItem = visitSelectTargetItem(selectTargetItemContext);
            x.addSelectTargetItem(selectTargetItem);
        }

        if (ctx.fromClause() != null) {
            SQLFromClause fromClause = visitFromClause(ctx.fromClause());
            x.setFromClause(fromClause);
        }

        if (ctx.whereClause() != null) {
            SQLWhereClause whereClause = visitWhereClause(ctx.whereClause());
            x.setWhereClause(whereClause);
        }

        if (ctx.hierarchicalQueryClause() != null) {
            SQLHierarchicalQueryClause hierarchicalQueryClause = (SQLHierarchicalQueryClause) visit(ctx.hierarchicalQueryClause());
            x.setHierarchicalQueryClause(hierarchicalQueryClause);
        }

        if (ctx.groupByClause() != null) {
            SQLGroupByClause groupByClause = (SQLGroupByClause) visit(ctx.groupByClause());
            x.setGroupByClause(groupByClause);
        }

        if (ctx.orderByClause() != null) {
            SQLOrderByClause orderByClause = visitOrderByClause(ctx.orderByClause());
            x.setOrderByClause(orderByClause);
        }

        if (ctx.rowLimitingClause() != null) {
            ISQLLimitClause limitClause = visitRowLimitingClause(ctx.rowLimitingClause());
            x.setLimitClause(limitClause);
        }

        if (ctx.forUpdateClause() != null) {
            SQLForUpdateClause forUpdateClause = visitForUpdateClause(ctx.forUpdateClause());
            x.setLockClause(forUpdateClause);
        }

        return x;
    }

    @Override
    public SQLSelectTargetItem visitSelectTargetItem(SelectTargetItemContext ctx) {
        SQLExpr expr = visitExpr(ctx.expr());
        return new SQLSelectTargetItem(expr);
    }

    @Override
    public SQLUpdateStatement visitUpdateStatement(UpdateStatementContext ctx) {
        SQLUpdateStatement x = new SQLUpdateStatement(DBType.Oracle);

        ISQLTableReference tableReference = (ISQLTableReference) visit(ctx.iTableReference());
        x.setTableReference(tableReference);

        ISQLUpdateSetClause updateSetClause = (ISQLUpdateSetClause) visit(ctx.iUpdateSetClause());
        x.setUpdateSetClause(updateSetClause);

        if (ctx.whereClause() != null) {
            SQLWhereClause whereClause = visitWhereClause(ctx.whereClause());
            x.setWhereClause(whereClause);
        }

        if (ctx.returningIntoClause() != null) {
            SQLReturningIntoClause returningIntoClause = visitReturningIntoClause(ctx.returningIntoClause());
            x.setReturningClause(returningIntoClause);
        }

        if (ctx.errorLoggingClause() != null) {
            SQLErrorLoggingClause errorLoggingClause = visitErrorLoggingClause(ctx.errorLoggingClause());
            x.setErrorLoggingClause(errorLoggingClause);
        }

        return x;
    }


    @Override
    public SQLUpdateSetClause visitUpdateSetClause(UpdateSetClauseContext ctx) {
        SQLUpdateSetClause x = new SQLUpdateSetClause();

        for (UpdateSetItemClauseContext updateSetItemClauseContext : ctx.updateSetItemClause()) {
            SQLUpdateSetClause.SQLUpdateSetItemClause item = visitUpdateSetItemClause(updateSetItemClauseContext);
            x.addItem(item);
        }

        return x;
    }

    @Override
    public SQLUpdateSetByValueClause visitUpdateSetByValueClause(UpdateSetByValueClauseContext ctx) {
        SQLExpr column = visitExpr(ctx.column);
        SQLExpr value = visitExpr(ctx.value);

        return new SQLUpdateSetByValueClause(column, value);
    }

    @Override
    public SQLUpdateSetClause.SQLUpdateSetItemClause visitUpdateSetItemClause(UpdateSetItemClauseContext ctx) {
        SQLExpr column = visitExpr(ctx.column);
        SQLExpr value = visitExpr(ctx.value);

        return new SQLUpdateSetClause.SQLUpdateSetItemClause(column, value);
    }

    @Override
    public SQLLockTableStatement visitLockTableStatement(LockTableStatementContext ctx) {
        SQLLockTableStatement x = new SQLLockTableStatement(DBType.Oracle);

        for (LockTableItemContext lockTableItemContext : ctx.lockTableItem()) {
            SQLLockTableStatement.SQLLockTableItem item = visitLockTableItem(lockTableItemContext);
            x.addItem(item);
        }

        String lockModeName = getText(ctx.lockMode().children);
        SQLLockTableStatement.SQLLockMode lockMode = SQLLockTableStatement.SQLLockMode.of(lockModeName);
        x.setLockMode(lockMode);

        if (ctx.forUpdateOption() != null) {
            SQLForUpdateClause.SQLForOption option = (SQLForUpdateClause.SQLForOption) visit(ctx.forUpdateOption());
            x.setOption(option);
        }


        return x;
    }

    @Override
    public SQLLockTableStatement.SQLLockTableItem visitLockTableItem(LockTableItemContext ctx) {
        SQLLockTableStatement.SQLLockTableItem x = new SQLLockTableStatement.SQLLockTableItem();
        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);

        if (ctx.iPartitionClause() != null) {
            ISQLPartitionClause partitionClause = (ISQLPartitionClause) visit(ctx.iPartitionClause());
            x.setPartitionClause(partitionClause);
        }
        return x;
    }

    @Override
    public SQLDeleteStatement visitDeleteStatement(DeleteStatementContext ctx) {
        SQLDeleteStatement x = new SQLDeleteStatement(DBType.Oracle);

        if (ctx.FROM() == null) {
            x.setFrom(false);
        }

        ISQLTableReference tableReference = (ISQLTableReference) visit(ctx.iTableReference());
        x.setTableReference(tableReference);

        if (ctx.whereClause() != null) {
            SQLWhereClause whereClause = visitWhereClause(ctx.whereClause());
            x.setWhereClause(whereClause);
        }

        if (ctx.returningIntoClause() != null) {
            SQLReturningIntoClause returningIntoClause = visitReturningIntoClause(ctx.returningIntoClause());
            x.setReturningClause(returningIntoClause);
        }

        if (ctx.errorLoggingClause() != null) {
            SQLErrorLoggingClause errorLoggingClause = visitErrorLoggingClause(ctx.errorLoggingClause());
            x.setErrorLoggingClause(errorLoggingClause);
        }

        return x;
    }

    @Override
    public SQLInsertStatement visitInsertStatement(InsertStatementContext ctx) {
        SQLInsertStatement x = new SQLInsertStatement(DBType.Oracle);

        ISQLTableReference tableReference = (ISQLTableReference) visit(ctx.iTableReference());
        x.setTableReference(tableReference);

        for (ExprContext exprContext : ctx.expr()) {
            SQLExpr column = visitExpr(exprContext);
            x.addColumn(column);
        }

        SQLExpr valueClause = (SQLExpr) visit(ctx.iValueClause());
        x.setValuesClause(valueClause);

        if (ctx.returningIntoClause() != null) {
            SQLReturningIntoClause returningIntoClause = visitReturningIntoClause(ctx.returningIntoClause());
            x.setReturningClause(returningIntoClause);
        }

        if (ctx.errorLoggingClause() != null) {
            SQLErrorLoggingClause errorLoggingClause = visitErrorLoggingClause(ctx.errorLoggingClause());
            x.setErrorLoggingClause(errorLoggingClause);
        }
        return x;
    }

    @Override
    public SQLMultiInsertStatement visitMultiInsertStatement(MultiInsertStatementContext ctx) {
        SQLMultiInsertStatement x = new SQLMultiInsertStatement(DBType.Oracle);

        SQLReserved option = null;
        if (ctx.ALL() != null) {
            option = SQLReserved.ALL;
        } else if (ctx.FIRST() != null) {
            option = SQLReserved.FIRST;
        }
        x.setOption(option);


        SQLExpr expr = (SQLExpr) visit(ctx.multiInsertClause());
        x.setExpr(expr);

        if (ctx.iSelectQuery() != null) {
            ISQLSelectQuery subQuery = (ISQLSelectQuery) visit(ctx.iSelectQuery());
            x.setSubQuery(subQuery);
        }


        return x;
    }

    @Override
    public SQLMultiInsertStatement.SQLInsertIntoClause visitMultiInsertIntoClause(MultiInsertIntoClauseContext ctx) {
        SQLMultiInsertStatement.SQLInsertIntoClause x = new SQLMultiInsertStatement.SQLInsertIntoClause();

        for (MultiInsertIntoClauseItemContext multiInsertIntoClauseItemContext : ctx.multiInsertIntoClauseItem()) {
            SQLMultiInsertStatement.SQLInsertIntoClauseItem item = visitMultiInsertIntoClauseItem(multiInsertIntoClauseItemContext);
            x.addItem(item);
        }

        return x;
    }

    @Override
    public SQLMultiInsertStatement.SQLConditionalInsertIntoClause visitMultiConditionalInsertIntoClause(MultiConditionalInsertIntoClauseContext ctx) {
        SQLMultiInsertStatement.SQLConditionalInsertIntoClause x = new SQLMultiInsertStatement.SQLConditionalInsertIntoClause();

        for (MultiConditionalInsertWhenClauseContext multiConditionalInsertWhenClauseContext : ctx.multiConditionalInsertWhenClause()) {
            SQLMultiInsertStatement.SQLConditionalInsertWhenClause whenClause = visitMultiConditionalInsertWhenClause(multiConditionalInsertWhenClauseContext);
            x.addWhenClause(whenClause);
        }

        if (ctx.multiInsertIntoClauseItem() != null
                && ctx.multiInsertIntoClauseItem().size() > 0) {

            for (MultiInsertIntoClauseItemContext multiInsertIntoClauseItemContext : ctx.multiInsertIntoClauseItem()) {
                SQLMultiInsertStatement.SQLInsertIntoClauseItem elseItem = visitMultiInsertIntoClauseItem(multiInsertIntoClauseItemContext);
                x.addElseItem(elseItem);
            }
        }

        return x;
    }

    @Override
    public SQLMultiInsertStatement.SQLInsertIntoClauseItem visitMultiInsertIntoClauseItem(MultiInsertIntoClauseItemContext ctx) {
        SQLMultiInsertStatement.SQLInsertIntoClauseItem x = new SQLMultiInsertStatement.SQLInsertIntoClauseItem();

        ISQLTableReference tableReference = (ISQLTableReference) visit(ctx.iTableReference());
        x.setTableReference(tableReference);

        for (ExprContext exprContext : ctx.expr()) {
            SQLExpr column = visitExpr(exprContext);
            x.addColumn(column);
        }

        if (ctx.valuesClause() != null) {
            SQLValuesClause valueClause = visitValuesClause(ctx.valuesClause());
            x.setValuesClause(valueClause);
        }

        if (ctx.returningIntoClause() != null) {
            visitReturningIntoClause(ctx.returningIntoClause());
        }

        if (ctx.errorLoggingClause() != null) {
            visitErrorLoggingClause(ctx.errorLoggingClause());
        }


        return x;
    }

    @Override
    public SQLMultiInsertStatement.SQLConditionalInsertWhenClause visitMultiConditionalInsertWhenClause(MultiConditionalInsertWhenClauseContext ctx) {
        SQLMultiInsertStatement.SQLConditionalInsertWhenClause x = new SQLMultiInsertStatement.SQLConditionalInsertWhenClause();

        SQLExpr condition = visitExpr(ctx.expr());
        x.setCondition(condition);

        for (MultiInsertIntoClauseItemContext multiInsertIntoClauseItemContext : ctx.multiInsertIntoClauseItem()) {
            SQLMultiInsertStatement.SQLInsertIntoClauseItem item = visitMultiInsertIntoClauseItem(multiInsertIntoClauseItemContext);
            x.addThenItem(item);
        }
        return x;
    }

    @Override
    public SQLValuesClause visitValuesClause(ValuesClauseContext ctx) {
        SQLValuesClause x = new SQLValuesClause();

        for (ValuesClauseItemContext valuesClauseItemContext : ctx.valuesClauseItem()) {
            SQLValuesClause.SQLValuesItem item = visitValuesClauseItem(valuesClauseItemContext);
            x.addValue(item);
        }

        return x;
    }

    @Override
    public SQLValuesClause.SQLValuesItem visitValuesClauseItem(ValuesClauseItemContext ctx) {
        SQLValuesClause.SQLValuesItem x = new SQLValuesClause.SQLValuesItem();

        for (ExprContext exprContext : ctx.expr()) {
            SQLExpr column = visitExpr(exprContext);
            x.addColumn(column);
        }
        return x;
    }

    // --------------------------------------- DML End ----------------------------------------------------------------


    // --------------------------------------- TCL Start ----------------------------------------------------------------
    @Override
    public SQLCommitStatement visitCommitStatement(CommitStatementContext ctx) {
        SQLCommitStatement x = new SQLCommitStatement(DBType.Oracle);

        if (ctx.WORK() != null) {
            x.setAction(SQLCommitStatement.SQLAction.WORK);
        }

        for (CommitStatementOptionContext commitStatementOptionContext : ctx.commitStatementOption()) {
            SQLCommitOption option = visitCommitStatementOption(commitStatementOptionContext);
            x.addOption(option);
        }
        return x;
    }

    @Override
    public SQLCommitOption visitCommitStatementOption(CommitStatementOptionContext ctx) {
        return (SQLCommitOption) super.visitChildren(ctx);
    }

    @Override
    public SQLCommitCommentOption visitCommitStatementCommentOption(CommitStatementCommentOptionContext ctx) {
        SQLCommitCommentOption x = new SQLCommitCommentOption();
        SQLExpr value = visitExpr(ctx.expr());
        x.setValue(value);
        return x;
    }

    @Override
    public SQLCommitWriteOption visitCommitStatementWriteOption(CommitStatementWriteOptionContext ctx) {
        SQLCommitWriteOption x = new SQLCommitWriteOption();

        SQLWaitType wait = null;
        if (ctx.WAIT() != null) {
            wait = SQLWaitType.WAIT;
        } else if (ctx.NOWAIT() != null) {
            wait = SQLWaitType.NOWAIT;
        }
        x.setWait(wait);

        SQLCommitWriteOption.SQLImmediateType immediate = null;
        if (ctx.IMMEDIATE() != null) {
            immediate = SQLCommitWriteOption.SQLImmediateType.IMMEDIATE;
        } else if (ctx.BATCH() != null) {
            immediate = SQLCommitWriteOption.SQLImmediateType.BATCH;
        }
        x.setImmediate(immediate);
        return x;
    }

    @Override
    public SQLCommitForceOption visitCommitStatementForceOption(CommitStatementForceOptionContext ctx) {
        SQLCommitForceOption x = new SQLCommitForceOption();

        SQLExpr id = visitExpr(ctx.id);
        x.setId(id);

        if (ctx.scn != null) {
            SQLExpr scn = visitExpr(ctx.scn);
            x.setScn(scn);
        }
        return x;
    }

    @Override
    public SQLRollbackStatement visitRollbackStatement(RollbackStatementContext ctx) {
        SQLRollbackStatement x = new SQLRollbackStatement(DBType.Oracle);

        if (ctx.WORK() != null) {
            x.setAction(SQLRollbackStatement.SQLAction.WORK);
        }

        for (RollbackStatementOptionContext rollbackStatementOptionContext : ctx.rollbackStatementOption()) {
            SQLRollbackOption option = visitRollbackStatementOption(rollbackStatementOptionContext);
            x.addOption(option);
        }
        return x;
    }

    @Override
    public SQLRollbackOption visitRollbackStatementOption(RollbackStatementOptionContext ctx) {
        return (SQLRollbackOption) super.visitChildren(ctx);
    }

    @Override
    public SQLRollbackToSavepointOption visitRollbackStatementToSavepointOption(RollbackStatementToSavepointOptionContext ctx) {
        SQLRollbackToSavepointOption x = new SQLRollbackToSavepointOption();

        if (ctx.SAVEPOINT() != null) {
            x.setSavepoint(true);
        }

        SQLExpr name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);
        return x;
    }

    @Override
    public SQLRollbackForceOption visitRollbackStatementForceOption(RollbackStatementForceOptionContext ctx) {
        SQLRollbackForceOption x = new SQLRollbackForceOption();
        SQLExpr expr = visitExpr(ctx.expr());
        x.setId(expr);
        return x;
    }

    @Override
    public SQLSavepointStatement visitSavepointStatement(SavepointStatementContext ctx) {
        SQLSavepointStatement x = new SQLSavepointStatement(DBType.Oracle);
        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);
        return x;
    }

    @Override
    public SQLSetTransactionStatement visitSetTransactionStatement(SetTransactionStatementContext ctx) {
        SQLSetTransactionStatement x = new SQLSetTransactionStatement(DBType.Oracle);
        for (SetTransactionStatementOptionContext setTransactionStatementOptionContext : ctx.setTransactionStatementOption()) {
            SQLSetTransactionOption option = visitSetTransactionStatementOption(setTransactionStatementOptionContext);
            x.addOption(option);
        }
        return x;
    }

    @Override
    public SQLSetTransactionOption visitSetTransactionStatementOption(SetTransactionStatementOptionContext ctx) {
        return (SQLSetTransactionOption) super.visitChildren(ctx);
    }

    @Override
    public SQLSetTransactionReadOnlyOption visitSetTransactionStatementReadOnlyOption(SetTransactionStatementReadOnlyOptionContext ctx) {
        return new SQLSetTransactionReadOnlyOption();
    }

    @Override
    public SQLSetTransactionReadWriteOption visitSetTransactionStatementReadWriteOption(SetTransactionStatementReadWriteOptionContext ctx) {
        return new SQLSetTransactionReadWriteOption();
    }

    @Override
    public SQLSetTransactionIsolationLevelOption visitSetTransactionStatementIsolationLevelOption(SetTransactionStatementIsolationLevelOptionContext ctx) {
        SQLSetTransactionIsolationLevelOption x = new SQLSetTransactionIsolationLevelOption();

        SQLSetTransactionIsolationLevelOption.SQLLevel level = SQLSetTransactionIsolationLevelOption.SQLLevel.SERIALIZABLE;
        if (ctx.READ() != null
                && ctx.COMMITTED() != null) {
            level = SQLSetTransactionIsolationLevelOption.SQLLevel.READ_COMMITTED;
        }
        x.setLevel(level);
        return x;
    }

    @Override
    public SQLSetTransactionUseRollbackSegmentOption visitSetTransactionStatementUseRollbackSegmentOption(SetTransactionStatementUseRollbackSegmentOptionContext ctx) {
        SQLSetTransactionUseRollbackSegmentOption x = new SQLSetTransactionUseRollbackSegmentOption();
        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);
        return x;
    }

    @Override
    public SQLSetTransactionNameOption visitSetTransactionStatementNameOption(SetTransactionStatementNameOptionContext ctx) {
        SQLSetTransactionNameOption x = new SQLSetTransactionNameOption();

        SQLExpr name = visitExpr(ctx.expr());
        x.setName(name);
        return x;
    }

    @Override
    public SQLSetConstraintStatement visitSetConstraintStatement(SetConstraintStatementContext ctx) {
        SQLSetConstraintStatement x = new SQLSetConstraintStatement(DBType.Oracle);

        if (ctx.ALL() != null) {
            x.addItem(ISQLSetConstraintsStatement.SQLAllItem.of());
        }

        for (NameIdentifierContext nameIdentifierContext : ctx.nameIdentifier()) {
            SQLName name = visitNameIdentifier(nameIdentifierContext);
            x.addItem(name);
        }

        ISQLSetConstraintsStatement.SQLOption option = null;
        if (ctx.IMMEDIATE() != null) {
            option = ISQLSetConstraintsStatement.SQLOption.IMMEDIATE;
        } else if (ctx.DEFERRED() != null) {
            option = ISQLSetConstraintsStatement.SQLOption.DEFERRED;
        }
        x.setOption(option);
        return x;
    }

    @Override
    public SQLSetConstraintsStatement visitSetConstraintsStatement(SetConstraintsStatementContext ctx) {
        SQLSetConstraintsStatement x = new SQLSetConstraintsStatement(DBType.Oracle);

        if (ctx.ALL() != null) {
            x.addItem(ISQLSetConstraintsStatement.SQLAllItem.of());
        }

        for (NameIdentifierContext nameIdentifierContext : ctx.nameIdentifier()) {
            SQLName name = visitNameIdentifier(nameIdentifierContext);
            x.addItem(name);
        }

        ISQLSetConstraintsStatement.SQLOption option = null;
        if (ctx.IMMEDIATE() != null) {
            option = ISQLSetConstraintsStatement.SQLOption.IMMEDIATE;
        } else if (ctx.DEFERRED() != null) {
            option = ISQLSetConstraintsStatement.SQLOption.DEFERRED;
        }
        x.setOption(option);
        return x;
    }

    // --------------------------------------- TCL End ----------------------------------------------------------------


    // --------------------------------------- Database Dlls Start ----------------------------------------------------------------
    @Override
    public SQLCreateDatabaseStatement visitCreateDatabaseStatement(OracleSQLStatementParser.CreateDatabaseStatementContext ctx) {

        SQLCreateDatabaseStatement x = new SQLCreateDatabaseStatement(DBType.Oracle);

        SQLName name = visitNameIdentifier(ctx.databaseName);
        x.setName(name);

        for (CreateDatabaseStatementItemContext createDatabaseStatementItemContext : ctx.createDatabaseStatementItem()) {
            SQLExpr item = (SQLExpr) visitChildren(createDatabaseStatementItemContext);
            x.addItem(item);
        }

        return x;
    }

    @Override
    public SQLAlterDatabaseStatement visitAlterDatabaseStatement(AlterDatabaseStatementContext ctx) {
        SQLAlterDatabaseStatement x = new SQLAlterDatabaseStatement(DBType.Oracle);

        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);


        return x;
    }

    @Override
    public SQLDropDatabaseStatement visitDropDatabaseStatement(DropDatabaseStatementContext ctx) {
        return new SQLDropDatabaseStatement(DBType.Oracle);
    }

    @Override
    public OracleSQLUserSysClause visitUserSysClause(OracleSQLStatementParser.UserSysClauseContext ctx) {

        String password = ctx.password.getText();
        SQLIdentifierImpl passwordExpr = new SQLIdentifierImpl(password);

        OracleSQLUserSysClause x = new OracleSQLUserSysClause(passwordExpr);

        return x;
    }

    @Override
    public OracleSQLUserSystemClause visitUserSystemClause(OracleSQLStatementParser.UserSystemClauseContext ctx) {

        String password = ctx.password.getText();
        SQLIdentifierImpl passwordExpr = new SQLIdentifierImpl(password);
        OracleSQLUserSystemClause x = new OracleSQLUserSystemClause(passwordExpr);

        return x;
    }


    @Override
    public SQLCharacterSetOptionExpr visitCharacterSetOptionExpr(CharacterSetOptionExprContext ctx) {

        SQLLiteral value = (SQLLiteral) visitChildren(ctx.charset);
        SQLCharacterSetOptionExpr x = new SQLCharacterSetOptionExpr(value);

        return x;
    }


    @Override
    public OracleSQLEnablePluggableDatabase visitEnablePluggableDatabase(EnablePluggableDatabaseContext ctx) {
        OracleSQLEnablePluggableDatabase x = new OracleSQLEnablePluggableDatabase();


        return x;
    }
    // --------------------------------------- Database Dlls End ----------------------------------------------------------------


    @Override
    public SQLCommentOnAuditPolicyStatement visitCommentOnAuditPolicyStatement(CommentOnAuditPolicyStatementContext ctx) {
        SQLCommentOnAuditPolicyStatement x = new SQLCommentOnAuditPolicyStatement(DBType.Oracle);

        SQLName policy = visitNameIdentifier(ctx.policy);
        x.setName(policy);

        SQLExpr comment = visitExpr(ctx.comment);
        x.setComment(comment);
        return x;
    }

    @Override
    public SQLCommentOnColumnStatement visitCommentOnColumnStatement(OracleSQLStatementParser.CommentOnColumnStatementContext ctx) {
        SQLCommentOnColumnStatement x = new SQLCommentOnColumnStatement(DBType.Oracle);

        SQLName column = visitNameIdentifier(ctx.column);
        x.setName(column);

        SQLExpr comment = visitExpr(ctx.comment);
        x.setComment(comment);
        return x;
    }

    @Override
    public SQLCommentOnEditionStatement visitCommentOnEditionStatement(CommentOnEditionStatementContext ctx) {
        SQLCommentOnEditionStatement x = new SQLCommentOnEditionStatement(DBType.Oracle);

        SQLName edition = visitNameIdentifier(ctx.edition);
        x.setName(edition);

        SQLExpr comment = visitExpr(ctx.comment);
        x.setComment(comment);
        return x;
    }

    @Override
    public SQLCommentOnIndexTypeStatement visitCommentOnIndexTypeStatement(CommentOnIndexTypeStatementContext ctx) {
        SQLCommentOnIndexTypeStatement x = new SQLCommentOnIndexTypeStatement(DBType.Oracle);

        SQLName indexType = visitNameIdentifier(ctx.indexType);
        x.setName(indexType);

        SQLExpr comment = visitExpr(ctx.comment);
        x.setComment(comment);
        return x;
    }

    @Override
    public SQLCommentOnMaterializedViewStatement visitCommentOnMaterializedViewStatement(CommentOnMaterializedViewStatementContext ctx) {
        SQLCommentOnMaterializedViewStatement x = new SQLCommentOnMaterializedViewStatement(DBType.Oracle);

        SQLName materializedView = visitNameIdentifier(ctx.materializedView);
        x.setName(materializedView);

        SQLExpr comment = visitExpr(ctx.comment);
        x.setComment(comment);
        return x;
    }

    @Override
    public SQLCommentOnMiningModelStatement visitCommentOnMiningModelStatement(CommentOnMiningModelStatementContext ctx) {
        SQLCommentOnMiningModelStatement x = new SQLCommentOnMiningModelStatement(DBType.Oracle);

        SQLName model = visitNameIdentifier(ctx.model);
        x.setName(model);

        SQLExpr comment = visitExpr(ctx.comment);
        x.setComment(comment);
        return x;
    }

    @Override
    public SQLCommentOnOperatorStatement visitCommentOnOperatorStatement(CommentOnOperatorStatementContext ctx) {
        SQLCommentOnOperatorStatement x = new SQLCommentOnOperatorStatement(DBType.Oracle);

        SQLName operator = visitNameIdentifier(ctx.operator);
        x.setName(operator);

        SQLExpr comment = visitExpr(ctx.comment);
        x.setComment(comment);
        return x;
    }

    @Override
    public SQLCommentOnTableStatement visitCommentOnTableStatement(OracleSQLStatementParser.CommentOnTableStatementContext ctx) {
        SQLCommentOnTableStatement x = new SQLCommentOnTableStatement(DBType.Oracle);
        SQLName table = visitNameIdentifier(ctx.table);
        x.setName(table);

        SQLExpr comment = visitExpr(ctx.comment);
        x.setComment(comment);
        return x;
    }


    @Override
    public SQLObject visitTable_indexed_by_part(OracleSQLStatementParser.Table_indexed_by_partContext ctx) {
        return super.visitTable_indexed_by_part(ctx);
    }


    @Override
    public SQLObject visitStatement(OracleSQLStatementParser.StatementContext ctx) {
        return super.visitStatement(ctx);
    }

    @Override
    public SQLObject visitFunction_call(OracleSQLStatementParser.Function_callContext ctx) {
        return super.visitFunction_call(ctx);
    }

    @Override
    public SQLObject visitExecute_immediate(OracleSQLStatementParser.Execute_immediateContext ctx) {
        return super.visitExecute_immediate(ctx);
    }

    @Override
    public SQLObject visitCursor_manipulation_statements(OracleSQLStatementParser.Cursor_manipulation_statementsContext ctx) {
        return super.visitCursor_manipulation_statements(ctx);
    }


    // ------------- Select Statement Start ----------------------------------------------------

    @Override
    public SQLSelectStatement visitSelectStatement(SelectStatementContext ctx) {

        SQLSelectStatement x = new SQLSelectStatement(DBType.Oracle);

        ISelectQueryContext queryContext = ctx.iSelectQuery();
        ISQLSelectQuery query = visitISelectQuery(queryContext);
        x.setQuery(query);
        return x;
    }

    @Override
    public ISQLSelectQuery visitISelectQuery(ISelectQueryContext ctx) {
        ISQLSelectQuery x = null;

        if (ctx.selectQueryBasic() != null) {
            x = visitSelectQueryBasic(ctx.selectQueryBasic());
        } else if (ctx.selectUnionQuery() != null) {
            x = visitSelectUnionQuery(ctx.selectUnionQuery());
        }

        return x;
    }

    @Override
    public ISQLSelectQuery visitSelectQueryBasic(SelectQueryBasicContext ctx) {
        return (ISQLSelectQuery) super.visitChildren(ctx);
    }

    @Override
    public OracleSQLSelectQuery visitSelectQuery(SelectQueryContext ctx) {

        OracleSQLSelectQuery x = new OracleSQLSelectQuery();
        if (ctx.withClause() != null) {
            OracleSQLWithClause withClause = visitWithClause(ctx.withClause());
            x.setWithClause(withClause);
        }

        if (ctx.setQuantifier() != null) {
            SQLSetQuantifier setQuantifier = null;

            if (ctx.setQuantifier().DISTINCT() != null) {
                setQuantifier = SQLSetQuantifier.DISTINCT;

            } else if (ctx.setQuantifier().UNIQUE() != null) {
                setQuantifier = SQLSetQuantifier.UNIQUE;

            } else if (ctx.setQuantifier().ALL() != null) {
                setQuantifier = SQLSetQuantifier.ALL;
            }

            x.setSetQuantifier(setQuantifier);
        }

        for (SelectItemContext context : ctx.selectItem()) {
            SQLSelectItem selectItem = visitSelectItem(context);
            x.addSelectItem(selectItem);
        }

        FromClauseContext fromClauseContext = ctx.fromClause();
        if (fromClauseContext != null) {
            SQLFromClause fromClause = visitFromClause(fromClauseContext);
            x.setFromClause(fromClause);
        }


        WhereClauseContext whereClauseContext = ctx.whereClause();
        if (whereClauseContext != null) {
            SQLWhereClause whereClause = visitWhereClause(whereClauseContext);
            x.setWhereClause(whereClause);
        }

        HierarchicalQueryClauseContext hierarchicalQueryClauseContext = ctx.hierarchicalQueryClause();
        if (hierarchicalQueryClauseContext != null) {
            SQLHierarchicalQueryClause hierarchicalQueryClause = (SQLHierarchicalQueryClause) visit(hierarchicalQueryClauseContext);
            x.setHierarchicalQueryClause(hierarchicalQueryClause);
        }

        GroupByClauseContext groupByClauseContext = ctx.groupByClause();
        if (groupByClauseContext != null) {
            SQLGroupByClause groupByClause = (SQLGroupByClause) visit(groupByClauseContext);
            x.setGroupByClause(groupByClause);
        }

        ModelClauseContext modelClauseContext = ctx.modelClause();
        if (modelClauseContext != null) {
            OracleSQLModelClause modelClause = visitModelClause(modelClauseContext);
            x.setModelClause(modelClause);
        }

        if (ctx.orderByClause() != null) {
            SQLOrderByClause orderByClause = visitOrderByClause(ctx.orderByClause());
            x.setOrderByClause(orderByClause);
        }

        if (ctx.rowLimitingClause() != null) {
            ISQLLimitClause limitClause = visitRowLimitingClause(ctx.rowLimitingClause());
            x.setLimitClause(limitClause);
        }

        ForUpdateClauseContext forUpdateClauseContext = ctx.forUpdateClause();
        if (forUpdateClauseContext != null) {
            SQLForUpdateClause forUpdateClause = visitForUpdateClause(forUpdateClauseContext);
            x.setLockClause(forUpdateClause);
        }

        return x;
    }

    @Override
    public SQLParenSelectQuery visitSelectParenQuery(SelectParenQueryContext ctx) {
        ISQLSelectQuery selectQuery = visitISelectQuery(ctx.iSelectQuery());
        SQLParenSelectQuery x = new SQLParenSelectQuery(selectQuery);

        if (ctx.orderByClause() != null) {
            SQLOrderByClause orderByClause = visitOrderByClause(ctx.orderByClause());
            x.setOrderByClause(orderByClause);
        }

        if (ctx.rowLimitingClause() != null) {
            ISQLLimitClause limitClause = visitRowLimitingClause(ctx.rowLimitingClause());
            x.setLimitClause(limitClause);
        }

        ForUpdateClauseContext forUpdateClauseContext = ctx.forUpdateClause();
        if (forUpdateClauseContext != null) {
            SQLForUpdateClause forUpdateClause = visitForUpdateClause(forUpdateClauseContext);
            x.setLockClause(forUpdateClause);
        }
        return x;
    }


    @Override
    public SQLSelectUnionQuery visitSelectUnionQuery(SelectUnionQueryContext ctx) {


        ISQLSelectQuery left = visitSelectQueryBasic(ctx.selectQueryBasic(0));

        SQLUnionOperator operator = of(ctx.unionOperator(0));
        ISQLSelectQuery right = visitSelectQueryBasic(ctx.selectQueryBasic(1));

        SQLSelectUnionQuery x = new SQLSelectUnionQuery(left, operator, right);

        for (int i = 2; i < ctx.selectQueryBasic().size(); i++) {
            SelectQueryBasicContext queryContext = ctx.selectQueryBasic(i);
            ISQLSelectQuery nextSelectQuery = visitSelectQueryBasic(queryContext);
            operator = of(ctx.unionOperator(i - 1));
            x = new SQLSelectUnionQuery(x, operator, nextSelectQuery);
        }


        if (ctx.orderByClause() != null) {
            SQLOrderByClause orderByClause = visitOrderByClause(ctx.orderByClause());
            x.setOrderByClause(orderByClause);
        }

        if (ctx.rowLimitingClause() != null) {
            ISQLLimitClause limitClause = visitRowLimitingClause(ctx.rowLimitingClause());
            x.setLimitClause(limitClause);
        }

        ForUpdateClauseContext forUpdateClauseContext = ctx.forUpdateClause();
        if (forUpdateClauseContext != null) {
            SQLForUpdateClause forUpdateClause = visitForUpdateClause(forUpdateClauseContext);
            x.setLockClause(forUpdateClause);
        }
        return x;
    }

    @Override
    public OracleSQLWithClause visitWithClause(WithClauseContext ctx) {
        OracleSQLWithClause x = new OracleSQLWithClause();

        for (PlsqlDeclarationContext plsqlDeclarationContext : ctx.plsqlDeclaration()) {
            SQLExpr declaration = (SQLExpr) visitChildren(plsqlDeclarationContext);
            x.addDeclaration(declaration);
        }

        for (WithElementContext withElementContext : ctx.withElement()) {
            SQLWithClause.SQLWithElement withElement = (SQLWithClause.SQLWithElement) visitChildren(withElementContext);
            x.addWithElement(withElement);
        }

        return x;
    }

    @Override
    public SQLWithClause.SQLSubQueryFactoringClause visitSubQueryFactoringClause(SubQueryFactoringClauseContext ctx) {
        SQLWithClause.SQLSubQueryFactoringClause x = new SQLWithClause.SQLSubQueryFactoringClause();


        SQLName queryName = visitNameIdentifier(ctx.queryName);
        x.setQueryName(queryName);

        for (NameIdentifierContext columnContext : ctx.columns) {
            SQLName column = visitNameIdentifier(columnContext);
            x.addColumn(column);
        }

        ISQLSelectQuery subQuery = visitISelectQuery(ctx.iSelectQuery());
        x.setStatement(subQuery);

        if (ctx.searchClause() != null) {
            SQLWithClause.SQLSearchClause searchClause = visitSearchClause(ctx.searchClause());
            x.setSearchClause(searchClause);
        }

        if (ctx.cycleClause() != null) {
            SQLWithClause.SQLCycleClause cycleClause = visitCycleClause(ctx.cycleClause());
            x.setCycleClause(cycleClause);
        }
        return x;
    }


    @Override
    public SQLWithClause.SQLSearchClause visitSearchClause(OracleSQLStatementParser.SearchClauseContext ctx) {
        SQLWithClause.SQLSearchClause x = new SQLWithClause.SQLSearchClause();

        SQLReserved type = SQLReserved.DEPTH;
        if (ctx.BREADTH() != null) {
            type = SQLReserved.BREADTH;
        }
        x.setType(type);

        for (OrderByItemContext orderByItemContext : ctx.orderByItem()) {
            SQLOrderByItem orderByItem = visitOrderByItem(orderByItemContext);
            x.addOrderByItem(orderByItem);
        }

        SQLName column = visitNameIdentifier(ctx.nameIdentifier());
        x.setColumn(column);

        return x;
    }

    @Override
    public SQLWithClause.SQLCycleClause visitCycleClause(OracleSQLStatementParser.CycleClauseContext ctx) {
        SQLWithClause.SQLCycleClause x = new SQLWithClause.SQLCycleClause();

        for (NameIdentifierContext cycleColumnContext : ctx.cycleColumns) {
            SQLName cycleColumn = visitNameIdentifier(cycleColumnContext);
            x.addCycleColumn(cycleColumn);
        }

        SQLName cycleMarkColumn = visitNameIdentifier(ctx.cycleMarkColumn);
        x.setCycleMarkColumn(cycleMarkColumn);

        SQLExpr cycleMarkValue = visitExpr(ctx.cycleMarkValue);
        x.setCycleMarkValue(cycleMarkValue);

        SQLExpr nonCycleMarkValue = visitExpr(ctx.nonCycleMarkValue);
        x.setNonCycleMarkValue(nonCycleMarkValue);

        return x;
    }


    @Override
    public OracleSQLWithClause.OracleSQLSubAvFactoringClause visitSubAvFactoringClause(SubAvFactoringClauseContext ctx) {
        OracleSQLWithClause.OracleSQLSubAvFactoringClause x = new OracleSQLWithClause.OracleSQLSubAvFactoringClause();

        SQLName name = visitNameIdentifier(ctx.name);
        x.setName(name);

        OracleSQLSubAvClause subAvClause = visitSubAvClause(ctx.subAvClause());
        x.setSubAvClause(subAvClause);

        return x;
    }

    @Override
    public OracleSQLSubAvClause visitSubAvClause(SubAvClauseContext ctx) {
        OracleSQLSubAvClause x = new OracleSQLSubAvClause();

        SQLName using = visitNameIdentifier(ctx.using);
        x.setName(using);

        if (ctx.hierarchiesClause() != null) {
            OracleSQLHierarchiesClause hierarchiesClause = visitHierarchiesClause(ctx.hierarchiesClause());
            x.setHierarchiesClause(hierarchiesClause);
        }

        for (SubAvClauseFilterClauseContext subAvClauseFilterClauseContext : ctx.subAvClauseFilterClause()) {
            SQLExprToExprExpr filterClauseItem = visitSubAvClauseFilterClause(subAvClauseFilterClauseContext);
            x.addFilterClause(filterClauseItem);
        }

        for (CalcMeasClauseContext calcMeasClauseContext : ctx.calcMeasClause()) {
            OracleSQLSubAvClause.OracleSQLCalcMeasClause calcMeasClause = visitCalcMeasClause(calcMeasClauseContext);
            x.addCalcMeasClause(calcMeasClause);
        }
        return x;
    }

    @Override
    public OracleSQLHierarchiesClause visitHierarchiesClause(HierarchiesClauseContext ctx) {
        OracleSQLHierarchiesClause x = new OracleSQLHierarchiesClause();

        for (NameIdentifierContext nameIdentifierContext : ctx.nameIdentifier()) {
            SQLName name = visitNameIdentifier(nameIdentifierContext);
            x.addName(name);
        }
        return x;
    }

    @Override
    public SQLExprToExprExpr visitSubAvClauseFilterClause(SubAvClauseFilterClauseContext ctx) {
        SQLExpr expr = visitExpr(ctx.value);
        SQLExpr toExpr = visitExpr(ctx.predicate);
        return new SQLExprToExprExpr(expr, toExpr);
    }

    @Override
    public OracleSQLSubAvClause.OracleSQLCalcMeasClause visitCalcMeasClause(CalcMeasClauseContext ctx) {
        OracleSQLSubAvClause.OracleSQLCalcMeasClause x = new OracleSQLSubAvClause.OracleSQLCalcMeasClause();

        SQLExpr name = visitExpr(ctx.value);
        x.setName(name);

        SQLExpr asExpr = visitExpr(ctx.asExpr);
        x.setExpr(asExpr);

        return x;
    }


    public SQLSetQuantifier of(SetQuantifierContext ctx) {
        if (ctx == null) {
            return null;
        }

        SQLSetQuantifier x = null;
        if (ctx.DISTINCT() != null) {
            x = SQLSetQuantifier.DISTINCT;
        } else if (ctx.UNIQUE() != null) {
            x = SQLSetQuantifier.UNIQUE;

        } else if (ctx.ALL() != null) {
            x = SQLSetQuantifier.ALL;
        }

        return x;
    }

    @Override
    public SQLSelectItem visitSelectItem(SelectItemContext ctx) {
        SQLSelectItem x = new SQLSelectItem();

        SQLExpr expr = visitExpr(ctx.column);
        x.setExpr(expr);

        if (ctx.alias != null) {

            if (ctx.AS() != null) {
                x.setAs(true);
            }

            SQLExpr alias = (SQLExpr) visitChildren(ctx.alias);
            x.setAlias(alias);
        }

        return x;
    }


    @Override
    public SQLFromClause visitFromClause(OracleSQLStatementParser.FromClauseContext ctx) {
        ISQLTableReference tableReference = (ISQLTableReference) visit(ctx.iTableReference());
        return new SQLFromClause(tableReference);
    }


    @Override
    public OracleSQLObjectNameTableTableReference visitObjectNameTableReference(ObjectNameTableReferenceContext ctx) {

        SQLName tableName = visitNameIdentifier(ctx.tableName);
        OracleSQLObjectNameTableTableReference x = new OracleSQLObjectNameTableTableReference(tableName);

        if (ctx.ONLY() != null) {
            x.setOnly(true);
        }

        if (ctx.objectNameTableReferenceOption() != null) {
            SQLExpr option = (SQLExpr) visitChildren(ctx.objectNameTableReferenceOption());
            x.setOption(option);
        }

        if (ctx.sampleClause() != null) {
            OracleSQLObjectNameTableTableReference.OracleSQLSampleClause sampleClause = visitSampleClause(ctx.sampleClause());
            x.setOracleSQLSampleClause(sampleClause);
        }

        for (FlashbackQueryClauseContext flashbackQueryClauseContext : ctx.flashbackQueryClause()) {
            OracleSQLFlashbackQueryClause flashbackQueryClause = (OracleSQLFlashbackQueryClause) visit(flashbackQueryClauseContext);
            x.addFlashbackQueryClause(flashbackQueryClause);
        }


        if (ctx.iPivotClause() != null) {
            SQLExpr pivotClause = (SQLExpr) visitChildren(ctx.iPivotClause());
            x.setPivot(pivotClause);
        }

        if (ctx.alias1 != null) {
            SQLIdentifier alias = (SQLIdentifier) visitNameIdentifier(ctx.alias1);
            x.setAlias(alias);
        }
        if (ctx.alias2 != null) {
            SQLIdentifier alias = (SQLIdentifier) visitNameIdentifier(ctx.alias2);
            x.setAlias(alias);
        }
        return x;
    }


    @Override
    public OracleSQLSubQueryTableReference visitLateralSubQueryTableReference(LateralSubQueryTableReferenceContext ctx) {
        OracleSQLSubQueryTableReference x = new OracleSQLSubQueryTableReference();

        if (ctx.ONLY() != null) {
            x.setOnly(true);
        }

        if (ctx.LATERAL() != null) {
            x.setLateral(true);
        }

        ISQLSelectQuery subQuery = visitISelectQuery(ctx.iSelectQuery());
        x.setSubQuery(subQuery);

        if (ctx.iSubQueryRestrictionClause() != null) {
            ISQLSubqueryRestrictionClause subqueryRestriction = (ISQLSubqueryRestrictionClause) visit(ctx.iSubQueryRestrictionClause());
            x.setSubQueryRestrictionClause(subqueryRestriction);
        }

        for (FlashbackQueryClauseContext flashbackQueryClauseContext : ctx.flashbackQueryClause()) {
            OracleSQLFlashbackQueryClause flashbackQueryClause = (OracleSQLFlashbackQueryClause) visit(flashbackQueryClauseContext);
            x.addFlashbackQueryClause(flashbackQueryClause);
        }

        if (ctx.iPivotClause() != null) {
            SQLExpr pivotClause = (SQLExpr) visitChildren(ctx.iPivotClause());
            x.setPivot(pivotClause);
        }

        if (ctx.AS() != null) {
            x.setAs(true);
        }

        if (ctx.alias != null) {
            SQLIdentifier alias = (SQLIdentifier) visitNameIdentifier(ctx.alias);
            x.setAlias(alias);
        }

        return x;
    }


    @Override
    public OracleSQLContainersFunctionTableReference visitContainersFunctionTableReference(ContainersFunctionTableReferenceContext ctx) {
        OracleSQLContainersFunctionTableReference x = new OracleSQLContainersFunctionTableReference();

        SQLName name = visitNameIdentifier(ctx.name);
        x.setName(name);

        if (ctx.AS() != null) {
            x.setAs(true);
        }

        if (ctx.alias != null) {
            SQLIdentifier alias = (SQLIdentifier) visitNameIdentifier(ctx.alias);
            x.setAlias(alias);
        }

        return x;
    }

    @Override
    public SQLTableFunctionTableReference visitTableFunctionTableReference(TableFunctionTableReferenceContext ctx) {

        SQLTableFunctionTableReference x = new SQLTableFunctionTableReference();

        if (ctx.ONLY() != null) {
            x.setOnly(true);
        }

        SQLExpr expr = visitExpr(ctx.expr());
        x.setExpr(expr);

        if (ctx.PLUS_SIGN() != null) {
            x.setOuterJoin(true);
        }

        for (FlashbackQueryClauseContext flashbackQueryClauseContext : ctx.flashbackQueryClause()) {
            OracleSQLFlashbackQueryClause flashbackQueryClause = (OracleSQLFlashbackQueryClause) visit(flashbackQueryClauseContext);
            // todo
            // x.addFlashbackQueryClause(flashbackQueryClause);
        }

        if (ctx.iPivotClause() != null) {
            SQLExpr pivotClause = (SQLExpr) visitChildren(ctx.iPivotClause());
            x.setPivot(pivotClause);
        }


        if (ctx.AS() != null) {
            x.setAs(true);
        }

        if (ctx.alias != null) {
            SQLIdentifier alias = (SQLIdentifier) visitNameIdentifier(ctx.alias);
            x.setAlias(alias);
        }
        return x;
    }

    @Override
    public OracleSQLShardsFunctionTableReference visitShardsFunctionTableReference(ShardsFunctionTableReferenceContext ctx) {

        OracleSQLShardsFunctionTableReference x = new OracleSQLShardsFunctionTableReference();

        SQLName name = visitNameIdentifier(ctx.name);
        x.setName(name);

        if (ctx.AS() != null) {
            x.setAs(true);
        }

        if (ctx.alias != null) {
            SQLIdentifier alias = (SQLIdentifier) visitNameIdentifier(ctx.alias);
            x.setAlias(alias);
        }
        return x;
    }

    @Override
    public SQLJoinTableReference visitJoinTableReference(JoinTableReferenceContext ctx) {

        ISQLTableReference left = (ISQLTableReference) visit(ctx.tableReferenceBasic());
        SQLJoinTableReference x = null;
        for (RightJoinClauseContext rightJoinClauseContext : ctx.rightJoinClause()) {
            SQLJoinTableReference.SQLJoinType joinType = of(rightJoinClauseContext.joinType());
            ISQLTableReference right = (ISQLTableReference) visit(rightJoinClauseContext.tableReferenceBasic());

            x = new SQLJoinTableReference(left, joinType, right);

            if (rightJoinClauseContext.leftPartitionByClause != null) {
                SQLPartitionByClause leftPartitionByClause = visitPartitionByClause(rightJoinClauseContext.leftPartitionByClause);
                x.setLeftPartitionByClause(leftPartitionByClause);
            }

            if (rightJoinClauseContext.rightPartitionByClause != null) {
                SQLPartitionByClause rightPartitionByClause = visitPartitionByClause(rightJoinClauseContext.rightPartitionByClause);
                x.setRightPartitionByClause(rightPartitionByClause);
            }

            for (JoinSpecificationContext joinSpecificationContext : rightJoinClauseContext.joinSpecification()) {
                SQLJoinTableReference.ISQLJoinCondition condition = (SQLJoinTableReference.ISQLJoinCondition) visit(joinSpecificationContext);
                x.addCondition(condition);
            }

            left = x;
        }
        return x;
    }

    @Override
    public SQLJoinTableReference visitParenJoinTableReference(ParenJoinTableReferenceContext ctx) {
        SQLJoinTableReference x = visitJoinTableReference(ctx.joinTableReference());
        x.setParen(true);
        return x;
    }

    //    @Override
//    public ISQLTableReference visitParenTableReference(MySQLSQLStatementParser.ParenTableReferenceContext ctx) {
//        ISQLTableReference x = (ISQLTableReference) visit(ctx.iTableReference());
//        x.setParen(true);
//        return x;
//    }

    @Override
    public OracleSQLInlineAnalyticViewTableReference visitInlineAnalyticViewTableReference(InlineAnalyticViewTableReferenceContext ctx) {
        OracleSQLInlineAnalyticViewTableReference x = new OracleSQLInlineAnalyticViewTableReference();

        OracleSQLSubAvClause subAvClause = visitSubAvClause(ctx.subAvClause());
        x.setSubAvClause(subAvClause);

        if (ctx.AS() != null) {
            x.setAs(true);
        }

        if (ctx.nameIdentifier() != null) {
            SQLIdentifier alias = (SQLIdentifier) visitNameIdentifier(ctx.nameIdentifier());
            x.setAlias(alias);
        }

        return x;
    }


    public SQLJoinTableReference.SQLJoinType of(JoinTypeContext ctx) {
        if (ctx == null) {
            return null;
        }
        String joinTypeName = getText(ctx.children);
        return SQLJoinTableReference.SQLJoinType.of(joinTypeName);
    }

    public static String getText(List<ParseTree> parseTrees) {
        if (parseTrees == null) {
            return "";
        }

        StringBuilder name = new StringBuilder();
        for (int i = 0; i < parseTrees.size(); i++) {

            if (i != 0) {
                name.append(" ");
            }
            name.append(parseTrees.get(i).getText());
        }

        return name.toString();
    }

    @Override
    public SQLJoinTableReference.SQLJoinOnCondition visitJoinCondition(JoinConditionContext ctx) {
        SQLJoinTableReference.SQLJoinOnCondition x = new SQLJoinTableReference.SQLJoinOnCondition();
        SQLExpr condition = visitExpr(ctx.expr());
        x.setCondition(condition);

        return x;
    }

    @Override
    public SQLJoinTableReference.SQLJoinUsingCondition visitNamedColumnsJoin(NamedColumnsJoinContext ctx) {
        SQLJoinTableReference.SQLJoinUsingCondition x = new SQLJoinTableReference.SQLJoinUsingCondition();
        for (ExprContext exprContext : ctx.expr()) {
            SQLExpr expr = visitExpr(exprContext);
            x.addColumn(expr);
        }
        return x;
    }


    @Override
    public SQLObject visitModifiedExternalTableClause(ModifiedExternalTableClauseContext ctx) {
        return super.visitModifiedExternalTableClause(ctx);
    }

    @Override
    public OracleSQLFlashbackQueryByVersionsBetweenClause visitFlashbackQueryByVersionsBetweenClause(FlashbackQueryByVersionsBetweenClauseContext ctx) {
        OracleSQLFlashbackQueryByVersionsBetweenClause x = new OracleSQLFlashbackQueryByVersionsBetweenClause();

        SQLReserved type = SQLReserved.SCN;
        if (ctx.TIMESTAMP() != null) {
            type = SQLReserved.TIMESTAMP;
        }
        x.setType(type);

        SQLExpr minValue = visitExpr(ctx.minValue);
        SQLExpr maxValue = visitExpr(ctx.maxValue);

        x.setMinValue(minValue);
        x.setMaxValue(maxValue);

        return x;
    }

    @Override
    public OracleSQLFlashbackQueryByVersionsPeriodForClause visitFlashbackQueryByVersionsPeriodForClause(FlashbackQueryByVersionsPeriodForClauseContext ctx) {
        OracleSQLFlashbackQueryByVersionsPeriodForClause x = new OracleSQLFlashbackQueryByVersionsPeriodForClause();

        SQLName column = visitNameIdentifier(ctx.nameIdentifier());
        x.setValidTimeColumn(column);

        SQLExpr minValue = visitExpr(ctx.minValue);
        SQLExpr maxValue = visitExpr(ctx.maxValue);

        x.setMinValue(minValue);
        x.setMaxValue(maxValue);

        return x;
    }

    @Override
    public OracleSQLFlashbackQueryByAsOfClause visitFlashbackQueryByAsOfClause(FlashbackQueryByAsOfClauseContext ctx) {
        OracleSQLFlashbackQueryByAsOfClause x = new OracleSQLFlashbackQueryByAsOfClause();

        SQLReserved type = SQLReserved.SCN;
        if (ctx.TIMESTAMP() != null) {
            type = SQLReserved.TIMESTAMP;
        }
        x.setType(type);

        SQLExpr expr = visitExpr(ctx.expr());
        x.setExpr(expr);

        return x;
    }

    @Override
    public OracleSQLFlashbackQueryByAsOfPeriodForClause visitFlashbackQueryByAsOfPeriodForClause(FlashbackQueryByAsOfPeriodForClauseContext ctx) {
        OracleSQLFlashbackQueryByAsOfPeriodForClause x = new OracleSQLFlashbackQueryByAsOfPeriodForClause();

        SQLName column = visitNameIdentifier(ctx.nameIdentifier());
        x.setValidTimeColumn(column);

        SQLExpr expr = visitExpr(ctx.expr());
        x.setExpr(expr);

        return x;
    }

    @Override
    public OracleSQLPivotClause visitPivotClause(PivotClauseContext ctx) {
        OracleSQLPivotClause x = new OracleSQLPivotClause();

        if (ctx.XML() != null) {
            x.setXml(true);
        }

        for (PivotItemContext pivotItemContext : ctx.pivotItem()) {
            OracleSQLPivotClause.OracleSQLPivotItem pivotItem = visitPivotItem(pivotItemContext);
            x.addItem(pivotItem);
        }

        SQLExpr forExpr = visitExpr(ctx.expr());
        x.setPivotForExpr(forExpr);

        for (ExprOrExprAsAliasArgumentContext exprOrExprAsAliasArgumentContext : ctx.exprOrExprAsAliasArgument()) {
            SQLExpr inItem = (SQLExpr) visitChildren(exprOrExprAsAliasArgumentContext);
            x.addInItem(inItem);
        }

        return x;
    }

    @Override
    public OracleSQLPivotClause.OracleSQLPivotItem visitPivotItem(PivotItemContext ctx) {
        OracleSQLPivotClause.OracleSQLPivotItem x = new OracleSQLPivotClause.OracleSQLPivotItem();

        SQLAggregateFunction function = visitAggregateFunction(ctx.aggregateFunction());
        x.setAggregateFunction(function);

        if (ctx.AS() != null) {
            x.setAs(true);
        }

        if (ctx.nameIdentifier() != null) {
            SQLName alias = visitNameIdentifier(ctx.nameIdentifier());
            x.setAlias(alias);
        }
        return x;
    }

    @Override
    public OracleSQLUnPivotClause visitUnpivotClause(UnpivotClauseContext ctx) {
        OracleSQLUnPivotClause x = new OracleSQLUnPivotClause();

        if (ctx.NULLS() != null) {
            OracleSQLUnPivotClause.NullsType nullsType = OracleSQLUnPivotClause.NullsType.INCLUDE_NULLS;
            if (ctx.EXCLUDE() != null) {
                nullsType = OracleSQLUnPivotClause.NullsType.EXCLUDE_NULLS;
            }
            x.setNullsType(nullsType);
        }

        SQLExpr column = visitExpr(ctx.column);
        x.setColumn(column);

        SQLExpr forExpr = visitExpr(ctx.forExpr);
        x.setPivotForExpr(forExpr);

        for (ExprOrExprAsAliasArgumentContext exprOrExprAsAliasArgumentContext : ctx.exprOrExprAsAliasArgument()) {
            SQLExpr inItem = (SQLExpr) visitChildren(exprOrExprAsAliasArgumentContext);
            x.addInItem(inItem);
        }

        return x;
    }

    @Override
    public OracleSQLObjectNameTableTableReference.OracleSQLSampleClause visitSampleClause(SampleClauseContext ctx) {
        OracleSQLObjectNameTableTableReference.OracleSQLSampleClause x = new OracleSQLObjectNameTableTableReference.OracleSQLSampleClause();

        if (ctx.BLOCK() != null) {
            x.setBlock(true);
        }

        SQLExpr percent = visitExpr(ctx.percent);
        x.setPercent(percent);

        SQLExpr send = visitExpr(ctx.send);
        x.setSeedValue(send);

        return x;
    }

    @Override
    public SQLPartitionClause visitPartitionClause(OracleSQLStatementParser.PartitionClauseContext ctx) {
        SQLPartitionClause x = new SQLPartitionClause();
        for (ExprContext exprContext : ctx.expr()) {
            SQLExpr item = visitExpr(exprContext);
            x.addItem(item);
        }

        return x;
    }

    @Override
    public SQLPartitionForClause visitPartitionForClause(PartitionForClauseContext ctx) {
        SQLPartitionForClause x = new SQLPartitionForClause();

        for (ExprContext exprContext : ctx.expr()) {
            SQLExpr item = visitExpr(exprContext);
            x.addItem(item);
        }

        return x;
    }

    @Override
    public SQLSubPartitionClause visitSubPartitionClause(SubPartitionClauseContext ctx) {
        SQLSubPartitionClause x = new SQLSubPartitionClause();
        for (ExprContext exprContext : ctx.expr()) {
            SQLExpr item = visitExpr(exprContext);
            x.addItem(item);
        }
        return x;
    }

    @Override
    public SQLSubPartitionForClause visitSubPartitionForClause(SubPartitionForClauseContext ctx) {
        SQLSubPartitionForClause x = new SQLSubPartitionForClause();
        for (ExprContext exprContext : ctx.expr()) {
            SQLExpr item = visitExpr(exprContext);
            x.addItem(item);
        }
        return x;
    }

    @Override
    public ISQLSubqueryRestrictionClause.SQLWithReadOnly visitWithReadOnly(WithReadOnlyContext ctx) {
        ISQLSubqueryRestrictionClause.SQLWithReadOnly x = new ISQLSubqueryRestrictionClause.SQLWithReadOnly();
        if (ctx.nameIdentifier() != null) {
            SQLName name = visitNameIdentifier(ctx.nameIdentifier());
            x.setConstraint(name);
        }
        return x;
    }

    @Override
    public ISQLSubqueryRestrictionClause.SQLWithCheckOption visitWithCheckOption(WithCheckOptionContext ctx) {
        ISQLSubqueryRestrictionClause.SQLWithCheckOption x = new ISQLSubqueryRestrictionClause.SQLWithCheckOption();
        if (ctx.nameIdentifier() != null) {
            SQLName name = visitNameIdentifier(ctx.nameIdentifier());
            x.setConstraint(name);
        }
        return x;
    }

    @Override
    public SQLWhereClause visitWhereClause(WhereClauseContext ctx) {
        SQLExpr condition = null;
        if (ctx.currentOfClause() != null) {
            condition = visitCurrentOfClause(ctx.currentOfClause());
        } else if (ctx.expr() != null) {
            condition = visitExpr(ctx.expr());
        }

        return new SQLWhereClause(condition);
    }

    @Override
    public SQLCurrentOfClause visitCurrentOfClause(CurrentOfClauseContext ctx) {
        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        return new SQLCurrentOfClause(name);
    }


    public SQLUnionOperator of(UnionOperatorContext operatorContext) {
        SQLUnionOperator operator = SQLUnionOperator.UNION;
        if (operatorContext.UNION() != null) {
            if (operatorContext.ALL() != null) {
                operator = SQLUnionOperator.UNION_ALL;
            }

        } else if (operatorContext.INTERSECT() != null) {
            operator = SQLUnionOperator.INTERSECT;

        } else if (operatorContext.MINUS() != null) {
            operator = SQLUnionOperator.MINUS;
        }
        return operator;
    }

    @Override
    public SQLHierarchicalQueryConnectByStartWithClause visitHierarchicalQueryConnectByToStartWithClause(HierarchicalQueryConnectByToStartWithClauseContext ctx) {
        SQLHierarchicalQueryConnectByStartWithClause x = new SQLHierarchicalQueryConnectByStartWithClause();

        SQLExpr connectBy = visitExpr(ctx.connectBy);
        boolean nocycle = ctx.NOCYCLE() != null;

        x.setConnectByCondition(connectBy);
        x.setNoCycle(nocycle);

        if (ctx.startWith != null) {
            SQLExpr startWith = visitExpr(ctx.startWith);
            x.setStartWithCondition(startWith);
        }

        return x;
    }

    @Override
    public SQLHierarchicalQueryStartWithConnectByClause visitHierarchicalQueryStartWithToConnectByClause(HierarchicalQueryStartWithToConnectByClauseContext ctx) {
        SQLHierarchicalQueryStartWithConnectByClause x = new SQLHierarchicalQueryStartWithConnectByClause();

        SQLExpr startWith = visitExpr(ctx.startWith);
        SQLExpr connectBy = visitExpr(ctx.connectBy);
        boolean nocycle = ctx.NOCYCLE() != null;

        x.setStartWithCondition(startWith);
        x.setConnectByCondition(connectBy);
        x.setNoCycle(nocycle);

        return x;
    }


    @Override
    public SQLGroupByClause visitGroupByHavingClause(GroupByHavingClauseContext ctx) {
        SQLGroupByClause x = new SQLGroupByClause();

        for (GroupByItemContext groupByItemContext : ctx.groupByItem()) {
            SQLGroupByClause.SQLGroupByItem groupByElement = visitGroupByItem(groupByItemContext);
            x.addItem(groupByElement);
        }

        HavingClauseContext havingClauseContext = ctx.havingClause();
        if (havingClauseContext != null) {
            SQLHavingClause havingClause = visitHavingClause(havingClauseContext);
            x.setHavingClause(havingClause);
        }

        return x;
    }


    @Override
    public SQLGroupByClause visitHavingGroupByClause(HavingGroupByClauseContext ctx) {
        SQLGroupByClause x = new SQLGroupByClause();

        x.setOrder(false);

        for (GroupByItemContext groupByItemContext : ctx.groupByItem()) {
            SQLGroupByClause.SQLGroupByItem groupByElement = visitGroupByItem(groupByItemContext);
            x.addItem(groupByElement);
        }

        HavingClauseContext havingClauseContext = ctx.havingClause();
        if (havingClauseContext != null) {
            SQLHavingClause havingClause = visitHavingClause(havingClauseContext);
            x.setHavingClause(havingClause);
        }

        return x;
    }

    @Override
    public SQLGroupByClause.SQLGroupByItem visitGroupByItem(GroupByItemContext ctx) {
        SQLExpr expr = (SQLExpr) super.visitChildren(ctx);
        SQLGroupByClause.SQLGroupByItem x = new SQLGroupByClause.SQLGroupByItem(expr);
        return x;
    }


    @Override
    public SQLExpr visitRollupCubeClause(OracleSQLStatementParser.RollupCubeClauseContext ctx) {

        SQLExpr x = null;
        if (ctx.ROLLUP() != null) {
            SQLRollupClause rollupClause = new SQLRollupClause();
            for (ExprContext exprContext : ctx.expr()) {
                SQLExpr item = visitExpr(exprContext);
                rollupClause.addItem(item);
            }
            x = rollupClause;

        } else if (ctx.CUBE() != null) {

            SQLCubeClause cubeClause = new SQLCubeClause();
            for (ExprContext exprContext : ctx.expr()) {
                SQLExpr item = visitExpr(exprContext);
                cubeClause.addItem(item);
            }
            x = cubeClause;
        }
        return x;
    }

    @Override
    public SQLGroupingSetsClause visitGroupingSetsClause(OracleSQLStatementParser.GroupingSetsClauseContext ctx) {
        SQLGroupingSetsClause x = new SQLGroupingSetsClause();
        for (GroupingSetsClauseItemContext groupingSetsClauseItemContext : ctx.groupingSetsClauseItem()) {
            SQLExpr argument = (SQLExpr) visit(groupingSetsClauseItemContext);
            x.addArgument(argument);
        }
        return x;
    }

    @Override
    public SQLHavingClause visitHavingClause(OracleSQLStatementParser.HavingClauseContext ctx) {
        SQLExpr condition = visitExpr(ctx.expr());
        SQLHavingClause x = new SQLHavingClause(condition);
        return x;
    }

    @Override
    public OracleSQLModelClause visitModelClause(OracleSQLStatementParser.ModelClauseContext ctx) {
        OracleSQLModelClause x = new OracleSQLModelClause();

        if (ctx.cellReferenceOptions() != null) {
            OracleSQLModelClause.OracleSQLCellReferenceOptions cellReferenceOptions = visitCellReferenceOptions(ctx.cellReferenceOptions());
            x.setCellReferenceOptions(cellReferenceOptions);
        }

        if (ctx.returnRowsClause() != null) {
            SQLReserved returnRowsClause = SQLReserved.RETURN_UPDATED_ROWS;
            if (ctx.returnRowsClause().ALL() != null) {
                returnRowsClause = SQLReserved.RETURN_ALL_ROWS;
            }
            x.setReturnRowsClause(returnRowsClause);
        }

        for (ReferenceModelContext referenceModelContext : ctx.referenceModel()) {
            OracleSQLModelClause.OracleSQLReferenceModelClause referenceModelClause = visitReferenceModel(referenceModelContext);
            x.addReferenceModelClause(referenceModelClause);
        }

        if (ctx.mainModel() != null) {
            OracleSQLModelClause.OracleSQLMainModel mainModel = visitMainModel(ctx.mainModel());
            x.setMainModel(mainModel);
        }

        return x;
    }

    @Override
    public OracleSQLModelClause.OracleSQLCellReferenceOptions visitCellReferenceOptions(CellReferenceOptionsContext ctx) {
        if (ctx.NAV() == null
                && ctx.UNIQUE() == null) {
            return null;
        }

        OracleSQLModelClause.OracleSQLCellReferenceOptions x = new OracleSQLModelClause.OracleSQLCellReferenceOptions();
        if (ctx.NAV() != null) {
            OracleSQLModelClause.OracleSQLCellReferenceNavOptionType navOptionType = OracleSQLModelClause.OracleSQLCellReferenceNavOptionType.IGNORE;
            if (ctx.KEEP() != null) {
                navOptionType = OracleSQLModelClause.OracleSQLCellReferenceNavOptionType.KEEP;
            }
            x.setNavOptionType(navOptionType);
        }

        if (ctx.UNIQUE() != null) {
            OracleSQLModelClause.OracleSQLCellReferenceUniqueOptionType uniqueOptionType = OracleSQLModelClause.OracleSQLCellReferenceUniqueOptionType.DIMENSION;
            if (ctx.SINGLE() != null) {
                uniqueOptionType = OracleSQLModelClause.OracleSQLCellReferenceUniqueOptionType.SINGLE_REFERENCE;
            }
            x.setUniqueOptionType(uniqueOptionType);
        }

        return x;
    }

    @Override
    public OracleSQLModelClause.OracleSQLReferenceModelClause visitReferenceModel(ReferenceModelContext ctx) {
        OracleSQLModelClause.OracleSQLReferenceModelClause x = new OracleSQLModelClause.OracleSQLReferenceModelClause();

        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);

        ISQLSelectQuery subQuery = visitISelectQuery(ctx.iSelectQuery());
        x.setSubQuery(subQuery);

        OracleSQLModelClause.OracleSQLModelColumnClauses modelColumnClauses = visitModelColumnClauses(ctx.modelColumnClauses());
        x.setModelColumnClauses(modelColumnClauses);

        if (ctx.cellReferenceOptions() != null) {
            OracleSQLModelClause.OracleSQLCellReferenceOptions cellReferenceOptions = visitCellReferenceOptions(ctx.cellReferenceOptions());
            x.setCellReferenceOptions(cellReferenceOptions);
        }

        return x;
    }

    @Override
    public OracleSQLModelClause.OracleSQLMainModel visitMainModel(MainModelContext ctx) {
        OracleSQLModelClause.OracleSQLMainModel x = new OracleSQLModelClause.OracleSQLMainModel();
        if (ctx.nameIdentifier() != null) {
            SQLName name = visitNameIdentifier(ctx.nameIdentifier());
            x.setName(name);
        }

        OracleSQLModelClause.OracleSQLModelColumnClauses modelColumnClauses = visitModelColumnClauses(ctx.modelColumnClauses());
        x.setModelColumnClauses(modelColumnClauses);

        if (ctx.cellReferenceOptions() != null) {
            OracleSQLModelClause.OracleSQLCellReferenceOptions cellReferenceOptions = visitCellReferenceOptions(ctx.cellReferenceOptions());
            x.setCellReferenceOptions(cellReferenceOptions);
        }

        OracleSQLModelClause.OracleSQLModelRulesClause modelRulesClause = visitModelRulesClause(ctx.modelRulesClause());
        x.setModelRulesClause(modelRulesClause);
        return x;
    }

    @Override
    public OracleSQLModelClause.OracleSQLModelColumnClauses visitModelColumnClauses(ModelColumnClausesContext ctx) {
        OracleSQLModelClause.OracleSQLModelColumnClauses x = new OracleSQLModelClause.OracleSQLModelColumnClauses();

        if (ctx.partitionBy != null
                && ctx.partitionBy.size() > 0) {
            for (ModelColumnClausesItemContext modelColumnClausesItemContext : ctx.partitionBy) {
                OracleSQLModelClause.OracleSQLModelColumnClausesItem item = visitModelColumnClausesItem(modelColumnClausesItemContext);
                x.addPartitionByItem(item);
            }
        }

        for (ModelColumnClausesItemContext modelColumnClausesItemContext : ctx.dimensionBy) {
            OracleSQLModelClause.OracleSQLModelColumnClausesItem item = visitModelColumnClausesItem(modelColumnClausesItemContext);
            x.addDimensionByItem(item);
        }

        for (ModelColumnClausesItemContext modelColumnClausesItemContext : ctx.measures) {
            OracleSQLModelClause.OracleSQLModelColumnClausesItem item = visitModelColumnClausesItem(modelColumnClausesItemContext);
            x.addMeasuresItem(item);
        }

        return x;
    }

    @Override
    public OracleSQLModelClause.OracleSQLModelColumnClausesItem visitModelColumnClausesItem(ModelColumnClausesItemContext ctx) {
        OracleSQLModelClause.OracleSQLModelColumnClausesItem x = new OracleSQLModelClause.OracleSQLModelColumnClausesItem();

        SQLExpr expr = visitExpr(ctx.expr());
        x.setExpr(expr);

        if (ctx.nameIdentifier() != null) {
            SQLName alias = visitNameIdentifier(ctx.nameIdentifier());
            x.setAlias(alias);
        }

        return x;
    }

    @Override
    public OracleSQLModelClause.OracleSQLModelRulesClause visitModelRulesClause(ModelRulesClauseContext ctx) {
        OracleSQLModelClause.OracleSQLModelRulesClause x = new OracleSQLModelClause.OracleSQLModelRulesClause();

        if (ctx.RULES() != null) {
            x.setRules(true);
        }

        OracleSQLModelClause.OracleSQLModelRulesType rulesType = null;
        if (ctx.UPDATE() != null) {
            rulesType = OracleSQLModelClause.OracleSQLModelRulesType.UPDATE;
        } else if (ctx.UPSERT() != null) {
            rulesType = OracleSQLModelClause.OracleSQLModelRulesType.UPSERT;
            if (ctx.ALL() != null) {
                rulesType = OracleSQLModelClause.OracleSQLModelRulesType.UPSERT_ALL;
            }
        }
        x.setRulesType(rulesType);


        if (ctx.ORDER() != null) {
            OracleSQLModelClause.OracleSQLModelRulesOrderType order = OracleSQLModelClause.OracleSQLModelRulesOrderType.AUTOMATIC_ORDER;
            if (ctx.SEQUENTIAL() != null) {
                order = OracleSQLModelClause.OracleSQLModelRulesOrderType.SEQUENTIAL_ORDER;
            }
            x.setOrder(order);
        }

        if (ctx.modelIterateClause() != null) {
            OracleSQLModelClause.OracleSQLModelIterateClause modelIterateClause = visitModelIterateClause(ctx.modelIterateClause());
            x.setModelIterateClause(modelIterateClause);
        }

        for (ModelRulesClauseItemContext modelRulesClauseItemContext : ctx.modelRulesClauseItem()) {
            OracleSQLModelClause.OracleSQLModelRulesClauseItem modelRulesClauseItem = visitModelRulesClauseItem(modelRulesClauseItemContext);
            x.addItem(modelRulesClauseItem);
        }

        return x;
    }

    @Override
    public OracleSQLModelClause.OracleSQLModelRulesClauseItem visitModelRulesClauseItem(ModelRulesClauseItemContext ctx) {
        OracleSQLModelClause.OracleSQLModelRulesClauseItem x = new OracleSQLModelClause.OracleSQLModelRulesClauseItem();

        OracleSQLModelClause.OracleSQLModelRulesType rulesType = null;
        if (ctx.UPDATE() != null) {
            rulesType = OracleSQLModelClause.OracleSQLModelRulesType.UPDATE;
        } else if (ctx.UPSERT() != null) {
            rulesType = OracleSQLModelClause.OracleSQLModelRulesType.UPSERT;

            if (ctx.ALL() != null) {
                rulesType = OracleSQLModelClause.OracleSQLModelRulesType.UPSERT_ALL;
            }
        }
        x.setRulesType(rulesType);

        SQLArrayExpr cellAssignment = visitCellAssignment(ctx.cellAssignment());
        x.setCellAssignment(cellAssignment);

        if (ctx.orderByClause() != null) {
            SQLOrderByClause orderByClause = visitOrderByClause(ctx.orderByClause());
            x.setOrderByClause(orderByClause);
        }

        SQLExpr expr = visitExpr(ctx.expr());
        x.setExpr(expr);


        return x;
    }

    @Override
    public OracleSQLModelClause.OracleSQLModelIterateClause visitModelIterateClause(ModelIterateClauseContext ctx) {
        OracleSQLModelClause.OracleSQLModelIterateClause x = new OracleSQLModelClause.OracleSQLModelIterateClause();

        SQLExpr value = visitExpr(ctx.value);
        x.setValue(value);

        if (ctx.until != null) {
            SQLExpr until = visitExpr(ctx.until);
            x.setCondition(until);
        }

        return x;
    }

    @Override
    public SQLArrayExpr visitCellAssignment(CellAssignmentContext ctx) {
        SQLArrayExpr x = new SQLArrayExpr();

        SQLExpr name = visitExpr(ctx.expr());
        x.setName(name);

        for (CellAssignmentItemContext cellAssignmentItemContext : ctx.cellAssignmentItem()) {
            SQLExpr argument = (SQLExpr) visitChildren(cellAssignmentItemContext);
            x.addArgument(argument);
        }

        return x;
    }

    @Override
    public OracleSQLSingleColumnForLoop visitSingleColumnForLoop(SingleColumnForLoopContext ctx) {
        OracleSQLSingleColumnForLoop x = new OracleSQLSingleColumnForLoop();

        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);

        OracleSQLSingleColumnForLoop.OracleSQLSingleColumnForLoopConditionExpr condition = null;
        if (ctx.IN() != null) {
            OracleSQLSingleColumnForLoop.OracleSQLSingleColumnForLoopInConditionExpr inCondition = new OracleSQLSingleColumnForLoop.OracleSQLSingleColumnForLoopInConditionExpr();
            for (ExprContext exprContext : ctx.in) {
                SQLExpr argument = visitExpr(exprContext);
                inCondition.addArgument(argument);
            }
            condition = inCondition;
        } else {
            OracleSQLSingleColumnForLoop.OracleSQLSingleColumnForLoopFromToConditionExpr fromToCondition = new OracleSQLSingleColumnForLoop.OracleSQLSingleColumnForLoopFromToConditionExpr();
            if (ctx.pattern != null) {
                SQLExpr pattern = visitExpr(ctx.pattern);
                fromToCondition.setPattern(pattern);
            }

            SQLExpr from = visitExpr(ctx.from);
            fromToCondition.setFrom(from);

            SQLExpr to = visitExpr(ctx.to);
            fromToCondition.setTo(to);


            SQLReserved increment = SQLReserved.INCREMENT;
            if (ctx.DECREMENT() != null) {
                increment = SQLReserved.DECREMENT;
            }
            fromToCondition.setIncrement(increment);

            SQLExpr incrementVal = visitExpr(ctx.increment);
            fromToCondition.setIncrementVal(incrementVal);

            condition = fromToCondition;
        }
        x.setCondition(condition);

        return x;
    }

    @Override
    public OracleSQLMultiColumnForLoop visitMultiColumnForLoop(MultiColumnForLoopContext ctx) {
        OracleSQLMultiColumnForLoop x = new OracleSQLMultiColumnForLoop();

        for (NameIdentifierContext nameIdentifierContext : ctx.nameIdentifier()) {
            SQLName name = visitNameIdentifier(nameIdentifierContext);
            x.addForItem(name);
        }

        for (ExprContext exprContext : ctx.in) {
            SQLExpr item = visitExpr(exprContext);
            x.addInItem(item);
        }
        return x;
    }

    @Override
    public SQLOrderByClause visitOrderByClause(OrderByClauseContext ctx) {

        SQLOrderByClause x = new SQLOrderByClause();

        boolean siblings = ctx.SIBLINGS() != null;
        x.setSiblings(siblings);

        for (OrderByItemContext orderByItemContext : ctx.orderByItem()) {
            SQLOrderByItem orderByItem = visitOrderByItem(orderByItemContext);
            x.addItem(orderByItem);
        }

        return x;
    }

    @Override
    public SQLOrderByItem visitOrderByItem(OrderByItemContext ctx) {

        SQLExpr sortKey = visitExpr(ctx.sortKey);
        SQLOrderByItem x = new SQLOrderByItem(sortKey);

        Token orderingSpecificationToken = ctx.orderingSpecification;
        if (orderingSpecificationToken != null) {
            if (orderingSpecificationToken.getType() == OracleSQLStatementParser.ASC) {
                x.setOrderingSpecification(SQLReserved.ASC.ofExpr());
            } else {
                x.setOrderingSpecification(SQLReserved.DESC.ofExpr());
            }
        }

        if (ctx.FIRST() != null) {
            x.setNullOrdering(SQLNullOrderingType.NULLS_FIRST);
        } else if (ctx.LAST() != null) {
            x.setNullOrdering(SQLNullOrderingType.NULLS_LAST);
        }

        return x;
    }

    @Override
    public ISQLLimitClause visitRowLimitingClause(RowLimitingClauseContext ctx) {
        if (ctx.OFFSET() == null
                && ctx.FETCH() == null) {
            return null;
        }

        SQLOffsetFetchClause x = new SQLOffsetFetchClause();

        if (ctx.OFFSET() != null) {
            SQLExpr offsetExpr = visitExpr(ctx.offset);
            x.setOffsetExpr(offsetExpr);

            if (ctx.offSetRowType.getType() == OracleSQLStatementParser.ROW) {
                x.setOffSetRowType(SQLRowType.ROW);
            } else {
                x.setOffSetRowType(SQLRowType.ROWS);
            }
        }

        if (ctx.FETCH() != null) {

            SQLOffsetFetchClause.SQLFetchType fetchType = SQLOffsetFetchClause.SQLFetchType.FIRST;
            if (ctx.NEXT() != null) {
                fetchType = SQLOffsetFetchClause.SQLFetchType.NEXT;
            }
            x.setFetchType(fetchType);

            if (ctx.rowCount != null) {
                SQLExpr rowCountExpr = visitExpr(ctx.rowCount);
                x.setRowCountExpr(rowCountExpr);
            }

            boolean percent = ctx.PERCENT_KEYWORD() != null;
            x.setPercent(percent);

            SQLRowType fetchRowType = SQLRowType.ROW;
            if (ctx.fetchRowType.getType() == OracleSQLStatementParser.ROWS) {
                fetchRowType = SQLRowType.ROWS;
            }
            x.setFetchRowType(fetchRowType);


            SQLOffsetFetchClause.SQLFetchOnlyType onlyType = SQLOffsetFetchClause.SQLFetchOnlyType.ONLY;
            if (ctx.WITH() != null
                    && ctx.TIES() != null) {
                onlyType = SQLOffsetFetchClause.SQLFetchOnlyType.WITH_TIES;
                x.setOnlyType(SQLOffsetFetchClause.SQLFetchOnlyType.ONLY);
            }
            x.setOnlyType(onlyType);
        }

        return x;
    }

    @Override
    public SQLForUpdateClause visitForUpdateClause(ForUpdateClauseContext ctx) {
        SQLForUpdateClause x = new SQLForUpdateClause();

        x.setForType(SQLForUpdateClause.SQLForType.UPDATE);

        for (NameIdentifierContext nameIdentifierContext : ctx.nameIdentifier()) {
            SQLName column = visitNameIdentifier(nameIdentifierContext);
            x.addColumn(column);
        }

        if (ctx.forUpdateOption() != null) {
            SQLForUpdateClause.SQLForOption forOption = (SQLForUpdateClause.SQLForOption) visit(ctx.forUpdateOption());
            x.setForOption(forOption);
        }
        return x;
    }


    @Override
    public SQLForUpdateClause.SQLForSkipLockedOption visitForUpdateSkipLockedOption(ForUpdateSkipLockedOptionContext ctx) {
        return new SQLForUpdateClause.SQLForSkipLockedOption();
    }

    @Override
    public SQLForUpdateClause.SQLForNoWaitOption visitForUpdateNoWaitOption(ForUpdateNoWaitOptionContext ctx) {
        return new SQLForUpdateClause.SQLForNoWaitOption();
    }

    @Override
    public SQLForUpdateClause.SQLForWaitOption visitForUpdateWaitOption(ForUpdateWaitOptionContext ctx) {
        SQLExpr expr = visitExpr(ctx.expr());
        return new SQLForUpdateClause.SQLForWaitOption(expr);
    }

    // ------------- Select Statement End ----------------------------------------------------


    @Override
    public SQLDateTimeAtTimeZoneExpr visitDateTimeAtTimeZoneExpr(DateTimeAtTimeZoneExprContext ctx) {
        SQLExpr expr = visitExpr(ctx.value);
        SQLExpr timeZone = visitExpr(ctx.timeZone);

        return new SQLDateTimeAtTimeZoneExpr(expr, timeZone);
    }

    @Override
    public SQLDateTimeAtLocalExpr visitDateTimeAtLocalExpr(DateTimeAtLocalExprContext ctx) {
        SQLExpr expr = visitExpr(ctx.expr());
        return new SQLDateTimeAtLocalExpr(expr);
    }

    @Override
    public SQLIntervalExpr visitIntervalExpr(IntervalExprContext ctx) {
        SQLIntervalExpr x = new SQLIntervalExpr();
        SQLExpr value1 = visitExpr(ctx.value1);
        SQLExpr value2 = visitExpr(ctx.value2);
        x.setValue1(value1);
        x.setValue2(value2);

        SQLIntervalExpr.SQLUnit unit = null;
        if (ctx.DAY() != null) {
            unit = SQLIntervalExpr.SQLUnit.DAY;
        } else if (ctx.YEAR() != null) {
            unit = SQLIntervalExpr.SQLUnit.YEAR;
        }
        x.setUnit(unit);

        if (ctx.precision != null) {
            SQLExpr precision = visitExpr(ctx.precision);
            x.setPrecision(precision);
        }

        SQLIntervalExpr.SQLToUnit toUnit = null;
        if (ctx.SECOND() != null) {
            toUnit = SQLIntervalExpr.SQLToUnit.SECOND;
        } else if (ctx.MONTH() != null) {
            toUnit = SQLIntervalExpr.SQLToUnit.MONTH;
        }
        x.setToUnit(toUnit);

        if (ctx.toPrecision != null) {
            SQLExpr toPrecision = visitExpr(ctx.toPrecision);
            x.setToPrecision(toPrecision);
        }

        return x;
    }

    @Override
    public SQLBinaryOperatorExpr visitBinaryOperatorExpr(BinaryOperatorExprContext ctx) {
        boolean paren = ctx.LEFT_PAREN() != null;

        SQLExpr left = visitExpr(ctx.expr(0));
        SQLExpr right = visitExpr(ctx.expr(1));
        SQLBinaryOperator operator = SQLBinaryOperator.of(ctx.operator.getText());

        return new SQLBinaryOperatorExpr(paren, left, operator, right);
    }

    @Override
    public SQLBinaryOperatorExpr visitConcatenationBinaryOperatorExpr(ConcatenationBinaryOperatorExprContext ctx) {
        boolean paren = ctx.LEFT_PAREN() != null;
        SQLExpr left = visitExpr(ctx.expr(0));
        SQLExpr right = visitExpr(ctx.expr(1));
        return new SQLBinaryOperatorExpr(paren, left, SQLBinaryOperator.LOGIC_OR_OP, right);
    }

    @Override
    public SQLBinaryOperatorExpr visitRelationalBinaryOperatorExpr(RelationalBinaryOperatorExprContext ctx) {
        boolean paren = ctx.LEFT_PAREN() != null;
        SQLExpr left = visitExpr(ctx.expr(0));
        SQLExpr right = visitExpr(ctx.expr(1));
        SQLBinaryOperator operator = SQLBinaryOperator.of(ctx.comparisonOp().getText());
        return new SQLBinaryOperatorExpr(paren, left, operator, right);
    }

    @Override
    public SQLCallArgumentExpr visitCallArgumentExpr(CallArgumentExprContext ctx) {
        SQLExpr name = visitExpr(ctx.name);
        SQLExpr value = visitExpr(ctx.value);
        return new SQLCallArgumentExpr(name, value);
    }


    @Override
    public SQLNotCondition visitNotCondition(NotConditionContext ctx) {
        SQLExpr expr = visitExpr(ctx.expr());
        return new SQLNotCondition(expr);
    }

    @Override
    public SQLIsAnyCondition visitIsAnyCondition(IsAnyConditionContext ctx) {
        SQLIsAnyCondition x = new SQLIsAnyCondition();
        if (ctx.nameIdentifier() != null) {
            SQLName name = visitNameIdentifier(ctx.nameIdentifier());
            x.setColumn(name);
        }
        return x;
    }

    @Override
    public SQLIsNanCondition visitIsNanCondition(IsNanConditionContext ctx) {
        SQLExpr expr = visitExpr(ctx.expr());
        SQLIsNanCondition x = new SQLIsNanCondition(expr);

        boolean not = ctx.NOT() != null;
        x.setNot(not);

        return x;
    }

    @Override
    public SQLIsInfiniteCondition visitIsInfiniteCondition(IsInfiniteConditionContext ctx) {
        SQLExpr expr = visitExpr(ctx.expr());
        SQLIsInfiniteCondition x = new SQLIsInfiniteCondition(expr);

        boolean not = ctx.NOT() != null;
        x.setNot(not);

        return x;
    }


    @Override
    public SQLIsPresentCondition visitIsPresentCondition(IsPresentConditionContext ctx) {

        SQLExpr expr = visitExpr(ctx.expr());

        SQLIsPresentCondition x = new SQLIsPresentCondition();
        x.setCellReference(expr);

        return x;
    }

    @Override
    public SQLIsASetCondition visitIsASetCondition(IsASetConditionContext ctx) {
        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        boolean not = ctx.NOT() != null;

        SQLIsASetCondition x = new SQLIsASetCondition();
        x.setNestedTable(name);
        x.setNot(not);

        return x;
    }

    @Override
    public SQLIsEmptyCondition visitIsEmptyCondition(IsEmptyConditionContext ctx) {
        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        boolean not = ctx.NOT() != null;

        SQLIsEmptyCondition x = new SQLIsEmptyCondition();
        x.setNestedTable(name);
        x.setNot(not);

        return x;
    }

    @Override
    public SQLMemberCondition visitMemberCondition(MemberConditionContext ctx) {

        SQLExpr member = visitExpr(ctx.member);
        boolean not = ctx.NOT() != null;
        boolean of = ctx.OF() != null;
        SQLName nestedTable = visitNameIdentifier(ctx.nestedTable);

        SQLMemberCondition x = new SQLMemberCondition();
        x.setExpr(member);
        x.setNot(not);
        x.setOf(of);
        x.setNestedTable(nestedTable);

        return x;
    }

    @Override
    public SQLSubMultisetCondition visitSubmultisetCondition(SubmultisetConditionContext ctx) {
        SQLName nestedTable1 = visitNameIdentifier(ctx.nestedTable1);
        boolean not = ctx.NOT() != null;
        boolean of = ctx.OF() != null;
        SQLName nestedTable2 = visitNameIdentifier(ctx.nestedTable2);

        SQLSubMultisetCondition x = new SQLSubMultisetCondition();
        x.setNestedTable1(nestedTable1);
        x.setNot(not);
        x.setOf(of);
        x.setNestedTable2(nestedTable2);

        return x;
    }

    @Override
    public SQLLikeCondition visitLikeCondition(LikeConditionContext ctx) {
        SQLExpr expr = visitExpr(ctx.value);
        boolean not = ctx.NOT() != null;
        SQLLikeOperator operator = SQLLikeOperator.of(ctx.operator.getText());
        SQLExpr pattern = visitExpr(ctx.pattern);

        SQLLikeCondition x = new SQLLikeCondition(expr, operator, pattern);
        x.setNot(not);

        if (ctx.escape != null) {
            SQLExpr escape = visitExpr(ctx.escape);
            x.setEscape(escape);
        }

        return x;
    }

    @Override
    public SQLRegexpLikeCondition visitRegexpLikeCondition(RegexpLikeConditionContext ctx) {
        SQLRegexpLikeCondition x = new SQLRegexpLikeCondition();
        for (ExprContext exprContext : ctx.expr()) {
            SQLExpr argument = visitExpr(exprContext);
            x.addArgument(argument);
        }
        return x;
    }

    @Override
    public SQLIsNullCondition visitIsNullCondition(IsNullConditionContext ctx) {
        SQLExpr expr = visitExpr(ctx.expr());

        SQLIsNullCondition x = new SQLIsNullCondition(expr);

        boolean not = ctx.NOT() != null;
        x.setNot(not);

        return x;
    }

    @Override
    public SQLIsJsonCondition visitIsJsonCondition(IsJsonConditionContext ctx) {
        SQLExpr expr = visitExpr(ctx.expr());

        SQLIsJsonCondition x = new SQLIsJsonCondition(expr);

        boolean not = ctx.NOT() != null;
        x.setNot(not);

        boolean formatJson = ctx.formatJson() != null;
        x.setFormatJson(formatJson);

        if (ctx.STRICT() != null) {
            x.setOption(SQLReserved.STRICT);
        } else if (ctx.LAX() != null) {
            x.setOption(SQLReserved.LAX);
        }

        if (ctx.WITH() != null) {
            x.setOption(SQLReserved.WITH_UNIQUE_KEYS);
        } else if (ctx.WITHOUT() != null) {
            x.setOption(SQLReserved.WITHOUT_UNIQUE_KEYS);
        }

        return x;
    }

    @Override
    public SQLJsonExistsCondition visitJsonExistsCondition(JsonExistsConditionContext ctx) {
        SQLJsonExistsCondition x = new SQLJsonExistsCondition();

        SQLExpr expr = visitExpr(ctx.name);
        x.setExpr(expr);

        SQLExpr pathExpr = visitExpr(ctx.pathExpr);
        x.setPathExpr(pathExpr);

        for (ExprAsObjectExprContext exprASObjectExprContext : ctx.exprAsObjectExpr()) {
            SQLExprAsObjectExpr item = visitExprAsObjectExpr(exprASObjectExprContext);
            x.addJsonPassingClauseItem(item);
        }

        if (ctx.jsonExistsOnErrorClause() != null) {
            SQLReservedIdentifier onErrorClause = visitJsonExistsOnErrorClause(ctx.jsonExistsOnErrorClause());
            x.setOnErrorClause(onErrorClause);
        }
        return x;
    }

    @Override
    public SQLExprAsObjectExpr visitExprAsObjectExpr(ExprAsObjectExprContext ctx) {

        SQLExpr expr = visitExpr(ctx.expr(0));

        boolean as = ctx.AS() != null;

        SQLObject asObject = null;
        if (ctx.dataType() != null) {
            asObject = visitDataType(ctx.dataType());
        } else {
            asObject = visitExpr(ctx.expr(1));
        }
        return new SQLExprAsObjectExpr(expr, as, asObject);
    }

    @Override
    public SQLReservedIdentifier visitJsonExistsOnErrorClause(JsonExistsOnErrorClauseContext ctx) {
        SQLReservedIdentifier x = SQLReserved.ERROR_ON_ERROR.ofExpr();
        if (ctx.TRUE() != null) {
            x = SQLReserved.TRUE_ON_ERROR.ofExpr();
        } else if (ctx.FALSE() != null) {
            x = SQLReserved.FALSE_ON_ERROR.ofExpr();
        }

        return x;
    }

    @Override
    public SQLBetweenCondition visitBetweenCondition(BetweenConditionContext ctx) {
        SQLExpr name = visitExpr(ctx.name);
        SQLExpr between = visitExpr(ctx.between);
        SQLExpr and = visitExpr(ctx.and);

        SQLBetweenCondition x = new SQLBetweenCondition(name, between, and);
        boolean not = ctx.NOT() != null;
        x.setNot(not);
        return x;
    }

    @Override
    public SQLExistsCondition visitExistsCondition(ExistsConditionContext ctx) {
        ISQLSelectQuery subQuery = visitISelectQuery(ctx.iSelectQuery());
        SQLExistsCondition x = new SQLExistsCondition(subQuery);
        return x;
    }

    @Override
    public SQLInCondition visitInCondition(InConditionContext ctx) {
        SQLExpr name = visitExpr(ctx.name);

        SQLInCondition x = new SQLInCondition();

        x.setExpr(name);

        for (ExprContext exprContext : ctx.values) {
            SQLExpr value = visitExpr(exprContext);
            x.addValue(value);
        }

        boolean not = ctx.NOT() != null;
        x.setNot(not);

        return x;
    }

    @Override
    public SQLIsOfTypeCondition visitIsOfTypeCondition(IsOfTypeConditionContext ctx) {
        SQLIsOfTypeCondition x = new SQLIsOfTypeCondition();

        SQLExpr name = visitExpr(ctx.name);
        boolean not = ctx.NOT() != null;
        boolean type = ctx.TYPE() != null;

        x.setExpr(name);
        x.setNot(not);
        x.setType(type);


        for (IsOfTypeConditionItemContext isOfTypeConditionItemContext : ctx.isOfTypeConditionItem()) {
            SQLIsOfTypeCondition.Item item = visitIsOfTypeConditionItem(isOfTypeConditionItemContext);
            x.addItem(item);
        }

        return x;
    }

    @Override
    public SQLIsOfTypeCondition.Item visitIsOfTypeConditionItem(IsOfTypeConditionItemContext ctx) {
        SQLIsOfTypeCondition.Item x = new SQLIsOfTypeCondition.Item();

        boolean only = ctx.ONLY() != null;
        SQLName name = visitNameIdentifier(ctx.name);

        x.setOnly(only);
        x.setName(name);
        return x;
    }

    @Override
    public SQLInsertingCondition visitInsertingCondition(InsertingConditionContext ctx) {
        return new SQLInsertingCondition();
    }

    @Override
    public SQLUpdatingCondition visitUpdatingCondition(UpdatingConditionContext ctx) {
        SQLUpdatingCondition x = new SQLUpdatingCondition();
        SQLExpr column = visitExpr(ctx.expr());
        x.setColumn(column);
        return x;
    }

    @Override
    public SQLDeletingCondition visitDeletingCondition(DeletingConditionContext ctx) {
        return new SQLDeletingCondition();
    }

    @Override
    public ISQLCondition visitCondition(OracleSQLStatementParser.ConditionContext ctx) {
        return (ISQLCondition) super.visitCondition(ctx);
    }

    //---------------------------- Condition


    // ---------------------------- Common SQL DDL Clauses Start

    // ------ allocate_extent_clause
    @Override
    public OracleSQLAllocateExtentClause visitAllocateExtentClause(AllocateExtentClauseContext ctx) {

        OracleSQLAllocateExtentClause x = new OracleSQLAllocateExtentClause();

        for (AllocateExtentItemContext allocateExtentItemContext : ctx.allocateExtentItem()) {
            OracleSQLAllocateExtentClause.Item item = visitAllocateExtentItem(allocateExtentItemContext);
            x.addItem(item);
        }

        return x;
    }

    @Override
    public OracleSQLAllocateExtentClause.Item visitAllocateExtentItem(AllocateExtentItemContext ctx) {
        if (ctx == null) {
            return null;
        }

        OracleSQLAllocateExtentClause.Item x = null;
        if (ctx.size != null) {
            OracleSQLSizeClause size = visitSizeClause(ctx.size);
            x = new OracleSQLAllocateExtentClause.OracleSQLAllocateExtentSizeClauseItem(size);
        } else if (ctx.dataFile != null) {
            SQLLiteral literal = visitLiteral(ctx.dataFile);
            x = new OracleSQLAllocateExtentClause.OracleSQLAllocateExtentDataFileClauseItem(literal);
        } else if (ctx.instance != null) {
            SQLIntegerLiteral value = new SQLIntegerLiteral(ctx.UNSIGNED_INTEGER().getText());
            x = new OracleSQLAllocateExtentClause.OracleSQLAllocateExtentInstanceClauseItem(value);
        }

        return x;
    }

    // ------ constraint
    @Override
    public SQLConstraint visitConstraint(ConstraintContext ctx) {
        return (SQLConstraint) super.visitChildren(ctx);
    }

    public List<ISQLConstraintOption> of(List<IConstraintStateContext> stateContexts) {
        if (stateContexts == null
                || stateContexts.size() == 0) {
            return Collections.emptyList();
        }

        List<ISQLConstraintOption> options = new ArrayList<>();
        for (IConstraintStateContext iConstraintStateContext : stateContexts) {
            ISQLConstraintOption option = visitIConstraintState(iConstraintStateContext);
            options.add(option);
        }
        return options;
    }

    @Override
    public SQLNullColumnConstraint visitNullColumnConstraint(NullColumnConstraintContext ctx) {
        SQLNullColumnConstraint x = new SQLNullColumnConstraint();

        if (ctx.nameIdentifier() != null) {
            SQLName name = visitNameIdentifier(ctx.nameIdentifier());
            x.setName(name);
        }

        List<ISQLConstraintOption> options = of(ctx.iConstraintState());
        x.addAllOption(options);

        return x;
    }

    @Override
    public SQLNotNullColumnConstraint visitNotNullColumnConstraint(NotNullColumnConstraintContext ctx) {
        SQLNotNullColumnConstraint x = new SQLNotNullColumnConstraint();
        if (ctx.nameIdentifier() != null) {
            SQLName name = visitNameIdentifier(ctx.nameIdentifier());
            x.setName(name);
        }

        List<ISQLConstraintOption> options = of(ctx.iConstraintState());
        x.addAllOption(options);
        return x;
    }

    @Override
    public SQLUniqueColumnConstraint visitUniqueColumnConstraint(UniqueColumnConstraintContext ctx) {
        SQLUniqueColumnConstraint x = new SQLUniqueColumnConstraint();
        if (ctx.nameIdentifier() != null) {
            SQLName name = visitNameIdentifier(ctx.nameIdentifier());
            x.setName(name);
        }

        List<ISQLConstraintOption> options = of(ctx.iConstraintState());
        x.addAllOption(options);
        return x;
    }

    @Override
    public SQLPrimaryKeyColumnConstraint visitPrimaryKeyColumnConstraint(PrimaryKeyColumnConstraintContext ctx) {
        SQLPrimaryKeyColumnConstraint x = new SQLPrimaryKeyColumnConstraint();
        if (ctx.nameIdentifier() != null) {
            SQLName name = visitNameIdentifier(ctx.nameIdentifier());
            x.setName(name);
        }

        List<ISQLConstraintOption> options = of(ctx.iConstraintState());
        x.addAllOption(options);
        return x;
    }

    @Override
    public SQLReferencesColumnConstraint visitReferencesColumnConstraint(ReferencesColumnConstraintContext ctx) {
        SQLReferencesColumnConstraint x = new SQLReferencesColumnConstraint();
        if (ctx.constraintName != null) {
            SQLName name = visitNameIdentifier(ctx.constraintName);
            x.setName(name);
        }

        if (ctx.referenced != null) {
            SQLName name = visitNameIdentifier(ctx.referenced);
            x.setReferencedTable(name);
        }

        for (ExprContext exprContext : ctx.expr()) {
            SQLExpr column = visitExpr(exprContext);
            x.addReferencedColumn(column);
        }

        if (ctx.onDeleteAction() != null) {
            AbstractSQLReferencesConstraint.SQLOnDeleteAction action = visitOnDeleteAction(ctx.onDeleteAction());
            x.addAction(action);
        }

        List<ISQLConstraintOption> options = of(ctx.iConstraintState());
        x.addAllOption(options);
        return x;
    }

    @Override
    public AbstractSQLReferencesConstraint.SQLOnDeleteAction visitOnDeleteAction(OnDeleteActionContext ctx) {
        if (ctx == null) {
            return null;
        }
        AbstractSQLReferencesConstraint.SQLOnDeleteAction x = new AbstractSQLReferencesConstraint.SQLOnDeleteAction();
        SQLReferentialAction action = SQLReferentialAction.CASCADE;
        if (ctx.SET() != null
                && ctx.NULL() != null) {
            action = SQLReferentialAction.SET_NULL;
        }
        x.setAction(action);
        return x;
    }

    @Override
    public SQLCheckColumnConstraint visitCheckColumnConstraint(CheckColumnConstraintContext ctx) {
        SQLCheckColumnConstraint x = new SQLCheckColumnConstraint();
        if (ctx.nameIdentifier() != null) {
            SQLName name = visitNameIdentifier(ctx.nameIdentifier());
            x.setName(name);
        }

        SQLExpr condition = visitExpr(ctx.expr());
        x.setCondition(condition);

        List<ISQLConstraintOption> options = of(ctx.iConstraintState());
        x.addAllOption(options);
        return x;
    }

    @Override
    public SQLScopeIsColumnConstraint visitScopeIsColumnConstraint(ScopeIsColumnConstraintContext ctx) {
        SQLScopeIsColumnConstraint x = new SQLScopeIsColumnConstraint();
        if (ctx.nameIdentifier() != null) {
            SQLName name = visitNameIdentifier(ctx.nameIdentifier());
            x.setScopeTable(name);
        }
        return x;
    }

    @Override
    public SQLWithRowIdColumnConstraint visitWithRowIdColumnConstraint(WithRowIdColumnConstraintContext ctx) {
        return new SQLWithRowIdColumnConstraint();
    }

    @Override
    public SQLUniqueTableConstraint visitUniqueTableConstraint(UniqueTableConstraintContext ctx) {
        SQLUniqueTableConstraint x = new SQLUniqueTableConstraint();
        if (ctx.nameIdentifier() != null) {
            SQLName name = visitNameIdentifier(ctx.nameIdentifier());
            x.setName(name);
        }

        for (ExprContext exprContext : ctx.expr()) {
            SQLExpr column = visitExpr(exprContext);
            x.addColumn(column);
        }

        List<ISQLConstraintOption> options = of(ctx.iConstraintState());
        x.addAllOption(options);
        return x;
    }

    @Override
    public SQLPrimaryKeyTableConstraint visitPrimaryKeyTableConstraint(PrimaryKeyTableConstraintContext ctx) {
        SQLPrimaryKeyTableConstraint x = new SQLPrimaryKeyTableConstraint();
        if (ctx.nameIdentifier() != null) {
            SQLName name = visitNameIdentifier(ctx.nameIdentifier());
            x.setName(name);
        }

        for (ExprContext exprContext : ctx.expr()) {
            SQLExpr column = visitExpr(exprContext);
            x.addColumn(column);
        }

        List<ISQLConstraintOption> options = of(ctx.iConstraintState());
        x.addAllOption(options);
        return x;
    }

    @Override
    public SQLForeignKeyTableConstraint visitForeignKeyTableConstraint(ForeignKeyTableConstraintContext ctx) {
        SQLForeignKeyTableConstraint x = new SQLForeignKeyTableConstraint();
        if (ctx.constraintName != null) {
            SQLName name = visitNameIdentifier(ctx.constraintName);
            x.setName(name);
        }

        for (ExprContext exprContext : ctx.referencingColumns) {
            SQLExpr column = visitExpr(exprContext);
            x.addReferencingColumn(column);
        }

        if (ctx.referencedTable != null) {
            SQLName name = visitNameIdentifier(ctx.referencedTable);
            x.setReferencedTable(name);
        }

        for (ExprContext exprContext : ctx.referencedColumns) {
            SQLExpr column = visitExpr(exprContext);
            x.addReferencedColumn(column);
        }

        List<ISQLConstraintOption> options = of(ctx.iConstraintState());
        x.addAllOption(options);
        return x;
    }

    @Override
    public SQLCheckTableConstraint visitCheckTableConstraint(CheckTableConstraintContext ctx) {
        SQLCheckTableConstraint x = new SQLCheckTableConstraint();
        if (ctx.nameIdentifier() != null) {
            SQLName name = visitNameIdentifier(ctx.nameIdentifier());
            x.setName(name);
        }

        SQLExpr condition = visitExpr(ctx.expr());
        x.setCondition(condition);

        List<ISQLConstraintOption> options = of(ctx.iConstraintState());
        x.addAllOption(options);
        return x;
    }

    @Override
    public SQLScopeForTableConstraint visitScopeForTableConstraint(ScopeForTableConstraintContext ctx) {
        SQLScopeForTableConstraint x = new SQLScopeForTableConstraint();

        SQLExpr ref = visitExpr(ctx.expr());
        x.setRef(ref);

        SQLName scopeTale = visitNameIdentifier(ctx.nameIdentifier());
        x.setScopeTale(scopeTale);

        return x;
    }

    @Override
    public SQLRefWithRowIdTableConstraint visitRefWithRowIdTableConstraint(RefWithRowIdTableConstraintContext ctx) {
        SQLRefWithRowIdTableConstraint x = new SQLRefWithRowIdTableConstraint();

        SQLExpr ref = visitExpr(ctx.expr());
        x.setRef(ref);
        return x;
    }

    @Override
    public ISQLConstraintOption visitIConstraintState(IConstraintStateContext ctx) {
        return (ISQLConstraintOption) super.visitChildren(ctx);
    }

    @Override
    public SQLDeferrableConstraintState visitDeferrableConstraintState(DeferrableConstraintStateContext ctx) {
        return new SQLDeferrableConstraintState();
    }

    @Override
    public SQLNotDeferrableConstraintState visitNotDeferrableConstraintState(NotDeferrableConstraintStateContext ctx) {
        return new SQLNotDeferrableConstraintState();
    }

    @Override
    public SQLInitiallyImmediateConstraintState visitInitiallyImmediateConstraintState(InitiallyImmediateConstraintStateContext ctx) {
        return new SQLInitiallyImmediateConstraintState();
    }

    @Override
    public SQLInitiallyDeferredConstraintState visitInitiallyDeferredConstraintState(InitiallyDeferredConstraintStateContext ctx) {
        return new SQLInitiallyDeferredConstraintState();
    }

    @Override
    public SQLRelyConstraintState visitRelyConstraintState(RelyConstraintStateContext ctx) {
        return new SQLRelyConstraintState();
    }

    @Override
    public SQLNoRelyConstraintState visitNoRelyConstraintState(NoRelyConstraintStateContext ctx) {
        return new SQLNoRelyConstraintState();
    }

    @Override
    public SQLEnableConstraintState visitEnableConstraintState(EnableConstraintStateContext ctx) {
        return new SQLEnableConstraintState();
    }

    @Override
    public SQLDisableConstraintState visitDisableConstraintState(DisableConstraintStateContext ctx) {
        return new SQLDisableConstraintState();
    }

    @Override
    public SQValidateConstraintState visitValidateConstraintState(ValidateConstraintStateContext ctx) {
        return new SQValidateConstraintState();
    }

    @Override
    public SQNoValidateConstraintState visitNovalidateConstraintState(NovalidateConstraintStateContext ctx) {
        return new SQNoValidateConstraintState();
    }

    @Override
    public SQExceptionsClause visitExceptionsClause(ExceptionsClauseContext ctx) {
        SQExceptionsClause x = new SQExceptionsClause();
        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);
        return x;
    }

    // ------ deallocate_unused_clause
    @Override
    public SQLObject visitDeallocateUnusedClause(DeallocateUnusedClauseContext ctx) {
        OracleSQLDeallocateUnusedClause x = new OracleSQLDeallocateUnusedClause();

        if (ctx.keep != null) {
            OracleSQLSizeClause keep = visitSizeClause(ctx.keep);
            x.setKeep(keep);
        }

        return x;
    }

    @Override
    public OracleSQLFileSpecification visitFileSpecification(FileSpecificationContext ctx) {

        DataFileTempFileSpecContext dataFileTempFileSpecContext = ctx.dataFileTempFileSpec();
        if (dataFileTempFileSpecContext != null) {
            return visitDataFileTempFileSpec(dataFileTempFileSpecContext);
        }

        RedoLogFileSpecContext redoLogFileSpecContext = ctx.redoLogFileSpec();
        if (redoLogFileSpecContext != null) {
            return visitRedoLogFileSpec(redoLogFileSpecContext);
        }
        return null;
    }

    @Override
    public OracleSQLDataFileTempFileSpec visitDataFileTempFileSpec(DataFileTempFileSpecContext ctx) {
        OracleSQLDataFileTempFileSpec x = new OracleSQLDataFileTempFileSpec();

        LiteralContext fileNameContext = ctx.fileName;
        if (fileNameContext != null) {
//            SQLSingleQuoteIdentifierExpr fileName = visitSingleQuoteIdentifier(fileNameContext);
//            x.setFileName(fileName);
        }

        SizeClauseContext sizeClauseContext = ctx.size;
        if (sizeClauseContext != null) {
            OracleSQLSizeClause sizeClause = visitSizeClause(sizeClauseContext);
            x.setSizeClause(sizeClause);
        }

        TerminalNode reuse = ctx.REUSE();
        if (reuse != null) {
            x.setReuse(true);
        }

        AutoExtendClauseContext autoExtendClauseContext = ctx.autoExtendClause();
        if (autoExtendClauseContext != null) {
            OracleSQLAutoExtendClause autoExtendClause = visitAutoExtendClause(autoExtendClauseContext);
            x.setAutoextendClause(autoExtendClause);
        }

        return x;
    }

    @Override
    public OracleSQLRedoLogFileSpec visitRedoLogFileSpec(RedoLogFileSpecContext ctx) {

        OracleSQLRedoLogFileSpec x = new OracleSQLRedoLogFileSpec();

        LiteralContext fileName1Context = ctx.fileName1;
        LiteralContext fileName2Context = ctx.fileName2;
        if (fileName2Context != null) {
            x.paren = true;
        }

        if (fileName1Context != null
                || fileName2Context != null) {
//            List<SQLSingleQuoteIdentifierExpr> fileNames = new ArrayList<>();
//            for (SingleQuoteIdentifierContext singleQuoteIdentifierContext : ctx.singleQuoteIdentifier()) {
//                SQLSingleQuoteIdentifierExpr condition = visitSingleQuoteIdentifier(singleQuoteIdentifierContext);
//                fileNames.add(condition);
//            }
//            x.setFileNames(fileNames);
        }

        if (ctx.size != null) {
            OracleSQLSizeClause sizeClause = visitSizeClause(ctx.size);
            x.setSize(sizeClause);
        }

        if (ctx.blockSize != null) {
            OracleSQLSizeClause blockSize = visitSizeClause(ctx.blockSize);
            x.setBlockSize(blockSize);
        }

        TerminalNode reuse = ctx.REUSE();
        if (reuse != null) {
            x.setReuse(true);
        }

        return x;
    }

    @Override
    public OracleSQLAutoExtendClause visitAutoExtendClause(AutoExtendClauseContext ctx) {


        TerminalNode offNode = ctx.OFF();

        if (offNode != null) {
            return new OracleSQLAutoExtendOffClause();
        } else {

            OracleSQLAutoExtendOnClause x = new OracleSQLAutoExtendOnClause();

            if (ctx.next != null) {
                OracleSQLSizeClause next = visitSizeClause(ctx.next);
                x.setNext(next);
            }

            if (ctx.maxSizeClause() != null) {
                SQLExpr maxSizeClause = visitMaxSizeClause(ctx.maxSizeClause());
                x.setMaxsize(maxSizeClause);
            }

            return x;
        }
    }

    @Override
    public OracleSQLMaxSizeClause visitMaxSizeClause(MaxSizeClauseContext ctx) {
        OracleSQLMaxSizeClause x = new OracleSQLMaxSizeClause();

        SQLExpr value = SQLUnLimitedLiteral.of();
        if (ctx.sizeClause() != null) {
            value = visitSizeClause(ctx.sizeClause());
        }
        x.setValue(value);

        return x;
    }

    @Override
    public IOracleSQLLoggingClause visitLoggingClause(LoggingClauseContext ctx) {

        if (ctx.LOGGING() != null) {

            return new OracleSQLLoggingClause();

        } else if (ctx.NOLOGGING() != null) {

            return new OracleSQLNoLoggingClause();

        } else if (ctx.FILESYSTEM_LIKE_LOGGING() != null) {

            return new OracleSQLFilesystemLikeLogging();

        }

        return null;

    }

    @Override
    public ISQLParallelClause visitParallelClause(ParallelClauseContext ctx) {

        if (ctx == null) {
            return null;
        }

        if (ctx.NOPARALLEL() != null) {
            return new SQLNoParallelClause();
        } else if (ctx.PARALLEL() != null) {

            SQLParallelClause x = new SQLParallelClause();
            if (ctx.expr() != null) {
                x.setValue(visitExpr(ctx.expr()));
            }

            return x;
        }

        return null;
    }


    // ------ physical_attributes_clause
    @Override
    public IOracleSQLPhysicalAttributesClause visitPhysicalAttributesClause(PhysicalAttributesClauseContext ctx) {
        return (IOracleSQLPhysicalAttributesClause) super.visitChildren(ctx);
    }

    @Override
    public IOracleSQLPhysicalAttributesClause.OracleSQLUsageQueueClause visitUsageQueueClause(UsageQueueClauseContext ctx) {
        return new IOracleSQLPhysicalAttributesClause.OracleSQLUsageQueueClause();
    }

    @Override
    public IOracleSQLPhysicalAttributesClause.OracleSQLPctfreeClause visitPctfreeClause(PctfreeClauseContext ctx) {
        IOracleSQLPhysicalAttributesClause.OracleSQLPctfreeClause x = new IOracleSQLPhysicalAttributesClause.OracleSQLPctfreeClause();
        SQLExpr value = visitExpr(ctx.expr());
        x.setValue(value);
        return x;
    }

    @Override
    public IOracleSQLPhysicalAttributesClause.OracleSQLPctusedClause visitPctusedClause(PctusedClauseContext ctx) {
        IOracleSQLPhysicalAttributesClause.OracleSQLPctusedClause x = new IOracleSQLPhysicalAttributesClause.OracleSQLPctusedClause();
        SQLExpr value = visitExpr(ctx.expr());
        x.setValue(value);
        return x;
    }

    @Override
    public IOracleSQLPhysicalAttributesClause.OracleSQLInitransClause visitInitransClause(InitransClauseContext ctx) {
        IOracleSQLPhysicalAttributesClause.OracleSQLInitransClause x = new IOracleSQLPhysicalAttributesClause.OracleSQLInitransClause();
        SQLExpr value = visitExpr(ctx.expr());
        x.setValue(value);
        return x;
    }

    @Override
    public IOracleSQLPhysicalAttributesClause.OracleSQLMaxTransClause visitMaxtransClause(MaxtransClauseContext ctx) {
        IOracleSQLPhysicalAttributesClause.OracleSQLMaxTransClause x = new IOracleSQLPhysicalAttributesClause.OracleSQLMaxTransClause();
        SQLExpr value = visitExpr(ctx.expr());
        x.setValue(value);
        return x;
    }

    // ------ size_clause
    @Override
    public OracleSQLSizeClause visitSizeClause(SizeClauseContext ctx) {

        SQLExpr expr = visitExpr(ctx.expr());

        OracleSQLSizeClause x = new OracleSQLSizeClause();
        x.setValue(expr);

        SizeTypeContext sizeTypeContext = ctx.sizeType();
        if (sizeTypeContext != null) {
            OracleSQLSizeClause.Type type = OracleSQLSizeClause.Type.of(sizeTypeContext.getText());
            x.setType(type);
        }

        return x;
    }

    @Override
    public OracleSQLStorageClause visitStorageClause(StorageClauseContext ctx) {

        OracleSQLStorageClause x = new OracleSQLStorageClause();

        for (StorageClauseItemContext storageClauseItemContext : ctx.storageClauseItem()) {
            OracleSQLStorageClause.OracleSQLStorageClauseItem item = (OracleSQLStorageClause.OracleSQLStorageClauseItem) visit(storageClauseItemContext);
            x.addItem(item);
        }

        return x;
    }

    @Override
    public OracleSQLStorageClause.OracleSQLStorageInitialSizeClause visitStorageClauseInitialItem(StorageClauseInitialItemContext ctx) {
        OracleSQLStorageClause.OracleSQLStorageInitialSizeClause x = new OracleSQLStorageClause.OracleSQLStorageInitialSizeClause();

        OracleSQLSizeClause sizeClause = visitSizeClause(ctx.sizeClause());
        x.setSizeClause(sizeClause);
        return x;
    }

    @Override
    public OracleSQLStorageClause.OracleSQLStorageNextSizeClause visitStorageClauseNextItem(StorageClauseNextItemContext ctx) {
        OracleSQLStorageClause.OracleSQLStorageNextSizeClause x = new OracleSQLStorageClause.OracleSQLStorageNextSizeClause();

        OracleSQLSizeClause sizeClause = visitSizeClause(ctx.sizeClause());
        x.setSizeClause(sizeClause);
        return x;
    }

    @Override
    public OracleSQLStorageClause.OracleSQLStorageMinExtentsClause visitStorageClauseMinextentsItem(StorageClauseMinextentsItemContext ctx) {
        OracleSQLStorageClause.OracleSQLStorageMinExtentsClause x = new OracleSQLStorageClause.OracleSQLStorageMinExtentsClause();

        SQLExpr value = visitExpr(ctx.expr());
        x.setValue(value);
        return x;
    }

    @Override
    public OracleSQLStorageClause.OracleSQLStorageMaxExtentsClause visitStorageClauseMaxextentsItem(StorageClauseMaxextentsItemContext ctx) {
        OracleSQLStorageClause.OracleSQLStorageMaxExtentsClause x = new OracleSQLStorageClause.OracleSQLStorageMaxExtentsClause();

        SQLExpr value = visitExpr(ctx.expr());
        x.setValue(value);
        return x;
    }

    @Override
    public OracleSQLMaxSizeClause visitStorageClauseMaxsizeItem(StorageClauseMaxsizeItemContext ctx) {
        OracleSQLMaxSizeClause x = new OracleSQLMaxSizeClause();

        SQLExpr value = SQLUnLimitedLiteral.of();

        if (ctx.sizeClause() != null) {
            value = visitSizeClause(ctx.sizeClause());
        }
        x.setValue(value);
        return x;
    }

    @Override
    public OracleSQLStorageClause.OracleSQLStoragePctIncreaseClause visitStorageClausePctincreaseItem(StorageClausePctincreaseItemContext ctx) {
        OracleSQLStorageClause.OracleSQLStoragePctIncreaseClause x = new OracleSQLStorageClause.OracleSQLStoragePctIncreaseClause();

        SQLExpr value = visitExpr(ctx.expr());
        x.setValue(value);
        return x;
    }

    @Override
    public OracleSQLStorageClause.OracleSQLStorageFreeListsClause visitStorageClauseFreelistsItem(StorageClauseFreelistsItemContext ctx) {
        OracleSQLStorageClause.OracleSQLStorageFreeListsClause x = new OracleSQLStorageClause.OracleSQLStorageFreeListsClause();

        SQLExpr value = visitExpr(ctx.expr());
        x.setValue(value);
        return x;
    }

    @Override
    public OracleSQLStorageClause.OracleSQLStorageFreeListGroupsClause visitStorageClauseFreelistGroupsItem(StorageClauseFreelistGroupsItemContext ctx) {
        OracleSQLStorageClause.OracleSQLStorageFreeListGroupsClause x = new OracleSQLStorageClause.OracleSQLStorageFreeListGroupsClause();

        SQLExpr value = visitExpr(ctx.expr());
        x.setValue(value);

        return x;
    }

    @Override
    public OracleSQLStorageClause.OracleSQLStorageOptimalClause visitStorageClauseOptimalItem(StorageClauseOptimalItemContext ctx) {
        OracleSQLStorageClause.OracleSQLStorageOptimalClause x = new OracleSQLStorageClause.OracleSQLStorageOptimalClause();

        SQLExpr value = null;
        if (ctx.NULL() != null) {
            value = SQLNullExpr.of();
        } else if (ctx.sizeClause() != null) {
            value = visitSizeClause(ctx.sizeClause());
        }

        x.setValue(value);
        return x;
    }

    @Override
    public OracleSQLStorageClause.OracleSQLStorageBufferPoolClause visitStorageClauseBufferPoolItem(StorageClauseBufferPoolItemContext ctx) {
        OracleSQLStorageClause.OracleSQLStorageBufferPoolClause x = new OracleSQLStorageClause.OracleSQLStorageBufferPoolClause();

        OracleSQLStorageClause.SQLBufferPoolType type = OracleSQLStorageClause.SQLBufferPoolType.KEEP;
        if (ctx.RECYCLE() != null) {
            type = OracleSQLStorageClause.SQLBufferPoolType.RECYCLE;
        } else if (ctx.DEFAULT() != null) {
            type = OracleSQLStorageClause.SQLBufferPoolType.DEFAULT;
        }
        x.setType(type);
        return x;
    }

    @Override
    public OracleSQLStorageClause.OracleSQLStorageFlashCacheClause visitStorageClauseFlashCacheItem(StorageClauseFlashCacheItemContext ctx) {
        OracleSQLStorageClause.OracleSQLStorageFlashCacheClause x = new OracleSQLStorageClause.OracleSQLStorageFlashCacheClause();

        OracleSQLStorageClause.SQLFlashCacheType type = OracleSQLStorageClause.SQLFlashCacheType.KEEP;
        if (ctx.NONE() != null) {
            type = OracleSQLStorageClause.SQLFlashCacheType.NONE;
        } else if (ctx.DEFAULT() != null) {
            type = OracleSQLStorageClause.SQLFlashCacheType.DEFAULT;
        }
        x.setType(type);
        return x;
    }

    @Override
    public OracleSQLStorageClause.OracleSQLStorageCellFlashCacheClause visitStorageClauseCellFlashCacheItem(StorageClauseCellFlashCacheItemContext ctx) {
        OracleSQLStorageClause.OracleSQLStorageCellFlashCacheClause x = new OracleSQLStorageClause.OracleSQLStorageCellFlashCacheClause();

        OracleSQLStorageClause.SQLCellFlashCacheType type = OracleSQLStorageClause.SQLCellFlashCacheType.KEEP;
        if (ctx.NONE() != null) {
            type = OracleSQLStorageClause.SQLCellFlashCacheType.NONE;
        } else if (ctx.DEFAULT() != null) {
            type = OracleSQLStorageClause.SQLCellFlashCacheType.DEFAULT;
        }
        x.setType(type);
        return x;
    }

    @Override
    public OracleSQLStorageClause.OracleSQLStorageEncryptClause visitStorageClauseEncryptItem(StorageClauseEncryptItemContext ctx) {
        return new OracleSQLStorageClause.OracleSQLStorageEncryptClause();
    }

    @Override
    public OracleSQLPhysicalPropertyOrganizationHeapClause visitPhysicalPropertyOrganizationHeapClause(PhysicalPropertyOrganizationHeapClauseContext ctx) {
        OracleSQLPhysicalPropertyOrganizationHeapClause x = new OracleSQLPhysicalPropertyOrganizationHeapClause();

        for (SegmentAttributesClauseContext segmentAttributesClauseContext : ctx.segmentAttributesClause()) {
            ISQLSegmentAttributesClause segmentAttributesClause = visitSegmentAttributesClause(segmentAttributesClauseContext);
            x.addSegmentAttributesClause(segmentAttributesClause);
        }

        if (ctx.heapOrgTableClause() != null) {
            OracleSQLHeapOrgTableClause heapOrgTableClause = visitHeapOrgTableClause(ctx.heapOrgTableClause());
            x.setHeapOrgTableClause(heapOrgTableClause);
        }
        return x;
    }

    @Override
    public OracleSQLPhysicalPropertyOrganizationIndexClause visitPhysicalPropertyOrganizationIndexClause(PhysicalPropertyOrganizationIndexClauseContext ctx) {
        OracleSQLPhysicalPropertyOrganizationIndexClause x = new OracleSQLPhysicalPropertyOrganizationIndexClause();

        for (PhysicalPropertyOrganizationIndexClauseItemContext physicalPropertyOrganizationIndexClauseItemContext : ctx.physicalPropertyOrganizationIndexClauseItem()) {
            SQLExpr item = (SQLExpr) visitChildren(physicalPropertyOrganizationIndexClauseItemContext);
            x.addItem(item);
        }
        return x;
    }

    @Override
    public OracleSQLPhysicalPropertyOrganizationExternalClause visitPhysicalPropertyOrganizationExternalClause(PhysicalPropertyOrganizationExternalClauseContext ctx) {
        OracleSQLPhysicalPropertyOrganizationExternalClause x = new OracleSQLPhysicalPropertyOrganizationExternalClause();

        OracleSQLExternalTableClause externalTableClause = visitExternalTableClause(ctx.externalTableClause());
        x.setExternalTableClause(externalTableClause);

        return x;
    }

    @Override
    public OracleSQLPhysicalPropertyClusterClause visitPhysicalPropertyClusterClause(PhysicalPropertyClusterClauseContext ctx) {
        OracleSQLPhysicalPropertyClusterClause x = new OracleSQLPhysicalPropertyClusterClause();
        SQLExpr cluster = visitExpr(ctx.cluster);
        x.setCluster(cluster);

        for (ExprContext exprContext : ctx.columns) {
            SQLExpr column = visitExpr(exprContext);
            x.addColumn(column);
        }

        return x;
    }

    @Override
    public OracleSQLExternalTableClause visitExternalTableClause(ExternalTableClauseContext ctx) {
        OracleSQLExternalTableClause x = new OracleSQLExternalTableClause();

        if (ctx.nameIdentifier() != null) {
            SQLName name = visitNameIdentifier(ctx.nameIdentifier());
            x.setAccessDriverType(name);
        }

        for (ExternalTableDataPropertyContext externalTableDataPropertyContext : ctx.externalTableDataProperty()) {
            SQLExpr externalTableDataProperty = (SQLExpr) visitChildren(externalTableDataPropertyContext);
            x.addExternalTableDataProp(externalTableDataProperty);
        }

        if (ctx.expr() != null) {
            SQLExpr rejectLimit = visitExpr(ctx.expr());
            x.setRejectLimit(rejectLimit);
        }

        if (ctx.inMemoryTableClause() != null) {
            OracleSQLInMemoryTableClause inMemoryTableClause = visitInMemoryTableClause(ctx.inMemoryTableClause());
            x.setInMemoryTableClause(inMemoryTableClause);
        }

        return x;
    }

    @Override
    public SQLObject visitReadOnlyClause(ReadOnlyClauseContext ctx) {
        return super.visitReadOnlyClause(ctx);
    }

    public SQLReadOnlyType of(ReadOnlyClauseContext ctx) {
        if (ctx == null) {
            return null;
        }
        SQLReadOnlyType x = SQLReadOnlyType.READ_ONLY;
        if (ctx.WRITE() != null) {
            x = SQLReadOnlyType.READ_WRITE;
        }
        return x;
    }

    @Override
    public SQLObject visitIndexingClause(IndexingClauseContext ctx) {
        return super.visitIndexingClause(ctx);
    }

    public SQLIndexingOnType of(IndexingClauseContext ctx) {
        if (ctx == null) {
            return null;
        }
        SQLIndexingOnType x = SQLIndexingOnType.INDEXING_ON;
        if (ctx.OFF() != null) {
            x = SQLIndexingOnType.INDEXING_OFF;
        }
        return x;
    }

    @Override
    public SQLExpr visitAccessParametersItem(AccessParametersItemContext ctx) {
        SQLExpr x = null;
        if (ctx.expr() != null) {
            x = visitExpr(ctx.expr());

        } else if (ctx.iSelectQuery() != null) {
            x = visitISelectQuery(ctx.iSelectQuery());
        }
        return x;
    }

    @Override
    public OracleSQLDeferredSegmentCreation visitDeferredSegmentCreation(DeferredSegmentCreationContext ctx) {
        OracleSQLDeferredSegmentCreation x = new OracleSQLDeferredSegmentCreation();

        OracleSQLDeferredSegmentCreation.OracleSQLSegmentCreationType type = OracleSQLDeferredSegmentCreation.OracleSQLSegmentCreationType.IMMEDIATE;
        if (ctx.DEFERRED() != null) {
            type = OracleSQLDeferredSegmentCreation.OracleSQLSegmentCreationType.DEFERRED;
        }
        x.setType(type);
        return x;
    }

    @Override
    public ISQLSegmentAttributesClause visitSegmentAttributesClause(SegmentAttributesClauseContext ctx) {
        return (ISQLSegmentAttributesClause) super.visitChildren(ctx);
    }

    @Override
    public SQLTablespaceOptionExpr visitTableSpaceClause(TableSpaceClauseContext ctx) {
        SQLTablespaceOptionExpr x = new SQLTablespaceOptionExpr();
        SQLName tablespace = visitNameIdentifier(ctx.nameIdentifier());
        x.setValue(tablespace);
        return x;
    }

    @Override
    public SQLTableSpaceSetClause visitTableSpaceSetClause(TableSpaceSetClauseContext ctx) {
        SQLTableSpaceSetClause x = new SQLTableSpaceSetClause();
        SQLName tablespace = visitNameIdentifier(ctx.nameIdentifier());
        x.setTablespace(tablespace);
        return x;
    }

    @Override
    public OracleSQLTableCompressionByCompress visitTableCompressionByCompress(TableCompressionByCompressContext ctx) {
        OracleSQLTableCompressionByCompress x = new OracleSQLTableCompressionByCompress();

        if (ctx.FOR() != null) {
            OracleSQLTableCompressionByCompress.ForOperations forOperations = OracleSQLTableCompressionByCompress.ForOperations.ALL;
            if (ctx.DIRECT_LOAD() != null) {
                forOperations = OracleSQLTableCompressionByCompress.ForOperations.DIRECT_LOAD;
            }
            x.setForOperations(forOperations);
        }
        return x;
    }

    @Override
    public OracleSQLTableCompressionByRowStoreCompress visitTableCompressionByRowStoreCompress(TableCompressionByRowStoreCompressContext ctx) {
        OracleSQLTableCompressionByRowStoreCompress x = new OracleSQLTableCompressionByRowStoreCompress();

        OracleSQLTableCompressionByRowStoreCompress.RowStoreCompressType compressType = null;
        if (ctx.BASIC() != null) {
            compressType = OracleSQLTableCompressionByRowStoreCompress.RowStoreCompressType.BASIC;
        } else if (ctx.ADVANCED() != null) {
            compressType = OracleSQLTableCompressionByRowStoreCompress.RowStoreCompressType.ADVANCED;
        }
        x.setCompressType(compressType);
        return x;
    }

    @Override
    public OracleSQLTableCompressionByColumnStoreCompress visitTableCompressionByColumnStoreCompress(TableCompressionByColumnStoreCompressContext ctx) {
        OracleSQLTableCompressionByColumnStoreCompress x = new OracleSQLTableCompressionByColumnStoreCompress();

        if (ctx.FOR() != null) {
            OracleSQLTableCompressionByColumnStoreCompress.ForType forType = null;
            if (ctx.QUERY() != null) {
                forType = OracleSQLTableCompressionByColumnStoreCompress.ForType.FOR_QUERY;

                if (ctx.LOW() != null) {
                    forType = OracleSQLTableCompressionByColumnStoreCompress.ForType.FOR_QUERY_LOW;
                } else if (ctx.HIGH() != null) {
                    forType = OracleSQLTableCompressionByColumnStoreCompress.ForType.FOR_QUERY_HIGH;
                }

            } else if (ctx.ARCHIVE() != null) {

                forType = OracleSQLTableCompressionByColumnStoreCompress.ForType.FOR_ARCHIVE;
                if (ctx.LOW() != null) {
                    forType = OracleSQLTableCompressionByColumnStoreCompress.ForType.FOR_ARCHIVE_LOW;
                } else if (ctx.HIGH() != null) {
                    forType = OracleSQLTableCompressionByColumnStoreCompress.ForType.FOR_ARCHIVE_HIGH;
                }
            }

            x.setForType(forType);
        }


        if (ctx.ROW() != null
                && ctx.LEVEL() != null
                && ctx.LOCKING() != null) {
            OracleSQLTableCompressionByColumnStoreCompress.RowLevelLockingType rowLevelLockingType = OracleSQLTableCompressionByColumnStoreCompress.RowLevelLockingType.ROW_LEVEL_LOCKING;

            if (ctx.NO() != null) {
                rowLevelLockingType = OracleSQLTableCompressionByColumnStoreCompress.RowLevelLockingType.NO_ROW_LEVEL_LOCKING;
            }

            x.setRowLevelLockingType(rowLevelLockingType);
        }
        return x;
    }

    @Override
    public OracleSQLTableCompressionByNoCompress visitTableCompressionByNoCompress(TableCompressionByNoCompressContext ctx) {
        return new OracleSQLTableCompressionByNoCompress();
    }

    @Override
    public OracleSQLInMemoryTableClause visitInMemoryTableClause(InMemoryTableClauseContext ctx) {

        if (ctx.iInMemoryClause() == null
                && (ctx.iInMemoryColumnClause() == null || ctx.iInMemoryColumnClause().size() == 0)) {
            return null;
        }

        OracleSQLInMemoryTableClause x = new OracleSQLInMemoryTableClause();

        if (ctx.iInMemoryClause() != null) {
            IOracleSQLInMemoryClause inMemoryClause = (IOracleSQLInMemoryClause) visit(ctx.iInMemoryClause());
            x.setInMemoryClause(inMemoryClause);
        }

        for (IInMemoryColumnClauseContext iInMemoryColumnClauseContext : ctx.iInMemoryColumnClause()) {
            IOracleSQLInMemoryColumnClause inMemoryColumnClause = (IOracleSQLInMemoryColumnClause) visit(iInMemoryColumnClauseContext);
            x.addInMemoryColumnClause(inMemoryColumnClause);
        }

        return x;
    }


    @Override
    public OracleSQLInMemoryAttributes visitInMemoryAttributes(InMemoryAttributesContext ctx) {
        if (ctx.iInMemoryMemcompress() == null
                && ctx.inMemoryPriority() == null
                && ctx.inMemoryDistribute() == null
                && ctx.iInMemoryDuplicate() == null) {
            return null;
        }

        OracleSQLInMemoryAttributes x = new OracleSQLInMemoryAttributes();

        if (ctx.iInMemoryMemcompress() != null) {
            visit(ctx.iInMemoryMemcompress());
        }

        if (ctx.inMemoryPriority() != null) {

        }

        if (ctx.inMemoryDistribute() != null) {

        }

        if (ctx.iInMemoryDuplicate() != null) {

        }
        return x;
    }

    @Override
    public SQLObject visitInMemoryMemCompressClause(InMemoryMemCompressClauseContext ctx) {
        return super.visitInMemoryMemCompressClause(ctx);
    }

    @Override
    public SQLObject visitInMemoryNoMemCompressClause(InMemoryNoMemCompressClauseContext ctx) {
        return super.visitInMemoryNoMemCompressClause(ctx);
    }

    @Override
    public SQLObject visitInMemoryPriority(InMemoryPriorityContext ctx) {
        return super.visitInMemoryPriority(ctx);
    }

    @Override
    public SQLObject visitInMemoryDistribute(InMemoryDistributeContext ctx) {
        return super.visitInMemoryDistribute(ctx);
    }

    @Override
    public SQLObject visitInMemoryDuplicate(InMemoryDuplicateContext ctx) {
        return super.visitInMemoryDuplicate(ctx);
    }

    @Override
    public SQLObject visitInMemoryDuplicateAll(InMemoryDuplicateAllContext ctx) {
        return super.visitInMemoryDuplicateAll(ctx);
    }

    @Override
    public SQLObject visitInMemoryNoDuplicate(InMemoryNoDuplicateContext ctx) {
        return super.visitInMemoryNoDuplicate(ctx);
    }

    @Override
    public SQLObject visitInMemoryColumnClause(InMemoryColumnClauseContext ctx) {
        return super.visitInMemoryColumnClause(ctx);
    }

    @Override
    public SQLObject visitIlmClauseAddPolicy(IlmClauseAddPolicyContext ctx) {
        return super.visitIlmClauseAddPolicy(ctx);
    }

    @Override
    public SQLObject visitIlmClauseDeleteAll(IlmClauseDeleteAllContext ctx) {
        return super.visitIlmClauseDeleteAll(ctx);
    }

    @Override
    public SQLObject visitIlmClauseEnableAll(IlmClauseEnableAllContext ctx) {
        return super.visitIlmClauseEnableAll(ctx);
    }

    @Override
    public SQLObject visitIlmClauseDisableAll(IlmClauseDisableAllContext ctx) {
        return super.visitIlmClauseDisableAll(ctx);
    }

    @Override
    public SQLObject visitIlmPolicyClause(IlmPolicyClauseContext ctx) {
        return super.visitIlmPolicyClause(ctx);
    }

    @Override
    public SQLObject visitIlmCompressionPolicy(IlmCompressionPolicyContext ctx) {
        return super.visitIlmCompressionPolicy(ctx);
    }

    @Override
    public SQLObject visitIlmTieringPolicy(IlmTieringPolicyContext ctx) {
        return super.visitIlmTieringPolicy(ctx);
    }

    @Override
    public SQLObject visitIlmInMemoryPolicy(IlmInMemoryPolicyContext ctx) {
        return super.visitIlmInMemoryPolicy(ctx);
    }

    @Override
    public SQLObject visitIlmInMemoryPolicyBySetInMemory(IlmInMemoryPolicyBySetInMemoryContext ctx) {
        return super.visitIlmInMemoryPolicyBySetInMemory(ctx);
    }

    @Override
    public SQLObject visitIlmInMemoryPolicyByModifyInMemory(IlmInMemoryPolicyByModifyInMemoryContext ctx) {
        return super.visitIlmInMemoryPolicyByModifyInMemory(ctx);
    }

    @Override
    public SQLObject visitIlmInMemoryPolicyByNoInMemory(IlmInMemoryPolicyByNoInMemoryContext ctx) {
        return super.visitIlmInMemoryPolicyByNoInMemory(ctx);
    }

    @Override
    public SQLObject visitIlmAfterOfClause(IlmAfterOfClauseContext ctx) {
        return super.visitIlmAfterOfClause(ctx);
    }

    @Override
    public SQLObject visitIlmOnClause(IlmOnClauseContext ctx) {
        return super.visitIlmOnClause(ctx);
    }

    @Override
    public SQLObject visitIlmTimePeriod(IlmTimePeriodContext ctx) {
        return super.visitIlmTimePeriod(ctx);
    }

    @Override
    public IOracleSQLSubstitutableColumnClause.OracleSQLSubstitutableColumnIsOFClause visitSubstitutableColumnIsOfClause(SubstitutableColumnIsOfClauseContext ctx) {
        IOracleSQLSubstitutableColumnClause.OracleSQLSubstitutableColumnIsOFClause x = new IOracleSQLSubstitutableColumnClause.OracleSQLSubstitutableColumnIsOFClause();

        if (ctx.ELEMENT() != null) {
            x.setElement(true);
        }

        if (ctx.TYPE() != null) {
            x.setType(true);
        }

        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setOnlyType(name);

        return x;
    }

    @Override
    public IOracleSQLSubstitutableColumnClause.OracleSQLSubstitutableColumnAtAllLevelsClause visitSubstitutableColumnAtAllLevelsClause(SubstitutableColumnAtAllLevelsClauseContext ctx) {
        IOracleSQLSubstitutableColumnClause.OracleSQLSubstitutableColumnAtAllLevelsClause x = new IOracleSQLSubstitutableColumnClause.OracleSQLSubstitutableColumnAtAllLevelsClause();

        if (ctx.NOT() != null) {
            x.setNot(true);
        }
        return x;
    }

    @Override
    public OracleSQLNestedTableColProperty visitNestedTableColProperty(NestedTableColPropertyContext ctx) {
        OracleSQLNestedTableColProperty x = new OracleSQLNestedTableColProperty();

        SQLExpr nestedItem;
        if (ctx.nestedItem != null) {
            nestedItem = visitNameIdentifier(ctx.nestedItem);
        } else {
            nestedItem = OracleSQLNestedTableColProperty.SQLColumnValue.of();
        }
        x.setNestedItem(nestedItem);

        if (ctx.substitutableColumnClause() != null) {
            IOracleSQLSubstitutableColumnClause substitutableColumnClause = (IOracleSQLSubstitutableColumnClause) visit(ctx.substitutableColumnClause());
            x.setSubstitutableColumnClause(substitutableColumnClause);
        }

        SQLLocalType localType = null;
        if (ctx.LOCAL() != null) {
            localType = SQLLocalType.LOCAL;
        } else if (ctx.GLOBAL() != null) {
            localType = SQLLocalType.GLOBAL;
        }
        x.setLocalType(localType);


        SQLExpr storageTable = visitNameIdentifier(ctx.storageTable);
        x.setStorageTable(storageTable);

        for (NestedTableColPropertyStoreAsItemContext nestedTableColPropertyStoreAsItemContext : ctx.nestedTableColPropertyStoreAsItem()) {
            SQLExpr item = (SQLExpr) visitChildren(nestedTableColPropertyStoreAsItemContext);
            x.addStoreAsItem(item);
        }

        if (ctx.RETURN() != null) {

            OracleSQLNestedTableColProperty.ReturnOption returnOption;

            if (ctx.AS() != null) {
                returnOption = OracleSQLNestedTableColProperty.ReturnOption.RETURN_AS_LOCATOR;
                if (ctx.VALUE() != null) {
                    returnOption = OracleSQLNestedTableColProperty.ReturnOption.RETURN_AS_VALUE;
                }
            } else {
                returnOption = OracleSQLNestedTableColProperty.ReturnOption.RETURN_LOCATOR;
                if (ctx.VALUE() != null) {
                    returnOption = OracleSQLNestedTableColProperty.ReturnOption.RETURN_VALUE;
                }
            }

            x.setReturnOption(returnOption);
        }

        return x;
    }

    @Override
    public OracleSQLVarrayColProperty visitVarrayColProperty(VarrayColPropertyContext ctx) {
        OracleSQLVarrayColProperty x = new OracleSQLVarrayColProperty();

        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setItem(name);

        if (ctx.substitutableColumnClause() != null) {
            IOracleSQLSubstitutableColumnClause substitutableColumnClause = (IOracleSQLSubstitutableColumnClause) visit(ctx.substitutableColumnClause());
            x.setSubstitutableColumnClause(substitutableColumnClause);
        }

        if (ctx.varrayStorageClause() != null) {
            OracleSQLVarrayStorageClause varrayStorageClause = visitVarrayStorageClause(ctx.varrayStorageClause());
            x.setVarrayStorageClause(varrayStorageClause);
        }

        return x;
    }

    @Override
    public OracleSQLVarrayStorageClause visitVarrayStorageClause(VarrayStorageClauseContext ctx) {
        OracleSQLVarrayStorageClause x = new OracleSQLVarrayStorageClause();

        if (ctx.basicFileType() != null) {
            SQLBasicFileType basicFileType = of(ctx.basicFileType());
            x.setStoreAsType(basicFileType);
        }

        if (ctx.nameIdentifier() != null) {
            SQLName segName = visitNameIdentifier(ctx.nameIdentifier());
            x.setSegName(segName);
        }

        if (ctx.lobStorageParameters() != null) {
            OracleSQLLobStorageParameters lobStorageParameters = visitLobStorageParameters(ctx.lobStorageParameters());
            x.setLobStorageParameters(lobStorageParameters);
        }

        return x;
    }

    @Override
    public OracleSQLLobStorageClause visitLobStorageClause(LobStorageClauseContext ctx) {
        OracleSQLLobStorageClause x = new OracleSQLLobStorageClause();

        for (NameIdentifierContext nameIdentifierContext : ctx.nameIdentifier()) {
            SQLName name = visitNameIdentifier(nameIdentifierContext);
            x.addItem(name);
        }

        for (LobStorageClauseStoreAsItemContext lobStorageClauseStoreAsItemContext : ctx.lobStorageClauseStoreAsItem()) {
            SQLExpr parameter = (SQLExpr) visitChildren(lobStorageClauseStoreAsItemContext);
            x.addParameter(parameter);
        }
        return x;
    }

    @Override
    public OracleSQLLobStorageParameters visitLobStorageParameters(LobStorageParametersContext ctx) {
        OracleSQLLobStorageParameters x = new OracleSQLLobStorageParameters();
        for (LobStorageParameterContext lobStorageParameterContext : ctx.lobStorageParameter()) {
            ISQLLobStorageParameter lobStorageParameter = visitLobStorageParameter(lobStorageParameterContext);
            x.addLobStorageParameter(lobStorageParameter);
        }
        return x;
    }

    @Override
    public ISQLLobStorageParameter visitLobStorageParameter(LobStorageParameterContext ctx) {
        return (ISQLLobStorageParameter) super.visitChildren(ctx);
    }

    @Override
    public OracleSQLLobParameterEnable visitLobParameterEnable(LobParameterEnableContext ctx) {
        return new OracleSQLLobParameterEnable();
    }

    @Override
    public OracleSQLLobParameterDisable visitLobParameterDisable(LobParameterDisableContext ctx) {
        return new OracleSQLLobParameterDisable();
    }

    @Override
    public OracleSQLLobParameterChunk visitLobParameterChunk(LobParameterChunkContext ctx) {
        OracleSQLLobParameterChunk x = new OracleSQLLobParameterChunk();
        SQLExpr value = visitExpr(ctx.expr());
        x.setValue(value);
        return x;
    }

    @Override
    public OracleSQLLobParameterPctversion visitLobParameterPctversion(LobParameterPctversionContext ctx) {
        OracleSQLLobParameterPctversion x = new OracleSQLLobParameterPctversion();
        SQLExpr value = visitExpr(ctx.expr());
        x.setValue(value);
        return x;
    }

    @Override
    public OracleSQLLobParameterFreepools visitLobParameterFreepools(LobParameterFreepoolsContext ctx) {
        OracleSQLLobParameterFreepools x = new OracleSQLLobParameterFreepools();
        SQLExpr value = visitExpr(ctx.expr());
        x.setValue(value);
        return x;
    }

    @Override
    public OracleSQLLobRetentionClause visitLobRetentionClause(LobRetentionClauseContext ctx) {
        OracleSQLLobRetentionClause x = new OracleSQLLobRetentionClause();

        OracleSQLLobRetentionClause.OptionType optionType = null;
        if (ctx.MAX() != null) {
            optionType = OracleSQLLobRetentionClause.OptionType.MAX;
        } else if (ctx.MIN() != null) {
            optionType = OracleSQLLobRetentionClause.OptionType.MIN;
        } else if (ctx.AUTO() != null) {
            optionType = OracleSQLLobRetentionClause.OptionType.AUTO;
        } else if (ctx.NONE() != null) {
            optionType = OracleSQLLobRetentionClause.OptionType.NONE;
        }
        x.setOptionType(optionType);

        if (ctx.expr() != null) {
            SQLExpr value = visitExpr(ctx.expr());
            x.setValue(value);
        }
        return x;
    }

    @Override
    public OracleSQLLobDeduplicateClause visitLobDeduplicate(LobDeduplicateContext ctx) {
        return new OracleSQLLobDeduplicateClause();
    }

    @Override
    public OracleSQLLobKeepDuplicatesClause visitLobKeepDuplicates(LobKeepDuplicatesContext ctx) {
        return new OracleSQLLobKeepDuplicatesClause();
    }

    @Override
    public OracleSQLLobCompressionClause visitLobCompressionClause(LobCompressionClauseContext ctx) {
        OracleSQLLobCompressionClause x = new OracleSQLLobCompressionClause();

        OracleSQLLobCompressionClause.CompressionType type = null;
        if (ctx.HIGH() != null) {
            type = OracleSQLLobCompressionClause.CompressionType.HIGH;
        } else if (ctx.MEDIUM() != null) {
            type = OracleSQLLobCompressionClause.CompressionType.MEDIUM;
        } else if (ctx.LOW() != null) {
            type = OracleSQLLobCompressionClause.CompressionType.LOW;
        }
        x.setType(type);
        return x;
    }

    @Override
    public OracleSQLLobNoCompressionClause visitLobNoCompressionClause(LobNoCompressionClauseContext ctx) {
        return new OracleSQLLobNoCompressionClause();
    }

    @Override
    public SQLObject visitLobParameterEncrypt(LobParameterEncryptContext ctx) {
        return super.visitLobParameterEncrypt(ctx);
    }

    @Override
    public OracleSQLLobParameterDecrypt visitLobParameterDecrypt(LobParameterDecryptContext ctx) {
        return new OracleSQLLobParameterDecrypt();
    }

    @Override
    public OracleSQLLobParameterCache visitLobParameterCache(LobParameterCacheContext ctx) {
        OracleSQLLobParameterCache x = new OracleSQLLobParameterCache();
        if (ctx.loggingClause() != null) {
            IOracleSQLLoggingClause loggingClause = visitLoggingClause(ctx.loggingClause());
            x.setLoggingClause(loggingClause);
        }
        return x;
    }

    @Override
    public OracleSQLLobParameterNoCache visitLobParameterNoCache(LobParameterNoCacheContext ctx) {
        OracleSQLLobParameterNoCache x = new OracleSQLLobParameterNoCache();
        if (ctx.loggingClause() != null) {
            IOracleSQLLoggingClause loggingClause = visitLoggingClause(ctx.loggingClause());
            x.setLoggingClause(loggingClause);
        }
        return x;
    }

    @Override
    public OracleSQLLobParameterCacheReads visitLobParameterCacheReads(LobParameterCacheReadsContext ctx) {
        OracleSQLLobParameterCacheReads x = new OracleSQLLobParameterCacheReads();
        if (ctx.loggingClause() != null) {
            IOracleSQLLoggingClause loggingClause = visitLoggingClause(ctx.loggingClause());
            x.setLoggingClause(loggingClause);
        }
        return x;
    }

    @Override
    public OracleSQLLobParameterRebuildFreepools visitLobParameterRebuildFreepools(LobParameterRebuildFreepoolsContext ctx) {
        return new OracleSQLLobParameterRebuildFreepools();
    }

    @Override
    public OracleSQLLobPartitionStorage visitLobPartitionStorage(LobPartitionStorageContext ctx) {
        OracleSQLLobPartitionStorage x = new OracleSQLLobPartitionStorage();

        if (ctx.partitionName != null) {
            SQLName name = visitNameIdentifier(ctx.partitionName);
            x.setName(name);
        }

        for (LobPartitionStoragePartitionItemContext lobPartitionStoragePartitionItemContext : ctx.lobPartitionStoragePartitionItem()) {
            SQLExpr item = (SQLExpr) visitChildren(lobPartitionStoragePartitionItemContext);
            x.addItem(item);
        }


        if (ctx.subpartitionName != null) {
            SQLName subpartitionName = visitNameIdentifier(ctx.subpartitionName);
            x.setSubPartitionName(subpartitionName);
        }

        for (LobPartitionStorageSubpartitionItemContext lobPartitionStorageSubpartitionItemContext : ctx.lobPartitionStorageSubpartitionItem()) {
            SQLExpr item = (SQLExpr) visitChildren(lobPartitionStorageSubpartitionItemContext);
            x.addSubPartitionItem(item);
        }

        return x;
    }

    @Override
    public OracleSQLLobPartitioningStorage visitLobPartitioningStorage(LobPartitioningStorageContext ctx) {
        OracleSQLLobPartitioningStorage x = new OracleSQLLobPartitioningStorage();

        SQLName lobItem = visitNameIdentifier(ctx.lobItem);
        x.setItem(lobItem);

        if (ctx.basicFileType() != null) {
            SQLBasicFileType basicFileType = of(ctx.basicFileType());
            x.setFileType(basicFileType);
        }

        if (ctx.lobSegname != null) {
            SQLName lobSegName = visitNameIdentifier(ctx.lobSegname);
            x.setSegName(lobSegName);
        }

        if (ctx.segmentAttributesClause() != null) {
            ISQLSegmentAttributesClause segmentAttributesClause = visitSegmentAttributesClause(ctx.segmentAttributesClause());
            x.setSegmentAttributesClause(segmentAttributesClause);
        }

        return x;
    }

    @Override
    public OracleSQLXmlTypeColumnProperty visitXmlTypeColumnProperty(XmlTypeColumnPropertyContext ctx) {
        OracleSQLXmlTypeColumnProperty x = new OracleSQLXmlTypeColumnProperty();
        return x;
    }

    @Override
    public OracleSQLXmlTypeStorage.OracleSQLXmlTypeStorageAsObjectRelational visitXmlTypeStorageAsObjectRelational(XmlTypeStorageAsObjectRelationalContext ctx) {
        return new OracleSQLXmlTypeStorage.OracleSQLXmlTypeStorageAsObjectRelational();
    }

    @Override
    public OracleSQLXmlTypeStorage.OracleSQLXmlTypeStorageAsClob visitXmlTypeStorageAsClob(XmlTypeStorageAsClobContext ctx) {
        OracleSQLXmlTypeStorage.OracleSQLXmlTypeStorageAsClob x = new OracleSQLXmlTypeStorage.OracleSQLXmlTypeStorageAsClob();

        if (ctx.basicFileType() != null) {
            SQLBasicFileType fileType = of(ctx.basicFileType());
            x.setFileType(fileType);
        }

        if (ctx.expr() != null) {
            SQLExpr name = visitExpr(ctx.expr());
            x.setLobSegName(name);
        }

        for (LobParameterContext lobParameterContext : ctx.lobParameter()) {
            ISQLLobParameter parameter = (ISQLLobParameter) visit(lobParameterContext);
            x.addParameter(parameter);
        }

        return x;
    }

    @Override
    public OracleSQLXmlTypeStorage.OracleSQLXmlTypeStorageAsBinaryXml visitXmlTypeStorageAsBinaryXml(XmlTypeStorageAsBinaryXmlContext ctx) {
        OracleSQLXmlTypeStorage.OracleSQLXmlTypeStorageAsBinaryXml x = new OracleSQLXmlTypeStorage.OracleSQLXmlTypeStorageAsBinaryXml();

        if (ctx.basicFileType() != null) {
            SQLBasicFileType fileType = of(ctx.basicFileType());
            x.setFileType(fileType);
        }

        if (ctx.expr() != null) {
            SQLExpr name = visitExpr(ctx.expr());
            x.setLobSegName(name);
        }

        for (LobParameterContext lobParameterContext : ctx.lobParameter()) {
            ISQLLobParameter parameter = (ISQLLobParameter) visit(lobParameterContext);
            x.addParameter(parameter);
        }

        return x;
    }

    @Override
    public OracleSQLXmlTypeStorage.OracleSQLXmlTypeStorageAsAllVarrays visitXmlTypeStorageAsAllVarrays(XmlTypeStorageAsAllVarraysContext ctx) {
        if (ctx == null) {
            return null;
        }
        OracleSQLXmlTypeStorage.OracleSQLXmlTypeStorageAsAllVarrays x = new OracleSQLXmlTypeStorage.OracleSQLXmlTypeStorageAsAllVarrays();
        OracleSQLStoreAllVarraysAsType type = OracleSQLStoreAllVarraysAsType.LOBS;
        if (ctx.TABLES() != null) {
            type = OracleSQLStoreAllVarraysAsType.TABLES;
        }
        x.setType(type);
        return x;
    }

    @Override
    public SQLXmlSchemaSpec visitXmlSchemaSpec(XmlSchemaSpecContext ctx) {
        SQLXmlSchemaSpec x = new SQLXmlSchemaSpec();
        if (ctx.xmlSchemaUrl != null) {
            SQLExpr xmlSchemaUrl = visitExpr(ctx.xmlSchemaUrl);
            x.setXmlSchemaUrl(xmlSchemaUrl);
        }

        if (ctx.elementXmlSchemaUrl != null) {
            SQLExpr elementXmlSchemaUrl = visitExpr(ctx.elementXmlSchemaUrl);
            x.setElementXmlSchemaUrl(elementXmlSchemaUrl);
        }

        if (ctx.element != null) {
            SQLExpr element = visitExpr(ctx.element);
            x.setElement(element);
        }

        OracleSQLStoreAllVarraysAsType storeAllVarraysAsType = null;
        if (ctx.LOBS() != null) {
            storeAllVarraysAsType = OracleSQLStoreAllVarraysAsType.LOBS;
        } else if (ctx.TABLES() != null) {
            storeAllVarraysAsType = OracleSQLStoreAllVarraysAsType.TABLES;
        }
        // todo
        // x.setStoreAllVarraysAsType(storeAllVarraysAsType);

        return x;
    }

    @Override
    public OracleSQLXMLTypeVirtualColumns visitXmlTypeVirtualColumns(XmlTypeVirtualColumnsContext ctx) {
        OracleSQLXMLTypeVirtualColumns x = new OracleSQLXMLTypeVirtualColumns();
        for (XmlTypeVirtualColumnsItemContext xmlTypeVirtualColumnsItemContext : ctx.xmlTypeVirtualColumnsItem()) {
            OracleSQLXMLTypeVirtualColumns.SQLItem item = visitXmlTypeVirtualColumnsItem(xmlTypeVirtualColumnsItemContext);
            x.addItem(item);
        }
        return x;
    }

    @Override
    public OracleSQLXMLTypeVirtualColumns.SQLItem visitXmlTypeVirtualColumnsItem(XmlTypeVirtualColumnsItemContext ctx) {
        OracleSQLXMLTypeVirtualColumns.SQLItem x = new OracleSQLXMLTypeVirtualColumns.SQLItem();
        SQLName column = visitNameIdentifier(ctx.nameIdentifier());
        SQLExpr expr = visitExpr(ctx.expr());
        x.setColumn(column);
        x.setExpr(expr);
        return x;
    }

    @Override
    public SQLStoreInClause visitStoreInClause(StoreInClauseContext ctx) {
        SQLStoreInClause x = new SQLStoreInClause();
        for (ExprContext exprContext : ctx.expr()) {
            SQLExpr expr = visitExpr(exprContext);
            x.addItem(expr);
        }
        return x;
    }

    @Override
    public SQLOverflowStoreInClause visitOverflowStoreInClause(OverflowStoreInClauseContext ctx) {
        SQLOverflowStoreInClause x = new SQLOverflowStoreInClause();
        for (ExprContext exprContext : ctx.expr()) {
            SQLExpr expr = visitExpr(exprContext);
            x.addItem(expr);
        }
        return x;
    }

    @Override
    public SQLSubPartitionsetStoreInClause visitSubPartitionsetStoreInClause(SubPartitionsetStoreInClauseContext ctx) {
        SQLSubPartitionsetStoreInClause x = new SQLSubPartitionsetStoreInClause();
        for (ExprContext exprContext : ctx.expr()) {
            SQLExpr expr = visitExpr(exprContext);
            x.addItem(expr);
        }
        return x;
    }

    // ----------------Table Partition
    @Override
    public SQLTablePartitioning visitTablePartitioningClause(TablePartitioningClauseContext ctx) {
        return (SQLTablePartitioning) super.visitChildren(ctx);
    }

    @Override
    public ISQLPartitionBy visitIPartitionBy(IPartitionByContext ctx) {
        return (ISQLPartitionBy) super.visitChildren(ctx);
    }

    @Override
    public SQLPartitionByRange visitPartitionByRange(PartitionByRangeContext ctx) {
        SQLPartitionByRange x = new SQLPartitionByRange();

        for (ExprContext exprContext : ctx.columns) {
            SQLExpr column = visitExpr(exprContext);
            x.addColumn(column);
        }

        if (ctx.interval != null) {
            SQLExpr interval = visitExpr(ctx.interval);
            x.setInterval(interval);
        }

        if (ctx.storeInClause() != null) {
            SQLStoreInClause storeInClause = visitStoreInClause(ctx.storeInClause());
            x.setStoreInClause(storeInClause);
        }

        if (ctx.iSubPartitionBy() != null) {
            ISQLSubPartitionBy subPartitionBy = visitISubPartitionBy(ctx.iSubPartitionBy());
            x.setSubPartitionBy(subPartitionBy);
        }

        for (PartitionDefinitionContext partitionDefinitionContext : ctx.partitionDefinition()) {
            SQLPartitionDefinition partition = visitPartitionDefinition(partitionDefinitionContext);
            x.addPartition(partition);
        }

        return x;
    }

    @Override
    public SQLPartitionByHash visitPartitionByHash(PartitionByHashContext ctx) {
        SQLPartitionByHash x = new SQLPartitionByHash();

        for (ExprContext exprContext : ctx.columns) {
            SQLExpr column = visitExpr(exprContext);
            x.addColumn(column);
        }

        if (ctx.partitionsNum != null) {
            SQLExpr partitionsNum = visitExpr(ctx.partitionsNum);
            x.setPartitionsNum(partitionsNum);
        }

        if (ctx.storeInClause() != null) {
            SQLStoreInClause storeInClause = visitStoreInClause(ctx.storeInClause());
            x.setStoreInClause(storeInClause);
        }

        if (ctx.iCompression() != null) {
            ISQLCompression compression = (ISQLCompression) visitChildren(ctx.iCompression());
            x.setCompression(compression);
        }

        if (ctx.overflowStoreInClause() != null) {
            SQLOverflowStoreInClause overflowStoreInClause = visitOverflowStoreInClause(ctx.overflowStoreInClause());
            x.setOverflowStoreInClause(overflowStoreInClause);
        }

        if (ctx.iSubPartitionBy() != null) {
            ISQLSubPartitionBy subPartitionBy = visitISubPartitionBy(ctx.iSubPartitionBy());
            x.setSubPartitionBy(subPartitionBy);
        }

        for (PartitionDefinitionContext partitionDefinitionContext : ctx.partitionDefinition()) {
            SQLPartitionDefinition partition = visitPartitionDefinition(partitionDefinitionContext);
            x.addPartition(partition);
        }

        return x;
    }

    @Override
    public SQLPartitionByList visitPartitionByList(PartitionByListContext ctx) {
        SQLPartitionByList x = new SQLPartitionByList();

        for (ExprContext exprContext : ctx.columns) {
            SQLExpr column = visitExpr(exprContext);
            x.addColumn(column);
        }

        if (ctx.storeInClause() != null) {
            SQLStoreInClause storeInClause = visitStoreInClause(ctx.storeInClause());
            x.setStoreInClause(storeInClause);
        }

        if (ctx.iSubPartitionBy() != null) {
            ISQLSubPartitionBy subPartitionBy = visitISubPartitionBy(ctx.iSubPartitionBy());
            x.setSubPartitionBy(subPartitionBy);
        }

        for (PartitionDefinitionContext partitionDefinitionContext : ctx.partitionDefinition()) {
            SQLPartitionDefinition partition = visitPartitionDefinition(partitionDefinitionContext);
            x.addPartition(partition);
        }
        return x;
    }

    @Override
    public SQLPartitionByReference visitPartitionByReference(PartitionByReferenceContext ctx) {
        SQLPartitionByReference x = new SQLPartitionByReference();

        SQLExpr column = visitExpr(ctx.expr());
        x.addColumn(column);

        for (PartitionDefinitionContext partitionDefinitionContext : ctx.partitionDefinition()) {
            SQLPartitionDefinition partition = visitPartitionDefinition(partitionDefinitionContext);
            x.addPartition(partition);
        }

        return x;
    }

    @Override
    public SQLPartitionBySystem visitPartitionBySystem(PartitionBySystemContext ctx) {
        SQLPartitionBySystem x = new SQLPartitionBySystem();

        if (ctx.expr() != null) {
            SQLExpr partitionsQuantity = visitExpr(ctx.expr());
            x.setPartitionsNum(partitionsQuantity);
        }

        for (PartitionDefinitionContext partitionDefinitionContext : ctx.partitionDefinition()) {
            SQLPartitionDefinition partition = visitPartitionDefinition(partitionDefinitionContext);
            x.addPartition(partition);
        }

        return x;
    }

    @Override
    public SQLPartitionByConsistentHash visitPartitionByConsistentHash(PartitionByConsistentHashContext ctx) {
        SQLPartitionByConsistentHash x = new SQLPartitionByConsistentHash();

        for (ExprContext exprContext : ctx.columns) {
            SQLExpr column = visitExpr(exprContext);
            x.addColumn(column);
        }

        if (ctx.iSubPartitionBy() != null) {
            ISQLSubPartitionBy subPartitionBy = visitISubPartitionBy(ctx.iSubPartitionBy());
            x.setSubPartitionBy(subPartitionBy);
        }

        if (ctx.partitionsAuto() != null) {
            x.setPartitionsAuto(true);
        }

        if (ctx.tableSpaceClause() != null) {
            SQLTablespaceOptionExpr tableSpaceClause = visitTableSpaceClause(ctx.tableSpaceClause());
            x.setTableSpaceClause(tableSpaceClause);
        }

        return x;
    }

    @Override
    public SQLPartitionDefinition visitPartitionDefinition(PartitionDefinitionContext ctx) {
        SQLPartitionDefinition x = new SQLPartitionDefinition();

        if (ctx.partitionName != null) {
            SQLName name = visitNameIdentifier(ctx.partitionName);
            x.setName(name);
        }

        if (ctx.iPartitionValues() != null) {
            ISQLPartitionValues values = (ISQLPartitionValues) visit(ctx.iPartitionValues());
            x.setValues(values);
        }

        for (PartitionDefinitionOptionContext partitionDefinitionOptionContext : ctx.partitionDefinitionOption()) {
            SQLExpr option = (SQLExpr) visitChildren(partitionDefinitionOptionContext);
            x.addOption(option);
        }

        if (ctx.subpartitionsNum != null) {
            SQLExpr subpartitionsNum = visitExpr(ctx.subpartitionsNum);
            x.setSubpartitionsNum(subpartitionsNum);
        }

        if (ctx.storeInClause() != null) {
            SQLStoreInClause storeInClause = visitStoreInClause(ctx.storeInClause());
            x.setStoreInClause(storeInClause);
        }

        for (SubPartitionDefinitionContext subPartitionDefinitionContext : ctx.subPartitionDefinition()) {
            SQLSubPartitionDefinition subPartition = visitSubPartitionDefinition(subPartitionDefinitionContext);
            x.addSubPartition(subPartition);
        }

        return x;
    }


    @Override
    public ISQLPartitionsetBy visitIpartitionsetBy(IpartitionsetByContext ctx) {
        return (ISQLPartitionsetBy) super.visitChildren(ctx);
    }

    @Override
    public SQLPartitionsetByRange visitPartitionsetByRange(PartitionsetByRangeContext ctx) {
        SQLPartitionsetByRange x = new SQLPartitionsetByRange();

        for (ExprContext exprContext : ctx.columns) {
            SQLExpr column = visitExpr(exprContext);
            x.addColumn(column);
        }

        if (ctx.iPartitionBy() != null) {
            ISQLPartitionBy partitionBy = visitIPartitionBy(ctx.iPartitionBy());
            x.setPartitionBy(partitionBy);
        }

        if (ctx.iSubPartitionBy() != null) {
            ISQLSubPartitionBy subPartitionBy = visitISubPartitionBy(ctx.iSubPartitionBy());
            x.setSubPartitionBy(subPartitionBy);
        }

        for (PartitionsetDefinitionContext partitionsetDefinitionContext : ctx.partitionsetDefinition()) {
            SQLPartitionsetDefinition partitionset = visitPartitionsetDefinition(partitionsetDefinitionContext);
            x.addPartitionset(partitionset);
        }
        return x;
    }

    @Override
    public SQLPartitionsetByList visitPartitionsetByList(PartitionsetByListContext ctx) {
        SQLPartitionsetByList x = new SQLPartitionsetByList();
        for (ExprContext exprContext : ctx.columns) {
            SQLExpr column = visitExpr(exprContext);
            x.addColumn(column);
        }

        if (ctx.iPartitionBy() != null) {
            ISQLPartitionBy partitionBy = visitIPartitionBy(ctx.iPartitionBy());
            x.setPartitionBy(partitionBy);
        }

        if (ctx.iSubPartitionBy() != null) {
            ISQLSubPartitionBy subPartitionBy = visitISubPartitionBy(ctx.iSubPartitionBy());
            x.setSubPartitionBy(subPartitionBy);
        }

        for (PartitionsetDefinitionContext partitionsetDefinitionContext : ctx.partitionsetDefinition()) {
            SQLPartitionsetDefinition partitionset = visitPartitionsetDefinition(partitionsetDefinitionContext);
            x.addPartitionset(partitionset);
        }
        return x;
    }

    @Override
    public SQLPartitionsetDefinition visitPartitionsetDefinition(PartitionsetDefinitionContext ctx) {
        SQLPartitionsetDefinition x = new SQLPartitionsetDefinition();

        if (ctx.nameIdentifier() != null) {
            SQLName name = visitNameIdentifier(ctx.nameIdentifier());
            x.setName(name);
        }

        if (ctx.iPartitionValues() != null) {
            ISQLPartitionValues values = (ISQLPartitionValues) visit(ctx.iPartitionValues());
            x.setValues(values);
        }

        for (PartitionsetDefinitionOptionContext partitionsetDefinitionOptionContext : ctx.partitionsetDefinitionOption()) {
            SQLExpr option = (SQLExpr) visitChildren(partitionsetDefinitionOptionContext);
            x.addOption(option);
        }
        return x;
    }


    @Override
    public SQLPartitionValuesLessThan visitPartitionValuesLessThan(PartitionValuesLessThanContext ctx) {
        SQLPartitionValuesLessThan x = new SQLPartitionValuesLessThan();

        for (ExprContext exprContext : ctx.expr()) {
            SQLExpr value = visitExpr(exprContext);
            x.addValue(value);
        }

        return x;
    }

    @Override
    public SQLPartitionValues visitPartitionValues(PartitionValuesContext ctx) {
        SQLPartitionValues x = new SQLPartitionValues();
        for (ExprContext exprContext : ctx.expr()) {
            SQLExpr value = visitExpr(exprContext);
            x.addValue(value);
        }
        return x;
    }

    @Override
    public ISQLSubPartitionBy visitISubPartitionBy(ISubPartitionByContext ctx) {
        return (ISQLSubPartitionBy) super.visitChildren(ctx);
    }

    @Override
    public SQLSubpartitionTemplate visitSubpartitionTemplate(SubpartitionTemplateContext ctx) {
        SQLSubpartitionTemplate x = new SQLSubpartitionTemplate();

        for (SubPartitionDefinitionContext subPartitionDefinitionContext : ctx.subPartitionDefinition()) {
            SQLSubPartitionDefinition subPartition = visitSubPartitionDefinition(subPartitionDefinitionContext);
            x.addSubPartition(subPartition);
        }
        return x;
    }

    @Override
    public SQLSubPartitionByRange visitSubpartitionByRange(SubpartitionByRangeContext ctx) {
        SQLSubPartitionByRange x = new SQLSubPartitionByRange();

        for (ExprContext exprContext : ctx.expr()) {
            SQLExpr column = visitExpr(exprContext);
            x.addColumn(column);
        }

        if (ctx.subpartitionTemplate() != null) {
            SQLSubpartitionTemplate subpartitionTemplate = visitSubpartitionTemplate(ctx.subpartitionTemplate());
            x.setSubpartitionTemplate(subpartitionTemplate);
        }

        return x;
    }

    @Override
    public SQLSubPartitionByList visitSubpartitionByList(SubpartitionByListContext ctx) {
        SQLSubPartitionByList x = new SQLSubPartitionByList();

        for (ExprContext exprContext : ctx.expr()) {
            SQLExpr column = visitExpr(exprContext);
            x.addColumn(column);
        }

        if (ctx.subpartitionTemplate() != null) {
            SQLSubpartitionTemplate subpartitionTemplate = visitSubpartitionTemplate(ctx.subpartitionTemplate());
            x.setSubpartitionTemplate(subpartitionTemplate);
        }
        return x;
    }

    @Override
    public SQLSubPartitionByHash visitSubpartitionByHash(SubpartitionByHashContext ctx) {
        SQLSubPartitionByHash x = new SQLSubPartitionByHash();

        for (ExprContext exprContext : ctx.columns) {
            SQLExpr column = visitExpr(exprContext);
            x.addColumn(column);
        }

        if (ctx.subpartitionsNum != null) {
            SQLExpr subpartitionsNum = visitExpr(ctx.subpartitionsNum);
            x.setSubpartitionsNum(subpartitionsNum);
        }

        if (ctx.storeInClause() != null) {
            SQLStoreInClause storeInClause = visitStoreInClause(ctx.storeInClause());
            x.setStoreInClause(storeInClause);
        }

        if (ctx.subpartitionTemplate() != null) {
            SQLSubpartitionTemplate subpartitionTemplate = visitSubpartitionTemplate(ctx.subpartitionTemplate());
            x.setSubpartitionTemplate(subpartitionTemplate);
        }
        return x;
    }

    @Override
    public SQLSubPartitionDefinition visitSubPartitionDefinition(SubPartitionDefinitionContext ctx) {
        SQLSubPartitionDefinition x = new SQLSubPartitionDefinition();

        if (ctx.nameIdentifier() != null) {
            SQLName name = visitNameIdentifier(ctx.nameIdentifier());
            x.setName(name);
        }

        if (ctx.iPartitionValues() != null) {
            ISQLPartitionValues values = (ISQLPartitionValues) visit(ctx.iPartitionValues());
            x.setValues(values);
        }

        for (SubPartitionDefinitionOptionContext subPartitionDefinitionOptionContext : ctx.subPartitionDefinitionOption()) {
            SQLExpr option = (SQLExpr) visitChildren(subPartitionDefinitionOptionContext);
            x.addOption(option);
        }

        return x;
    }


    // ---------------------------- Common SQL DDL Clauses End


    // --------------------------------------- PL/SQL Language Elements Start ----------------------------------------------------------------

    // 13.1 ACCESSIBLE BY Clause
    @Override
    public OracleSQLAccessibleByClause visitAccessibleByClause(AccessibleByClauseContext ctx) {
        OracleSQLAccessibleByClause x = new OracleSQLAccessibleByClause();
        for (AccessorContext accessorContext : ctx.accessor()) {
            OracleSQLAccessorClause accessorClause = visitAccessor(accessorContext);
            x.addAccessorClause(accessorClause);
        }
        return x;
    }

    @Override
    public OracleSQLAccessorClause visitAccessor(AccessorContext ctx) {
        OracleSQLAccessorClause x = new OracleSQLAccessorClause();

        if (ctx.unitKind() != null) {
            OracleSQLAccessorClause.SQLUnitKind unitKind = OracleSQLAccessorClause.SQLUnitKind.of(ctx.unitKind().getText());
            x.setUnitKind(unitKind);
        }

        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);
        return x;
    }


    // 13.2 AGGREGATE Clause
    @Override
    public OracleSQLAggregateClause visitAggregateClause(AggregateClauseContext ctx) {
        SQLName name = visitNameIdentifier(ctx.usingName);
        return new OracleSQLAggregateClause(name);
    }

    // 13.3 Assignment Statement
    @Override
    public OracleSQLAssignmentStatement visitAssignmentStatement(AssignmentStatementContext ctx) {
        SQLExpr target = visitExpr(ctx.target);
        SQLExpr value = visitExpr(ctx.value);
        return new OracleSQLAssignmentStatement(target, value);
    }

    // 13.4 AUTONOMOUS_TRANSACTION Pragma
    @Override
    public OracleSQLAutonomousTransPragma visitAutonomousTransPragma(AutonomousTransPragmaContext ctx) {
        return new OracleSQLAutonomousTransPragma();
    }

    // 13.5 Basic LOOP Statement
    @Override
    public SQLLoopStatement visitBasicLoopStatement(BasicLoopStatementContext ctx) {
        SQLLoopStatement x = new SQLLoopStatement(DBType.Oracle);
        for (BodyItemContext bodyItemContext : ctx.bodyItem()) {
            SQLBody.SQLBodyItem bodyItem = visitBodyItem(bodyItemContext);
            x.addStatement(bodyItem);
        }

        if (ctx.nameIdentifier() != null) {
            SQLName endLabel = visitNameIdentifier(ctx.nameIdentifier());
            x.setEndLabel(endLabel);
        }
        return x;
    }

    // 13.6 Block
    @Override
    public OracleSQLBlock visitPlsqlBlock(PlsqlBlockContext ctx) {
        OracleSQLBlock x = new OracleSQLBlock();
        for (LabelDeclarationContext labelDeclarationContext : ctx.labelDeclaration()) {
            SQLLabel label = visitLabelDeclaration(labelDeclarationContext);
            x.addLabel(label);
        }

        if (ctx.declareSection() != null
                && ctx.declareSection().size() > 0) {
            for (DeclareSectionContext declareSectionContext : ctx.declareSection()) {
                SQLObject declare = visitDeclareSection(declareSectionContext);
                x.addDeclare(declare);
            }
        }

        SQLBody body = visitBody(ctx.body());
        x.setBody(body);

        return x;
    }

    @Override
    public OracleSQLSubtypeDefinition visitSubTypeDefinition(SubTypeDefinitionContext ctx) {
        OracleSQLSubtypeDefinition x = new OracleSQLSubtypeDefinition();

        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        SQLDataType dataType = visitDataType(ctx.dataType());

        x.setName(name);
        x.setDataType(dataType);

        if (ctx.subTypeDefinitionConstraint() != null) {
            SQLExpr constraint = (SQLExpr) visitChildren(ctx.subTypeDefinitionConstraint());
            x.setConstraint(constraint);
        }

        if (ctx.notNull() != null) {
            x.setNotNull(true);
        }

        return x;
    }

    @Override
    public SQLRangeExpr visitRangeExpr(RangeExprContext ctx) {

        SQLExpr lower = visitExpr(ctx.lowerValue);
        SQLExpr high = visitExpr(ctx.highValue);

        return new SQLRangeExpr(lower, high);
    }

    @Override
    public SQLBody visitBody(OracleSQLStatementParser.BodyContext ctx) {
        SQLBody x = new SQLBody();
        for (BodyItemContext bodyItemContext : ctx.bodyItem()) {
            SQLBody.SQLBodyItem bodyItem = visitBodyItem(bodyItemContext);
            x.addBodyItem(bodyItem);
        }


        if (ctx.exceptionClause() != null) {
            SQLExceptionClause exceptionClause = visitExceptionClause(ctx.exceptionClause());
            x.setExceptionClause(exceptionClause);
        }

        if (ctx.nameIdentifier() != null) {
            SQLName name = visitNameIdentifier(ctx.nameIdentifier());
            x.setEndName(name);
        }

        return x;
    }

    @Override
    public SQLBody.SQLBodyItem visitBodyItem(BodyItemContext ctx) {
        SQLBody.SQLBodyItem x = new SQLBody.SQLBodyItem();

        for (LabelDeclarationContext labelDeclarationContext : ctx.labelDeclaration()) {
            SQLLabel label = visitLabelDeclaration(labelDeclarationContext);
            x.addLabel(label);
        }

        SQLObject statement = visitBodyItemStatement(ctx.bodyItemStatement());
        x.setStatement(statement);

        if (ctx.SEMI() != null) {
            statement.setAfterSemi(true);
        }

        return x;
    }

    @Override
    public SQLLabel visitLabelDeclaration(LabelDeclarationContext ctx) {
        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        return new SQLLabel(name);
    }


    @Override
    public SQLProcedureInvocation visitProcedureCall(ProcedureCallContext ctx) {
        SQLName name = visitNameIdentifier(ctx.nameIdentifier());

        SQLProcedureInvocation x = new SQLProcedureInvocation(name);

        for (ExprContext exprContext : ctx.expr()) {
            SQLExpr argument = visitExpr(exprContext);
            x.addArgument(argument);
        }

        return x;
    }

    // 13.7 Call Specification
    @Override
    public OracleSQLCallSpec.OracleSQLJavaDeclaration visitJavaDeclaration(JavaDeclarationContext ctx) {
        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        return new OracleSQLCallSpec.OracleSQLJavaDeclaration(name);
    }

    @Override
    public OracleSQLCallSpec.OracleSQLCDeclaration visitCDeclaration(CDeclarationContext ctx) {
        OracleSQLCallSpec.OracleSQLCDeclaration x = new OracleSQLCallSpec.OracleSQLCDeclaration();

        OracleSQLCallSpec.OracleSQLCDeclarationType type = null;
        if (ctx.LANGUAGE() != null
                && ctx.C_LETTER() != null) {
            type = OracleSQLCallSpec.OracleSQLCDeclarationType.LANGUAGE_C;
        } else if (ctx.EXTERNAL() != null) {
            type = OracleSQLCallSpec.OracleSQLCDeclarationType.EXTERNAL;
        }
        x.setType(type);

        for (CDeclarationNameContext cDeclarationNameContext : ctx.cDeclarationName()) {
            SQLExpr languageName = (SQLExpr) visit(cDeclarationNameContext);
            x.addName(languageName);
        }


        if (ctx.agentIn != null
                && ctx.agentIn.size() > 0) {
            for (ExprContext exprContext : ctx.agentIn) {
                SQLExpr agentInArgument = visitExpr(exprContext);
                x.addAgentInArgument(agentInArgument);
            }
        }

        if (ctx.withContext() != null) {
            x.setWithContext(true);
        }

        if (ctx.externalParameter() != null
                && ctx.externalParameter().size() > 0) {
            for (ExternalParameterContext externalParameterContext : ctx.externalParameter()) {
                OracleSQLCallSpec.OracleSQLExternalParameter parameter = (OracleSQLCallSpec.OracleSQLExternalParameter) visit(externalParameterContext);
                x.addParameter(parameter);
            }
        }
        return x;
    }

    @Override
    public OracleSQLCallSpec.LanguageCNameExpr visitLanguageCName(LanguageCNameContext ctx) {
        SQLExpr name = visitExpr(ctx.expr());
        return new OracleSQLCallSpec.LanguageCNameExpr(name);
    }

    @Override
    public OracleSQLCallSpec.LanguageCLibraryExpr visitLanguageClibraryName(LanguageClibraryNameContext ctx) {
        SQLExpr name = visitExpr(ctx.expr());
        return new OracleSQLCallSpec.LanguageCLibraryExpr(name);
    }

    @Override
    public OracleSQLCallSpec.OracleSQLContextExternalParameter visitContextExternalParameter(ContextExternalParameterContext ctx) {
        return new OracleSQLCallSpec.OracleSQLContextExternalParameter();
    }

    @Override
    public OracleSQLCallSpec.OracleSQLSelfExternalParameter visitSelfExternalParameter(SelfExternalParameterContext ctx) {
        OracleSQLCallSpec.OracleSQLSelfExternalParameter x = new OracleSQLCallSpec.OracleSQLSelfExternalParameter();

        OracleSQLCallSpec.OracleSQLExternalParameterProperty property = of(ctx.externalParameterProperty());
        x.setProperty(property);
        return x;
    }

    @Override
    public OracleSQLCallSpec.OracleSQLReturnExternalParameter visitReturnExternalParameter(ReturnExternalParameterContext ctx) {
        OracleSQLCallSpec.OracleSQLReturnExternalParameter x = new OracleSQLCallSpec.OracleSQLReturnExternalParameter();


        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);

        OracleSQLCallSpec.OracleSQLExternalParameterProperty property = of(ctx.externalParameterProperty());
        x.setProperty(property);

        if (ctx.byReference() != null) {
            x.setByReference(true);
        }

        if (ctx.dataType() != null) {
            SQLDataType dataType = visitDataType(ctx.dataType());
            x.setDataType(dataType);
        }
        return x;
    }


    public OracleSQLCallSpec.OracleSQLExternalParameterProperty of(ExternalParameterPropertyContext ctx) {
        if (ctx == null) {
            return null;
        }
        OracleSQLCallSpec.OracleSQLExternalParameterProperty x = null;

        if (ctx.INDICATOR() != null) {
            x = OracleSQLCallSpec.OracleSQLExternalParameterProperty.INDICATOR;

            if (ctx.STRUCT() != null) {
                x = OracleSQLCallSpec.OracleSQLExternalParameterProperty.INDICATOR_STRUCT;
            } else if (ctx.TDO() != null) {
                x = OracleSQLCallSpec.OracleSQLExternalParameterProperty.INDICATOR_TDO;
            }
        } else if (ctx.TDO() != null) {
            x = OracleSQLCallSpec.OracleSQLExternalParameterProperty.TDO;

        } else if (ctx.LENGTH() != null) {
            x = OracleSQLCallSpec.OracleSQLExternalParameterProperty.LENGTH;

        } else if (ctx.DURATION() != null) {
            x = OracleSQLCallSpec.OracleSQLExternalParameterProperty.DURATION;

        } else if (ctx.MAXLEN() != null) {
            x = OracleSQLCallSpec.OracleSQLExternalParameterProperty.MAXLEN;

        } else if (ctx.CHARSETID() != null) {
            x = OracleSQLCallSpec.OracleSQLExternalParameterProperty.CHARSETID;

        } else if (ctx.CHARSETFORM() != null) {
            x = OracleSQLCallSpec.OracleSQLExternalParameterProperty.CHARSETFORM;

        }

        return x;
    }

    // 13.8 CASE Statement
    @Override
    public SQLCaseStatement visitCaseStatement(CaseStatementContext ctx) {
        SQLCaseStatement x = new SQLCaseStatement(DBType.Oracle);
        if (ctx.expr() != null) {
            SQLExpr expr = visitExpr(ctx.expr());
            x.setSelector(expr);
        }

        for (CaseStatementWhenItemContext caseStatementWhenItemContext : ctx.caseStatementWhenItem()) {
            SQLCaseStatement.SQLCaseStatementWhenItem whenItem = visitCaseStatementWhenItem(caseStatementWhenItemContext);
            x.addWhenItem(whenItem);
        }

        if (ctx.caseStatementElseClause() != null) {
            SQLCaseStatement.SQLCaseStatementElseClause elseClause = visitCaseStatementElseClause(ctx.caseStatementElseClause());
            x.setElseClause(elseClause);
        }

        if (ctx.nameIdentifier() != null) {
            SQLName endLabel = visitNameIdentifier(ctx.nameIdentifier());
            x.setEndLabel(endLabel);
        }

        return x;
    }

    @Override
    public SQLCaseStatement.SQLCaseStatementWhenItem visitCaseStatementWhenItem(CaseStatementWhenItemContext ctx) {
        SQLCaseStatement.SQLCaseStatementWhenItem x = new SQLCaseStatement.SQLCaseStatementWhenItem();

        SQLExpr expr = visitExpr(ctx.expr());
        x.setExpr(expr);

        SQLBody.SQLBodyItem bodyItem = visitBodyItem(ctx.bodyItem());
        x.setStatement(bodyItem);

        return x;
    }

    @Override
    public SQLCaseStatement.SQLCaseStatementElseClause visitCaseStatementElseClause(CaseStatementElseClauseContext ctx) {
        SQLCaseStatement.SQLCaseStatementElseClause x = new SQLCaseStatement.SQLCaseStatementElseClause();

        for (BodyItemContext bodyItemContext : ctx.bodyItem()) {
            SQLBody.SQLBodyItem stmt = visitBodyItem(bodyItemContext);
            x.addStatement(stmt);
        }

        return x;
    }

    // 13.9 CLOSE Statement
    @Override
    public SQLCloseStatement visitCloseStatement(CloseStatementContext ctx) {
        SQLCloseStatement x = new SQLCloseStatement(DBType.Oracle);
        SQLExpr name = visitExpr(ctx.expr());
        x.setName(name);

        return x;
    }

    // 13.10 Collection Method Invocation
    @Override
    public SQLCollectionMethodInvocation visitCollectionMethodCall(CollectionMethodCallContext ctx) {
        SQLCollectionMethodInvocation x = new SQLCollectionMethodInvocation();

        SQLName collection = visitNameIdentifier(ctx.nameIdentifier());
        x.setCollection(collection);

        SQLCollectionMethodInvocation.SQLCollectionMethodName methodName = of(ctx.collectionMethod());
        x.setName(methodName);

        for (ExprContext exprContext : ctx.expr()) {
            SQLExpr argument = visitExpr(exprContext);
            x.addArgument(argument);
        }

        return x;
    }

    public SQLCollectionMethodInvocation.SQLCollectionMethodName of(CollectionMethodContext ctx) {
        String name = ctx.getText();
        return SQLCollectionMethodInvocation.SQLCollectionMethodName.of(name);
    }


    // 13.11 Collection Variable Declaration
    @Override
    public OracleSQLCollectionTypeDefinition visitCollectionTypeDefinition(CollectionTypeDefinitionContext ctx) {

        OracleSQLCollectionTypeDefinition x = new OracleSQLCollectionTypeDefinition();
        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        SQLDataType dataType = visitDataType(ctx.dataType());

        x.setName(name);
        x.setDataType(dataType);
        x.setAfterSemi(true);

        return x;
    }


    // 13.13 COMPILE Clause
    @Override
    public SQLCompileClause visitCompileClause(CompileClauseContext ctx) {
        SQLCompileClause x = new SQLCompileClause();

        if (ctx.DEBUG() != null) {
            x.setDebug(true);
        }

        SQLCompileClause.SQLCompiler compiler = null;
        if (ctx.PACKAGE() != null) {
            compiler = SQLCompileClause.SQLCompiler.PACKAGE;

        } else if (ctx.BODY() != null) {
            compiler = SQLCompileClause.SQLCompiler.BODY;

        } else if (ctx.SPECIFICATION() != null) {
            compiler = SQLCompileClause.SQLCompiler.SPECIFICATION;
        }
        x.setCompiler(compiler);

        for (AssignmentExprContext assignmentExprContext : ctx.assignmentExpr()) {
            SQLAssignmentExpr parameter = visitAssignmentExpr(assignmentExprContext);
            x.addParameter(parameter);
        }

        if (ctx.REUSE() != null
                && ctx.SETTINGS() != null) {
            x.setReuseSettings(true);
        }

        return x;
    }

    // 13.14 Constant Declaration
    @Override
    public OracleSQLConstantDeclaration visitConstantDeclaration(ConstantDeclarationContext ctx) {
        OracleSQLConstantDeclaration x = new OracleSQLConstantDeclaration();

        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);

        SQLDataType dataType = visitDataType(ctx.dataType());
        x.setDataType(dataType);

        if (ctx.notNull() != null) {
            x.setNotNull(true);
        }

        SQLDefaultClause defaultClause = visitDefaultClause(ctx.defaultClause());
        x.setDefaultClause(defaultClause);

        if (ctx.SEMI() != null) {
            x.setAfterSemi(true);
        }

        return x;
    }

    // 13.15 CONTINUE Statement
    @Override
    public SQLContinueStatement visitContinueStatement(ContinueStatementContext ctx) {
        SQLContinueStatement x = new SQLContinueStatement(DBType.Oracle);

        if (ctx.nameIdentifier() != null) {
            SQLName name = visitNameIdentifier(ctx.nameIdentifier());
            x.setName(name);
        }

        if (ctx.expr() != null) {
            SQLExpr whenExpr = visitExpr(ctx.expr());
            x.setCondition(whenExpr);
        }

        return x;
    }

    // 13.16 COVERAGE Pragma
    @Override
    public OracleSQLCoveragePragma visitCoveragePragma(CoveragePragmaContext ctx) {
        OracleSQLCoveragePragma x = new OracleSQLCoveragePragma();
        SQLExpr expr = visitExpr(ctx.expr());
        x.addArgument(expr);
        return x;
    }


    // 13.18 Cursor Variable Declaration
    @Override
    public OracleSQLRefCursorTypeDefinition visitRefCursorTypeDefinition(RefCursorTypeDefinitionContext ctx) {
        OracleSQLRefCursorTypeDefinition x = new OracleSQLRefCursorTypeDefinition();

        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);

        SQLDataType dataType = visitDataType(ctx.dataType());
        x.setReturnDataType(dataType);

        x.setAfterSemi(true);
        return x;
    }


    // 13.20 DEFAULT COLLATION Clause
    @Override
    public SQLCollationExpr visitCollationExpr(CollationExprContext ctx) {
        if (ctx == null) {
            return null;
        }
        boolean default_ = ctx.DEFAULT() != null;
        SQLName name = visitNameIdentifier(ctx.nameIdentifier());

        SQLCollationExpr x = new SQLCollationExpr(name);
        x.setDefault_(default_);

        return x;
    }

    @Override
    public SQLCollateOptionExpr visitCollateExpr(CollateExprContext ctx) {
        if (ctx == null) {
            return null;
        }
        boolean default_ = ctx.DEFAULT() != null;
        SQLName name = visitNameIdentifier(ctx.nameIdentifier());

        SQLCollateOptionExpr x = new SQLCollateOptionExpr(name);
        x.setDefault_(default_);

        return x;
    }

    @Override
    public SQLDirectoryExpr visitDirectoryExpr(DirectoryExprContext ctx) {
        SQLDirectoryExpr x = new SQLDirectoryExpr();

        boolean default_ = ctx.DEFAULT() != null;
        x.setDefault_(default_);

        SQLExpr value = visitExpr(ctx.expr());
        x.setValue(value);

        return x;
    }

    // 13.22 DEPRECATE Pragma
    @Override
    public OracleSQLDeprecatePragma visitDeprecatePragma(DeprecatePragmaContext ctx) {
        OracleSQLDeprecatePragma x = new OracleSQLDeprecatePragma();

        for (ExprContext exprContext : ctx.expr()) {
            SQLExpr argument = visitExpr(exprContext);
            x.addArgument(argument);
        }

        x.setAfterSemi(true);
        return x;
    }

    // 13.23 DETERMINISTIC Clause
    @Override
    public SQLDeterministicClause visitDeterministicClause(DeterministicClauseContext ctx) {
        SQLDeterministicClause x = new SQLDeterministicClause();
        return x;
    }

    // 13.24 Element Specification
    @Override
    public OracleSQLElementSpec visitElementSpec(ElementSpecContext ctx) {
        OracleSQLElementSpec x = new OracleSQLElementSpec();
        for (InheritanceClausesContext inheritanceClausesContext : ctx.inheritanceClauses()) {
            OracleSQLElementSpec.OracleSQLInheritanceType inheritance = of(inheritanceClausesContext);
            x.addInheritance(inheritance);
        }

        for (ElementSpecItemContext elementSpecItemContext : ctx.elementSpecItem()) {
            SQLExpr item = (SQLExpr) visitChildren(elementSpecItemContext);
            x.addItem(item);
        }

        OracleSQLRestrictReferencesPragma restrictReferencesPragma = visitRestrictReferencesPragma(ctx.restrictReferencesPragma());
        x.setRestrictReferencesPragma(restrictReferencesPragma);

        return x;
    }

    public OracleSQLElementSpec.OracleSQLInheritanceType of(InheritanceClausesContext ctx) {
        if (ctx == null) {
            return null;
        }
        OracleSQLElementSpec.OracleSQLInheritanceType x = null;

        if (ctx.OVERRIDING() != null) {
            x = OracleSQLElementSpec.OracleSQLInheritanceType.OVERRIDING;
            if (ctx.NOT() != null) {
                x = OracleSQLElementSpec.OracleSQLInheritanceType.NOT_OVERRIDING;
            }

        } else if (ctx.FINAL() != null) {
            x = OracleSQLElementSpec.OracleSQLInheritanceType.FINAL;
            if (ctx.NOT() != null) {
                x = OracleSQLElementSpec.OracleSQLInheritanceType.NOT_FINAL;
            }

        } else if (ctx.INSTANTIABLE() != null) {
            x = OracleSQLElementSpec.OracleSQLInheritanceType.INSTANTIABLE;
            if (ctx.NOT() != null) {
                x = OracleSQLElementSpec.OracleSQLInheritanceType.NOT_INSTANTIABLE;
            }
        }
        return x;
    }

    @Override
    public OracleSQSubprogramDeclaration visitSubProgramDeclaration(SubProgramDeclarationContext ctx) {
        OracleSQSubprogramDeclaration x = new OracleSQSubprogramDeclaration();

        OracleSQSubprogramDeclaration.OracleSQLSubprogramType type = null;
        if (ctx.MEMBER() != null) {
            type = OracleSQSubprogramDeclaration.OracleSQLSubprogramType.MEMBER;
        } else if (ctx.STATIC() != null) {
            type = OracleSQSubprogramDeclaration.OracleSQLSubprogramType.STATIC;
        }
        x.setType(type);

        SQLExpr expr = (SQLExpr) visitChildren(ctx.subProgramExpr());
        x.setExpr(expr);

        return x;
    }


    @Override
    public OracleSQLConstructorDeclaration visitConstructorDeclaration(ConstructorDeclarationContext ctx) {
        OracleSQLConstructorDeclaration x = new OracleSQLConstructorDeclaration();

        if (ctx.FINAL() != null) {
            x.setFinal_(true);
        }

        if (ctx.INSTANTIABLE() != null) {
            x.setInstantiable(true);
        }

        SQLDataType constructorFunctionDataType = visitDataType(ctx.constructorFunction);
        x.setDataType(constructorFunctionDataType);

        if (ctx.selfInOut != null) {
            SQLDataType selfInOutDataType = visitDataType(ctx.selfInOut);
            x.setSelfInOutDataType(selfInOutDataType);
        }

        for (ParameterDeclarationContext parameterDeclarationContext : ctx.parameterDeclaration()) {
            SQLParameterDeclaration parameter = visitParameterDeclaration(parameterDeclarationContext);
            x.addParameter(parameter);
        }

        return x;
    }

    @Override
    public OracleSQLConstructorDefinition visitConstructorDefinition(ConstructorDefinitionContext ctx) {
        OracleSQLConstructorDefinition x = new OracleSQLConstructorDefinition();

        if (ctx.FINAL() != null) {
            x.setFinal_(true);
        }

        if (ctx.INSTANTIABLE() != null) {
            x.setInstantiable(true);
        }

        SQLDataType constructorFunctionDataType = visitDataType(ctx.constructorFunction);
        x.setDataType(constructorFunctionDataType);

        if (ctx.selfInOut != null) {
            SQLDataType selfInOutDataType = visitDataType(ctx.selfInOut);
            x.setSelfInOutDataType(selfInOutDataType);
        }

        for (ParameterDeclarationContext parameterDeclarationContext : ctx.parameterDeclaration()) {
            SQLParameterDeclaration parameter = visitParameterDeclaration(parameterDeclarationContext);
            x.addParameter(parameter);
        }

        SQLASType as = of(ctx.asType());
        x.setAs(as);

        for (DeclareSectionContext declareSectionContext : ctx.declareSection()) {
            SQLExpr declareSection = (SQLExpr) visitChildren(declareSectionContext);
            x.addDeclareSection(declareSection);
        }

        SQLExpr asExpr = null;
        if (ctx.body() != null) {
            asExpr = visitBody(ctx.body());
        } else if (ctx.callSpec() != null) {

            asExpr = (SQLExpr) visit(ctx.callSpec());
        }
        x.setAsExpr(asExpr);

        if (ctx.SEMI() != null) {
            x.setAfterSemi(true);
        }
        return x;
    }

    @Override
    public OracleSQLMapOrderFunctionDeclaration visitMapOrderFunctionDeclaration(MapOrderFunctionDeclarationContext ctx) {
        OracleSQLMapOrderFunctionDeclaration x = new OracleSQLMapOrderFunctionDeclaration();

        OracleSQLMapOrderFunctionDeclaration.SQLType type = null;
        if (ctx.MAP() != null) {
            type = OracleSQLMapOrderFunctionDeclaration.SQLType.MAP;

        } else if (ctx.ORDER() != null) {
            type = OracleSQLMapOrderFunctionDeclaration.SQLType.ORDER;
        }
        x.setType(type);

        SQLExpr expr = (SQLExpr) visitChildren(ctx.mapOrderFunctionDeclarationItem());
        x.setExpr(expr);
        return x;
    }

    @Override
    public OracleSQLElementSpec.SQLExternalNameClause visitExternalNameClause(ExternalNameClauseContext ctx) {
        OracleSQLElementSpec.SQLExternalNameClause x = new OracleSQLElementSpec.SQLExternalNameClause();
        SQLExpr name = visitExpr(ctx.expr());
        x.setName(name);
        return x;
    }

    @Override
    public OracleSQLElementSpec.SQLExternalVariableNameClause visitExternalVariableNameClause(ExternalVariableNameClauseContext ctx) {
        OracleSQLElementSpec.SQLExternalVariableNameClause x = new OracleSQLElementSpec.SQLExternalVariableNameClause();
        SQLExpr name = visitExpr(ctx.expr());
        x.setName(name);
        return x;
    }

    // 13.27 Exception Handler
    @Override
    public OracleSQLExceptionHandler visitExceptionHandler(ExceptionHandlerContext ctx) {
        OracleSQLExceptionHandler x = new OracleSQLExceptionHandler();

        for (NameIdentifierContext nameIdentifierContext : ctx.nameIdentifier()) {
            SQLName exception = visitNameIdentifier(nameIdentifierContext);
            x.addException(exception);
        }

        for (BodyItemContext bodyItemContext : ctx.bodyItem()) {
            SQLBody.SQLBodyItem bodyItem = visitBodyItem(bodyItemContext);
            x.addBodyItem(bodyItem);
        }
        return x;
    }

    // 13.28 EXECUTE IMMEDIATE Statement
    @Override
    public OracleSQLExecuteImmediateStatement visitExecuteImmediateStatement(ExecuteImmediateStatementContext ctx) {
        OracleSQLExecuteImmediateStatement x = new OracleSQLExecuteImmediateStatement();

        SQLExpr stmt = visitExpr(ctx.stmt);
        x.setDynamicSQLStmt(stmt);

        if (ctx.bulkCollect() != null) {
            x.setBulkCollect(true);
        }

        for (ExprContext intoItemContext : ctx.intoItems) {
            SQLExpr intoItem = visitExpr(intoItemContext);
            x.addInotItem(intoItem);
        }

        if (ctx.usingClause() != null) {
            SQLUsingClause usingClause = visitUsingClause(ctx.usingClause());
            x.setUsingClause(usingClause);
        }

        if (ctx.returningIntoClause() != null) {
            SQLReturningIntoClause returningIntoClause = visitReturningIntoClause(ctx.returningIntoClause());
            x.setReturningIntoClause(returningIntoClause);
        }
        return x;
    }

    @Override
    public SQLExitStatement visitExitStatement(ExitStatementContext ctx) {
        SQLExitStatement x = new SQLExitStatement(DBType.Oracle);

        if (ctx.nameIdentifier() != null) {
            SQLName name = visitNameIdentifier(ctx.nameIdentifier());
            x.setName(name);
        }

        if (ctx.expr() != null) {
            SQLExpr condition = visitExpr(ctx.expr());
            x.setCondition(condition);
        }
        return x;
    }

    // 13.30 Explicit Cursor Declaration and Definition
    @Override
    public OracleSQLCursorDeclaration visitCursorDeclaration(CursorDeclarationContext ctx) {
        OracleSQLCursorDeclaration x = new OracleSQLCursorDeclaration();

        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);

        if (ctx.parameterDeclaration() != null
                && ctx.parameterDeclaration().size() > 0) {
            for (ParameterDeclarationContext parameterDeclarationContext : ctx.parameterDeclaration()) {
                SQLParameterDeclaration parameter = visitParameterDeclaration(parameterDeclarationContext);
                x.addParameter(parameter);
            }
        }

        SQLDataType dataType = visitDataType(ctx.dataType());
        x.setReturnDataType(dataType);

        x.setAfterSemi(true);

        return x;
    }

    @Override
    public OracleSQLCursorDefinition visitCursorDefinition(CursorDefinitionContext ctx) {
        OracleSQLCursorDefinition x = new OracleSQLCursorDefinition();

        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);

        if (ctx.parameterDeclaration() != null
                && ctx.parameterDeclaration().size() > 0) {
            for (ParameterDeclarationContext parameterDeclarationContext : ctx.parameterDeclaration()) {
                SQLParameterDeclaration parameter = visitParameterDeclaration(parameterDeclarationContext);
                x.addParameter(parameter);
            }
        }

        if (ctx.dataType() != null) {
            SQLDataType dataType = visitDataType(ctx.dataType());
            x.setReturnDataType(dataType);
        }

        SQLSelectStatement selectStatement = visitSelectStatement(ctx.selectStatement());
        x.setSelectStatement(selectStatement);

        x.setAfterSemi(true);

        return x;
    }

    // 13.32 FETCH Statement
    @Override
    public SQLFetchStatement visitFetchStatement(FetchStatementContext ctx) {
        SQLFetchStatement x = new SQLFetchStatement(DBType.Oracle);

        SQLExpr name = visitExpr(ctx.name);
        x.setName(name);

        if (ctx.bulkCollect() != null) {
            x.setBulkCollect(true);
        }

        for (ExprContext exprContext : ctx.intoItems) {
            SQLExpr intoItem = visitExpr(exprContext);
            x.addIntoItem(intoItem);
        }

        return x;
    }

    // 13.33 FOR LOOP Statement
    @Override
    public SQLForLoopStatement visitForLoopStatement(ForLoopStatementContext ctx) {
        SQLForLoopStatement x = new SQLForLoopStatement(DBType.Oracle);

        SQLExpr index = visitExpr(ctx.index);
        x.setIndex(index);

        if (ctx.REVERSE() != null) {
            x.setReverse(true);
        }

        SQLExpr inExpr = (SQLExpr) visitChildren(ctx.forLoopStatementCondition());
        x.setInExpr(inExpr);

        for (BodyItemContext bodyItemContext : ctx.bodyItem()) {
            SQLBody.SQLBodyItem bodyItem = visitBodyItem(bodyItemContext);
            x.addStatement(bodyItem);
        }

        if (ctx.nameIdentifier() != null) {
            SQLName endLabel = visitNameIdentifier(ctx.nameIdentifier());
            x.setEndLabel(endLabel);
        }

        return x;
    }

    // 13.34 FORALL Statement
    @Override
    public SQLForAllStatement visitForallStatement(ForallStatementContext ctx) {
        SQLForAllStatement x = new SQLForAllStatement(DBType.Oracle);

        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setIndex(name);

        ISQLBoundsClause boundsClause = (ISQLBoundsClause) visit(ctx.iBoundsClause());
        x.setBoundsClause(boundsClause);

        if (ctx.before != null) {
            x.setBeforeSaveExceptions(true);
        }

        if (ctx.dmlStatement() != null) {
            SQLStatement stmt = (SQLStatement) visitChildren(ctx.dmlStatement());
            x.setStatement(stmt);
        }

        if (ctx.after != null) {
            x.setAfterSaveExceptions(true);
        }
        return x;
    }


    @Override
    public SQLBoundsClause visitBoundsClause(BoundsClauseContext ctx) {
        SQLExpr lower = visitExpr(ctx.lower);
        SQLExpr upper = visitExpr(ctx.upper);

        return new SQLBoundsClause(lower, upper);
    }

    @Override
    public SQLBoundsByIndicesOfClause visitBoundsClauseByIndicesOf(BoundsClauseByIndicesOfContext ctx) {
        SQLBoundsByIndicesOfClause x = new SQLBoundsByIndicesOfClause();

        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setCollection(name);

        if (ctx.lower != null) {
            SQLExpr lower = visitExpr(ctx.lower);
            x.setLower(lower);
        }

        if (ctx.upper != null) {
            SQLExpr upper = visitExpr(ctx.upper);
            x.setUpper(upper);
        }

        return x;
    }

    @Override
    public SQLBoundsByValuesOfClause visitBoundsClauseByValuesOf(BoundsClauseByValuesOfContext ctx) {
        SQLBoundsByValuesOfClause x = new SQLBoundsByValuesOfClause();
        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setCollection(name);
        return x;
    }

    // 13.35 Formal Parameter Declaration
    @Override
    public SQLParameterDeclaration visitParameterDeclaration(ParameterDeclarationContext ctx) {
        SQLParameterDeclaration x = new SQLParameterDeclaration();

        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);


        SQLParameterModel parameterModel = of(ctx.parameterModel());
        x.setParameterModel(parameterModel);

        if (ctx.NOCOPY() != null) {
            x.setNoCopy(true);
        }

        if (ctx.dataType() != null) {
            SQLDataType dataType = visitDataType(ctx.dataType());
            x.setDataType(dataType);
        }

        if (ctx.defaultClause() != null) {
            SQLDefaultClause defaultClause = visitDefaultClause(ctx.defaultClause());
            x.setDefaultClause(defaultClause);
        }

        return x;
    }

    public SQLParameterModel of(ParameterModelContext ctx) {
        if (ctx == null) {
            return null;
        }
        SQLParameterModel x = null;
        if (ctx.IN() != null
                && ctx.OUT() != null) {
            x = SQLParameterModel.IN_OUT;
        } else if (ctx.IN() != null) {
            x = SQLParameterModel.IN;
        } else if (ctx.OUT() != null) {
            x = SQLParameterModel.OUT;
        }
        return x;
    }

    // 13.36 Function Declaration and Definition
    @Override
    public OracleSQLFunctionDeclaration visitFunctionDeclaration(FunctionDeclarationContext ctx) {
        OracleSQLFunctionDeclaration x = new OracleSQLFunctionDeclaration();

        OracleSQLFunctionHeading functionHeading = visitFunctionHeading(ctx.functionHeading());
        x.setName(functionHeading.getName());
        x.addAllParameter(functionHeading.getParameters());
        x.setReturnDataType(functionHeading.getReturnDataType());

        if (ctx.iExternalNameClause() != null) {
            OracleSQLElementSpec.ISQLExternalNameClause externalClause = (OracleSQLElementSpec.ISQLExternalNameClause) visit(ctx.iExternalNameClause());
            x.setExternalClause(externalClause);
        }

        for (FunctionPropertyContext functionPropertyContext : ctx.functionProperty()) {
            SQLExpr property = (SQLExpr) visitChildren(functionPropertyContext);
            x.addProperty(property);
        }

        if (ctx.SEMI() != null) {
            x.setAfterSemi(true);
        }

        return x;
    }

    @Override
    public OracleSQLFunctionDefinition visitFunctionDefinition(FunctionDefinitionContext ctx) {
        OracleSQLFunctionDefinition x = new OracleSQLFunctionDefinition();

        OracleSQLFunctionHeading functionHeading = visitFunctionHeading(ctx.functionHeading());
        x.setName(functionHeading.getName());
        x.addAllParameter(functionHeading.getParameters());
        x.setReturnDataType(functionHeading.getReturnDataType());

        for (FunctionPropertyContext functionPropertyContext : ctx.functionProperty()) {
            SQLExpr property = (SQLExpr) visitChildren(functionPropertyContext);
            x.addProperty(property);
        }

        if (ctx.IS() != null) {
            x.setAs(SQLASType.IS);
        }

        if (ctx.declareSection() != null
                && ctx.declareSection().size() > 0) {
            for (DeclareSectionContext declareSectionContext : ctx.declareSection()) {
                SQLExpr declareSection = (SQLExpr) visitChildren(declareSectionContext);
                x.addDeclareSection(declareSection);
            }
        }

        SQLExpr asExpr = null;
        if (ctx.body() != null) {
            asExpr = visitBody(ctx.body());

        } else if (ctx.callSpec() != null) {
            asExpr = (SQLExpr) visit(ctx.callSpec());
        }
        x.setAsExpr(asExpr);

        if (ctx.SEMI() != null) {
            x.setAfterSemi(true);
        }

        return x;
    }


    @Override
    public OracleSQLFunctionHeading visitFunctionHeading(FunctionHeadingContext ctx) {
        OracleSQLFunctionHeading x = new OracleSQLFunctionHeading();

        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);

        if (ctx.parameterDeclaration() != null
                && ctx.parameterDeclaration().size() > 0) {
            for (ParameterDeclarationContext parameterDeclarationContext : ctx.parameterDeclaration()) {
                SQLParameterDeclaration parameter = visitParameterDeclaration(parameterDeclarationContext);
                x.addParameter(parameter);
            }
        }

        SQLDataType dataType = visitDataType(ctx.dataType());
        x.setReturnDataType(dataType);
        return x;
    }

    // 13.37 GOTO Statement
    @Override
    public SQLGotoStatement visitGotoStatement(GotoStatementContext ctx) {
        SQLGotoStatement x = new SQLGotoStatement(DBType.Oracle);
        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);
        return x;
    }

    // 13.38 IF Statement
    @Override
    public SQLIfStatement visitIfStatement(IfStatementContext ctx) {
        SQLIfStatement x = new SQLIfStatement(DBType.Oracle);

        SQLExpr condition = visitExpr(ctx.expr());
        x.setCondition(condition);

        for (BodyItemContext bodyItemContext : ctx.then) {
            SQLBody.SQLBodyItem stmt = visitBodyItem(bodyItemContext);
            x.addStatement(stmt);
        }

        for (IfStatementElsIfContext ifStatementElsIfContext : ctx.ifStatementElsIf()) {
            SQLIfStatement.SQLElseIf elseIf = visitIfStatementElsIf(ifStatementElsIfContext);
            x.addElseIf(elseIf);
        }


        for (BodyItemContext bodyItemContext : ctx.else_) {
            SQLBody.SQLBodyItem stmt = visitBodyItem(bodyItemContext);
            x.addElseStatement(stmt);
        }

        return x;
    }

    @Override
    public SQLIfStatement.SQLElseIf visitIfStatementElsIf(IfStatementElsIfContext ctx) {
        SQLIfStatement.SQLElseIf x = new SQLIfStatement.SQLElseIf();
        SQLExpr condition = visitExpr(ctx.expr());
        x.setCondition(condition);

        for (BodyItemContext bodyItemContext : ctx.bodyItem()) {
            SQLBody.SQLBodyItem stmt = visitBodyItem(bodyItemContext);
            x.addStatement(stmt);
        }
        return x;
    }

    // 13.40 INLINE Pragma
    @Override
    public OracleSQLInlinePragma visitInlinePragma(InlinePragmaContext ctx) {
        OracleSQLInlinePragma x = new OracleSQLInlinePragma();

        for (ExprContext exprContext : ctx.expr()) {
            SQLExpr argument = visitExpr(exprContext);
            x.addArgument(argument);
        }
        return x;
    }

    // 13.41 Invoker’s Rights and Definer’s Rights Clause
    @Override
    public OracleSQLInvokerRightsClause visitInvokerRightsClause(InvokerRightsClauseContext ctx) {
        OracleSQLInvokerRightsClause x = new OracleSQLInvokerRightsClause();

        OracleSQLInvokerRightsClause.SQLAuthIdType authidType = OracleSQLInvokerRightsClause.SQLAuthIdType.AUTHID_CURRENT_USER;
        if (ctx.DEFINER() != null) {
            authidType = OracleSQLInvokerRightsClause.SQLAuthIdType.AUTHID_DEFINER;
        }

        x.setAuthidType(authidType);
        return x;
    }

    // 13.44 NULL Statement
    @Override
    public SQLNullStatement visitNullStatement(NullStatementContext ctx) {
        return new SQLNullStatement(DBType.Oracle);
    }

    // 13.45 OPEN Statement
    @Override
    public SQLOpenStatement visitOpenStatement(OpenStatementContext ctx) {
        SQLOpenStatement x = new SQLOpenStatement(DBType.Oracle);

        SQLExpr expr = visitNameIdentifier(ctx.name);
        x.setName(expr);

        for (ExprContext exprContext : ctx.parameter) {
            SQLExpr parameter = visitExpr(exprContext);
            x.addParameter(parameter);
        }
        return x;
    }

    // 13.46 OPEN FOR Statement
    @Override
    public SQLOpenForStatement visitOpenForStatement(OpenForStatementContext ctx) {
        SQLOpenForStatement x = new SQLOpenForStatement(DBType.Oracle);

        SQLExpr open = visitExpr(ctx.open);
        x.setOpen(open);

        SQLExpr forExpr = visitExpr(ctx.forExpr);
        x.setFor_(forExpr);

        if (ctx.usingClause() != null) {
            visitUsingClause(ctx.usingClause());
        }

        return x;
    }

    // 13.47 PARALLEL_ENABLE Clause
    @Override
    public OracleParallelEnableClause visitParallelEnableClause(ParallelEnableClauseContext ctx) {
        return new OracleParallelEnableClause();
    }

    @Override
    public OracleParallelEnableByAnyClause visitParallelEnableByAnyClause(ParallelEnableByAnyClauseContext ctx) {
        OracleParallelEnableByAnyClause x = new OracleParallelEnableByAnyClause();
        SQLExpr expr = visitExpr(ctx.expr());
        x.setArgument(expr);
        return x;
    }

    @Override
    public OracleParallelEnableByHashClause visitParallelEnableByHashClause(ParallelEnableByHashClauseContext ctx) {
        OracleParallelEnableByHashClause x = new OracleParallelEnableByHashClause();
        return x;
    }

    @Override
    public OracleParallelEnableByRangeClause visitParallelEnableByRangeClause(ParallelEnableByRangeClauseContext ctx) {
        OracleParallelEnableByRangeClause x = new OracleParallelEnableByRangeClause();
        return x;
    }

    @Override
    public OracleParallelEnableByValueClause visitParallelEnableByValueClause(ParallelEnableByValueClauseContext ctx) {
        OracleParallelEnableByValueClause x = new OracleParallelEnableByValueClause();

        return x;
    }

    @Override
    public AbstractOracleSQLParallelEnableClause.AbstractOracleSQLStreamingClause visitStreamingClause(StreamingClauseContext ctx) {
        AbstractOracleSQLParallelEnableClause.AbstractOracleSQLStreamingClause x = null;
        if (ctx.ORDER() != null) {
            x = new AbstractOracleSQLParallelEnableClause.OracleSQLStreamingClauseByOrder();
        } else if (ctx.CLUSTER() != null) {
            x = new AbstractOracleSQLParallelEnableClause.OracleSQLStreamingClusterByCluster();
        }

        SQLExpr value = visitExpr(ctx.value);
        x.setExpr(value);

        for (ExprContext exprContext : ctx.argument) {
            SQLExpr column = visitExpr(exprContext);
            x.addColumn(column);
        }

        return x;
    }


    // 13.48 PIPE ROW Statement
    @Override
    public SQLPipeRowStatement visitPipeRowStatement(PipeRowStatementContext ctx) {
        SQLExpr expr = visitExpr(ctx.expr());
        return new SQLPipeRowStatement(DBType.Oracle, expr);
    }


    // 13.49 PIPELINED Clause
    @Override
    public OracleSQLPipelinedClause visitPipelinedClause(PipelinedClauseContext ctx) {
        return new OracleSQLPipelinedClause();
    }

    @Override
    public OracleSQLPipelinedByUsingClause visitPipelinedByUsingClause(PipelinedByUsingClauseContext ctx) {
        OracleSQLPipelinedByUsingClause x = new OracleSQLPipelinedByUsingClause();
        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setUsing(name);
        return x;
    }

    @Override
    public OracleSQLPipelinedByRowClause visitPipelinedByRowClause(PipelinedByRowClauseContext ctx) {
        OracleSQLPipelinedByRowClause x = new OracleSQLPipelinedByRowClause();
        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setUsing(name);
        return x;
    }

    @Override
    public OracleSQLPipelinedByTableClause visitPipelinedByTableClause(PipelinedByTableClauseContext ctx) {
        OracleSQLPipelinedByTableClause x = new OracleSQLPipelinedByTableClause();
        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setUsing(name);
        return x;
    }


    // 13.50 Procedure Declaration and Definition
    @Override
    public OracleSQLProcedureDeclaration visitProcedureDeclaration(ProcedureDeclarationContext ctx) {
        OracleSQLProcedureDeclaration x = new OracleSQLProcedureDeclaration();

        OracleSQLProcedureHeading procedureHeading = visitProcedureHeading(ctx.procedureHeading());
        x.setName(procedureHeading.getName());
        x.addAllParameter(procedureHeading.getParameters());

        for (ProcedurePropertyContext procedurePropertyContext : ctx.procedureProperty()) {
            SQLExpr property = (SQLExpr) visitChildren(procedurePropertyContext);
            x.addProperty(property);
        }

        if (ctx.SEMI() != null) {
            x.setAfterSemi(true);
        }
        return x;
    }

    @Override
    public OracleSQLProcedureDefinition visitProcedureDefinition(ProcedureDefinitionContext ctx) {
        OracleSQLProcedureDefinition x = new OracleSQLProcedureDefinition();

        OracleSQLProcedureHeading procedureHeading = visitProcedureHeading(ctx.procedureHeading());
        x.setName(procedureHeading.getName());
        x.addAllParameter(procedureHeading.getParameters());

        for (ProcedurePropertyContext procedurePropertyContext : ctx.procedureProperty()) {
            SQLExpr property = (SQLExpr) visitChildren(procedurePropertyContext);
            x.addProperty(property);
        }

        if (ctx.IS() != null) {
            x.setAs(SQLASType.IS);
        }

        if (ctx.declareSection() != null
                && ctx.declareSection().size() > 0) {
            for (DeclareSectionContext declareSectionContext : ctx.declareSection()) {
                SQLExpr declareSection = (SQLExpr) visitChildren(declareSectionContext);
                x.addDeclareSection(declareSection);
            }
        }

        SQLExpr asExpr = null;
        if (ctx.body() != null) {
            asExpr = visitBody(ctx.body());
        } else if (ctx.callSpec() != null) {
            asExpr = (SQLExpr) visit(ctx.callSpec());
        }
        x.setAsExpr(asExpr);

        if (ctx.SEMI() != null) {
            x.setAfterSemi(true);
        }

        return x;
    }

    @Override
    public OracleSQLProcedureHeading visitProcedureHeading(ProcedureHeadingContext ctx) {
        OracleSQLProcedureHeading x = new OracleSQLProcedureHeading();

        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);

        if (ctx.parameterDeclaration() != null
                && ctx.parameterDeclaration().size() > 0) {
            for (ParameterDeclarationContext parameterDeclarationContext : ctx.parameterDeclaration()) {
                SQLParameterDeclaration parameterDeclaration = visitParameterDeclaration(parameterDeclarationContext);
                x.addParameter(parameterDeclaration);
            }
        }

        return x;
    }


    @Override
    public SQLRaiseStatement visitRaiseStatement(RaiseStatementContext ctx) {
        SQLRaiseStatement x = new SQLRaiseStatement(DBType.Oracle);
        if (ctx.nameIdentifier() != null) {
            SQLName name = visitNameIdentifier(ctx.nameIdentifier());
            x.setException(name);
        }
        return x;
    }

    // 13.52 Record Variable Declaration
    @Override
    public OracleSQLRecordTypeDefinition visitRecordTypeDefinition(RecordTypeDefinitionContext ctx) {
        OracleSQLRecordTypeDefinition x = new OracleSQLRecordTypeDefinition();

        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);

        for (VariableDeclarationContext variableDeclarationContext : ctx.variableDeclaration()) {
            SQLVariableDeclaration argument = visitVariableDeclaration(variableDeclarationContext);
            x.addArgument(argument);
        }

        x.setAfterSemi(true);
        return x;
    }

    // 13.53 RESTRICT_REFERENCES Pragma
    @Override
    public OracleSQLRestrictReferencesPragma visitRestrictReferencesPragma(RestrictReferencesPragmaContext ctx) {
        if (ctx == null) {
            return null;
        }
        OracleSQLRestrictReferencesPragma x = new OracleSQLRestrictReferencesPragma();

        for (ExprContext exprContext : ctx.expr()) {
            SQLExpr argument = visitExpr(exprContext);
            x.addArgument(argument);
        }

        if (ctx.SEMI() != null) {
            x.setAfterSemi(true);
        }

        return x;
    }

    // 13.54 RETURN Statement
    @Override
    public SQLReturnStatement visitReturnStatement(ReturnStatementContext ctx) {

        SQLReturnStatement x = new SQLReturnStatement(DBType.Oracle);

        if (ctx.expr() != null) {
            SQLExpr expr = visitExpr(ctx.expr());
            x.setExpr(expr);
        }

        return x;
    }

    @Override
    public SQLReturningIntoClause visitReturningIntoClause(ReturningIntoClauseContext ctx) {
        SQLReturningIntoClause x = new SQLReturningIntoClause();

        SQLReturningClause.SQLReturningType returning = SQLReturningClause.SQLReturningType.RETURNING;
        if (ctx.RETURN() != null) {
            returning = SQLReturningClause.SQLReturningType.RETURN;
        }
        x.setReturning(returning);


        for (ExprContext exprContext : ctx.returningItems) {
            SQLExpr returningItem = visitExpr(exprContext);
            x.addReturningItem(returningItem);
        }

        if (ctx.bulkCollect() != null) {
            x.setBulkCollect(true);
        }

        for (ExprContext exprContext : ctx.intoItems) {
            SQLExpr intoItem = visitExpr(exprContext);
            x.addIntoItem(intoItem);
        }

        return x;
    }

    // 13.56 RESULT_CACHE Clause
    @Override
    public OracleSQLResultCacheClause visitResultCacheClause(ResultCacheClauseContext ctx) {
        OracleSQLResultCacheClause x = new OracleSQLResultCacheClause();

        for (ExprContext exprContext : ctx.expr()) {
            SQLExpr expr = visitExpr(exprContext);
            x.addDataSource(expr);
        }

        return x;
    }

    // 13.58 Scalar Variable Declaration
    @Override
    public SQLVariableDeclaration visitVariableDeclaration(VariableDeclarationContext ctx) {
        SQLVariableDeclaration x = new SQLVariableDeclaration();

        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);

        SQLDataType dataType = visitDataType(ctx.dataType());
        x.setDataType(dataType);

        if (ctx.notNull() != null) {
            x.setNotNull(true);
        }

        if (ctx.defaultClause() != null) {
            SQLDefaultClause defaultClause = visitDefaultClause(ctx.defaultClause());
            x.setDefaultClause(defaultClause);
        }

        x.setAfterSemi(true);

        return x;
    }

    // 13.60 SERIALLY_REUSABLE Pragma
    @Override
    public OracleSQLSeriallyReusablePragma visitSeriallyReusablePragma(SeriallyReusablePragmaContext ctx) {
        OracleSQLSeriallyReusablePragma x = new OracleSQLSeriallyReusablePragma();
        if (ctx.SEMI() != null) {
            x.setAfterSemi(true);
        }
        return x;
    }

    @Override
    public SQLSharingClause visitSharingClause(SharingClauseContext ctx) {
        if (ctx == null) {
            return null;
        }
        SQLSharingClause x = new SQLSharingClause();
        SQLExpr value = null;
        if (ctx.METADATA() != null) {
            value = SQLReserved.METADATA.ofExpr();
        } else if (ctx.NONE() != null) {
            value = SQLReserved.NONE.ofExpr();
        } else if (ctx.DATA() != null) {
            value = SQLReserved.DATA.ofExpr();
        }
        x.setValue(value);

        return x;
    }

    // 13.65 UDF Pragma
    @Override
    public OracleSQLUDFPragma visitUdfPragma(UdfPragmaContext ctx) {
        OracleSQLUDFPragma x = new OracleSQLUDFPragma();
        return x;
    }

    @Override
    public SQLWhileLoopStatement visitWhileLoopStatement(WhileLoopStatementContext ctx) {
        SQLWhileLoopStatement x = new SQLWhileLoopStatement(DBType.Oracle);
        SQLExpr condition = visitExpr(ctx.expr());
        x.setCondition(condition);

        for (BodyItemContext bodyItemContext : ctx.bodyItem()) {
            SQLBody.SQLBodyItem bodyItem = visitBodyItem(bodyItemContext);
            x.addStatement(bodyItem);
        }

        if (ctx.nameIdentifier() != null) {
            SQLName endLabel = visitNameIdentifier(ctx.nameIdentifier());
            x.setEndLabel(endLabel);
        }

        return x;
    }

    @Override
    public SQLErrorLoggingClause visitErrorLoggingClause(ErrorLoggingClauseContext ctx) {
        SQLErrorLoggingClause x = new SQLErrorLoggingClause();

        if (ctx.nameIdentifier() != null) {
            SQLName into = visitNameIdentifier(ctx.nameIdentifier());
            x.setInto(into);
        }

        if (ctx.simpleExpr != null) {
            SQLExpr simpleExpr = visitExpr(ctx.simpleExpr);
            x.setExpr(simpleExpr);
        }

        if (ctx.rejectLimit != null) {
            SQLExpr rejectLimit = visitExpr(ctx.rejectLimit);
            x.setRejectLimit(rejectLimit);
        }

        return x;
    }


    public SQLEditionAbleType of(EditionableTypeContext ctx) {
        if (ctx == null) {
            return null;
        }

        SQLEditionAbleType x = null;
        if (ctx.EDITIONABLE() != null) {
            x = SQLEditionAbleType.EDITIONABLE;
            if (ctx.EDITIONING() != null) {
                x = SQLEditionAbleType.EDITIONABLE_EDITIONING;
            }
        } else if (ctx.NONEDITIONABLE() != null) {
            x = SQLEditionAbleType.NONEDITIONABLE;

        } else if (ctx.EDITIONING() != null) {
            x = SQLEditionAbleType.EDITIONING;
        }
        return x;
    }

    public SQLASType of(AsTypeContext ctx) {
        if (ctx == null) {
            return null;
        }

        SQLASType x = null;
        if (ctx.IS() != null) {
            x = SQLASType.IS;

        } else if (ctx.AS() != null) {
            x = SQLASType.AS;

        }
        return x;
    }

    public SQLVisibleType of(VisibleTypeContext ctx) {
        if (ctx == null) {
            return null;
        }
        SQLVisibleType x = SQLVisibleType.VISIBLE;
        if (ctx.INVISIBLE() != null) {
            x = SQLVisibleType.INVISIBLE;
        }
        return x;
    }

    public SQLEnableType of(EnableTypeContext ctx) {
        if (ctx == null) {
            return null;
        }
        SQLEnableType x = SQLEnableType.ENABLE;
        if (ctx.DISABLE() != null) {
            x = SQLEnableType.DISABLE;
        }
        return x;
    }

    public SQLCacheType of(CacheTypeContext ctx) {
        if (ctx == null) {
            return null;
        }
        SQLCacheType x = SQLCacheType.CACHE;
        if (ctx.NOCACHE() != null) {
            x = SQLCacheType.NOCACHE;
        }
        return x;
    }


    public SQLBasicFileType of(BasicFileTypeContext ctx) {
        if (ctx == null) {
            return null;
        }
        SQLBasicFileType x = SQLBasicFileType.BASICFILE;
        if (ctx.SECUREFILE() != null) {
            x = SQLBasicFileType.SECUREFILE;
        }
        return x;
    }

    public SQLInvalidationType of(InvalidationTypeContext ctx) {
        if (ctx == null) {
            return null;
        }
        SQLInvalidationType x = SQLInvalidationType.IMMEDIATE_INVALIDATION;
        if (ctx.DEFERRED() != null) {
            x = SQLInvalidationType.DEFERRED_INVALIDATION;
        }
        return x;
    }

    public SQLValidateType of(ValidateTypeContext ctx) {
        if (ctx == null) {
            return null;
        }
        SQLValidateType x = SQLValidateType.VALIDATE;
        if (ctx.NOVALIDATE() != null) {
            x = SQLValidateType.NOVALIDATE;
        }
        return x;
    }


    public SQLForceType of(ForceTypeContext ctx) {
        if (ctx == null) {
            return null;
        }
        SQLForceType x = SQLForceType.FORCE;
        if (ctx.NOFORCE() != null) {
            x = SQLForceType.NOFORCE;
        }
        return x;
    }

    public SQLKeepIndexType of(KeepIndexTypeContext ctx) {
        if (ctx == null) {
            return null;
        }
        SQLKeepIndexType x = SQLKeepIndexType.KEEP_INDEX;
        if (ctx.DROP() != null) {
            x = SQLKeepIndexType.DROP_INDEX;
        }
        return x;
    }


    public SQLYesType of(YesTypeContext ctx) {
        if (ctx == null) {
            return null;
        }
        SQLYesType x = SQLYesType.YES;
        if (ctx.NO() != null) {
            x = SQLYesType.NO;
        }
        return x;
    }

    // --------------------------------------- PL/SQL Language Elements End ----------------------------------------------------------------

}
