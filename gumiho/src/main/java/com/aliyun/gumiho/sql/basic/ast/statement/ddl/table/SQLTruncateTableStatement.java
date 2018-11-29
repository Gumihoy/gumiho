package com.aliyun.gumiho.sql.basic.ast.statement.ddl.table;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.enums.ISQLEnum;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLCascadeType;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.SQLObjectType;
import com.aliyun.gumiho.sql.hash.FNVHash;

import java.util.ArrayList;
import java.util.List;

/**
 * TRUNCATE [TABLE] tbl_name
 * https://dev.mysql.com/doc/refman/5.6/en/truncate-table.html
 * <p>
 * TRUNCATE [ TABLE ] [ ONLY ] name [ * ] [, ... ] [RESTART IDENTITY | CONTINUE IDENTITY ] [ CASCADE | RESTRICT ]
 * https://www.postgresql.org/docs/devel/static/sql-truncate.html
 * <p>
 * TRUNCATE TABLE [schema.] table [ {PRESERVE | PURGE} MATERIALIZED VIEW LOG ] [ {DROP [ ALL ] | REUSE} STORAGE ] [ CASCADE ] ;
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/TRUNCATE-TABLE.html
 *
 * @author kongtong.ouyang on 2018/6/4.
 */
public class SQLTruncateTableStatement extends AbstractSQLStatement {

    protected boolean table = true;
    protected boolean only = false;
    protected final List<SQLName> names = new ArrayList<>();

    protected SQLMaterializedViewLogType materializedViewLog;
    protected SQLStorageType storage;
    protected SQLCascadeType cascade;

    public SQLTruncateTableStatement(DBType dbType) {
        super(dbType);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, names);
        }
    }

    @Override
    public SQLTruncateTableStatement clone() {
        SQLTruncateTableStatement x = new SQLTruncateTableStatement(this.dbType);
        this.cloneTo(x);
        return x;
    }

    public void cloneTo(SQLTruncateTableStatement x) {
        super.cloneTo(x);

        x.table = this.table;
        x.only = this.only;

        for (SQLName name : this.names) {
            SQLName nameClone = name.clone();
            x.addName(nameClone);
        }
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (target == null) {
            boolean replace = replaceInList(names, source, null, this);
            if (replace) {
                return true;
            }
            return false;
        }

        if (target instanceof SQLName) {
            boolean replace = replaceInList(names, source, (SQLName) target, this);
            if (replace) {
                return true;
            }
        }

        return false;
    }


    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.TRUNCATE_TABLE;
    }


    public boolean isTable() {
        return table;
    }

    public SQLTruncateTableStatement setTable(boolean table) {
        this.table = table;
        return this;
    }

    public boolean isOnly() {
        return only;
    }

    public SQLTruncateTableStatement setOnly(boolean only) {
        this.only = only;
        return this;
    }

    public List<SQLName> getNames() {
        return names;
    }

    public void addName(SQLName name) {
        if (name == null) {
            return;
        }
        setChildParent(name);
        this.names.add(name);
    }


    public SQLMaterializedViewLogType getMaterializedViewLog() {
        return materializedViewLog;
    }

    public void setMaterializedViewLog(SQLMaterializedViewLogType materializedViewLog) {
        this.materializedViewLog = materializedViewLog;
    }

    public SQLStorageType getStorage() {
        return storage;
    }

    public void setStorage(SQLStorageType storage) {
        this.storage = storage;
    }

    public SQLCascadeType getCascade() {
        return cascade;
    }

    public void setCascade(SQLCascadeType cascade) {
        this.cascade = cascade;
    }

    public enum SQLMaterializedViewLogType implements ISQLEnum {
        PRESERVE_MATERIALIZED_VIEW_LOG(SQLReserved.PRESERVE_MATERIALIZED_VIEW_LOG),
        PURGE_MATERIALIZED_VIEW_LOG(SQLReserved.PURGE_MATERIALIZED_VIEW_LOG),;

        public final SQLReserved name;

        SQLMaterializedViewLogType(SQLReserved name) {
            this.name = name;
        }

        public static SQLMaterializedViewLogType of(String name) {
            long lowerHash = FNVHash.fnv1a_64_lower(name);
            for (SQLMaterializedViewLogType item : SQLMaterializedViewLogType.values()) {
                if (item.name.lowerHashCode64 == lowerHash) {
                    return item;
                }
            }
            return null;
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


    public enum SQLStorageType implements ISQLEnum {
        DROP_STORAGE(SQLReserved.DROP_STORAGE),
        DROP_ALL_STORAGE(SQLReserved.DROP_ALL_STORAGE),
        REUSE_STORAGE(SQLReserved.REUSE_STORAGE),;

        public final SQLReserved name;

        SQLStorageType(SQLReserved name) {
            this.name = name;
        }

        public static SQLStorageType of(String name) {
            long lowerHash = FNVHash.fnv1a_64_lower(name);
            for (SQLStorageType item : SQLStorageType.values()) {
                if (item.name.lowerHashCode64 == lowerHash) {
                    return item;
                }
            }
            return null;
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
