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
package com.aliyun.gumiho.sql.basic.ast.statement.ddl.pluggabledatabase;


import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.enums.ISQLEnum;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.SQLDropStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

/**
 * DROP PLUGGABLE DATABASE pdb_name [ { KEEP | INCLUDING } DATAFILES ] ;
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/DROP-PLUGGABLE-DATABASE.html
 *
 * @author kongtong.ouyang onCondition 2018/1/23.
 */
public class SQLDropPluggableDatabaseStatement extends AbstractSQLStatement implements SQLDropStatement {

    protected SQLName name;
    protected SQLOption option;


    public SQLDropPluggableDatabaseStatement(DBType dbType) {
        super(dbType);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
//        if (visitor.visit(this)) {
//            this.acceptChild(visitor, name);
//        }
    }

    @Override
    public SQLDropPluggableDatabaseStatement clone() {
        SQLDropPluggableDatabaseStatement x = new SQLDropPluggableDatabaseStatement(this.dbType);
        this.cloneTo(x);
        return x;
    }

    public void cloneTo(SQLDropPluggableDatabaseStatement x) {
        super.cloneTo(x);

        SQLName nameClone = this.name.clone();
        x.setName(nameClone);

        x.option = this.option;
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == name
                && target instanceof SQLName) {
            setName((SQLName) target);
            return true;
        }
        return false;
    }

    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.DROP_PLUGGABLE_DATABASE;
    }



    public SQLName getName() {
        return name;
    }

    public void setName(SQLName name) {
        setChildParent(name);
        this.name = name;
    }

    public SQLOption getOption() {
        return option;
    }

    public void setOption(SQLOption option) {
        this.option = option;
    }

    /**
     * KEEP DATAFILES
     * INCLUDING DATAFILES
     */
    public enum SQLOption implements ISQLEnum {
        KEEP_DATAFILES(SQLReserved.KEEP_DATAFILES),
        INCLUDING_DATAFILES(SQLReserved.INCLUDING_DATAFILES);

        public final SQLReserved name;

        SQLOption(SQLReserved name) {
            this.name = name;
        }

        @Override
        public SQLReserved getName() {
            return name;
        }

        @Override
        public String toString() {
            return name.upper;
        }
    }
}
