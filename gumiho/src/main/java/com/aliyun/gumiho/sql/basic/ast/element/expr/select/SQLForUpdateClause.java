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
package com.aliyun.gumiho.sql.basic.ast.element.expr.select;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * FOR { UPDATE | NO KEY UPDATE | SHARE | KEY SHARE } [ OF table_name [, ...] ] [ NOWAIT | SKIP LOCKED| WAIT integer  ] [...]
 * <p>
 * <p>
 * [FOR {UPDATE | SHARE} [OF tbl_name [, tbl_name] ...] [NOWAIT | SKIP LOCKED] | LOCK IN SHARE MODE]]
 * https://dev.mysql.com/doc/refman/5.7/en/select.html
 * <p>
 * <p>
 * https://www.postgresql.org/docs/devel/static/sql-select.html
 * for_update_clause: https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/SELECT.html#GUID-CFA006CA-6FF1-4972-821E-6996142A51C6
 *
 * @author kongtong.ouyang onCondition 2018/3/21.
 */
public class SQLForUpdateClause extends AbstractSQLExpr implements ISQLLockClause {

    protected SQLForType forType;

    private final List<SQLExpr> columns = new ArrayList<>();

    private SQLForOption forOption;


    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, columns);
            this.acceptChild(visitor, forOption);
        }
    }

    @Override
    public SQLForUpdateClause clone() {

        SQLForUpdateClause x = new SQLForUpdateClause();

        this.cloneTo(x);
        return x;
    }

    public void cloneTo(SQLForUpdateClause x) {
        super.cloneTo(x);

        x.forType = this.forType;

        for (SQLExpr column : this.columns) {
            SQLExpr columnClone = column.clone();
            x.addColumn(columnClone);
        }

        x.forOption = this.forOption;
    }


    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {

        boolean replace = replaceInList(columns, source, target, this);
        if (replace) {
            return true;
        }

        if (source == forOption) {
            if (target == null) {
                setForOption(null);
                return true;
            } else if (target instanceof SQLForOption) {
                setForOption((SQLForOption) target);
                return true;
            }
            return false;
        }

        return false;
    }

    public SQLForType getForType() {
        return forType;
    }

    public void setForType(SQLForType forType) {
        this.forType = forType;
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

    public SQLForOption getForOption() {
        return forOption;
    }

    public void setForOption(SQLForOption forOption) {
        setChildParent(forOption);
        this.forOption = forOption;
    }


    public enum SQLForType {
        UPDATE(SQLReserved.UPDATE),
        NO(SQLReserved.NO),
        KEY_UPDATE(SQLReserved.KEY_UPDATE),
        SHARE(SQLReserved.SHARE),
        KEY_SHARE(SQLReserved.KEY_SHARE);

        public final SQLReserved name;

        SQLForType(SQLReserved name) {
            this.name = name;
        }
    }


    public interface SQLForOption extends SQLExpr {
        @Override
        SQLForOption clone();
    }

    /**
     * NOWAIT
     */
    public static class SQLForNoWaitOption extends AbstractSQLExpr implements SQLForOption {

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            visitor.visit(this);
        }

        @Override
        public SQLForNoWaitOption clone() {
            return new SQLForNoWaitOption();
        }
    }

    /**
     * WAIT integer
     */
    public static class SQLForWaitOption extends AbstractSQLExpr implements SQLForOption {

        protected SQLExpr expr;

        public SQLForWaitOption(SQLExpr expr) {
            setExpr(expr);
        }

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, expr);
            }
        }

        @Override
        public SQLForWaitOption clone() {
            SQLExpr exprClone = this.expr.clone();
            return new SQLForWaitOption(exprClone);
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
     * SKIP LOCKED
     */
    public static class SQLForSkipLockedOption extends AbstractSQLExpr implements SQLForOption {

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            visitor.visit(this);
        }

        @Override
        public SQLForSkipLockedOption clone() {
            return new SQLForSkipLockedOption();
        }
    }


}

