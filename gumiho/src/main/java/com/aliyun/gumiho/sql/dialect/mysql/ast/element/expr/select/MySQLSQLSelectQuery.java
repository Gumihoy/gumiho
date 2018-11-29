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
package com.aliyun.gumiho.sql.dialect.mysql.ast.element.expr.select;

import com.aliyun.gumiho.sql.basic.ast.SQLObject;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLCharacterSetOptionExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.SQLSelectQuery;
import com.aliyun.gumiho.sql.basic.ast.element.literal.text.SQLCharLiteral;
import com.aliyun.gumiho.sql.basic.ast.enums.ISQLEnum;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.dialect.mysql.ast.MySQLSQLObject;
import com.aliyun.gumiho.sql.dialect.mysql.ast.element.expr.AbstractMySQLSQLExpr;
import com.aliyun.gumiho.sql.dialect.mysql.ast.element.expr.MySQLSQLExpr;
import com.aliyun.gumiho.sql.dialect.mysql.visitor.MySQLSQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * https://dev.mysql.com/doc/refman/8.0/en/select.html
 *
 * @author kongtong.ouyang onCondition 2018/3/21.
 */
public class MySQLSQLSelectQuery extends SQLSelectQuery implements MySQLSQLObject {

    protected boolean highPriority;
    protected boolean straightJoin;
    protected boolean smallResult;
    protected boolean bigResult;
    protected boolean bufferResult;
    protected SQLCache cache;
    protected boolean calcFoundRows;

    protected IMySQLSQLIntoClause intoClause;



    public MySQLSQLSelectQuery() {
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor instanceof MySQLSQLASTVisitor) {
            accept0((MySQLSQLASTVisitor) visitor);
        } else {
            super.accept0(visitor);
        }
    }

    @Override
    public void accept0(MySQLSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, selectItems);
            this.acceptChild(visitor, fromClause);
            this.acceptChild(visitor, whereClause);
            this.acceptChild(visitor, groupByClause);
            this.acceptChild(visitor, orderByClause);
            this.acceptChild(visitor, limitClause);
            this.acceptChild(visitor, lockClause);
        }
    }


    public boolean isHighPriority() {
        return highPriority;
    }

    public void setHighPriority(boolean highPriority) {
        this.highPriority = highPriority;
    }

    public boolean isStraightJoin() {
        return straightJoin;
    }

    public void setStraightJoin(boolean straightJoin) {
        this.straightJoin = straightJoin;
    }

    public boolean isSmallResult() {
        return smallResult;
    }

    public void setSmallResult(boolean smallResult) {
        this.smallResult = smallResult;
    }

    public boolean isBigResult() {
        return bigResult;
    }

    public void setBigResult(boolean bigResult) {
        this.bigResult = bigResult;
    }

    public boolean isBufferResult() {
        return bufferResult;
    }

    public void setBufferResult(boolean bufferResult) {
        this.bufferResult = bufferResult;
    }

    public SQLCache getCache() {
        return cache;
    }

    public void setCache(SQLCache cache) {
        this.cache = cache;
    }

    public boolean isCalcFoundRows() {
        return calcFoundRows;
    }

    public void setCalcFoundRows(boolean calcFoundRows) {
        this.calcFoundRows = calcFoundRows;
    }

    public IMySQLSQLIntoClause getIntoClause() {
        return intoClause;
    }

    public void setIntoClause(IMySQLSQLIntoClause intoClause) {
        this.intoClause = intoClause;
    }


    public interface IMySQLSQLIntoClause extends MySQLSQLExpr {
        @Override
        IMySQLSQLIntoClause clone();
    }

    public class MySQLSQLIntoClause extends AbstractMySQLSQLExpr implements IMySQLSQLIntoClause {

        protected final List<SQLExpr> names = new ArrayList<>();

        @Override
        public void accept0(MySQLSQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, names);
            }
        }

        @Override
        public MySQLSQLIntoOutFileClause clone() {
            MySQLSQLIntoOutFileClause x = new MySQLSQLIntoOutFileClause();
            return x;
        }

        @Override
        public void cloneTo(SQLObject x) {
            super.cloneTo(x);
        }
    }

    public class MySQLSQLIntoOutFileClause extends AbstractMySQLSQLExpr implements IMySQLSQLIntoClause {

        protected SQLCharLiteral name;
        protected SQLCharacterSetOptionExpr characterSetExpr;
        protected SQLExpr option;

        @Override
        public void accept0(MySQLSQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, name);
                this.acceptChild(visitor, characterSetExpr);
                this.acceptChild(visitor, option);
            }
        }

        @Override
        public MySQLSQLIntoOutFileClause clone() {
            MySQLSQLIntoOutFileClause x = new MySQLSQLIntoOutFileClause();
            return x;
        }

        @Override
        public void cloneTo(SQLObject x) {
            super.cloneTo(x);
        }

        public SQLCharLiteral getName() {
            return name;
        }

        public void setName(SQLCharLiteral name) {
            this.name = name;
        }

        public SQLCharacterSetOptionExpr getCharacterSetExpr() {
            return characterSetExpr;
        }

        public void setCharacterSetExpr(SQLCharacterSetOptionExpr characterSetExpr) {
            this.characterSetExpr = characterSetExpr;
        }

        public SQLExpr getOption() {
            return option;
        }

        public void setOption(SQLExpr option) {
            this.option = option;
        }
    }


    public class MySQLSQLIntoDumpFileClause extends AbstractMySQLSQLExpr implements IMySQLSQLIntoClause {
        protected SQLCharLiteral name;

        @Override
        public void accept0(MySQLSQLASTVisitor visitor) {

        }

        @Override
        public MySQLSQLIntoOutFileClause clone() {
            MySQLSQLIntoOutFileClause x = new MySQLSQLIntoOutFileClause();
            return x;
        }

        @Override
        public void cloneTo(SQLObject x) {
            super.cloneTo(x);
        }

        public SQLCharLiteral getName() {
            return name;
        }

        public void setName(SQLCharLiteral name) {
            this.name = name;
        }
    }


    /**
     * SQL_CACHE | SQL_NO_CACHE
     */
    public enum SQLCache implements ISQLEnum {
        SQL_CACHE(SQLReserved.SQL_CACHE),
        SQL_NO_CACHE(SQLReserved.SQL_NO_CACHE);
        public final SQLReserved name;

        SQLCache(SQLReserved name) {
            this.name = name;
        }


        @Override
        public SQLReserved getName() {
            return name;
        }
    }
}
