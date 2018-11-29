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
package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLReturningIntoClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.clause.SQLUsingClause;
import com.aliyun.gumiho.sql.dialect.oracle.ast.statement.AbstractOracleSQLStatement;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

import java.util.ArrayList;
import java.util.List;

/**
 * 13.28 EXECUTE IMMEDIATE Statement
 * <p>
 * EXECUTE IMMEDIATE dynamic_sql_stmt
 * [ { into_clause | bulk_collect_into_clause } [ using_clause ]
 * | using_clause [ dynamic_returning_clause ]
 * | dynamic_returning_clause
 * ] ;
 * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/lnpls/EXECUTE-IMMEDIATE-statement.html#GUID-C3245A95-B85B-4280-A01F-12307B108DC8
 * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/lnpls/EXECUTE-IMMEDIATE-statement.html#GUID-C3245A95-B85B-4280-A01F-12307B108DC8
 *
 * @author kongtong.ouyang onCondition 2018/3/22.
 */
public class OracleSQLExecuteImmediateStatement extends AbstractOracleSQLStatement {

    protected SQLExpr dynamicSQLStmt;

    protected boolean bulkCollect = false;
    protected final List<SQLExpr> intoItems = new ArrayList<>();

    protected SQLUsingClause usingClause;

    protected SQLReturningIntoClause returningIntoClause;

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if(visitor.visit(this)) {
            this.acceptChild(visitor, dynamicSQLStmt);
            this.acceptChild(visitor, intoItems);
            this.acceptChild(visitor, usingClause);
            this.acceptChild(visitor, returningIntoClause);
        }
    }

    @Override
    public SQLObjectType getObjectType() {
        return null;
    }

    public SQLExpr getDynamicSQLStmt() {
        return dynamicSQLStmt;
    }

    public void setDynamicSQLStmt(SQLExpr dynamicSQLStmt) {
        this.dynamicSQLStmt = dynamicSQLStmt;
    }

    public boolean isBulkCollect() {
        return bulkCollect;
    }

    public void setBulkCollect(boolean bulkCollect) {
        this.bulkCollect = bulkCollect;
    }

    public List<SQLExpr> getIntoItems() {
        return intoItems;
    }

    public void addInotItem(SQLExpr item) {
        if (item == null) {
            return;
        }
        setChildParent(item);
        this.intoItems.add(item);
    }

    public SQLUsingClause getUsingClause() {
        return usingClause;
    }

    public void setUsingClause(SQLUsingClause usingClause) {
        setChildParent(usingClause);
        this.usingClause = usingClause;
    }



    public SQLReturningIntoClause getReturningIntoClause() {
        return returningIntoClause;
    }

    public void setReturningIntoClause(SQLReturningIntoClause returningIntoClause) {
        setChildParent(returningIntoClause);
        this.returningIntoClause = returningIntoClause;
    }
}
