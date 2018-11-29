package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.ast.element.expr.index.attribute.ISQLIndexAttribute;
import com.aliyun.gumiho.sql.basic.ast.enums.ISQLEnum;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * TABLESPACE tablespace
 * <p>
 * TABLESPACE tablespace_name [STORAGE {DISK|MEMORY|DEFAULT}]
 * https://dev.mysql.com/doc/refman/5.6/en/alter-table.html
 *
 * @author kongtong.ouyang on 2018/6/21.
 */
public class SQLTablespaceOptionExpr extends SQLSetOptionExpr implements ISQLSegmentAttributesClause, ISQLLobStorageParameter, ISQLPartitioningStorageClause, ISQLIndexAttribute {

    protected SQLStorageType storage;

    public SQLTablespaceOptionExpr() {
    }

    public SQLTablespaceOptionExpr(SQLExpr value) {
        super(SQLReserved.TABLESPACE.ofExpr(), value);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, value);
        }
    }

    @Override
    public SQLTablespaceOptionExpr clone() {
        SQLTablespaceOptionExpr x = new SQLTablespaceOptionExpr();
        this.cloneTo(x);
        x.storage = this.storage;
        return x;
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == value) {
            setValue(target);
            return true;
        }
        return false;
    }


    public SQLStorageType getStorage() {
        return storage;
    }

    public SQLTablespaceOptionExpr setStorage(SQLStorageType storage) {
        this.storage = storage;
        return this;
    }

    /**
     * STORAGE {DISK|MEMORY|DEFAULT}
     */
    public enum SQLStorageType implements ISQLEnum {
        STORAGE_DISK(SQLReserved.STORAGE_DISK),
        STORAGE_MEMORY(SQLReserved.STORAGE_MEMORY),
        STORAGE_DEFAULT(SQLReserved.STORAGE_DEFAULT),;
        final SQLReserved name;

        SQLStorageType(SQLReserved name) {
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
