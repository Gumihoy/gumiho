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
package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common.storage;

import com.aliyun.gumiho.sql.basic.ast.element.expr.ISQLLobStorageParameter;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.OracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common.IOracleSQLPhysicalAttributesClause;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common.OracleSQLSizeClause;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * STORAGE ({ INITIAL size_clause | NEXT size_clause | MINEXTENTS integer | MAXEXTENTS { integer | UNLIMITED } | maxsize_clause | PCTINCREASE integer | FREELISTS integer | FREELIST GROUPS integer | OPTIMAL [ size_clause | NULL ] | BUFFER_POOL { KEEP | RECYCLE | DEFAULT } | FLASH_CACHE { KEEP | NONE | DEFAULT } | ENCRYPT } ... )
 * <p>
 * storage_clause
 * <p>
 * https://docs.oracle.com/database/121/SQLRF/clauses009.htm#SQLRF30013
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/storage_clause.html#GUID-C5A67610-3160-41E9-8D48-03206BD5ED15
 *
 * @author kongtong.ouyang onCondition 2018/3/16.
 */
public class OracleSQLStorageClause extends AbstractOracleSQLExpr implements IOracleSQLPhysicalAttributesClause, ISQLLobStorageParameter {

    protected final List<OracleSQLStorageClauseItem> items = new ArrayList<>();

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, items);
        }
    }

    @Override
    public OracleSQLStorageClause clone() {
        OracleSQLStorageClause x = new OracleSQLStorageClause();
        for (OracleSQLStorageClauseItem item : items) {
            OracleSQLStorageClauseItem itemClone = item.clone();
            x.addItem(itemClone);
        }
        return x;
    }


    public List<OracleSQLStorageClauseItem> getItems() {
        return items;
    }

    public void addItem(OracleSQLStorageClauseItem item) {
        if (item == null) {
            return;
        }
        setChildParent(item);
        this.items.add(item);
    }


    public interface OracleSQLStorageClauseItem extends OracleSQLExpr {
        @Override
        OracleSQLStorageClauseItem clone();
    }

    /**
     * INITIAL size_clause
     */
    public static class OracleSQLStorageInitialSizeClause extends AbstractOracleSQLExpr implements OracleSQLStorageClauseItem {

        protected OracleSQLSizeClause sizeClause;

        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, sizeClause);
            }
        }

        @Override
        public OracleSQLStorageInitialSizeClause clone() {
            OracleSQLStorageInitialSizeClause x = new OracleSQLStorageInitialSizeClause();
            OracleSQLSizeClause sizeClauseClone = this.sizeClause.clone();
            x.setSizeClause(sizeClauseClone);
            return x;
        }

        public OracleSQLSizeClause getSizeClause() {
            return sizeClause;
        }

        public void setSizeClause(OracleSQLSizeClause sizeClause) {
            setChildParent(sizeClause);
            this.sizeClause = sizeClause;
        }
    }


    /**
     * NEXT size_clause
     */
    public static class OracleSQLStorageNextSizeClause extends AbstractOracleSQLExpr implements OracleSQLStorageClauseItem {

        protected OracleSQLSizeClause sizeClause;

        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, sizeClause);
            }
        }

        @Override
        public OracleSQLStorageNextSizeClause clone() {
            OracleSQLStorageNextSizeClause x = new OracleSQLStorageNextSizeClause();
            OracleSQLSizeClause sizeClauseClone = this.sizeClause.clone();
            x.setSizeClause(sizeClauseClone);
            return x;
        }

        public OracleSQLSizeClause getSizeClause() {
            return sizeClause;
        }

        public void setSizeClause(OracleSQLSizeClause sizeClause) {
            setChildParent(sizeClause);
            this.sizeClause = sizeClause;
        }
    }

    /**
     * MINEXTENTS integer
     */
    public static class OracleSQLStorageMinExtentsClause extends AbstractOracleSQLExpr implements OracleSQLStorageClauseItem {

        protected SQLExpr value;

        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, value);
            }
        }

        @Override
        public OracleSQLStorageMinExtentsClause clone() {
            OracleSQLStorageMinExtentsClause x = new OracleSQLStorageMinExtentsClause();
            SQLExpr valueClone = this.value.clone();
            x.setValue(valueClone);
            return x;
        }

        public SQLExpr getValue() {
            return value;
        }

        public void setValue(SQLExpr value) {
            setChildParent(value);
            this.value = value;
        }
    }


    /**
     * MAXEXTENTS integer/UNLIMITED
     */
    public static class OracleSQLStorageMaxExtentsClause extends AbstractOracleSQLExpr implements OracleSQLStorageClauseItem {

        protected SQLExpr value;

        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, value);
            }
        }

        @Override
        public OracleSQLStorageMaxExtentsClause clone() {
            OracleSQLStorageMaxExtentsClause x = new OracleSQLStorageMaxExtentsClause();
            SQLExpr valueClone = this.value.clone();
            x.setValue(valueClone);
            return x;
        }

        public SQLExpr getValue() {
            return value;
        }

        public void setValue(SQLExpr value) {
            setChildParent(value);
            this.value = value;
        }
    }

    /**
     * PCTINCREASE integer
     */
    public static class OracleSQLStoragePctIncreaseClause extends AbstractOracleSQLExpr implements OracleSQLStorageClauseItem {

        protected SQLExpr value;

        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, value);
            }
        }

        @Override
        public OracleSQLStoragePctIncreaseClause clone() {
            OracleSQLStoragePctIncreaseClause x = new OracleSQLStoragePctIncreaseClause();
            SQLExpr valueClone = this.value.clone();
            x.setValue(valueClone);
            return x;
        }

        public SQLExpr getValue() {
            return value;
        }

        public void setValue(SQLExpr value) {
            setChildParent(value);
            this.value = value;
        }
    }


    /**
     * FREELISTS integer
     */
    public static class OracleSQLStorageFreeListsClause extends AbstractOracleSQLExpr implements OracleSQLStorageClauseItem {

        protected SQLExpr value;

        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, value);
            }
        }

        @Override
        public OracleSQLStorageFreeListsClause clone() {
            OracleSQLStorageFreeListsClause x = new OracleSQLStorageFreeListsClause();
            SQLExpr valueClone = this.value.clone();
            x.setValue(valueClone);
            return x;
        }

        public SQLExpr getValue() {
            return value;
        }

        public void setValue(SQLExpr value) {
            setChildParent(value);
            this.value = value;
        }
    }

    /**
     * FREELIST GROUPS integer
     */
    public static class OracleSQLStorageFreeListGroupsClause extends AbstractOracleSQLExpr implements OracleSQLStorageClauseItem {

        protected SQLExpr value;

        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, value);
            }
        }

        @Override
        public OracleSQLStorageFreeListGroupsClause clone() {
            OracleSQLStorageFreeListGroupsClause x = new OracleSQLStorageFreeListGroupsClause();
            SQLExpr valueClone = this.value.clone();
            x.setValue(valueClone);
            return x;
        }

        public SQLExpr getValue() {
            return value;
        }

        public void setValue(SQLExpr value) {
            setChildParent(value);
            this.value = value;
        }
    }

    /**
     * Optimal [size_clause|NULL]
     */
    public static class OracleSQLStorageOptimalClause extends AbstractOracleSQLExpr implements OracleSQLStorageClauseItem {

        protected SQLExpr value;

        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, value);
            }
        }

        @Override
        public OracleSQLStorageOptimalClause clone() {
            OracleSQLStorageOptimalClause x = new OracleSQLStorageOptimalClause();

            if (this.value != null) {
                SQLExpr valueClone = this.value.clone();
                x.setValue(valueClone);
            }

            return x;
        }

        public SQLExpr getValue() {
            return value;
        }

        public void setValue(SQLExpr value) {
            setChildParent(value);
            this.value = value;
        }
    }


    /**
     * BUFFER_POOL (KEEP|RECYCLE|DEFAULT)
     */
    public static class OracleSQLStorageBufferPoolClause extends AbstractOracleSQLExpr implements OracleSQLStorageClauseItem {

        protected SQLBufferPoolType type;

        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            visitor.visit(this);
        }

        @Override
        public OracleSQLStorageBufferPoolClause clone() {
            OracleSQLStorageBufferPoolClause x = new OracleSQLStorageBufferPoolClause();
            x.type = this.type;
            return x;
        }

        public SQLBufferPoolType getType() {
            return type;
        }

        public void setType(SQLBufferPoolType type) {
            this.type = type;
        }
    }


    /**
     * FLASH_CACHE { KEEP | NONE | DEFAULT }
     * https://docs.oracle.com/en/database/oracle/oracle-database/18/refrn/ALL_ALL_TABLES.html#GUID-B8CF1D2A-9AA0-4C94-BBBA-4672C7CF735F
     */
    public static class OracleSQLStorageFlashCacheClause extends AbstractOracleSQLExpr implements OracleSQLStorageClauseItem {

        protected SQLFlashCacheType type;

        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            visitor.visit(this);
        }

        @Override
        public OracleSQLStorageFlashCacheClause clone() {
            OracleSQLStorageFlashCacheClause x = new OracleSQLStorageFlashCacheClause();
            x.type = this.type;
            return x;
        }

        public SQLFlashCacheType getType() {
            return type;
        }

        public void setType(SQLFlashCacheType type) {
            this.type = type;
        }
    }

    /**
     * CELL_FLASH_CACHE { KEEP | NONE | DEFAULT }
     * https://docs.oracle.com/en/database/oracle/oracle-database/18/refrn/ALL_ALL_TABLES.html#GUID-B8CF1D2A-9AA0-4C94-BBBA-4672C7CF735F
     */
    public static class OracleSQLStorageCellFlashCacheClause extends AbstractOracleSQLExpr implements OracleSQLStorageClauseItem {

        protected SQLCellFlashCacheType type;

        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            visitor.visit(this);
        }

        @Override
        public OracleSQLStorageCellFlashCacheClause clone() {
            OracleSQLStorageCellFlashCacheClause x = new OracleSQLStorageCellFlashCacheClause();
            x.type = this.type;
            return x;
        }

        public SQLCellFlashCacheType getType() {
            return type;
        }

        public void setType(SQLCellFlashCacheType type) {
            this.type = type;
        }
    }

    /**
     * Encrypt
     */
    public static class OracleSQLStorageEncryptClause extends AbstractOracleSQLExpr implements OracleSQLStorageClauseItem {

        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            visitor.visit(this);
        }

        @Override
        public OracleSQLStorageEncryptClause clone() {
            OracleSQLStorageEncryptClause x = new OracleSQLStorageEncryptClause();
            return x;
        }

    }


    public enum SQLBufferPoolType {
        KEEP(SQLReserved.KEEP),
        RECYCLE(SQLReserved.RECYCLE),
        DEFAULT(SQLReserved.DEFAULT);
        public final SQLReserved name;

        SQLBufferPoolType(SQLReserved name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name.upper;
        }
    }

    public enum SQLFlashCacheType {
        KEEP(SQLReserved.KEEP),
        NONE(SQLReserved.NONE),
        DEFAULT(SQLReserved.DEFAULT);

        public final SQLReserved name;

        SQLFlashCacheType(SQLReserved name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name.upper;
        }
    }

    public enum SQLCellFlashCacheType {
        KEEP(SQLReserved.KEEP),
        NONE(SQLReserved.NONE),
        DEFAULT(SQLReserved.DEFAULT);

        public final SQLReserved name;

        SQLCellFlashCacheType(SQLReserved name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name.upper;
        }
    }
}
