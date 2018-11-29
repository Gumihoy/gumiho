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
package com.aliyun.gumiho.sql.dialect.mysql.visitor;


import static com.aliyun.gumiho.sql.dialect.mysql.parser.MySQLSQLStatementParser.SEMI;

import com.aliyun.gumiho.sql.basic.ast.SQLObject;
import com.aliyun.gumiho.sql.basic.ast.element.datatype.SQLDataType;
import com.aliyun.gumiho.sql.basic.ast.element.datatype.SQLDataTypeImpl;
import com.aliyun.gumiho.sql.basic.ast.element.datatype.bool.SQLBoolDataType;
import com.aliyun.gumiho.sql.basic.ast.element.datatype.bool.SQLBooleanDataType;
import com.aliyun.gumiho.sql.basic.ast.element.datatype.datetime.*;
import com.aliyun.gumiho.sql.basic.ast.element.datatype.json.SQLJsonDataType;
import com.aliyun.gumiho.sql.basic.ast.element.datatype.numeric.*;
import com.aliyun.gumiho.sql.basic.ast.element.datatype.spatial.*;
import com.aliyun.gumiho.sql.basic.ast.element.datatype.string.*;
import com.aliyun.gumiho.sql.basic.ast.element.expr.*;
import com.aliyun.gumiho.sql.basic.ast.element.expr.clause.*;
import com.aliyun.gumiho.sql.basic.ast.element.expr.condition.*;
import com.aliyun.gumiho.sql.basic.ast.element.expr.index.SQLIndexColumn;
import com.aliyun.gumiho.sql.basic.ast.element.expr.operator.SQLBinaryOperatorExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.operator.SQLUnaryOperatorExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.*;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.group.SQLGroupByClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.group.SQLHavingClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.limit.ISQLLimitClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.limit.SQLLimitOffsetClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.order.SQLOrderByClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.order.SQLOrderByItem;
import com.aliyun.gumiho.sql.basic.ast.element.expr.server.ISQLServerOption;
import com.aliyun.gumiho.sql.basic.ast.element.expr.server.SQLServerHostOption;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.SQLCommentOptionExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.constraint.SQLAlterTableAddTableConstraintAction;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.AbstractSQLReferencesConstraint;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.SQLColumnDefinition;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.SQLLikeClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.SQLTableElement;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.constraint.SQLConstraint;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.constraint.column.*;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.constraint.table.*;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.partition.*;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.partition.sub.ISQLSubPartitionBy;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.partition.sub.SQLSubPartitionByHash;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.partition.sub.SQLSubPartitionByKey;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.partition.sub.SQLSubPartitionDefinition;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.partition.values.ISQLPartitionValues;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.partition.values.SQLPartitionValuesIn;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.partition.values.SQLPartitionValuesLessThan;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.partition.values.SQLPartitionValuesLessThanMaxValue;
import com.aliyun.gumiho.sql.basic.ast.element.expr.trigger.SQLTriggerDMLEvent;
import com.aliyun.gumiho.sql.basic.ast.element.expr.trigger.SQLTriggerEvent;
import com.aliyun.gumiho.sql.basic.ast.element.expr.trigger.SQLTriggerOrderingClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.update.ISQLUpdateSetClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.update.SQLUpdateSetClause;
import com.aliyun.gumiho.sql.basic.ast.element.function.SQLMethodInvocation;
import com.aliyun.gumiho.sql.basic.ast.element.hint.*;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.*;
import com.aliyun.gumiho.sql.basic.ast.element.literal.*;
import com.aliyun.gumiho.sql.basic.ast.element.literal.datetime.SQLDateLiteral;
import com.aliyun.gumiho.sql.basic.ast.element.literal.datetime.SQLTimeLiteral;
import com.aliyun.gumiho.sql.basic.ast.element.literal.datetime.SQLTimestampLiteral;
import com.aliyun.gumiho.sql.basic.ast.element.literal.interval.SQLIntervalLiteral;
import com.aliyun.gumiho.sql.basic.ast.element.literal.numeric.SQLIntegerLiteral;
import com.aliyun.gumiho.sql.basic.ast.element.literal.numeric.SQLNumberLiteral;
import com.aliyun.gumiho.sql.basic.ast.element.literal.text.SQLCharLiteral;
import com.aliyun.gumiho.sql.basic.ast.element.literal.text.SQLNCharLiteral;
import com.aliyun.gumiho.sql.basic.ast.enums.*;
import com.aliyun.gumiho.sql.basic.ast.statement.dal.SQLSetPasswordStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.dal.SQLSetVariableStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.database.SQLCreateDatabaseStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.database.SQLDropDatabaseStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.event.SQLCreateEventStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.event.SQLDropEventStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.function.SQLCreateFunctionStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.index.SQLCreateIndexStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.index.SQLDropIndexStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.procedure.SQLCreateProcedureStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.schema.SQLCreateSchemaStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.schema.SQLDropSchemaStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.server.SQLCreateServerStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.server.SQLDropServerStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.table.*;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.trigger.SQLCreateTriggerStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.trigger.SQLDropTriggerStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.view.SQLCreateViewStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.view.SQLDropViewStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.dml.*;
import com.aliyun.gumiho.sql.basic.ast.statement.fcl.*;
import com.aliyun.gumiho.sql.dialect.mysql.ast.element.expr.select.MySQLSQLOJTableReference;
import com.aliyun.gumiho.sql.dialect.mysql.ast.element.expr.select.MySQLSQLSelectQuery;
import com.aliyun.gumiho.sql.dialect.mysql.parser.MySQLSQLStatementParser;
import com.aliyun.gumiho.sql.dialect.mysql.parser.MySQLSQLStatementParserBaseVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

/**
 * @author kongtong.ouyang onCondition 2018/3/6.
 */
public class MySQLSQLASTBuilderVisitor extends MySQLSQLStatementParserBaseVisitor<SQLObject> {


    private List<SQLObject> sqlObjects;

    public MySQLSQLASTBuilderVisitor() {
    }

    public MySQLSQLASTBuilderVisitor(List<SQLObject> sqlObjects) {
        this.sqlObjects = sqlObjects;
    }

    @Override
    public SQLObject visitParse(MySQLSQLStatementParser.ParseContext ctx) {
        int childCount = ctx.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ParseTree parseTree = ctx.getChild(i);

            if (parseTree instanceof TerminalNode
                    && (
                    ((TerminalNode) parseTree).getSymbol().getType() == Token.EOF
                            || ((TerminalNode) parseTree).getSymbol().getType() == SEMI)
                    ) {
                continue;
            }

            SQLObject sqlObject = visit(parseTree);
            if (i < childCount - 2) {
                ParseTree nextParseTree = ctx.getChild(i + 1);

                if (nextParseTree instanceof TerminalNode
                        && ((TerminalNode) nextParseTree).getSymbol().getType() == SEMI
                        ) {
                    sqlObject.setAfterSemi(true);
                }
            }

            sqlObjects.add(sqlObject);
        }

        return null;
    }


    @Override
    public SQLCreateDatabaseStatement visitCreateDatabaseStatement(MySQLSQLStatementParser.CreateDatabaseStatementContext ctx) {
        SQLCreateDatabaseStatement x = new SQLCreateDatabaseStatement(DBType.MySQL);

        if (ctx.ifNotExists() != null) {
            x.setIfNotExists(true);
        }

        for (MySQLSQLStatementParser.CreateDatabaseOptionContext createDatabaseOptionContext : ctx.createDatabaseOption()) {
            SQLExpr item = (SQLExpr) visitChildren(createDatabaseOptionContext);
            x.addItem(item);
        }
        return x;
    }

    @Override
    public SQLCreateSchemaStatement visitCreateSchemaStatement(MySQLSQLStatementParser.CreateSchemaStatementContext ctx) {
        SQLCreateSchemaStatement x = new SQLCreateSchemaStatement(DBType.MySQL);

        if (ctx.ifNotExists() != null) {
            x.setIfNotExists(true);
        }

        for (MySQLSQLStatementParser.CreateDatabaseOptionContext createDatabaseOptionContext : ctx.createDatabaseOption()) {
            SQLExpr action = (SQLExpr) visitChildren(createDatabaseOptionContext);
            x.addAction(action);
        }
        return x;
    }

    @Override
    public SQLCreateEventStatement visitCreateEventStatement(MySQLSQLStatementParser.CreateEventStatementContext ctx) {
        SQLCreateEventStatement x = new SQLCreateEventStatement(DBType.MySQL);

        return x;
    }


    // ----- crate index start ---------------
    @Override
    public SQLCreateIndexStatement visitCreateIndexStatement(MySQLSQLStatementParser.CreateIndexStatementContext ctx) {
        SQLCreateIndexStatement x = new SQLCreateIndexStatement(DBType.MySQL);

        if (ctx.intimeAction() != null) {
            SQLInTimeAction inTimeAction = of(ctx.intimeAction());
            x.setInTimeAction(inTimeAction);
        }

        if (ctx.indexCategory() != null) {
            SQLIndexCategory indexCategory = of(ctx.indexCategory());
            x.setCategory(indexCategory);
        }

        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);

        if (ctx.indexType() != null) {
            SQLIndexType indexType = of(ctx.indexType());
            x.setIndexType(indexType);
        }

        SQLObjectNameTableReference tableReference = (SQLObjectNameTableReference) visit(ctx.iTableReference());
        x.setTableReference(tableReference);

        for (MySQLSQLStatementParser.CreateIndexStatementColumnContext createIndexStatementColumnContext : ctx.createIndexStatementColumn()) {
            SQLIndexColumn column = visitCreateIndexStatementColumn(createIndexStatementColumnContext);
            x.addColumn(column);
        }

        for (MySQLSQLStatementParser.CreateIndexStatementOptionContext createIndexStatementOptionContext : ctx.createIndexStatementOption()) {
            SQLExpr option = (SQLExpr) visitChildren(createIndexStatementOptionContext);
            x.addProperty(option);
        }
        return x;
    }

    @Override
    public SQLIndexColumn visitCreateIndexStatementColumn(MySQLSQLStatementParser.CreateIndexStatementColumnContext ctx) {
        SQLIndexColumn x = new SQLIndexColumn();

        SQLExpr name = visitExpr(ctx.column);
        x.setName(name);

        if (ctx.len != null) {
            SQLExpr len = visitExpr(ctx.len);
            x.setLength(len);
        }

        if (ctx.orderingSpecification() != null) {
            SQLOrderingSpecification orderingSpecification = of(ctx.orderingSpecification());
            x.setOrderingSpecification(orderingSpecification);
        }

        return x;
    }

    @Override
    public SQLAlgorithmOptionExpr visitAlgorithmOptionExpr(MySQLSQLStatementParser.AlgorithmOptionExprContext ctx) {
        if (ctx == null) {
            return null;
        }

        SQLExpr value;

        int tokenValue = ctx.algType.getType();
        switch (tokenValue) {
            case MySQLSQLStatementParser.INPLACE:
                value = SQLReserved.INPLACE.ofExpr();
                break;
            case MySQLSQLStatementParser.COPY:
                value = SQLReserved.COPY.ofExpr();
                break;
            default:
                value = SQLReserved.DEFAULT.ofExpr();
                break;
        }
        return new SQLAlgorithmOptionExpr(value);
    }

    @Override
    public SQLLockOptionExpr visitLockOptionExpr(MySQLSQLStatementParser.LockOptionExprContext ctx) {
        SQLLockOptionExpr x = new SQLLockOptionExpr();
        SQLExpr value;

        int tokenValue = ctx.lockType.getType();
        switch (tokenValue) {
            case MySQLSQLStatementParser.NONE:
                value = SQLReserved.NONE.ofExpr();
                break;
            case MySQLSQLStatementParser.SHARED:
                value = SQLReserved.SHARED.ofExpr();
                break;
            case MySQLSQLStatementParser.EXCLUSIVE:
                value = SQLReserved.EXCLUSIVE.ofExpr();
                break;
            default:
                value = SQLReserved.DEFAULT.ofExpr();
                break;
        }
        x.setValue(value);

        return x;
    }
    // ----- crate index end ---------------


    @Override
    public SQLObject visitCreateLogfileGroupStatement(MySQLSQLStatementParser.CreateLogfileGroupStatementContext ctx) {
        return super.visitCreateLogfileGroupStatement(ctx);
    }

    @Override
    public SQLCreateProcedureStatement visitCreateProcedureStatement(MySQLSQLStatementParser.CreateProcedureStatementContext ctx) {
        SQLCreateProcedureStatement x = new SQLCreateProcedureStatement(DBType.MySQL);

        if (ctx.definerOptionExpr() != null) {
            SQLDefinerOptionExpr definerOptionExpr = visitDefinerOptionExpr(ctx.definerOptionExpr());
            x.setDefinerOptionExpr(definerOptionExpr);
        }

        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);

        for (MySQLSQLStatementParser.ParameterDeclarationContext parameterDeclarationContext : ctx.parameterDeclaration()) {
            SQLParameterDeclaration parameter = visitParameterDeclaration(parameterDeclarationContext);
            x.addParameter(parameter);
        }


        return x;
    }

    @Override
    public SQLCreateFunctionStatement visitCreateFunctionStatement(MySQLSQLStatementParser.CreateFunctionStatementContext ctx) {
        SQLCreateFunctionStatement x = new SQLCreateFunctionStatement(DBType.MySQL);

        if (ctx.definerOptionExpr() != null) {
            SQLDefinerOptionExpr definerOptionExpr = visitDefinerOptionExpr(ctx.definerOptionExpr());
            x.setDefinerOptionExpr(definerOptionExpr);
        }

        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);

        for (MySQLSQLStatementParser.ParameterDeclarationContext parameterDeclarationContext : ctx.parameterDeclaration()) {
            SQLParameterDeclaration parameter = visitParameterDeclaration(parameterDeclarationContext);
            x.addParameter(parameter);
        }
        return x;
    }


    // ----- server statement Start --------------------------
    @Override
    public SQLCreateServerStatement visitCreateServerStatement(MySQLSQLStatementParser.CreateServerStatementContext ctx) {
        SQLCreateServerStatement x = new SQLCreateServerStatement(DBType.MySQL);

        SQLName name = visitNameIdentifier(ctx.name);
        x.setName(name);

        SQLName wrapper = visitNameIdentifier(ctx.wrapper);
        x.setWrapper(wrapper);

        for (MySQLSQLStatementParser.ServerOptionContext serverOptionContext : ctx.serverOption()) {
            ISQLServerOption option = (ISQLServerOption) visitChildren(serverOptionContext);
            x.addOption(option);
        }
        return x;
    }

    @Override
    public SQLServerHostOption visitServerHostOption(MySQLSQLStatementParser.ServerHostOptionContext ctx) {
        SQLServerHostOption x = new SQLServerHostOption();
        return x;
    }

    @Override
    public SQLObject visitServerDatabaseOption(MySQLSQLStatementParser.ServerDatabaseOptionContext ctx) {
        return super.visitServerDatabaseOption(ctx);
    }

    @Override
    public SQLObject visitServerUserOption(MySQLSQLStatementParser.ServerUserOptionContext ctx) {
        return super.visitServerUserOption(ctx);
    }

    @Override
    public SQLObject visitServerPasswordOption(MySQLSQLStatementParser.ServerPasswordOptionContext ctx) {
        return super.visitServerPasswordOption(ctx);
    }

    @Override
    public SQLObject visitServerSocketOption(MySQLSQLStatementParser.ServerSocketOptionContext ctx) {
        return super.visitServerSocketOption(ctx);
    }

    @Override
    public SQLObject visitServerOwnerOption(MySQLSQLStatementParser.ServerOwnerOptionContext ctx) {
        return super.visitServerOwnerOption(ctx);
    }

    @Override
    public SQLObject visitServerPortOption(MySQLSQLStatementParser.ServerPortOptionContext ctx) {
        return super.visitServerPortOption(ctx);
    }
    // ----- server statement End --------------------------


    // ----- table statement Start --------------------------
    @Override
    public SQLCreateTableStatement visitCreateTableStatement(MySQLSQLStatementParser.CreateTableStatementContext ctx) {
        SQLCreateTableStatement x = new SQLCreateTableStatement(DBType.MySQL);

        if (ctx.TEMPORARY() != null) {
            x.setScope(SQLTableScope.TEMPORARY);
        }
        if (ctx.ifNotExists() != null) {
            x.setIfNotExists(true);
        }

        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);

        if (ctx.tableElementsParen != null) {
            x.setTableElementsParen(true);
        }
        for (MySQLSQLStatementParser.TableElementContext tableElementContext : ctx.tableElement()) {
            SQLTableElement tableElement = visitTableElement(tableElementContext);
            x.addTableElement(tableElement);
        }

        for (MySQLSQLStatementParser.TableOptionContext tableOptionContext : ctx.tableOption()) {
            SQLExpr property = (SQLExpr) visit(tableOptionContext);
            x.addProperty(property);
        }

        if (ctx.iPartitionBy() != null) {
            ISQLPartitionBy partitionBy = (ISQLPartitionBy) visit(ctx.iPartitionBy());
            x.setPartitionBy(partitionBy);
        }

        if (ctx.keyViolate() != null) {
            SQLKeyViolate keyViolate = of(ctx.keyViolate());
            x.setKeyViolate(keyViolate);
        }

        if (ctx.iSelectQuery() != null) {
            if (ctx.AS() != null) {
                x.setAs(true);
            }

            ISQLSelectQuery subQuery = visitISelectQuery(ctx.iSelectQuery());
            x.setSubQuery(subQuery);
        }



        return x;
    }

    @Override
    public SQLTableElement visitTableElement(MySQLSQLStatementParser.TableElementContext ctx) {
        return (SQLTableElement) super.visitChildren(ctx);
    }

    @Override
    public SQLColumnDefinition visitColumnDefinition(MySQLSQLStatementParser.ColumnDefinitionContext ctx) {
        SQLColumnDefinition x = new SQLColumnDefinition();

        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);

        if (ctx.dataType() != null) {
            SQLDataType dataType = visitDataType(ctx.dataType());
            x.setDataType(dataType);
        }

        for (MySQLSQLStatementParser.ColumnConstraintContext columnConstraintContext : ctx.columnConstraint()) {
            SQLExpr expr = (SQLExpr) visit(columnConstraintContext);
            if (expr instanceof SQLDefaultClause) {
                x.setDefaultExpr(expr);
            } else if (expr instanceof SQLCommentOptionExpr) {
                x.setCommentClause((SQLCommentOptionExpr) expr);
            } else if (expr instanceof ISQLColumnConstraint) {
                x.addColumnConstraint((ISQLColumnConstraint) expr);
            }
        }

        return x;
    }

    @Override
    public SQLLikeClause visitLikeClause(MySQLSQLStatementParser.LikeClauseContext ctx) {
        SQLLikeClause x = new SQLLikeClause();
        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);
        return x;
    }

    @Override
    public SQLNullColumnConstraint visitNullColumnConstraint(MySQLSQLStatementParser.NullColumnConstraintContext ctx) {
        return new SQLNullColumnConstraint();
    }

    @Override
    public SQLNotNullColumnConstraint visitNotNullColumnConstraint(MySQLSQLStatementParser.NotNullColumnConstraintContext ctx) {
        return new SQLNotNullColumnConstraint();
    }

    @Override
    public SQLAutoIncrementColumnConstraint visitAutoIncrementColumnConstraint(MySQLSQLStatementParser.AutoIncrementColumnConstraintContext ctx) {
        return new SQLAutoIncrementColumnConstraint();
    }

    @Override
    public SQLPrimaryKeyColumnConstraint visitPrimaryKeyColumnConstraint(MySQLSQLStatementParser.PrimaryKeyColumnConstraintContext ctx) {
        SQLPrimaryKeyColumnConstraint x = new SQLPrimaryKeyColumnConstraint();
        if (ctx.PRIMARY() == null) {
            x.setPrimary(false);
        }
        return x;
    }

    @Override
    public SQLUniqueColumnConstraint visitUniqueColumnConstraint(MySQLSQLStatementParser.UniqueColumnConstraintContext ctx) {
        SQLUniqueColumnConstraint x = new SQLUniqueColumnConstraint();
        if (ctx.KEY() != null) {
            x.setKey(true);
        }
        return x;
    }

    @Override
    public SQLCommentOptionExpr visitCommentClause(MySQLSQLStatementParser.CommentClauseContext ctx) {
        if (ctx == null) {
            return null;
        }
        SQLExpr expr = visitExpr(ctx.expr());
        return new SQLCommentOptionExpr(expr);
    }

    @Override
    public SQLFormatColumnConstraint visitFormatColumnConstraint(MySQLSQLStatementParser.FormatColumnConstraintContext ctx) {
        SQLFormatColumnConstraint x = new SQLFormatColumnConstraint();
        SQLFormatColumnConstraint.FormatType formatType = SQLFormatColumnConstraint.FormatType.DEFAULT;
        if (ctx.FIXED() != null) {
            formatType = SQLFormatColumnConstraint.FormatType.FIXED;
        } else if (ctx.DYNAMIC() != null) {
            formatType = SQLFormatColumnConstraint.FormatType.DYNAMIC;
        }
        x.setFormatType(formatType);
        return x;
    }

    @Override
    public SQLStorageColumnConstraint visitStorageColumnConstraint(MySQLSQLStatementParser.StorageColumnConstraintContext ctx) {
        SQLStorageColumnConstraint x = new SQLStorageColumnConstraint();
        SQLStorageColumnConstraint.StorageType storageType = SQLStorageColumnConstraint.StorageType.DEFAULT;
        if (ctx.DISK() != null) {
            storageType = SQLStorageColumnConstraint.StorageType.DISK;
        } else if (ctx.MEMORY() != null) {
            storageType = SQLStorageColumnConstraint.StorageType.MEMORY;
        }
        x.setStorageType(storageType);
        return x;
    }

    @Override
    public SQLReferencesColumnConstraint visitReferencesColumnConstraint(MySQLSQLStatementParser.ReferencesColumnConstraintContext ctx) {
        SQLReferencesColumnConstraint x = new SQLReferencesColumnConstraint();
        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setReferencedTable(name);

        for (MySQLSQLStatementParser.ConstraintColumnContext constraintColumnContext : ctx.constraintColumn()) {
            SQLConstraint.SQLColumn column = visitConstraintColumn(constraintColumnContext);
            x.addReferencedColumn(column);
        }

        if (ctx.matchType() != null) {
            SQLReferencesColumnConstraint.MatchType matchType = of(ctx.matchType());
            x.setMatchType(matchType);
        }

        for (MySQLSQLStatementParser.ReferenceTriggerActionContext referenceTriggerActionContext : ctx.referenceTriggerAction()) {
            AbstractSQLReferencesConstraint.SQLReferentialTriggerAction action = (AbstractSQLReferencesConstraint.SQLReferentialTriggerAction) visit(referenceTriggerActionContext);
            x.addAction(action);
        }

        return x;
    }

    @Override
    public SQLPrimaryKeyTableConstraint visitPrimaryKeyTableConstraint(MySQLSQLStatementParser.PrimaryKeyTableConstraintContext ctx) {
        SQLPrimaryKeyTableConstraint x = new SQLPrimaryKeyTableConstraint();

        if (ctx.CONSTRAINT() != null) {
            x.setConstraint(true);
            if (ctx.name != null) {
                SQLName name = visitNameIdentifier(ctx.name);
                x.setName(name);
            }
        }

        if (ctx.indexType() != null) {
            SQLIndexType indexType = of(ctx.indexType());
            x.setIndexType(indexType);
        }

        for (MySQLSQLStatementParser.ConstraintColumnContext constraintColumnContext : ctx.constraintColumn()) {
            SQLConstraint.SQLColumn column = visitConstraintColumn(constraintColumnContext);
            x.addColumn(column);
        }

        return x;
    }

    @Override
    public SQLIndexTableConstraint visitIndexTableConstraint(MySQLSQLStatementParser.IndexTableConstraintContext ctx) {
        SQLIndexTableConstraint x = new SQLIndexTableConstraint();

        if (ctx.nameIdentifier() != null) {
            SQLName indexName = visitNameIdentifier(ctx.nameIdentifier());
            x.setIndexName(indexName);
        }

        if (ctx.indexType() != null) {
            SQLIndexType indexType = of(ctx.indexType());
            x.setIndexType(indexType);
        }

        for (MySQLSQLStatementParser.ConstraintColumnContext constraintColumnContext : ctx.constraintColumn()) {
            SQLConstraint.SQLColumn column = visitConstraintColumn(constraintColumnContext);
            x.addColumn(column);
        }

        for (MySQLSQLStatementParser.IndexOptionContext indexOptionContext : ctx.indexOption()) {
            SQLExpr option = (SQLExpr) visit(indexOptionContext);
            x.addOption(option);
        }

        return x;
    }

    @Override
    public SQLKeyTableConstraint visitKeyTableConstraint(MySQLSQLStatementParser.KeyTableConstraintContext ctx) {
        SQLKeyTableConstraint x = new SQLKeyTableConstraint();

        if (ctx.nameIdentifier() != null) {
            SQLName indexName = visitNameIdentifier(ctx.nameIdentifier());
            x.setIndexName(indexName);
        }

        if (ctx.indexType() != null) {
            SQLIndexType indexType = of(ctx.indexType());
            x.setIndexType(indexType);
        }

        for (MySQLSQLStatementParser.ConstraintColumnContext constraintColumnContext : ctx.constraintColumn()) {
            SQLConstraint.SQLColumn column = visitConstraintColumn(constraintColumnContext);
            x.addColumn(column);
        }

        for (MySQLSQLStatementParser.IndexOptionContext indexOptionContext : ctx.indexOption()) {
            SQLExpr option = (SQLExpr) visit(indexOptionContext);
            x.addOption(option);
        }
        return x;
    }

    @Override
    public SQLUniqueTableConstraint visitUniqueTableConstraint(MySQLSQLStatementParser.UniqueTableConstraintContext ctx) {
        SQLUniqueTableConstraint x = new SQLUniqueTableConstraint();

        if (ctx.CONSTRAINT() != null) {
            x.setConstraint(true);
            if (ctx.name != null) {
                SQLName name = visitNameIdentifier(ctx.name);
                x.setName(name);
            }
        }
        if (ctx.indexFormat() != null) {
            SQLIndexFormat indexFormat = of(ctx.indexFormat());
            x.setIndexFormat(indexFormat);
        }

        if (ctx.index != null) {
            SQLName indexName = visitNameIdentifier(ctx.index);
            x.setIndexName(indexName);
        }

        if (ctx.indexType() != null) {
            SQLIndexType indexType = of(ctx.indexType());
            x.setIndexType(indexType);
        }

        for (MySQLSQLStatementParser.ConstraintColumnContext constraintColumnContext : ctx.constraintColumn()) {
            SQLConstraint.SQLColumn column = visitConstraintColumn(constraintColumnContext);
            x.addColumn(column);
        }

        for (MySQLSQLStatementParser.IndexOptionContext indexOptionContext : ctx.indexOption()) {
            SQLExpr option = (SQLExpr) visit(indexOptionContext);
            x.addOption(option);
        }

        return x;
    }

    @Override
    public SQLFullTextTableConstraint visitFullTextTableConstraint(MySQLSQLStatementParser.FullTextTableConstraintContext ctx) {
        SQLFullTextTableConstraint x = new SQLFullTextTableConstraint();
        if (ctx.indexFormat() != null) {
            SQLIndexFormat indexFormat = of(ctx.indexFormat());
            x.setIndexFormat(indexFormat);
        }
        if (ctx.nameIdentifier() != null) {
            SQLName indexName = visitNameIdentifier(ctx.nameIdentifier());
            x.setIndexName(indexName);
        }

        for (MySQLSQLStatementParser.ConstraintColumnContext constraintColumnContext : ctx.constraintColumn()) {
            SQLConstraint.SQLColumn column = visitConstraintColumn(constraintColumnContext);
            x.addColumn(column);
        }

        for (MySQLSQLStatementParser.IndexOptionContext indexOptionContext : ctx.indexOption()) {
            SQLExpr option = (SQLExpr) visit(indexOptionContext);
            x.addOption(option);
        }
        return x;
    }

    @Override
    public SQLSpatialTableConstraint visitSpatialTableConstraint(MySQLSQLStatementParser.SpatialTableConstraintContext ctx) {
        SQLSpatialTableConstraint x = new SQLSpatialTableConstraint();
        if (ctx.indexFormat() != null) {
            SQLIndexFormat indexFormat = of(ctx.indexFormat());
            x.setIndexFormat(indexFormat);
        }
        if (ctx.nameIdentifier() != null) {
            SQLName indexName = visitNameIdentifier(ctx.nameIdentifier());
            x.setIndexName(indexName);
        }

        for (MySQLSQLStatementParser.ConstraintColumnContext constraintColumnContext : ctx.constraintColumn()) {
            SQLConstraint.SQLColumn column = visitConstraintColumn(constraintColumnContext);
            x.addColumn(column);
        }

        for (MySQLSQLStatementParser.IndexOptionContext indexOptionContext : ctx.indexOption()) {
            SQLExpr option = (SQLExpr) visit(indexOptionContext);
            x.addOption(option);
        }
        return x;
    }

    @Override
    public SQLForeignKeyTableConstraint visitForeignKeyTableConstraint(MySQLSQLStatementParser.ForeignKeyTableConstraintContext ctx) {
        SQLForeignKeyTableConstraint x = new SQLForeignKeyTableConstraint();

        if (ctx.CONSTRAINT() != null) {
            x.setConstraint(true);
        }
        if (ctx.name != null) {
            SQLName name = visitNameIdentifier(ctx.name);
            x.setName(name);
        }

        for (MySQLSQLStatementParser.ConstraintColumnContext referencingColumnContext : ctx.referencingColumns) {
            SQLConstraint.SQLColumn referencingColumn = visitConstraintColumn(referencingColumnContext);
            x.addReferencingColumn(referencingColumn);
        }


        SQLName referencedTable = visitNameIdentifier(ctx.referencedTable);
        x.setReferencedTable(referencedTable);

        for (MySQLSQLStatementParser.ConstraintColumnContext referencedColumnContext : ctx.referencedColumns) {
            SQLConstraint.SQLColumn referencedColumn = visitConstraintColumn(referencedColumnContext);
            x.addReferencingColumn(referencedColumn);
        }

        if (ctx.matchType() != null) {
            SQLReferencesColumnConstraint.MatchType matchType = of(ctx.matchType());
            x.setMatchType(matchType);
        }

        for (MySQLSQLStatementParser.ReferenceTriggerActionContext referenceTriggerActionContext : ctx.referenceTriggerAction()) {
            AbstractSQLReferencesConstraint.SQLReferentialTriggerAction action = (AbstractSQLReferencesConstraint.SQLReferentialTriggerAction) visit(referenceTriggerActionContext);
            x.addAction(action);
        }

        return x;
    }

    @Override
    public SQLCheckTableConstraint visitCheckTableConstraint(MySQLSQLStatementParser.CheckTableConstraintContext ctx) {
        SQLCheckTableConstraint x = new SQLCheckTableConstraint();
        SQLExpr condition = visitExpr(ctx.expr());
        x.setCondition(condition);
        return x;
    }

    @Override
    public SQLConstraint.SQLColumn visitConstraintColumn(MySQLSQLStatementParser.ConstraintColumnContext ctx) {
        SQLExpr name = visitExpr(ctx.name);

        SQLConstraint.SQLColumn x = new SQLConstraint.SQLColumn(name);
        if (ctx.length != null) {
            SQLExpr length = visitExpr(ctx.length);
            x.setLength(length);
        }

        if (ctx.orderingSpecification() != null) {
            SQLOrderingSpecification orderingSpecification = of(ctx.orderingSpecification());
            x.setOrdering(orderingSpecification);
        }

        return x;
    }

    public SQLReferencesColumnConstraint.MatchType of(MySQLSQLStatementParser.MatchTypeContext ctx) {
        if (ctx == null) {
            return null;
        }
        String name = getText(ctx.children);
        return SQLReferencesColumnConstraint.MatchType.of(name);
    }

    @Override
    public SQLReferencesColumnConstraint.SQLOnDeleteAction visitOnDeleteAction(MySQLSQLStatementParser.OnDeleteActionContext ctx) {
        if (ctx == null) {
            return null;
        }
        SQLReferencesColumnConstraint.SQLOnDeleteAction x = new SQLReferencesColumnConstraint.SQLOnDeleteAction();
        SQLReferentialAction action = of(ctx.referenceControlType());
        x.setAction(action);
        return x;
    }

    @Override
    public SQLReferencesColumnConstraint.SQLOnUpdateAction visitOnUpdateAction(MySQLSQLStatementParser.OnUpdateActionContext ctx) {
        if (ctx == null) {
            return null;
        }
        SQLReferencesColumnConstraint.SQLOnUpdateAction x = new SQLReferencesColumnConstraint.SQLOnUpdateAction();
        SQLReferentialAction action = of(ctx.referenceControlType());
        x.setAction(action);
        return x;
    }

    public SQLReferentialAction of(MySQLSQLStatementParser.ReferenceControlTypeContext ctx) {
        if (ctx == null) {
            return null;
        }
        String name = getText(ctx.children);
        return SQLReferentialAction.of(name);
    }


    @Override
    public SQLPartitionByHash visitPartitionByHash(MySQLSQLStatementParser.PartitionByHashContext ctx) {
        SQLPartitionByHash x = new SQLPartitionByHash();

        if (ctx.LINEAR() != null) {
            x.setLinear(true);
        }

        for (MySQLSQLStatementParser.ExprContext exprContext : ctx.columns) {
            SQLExpr column = visitExpr(exprContext);
            x.addColumn(column);
        }

        if (ctx.partitionsNum != null) {
            SQLExpr partitionsNum = visitExpr(ctx.partitionsNum);
            x.setPartitionsNum(partitionsNum);
        }

        if (ctx.iSubPartitionBy() != null) {
            ISQLSubPartitionBy subPartitionBy = (ISQLSubPartitionBy) visit(ctx.iSubPartitionBy());
            x.setSubPartitionBy(subPartitionBy);
        }

        for (MySQLSQLStatementParser.PartitionDefinitionContext partitionDefinitionContext : ctx.partitionDefinition()) {
            SQLPartitionDefinition partition = visitPartitionDefinition(partitionDefinitionContext);
            x.addPartition(partition);
        }

        return x;
    }

    @Override
    public SQLPartitionByKey visitPartitionByKey(MySQLSQLStatementParser.PartitionByKeyContext ctx) {
        SQLPartitionByKey x = new SQLPartitionByKey();

        if (ctx.LINEAR() != null) {
            x.setLinear(true);
        }

        if (ctx.algorithm != null) {
            SQLExpr algorithm = visitExpr(ctx.algorithm);
            x.setAlgorithm(algorithm);
        }

        for (MySQLSQLStatementParser.ExprContext exprContext : ctx.columns) {
            SQLExpr column = visitExpr(exprContext);
            x.addColumn(column);
        }

        if (ctx.partitionsNum != null) {
            SQLExpr partitionsNum = visitExpr(ctx.partitionsNum);
            x.setPartitionsNum(partitionsNum);
        }

        if (ctx.iSubPartitionBy() != null) {
            ISQLSubPartitionBy subPartitionBy = (ISQLSubPartitionBy) visit(ctx.iSubPartitionBy());
            x.setSubPartitionBy(subPartitionBy);
        }

        for (MySQLSQLStatementParser.PartitionDefinitionContext partitionDefinitionContext : ctx.partitionDefinition()) {
            SQLPartitionDefinition partition = visitPartitionDefinition(partitionDefinitionContext);
            x.addPartition(partition);
        }

        return x;
    }

    @Override
    public SQLPartitionByRange visitPartitionByRange(MySQLSQLStatementParser.PartitionByRangeContext ctx) {
        SQLPartitionByRange x = new SQLPartitionByRange();

        for (MySQLSQLStatementParser.ExprContext exprContext : ctx.columns) {
            SQLExpr column = visitExpr(exprContext);
            x.addColumn(column);
        }

        if (ctx.partitionsNum != null) {
            SQLExpr partitionsNum = visitExpr(ctx.partitionsNum);
            x.setPartitionsNum(partitionsNum);
        }

        if (ctx.iSubPartitionBy() != null) {
            ISQLSubPartitionBy subPartitionBy = (ISQLSubPartitionBy) visit(ctx.iSubPartitionBy());
            x.setSubPartitionBy(subPartitionBy);
        }

        for (MySQLSQLStatementParser.PartitionDefinitionContext partitionDefinitionContext : ctx.partitionDefinition()) {
            SQLPartitionDefinition partition = visitPartitionDefinition(partitionDefinitionContext);
            x.addPartition(partition);
        }

        return x;
    }

    @Override
    public SQLPartitionByRangeColumns visitPartitionByRangeColumns(MySQLSQLStatementParser.PartitionByRangeColumnsContext ctx) {
        SQLPartitionByRangeColumns x = new SQLPartitionByRangeColumns();

        for (MySQLSQLStatementParser.ExprContext exprContext : ctx.columns) {
            SQLExpr column = visitExpr(exprContext);
            x.addColumn(column);
        }

        if (ctx.partitionsNum != null) {
            SQLExpr partitionsNum = visitExpr(ctx.partitionsNum);
            x.setPartitionsNum(partitionsNum);
        }

        if (ctx.iSubPartitionBy() != null) {
            ISQLSubPartitionBy subPartitionBy = (ISQLSubPartitionBy) visit(ctx.iSubPartitionBy());
            x.setSubPartitionBy(subPartitionBy);
        }

        for (MySQLSQLStatementParser.PartitionDefinitionContext partitionDefinitionContext : ctx.partitionDefinition()) {
            SQLPartitionDefinition partition = visitPartitionDefinition(partitionDefinitionContext);
            x.addPartition(partition);
        }

        return x;
    }

    @Override
    public SQLPartitionByList visitPartitionByList(MySQLSQLStatementParser.PartitionByListContext ctx) {
        SQLPartitionByList x = new SQLPartitionByList();

        for (MySQLSQLStatementParser.ExprContext exprContext : ctx.columns) {
            SQLExpr column = visitExpr(exprContext);
            x.addColumn(column);
        }

        if (ctx.partitionsNum != null) {
            SQLExpr partitionsNum = visitExpr(ctx.partitionsNum);
            x.setPartitionsNum(partitionsNum);
        }

        if (ctx.iSubPartitionBy() != null) {
            ISQLSubPartitionBy subPartitionBy = (ISQLSubPartitionBy) visit(ctx.iSubPartitionBy());
            x.setSubPartitionBy(subPartitionBy);
        }

        for (MySQLSQLStatementParser.PartitionDefinitionContext partitionDefinitionContext : ctx.partitionDefinition()) {
            SQLPartitionDefinition partition = visitPartitionDefinition(partitionDefinitionContext);
            x.addPartition(partition);
        }

        return x;
    }

    @Override
    public SQLPartitionByListColumns visitPartitionByListColumns(MySQLSQLStatementParser.PartitionByListColumnsContext ctx) {
        SQLPartitionByListColumns x = new SQLPartitionByListColumns();

        for (MySQLSQLStatementParser.ExprContext exprContext : ctx.columns) {
            SQLExpr column = visitExpr(exprContext);
            x.addColumn(column);
        }

        if (ctx.partitionsNum != null) {
            SQLExpr partitionsNum = visitExpr(ctx.partitionsNum);
            x.setPartitionsNum(partitionsNum);
        }

        if (ctx.iSubPartitionBy() != null) {
            ISQLSubPartitionBy subPartitionBy = (ISQLSubPartitionBy) visit(ctx.iSubPartitionBy());
            x.setSubPartitionBy(subPartitionBy);
        }

        for (MySQLSQLStatementParser.PartitionDefinitionContext partitionDefinitionContext : ctx.partitionDefinition()) {
            SQLPartitionDefinition partition = visitPartitionDefinition(partitionDefinitionContext);
            x.addPartition(partition);
        }

        return x;
    }

    @Override
    public SQLSubPartitionByHash visitSubPartitionByHash(MySQLSQLStatementParser.SubPartitionByHashContext ctx) {
        SQLSubPartitionByHash x = new SQLSubPartitionByHash();

        if (ctx.LINEAR() != null) {
            x.setLinear(true);
        }

        for (MySQLSQLStatementParser.ExprContext columnContext : ctx.columns) {
            SQLExpr column = visitExpr(columnContext);
            x.addColumn(column);
        }

        if (ctx.subpartitionsNum != null) {
            SQLExpr subpartitionsNum = visitExpr(ctx.subpartitionsNum);
            x.setSubpartitionsNum(subpartitionsNum);
        }

        return x;

    }

    @Override
    public SQLSubPartitionByKey visitSubPartitionByKey(MySQLSQLStatementParser.SubPartitionByKeyContext ctx) {
        SQLSubPartitionByKey x = new SQLSubPartitionByKey();
        if (ctx.LINEAR() != null) {
            x.setLinear(true);
        }

        if (ctx.algorithm != null) {
            SQLExpr algorithm = visitExpr(ctx.algorithm);
            x.setAlgorithm(algorithm);
        }

        for (MySQLSQLStatementParser.ExprContext columnContext : ctx.columns) {
            SQLExpr column = visitExpr(columnContext);
            x.addColumn(column);
        }

        if (ctx.subpartitionsNum != null) {
            SQLExpr subpartitionsNum = visitExpr(ctx.subpartitionsNum);
            x.setSubpartitionsNum(subpartitionsNum);
        }

        return x;
    }

    @Override
    public SQLPartitionDefinition visitPartitionDefinition(MySQLSQLStatementParser.PartitionDefinitionContext ctx) {
        SQLPartitionDefinition x = new SQLPartitionDefinition();
        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);

        if (ctx.iPartitionValues() != null) {
            ISQLPartitionValues values = (ISQLPartitionValues) visit(ctx.iPartitionValues());
            x.setValues(values);
        }

        for (MySQLSQLStatementParser.PartitionOptionContext partitionOptionContext : ctx.partitionOption()) {
            SQLExpr option = (SQLExpr) visit(partitionOptionContext);
            x.addOption(option);
        }

        for (MySQLSQLStatementParser.SubPartitionDefinitionContext subPartitionDefinitionContext : ctx.subPartitionDefinition()) {
            SQLSubPartitionDefinition subPartition = visitSubPartitionDefinition(subPartitionDefinitionContext);
            x.addSubPartition(subPartition);
        }
        return x;
    }

    @Override
    public SQLPartitionValuesLessThan visitPartitionValuesLessThan(MySQLSQLStatementParser.PartitionValuesLessThanContext ctx) {
        SQLPartitionValuesLessThan x = new SQLPartitionValuesLessThan();

        for (MySQLSQLStatementParser.ExprContext exprContext : ctx.expr()) {
            SQLExpr value = visitExpr(exprContext);
            x.addValue(value);
        }
        return x;
    }

    @Override
    public SQLPartitionValuesLessThanMaxValue visitPartitionValuesLessThanMaxValue(MySQLSQLStatementParser.PartitionValuesLessThanMaxValueContext ctx) {
        return new SQLPartitionValuesLessThanMaxValue();
    }

    @Override
    public SQLPartitionValuesIn visitPartitionValuesIn(MySQLSQLStatementParser.PartitionValuesInContext ctx) {
        SQLPartitionValuesIn x = new SQLPartitionValuesIn();
        for (MySQLSQLStatementParser.ExprContext exprContext : ctx.expr()) {
            SQLExpr value = visitExpr(exprContext);
            x.addValue(value);
        }
        return x;
    }

    @Override
    public SQLSubPartitionDefinition visitSubPartitionDefinition(MySQLSQLStatementParser.SubPartitionDefinitionContext ctx) {
        SQLSubPartitionDefinition x = new SQLSubPartitionDefinition();
        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);
        for (MySQLSQLStatementParser.PartitionOptionContext partitionOptionContext : ctx.partitionOption()) {
            SQLExpr option = (SQLExpr) visit(partitionOptionContext);
            x.addOption(option);
        }
        return x;
    }

    @Override
    public SQLObject visitPartitionOptionEngine(MySQLSQLStatementParser.PartitionOptionEngineContext ctx) {
        return super.visitPartitionOptionEngine(ctx);
    }

    @Override
    public SQLObject visitPartitionOptionComment(MySQLSQLStatementParser.PartitionOptionCommentContext ctx) {
        return super.visitPartitionOptionComment(ctx);
    }

    @Override
    public SQLObject visitPartitionOptionDataDirectory(MySQLSQLStatementParser.PartitionOptionDataDirectoryContext ctx) {
        return super.visitPartitionOptionDataDirectory(ctx);
    }

    @Override
    public SQLObject visitPartitionOptionIndexDirectory(MySQLSQLStatementParser.PartitionOptionIndexDirectoryContext ctx) {
        return super.visitPartitionOptionIndexDirectory(ctx);
    }

    @Override
    public SQLObject visitPartitionOptionMaxRows(MySQLSQLStatementParser.PartitionOptionMaxRowsContext ctx) {
        return super.visitPartitionOptionMaxRows(ctx);
    }

    @Override
    public SQLObject visitPartitionOptionMinRows(MySQLSQLStatementParser.PartitionOptionMinRowsContext ctx) {
        return super.visitPartitionOptionMinRows(ctx);
    }

    @Override
    public SQLObject visitPartitionOptionTablespace(MySQLSQLStatementParser.PartitionOptionTablespaceContext ctx) {
        return super.visitPartitionOptionTablespace(ctx);
    }

    @Override
    public SQLObject visitPartitionOptionNodeGroup(MySQLSQLStatementParser.PartitionOptionNodeGroupContext ctx) {
        return super.visitPartitionOptionNodeGroup(ctx);
    }
    // ----- table statement End --------------------------

    @Override
    public SQLObject visitCreateTablespaceStatement(MySQLSQLStatementParser.CreateTablespaceStatementContext ctx) {
        return super.visitCreateTablespaceStatement(ctx);
    }

    @Override
    public SQLObject visitCreateTablespaceInnodb(MySQLSQLStatementParser.CreateTablespaceInnodbContext ctx) {
        return super.visitCreateTablespaceInnodb(ctx);
    }

    @Override
    public SQLObject visitCreateTablespaceNdb(MySQLSQLStatementParser.CreateTablespaceNdbContext ctx) {
        return super.visitCreateTablespaceNdb(ctx);
    }

    @Override
    public SQLCreateTriggerStatement visitCreateTriggerStatement(MySQLSQLStatementParser.CreateTriggerStatementContext ctx) {
        SQLCreateTriggerStatement x = new SQLCreateTriggerStatement(DBType.MySQL);

        if (ctx.definerOptionExpr() != null) {
            SQLDefinerOptionExpr definerExpr = visitDefinerOptionExpr(ctx.definerOptionExpr());
            x.setDefinerExpr(definerExpr);
        }

        SQLName name = visitNameIdentifier(ctx.name);
        x.setName(name);

        SQLCreateTriggerStatement.SQLTriggerActionTime actionTime = null;
        if (ctx.BEFORE() != null) {
            actionTime = SQLCreateTriggerStatement.SQLTriggerActionTime.BEFORE;
        } else if (ctx.AFTER() != null) {
            actionTime = SQLCreateTriggerStatement.SQLTriggerActionTime.AFTER;
        }
        x.setActionTime(actionTime);

        SQLTriggerEvent event = null;
        if (ctx.INSERT() != null) {
            event = SQLTriggerDMLEvent.of(SQLTriggerDMLEvent.SQLTriggerDMLEventType.INSERT);
        } else if (ctx.UPDATE() != null) {
            event = SQLTriggerDMLEvent.of(SQLTriggerDMLEvent.SQLTriggerDMLEventType.UPDATE);
        } else if (ctx.DELETE() != null) {
            event = SQLTriggerDMLEvent.of(SQLTriggerDMLEvent.SQLTriggerDMLEventType.DELETE);
        }
        x.addEvent(event);

        SQLName onExpr = visitNameIdentifier(ctx.onExpr);
        x.setOnExpr(onExpr);

        if (ctx.triggerOrderingClause() != null) {
            visitTriggerOrderingClause(ctx.triggerOrderingClause());
        }

        SQLObject body = visitChildren(ctx.statement());
        x.setTriggerBody(body);

        return x;
    }

    @Override
    public SQLTriggerOrderingClause visitTriggerOrderingClause(MySQLSQLStatementParser.TriggerOrderingClauseContext ctx) {
        if (ctx == null) {
            return null;
        }
        SQLTriggerOrderingClause x = new SQLTriggerOrderingClause();
        SQLTriggerOrderingClause.Type type = SQLTriggerOrderingClause.Type.FOLLOWS;
        if (ctx.PRECEDES() != null) {
            type = SQLTriggerOrderingClause.Type.PRECEDES;
        }
        x.setType(type);
        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.addName(name);

        return x;
    }

    @Override
    public SQLCreateViewStatement visitCreateViewStatement(MySQLSQLStatementParser.CreateViewStatementContext ctx) {
        SQLCreateViewStatement x = new SQLCreateViewStatement(DBType.MySQL);
        if (ctx.orReplace() != null) {
            x.setOrReplace(true);
        }

        if (ctx.algorithmOptionExpr() != null) {
            SQLAlgorithmOptionExpr algorithmOption = visitAlgorithmOptionExpr(ctx.algorithmOptionExpr());
            x.setAlgorithmSetOptionExpr(algorithmOption);
        }

        if (ctx.definerOptionExpr() != null) {
            SQLDefinerOptionExpr definerExpr = visitDefinerOptionExpr(ctx.definerOptionExpr());
            x.setDefinerSetOptionExpr(definerExpr);
        }

        if (ctx.secContext != null) {
            SQLCreateViewStatement.SQLSecurityType securityType = null;
            if (ctx.DEFINER() != null) {
                securityType = SQLCreateViewStatement.SQLSecurityType.SQL_SECURITY_DEFINER;
            } else if (ctx.INVOKER() != null) {
                securityType = SQLCreateViewStatement.SQLSecurityType.SQL_SECURITY_INVOKER;
            }
            x.setSecurityType(securityType);
        }

        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);

        for (MySQLSQLStatementParser.ColumnDefinitionContext columnDefinitionContext : ctx.columnDefinition()) {
            SQLColumnDefinition column = visitColumnDefinition(columnDefinitionContext);
            x.addColumn(column);
        }

        ISQLSelectQuery subQuery = visitISelectQuery(ctx.iSelectQuery());
        x.setSubQuery(subQuery);

        if (ctx.withCheckOption() != null) {
            ISQLSubqueryRestrictionClause.SQLWithCheckOption withCheckOption = visitWithCheckOption(ctx.withCheckOption());
            x.setSubqueryRestriction(withCheckOption);
        }
        return x;
    }

    @Override
    public ISQLSubqueryRestrictionClause.SQLWithCheckOption visitWithCheckOption(MySQLSQLStatementParser.WithCheckOptionContext ctx) {
        if (ctx == null) {
            return null;
        }

        ISQLSubqueryRestrictionClause.SQLWithCheckOption x = new ISQLSubqueryRestrictionClause.SQLWithCheckOption();
        ISQLSubqueryRestrictionClause.SQLWithCheckOption.SQLLevels levels = null;
        if (ctx.CASCADED() != null) {
            levels = ISQLSubqueryRestrictionClause.SQLWithCheckOption.SQLLevels.CASCADED;
        } else if (ctx.LOCAL() != null) {
            levels = ISQLSubqueryRestrictionClause.SQLWithCheckOption.SQLLevels.LOCAL;
        }
        x.setLevels(levels);
        return x;
    }

    @Override
    public SQLObject visitCreateDatabaseOption(MySQLSQLStatementParser.CreateDatabaseOptionContext ctx) {
        return super.visitCreateDatabaseOption(ctx);
    }

    @Override
    public SQLDefinerOptionExpr visitDefinerOptionExpr(MySQLSQLStatementParser.DefinerOptionExprContext ctx) {
        if (ctx == null) {
            return null;
        }

        SQLExpr value = null;
        if (ctx.CURRENT_USER() != null) {
            value = SQLMethodInvocation.ofNoneParen(SQLReserved.CURRENT_USER.upper);
            if (ctx.LEFT_PAREN() != null) {
                value = SQLMethodInvocation.of(SQLReserved.CURRENT_USER.upper);
            }
        } else {
            value = visitNameIdentifier(ctx.nameIdentifier());
        }

        SQLDefinerOptionExpr x = new SQLDefinerOptionExpr(true, value);

        return x;
    }

    @Override
    public SQLObject visitPreciseSchedule(MySQLSQLStatementParser.PreciseScheduleContext ctx) {
        return super.visitPreciseSchedule(ctx);
    }

    @Override
    public SQLObject visitIntervalSchedule(MySQLSQLStatementParser.IntervalScheduleContext ctx) {
        return super.visitIntervalSchedule(ctx);
    }

    @Override
    public SQLObject visitTimestampValue(MySQLSQLStatementParser.TimestampValueContext ctx) {
        return super.visitTimestampValue(ctx);
    }

    @Override
    public SQLObject visitEnableType(MySQLSQLStatementParser.EnableTypeContext ctx) {
        return super.visitEnableType(ctx);
    }

    @Override
    public SQLObject visitIndexOption(MySQLSQLStatementParser.IndexOptionContext ctx) {
        return super.visitIndexOption(ctx);
    }

    @Override
    public SQLObject visitIndexOptionKeyBlockSize(MySQLSQLStatementParser.IndexOptionKeyBlockSizeContext ctx) {
        return super.visitIndexOptionKeyBlockSize(ctx);
    }

    @Override
    public SQLObject visitIndexOptionUsingBtree(MySQLSQLStatementParser.IndexOptionUsingBtreeContext ctx) {
        return super.visitIndexOptionUsingBtree(ctx);
    }

    @Override
    public SQLObject visitIndexOptionUsingHash(MySQLSQLStatementParser.IndexOptionUsingHashContext ctx) {
        return super.visitIndexOptionUsingHash(ctx);
    }

    @Override
    public SQLObject visitIndexOptionWithParser(MySQLSQLStatementParser.IndexOptionWithParserContext ctx) {
        return super.visitIndexOptionWithParser(ctx);
    }

    @Override
    public SQLObject visitIndexAttributeVisible(MySQLSQLStatementParser.IndexAttributeVisibleContext ctx) {
        return super.visitIndexAttributeVisible(ctx);
    }

    @Override
    public SQLObject visitIndexAttributeInvisible(MySQLSQLStatementParser.IndexAttributeInvisibleContext ctx) {
        return super.visitIndexAttributeInvisible(ctx);
    }

    @Override
    public SQLObject visitIndexOptionCommentOption(MySQLSQLStatementParser.IndexOptionCommentOptionContext ctx) {
        return super.visitIndexOptionCommentOption(ctx);
    }

    @Override
    public SQLParameterDeclaration visitParameterDeclaration(MySQLSQLStatementParser.ParameterDeclarationContext ctx) {
        SQLParameterDeclaration x = new SQLParameterDeclaration();

        SQLParameterModel parameterModel = null;
        if (ctx.IN() != null) {
            parameterModel = SQLParameterModel.IN;
        } else if (ctx.OUT() != null) {
            parameterModel = SQLParameterModel.OUT;
        } else if (ctx.INOUT() != null) {
            parameterModel = SQLParameterModel.INOUT;
        }
        x.setParameterModel(parameterModel);

        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);

        SQLDataType dataType = visitDataType(ctx.dataType());
        x.setDataType(dataType);
        return x;
    }

    @Override
    public SQLObject visitRoutineComment(MySQLSQLStatementParser.RoutineCommentContext ctx) {
        return super.visitRoutineComment(ctx);
    }

    @Override
    public SQLObject visitRoutineLanguage(MySQLSQLStatementParser.RoutineLanguageContext ctx) {
        return super.visitRoutineLanguage(ctx);
    }

    @Override
    public SQLObject visitRoutineBehavior(MySQLSQLStatementParser.RoutineBehaviorContext ctx) {
        return super.visitRoutineBehavior(ctx);
    }

    @Override
    public SQLObject visitRoutineData(MySQLSQLStatementParser.RoutineDataContext ctx) {
        return super.visitRoutineData(ctx);
    }

    @Override
    public SQLObject visitRoutineSecurity(MySQLSQLStatementParser.RoutineSecurityContext ctx) {
        return super.visitRoutineSecurity(ctx);
    }


    @Override
    public SQLObject visitAlterSimpleDatabase(MySQLSQLStatementParser.AlterSimpleDatabaseContext ctx) {
        return super.visitAlterSimpleDatabase(ctx);
    }

    @Override
    public SQLObject visitAlterUpgradeName(MySQLSQLStatementParser.AlterUpgradeNameContext ctx) {
        return super.visitAlterUpgradeName(ctx);
    }

    @Override
    public SQLObject visitAlterEventStatement(MySQLSQLStatementParser.AlterEventStatementContext ctx) {
        return super.visitAlterEventStatement(ctx);
    }

    @Override
    public SQLObject visitAlterFunctionStatement(MySQLSQLStatementParser.AlterFunctionStatementContext ctx) {
        return super.visitAlterFunctionStatement(ctx);
    }

    @Override
    public SQLObject visitAlterInstanceStatement(MySQLSQLStatementParser.AlterInstanceStatementContext ctx) {
        return super.visitAlterInstanceStatement(ctx);
    }

    @Override
    public SQLObject visitAlterLogfileGroupStatement(MySQLSQLStatementParser.AlterLogfileGroupStatementContext ctx) {
        return super.visitAlterLogfileGroupStatement(ctx);
    }

    @Override
    public SQLObject visitAlterProcedureStatement(MySQLSQLStatementParser.AlterProcedureStatementContext ctx) {
        return super.visitAlterProcedureStatement(ctx);
    }

    @Override
    public SQLObject visitAlterServerStatement(MySQLSQLStatementParser.AlterServerStatementContext ctx) {
        return super.visitAlterServerStatement(ctx);
    }

    @Override
    public SQLAlterTableStatement visitAlterTableStatement(MySQLSQLStatementParser.AlterTableStatementContext ctx) {
        SQLAlterTableStatement x = new SQLAlterTableStatement(DBType.MySQL);

        if (ctx.intimeAction() != null) {
            SQLInTimeAction inTimeAction = of(ctx.intimeAction());
            x.setInTimeAction(inTimeAction);
        }

        if (ctx.IGNORE() != null) {
            x.setIgnore(true);
        }

        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        SQLObjectNameTableReference tableReference = SQLObjectNameTableReference.of(name);
        x.setTableReference(tableReference);

        for (MySQLSQLStatementParser.AlterTableItemContext alterTableItemContext : ctx.alterTableItem()) {
            SQLExpr item = (SQLExpr) visit(alterTableItemContext);
            x.addItem(item);
        }

        if (ctx.iPartitionBy() != null) {
            ISQLPartitionBy partitionBy = (ISQLPartitionBy) visit(ctx.iPartitionBy());
            x.setPartitionBy(partitionBy);
        }

        return x;
    }

    @Override
    public SQLObject visitAlterByTableOption(MySQLSQLStatementParser.AlterByTableOptionContext ctx) {
        return super.visitAlterByTableOption(ctx);
    }

    @Override
    public SQLObject visitAlterTableAddColumnAction(MySQLSQLStatementParser.AlterTableAddColumnActionContext ctx) {
        return super.visitAlterTableAddColumnAction(ctx);
    }

    @Override
    public SQLAlterTableAddTableConstraintAction visitAlterTableAddTableConstraintAction(MySQLSQLStatementParser.AlterTableAddTableConstraintActionContext ctx) {
        SQLAlterTableAddTableConstraintAction x = new SQLAlterTableAddTableConstraintAction();

        return x;
    }

    @Override
    public SQLObject visitAlterTableAlgorithmAction(MySQLSQLStatementParser.AlterTableAlgorithmActionContext ctx) {
        return super.visitAlterTableAlgorithmAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableAlterColumnAction(MySQLSQLStatementParser.AlterTableAlterColumnActionContext ctx) {
        return super.visitAlterTableAlterColumnAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableAlterIndexConstraintAction(MySQLSQLStatementParser.AlterTableAlterIndexConstraintActionContext ctx) {
        return super.visitAlterTableAlterIndexConstraintAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableChangeColumnAction(MySQLSQLStatementParser.AlterTableChangeColumnActionContext ctx) {
        return super.visitAlterTableChangeColumnAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableDefaultCharsetAction(MySQLSQLStatementParser.AlterTableDefaultCharsetActionContext ctx) {
        return super.visitAlterTableDefaultCharsetAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableConvertCharsetAction(MySQLSQLStatementParser.AlterTableConvertCharsetActionContext ctx) {
        return super.visitAlterTableConvertCharsetAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableDisableKeysAction(MySQLSQLStatementParser.AlterTableDisableKeysActionContext ctx) {
        return super.visitAlterTableDisableKeysAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableEnableKeysAction(MySQLSQLStatementParser.AlterTableEnableKeysActionContext ctx) {
        return super.visitAlterTableEnableKeysAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableDiscardTablespaceAction(MySQLSQLStatementParser.AlterTableDiscardTablespaceActionContext ctx) {
        return super.visitAlterTableDiscardTablespaceAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableImportTablespaceAction(MySQLSQLStatementParser.AlterTableImportTablespaceActionContext ctx) {
        return super.visitAlterTableImportTablespaceAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableDropColumnAction(MySQLSQLStatementParser.AlterTableDropColumnActionContext ctx) {
        return super.visitAlterTableDropColumnAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableDropIndexConstraintAction(MySQLSQLStatementParser.AlterTableDropIndexConstraintActionContext ctx) {
        return super.visitAlterTableDropIndexConstraintAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableDropKeyConstraintAction(MySQLSQLStatementParser.AlterTableDropKeyConstraintActionContext ctx) {
        return super.visitAlterTableDropKeyConstraintAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableDropPrimaryKeyConstraintAction(MySQLSQLStatementParser.AlterTableDropPrimaryKeyConstraintActionContext ctx) {
        return super.visitAlterTableDropPrimaryKeyConstraintAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableDropForeignKeyConstraintAction(MySQLSQLStatementParser.AlterTableDropForeignKeyConstraintActionContext ctx) {
        return super.visitAlterTableDropForeignKeyConstraintAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableForceAction(MySQLSQLStatementParser.AlterTableForceActionContext ctx) {
        return super.visitAlterTableForceAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableLockAction(MySQLSQLStatementParser.AlterTableLockActionContext ctx) {
        return super.visitAlterTableLockAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableModifyColumnAction(MySQLSQLStatementParser.AlterTableModifyColumnActionContext ctx) {
        return super.visitAlterTableModifyColumnAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableOrderByColumnAction(MySQLSQLStatementParser.AlterTableOrderByColumnActionContext ctx) {
        return super.visitAlterTableOrderByColumnAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableRenameColumnAction(MySQLSQLStatementParser.AlterTableRenameColumnActionContext ctx) {
        return super.visitAlterTableRenameColumnAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableRenameIndexConstraintAction(MySQLSQLStatementParser.AlterTableRenameIndexConstraintActionContext ctx) {
        return super.visitAlterTableRenameIndexConstraintAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableRenameKeyConstraintAction(MySQLSQLStatementParser.AlterTableRenameKeyConstraintActionContext ctx) {
        return super.visitAlterTableRenameKeyConstraintAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableRenameTableAction(MySQLSQLStatementParser.AlterTableRenameTableActionContext ctx) {
        return super.visitAlterTableRenameTableAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableWithoutValidateAction(MySQLSQLStatementParser.AlterTableWithoutValidateActionContext ctx) {
        return super.visitAlterTableWithoutValidateAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableWithValidateAction(MySQLSQLStatementParser.AlterTableWithValidateActionContext ctx) {
        return super.visitAlterTableWithValidateAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableAddPartitionAction(MySQLSQLStatementParser.AlterTableAddPartitionActionContext ctx) {
        return super.visitAlterTableAddPartitionAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableDropPartitionAction(MySQLSQLStatementParser.AlterTableDropPartitionActionContext ctx) {
        return super.visitAlterTableDropPartitionAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableDiscardPartitionAction(MySQLSQLStatementParser.AlterTableDiscardPartitionActionContext ctx) {
        return super.visitAlterTableDiscardPartitionAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableImportPartitionAction(MySQLSQLStatementParser.AlterTableImportPartitionActionContext ctx) {
        return super.visitAlterTableImportPartitionAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableTruncatePartitionAction(MySQLSQLStatementParser.AlterTableTruncatePartitionActionContext ctx) {
        return super.visitAlterTableTruncatePartitionAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableCoalescePartitionAction(MySQLSQLStatementParser.AlterTableCoalescePartitionActionContext ctx) {
        return super.visitAlterTableCoalescePartitionAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableReorganizePartitionAction(MySQLSQLStatementParser.AlterTableReorganizePartitionActionContext ctx) {
        return super.visitAlterTableReorganizePartitionAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableExchangePartitionAction(MySQLSQLStatementParser.AlterTableExchangePartitionActionContext ctx) {
        return super.visitAlterTableExchangePartitionAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableAnalyzePartitiionAction(MySQLSQLStatementParser.AlterTableAnalyzePartitiionActionContext ctx) {
        return super.visitAlterTableAnalyzePartitiionAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableCheckPartitionAction(MySQLSQLStatementParser.AlterTableCheckPartitionActionContext ctx) {
        return super.visitAlterTableCheckPartitionAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableOptimizePartitionAction(MySQLSQLStatementParser.AlterTableOptimizePartitionActionContext ctx) {
        return super.visitAlterTableOptimizePartitionAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableRebuildPartitionAction(MySQLSQLStatementParser.AlterTableRebuildPartitionActionContext ctx) {
        return super.visitAlterTableRebuildPartitionAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableRepairPartitionAction(MySQLSQLStatementParser.AlterTableRepairPartitionActionContext ctx) {
        return super.visitAlterTableRepairPartitionAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableRemovePartitioningAction(MySQLSQLStatementParser.AlterTableRemovePartitioningActionContext ctx) {
        return super.visitAlterTableRemovePartitioningAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableUpgradePartitioningAction(MySQLSQLStatementParser.AlterTableUpgradePartitioningActionContext ctx) {
        return super.visitAlterTableUpgradePartitioningAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableColumnActionProperty(MySQLSQLStatementParser.AlterTableColumnActionPropertyContext ctx) {
        return super.visitAlterTableColumnActionProperty(ctx);
    }

    @Override
    public SQLObject visitAlterColumnSetDefaultAction(MySQLSQLStatementParser.AlterColumnSetDefaultActionContext ctx) {
        return super.visitAlterColumnSetDefaultAction(ctx);
    }

    @Override
    public SQLObject visitAlterColumnDropDefaultAction(MySQLSQLStatementParser.AlterColumnDropDefaultActionContext ctx) {
        return super.visitAlterColumnDropDefaultAction(ctx);
    }

    @Override
    public SQLObject visitAlterTablePartitionItem(MySQLSQLStatementParser.AlterTablePartitionItemContext ctx) {
        return super.visitAlterTablePartitionItem(ctx);
    }

    @Override
    public SQLObject visitAlterTablespaceStatement(MySQLSQLStatementParser.AlterTablespaceStatementContext ctx) {
        return super.visitAlterTablespaceStatement(ctx);
    }

    @Override
    public SQLObject visitAlterViewStatement(MySQLSQLStatementParser.AlterViewStatementContext ctx) {
        return super.visitAlterViewStatement(ctx);
    }

    @Override
    public SQLDropDatabaseStatement visitDropDatabaseStatement(MySQLSQLStatementParser.DropDatabaseStatementContext ctx) {
        SQLDropDatabaseStatement x = new SQLDropDatabaseStatement(DBType.MySQL);
        if (ctx.ifExists() != null) {
            x.setIfExists(true);
        }
        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);
        return x;
    }

    @Override
    public SQLDropSchemaStatement visitDropSchemaStatement(MySQLSQLStatementParser.DropSchemaStatementContext ctx) {
        SQLDropSchemaStatement x = new SQLDropSchemaStatement(DBType.MySQL);
        if (ctx.ifExists() != null) {
            x.setIfExists(true);
        }
        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.addName(name);
        return x;
    }

    @Override
    public SQLDropEventStatement visitDropEventStatement(MySQLSQLStatementParser.DropEventStatementContext ctx) {
        SQLDropEventStatement x = new SQLDropEventStatement(DBType.MySQL);
        if (ctx.ifExists() != null) {
            x.setIfExists(true);
        }
        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);
        return x;
    }

    @Override
    public SQLDropIndexStatement visitDropIndexStatement(MySQLSQLStatementParser.DropIndexStatementContext ctx) {
        SQLDropIndexStatement x = new SQLDropIndexStatement(DBType.MySQL);

        if (ctx.intimeAction() != null) {
            SQLInTimeAction inTimeAction = of(ctx.intimeAction());
            x.setInTimeAction(inTimeAction);
        }

        SQLName name = visitNameIdentifier(ctx.index);
        x.addName(name);

        SQLName table = visitNameIdentifier(ctx.table);
        x.setTable(table);

        for (MySQLSQLStatementParser.DropIndexStatementOptionContext dropIndexStatementOptionContext : ctx.dropIndexStatementOption()) {
            SQLExpr option = (SQLExpr) visitChildren(dropIndexStatementOptionContext);
            x.addOption(option);
        }
        return x;
    }

    @Override
    public SQLObject visitDropIndexStatementOption(MySQLSQLStatementParser.DropIndexStatementOptionContext ctx) {
        return super.visitDropIndexStatementOption(ctx);
    }

    @Override
    public SQLObject visitDropLogfileGroupStatement(MySQLSQLStatementParser.DropLogfileGroupStatementContext ctx) {
        return super.visitDropLogfileGroupStatement(ctx);
    }

    @Override
    public SQLObject visitDropProcedureStatement(MySQLSQLStatementParser.DropProcedureStatementContext ctx) {
        return super.visitDropProcedureStatement(ctx);
    }

    @Override
    public SQLObject visitDropFunctionStatement(MySQLSQLStatementParser.DropFunctionStatementContext ctx) {
        return super.visitDropFunctionStatement(ctx);
    }

    @Override
    public SQLDropServerStatement visitDropServerStatement(MySQLSQLStatementParser.DropServerStatementContext ctx) {
        SQLDropServerStatement x = new SQLDropServerStatement(DBType.MySQL);
        if (ctx.ifExists() != null) {
            x.setIfExists(true);
        }
        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);
        return x;
    }

    @Override
    public SQLDropTableStatement visitDropTableStatement(MySQLSQLStatementParser.DropTableStatementContext ctx) {
        SQLDropTableStatement x = new SQLDropTableStatement(DBType.MySQL);
        if (ctx.TEMPORARY() != null) {
            x.setTemporary(true);
        }

        if (ctx.ifExists() != null) {
            x.setIfExists(true);
        }

        for (MySQLSQLStatementParser.NameIdentifierContext nameIdentifierContext : ctx.nameIdentifier()) {
            SQLName name = visitNameIdentifier(nameIdentifierContext);
            x.addName(name);
        }

        SQLCascadeType dropBehavior = null;
        if (ctx.RESTRICT() != null) {
            dropBehavior = SQLCascadeType.RESTRICT;
        } else if (ctx.CASCADE() != null) {
            dropBehavior = SQLCascadeType.CASCADE;
        }
        x.setDropBehavior(dropBehavior);

        return x;
    }

    @Override
    public SQLObject visitDropTablespaceStatement(MySQLSQLStatementParser.DropTablespaceStatementContext ctx) {
        return super.visitDropTablespaceStatement(ctx);
    }

    @Override
    public SQLDropTriggerStatement visitDropTriggerStatement(MySQLSQLStatementParser.DropTriggerStatementContext ctx) {
        SQLDropTriggerStatement x = new SQLDropTriggerStatement(DBType.MySQL);
        if (ctx.ifExists() != null) {
            x.setIfExists(true);
        }
        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);
        return x;
    }

    @Override
    public SQLDropViewStatement visitDropViewStatement(MySQLSQLStatementParser.DropViewStatementContext ctx) {
        SQLDropViewStatement x = new SQLDropViewStatement(DBType.MySQL);

        if (ctx.ifExists() != null) {
            x.setIfExists(true);
        }

        for (MySQLSQLStatementParser.NameIdentifierContext nameIdentifierContext : ctx.nameIdentifier()) {
            SQLName name = visitNameIdentifier(nameIdentifierContext);
            x.addName(name);
        }

        SQLCascadeType dropBehavior = null;
        if (ctx.RESTRICT() != null) {
            dropBehavior = SQLCascadeType.RESTRICT;
        } else if (ctx.CASCADE() != null) {
            dropBehavior = SQLCascadeType.CASCADE;
        }
        x.setBehavior(dropBehavior);
        return x;
    }

    @Override
    public SQLRenameTableStatement visitRenameTableStatement(MySQLSQLStatementParser.RenameTableStatementContext ctx) {
        SQLRenameTableStatement x = new SQLRenameTableStatement(DBType.MySQL);
        for (MySQLSQLStatementParser.RenameTableClauseContext renameTableClauseContext : ctx.renameTableClause()) {
            SQLRenameTableStatement.Item item = visitRenameTableClause(renameTableClauseContext);
            x.addItem(item);
        }
        return x;
    }

    @Override
    public SQLRenameTableStatement.Item visitRenameTableClause(MySQLSQLStatementParser.RenameTableClauseContext ctx) {
        SQLName oldName = visitNameIdentifier(ctx.nameIdentifier(0));
        SQLName newName = visitNameIdentifier(ctx.nameIdentifier(1));

        SQLRenameTableStatement.Item x = new SQLRenameTableStatement.Item(oldName, newName);
        return x;
    }

    @Override
    public SQLTruncateTableStatement visitTruncateTableStatement(MySQLSQLStatementParser.TruncateTableStatementContext ctx) {
        SQLTruncateTableStatement x = new SQLTruncateTableStatement(DBType.MySQL);

        if (ctx.TABLE() == null) {
            x.setTable(false);
        }

        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.addName(name);

        return x;
    }

    // ----- Select ------------
    @Override
    public SQLSelectStatement visitSelectStatement(MySQLSQLStatementParser.SelectStatementContext ctx) {
        SQLSelectStatement x = new SQLSelectStatement(DBType.MySQL);
        ISQLSelectQuery query = visitISelectQuery(ctx.iSelectQuery());
        x.setQuery(query);
        return x;
    }

    @Override
    public ISQLSelectQuery visitISelectQuery(MySQLSQLStatementParser.ISelectQueryContext ctx) {
        return (ISQLSelectQuery) super.visitChildren(ctx);
    }

    @Override
    public ISQLSelectQuery visitSelectQueryBasic(MySQLSQLStatementParser.SelectQueryBasicContext ctx) {
        return (ISQLSelectQuery) super.visitChildren(ctx);
    }

    @Override
    public MySQLSQLSelectQuery visitSelectQuery(MySQLSQLStatementParser.SelectQueryContext ctx) {
        MySQLSQLSelectQuery x = new MySQLSQLSelectQuery();

        if (ctx.setQuantifier() != null) {
            SQLSetQuantifier setQuantifier = of(ctx.setQuantifier());
            x.setSetQuantifier(setQuantifier);
        }

        for (MySQLSQLStatementParser.SelectItemContext selectItemContext : ctx.selectItem()) {
            SQLSelectItem selectItem = visitSelectItem(selectItemContext);
            x.addSelectItem(selectItem);
        }

        MySQLSQLStatementParser.FromClauseContext fromClauseContext = ctx.fromClause();
        if (fromClauseContext != null) {
            SQLFromClause fromClause = visitFromClause(fromClauseContext);
            x.setFromClause(fromClause);
        }

        MySQLSQLStatementParser.WhereClauseContext whereClauseContext = ctx.whereClause();
        if (whereClauseContext != null) {
            SQLWhereClause whereClause = visitWhereClause(whereClauseContext);
            x.setWhereClause(whereClause);
        }

        MySQLSQLStatementParser.GroupByClauseContext groupByClauseContext = ctx.groupByClause();
        if (groupByClauseContext != null) {
            SQLGroupByClause groupByClause = (SQLGroupByClause) visit(groupByClauseContext);
            x.setGroupByClause(groupByClause);
        }

        if (ctx.orderByClause() != null) {
            SQLOrderByClause orderByClause = visitOrderByClause(ctx.orderByClause());
            x.setOrderByClause(orderByClause);
        }

        if (ctx.limitOffsetClause() != null) {
            ISQLLimitClause limitClause = visitLimitOffsetClause(ctx.limitOffsetClause());
            x.setLimitClause(limitClause);
        }

        MySQLSQLStatementParser.ILockClauseContext lockClauseContext = ctx.iLockClause();
        if (lockClauseContext != null) {
            ISQLLockClause lockClause = (ISQLLockClause) visit(lockClauseContext);
            x.setLockClause(lockClause);
        }

        return x;
    }


    @Override
    public SQLParenSelectQuery visitSelectParenQuery(MySQLSQLStatementParser.SelectParenQueryContext ctx) {
        ISQLSelectQuery selectQuery = visitISelectQuery(ctx.iSelectQuery());
        SQLParenSelectQuery x = new SQLParenSelectQuery(selectQuery);

        if (ctx.orderByClause() != null) {
            SQLOrderByClause orderByClause = visitOrderByClause(ctx.orderByClause());
            x.setOrderByClause(orderByClause);
        }

        if (ctx.limitOffsetClause() != null) {
            ISQLLimitClause limitClause = visitLimitOffsetClause(ctx.limitOffsetClause());
            x.setLimitClause(limitClause);
        }

        MySQLSQLStatementParser.ILockClauseContext lockClauseContext = ctx.iLockClause();
        if (lockClauseContext != null) {
            ISQLLockClause lockClause = (ISQLLockClause) visit(lockClauseContext);
            x.setLockClause(lockClause);
        }
        return x;
    }

    @Override
    public SQLObject visitSelectUnionQuery(MySQLSQLStatementParser.SelectUnionQueryContext ctx) {
        ISQLSelectQuery left = visitSelectQueryBasic(ctx.selectQueryBasic(0));

        SQLUnionOperator operator = of(ctx.unionOperator(0));
        ISQLSelectQuery right = visitSelectQueryBasic(ctx.selectQueryBasic(1));

        SQLSelectUnionQuery x = new SQLSelectUnionQuery(left, operator, right);

        for (int i = 2; i < ctx.selectQueryBasic().size(); i++) {
            MySQLSQLStatementParser.SelectQueryBasicContext queryContext = ctx.selectQueryBasic(i);
            ISQLSelectQuery nextSelectQuery = visitSelectQueryBasic(queryContext);
            operator = of(ctx.unionOperator(i - 1));
            x = new SQLSelectUnionQuery(x, operator, nextSelectQuery);
        }

        if (ctx.orderByClause() != null) {
            SQLOrderByClause orderByClause = visitOrderByClause(ctx.orderByClause());
            x.setOrderByClause(orderByClause);
        }

        if (ctx.limitOffsetClause() != null) {
            ISQLLimitClause limitClause = visitLimitOffsetClause(ctx.limitOffsetClause());
            x.setLimitClause(limitClause);
        }

        MySQLSQLStatementParser.ILockClauseContext lockClauseContext = ctx.iLockClause();
        if (lockClauseContext != null) {
            ISQLLockClause lockClause = (ISQLLockClause) visit(lockClauseContext);
            x.setLockClause(lockClause);
        }
        return x;
    }

    public SQLSetQuantifier of(MySQLSQLStatementParser.SetQuantifierContext ctx) {
        if (ctx == null) {
            return null;
        }

        SQLSetQuantifier x = null;
        if (ctx.DISTINCT() != null) {
            x = SQLSetQuantifier.DISTINCT;
        } else if (ctx.DISTINCTROW() != null) {
            x = SQLSetQuantifier.DISTINCTROW;

        } else if (ctx.ALL() != null) {
            x = SQLSetQuantifier.ALL;
        }

        return x;
    }

    public SQLUnionOperator of(MySQLSQLStatementParser.UnionOperatorContext ctx) {
        if (ctx == null) {
            return null;
        }

        SQLUnionOperator operator = null;
        if (ctx.UNION() != null) {

            operator = SQLUnionOperator.UNION;

            if (ctx.ALL() != null) {
                operator = SQLUnionOperator.UNION_ALL;
            } else if (ctx.DISTINCT() != null) {
                operator = SQLUnionOperator.UNION_DISTINCT;
            }
        }

        return operator;
    }

    @Override
    public SQLSelectItem visitSelectItem(MySQLSQLStatementParser.SelectItemContext ctx) {
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
    public SQLObject visitSelectItemAlias(MySQLSQLStatementParser.SelectItemAliasContext ctx) {
        return super.visitSelectItemAlias(ctx);
    }

    @Override
    public SQLFromClause visitFromClause(MySQLSQLStatementParser.FromClauseContext ctx) {
        ISQLTableReference tableReference = (ISQLTableReference) visit(ctx.iTableReference());
        return new SQLFromClause(tableReference);
    }

    @Override
    public SQLObjectNameTableReference visitObjectNameTableReference(MySQLSQLStatementParser.ObjectNameTableReferenceContext ctx) {
        SQLObjectNameTableReference x = new SQLObjectNameTableReference();

        SQLName name = visitNameIdentifier(ctx.tableName);
        x.setName(name);

        if (ctx.partitionClause() != null) {
            SQLPartitionClause partitionClause = visitPartitionClause(ctx.partitionClause());
            x.setOption(partitionClause);
        }

        if (ctx.alias != null) {

            if (ctx.AS() != null) {
                x.setAs(true);
            }

            SQLIdentifier alias = (SQLIdentifier) visitNameIdentifier(ctx.alias);
            x.setAlias(alias);
        }


        for (MySQLSQLStatementParser.IIndexHintContext indexHintContext : ctx.indexes) {
            SQLIndexHint indexHint = (SQLIndexHint) visit(indexHintContext);
            x.addIndexHint(indexHint);
        }

        return x;
    }

    @Override
    public MySQLSQLOJTableReference visitOjTableReference(MySQLSQLStatementParser.OjTableReferenceContext ctx) {
        MySQLSQLOJTableReference x = new MySQLSQLOJTableReference();
        ISQLTableReference tableReference = (ISQLTableReference) visit(ctx.iTableReference());
        x.setTableReference(tableReference);
        return x;
    }

    @Override
    public SQLSubQueryTableReference visitSubQueryTableReference(MySQLSQLStatementParser.SubQueryTableReferenceContext ctx) {
        SQLSubQueryTableReference x = new SQLSubQueryTableReference();

        ISQLSelectQuery subQuery = visitISelectQuery(ctx.iSelectQuery());
        x.setSubQuery(subQuery);

        if (ctx.AS() != null) {
            x.setAs(true);
        }

        SQLIdentifier alias = (SQLIdentifier) visitNameIdentifier(ctx.nameIdentifier());
        x.setAlias(alias);

        for (MySQLSQLStatementParser.ExprContext columnContext : ctx.columns) {
            SQLExpr column = visitExpr(columnContext);
            x.addColumn(column);
        }

        return x;
    }

    @Override
    public ISQLTableReference visitParenTableReference(MySQLSQLStatementParser.ParenTableReferenceContext ctx) {
        ISQLTableReference x = (ISQLTableReference) visit(ctx.iTableReference());
        x.setParen(true);
        return x;
    }

    @Override
    public SQLJoinTableReference visitJoinTableReference(MySQLSQLStatementParser.JoinTableReferenceContext ctx) {

        ISQLTableReference left = (ISQLTableReference) visit(ctx.tableReferenceBasic());
        SQLJoinTableReference x = null;
        for (MySQLSQLStatementParser.RightJoinClauseContext rightJoinClauseContext : ctx.rightJoinClause()) {
            SQLJoinTableReference.SQLJoinType joinType = of(rightJoinClauseContext.joinType());
            ISQLTableReference right = (ISQLTableReference) visit(rightJoinClauseContext.tableReferenceBasic());

            x = new SQLJoinTableReference(left, joinType, right);

            if (rightJoinClauseContext.iJoinCondition() != null) {
                SQLJoinTableReference.ISQLJoinCondition condition = (SQLJoinTableReference.ISQLJoinCondition) visit(rightJoinClauseContext.iJoinCondition());
                x.setCondition(condition);
            }

            left = x;
        }
        return x;
    }

    @Override
    public SQLPartitionClause visitPartitionClause(MySQLSQLStatementParser.PartitionClauseContext ctx) {
        SQLPartitionClause x = new SQLPartitionClause();
        for (MySQLSQLStatementParser.ExprContext exprContext : ctx.expr()) {
            SQLExpr item = visitExpr(exprContext);
            x.addItem(item);
        }

        return x;
    }

    @Override
    public SQLUseIndexHint visitUseIndexHint(MySQLSQLStatementParser.UseIndexHintContext ctx) {
        SQLUseIndexHint x = new SQLUseIndexHint();

        AbstractSQLIndexHint.SQLForType forType = of(ctx.indexHintType());
        x.setForType(forType);

        for (MySQLSQLStatementParser.ExprContext exprContext : ctx.expr()) {
            SQLExpr name = visitExpr(exprContext);
            x.addName(name);
        }

        return x;
    }

    @Override
    public SQLUseKeyHint visitUseKeyHint(MySQLSQLStatementParser.UseKeyHintContext ctx) {
        SQLUseKeyHint x = new SQLUseKeyHint();

        AbstractSQLIndexHint.SQLForType forType = of(ctx.indexHintType());
        x.setForType(forType);

        for (MySQLSQLStatementParser.ExprContext exprContext : ctx.expr()) {
            SQLExpr name = visitExpr(exprContext);
            x.addName(name);
        }

        return x;
    }

    @Override
    public SQLIgnoreIndexHint visitIgnoreIndexHint(MySQLSQLStatementParser.IgnoreIndexHintContext ctx) {
        SQLIgnoreIndexHint x = new SQLIgnoreIndexHint();

        AbstractSQLIndexHint.SQLForType forType = of(ctx.indexHintType());
        x.setForType(forType);

        for (MySQLSQLStatementParser.ExprContext exprContext : ctx.expr()) {
            SQLExpr name = visitExpr(exprContext);
            x.addName(name);
        }

        return x;
    }

    @Override
    public SQLIgnoreKeyHint visitIgnoreKeyHint(MySQLSQLStatementParser.IgnoreKeyHintContext ctx) {
        SQLIgnoreKeyHint x = new SQLIgnoreKeyHint();

        AbstractSQLIndexHint.SQLForType forType = of(ctx.indexHintType());
        x.setForType(forType);

        for (MySQLSQLStatementParser.ExprContext exprContext : ctx.expr()) {
            SQLExpr name = visitExpr(exprContext);
            x.addName(name);
        }

        return x;
    }

    @Override
    public SQLForceIndexHint visitForceIndexHint(MySQLSQLStatementParser.ForceIndexHintContext ctx) {
        SQLForceIndexHint x = new SQLForceIndexHint();

        AbstractSQLIndexHint.SQLForType forType = of(ctx.indexHintType());
        x.setForType(forType);

        for (MySQLSQLStatementParser.ExprContext exprContext : ctx.expr()) {
            SQLExpr name = visitExpr(exprContext);
            x.addName(name);
        }

        return x;
    }

    @Override
    public SQLForceKeyHint visitForceKeyHint(MySQLSQLStatementParser.ForceKeyHintContext ctx) {
        SQLForceKeyHint x = new SQLForceKeyHint();

        AbstractSQLIndexHint.SQLForType forType = of(ctx.indexHintType());
        x.setForType(forType);

        for (MySQLSQLStatementParser.ExprContext exprContext : ctx.expr()) {
            SQLExpr name = visitExpr(exprContext);
            x.addName(name);
        }

        return x;
    }

    public AbstractSQLIndexHint.SQLForType of(MySQLSQLStatementParser.IndexHintTypeContext ctx) {
        if (ctx == null) {
            return null;
        }
        AbstractSQLIndexHint.SQLForType x = null;
        if (ctx.JOIN() != null) {
            x = AbstractSQLIndexHint.SQLForType.JOIN;
        } else if (ctx.ORDER() != null) {
            x = AbstractSQLIndexHint.SQLForType.ORDER_BY;
        } else if (ctx.GROUP() != null) {
            x = AbstractSQLIndexHint.SQLForType.GROUP_BY;
        }
        return x;
    }


    public SQLJoinTableReference.SQLJoinType of(MySQLSQLStatementParser.JoinTypeContext ctx) {
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
    public SQLJoinTableReference.SQLJoinOnCondition visitJoinOnCondition(MySQLSQLStatementParser.JoinOnConditionContext ctx) {
        SQLJoinTableReference.SQLJoinOnCondition x = new SQLJoinTableReference.SQLJoinOnCondition();
        SQLExpr condition = visitExpr(ctx.expr());
        x.setCondition(condition);
        return x;
    }

    @Override
    public SQLJoinTableReference.SQLJoinUsingCondition visitJoinUsingCondition(MySQLSQLStatementParser.JoinUsingConditionContext ctx) {
        SQLJoinTableReference.SQLJoinUsingCondition x = new SQLJoinTableReference.SQLJoinUsingCondition();
        for (MySQLSQLStatementParser.ExprContext exprContext : ctx.expr()) {
            SQLExpr expr = visitExpr(exprContext);
            x.addColumn(expr);
        }
        return x;
    }

    @Override
    public SQLWhereClause visitWhereClause(MySQLSQLStatementParser.WhereClauseContext ctx) {
        SQLExpr condition = visitExpr(ctx.expr());
        return new SQLWhereClause(condition);
    }

    @Override
    public SQLGroupByClause visitGroupByClause(MySQLSQLStatementParser.GroupByClauseContext ctx) {
        if (ctx.GROUP() == null
                && ctx.havingClause() == null) {
            return null;
        }

        SQLGroupByClause x = new SQLGroupByClause();
        for (MySQLSQLStatementParser.GroupByItemContext groupByItemContext : ctx.groupByItem()) {
            SQLGroupByClause.SQLGroupByItem groupByElement = visitGroupByItem(groupByItemContext);
            x.addItem(groupByElement);
        }

        MySQLSQLStatementParser.HavingClauseContext havingClauseContext = ctx.havingClause();
        if (havingClauseContext != null) {
            SQLHavingClause havingClause = visitHavingClause(havingClauseContext);
            x.setHavingClause(havingClause);
        }

        return x;
    }

    @Override
    public SQLHavingClause visitHavingClause(MySQLSQLStatementParser.HavingClauseContext ctx) {
        SQLExpr condition = visitExpr(ctx.expr());
        SQLHavingClause x = new SQLHavingClause(condition);
        return x;
    }

    @Override
    public SQLGroupByClause.SQLGroupByItem visitGroupByItem(MySQLSQLStatementParser.GroupByItemContext ctx) {
        SQLExpr expr = (SQLExpr) super.visitChildren(ctx);
        SQLGroupByClause.SQLGroupByItem x = new SQLGroupByClause.SQLGroupByItem(expr);
        return x;
    }

    @Override
    public SQLOrderByClause visitOrderByClause(MySQLSQLStatementParser.OrderByClauseContext ctx) {
        SQLOrderByClause x = new SQLOrderByClause();

        for (MySQLSQLStatementParser.OrderByItemContext orderByItemContext : ctx.orderByItem()) {
            SQLOrderByItem orderByItem = visitOrderByItem(orderByItemContext);
            x.addItem(orderByItem);
        }

        return x;
    }

    @Override
    public SQLOrderByItem visitOrderByItem(MySQLSQLStatementParser.OrderByItemContext ctx) {
        SQLExpr sortKey = visitExpr(ctx.sortKey);
        SQLOrderByItem x = new SQLOrderByItem(sortKey);

        if (ctx.orderingSpecification() != null) {
            SQLOrderingSpecification orderingSpecification = of(ctx.orderingSpecification());
            x.setOrderingSpecification(orderingSpecification.name.ofExpr());
        }

        return x;
    }

    @Override
    public ISQLLimitClause visitLimitOffsetClause(MySQLSQLStatementParser.LimitOffsetClauseContext ctx) {

        SQLExpr limit = visitExpr(ctx.limit);
        boolean offset = ctx.OFFSET() != null;
        SQLExpr offsetExpr = visitExpr(ctx.offset);

        return new SQLLimitOffsetClause(limit, offset, offsetExpr);
    }

    @Override
    public SQLObject visitSelectQueryIntoClause(MySQLSQLStatementParser.SelectQueryIntoClauseContext ctx) {
        return super.visitSelectQueryIntoClause(ctx);
    }

    @Override
    public SQLObject visitSelectQueryIntoDumpFileClause(MySQLSQLStatementParser.SelectQueryIntoDumpFileClauseContext ctx) {
        return super.visitSelectQueryIntoDumpFileClause(ctx);
    }

    @Override
    public SQLObject visitSelectIntoTextFile(MySQLSQLStatementParser.SelectIntoTextFileContext ctx) {
        return super.visitSelectIntoTextFile(ctx);
    }

    @Override
    public SQLForUpdateClause visitForUpdateClause(MySQLSQLStatementParser.ForUpdateClauseContext ctx) {
        SQLForUpdateClause x = new SQLForUpdateClause();

        x.setForType(SQLForUpdateClause.SQLForType.UPDATE);

        for (MySQLSQLStatementParser.ExprContext exprContext : ctx.expr()) {
            SQLExpr column = visitExpr(exprContext);
            x.addColumn(column);
        }

        if (ctx.forUpdateOption() != null) {
            SQLForUpdateClause.SQLForOption forOption = (SQLForUpdateClause.SQLForOption) visit(ctx.forUpdateOption());
            x.setForOption(forOption);
        }
        return x;
    }

    @Override
    public SQLLockInShareModeClause visitLockInShareModeClause(MySQLSQLStatementParser.LockInShareModeClauseContext ctx) {
        return new SQLLockInShareModeClause();
    }

    @Override
    public SQLForUpdateClause.SQLForSkipLockedOption visitForUpdateSkipLockedOption(MySQLSQLStatementParser.ForUpdateSkipLockedOptionContext ctx) {
        return new SQLForUpdateClause.SQLForSkipLockedOption();
    }

    @Override
    public SQLForUpdateClause.SQLForNoWaitOption visitForUpdateNoWaitOption(MySQLSQLStatementParser.ForUpdateNoWaitOptionContext ctx) {
        return new SQLForUpdateClause.SQLForNoWaitOption();
    }

    @Override
    public SQLSelectIntoStatement visitSelectIntoStatement(MySQLSQLStatementParser.SelectIntoStatementContext ctx) {
        SQLSelectIntoStatement x = new SQLSelectIntoStatement(DBType.MySQL);

        SQLSetQuantifier setQuantifier = of(ctx.setQuantifier());
        x.setSetQuantifier(setQuantifier);

        for (MySQLSQLStatementParser.SelectItemContext selectItemContext : ctx.selectItem()) {
            SQLSelectItem selectItem = visitSelectItem(selectItemContext);
            x.addSelectItem(selectItem);
        }

        for (MySQLSQLStatementParser.SelectTargetItemContext selectTargetItemContext : ctx.selectTargetItem()) {
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


        if (ctx.groupByClause() != null) {
            SQLGroupByClause groupByClause = (SQLGroupByClause) visit(ctx.groupByClause());
            x.setGroupByClause(groupByClause);
        }

        if (ctx.orderByClause() != null) {
            SQLOrderByClause orderByClause = visitOrderByClause(ctx.orderByClause());
            x.setOrderByClause(orderByClause);
        }

        if (ctx.limitOffsetClause() != null) {
            ISQLLimitClause limitClause = visitLimitOffsetClause(ctx.limitOffsetClause());
            x.setLimitClause(limitClause);
        }

        if (ctx.iLockClause() != null) {
            ISQLLockClause lockClause = (ISQLLockClause) visit(ctx.iLockClause());
            x.setLockClause(lockClause);
        }

        return x;
    }

    @Override
    public SQLSelectTargetItem visitSelectTargetItem(MySQLSQLStatementParser.SelectTargetItemContext ctx) {
        SQLExpr expr = visitExpr(ctx.expr());
        return new SQLSelectTargetItem(expr);
    }

    @Override
    public SQLInsertStatement visitInsertStatement(MySQLSQLStatementParser.InsertStatementContext ctx) {
        SQLInsertStatement x = new SQLInsertStatement(DBType.MySQL);

        ISQLTableReference tableReference = (ISQLTableReference) visit(ctx.iTableReference());
        x.setTableReference(tableReference);

        for (MySQLSQLStatementParser.ExprContext exprContext : ctx.expr()) {
            SQLExpr column = visitExpr(exprContext);
            x.addColumn(column);
        }

        SQLExpr valueClause = (SQLExpr) visit(ctx.iValueClause());
        x.setValuesClause(valueClause);

        if (ctx.onDuplicateKeyUpdateClause() != null) {
            SQLOnDuplicateKeyUpdateClause onDuplicateKeyUpdateClause = visitOnDuplicateKeyUpdateClause(ctx.onDuplicateKeyUpdateClause());
            x.setOnDuplicateKeyUpdateClause(onDuplicateKeyUpdateClause);
        }
        return x;
    }

    @Override
    public SQLValuesClause visitValuesClause(MySQLSQLStatementParser.ValuesClauseContext ctx) {
        SQLValuesClause x = new SQLValuesClause();

        if (ctx.VALUE() != null) {
            x.setValues(SQLReserved.VALUE);
        }

        for (MySQLSQLStatementParser.ValuesClauseItemContext valuesClauseItemContext : ctx.valuesClauseItem()) {
            SQLValuesClause.SQLValuesItem item = visitValuesClauseItem(valuesClauseItemContext);
            x.addValue(item);
        }

        return x;
    }

    @Override
    public SQLValuesClause.SQLValuesItem visitValuesClauseItem(MySQLSQLStatementParser.ValuesClauseItemContext ctx) {
        SQLValuesClause.SQLValuesItem x = new SQLValuesClause.SQLValuesItem();

        for (MySQLSQLStatementParser.ExprContext exprContext : ctx.expr()) {
            SQLExpr column = visitExpr(exprContext);
            x.addColumn(column);
        }
        return x;
    }

    @Override
    public SQLOnDuplicateKeyUpdateClause visitOnDuplicateKeyUpdateClause(MySQLSQLStatementParser.OnDuplicateKeyUpdateClauseContext ctx) {
        SQLOnDuplicateKeyUpdateClause x = new SQLOnDuplicateKeyUpdateClause();
        for (MySQLSQLStatementParser.AssignmentExprContext assignmentExprContext : ctx.assignmentExpr()) {
            SQLAssignmentExpr item = visitAssignmentExpr(assignmentExprContext);
            x.addItem(item);
        }
        return x;
    }

    @Override
    public SQLUpdateStatement visitUpdateStatement(MySQLSQLStatementParser.UpdateStatementContext ctx) {
        SQLUpdateStatement x = new SQLUpdateStatement(DBType.MySQL);

        ISQLTableReference tableReference = (ISQLTableReference) visit(ctx.iTableReference());
        x.setTableReference(tableReference);

        ISQLUpdateSetClause updateSetClause = visitUpdateSetClause(ctx.updateSetClause());
        x.setUpdateSetClause(updateSetClause);

        if (ctx.whereClause() != null) {
            SQLWhereClause whereClause = visitWhereClause(ctx.whereClause());
            x.setWhereClause(whereClause);
        }

        if (ctx.orderByClause() != null) {
            SQLOrderByClause orderByClause = visitOrderByClause(ctx.orderByClause());
            x.setOrderByClause(orderByClause);
        }
        if (ctx.limitOffsetClause() != null) {
            ISQLLimitClause limitClause = visitLimitOffsetClause(ctx.limitOffsetClause());
            x.setLimitClause(limitClause);
        }

        return x;
    }

    @Override
    public SQLUpdateSetClause visitUpdateSetClause(MySQLSQLStatementParser.UpdateSetClauseContext ctx) {
        SQLUpdateSetClause x = new SQLUpdateSetClause();

        for (MySQLSQLStatementParser.UpdateSetItemClauseContext updateSetItemClauseContext : ctx.updateSetItemClause()) {
            SQLUpdateSetClause.SQLUpdateSetItemClause item = visitUpdateSetItemClause(updateSetItemClauseContext);
            x.addItem(item);
        }

        return x;
    }

    @Override
    public SQLUpdateSetClause.SQLUpdateSetItemClause visitUpdateSetItemClause(MySQLSQLStatementParser.UpdateSetItemClauseContext ctx) {
        SQLExpr column = visitExpr(ctx.column);
        SQLExpr value = visitExpr(ctx.value);

        return new SQLUpdateSetClause.SQLUpdateSetItemClause(column, value);
    }

    @Override
    public SQLDeleteStatement visitDeleteStatement(MySQLSQLStatementParser.DeleteStatementContext ctx) {
        SQLDeleteStatement x = new SQLDeleteStatement(DBType.MySQL);

        if (ctx.FROM() != null) {
            x.setFrom(true);
        }

        ISQLTableReference tableReference = (ISQLTableReference) visit(ctx.iTableReference());
        x.setTableReference(tableReference);


        if (ctx.whereClause() != null) {
            SQLWhereClause whereClause = visitWhereClause(ctx.whereClause());
            x.setWhereClause(whereClause);
        }

        if (ctx.orderByClause() != null) {
            SQLOrderByClause orderByClause = visitOrderByClause(ctx.orderByClause());
            x.setOrderByClause(orderByClause);
        }
        if (ctx.limitOffsetClause() != null) {
            ISQLLimitClause limitClause = visitLimitOffsetClause(ctx.limitOffsetClause());
            x.setLimitClause(limitClause);
        }

        return x;
    }

    @Override
    public SQLObject visitDeleteStatementUsingClause(MySQLSQLStatementParser.DeleteStatementUsingClauseContext ctx) {
        return super.visitDeleteStatementUsingClause(ctx);
    }

    @Override
    public SQLReplaceStatement visitReplaceStatement(MySQLSQLStatementParser.ReplaceStatementContext ctx) {
        SQLReplaceStatement x = new SQLReplaceStatement(DBType.MySQL);

        if (ctx.priority() != null) {
            SQLPriorityType priority = of(ctx.priority());
            x.setPriority(priority);
        }

        if (ctx.INTO() != null) {
            x.setInto(true);
        }

        ISQLTableReference tableReference = (ISQLTableReference) visitChildren(ctx.iTableReference());
        x.setTableReference(tableReference);

        for (MySQLSQLStatementParser.ExprContext columnContext : ctx.columns) {
            SQLExpr column = visitExpr(columnContext);
            x.addColumn(column);
        }

        SQLExpr valuesClause = (SQLExpr) visitChildren(ctx.replaceStatementValuseClause());
        x.setValuesClause(valuesClause);

        return x;
    }


    @Override
    public SQLCallStatement visitCallStatement(MySQLSQLStatementParser.CallStatementContext ctx) {
        SQLCallStatement x = new SQLCallStatement(DBType.MySQL);
        SQLExpr expr = visitExpr(ctx.expr());
        x.setExpr(expr);
        return x;
    }

    @Override
    public SQLLoadDataStatement visitLoadDataInfileStatement(MySQLSQLStatementParser.LoadDataInfileStatementContext ctx) {
        SQLLoadDataStatement x = new SQLLoadDataStatement(DBType.MySQL);

        return x;
    }

    @Override
    public SQLLoadXmlStatement visitLoadXmlStatement(MySQLSQLStatementParser.LoadXmlStatementContext ctx) {
        SQLLoadXmlStatement x = new SQLLoadXmlStatement(DBType.MySQL);

        return x;
    }

    @Override
    public SQLDoStatement visitDoStatement(MySQLSQLStatementParser.DoStatementContext ctx) {
        SQLDoStatement x = new SQLDoStatement(DBType.MySQL);

        return x;
    }

    @Override
    public SQLHandlerOpenStatement visitHandlerOpenStatement(MySQLSQLStatementParser.HandlerOpenStatementContext ctx) {
        SQLHandlerOpenStatement x = new SQLHandlerOpenStatement(DBType.MySQL);
        SQLName name = visitNameIdentifier(ctx.name);
        x.setName(name);

        if (ctx.AS() != null) {
            x.setAs(true);
        }

        if (ctx.alias != null) {
            SQLName alias = visitNameIdentifier(ctx.alias);
            x.setAlias(alias);
        }

        return x;
    }

    @Override
    public SQLHandlerReadStatement visitHandlerReadStatement(MySQLSQLStatementParser.HandlerReadStatementContext ctx) {
        SQLHandlerReadStatement x = new SQLHandlerReadStatement(DBType.MySQL);
        SQLName name = visitNameIdentifier(ctx.name);
        x.setName(name);
        return x;
    }

    @Override
    public SQLHandlerCloseStatement visitHandlerCloseStatement(MySQLSQLStatementParser.HandlerCloseStatementContext ctx) {
        SQLHandlerCloseStatement x = new SQLHandlerCloseStatement(DBType.MySQL);
        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);
        return x;
    }

    @Override
    public SQLObject visitSelectFieldsInto(MySQLSQLStatementParser.SelectFieldsIntoContext ctx) {
        return super.visitSelectFieldsInto(ctx);
    }

    @Override
    public SQLObject visitSelectLinesInto(MySQLSQLStatementParser.SelectLinesIntoContext ctx) {
        return super.visitSelectLinesInto(ctx);
    }

    @Override
    public SQLObject visitStartTransaction(MySQLSQLStatementParser.StartTransactionContext ctx) {
        return super.visitStartTransaction(ctx);
    }

    @Override
    public SQLObject visitTransactionMode(MySQLSQLStatementParser.TransactionModeContext ctx) {
        return super.visitTransactionMode(ctx);
    }

    @Override
    public SQLObject visitBeginWork(MySQLSQLStatementParser.BeginWorkContext ctx) {
        return super.visitBeginWork(ctx);
    }

    @Override
    public SQLObject visitCommitWork(MySQLSQLStatementParser.CommitWorkContext ctx) {
        return super.visitCommitWork(ctx);
    }

    @Override
    public SQLObject visitRollbackWork(MySQLSQLStatementParser.RollbackWorkContext ctx) {
        return super.visitRollbackWork(ctx);
    }

    @Override
    public SQLObject visitSavepointStatement(MySQLSQLStatementParser.SavepointStatementContext ctx) {
        return super.visitSavepointStatement(ctx);
    }

    @Override
    public SQLObject visitRollbackStatement(MySQLSQLStatementParser.RollbackStatementContext ctx) {
        return super.visitRollbackStatement(ctx);
    }

    @Override
    public SQLObject visitReleaseStatement(MySQLSQLStatementParser.ReleaseStatementContext ctx) {
        return super.visitReleaseStatement(ctx);
    }

    @Override
    public SQLLockTableStatement visitLockTablesStatement(MySQLSQLStatementParser.LockTablesStatementContext ctx) {
        SQLLockTableStatement x = new SQLLockTableStatement(DBType.MySQL);

        x.setType(SQLLockTableStatement.SQLType.TABLES);
        for (MySQLSQLStatementParser.LockTableItemContext lockTableItemContext : ctx.lockTableItem()) {
            SQLLockTableStatement.SQLLockTableItem item = visitLockTableItem(lockTableItemContext);
            x.addItem(item);
        }

        return x;
    }

    @Override
    public SQLLockTableStatement.SQLLockTableItem visitLockTableItem(MySQLSQLStatementParser.LockTableItemContext ctx) {
        SQLLockTableStatement.SQLLockTableItem x = new SQLLockTableStatement.SQLLockTableItem();
        SQLName name = visitNameIdentifier(ctx.name);
        x.setName(name);

        if (ctx.AS() != null) {
            x.setAs(true);
        }

        if (ctx.alias != null) {
            SQLName alias = visitNameIdentifier(ctx.alias);
            x.setAlias(alias);
        }

        if (ctx.lockAction() != null) {
            SQLLockTableStatement.SQLLockType lockType = of(ctx.lockAction());
            x.setLockType(lockType);
        }
        return x;
    }

    public SQLLockTableStatement.SQLLockType of(MySQLSQLStatementParser.LockActionContext ctx) {
        if (ctx == null) {
            return null;
        }

        SQLLockTableStatement.SQLLockType x = null;
        if (ctx.READ() != null) {
            x = SQLLockTableStatement.SQLLockType.READ;
            if (ctx.LOCAL() != null) {
                x = SQLLockTableStatement.SQLLockType.READ_LOCAL;
            }
        } else if (ctx.WRITE() != null) {
            x = SQLLockTableStatement.SQLLockType.WRITE;
            if (ctx.LOW_PRIORITY() != null) {
                x = SQLLockTableStatement.SQLLockType.LOW_PRIORITY_WRITE;
            }
        }
        return x;
    }

    @Override
    public SQLUnLockTablesStatement visitUnlockTablesStatement(MySQLSQLStatementParser.UnlockTablesStatementContext ctx) {
        return new SQLUnLockTablesStatement(DBType.MySQL);
    }

    @Override
    public SQLObject visitSetAutoCommitStatement(MySQLSQLStatementParser.SetAutoCommitStatementContext ctx) {
        return super.visitSetAutoCommitStatement(ctx);
    }

    @Override
    public SQLObject visitTransactionOption(MySQLSQLStatementParser.TransactionOptionContext ctx) {
        return super.visitTransactionOption(ctx);
    }

    @Override
    public SQLObject visitTransactionLevel(MySQLSQLStatementParser.TransactionLevelContext ctx) {
        return super.visitTransactionLevel(ctx);
    }

    @Override
    public SQLObject visitChangeMaster(MySQLSQLStatementParser.ChangeMasterContext ctx) {
        return super.visitChangeMaster(ctx);
    }

    @Override
    public SQLObject visitChangeReplicationFilter(MySQLSQLStatementParser.ChangeReplicationFilterContext ctx) {
        return super.visitChangeReplicationFilter(ctx);
    }

    @Override
    public SQLObject visitPurgeBinaryLogs(MySQLSQLStatementParser.PurgeBinaryLogsContext ctx) {
        return super.visitPurgeBinaryLogs(ctx);
    }

    @Override
    public SQLObject visitResetMaster(MySQLSQLStatementParser.ResetMasterContext ctx) {
        return super.visitResetMaster(ctx);
    }

    @Override
    public SQLObject visitResetSlave(MySQLSQLStatementParser.ResetSlaveContext ctx) {
        return super.visitResetSlave(ctx);
    }

    @Override
    public SQLObject visitStartSlave(MySQLSQLStatementParser.StartSlaveContext ctx) {
        return super.visitStartSlave(ctx);
    }

    @Override
    public SQLObject visitStopSlave(MySQLSQLStatementParser.StopSlaveContext ctx) {
        return super.visitStopSlave(ctx);
    }

    @Override
    public SQLObject visitStartGroupReplication(MySQLSQLStatementParser.StartGroupReplicationContext ctx) {
        return super.visitStartGroupReplication(ctx);
    }

    @Override
    public SQLObject visitStopGroupReplication(MySQLSQLStatementParser.StopGroupReplicationContext ctx) {
        return super.visitStopGroupReplication(ctx);
    }

    @Override
    public SQLObject visitMasterStringOption(MySQLSQLStatementParser.MasterStringOptionContext ctx) {
        return super.visitMasterStringOption(ctx);
    }

    @Override
    public SQLObject visitMasterDecimalOption(MySQLSQLStatementParser.MasterDecimalOptionContext ctx) {
        return super.visitMasterDecimalOption(ctx);
    }

    @Override
    public SQLObject visitMasterBoolOption(MySQLSQLStatementParser.MasterBoolOptionContext ctx) {
        return super.visitMasterBoolOption(ctx);
    }

    @Override
    public SQLObject visitMasterRealOption(MySQLSQLStatementParser.MasterRealOptionContext ctx) {
        return super.visitMasterRealOption(ctx);
    }

    @Override
    public SQLObject visitMaster(MySQLSQLStatementParser.MasterContext ctx) {
        return super.visitMaster(ctx);
    }

    @Override
    public SQLObject visitStringMasterOption(MySQLSQLStatementParser.StringMasterOptionContext ctx) {
        return super.visitStringMasterOption(ctx);
    }

    @Override
    public SQLObject visitDecimalMasterOption(MySQLSQLStatementParser.DecimalMasterOptionContext ctx) {
        return super.visitDecimalMasterOption(ctx);
    }

    @Override
    public SQLObject visitBoolMasterOption(MySQLSQLStatementParser.BoolMasterOptionContext ctx) {
        return super.visitBoolMasterOption(ctx);
    }

    @Override
    public SQLObject visitChannelOption(MySQLSQLStatementParser.ChannelOptionContext ctx) {
        return super.visitChannelOption(ctx);
    }

    @Override
    public SQLObject visitDoDbReplication(MySQLSQLStatementParser.DoDbReplicationContext ctx) {
        return super.visitDoDbReplication(ctx);
    }

    @Override
    public SQLObject visitIgnoreDbReplication(MySQLSQLStatementParser.IgnoreDbReplicationContext ctx) {
        return super.visitIgnoreDbReplication(ctx);
    }

    @Override
    public SQLObject visitDoTableReplication(MySQLSQLStatementParser.DoTableReplicationContext ctx) {
        return super.visitDoTableReplication(ctx);
    }

    @Override
    public SQLObject visitIgnoreTableReplication(MySQLSQLStatementParser.IgnoreTableReplicationContext ctx) {
        return super.visitIgnoreTableReplication(ctx);
    }

    @Override
    public SQLObject visitWildDoTableReplication(MySQLSQLStatementParser.WildDoTableReplicationContext ctx) {
        return super.visitWildDoTableReplication(ctx);
    }

    @Override
    public SQLObject visitWildIgnoreTableReplication(MySQLSQLStatementParser.WildIgnoreTableReplicationContext ctx) {
        return super.visitWildIgnoreTableReplication(ctx);
    }

    @Override
    public SQLObject visitRewriteDbReplication(MySQLSQLStatementParser.RewriteDbReplicationContext ctx) {
        return super.visitRewriteDbReplication(ctx);
    }

    @Override
    public SQLObject visitTablePair(MySQLSQLStatementParser.TablePairContext ctx) {
        return super.visitTablePair(ctx);
    }

    @Override
    public SQLObject visitThreadType(MySQLSQLStatementParser.ThreadTypeContext ctx) {
        return super.visitThreadType(ctx);
    }

    @Override
    public SQLObject visitGtidsUntilOption(MySQLSQLStatementParser.GtidsUntilOptionContext ctx) {
        return super.visitGtidsUntilOption(ctx);
    }

    @Override
    public SQLObject visitMasterLogUntilOption(MySQLSQLStatementParser.MasterLogUntilOptionContext ctx) {
        return super.visitMasterLogUntilOption(ctx);
    }

    @Override
    public SQLObject visitRelayLogUntilOption(MySQLSQLStatementParser.RelayLogUntilOptionContext ctx) {
        return super.visitRelayLogUntilOption(ctx);
    }

    @Override
    public SQLObject visitSqlGapsUntilOption(MySQLSQLStatementParser.SqlGapsUntilOptionContext ctx) {
        return super.visitSqlGapsUntilOption(ctx);
    }

    @Override
    public SQLObject visitUserConnectionOption(MySQLSQLStatementParser.UserConnectionOptionContext ctx) {
        return super.visitUserConnectionOption(ctx);
    }

    @Override
    public SQLObject visitPasswordConnectionOption(MySQLSQLStatementParser.PasswordConnectionOptionContext ctx) {
        return super.visitPasswordConnectionOption(ctx);
    }

    @Override
    public SQLObject visitDefaultAuthConnectionOption(MySQLSQLStatementParser.DefaultAuthConnectionOptionContext ctx) {
        return super.visitDefaultAuthConnectionOption(ctx);
    }

    @Override
    public SQLObject visitPluginDirConnectionOption(MySQLSQLStatementParser.PluginDirConnectionOptionContext ctx) {
        return super.visitPluginDirConnectionOption(ctx);
    }

    @Override
    public SQLObject visitGtnameIdentifierSet(MySQLSQLStatementParser.GtnameIdentifierSetContext ctx) {
        return super.visitGtnameIdentifierSet(ctx);
    }

    @Override
    public SQLObject visitXaStartTransaction(MySQLSQLStatementParser.XaStartTransactionContext ctx) {
        return super.visitXaStartTransaction(ctx);
    }

    @Override
    public SQLObject visitXaEndTransaction(MySQLSQLStatementParser.XaEndTransactionContext ctx) {
        return super.visitXaEndTransaction(ctx);
    }

    @Override
    public SQLObject visitXaPrepareStatement(MySQLSQLStatementParser.XaPrepareStatementContext ctx) {
        return super.visitXaPrepareStatement(ctx);
    }

    @Override
    public SQLObject visitXaCommitWork(MySQLSQLStatementParser.XaCommitWorkContext ctx) {
        return super.visitXaCommitWork(ctx);
    }

    @Override
    public SQLObject visitXaRollbackWork(MySQLSQLStatementParser.XaRollbackWorkContext ctx) {
        return super.visitXaRollbackWork(ctx);
    }

    @Override
    public SQLObject visitXaRecoverWork(MySQLSQLStatementParser.XaRecoverWorkContext ctx) {
        return super.visitXaRecoverWork(ctx);
    }

    @Override
    public SQLObject visitPrepareStatement(MySQLSQLStatementParser.PrepareStatementContext ctx) {
        return super.visitPrepareStatement(ctx);
    }

    @Override
    public SQLObject visitExecuteStatement(MySQLSQLStatementParser.ExecuteStatementContext ctx) {
        return super.visitExecuteStatement(ctx);
    }

    @Override
    public SQLObject visitDeallocatePrepare(MySQLSQLStatementParser.DeallocatePrepareContext ctx) {
        return super.visitDeallocatePrepare(ctx);
    }

    @Override
    public SQLObject visitStatementItem(MySQLSQLStatementParser.StatementItemContext ctx) {
        SQLObject x = visitStatement(ctx.statement());
        if (ctx.SEMI() != null) {
            x.setAfterSemi(true);
        }
        return x;
    }

    @Override
    public SQLBody visitBody(MySQLSQLStatementParser.BodyContext ctx) {
        SQLBody x = new SQLBody();
        if (ctx.beginName != null) {
            SQLName beginName = visitNameIdentifier(ctx.beginName);
            x.setBeginLabel(beginName);
        }

        for (MySQLSQLStatementParser.BodyItemContext bodyItemContext : ctx.bodyItem()) {
            SQLBody.SQLBodyItem item = visitBodyItem(bodyItemContext);
            x.addBodyItem(item);
        }

        if (ctx.endName != null) {
            SQLName endName = visitNameIdentifier(ctx.endName);
            x.setEndName(endName);
        }

        return x;
    }

    @Override
    public SQLBody.SQLBodyItem visitBodyItem(MySQLSQLStatementParser.BodyItemContext ctx) {
        SQLBody.SQLBodyItem x = new SQLBody.SQLBodyItem();

        SQLObject statement = visitBodyItemStatement(ctx.bodyItemStatement());
        x.setStatement(statement);

        if (ctx.SEMI() != null) {
            statement.setAfterSemi(true);
        }

        return x;
    }

    @Override
    public SQLObject visitBodyItemStatement(MySQLSQLStatementParser.BodyItemStatementContext ctx) {
        return super.visitBodyItemStatement(ctx);
    }

    @Override
    public SQLCaseStatement visitCaseStatement(MySQLSQLStatementParser.CaseStatementContext ctx) {
        SQLCaseStatement x = new SQLCaseStatement(DBType.MySQL);
        if (ctx.expr() != null) {
            SQLExpr selector = visitExpr(ctx.expr());
            x.setSelector(selector);
        }

        for (MySQLSQLStatementParser.CaseStatementWhenItemContext caseStatementWhenItemContext : ctx.caseStatementWhenItem()) {
            SQLCaseStatement.SQLCaseStatementWhenItem whenItem = visitCaseStatementWhenItem(caseStatementWhenItemContext);
            x.addWhenItem(whenItem);
        }

        if (ctx.caseStatementElseClause() != null) {
            SQLCaseStatement.SQLCaseStatementElseClause elseClause = visitCaseStatementElseClause(ctx.caseStatementElseClause());
            x.setElseClause(elseClause);
        }

        return x;
    }

    @Override
    public SQLCaseStatement.SQLCaseStatementWhenItem visitCaseStatementWhenItem(MySQLSQLStatementParser.CaseStatementWhenItemContext ctx) {
        SQLCaseStatement.SQLCaseStatementWhenItem x = new SQLCaseStatement.SQLCaseStatementWhenItem();

        SQLExpr expr = visitExpr(ctx.expr());
        x.setExpr(expr);

        SQLObject stmt = visitStatementItem(ctx.statementItem());
        x.setStatement(stmt);

        return x;
    }

    @Override
    public SQLCaseStatement.SQLCaseStatementElseClause visitCaseStatementElseClause(MySQLSQLStatementParser.CaseStatementElseClauseContext ctx) {
        SQLCaseStatement.SQLCaseStatementElseClause x = new SQLCaseStatement.SQLCaseStatementElseClause();

        for (MySQLSQLStatementParser.StatementItemContext statementItemContext : ctx.statementItem()) {
            SQLObject stmt = visitStatementItem(statementItemContext);
            x.addStatement(stmt);
        }

        return x;
    }

    @Override
    public SQLIfStatement visitIfStatement(MySQLSQLStatementParser.IfStatementContext ctx) {
        SQLIfStatement x = new SQLIfStatement(DBType.MySQL);

        SQLExpr condition = visitExpr(ctx.expr());
        x.setCondition(condition);
        for (MySQLSQLStatementParser.StatementItemContext statementItemContext : ctx.then) {
            SQLObject statement = visitStatementItem(statementItemContext);
            x.addStatement(statement);
        }

        for (MySQLSQLStatementParser.ElseIfContext elseIfContext : ctx.elseIf()) {
            SQLIfStatement.SQLElseIf elseIf = visitElseIf(elseIfContext);
            x.addElseIf(elseIf);
        }

        for (MySQLSQLStatementParser.StatementItemContext statementItemContext : ctx.else_) {
            SQLObject statement = visitStatementItem(statementItemContext);
            x.addElseStatement(statement);
        }
        return x;
    }

    @Override
    public SQLIfStatement.SQLElseIf visitElseIf(MySQLSQLStatementParser.ElseIfContext ctx) {
        SQLIfStatement.SQLElseIf x = new SQLIfStatement.SQLElseIf();
        SQLExpr condition = visitExpr(ctx.expr());
        x.setCondition(condition);
        for (MySQLSQLStatementParser.StatementItemContext statementItemContext : ctx.statementItem()) {
            SQLObject statement = visitStatementItem(statementItemContext);
            x.addStatement(statement);
        }
        return x;
    }

    @Override
    public SQLIterateStatement visitIterateStatement(MySQLSQLStatementParser.IterateStatementContext ctx) {
        SQLIterateStatement x = new SQLIterateStatement(DBType.MySQL);
        return x;
    }

    @Override
    public SQLLeaveStatement visitLeaveStatement(MySQLSQLStatementParser.LeaveStatementContext ctx) {
        SQLLeaveStatement x = new SQLLeaveStatement(DBType.MySQL);
        return x;
    }

    @Override
    public SQLLoopStatement visitLoopStatement(MySQLSQLStatementParser.LoopStatementContext ctx) {
        SQLLoopStatement x = new SQLLoopStatement(DBType.MySQL);
        return x;
    }

    @Override
    public SQLRepeatStatement visitRepeatStatement(MySQLSQLStatementParser.RepeatStatementContext ctx) {
        SQLRepeatStatement x = new SQLRepeatStatement(DBType.MySQL);
        return x;
    }

    @Override
    public SQLReturnStatement visitReturnStatement(MySQLSQLStatementParser.ReturnStatementContext ctx) {
        SQLReturnStatement x = new SQLReturnStatement(DBType.MySQL);
        return x;
    }

    @Override
    public SQLWhileStatement visitWhileStatement(MySQLSQLStatementParser.WhileStatementContext ctx) {
        SQLWhileStatement x = new SQLWhileStatement(DBType.MySQL);
        return x;
    }

    @Override
    public SQLObject visitCloseCursor(MySQLSQLStatementParser.CloseCursorContext ctx) {
        SQLReturnStatement x = new SQLReturnStatement(DBType.MySQL);
        return x;
    }

    @Override
    public SQLObject visitFetchCursor(MySQLSQLStatementParser.FetchCursorContext ctx) {
        return super.visitFetchCursor(ctx);
    }

    @Override
    public SQLObject visitOpenCursor(MySQLSQLStatementParser.OpenCursorContext ctx) {
        return super.visitOpenCursor(ctx);
    }

    @Override
    public SQLObject visitDeclareVariable(MySQLSQLStatementParser.DeclareVariableContext ctx) {
        return super.visitDeclareVariable(ctx);
    }

    @Override
    public SQLObject visitDeclareCondition(MySQLSQLStatementParser.DeclareConditionContext ctx) {
        return super.visitDeclareCondition(ctx);
    }

    @Override
    public SQLObject visitDeclareCursor(MySQLSQLStatementParser.DeclareCursorContext ctx) {
        return super.visitDeclareCursor(ctx);
    }

    @Override
    public SQLObject visitDeclareHandler(MySQLSQLStatementParser.DeclareHandlerContext ctx) {
        return super.visitDeclareHandler(ctx);
    }

    @Override
    public SQLObject visitHandlerConditionCode(MySQLSQLStatementParser.HandlerConditionCodeContext ctx) {
        return super.visitHandlerConditionCode(ctx);
    }

    @Override
    public SQLObject visitHandlerConditionState(MySQLSQLStatementParser.HandlerConditionStateContext ctx) {
        return super.visitHandlerConditionState(ctx);
    }

    @Override
    public SQLObject visitHandlerConditionName(MySQLSQLStatementParser.HandlerConditionNameContext ctx) {
        return super.visitHandlerConditionName(ctx);
    }

    @Override
    public SQLObject visitHandlerConditionWarning(MySQLSQLStatementParser.HandlerConditionWarningContext ctx) {
        return super.visitHandlerConditionWarning(ctx);
    }

    @Override
    public SQLObject visitHandlerConditionNotfound(MySQLSQLStatementParser.HandlerConditionNotfoundContext ctx) {
        return super.visitHandlerConditionNotfound(ctx);
    }

    @Override
    public SQLObject visitHandlerConditionException(MySQLSQLStatementParser.HandlerConditionExceptionContext ctx) {
        return super.visitHandlerConditionException(ctx);
    }

    @Override
    public SQLObject visitAlterUserMysqlV56(MySQLSQLStatementParser.AlterUserMysqlV56Context ctx) {
        return super.visitAlterUserMysqlV56(ctx);
    }

    @Override
    public SQLObject visitAlterUserMysqlV57(MySQLSQLStatementParser.AlterUserMysqlV57Context ctx) {
        return super.visitAlterUserMysqlV57(ctx);
    }

    @Override
    public SQLObject visitDropUserStatement(MySQLSQLStatementParser.DropUserStatementContext ctx) {
        return super.visitDropUserStatement(ctx);
    }

    @Override
    public SQLObject visitGrantStatement(MySQLSQLStatementParser.GrantStatementContext ctx) {
        return super.visitGrantStatement(ctx);
    }

    @Override
    public SQLObject visitGrantProxy(MySQLSQLStatementParser.GrantProxyContext ctx) {
        return super.visitGrantProxy(ctx);
    }

    @Override
    public SQLObject visitRenameUser(MySQLSQLStatementParser.RenameUserContext ctx) {
        return super.visitRenameUser(ctx);
    }

    @Override
    public SQLObject visitDetailRevoke(MySQLSQLStatementParser.DetailRevokeContext ctx) {
        return super.visitDetailRevoke(ctx);
    }

    @Override
    public SQLObject visitShortRevoke(MySQLSQLStatementParser.ShortRevokeContext ctx) {
        return super.visitShortRevoke(ctx);
    }

    @Override
    public SQLObject visitRevokeProxy(MySQLSQLStatementParser.RevokeProxyContext ctx) {
        return super.visitRevokeProxy(ctx);
    }

    @Override
    public SQLObject visitUserSpecification(MySQLSQLStatementParser.UserSpecificationContext ctx) {
        return super.visitUserSpecification(ctx);
    }

    @Override
    public SQLObject visitPasswordAuthOption(MySQLSQLStatementParser.PasswordAuthOptionContext ctx) {
        return super.visitPasswordAuthOption(ctx);
    }

    @Override
    public SQLObject visitStringAuthOption(MySQLSQLStatementParser.StringAuthOptionContext ctx) {
        return super.visitStringAuthOption(ctx);
    }

    @Override
    public SQLObject visitHashAuthOption(MySQLSQLStatementParser.HashAuthOptionContext ctx) {
        return super.visitHashAuthOption(ctx);
    }

    @Override
    public SQLObject visitSimpleAuthOption(MySQLSQLStatementParser.SimpleAuthOptionContext ctx) {
        return super.visitSimpleAuthOption(ctx);
    }

    @Override
    public SQLObject visitTlsOption(MySQLSQLStatementParser.TlsOptionContext ctx) {
        return super.visitTlsOption(ctx);
    }

    @Override
    public SQLObject visitUserResourceOption(MySQLSQLStatementParser.UserResourceOptionContext ctx) {
        return super.visitUserResourceOption(ctx);
    }

    @Override
    public SQLObject visitUserPasswordOption(MySQLSQLStatementParser.UserPasswordOptionContext ctx) {
        return super.visitUserPasswordOption(ctx);
    }

    @Override
    public SQLObject visitUserLockOption(MySQLSQLStatementParser.UserLockOptionContext ctx) {
        return super.visitUserLockOption(ctx);
    }

    @Override
    public SQLObject visitPrivelegeClause(MySQLSQLStatementParser.PrivelegeClauseContext ctx) {
        return super.visitPrivelegeClause(ctx);
    }

    @Override
    public SQLObject visitPrivilege(MySQLSQLStatementParser.PrivilegeContext ctx) {
        return super.visitPrivilege(ctx);
    }

    @Override
    public SQLObject visitCurrentSchemaPriviLevel(MySQLSQLStatementParser.CurrentSchemaPriviLevelContext ctx) {
        return super.visitCurrentSchemaPriviLevel(ctx);
    }

    @Override
    public SQLObject visitGlobalPrivLevel(MySQLSQLStatementParser.GlobalPrivLevelContext ctx) {
        return super.visitGlobalPrivLevel(ctx);
    }

    @Override
    public SQLObject visitDefiniteSchemaPrivLevel(MySQLSQLStatementParser.DefiniteSchemaPrivLevelContext ctx) {
        return super.visitDefiniteSchemaPrivLevel(ctx);
    }

    @Override
    public SQLObject visitDefiniteFullTablePrivLevel(MySQLSQLStatementParser.DefiniteFullTablePrivLevelContext ctx) {
        return super.visitDefiniteFullTablePrivLevel(ctx);
    }

    @Override
    public SQLObject visitDefiniteTablePrivLevel(MySQLSQLStatementParser.DefiniteTablePrivLevelContext ctx) {
        return super.visitDefiniteTablePrivLevel(ctx);
    }

    @Override
    public SQLObject visitRenameUserClause(MySQLSQLStatementParser.RenameUserClauseContext ctx) {
        return super.visitRenameUserClause(ctx);
    }

    @Override
    public SQLObject visitAnalyzeTable(MySQLSQLStatementParser.AnalyzeTableContext ctx) {
        return super.visitAnalyzeTable(ctx);
    }

    @Override
    public SQLObject visitCheckTable(MySQLSQLStatementParser.CheckTableContext ctx) {
        return super.visitCheckTable(ctx);
    }

    @Override
    public SQLObject visitChecksumTable(MySQLSQLStatementParser.ChecksumTableContext ctx) {
        return super.visitChecksumTable(ctx);
    }

    @Override
    public SQLObject visitOptimizeTable(MySQLSQLStatementParser.OptimizeTableContext ctx) {
        return super.visitOptimizeTable(ctx);
    }

    @Override
    public SQLObject visitRepairTable(MySQLSQLStatementParser.RepairTableContext ctx) {
        return super.visitRepairTable(ctx);
    }

    @Override
    public SQLObject visitCheckTableOption(MySQLSQLStatementParser.CheckTableOptionContext ctx) {
        return super.visitCheckTableOption(ctx);
    }

    @Override
    public SQLObject visitCreateUdfunction(MySQLSQLStatementParser.CreateUdfunctionContext ctx) {
        return super.visitCreateUdfunction(ctx);
    }

    @Override
    public SQLObject visitInstallPlugin(MySQLSQLStatementParser.InstallPluginContext ctx) {
        return super.visitInstallPlugin(ctx);
    }

    @Override
    public SQLObject visitUninstallPlugin(MySQLSQLStatementParser.UninstallPluginContext ctx) {
        return super.visitUninstallPlugin(ctx);
    }

    @Override
    public SQLObject visitSetDefaultRoleStatement(MySQLSQLStatementParser.SetDefaultRoleStatementContext ctx) {
        return super.visitSetDefaultRoleStatement(ctx);
    }

    @Override
    public SQLSetPasswordStatement visitSetPasswordStatement(MySQLSQLStatementParser.SetPasswordStatementContext ctx) {
        SQLSetPasswordStatement x = new SQLSetPasswordStatement(DBType.MySQL);

        return x;
    }

    @Override
    public SQLSetVariableStatement visitSetVariableStatement(MySQLSQLStatementParser.SetVariableStatementContext ctx) {
        SQLSetVariableStatement x = new SQLSetVariableStatement(DBType.MySQL);

        for (MySQLSQLStatementParser.AssignmentExprContext assignmentExprContext : ctx.assignmentExpr()) {
            SQLAssignmentExpr item = visitAssignmentExpr(assignmentExprContext);
            x.addItem(item);
        }

        return x;
    }

    @Override
    public SQLObject visitSetCharacterSetStatement(MySQLSQLStatementParser.SetCharacterSetStatementContext ctx) {
        return super.visitSetCharacterSetStatement(ctx);
    }

    @Override
    public SQLObject visitSetCharsetStatement(MySQLSQLStatementParser.SetCharsetStatementContext ctx) {
        return super.visitSetCharsetStatement(ctx);
    }

    @Override
    public SQLObject visitSetNamesStatement(MySQLSQLStatementParser.SetNamesStatementContext ctx) {
        return super.visitSetNamesStatement(ctx);
    }

    @Override
    public SQLObject visitSetTransactionStatement(MySQLSQLStatementParser.SetTransactionStatementContext ctx) {
        return super.visitSetTransactionStatement(ctx);
    }

    @Override
    public SQLObject visitSetAutocommit(MySQLSQLStatementParser.SetAutocommitContext ctx) {
        return super.visitSetAutocommit(ctx);
    }

    @Override
    public SQLObject visitSetDefaultRole(MySQLSQLStatementParser.SetDefaultRoleContext ctx) {
        return super.visitSetDefaultRole(ctx);
    }

    @Override
    public SQLObject visitShowMasterLogs(MySQLSQLStatementParser.ShowMasterLogsContext ctx) {
        return super.visitShowMasterLogs(ctx);
    }

    @Override
    public SQLObject visitShowLogEvents(MySQLSQLStatementParser.ShowLogEventsContext ctx) {
        return super.visitShowLogEvents(ctx);
    }

    @Override
    public SQLObject visitShowObjectFilter(MySQLSQLStatementParser.ShowObjectFilterContext ctx) {
        return super.visitShowObjectFilter(ctx);
    }

    @Override
    public SQLObject visitShowColumns(MySQLSQLStatementParser.ShowColumnsContext ctx) {
        return super.visitShowColumns(ctx);
    }

    @Override
    public SQLObject visitShowCreateDb(MySQLSQLStatementParser.ShowCreateDbContext ctx) {
        return super.visitShowCreateDb(ctx);
    }

    @Override
    public SQLObject visitShowCreatenameIdentifierObject(MySQLSQLStatementParser.ShowCreatenameIdentifierObjectContext ctx) {
        return super.visitShowCreatenameIdentifierObject(ctx);
    }

    @Override
    public SQLObject visitShowCreateUser(MySQLSQLStatementParser.ShowCreateUserContext ctx) {
        return super.visitShowCreateUser(ctx);
    }

    @Override
    public SQLObject visitShowEngine(MySQLSQLStatementParser.ShowEngineContext ctx) {
        return super.visitShowEngine(ctx);
    }

    @Override
    public SQLObject visitShowGlobalInfo(MySQLSQLStatementParser.ShowGlobalInfoContext ctx) {
        return super.visitShowGlobalInfo(ctx);
    }

    @Override
    public SQLObject visitShowErrors(MySQLSQLStatementParser.ShowErrorsContext ctx) {
        return super.visitShowErrors(ctx);
    }

    @Override
    public SQLObject visitShowCountErrors(MySQLSQLStatementParser.ShowCountErrorsContext ctx) {
        return super.visitShowCountErrors(ctx);
    }

    @Override
    public SQLObject visitShowSchemaFilter(MySQLSQLStatementParser.ShowSchemaFilterContext ctx) {
        return super.visitShowSchemaFilter(ctx);
    }

    @Override
    public SQLObject visitShowRoutine(MySQLSQLStatementParser.ShowRoutineContext ctx) {
        return super.visitShowRoutine(ctx);
    }

    @Override
    public SQLObject visitShowGrants(MySQLSQLStatementParser.ShowGrantsContext ctx) {
        return super.visitShowGrants(ctx);
    }

    @Override
    public SQLObject visitShowIndexes(MySQLSQLStatementParser.ShowIndexesContext ctx) {
        return super.visitShowIndexes(ctx);
    }

    @Override
    public SQLObject visitShowOpenTables(MySQLSQLStatementParser.ShowOpenTablesContext ctx) {
        return super.visitShowOpenTables(ctx);
    }

    @Override
    public SQLObject visitShowProfile(MySQLSQLStatementParser.ShowProfileContext ctx) {
        return super.visitShowProfile(ctx);
    }

    @Override
    public SQLObject visitShowSlaveStatus(MySQLSQLStatementParser.ShowSlaveStatusContext ctx) {
        return super.visitShowSlaveStatus(ctx);
    }

    @Override
    public SQLObject visitShowCommonEntity(MySQLSQLStatementParser.ShowCommonEntityContext ctx) {
        return super.visitShowCommonEntity(ctx);
    }

    @Override
    public SQLObject visitShowFilter(MySQLSQLStatementParser.ShowFilterContext ctx) {
        return super.visitShowFilter(ctx);
    }

    @Override
    public SQLObject visitShowGlobalInfoClause(MySQLSQLStatementParser.ShowGlobalInfoClauseContext ctx) {
        return super.visitShowGlobalInfoClause(ctx);
    }

    @Override
    public SQLObject visitShowSchemaEntity(MySQLSQLStatementParser.ShowSchemaEntityContext ctx) {
        return super.visitShowSchemaEntity(ctx);
    }

    @Override
    public SQLObject visitShowProfileType(MySQLSQLStatementParser.ShowProfileTypeContext ctx) {
        return super.visitShowProfileType(ctx);
    }

    @Override
    public SQLObject visitBinlogStatement(MySQLSQLStatementParser.BinlogStatementContext ctx) {
        return super.visitBinlogStatement(ctx);
    }

    @Override
    public SQLObject visitCacheIndexStatement(MySQLSQLStatementParser.CacheIndexStatementContext ctx) {
        return super.visitCacheIndexStatement(ctx);
    }

    @Override
    public SQLObject visitFlushStatement(MySQLSQLStatementParser.FlushStatementContext ctx) {
        return super.visitFlushStatement(ctx);
    }

    @Override
    public SQLObject visitKillStatement(MySQLSQLStatementParser.KillStatementContext ctx) {
        return super.visitKillStatement(ctx);
    }

    @Override
    public SQLObject visitLoadIndexIntoCache(MySQLSQLStatementParser.LoadIndexIntoCacheContext ctx) {
        return super.visitLoadIndexIntoCache(ctx);
    }

    @Override
    public SQLObject visitResetStatement(MySQLSQLStatementParser.ResetStatementContext ctx) {
        return super.visitResetStatement(ctx);
    }

    @Override
    public SQLObject visitShutdownStatement(MySQLSQLStatementParser.ShutdownStatementContext ctx) {
        return super.visitShutdownStatement(ctx);
    }

    @Override
    public SQLObject visitTableIndexes(MySQLSQLStatementParser.TableIndexesContext ctx) {
        return super.visitTableIndexes(ctx);
    }

    @Override
    public SQLObject visitSimpleFlushOption(MySQLSQLStatementParser.SimpleFlushOptionContext ctx) {
        return super.visitSimpleFlushOption(ctx);
    }

    @Override
    public SQLObject visitChannelFlushOption(MySQLSQLStatementParser.ChannelFlushOptionContext ctx) {
        return super.visitChannelFlushOption(ctx);
    }

    @Override
    public SQLObject visitTableFlushOption(MySQLSQLStatementParser.TableFlushOptionContext ctx) {
        return super.visitTableFlushOption(ctx);
    }

    @Override
    public SQLObject visitFlushTableOption(MySQLSQLStatementParser.FlushTableOptionContext ctx) {
        return super.visitFlushTableOption(ctx);
    }

    @Override
    public SQLObject visitLoadedTableIndexes(MySQLSQLStatementParser.LoadedTableIndexesContext ctx) {
        return super.visitLoadedTableIndexes(ctx);
    }

    @Override
    public SQLObject visitSimpleDescribeStatement(MySQLSQLStatementParser.SimpleDescribeStatementContext ctx) {
        return super.visitSimpleDescribeStatement(ctx);
    }

    @Override
    public SQLObject visitFullDescribeStatement(MySQLSQLStatementParser.FullDescribeStatementContext ctx) {
        return super.visitFullDescribeStatement(ctx);
    }

    @Override
    public SQLObject visitHelpStatement(MySQLSQLStatementParser.HelpStatementContext ctx) {
        return super.visitHelpStatement(ctx);
    }

    @Override
    public SQLObject visitUseStatement(MySQLSQLStatementParser.UseStatementContext ctx) {
        return super.visitUseStatement(ctx);
    }

    @Override
    public SQLObject visitDescribeStatements(MySQLSQLStatementParser.DescribeStatementsContext ctx) {
        return super.visitDescribeStatements(ctx);
    }

    @Override
    public SQLObject visitDescribeConnection(MySQLSQLStatementParser.DescribeConnectionContext ctx) {
        return super.visitDescribeConnection(ctx);
    }


    @Override
    public SQLObject visitEngineName(MySQLSQLStatementParser.EngineNameContext ctx) {
        return super.visitEngineName(ctx);
    }

    @Override
    public SQLObject visitUnameIdentifierSet(MySQLSQLStatementParser.UnameIdentifierSetContext ctx) {
        return super.visitUnameIdentifierSet(ctx);
    }

    @Override
    public SQLObject visitXid(MySQLSQLStatementParser.XidContext ctx) {
        return super.visitXid(ctx);
    }

    @Override
    public SQLObject visitXnameIdentifierStringId(MySQLSQLStatementParser.XnameIdentifierStringIdContext ctx) {
        return super.visitXnameIdentifierStringId(ctx);
    }

    @Override
    public SQLObject visitAuthPlugin(MySQLSQLStatementParser.AuthPluginContext ctx) {
        return super.visitAuthPlugin(ctx);
    }

    // ----------------  DataType Start --------------------------------------------------------

    @Override
    public SQLDataType visitDataType(MySQLSQLStatementParser.DataTypeContext ctx) {
        if (ctx == null) {
            return null;
        }
        return (SQLDataType) super.visitChildren(ctx);
    }

    @Override
    public SQLBitDataType visitBitDataType(MySQLSQLStatementParser.BitDataTypeContext ctx) {
        SQLBitDataType x = new SQLBitDataType();
        SQLExpr expr = visitExpr(ctx.expr());
        x.addArgument(expr);
        return x;
    }

    @Override
    public SQLTinyintDataType visitTinyintDataType(MySQLSQLStatementParser.TinyintDataTypeContext ctx) {
        SQLTinyintDataType x = new SQLTinyintDataType();
        SQLExpr expr = visitExpr(ctx.expr());
        x.addArgument(expr);

        if (ctx.UNSIGNED() != null) {
            x.setUnsigned(true);
        }

        if (ctx.ZEROFILL() != null) {
            x.setZerofill(true);
        }
        return x;
    }

    @Override
    public SQLSmallintDataType visitSmallintDataType(MySQLSQLStatementParser.SmallintDataTypeContext ctx) {
        SQLSmallintDataType x = new SQLSmallintDataType();
        SQLExpr expr = visitExpr(ctx.expr());
        x.addArgument(expr);
        if (ctx.UNSIGNED() != null) {
            x.setUnsigned(true);
        }

        if (ctx.ZEROFILL() != null) {
            x.setZerofill(true);
        }
        return x;
    }

    @Override
    public SQLMediumintDataType visitMediumintDataType(MySQLSQLStatementParser.MediumintDataTypeContext ctx) {
        SQLMediumintDataType x = new SQLMediumintDataType();
        SQLExpr expr = visitExpr(ctx.expr());
        x.addArgument(expr);

        if (ctx.UNSIGNED() != null) {
            x.setUnsigned(true);
        }

        if (ctx.ZEROFILL() != null) {
            x.setZerofill(true);
        }
        return x;
    }

    @Override
    public SQLIntDataType visitIntDataType(MySQLSQLStatementParser.IntDataTypeContext ctx) {
        SQLIntDataType x = new SQLIntDataType();
        SQLExpr expr = visitExpr(ctx.expr());
        x.addArgument(expr);

        if (ctx.UNSIGNED() != null) {
            x.setUnsigned(true);
        }

        if (ctx.ZEROFILL() != null) {
            x.setZerofill(true);
        }
        return x;
    }

    @Override
    public SQLIntegerDataType visitIntegerDataType(MySQLSQLStatementParser.IntegerDataTypeContext ctx) {
        SQLIntegerDataType x = new SQLIntegerDataType();
        SQLExpr expr = visitExpr(ctx.expr());
        x.addArgument(expr);

        if (ctx.UNSIGNED() != null) {
            x.setUnsigned(true);
        }

        if (ctx.ZEROFILL() != null) {
            x.setZerofill(true);
        }
        return x;
    }

    @Override
    public SQLBigintDataType visitBigintDataType(MySQLSQLStatementParser.BigintDataTypeContext ctx) {
        SQLBigintDataType x = new SQLBigintDataType();
        SQLExpr expr = visitExpr(ctx.expr());
        x.addArgument(expr);

        if (ctx.UNSIGNED() != null) {
            x.setUnsigned(true);
        }

        if (ctx.ZEROFILL() != null) {
            x.setZerofill(true);
        }
        return x;
    }

    @Override
    public SQLDecimalDataType visitDecimalDataType(MySQLSQLStatementParser.DecimalDataTypeContext ctx) {
        SQLDecimalDataType x = new SQLDecimalDataType();

        for (MySQLSQLStatementParser.ExprContext exprContext : ctx.expr()) {
            SQLExpr expr = visitExpr(exprContext);
            x.addArgument(expr);
        }

        if (ctx.UNSIGNED() != null) {
            x.setUnsigned(true);
        }

        if (ctx.ZEROFILL() != null) {
            x.setZerofill(true);
        }
        return x;
    }

    @Override
    public SQLDecDataType visitDecDataType(MySQLSQLStatementParser.DecDataTypeContext ctx) {
        SQLDecDataType x = new SQLDecDataType();

        for (MySQLSQLStatementParser.ExprContext exprContext : ctx.expr()) {
            SQLExpr expr = visitExpr(exprContext);
            x.addArgument(expr);
        }

        if (ctx.UNSIGNED() != null) {
            x.setUnsigned(true);
        }

        if (ctx.ZEROFILL() != null) {
            x.setZerofill(true);
        }
        return x;
    }

    @Override
    public SQLNumericDataType visitNumericDataType(MySQLSQLStatementParser.NumericDataTypeContext ctx) {
        SQLNumericDataType x = new SQLNumericDataType();

        for (MySQLSQLStatementParser.ExprContext exprContext : ctx.expr()) {
            SQLExpr expr = visitExpr(exprContext);
            x.addArgument(expr);
        }

        if (ctx.UNSIGNED() != null) {
            x.setUnsigned(true);
        }

        if (ctx.ZEROFILL() != null) {
            x.setZerofill(true);
        }
        return x;
    }

    @Override
    public SQLFixedDataType visitFixedDataType(MySQLSQLStatementParser.FixedDataTypeContext ctx) {
        SQLFixedDataType x = new SQLFixedDataType();

        for (MySQLSQLStatementParser.ExprContext exprContext : ctx.expr()) {
            SQLExpr expr = visitExpr(exprContext);
            x.addArgument(expr);
        }

        if (ctx.UNSIGNED() != null) {
            x.setUnsigned(true);
        }

        if (ctx.ZEROFILL() != null) {
            x.setZerofill(true);
        }
        return x;
    }

    @Override
    public SQLFloatDataType visitFloatDataType(MySQLSQLStatementParser.FloatDataTypeContext ctx) {
        SQLFloatDataType x = new SQLFloatDataType();

        for (MySQLSQLStatementParser.ExprContext exprContext : ctx.expr()) {
            SQLExpr expr = visitExpr(exprContext);
            x.addArgument(expr);
        }

        if (ctx.UNSIGNED() != null) {
            x.setUnsigned(true);
        }

        if (ctx.ZEROFILL() != null) {
            x.setZerofill(true);
        }
        return x;
    }

    @Override
    public SQLDoubleDataType visitDoubleDataType(MySQLSQLStatementParser.DoubleDataTypeContext ctx) {
        SQLDoubleDataType x = new SQLDoubleDataType();

        for (MySQLSQLStatementParser.ExprContext exprContext : ctx.expr()) {
            SQLExpr expr = visitExpr(exprContext);
            x.addArgument(expr);
        }

        if (ctx.UNSIGNED() != null) {
            x.setUnsigned(true);
        }

        if (ctx.ZEROFILL() != null) {
            x.setZerofill(true);
        }
        return x;
    }

    @Override
    public SQLDoublePrecisionDataType visitDoublePrecisionDataType(MySQLSQLStatementParser.DoublePrecisionDataTypeContext ctx) {
        SQLDoublePrecisionDataType x = new SQLDoublePrecisionDataType();

        for (MySQLSQLStatementParser.ExprContext exprContext : ctx.expr()) {
            SQLExpr expr = visitExpr(exprContext);
            x.addArgument(expr);
        }

        if (ctx.UNSIGNED() != null) {
            x.setUnsigned(true);
        }

        if (ctx.ZEROFILL() != null) {
            x.setZerofill(true);
        }
        return x;
    }

    @Override
    public SQLRealDataType visitRealDataType(MySQLSQLStatementParser.RealDataTypeContext ctx) {
        SQLRealDataType x = new SQLRealDataType();

        for (MySQLSQLStatementParser.ExprContext exprContext : ctx.expr()) {
            SQLExpr expr = visitExpr(exprContext);
            x.addArgument(expr);
        }

        if (ctx.UNSIGNED() != null) {
            x.setUnsigned(true);
        }

        if (ctx.ZEROFILL() != null) {
            x.setZerofill(true);
        }
        return x;
    }

    @Override
    public SQLCharDataType visitCharDataType(MySQLSQLStatementParser.CharDataTypeContext ctx) {
        SQLCharDataType x = new SQLCharDataType();

        SQLExpr expr = visitExpr(ctx.expr());
        x.addArgument(expr);

        if (ctx.characterSetOptionExpr() != null) {
            SQLCharacterSetOptionExpr characterSetExpr = visitCharacterSetOptionExpr(ctx.characterSetOptionExpr());
            x.setCharacterSetExpr(characterSetExpr);
        }

        if (ctx.collateOptionExpr() != null) {
            SQLCollateOptionExpr collateExpr = visitCollateOptionExpr(ctx.collateOptionExpr());
            x.setCollateClause(collateExpr);
        }
        return x;
    }

    @Override
    public SQLNationalCharDataType visitNationalCharDataType(MySQLSQLStatementParser.NationalCharDataTypeContext ctx) {
        SQLNationalCharDataType x = new SQLNationalCharDataType();

        SQLExpr expr = visitExpr(ctx.expr());
        x.addArgument(expr);

        if (ctx.characterSetOptionExpr() != null) {
            SQLCharacterSetOptionExpr characterSetExpr = visitCharacterSetOptionExpr(ctx.characterSetOptionExpr());
            x.setCharacterSetExpr(characterSetExpr);
        }

        if (ctx.collateOptionExpr() != null) {
            SQLCollateOptionExpr collateExpr = visitCollateOptionExpr(ctx.collateOptionExpr());
            x.setCollateClause(collateExpr);
        }
        return x;
    }

    @Override
    public SQLVarcharDataType visitVarcharDataType(MySQLSQLStatementParser.VarcharDataTypeContext ctx) {
        SQLVarcharDataType x = new SQLVarcharDataType();

        SQLExpr expr = visitExpr(ctx.expr());
        x.addArgument(expr);

        if (ctx.characterSetOptionExpr() != null) {
            SQLCharacterSetOptionExpr characterSetExpr = visitCharacterSetOptionExpr(ctx.characterSetOptionExpr());
            x.setCharacterSetExpr(characterSetExpr);
        }

        if (ctx.collateOptionExpr() != null) {
            SQLCollateOptionExpr collateExpr = visitCollateOptionExpr(ctx.collateOptionExpr());
            x.setCollateClause(collateExpr);
        }
        return x;
    }

    @Override
    public SQLNationalVarcharDataType visitNationalVarcharDataType(MySQLSQLStatementParser.NationalVarcharDataTypeContext ctx) {
        SQLNationalVarcharDataType x = new SQLNationalVarcharDataType();

        SQLExpr expr = visitExpr(ctx.expr());
        x.addArgument(expr);

        if (ctx.characterSetOptionExpr() != null) {
            SQLCharacterSetOptionExpr characterSetExpr = visitCharacterSetOptionExpr(ctx.characterSetOptionExpr());
            x.setCharacterSetExpr(characterSetExpr);
        }

        if (ctx.collateOptionExpr() != null) {
            SQLCollateOptionExpr collateExpr = visitCollateOptionExpr(ctx.collateOptionExpr());
            x.setCollateClause(collateExpr);
        }
        return x;
    }

    @Override
    public SQLBinaryDataType visitBinaryDataType(MySQLSQLStatementParser.BinaryDataTypeContext ctx) {
        SQLBinaryDataType x = new SQLBinaryDataType();

        SQLExpr expr = visitExpr(ctx.expr());
        x.addArgument(expr);

        return x;
    }

    @Override
    public SQLVarBinaryDataType visitVarBinaryDataType(MySQLSQLStatementParser.VarBinaryDataTypeContext ctx) {
        SQLVarBinaryDataType x = new SQLVarBinaryDataType();

        SQLExpr expr = visitExpr(ctx.expr());
        x.addArgument(expr);

        return x;
    }

    @Override
    public SQLTinyBlobDataType visitTinyBlobDataType(MySQLSQLStatementParser.TinyBlobDataTypeContext ctx) {
        return new SQLTinyBlobDataType();
    }

    @Override
    public SQLTinyTextDataType visitTinyTextDataType(MySQLSQLStatementParser.TinyTextDataTypeContext ctx) {
        SQLTinyTextDataType x = new SQLTinyTextDataType();

        if (ctx.characterSetOptionExpr() != null) {
            SQLCharacterSetOptionExpr characterSetExpr = visitCharacterSetOptionExpr(ctx.characterSetOptionExpr());
            x.setCharacterSetExpr(characterSetExpr);
        }

        if (ctx.collateOptionExpr() != null) {
            SQLCollateOptionExpr collateExpr = visitCollateOptionExpr(ctx.collateOptionExpr());
            x.setCollateClause(collateExpr);
        }
        return x;
    }

    @Override
    public SQLBlobDataType visitBlobDataType(MySQLSQLStatementParser.BlobDataTypeContext ctx) {
        SQLBlobDataType x = new SQLBlobDataType();

        SQLExpr expr = visitExpr(ctx.expr());
        x.addArgument(expr);

        return x;
    }

    @Override
    public SQLTextDataType visitTextDataType(MySQLSQLStatementParser.TextDataTypeContext ctx) {
        SQLTextDataType x = new SQLTextDataType();

        SQLExpr expr = visitExpr(ctx.expr());
        x.addArgument(expr);
        if (ctx.characterSetOptionExpr() != null) {
            SQLCharacterSetOptionExpr characterSetExpr = visitCharacterSetOptionExpr(ctx.characterSetOptionExpr());
            x.setCharacterSetExpr(characterSetExpr);
        }

        if (ctx.collateOptionExpr() != null) {
            SQLCollateOptionExpr collateExpr = visitCollateOptionExpr(ctx.collateOptionExpr());
            x.setCollateClause(collateExpr);
        }
        return x;
    }

    @Override
    public SQLMediumBlobDataType visitMediumBlobDataType(MySQLSQLStatementParser.MediumBlobDataTypeContext ctx) {
        return new SQLMediumBlobDataType();
    }

    @Override
    public SQLMediumTextDataType visitMediumTextDataType(MySQLSQLStatementParser.MediumTextDataTypeContext ctx) {
        SQLMediumTextDataType x = new SQLMediumTextDataType();
        if (ctx.characterSetOptionExpr() != null) {
            SQLCharacterSetOptionExpr characterSetExpr = visitCharacterSetOptionExpr(ctx.characterSetOptionExpr());
            x.setCharacterSetExpr(characterSetExpr);
        }

        if (ctx.collateOptionExpr() != null) {
            SQLCollateOptionExpr collateExpr = visitCollateOptionExpr(ctx.collateOptionExpr());
            x.setCollateClause(collateExpr);
        }
        return x;
    }

    @Override
    public SQLLongBlobDataType visitLongBlobDataType(MySQLSQLStatementParser.LongBlobDataTypeContext ctx) {
        return new SQLLongBlobDataType();
    }

    @Override
    public SQLLongTextDataType visitLongTextDataType(MySQLSQLStatementParser.LongTextDataTypeContext ctx) {
        SQLLongTextDataType x = new SQLLongTextDataType();
        if (ctx.characterSetOptionExpr() != null) {
            SQLCharacterSetOptionExpr characterSetExpr = visitCharacterSetOptionExpr(ctx.characterSetOptionExpr());
            x.setCharacterSetExpr(characterSetExpr);
        }

        if (ctx.collateOptionExpr() != null) {
            SQLCollateOptionExpr collateExpr = visitCollateOptionExpr(ctx.collateOptionExpr());
            x.setCollateClause(collateExpr);
        }
        return x;
    }

    @Override
    public SQLEnumDataType visitEnumDataType(MySQLSQLStatementParser.EnumDataTypeContext ctx) {
        SQLEnumDataType x = new SQLEnumDataType();

        for (MySQLSQLStatementParser.ExprContext exprContext : ctx.expr()) {
            SQLExpr expr = visitExpr(exprContext);
            x.addArgument(expr);
        }

        if (ctx.characterSetOptionExpr() != null) {
            SQLCharacterSetOptionExpr characterSetExpr = visitCharacterSetOptionExpr(ctx.characterSetOptionExpr());
            x.setCharacterSetExpr(characterSetExpr);
        }

        if (ctx.collateOptionExpr() != null) {
            SQLCollateOptionExpr collateExpr = visitCollateOptionExpr(ctx.collateOptionExpr());
            x.setCollateClause(collateExpr);
        }
        return x;
    }

    @Override
    public SQLSetDataType visitSetDataType(MySQLSQLStatementParser.SetDataTypeContext ctx) {
        SQLSetDataType x = new SQLSetDataType();

        for (MySQLSQLStatementParser.ExprContext exprContext : ctx.expr()) {
            SQLExpr expr = visitExpr(exprContext);
            x.addArgument(expr);
        }

        if (ctx.characterSetOptionExpr() != null) {
            SQLCharacterSetOptionExpr characterSetExpr = visitCharacterSetOptionExpr(ctx.characterSetOptionExpr());
            x.setCharacterSetExpr(characterSetExpr);
        }

        if (ctx.collateOptionExpr() != null) {
            SQLCollateOptionExpr collateExpr = visitCollateOptionExpr(ctx.collateOptionExpr());
            x.setCollateClause(collateExpr);
        }
        return x;
    }

    @Override
    public SQLDateDataType visitDateDataType(MySQLSQLStatementParser.DateDataTypeContext ctx) {
        return new SQLDateDataType();
    }

    @Override
    public SQLDateTimeDataType visitDatetimeDataType(MySQLSQLStatementParser.DatetimeDataTypeContext ctx) {
        SQLDateTimeDataType x = new SQLDateTimeDataType();
        if (ctx.expr() != null) {
            SQLExpr expr = visitExpr(ctx.expr());
            x.addArgument(expr);
        }

        return x;
    }

    @Override
    public SQLTimestampDataType visitTimestampDataType(MySQLSQLStatementParser.TimestampDataTypeContext ctx) {
        SQLTimestampDataType x = new SQLTimestampDataType();
        if (ctx.expr() != null) {
            SQLExpr expr = visitExpr(ctx.expr());
            x.addArgument(expr);
        }

        return x;
    }

    @Override
    public SQLTimeDataType visitTimeDataType(MySQLSQLStatementParser.TimeDataTypeContext ctx) {
        SQLTimeDataType x = new SQLTimeDataType();
        if (ctx.expr() != null) {
            SQLExpr expr = visitExpr(ctx.expr());
            x.addArgument(expr);
        }
        return x;
    }

    @Override
    public SQLYearDataType visitYearDataType(MySQLSQLStatementParser.YearDataTypeContext ctx) {
        SQLYearDataType x = new SQLYearDataType();
        if (ctx.expr() != null) {
            SQLExpr expr = visitExpr(ctx.expr());
            x.addArgument(expr);
        }
        return x;
    }

    @Override
    public SQLGeometryDataType visitGeometryDataType(MySQLSQLStatementParser.GeometryDataTypeContext ctx) {
        return new SQLGeometryDataType();
    }

    @Override
    public SQLPointDataType visitPointDataType(MySQLSQLStatementParser.PointDataTypeContext ctx) {
        return new SQLPointDataType();
    }

    @Override
    public SQLLineStringDataType visitLineStringDataType(MySQLSQLStatementParser.LineStringDataTypeContext ctx) {
        return new SQLLineStringDataType();
    }

    @Override
    public SQLPolygonDataType visitPolygonDataType(MySQLSQLStatementParser.PolygonDataTypeContext ctx) {
        return new SQLPolygonDataType();
    }

    @Override
    public SQLMultiPointDataType visitMultiPointDataType(MySQLSQLStatementParser.MultiPointDataTypeContext ctx) {
        return new SQLMultiPointDataType();
    }

    @Override
    public SQLMultiLineStringDataType visitMultiLineStringDataType(MySQLSQLStatementParser.MultiLineStringDataTypeContext ctx) {
        return new SQLMultiLineStringDataType();
    }

    @Override
    public SQLMultiPolygonDataType visitMultiPolygonDataType(MySQLSQLStatementParser.MultiPolygonDataTypeContext ctx) {
        return new SQLMultiPolygonDataType();
    }

    @Override
    public SQLGeometryCollectionDataType visitGeometryCollectionDataType(MySQLSQLStatementParser.GeometryCollectionDataTypeContext ctx) {
        return new SQLGeometryCollectionDataType();
    }

    @Override
    public SQLBoolDataType visitBoolDataType(MySQLSQLStatementParser.BoolDataTypeContext ctx) {
        return new SQLBoolDataType();
    }

    @Override
    public SQLBooleanDataType visitBooleanDataType(MySQLSQLStatementParser.BooleanDataTypeContext ctx) {
        return new SQLBooleanDataType();
    }

    @Override
    public SQLJsonDataType visitJsonDataType(MySQLSQLStatementParser.JsonDataTypeContext ctx) {
        return new SQLJsonDataType();
    }

    @Override
    public SQLDataTypeImpl visitOtherDataType(MySQLSQLStatementParser.OtherDataTypeContext ctx) {
        SQLName name = visitNameIdentifier(ctx.name);

        SQLDataTypeImpl x = new SQLDataTypeImpl(name);

        if (ctx.LEFT_PAREN() != null) {
            x.setParen(true);
        }

        for (MySQLSQLStatementParser.ExprContext exprContext : ctx.expr()) {
            SQLExpr argument = visitExpr(exprContext);
            x.addArgument(argument);
        }

        return x;
    }

    // ----------------  DataType End --------------------------------------------------------


    // ----------------  Identified Start --------------------------------------------------------
    public SQLIdentifier visitIdentifier(MySQLSQLStatementParser.IdentifierContext ctx) {
        return (SQLIdentifier) super.visit(ctx);
    }

    @Override
    public SQLAllColumnExpr visitAsteriskIdentifier(MySQLSQLStatementParser.AsteriskIdentifierContext ctx) {
        return new SQLAllColumnExpr();
    }

    @Override
    public SQLIdentifierImpl visitNormalIdentifier(MySQLSQLStatementParser.NormalIdentifierContext ctx) {
        return new SQLIdentifierImpl(ctx.getText());
    }

    @Override
    public SQLReverseQuoteIdentifier visitReverseQuoteIdentifier(MySQLSQLStatementParser.ReverseQuoteIdentifierContext ctx) {
        return new SQLReverseQuoteIdentifier(ctx.getText());
    }

    @Override
    public SQLDoubleQuoteIdentifier visitDoubleQuoteIdentifier1(MySQLSQLStatementParser.DoubleQuoteIdentifier1Context ctx) {
        return new SQLDoubleQuoteIdentifier(ctx.getText());
    }

    public SQLName visitNameIdentifier(MySQLSQLStatementParser.NameIdentifierContext ctx) {
        if (ctx == null) {
            return null;
        }
        return (SQLName) super.visit(ctx);
    }

    @Override
    public SQLPropertyExpr visitPropertyIdentifier1(MySQLSQLStatementParser.PropertyIdentifier1Context ctx) {
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
    public SQLPropertyExpr visitPropertyIdentifier2(MySQLSQLStatementParser.PropertyIdentifier2Context ctx) {
        SQLExpr owner = visitExpr(ctx.expr());
        SQLIdentifier name = (SQLIdentifier) visit(ctx.nameIdentifier());
        return new SQLPropertyExpr(owner, name);
    }

    // ----------------  Identified End --------------------------------------------------------


    // ----------------  Literals Start --------------------------------------------------------

    @Override
    public SQLNCharLiteral visitNCharLiteral(MySQLSQLStatementParser.NCharLiteralContext ctx) {
        return new SQLNCharLiteral(ctx.getText());
    }

    @Override
    public SQLCharLiteral visitCharLiteral(MySQLSQLStatementParser.CharLiteralContext ctx) {
        return new SQLCharLiteral(ctx.getText());
    }

    @Override
    public SQLObject visitCharsetNamChareLiteral(MySQLSQLStatementParser.CharsetNamChareLiteralContext ctx) {
        return super.visitCharsetNamChareLiteral(ctx);
    }

    @Override
    public SQLIntegerLiteral visitIntegerLiteral(MySQLSQLStatementParser.IntegerLiteralContext ctx) {
        return new SQLIntegerLiteral(ctx.getText());
    }

    @Override
    public SQLNumberLiteral visitNumberLiteral(MySQLSQLStatementParser.NumberLiteralContext ctx) {
        return new SQLNumberLiteral(ctx.getText());
    }

    @Override
    public SQLDateLiteral visitDateLiteral(MySQLSQLStatementParser.DateLiteralContext ctx) {
        SQLExpr value = (SQLExpr) visitChildren(ctx.expr());
        return new SQLDateLiteral(value);
    }

    @Override
    public SQLTimeLiteral visitTimeLiteral(MySQLSQLStatementParser.TimeLiteralContext ctx) {
        SQLExpr value = (SQLExpr) visitChildren(ctx.expr());
        return new SQLTimeLiteral(value);
    }

    @Override
    public SQLTimestampLiteral visitTimestampLiteral(MySQLSQLStatementParser.TimestampLiteralContext ctx) {
        SQLExpr value = (SQLExpr) visitChildren(ctx.value);
        return new SQLTimestampLiteral(value);
    }

    @Override
    public SQLObject visitIntervalLiteral(MySQLSQLStatementParser.IntervalLiteralContext ctx) {
        SQLIntervalLiteral x = new SQLIntervalLiteral();

        SQLExpr value = visitExpr(ctx.expr());
        x.setValue(value);

        SQLIntervalUnit unit = SQLIntervalUnit.valueOf(ctx.intervalType().getText());
        x.setUnit(unit);

        return x;
    }

    @Override
    public SQLHexadecimalLiteral visitHexadecimalLiteral(MySQLSQLStatementParser.HexadecimalLiteralContext ctx) {
        return new SQLHexadecimalLiteral(ctx.getText());
    }

    @Override
    public SQLBitLiteral visitBitLiteral(MySQLSQLStatementParser.BitLiteralContext ctx) {
        return new SQLBitLiteral(ctx.getText());
    }

    @Override
    public SQLBooleanLiteral visitFalseLiteral(MySQLSQLStatementParser.FalseLiteralContext ctx) {
        return new SQLBooleanLiteral(false);
    }

    @Override
    public SQLBooleanLiteral visitTrueLiteral(MySQLSQLStatementParser.TrueLiteralContext ctx) {
        return new SQLBooleanLiteral(true);
    }

    @Override
    public SQLNullExpr visitNullLiteral(MySQLSQLStatementParser.NullLiteralContext ctx) {
        return new SQLNullExpr();
    }

    // ----------------  Literals End --------------------------------------------------------

    // ----------------  Expr Start --------------------------------------------------------
    public SQLExpr visitExpr(MySQLSQLStatementParser.ExprContext ctx) {
        if (ctx == null) {
            return null;
        }
        return (SQLExpr) super.visit(ctx);
    }

    @Override
    public SQLUnaryOperatorExpr visitUnaryOperatorExpr(MySQLSQLStatementParser.UnaryOperatorExprContext ctx) {
        boolean paren = ctx.LEFT_PAREN() != null;
        SQLUnaryOperator operator = SQLUnaryOperator.of(ctx.unaryOperator().getText());
        SQLExpr expr = visitExpr(ctx.expr());
        SQLUnaryOperatorExpr x = new SQLUnaryOperatorExpr(paren, operator, expr);
        return x;
    }

    @Override
    public SQLBinaryOperatorExpr visitBinaryOperatorExpr(MySQLSQLStatementParser.BinaryOperatorExprContext ctx) {
        boolean paren = ctx.LEFT_PAREN() != null;

        SQLExpr left = visitExpr(ctx.expr(0));
        SQLExpr right = visitExpr(ctx.expr(1));
        SQLBinaryOperator operator = SQLBinaryOperator.of(ctx.operator.getText());

        return new SQLBinaryOperatorExpr(paren, left, operator, right);
    }

    @Override
    public SQLBinaryOperatorExpr visitComparisonBinaryOperatorExpr(MySQLSQLStatementParser.ComparisonBinaryOperatorExprContext ctx) {
        boolean paren = ctx.LEFT_PAREN() != null;
        SQLExpr left = visitExpr(ctx.expr(0));
        SQLExpr right = visitExpr(ctx.expr(1));
        SQLBinaryOperator operator = SQLBinaryOperator.of(ctx.comparisonOp().getText());
        return new SQLBinaryOperatorExpr(paren, left, operator, right);
    }

    @Override
    public SQLVariableExpr visitVariableExpr(MySQLSQLStatementParser.VariableExprContext ctx) {
        return new SQLVariableExpr();
    }

    @Override
    public SQLLocalVariableExpr visitLocalVariableExpr(MySQLSQLStatementParser.LocalVariableExprContext ctx) {
        return new SQLLocalVariableExpr(ctx.getText());
    }

    @Override
    public SQLGlobalVariableExpr visitGlobalVariableExpr(MySQLSQLStatementParser.GlobalVariableExprContext ctx) {
        return new SQLGlobalVariableExpr(ctx.getText());
    }

    @Override
    public SQLGlobalGlobalVariableExpr visitGlobalGlobalVariableExpr(MySQLSQLStatementParser.GlobalGlobalVariableExprContext ctx) {
        SQLGlobalGlobalVariableExpr x = new SQLGlobalGlobalVariableExpr();
        SQLGlobalGlobalVariableExpr.SQLPrefix prefix = SQLGlobalGlobalVariableExpr.SQLPrefix.AT_SIGN_AT_SIGN_GLOBAL;
        if (ctx.PERIOD() != null) {
            prefix = SQLGlobalGlobalVariableExpr.SQLPrefix.GLOBAL;
        }
        x.setPrefix(prefix);

        SQLIdentifier name = visitIdentifier(ctx.identifier());
        x.setName(name);

        return x;
    }

    @Override
    public SQLSessionGlobalVariableExpr visitSessionGlobalVariableExpr(MySQLSQLStatementParser.SessionGlobalVariableExprContext ctx) {
        SQLSessionGlobalVariableExpr x = new SQLSessionGlobalVariableExpr();
        SQLSessionGlobalVariableExpr.SQLPrefix prefix = SQLSessionGlobalVariableExpr.SQLPrefix.AT_SIGN_AT_SIGN_SESSION;
        if (ctx.PERIOD() != null) {
            prefix = SQLSessionGlobalVariableExpr.SQLPrefix.SESSION;
        }
        x.setPrefix(prefix);

        SQLIdentifier name = visitIdentifier(ctx.identifier());
        x.setName(name);

        return x;
    }

    @Override
    public SQLPersistGlobalVariableExpr visitPersistGlobalVariableExpr(MySQLSQLStatementParser.PersistGlobalVariableExprContext ctx) {
        SQLPersistGlobalVariableExpr x = new SQLPersistGlobalVariableExpr();
        SQLPersistGlobalVariableExpr.SQLPrefix prefix = SQLPersistGlobalVariableExpr.SQLPrefix.AT_SIGN_AT_SIGN_PERSIST;
        if (ctx.PERIOD() != null) {
            prefix = SQLPersistGlobalVariableExpr.SQLPrefix.PERSIST;
        }
        x.setPrefix(prefix);

        SQLIdentifier name = visitIdentifier(ctx.identifier());
        x.setName(name);

        return x;
    }

    @Override
    public SQLPersistOnlyGlobalVariableExpr visitPersistOnlyGlobalVariableExpr(MySQLSQLStatementParser.PersistOnlyGlobalVariableExprContext ctx) {
        SQLPersistOnlyGlobalVariableExpr x = new SQLPersistOnlyGlobalVariableExpr();
        SQLPersistOnlyGlobalVariableExpr.SQLPrefix prefix = SQLPersistOnlyGlobalVariableExpr.SQLPrefix.AT_SIGN_AT_SIGN_PERSIST_ONLY;
        if (ctx.PERIOD() != null) {
            prefix = SQLPersistOnlyGlobalVariableExpr.SQLPrefix.PERSIST_ONLY;
        }
        x.setPrefix(prefix);

        SQLIdentifier name = visitIdentifier(ctx.identifier());
        x.setName(name);

        return x;
    }

    @Override
    public SQLNewVariableRefExpr visitNewVariableRefExpr(MySQLSQLStatementParser.NewVariableRefExprContext ctx) {
        if (ctx == null) {
            return null;
        }
        SQLNewVariableRefExpr x = new SQLNewVariableRefExpr();
        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);
        return x;
    }

    @Override
    public SQLOldVariableRefExpr visitOldVariableRefExpr(MySQLSQLStatementParser.OldVariableRefExprContext ctx) {
        if (ctx == null) {
            return null;
        }
        SQLOldVariableRefExpr x = new SQLOldVariableRefExpr();
        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);
        return x;
    }

    @Override
    public SQLSelectQueryExpr visitSelectQueryExpr(MySQLSQLStatementParser.SelectQueryExprContext ctx) {
        ISQLSelectQuery subQuery = visitISelectQuery(ctx.iSelectQuery());
        SQLSelectQueryExpr x = new SQLSelectQueryExpr(subQuery);

        if (ctx.LEFT_PAREN() != null
                && ctx.RIGHT_PAREN() != null) {
            x.setParen(true);
        }
        return x;
    }

    @Override
    public SQLObject visitMatchExpr(MySQLSQLStatementParser.MatchExprContext ctx) {
        return super.visitMatchExpr(ctx);
    }

    @Override
    public SQLObject visitSearchModifier(MySQLSQLStatementParser.SearchModifierContext ctx) {
        return super.visitSearchModifier(ctx);
    }

    @Override
    public SQLObject visitCaseExpr(MySQLSQLStatementParser.CaseExprContext ctx) {
        SQLCaseExpr x = new SQLCaseExpr();

        if (ctx.expr() != null) {
            SQLExpr expr = visitExpr(ctx.expr());
            x.setExpr(expr);
        }

        for (MySQLSQLStatementParser.CaseExprWhenItemContext caseExprWhenItemContext : ctx.caseExprWhenItem()) {
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
    public SQLCaseExpr.SQLCaseExprWhenItem visitCaseExprWhenItem(MySQLSQLStatementParser.CaseExprWhenItemContext ctx) {
        SQLExpr when = visitExpr(ctx.when);
        SQLExpr then = visitExpr(ctx.then);

        return new SQLCaseExpr.SQLCaseExprWhenItem(when, then);
    }

    @Override
    public SQLCaseExpr.SQLCaseExprElseClause visitCaseExprElseClause(MySQLSQLStatementParser.CaseExprElseClauseContext ctx) {
        SQLExpr expr = visitExpr(ctx.expr());
        return new SQLCaseExpr.SQLCaseExprElseClause(expr);
    }

    @Override
    public SQLListExpr visitListExpr(MySQLSQLStatementParser.ListExprContext ctx) {
        SQLListExpr x = new SQLListExpr();
        for (MySQLSQLStatementParser.ExprContext exprContext : ctx.expr()) {
            SQLExpr item = visitExpr(exprContext);
            x.addItem(item);
        }
        return x;
    }

    @Override
    public SQLSomeClause visitSomeExpr(MySQLSQLStatementParser.SomeExprContext ctx) {
        SQLExpr expr = visitExpr(ctx.expr());
        return new SQLSomeClause(expr);
    }

    @Override
    public SQLAllClause visitAllExpr(MySQLSQLStatementParser.AllExprContext ctx) {
        SQLExpr expr = visitExpr(ctx.expr());
        return new SQLAllClause(expr);
    }

    @Override
    public SQLAnyClause visitAnyExpr(MySQLSQLStatementParser.AnyExprContext ctx) {
        SQLExpr expr = visitExpr(ctx.expr());
        return new SQLAnyClause(expr);
    }

    @Override
    public SQLDefaultClause visitDefaultClause(MySQLSQLStatementParser.DefaultClauseContext ctx) {
        SQLExpr expr = visitExpr(ctx.expr());
        return new SQLDefaultClause(expr);
    }

    @Override
    public SQLAutoIncrementOptionExpr visitAutoIncrementOptionExpr(MySQLSQLStatementParser.AutoIncrementOptionExprContext ctx) {
        if (ctx == null) {
            return null;
        }
        SQLExpr value = visitExpr(ctx.expr());
        SQLAutoIncrementOptionExpr x = new SQLAutoIncrementOptionExpr(value);
        return x;
    }

    @Override
    public SQLAvgRowLengthOptionExpr visitAvgRowLengthOptionExpr(MySQLSQLStatementParser.AvgRowLengthOptionExprContext ctx) {
        if (ctx == null) {
            return null;
        }
        SQLExpr value = visitExpr(ctx.expr());
        SQLAvgRowLengthOptionExpr x = new SQLAvgRowLengthOptionExpr(value);
        return x;
    }

    @Override
    public SQLCharacterSetOptionExpr visitCharacterSetOptionExpr(MySQLSQLStatementParser.CharacterSetOptionExprContext ctx) {
        if (ctx == null) {
            return null;
        }
        boolean default_ = ctx.DEFAULT() != null;
        boolean equalSign = ctx.EQUALS_OP() != null;
        SQLName value = visitNameIdentifier(ctx.nameIdentifier());
        SQLCharacterSetOptionExpr x = new SQLCharacterSetOptionExpr(default_, equalSign, value);
        return x;
    }

    @Override
    public SQLCharsetOptionExpr visitCharsetOptionExpr(MySQLSQLStatementParser.CharsetOptionExprContext ctx) {
        if (ctx == null) {
            return null;
        }
        boolean default_ = ctx.DEFAULT() != null;
        boolean equalSign = ctx.EQUALS_OP() != null;
        SQLName value = visitNameIdentifier(ctx.nameIdentifier());
        SQLCharsetOptionExpr x = new SQLCharsetOptionExpr(default_, equalSign, value);
        return x;
    }

    @Override
    public SQLChecksumOptionExpr visitChecksumOptionExpr(MySQLSQLStatementParser.ChecksumOptionExprContext ctx) {
        if (ctx == null) {
            return null;
        }
        boolean equalSign = ctx.EQUALS_OP() != null;
        SQLExpr value = visitExpr(ctx.expr());
        SQLChecksumOptionExpr x = new SQLChecksumOptionExpr(equalSign, value);
        return x;
    }

    @Override
    public SQLCommentOptionExpr visitCommentOptionExpr(MySQLSQLStatementParser.CommentOptionExprContext ctx) {
        if (ctx == null) {
            return null;
        }
        boolean equalSign = ctx.EQUALS_OP() != null;
        SQLExpr value = visitExpr(ctx.expr());
        SQLCommentOptionExpr x = new SQLCommentOptionExpr(equalSign, value);
        return x;
    }

    @Override
    public SQLObject visitCompressionOptionExpr(MySQLSQLStatementParser.CompressionOptionExprContext ctx) {
        return super.visitCompressionOptionExpr(ctx);
    }

    @Override
    public SQLObject visitConnectionOptionExpr(MySQLSQLStatementParser.ConnectionOptionExprContext ctx) {
        return super.visitConnectionOptionExpr(ctx);
    }

    @Override
    public SQLObject visitDataDirectoryOptionExpr(MySQLSQLStatementParser.DataDirectoryOptionExprContext ctx) {
        return super.visitDataDirectoryOptionExpr(ctx);
    }

    @Override
    public SQLObject visitIndexDirectoryOptionExpr(MySQLSQLStatementParser.IndexDirectoryOptionExprContext ctx) {
        return super.visitIndexDirectoryOptionExpr(ctx);
    }

    @Override
    public SQLObject visitDelayKeyWriteOptionExpr(MySQLSQLStatementParser.DelayKeyWriteOptionExprContext ctx) {
        return super.visitDelayKeyWriteOptionExpr(ctx);
    }

    @Override
    public SQLObject visitEncryptionOptionExpr(MySQLSQLStatementParser.EncryptionOptionExprContext ctx) {
        return super.visitEncryptionOptionExpr(ctx);
    }

    @Override
    public SQLEngineOptionExpr visitEngineOptionExpr(MySQLSQLStatementParser.EngineOptionExprContext ctx) {
        if (ctx == null) {
            return null;
        }
        boolean equalSign = ctx.EQUALS_OP() != null;
        SQLExpr value = visitExpr(ctx.expr());
        SQLEngineOptionExpr x = new SQLEngineOptionExpr(equalSign, value);
        return x;
    }

    @Override
    public SQLObject visitInsertMethodOptionExpr(MySQLSQLStatementParser.InsertMethodOptionExprContext ctx) {
        return super.visitInsertMethodOptionExpr(ctx);
    }

    @Override
    public SQLObject visitKeyBlockSizeOptionExpr(MySQLSQLStatementParser.KeyBlockSizeOptionExprContext ctx) {
        return super.visitKeyBlockSizeOptionExpr(ctx);
    }

    @Override
    public SQLObject visitMaxRowsOptionExpr(MySQLSQLStatementParser.MaxRowsOptionExprContext ctx) {
        return super.visitMaxRowsOptionExpr(ctx);
    }

    @Override
    public SQLObject visitMinRowsOptionExpr(MySQLSQLStatementParser.MinRowsOptionExprContext ctx) {
        return super.visitMinRowsOptionExpr(ctx);
    }

    @Override
    public SQLObject visitPackKeysOptionExpr(MySQLSQLStatementParser.PackKeysOptionExprContext ctx) {
        return super.visitPackKeysOptionExpr(ctx);
    }

    @Override
    public SQLObject visitPasswordOptionExpr(MySQLSQLStatementParser.PasswordOptionExprContext ctx) {
        return super.visitPasswordOptionExpr(ctx);
    }

    @Override
    public SQLObject visitRowFormatOptionExpr(MySQLSQLStatementParser.RowFormatOptionExprContext ctx) {
        return super.visitRowFormatOptionExpr(ctx);
    }

    @Override
    public SQLObject visitStatsAutoRecalcOptionExpr(MySQLSQLStatementParser.StatsAutoRecalcOptionExprContext ctx) {
        return super.visitStatsAutoRecalcOptionExpr(ctx);
    }

    @Override
    public SQLObject visitStatsPersistentOptionExpr(MySQLSQLStatementParser.StatsPersistentOptionExprContext ctx) {
        return super.visitStatsPersistentOptionExpr(ctx);
    }

    @Override
    public SQLObject visitStatsSamplePageOptionExpr(MySQLSQLStatementParser.StatsSamplePageOptionExprContext ctx) {
        return super.visitStatsSamplePageOptionExpr(ctx);
    }

    @Override
    public SQLTablespaceOptionExpr visitTablespaceOptionExpr(MySQLSQLStatementParser.TablespaceOptionExprContext ctx) {
        if (ctx == null) {
            return null;
        }
        SQLExpr value = visitNameIdentifier(ctx.nameIdentifier());
        SQLTablespaceOptionExpr x = new SQLTablespaceOptionExpr(value);
        return x;
    }

    @Override
    public SQLObject visitUnionOptionExpr(MySQLSQLStatementParser.UnionOptionExprContext ctx) {
        return super.visitUnionOptionExpr(ctx);
    }

    @Override
    public SQLCollateOptionExpr visitCollateOptionExpr(MySQLSQLStatementParser.CollateOptionExprContext ctx) {
        if (ctx == null) {
            return null;
        }
        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        SQLCollateOptionExpr x = new SQLCollateOptionExpr(name);
        return x;
    }

    @Override
    public SQLAssignmentExpr visitAssignmentExpr(MySQLSQLStatementParser.AssignmentExprContext ctx) {
        if (ctx == null) {
            return null;
        }
        SQLExpr column = visitExpr(ctx.name);
        SQLExpr value = visitExpr(ctx.value);
        return new SQLAssignmentExpr(column, value);
    }

    @Override
    public SQLDefaultLiteral visitDefaultLiteral(MySQLSQLStatementParser.DefaultLiteralContext ctx) {
        return new SQLDefaultLiteral();
    }

    @Override
    public SQLAllLiteral visitAllLiteral(MySQLSQLStatementParser.AllLiteralContext ctx) {
        return new SQLAllLiteral();
    }

    @Override
    public SQLNoneLiteral visitNoneLiteral(MySQLSQLStatementParser.NoneLiteralContext ctx) {
        return new SQLNoneLiteral();
    }

    @Override
    public SQLMaxValueLiteral visitMaxValueLiteral(MySQLSQLStatementParser.MaxValueLiteralContext ctx) {
        return new SQLMaxValueLiteral();
    }

    // ----------------  Expr End --------------------------------------------------------


    // --------------------------------------- condition Start ----------------------------------------------------------------

    @Override
    public SQLSoundsLikeCondition visitSoundsLikeCondition(MySQLSQLStatementParser.SoundsLikeConditionContext ctx) {
        SQLExpr expr = visitExpr(ctx.value);
        SQLExpr pattern = visitExpr(ctx.pattern);

        return new SQLSoundsLikeCondition(expr, pattern);
    }

    @Override
    public SQLRlikeCondition visitRlikeCondition(MySQLSQLStatementParser.RlikeConditionContext ctx) {
        SQLExpr expr = visitExpr(ctx.value);
        SQLExpr pattern = visitExpr(ctx.pattern);
        boolean not = ctx.NOT() != null;

        return new SQLRlikeCondition(expr, not, pattern);
    }

    @Override
    public SQLInCondition visitInCondition(MySQLSQLStatementParser.InConditionContext ctx) {
        SQLExpr name = visitExpr(ctx.name);

        SQLInCondition x = new SQLInCondition();

        x.setExpr(name);

        for (MySQLSQLStatementParser.ExprContext exprContext : ctx.values) {
            SQLExpr value = visitExpr(exprContext);
            x.addValue(value);
        }

        boolean not = ctx.NOT() != null;
        x.setNot(not);

        return x;
    }

    @Override
    public SQLObject visitIsNullCondition(MySQLSQLStatementParser.IsNullConditionContext ctx) {
        SQLExpr expr = visitExpr(ctx.expr());

        SQLIsNullCondition x = new SQLIsNullCondition(expr);

        boolean not = ctx.NOT() != null;
        x.setNot(not);

        return x;
    }

    @Override
    public SQLRegexpCondition visitRegexpCondition(MySQLSQLStatementParser.RegexpConditionContext ctx) {
        SQLExpr expr = visitExpr(ctx.value);
        boolean not = ctx.NOT() != null;
        SQLExpr pattern = visitExpr(ctx.pattern);

        return new SQLRegexpCondition(expr, not, pattern);
    }

    @Override
    public SQLObject visitLikeCondition(MySQLSQLStatementParser.LikeConditionContext ctx) {
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
    public SQLBetweenCondition visitBetweenCondition(MySQLSQLStatementParser.BetweenConditionContext ctx) {
        SQLExpr name = visitExpr(ctx.name);
        SQLExpr between = visitExpr(ctx.between);
        SQLExpr and = visitExpr(ctx.and);

        boolean not = ctx.NOT() != null;

        return new SQLBetweenCondition(name, not, between, and);
    }

    @Override
    public SQLIsBooleanLiteralCondition visitIsBooleanLiteralCondition(MySQLSQLStatementParser.IsBooleanLiteralConditionContext ctx) {
        SQLExpr expr = visitExpr(ctx.expr());
        boolean not = ctx.NOT() != null;
        SQLIsBooleanLiteralCondition.SQLValue value = SQLIsBooleanLiteralCondition.SQLValue.TRUE;
        if (ctx.FALSE() != null) {
            value = SQLIsBooleanLiteralCondition.SQLValue.FALSE;
        } else if (ctx.UNKNOWN() != null) {
            value = SQLIsBooleanLiteralCondition.SQLValue.UNKNOWN;
        }

        return new SQLIsBooleanLiteralCondition(expr, not, value);
    }

    @Override
    public SQLNotCondition visitNotCondition(MySQLSQLStatementParser.NotConditionContext ctx) {
        SQLExpr expr = visitExpr(ctx.expr());
        return new SQLNotCondition(expr);
    }

    @Override
    public SQLExistsCondition visitExistsCondition(MySQLSQLStatementParser.ExistsConditionContext ctx) {
        ISQLSelectQuery subQuery = visitISelectQuery(ctx.iSelectQuery());
        SQLExistsCondition x = new SQLExistsCondition(subQuery);
        return x;
    }

    // --------------------------------------- condition End ----------------------------------------------------------------


    // --------------------------------------- Function Start ----------------------------------------------------------------
    @Override
    public SQLMethodInvocation visitMethodInvocation1(MySQLSQLStatementParser.MethodInvocation1Context ctx) {
        String name = ctx.noArgumentFunctionName().getText();

        SQLMethodInvocation x = new SQLMethodInvocation(name);

        boolean paren = ctx.LEFT_PAREN() != null;
        x.setParen(paren);

        for (MySQLSQLStatementParser.ExprContext argumentContext : ctx.arguments) {
            SQLExpr argument = visitExpr(argumentContext);
            x.addArgument(argument);
        }
        return x;
    }

    @Override
    public SQLMethodInvocation visitMethodInvocation2(MySQLSQLStatementParser.MethodInvocation2Context ctx) {
        SQLExpr name = visitExpr(ctx.name);

        SQLMethodInvocation x = new SQLMethodInvocation(name);

        SQLSetQuantifier setQuantifier = of(ctx.setQuantifier());
        x.setSetQuantifier(setQuantifier);

        for (MySQLSQLStatementParser.ExprContext argumentContext : ctx.arguments) {
            SQLExpr argument = visitExpr(argumentContext);
            x.addArgument(argument);
        }
        return x;
    }
    // --------------------------------------- Function End ----------------------------------------------------------------


    public SQLOrderingSpecification of(MySQLSQLStatementParser.OrderingSpecificationContext ctx) {
        if (ctx == null) {
            return null;
        }

        SQLOrderingSpecification x = null;
        if (ctx.ASC() != null) {
            x = SQLOrderingSpecification.ASC;
        } else if (ctx.DESC() != null) {
            x = SQLOrderingSpecification.DESC;
        }
        return x;
    }


    public SQLInTimeAction of(MySQLSQLStatementParser.IntimeActionContext ctx) {
        if (ctx == null) {
            return null;
        }

        SQLInTimeAction x = null;
        if (ctx.ONLINE() != null) {
            x = SQLInTimeAction.ONLINE;
        } else if (ctx.OFFLINE() != null) {
            x = SQLInTimeAction.OFFLINE;
        }
        return x;
    }

    public SQLIndexCategory of(MySQLSQLStatementParser.IndexCategoryContext ctx) {
        if (ctx == null) {
            return null;
        }

        SQLIndexCategory x = null;
        if (ctx.UNIQUE() != null) {
            x = SQLIndexCategory.UNIQUE;
        } else if (ctx.FULLTEXT() != null) {
            x = SQLIndexCategory.FULLTEXT;
        } else if (ctx.SPATIAL() != null) {
            x = SQLIndexCategory.SPATIAL;
        }
        return x;
    }


    public SQLKeyViolate of(MySQLSQLStatementParser.KeyViolateContext ctx) {
        if (ctx == null) {
            return null;
        }

        SQLKeyViolate x = null;
        if (ctx.IGNORE() != null) {
            x = SQLKeyViolate.IGNORE;
        } else if (ctx.REPLACE() != null) {
            x = SQLKeyViolate.REPLACE;
        }
        return x;
    }


    public SQLIndexFormat of(MySQLSQLStatementParser.IndexFormatContext ctx) {
        if (ctx == null) {
            return null;
        }

        SQLIndexFormat x = null;
        if (ctx.INDEX() != null) {
            x = SQLIndexFormat.INDEX;
        } else if (ctx.KEY() != null) {
            x = SQLIndexFormat.KEY;
        }
        return x;
    }

    public SQLIndexType of(MySQLSQLStatementParser.IndexTypeContext ctx) {
        if (ctx == null) {
            return null;
        }

        SQLIndexType x = null;
        if (ctx.BTREE() != null) {
            x = SQLIndexType.USING_BTREE;
        } else if (ctx.HASH() != null) {
            x = SQLIndexType.USING_HASH;
        }
        return x;
    }


    public SQLWithType of(MySQLSQLStatementParser.WithTypeContext ctx) {
        if (ctx == null) {
            return null;
        }

        SQLWithType x = null;
        if (ctx.WITH() != null) {
            x = SQLWithType.WITH;
        } else if (ctx.WITHOUT() != null) {
            x = SQLWithType.WITHOUT;
        }
        return x;
    }

    public SQLVisibleType of(MySQLSQLStatementParser.VisibleTypeContext ctx) {
        if (ctx == null) {
            return null;
        }

        SQLVisibleType x = null;
        if (ctx.VISIBLE() != null) {
            x = SQLVisibleType.VISIBLE;
        } else if (ctx.INVISIBLE() != null) {
            x = SQLVisibleType.INVISIBLE;
        }
        return x;
    }

    public SQLPriorityType of(MySQLSQLStatementParser.PriorityContext ctx) {
        if (ctx == null) {
            return null;
        }

        SQLPriorityType x = null;
        if (ctx.LOW_PRIORITY() != null) {
            x = SQLPriorityType.LOW_PRIORITY;
        } else if (ctx.DELAYED() != null) {
            x = SQLPriorityType.DELAYED;
        } else if (ctx.CONCURRENT() != null) {
            x = SQLPriorityType.CONCURRENT;
        } else if (ctx.HIGH_PRIORITY() != null) {
            x = SQLPriorityType.HIGH_PRIORITY;
        }
        return x;
    }
}
