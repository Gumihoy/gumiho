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
package com.aliyun.gumiho.sql.basic.ast.statement.dml;

import com.aliyun.gumiho.sql.basic.ast.element.expr.ISQLReturningClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.clause.SQLErrorLoggingClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.clause.SQLOnDuplicateKeyUpdateClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.ISQLTableReference;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.SQLWithClause;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

import java.util.ArrayList;
import java.util.List;

/**
 * INSERT [INTO] <insertion target> <insert columns and source>
 * <p>
 * overrideClause: OVERRIDING USER VALUE | OVERRIDING SYSTEM VALUE
 * <p>
 * valuesClause: subQuery , SQLValuesClause
 * <p>
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#insert%20statement
 * <p>
 * INSERT [LOW_PRIORITY | DELAYED | HIGH_PRIORITY] [IGNORE]
 * [INTO] tbl_name
 * [PARTITION (partition_name [, partition_name] ...)]
 * [(col_name [, col_name] ...)]
 * {VALUES | VALUE} (value_list) [, (value_list)] ...
 * [ON DUPLICATE KEY UPDATE assignment_list]
 * https://dev.mysql.com/doc/refman/8.0/en/insert.html
 *
 * @author kongtong.ouyang onCondition 2018/1/23.
 */
public class SQLInsertStatement extends AbstractSQLStatement implements SQLDMLStatement {

    protected SQLWithClause withClause;

    protected SQLPriority priority;

    protected boolean ignore;

    protected boolean into = true;

    protected ISQLTableReference tableReference;

    protected final List<SQLExpr> columns = new ArrayList<>();

    protected SQLOverrideClause overrideClause;

    protected SQLExpr valuesClause;

    // mysql
    protected SQLOnDuplicateKeyUpdateClause onDuplicateKeyUpdateClause;

    protected ISQLReturningClause returningClause;

    protected SQLErrorLoggingClause errorLoggingClause;


    public SQLInsertStatement(DBType dbType) {
        super(dbType);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, withClause);
            this.acceptChild(visitor, tableReference);
            this.acceptChild(visitor, columns);
            this.acceptChild(visitor, valuesClause);
            this.acceptChild(visitor, returningClause);
            this.acceptChild(visitor, errorLoggingClause);
        }
    }

    @Override
    public SQLInsertStatement clone() {
        SQLInsertStatement x = new SQLInsertStatement(this.dbType);
        return x;
    }

    public void cloneTo(SQLInsertStatement x) {
        super.cloneTo(x);

        if (this.withClause != null) {
            SQLWithClause withClauseClone = this.withClause.clone();
            x.setWithClause(withClauseClone);
        }

        x.priority = this.priority;
        x.ignore = this.ignore;
        x.into = this.into;

        ISQLTableReference tableReferenceClone = this.tableReference.clone();
        x.setTableReference(tableReferenceClone);


        for (SQLExpr column : columns) {
            SQLExpr columnClone = column.clone();
            x.addColumn(columnClone);
        }

        x.overrideClause = this.overrideClause;

        if (this.valuesClause != null) {
            SQLExpr valuesClauseClone = valuesClause.clone();
            x.setValuesClause(valuesClauseClone);
        }

        if (this.returningClause != null) {
            ISQLReturningClause returningClauseClone = this.returningClause.clone();
            x.setReturningClause(returningClauseClone);
        }

        if (this.errorLoggingClause != null) {
            SQLErrorLoggingClause errorLoggingClause = this.errorLoggingClause.clone();
            x.setErrorLoggingClause(errorLoggingClause);
        }

    }


    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        boolean replace = replaceInList(columns, source, target, this);
        if (replace) {
            return true;
        }
        return false;
    }

    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.INSERT;
    }


    public SQLWithClause getWithClause() {
        return withClause;
    }

    public void setWithClause(SQLWithClause withClause) {
        setChildParent(withClause);
        this.withClause = withClause;
    }

    public SQLPriority getPriority() {
        return priority;
    }

    public void setPriority(SQLPriority priority) {
        this.priority = priority;
    }

    public boolean isIgnore() {
        return ignore;
    }

    public void setIgnore(boolean ignore) {
        this.ignore = ignore;
    }

    public boolean isInto() {
        return into;
    }

    public void setInto(boolean into) {
        this.into = into;
    }

    public ISQLTableReference getTableReference() {
        return tableReference;
    }

    public void setTableReference(ISQLTableReference tableReference) {
        setChildParent(tableReference);
        this.tableReference = tableReference;
    }

    public List<SQLExpr> getColumns() {
        return columns;
    }

    public void addColumn(SQLExpr column) {
        if (column == null) {
            return;
        }
        setChildParent(column);
        this.columns.add(column);
    }

    public SQLOverrideClause getOverrideClause() {
        return overrideClause;
    }

    public void setOverrideClause(SQLOverrideClause overrideClause) {
        this.overrideClause = overrideClause;
    }

    public SQLExpr getValuesClause() {
        return valuesClause;
    }

    public void setValuesClause(SQLExpr valuesClause) {
        setChildParent(valuesClause);
        this.valuesClause = valuesClause;
    }

    public SQLOnDuplicateKeyUpdateClause getOnDuplicateKeyUpdateClause() {
        return onDuplicateKeyUpdateClause;
    }

    public void setOnDuplicateKeyUpdateClause(SQLOnDuplicateKeyUpdateClause onDuplicateKeyUpdateClause) {
        setParent(onDuplicateKeyUpdateClause);
        this.onDuplicateKeyUpdateClause = onDuplicateKeyUpdateClause;
    }

    public ISQLReturningClause getReturningClause() {
        return returningClause;
    }

    public void setReturningClause(ISQLReturningClause returningClause) {
        setChildParent(returningClause);
        this.returningClause = returningClause;
    }

    public SQLErrorLoggingClause getErrorLoggingClause() {
        return errorLoggingClause;
    }

    public void setErrorLoggingClause(SQLErrorLoggingClause errorLoggingClause) {
        setChildParent(errorLoggingClause);
        this.errorLoggingClause = errorLoggingClause;
    }

    /**
     * https://dev.mysql.com/doc/refman/8.0/en/insert.html
     */
    public enum SQLPriority {
        LOW_PRIORITY(SQLReserved.LOW_PRIORITY),
        DELAYED(SQLReserved.DELAYED),
        HIGH_PRIORITY(SQLReserved.HIGH_PRIORITY),;
        public final SQLReserved name;

        SQLPriority(SQLReserved name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name.upper;
        }
    }

    /**
     * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#override%20clause
     */
    public enum SQLOverrideClause {
        OVERRIDING_USER_VALUE(SQLReserved.OVERRIDING_USER_VALUE),
        OVERRIDING_SYSTEM_VALUE(SQLReserved.OVERRIDING_SYSTEM_VALUE);
        public final SQLReserved name;

        SQLOverrideClause(SQLReserved name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name.upper;
        }
    }
}
