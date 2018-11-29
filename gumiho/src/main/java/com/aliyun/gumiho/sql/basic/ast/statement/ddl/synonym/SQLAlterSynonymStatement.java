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


import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.SQLAlterStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

/**
 * ALTER [ PUBLIC ] SYNONYM [ schema. ] synonym { EDITIONABLE | NONEDITIONABLE | COMPILE } ;
 * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/sqlrf/ALTER-SYNONYM.html
 *
 * @author kongtong.ouyang onCondition 2018/1/23.
 */
public class SQLAlterSynonymStatement extends AbstractSQLStatement implements SQLAlterStatement {


    protected boolean public_;

    protected SQLName name;

    protected SQLOption option;


    public SQLAlterSynonymStatement(DBType dbType) {
        super(dbType);
    }


    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
        }
    }


    @Override
    public SQLAlterSynonymStatement clone() {
        SQLAlterSynonymStatement x = new SQLAlterSynonymStatement(this.dbType);
        cloneTo(x);
        return x;
    }


    public void cloneTo(SQLAlterSynonymStatement x) {
        super.cloneTo(x);

        x.public_ = this.public_;

        SQLName cloneName = this.name.clone();
        x.setName(cloneName);

        x.option = this.option;

    }


    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.ALTER_SYNONYM;
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
        this.name = name;
    }

    public SQLOption getOption() {
        return option;
    }

    public void setOption(SQLOption option) {
        this.option = option;
    }


    public enum SQLOption {

        EDITIONABLE("EDITIONABLE"),
        NONEDITIONABLE("NONEDITIONABLE"),
        COMPILE("COMPILE"),;

        public final String name;

        SQLOption(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
