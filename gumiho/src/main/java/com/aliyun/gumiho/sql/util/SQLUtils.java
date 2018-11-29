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
import com.aliyun.gumiho.sql.basic.ast.SQLReplaceable;
import com.aliyun.gumiho.sql.basic.ast.element.datatype.SQLDataType;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.SQLSelectItem;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.SQLSelectQuery;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.SQLSubQueryTableReference;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.*;
import com.aliyun.gumiho.sql.basic.ast.element.pseudocolumn.SQLRowNumExpr;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.table.SQLCreateTableStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTOutputVisitor;
import com.aliyun.gumiho.sql.config.SQLOutputConfig;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTOutputVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.exception.SQLParserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author kongtong.ouyang onCondition 2018/1/18.
 */
public class SQLUtils {

    protected final static Logger log = LoggerFactory.getLogger(SQLUtils.class);

    public static SQLExpr toSQLExpr(String sql, DBType dbType) {
        try {
            return SQLParserUtils.toSQLExpr(sql, dbType);
        } catch (Exception e) {
            log.warn("to SQLExpr exception. sql: {}", sql, e);
            throw e;
        }
    }

    public static SQLDataType toSQLDataType(String sql, DBType dbType) {
        try {
            return SQLParserUtils.toSQLDataType(sql, dbType);
        } catch (Exception e) {
            log.warn("to SQLDataType exception. sql: {}", sql, e);
            throw e;
        }
    }

    public static String format(String sql, DBType dbType) {
        try {
            List<SQLObject> statements = SQLParserUtils.parse(sql, dbType);
            return toSQLString(statements, dbType);
        } catch (SQLParserException e) {
            log.warn("format exception. sql: {}", sql, e);
            throw e;
        }
    }

    public static String toSQLString(SQLObject sqlObject, DBType dbType) {
        if (sqlObject == null) {
            throw new IllegalArgumentException("sqlObject is null.");
        }

        StringBuilder out = new StringBuilder();
        SQLASTOutputVisitor visitor = createASTOutputVisitor(out, dbType);
        sqlObject.accept(visitor);

        return out.toString();
    }

    public static String toSQLString(List<SQLObject> sqlObjects, DBType dbType) {
        StringBuilder out = new StringBuilder();

        SQLASTOutputVisitor visitor = createASTOutputVisitor(out, dbType);
        outputVisitor(sqlObjects, visitor);

        return out.toString();
    }

    public static void outputVisitor(SQLObject sqlObject, SQLASTOutputVisitor visitor) {
        sqlObject.accept(visitor);
    }

    public static void outputVisitor(List<SQLObject> sqlObjects, SQLASTOutputVisitor visitor) {
        for (int i = 0; i < sqlObjects.size(); i++) {
            SQLObject stmt = sqlObjects.get(i);
            if (i > 0) {
                SQLObject preStmt = sqlObjects.get(i - 1);
                if (!preStmt.isAfterSemi()) {
                    visitor.print(";");
                }
                visitor.println();
            }
            stmt.accept(visitor);
        }
    }


    public static SQLASTOutputVisitor createASTOutputVisitor(StringBuilder out, DBType dbType) {
        if (dbType == null) {
            dbType = DBType.SQL;
        }
        switch (dbType) {
            case Oracle:
                return new OracleSQLASTOutputVisitor(out);
            case PPAS:
//                return new PPASSQLASTOutputVisitor(out);
//            case PostgreSQL:
//                return new PostgreSQLSQLASTOutputVisitor(out);
//            case MySQL:
//                return new MySQLSQLASTOutputVisitor(out);
//            case DRDS:
//                return new DRDSSQLASTOutputVisitor(out);
            default:
                return new SQLASTOutputVisitor(out);
        }
    }

    public static SQLASTOutputVisitor createASTOutputVisitor(StringBuilder out, DBType source, DBType target) {
        return createASTOutputVisitor(out, new SQLOutputConfig(), source, target);
    }

    public static SQLASTOutputVisitor createASTOutputVisitor(StringBuilder out, SQLOutputConfig config, DBType source, DBType target) {
        if (source == null) {
            source = DBType.SQL;
        }
        if (target == null) {
            target = source;
        }
        switch (source) {
            case Oracle:
                switch (target) {
                    case MySQL:
//                        return new Oracle2MySQLASTOutputVisitor(out, config);
//                    case DRDS:
//                        return new Oracle2DRDSASTOutputVisitor(out, config);
//                    case MariaDB:
//                        return new Oracle2MariaDBASTOutputVisitor(out, config);
//                    case ADS:
//                        return new Oracle2ADSASTOutputVisitor(out, config);
//                    case PPAS:
//                        return new Oracle2PPASASTOutputVisitor(out, config);
//                    case PostgreSQL:
//                        return new Oracle2PostgreSQLASTOutputVisitor(out, config);
//                    case SQLServer:
//                        return new Oracle2SQLServerASTOutputVisitor(out, config);
                    default:
                        return new OracleSQLASTOutputVisitor(out);
                }
            case MySQL:
                switch (target) {
                    case Oracle:
//                        return new MySQL2OracleASTOutputVisitor(out, config);
//                    default:
//                        return new MySQLSQLASTOutputVisitor(out);
                }
            case DRDS:
                switch (target) {
                    default:
//                        return new DRDSSQLASTOutputVisitor(out);
                }
            case MariaDB:
                switch (target) {
                    default:
//                        return new MariaDBSQLASTOutputVisitor(out);
                }
            case PPAS:
                switch (target) {
                    default:
//                        return new PPASSQLASTOutputVisitor(out);
                }
            case PostgreSQL:
                switch (target) {
                    default:
//                        return new PostgreSQLSQLASTOutputVisitor(out);
                }
            case SQLServer:
                switch (target) {
                    default:
//                        return new SQLServerSQLASTOutputVisitor(out);
                }
            default:
                return new SQLASTOutputVisitor(out);
        }
    }

    /**
     * 判断是否是数字开头
     *
     * @return true: 数字开头, false: 不是数字开头
     */
    public static boolean isStartWithNumber(String text) {
        if (text == null
                || text.length() == 0) {
            return false;
        }
        char c = text.charAt(0);
        if (c >= '0'
                && c <= '9') {
            return true;
        }
        return false;
    }

    private static final String[] SPECIAL_CHARACTER = new String[]{"<", ">", "（", "）", "(", ")", "{", "}", "[", "]", "!", "@", "%", "^", "&", "*", "/", "\\", "+", "-", "|", ":", "'", "=", " ", ";", ".", "\"", "?", "~"};

    /**
     * 判断是否是包含特殊字符
     *
     * @return true: 数字开头, false: 不是数字开头
     */
    public static boolean containsSpecialCharacter(String text) {
        if (text == null
                || text.length() == 0) {
            return false;
        }
        for (String src : SPECIAL_CHARACTER) {
            boolean contains = text.contains(src);
            if (contains) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断是否有小写字母
     */
    public static boolean hasLowerLetter(String text) {
        if (text == null
                || text.length() == 0) {
            return false;
        }
        for (char c : text.toCharArray()) {
            if (c >= 'a'
                    && c <= 'z') {
                return true;
            }
        }
        return false;
    }


    public static boolean hasDoubleQuote(String text) {
        if (text == null || text.length() == 0) {
            return false;
        }

        char c1 = text.charAt(0);
        char c2 = text.charAt(text.length() - 1);

        return c1 == '"' && c2 == '"';
    }

    public static boolean hasReverseQuote(String text) {
        if (text == null || text.length() == 0) {
            return false;
        }

        char c1 = text.charAt(0);
        char c2 = text.charAt(text.length() - 1);

        return c1 == '`' && c2 == '`';
    }

    public static boolean hasSingeQuote(String text) {
        if (text == null || text.length() == 0) {
            return false;
        }

        char c1 = text.charAt(0);
        char c2 = text.charAt(text.length() - 1);

        return c1 == '\'' && c2 == '\'';
    }

    /**
     * remove double quote
     *
     * @param text "xxx"
     * @return xxx
     */
    public static String removeDoubleQuote(String text) {
        if (text == null || text.length() == 0) {
            return text;
        }

        char c1 = text.charAt(0);
        char c2 = text.charAt(text.length() - 1);

        return (c1 == '"' && c2 == '"') ? text.substring(1, text.length() - 1) : text;
    }

    /**
     * remove Single Quote
     *
     * @param text 'xx'
     * @return xx
     */
    public static String removeSingleQuote(String text) {
        if (text == null || text.length() == 0) {
            return text;
        }

        char c1 = text.charAt(0);
        char c2 = text.charAt(text.length() - 1);

        return (c1 == '\'' && c2 == '\'') ? text.substring(1, text.length() - 1) : text;
    }

    /**
     * remove Reverse Quote
     *
     * @param text `xx`
     * @return xx
     */
    public static String removeReverseQuote(String text) {
        if (text == null || text.length() == 0) {
            return text;
        }

        char c1 = text.charAt(0);
        char c2 = text.charAt(text.length() - 1);

        return (c1 == '`' && c2 == '`') ? text.substring(1, text.length() - 1) : text;
    }


    public static String removeQuote(String text) {
        if (text == null
                || text.length() < 2) {
            return text;
        }

        text = removeDoubleQuote(text);
        text = removeReverseQuote(text);
        text = removeSingleQuote(text);
        return text;
    }

    public static boolean nameEquals(SQLName a, SQLName b, boolean full) {
        if (a == b) {
            return true;
        }

        if (a == null || b == null) {
            return false;
        }

        if (full) {
            return a.fullNameHash() == b.fullNameHash();
        } else {
            return a.hash() == b.hash();
        }
    }


    public static boolean nameEqualsIgnoreCase(SQLName a, SQLName b) {
        if (a == b) {
            return true;
        }

        if (a == null || b == null) {
            return false;
        }

        if (a instanceof SQLPropertyExpr
                && b instanceof SQLPropertyExpr) {
            return a.fullNameLowerHash() == b.fullNameLowerHash();
        } else {
            return a.lowerHash() == b.lowerHash();
        }
    }

    public static boolean nameEqualsIgnoreCase(SQLName a, SQLName b, boolean full) {
        if (a == b) {
            return true;
        }

        if (a == null || b == null) {
            return false;
        }

        if (full) {
            return a.fullNameLowerHash() == b.fullNameLowerHash();
        } else {
            return a.lowerHash() == b.lowerHash();
        }
    }


    public static boolean equals(SQLExpr a, SQLExpr b, boolean full) {
        if (a == b) {
            return true;
        }

        if (a == null || b == null) {
            return false;
        }

        if (a instanceof SQLName
                && b instanceof SQLName) {
            if (full) {
                return ((SQLName) a).fullNameHash() == ((SQLName) b).fullNameHash();
            } else {
                return ((SQLName) a).hash() == ((SQLName) b).hash();
            }
        }

        return a.equals(b);
    }

    public static boolean equalsIgnoreCase(SQLExpr a, SQLExpr b, boolean full) {

        if (a == b) {
            return true;
        }

        if (a == null || b == null) {
            return false;
        }


        if (a instanceof SQLName
                && b instanceof SQLName) {
            if (full) {
                return ((SQLName) a).fullNameLowerHash() == ((SQLName) b).fullNameLowerHash();
            } else {
                return ((SQLName) a).lowerHash() == ((SQLName) b).lowerHash();
            }
        }

        return a.equals(b);
    }


    public static SQLIdentifier ofName(String name) {

        boolean hasDoubleQuote = SQLUtils.hasDoubleQuote(name);
        if (hasDoubleQuote) {
            return new SQLDoubleQuoteIdentifier(name);
        }

        boolean hasReverseQuote = SQLUtils.hasReverseQuote(name);
        if (hasReverseQuote) {
            return new SQLReverseQuoteIdentifier(name);
        }

        return new SQLIdentifierImpl(name);
    }


    /**
     * target replace source
     *
     * @return true replace succ , false not replace
     */
    public static boolean replaceInParent(SQLExpr source, SQLExpr target) {
        if (source == null) {
            return false;
        }

        SQLObject parent = source.getParent();
        if (parent instanceof SQLReplaceable) {
            return ((SQLReplaceable) parent).replace(source, target);
        }
        return false;
    }

    public static boolean isRowNum(SQLExpr x, SQLSelectQuery query) {
        if (x instanceof SQLRowNumExpr) {
            return true;
        }

        if (x instanceof SQLName) {
            long nameLowerHash = ((SQLName) x).lowerHash();
            return isRowNum(nameLowerHash, query);
        }

        return false;
    }

    private static boolean isRowNum(long nameHash, SQLSelectQuery query) {
        if (query == null) {
            return false;
        }

        SQLSelectItem item = query.findSelectItem(nameHash);
        if (query.getFromClause() != null
                && query.getFromClause().getTableReference() instanceof SQLSubQueryTableReference
                && ((SQLSubQueryTableReference) query.getFromClause().getTableReference()).getSubQuery() instanceof SQLSelectQuery) {
            query = (SQLSelectQuery) ((SQLSubQueryTableReference) query.getFromClause().getTableReference()).getSubQuery();
        } else {
            query = null;
        }

        if (item == null
                && isRowNum(nameHash, query)) {
            return true;
        }
        if (item != null
                && isRowNum(item.getExpr(), query)) {
            return true;
        }

        return false;
    }

    public static void sortSQL(String sql, DBType dbType) {
        if (sql == null
                || sql.length() == 0) {
            return;
        }

        List<SQLObject> stmtList = SQLParserUtils.parse(sql, dbType);
        sort(stmtList);
    }

    public static void sortSQL(List<String> sqlList, DBType dbType) {
        if (sqlList == null
                || sqlList.size() == 0) {
            return;
        }
        List<SQLObject> stmtList = new ArrayList<>();
        for (String sql : sqlList) {
            stmtList.addAll(SQLParserUtils.parse(sql, dbType));
        }

        sort(stmtList);
    }


    /**
     * Create Type
     * Alter Type
     * Create Table
     * Synonym
     * Comment On Table
     * Comment On Column
     * ALTER Table
     * Drop Table
     * Drop Type
     * Create View
     * Alter View
     * Drop View
     * Create Index
     * Alter Index
     * Drop Index
     * Create Package
     * Alter Package
     * Drop Package
     * INSERT/SELECT/UPDATE/DELETE
     */
    public static void sort(List<SQLObject> objectList) {
        if (objectList == null
                || objectList.size() == 0) {
            return;
        }

//        SQLDAG dag = SQLDAG.of(objectList);
//        dag.buildG();
//        dag.topologicalSort();

//        SQLDAG dag = new SQLDAG(objectList.toArray());

        List<SQLExpr> exprs = new ArrayList<>();
        Map<String, SQLCreateTableStatement> createTables = new HashMap<>();
        Map<String, List<SQLCreateTableStatement>> referencedCreateTables = new HashMap<>();

        Map<String, SQLCreateTableStatement> dropTables = new HashMap<>();
        Map<String, List<SQLCreateTableStatement>> referencedDropTables = new HashMap<>();

        for (int i = 0; i < objectList.size(); i++) {
            SQLObject object = objectList.get(i);
            if (object instanceof SQLExpr) {
                continue;
            }

            if (object instanceof SQLCreateTableStatement) {

            }
        }


    }


}
