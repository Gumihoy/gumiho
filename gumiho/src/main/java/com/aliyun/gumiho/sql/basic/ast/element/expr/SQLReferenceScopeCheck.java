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
package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.ast.enums.SQLReferentialAction;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * REFERENCES ARE [ NOT ] CHECKED [ ON DELETE <reference scope check action> ]
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#reference%20scope%20check
 *
 * @author kongtong.ouyang onCondition 2018/3/27.
 */
public class SQLReferenceScopeCheck extends AbstractSQLExpr {

    private boolean not;

    private SQLReferentialAction checkAction;


    @Override
    protected void accept0(SQLASTVisitor visitor) {
//        visitor.visit(this);
    }

    public boolean isNot() {
        return not;
    }

    public void setNot(boolean not) {
        this.not = not;
    }

    public SQLReferentialAction getCheckAction() {
        return checkAction;
    }

    public void setCheckAction(SQLReferentialAction checkAction) {
        this.checkAction = checkAction;
    }
}
