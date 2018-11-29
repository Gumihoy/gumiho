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
package com.aliyun.gumiho.sql.dialect.postgresql.ast.element.expr;


import com.aliyun.gumiho.sql.basic.ast.element.datatype.SQLDataType;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.dialect.postgresql.visitor.PostgreSQLSQLASTVisitor;

/**
 * CAST ( expr AS type )
 * expr::type
 * <p>
 * https://www.postgresql.org/docs/devel/static/sql-expressions.html
 */
public class PostgreSQLSQLTypeCastExpr extends AbstractPostgreSQLSQLExpr {

    protected SQLExpr expr;

    protected SQLDataType dataType;


    @Override
    public void accept0(PostgreSQLSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, expr);
            this.acceptChild(visitor, dataType);
        }
    }


    @Override
    public PostgreSQLSQLTypeCastExpr clone() {
        PostgreSQLSQLTypeCastExpr x = new PostgreSQLSQLTypeCastExpr();

        SQLExpr exprClone = expr.clone();
        x.setExpr(exprClone);

        SQLDataType dataTypeClone = dataType.clone();
        x.setDataType(dataTypeClone);

        return x;
    }

    public SQLExpr getExpr() {
        return expr;
    }

    public void setExpr(SQLExpr expr) {
        setChildParent(dataType);
        this.expr = expr;
    }

    public SQLDataType getDataType() {
        return dataType;
    }

    public void setDataType(SQLDataType dataType) {
        setChildParent(dataType);
        this.dataType = dataType;
    }
}
