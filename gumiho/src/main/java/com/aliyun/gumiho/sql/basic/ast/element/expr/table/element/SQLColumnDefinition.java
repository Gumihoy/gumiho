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
package com.aliyun.gumiho.sql.basic.ast.element.expr.table.element;

import com.aliyun.gumiho.sql.basic.ast.element.datatype.SQLDataType;
import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLCollateOptionExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLReferenceScopeCheck;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.SQLCommentOptionExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.SQLAlterXmlSchemaClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.constraint.column.ISQLColumnConstraint;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.constraint.column.ISQLNullColumnConstraint;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.constraint.column.SQLAutoIncrementColumnConstraint;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.constraint.column.SQLReferencesColumnConstraint;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLVisibleType;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.util.SQLUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <column name> [ <data type> | <domain name> ] [ <reference scope check> ]
 * [ <default clause> | <identity column specification> | <generation clause> ]
 * [ <column constraint definition> ... ] [ <collate clause> ]
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#column%20definition
 * <p>
 * <p>
 * <p>
 * col_name  data_type [NOT NULL | NULL] [DEFAULT default_value]
 * [AUTO_INCREMENT] [UNIQUE [KEY]] [[PRIMARY] KEY] [COMMENT 'string'] [COLUMN_FORMAT {FIXED|DYNAMIC|DEFAULT}] [STORAGE {DISK|MEMORY|DEFAULT}] [reference_definition]
 * https://dev.mysql.com/doc/refman/5.6/en/create-table.html
 * <p>
 * <p
 * column [ datatype [ COLLATE column_collation_name ] ]
 * [ SORT ] [ VISIBLE | INVISIBLE ]
 * [ DEFAULT [ ON NULL ] expr | identity_clause ]
 * [ ENCRYPT encryption_spec ]
 * [ { inline_constraint }...
 * | inline_ref_constraint
 * ]
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-TABLE.html#GUID-F9CE0CC3-13AE-4744-A43C-EAC7A71AAAB6
 *
 * @author kongtong.ouyang onCondition 2018/3/13.
 */
public class SQLColumnDefinition extends AbstractSQLExpr implements ISQLColumnDefinition {

    protected SQLName name;

    protected SQLDataType dataType;

    protected SQLCollateOptionExpr collateClause;

    protected boolean sort;

    protected SQLVisibleType visible;

    protected SQLReferenceScopeCheck referenceScopeCheck;

    protected SQLExpr defaultExpr;

    protected SQLExpr cryptClause;

    protected final List<ISQLColumnConstraint> columnConstraints = new ArrayList<>();

    // mysql
    protected SQLCommentOptionExpr commentClause;

    // oracle
//    protected OracleSQLLobStorageClause lobStorageClause;
    protected SQLAlterXmlSchemaClause alterXmlSchemaClause;



    public SQLColumnDefinition() {
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
            this.acceptChild(visitor, dataType);
            this.acceptChild(visitor, referenceScopeCheck);
            this.acceptChild(visitor, defaultExpr);
            this.acceptChild(visitor, columnConstraints);
            this.acceptChild(visitor, cryptClause);
            this.acceptChild(visitor, collateClause);
            this.acceptChild(visitor, commentClause);
        }
    }

    @Override
    public SQLColumnDefinition clone() {
        SQLColumnDefinition x = new SQLColumnDefinition();
        this.cloneTo(x);
        return null;
    }

    public void cloneTo(SQLColumnDefinition x) {

    }


    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (target == null) {

            if (source == dataType) {
                setDataType(null);
                return true;
            }

            if (source == defaultExpr) {
                setDefaultExpr(null);
                return true;
            }

        }

        if (source == name
                && target instanceof SQLName) {
            setName((SQLName) target);
            return true;
        }

        if (source == dataType
                && target instanceof SQLDataType) {
            setDataType((SQLDataType) target);
            return true;
        }

        return false;
    }


    public final ISQLNullColumnConstraint findNullOrNotNullColumnConstraint() {
        for (ISQLColumnConstraint columnConstraint : columnConstraints) {
            if (columnConstraint instanceof ISQLNullColumnConstraint) {
                return (ISQLNullColumnConstraint) columnConstraint;
            }
        }
        return null;
    }

    public final boolean isAutoIncrement() {
        for (ISQLColumnConstraint columnConstraint : columnConstraints) {
            if (columnConstraint instanceof SQLAutoIncrementColumnConstraint) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isReferencesColumn() {
        for (ISQLColumnConstraint columnConstraint : columnConstraints) {
            if (columnConstraint instanceof SQLReferencesColumnConstraint) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<SQLName> referencedTables() {
        List<SQLName> referencedTables = new ArrayList<>();
        for (ISQLColumnConstraint columnConstraint : columnConstraints) {
            if (columnConstraint instanceof SQLReferencesColumnConstraint) {
                referencedTables.add(((SQLReferencesColumnConstraint) columnConstraint).getReferencedTable());
            }
        }
        return referencedTables;
    }

    public SQLName getName() {
        return name;
    }

    public String getColumnName() {
        if (name != null) {
            return name.getName();
        }
        return null;
    }

    public void setName(SQLName name) {
        if (name == null) {
            return;
        }
        setChildParent(name);
        this.name = name;
    }

    public void setColumnName(String columnName) {
        if (columnName == null) {
            return;
        }
        setName(SQLUtils.ofName(columnName));
    }

    public SQLDataType getDataType() {
        return dataType;
    }

    public void setDataType(SQLDataType dataType) {
        setChildParent(dataType);
        this.dataType = dataType;
    }

    public boolean isSort() {
        return sort;
    }

    public void setSort(boolean sort) {
        this.sort = sort;
    }

    public SQLVisibleType getVisible() {
        return visible;
    }

    public void setVisible(SQLVisibleType visible) {
        this.visible = visible;
    }

    public SQLReferenceScopeCheck getReferenceScopeCheck() {
        return referenceScopeCheck;
    }

    public void setReferenceScopeCheck(SQLReferenceScopeCheck referenceScopeCheck) {
        setChildParent(referenceScopeCheck);
        this.referenceScopeCheck = referenceScopeCheck;
    }

    public SQLExpr getDefaultExpr() {
        return defaultExpr;
    }

    public void setDefaultExpr(SQLExpr defaultExpr) {
        setChildParent(defaultExpr);
        this.defaultExpr = defaultExpr;
    }

    @Override
    public List<ISQLColumnConstraint> getColumnConstraints() {
        return columnConstraints;
    }

    public void addColumnConstraint(ISQLColumnConstraint columnConstraint) {
        if (columnConstraint == null) {
            return;
        }
        setChildParent(columnConstraint);
        this.columnConstraints.add(columnConstraint);
    }

    public SQLExpr getCryptClause() {
        return cryptClause;
    }

    public void setCryptClause(SQLExpr cryptClause) {
        setChildParent(cryptClause);
        this.cryptClause = cryptClause;
    }

    public SQLCollateOptionExpr getCollateClause() {
        return collateClause;
    }

    public void setCollateClause(SQLCollateOptionExpr collateClause) {
        setChildParent(collateClause);
        this.collateClause = collateClause;
    }


    public SQLCommentOptionExpr getCommentClause() {
        return commentClause;
    }

    public void setCommentClause(SQLCommentOptionExpr commentClause) {
        setChildParent(commentClause);
        this.commentClause = commentClause;
    }

    public SQLExpr getComment() {
        if (commentClause != null) {
            return commentClause.getValue();
        }
        return null;
    }

    public void setComment(SQLExpr expr) {
        SQLCommentOptionExpr commentClause;
        if (expr instanceof SQLCommentOptionExpr) {
            commentClause = (SQLCommentOptionExpr)expr;
        } else {
            commentClause = SQLCommentOptionExpr.of(expr);
        }
        setChildParent(commentClause);
        this.commentClause = commentClause;
    }

//    public OracleSQLLobStorageClause getLobStorageClause() {
//        return lobStorageClause;
//    }
//
//    public void setLobStorageClause(OracleSQLLobStorageClause lobStorageClause) {
//        setChildParent(lobStorageClause);
//        this.lobStorageClause = lobStorageClause;
//    }

    public SQLAlterXmlSchemaClause getAlterXmlSchemaClause() {
        return alterXmlSchemaClause;
    }

    public void setAlterXmlSchemaClause(SQLAlterXmlSchemaClause alterXmlSchemaClause) {
        setChildParent(alterXmlSchemaClause);
        this.alterXmlSchemaClause = alterXmlSchemaClause;
    }

    /**
     * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#identity%20column%20specification
     * <p>
     * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/sqlrf/CREATE-TABLE.html#GUID-F9CE0CC3-13AE-4744-A43C-EAC7A71AAAB6
     */
    public class SQLIdentityColumnSpecification extends AbstractSQLExpr {

        protected SQLGeneratedType generatedType;

        protected boolean onNull;

        protected final List<SQLExpr> identityOptions = new ArrayList<>();


        @Override
        protected void accept0(SQLASTVisitor visitor) {

        }

        public SQLGeneratedType getGeneratedType() {
            return generatedType;
        }

        public void setGeneratedType(SQLGeneratedType generatedType) {
            this.generatedType = generatedType;
        }

        public boolean isOnNull() {
            return onNull;
        }

        public void setOnNull(boolean onNull) {
            this.onNull = onNull;
        }

        public List<SQLExpr> getIdentityOptions() {
            return identityOptions;
        }


    }

    /**
     * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#generation%20clause
     */
    public class SQLGenerationClause extends AbstractSQLExpr {

        private SQLExpr expr;

        @Override
        protected void accept0(SQLASTVisitor visitor) {

        }

        public SQLExpr getExpr() {
            return expr;
        }

        public void setExpr(SQLExpr expr) {
            this.expr = expr;
        }
    }

    public enum SQLGeneratedType {

    }
}
