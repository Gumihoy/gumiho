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
package com.aliyun.gumiho.sql.basic.ast.element.expr.select;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * TABLESAMPLE <sample method> <left paren> <sample percentage> <right paren> [ REPEATABLE <left paren> <repeat argument> <right paren> ]
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#sample%20clause
 * <p>
 *
 * @author kongtong.ouyang onCondition 2018/3/20.
 */
public class SQLSampleClause extends AbstractSQLExpr {

    protected SampleMethodType sampleMethod;

    protected SQLExpr percent;

    // REPEATABLE <left paren> <repeat argument> <right paren>
    protected SQLExpr repeatArgument;


    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, percent);
            this.acceptChild(visitor, repeatArgument);
        }
    }


    public SampleMethodType getSampleMethod() {
        return sampleMethod;
    }

    public void setSampleMethod(SampleMethodType sampleMethod) {
        this.sampleMethod = sampleMethod;
    }

    public SQLExpr getPercent() {
        return percent;
    }

    public void setPercent(SQLExpr percent) {
        setChildParent(percent);
        this.percent = percent;
    }

    public SQLExpr getRepeatArgument() {
        return repeatArgument;
    }

    public void setRepeatArgument(SQLExpr repeatArgument) {
        setChildParent(repeatArgument);
        this.repeatArgument = repeatArgument;
    }

    public enum SampleMethodType {
        BERNOULLI, SYSTEM;
    }


}
