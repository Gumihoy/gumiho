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
import com.aliyun.gumiho.sql.basic.ast.element.expr.clause.SQLErrorLoggingClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.clause.SQLWhereClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.ISQLTableReference;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.SQLWithClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.limit.ISQLLimitClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.order.SQLOrderByClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.update.ISQLUpdateSetClause;
import com.aliyun.gumiho.sql.basic.ast.element.hint.SQLHint;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

/**
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html
 * <p>
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#update%20statement:%20positioned
 * <p>
 * <p>
 * UPDATE [LOW_PRIORITY] [IGNORE] table_reference
 * SET assignment_list
 * [WHERE where_condition]
 * [ORDER BY ...] [LIMIT row_count]
 * https://dev.mysql.com/doc/refman/5.7/en/update.html
 * <p>
 * <p>
 * [ WITH [ RECURSIVE ] with_query [, ...] ]
 * UPDATE [ ONLY ] table_name [ * ] [ [ AS ] alias ]
 * SET { column_name = { expression | DEFAULT } | ( column_name [, ...] ) = [ ROW ]
 * ( { expression | DEFAULT } [, ...] ) | ( column_name [, ...] ) = ( sub-SELECT ) } [, ...]
 * [ FROM from_list ] [ WHERE condition
 * | WHERE CURRENT OF cursor_name ]
 * [ RETURNING * | output_expression [ [ AS ] output_name ] [, ...] ]
 * https://www.postgresql.org/docs/devel/static/sql-update.html
 *
 * @author kongtong.ouyang onCondition 2018/1/23.
 */
public class SQLUpdateStatement extends AbstractSQLStatement implements SQLDMLStatement {

    protected SQLWithClause withClause;

    protected SQLHint hint;

    protected boolean lowPriority;

    protected boolean ignore;

    protected ISQLTableReference tableReference;

    protected ISQLUpdateSetClause updateSetClause;

    protected SQLWhereClause whereClause;

    protected SQLOrderByClause orderByClause;

    protected ISQLLimitClause limitClause;

    protected ISQLReturningClause returningClause;

    protected SQLErrorLoggingClause errorLoggingClause;


    public SQLUpdateStatement(DBType dbType) {
        super(dbType);
    }


    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, withClause);
            this.acceptChild(visitor, hint);
            this.acceptChild(visitor, tableReference);
            this.acceptChild(visitor, updateSetClause);
            this.acceptChild(visitor, whereClause);
            this.acceptChild(visitor, orderByClause);
            this.acceptChild(visitor, limitClause);
            this.acceptChild(visitor, returningClause);
            this.acceptChild(visitor, errorLoggingClause);
        }
    }


    @Override
    public SQLUpdateStatement clone() {
        SQLUpdateStatement x = new SQLUpdateStatement(this.dbType);
        this.cloneTo(x);
        return x;
    }

    public void cloneTo(SQLUpdateStatement x) {
        super.cloneTo(x);

        if (this.withClause != null) {
            SQLWithClause withClauseClone = this.withClause.clone();
            x.setWithClause(withClauseClone);
        }

        if (this.hint != null) {
            SQLHint hintClone = this.hint.clone();
            x.setHint(hintClone);
        }


        ISQLTableReference tableReferenceClone = this.tableReference.clone();
        x.setTableReference(tableReferenceClone);

        ISQLUpdateSetClause updateSetClauseClone = this.updateSetClause.clone();
        x.setUpdateSetClause(updateSetClauseClone);

        if (this.whereClause != null) {
            SQLWhereClause whereClauseClone = this.whereClause.clone();
            x.setWhereClause(whereClauseClone);
        }

        if (this.orderByClause != null) {
            SQLOrderByClause orderByClauseClone = this.orderByClause.clone();
            x.setOrderByClause(orderByClauseClone);
        }

        if (this.limitClause != null) {
            ISQLLimitClause limitClauseClone = this.limitClause.clone();
            x.setLimitClause(limitClauseClone);
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
    public SQLObjectType getObjectType() {
        return SQLObjectType.UPDATE;
    }



    public SQLWithClause getWithClause() {
        return withClause;
    }

    public void setWithClause(SQLWithClause withClause) {
        setChildParent(withClause);
        this.withClause = withClause;
    }

    public SQLHint getHint() {
        return hint;
    }

    public void setHint(SQLHint hint) {
        setChildParent(hint);
        this.hint = hint;
    }

    public boolean isLowPriority() {
        return lowPriority;
    }

    public void setLowPriority(boolean lowPriority) {
        this.lowPriority = lowPriority;
    }

    public boolean isIgnore() {
        return ignore;
    }

    public void setIgnore(boolean ignore) {
        this.ignore = ignore;
    }

    public ISQLTableReference getTableReference() {
        return tableReference;
    }

    public void setTableReference(ISQLTableReference tableReference) {
        setChildParent(tableReference);
        this.tableReference = tableReference;
    }

    public ISQLUpdateSetClause getUpdateSetClause() {
        return updateSetClause;
    }

    public void setUpdateSetClause(ISQLUpdateSetClause updateSetClause) {
        setChildParent(updateSetClause);
        this.updateSetClause = updateSetClause;
    }

    public SQLWhereClause getWhereClause() {
        return whereClause;
    }

    public void setWhereClause(SQLWhereClause whereClause) {
        setChildParent(whereClause);
        this.whereClause = whereClause;
    }

    public SQLOrderByClause getOrderByClause() {
        return orderByClause;
    }

    public void setOrderByClause(SQLOrderByClause orderByClause) {
        setChildParent(orderByClause);
        this.orderByClause = orderByClause;
    }

    public ISQLLimitClause getLimitClause() {
        return limitClause;
    }

    public void setLimitClause(ISQLLimitClause limitClause) {
        setChildParent(limitClause);
        this.limitClause = limitClause;
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
}
