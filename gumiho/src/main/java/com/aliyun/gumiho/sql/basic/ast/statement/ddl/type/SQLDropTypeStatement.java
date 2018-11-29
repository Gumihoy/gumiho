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
package com.aliyun.gumiho.sql.basic.ast.statement.ddl.type;


import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.SQLDropStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

import java.util.ArrayList;
import java.util.List;

/**
 * DROP TYPE <schema-resolved user-defined type name> [CASCADE | RESTRICT]
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#drop%20data%20type%20statement
 * <p>
 * <p>
 * DROP TYPE [ IF EXISTS ] name [, ...] [ CASCADE | RESTRICT ]
 * https://www.postgresql.org/docs/10/static/sql-droptype.html
 * <p>
 * <p>
 * DROP TYPE [ schema. ] type_name [ FORCE | VALIDATE ]
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/DROP-TYPE-statement.html
 *
 * @author kongtong.ouyang onCondition 2018/1/23.
 */
public class SQLDropTypeStatement extends AbstractSQLStatement implements SQLDropStatement {

    protected boolean ifExists;

    protected final List<SQLName> names = new ArrayList<>();

    protected SQLDropTypeOption option;


    public SQLDropTypeStatement(DBType dbType) {
        super(dbType);
    }


    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, names);
        }
    }

    @Override
    public SQLDropTypeStatement clone() {
        SQLDropTypeStatement x = new SQLDropTypeStatement(this.dbType);
        this.cloneTo(x);
        return x;
    }

    public void cloneTo(SQLDropTypeStatement x) {
        super.cloneTo(x);

        x.ifExists = this.ifExists;

        for (SQLName name : names) {
            SQLName cloneName = name.clone();
            x.addName(cloneName);
        }

        x.option = this.option;
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        boolean replace = replaceInList(names, source, (SQLName) target, this);
        if (replace) {
            return true;
        }

        return false;
    }

    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.DROP_TYPE;
    }



    public boolean isIfExists() {
        return ifExists;
    }

    public void setIfExists(boolean ifExists) {
        this.ifExists = ifExists;
    }

    public List<SQLName> getNames() {
        return names;
    }

    public void addName(SQLName name) {
        if (name == null) {
            return;
        }
        setChildParent(name);
        this.names.add(name);
    }

    public SQLDropTypeOption getOption() {
        return option;
    }

    public void setOption(SQLDropTypeOption option) {
        this.option = option;
    }

    public enum SQLDropTypeOption {
        FORCE("FORCE"),
        VALIDATE("VALIDATE"),
        CASCADE("CASCADE"),
        RESTRICT("RESTRICT"),;

        public final String name;

        SQLDropTypeOption(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
