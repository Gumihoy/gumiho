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

import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * 'xxx'
 * <p>
 * character string literal
 * <p>
 * https://docs.oracle.com/database/121/SQLRF/sql_elements003.htm#SQLRF00220
 * <p>
 * 'hello', '"hello"', '""hello""', 'hel''lo', '\'hello' , 'This\nIs\nFour\nLines', 'disappearing\ backslash'
 * https://dev.mysql.com/doc/refman/8.0/en/string-literals.html
 * <p>
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#character%20string%20literal
 *
 * @author kongtong.ouyang onCondition 2018/3/19.
 */
public class SQLCharLiteral extends AbstractSQLTextLiteral {

    protected static final String EMPTY = "";

    public SQLCharLiteral(String value) {
        super(value);
    }

    public static SQLCharLiteral of(String value) {
        return new SQLCharLiteral(value);
    }

    /**
     * ''
     */
    public static SQLCharLiteral empty() {
        return new SQLCharLiteral(EMPTY);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SQLCharLiteral clone() {
        SQLCharLiteral x = new SQLCharLiteral(this.value);
        return x;
    }
}
