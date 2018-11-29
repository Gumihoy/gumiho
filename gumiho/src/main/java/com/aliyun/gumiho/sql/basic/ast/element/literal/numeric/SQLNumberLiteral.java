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
package com.aliyun.gumiho.sql.basic.ast.element.literal.numeric;

import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

import java.math.BigDecimal;

/**
 * NUMBER Literals
 * <p>
 * .2, 3.4, -6.78, +9.10, 1.2E3, 1.2E-3, -1.2E3, -1.2E-3.
 * https://dev.mysql.com/doc/refman/8.0/en/number-literals.html
 * <p>
 * https://docs.oracle.com/database/121/SQLRF/sql_elements003.htm#SQLRF00220
 *
 * @author kongtong.ouyang onCondition 2018/3/19.
 */
public class SQLNumberLiteral extends AbstractSQLNumericLiteral {

    public SQLNumberLiteral() {
    }

    public SQLNumberLiteral(String source) {
        this.source = source;
        this.value = new BigDecimal(source);
    }

    public SQLNumberLiteral(float value) {
        this.source = Float.toString(value);
        this.value = value;
    }

    public SQLNumberLiteral(double value) {
        this.source = Double.toString(value);
        this.value = value;
    }

    public SQLNumberLiteral(BigDecimal value) {
        this.source = value.toString();
        this.value = value;
    }

    public static SQLNumberLiteral of(String source) {
        return new SQLNumberLiteral(source);
    }

    public static SQLNumberLiteral of(double value) {
        return new SQLNumberLiteral(value);
    }

    public static SQLNumberLiteral of(BigDecimal value) {
        return new SQLNumberLiteral(value);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }


    @Override
    public SQLNumberLiteral clone() {
        SQLNumberLiteral x = new SQLNumberLiteral();
        this.cloneTo(x);
        return x;
    }

    @Override
    public Number getValue() {
        return value;
    }

    public void setValue(Number value) {
        this.value = value;
    }

    public static void main(String[] args) {
        Number number = new BigDecimal("+122E10");
        System.out.println(number.toString());
    }
}
