package com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.constraint.column;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.enums.ISQLEnum;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * STORAGE {DISK|MEMORY|DEFAULT}
 * https://dev.mysql.com/doc/refman/5.6/en/create-table.html
 *
 * @author kongtong.ouyang on 2018/7/31.
 */
public class SQLStorageColumnConstraint extends AbstractSQLExpr implements ISQLColumnConstraint {

    protected StorageType storageType;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SQLStorageColumnConstraint clone() {
        SQLStorageColumnConstraint x = new SQLStorageColumnConstraint();
        x.storageType = this.storageType;
        return x;
    }

    public StorageType getStorageType() {
        return storageType;
    }

    public void setStorageType(StorageType storageType) {
        this.storageType = storageType;
    }

    /**
     * DISK|MEMORY|DEFAULT
     */
    public enum StorageType implements ISQLEnum {
        DISK(SQLReserved.FIXED),
        MEMORY(SQLReserved.DYNAMIC),
        DEFAULT(SQLReserved.DEFAULT);

        public final SQLReserved name;

        StorageType(SQLReserved name) {
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
