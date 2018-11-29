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

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.hash.FNVHash;
import com.aliyun.gumiho.sql.util.SQLUtils;

/**
 * TextLiteral
 * value : 'xx'
 * <p>
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#general%20literal
 * <p>
 * 'hello', '"hello"', '""hello""', 'hel''lo', '\'hello' , 'This\nIs\nFour\nLines', 'disappearing\ backslash'
 * https://dev.mysql.com/doc/refman/8.0/en/string-literals.html
 * <p>
 * https://docs.oracle.com/database/121/SQLRF/sql_elements003.htm#SQLRF00218
 *
 * @author kongtong.ouyang onCondition 2018/3/19.
 */
public abstract class AbstractSQLTextLiteral extends AbstractSQLExpr implements ISQLTextLiteral {

    protected String value;
    protected long hash;
    protected long lowerHash;


    public AbstractSQLTextLiteral() {
    }

    public AbstractSQLTextLiteral(String value) {
        this.value = SQLUtils.removeSingleQuote(value);
    }

    @Override
    public AbstractSQLTextLiteral clone() {
        throw new UnsupportedOperationException(this.getClass().getName());
    }

    @Override
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public long hash() {
        if (this.hash == 0) {
            this.hash = FNVHash.fnv1a_64(this.value);
        }
        return hash;
    }

    @Override
    public long lowerHash() {
        if (this.lowerHash == 0) {
            this.lowerHash = FNVHash.fnv1a_64_lower(this.value);
        }
        return lowerHash;
    }
}
