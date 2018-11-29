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
package com.aliyun.gumiho.sql.basic.ast.statement.fcl;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.SQLStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

/**
 * EXIT [ label ] [ WHEN boolean-expression ];
 * https://www.postgresql.org/docs/9.3/static/plpgsql-control-structures.html
 * <p>
 * EXIT [ label ] [ WHEN boolean_expression ] ;
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/EXIT-statement.html#GUID-66E20B6C-3606-42AD-A7DB-C8EC782B94D8
 *
 * @author kongtong.ouyang onCondition 2018/6/29.
 */
public class SQLExitStatement extends AbstractSQLStatement {

    public SQLExpr name;
    protected SQLExpr condition;


    public SQLExitStatement(DBType dbType) {
        super(dbType);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
            this.acceptChild(visitor, condition);
        }
    }


    @Override
    public SQLStatement clone() {
        SQLExitStatement x = new SQLExitStatement(this.dbType);

        if (this.name != null) {
            SQLExpr nameClone = this.name.clone();
            x.setName(nameClone);
        }

        if (this.condition != null) {
            SQLExpr conditionClone = this.condition.clone();
            x.setCondition(conditionClone);
        }

        this.cloneTo(x);

        return x;
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == name) {
            setName(target);
            return true;
        }
        if (source == condition) {
            setCondition(target);
            return true;
        }
        return false;
    }

    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.EXIT;
    }


    public SQLExpr getName() {
        return name;
    }

    public void setName(SQLExpr name) {
        setChildParent(name);
        this.name = name;
    }

    public SQLExpr getCondition() {
        return condition;
    }

    public void setCondition(SQLExpr condition) {
        this.condition = condition;
    }
}
