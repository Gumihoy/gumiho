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

import com.aliyun.gumiho.sql.basic.ast.SQLObject;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.comment.SQLCommentOnColumnStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.comment.SQLCommentOnTableStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.table.SQLCreateTableStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTOutputVisitor;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.config.SQLOutputConfig;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.DBVersion;
import com.aliyun.gumiho.sql.translate.SQLTransformConfig;
import com.aliyun.gumiho.sql.translate.result.SQLTransformResult;
import com.aliyun.gumiho.sql.translate.visitor.*;
import com.aliyun.gumiho.sql.translate.visitor.oracle2.OracleSQLIntersectOrMinusToJoinASTVisitor;
import com.aliyun.gumiho.sql.translate.visitor.oracle2.OracleSQLRemovePropertyASTVisitor;
import com.aliyun.gumiho.sql.translate.visitor.oracle2.drds.Oracle2DRDSVersion5_6ASTTransformVisitor;
import com.aliyun.gumiho.sql.translate.visitor.oracle2.drds.Oracle2DRDSVersion5_7ASTTransformVisitor;
import com.aliyun.gumiho.sql.translate.visitor.oracle2.drds.Oracle2DRDSVersion8_0ASTTransformVisitor;
import com.aliyun.gumiho.sql.translate.visitor.oracle2.mysql.Oracle2MySQLVersion5_6ASTTransformVisitor;
import com.aliyun.gumiho.sql.translate.visitor.oracle2.mysql.Oracle2MySQLVersion5_7ASTTransformVisitor;
import com.aliyun.gumiho.sql.translate.visitor.oracle2.mysql.Oracle2MySQLVersion8_0ASTTransformVisitor;
import com.aliyun.gumiho.sql.translate.visitor.oracle2.postgresql.Oracle2PostgreSQLVersion10ASTTransformVisitor;
import com.aliyun.gumiho.sql.translate.visitor.oracle2.postgresql.Oracle2PostgreSQLVersion9_6ASTTransformVisitor;
import com.aliyun.gumiho.sql.translate.visitor.oracle2.ppas.Oracle2PPASSQLMixRemoveDoubleQuotesASTVisitor;
import com.aliyun.gumiho.sql.translate.visitor.oracle2.ppas.Oracle2PPASVersion10ASTTransformVisitor;
import com.aliyun.gumiho.sql.translate.visitor.oracle2.ppas.Oracle2PPASVersion9_6ASTTransformVisitor;
import com.aliyun.gumiho.sql.translate.visitor.oracle2.sqlserver.Oracle2SQLServerASTTransformVisitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

/**
 * @author kongtong.ouyang onCondition 2018/1/18.
 */
public final class SQLTransformUtils {

    protected final static Logger log = LoggerFactory.getLogger(SQLUtils.class);

    public static SQLTransformResult oracleToMySQL(String sql) {
        SQLTransformConfig config = new SQLTransformConfig();
        return oracleToMySQL(sql, config);
    }

    public static SQLTransformResult oracleToMySQL(String sql, SQLTransformConfig config) {
        if (config == null) {
            config = new SQLTransformConfig();
        }
        config.source = DBType.Oracle;
        config.target = DBType.MySQL;
        return translate(sql, config);
    }

    public static SQLTransformResult oracleToDRDS(String sql) {
        SQLTransformConfig config = new SQLTransformConfig();
        return oracleToDRDS(sql, config);
    }

    public static SQLTransformResult oracleToDRDS(String sql, SQLTransformConfig config) {
        if (config == null) {
            config = new SQLTransformConfig();
        }
        config.source = DBType.Oracle;
        config.target = DBType.DRDS;
        return translate(sql, config);
    }

    public static SQLTransformResult oracleToPPAS(String sql) {
        SQLTransformConfig config = new SQLTransformConfig();
        return oracleToPPAS(sql, config);
    }

    public static SQLTransformResult oracleToPPAS(String sql, SQLTransformConfig config) {
        if (config == null) {
            config = new SQLTransformConfig();
        }
        config.source = DBType.Oracle;
        config.target = DBType.PPAS;
        return translate(sql, config);
    }

    public static SQLTransformResult oracleToPostgreSQL(String sql) {
        SQLTransformConfig config = new SQLTransformConfig();
        return oracleToPostgreSQL(sql, config);
    }

    public static SQLTransformResult oracleToPostgreSQL(String sql, SQLTransformConfig config) {
        if (config == null) {
            config = new SQLTransformConfig();
        }
        config.source = DBType.Oracle;
        config.target = DBType.PostgreSQL;
        return translate(sql, config);
    }


    public static SQLTransformResult mysqlToOracle(String sql) {
        SQLTransformConfig config = new SQLTransformConfig();
        return mysqlToOracle(sql, config);
    }

    public static SQLTransformResult mysqlToOracle(String sql, SQLTransformConfig config) {
        if (config == null) {
            config = new SQLTransformConfig();
        }
        config.source = DBType.MySQL;
        config.target = DBType.Oracle;
        return translate(sql, config);
    }


    public static SQLTransformResult translate(String sql, SQLTransformConfig config) {

        DBType sourceDBType = config.source;
        DBType targetDBType = config.target;

        SQLTransformResult result = new SQLTransformResult(sql);
        List<SQLObject> stmtList;
        try {
            stmtList = SQLParserUtils.parse(sql, sourceDBType);
        } catch (Exception e) {
            log.warn("parser exception.", e);
            throw e;
        }

        config.stmtList = stmtList;
        StringBuilder buffers = new StringBuilder();
        SQLOutputConfig outputConfig = new SQLOutputConfig();
        List<SQLASTVisitor> transformVisitors = SQLTransformUtils.createASTTranslateVisitors(config);


        for (int i = 0; i < stmtList.size(); i++) {
            config.index = i;
            SQLObject stmt = stmtList.get(i);
            stmt.setDbType(sourceDBType);
            stmt.setTargetDBType(targetDBType);

            if ((targetDBType == DBType.MySQL
                    || targetDBType == DBType.DRDS
                    || targetDBType == DBType.MariaDB)
                    && stmt instanceof SQLCreateTableStatement) {
                SQLCreateTableStatement createTableStmt = (SQLCreateTableStatement) stmt;

                for (int j = 0; j < stmtList.size(); j++) {
                    SQLObject nextStmt = stmtList.get(j);
                    if (nextStmt instanceof SQLCommentOnTableStatement) {
                        boolean comment = createTableStmt.comment((SQLCommentOnTableStatement) nextStmt);
                        if (comment) {
                            stmtList.remove(j);
                            j = j - 1;
                        }
                    } else if (nextStmt instanceof SQLCommentOnColumnStatement) {
                        boolean comment = createTableStmt.comment((SQLCommentOnColumnStatement) nextStmt);
                        if (comment) {
                            stmtList.remove(j);
                            j = j - 1;
                        }
                    }
                }
            }

//            for (SQLASTTransformVisitor visitor : transformVisitors) {
//                SQLObject newStmt = stmtList.get(i);
//                if (stmt != newStmt) {
//                    i = i - 1;
//                    break;
//                }
//
//                stmt.accept(visitor);
//
//                result.changes.addAll(visitor.getChanges());
//                result.warnnings.addAll(visitor.getWarnnings());
//                result.errors.addAll(visitor.getErrors());
//            }
        }

        // output
        for (int i = 0; i < stmtList.size(); i++) {
            SQLObject stmt = stmtList.get(i);

            if (i != stmtList.size() - 1) {
                stmt.setAfterSemi(true);
            }

            StringBuilder buffer = new StringBuilder();
            SQLASTOutputVisitor outputVisitor = SQLUtils.createASTOutputVisitor(buffer, outputConfig, sourceDBType, targetDBType);
            SQLUtils.outputVisitor(stmt, outputVisitor);

            if (buffer.length() > 0) {
                if (i != stmtList.size() - 1) {
                    outputVisitor.println();
                }
                buffers.append(buffer);
            }

            result.addResult(SQLTransformResult.SQLResult.of(stmt.getObjectType(), buffer.toString()));
        }

        result.targetSql = buffers.toString();

        config.stmtList.clear();

        return result;
    }


    public static List<SQLASTVisitor> createASTTranslateVisitors(SQLTransformConfig config) {
        if (config == null) {
            throw new IllegalArgumentException("Translate config is null.");
        }
        DBType sourceDBType = config.source;
        DBType targetDBType = config.target;
        DBVersion targetDBVersion = config.targetVersion;

        if (sourceDBType == null) {
            throw new IllegalArgumentException("source database type is null.");
        }
        if (targetDBType == null) {
            throw new IllegalArgumentException("target database type is null.");
        }
        if (targetDBVersion == null) {
            targetDBVersion = DBVersion.defaultVersion(targetDBType);
        }

        List<SQLASTVisitor> visitors = new LinkedList<>();

        switch (sourceDBType) {
            case Oracle:
                switch (targetDBType) {
                    case Oracle:
                        visitors.add(new OracleSQLRemovePropertyASTVisitor(config));
                        break;
                    case PPAS:
                        visitors.add(new OracleSQLRemovePropertyASTVisitor(config));
                        visitors.add(new Oracle2PPASSQLMixRemoveDoubleQuotesASTVisitor(config));
                        switch (targetDBVersion) {
                            case PPAS_VERSION_9_6:
                                visitors.add(new Oracle2PPASVersion9_6ASTTransformVisitor(config));
                                break;
                            case PPAS_VERSION_10:
                                visitors.add(new Oracle2PPASVersion10ASTTransformVisitor(config));
                                break;
                        }
                        break;
                    case PostgreSQL:
                        visitors.add(new OracleSQLRemovePropertyASTVisitor(config));
                        visitors.add(new Oracle2PPASSQLMixRemoveDoubleQuotesASTVisitor(config));
                        switch (targetDBVersion) {
                            case POSTGRESQL_VERSION_9_6:
                                visitors.add(new Oracle2PostgreSQLVersion9_6ASTTransformVisitor(config));
                                break;
                            case POSTGRESQL_VERSION_10:
                                visitors.add(new Oracle2PostgreSQLVersion10ASTTransformVisitor(config));
                                break;
                        }
                        break;
                    case MySQL:
                        visitors.add(new OracleSQLRemovePropertyASTVisitor(config));

                        switch (targetDBVersion) {
                            case MYSQL_VERSION_5_6:
                            case MYSQL_VERSION_5_7:
                                visitors.add(new SQLWithClauseSubQueryTranslateAndRemoveASTVisitor(config));
                                visitors.add(new SQLCreateViewSubQueryTableRefToCreateViewASTVisitor(config));
                                break;
                            default:
                                break;
                        }

                        visitors.add(new SQLOuterJoinToJoinASTVisitor(config));
                        visitors.add(new SQLRowNumToLimitASTVisitor(config));
                        visitors.add(new OracleSQLIntersectOrMinusToJoinASTVisitor(config));
                        visitors.add(new SQLBindVarToVarASTVisitor(config));

                        switch (targetDBVersion) {
                            case MYSQL_VERSION_5_6:
                                visitors.add(new Oracle2MySQLVersion5_6ASTTransformVisitor(config));
                                break;
                            case MYSQL_VERSION_5_7:
                                visitors.add(new Oracle2MySQLVersion5_7ASTTransformVisitor(config));
                                break;
                            case MYSQL_VERSION_8_0:
                                visitors.add(new Oracle2MySQLVersion8_0ASTTransformVisitor(config));
                                break;
                            default:
                                break;
                        }

                        visitors.add(new SQLRenameColumnASTVisitor(config));
                        visitors.add(new SQLRenameObjectNameASTVisitor(config));

                        visitors.add(new SQLDefaultClauseToTriggerAndRemoveASTVisitor(config));

                        if (config.removeSchema) {
                            visitors.add(new SQLRemoveSchemaASTVisitor(config));
                        }

                        visitors.add(new SQLOptimizationASTVisitor(config));
                        visitors.add(new SQLAddReverseQuotesASTVisitor(config));
                        break;
                    case DRDS:
                        visitors.add(new OracleSQLRemovePropertyASTVisitor(config));

                        switch (targetDBVersion) {
                            case DRDS_VERSION_5_6:
                            case DRDS_VERSION_5_7:
                                visitors.add(new SQLWithClauseSubQueryTranslateAndRemoveASTVisitor(config));
                                visitors.add(new SQLCreateViewSubQueryTableRefToCreateViewASTVisitor(config));
                                break;
                            default:
                                break;
                        }

                        visitors.add(new SQLOuterJoinToJoinASTVisitor(config));
                        visitors.add(new SQLRowNumToLimitASTVisitor(config));
                        visitors.add(new OracleSQLIntersectOrMinusToJoinASTVisitor(config));
                        visitors.add(new SQLBindVarToVarASTVisitor(config));

                        switch (targetDBVersion) {
                            case DRDS_VERSION_5_6:
                                visitors.add(new Oracle2DRDSVersion5_6ASTTransformVisitor(config));
                                break;
                            case DRDS_VERSION_5_7:
                                visitors.add(new Oracle2DRDSVersion5_7ASTTransformVisitor(config));
                                break;
                            case DRDS_VERSION_8_0:
                                visitors.add(new Oracle2DRDSVersion8_0ASTTransformVisitor(config));
                                break;
                            default:
                                break;
                        }

                        visitors.add(new SQLRenameColumnASTVisitor(config));
                        visitors.add(new SQLRenameObjectNameASTVisitor(config));

                        visitors.add(new SQLDefaultClauseToTriggerAndRemoveASTVisitor(config));

                        if (config.removeSchema) {
                            visitors.add(new SQLRemoveSchemaASTVisitor(config));
                        }

                        visitors.add(new SQLOptimizationASTVisitor(config));
                        visitors.add(new SQLAddReverseQuotesASTVisitor(config));
                        break;
                    case ADS:
                        visitors.add(new OracleSQLRemovePropertyASTVisitor(config));
//                        visitors.add(new Oracle2ADSASTTransformVisitor(config));

                        if (config.removeSchema) {
                            visitors.add(new SQLRemoveSchemaASTVisitor(config));
                        }

                        break;
                    case SQLServer:
                        visitors.add(new OracleSQLRemovePropertyASTVisitor(config));
                        visitors.add(new Oracle2SQLServerASTTransformVisitor(config));
                        break;
                }
                break;
            case MySQL:
                break;
            case PPAS:
                switch (targetDBType) {
                    case PPAS:
                        break;
                    case Oracle:
//                    visitors.add(new Oracle2ADSASTTransformVisitor(config));
                        break;
                    case PostgreSQL:
//                    visitors.add(new Oracle2ADSASTTransformVisitor(config));
                        break;
                    case MySQL:
//                    visitors.add(new Oracle2ADSASTTransformVisitor(config));
                        break;
                    case DRDS:
//                    visitors.add(new Oracle2ADSASTTransformVisitor(config));
                        break;
                    case ADS:
//                    visitors.add(new Oracle2ADSASTTransformVisitor(config));
                        break;
                }
                break;
            case PostgreSQL:
                switch (targetDBType) {
                    case PostgreSQL:
                        break;
                    case Oracle:
//                    visitors.add(new Oracle2ADSASTTransformVisitor(config));
                        break;
                    case PPAS:
//                    visitors.add(new Oracle2ADSASTTransformVisitor(config));
                        break;
                    case MySQL:
//                    visitors.add(new Oracle2ADSASTTransformVisitor(config));
                        break;
                    case DRDS:
//                    visitors.add(new Oracle2ADSASTTransformVisitor(config));
                        break;
                    case ADS:
//                    visitors.add(new Oracle2ADSASTTransformVisitor(config));
                        break;
                    default:
                        break;
                }
                break;
            case SQLServer:
                switch (targetDBType) {
                    case SQLServer:
                        break;
                    case Oracle:
//                    visitors.add(new Oracle2ADSASTTransformVisitor(config));
                        break;
                    case PPAS:
//                    visitors.add(new Oracle2ADSASTTransformVisitor(config));
                        break;
                    case MySQL:
//                    visitors.add(new Oracle2ADSASTTransformVisitor(config));
                        break;
                    case DRDS:
//                    visitors.add(new Oracle2ADSASTTransformVisitor(config));
                        break;
                    case ADS:
//                    visitors.add(new Oracle2ADSASTTransformVisitor(config));
                        break;
                    default:
                        break;
                }
                break;
        }
        return null;
    }


}
