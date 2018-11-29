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
package com.aliyun.gumiho.sql.dialect.drds.visitor;


import static com.aliyun.gumiho.sql.dialect.drds.parser.DRDSSQLStatementLexer.SEMI;

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
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.AbstractSQLReferencesConstraint;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.SQLColumnDefinition;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.SQLLikeClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.SQLTableElement;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.constraint.SQLConstraint;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.constraint.column.*;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.constraint.table.*;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.partition.ISQLPartitionBy;
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
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.index.SQLCreateIndexStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.index.SQLDropIndexStatement;
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
import com.aliyun.gumiho.sql.dialect.drds.ast.element.expr.table.partition.*;
import com.aliyun.gumiho.sql.dialect.drds.parser.DRDSSQLStatementParser;
import com.aliyun.gumiho.sql.dialect.drds.parser.DRDSSQLStatementParserBaseVisitor;
import com.aliyun.gumiho.sql.dialect.mysql.ast.element.expr.select.MySQLSQLOJTableReference;
import com.aliyun.gumiho.sql.dialect.mysql.ast.element.expr.select.MySQLSQLSelectQuery;
import com.aliyun.gumiho.sql.enums.DBType;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

/**
 * @author kongtong.ouyang onCondition 2018/3/6.
 */
public class DRDSSQLASTBuilderVisitor extends DRDSSQLStatementParserBaseVisitor<SQLObject> {


    private List<SQLObject> sqlObjects;

    public DRDSSQLASTBuilderVisitor() {
    }

    public DRDSSQLASTBuilderVisitor(List<SQLObject> sqlObjects) {
        this.sqlObjects = sqlObjects;
    }

    @Override
    public SQLObject visitParse(DRDSSQLStatementParser.ParseContext ctx) {
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
    public SQLCreateDatabaseStatement visitCreateDatabaseStatement(DRDSSQLStatementParser.CreateDatabaseStatementContext ctx) {
        SQLCreateDatabaseStatement x = new SQLCreateDatabaseStatement(DBType.DRDS);

        if (ctx.ifNotExists() != null) {
            x.setIfNotExists(true);
        }

        for (DRDSSQLStatementParser.CreateDatabaseOptionContext createDatabaseOptionContext : ctx.createDatabaseOption()) {
            SQLExpr item = (SQLExpr) visitChildren(createDatabaseOptionContext);
            x.addItem(item);
        }
        return x;
    }

    @Override
    public SQLCreateSchemaStatement visitCreateSchemaStatement(DRDSSQLStatementParser.CreateSchemaStatementContext ctx) {
        SQLCreateSchemaStatement x = new SQLCreateSchemaStatement(DBType.DRDS);

        if (ctx.ifNotExists() != null) {
            x.setIfNotExists(true);
        }

        for (DRDSSQLStatementParser.CreateDatabaseOptionContext createDatabaseOptionContext : ctx.createDatabaseOption()) {
            SQLExpr action = (SQLExpr) visitChildren(createDatabaseOptionContext);
            x.addAction(action);
        }
        return x;
    }

    @Override
    public SQLCreateEventStatement visitCreateEventStatement(DRDSSQLStatementParser.CreateEventStatementContext ctx) {
        SQLCreateEventStatement x = new SQLCreateEventStatement(DBType.DRDS);

        return x;
    }


    // ----- crate index start ---------------
    @Override
    public SQLCreateIndexStatement visitCreateIndexStatement(DRDSSQLStatementParser.CreateIndexStatementContext ctx) {
        SQLCreateIndexStatement x = new SQLCreateIndexStatement(DBType.DRDS);

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

        for (DRDSSQLStatementParser.CreateIndexStatementColumnContext createIndexStatementColumnContext : ctx.createIndexStatementColumn()) {
            SQLIndexColumn column = visitCreateIndexStatementColumn(createIndexStatementColumnContext);
            x.addColumn(column);
        }

        for (DRDSSQLStatementParser.CreateIndexStatementOptionContext createIndexStatementOptionContext : ctx.createIndexStatementOption()) {
            SQLExpr option = (SQLExpr) visitChildren(createIndexStatementOptionContext);
            x.addProperty(option);
        }
        return x;
    }

    @Override
    public SQLIndexColumn visitCreateIndexStatementColumn(DRDSSQLStatementParser.CreateIndexStatementColumnContext ctx) {
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
    public SQLAlgorithmOptionExpr visitAlgorithmOptionExpr(DRDSSQLStatementParser.AlgorithmOptionExprContext ctx) {
        if (ctx == null) {
            return null;
        }

        SQLExpr value;

        int tokenValue = ctx.algType.getType();
        switch (tokenValue) {
            case DRDSSQLStatementParser.INPLACE:
                value = SQLReserved.INPLACE.ofExpr();
                break;
            case DRDSSQLStatementParser.COPY:
                value = SQLReserved.COPY.ofExpr();
                break;
            default:
                value = SQLReserved.DEFAULT.ofExpr();
                break;
        }
        return new SQLAlgorithmOptionExpr(value);
    }

    @Override
    public SQLLockOptionExpr visitLockOptionExpr(DRDSSQLStatementParser.LockOptionExprContext ctx) {
        SQLLockOptionExpr x = new SQLLockOptionExpr();
        SQLExpr value;

        int tokenValue = ctx.lockType.getType();
        switch (tokenValue) {
            case DRDSSQLStatementParser.NONE:
                value = SQLReserved.NONE.ofExpr();
                break;
            case DRDSSQLStatementParser.SHARED:
                value = SQLReserved.SHARED.ofExpr();
                break;
            case DRDSSQLStatementParser.EXCLUSIVE:
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
    public SQLObject visitCreateLogfileGroupStatement(DRDSSQLStatementParser.CreateLogfileGroupStatementContext ctx) {
        return super.visitCreateLogfileGroupStatement(ctx);
    }

    @Override
    public SQLObject visitCreateProcedureStatement(DRDSSQLStatementParser.CreateProcedureStatementContext ctx) {
        return super.visitCreateProcedureStatement(ctx);
    }

    @Override
    public SQLObject visitCreateFunctionStatement(DRDSSQLStatementParser.CreateFunctionStatementContext ctx) {
        return super.visitCreateFunctionStatement(ctx);
    }


    // ----- server statement Start --------------------------
    @Override
    public SQLCreateServerStatement visitCreateServerStatement(DRDSSQLStatementParser.CreateServerStatementContext ctx) {
        SQLCreateServerStatement x = new SQLCreateServerStatement(DBType.DRDS);

        SQLName name = visitNameIdentifier(ctx.name);
        x.setName(name);

        SQLName wrapper = visitNameIdentifier(ctx.wrapper);
        x.setWrapper(wrapper);

        for (DRDSSQLStatementParser.ServerOptionContext serverOptionContext : ctx.serverOption()) {
            ISQLServerOption option = (ISQLServerOption) visitChildren(serverOptionContext);
            x.addOption(option);
        }
        return x;
    }

    @Override
    public SQLServerHostOption visitServerHostOption(DRDSSQLStatementParser.ServerHostOptionContext ctx) {
        SQLServerHostOption x = new SQLServerHostOption();
        return x;
    }

    @Override
    public SQLObject visitServerDatabaseOption(DRDSSQLStatementParser.ServerDatabaseOptionContext ctx) {
        return super.visitServerDatabaseOption(ctx);
    }

    @Override
    public SQLObject visitServerUserOption(DRDSSQLStatementParser.ServerUserOptionContext ctx) {
        return super.visitServerUserOption(ctx);
    }

    @Override
    public SQLObject visitServerPasswordOption(DRDSSQLStatementParser.ServerPasswordOptionContext ctx) {
        return super.visitServerPasswordOption(ctx);
    }

    @Override
    public SQLObject visitServerSocketOption(DRDSSQLStatementParser.ServerSocketOptionContext ctx) {
        return super.visitServerSocketOption(ctx);
    }

    @Override
    public SQLObject visitServerOwnerOption(DRDSSQLStatementParser.ServerOwnerOptionContext ctx) {
        return super.visitServerOwnerOption(ctx);
    }

    @Override
    public SQLObject visitServerPortOption(DRDSSQLStatementParser.ServerPortOptionContext ctx) {
        return super.visitServerPortOption(ctx);
    }
    // ----- server statement End --------------------------


    // ----- table statement Start --------------------------
    @Override
    public SQLCreateTableStatement visitCreateTableStatement(DRDSSQLStatementParser.CreateTableStatementContext ctx) {
        SQLCreateTableStatement x = new SQLCreateTableStatement(DBType.DRDS);

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
        for (DRDSSQLStatementParser.TableElementContext tableElementContext : ctx.tableElement()) {
            SQLTableElement tableElement = visitTableElement(tableElementContext);
            x.addTableElement(tableElement);
        }

        for (DRDSSQLStatementParser.TableOptionContext tableOptionContext : ctx.tableOption()) {
            SQLExpr property = (SQLExpr) visit(tableOptionContext);
            x.addProperty(property);
        }

        if (ctx.iDBPartitionBy() != null) {
            ISQLPartitionBy partitionBy = (ISQLPartitionBy) visit(ctx.iDBPartitionBy());
            x.setPartitionBy(partitionBy);
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
    public SQLTableElement visitTableElement(DRDSSQLStatementParser.TableElementContext ctx) {
        return (SQLTableElement) super.visitChildren(ctx);
    }

    @Override
    public SQLColumnDefinition visitColumnDefinition(DRDSSQLStatementParser.ColumnDefinitionContext ctx) {
        SQLColumnDefinition x = new SQLColumnDefinition();

        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);

        if (ctx.dataType() != null) {
            SQLDataType dataType = visitDataType(ctx.dataType());
            x.setDataType(dataType);
        }

        for (DRDSSQLStatementParser.ColumnConstraintContext columnConstraintContext : ctx.columnConstraint()) {
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
    public SQLLikeClause visitLikeClause(DRDSSQLStatementParser.LikeClauseContext ctx) {
        SQLLikeClause x = new SQLLikeClause();
        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);
        return x;
    }

    @Override
    public SQLNullColumnConstraint visitNullColumnConstraint(DRDSSQLStatementParser.NullColumnConstraintContext ctx) {
        return new SQLNullColumnConstraint();
    }

    @Override
    public SQLNotNullColumnConstraint visitNotNullColumnConstraint(DRDSSQLStatementParser.NotNullColumnConstraintContext ctx) {
        return new SQLNotNullColumnConstraint();
    }

    @Override
    public SQLAutoIncrementColumnConstraint visitAutoIncrementColumnConstraint(DRDSSQLStatementParser.AutoIncrementColumnConstraintContext ctx) {
        return new SQLAutoIncrementColumnConstraint();
    }

    @Override
    public SQLPrimaryKeyColumnConstraint visitPrimaryKeyColumnConstraint(DRDSSQLStatementParser.PrimaryKeyColumnConstraintContext ctx) {
        SQLPrimaryKeyColumnConstraint x = new SQLPrimaryKeyColumnConstraint();
        if (ctx.PRIMARY() == null) {
            x.setPrimary(false);
        }
        return x;
    }

    @Override
    public SQLUniqueColumnConstraint visitUniqueColumnConstraint(DRDSSQLStatementParser.UniqueColumnConstraintContext ctx) {
        SQLUniqueColumnConstraint x = new SQLUniqueColumnConstraint();
        if (ctx.KEY() != null) {
            x.setKey(true);
        }
        return x;
    }

    @Override
    public SQLCommentOptionExpr visitCommentClause(DRDSSQLStatementParser.CommentClauseContext ctx) {
        if (ctx == null) {
            return null;
        }
        SQLExpr expr = visitExpr(ctx.expr());
        return new SQLCommentOptionExpr(expr);
    }

    @Override
    public SQLFormatColumnConstraint visitFormatColumnConstraint(DRDSSQLStatementParser.FormatColumnConstraintContext ctx) {
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
    public SQLStorageColumnConstraint visitStorageColumnConstraint(DRDSSQLStatementParser.StorageColumnConstraintContext ctx) {
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
    public SQLReferencesColumnConstraint visitReferencesColumnConstraint(DRDSSQLStatementParser.ReferencesColumnConstraintContext ctx) {
        SQLReferencesColumnConstraint x = new SQLReferencesColumnConstraint();
        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setReferencedTable(name);

        for (DRDSSQLStatementParser.ConstraintColumnContext constraintColumnContext : ctx.constraintColumn()) {
            SQLConstraint.SQLColumn column = visitConstraintColumn(constraintColumnContext);
            x.addReferencedColumn(column);
        }

        if (ctx.matchType() != null) {
            SQLReferencesColumnConstraint.MatchType matchType = of(ctx.matchType());
            x.setMatchType(matchType);
        }

        for (DRDSSQLStatementParser.ReferenceTriggerActionContext referenceTriggerActionContext : ctx.referenceTriggerAction()) {
            AbstractSQLReferencesConstraint.SQLReferentialTriggerAction action = (AbstractSQLReferencesConstraint.SQLReferentialTriggerAction) visit(referenceTriggerActionContext);
            x.addAction(action);
        }

        return x;
    }

    @Override
    public SQLPrimaryKeyTableConstraint visitPrimaryKeyTableConstraint(DRDSSQLStatementParser.PrimaryKeyTableConstraintContext ctx) {
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

        for (DRDSSQLStatementParser.ConstraintColumnContext constraintColumnContext : ctx.constraintColumn()) {
            SQLConstraint.SQLColumn column = visitConstraintColumn(constraintColumnContext);
            x.addColumn(column);
        }

        return x;
    }

    @Override
    public SQLIndexTableConstraint visitIndexTableConstraint(DRDSSQLStatementParser.IndexTableConstraintContext ctx) {
        SQLIndexTableConstraint x = new SQLIndexTableConstraint();

        if (ctx.nameIdentifier() != null) {
            SQLName indexName = visitNameIdentifier(ctx.nameIdentifier());
            x.setIndexName(indexName);
        }

        if (ctx.indexType() != null) {
            SQLIndexType indexType = of(ctx.indexType());
            x.setIndexType(indexType);
        }

        for (DRDSSQLStatementParser.ConstraintColumnContext constraintColumnContext : ctx.constraintColumn()) {
            SQLConstraint.SQLColumn column = visitConstraintColumn(constraintColumnContext);
            x.addColumn(column);
        }

        for (DRDSSQLStatementParser.IndexOptionContext indexOptionContext : ctx.indexOption()) {
            SQLExpr option = (SQLExpr) visit(indexOptionContext);
            x.addOption(option);
        }

        return x;
    }

    @Override
    public SQLKeyTableConstraint visitKeyTableConstraint(DRDSSQLStatementParser.KeyTableConstraintContext ctx) {
        SQLKeyTableConstraint x = new SQLKeyTableConstraint();

        if (ctx.nameIdentifier() != null) {
            SQLName indexName = visitNameIdentifier(ctx.nameIdentifier());
            x.setIndexName(indexName);
        }

        if (ctx.indexType() != null) {
            SQLIndexType indexType = of(ctx.indexType());
            x.setIndexType(indexType);
        }

        for (DRDSSQLStatementParser.ConstraintColumnContext constraintColumnContext : ctx.constraintColumn()) {
            SQLConstraint.SQLColumn column = visitConstraintColumn(constraintColumnContext);
            x.addColumn(column);
        }

        for (DRDSSQLStatementParser.IndexOptionContext indexOptionContext : ctx.indexOption()) {
            SQLExpr option = (SQLExpr) visit(indexOptionContext);
            x.addOption(option);
        }
        return x;
    }

    @Override
    public SQLUniqueTableConstraint visitUniqueTableConstraint(DRDSSQLStatementParser.UniqueTableConstraintContext ctx) {
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

        for (DRDSSQLStatementParser.ConstraintColumnContext constraintColumnContext : ctx.constraintColumn()) {
            SQLConstraint.SQLColumn column = visitConstraintColumn(constraintColumnContext);
            x.addColumn(column);
        }

        for (DRDSSQLStatementParser.IndexOptionContext indexOptionContext : ctx.indexOption()) {
            SQLExpr option = (SQLExpr) visit(indexOptionContext);
            x.addOption(option);
        }

        return x;
    }

    @Override
    public SQLFullTextTableConstraint visitFullTextTableConstraint(DRDSSQLStatementParser.FullTextTableConstraintContext ctx) {
        SQLFullTextTableConstraint x = new SQLFullTextTableConstraint();
        if (ctx.indexFormat() != null) {
            SQLIndexFormat indexFormat = of(ctx.indexFormat());
            x.setIndexFormat(indexFormat);
        }
        if (ctx.nameIdentifier() != null) {
            SQLName indexName = visitNameIdentifier(ctx.nameIdentifier());
            x.setIndexName(indexName);
        }

        for (DRDSSQLStatementParser.ConstraintColumnContext constraintColumnContext : ctx.constraintColumn()) {
            SQLConstraint.SQLColumn column = visitConstraintColumn(constraintColumnContext);
            x.addColumn(column);
        }

        for (DRDSSQLStatementParser.IndexOptionContext indexOptionContext : ctx.indexOption()) {
            SQLExpr option = (SQLExpr) visit(indexOptionContext);
            x.addOption(option);
        }
        return x;
    }

    @Override
    public SQLSpatialTableConstraint visitSpatialTableConstraint(DRDSSQLStatementParser.SpatialTableConstraintContext ctx) {
        SQLSpatialTableConstraint x = new SQLSpatialTableConstraint();
        if (ctx.indexFormat() != null) {
            SQLIndexFormat indexFormat = of(ctx.indexFormat());
            x.setIndexFormat(indexFormat);
        }
        if (ctx.nameIdentifier() != null) {
            SQLName indexName = visitNameIdentifier(ctx.nameIdentifier());
            x.setIndexName(indexName);
        }

        for (DRDSSQLStatementParser.ConstraintColumnContext constraintColumnContext : ctx.constraintColumn()) {
            SQLConstraint.SQLColumn column = visitConstraintColumn(constraintColumnContext);
            x.addColumn(column);
        }

        for (DRDSSQLStatementParser.IndexOptionContext indexOptionContext : ctx.indexOption()) {
            SQLExpr option = (SQLExpr) visit(indexOptionContext);
            x.addOption(option);
        }
        return x;
    }

    @Override
    public SQLForeignKeyTableConstraint visitForeignKeyTableConstraint(DRDSSQLStatementParser.ForeignKeyTableConstraintContext ctx) {
        SQLForeignKeyTableConstraint x = new SQLForeignKeyTableConstraint();

        if (ctx.CONSTRAINT() != null) {
            x.setConstraint(true);
        }
        if (ctx.name != null) {
            SQLName name = visitNameIdentifier(ctx.name);
            x.setName(name);
        }

        for (DRDSSQLStatementParser.ConstraintColumnContext referencingColumnContext : ctx.referencingColumns) {
            SQLConstraint.SQLColumn referencingColumn = visitConstraintColumn(referencingColumnContext);
            x.addReferencingColumn(referencingColumn);
        }


        SQLName referencedTable = visitNameIdentifier(ctx.referencedTable);
        x.setReferencedTable(referencedTable);

        for (DRDSSQLStatementParser.ConstraintColumnContext referencedColumnContext : ctx.referencedColumns) {
            SQLConstraint.SQLColumn referencedColumn = visitConstraintColumn(referencedColumnContext);
            x.addReferencingColumn(referencedColumn);
        }

        if (ctx.matchType() != null) {
            SQLReferencesColumnConstraint.MatchType matchType = of(ctx.matchType());
            x.setMatchType(matchType);
        }

        for (DRDSSQLStatementParser.ReferenceTriggerActionContext referenceTriggerActionContext : ctx.referenceTriggerAction()) {
            AbstractSQLReferencesConstraint.SQLReferentialTriggerAction action = (AbstractSQLReferencesConstraint.SQLReferentialTriggerAction) visit(referenceTriggerActionContext);
            x.addAction(action);
        }

        return x;
    }

    @Override
    public SQLCheckTableConstraint visitCheckTableConstraint(DRDSSQLStatementParser.CheckTableConstraintContext ctx) {
        SQLCheckTableConstraint x = new SQLCheckTableConstraint();
        SQLExpr condition = visitExpr(ctx.expr());
        x.setCondition(condition);
        return x;
    }

    @Override
    public SQLConstraint.SQLColumn visitConstraintColumn(DRDSSQLStatementParser.ConstraintColumnContext ctx) {
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

    public SQLReferencesColumnConstraint.MatchType of(DRDSSQLStatementParser.MatchTypeContext ctx) {
        if (ctx == null) {
            return null;
        }
        String name = getText(ctx.children);
        return SQLReferencesColumnConstraint.MatchType.of(name);
    }

    @Override
    public SQLReferencesColumnConstraint.SQLOnDeleteAction visitOnDeleteAction(DRDSSQLStatementParser.OnDeleteActionContext ctx) {
        if (ctx == null) {
            return null;
        }
        SQLReferencesColumnConstraint.SQLOnDeleteAction x = new SQLReferencesColumnConstraint.SQLOnDeleteAction();
        SQLReferentialAction action = of(ctx.referenceControlType());
        x.setAction(action);
        return x;
    }

    @Override
    public SQLReferencesColumnConstraint.SQLOnUpdateAction visitOnUpdateAction(DRDSSQLStatementParser.OnUpdateActionContext ctx) {
        if (ctx == null) {
            return null;
        }
        SQLReferencesColumnConstraint.SQLOnUpdateAction x = new SQLReferencesColumnConstraint.SQLOnUpdateAction();
        SQLReferentialAction action = of(ctx.referenceControlType());
        x.setAction(action);
        return x;
    }

    public SQLReferentialAction of(DRDSSQLStatementParser.ReferenceControlTypeContext ctx) {
        if (ctx == null) {
            return null;
        }
        String name = getText(ctx.children);
        return SQLReferentialAction.of(name);
    }


    @Override
    public DRDSSQLDBPartitionByHash visitDBPartitionByHash(DRDSSQLStatementParser.DBPartitionByHashContext ctx) {
        DRDSSQLDBPartitionByHash x = new DRDSSQLDBPartitionByHash();

        for (DRDSSQLStatementParser.ExprContext exprContext : ctx.columns) {
            SQLExpr column = visitExpr(exprContext);
            x.addColumn(column);
        }


        if (ctx.iTBPartitionBy() != null) {
            IDRDSSQLTBPartitionBy tbPartitionBy = (IDRDSSQLTBPartitionBy) visit(ctx.iTBPartitionBy());
            x.setTbPartitionBy(tbPartitionBy);
        }

        return x;
    }

    @Override
    public DRDSSQLDBPartitionByRangeHash visitDBPartitionByRangeHash(DRDSSQLStatementParser.DBPartitionByRangeHashContext ctx) {
        DRDSSQLDBPartitionByRangeHash x = new DRDSSQLDBPartitionByRangeHash();

        for (DRDSSQLStatementParser.ExprContext exprContext : ctx.columns) {
            SQLExpr column = visitExpr(exprContext);
            x.addColumn(column);
        }


        if (ctx.iTBPartitionBy() != null) {
            IDRDSSQLTBPartitionBy tbPartitionBy = (IDRDSSQLTBPartitionBy) visit(ctx.iTBPartitionBy());
            x.setTbPartitionBy(tbPartitionBy);
        }

        return x;
    }

    @Override
    public DRDSSQLTBPartitionByHash visitTBPartitionByHash(DRDSSQLStatementParser.TBPartitionByHashContext ctx) {
        DRDSSQLTBPartitionByHash x = new DRDSSQLTBPartitionByHash();

        for (DRDSSQLStatementParser.ExprContext columnContext : ctx.columns) {
            SQLExpr column = visitExpr(columnContext);
            x.addColumn(column);
        }

        if (ctx.tbPartitionsNum != null) {
            SQLExpr tbPartitionsNum = visitExpr(ctx.tbPartitionsNum);
            x.setTbPartitionsNum(tbPartitionsNum);
        }

        return x;

    }

    @Override
    public DRDSSQLTBPartitionByRangeHash visitTBPartitionByRangeHash(DRDSSQLStatementParser.TBPartitionByRangeHashContext ctx) {
        DRDSSQLTBPartitionByRangeHash x = new DRDSSQLTBPartitionByRangeHash();

        for (DRDSSQLStatementParser.ExprContext columnContext : ctx.columns) {
            SQLExpr column = visitExpr(columnContext);
            x.addColumn(column);
        }

        if (ctx.tbPartitionsNum != null) {
            SQLExpr tbPartitionsNum = visitExpr(ctx.tbPartitionsNum);
            x.setTbPartitionsNum(tbPartitionsNum);
        }

        return x;
    }

    @Override
    public DRDSSQLTBPartitionByMM visitTBPartitionByMM(DRDSSQLStatementParser.TBPartitionByMMContext ctx) {
        DRDSSQLTBPartitionByMM x = new DRDSSQLTBPartitionByMM();

        for (DRDSSQLStatementParser.ExprContext columnContext : ctx.columns) {
            SQLExpr column = visitExpr(columnContext);
            x.addColumn(column);
        }

        if (ctx.tbPartitionsNum != null) {
            SQLExpr tbPartitionsNum = visitExpr(ctx.tbPartitionsNum);
            x.setTbPartitionsNum(tbPartitionsNum);
        }

        return x;
    }

    @Override
    public DRDSSQLTBPartitionByDD visitTBPartitionByDD(DRDSSQLStatementParser.TBPartitionByDDContext ctx) {
        DRDSSQLTBPartitionByDD x = new DRDSSQLTBPartitionByDD();

        for (DRDSSQLStatementParser.ExprContext columnContext : ctx.columns) {
            SQLExpr column = visitExpr(columnContext);
            x.addColumn(column);
        }

        if (ctx.tbPartitionsNum != null) {
            SQLExpr tbPartitionsNum = visitExpr(ctx.tbPartitionsNum);
            x.setTbPartitionsNum(tbPartitionsNum);
        }

        return x;
    }

    @Override
    public DRDSSQLTBPartitionByWeek visitTBPartitionByWeek(DRDSSQLStatementParser.TBPartitionByWeekContext ctx) {
        DRDSSQLTBPartitionByWeek x = new DRDSSQLTBPartitionByWeek();

        for (DRDSSQLStatementParser.ExprContext columnContext : ctx.columns) {
            SQLExpr column = visitExpr(columnContext);
            x.addColumn(column);
        }

        if (ctx.tbPartitionsNum != null) {
            SQLExpr tbPartitionsNum = visitExpr(ctx.tbPartitionsNum);
            x.setTbPartitionsNum(tbPartitionsNum);
        }

        return x;
    }

    @Override
    public DRDSSQLTBPartitionByDD visitTBPartitionByMMDD(DRDSSQLStatementParser.TBPartitionByMMDDContext ctx) {
        DRDSSQLTBPartitionByDD x = new DRDSSQLTBPartitionByDD();

        for (DRDSSQLStatementParser.ExprContext columnContext : ctx.columns) {
            SQLExpr column = visitExpr(columnContext);
            x.addColumn(column);
        }

        if (ctx.tbPartitionsNum != null) {
            SQLExpr tbPartitionsNum = visitExpr(ctx.tbPartitionsNum);
            x.setTbPartitionsNum(tbPartitionsNum);
        }

        return x;
    }

    // ----- table statement End --------------------------

    @Override
    public SQLObject visitCreateTablespaceStatement(DRDSSQLStatementParser.CreateTablespaceStatementContext ctx) {
        return super.visitCreateTablespaceStatement(ctx);
    }

    @Override
    public SQLObject visitCreateTablespaceInnodb(DRDSSQLStatementParser.CreateTablespaceInnodbContext ctx) {
        return super.visitCreateTablespaceInnodb(ctx);
    }

    @Override
    public SQLObject visitCreateTablespaceNdb(DRDSSQLStatementParser.CreateTablespaceNdbContext ctx) {
        return super.visitCreateTablespaceNdb(ctx);
    }

    @Override
    public SQLCreateTriggerStatement visitCreateTriggerStatement(DRDSSQLStatementParser.CreateTriggerStatementContext ctx) {
        SQLCreateTriggerStatement x = new SQLCreateTriggerStatement(DBType.DRDS);

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
    public SQLTriggerOrderingClause visitTriggerOrderingClause(DRDSSQLStatementParser.TriggerOrderingClauseContext ctx) {
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
    public SQLCreateViewStatement visitCreateViewStatement(DRDSSQLStatementParser.CreateViewStatementContext ctx) {
        SQLCreateViewStatement x = new SQLCreateViewStatement(DBType.DRDS);
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

        for (DRDSSQLStatementParser.ColumnDefinitionContext columnDefinitionContext : ctx.columnDefinition()) {
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
    public ISQLSubqueryRestrictionClause.SQLWithCheckOption visitWithCheckOption(DRDSSQLStatementParser.WithCheckOptionContext ctx) {
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
    public SQLObject visitCreateDatabaseOption(DRDSSQLStatementParser.CreateDatabaseOptionContext ctx) {
        return super.visitCreateDatabaseOption(ctx);
    }

    @Override
    public SQLDefinerOptionExpr visitDefinerOptionExpr(DRDSSQLStatementParser.DefinerOptionExprContext ctx) {
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
    public SQLObject visitPreciseSchedule(DRDSSQLStatementParser.PreciseScheduleContext ctx) {
        return super.visitPreciseSchedule(ctx);
    }

    @Override
    public SQLObject visitIntervalSchedule(DRDSSQLStatementParser.IntervalScheduleContext ctx) {
        return super.visitIntervalSchedule(ctx);
    }

    @Override
    public SQLObject visitTimestampValue(DRDSSQLStatementParser.TimestampValueContext ctx) {
        return super.visitTimestampValue(ctx);
    }

    @Override
    public SQLObject visitEnableType(DRDSSQLStatementParser.EnableTypeContext ctx) {
        return super.visitEnableType(ctx);
    }

    @Override
    public SQLObject visitIndexOption(DRDSSQLStatementParser.IndexOptionContext ctx) {
        return super.visitIndexOption(ctx);
    }

    @Override
    public SQLObject visitIndexOptionKeyBlockSize(DRDSSQLStatementParser.IndexOptionKeyBlockSizeContext ctx) {
        return super.visitIndexOptionKeyBlockSize(ctx);
    }

    @Override
    public SQLObject visitIndexOptionUsingBtree(DRDSSQLStatementParser.IndexOptionUsingBtreeContext ctx) {
        return super.visitIndexOptionUsingBtree(ctx);
    }

    @Override
    public SQLObject visitIndexOptionUsingHash(DRDSSQLStatementParser.IndexOptionUsingHashContext ctx) {
        return super.visitIndexOptionUsingHash(ctx);
    }

    @Override
    public SQLObject visitIndexOptionWithParser(DRDSSQLStatementParser.IndexOptionWithParserContext ctx) {
        return super.visitIndexOptionWithParser(ctx);
    }

    @Override
    public SQLObject visitIndexAttributeVisible(DRDSSQLStatementParser.IndexAttributeVisibleContext ctx) {
        return super.visitIndexAttributeVisible(ctx);
    }

    @Override
    public SQLObject visitIndexAttributeInvisible(DRDSSQLStatementParser.IndexAttributeInvisibleContext ctx) {
        return super.visitIndexAttributeInvisible(ctx);
    }

    @Override
    public SQLObject visitIndexOptionCommentOption(DRDSSQLStatementParser.IndexOptionCommentOptionContext ctx) {
        return super.visitIndexOptionCommentOption(ctx);
    }

    @Override
    public SQLParameterDeclaration visitParameterDeclaration(DRDSSQLStatementParser.ParameterDeclarationContext ctx) {
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
    public SQLObject visitRoutineComment(DRDSSQLStatementParser.RoutineCommentContext ctx) {
        return super.visitRoutineComment(ctx);
    }

    @Override
    public SQLObject visitRoutineLanguage(DRDSSQLStatementParser.RoutineLanguageContext ctx) {
        return super.visitRoutineLanguage(ctx);
    }

    @Override
    public SQLObject visitRoutineBehavior(DRDSSQLStatementParser.RoutineBehaviorContext ctx) {
        return super.visitRoutineBehavior(ctx);
    }

    @Override
    public SQLObject visitRoutineData(DRDSSQLStatementParser.RoutineDataContext ctx) {
        return super.visitRoutineData(ctx);
    }

    @Override
    public SQLObject visitRoutineSecurity(DRDSSQLStatementParser.RoutineSecurityContext ctx) {
        return super.visitRoutineSecurity(ctx);
    }


    @Override
    public SQLObject visitAlterSimpleDatabase(DRDSSQLStatementParser.AlterSimpleDatabaseContext ctx) {
        return super.visitAlterSimpleDatabase(ctx);
    }

    @Override
    public SQLObject visitAlterUpgradeName(DRDSSQLStatementParser.AlterUpgradeNameContext ctx) {
        return super.visitAlterUpgradeName(ctx);
    }

    @Override
    public SQLObject visitAlterEventStatement(DRDSSQLStatementParser.AlterEventStatementContext ctx) {
        return super.visitAlterEventStatement(ctx);
    }

    @Override
    public SQLObject visitAlterFunctionStatement(DRDSSQLStatementParser.AlterFunctionStatementContext ctx) {
        return super.visitAlterFunctionStatement(ctx);
    }

    @Override
    public SQLObject visitAlterInstanceStatement(DRDSSQLStatementParser.AlterInstanceStatementContext ctx) {
        return super.visitAlterInstanceStatement(ctx);
    }

    @Override
    public SQLObject visitAlterLogfileGroupStatement(DRDSSQLStatementParser.AlterLogfileGroupStatementContext ctx) {
        return super.visitAlterLogfileGroupStatement(ctx);
    }

    @Override
    public SQLObject visitAlterProcedureStatement(DRDSSQLStatementParser.AlterProcedureStatementContext ctx) {
        return super.visitAlterProcedureStatement(ctx);
    }

    @Override
    public SQLObject visitAlterServerStatement(DRDSSQLStatementParser.AlterServerStatementContext ctx) {
        return super.visitAlterServerStatement(ctx);
    }

    @Override
    public SQLAlterTableStatement visitAlterTableStatement(DRDSSQLStatementParser.AlterTableStatementContext ctx) {
        SQLAlterTableStatement x = new SQLAlterTableStatement(DBType.DRDS);

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

        for (DRDSSQLStatementParser.AlterTableItemContext alterTableItemContext : ctx.alterTableItem()) {
            SQLExpr item = (SQLExpr) visit(alterTableItemContext);
            x.addItem(item);
        }

        if (ctx.iDBPartitionBy() != null) {
            IDRDSSQLDBPartitionBy partitionBy = (IDRDSSQLDBPartitionBy) visit(ctx.iDBPartitionBy());
            x.setPartitionBy(partitionBy);
        }

        return x;
    }

    @Override
    public SQLObject visitAlterByTableOption(DRDSSQLStatementParser.AlterByTableOptionContext ctx) {
        return super.visitAlterByTableOption(ctx);
    }

    @Override
    public SQLObject visitAlterTableAddColumnAction(DRDSSQLStatementParser.AlterTableAddColumnActionContext ctx) {
        return super.visitAlterTableAddColumnAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableAddTableConstraintAction(DRDSSQLStatementParser.AlterTableAddTableConstraintActionContext ctx) {
        return super.visitAlterTableAddTableConstraintAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableAlgorithmAction(DRDSSQLStatementParser.AlterTableAlgorithmActionContext ctx) {
        return super.visitAlterTableAlgorithmAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableAlterColumnAction(DRDSSQLStatementParser.AlterTableAlterColumnActionContext ctx) {
        return super.visitAlterTableAlterColumnAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableAlterIndexConstraintAction(DRDSSQLStatementParser.AlterTableAlterIndexConstraintActionContext ctx) {
        return super.visitAlterTableAlterIndexConstraintAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableChangeColumnAction(DRDSSQLStatementParser.AlterTableChangeColumnActionContext ctx) {
        return super.visitAlterTableChangeColumnAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableDefaultCharsetAction(DRDSSQLStatementParser.AlterTableDefaultCharsetActionContext ctx) {
        return super.visitAlterTableDefaultCharsetAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableConvertCharsetAction(DRDSSQLStatementParser.AlterTableConvertCharsetActionContext ctx) {
        return super.visitAlterTableConvertCharsetAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableDisableKeysAction(DRDSSQLStatementParser.AlterTableDisableKeysActionContext ctx) {
        return super.visitAlterTableDisableKeysAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableEnableKeysAction(DRDSSQLStatementParser.AlterTableEnableKeysActionContext ctx) {
        return super.visitAlterTableEnableKeysAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableDiscardTablespaceAction(DRDSSQLStatementParser.AlterTableDiscardTablespaceActionContext ctx) {
        return super.visitAlterTableDiscardTablespaceAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableImportTablespaceAction(DRDSSQLStatementParser.AlterTableImportTablespaceActionContext ctx) {
        return super.visitAlterTableImportTablespaceAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableDropColumnAction(DRDSSQLStatementParser.AlterTableDropColumnActionContext ctx) {
        return super.visitAlterTableDropColumnAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableDropIndexConstraintAction(DRDSSQLStatementParser.AlterTableDropIndexConstraintActionContext ctx) {
        return super.visitAlterTableDropIndexConstraintAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableDropKeyConstraintAction(DRDSSQLStatementParser.AlterTableDropKeyConstraintActionContext ctx) {
        return super.visitAlterTableDropKeyConstraintAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableDropPrimaryKeyConstraintAction(DRDSSQLStatementParser.AlterTableDropPrimaryKeyConstraintActionContext ctx) {
        return super.visitAlterTableDropPrimaryKeyConstraintAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableDropForeignKeyConstraintAction(DRDSSQLStatementParser.AlterTableDropForeignKeyConstraintActionContext ctx) {
        return super.visitAlterTableDropForeignKeyConstraintAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableForceAction(DRDSSQLStatementParser.AlterTableForceActionContext ctx) {
        return super.visitAlterTableForceAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableLockAction(DRDSSQLStatementParser.AlterTableLockActionContext ctx) {
        return super.visitAlterTableLockAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableModifyColumnAction(DRDSSQLStatementParser.AlterTableModifyColumnActionContext ctx) {
        return super.visitAlterTableModifyColumnAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableOrderByColumnAction(DRDSSQLStatementParser.AlterTableOrderByColumnActionContext ctx) {
        return super.visitAlterTableOrderByColumnAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableRenameColumnAction(DRDSSQLStatementParser.AlterTableRenameColumnActionContext ctx) {
        return super.visitAlterTableRenameColumnAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableRenameIndexConstraintAction(DRDSSQLStatementParser.AlterTableRenameIndexConstraintActionContext ctx) {
        return super.visitAlterTableRenameIndexConstraintAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableRenameKeyConstraintAction(DRDSSQLStatementParser.AlterTableRenameKeyConstraintActionContext ctx) {
        return super.visitAlterTableRenameKeyConstraintAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableRenameTableAction(DRDSSQLStatementParser.AlterTableRenameTableActionContext ctx) {
        return super.visitAlterTableRenameTableAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableWithoutValidateAction(DRDSSQLStatementParser.AlterTableWithoutValidateActionContext ctx) {
        return super.visitAlterTableWithoutValidateAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableWithValidateAction(DRDSSQLStatementParser.AlterTableWithValidateActionContext ctx) {
        return super.visitAlterTableWithValidateAction(ctx);
    }
//
//    @Override
//    public SQLObject visitAlterTableAddPartitionAction(DRDSSQLStatementParser.AlterTableAddPartitionActionContext ctx) {
//        return super.visitAlterTableAddPartitionAction(ctx);
//    }

    @Override
    public SQLObject visitAlterTableDropPartitionAction(DRDSSQLStatementParser.AlterTableDropPartitionActionContext ctx) {
        return super.visitAlterTableDropPartitionAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableDiscardPartitionAction(DRDSSQLStatementParser.AlterTableDiscardPartitionActionContext ctx) {
        return super.visitAlterTableDiscardPartitionAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableImportPartitionAction(DRDSSQLStatementParser.AlterTableImportPartitionActionContext ctx) {
        return super.visitAlterTableImportPartitionAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableTruncatePartitionAction(DRDSSQLStatementParser.AlterTableTruncatePartitionActionContext ctx) {
        return super.visitAlterTableTruncatePartitionAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableCoalescePartitionAction(DRDSSQLStatementParser.AlterTableCoalescePartitionActionContext ctx) {
        return super.visitAlterTableCoalescePartitionAction(ctx);
    }

//    @Override
//    public SQLObject visitAlterTableReorganizePartitionAction(DRDSSQLStatementParser.AlterTableReorganizePartitionActionContext ctx) {
//        return super.visitAlterTableReorganizePartitionAction(ctx);
//    }

    @Override
    public SQLObject visitAlterTableExchangePartitionAction(DRDSSQLStatementParser.AlterTableExchangePartitionActionContext ctx) {
        return super.visitAlterTableExchangePartitionAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableAnalyzePartitiionAction(DRDSSQLStatementParser.AlterTableAnalyzePartitiionActionContext ctx) {
        return super.visitAlterTableAnalyzePartitiionAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableCheckPartitionAction(DRDSSQLStatementParser.AlterTableCheckPartitionActionContext ctx) {
        return super.visitAlterTableCheckPartitionAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableOptimizePartitionAction(DRDSSQLStatementParser.AlterTableOptimizePartitionActionContext ctx) {
        return super.visitAlterTableOptimizePartitionAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableRebuildPartitionAction(DRDSSQLStatementParser.AlterTableRebuildPartitionActionContext ctx) {
        return super.visitAlterTableRebuildPartitionAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableRepairPartitionAction(DRDSSQLStatementParser.AlterTableRepairPartitionActionContext ctx) {
        return super.visitAlterTableRepairPartitionAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableRemovePartitioningAction(DRDSSQLStatementParser.AlterTableRemovePartitioningActionContext ctx) {
        return super.visitAlterTableRemovePartitioningAction(ctx);
    }

    @Override
    public SQLObject visitAlterTableUpgradePartitioningAction(DRDSSQLStatementParser.AlterTableUpgradePartitioningActionContext ctx) {
        return super.visitAlterTableUpgradePartitioningAction(ctx);
    }

//    @Override
//    public SQLObject visitAlterTableColumnActionProperty(DRDSSQLStatementParser.AlterTableColumnActionPropertyContext ctx) {
//        return super.visitAlterTableColumnActionProperty(ctx);
//    }

    @Override
    public SQLObject visitAlterColumnSetDefaultAction(DRDSSQLStatementParser.AlterColumnSetDefaultActionContext ctx) {
        return super.visitAlterColumnSetDefaultAction(ctx);
    }

    @Override
    public SQLObject visitAlterColumnDropDefaultAction(DRDSSQLStatementParser.AlterColumnDropDefaultActionContext ctx) {
        return super.visitAlterColumnDropDefaultAction(ctx);
    }

    @Override
    public SQLObject visitAlterTablePartitionItem(DRDSSQLStatementParser.AlterTablePartitionItemContext ctx) {
        return super.visitAlterTablePartitionItem(ctx);
    }

    @Override
    public SQLObject visitAlterTablespaceStatement(DRDSSQLStatementParser.AlterTablespaceStatementContext ctx) {
        return super.visitAlterTablespaceStatement(ctx);
    }

    @Override
    public SQLObject visitAlterViewStatement(DRDSSQLStatementParser.AlterViewStatementContext ctx) {
        return super.visitAlterViewStatement(ctx);
    }

    @Override
    public SQLDropDatabaseStatement visitDropDatabaseStatement(DRDSSQLStatementParser.DropDatabaseStatementContext ctx) {
        SQLDropDatabaseStatement x = new SQLDropDatabaseStatement(DBType.DRDS);
        if (ctx.ifExists() != null) {
            x.setIfExists(true);
        }
        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);
        return x;
    }

    @Override
    public SQLDropSchemaStatement visitDropSchemaStatement(DRDSSQLStatementParser.DropSchemaStatementContext ctx) {
        SQLDropSchemaStatement x = new SQLDropSchemaStatement(DBType.DRDS);
        if (ctx.ifExists() != null) {
            x.setIfExists(true);
        }
        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.addName(name);
        return x;
    }

    @Override
    public SQLDropEventStatement visitDropEventStatement(DRDSSQLStatementParser.DropEventStatementContext ctx) {
        SQLDropEventStatement x = new SQLDropEventStatement(DBType.DRDS);
        if (ctx.ifExists() != null) {
            x.setIfExists(true);
        }
        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);
        return x;
    }

    @Override
    public SQLDropIndexStatement visitDropIndexStatement(DRDSSQLStatementParser.DropIndexStatementContext ctx) {
        SQLDropIndexStatement x = new SQLDropIndexStatement(DBType.DRDS);

        if (ctx.intimeAction() != null) {
            SQLInTimeAction inTimeAction = of(ctx.intimeAction());
            x.setInTimeAction(inTimeAction);
        }

        SQLName name = visitNameIdentifier(ctx.index);
        x.addName(name);

        SQLName table = visitNameIdentifier(ctx.table);
        x.setTable(table);

        for (DRDSSQLStatementParser.DropIndexStatementOptionContext dropIndexStatementOptionContext : ctx.dropIndexStatementOption()) {
            SQLExpr option = (SQLExpr) visitChildren(dropIndexStatementOptionContext);
            x.addOption(option);
        }
        return x;
    }

    @Override
    public SQLObject visitDropIndexStatementOption(DRDSSQLStatementParser.DropIndexStatementOptionContext ctx) {
        return super.visitDropIndexStatementOption(ctx);
    }

    @Override
    public SQLObject visitDropLogfileGroupStatement(DRDSSQLStatementParser.DropLogfileGroupStatementContext ctx) {
        return super.visitDropLogfileGroupStatement(ctx);
    }

    @Override
    public SQLObject visitDropProcedureStatement(DRDSSQLStatementParser.DropProcedureStatementContext ctx) {
        return super.visitDropProcedureStatement(ctx);
    }

    @Override
    public SQLObject visitDropFunctionStatement(DRDSSQLStatementParser.DropFunctionStatementContext ctx) {
        return super.visitDropFunctionStatement(ctx);
    }

    @Override
    public SQLDropServerStatement visitDropServerStatement(DRDSSQLStatementParser.DropServerStatementContext ctx) {
        SQLDropServerStatement x = new SQLDropServerStatement(DBType.DRDS);
        if (ctx.ifExists() != null) {
            x.setIfExists(true);
        }
        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);
        return x;
    }

    @Override
    public SQLDropTableStatement visitDropTableStatement(DRDSSQLStatementParser.DropTableStatementContext ctx) {
        SQLDropTableStatement x = new SQLDropTableStatement(DBType.DRDS);
        if (ctx.TEMPORARY() != null) {
            x.setTemporary(true);
        }

        if (ctx.ifExists() != null) {
            x.setIfExists(true);
        }

        for (DRDSSQLStatementParser.NameIdentifierContext nameIdentifierContext : ctx.nameIdentifier()) {
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
    public SQLObject visitDropTablespaceStatement(DRDSSQLStatementParser.DropTablespaceStatementContext ctx) {
        return super.visitDropTablespaceStatement(ctx);
    }

    @Override
    public SQLDropTriggerStatement visitDropTriggerStatement(DRDSSQLStatementParser.DropTriggerStatementContext ctx) {
        SQLDropTriggerStatement x = new SQLDropTriggerStatement(DBType.DRDS);
        if (ctx.ifExists() != null) {
            x.setIfExists(true);
        }
        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);
        return x;
    }

    @Override
    public SQLDropViewStatement visitDropViewStatement(DRDSSQLStatementParser.DropViewStatementContext ctx) {
        SQLDropViewStatement x = new SQLDropViewStatement(DBType.DRDS);

        if (ctx.ifExists() != null) {
            x.setIfExists(true);
        }

        for (DRDSSQLStatementParser.NameIdentifierContext nameIdentifierContext : ctx.nameIdentifier()) {
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
    public SQLRenameTableStatement visitRenameTableStatement(DRDSSQLStatementParser.RenameTableStatementContext ctx) {
        SQLRenameTableStatement x = new SQLRenameTableStatement(DBType.DRDS);
        for (DRDSSQLStatementParser.RenameTableClauseContext renameTableClauseContext : ctx.renameTableClause()) {
            SQLRenameTableStatement.Item item = visitRenameTableClause(renameTableClauseContext);
            x.addItem(item);
        }
        return x;
    }

    @Override
    public SQLRenameTableStatement.Item visitRenameTableClause(DRDSSQLStatementParser.RenameTableClauseContext ctx) {

        SQLName oldName = visitNameIdentifier(ctx.nameIdentifier(0));
        SQLName newName = visitNameIdentifier(ctx.nameIdentifier(1));

        SQLRenameTableStatement.Item x = new SQLRenameTableStatement.Item(oldName, newName);
        return x;
    }

    @Override
    public SQLTruncateTableStatement visitTruncateTableStatement(DRDSSQLStatementParser.TruncateTableStatementContext ctx) {
        SQLTruncateTableStatement x = new SQLTruncateTableStatement(DBType.DRDS);

        if (ctx.TABLE() == null) {
            x.setTable(false);
        }

        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.addName(name);

        return x;
    }

    // ----- Select ------------
    @Override
    public SQLSelectStatement visitSelectStatement(DRDSSQLStatementParser.SelectStatementContext ctx) {
        SQLSelectStatement x = new SQLSelectStatement(DBType.DRDS);
        ISQLSelectQuery query = visitISelectQuery(ctx.iSelectQuery());
        x.setQuery(query);
        return x;
    }

    @Override
    public ISQLSelectQuery visitISelectQuery(DRDSSQLStatementParser.ISelectQueryContext ctx) {
        return (ISQLSelectQuery) super.visitChildren(ctx);
    }

    @Override
    public ISQLSelectQuery visitSelectQueryBasic(DRDSSQLStatementParser.SelectQueryBasicContext ctx) {
        return (ISQLSelectQuery) super.visitChildren(ctx);
    }

    @Override
    public MySQLSQLSelectQuery visitSelectQuery(DRDSSQLStatementParser.SelectQueryContext ctx) {
        MySQLSQLSelectQuery x = new MySQLSQLSelectQuery();

        if (ctx.setQuantifier() != null) {
            SQLSetQuantifier setQuantifier = of(ctx.setQuantifier());
            x.setSetQuantifier(setQuantifier);
        }

        for (DRDSSQLStatementParser.SelectItemContext selectItemContext : ctx.selectItem()) {
            SQLSelectItem selectItem = visitSelectItem(selectItemContext);
            x.addSelectItem(selectItem);
        }

        DRDSSQLStatementParser.FromClauseContext fromClauseContext = ctx.fromClause();
        if (fromClauseContext != null) {
            SQLFromClause fromClause = visitFromClause(fromClauseContext);
            x.setFromClause(fromClause);
        }

        DRDSSQLStatementParser.WhereClauseContext whereClauseContext = ctx.whereClause();
        if (whereClauseContext != null) {
            SQLWhereClause whereClause = visitWhereClause(whereClauseContext);
            x.setWhereClause(whereClause);
        }

        DRDSSQLStatementParser.GroupByClauseContext groupByClauseContext = ctx.groupByClause();
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

        DRDSSQLStatementParser.ILockClauseContext lockClauseContext = ctx.iLockClause();
        if (lockClauseContext != null) {
            ISQLLockClause lockClause = (ISQLLockClause) visit(lockClauseContext);
            x.setLockClause(lockClause);
        }

        return x;
    }


    @Override
    public SQLParenSelectQuery visitSelectParenQuery(DRDSSQLStatementParser.SelectParenQueryContext ctx) {
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

        DRDSSQLStatementParser.ILockClauseContext lockClauseContext = ctx.iLockClause();
        if (lockClauseContext != null) {
            ISQLLockClause lockClause = (ISQLLockClause) visit(lockClauseContext);
            x.setLockClause(lockClause);
        }
        return x;
    }

    @Override
    public SQLObject visitSelectUnionQuery(DRDSSQLStatementParser.SelectUnionQueryContext ctx) {
        ISQLSelectQuery left = visitSelectQueryBasic(ctx.selectQueryBasic(0));

        SQLUnionOperator operator = of(ctx.unionOperator(0));
        ISQLSelectQuery right = visitSelectQueryBasic(ctx.selectQueryBasic(1));

        SQLSelectUnionQuery x = new SQLSelectUnionQuery(left, operator, right);

        for (int i = 2; i < ctx.selectQueryBasic().size(); i++) {
            DRDSSQLStatementParser.SelectQueryBasicContext queryContext = ctx.selectQueryBasic(i);
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

        DRDSSQLStatementParser.ILockClauseContext lockClauseContext = ctx.iLockClause();
        if (lockClauseContext != null) {
            ISQLLockClause lockClause = (ISQLLockClause) visit(lockClauseContext);
            x.setLockClause(lockClause);
        }
        return x;
    }

    public SQLSetQuantifier of(DRDSSQLStatementParser.SetQuantifierContext ctx) {
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

    public SQLUnionOperator of(DRDSSQLStatementParser.UnionOperatorContext ctx) {
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
    public SQLSelectItem visitSelectItem(DRDSSQLStatementParser.SelectItemContext ctx) {
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
    public SQLObject visitSelectItemAlias(DRDSSQLStatementParser.SelectItemAliasContext ctx) {
        return super.visitSelectItemAlias(ctx);
    }

    @Override
    public SQLFromClause visitFromClause(DRDSSQLStatementParser.FromClauseContext ctx) {
        ISQLTableReference tableReference = (ISQLTableReference) visit(ctx.iTableReference());
        return new SQLFromClause(tableReference);
    }

    @Override
    public SQLObjectNameTableReference visitObjectNameTableReference(DRDSSQLStatementParser.ObjectNameTableReferenceContext ctx) {
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

        for (DRDSSQLStatementParser.IIndexHintContext indexHintContext : ctx.indexes) {
            SQLIndexHint index = (SQLIndexHint) visit(indexHintContext);
            x.addIndexHint(index);
        }

        return x;
    }

    @Override
    public MySQLSQLOJTableReference visitOjTableReference(DRDSSQLStatementParser.OjTableReferenceContext ctx) {
        MySQLSQLOJTableReference x = new MySQLSQLOJTableReference();
        ISQLTableReference tableReference = (ISQLTableReference) visit(ctx.iTableReference());
        x.setTableReference(tableReference);
        return x;
    }

    @Override
    public SQLSubQueryTableReference visitSubQueryTableReference(DRDSSQLStatementParser.SubQueryTableReferenceContext ctx) {
        SQLSubQueryTableReference x = new SQLSubQueryTableReference();

        ISQLSelectQuery subQuery = visitISelectQuery(ctx.iSelectQuery());
        x.setSubQuery(subQuery);

        if (ctx.AS() != null) {
            x.setAs(true);
        }

        SQLIdentifier alias = (SQLIdentifier) visitNameIdentifier(ctx.nameIdentifier());
        x.setAlias(alias);

        for (DRDSSQLStatementParser.ExprContext columnContext : ctx.columns) {
            SQLExpr column = visitExpr(columnContext);
            x.addColumn(column);
        }

        return x;
    }

    @Override
    public ISQLTableReference visitParenTableReference(DRDSSQLStatementParser.ParenTableReferenceContext ctx) {
        ISQLTableReference x = (ISQLTableReference) visit(ctx.iTableReference());
        x.setParen(true);
        return x;
    }

    @Override
    public SQLJoinTableReference visitJoinTableReference(DRDSSQLStatementParser.JoinTableReferenceContext ctx) {

        ISQLTableReference left = (ISQLTableReference) visit(ctx.tableReferenceBasic());
        SQLJoinTableReference x = null;
        for (DRDSSQLStatementParser.RightJoinClauseContext rightJoinClauseContext : ctx.rightJoinClause()) {
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
    public SQLPartitionClause visitPartitionClause(DRDSSQLStatementParser.PartitionClauseContext ctx) {
        SQLPartitionClause x = new SQLPartitionClause();
        for (DRDSSQLStatementParser.ExprContext exprContext : ctx.expr()) {
            SQLExpr item = visitExpr(exprContext);
            x.addItem(item);
        }

        return x;
    }

    @Override
    public SQLUseIndexHint visitUseIndexHint(DRDSSQLStatementParser.UseIndexHintContext ctx) {
        SQLUseIndexHint x = new SQLUseIndexHint();

        AbstractSQLIndexHint.SQLForType forIndexType = of(ctx.indexHintType());
        x.setForType(forIndexType);

        for (DRDSSQLStatementParser.ExprContext exprContext : ctx.expr()) {
            SQLExpr name = visitExpr(exprContext);
            x.addName(name);
        }

        return x;
    }

    @Override
    public SQLUseKeyHint visitUseKeyHint(DRDSSQLStatementParser.UseKeyHintContext ctx) {
        SQLUseKeyHint x = new SQLUseKeyHint();

        AbstractSQLIndexHint.SQLForType forIndexType = of(ctx.indexHintType());
        x.setForType(forIndexType);

        for (DRDSSQLStatementParser.ExprContext exprContext : ctx.expr()) {
            SQLExpr name = visitExpr(exprContext);
            x.addName(name);
        }

        return x;
    }

    @Override
    public SQLIgnoreIndexHint visitIgnoreIndexHint(DRDSSQLStatementParser.IgnoreIndexHintContext ctx) {
        SQLIgnoreIndexHint x = new SQLIgnoreIndexHint();

        AbstractSQLIndexHint.SQLForType forIndexType = of(ctx.indexHintType());
        x.setForType(forIndexType);

        for (DRDSSQLStatementParser.ExprContext exprContext : ctx.expr()) {
            SQLExpr name = visitExpr(exprContext);
            x.addName(name);
        }

        return x;
    }

    @Override
    public SQLIgnoreKeyHint visitIgnoreKeyHint(DRDSSQLStatementParser.IgnoreKeyHintContext ctx) {
        SQLIgnoreKeyHint x = new SQLIgnoreKeyHint();

        AbstractSQLIndexHint.SQLForType forIndexType = of(ctx.indexHintType());
        x.setForType(forIndexType);

        for (DRDSSQLStatementParser.ExprContext exprContext : ctx.expr()) {
            SQLExpr name = visitExpr(exprContext);
            x.addName(name);
        }

        return x;
    }

    @Override
    public SQLForceIndexHint visitForceIndexHint(DRDSSQLStatementParser.ForceIndexHintContext ctx) {
        SQLForceIndexHint x = new SQLForceIndexHint();

        AbstractSQLIndexHint.SQLForType forIndexType = of(ctx.indexHintType());
        x.setForType(forIndexType);

        for (DRDSSQLStatementParser.ExprContext exprContext : ctx.expr()) {
            SQLExpr name = visitExpr(exprContext);
            x.addName(name);
        }

        return x;
    }

    @Override
    public SQLForceKeyHint visitForceKeyHint(DRDSSQLStatementParser.ForceKeyHintContext ctx) {
        SQLForceKeyHint x = new SQLForceKeyHint();

        AbstractSQLIndexHint.SQLForType forIndexType = of(ctx.indexHintType());
        x.setForType(forIndexType);

        for (DRDSSQLStatementParser.ExprContext exprContext : ctx.expr()) {
            SQLExpr name = visitExpr(exprContext);
            x.addName(name);
        }

        return x;
    }

    public AbstractSQLIndexHint.SQLForType of(DRDSSQLStatementParser.IndexHintTypeContext ctx) {
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


    public SQLJoinTableReference.SQLJoinType of(DRDSSQLStatementParser.JoinTypeContext ctx) {
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
    public SQLJoinTableReference.SQLJoinOnCondition visitJoinOnCondition(DRDSSQLStatementParser.JoinOnConditionContext ctx) {
        SQLJoinTableReference.SQLJoinOnCondition x = new SQLJoinTableReference.SQLJoinOnCondition();
        SQLExpr condition = visitExpr(ctx.expr());
        x.setCondition(condition);
        return x;
    }

    @Override
    public SQLJoinTableReference.SQLJoinUsingCondition visitJoinUsingCondition(DRDSSQLStatementParser.JoinUsingConditionContext ctx) {
        SQLJoinTableReference.SQLJoinUsingCondition x = new SQLJoinTableReference.SQLJoinUsingCondition();
        for (DRDSSQLStatementParser.ExprContext exprContext : ctx.expr()) {
            SQLExpr expr = visitExpr(exprContext);
            x.addColumn(expr);
        }
        return x;
    }

    @Override
    public SQLWhereClause visitWhereClause(DRDSSQLStatementParser.WhereClauseContext ctx) {
        SQLExpr condition = visitExpr(ctx.expr());
        return new SQLWhereClause(condition);
    }

    @Override
    public SQLGroupByClause visitGroupByClause(DRDSSQLStatementParser.GroupByClauseContext ctx) {
        if (ctx.GROUP() == null
                && ctx.havingClause() == null) {
            return null;
        }

        SQLGroupByClause x = new SQLGroupByClause();
        for (DRDSSQLStatementParser.GroupByItemContext groupByItemContext : ctx.groupByItem()) {
            SQLGroupByClause.SQLGroupByItem groupByElement = visitGroupByItem(groupByItemContext);
            x.addItem(groupByElement);
        }

        DRDSSQLStatementParser.HavingClauseContext havingClauseContext = ctx.havingClause();
        if (havingClauseContext != null) {
            SQLHavingClause havingClause = visitHavingClause(havingClauseContext);
            x.setHavingClause(havingClause);
        }

        return x;
    }

    @Override
    public SQLHavingClause visitHavingClause(DRDSSQLStatementParser.HavingClauseContext ctx) {
        SQLExpr condition = visitExpr(ctx.expr());
        SQLHavingClause x = new SQLHavingClause(condition);
        return x;
    }

    @Override
    public SQLGroupByClause.SQLGroupByItem visitGroupByItem(DRDSSQLStatementParser.GroupByItemContext ctx) {
        SQLExpr expr = (SQLExpr) super.visitChildren(ctx);
        SQLGroupByClause.SQLGroupByItem x = new SQLGroupByClause.SQLGroupByItem(expr);
        return x;
    }

    @Override
    public SQLOrderByClause visitOrderByClause(DRDSSQLStatementParser.OrderByClauseContext ctx) {
        SQLOrderByClause x = new SQLOrderByClause();

        for (DRDSSQLStatementParser.OrderByItemContext orderByItemContext : ctx.orderByItem()) {
            SQLOrderByItem orderByItem = visitOrderByItem(orderByItemContext);
            x.addItem(orderByItem);
        }

        return x;
    }

    @Override
    public SQLOrderByItem visitOrderByItem(DRDSSQLStatementParser.OrderByItemContext ctx) {
        SQLExpr sortKey = visitExpr(ctx.sortKey);
        SQLOrderByItem x = new SQLOrderByItem(sortKey);

        if (ctx.orderingSpecification() != null) {
            SQLOrderingSpecification orderingSpecification = of(ctx.orderingSpecification());
            x.setOrderingSpecification(orderingSpecification.name.ofExpr());
        }

        return x;
    }

    @Override
    public ISQLLimitClause visitLimitOffsetClause(DRDSSQLStatementParser.LimitOffsetClauseContext ctx) {

        SQLExpr limit = visitExpr(ctx.limit);
        boolean offset = ctx.OFFSET() != null;
        SQLExpr offsetExpr = visitExpr(ctx.offset);

        return new SQLLimitOffsetClause(limit, offset, offsetExpr);
    }

    @Override
    public SQLObject visitSelectQueryIntoClause(DRDSSQLStatementParser.SelectQueryIntoClauseContext ctx) {
        return super.visitSelectQueryIntoClause(ctx);
    }

    @Override
    public SQLObject visitSelectQueryIntoDumpFileClause(DRDSSQLStatementParser.SelectQueryIntoDumpFileClauseContext ctx) {
        return super.visitSelectQueryIntoDumpFileClause(ctx);
    }

    @Override
    public SQLObject visitSelectIntoTextFile(DRDSSQLStatementParser.SelectIntoTextFileContext ctx) {
        return super.visitSelectIntoTextFile(ctx);
    }

    @Override
    public SQLForUpdateClause visitForUpdateClause(DRDSSQLStatementParser.ForUpdateClauseContext ctx) {
        SQLForUpdateClause x = new SQLForUpdateClause();

        x.setForType(SQLForUpdateClause.SQLForType.UPDATE);

        for (DRDSSQLStatementParser.ExprContext exprContext : ctx.expr()) {
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
    public SQLLockInShareModeClause visitLockInShareModeClause(DRDSSQLStatementParser.LockInShareModeClauseContext ctx) {
        return new SQLLockInShareModeClause();
    }

    @Override
    public SQLForUpdateClause.SQLForSkipLockedOption visitForUpdateSkipLockedOption(DRDSSQLStatementParser.ForUpdateSkipLockedOptionContext ctx) {
        return new SQLForUpdateClause.SQLForSkipLockedOption();
    }

    @Override
    public SQLForUpdateClause.SQLForNoWaitOption visitForUpdateNoWaitOption(DRDSSQLStatementParser.ForUpdateNoWaitOptionContext ctx) {
        return new SQLForUpdateClause.SQLForNoWaitOption();
    }

    @Override
    public SQLSelectIntoStatement visitSelectIntoStatement(DRDSSQLStatementParser.SelectIntoStatementContext ctx) {
        SQLSelectIntoStatement x = new SQLSelectIntoStatement(DBType.DRDS);

        SQLSetQuantifier setQuantifier = of(ctx.setQuantifier());
        x.setSetQuantifier(setQuantifier);

        for (DRDSSQLStatementParser.SelectItemContext selectItemContext : ctx.selectItem()) {
            SQLSelectItem selectItem = visitSelectItem(selectItemContext);
            x.addSelectItem(selectItem);
        }

        for (DRDSSQLStatementParser.SelectTargetItemContext selectTargetItemContext : ctx.selectTargetItem()) {
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
    public SQLSelectTargetItem visitSelectTargetItem(DRDSSQLStatementParser.SelectTargetItemContext ctx) {
        SQLExpr expr = visitExpr(ctx.expr());
        return new SQLSelectTargetItem(expr);
    }

    @Override
    public SQLInsertStatement visitInsertStatement(DRDSSQLStatementParser.InsertStatementContext ctx) {
        SQLInsertStatement x = new SQLInsertStatement(DBType.DRDS);

        ISQLTableReference tableReference = (ISQLTableReference) visit(ctx.iTableReference());
        x.setTableReference(tableReference);

        for (DRDSSQLStatementParser.ExprContext exprContext : ctx.expr()) {
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
    public SQLValuesClause visitValuesClause(DRDSSQLStatementParser.ValuesClauseContext ctx) {
        SQLValuesClause x = new SQLValuesClause();

        if (ctx.VALUE() != null) {
            x.setValues(SQLReserved.VALUE);
        }

        for (DRDSSQLStatementParser.ValuesClauseItemContext valuesClauseItemContext : ctx.valuesClauseItem()) {
            SQLValuesClause.SQLValuesItem item = visitValuesClauseItem(valuesClauseItemContext);
            x.addValue(item);
        }

        return x;
    }

    @Override
    public SQLValuesClause.SQLValuesItem visitValuesClauseItem(DRDSSQLStatementParser.ValuesClauseItemContext ctx) {
        SQLValuesClause.SQLValuesItem x = new SQLValuesClause.SQLValuesItem();

        for (DRDSSQLStatementParser.ExprContext exprContext : ctx.expr()) {
            SQLExpr column = visitExpr(exprContext);
            x.addColumn(column);
        }
        return x;
    }

    @Override
    public SQLOnDuplicateKeyUpdateClause visitOnDuplicateKeyUpdateClause(DRDSSQLStatementParser.OnDuplicateKeyUpdateClauseContext ctx) {
        SQLOnDuplicateKeyUpdateClause x = new SQLOnDuplicateKeyUpdateClause();
        for (DRDSSQLStatementParser.AssignmentExprContext assignmentExprContext : ctx.assignmentExpr()) {
            SQLAssignmentExpr item = visitAssignmentExpr(assignmentExprContext);
            x.addItem(item);
        }
        return x;
    }

    @Override
    public SQLUpdateStatement visitUpdateStatement(DRDSSQLStatementParser.UpdateStatementContext ctx) {
        SQLUpdateStatement x = new SQLUpdateStatement(DBType.DRDS);

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
    public SQLUpdateSetClause visitUpdateSetClause(DRDSSQLStatementParser.UpdateSetClauseContext ctx) {
        SQLUpdateSetClause x = new SQLUpdateSetClause();

        for (DRDSSQLStatementParser.UpdateSetItemClauseContext updateSetItemClauseContext : ctx.updateSetItemClause()) {
            SQLUpdateSetClause.SQLUpdateSetItemClause item = visitUpdateSetItemClause(updateSetItemClauseContext);
            x.addItem(item);
        }

        return x;
    }

    @Override
    public SQLUpdateSetClause.SQLUpdateSetItemClause visitUpdateSetItemClause(DRDSSQLStatementParser.UpdateSetItemClauseContext ctx) {
        SQLExpr column = visitExpr(ctx.column);
        SQLExpr value = visitExpr(ctx.value);

        return new SQLUpdateSetClause.SQLUpdateSetItemClause(column, value);
    }

    @Override
    public SQLDeleteStatement visitDeleteStatement(DRDSSQLStatementParser.DeleteStatementContext ctx) {
        SQLDeleteStatement x = new SQLDeleteStatement(DBType.DRDS);

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
    public SQLObject visitDeleteStatementUsingClause(DRDSSQLStatementParser.DeleteStatementUsingClauseContext ctx) {
        return super.visitDeleteStatementUsingClause(ctx);
    }

    @Override
    public SQLReplaceStatement visitReplaceStatement(DRDSSQLStatementParser.ReplaceStatementContext ctx) {
        SQLReplaceStatement x = new SQLReplaceStatement(DBType.DRDS);

        if (ctx.priority() != null) {
            SQLPriorityType priority = of(ctx.priority());
            x.setPriority(priority);
        }

        if (ctx.INTO() != null) {
            x.setInto(true);
        }

        ISQLTableReference tableReference = (ISQLTableReference) visitChildren(ctx.iTableReference());
        x.setTableReference(tableReference);

        for (DRDSSQLStatementParser.ExprContext columnContext : ctx.columns) {
            SQLExpr column = visitExpr(columnContext);
            x.addColumn(column);
        }

        SQLExpr valuesClause = (SQLExpr) visitChildren(ctx.replaceStatementValuseClause());
        x.setValuesClause(valuesClause);

        return x;
    }


    @Override
    public SQLCallStatement visitCallStatement(DRDSSQLStatementParser.CallStatementContext ctx) {
        SQLCallStatement x = new SQLCallStatement(DBType.DRDS);
        SQLExpr expr = visitExpr(ctx.expr());
        x.setExpr(expr);
        return x;
    }

    @Override
    public SQLLoadDataStatement visitLoadDataInfileStatement(DRDSSQLStatementParser.LoadDataInfileStatementContext ctx) {
        SQLLoadDataStatement x = new SQLLoadDataStatement(DBType.DRDS);

        return x;
    }

    @Override
    public SQLLoadXmlStatement visitLoadXmlStatement(DRDSSQLStatementParser.LoadXmlStatementContext ctx) {
        SQLLoadXmlStatement x = new SQLLoadXmlStatement(DBType.DRDS);

        return x;
    }

    @Override
    public SQLDoStatement visitDoStatement(DRDSSQLStatementParser.DoStatementContext ctx) {
        SQLDoStatement x = new SQLDoStatement(DBType.DRDS);

        return x;
    }

    @Override
    public SQLHandlerOpenStatement visitHandlerOpenStatement(DRDSSQLStatementParser.HandlerOpenStatementContext ctx) {
        SQLHandlerOpenStatement x = new SQLHandlerOpenStatement(DBType.DRDS);
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
    public SQLHandlerReadStatement visitHandlerReadStatement(DRDSSQLStatementParser.HandlerReadStatementContext ctx) {
        SQLHandlerReadStatement x = new SQLHandlerReadStatement(DBType.DRDS);
        SQLName name = visitNameIdentifier(ctx.name);
        x.setName(name);
        return x;
    }

    @Override
    public SQLHandlerCloseStatement visitHandlerCloseStatement(DRDSSQLStatementParser.HandlerCloseStatementContext ctx) {
        SQLHandlerCloseStatement x = new SQLHandlerCloseStatement(DBType.DRDS);
        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);
        return x;
    }

    @Override
    public SQLObject visitSelectFieldsInto(DRDSSQLStatementParser.SelectFieldsIntoContext ctx) {
        return super.visitSelectFieldsInto(ctx);
    }

    @Override
    public SQLObject visitSelectLinesInto(DRDSSQLStatementParser.SelectLinesIntoContext ctx) {
        return super.visitSelectLinesInto(ctx);
    }

    @Override
    public SQLObject visitStartTransaction(DRDSSQLStatementParser.StartTransactionContext ctx) {
        return super.visitStartTransaction(ctx);
    }

    @Override
    public SQLObject visitTransactionMode(DRDSSQLStatementParser.TransactionModeContext ctx) {
        return super.visitTransactionMode(ctx);
    }

    @Override
    public SQLObject visitBeginWork(DRDSSQLStatementParser.BeginWorkContext ctx) {
        return super.visitBeginWork(ctx);
    }

    @Override
    public SQLObject visitCommitWork(DRDSSQLStatementParser.CommitWorkContext ctx) {
        return super.visitCommitWork(ctx);
    }

    @Override
    public SQLObject visitRollbackWork(DRDSSQLStatementParser.RollbackWorkContext ctx) {
        return super.visitRollbackWork(ctx);
    }

    @Override
    public SQLObject visitSavepointStatement(DRDSSQLStatementParser.SavepointStatementContext ctx) {
        return super.visitSavepointStatement(ctx);
    }

    @Override
    public SQLObject visitRollbackStatement(DRDSSQLStatementParser.RollbackStatementContext ctx) {
        return super.visitRollbackStatement(ctx);
    }

    @Override
    public SQLObject visitReleaseStatement(DRDSSQLStatementParser.ReleaseStatementContext ctx) {
        return super.visitReleaseStatement(ctx);
    }

    @Override
    public SQLLockTableStatement visitLockTablesStatement(DRDSSQLStatementParser.LockTablesStatementContext ctx) {
        SQLLockTableStatement x = new SQLLockTableStatement(DBType.DRDS);

        x.setType(SQLLockTableStatement.SQLType.TABLES);
        for (DRDSSQLStatementParser.LockTableItemContext lockTableItemContext : ctx.lockTableItem()) {
            SQLLockTableStatement.SQLLockTableItem item = visitLockTableItem(lockTableItemContext);
            x.addItem(item);
        }

        return x;
    }

    @Override
    public SQLLockTableStatement.SQLLockTableItem visitLockTableItem(DRDSSQLStatementParser.LockTableItemContext ctx) {
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

    public SQLLockTableStatement.SQLLockType of(DRDSSQLStatementParser.LockActionContext ctx) {
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
    public SQLUnLockTablesStatement visitUnlockTablesStatement(DRDSSQLStatementParser.UnlockTablesStatementContext ctx) {
        return new SQLUnLockTablesStatement(DBType.DRDS);
    }

    @Override
    public SQLObject visitSetAutoCommitStatement(DRDSSQLStatementParser.SetAutoCommitStatementContext ctx) {
        return super.visitSetAutoCommitStatement(ctx);
    }

    @Override
    public SQLObject visitTransactionOption(DRDSSQLStatementParser.TransactionOptionContext ctx) {
        return super.visitTransactionOption(ctx);
    }

    @Override
    public SQLObject visitTransactionLevel(DRDSSQLStatementParser.TransactionLevelContext ctx) {
        return super.visitTransactionLevel(ctx);
    }

    @Override
    public SQLObject visitChangeMaster(DRDSSQLStatementParser.ChangeMasterContext ctx) {
        return super.visitChangeMaster(ctx);
    }

    @Override
    public SQLObject visitChangeReplicationFilter(DRDSSQLStatementParser.ChangeReplicationFilterContext ctx) {
        return super.visitChangeReplicationFilter(ctx);
    }

    @Override
    public SQLObject visitPurgeBinaryLogs(DRDSSQLStatementParser.PurgeBinaryLogsContext ctx) {
        return super.visitPurgeBinaryLogs(ctx);
    }

    @Override
    public SQLObject visitResetMaster(DRDSSQLStatementParser.ResetMasterContext ctx) {
        return super.visitResetMaster(ctx);
    }

    @Override
    public SQLObject visitResetSlave(DRDSSQLStatementParser.ResetSlaveContext ctx) {
        return super.visitResetSlave(ctx);
    }

    @Override
    public SQLObject visitStartSlave(DRDSSQLStatementParser.StartSlaveContext ctx) {
        return super.visitStartSlave(ctx);
    }

    @Override
    public SQLObject visitStopSlave(DRDSSQLStatementParser.StopSlaveContext ctx) {
        return super.visitStopSlave(ctx);
    }

    @Override
    public SQLObject visitStartGroupReplication(DRDSSQLStatementParser.StartGroupReplicationContext ctx) {
        return super.visitStartGroupReplication(ctx);
    }

    @Override
    public SQLObject visitStopGroupReplication(DRDSSQLStatementParser.StopGroupReplicationContext ctx) {
        return super.visitStopGroupReplication(ctx);
    }

    @Override
    public SQLObject visitMasterStringOption(DRDSSQLStatementParser.MasterStringOptionContext ctx) {
        return super.visitMasterStringOption(ctx);
    }

    @Override
    public SQLObject visitMasterDecimalOption(DRDSSQLStatementParser.MasterDecimalOptionContext ctx) {
        return super.visitMasterDecimalOption(ctx);
    }

    @Override
    public SQLObject visitMasterBoolOption(DRDSSQLStatementParser.MasterBoolOptionContext ctx) {
        return super.visitMasterBoolOption(ctx);
    }

    @Override
    public SQLObject visitMasterRealOption(DRDSSQLStatementParser.MasterRealOptionContext ctx) {
        return super.visitMasterRealOption(ctx);
    }

    @Override
    public SQLObject visitMaster(DRDSSQLStatementParser.MasterContext ctx) {
        return super.visitMaster(ctx);
    }

    @Override
    public SQLObject visitStringMasterOption(DRDSSQLStatementParser.StringMasterOptionContext ctx) {
        return super.visitStringMasterOption(ctx);
    }

    @Override
    public SQLObject visitDecimalMasterOption(DRDSSQLStatementParser.DecimalMasterOptionContext ctx) {
        return super.visitDecimalMasterOption(ctx);
    }

    @Override
    public SQLObject visitBoolMasterOption(DRDSSQLStatementParser.BoolMasterOptionContext ctx) {
        return super.visitBoolMasterOption(ctx);
    }

    @Override
    public SQLObject visitChannelOption(DRDSSQLStatementParser.ChannelOptionContext ctx) {
        return super.visitChannelOption(ctx);
    }

    @Override
    public SQLObject visitDoDbReplication(DRDSSQLStatementParser.DoDbReplicationContext ctx) {
        return super.visitDoDbReplication(ctx);
    }

    @Override
    public SQLObject visitIgnoreDbReplication(DRDSSQLStatementParser.IgnoreDbReplicationContext ctx) {
        return super.visitIgnoreDbReplication(ctx);
    }

    @Override
    public SQLObject visitDoTableReplication(DRDSSQLStatementParser.DoTableReplicationContext ctx) {
        return super.visitDoTableReplication(ctx);
    }

    @Override
    public SQLObject visitIgnoreTableReplication(DRDSSQLStatementParser.IgnoreTableReplicationContext ctx) {
        return super.visitIgnoreTableReplication(ctx);
    }

    @Override
    public SQLObject visitWildDoTableReplication(DRDSSQLStatementParser.WildDoTableReplicationContext ctx) {
        return super.visitWildDoTableReplication(ctx);
    }

    @Override
    public SQLObject visitWildIgnoreTableReplication(DRDSSQLStatementParser.WildIgnoreTableReplicationContext ctx) {
        return super.visitWildIgnoreTableReplication(ctx);
    }

    @Override
    public SQLObject visitRewriteDbReplication(DRDSSQLStatementParser.RewriteDbReplicationContext ctx) {
        return super.visitRewriteDbReplication(ctx);
    }

    @Override
    public SQLObject visitTablePair(DRDSSQLStatementParser.TablePairContext ctx) {
        return super.visitTablePair(ctx);
    }

    @Override
    public SQLObject visitThreadType(DRDSSQLStatementParser.ThreadTypeContext ctx) {
        return super.visitThreadType(ctx);
    }

    @Override
    public SQLObject visitGtidsUntilOption(DRDSSQLStatementParser.GtidsUntilOptionContext ctx) {
        return super.visitGtidsUntilOption(ctx);
    }

    @Override
    public SQLObject visitMasterLogUntilOption(DRDSSQLStatementParser.MasterLogUntilOptionContext ctx) {
        return super.visitMasterLogUntilOption(ctx);
    }

    @Override
    public SQLObject visitRelayLogUntilOption(DRDSSQLStatementParser.RelayLogUntilOptionContext ctx) {
        return super.visitRelayLogUntilOption(ctx);
    }

    @Override
    public SQLObject visitSqlGapsUntilOption(DRDSSQLStatementParser.SqlGapsUntilOptionContext ctx) {
        return super.visitSqlGapsUntilOption(ctx);
    }

    @Override
    public SQLObject visitUserConnectionOption(DRDSSQLStatementParser.UserConnectionOptionContext ctx) {
        return super.visitUserConnectionOption(ctx);
    }

    @Override
    public SQLObject visitPasswordConnectionOption(DRDSSQLStatementParser.PasswordConnectionOptionContext ctx) {
        return super.visitPasswordConnectionOption(ctx);
    }

    @Override
    public SQLObject visitDefaultAuthConnectionOption(DRDSSQLStatementParser.DefaultAuthConnectionOptionContext ctx) {
        return super.visitDefaultAuthConnectionOption(ctx);
    }

    @Override
    public SQLObject visitPluginDirConnectionOption(DRDSSQLStatementParser.PluginDirConnectionOptionContext ctx) {
        return super.visitPluginDirConnectionOption(ctx);
    }

    @Override
    public SQLObject visitGtnameIdentifierSet(DRDSSQLStatementParser.GtnameIdentifierSetContext ctx) {
        return super.visitGtnameIdentifierSet(ctx);
    }

    @Override
    public SQLObject visitXaStartTransaction(DRDSSQLStatementParser.XaStartTransactionContext ctx) {
        return super.visitXaStartTransaction(ctx);
    }

    @Override
    public SQLObject visitXaEndTransaction(DRDSSQLStatementParser.XaEndTransactionContext ctx) {
        return super.visitXaEndTransaction(ctx);
    }

    @Override
    public SQLObject visitXaPrepareStatement(DRDSSQLStatementParser.XaPrepareStatementContext ctx) {
        return super.visitXaPrepareStatement(ctx);
    }

    @Override
    public SQLObject visitXaCommitWork(DRDSSQLStatementParser.XaCommitWorkContext ctx) {
        return super.visitXaCommitWork(ctx);
    }

    @Override
    public SQLObject visitXaRollbackWork(DRDSSQLStatementParser.XaRollbackWorkContext ctx) {
        return super.visitXaRollbackWork(ctx);
    }

    @Override
    public SQLObject visitXaRecoverWork(DRDSSQLStatementParser.XaRecoverWorkContext ctx) {
        return super.visitXaRecoverWork(ctx);
    }

    @Override
    public SQLObject visitPrepareStatement(DRDSSQLStatementParser.PrepareStatementContext ctx) {
        return super.visitPrepareStatement(ctx);
    }

    @Override
    public SQLObject visitExecuteStatement(DRDSSQLStatementParser.ExecuteStatementContext ctx) {
        return super.visitExecuteStatement(ctx);
    }

    @Override
    public SQLObject visitDeallocatePrepare(DRDSSQLStatementParser.DeallocatePrepareContext ctx) {
        return super.visitDeallocatePrepare(ctx);
    }

    @Override
    public SQLObject visitStatementItem(DRDSSQLStatementParser.StatementItemContext ctx) {
        SQLObject x = visitStatement(ctx.statement());
        if (ctx.SEMI() != null) {
            x.setAfterSemi(true);
        }
        return x;
    }

    @Override
    public SQLBody visitBody(DRDSSQLStatementParser.BodyContext ctx) {
        SQLBody x = new SQLBody();
        if (ctx.beginName != null) {
            SQLName beginName = visitNameIdentifier(ctx.beginName);
            x.setBeginLabel(beginName);
        }

        for (DRDSSQLStatementParser.BodyItemContext bodyItemContext : ctx.bodyItem()) {
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
    public SQLBody.SQLBodyItem visitBodyItem(DRDSSQLStatementParser.BodyItemContext ctx) {
        SQLBody.SQLBodyItem x = new SQLBody.SQLBodyItem();

        SQLObject statement = visitBodyItemStatement(ctx.bodyItemStatement());
        x.setStatement(statement);

        if (ctx.SEMI() != null) {
            statement.setAfterSemi(true);
        }

        return x;
    }

    @Override
    public SQLObject visitBodyItemStatement(DRDSSQLStatementParser.BodyItemStatementContext ctx) {
        return super.visitBodyItemStatement(ctx);
    }

    @Override
    public SQLCaseStatement visitCaseStatement(DRDSSQLStatementParser.CaseStatementContext ctx) {
        SQLCaseStatement x = new SQLCaseStatement(DBType.DRDS);
        if (ctx.expr() != null) {
            SQLExpr selector = visitExpr(ctx.expr());
            x.setSelector(selector);
        }

        for (DRDSSQLStatementParser.CaseStatementWhenItemContext caseStatementWhenItemContext : ctx.caseStatementWhenItem()) {
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
    public SQLCaseStatement.SQLCaseStatementWhenItem visitCaseStatementWhenItem(DRDSSQLStatementParser.CaseStatementWhenItemContext ctx) {
        SQLCaseStatement.SQLCaseStatementWhenItem x = new SQLCaseStatement.SQLCaseStatementWhenItem();

        SQLExpr expr = visitExpr(ctx.expr());
        x.setExpr(expr);

        SQLObject stmt = visitStatementItem(ctx.statementItem());
        x.setStatement(stmt);

        return x;
    }

    @Override
    public SQLCaseStatement.SQLCaseStatementElseClause visitCaseStatementElseClause(DRDSSQLStatementParser.CaseStatementElseClauseContext ctx) {
        SQLCaseStatement.SQLCaseStatementElseClause x = new SQLCaseStatement.SQLCaseStatementElseClause();

        for (DRDSSQLStatementParser.StatementItemContext statementItemContext : ctx.statementItem()) {
            SQLObject stmt = visitStatementItem(statementItemContext);
            x.addStatement(stmt);
        }

        return x;
    }

    @Override
    public SQLIfStatement visitIfStatement(DRDSSQLStatementParser.IfStatementContext ctx) {
        SQLIfStatement x = new SQLIfStatement(DBType.DRDS);

        SQLExpr condition = visitExpr(ctx.expr());
        x.setCondition(condition);
        for (DRDSSQLStatementParser.StatementItemContext statementItemContext : ctx.then) {
            SQLObject statement = visitStatementItem(statementItemContext);
            x.addStatement(statement);
        }

        for (DRDSSQLStatementParser.ElseIfContext elseIfContext : ctx.elseIf()) {
            SQLIfStatement.SQLElseIf elseIf = visitElseIf(elseIfContext);
            x.addElseIf(elseIf);
        }

        for (DRDSSQLStatementParser.StatementItemContext statementItemContext : ctx.else_) {
            SQLObject statement = visitStatementItem(statementItemContext);
            x.addElseStatement(statement);
        }
        return x;
    }

    @Override
    public SQLIfStatement.SQLElseIf visitElseIf(DRDSSQLStatementParser.ElseIfContext ctx) {
        SQLIfStatement.SQLElseIf x = new SQLIfStatement.SQLElseIf();
        SQLExpr condition = visitExpr(ctx.expr());
        x.setCondition(condition);
        for (DRDSSQLStatementParser.StatementItemContext statementItemContext : ctx.statementItem()) {
            SQLObject statement = visitStatementItem(statementItemContext);
            x.addStatement(statement);
        }
        return x;
    }

    @Override
    public SQLIterateStatement visitIterateStatement(DRDSSQLStatementParser.IterateStatementContext ctx) {
        SQLIterateStatement x = new SQLIterateStatement(DBType.DRDS);
        return x;
    }

    @Override
    public SQLLeaveStatement visitLeaveStatement(DRDSSQLStatementParser.LeaveStatementContext ctx) {
        SQLLeaveStatement x = new SQLLeaveStatement(DBType.DRDS);
        return x;
    }

    @Override
    public SQLLoopStatement visitLoopStatement(DRDSSQLStatementParser.LoopStatementContext ctx) {
        SQLLoopStatement x = new SQLLoopStatement(DBType.DRDS);
        return x;
    }

    @Override
    public SQLRepeatStatement visitRepeatStatement(DRDSSQLStatementParser.RepeatStatementContext ctx) {
        SQLRepeatStatement x = new SQLRepeatStatement(DBType.DRDS);
        return x;
    }

    @Override
    public SQLReturnStatement visitReturnStatement(DRDSSQLStatementParser.ReturnStatementContext ctx) {
        SQLReturnStatement x = new SQLReturnStatement(DBType.DRDS);
        return x;
    }

    @Override
    public SQLWhileStatement visitWhileStatement(DRDSSQLStatementParser.WhileStatementContext ctx) {
        SQLWhileStatement x = new SQLWhileStatement(DBType.DRDS);
        return x;
    }

    @Override
    public SQLObject visitCloseCursor(DRDSSQLStatementParser.CloseCursorContext ctx) {
        SQLReturnStatement x = new SQLReturnStatement(DBType.DRDS);
        return x;
    }

    @Override
    public SQLObject visitFetchCursor(DRDSSQLStatementParser.FetchCursorContext ctx) {
        return super.visitFetchCursor(ctx);
    }

    @Override
    public SQLObject visitOpenCursor(DRDSSQLStatementParser.OpenCursorContext ctx) {
        return super.visitOpenCursor(ctx);
    }

    @Override
    public SQLObject visitDeclareVariable(DRDSSQLStatementParser.DeclareVariableContext ctx) {
        return super.visitDeclareVariable(ctx);
    }

    @Override
    public SQLObject visitDeclareCondition(DRDSSQLStatementParser.DeclareConditionContext ctx) {
        return super.visitDeclareCondition(ctx);
    }

    @Override
    public SQLObject visitDeclareCursor(DRDSSQLStatementParser.DeclareCursorContext ctx) {
        return super.visitDeclareCursor(ctx);
    }

    @Override
    public SQLObject visitDeclareHandler(DRDSSQLStatementParser.DeclareHandlerContext ctx) {
        return super.visitDeclareHandler(ctx);
    }

    @Override
    public SQLObject visitHandlerConditionCode(DRDSSQLStatementParser.HandlerConditionCodeContext ctx) {
        return super.visitHandlerConditionCode(ctx);
    }

    @Override
    public SQLObject visitHandlerConditionState(DRDSSQLStatementParser.HandlerConditionStateContext ctx) {
        return super.visitHandlerConditionState(ctx);
    }

    @Override
    public SQLObject visitHandlerConditionName(DRDSSQLStatementParser.HandlerConditionNameContext ctx) {
        return super.visitHandlerConditionName(ctx);
    }

    @Override
    public SQLObject visitHandlerConditionWarning(DRDSSQLStatementParser.HandlerConditionWarningContext ctx) {
        return super.visitHandlerConditionWarning(ctx);
    }

    @Override
    public SQLObject visitHandlerConditionNotfound(DRDSSQLStatementParser.HandlerConditionNotfoundContext ctx) {
        return super.visitHandlerConditionNotfound(ctx);
    }

    @Override
    public SQLObject visitHandlerConditionException(DRDSSQLStatementParser.HandlerConditionExceptionContext ctx) {
        return super.visitHandlerConditionException(ctx);
    }

    @Override
    public SQLObject visitAlterUserMysqlV56(DRDSSQLStatementParser.AlterUserMysqlV56Context ctx) {
        return super.visitAlterUserMysqlV56(ctx);
    }

    @Override
    public SQLObject visitAlterUserMysqlV57(DRDSSQLStatementParser.AlterUserMysqlV57Context ctx) {
        return super.visitAlterUserMysqlV57(ctx);
    }

    @Override
    public SQLObject visitDropUserStatement(DRDSSQLStatementParser.DropUserStatementContext ctx) {
        return super.visitDropUserStatement(ctx);
    }

    @Override
    public SQLObject visitGrantStatement(DRDSSQLStatementParser.GrantStatementContext ctx) {
        return super.visitGrantStatement(ctx);
    }

    @Override
    public SQLObject visitGrantProxy(DRDSSQLStatementParser.GrantProxyContext ctx) {
        return super.visitGrantProxy(ctx);
    }

    @Override
    public SQLObject visitRenameUser(DRDSSQLStatementParser.RenameUserContext ctx) {
        return super.visitRenameUser(ctx);
    }

    @Override
    public SQLObject visitDetailRevoke(DRDSSQLStatementParser.DetailRevokeContext ctx) {
        return super.visitDetailRevoke(ctx);
    }

    @Override
    public SQLObject visitShortRevoke(DRDSSQLStatementParser.ShortRevokeContext ctx) {
        return super.visitShortRevoke(ctx);
    }

    @Override
    public SQLObject visitRevokeProxy(DRDSSQLStatementParser.RevokeProxyContext ctx) {
        return super.visitRevokeProxy(ctx);
    }

    @Override
    public SQLObject visitUserSpecification(DRDSSQLStatementParser.UserSpecificationContext ctx) {
        return super.visitUserSpecification(ctx);
    }

    @Override
    public SQLObject visitPasswordAuthOption(DRDSSQLStatementParser.PasswordAuthOptionContext ctx) {
        return super.visitPasswordAuthOption(ctx);
    }

    @Override
    public SQLObject visitStringAuthOption(DRDSSQLStatementParser.StringAuthOptionContext ctx) {
        return super.visitStringAuthOption(ctx);
    }

    @Override
    public SQLObject visitHashAuthOption(DRDSSQLStatementParser.HashAuthOptionContext ctx) {
        return super.visitHashAuthOption(ctx);
    }

    @Override
    public SQLObject visitSimpleAuthOption(DRDSSQLStatementParser.SimpleAuthOptionContext ctx) {
        return super.visitSimpleAuthOption(ctx);
    }

    @Override
    public SQLObject visitTlsOption(DRDSSQLStatementParser.TlsOptionContext ctx) {
        return super.visitTlsOption(ctx);
    }

    @Override
    public SQLObject visitUserResourceOption(DRDSSQLStatementParser.UserResourceOptionContext ctx) {
        return super.visitUserResourceOption(ctx);
    }

    @Override
    public SQLObject visitUserPasswordOption(DRDSSQLStatementParser.UserPasswordOptionContext ctx) {
        return super.visitUserPasswordOption(ctx);
    }

    @Override
    public SQLObject visitUserLockOption(DRDSSQLStatementParser.UserLockOptionContext ctx) {
        return super.visitUserLockOption(ctx);
    }

    @Override
    public SQLObject visitPrivelegeClause(DRDSSQLStatementParser.PrivelegeClauseContext ctx) {
        return super.visitPrivelegeClause(ctx);
    }

    @Override
    public SQLObject visitPrivilege(DRDSSQLStatementParser.PrivilegeContext ctx) {
        return super.visitPrivilege(ctx);
    }

    @Override
    public SQLObject visitCurrentSchemaPriviLevel(DRDSSQLStatementParser.CurrentSchemaPriviLevelContext ctx) {
        return super.visitCurrentSchemaPriviLevel(ctx);
    }

    @Override
    public SQLObject visitGlobalPrivLevel(DRDSSQLStatementParser.GlobalPrivLevelContext ctx) {
        return super.visitGlobalPrivLevel(ctx);
    }

    @Override
    public SQLObject visitDefiniteSchemaPrivLevel(DRDSSQLStatementParser.DefiniteSchemaPrivLevelContext ctx) {
        return super.visitDefiniteSchemaPrivLevel(ctx);
    }

    @Override
    public SQLObject visitDefiniteFullTablePrivLevel(DRDSSQLStatementParser.DefiniteFullTablePrivLevelContext ctx) {
        return super.visitDefiniteFullTablePrivLevel(ctx);
    }

    @Override
    public SQLObject visitDefiniteTablePrivLevel(DRDSSQLStatementParser.DefiniteTablePrivLevelContext ctx) {
        return super.visitDefiniteTablePrivLevel(ctx);
    }

    @Override
    public SQLObject visitRenameUserClause(DRDSSQLStatementParser.RenameUserClauseContext ctx) {
        return super.visitRenameUserClause(ctx);
    }

    @Override
    public SQLObject visitAnalyzeTable(DRDSSQLStatementParser.AnalyzeTableContext ctx) {
        return super.visitAnalyzeTable(ctx);
    }

    @Override
    public SQLObject visitCheckTable(DRDSSQLStatementParser.CheckTableContext ctx) {
        return super.visitCheckTable(ctx);
    }

    @Override
    public SQLObject visitChecksumTable(DRDSSQLStatementParser.ChecksumTableContext ctx) {
        return super.visitChecksumTable(ctx);
    }

    @Override
    public SQLObject visitOptimizeTable(DRDSSQLStatementParser.OptimizeTableContext ctx) {
        return super.visitOptimizeTable(ctx);
    }

    @Override
    public SQLObject visitRepairTable(DRDSSQLStatementParser.RepairTableContext ctx) {
        return super.visitRepairTable(ctx);
    }

    @Override
    public SQLObject visitCheckTableOption(DRDSSQLStatementParser.CheckTableOptionContext ctx) {
        return super.visitCheckTableOption(ctx);
    }

    @Override
    public SQLObject visitCreateUdfunction(DRDSSQLStatementParser.CreateUdfunctionContext ctx) {
        return super.visitCreateUdfunction(ctx);
    }

    @Override
    public SQLObject visitInstallPlugin(DRDSSQLStatementParser.InstallPluginContext ctx) {
        return super.visitInstallPlugin(ctx);
    }

    @Override
    public SQLObject visitUninstallPlugin(DRDSSQLStatementParser.UninstallPluginContext ctx) {
        return super.visitUninstallPlugin(ctx);
    }

    @Override
    public SQLObject visitSetDefaultRoleStatement(DRDSSQLStatementParser.SetDefaultRoleStatementContext ctx) {
        return super.visitSetDefaultRoleStatement(ctx);
    }

    @Override
    public SQLSetPasswordStatement visitSetPasswordStatement(DRDSSQLStatementParser.SetPasswordStatementContext ctx) {
        SQLSetPasswordStatement x = new SQLSetPasswordStatement(DBType.DRDS);

        return x;
    }

    @Override
    public SQLSetVariableStatement visitSetVariableStatement(DRDSSQLStatementParser.SetVariableStatementContext ctx) {
        SQLSetVariableStatement x = new SQLSetVariableStatement(DBType.DRDS);

        for (DRDSSQLStatementParser.AssignmentExprContext assignmentExprContext : ctx.assignmentExpr()) {
            SQLAssignmentExpr item = visitAssignmentExpr(assignmentExprContext);
            x.addItem(item);
        }

        return x;
    }

    @Override
    public SQLObject visitSetCharacterSetStatement(DRDSSQLStatementParser.SetCharacterSetStatementContext ctx) {
        return super.visitSetCharacterSetStatement(ctx);
    }

    @Override
    public SQLObject visitSetCharsetStatement(DRDSSQLStatementParser.SetCharsetStatementContext ctx) {
        return super.visitSetCharsetStatement(ctx);
    }

    @Override
    public SQLObject visitSetNamesStatement(DRDSSQLStatementParser.SetNamesStatementContext ctx) {
        return super.visitSetNamesStatement(ctx);
    }

    @Override
    public SQLObject visitSetTransactionStatement(DRDSSQLStatementParser.SetTransactionStatementContext ctx) {
        return super.visitSetTransactionStatement(ctx);
    }

    @Override
    public SQLObject visitSetAutocommit(DRDSSQLStatementParser.SetAutocommitContext ctx) {
        return super.visitSetAutocommit(ctx);
    }

    @Override
    public SQLObject visitSetDefaultRole(DRDSSQLStatementParser.SetDefaultRoleContext ctx) {
        return super.visitSetDefaultRole(ctx);
    }

    @Override
    public SQLObject visitShowMasterLogs(DRDSSQLStatementParser.ShowMasterLogsContext ctx) {
        return super.visitShowMasterLogs(ctx);
    }

    @Override
    public SQLObject visitShowLogEvents(DRDSSQLStatementParser.ShowLogEventsContext ctx) {
        return super.visitShowLogEvents(ctx);
    }

    @Override
    public SQLObject visitShowObjectFilter(DRDSSQLStatementParser.ShowObjectFilterContext ctx) {
        return super.visitShowObjectFilter(ctx);
    }

    @Override
    public SQLObject visitShowColumns(DRDSSQLStatementParser.ShowColumnsContext ctx) {
        return super.visitShowColumns(ctx);
    }

    @Override
    public SQLObject visitShowCreateDb(DRDSSQLStatementParser.ShowCreateDbContext ctx) {
        return super.visitShowCreateDb(ctx);
    }

    @Override
    public SQLObject visitShowCreatenameIdentifierObject(DRDSSQLStatementParser.ShowCreatenameIdentifierObjectContext ctx) {
        return super.visitShowCreatenameIdentifierObject(ctx);
    }

    @Override
    public SQLObject visitShowCreateUser(DRDSSQLStatementParser.ShowCreateUserContext ctx) {
        return super.visitShowCreateUser(ctx);
    }

    @Override
    public SQLObject visitShowEngine(DRDSSQLStatementParser.ShowEngineContext ctx) {
        return super.visitShowEngine(ctx);
    }

    @Override
    public SQLObject visitShowGlobalInfo(DRDSSQLStatementParser.ShowGlobalInfoContext ctx) {
        return super.visitShowGlobalInfo(ctx);
    }

    @Override
    public SQLObject visitShowErrors(DRDSSQLStatementParser.ShowErrorsContext ctx) {
        return super.visitShowErrors(ctx);
    }

    @Override
    public SQLObject visitShowCountErrors(DRDSSQLStatementParser.ShowCountErrorsContext ctx) {
        return super.visitShowCountErrors(ctx);
    }

    @Override
    public SQLObject visitShowSchemaFilter(DRDSSQLStatementParser.ShowSchemaFilterContext ctx) {
        return super.visitShowSchemaFilter(ctx);
    }

    @Override
    public SQLObject visitShowRoutine(DRDSSQLStatementParser.ShowRoutineContext ctx) {
        return super.visitShowRoutine(ctx);
    }

    @Override
    public SQLObject visitShowGrants(DRDSSQLStatementParser.ShowGrantsContext ctx) {
        return super.visitShowGrants(ctx);
    }

    @Override
    public SQLObject visitShowIndexes(DRDSSQLStatementParser.ShowIndexesContext ctx) {
        return super.visitShowIndexes(ctx);
    }

    @Override
    public SQLObject visitShowOpenTables(DRDSSQLStatementParser.ShowOpenTablesContext ctx) {
        return super.visitShowOpenTables(ctx);
    }

    @Override
    public SQLObject visitShowProfile(DRDSSQLStatementParser.ShowProfileContext ctx) {
        return super.visitShowProfile(ctx);
    }

    @Override
    public SQLObject visitShowSlaveStatus(DRDSSQLStatementParser.ShowSlaveStatusContext ctx) {
        return super.visitShowSlaveStatus(ctx);
    }

    @Override
    public SQLObject visitShowCommonEntity(DRDSSQLStatementParser.ShowCommonEntityContext ctx) {
        return super.visitShowCommonEntity(ctx);
    }

    @Override
    public SQLObject visitShowFilter(DRDSSQLStatementParser.ShowFilterContext ctx) {
        return super.visitShowFilter(ctx);
    }

    @Override
    public SQLObject visitShowGlobalInfoClause(DRDSSQLStatementParser.ShowGlobalInfoClauseContext ctx) {
        return super.visitShowGlobalInfoClause(ctx);
    }

    @Override
    public SQLObject visitShowSchemaEntity(DRDSSQLStatementParser.ShowSchemaEntityContext ctx) {
        return super.visitShowSchemaEntity(ctx);
    }

    @Override
    public SQLObject visitShowProfileType(DRDSSQLStatementParser.ShowProfileTypeContext ctx) {
        return super.visitShowProfileType(ctx);
    }

    @Override
    public SQLObject visitBinlogStatement(DRDSSQLStatementParser.BinlogStatementContext ctx) {
        return super.visitBinlogStatement(ctx);
    }

    @Override
    public SQLObject visitCacheIndexStatement(DRDSSQLStatementParser.CacheIndexStatementContext ctx) {
        return super.visitCacheIndexStatement(ctx);
    }

    @Override
    public SQLObject visitFlushStatement(DRDSSQLStatementParser.FlushStatementContext ctx) {
        return super.visitFlushStatement(ctx);
    }

    @Override
    public SQLObject visitKillStatement(DRDSSQLStatementParser.KillStatementContext ctx) {
        return super.visitKillStatement(ctx);
    }

    @Override
    public SQLObject visitLoadIndexIntoCache(DRDSSQLStatementParser.LoadIndexIntoCacheContext ctx) {
        return super.visitLoadIndexIntoCache(ctx);
    }

    @Override
    public SQLObject visitResetStatement(DRDSSQLStatementParser.ResetStatementContext ctx) {
        return super.visitResetStatement(ctx);
    }

    @Override
    public SQLObject visitShutdownStatement(DRDSSQLStatementParser.ShutdownStatementContext ctx) {
        return super.visitShutdownStatement(ctx);
    }

    @Override
    public SQLObject visitTableIndexes(DRDSSQLStatementParser.TableIndexesContext ctx) {
        return super.visitTableIndexes(ctx);
    }

    @Override
    public SQLObject visitSimpleFlushOption(DRDSSQLStatementParser.SimpleFlushOptionContext ctx) {
        return super.visitSimpleFlushOption(ctx);
    }

    @Override
    public SQLObject visitChannelFlushOption(DRDSSQLStatementParser.ChannelFlushOptionContext ctx) {
        return super.visitChannelFlushOption(ctx);
    }

    @Override
    public SQLObject visitTableFlushOption(DRDSSQLStatementParser.TableFlushOptionContext ctx) {
        return super.visitTableFlushOption(ctx);
    }

    @Override
    public SQLObject visitFlushTableOption(DRDSSQLStatementParser.FlushTableOptionContext ctx) {
        return super.visitFlushTableOption(ctx);
    }

    @Override
    public SQLObject visitLoadedTableIndexes(DRDSSQLStatementParser.LoadedTableIndexesContext ctx) {
        return super.visitLoadedTableIndexes(ctx);
    }

    @Override
    public SQLObject visitSimpleDescribeStatement(DRDSSQLStatementParser.SimpleDescribeStatementContext ctx) {
        return super.visitSimpleDescribeStatement(ctx);
    }

    @Override
    public SQLObject visitFullDescribeStatement(DRDSSQLStatementParser.FullDescribeStatementContext ctx) {
        return super.visitFullDescribeStatement(ctx);
    }

    @Override
    public SQLObject visitHelpStatement(DRDSSQLStatementParser.HelpStatementContext ctx) {
        return super.visitHelpStatement(ctx);
    }

    @Override
    public SQLObject visitUseStatement(DRDSSQLStatementParser.UseStatementContext ctx) {
        return super.visitUseStatement(ctx);
    }

    @Override
    public SQLObject visitDescribeStatements(DRDSSQLStatementParser.DescribeStatementsContext ctx) {
        return super.visitDescribeStatements(ctx);
    }

    @Override
    public SQLObject visitDescribeConnection(DRDSSQLStatementParser.DescribeConnectionContext ctx) {
        return super.visitDescribeConnection(ctx);
    }


    @Override
    public SQLObject visitEngineName(DRDSSQLStatementParser.EngineNameContext ctx) {
        return super.visitEngineName(ctx);
    }

    @Override
    public SQLObject visitUnameIdentifierSet(DRDSSQLStatementParser.UnameIdentifierSetContext ctx) {
        return super.visitUnameIdentifierSet(ctx);
    }

    @Override
    public SQLObject visitXid(DRDSSQLStatementParser.XidContext ctx) {
        return super.visitXid(ctx);
    }

    @Override
    public SQLObject visitXnameIdentifierStringId(DRDSSQLStatementParser.XnameIdentifierStringIdContext ctx) {
        return super.visitXnameIdentifierStringId(ctx);
    }

    @Override
    public SQLObject visitAuthPlugin(DRDSSQLStatementParser.AuthPluginContext ctx) {
        return super.visitAuthPlugin(ctx);
    }

    // ----------------  DataType Start --------------------------------------------------------

    @Override
    public SQLDataType visitDataType(DRDSSQLStatementParser.DataTypeContext ctx) {
        if (ctx == null) {
            return null;
        }
        return (SQLDataType) super.visitChildren(ctx);
    }

    @Override
    public SQLBitDataType visitBitDataType(DRDSSQLStatementParser.BitDataTypeContext ctx) {
        SQLBitDataType x = new SQLBitDataType();
        SQLExpr expr = visitExpr(ctx.expr());
        x.addArgument(expr);
        return x;
    }

    @Override
    public SQLTinyintDataType visitTinyintDataType(DRDSSQLStatementParser.TinyintDataTypeContext ctx) {
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
    public SQLSmallintDataType visitSmallintDataType(DRDSSQLStatementParser.SmallintDataTypeContext ctx) {
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
    public SQLMediumintDataType visitMediumintDataType(DRDSSQLStatementParser.MediumintDataTypeContext ctx) {
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
    public SQLIntDataType visitIntDataType(DRDSSQLStatementParser.IntDataTypeContext ctx) {
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
    public SQLIntegerDataType visitIntegerDataType(DRDSSQLStatementParser.IntegerDataTypeContext ctx) {
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
    public SQLBigintDataType visitBigintDataType(DRDSSQLStatementParser.BigintDataTypeContext ctx) {
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
    public SQLDecimalDataType visitDecimalDataType(DRDSSQLStatementParser.DecimalDataTypeContext ctx) {
        SQLDecimalDataType x = new SQLDecimalDataType();

        for (DRDSSQLStatementParser.ExprContext exprContext : ctx.expr()) {
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
    public SQLDecDataType visitDecDataType(DRDSSQLStatementParser.DecDataTypeContext ctx) {
        SQLDecDataType x = new SQLDecDataType();

        for (DRDSSQLStatementParser.ExprContext exprContext : ctx.expr()) {
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
    public SQLNumericDataType visitNumericDataType(DRDSSQLStatementParser.NumericDataTypeContext ctx) {
        SQLNumericDataType x = new SQLNumericDataType();

        for (DRDSSQLStatementParser.ExprContext exprContext : ctx.expr()) {
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
    public SQLFixedDataType visitFixedDataType(DRDSSQLStatementParser.FixedDataTypeContext ctx) {
        SQLFixedDataType x = new SQLFixedDataType();

        for (DRDSSQLStatementParser.ExprContext exprContext : ctx.expr()) {
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
    public SQLFloatDataType visitFloatDataType(DRDSSQLStatementParser.FloatDataTypeContext ctx) {
        SQLFloatDataType x = new SQLFloatDataType();

        for (DRDSSQLStatementParser.ExprContext exprContext : ctx.expr()) {
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
    public SQLDoubleDataType visitDoubleDataType(DRDSSQLStatementParser.DoubleDataTypeContext ctx) {
        SQLDoubleDataType x = new SQLDoubleDataType();

        for (DRDSSQLStatementParser.ExprContext exprContext : ctx.expr()) {
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
    public SQLDoublePrecisionDataType visitDoublePrecisionDataType(DRDSSQLStatementParser.DoublePrecisionDataTypeContext ctx) {
        SQLDoublePrecisionDataType x = new SQLDoublePrecisionDataType();

        for (DRDSSQLStatementParser.ExprContext exprContext : ctx.expr()) {
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
    public SQLRealDataType visitRealDataType(DRDSSQLStatementParser.RealDataTypeContext ctx) {
        SQLRealDataType x = new SQLRealDataType();

        for (DRDSSQLStatementParser.ExprContext exprContext : ctx.expr()) {
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
    public SQLCharDataType visitCharDataType(DRDSSQLStatementParser.CharDataTypeContext ctx) {
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
    public SQLNationalCharDataType visitNationalCharDataType(DRDSSQLStatementParser.NationalCharDataTypeContext ctx) {
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
    public SQLVarcharDataType visitVarcharDataType(DRDSSQLStatementParser.VarcharDataTypeContext ctx) {
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
    public SQLNationalVarcharDataType visitNationalVarcharDataType(DRDSSQLStatementParser.NationalVarcharDataTypeContext ctx) {
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
    public SQLBinaryDataType visitBinaryDataType(DRDSSQLStatementParser.BinaryDataTypeContext ctx) {
        SQLBinaryDataType x = new SQLBinaryDataType();

        SQLExpr expr = visitExpr(ctx.expr());
        x.addArgument(expr);

        return x;
    }

    @Override
    public SQLVarBinaryDataType visitVarBinaryDataType(DRDSSQLStatementParser.VarBinaryDataTypeContext ctx) {
        SQLVarBinaryDataType x = new SQLVarBinaryDataType();

        SQLExpr expr = visitExpr(ctx.expr());
        x.addArgument(expr);

        return x;
    }

    @Override
    public SQLTinyBlobDataType visitTinyBlobDataType(DRDSSQLStatementParser.TinyBlobDataTypeContext ctx) {
        return new SQLTinyBlobDataType();
    }

    @Override
    public SQLTinyTextDataType visitTinyTextDataType(DRDSSQLStatementParser.TinyTextDataTypeContext ctx) {
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
    public SQLBlobDataType visitBlobDataType(DRDSSQLStatementParser.BlobDataTypeContext ctx) {
        SQLBlobDataType x = new SQLBlobDataType();

        SQLExpr expr = visitExpr(ctx.expr());
        x.addArgument(expr);

        return x;
    }

    @Override
    public SQLTextDataType visitTextDataType(DRDSSQLStatementParser.TextDataTypeContext ctx) {
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
    public SQLMediumBlobDataType visitMediumBlobDataType(DRDSSQLStatementParser.MediumBlobDataTypeContext ctx) {
        return new SQLMediumBlobDataType();
    }

    @Override
    public SQLMediumTextDataType visitMediumTextDataType(DRDSSQLStatementParser.MediumTextDataTypeContext ctx) {
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
    public SQLLongBlobDataType visitLongBlobDataType(DRDSSQLStatementParser.LongBlobDataTypeContext ctx) {
        return new SQLLongBlobDataType();
    }

    @Override
    public SQLLongTextDataType visitLongTextDataType(DRDSSQLStatementParser.LongTextDataTypeContext ctx) {
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
    public SQLEnumDataType visitEnumDataType(DRDSSQLStatementParser.EnumDataTypeContext ctx) {
        SQLEnumDataType x = new SQLEnumDataType();

        for (DRDSSQLStatementParser.ExprContext exprContext : ctx.expr()) {
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
    public SQLSetDataType visitSetDataType(DRDSSQLStatementParser.SetDataTypeContext ctx) {
        SQLSetDataType x = new SQLSetDataType();

        for (DRDSSQLStatementParser.ExprContext exprContext : ctx.expr()) {
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
    public SQLDateDataType visitDateDataType(DRDSSQLStatementParser.DateDataTypeContext ctx) {
        return new SQLDateDataType();
    }

    @Override
    public SQLDateTimeDataType visitDatetimeDataType(DRDSSQLStatementParser.DatetimeDataTypeContext ctx) {
        SQLDateTimeDataType x = new SQLDateTimeDataType();
        if (ctx.expr() != null) {
            SQLExpr expr = visitExpr(ctx.expr());
            x.addArgument(expr);
        }

        return x;
    }

    @Override
    public SQLTimestampDataType visitTimestampDataType(DRDSSQLStatementParser.TimestampDataTypeContext ctx) {
        SQLTimestampDataType x = new SQLTimestampDataType();
        if (ctx.expr() != null) {
            SQLExpr expr = visitExpr(ctx.expr());
            x.addArgument(expr);
        }

        return x;
    }

    @Override
    public SQLTimeDataType visitTimeDataType(DRDSSQLStatementParser.TimeDataTypeContext ctx) {
        SQLTimeDataType x = new SQLTimeDataType();
        if (ctx.expr() != null) {
            SQLExpr expr = visitExpr(ctx.expr());
            x.addArgument(expr);
        }
        return x;
    }

    @Override
    public SQLYearDataType visitYearDataType(DRDSSQLStatementParser.YearDataTypeContext ctx) {
        SQLYearDataType x = new SQLYearDataType();
        if (ctx.expr() != null) {
            SQLExpr expr = visitExpr(ctx.expr());
            x.addArgument(expr);
        }
        return x;
    }

    @Override
    public SQLGeometryDataType visitGeometryDataType(DRDSSQLStatementParser.GeometryDataTypeContext ctx) {
        return new SQLGeometryDataType();
    }

    @Override
    public SQLPointDataType visitPointDataType(DRDSSQLStatementParser.PointDataTypeContext ctx) {
        return new SQLPointDataType();
    }

    @Override
    public SQLLineStringDataType visitLineStringDataType(DRDSSQLStatementParser.LineStringDataTypeContext ctx) {
        return new SQLLineStringDataType();
    }

    @Override
    public SQLPolygonDataType visitPolygonDataType(DRDSSQLStatementParser.PolygonDataTypeContext ctx) {
        return new SQLPolygonDataType();
    }

    @Override
    public SQLMultiPointDataType visitMultiPointDataType(DRDSSQLStatementParser.MultiPointDataTypeContext ctx) {
        return new SQLMultiPointDataType();
    }

    @Override
    public SQLMultiLineStringDataType visitMultiLineStringDataType(DRDSSQLStatementParser.MultiLineStringDataTypeContext ctx) {
        return new SQLMultiLineStringDataType();
    }

    @Override
    public SQLMultiPolygonDataType visitMultiPolygonDataType(DRDSSQLStatementParser.MultiPolygonDataTypeContext ctx) {
        return new SQLMultiPolygonDataType();
    }

    @Override
    public SQLGeometryCollectionDataType visitGeometryCollectionDataType(DRDSSQLStatementParser.GeometryCollectionDataTypeContext ctx) {
        return new SQLGeometryCollectionDataType();
    }

    @Override
    public SQLBoolDataType visitBoolDataType(DRDSSQLStatementParser.BoolDataTypeContext ctx) {
        return new SQLBoolDataType();
    }

    @Override
    public SQLBooleanDataType visitBooleanDataType(DRDSSQLStatementParser.BooleanDataTypeContext ctx) {
        return new SQLBooleanDataType();
    }

    @Override
    public SQLJsonDataType visitJsonDataType(DRDSSQLStatementParser.JsonDataTypeContext ctx) {
        return new SQLJsonDataType();
    }

    @Override
    public SQLDataTypeImpl visitOtherDataType(DRDSSQLStatementParser.OtherDataTypeContext ctx) {
        SQLName name = visitNameIdentifier(ctx.name);

        SQLDataTypeImpl x = new SQLDataTypeImpl(name);

        if (ctx.LEFT_PAREN() != null) {
            x.setParen(true);
        }

        for (DRDSSQLStatementParser.ExprContext exprContext : ctx.expr()) {
            SQLExpr argument = visitExpr(exprContext);
            x.addArgument(argument);
        }

        return x;
    }

    // ----------------  DataType End --------------------------------------------------------


    // ----------------  Identified Start --------------------------------------------------------
    public SQLIdentifier visitIdentifier(DRDSSQLStatementParser.IdentifierContext ctx) {
        return (SQLIdentifier) super.visit(ctx);
    }

    @Override
    public SQLAllColumnExpr visitAsteriskIdentifier(DRDSSQLStatementParser.AsteriskIdentifierContext ctx) {
        return new SQLAllColumnExpr();
    }

    @Override
    public SQLIdentifierImpl visitNormalIdentifier(DRDSSQLStatementParser.NormalIdentifierContext ctx) {
        return new SQLIdentifierImpl(ctx.getText());
    }

    @Override
    public SQLReverseQuoteIdentifier visitReverseQuoteIdentifier(DRDSSQLStatementParser.ReverseQuoteIdentifierContext ctx) {
        return new SQLReverseQuoteIdentifier(ctx.getText());
    }

    @Override
    public SQLDoubleQuoteIdentifier visitDoubleQuoteIdentifier1(DRDSSQLStatementParser.DoubleQuoteIdentifier1Context ctx) {
        return new SQLDoubleQuoteIdentifier(ctx.getText());
    }

    public SQLName visitNameIdentifier(DRDSSQLStatementParser.NameIdentifierContext ctx) {
        if (ctx == null) {
            return null;
        }
        return (SQLName) super.visit(ctx);
    }

    @Override
    public SQLPropertyExpr visitPropertyIdentifier1(DRDSSQLStatementParser.PropertyIdentifier1Context ctx) {
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
    public SQLPropertyExpr visitPropertyIdentifier2(DRDSSQLStatementParser.PropertyIdentifier2Context ctx) {
        SQLExpr owner = visitExpr(ctx.expr());
        SQLIdentifier name = (SQLIdentifier) visit(ctx.nameIdentifier());
        return new SQLPropertyExpr(owner, name);
    }

    // ----------------  Identified End --------------------------------------------------------


    // ----------------  Literals Start --------------------------------------------------------

    @Override
    public SQLNCharLiteral visitNCharLiteral(DRDSSQLStatementParser.NCharLiteralContext ctx) {
        return new SQLNCharLiteral(ctx.getText());
    }

    @Override
    public SQLCharLiteral visitCharLiteral(DRDSSQLStatementParser.CharLiteralContext ctx) {
        return new SQLCharLiteral(ctx.getText());
    }

    @Override
    public SQLObject visitCharsetNamChareLiteral(DRDSSQLStatementParser.CharsetNamChareLiteralContext ctx) {
        return super.visitCharsetNamChareLiteral(ctx);
    }

    @Override
    public SQLIntegerLiteral visitIntegerLiteral(DRDSSQLStatementParser.IntegerLiteralContext ctx) {
        return new SQLIntegerLiteral(ctx.getText());
    }

    @Override
    public SQLNumberLiteral visitNumberLiteral(DRDSSQLStatementParser.NumberLiteralContext ctx) {
        return new SQLNumberLiteral(ctx.getText());
    }

    @Override
    public SQLDateLiteral visitDateLiteral(DRDSSQLStatementParser.DateLiteralContext ctx) {
        SQLExpr value = (SQLExpr) visitChildren(ctx.expr());
        return new SQLDateLiteral(value);
    }

    @Override
    public SQLTimeLiteral visitTimeLiteral(DRDSSQLStatementParser.TimeLiteralContext ctx) {
        SQLExpr value = (SQLExpr) visitChildren(ctx.expr());
        return new SQLTimeLiteral(value);
    }

    @Override
    public SQLTimestampLiteral visitTimestampLiteral(DRDSSQLStatementParser.TimestampLiteralContext ctx) {
        SQLExpr value = (SQLExpr) visitChildren(ctx.value);
        return new SQLTimestampLiteral(value);
    }

    @Override
    public SQLObject visitIntervalLiteral(DRDSSQLStatementParser.IntervalLiteralContext ctx) {
        SQLIntervalLiteral x = new SQLIntervalLiteral();

        SQLExpr value = visitExpr(ctx.expr());
        x.setValue(value);

        SQLIntervalUnit unit = SQLIntervalUnit.valueOf(ctx.intervalType().getText());
        x.setUnit(unit);

        return x;
    }

    @Override
    public SQLHexadecimalLiteral visitHexadecimalLiteral(DRDSSQLStatementParser.HexadecimalLiteralContext ctx) {
        return new SQLHexadecimalLiteral(ctx.getText());
    }

    @Override
    public SQLBitLiteral visitBitLiteral(DRDSSQLStatementParser.BitLiteralContext ctx) {
        return new SQLBitLiteral(ctx.getText());
    }

    @Override
    public SQLBooleanLiteral visitFalseLiteral(DRDSSQLStatementParser.FalseLiteralContext ctx) {
        return new SQLBooleanLiteral(false);
    }

    @Override
    public SQLBooleanLiteral visitTrueLiteral(DRDSSQLStatementParser.TrueLiteralContext ctx) {
        return new SQLBooleanLiteral(true);
    }

    @Override
    public SQLNullExpr visitNullLiteral(DRDSSQLStatementParser.NullLiteralContext ctx) {
        return new SQLNullExpr();
    }

    // ----------------  Literals End --------------------------------------------------------

    // ----------------  Expr Start --------------------------------------------------------
    public SQLExpr visitExpr(DRDSSQLStatementParser.ExprContext ctx) {
        if (ctx == null) {
            return null;
        }
        return (SQLExpr) super.visit(ctx);
    }

    @Override
    public SQLUnaryOperatorExpr visitUnaryOperatorExpr(DRDSSQLStatementParser.UnaryOperatorExprContext ctx) {
        boolean paren = ctx.LEFT_PAREN() != null;
        SQLUnaryOperator operator = SQLUnaryOperator.of(ctx.unaryOperator().getText());
        SQLExpr expr = visitExpr(ctx.expr());
        SQLUnaryOperatorExpr x = new SQLUnaryOperatorExpr(paren, operator, expr);
        return x;
    }

    @Override
    public SQLBinaryOperatorExpr visitBinaryOperatorExpr(DRDSSQLStatementParser.BinaryOperatorExprContext ctx) {
        boolean paren = ctx.LEFT_PAREN() != null;

        SQLExpr left = visitExpr(ctx.expr(0));
        SQLExpr right = visitExpr(ctx.expr(1));
        SQLBinaryOperator operator = SQLBinaryOperator.of(ctx.operator.getText());

        return new SQLBinaryOperatorExpr(paren, left, operator, right);
    }

    @Override
    public SQLBinaryOperatorExpr visitComparisonBinaryOperatorExpr(DRDSSQLStatementParser.ComparisonBinaryOperatorExprContext ctx) {
        boolean paren = ctx.LEFT_PAREN() != null;
        SQLExpr left = visitExpr(ctx.expr(0));
        SQLExpr right = visitExpr(ctx.expr(1));
        SQLBinaryOperator operator = SQLBinaryOperator.of(ctx.comparisonOp().getText());
        return new SQLBinaryOperatorExpr(paren, left, operator, right);
    }

    @Override
    public SQLVariableExpr visitVariableExpr(DRDSSQLStatementParser.VariableExprContext ctx) {
        return new SQLVariableExpr();
    }

    @Override
    public SQLLocalVariableExpr visitLocalVariableExpr(DRDSSQLStatementParser.LocalVariableExprContext ctx) {
        return new SQLLocalVariableExpr(ctx.getText());
    }

    @Override
    public SQLGlobalVariableExpr visitGlobalVariableExpr(DRDSSQLStatementParser.GlobalVariableExprContext ctx) {
        return new SQLGlobalVariableExpr(ctx.getText());
    }

    @Override
    public SQLGlobalGlobalVariableExpr visitGlobalGlobalVariableExpr(DRDSSQLStatementParser.GlobalGlobalVariableExprContext ctx) {
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
    public SQLSessionGlobalVariableExpr visitSessionGlobalVariableExpr(DRDSSQLStatementParser.SessionGlobalVariableExprContext ctx) {
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
    public SQLPersistGlobalVariableExpr visitPersistGlobalVariableExpr(DRDSSQLStatementParser.PersistGlobalVariableExprContext ctx) {
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
    public SQLPersistOnlyGlobalVariableExpr visitPersistOnlyGlobalVariableExpr(DRDSSQLStatementParser.PersistOnlyGlobalVariableExprContext ctx) {
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
    public SQLNewVariableRefExpr visitNewVariableRefExpr(DRDSSQLStatementParser.NewVariableRefExprContext ctx) {
        if (ctx == null) {
            return null;
        }
        SQLNewVariableRefExpr x = new SQLNewVariableRefExpr();
        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);
        return x;
    }

    @Override
    public SQLOldVariableRefExpr visitOldVariableRefExpr(DRDSSQLStatementParser.OldVariableRefExprContext ctx) {
        if (ctx == null) {
            return null;
        }
        SQLOldVariableRefExpr x = new SQLOldVariableRefExpr();
        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        x.setName(name);
        return x;
    }

    @Override
    public SQLSelectQueryExpr visitSelectQueryExpr(DRDSSQLStatementParser.SelectQueryExprContext ctx) {
        ISQLSelectQuery subQuery = visitISelectQuery(ctx.iSelectQuery());
        SQLSelectQueryExpr x = new SQLSelectQueryExpr(subQuery);

        if (ctx.LEFT_PAREN() != null
                && ctx.RIGHT_PAREN() != null) {
            x.setParen(true);
        }
        return x;
    }

    @Override
    public SQLObject visitMatchExpr(DRDSSQLStatementParser.MatchExprContext ctx) {
        return super.visitMatchExpr(ctx);
    }

    @Override
    public SQLObject visitSearchModifier(DRDSSQLStatementParser.SearchModifierContext ctx) {
        return super.visitSearchModifier(ctx);
    }

    @Override
    public SQLObject visitCaseExpr(DRDSSQLStatementParser.CaseExprContext ctx) {
        SQLCaseExpr x = new SQLCaseExpr();

        if (ctx.expr() != null) {
            SQLExpr expr = visitExpr(ctx.expr());
            x.setExpr(expr);
        }

        for (DRDSSQLStatementParser.CaseExprWhenItemContext caseExprWhenItemContext : ctx.caseExprWhenItem()) {
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
    public SQLCaseExpr.SQLCaseExprWhenItem visitCaseExprWhenItem(DRDSSQLStatementParser.CaseExprWhenItemContext ctx) {
        SQLExpr when = visitExpr(ctx.when);
        SQLExpr then = visitExpr(ctx.then);

        return new SQLCaseExpr.SQLCaseExprWhenItem(when, then);
    }

    @Override
    public SQLCaseExpr.SQLCaseExprElseClause visitCaseExprElseClause(DRDSSQLStatementParser.CaseExprElseClauseContext ctx) {
        SQLExpr expr = visitExpr(ctx.expr());
        return new SQLCaseExpr.SQLCaseExprElseClause(expr);
    }

    @Override
    public SQLListExpr visitListExpr(DRDSSQLStatementParser.ListExprContext ctx) {
        SQLListExpr x = new SQLListExpr();
        for (DRDSSQLStatementParser.ExprContext exprContext : ctx.expr()) {
            SQLExpr item = visitExpr(exprContext);
            x.addItem(item);
        }
        return x;
    }

    @Override
    public SQLSomeClause visitSomeExpr(DRDSSQLStatementParser.SomeExprContext ctx) {
        SQLExpr expr = visitExpr(ctx.expr());
        return new SQLSomeClause(expr);
    }

    @Override
    public SQLAllClause visitAllExpr(DRDSSQLStatementParser.AllExprContext ctx) {
        SQLExpr expr = visitExpr(ctx.expr());
        return new SQLAllClause(expr);
    }

    @Override
    public SQLAnyClause visitAnyExpr(DRDSSQLStatementParser.AnyExprContext ctx) {
        SQLExpr expr = visitExpr(ctx.expr());
        return new SQLAnyClause(expr);
    }

    @Override
    public SQLDefaultClause visitDefaultClause(DRDSSQLStatementParser.DefaultClauseContext ctx) {
        SQLExpr expr = visitExpr(ctx.expr());
        return new SQLDefaultClause(expr);
    }

    @Override
    public SQLAutoIncrementOptionExpr visitAutoIncrementOptionExpr(DRDSSQLStatementParser.AutoIncrementOptionExprContext ctx) {
        if (ctx == null) {
            return null;
        }
        SQLExpr value = visitExpr(ctx.expr());
        SQLAutoIncrementOptionExpr x = new SQLAutoIncrementOptionExpr(value);
        return x;
    }

    @Override
    public SQLAvgRowLengthOptionExpr visitAvgRowLengthOptionExpr(DRDSSQLStatementParser.AvgRowLengthOptionExprContext ctx) {
        if (ctx == null) {
            return null;
        }
        SQLExpr value = visitExpr(ctx.expr());
        SQLAvgRowLengthOptionExpr x = new SQLAvgRowLengthOptionExpr(value);
        return x;
    }

    @Override
    public SQLCharacterSetOptionExpr visitCharacterSetOptionExpr(DRDSSQLStatementParser.CharacterSetOptionExprContext ctx) {
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
    public SQLCharsetOptionExpr visitCharsetOptionExpr(DRDSSQLStatementParser.CharsetOptionExprContext ctx) {
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
    public SQLChecksumOptionExpr visitChecksumOptionExpr(DRDSSQLStatementParser.ChecksumOptionExprContext ctx) {
        if (ctx == null) {
            return null;
        }
        boolean equalSign = ctx.EQUALS_OP() != null;
        SQLExpr value = visitExpr(ctx.expr());
        SQLChecksumOptionExpr x = new SQLChecksumOptionExpr(equalSign, value);
        return x;
    }

    @Override
    public SQLCommentOptionExpr visitCommentOptionExpr(DRDSSQLStatementParser.CommentOptionExprContext ctx) {
        if (ctx == null) {
            return null;
        }
        boolean equalSign = ctx.EQUALS_OP() != null;
        SQLExpr value = visitExpr(ctx.expr());
        SQLCommentOptionExpr x = new SQLCommentOptionExpr(equalSign, value);
        return x;
    }

    @Override
    public SQLObject visitCompressionOptionExpr(DRDSSQLStatementParser.CompressionOptionExprContext ctx) {
        return super.visitCompressionOptionExpr(ctx);
    }

    @Override
    public SQLObject visitConnectionOptionExpr(DRDSSQLStatementParser.ConnectionOptionExprContext ctx) {
        return super.visitConnectionOptionExpr(ctx);
    }

    @Override
    public SQLObject visitDataDirectoryOptionExpr(DRDSSQLStatementParser.DataDirectoryOptionExprContext ctx) {
        return super.visitDataDirectoryOptionExpr(ctx);
    }

    @Override
    public SQLObject visitIndexDirectoryOptionExpr(DRDSSQLStatementParser.IndexDirectoryOptionExprContext ctx) {
        return super.visitIndexDirectoryOptionExpr(ctx);
    }

    @Override
    public SQLObject visitDelayKeyWriteOptionExpr(DRDSSQLStatementParser.DelayKeyWriteOptionExprContext ctx) {
        return super.visitDelayKeyWriteOptionExpr(ctx);
    }

    @Override
    public SQLObject visitEncryptionOptionExpr(DRDSSQLStatementParser.EncryptionOptionExprContext ctx) {
        return super.visitEncryptionOptionExpr(ctx);
    }

    @Override
    public SQLEngineOptionExpr visitEngineOptionExpr(DRDSSQLStatementParser.EngineOptionExprContext ctx) {
        if (ctx == null) {
            return null;
        }
        boolean equalSign = ctx.EQUALS_OP() != null;
        SQLExpr value = visitExpr(ctx.expr());
        SQLEngineOptionExpr x = new SQLEngineOptionExpr(equalSign, value);
        return x;
    }

    @Override
    public SQLObject visitInsertMethodOptionExpr(DRDSSQLStatementParser.InsertMethodOptionExprContext ctx) {
        return super.visitInsertMethodOptionExpr(ctx);
    }

    @Override
    public SQLObject visitKeyBlockSizeOptionExpr(DRDSSQLStatementParser.KeyBlockSizeOptionExprContext ctx) {
        return super.visitKeyBlockSizeOptionExpr(ctx);
    }

    @Override
    public SQLObject visitMaxRowsOptionExpr(DRDSSQLStatementParser.MaxRowsOptionExprContext ctx) {
        return super.visitMaxRowsOptionExpr(ctx);
    }

    @Override
    public SQLObject visitMinRowsOptionExpr(DRDSSQLStatementParser.MinRowsOptionExprContext ctx) {
        return super.visitMinRowsOptionExpr(ctx);
    }

    @Override
    public SQLObject visitPackKeysOptionExpr(DRDSSQLStatementParser.PackKeysOptionExprContext ctx) {
        return super.visitPackKeysOptionExpr(ctx);
    }

    @Override
    public SQLObject visitPasswordOptionExpr(DRDSSQLStatementParser.PasswordOptionExprContext ctx) {
        return super.visitPasswordOptionExpr(ctx);
    }

    @Override
    public SQLObject visitRowFormatOptionExpr(DRDSSQLStatementParser.RowFormatOptionExprContext ctx) {
        return super.visitRowFormatOptionExpr(ctx);
    }

    @Override
    public SQLObject visitStatsAutoRecalcOptionExpr(DRDSSQLStatementParser.StatsAutoRecalcOptionExprContext ctx) {
        return super.visitStatsAutoRecalcOptionExpr(ctx);
    }

    @Override
    public SQLObject visitStatsPersistentOptionExpr(DRDSSQLStatementParser.StatsPersistentOptionExprContext ctx) {
        return super.visitStatsPersistentOptionExpr(ctx);
    }

    @Override
    public SQLObject visitStatsSamplePageOptionExpr(DRDSSQLStatementParser.StatsSamplePageOptionExprContext ctx) {
        return super.visitStatsSamplePageOptionExpr(ctx);
    }

    @Override
    public SQLTablespaceOptionExpr visitTablespaceOptionExpr(DRDSSQLStatementParser.TablespaceOptionExprContext ctx) {
        if (ctx == null) {
            return null;
        }
        SQLExpr value = visitNameIdentifier(ctx.nameIdentifier());
        SQLTablespaceOptionExpr x = new SQLTablespaceOptionExpr(value);
        return x;
    }

    @Override
    public SQLObject visitUnionOptionExpr(DRDSSQLStatementParser.UnionOptionExprContext ctx) {
        return super.visitUnionOptionExpr(ctx);
    }

    @Override
    public SQLBroadcastExpr visitBroadcastExpr(DRDSSQLStatementParser.BroadcastExprContext ctx) {
        return new SQLBroadcastExpr();
    }

    @Override
    public SQLCollateOptionExpr visitCollateOptionExpr(DRDSSQLStatementParser.CollateOptionExprContext ctx) {
        if (ctx == null) {
            return null;
        }
        SQLName name = visitNameIdentifier(ctx.nameIdentifier());
        SQLCollateOptionExpr x = new SQLCollateOptionExpr(name);
        return x;
    }

    @Override
    public SQLAssignmentExpr visitAssignmentExpr(DRDSSQLStatementParser.AssignmentExprContext ctx) {
        if (ctx == null) {
            return null;
        }
        SQLExpr column = visitExpr(ctx.name);
        SQLExpr value = visitExpr(ctx.value);
        return new SQLAssignmentExpr(column, value);
    }

    @Override
    public SQLDefaultLiteral visitDefaultLiteral(DRDSSQLStatementParser.DefaultLiteralContext ctx) {
        return new SQLDefaultLiteral();
    }

    @Override
    public SQLAllLiteral visitAllLiteral(DRDSSQLStatementParser.AllLiteralContext ctx) {
        return new SQLAllLiteral();
    }

    @Override
    public SQLNoneLiteral visitNoneLiteral(DRDSSQLStatementParser.NoneLiteralContext ctx) {
        return new SQLNoneLiteral();
    }

    @Override
    public SQLMaxValueLiteral visitMaxValueLiteral(DRDSSQLStatementParser.MaxValueLiteralContext ctx) {
        return new SQLMaxValueLiteral();
    }

    // ----------------  Expr End --------------------------------------------------------


    // --------------------------------------- condition Start ----------------------------------------------------------------

    @Override
    public SQLSoundsLikeCondition visitSoundsLikeCondition(DRDSSQLStatementParser.SoundsLikeConditionContext ctx) {
        SQLExpr expr = visitExpr(ctx.value);
        SQLExpr pattern = visitExpr(ctx.pattern);

        return new SQLSoundsLikeCondition(expr, pattern);
    }

    @Override
    public SQLRlikeCondition visitRlikeCondition(DRDSSQLStatementParser.RlikeConditionContext ctx) {
        SQLExpr expr = visitExpr(ctx.value);
        SQLExpr pattern = visitExpr(ctx.pattern);
        boolean not = ctx.NOT() != null;

        return new SQLRlikeCondition(expr, not, pattern);
    }

    @Override
    public SQLInCondition visitInCondition(DRDSSQLStatementParser.InConditionContext ctx) {
        SQLExpr name = visitExpr(ctx.name);

        SQLInCondition x = new SQLInCondition();

        x.setExpr(name);

        for (DRDSSQLStatementParser.ExprContext exprContext : ctx.values) {
            SQLExpr value = visitExpr(exprContext);
            x.addValue(value);
        }

        boolean not = ctx.NOT() != null;
        x.setNot(not);

        return x;
    }

    @Override
    public SQLObject visitIsNullCondition(DRDSSQLStatementParser.IsNullConditionContext ctx) {
        SQLExpr expr = visitExpr(ctx.expr());

        SQLIsNullCondition x = new SQLIsNullCondition(expr);

        boolean not = ctx.NOT() != null;
        x.setNot(not);

        return x;
    }

    @Override
    public SQLRegexpCondition visitRegexpCondition(DRDSSQLStatementParser.RegexpConditionContext ctx) {
        SQLExpr expr = visitExpr(ctx.value);
        boolean not = ctx.NOT() != null;
        SQLExpr pattern = visitExpr(ctx.pattern);

        return new SQLRegexpCondition(expr, not, pattern);
    }

    @Override
    public SQLObject visitLikeCondition(DRDSSQLStatementParser.LikeConditionContext ctx) {
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
    public SQLBetweenCondition visitBetweenCondition(DRDSSQLStatementParser.BetweenConditionContext ctx) {
        SQLExpr name = visitExpr(ctx.name);
        SQLExpr between = visitExpr(ctx.between);
        SQLExpr and = visitExpr(ctx.and);

        boolean not = ctx.NOT() != null;

        return new SQLBetweenCondition(name, not, between, and);
    }

    @Override
    public SQLIsBooleanLiteralCondition visitIsBooleanLiteralCondition(DRDSSQLStatementParser.IsBooleanLiteralConditionContext ctx) {
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
    public SQLNotCondition visitNotCondition(DRDSSQLStatementParser.NotConditionContext ctx) {
        SQLExpr expr = visitExpr(ctx.expr());
        return new SQLNotCondition(expr);
    }

    @Override
    public SQLExistsCondition visitExistsCondition(DRDSSQLStatementParser.ExistsConditionContext ctx) {
        ISQLSelectQuery subQuery = visitISelectQuery(ctx.iSelectQuery());
        SQLExistsCondition x = new SQLExistsCondition(subQuery);
        return x;
    }

    // --------------------------------------- condition End ----------------------------------------------------------------


    // --------------------------------------- Function Start ----------------------------------------------------------------
    @Override
    public SQLMethodInvocation visitMethodInvocation1(DRDSSQLStatementParser.MethodInvocation1Context ctx) {
        String name = ctx.noArgumentFunctionName().getText();

        SQLMethodInvocation x = new SQLMethodInvocation(name);

        boolean paren = ctx.LEFT_PAREN() != null;
        x.setParen(paren);

        for (DRDSSQLStatementParser.ExprContext argumentContext : ctx.arguments) {
            SQLExpr argument = visitExpr(argumentContext);
            x.addArgument(argument);
        }
        return x;
    }

    @Override
    public SQLMethodInvocation visitMethodInvocation2(DRDSSQLStatementParser.MethodInvocation2Context ctx) {
        SQLExpr name = visitExpr(ctx.name);

        SQLMethodInvocation x = new SQLMethodInvocation(name);

        SQLSetQuantifier setQuantifier = of(ctx.setQuantifier());
        x.setSetQuantifier(setQuantifier);

        for (DRDSSQLStatementParser.ExprContext argumentContext : ctx.arguments) {
            SQLExpr argument = visitExpr(argumentContext);
            x.addArgument(argument);
        }
        return x;
    }
    // --------------------------------------- Function End ----------------------------------------------------------------


    public SQLOrderingSpecification of(DRDSSQLStatementParser.OrderingSpecificationContext ctx) {
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


    public SQLInTimeAction of(DRDSSQLStatementParser.IntimeActionContext ctx) {
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

    public SQLIndexCategory of(DRDSSQLStatementParser.IndexCategoryContext ctx) {
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

    public SQLIndexFormat of(DRDSSQLStatementParser.IndexFormatContext ctx) {
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

    public SQLIndexType of(DRDSSQLStatementParser.IndexTypeContext ctx) {
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


    public SQLWithType of(DRDSSQLStatementParser.WithTypeContext ctx) {
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

    public SQLVisibleType of(DRDSSQLStatementParser.VisibleTypeContext ctx) {
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

    public SQLPriorityType of(DRDSSQLStatementParser.PriorityContext ctx) {
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
