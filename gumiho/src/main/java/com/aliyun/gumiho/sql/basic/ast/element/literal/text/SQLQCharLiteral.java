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
 * Q 'quote_delimiter c [ c ]... quote_delimiter'
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Literals.html#GUID-F521FBA0-FFED-4079-ABC4-9052218B3FD5
 *
 * @author kongtong.ouyang onCondition 2018/3/19.
 */
public class SQLQCharLiteral extends AbstractSQLTextLiteral {

    public SQLQCharLiteral(String value) {
        super(value);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SQLQCharLiteral clone() {
        return new SQLQCharLiteral(this.value);
    }


    /**
     * @param value Q'XXX'
     * @return 'XXX'
     */
    public static String removeNQChar(String value) {
        if (value == null
                || value.length() == 0) {
            return value;
        }
        char qChar = value.charAt(0);
        char firstChar = value.charAt(1);
        char lastChar = value.charAt(value.length() - 1);

        if ((qChar == 'q'
                || qChar == 'Q')
                && firstChar == '\''
                && lastChar == '\'') {
            return value.substring(1, value.length());
        }
        return value;
    }

}
