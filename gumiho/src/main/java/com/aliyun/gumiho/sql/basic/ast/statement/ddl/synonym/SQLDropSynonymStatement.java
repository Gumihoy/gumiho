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
package com.aliyun.gumiho.sql.basic.ast.statement.ddl.synonym;


import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.SQLDropStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

/**
 *
 *
 * DROP [PUBLIC] SYNONYM [ IF EXISTS ] [ schema. ] synonym [FORCE]
 * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/sqlrf/DROP-SYNONYM.html
 *
 * @author kongtong.ouyang onCondition 2018/1/23.
 */
public class SQLDropSynonymStatement extends AbstractSQLStatement implements SQLDropStatement {

    protected boolean public_ = false;

    protected boolean ifExists;

    protected SQLName name;

    protected boolean force = false;


    public SQLDropSynonymStatement(DBType dbType) {
        super(dbType);
    }


    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
        }
    }

    @Override
    public SQLDropSynonymStatement clone() {
        SQLDropSynonymStatement x = new SQLDropSynonymStatement(this.dbType);
        this.cloneTo(x);
        return x;
    }

    public void cloneTo(SQLDropSynonymStatement x) {
        super.cloneTo(x);

        x.setPublic_(this.public_);

        x.ifExists = this.ifExists;

        SQLName cloneName = name.clone();
        x.setName(cloneName);

        x.force = this.force;
    }


    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == name) {
            this.setName((SQLName) target);
            return true;
        }
        return false;
    }

    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.DROP_SYNONYM;
    }


    public boolean isPublic_() {
        return public_;
    }

    public void setPublic_(boolean public_) {
        this.public_ = public_;
    }

    public boolean isIfExists() {
        return ifExists;
    }

    public void setIfExists(boolean ifExists) {
        this.ifExists = ifExists;
    }

    public SQLName getName() {
        return name;
    }

    public void setName(SQLName name) {
        this.name = name;
    }

    public boolean isForce() {
        return force;
    }

    public void setForce(boolean force) {
        this.force = force;
    }
}
