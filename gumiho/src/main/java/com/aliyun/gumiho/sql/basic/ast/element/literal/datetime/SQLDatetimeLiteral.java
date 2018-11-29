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
package com.aliyun.gumiho.sql.basic.ast.element.literal.datetime;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.literal.SQLLiteral;
import com.aliyun.gumiho.sql.basic.ast.element.literal.text.SQLCharLiteral;

/**
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#datetime%20literal
 * <p>
 * https://dev.mysql.com/doc/refman/5.7/en/date-and-time-literals.html
 * <p>
 * https://docs.oracle.com/database/121/SQLRF/sql_elements003.htm#SQLRF51062
 * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/sqlrf/Literals.html#GUID-8F4B3F82-8821-4071-84D6-FBBA21C05AC1
 *
 * @author kongtong.ouyang onCondition 2018/3/20.
 */
public abstract class SQLDatetimeLiteral extends AbstractSQLExpr implements SQLLiteral {

    protected SQLExpr value;

    public SQLDatetimeLiteral() {
    }

    public SQLDatetimeLiteral(String value) {
        setValue(SQLCharLiteral.of(value));
    }

    public SQLDatetimeLiteral(SQLExpr value) {
        setValue(value);
    }

    @Override
    public SQLDatetimeLiteral clone() {
        throw new UnsupportedOperationException(this.getClass().getName());
    }

    public void cloneTo(SQLDatetimeLiteral x) {
        super.cloneTo(x);

        SQLExpr valueClone = value.clone();
        x.setValue(valueClone);
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (value == source) {
            setValue(target);
            return true;
        }
        return false;
    }

    @Override
    public SQLExpr getValue() {
        return value;
    }

    public void setValue(SQLExpr value) {
        setChildParent(value);
        this.value = value;
    }
}
