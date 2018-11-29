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
package com.aliyun.gumiho.sql.util;

import com.aliyun.gumiho.sql.antlr.CaseInsensitiveCharStream;
import com.aliyun.gumiho.sql.basic.ast.SQLObject;
import com.aliyun.gumiho.sql.basic.ast.element.datatype.SQLDataType;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.dialect.mysql.parser.MySQLSQLStatementLexer;
import com.aliyun.gumiho.sql.dialect.mysql.parser.MySQLSQLStatementParser;
import com.aliyun.gumiho.sql.dialect.mysql.visitor.MySQLSQLASTBuilderVisitor;
import com.aliyun.gumiho.sql.dialect.oracle.parser.OracleSQLStatementLexer;
import com.aliyun.gumiho.sql.dialect.oracle.parser.OracleSQLStatementParser;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTBuilderVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.exception.SQLLexerExceptionListener;
import com.aliyun.gumiho.sql.exception.SQLParserException;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kongtong.ouyang onCondition 2018/3/2.
 */
public final class SQLParserUtils {

    public static List<SQLObject> parse(String sql, DBType dbType) throws SQLParserException {
        ParseTree parseTree = createParseTree(sql, dbType);

        List<SQLObject> sqlObjects = new ArrayList<>();
        ParseTreeVisitor visitor = createASTBuilderVisitor(sqlObjects, dbType);

        visitor.visit(parseTree);

        return sqlObjects;
    }

    private static ParseTree createParseTree(String sql, DBType dbType) {
        CodePointCharStream charStream = CharStreams.fromString(sql);
        CaseInsensitiveCharStream caseInsensitiveCharStream = new CaseInsensitiveCharStream(charStream);

        Lexer lexer;

        if (dbType == DBType.Oracle) {
            lexer = new OracleSQLStatementLexer(caseInsensitiveCharStream);

            lexer.removeErrorListeners();
            lexer.addErrorListener(SQLLexerExceptionListener.INSTANCE);

            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            OracleSQLStatementParser parser = new OracleSQLStatementParser(tokenStream);

            parser.removeErrorListeners();
            parser.addErrorListener(SQLLexerExceptionListener.INSTANCE);

            return parser.parse();
        }

        if (dbType == DBType.MySQL) {
            lexer = new MySQLSQLStatementLexer(caseInsensitiveCharStream);
            lexer.removeErrorListeners();
            lexer.addErrorListener(SQLLexerExceptionListener.INSTANCE);
            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            MySQLSQLStatementParser parser = new MySQLSQLStatementParser(tokenStream);

            parser.removeErrorListeners();
            parser.addErrorListener(SQLLexerExceptionListener.INSTANCE);

            return parser.parse();
        }

        if (dbType == DBType.DRDS) {
//            lexer = new DRDSSQLStatementLexer(caseInsensitiveCharStream);
//
//            lexer.removeErrorListeners();
//            lexer.addErrorListener(SQLLexerExceptionListener.INSTANCE);
//
//            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
//            DRDSSQLStatementParser parser = new DRDSSQLStatementParser(tokenStream);
//
//            parser.removeErrorListeners();
//            parser.addErrorListener(SQLLexerExceptionListener.INSTANCE);
//
//            return parser.parse();
        }

        if (dbType == DBType.SQLServer) {
//            lexer = new MySQLSQLStatementLexer(caseInsensitiveCharStream);
//            lexer.removeErrorListeners();
//            lexer.addErrorListener(SQLLexerExceptionListener.INSTANCE);
//            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
//            MySQLSQLStatementParser parser = new MySQLSQLStatementParser(tokenStream);
//            return parser.parse();
        }

        if (dbType == DBType.PPAS) {

            return null;
        }

        if (dbType == DBType.PostgreSQL) {
//            lexer = new MySQLSQLStatementLexer(caseInsensitiveCharStream);
//            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
//            MySQLSQLStatementParser parser = new MySQLSQLStatementParser(tokenStream);
//
//            return parser.parse();
        }

//        lexer = new SQLStatementLexer(caseInsensitiveCharStream);
//        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
//        SQLStatementParser parser = new SQLStatementParser(tokenStream);
//        return parser.parse();
        return null;

    }

    private static ParseTreeVisitor<SQLObject> createASTBuilderVisitor(List<SQLObject> sqlObjects, DBType dbType) {
        if (dbType == null) {
            dbType = DBType.SQL;
        }
        switch (dbType) {
            case Oracle:
                return new OracleSQLASTBuilderVisitor(sqlObjects);
//            case PPAS:
//                return new PPASSQLASTBuilderVisitor(sqlObjects);
//            case PostgreSQL:
//                return new PostgreSQLSQLASTBuilderVisitor(sqlObjects);
            case MySQL:
                return new MySQLSQLASTBuilderVisitor(sqlObjects);
//            case DRDS:
//                return new DRDSSQLASTBuilderVisitor(sqlObjects);
//            case MariaDB:
//                return new MariaDBSQLASTBuilderVisitor(sqlObjects);
//            case SQLServer:
//                return new SQLServerSQLASTBuilderVisitor(sqlObjects);
//            default:
//                return new SQLASTBuilderVisitor(sqlObjects);
        }
        return null;
    }


    public static SQLDataType toSQLDataType(String sql, DBType dbType) {
        ParseTree parseTree = createDataTypeParseTree(sql, dbType);

        ParseTreeVisitor<SQLObject> visitor = createASTBuilderVisitor(null, dbType);

        SQLObject target = visitor.visit(parseTree);
        if (target instanceof SQLDataType) {
            return (SQLDataType) target;
        }

        return null;
    }


    private static ParseTree createDataTypeParseTree(String sql, DBType dbType) {
        CodePointCharStream charStream = CharStreams.fromString(sql);
        CaseInsensitiveCharStream caseInsensitiveCharStream = new CaseInsensitiveCharStream(charStream);

        Lexer lexer;

        if (dbType == DBType.Oracle) {
            lexer = new OracleSQLStatementLexer(caseInsensitiveCharStream);

            lexer.removeErrorListeners();
            lexer.addErrorListener(SQLLexerExceptionListener.INSTANCE);
//            lexer.setInterpreter(new LexerATNSimulator(lexer, lexer.getATN(), lexer.getInterpreter().decisionToDFA, new PredictionContextCache()));

            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            OracleSQLStatementParser parser = new OracleSQLStatementParser(tokenStream);

            parser.removeErrorListeners();
            parser.addErrorListener(SQLLexerExceptionListener.INSTANCE);

//            parser.setInterpreter(new ParserATNSimulator(parser, parser.getATN(), parser.getInterpreter().decisionToDFA, new PredictionContextCache()));

            return parser.dataType();
        }

        if (dbType == DBType.MySQL) {
            lexer = new MySQLSQLStatementLexer(caseInsensitiveCharStream);

            lexer.removeErrorListeners();
            lexer.addErrorListener(SQLLexerExceptionListener.INSTANCE);

            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            MySQLSQLStatementParser parser = new MySQLSQLStatementParser(tokenStream);

            parser.removeErrorListeners();
            parser.addErrorListener(SQLLexerExceptionListener.INSTANCE);

            return parser.dataType();
        }

        if (dbType == DBType.DRDS) {
//            lexer = new DRDSSQLStatementLexer(caseInsensitiveCharStream);
//
//            lexer.removeErrorListeners();
//            lexer.addErrorListener(SQLLexerExceptionListener.INSTANCE);
//
//            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
//            DRDSSQLStatementParser parser = new DRDSSQLStatementParser(tokenStream);
//
//            parser.removeErrorListeners();
//            parser.addErrorListener(SQLLexerExceptionListener.INSTANCE);
//
//            return parser.dataType();
        }

        if (dbType == DBType.SQLServer) {
//            lexer = new SQLServerSQLStatementLexer(caseInsensitiveCharStream);
//
//            lexer.removeErrorListeners();
//            lexer.addErrorListener(SQLLexerExceptionListener.INSTANCE);
//
//            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
//            SQLServerSQLStatementParser parser = new SQLServerSQLStatementParser(tokenStream);
//
//            parser.removeErrorListeners();
//            parser.addErrorListener(SQLLexerExceptionListener.INSTANCE);
//
//            return parser.data_type();
        }

        if (dbType == DBType.PPAS) {
//            lexer = new PPASSQLStatementLexer(caseInsensitiveCharStream);
//
//            lexer.removeErrorListeners();
//            lexer.addErrorListener(SQLLexerExceptionListener.INSTANCE);
//
//            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
//            PPASSQLStatementParser parser = new PPASSQLStatementParser(tokenStream);
//
//            parser.removeErrorListeners();
//            parser.addErrorListener(SQLLexerExceptionListener.INSTANCE);
//
//            return parser.dataType();
        }

        if (dbType == DBType.PostgreSQL) {
//            lexer = new PostgreSQLSQLStatementLexer(caseInsensitiveCharStream);
//
//            lexer.removeErrorListeners();
//            lexer.addErrorListener(SQLLexerExceptionListener.INSTANCE);
//
//            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
//            PostgreSQLSQLStatementParser parser = new PostgreSQLSQLStatementParser(tokenStream);
//
//            parser.removeErrorListeners();
//            parser.addErrorListener(SQLLexerExceptionListener.INSTANCE);
//
//            return parser.dataType();
        }

//        lexer = new SQLStatementLexer(caseInsensitiveCharStream);
//        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
//        SQLStatementParser parser = new SQLStatementParser(tokenStream);
//        return parser.parse();
        return null;

    }


    public static SQLExpr toSQLExpr(String sql, DBType dbType) {
        ParseTree parseTree = createExprParseTree(sql, dbType);

        ParseTreeVisitor<SQLObject> visitor = createASTBuilderVisitor(null, dbType);

        SQLObject target = visitor.visit(parseTree);
        if (target instanceof SQLExpr) {
            return (SQLDataType) target;
        }
        return null;
    }


    private static ParseTree createExprParseTree(String sql, DBType dbType) {
        CodePointCharStream charStream = CharStreams.fromString(sql);
        CaseInsensitiveCharStream caseInsensitiveCharStream = new CaseInsensitiveCharStream(charStream);

        Lexer lexer;

        if (dbType == DBType.Oracle) {
            lexer = new OracleSQLStatementLexer(caseInsensitiveCharStream);

            lexer.removeErrorListeners();
            lexer.addErrorListener(SQLLexerExceptionListener.INSTANCE);

            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            OracleSQLStatementParser parser = new OracleSQLStatementParser(tokenStream);

            parser.removeErrorListeners();
            parser.addErrorListener(SQLLexerExceptionListener.INSTANCE);

            return parser.dataType();
        }

        if (dbType == DBType.MySQL) {
            lexer = new MySQLSQLStatementLexer(caseInsensitiveCharStream);

            lexer.removeErrorListeners();
            lexer.addErrorListener(SQLLexerExceptionListener.INSTANCE);

            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            MySQLSQLStatementParser parser = new MySQLSQLStatementParser(tokenStream);

            parser.removeErrorListeners();
            parser.addErrorListener(SQLLexerExceptionListener.INSTANCE);

            return parser.dataType();
        }

        if (dbType == DBType.DRDS) {
//            lexer = new DRDSSQLStatementLexer(caseInsensitiveCharStream);
//
//            lexer.removeErrorListeners();
//            lexer.addErrorListener(SQLLexerExceptionListener.INSTANCE);
//
//            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
//            DRDSSQLStatementParser parser = new DRDSSQLStatementParser(tokenStream);
//
//            parser.removeErrorListeners();
//            parser.addErrorListener(SQLLexerExceptionListener.INSTANCE);
//
//            return parser.dataType();
        }

        if (dbType == DBType.SQLServer) {
//            lexer = new SQLServerSQLStatementLexer(caseInsensitiveCharStream);
//
//            lexer.removeErrorListeners();
//            lexer.addErrorListener(SQLLexerExceptionListener.INSTANCE);
//
//            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
//            SQLServerSQLStatementParser parser = new SQLServerSQLStatementParser(tokenStream);
//
//            parser.removeErrorListeners();
//            parser.addErrorListener(SQLLexerExceptionListener.INSTANCE);
//
//            return parser.data_type();
        }

        if (dbType == DBType.PPAS) {
//            lexer = new PPASSQLStatementLexer(caseInsensitiveCharStream);
//
//            lexer.removeErrorListeners();
//            lexer.addErrorListener(SQLLexerExceptionListener.INSTANCE);
//
//            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
//            PPASSQLStatementParser parser = new PPASSQLStatementParser(tokenStream);
//
//            parser.removeErrorListeners();
//            parser.addErrorListener(SQLLexerExceptionListener.INSTANCE);
//
//            return parser.dataType();
        }

        if (dbType == DBType.PostgreSQL) {
//            lexer = new PostgreSQLSQLStatementLexer(caseInsensitiveCharStream);
//
//            lexer.removeErrorListeners();
//            lexer.addErrorListener(SQLLexerExceptionListener.INSTANCE);
//
//            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
//            PostgreSQLSQLStatementParser parser = new PostgreSQLSQLStatementParser(tokenStream);
//
//            parser.removeErrorListeners();
//            parser.addErrorListener(SQLLexerExceptionListener.INSTANCE);
//
//            return parser.dataType();
        }

//        lexer = new SQLStatementLexer(caseInsensitiveCharStream);
//        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
//        SQLStatementParser parser = new SQLStatementParser(tokenStream);
//        return parser.parse();
        return null;

    }

}
