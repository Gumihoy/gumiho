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
package com.aliyun.gumiho.sql.basic.ast.element.expr.clause;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#language%20clause
 *
 * @author kongtong.ouyang onCondition 2018/3/18.
 */
public class SQLLanguageClause extends AbstractSQLExpr {


    @Override
    protected void accept0(SQLASTVisitor visitor) {
//        visitor.visit(this);
    }

    public enum Type {
        ADA("ada", "ADA"),
        C("c", "C"),
        COBOL("COBOL", "COBOL"),
        FORTRAN("FORTRAN", "FORTRAN"),
        MUMPS("MUMPS", "MUMPS"),
        PASCAL("PASCAL", "PASCAL"),
        PLI("PLI", "PLI"),
        SQL("SQL", "SQL"),;

        public final String lower;
        public final String upper;

        Type(String lower, String upper) {
            this.lower = lower;
            this.upper = upper;
        }
    }
}
