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
import com.aliyun.gumiho.sql.basic.ast.enums.ISQLEnum;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.util.SQLUtils;

/**
 * b'XX' / B'XXX' / 0b01
 * <p>
 * https://dev.mysql.com/doc/refman/8.0/en/bit-value-literals.html
 *
 * @author kongtong.ouyang on 2018/3/20.
 */
public class SQLBitLiteral extends AbstractSQLNotation implements SQLLiteral {

    private SQLPrefix prefix = SQLPrefix.B;

    private String value;


    public SQLBitLiteral(String value) {
        setValue(value);
    }

    public SQLBitLiteral(SQLPrefix prefix, String value) {
        this.prefix = prefix;
        setValue(value);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SQLBitLiteral clone() {
        SQLBitLiteral x = new SQLBitLiteral(this.prefix, this.value);
        return x;
    }


    public SQLPrefix getPrefix() {
        return prefix;
    }

    public void setPrefix(SQLPrefix prefix) {
        this.prefix = prefix;
        setValue(this.value);
    }

    @Override
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

    public String notation() {
        if (notation == null) {
            notation = prefix.name.upper + value;
        }
        return notation;
    }


    private static SQLPrefix ofByValue(String value) {
        if (value == null) {
            return SQLPrefix.B;
        }

        char c0 = value.charAt(0);

        if (c0 == 'b'
                || c0 == 'B') {
            return SQLPrefix.B;
        }

        char c1 = value.charAt(1);
        if (c0 == '0'
                && c1 == 'b') {
            return SQLPrefix.ZERO_B;
        }

        return SQLPrefix.B;
    }

    private static String getValue(String value) {
        if (value == null) {
            return null;
        }

        String newValue = value;

        char c0 = value.charAt(0);

        if (c0 == 'b'
                || c0 == 'B') {
            newValue = value.substring(1, value.length());

        } else {

            char c1 = value.charAt(1);
            if (c0 == '0'
                    && c1 == 'b') {
                newValue = value.substring(2, value.length());
            }
        }

        newValue = SQLUtils.removeSingleQuote(newValue);

        return newValue;
    }

    public enum SQLPrefix implements ISQLEnum {

        B(SQLReserved.B),
        ZERO_B(SQLReserved.ZERO_B),;
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
