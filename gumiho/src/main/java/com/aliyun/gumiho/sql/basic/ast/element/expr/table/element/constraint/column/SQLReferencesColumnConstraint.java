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
package com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.constraint.column;

import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.AbstractSQLReferencesConstraint;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * [CONSTRAINT <constraint name>] REFERENCES <table name> [ <left paren> <reference column list> <right paren> ]
 * [MATCH {FULL | PARTIAL | SIMPLE}] [ON UPDATE <referential action> | ON DELETE <referential action>]
 * <constraint characteristics>
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#references%20specification
 * <p>
 * <p>
 * REFERENCES tbl_name (key_part,...) [MATCH FULL | MATCH PARTIAL | MATCH SIMPLE] [ON DELETE reference_option] [ON UPDATE reference_option]
 * https://dev.mysql.com/doc/refman/5.6/en/create-table.html
 * <p>
 * https://docs.oracle.com/cd/B28359_01/server.111/b28286/clauses002.htm#CJAFFBAA
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/constraint.html#GUID-1055EA97-BA6F-4764-A15F-1024FD5B6DFE
 *
 * @author kongtong.ouyang onCondition 2018/3/29.
 */
public class SQLReferencesColumnConstraint extends AbstractSQLReferencesConstraint implements ISQLColumnConstraint {

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
            this.acceptChild(visitor, referencedTable);
            this.acceptChild(visitor, referencedColumns);
            this.acceptChild(visitor, actions);
            this.acceptChild(visitor, options);
        }
    }

    @Override
    public SQLReferencesColumnConstraint clone() {
        SQLReferencesColumnConstraint x = new SQLReferencesColumnConstraint();
        return x;
    }


}
