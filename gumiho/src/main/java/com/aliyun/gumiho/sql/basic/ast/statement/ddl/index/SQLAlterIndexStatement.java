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
package com.aliyun.gumiho.sql.basic.ast.statement.ddl.index;


import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.SQLAlterStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

import java.util.ArrayList;
import java.util.List;

/**
 * ALTER INDEX { index_name | ALL } ON <object>
 * {
 * REBUILD {
 * [ PARTITION = ALL ] [ WITH ( <rebuild_index_option> [ ,...n ] ) ]
 * | [ PARTITION = partition_number [ WITH ( <single_partition_rebuild_index_option> ) [ ,...n ] ]
 * }
 * | DISABLE
 * | REORGANIZE  [ PARTITION = partition_number ] [ WITH ( <reorganize_option>  ) ]
 * | SET ( <set_index_option> [ ,...n ] )
 * | RESUME [WITH (<resumable_index_options>,[…n])]
 * | PAUSE
 * | ABORT
 * }
 * [ ; ]
 * https://docs.microsoft.com/en-us/sql/t-sql/statements/alter-index-transact-sql?view=sql-server-2017
 * <p>
 * <p>
 * ALTER INDEX [ IF EXISTS ] name RENAME TO new_name
 * ALTER INDEX [ IF EXISTS ] name SET TABLESPACE tablespace_name
 * ALTER INDEX name ATTACH PARTITION index_name
 * ALTER INDEX name DEPENDS ON EXTENSION extension_name
 * ALTER INDEX [ IF EXISTS ] name SET ( storage_parameter = value [, ... ] )
 * ALTER INDEX [ IF EXISTS ] name RESET ( storage_parameter [, ... ] )
 * ALTER INDEX [ IF EXISTS ] name ALTER [ COLUMN ] column_number
 * SET STATISTICS integer
 * ALTER INDEX ALL IN TABLESPACE name [ OWNED BY role_name [, ... ] ]
 * SET TABLESPACE new_tablespace [ NOWAIT ]
 * https://www.postgresql.org/docs/devel/static/sql-alterindex.html
 * <p>
 * <p>
 * <p>
 * ALTER INDEX [ schema. ]index
 * { { deallocate_unused_clause
 * | allocate_extent_clause
 * | shrink_clause
 * | parallel_clause
 * | physical_attributes_clause
 * | logging_clause
 * | partial_index_clause
 * } ...
 * | rebuild_clause
 * | PARAMETERS ( 'ODCI_parameters' )
 * )
 * | COMPILE
 * | { ENABLE | DISABLE }
 * | UNUSABLE [ ONLINE ] [ { DEFERRED | IMMEDIATE } INVALIDATION ]
 * | VISIBLE | INVISIBLE
 * | RENAME TO new_name
 * | COALESCE [ CLEANUP ] [ parallel_clause ]
 * | { MONITORING | NOMONITORING } USAGE
 * | UPDATE BLOCK REFERENCES
 * | alter_index_partitioning
 * }
 * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/sqlrf/ALTER-INDEX.html
 *
 * @author kongtong.ouyang onCondition 2018/1/23.
 */
public class SQLAlterIndexStatement extends AbstractSQLStatement implements SQLAlterStatement {

    protected boolean ifExists;

    protected SQLName name;

    protected SQLName onName;

    protected final List<SQLExpr> items = new ArrayList<>();


    public SQLAlterIndexStatement(DBType dbType) {
        super(dbType);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
            this.acceptChild(visitor, onName);
            this.acceptChild(visitor, items);
        }
    }


    @Override
    public SQLAlterIndexStatement clone() {
        SQLAlterIndexStatement x = new SQLAlterIndexStatement(this.dbType);
        this.cloneTo(x);
        return x;
    }

    public void cloneTo(SQLAlterIndexStatement x) {
        super.cloneTo(x);
        x.ifExists = this.ifExists;

        SQLName nameClone = this.name;
        x.setName(nameClone);

        if (this.onName != null) {
            SQLName onNameClone = this.onName.clone();
            x.setName(onNameClone);
        }

        for (SQLExpr item : this.items) {
            SQLExpr itemClone = item.clone();
            x.addItem(itemClone);
        }
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == name
                && target instanceof SQLName) {
            setName((SQLName) target);
            return true;
        }
        if (source == onName
                && target instanceof SQLName) {
            setOnName((SQLName) target);
            return true;
        }

        return false;
    }

    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.ALTER_INDEX;
    }


    public boolean isIfExists() {
        return ifExists;
    }

    public void setIfExists(boolean ifExists) {
        this.ifExists = ifExists;
    }


    public SQLName getName() {
        return name;
    }

    public void setName(SQLName name) {
        setChildParent(name);
        this.name = name;
    }

    public SQLName getOnName() {
        return onName;
    }

    public void setOnName(SQLName onName) {
        setChildParent(onName);
        this.onName = onName;
    }

    public List<SQLExpr> getItems() {
        return items;
    }

    public void addItem(SQLExpr item) {
        if (item == null) {
            return;
        }
        setChildParent(item);
        this.items.add(item);
    }
}
