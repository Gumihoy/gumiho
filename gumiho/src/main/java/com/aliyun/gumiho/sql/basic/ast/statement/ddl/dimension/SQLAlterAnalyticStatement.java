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
package com.aliyun.gumiho.sql.basic.ast.statement.ddl.dimension;


import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.analytic.ISQLAlterAnalyticAction;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.SQLAlterStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

/**
 * ALTER ANALYTIC VIEW [ schema. ] analytic_view_name { RENAME TO new_av_name | COMPILE };
 *
 * @author kongtong.ouyang onCondition 2018/1/23.
 */
public class SQLAlterAnalyticStatement extends AbstractSQLStatement implements SQLAlterStatement {

    protected SQLName name;
    protected ISQLAlterAnalyticAction action;


    public SQLAlterAnalyticStatement(DBType dbType) {
        super(dbType);
    }


    @Override
    protected void accept0(SQLASTVisitor visitor) {
//        if (visitor.visit(this)) {
//            this.acceptChild(visitor, name);
//            this.acceptChild(visitor, action);
//        }
    }

    @Override
    public SQLAlterAnalyticStatement clone() {
        return null;
    }


    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == name
                && target instanceof SQLName) {
            setName((SQLName) target);
            return true;
        }

        if (target instanceof ISQLAlterAnalyticAction) {
            setAction((ISQLAlterAnalyticAction) target);
            return true;
        }
        return false;
    }

    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.ALTER_ANALYTIC;
    }


    public SQLName getName() {
        return name;
    }

    public void setName(SQLName name) {
        setChildParent(name);
        this.name = name;
    }

    public ISQLAlterAnalyticAction getAction() {
        return action;
    }

    public void setAction(ISQLAlterAnalyticAction action) {
        setChildParent(action);
        this.action = action;
    }
}
