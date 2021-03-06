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
package com.aliyun.gumiho.sql.basic.ast.element.literal.text;

import com.aliyun.gumiho.sql.basic.ast.element.literal.SQLLiteral;
import com.aliyun.gumiho.sql.hash.SQLHash;

/**
 * TextLiteral
 * value : 'xx'
 * <p>
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#general%20literal
 *
 * 'hello', '"hello"', '""hello""', 'hel''lo', '\'hello' , 'This\nIs\nFour\nLines', 'disappearing\ backslash'
 * https://dev.mysql.com/doc/refman/8.0/en/string-literals.html
 *
 *
 * https://docs.oracle.com/database/121/SQLRF/sql_elements003.htm#SQLRF00218
 *
 * @author kongtong.ouyang onCondition 2018/3/19.
 */
public interface ISQLTextLiteral extends SQLLiteral, SQLHash {

    @Override
    String getValue();

    @Override
    ISQLTextLiteral clone();

}
