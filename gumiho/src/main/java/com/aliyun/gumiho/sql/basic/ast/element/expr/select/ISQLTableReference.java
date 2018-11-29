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
package com.aliyun.gumiho.sql.basic.ast.element.expr.select;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;

/**
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#table%20reference
 *
 * @author kongtong.ouyang onCondition 2018/3/24.
 */
public interface ISQLTableReference extends SQLExpr {

    boolean isParen();
    void setParen(boolean paren);

    SQLName getAlias();

    SQLName computeAlias();
    boolean containsAlias(String alias);
    boolean containsAlias(long aliasLowerHash);

    @Override
    ISQLTableReference clone();
}
