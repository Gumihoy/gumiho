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
package com.aliyun.gumiho.sql.basic.ast.statement.ddl.trigger;


import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.SQLAlterStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

/**
 * ALTER TRIGGER name  ON table_name  RENAME TO new_name
 * ALTER TRIGGER name  ON table_name  DEPENDS ON EXTENSION extension_name
 * <p>
 * https://www.postgresql.org/docs/current/static/sql-altertrigger.html
 * <p>
 * ALTER TRIGGER [ schema. ] trigger_name { trigger_compile_clause | { ENABLE | DISABLE } | RENAME TO new_name | { EDITIONABLE | NONEDITIONABLE } }
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/ALTER-TRIGGER-statement.html
 *
 * @author kongtong.ouyang onCondition 2018/1/23.
 */
public class SQLAlterTriggerStatement extends AbstractSQLStatement implements SQLAlterStatement {

    protected SQLName name;

    protected SQLName onTableName;

    protected SQLExpr option;


    public SQLAlterTriggerStatement(DBType dbType) {
        super(dbType);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
            this.acceptChild(visitor, onTableName);
            this.acceptChild(visitor, option);
        }
    }

    @Override
    public SQLAlterTriggerStatement clone() {
        SQLAlterTriggerStatement x = new SQLAlterTriggerStatement(this.dbType);
        this.cloneTo(x);
        return x;
    }


    public void cloneTo(SQLAlterTriggerStatement x) {
        super.cloneTo(x);

        SQLName nameClone = this.name.clone();
        x.setName(nameClone);

        if (this.onTableName != null) {
            SQLName onTableNameClone = onTableName.clone();
            x.setOnTableName(onTableNameClone);
        }

        if (this.option != null) {
            SQLExpr optionClone = option.clone();
            x.setOption(optionClone);
        }

    }

    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.ALTER_TRIGGER;
    }



    public SQLName getName() {
        return name;
    }

    public void setName(SQLName name) {
        setChildParent(name);
        this.name = name;
    }

    public SQLName getOnTableName() {
        return onTableName;
    }

    public void setOnTableName(SQLName onTableName) {
        setChildParent(onTableName);
        this.onTableName = onTableName;
    }

    public SQLExpr getOption() {
        return option;
    }

    public void setOption(SQLExpr option) {
        setChildParent(option);
        this.option = option;
    }
}
