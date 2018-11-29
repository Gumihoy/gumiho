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
package com.aliyun.gumiho.sql.basic.ast.element.function.window;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * analytic_function([ arguments ]) OVER ( [ query_partition_clause ] [ order_by_clause [ windowing_clause ] ] )
 *
 * query_partition_clause: PARTITION BY { expr[, expr ]... | ( expr[, expr ]... ) }
 * order_by_clause:  ORDER [ SIBLINGS ] BY { expr | position | c_alias } [ ASC | DESC ] [ NULLS FIRST | NULLS LAST ] [, { expr | position | c_alias } [ ASC | DESC ] [ NULLS FIRST | NULLS LAST ] ]...
 * windowing_clause:
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#window%20function
 * <p>
 * https://dev.mysql.com/doc/refman/8.0/en/window-function-descriptions.html
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Analytic-Functions.html
 * <p>
 * https://www.postgresql.org/docs/devel/static/tutorial-window.html
 *
 * @author kongtong.ouyang onCondition 2018/3/20.
 */
public class SQLWindowFunction extends AbstractSQLWindowFunction implements ISQLWindowFunction {

    public SQLWindowFunction(String name) {
        super(name);
    }

    public SQLWindowFunction(SQLExpr name) {
        super(name);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, nameExpr);
            this.acceptChild(visitor, arguments);
            this.acceptChild(visitor, overClause);
        }
    }

    @Override
    public SQLWindowFunction clone() {
        SQLWindowFunction x = new SQLWindowFunction(this.name);

        return x;
    }


    public void cloneTo(SQLWindowFunction x) {
        super.cloneTo(x);
    }

}
