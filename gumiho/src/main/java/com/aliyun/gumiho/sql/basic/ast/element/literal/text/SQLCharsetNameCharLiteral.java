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

import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.util.SQLUtils;

/**
 * _charset_name 'string'
 * <p>
 * https://dev.mysql.com/doc/refman/8.0/en/string-literals.html
 *
 * @author kongtong.ouyang onCondition 2018/3/19.
 */
public class SQLCharsetNameCharLiteral extends AbstractSQLTextLiteral {

    protected SQLName charsetName;

    public SQLCharsetNameCharLiteral(String charsetName, String value) {
        super(value);
        setCharsetName(SQLUtils.ofName(charsetName));
    }

    public SQLCharsetNameCharLiteral(SQLName charsetName, String value) {
        super(value);
        setCharsetName(charsetName);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
//        visitor.visit(this);
    }

    @Override
    public SQLCharsetNameCharLiteral clone() {
        SQLName charsetNameClone = this.charsetName.clone();
        SQLCharsetNameCharLiteral x = new SQLCharsetNameCharLiteral(charsetNameClone, this.value);
        return x;
    }


    public SQLName getCharsetName() {
        return charsetName;
    }

    public void setCharsetName(SQLName charsetName) {
        setChildParent(charsetName);
        this.charsetName = charsetName;
    }

}
