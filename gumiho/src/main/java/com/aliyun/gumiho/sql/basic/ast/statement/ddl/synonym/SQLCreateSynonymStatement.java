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
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLSharingClause;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLEditionAbleType;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.SQLCreateStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

/**
 *
 * https://docs.microsoft.com/en-us/sql/t-sql/statements/create-synonym-transact-sql?view=sql-server-2017
 *
 *
 * CREATE [ OR REPLACE ] [ EDITIONABLE | NONEDITIONABLE ]
 * [ PUBLIC ] SYNONYM [ schema. ] synonym
 * [ SHARING = { METADATA | NONE } ] FOR [ schema. ] object [ @ dblink ]
 * https://docs.oracle.com/cd/E11882_01/server.112/e41084/statements_7001.htm
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-SYNONYM.html
 *
 * @author kongtong.ouyang onCondition 2018/1/23.
 */
public class SQLCreateSynonymStatement extends AbstractSQLStatement implements SQLCreateStatement {

    protected boolean orReplace = false;

    protected SQLEditionAbleType editionAble;

    protected boolean public_ = false;

    protected SQLName name;

    protected SQLSharingClause sharingClause;

    protected SQLName forName;


    public SQLCreateSynonymStatement(DBType dbType) {
        super(dbType);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
            this.acceptChild(visitor, sharingClause);
            this.acceptChild(visitor, forName);
        }
    }

    @Override
    public SQLCreateSynonymStatement clone() {
        SQLCreateSynonymStatement x = new SQLCreateSynonymStatement(this.dbType);
        this.cloneTo(x);
        return x;
    }

    public void cloneTo(SQLCreateSynonymStatement x) {
        super.cloneTo(x);

        x.setOrReplace(this.orReplace);

        x.editionAble = this.editionAble;

        x.setPublic_(this.public_);

        SQLName nameClone = this.name.clone();
        x.setName(nameClone);

        x.sharingClause = this.sharingClause;

        SQLName forNameClone = this.forName.clone();
        x.setForName(forNameClone);
    }




    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source instanceof SQLName) {

            if (source == name) {
                this.setName((SQLName) target);
                return true;
            }

            if (source == forName) {
                this.setForName((SQLName) target);
                return true;
            }
        }

        return false;
    }


    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.CREATE_SYNONYM;
    }


    public boolean isOrReplace() {
        return orReplace;
    }

    public void setOrReplace(boolean orReplace) {
        this.orReplace = orReplace;
    }

    public SQLEditionAbleType getEditionAble() {
        return editionAble;
    }

    public void setEditionAble(SQLEditionAbleType editionAble) {
        this.editionAble = editionAble;
    }

    public boolean isPublic_() {
        return public_;
    }

    public void setPublic_(boolean public_) {
        this.public_ = public_;
    }

    public SQLName getName() {
        return name;
    }

    public void setName(SQLName name) {
        setChildParent(name);
        this.name = name;
    }

    public SQLSharingClause getSharingClause() {
        return sharingClause;
    }

    public void setSharingClause(SQLSharingClause sharingClause) {
        setChildParent(sharingClause);
        this.sharingClause = sharingClause;
    }

    public SQLName getForName() {
        return forName;
    }

    public void setForName(SQLName forName) {
        setChildParent(name);
        this.forName = forName;
    }
}
