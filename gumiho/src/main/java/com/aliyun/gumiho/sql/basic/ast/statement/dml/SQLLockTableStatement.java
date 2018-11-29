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

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.ISQLPartitionClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.SQLForUpdateClause;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.enums.ISQLEnum;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.SQLObjectType;
import com.aliyun.gumiho.sql.hash.FNVHash;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * LOCK TABLES tbl_name [[AS] alias] lock_type [, tbl_name [[AS] alias] lock_type] ...
 * lock_type: READ [LOCAL] | [LOW_PRIORITY] WRITE
 * https://dev.mysql.com/doc/refman/5.6/en/lock-tables.html
 * <p>
 * <p>
 * LOCK [ TABLE ] [ ONLY ] name [ * ] [, ...] [ IN lockmode MODE ] [ NOWAIT ]
 * https://www.postgresql.org/docs/10/static/sql-lock.html
 * <p>
 * LOCK TABLE [ schema. ] { table , view } [ partition_extension_clause , @ dblink ] [, [ schema. ] { table , view } [ partition_extension_clause , @ dblink ] ]... IN lockmode MODE [ NOWAIT , WAIT integer ] ;
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/LOCK-TABLE.html#GUID-4C00C6D9-C5C5-46CC-AD33-A64001744A4C
 *
 * @author kongtong.ouyang onCondition 2018/1/23.
 */
public class SQLLockTableStatement extends AbstractSQLStatement implements SQLDMLStatement {

    protected SQLType type = SQLType.TABLE;

    protected boolean only;

    protected final List<SQLLockTableItem> items = new ArrayList<>();

    protected SQLLockMode lockMode;

    protected SQLForUpdateClause.SQLForOption option;

    public SQLLockTableStatement(DBType dbType) {
        super(dbType);
    }


    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, items);
            this.acceptChild(visitor, option);
        }
    }

    @Override
    public SQLLockTableStatement clone() {
        SQLLockTableStatement x = new SQLLockTableStatement(this.dbType);
        this.cloneTo(x);
        return x;
    }

    public void cloneTo(SQLLockTableStatement x) {
        super.cloneTo(x);

        x.type = this.type;
        x.only = this.only;

        for (SQLLockTableItem item : this.items) {
            SQLLockTableItem itemClone = item.clone();
            x.addItem(itemClone);
        }

        x.lockMode = this.lockMode;

        if (this.option != null) {
            SQLForUpdateClause.SQLForOption optionClone = this.option.clone();
            x.setOption(optionClone);
        }
    }

    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.LOCK_TABLE;
    }


    public SQLType getType() {
        return type;
    }

    public SQLLockTableStatement setType(SQLType type) {
        this.type = type;
        return this;
    }

    public boolean isOnly() {
        return only;
    }

    public void setOnly(boolean only) {
        this.only = only;
    }

    public List<SQLLockTableItem> getItems() {
        return items;
    }

    public void addItem(SQLLockTableItem item) {
        if (item == null) {
            return;
        }
        setChildParent(item);
        this.items.add(item);
    }

    public SQLLockMode getLockMode() {
        return lockMode;
    }

    public void setLockMode(SQLLockMode lockMode) {
        this.lockMode = lockMode;
    }

    public SQLForUpdateClause.SQLForOption getOption() {
        return option;
    }

    public void setOption(SQLForUpdateClause.SQLForOption option) {
        this.option = option;
    }

    /**
     * tbl_name [[AS] alias] lock_type
     * https://dev.mysql.com/doc/refman/5.6/en/lock-tables.html
     * <p>
     * name [partitionClause]
     * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/LOCK-TABLE.html#GUID-4C00C6D9-C5C5-46CC-AD33-A64001744A4C
     */
    public static class SQLLockTableItem extends AbstractSQLExpr {
        protected SQLName name;
        protected boolean as;
        protected SQLName alias;
        protected ISQLPartitionClause partitionClause;

        protected SQLLockType lockType;

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, name);
                this.acceptChild(visitor, partitionClause);
            }
        }

        @Override
        public SQLLockTableItem clone() {
            SQLLockTableItem x = new SQLLockTableItem();

            SQLName nameClone = this.name.clone();
            x.setName(nameClone);

            x.as = this.as;

            if (this.alias != null) {
                SQLName aliasClone = this.alias.clone();
                x.setAlias(aliasClone);
            }

            if (this.partitionClause != null) {
                ISQLPartitionClause partitionClauseClone = this.partitionClause.clone();
                x.setPartitionClause(partitionClauseClone);
            }

            return x;
        }

        @Override
        public boolean replace(SQLExpr source, SQLExpr target) {
            if (source == name
                    && target instanceof SQLName) {
                setName((SQLName) target);
                return true;
            }
            return false;
        }

        public SQLName getName() {
            return name;
        }

        public void setName(SQLName name) {
            setChildParent(name);
            this.name = name;
        }

        public boolean isAs() {
            return as;
        }

        public SQLLockTableItem setAs(boolean as) {
            this.as = as;
            return this;
        }

        public SQLName getAlias() {
            return alias;
        }

        public SQLLockTableItem setAlias(SQLName alias) {
            setChildParent(alias);
            this.alias = alias;
            return this;
        }

        public ISQLPartitionClause getPartitionClause() {
            return partitionClause;
        }

        public void setPartitionClause(ISQLPartitionClause partitionClause) {
            setChildParent(partitionClause);
            this.partitionClause = partitionClause;
        }

        public SQLLockType getLockType() {
            return lockType;
        }

        public SQLLockTableItem setLockType(SQLLockType lockType) {
            this.lockType = lockType;
            return this;
        }
    }

    public enum SQLType implements ISQLEnum {
        TABLE(SQLReserved.TABLE),
        TABLES(SQLReserved.TABLES);

        public final SQLReserved name;

        SQLType(SQLReserved name) {
            this.name = name;
        }

        @Override
        public SQLReserved getName() {
            return name;
        }
    }

    /**
     * https://www.postgresql.org/docs/10/static/sql-lock.html
     * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/LOCK-TABLE.html#GUID-4C00C6D9-C5C5-46CC-AD33-A64001744A4C
     */
    public enum SQLLockMode implements ISQLEnum {

        ACCESS_SHARE(SQLReserved.ACCESS_SHARE),
        ROW_SHARE(SQLReserved.ROW_SHARE),
        ROW_EXCLUSIVE(SQLReserved.ROW_EXCLUSIVE),
        SHARE_UPDATE_EXCLUSIVE(SQLReserved.SHARE_UPDATE_EXCLUSIVE),
        SHARE_UPDATE(SQLReserved.SHARE_UPDATE),
        SHARE(SQLReserved.SHARE),
        SHARE_ROW_EXCLUSIVE(SQLReserved.SHARE_ROW_EXCLUSIVE),
        EXCLUSIVE(SQLReserved.EXCLUSIVE),
        ACCESS_EXCLUSIVE(SQLReserved.ACCESS_EXCLUSIVE),;

        public final SQLReserved name;

        SQLLockMode(SQLReserved name) {
            this.name = name;
        }

        @Override
        public SQLReserved getName() {
            return name;
        }

        public static SQLLockMode of(String name) {
            long lowerHashCode64 = FNVHash.fnv1a_64_lower(name);
            return SQLLockModeHandler.MAP.get(lowerHashCode64);
        }

        public static class SQLLockModeHandler {
            public static final ConcurrentHashMap<Long, SQLLockMode> MAP = new ConcurrentHashMap<>();

            static {
                for (SQLLockMode lockMode : SQLLockMode.values()) {
                    MAP.put(lockMode.name.lowerHashCode64, lockMode);
                }
            }
        }
    }


    /**
     * READ [LOCAL] 、[LOW_PRIORITY] WRITE
     * https://dev.mysql.com/doc/refman/5.6/en/lock-tables.html
     */
    public enum SQLLockType implements ISQLEnum {
        READ(SQLReserved.READ),
        READ_LOCAL(SQLReserved.READ_LOCAL),
        WRITE(SQLReserved.WRITE),
        LOW_PRIORITY_WRITE(SQLReserved.LOW_PRIORITY_WRITE),;

        public final SQLReserved name;

        SQLLockType(SQLReserved name) {
            this.name = name;
        }

        @Override
        public SQLReserved getName() {
            return name;
        }

        @Override
        public String toString() {
            return name.upper;
        }
    }
}
