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
package com.aliyun.gumiho.sql.basic.ast.statement.tcl;

import com.aliyun.gumiho.sql.basic.ast.element.expr.settransaction.SQLSetTransactionOption;
import com.aliyun.gumiho.sql.basic.ast.enums.ISQLEnum;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.SQLStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

import java.util.ArrayList;
import java.util.List;

/**
 *  SET [ LOCAL ] TRANSACTION <transaction mode> [ { <comma> <transaction mode> }... ]
 *  transaction mode: <isolation level> | <transaction access mode> | <diagnostics size>
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#set%20transaction%20statement
 *
 * SET [GLOBAL | SESSION] TRANSACTION transaction_characteristic [, transaction_characteristic] ...
 * https://dev.mysql.com/doc/refman/8.0/en/set-transaction.html
 * <p>
 * <p>
 * SET TRANSACTION transaction_mode [, ...]
 * SET TRANSACTION SNAPSHOT snapshot_id
 * https://www.postgresql.org/docs/10/static/sql-set-transaction.html
 * <p>
 * SET TRANSACTION { { READ { ONLY | WRITE } | ISOLATION LEVEL { SERIALIZABLE | READ COMMITTED } | USE ROLLBACK SEGMENT rollback_segment } [ NAME string ] | NAME string } ;
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/SET-TRANSACTION.html#GUID-F11E1E30-5871-48D1-8266-F80A1DF126A1
 *
 * @author kongtong.ouyang onCondition 2018/6/29.
 */
public class SQLSetTransactionStatement extends AbstractSQLStatement {

    protected SQLScope scope;
    protected final List<SQLSetTransactionOption> options = new ArrayList<>();


    public SQLSetTransactionStatement(DBType dbType) {
        super(dbType);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, options);
        }
    }


    @Override
    public SQLStatement clone() {
        SQLSetTransactionStatement x = new SQLSetTransactionStatement(this.dbType);

        x.scope = this.scope;

        for (SQLSetTransactionOption option : this.options) {
            SQLSetTransactionOption optionClone = option.clone();
            x.addOption(optionClone);
        }

        this.cloneTo(x);

        return x;
    }

    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.SET_TRANSACTION;
    }


    public SQLScope getScope() {
        return scope;
    }

    public void setScope(SQLScope scope) {
        this.scope = scope;
    }

    public List<SQLSetTransactionOption> getOptions() {
        return options;
    }

    public void addOption(SQLSetTransactionOption option) {
        if (option == null) {
            return;
        }
        setChildParent(option);
        this.options.add(option);
    }


    public enum SQLScope implements ISQLEnum {
        GLOBAL(SQLReserved.GLOBAL),
        SESSION(SQLReserved.SESSION),;

        public final SQLReserved name;

        SQLScope(SQLReserved name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name.upper;
        }

        @Override
        public SQLReserved getName() {
            return name;
        }
    }


}
