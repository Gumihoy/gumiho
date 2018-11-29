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
package com.aliyun.gumiho.sql.basic.ast.element.pseudocolumn;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Pseudocolumns.html#GUID-6C65C788-76AA-4A51-B011-51D53DD2521DO
 *
 * @author kongtong.ouyang onCondition 2018/3/19.
 */
public interface SQLPseudoColumn extends SQLExpr {

    @Override
    SQLPseudoColumn clone();
}
