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

import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * [DEFAULT] CHARSET [=] value
 *
 * @author kongtong.ouyang onCondition 2018/3/15.
 */
public class SQLCharsetOptionExpr extends SQLSetOptionExpr {


    public SQLCharsetOptionExpr(SQLExpr value) {
        super(SQLReserved.CHARSET.ofExpr(), value);
    }

    public SQLCharsetOptionExpr(boolean equalSign, SQLExpr value) {
        super(SQLReserved.CHARSET.ofExpr(), equalSign, value);
    }

    public SQLCharsetOptionExpr(boolean default_, boolean equalSign, SQLExpr value) {
        super(default_, SQLReserved.CHARACTER_SET.ofExpr(), equalSign, value);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, value);
        }
    }
}
