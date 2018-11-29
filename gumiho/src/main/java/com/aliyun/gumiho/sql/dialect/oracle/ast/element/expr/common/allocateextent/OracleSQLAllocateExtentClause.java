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
package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common.allocateextent;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.OracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common.OracleSQLSizeClause;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * ALLOCATE EXTENT[ ( { SIZE size_clause | DATAFILE 'filename'| INSTANCE integer} ...)]
 * allocate_extent_clause
 * <p>
 * https://docs.oracle.com/database/121/SQLRF/clauses001.htm#SQLRF30005
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/allocate_extent_clause.html#GUID-DA6B3DC2-84B5-4404-AD96-5ABF7341580F
 *
 * @author kongtong.ouyang onCondition 2018/3/16.
 */
public class OracleSQLAllocateExtentClause extends AbstractOracleSQLExpr {

    protected final List<Item> items = new ArrayList<>();

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, items);

        }
    }

    @Override
    public OracleSQLAllocateExtentClause clone() {
        OracleSQLAllocateExtentClause x = new OracleSQLAllocateExtentClause();

        return x;
    }

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        if (item == null) {
            return;
        }
        setChildParent(item);
        this.items.add(item);
    }


    public interface Item extends OracleSQLExpr {
        @Override
        Item clone();
    }

    /**
     * SIZE size_clause
      */
    public static class OracleSQLAllocateExtentSizeClauseItem extends AbstractOracleSQLExpr implements Item {

        protected OracleSQLSizeClause sizeClause;

        public OracleSQLAllocateExtentSizeClauseItem() {
        }

        public OracleSQLAllocateExtentSizeClauseItem(OracleSQLSizeClause sizeClause) {
            setSizeClause(sizeClause);
        }

        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, sizeClause);
            }
        }

        @Override
        public OracleSQLAllocateExtentSizeClauseItem clone() {
            OracleSQLAllocateExtentSizeClauseItem x = new OracleSQLAllocateExtentSizeClauseItem();
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
     * DATAFILE 'filename'
     */
    public static class OracleSQLAllocateExtentDataFileClauseItem extends AbstractOracleSQLExpr implements Item {

        protected SQLExpr name;

        public OracleSQLAllocateExtentDataFileClauseItem() {
        }

        public OracleSQLAllocateExtentDataFileClauseItem(SQLExpr name) {
            setName(name);
        }

        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, name);
            }
        }

        @Override
        public OracleSQLAllocateExtentDataFileClauseItem clone() {
            OracleSQLAllocateExtentDataFileClauseItem x = new OracleSQLAllocateExtentDataFileClauseItem();
            SQLExpr nameClone = this.name.clone();
            x.setName(nameClone);
            return x;
        }

        public SQLExpr getName() {
            return name;
        }

        public void setName(SQLExpr name) {
            setChildParent(name);
            this.name = name;
        }
    }

    /**
     * INSTANCE integer
     */
    public static class OracleSQLAllocateExtentInstanceClauseItem extends AbstractOracleSQLExpr implements Item {

        protected SQLExpr value;

        public OracleSQLAllocateExtentInstanceClauseItem() {
        }

        public OracleSQLAllocateExtentInstanceClauseItem(SQLExpr value) {
            setValue(value);
        }

        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, value);
            }
        }

        @Override
        public OracleSQLAllocateExtentInstanceClauseItem clone() {
            OracleSQLAllocateExtentInstanceClauseItem x = new OracleSQLAllocateExtentInstanceClauseItem();
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


}
