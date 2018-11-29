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
package com.aliyun.gumiho.sql.basic.ast.element.function.window;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * <window frame units> <window frame extent> [ <window frame exclusion> ]
 *
 * <window frame units>    ::=   ROWS | RANGE
 * <window frame extent> ::=
 * <window frame exclusion>    ::= EXCLUDE CURRENT ROW | EXCLUDE GROUP | EXCLUDE TIES | EXCLUDE NO OTHERS
 *
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#window%20frame%20clause
 * <p>
 * https://dev.mysql.com/doc/refman/8.0/en/window-functions-usage.html
 * <p>
 * windowing_clause : https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Analytic-Functions.html#GUID-527832F7-63C0-4445-8C16-307FA5084056
 *
 * @author kongtong.ouyang on 2018/2/8.
 */
public class SQLWindowFrameClause extends AbstractSQLExpr {

    protected SQLWindowFrameUnit unit;

    protected SQLExpr extent;

    protected SQLReserved exclusion;


    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, extent);
        }
    }


    @Override
    public SQLWindowFrameClause clone() {
        SQLWindowFrameClause x = new SQLWindowFrameClause();

        x.unit = this.unit;

        SQLExpr extentClone = this.extent.clone();
        x.setExtent(extentClone);

        x.exclusion = this.exclusion;

        return x;
    }



    public SQLWindowFrameUnit getUnit() {
        return unit;
    }

    public void setUnit(SQLWindowFrameUnit unit) {
        this.unit = unit;
    }

    public SQLExpr getExtent() {
        return extent;
    }

    public void setExtent(SQLExpr extent) {
        this.extent = extent;
    }

    public SQLReserved getExclusion() {
        return exclusion;
    }

    public void setExclusion(SQLReserved exclusion) {
        this.exclusion = exclusion;
    }


    public enum SQLWindowFrameUnit {

        ROWS(SQLReserved.ROWS),

        RANGE(SQLReserved.RANGE);

        public final SQLReserved name;

        private SQLWindowFrameUnit(SQLReserved name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name.upper;
        }
    }


    public static class SQLWindowFrameBetween extends AbstractSQLExpr {

        protected SQLExpr between;

        protected SQLExpr and;

        public SQLWindowFrameBetween(SQLExpr between, SQLExpr and) {
            setBetween(between);
            setAnd(and);
        }

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, between);
                this.acceptChild(visitor, and);
            }
        }

        public SQLExpr getBetween() {
            return between;
        }

        public void setBetween(SQLExpr between) {
            setChildParent(between);
            this.between = between;
        }

        public SQLExpr getAnd() {
            return and;
        }

        public void setAnd(SQLExpr and) {
            setChildParent(and);
            this.and = and;
        }
    }


    /**
     * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#window%20frame%20preceding
     * <p>
     * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Analytic-Functions.html#GUID-527832F7-63C0-4445-8C16-307FA5084056
     */
    public static class SQLWindowFramePreceding extends AbstractSQLExpr {

        protected SQLExpr value;

        public SQLWindowFramePreceding(SQLExpr value) {
            setValue(value);
        }

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, value);
            }
        }

        public SQLExpr getValue() {
            return value;
        }

        public void setValue(SQLExpr value) {
            setChildParent(value);
            this.value = value;
        }
    }

    /**
     * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#window%20frame%20following
     * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Analytic-Functions.html#GUID-527832F7-63C0-4445-8C16-307FA5084056
     */
    public static class SQLWindowFrameFollowing extends AbstractSQLExpr {

        protected SQLExpr value;

        public SQLWindowFrameFollowing(SQLExpr value) {
            setValue(value);
        }

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, value);
            }
        }

        public SQLExpr getValue() {
            return value;
        }

        public void setValue(SQLExpr value) {
            setChildParent(value);
            this.value = value;
        }
    }
}
