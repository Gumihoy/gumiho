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
package com.aliyun.gumiho.sql.basic.ast.element.datatype;


import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.hash.SQLHash;

import java.util.List;

/**
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#data%20type
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/datatype-attribute.html#GUID-B4A364AB-7CC2-4B3F-AF52-09A752029C8E
 */
public interface SQLDataType extends SQLExpr, SQLHash {

    String getName();

    SQLExpr getNameExpr();

    boolean isParen();

    void setParen(boolean paren);

    List<SQLExpr> getArguments();

    void addArgument(SQLExpr argument);

    @Override
    SQLDataType clone();

}
