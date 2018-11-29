package com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLFilterCondition;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.SQLUpdateIndexesClause;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * MOVE [ filter_condition ] [ ONLINE ] [ segment_attributes_clause ] [ table_compression ] [ index_org_table_clause ] [ { LOB_storage_clause | varray_col_properties }... ] [ parallel_clause ] [ allow_disallow_clustering ] [ UPDATE INDEXES [ ( index { segment_attributes_clause | update_index_partition } [, index { segment_attributes_clause | update_index_partition } ]... ) ] ]
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-TABLE.html#GUID-552E7373-BF93-477D-9DA3-B2C9386F2877
 *
 * @author kongtong.ouyang on 2018/7/11.
 */
public class SQLAlterTableMoveTableAction extends AbstractSQLExpr implements ISQLAlterTableAction {

    protected SQLFilterCondition filterCondition;
    protected boolean online;
    protected final List<SQLExpr> properties = new ArrayList<>();
    protected SQLUpdateIndexesClause updateIndexes;


    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, filterCondition);
            this.acceptChild(visitor, properties);
            this.acceptChild(visitor, updateIndexes);
        }
    }

    @Override
    public SQLAlterTableMoveTableAction clone() {
        SQLAlterTableMoveTableAction x = new SQLAlterTableMoveTableAction();
        return x;
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        return false;
    }

    public SQLFilterCondition getFilterCondition() {
        return filterCondition;
    }

    public void setFilterCondition(SQLFilterCondition filterCondition) {
        setChildParent(filterCondition);
        this.filterCondition = filterCondition;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public List<SQLExpr> getProperties() {
        return properties;
    }

    public void addProperty(SQLExpr property) {
        if (property == null) {
            return;
        }
        setChildParent(property);
        this.properties.add(property);
    }

    public SQLUpdateIndexesClause getUpdateIndexes() {
        return updateIndexes;
    }

    public void setUpdateIndexes(SQLUpdateIndexesClause updateIndexes) {
        setChildParent(updateIndexes);
        this.updateIndexes = updateIndexes;
    }


    /**
     * index { segment_attributes_clause | update_index_partition }
     */
    public static class SQLUpdateIndexItem extends AbstractSQLExpr {

        protected SQLExpr name;
        protected final List<SQLExpr> properties = new ArrayList<>();

        @Override
        protected void accept0(SQLASTVisitor visitor) {

        }

        @Override
        public SQLExpr clone() {
            return super.clone();
        }

        public SQLExpr getName() {
            return name;
        }

        public void setName(SQLExpr name) {
            this.name = name;
        }

        public List<SQLExpr> getProperties() {
            return properties;
        }

        public void addName(SQLName property) {
            if (property == null) {
                return;
            }
            setChildParent(property);
            this.properties.add(property);
        }
    }
}
