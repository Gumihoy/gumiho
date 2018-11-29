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
package com.aliyun.gumiho.sql.basic.ast.element.function.json;

import com.aliyun.gumiho.sql.basic.ast.element.datatype.SQLDataType;
import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.function.AbstractSQLFunction;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * ( expr [ FORMAT JSON ] [, expr [ FORMAT JSON ] ]...
 * [ JSON_on_null_clause ] [ JSON_returning_clause ]
 * [STRICT] [WITH UNIQUE KEYS]
 * [ JSON_query_wrapper_clause ] [ JSON_query_on_error_clause ]
 * [ JSON_query_on_empty_clause ] [JSON_columns_clause])
 * <p>
 * onNullClause: { NULL | ABSENT } ON NULL
 * wrapperClause: {WITHOUT [ ARRAY ] WRAPPER | WITH [ UNCONDITIONAL | CONDITIONAL ] [ ARRAY ] WRAPPER}
 * onErrorClause: { ERROR | NULL | DEFAULT literal } ON ERROR
 * onEmptyClause: { ERROR | NULL | DEFAULT literal } ON EMPTY
 * JSON_columns_clause: COLUMNS ( JSON_column_definition [, JSON_column_definition ]... )
 * <p>
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Single-Row-Functions.html#GUID-C13171B3-C070-4137-AC71-7A30BD26F380
 *
 * @author kongtong.ouyang onCondition 2018/3/20.
 */
public abstract class AbstractSQLJsonFunction extends AbstractSQLFunction implements ISQLJsonFunction {

    protected SQLReserved onNullClause;
    protected SQLJsonReturningClause returningClause;
    protected SQLReserved wrapperClause;
    protected boolean strict;
    protected boolean withUniqueKeys;
    protected SQLExpr onErrorClause;
    protected SQLExpr onEmptyClause;
    protected SQLJsonColumnsClause jsonColumnsClause;


    public AbstractSQLJsonFunction(String name) {
        super(name);
    }

    public AbstractSQLJsonFunction(SQLExpr name) {
        super(name);
    }

    @Override
    public AbstractSQLJsonFunction clone() {
        throw new UnsupportedOperationException(getClass().getName());
    }

    public void cloneTo(AbstractSQLJsonFunction x) {
        super.cloneTo(x);
    }


    public SQLReserved getOnNullClause() {
        return onNullClause;
    }

    public void setOnNullClause(SQLReserved onNullClause) {
        this.onNullClause = onNullClause;
    }

    public SQLJsonReturningClause getReturningClause() {
        return returningClause;
    }

    public void setReturningClause(SQLJsonReturningClause returningClause) {
        setChildParent(returningClause);
        this.returningClause = returningClause;
    }

    public SQLReserved getWrapperClause() {
        return wrapperClause;
    }

    public void setWrapperClause(SQLReserved wrapperClause) {
        this.wrapperClause = wrapperClause;
    }

    public boolean isStrict() {
        return strict;
    }

    public void setStrict(boolean strict) {
        this.strict = strict;
    }

    public boolean isWithUniqueKeys() {
        return withUniqueKeys;
    }

    public void setWithUniqueKeys(boolean withUniqueKeys) {
        this.withUniqueKeys = withUniqueKeys;
    }

    public SQLExpr getOnErrorClause() {
        return onErrorClause;
    }

    public void setOnErrorClause(SQLExpr onErrorClause) {
        setChildParent(onErrorClause);
        this.onErrorClause = onErrorClause;
    }

    public SQLExpr getOnEmptyClause() {
        return onEmptyClause;
    }

    public void setOnEmptyClause(SQLExpr onEmptyClause) {
        setChildParent(onEmptyClause);
        this.onEmptyClause = onEmptyClause;
    }

    public SQLJsonColumnsClause getJsonColumnsClause() {
        return jsonColumnsClause;
    }

    public void setJsonColumnsClause(SQLJsonColumnsClause jsonColumnsClause) {
        setChildParent(jsonColumnsClause);
        this.jsonColumnsClause = jsonColumnsClause;
    }

    /**
     * [ KEY ] string VALUE expr
     * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/img_text/json_object.html
     */
    public static class SQLKeyValueArgumentExpr extends AbstractSQLExpr {

        protected boolean key;
        protected SQLExpr keyExpr;
        protected SQLExpr valueExpr;

        public SQLKeyValueArgumentExpr() {
        }

        public SQLKeyValueArgumentExpr(boolean key, SQLExpr keyExpr, SQLExpr valueExpr) {
            this.key = key;
            setKeyExpr(keyExpr);
            setValueExpr(valueExpr);
        }

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, keyExpr);
                this.acceptChild(visitor, valueExpr);
            }
        }

        public boolean isKey() {
            return key;
        }

        public void setKey(boolean key) {
            this.key = key;
        }

        public SQLExpr getKeyExpr() {
            return keyExpr;
        }

        public void setKeyExpr(SQLExpr keyExpr) {
            setChildParent(keyExpr);
            this.keyExpr = keyExpr;
        }

        public SQLExpr getValueExpr() {
            return valueExpr;
        }

        public void setValueExpr(SQLExpr valueExpr) {
            setChildParent(valueExpr);
            this.valueExpr = valueExpr;
        }
    }

    /**
     * expr FORMAT JSON
     * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/img_text/json_array.html
     */
    public static class SQLFormatJsonArgumentExpr extends AbstractSQLExpr {

        protected SQLExpr expr;

        public SQLFormatJsonArgumentExpr() {
        }

        public SQLFormatJsonArgumentExpr(SQLExpr expr) {
            setExpr(expr);
        }

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, expr);
            }
        }

        public SQLExpr getExpr() {
            return expr;
        }

        public void setExpr(SQLExpr expr) {
            setChildParent(expr);
            this.expr = expr;
        }
    }


    /**
     * [ RETURNING JSON_query_return_type ] [ PRETTY ] [ ASCII ]
     * <p>
     * JSON_returning_clause: https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/JSON_QUERY.html#GUID-6D396EC4-D2AA-43D2-8F5D-08D646A4A2D9
     *
     * @author kongtong.ouyang on 2018/5/24.
     */
    public static class SQLJsonReturningClause extends AbstractSQLExpr {

        protected SQLDataType returnType;
        protected boolean pretty;
        protected boolean ascii;

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, returnType);
            }
        }

        public SQLDataType getReturnType() {
            return returnType;
        }

        public void setReturnType(SQLDataType returnType) {
            setChildParent(returnType);
            this.returnType = returnType;
        }

        public boolean isPretty() {
            return pretty;
        }

        public void setPretty(boolean pretty) {
            this.pretty = pretty;
        }

        public boolean isAscii() {
            return ascii;
        }

        public void setAscii(boolean ascii) {
            this.ascii = ascii;
        }
    }

    /**
     * DEFAULT literal ON ERROR
     */
    public static class SQLDefaultOnErrorExpr extends AbstractSQLExpr {
        protected SQLExpr literal;

        public SQLDefaultOnErrorExpr(SQLExpr literal) {
            setLiteral(literal);
        }

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, literal);
            }
        }

        public SQLExpr getLiteral() {
            return literal;
        }

        public void setLiteral(SQLExpr literal) {
            setChildParent(literal);
            this.literal = literal;
        }
    }

    /**
     * DEFAULT literal ON EMPTY
     */
    public static class SQLDefaultOnEmptyExpr extends AbstractSQLExpr {
        protected SQLExpr literal;

        public SQLDefaultOnEmptyExpr(SQLExpr literal) {
            setLiteral(literal);
        }

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, literal);
            }
        }

        public SQLExpr getLiteral() {
            return literal;
        }

        public void setLiteral(SQLExpr literal) {
            setChildParent(literal);
            this.literal = literal;
        }
    }

    /**
     * COLUMNS ( JSON_column_definition [, JSON_column_definition ]... )
     */
    public static class SQLJsonColumnsClause extends AbstractSQLExpr {
        protected final List<SQLExpr> columns = new ArrayList<>();

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, columns);
            }
        }

        public List<SQLExpr> getColumns() {
            return columns;
        }

        public void addColumn(SQLExpr column) {
            if (column == null) {
                return;
            }
            setChildParent(column);
            this.columns.add(column);
        }
    }


    /**
     * column_name JSON_value_return_type EXISTS [PATH JSON_basic_path_expression] [ JSON_exists_on_error_clause ]
     */
    public static class SQLJsonExistsColumn extends AbstractSQLExpr {
        protected SQLName column;
        protected SQLDataType dataType;
        protected SQLExpr pathExpr;
        protected SQLExpr onErrorClause;

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, column);
                this.acceptChild(visitor, dataType);
                this.acceptChild(visitor, pathExpr);
                this.acceptChild(visitor, onErrorClause);
            }
        }

        public SQLName getColumn() {
            return column;
        }

        public void setColumn(SQLName column) {
            setChildParent(column);
            this.column = column;
        }

        public SQLDataType getDataType() {
            return dataType;
        }

        public void setDataType(SQLDataType dataType) {
            setChildParent(dataType);
            this.dataType = dataType;
        }

        public SQLExpr getPathExpr() {
            return pathExpr;
        }

        public void setPathExpr(SQLExpr pathExpr) {
            setChildParent(pathExpr);
            this.pathExpr = pathExpr;
        }

        public SQLExpr getOnErrorClause() {
            return onErrorClause;
        }

        public void setOnErrorClause(SQLExpr onErrorClause) {
            setChildParent(onErrorClause);
            this.onErrorClause = onErrorClause;
        }
    }

    /**
     * column_name JSON_query_return_type FORMAT JSON [ JSON_query_wrapper_clause ] [PATH JSON_basic_path_expression] [ JSON_query_on_error_clause ]
     */
    public static class SQLJsonQueryColumn extends AbstractSQLExpr {
        protected SQLName column;
        protected SQLDataType dataType;
        protected SQLReserved wrapperClause;
        protected SQLExpr pathExpr;
        protected SQLExpr onErrorClause;

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, column);
                this.acceptChild(visitor, dataType);
                this.acceptChild(visitor, pathExpr);
                this.acceptChild(visitor, onErrorClause);
            }
        }

        public SQLName getColumn() {
            return column;
        }

        public void setColumn(SQLName column) {
            setChildParent(column);
            this.column = column;
        }

        public SQLDataType getDataType() {
            return dataType;
        }

        public void setDataType(SQLDataType dataType) {
            setChildParent(dataType);
            this.dataType = dataType;
        }

        public SQLReserved getWrapperClause() {
            return wrapperClause;
        }

        public void setWrapperClause(SQLReserved wrapperClause) {
            this.wrapperClause = wrapperClause;
        }

        public SQLExpr getPathExpr() {
            return pathExpr;
        }

        public void setPathExpr(SQLExpr pathExpr) {
            setChildParent(pathExpr);
            this.pathExpr = pathExpr;
        }

        public SQLExpr getOnErrorClause() {
            return onErrorClause;
        }

        public void setOnErrorClause(SQLExpr onErrorClause) {
            setChildParent(onErrorClause);
            this.onErrorClause = onErrorClause;
        }
    }

    /**
     * column_name JSON_value_return_type [PATH JSON_basic_path_expression] [ JSON_value_on_error_clause ]
     */
    public static class SQLJsonValueColumn extends AbstractSQLExpr {
        protected SQLName column;
        protected SQLDataType dataType;
        protected SQLExpr pathExpr;
        protected SQLExpr onErrorClause;

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, column);
                this.acceptChild(visitor, dataType);
                this.acceptChild(visitor, pathExpr);
                this.acceptChild(visitor, onErrorClause);
            }
        }

        public SQLName getColumn() {
            return column;
        }

        public void setColumn(SQLName column) {
            setChildParent(column);
            this.column = column;
        }

        public SQLDataType getDataType() {
            return dataType;
        }

        public void setDataType(SQLDataType dataType) {
            setChildParent(dataType);
            this.dataType = dataType;
        }

        public SQLExpr getPathExpr() {
            return pathExpr;
        }

        public void setPathExpr(SQLExpr pathExpr) {
            setChildParent(pathExpr);
            this.pathExpr = pathExpr;
        }

        public SQLExpr getOnErrorClause() {
            return onErrorClause;
        }

        public void setOnErrorClause(SQLExpr onErrorClause) {
            setChildParent(onErrorClause);
            this.onErrorClause = onErrorClause;
        }
    }

    /**
     * NESTED [PATH] JSON_basic_path_expression JSON_columns_clause
     */
    public static class SQLJsonNestedPathColumn extends AbstractSQLExpr {
        protected boolean path;
        protected SQLExpr pathExpr;
        protected SQLJsonColumnsClause jsonColumnsClause;

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, pathExpr);
                this.acceptChild(visitor, jsonColumnsClause);
            }
        }

        public boolean isPath() {
            return path;
        }

        public void setPath(boolean path) {
            this.path = path;
        }

        public SQLExpr getPathExpr() {
            return pathExpr;
        }

        public void setPathExpr(SQLExpr pathExpr) {
            setChildParent(pathExpr);
            this.pathExpr = pathExpr;
        }

        public SQLJsonColumnsClause getJsonColumnsClause() {
            return jsonColumnsClause;
        }

        public void setJsonColumnsClause(SQLJsonColumnsClause jsonColumnsClause) {
            setChildParent(jsonColumnsClause);
            this.jsonColumnsClause = jsonColumnsClause;
        }
    }

    /**
     * column_name FOR ORDINALITY
     */
    public static class SQLJsonOrdinalityColumn extends AbstractSQLExpr {
        protected SQLName column;

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, column);
            }
        }

        public SQLName getColumn() {
            return column;
        }

        public void setColumn(SQLName column) {
            setChildParent(column);
            this.column = column;
        }
    }
}
