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

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.operator.SQLBinaryOperatorExpr;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLBinaryOperator;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

import java.math.BigInteger;

/**
 * Integer Literals
 * <p>
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#signed%20numeric%20literal
 * https://docs.oracle.com/database/121/SQLRF/sql_elements003.htm#SQLRF00220
 *
 * @author kongtong.ouyang on 2018/3/19.
 */
public class SQLIntegerLiteral extends AbstractSQLNumericLiteral {


    public SQLIntegerLiteral() {
    }

    public SQLIntegerLiteral(String source) {
        this.source = source;
        this.value = new BigInteger(source);
    }

    public SQLIntegerLiteral(long value) {
        this.source = String.valueOf(value);
        this.value = BigInteger.valueOf(value);
    }

    public SQLIntegerLiteral(Number value) {
        this.source = value.toString();
        this.value = value;
    }

    public static SQLIntegerLiteral of(long value) {
        return new SQLIntegerLiteral(value);
    }
    public static SQLIntegerLiteral of(String value) {
        return new SQLIntegerLiteral(new BigInteger(value));
    }
    public static SQLIntegerLiteral of(Number value) {
        return new SQLIntegerLiteral(value);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SQLIntegerLiteral clone() {
        SQLIntegerLiteral x = new SQLIntegerLiteral(this.value);
        return x;
    }



    public static SQLExpr subtract(SQLExpr left, SQLExpr right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        if (left instanceof SQLIntegerLiteral
                && right instanceof SQLIntegerLiteral) {
            long val = ((SQLIntegerLiteral) left).getLongValue() - ((SQLIntegerLiteral) right).getLongValue();
            return new SQLIntegerLiteral(val);
        } else {
            return new SQLBinaryOperatorExpr(left, SQLBinaryOperator.Subtract, right);
        }
    }

    public static SQLExpr increment(SQLExpr x) {
        if (x instanceof SQLIntegerLiteral) {
            long val = ((SQLIntegerLiteral) x).getLongValue() + 1;
            return SQLIntegerLiteral.of(val);
        }

        return new SQLBinaryOperatorExpr(x.clone(), SQLBinaryOperator.Add, SQLIntegerLiteral.of(1));
    }

    public static SQLExpr decrement(SQLExpr x) {
        if (x instanceof SQLIntegerLiteral) {
            long val = ((SQLIntegerLiteral) x).getLongValue() - 1;
            return SQLIntegerLiteral.of(val);
        }

        return new SQLBinaryOperatorExpr(x.clone(), SQLBinaryOperator.Subtract, SQLIntegerLiteral.of(1));
    }

    public static SQLIntegerLiteral min() {
        return new SQLIntegerLiteral(Long.MIN_VALUE);
    }

    public static SQLIntegerLiteral max() {
        return new SQLIntegerLiteral(Long.MAX_VALUE);
    }


    public long getLongValue() {
        return value.longValue();
    }

    public String getStringValue() {
        return value.toString();
    }

    public void setValue(BigInteger value) {

        this.value = value;
    }
}
