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
package com.aliyun.gumiho.sql.basic.ast.element.literal;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLNotation;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLNotation;
import com.aliyun.gumiho.sql.basic.ast.enums.ISQLEnum;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.hash.SQLHash;
import com.aliyun.gumiho.sql.util.SQLUtils;

/**
 * x'XX' / X'XXX'  /0xXXX
 * <p>
 * https://dev.mysql.com/doc/refman/8.0/en/hexadecimal-literals.html
 *
 * @author kongtong.ouyang on 2018/3/20.
 */
public class SQLHexadecimalLiteral extends AbstractSQLNotation implements SQLNotation, SQLHash {

    protected SQLPrefix prefix = SQLPrefix.X;

    private String value;

    public SQLHexadecimalLiteral(String value) {
        setValue(value);
    }

    public SQLHexadecimalLiteral(SQLPrefix prefix, String value) {
        this.prefix = prefix;
        setValue(value);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SQLHexadecimalLiteral clone() {
        SQLHexadecimalLiteral x = new SQLHexadecimalLiteral(this.prefix, this.value);
        return x;
    }

    @Override
    public long hash() {
        return 0;
    }

    @Override
    public long lowerHash() {
        return 0;
    }

    public SQLPrefix getPrefix() {
        return prefix;
    }

    public void setPrefix(SQLPrefix prefix) {
        this.prefix = prefix;
        setValue(value);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        if (value == null) {
            return;
        }
        this.prefix = ofByValue(value);
        this.value = getValue(value);
    }

    @Override
    public String notation() {
        if (notation == null) {
            notation = prefix.name.upper + SQLReserved.QUOTE + value + SQLReserved.QUOTE;
        }
        return notation;
    }



    private static SQLPrefix ofByValue(String value) {
        if (value == null) {
            return SQLPrefix.X;
        }

        char c0 = value.charAt(0);

        if (c0 == 'x'
                || c0 == 'X') {
            return SQLPrefix.X;
        }

        char c1 = value.charAt(1);
        if (c0 == '0'
                && c1 == 'x') {
            return SQLPrefix.ZERO_X;
        }

        return SQLPrefix.X;
    }

    private static String getValue(String value) {
        if (value == null) {
            return null;
        }

        String newValue = value;

        char c0 = value.charAt(0);

        if (c0 == 'x'
                || c0 == 'X') {
            newValue = value.substring(1, value.length());

        } else {

            char c1 = value.charAt(1);
            if (c0 == '0'
                    && c1 == 'x') {
                newValue = value.substring(2, value.length());
            }
        }

        newValue = SQLUtils.removeSingleQuote(newValue);

        return newValue;
    }



    public enum SQLPrefix implements ISQLEnum {
        X(SQLReserved.X),
        ZERO_X(SQLReserved.ZERO_X);
        public final SQLReserved name;

        SQLPrefix(SQLReserved name) {
            this.name = name;
        }


        @Override
        public SQLReserved getName() {
            return name;
        }
    }
}
