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
import com.aliyun.gumiho.sql.util.SQLUtils;

/**
 * N'XXX'
 * national character string literal
 * <p>
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#national%20character%20string%20literal
 * https://docs.oracle.com/database/121/SQLRF/sql_elements003.htm#SQLRF00220
 *
 * @author kongtong.ouyang onCondition 2018/3/19.
 */
public class SQLNCharLiteral extends AbstractSQLTextLiteral {

    public SQLNCharLiteral(String value) {
        setValue(value);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SQLNCharLiteral clone() {
        return new SQLNCharLiteral(this.value);
    }


    @Override
    public void setValue(String value) {
        value = removeQChar(value);
        this.value = SQLUtils.removeSingleQuote(value);
    }

    /**
     * @param value N'XXX'
     * @return 'XXX'
     */
    public static String removeQChar(String value) {
        if (value == null
                || value.length() == 0) {
            return value;
        }
        char nChar = value.charAt(0);
        char firstChar = value.charAt(1);
        char lastChar = value.charAt(value.length() - 1);

        if ((nChar == 'N'
                || nChar == 'n')
                && firstChar == '\''
                && lastChar == '\'') {
            return value.substring(1, value.length());
        }
        return value;
    }



    public static void main(String[] args) {
        String s = "n'afaf'";
        System.out.println(removeQChar(s));
    }
}
