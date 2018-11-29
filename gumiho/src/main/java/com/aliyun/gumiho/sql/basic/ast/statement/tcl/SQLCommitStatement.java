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

import com.aliyun.gumiho.sql.basic.ast.element.expr.commit.SQLCommitOption;
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
 * COMMIT [WORK] [AND [NO] CHAIN] [[NO] RELEASE]
 * https://dev.mysql.com/doc/refman/8.0/en/commit.html
 * <p>
 * COMMIT [ WORK | TRANSACTION ]
 * https://www.postgresql.org/docs/10/static/sql-commit.html
 * <p>
 * <p>
 * COMMIT [ WORK ] [ [ COMMENT string ] | [ WRITE [ WAIT | NOWAIT ] [ IMMEDIATE | BATCH ] ] | FORCE string [, integer ] ] ;
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/COMMIT.html#GUID-6CD5C9A7-54B9-4FA2-BA3C-D6B4492B9EE2
 *
 * @author kongtong.ouyang onCondition 2018/6/29.
 */
public class SQLCommitStatement extends AbstractSQLStatement {

    protected SQLAction action;
    protected final List<SQLCommitOption> options = new ArrayList<>();


    public SQLCommitStatement(DBType dbType) {
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
        SQLCommitStatement x = new SQLCommitStatement(this.dbType);
        this.cloneTo(x);

        x.action = this.action;

        for (SQLCommitOption option : this.options) {
            SQLCommitOption optionClone = option.clone();
            x.addOption(optionClone);
        }
        return x;
    }


    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.COMMIT;
    }


    public SQLAction getAction() {
        return action;
    }

    public void setAction(SQLAction action) {
        this.action = action;
    }

    public List<SQLCommitOption> getOptions() {
        return options;
    }

    public void addOption(SQLCommitOption option) {
        if (option == null) {
            return;
        }
        setChildParent(option);
        this.options.add(option);
    }

    public enum SQLAction implements ISQLEnum {
        WORK(SQLReserved.WORK),
        TRANSACTION(SQLReserved.TRANSACTION);
        public final SQLReserved name;

        SQLAction(SQLReserved name) {
            this.name = name;
        }

        @Override
        public SQLReserved getName() {
            return name;
        }
    }


}
