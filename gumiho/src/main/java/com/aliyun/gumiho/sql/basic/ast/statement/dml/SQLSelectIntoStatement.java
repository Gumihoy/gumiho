package com.aliyun.gumiho.sql.basic.ast.statement.dml;

import com.aliyun.gumiho.sql.basic.ast.element.expr.clause.SQLFromClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.clause.SQLHierarchicalQueryClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.clause.SQLWhereClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.clause.SQLWindowClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.ISQLLockClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.SQLForUpdateClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.SQLSelectItem;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.SQLSelectTargetItem;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.group.SQLGroupByClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.limit.ISQLLimitClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.order.SQLOrderByClause;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLSetQuantifier;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

import java.util.ArrayList;
import java.util.List;

/**
 * SELECT [ <set quantifier> ] <select list> [BULK COLLECT] INTO <select target list> <table expression>
 * <p>
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#select%20statement:%20single%20row
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/SELECT-INTO-statement.html#GUID-6E14E04D-4344-45F3-BE80-979DD26C7A90
 *
 * @author kongtong.ouyang on 2018/5/2.
 */
public class SQLSelectIntoStatement extends AbstractSQLStatement implements SQLDMLStatement {

    private SQLSetQuantifier setQuantifier;

    protected final List<SQLSelectItem> selectItems = new ArrayList<>();

    protected boolean bulkCollect = false;

    protected final List<SQLSelectTargetItem> selectTargetItems = new ArrayList<>();

    protected SQLFromClause fromClause;

    protected SQLWhereClause whereClause;

    protected SQLHierarchicalQueryClause hierarchicalQueryClause;

    protected SQLGroupByClause groupByClause;

    protected SQLWindowClause windowClause;

    protected SQLOrderByClause orderByClause;

    protected ISQLLimitClause limitClause;

    protected ISQLLockClause lockClause;


    public SQLSelectIntoStatement(DBType dbType) {
        super(dbType);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, selectItems);
            this.acceptChild(visitor, selectTargetItems);
            this.acceptChild(visitor, fromClause);
            this.acceptChild(visitor, whereClause);
            this.acceptChild(visitor, hierarchicalQueryClause);
            this.acceptChild(visitor, groupByClause);
            this.acceptChild(visitor, hierarchicalQueryClause);
            this.acceptChild(visitor, windowClause);
            this.acceptChild(visitor, orderByClause);
            this.acceptChild(visitor, limitClause);
            this.acceptChild(visitor, lockClause);
        }
    }

    @Override
    public SQLSelectIntoStatement clone() {
        SQLSelectIntoStatement x = new SQLSelectIntoStatement(this.dbType);
        this.cloneTo(x);
        return x;
    }


    public void cloneTo(SQLSelectIntoStatement x) {
        super.cloneTo(x);

        x.setQuantifier = this.setQuantifier;

        for (SQLSelectItem selectItem : selectItems) {
            SQLSelectItem selectItemClone = selectItem.clone();
            x.addSelectItem(selectItemClone);
        }

        x.bulkCollect = this.bulkCollect;

        for (SQLSelectTargetItem selectTargetItem : selectTargetItems) {
            SQLSelectTargetItem selectTargetItemClone = selectTargetItem.clone();
            x.addSelectTargetItem(selectTargetItemClone);
        }

        SQLFromClause fromClauseClone = this.fromClause.clone();
        x.setFromClause(fromClauseClone);

        if (this.whereClause != null) {
            SQLWhereClause whereClauseClone = this.whereClause.clone();
            x.setWhereClause(whereClauseClone);
        }

        if (this.hierarchicalQueryClause != null) {
            SQLHierarchicalQueryClause hierarchicalQueryClauseClone = this.hierarchicalQueryClause.clone();
            x.setHierarchicalQueryClause(hierarchicalQueryClauseClone);
        }

        if (this.groupByClause != null) {
            SQLGroupByClause groupByClauseClone = this.groupByClause.clone();
            x.setGroupByClause(groupByClauseClone);
        }

        if (this.hierarchicalQueryClause != null) {
            SQLHierarchicalQueryClause hierarchicalQueryClauseClone = this.hierarchicalQueryClause.clone();
            x.setHierarchicalQueryClause(hierarchicalQueryClauseClone);
        }

        if (this.windowClause != null) {
            SQLWindowClause windowClauseClone = this.windowClause.clone();
            x.setWindowClause(windowClauseClone);
        }

        if (this.orderByClause != null) {
            SQLOrderByClause orderByClauseClone = this.orderByClause.clone();
            x.setOrderByClause(orderByClauseClone);
        }
        if (this.limitClause != null) {
            ISQLLimitClause limitClauseClone = this.limitClause.clone();
            x.setLimitClause(limitClauseClone);
        }
        if (this.lockClause != null) {
            ISQLLockClause lockClauseClone = this.lockClause.clone();
            x.setLockClause(lockClauseClone);
        }

    }

    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.SELECT_INTO;
    }




    public SQLSetQuantifier getSetQuantifier() {
        return setQuantifier;
    }

    public void setSetQuantifier(SQLSetQuantifier setQuantifier) {
        this.setQuantifier = setQuantifier;
    }

    public List<SQLSelectItem> getSelectItems() {
        return selectItems;
    }

    public void addSelectItem(SQLSelectItem item) {
        if (item == null) {
            return;
        }
        setChildParent(item);
        this.selectItems.add(item);
    }

    public boolean isBulkCollect() {
        return bulkCollect;
    }

    public void setBulkCollect(boolean bulkCollect) {
        this.bulkCollect = bulkCollect;
    }

    public List<SQLSelectTargetItem> getSelectTargetItems() {
        return selectTargetItems;
    }

    public void addSelectTargetItem(SQLSelectTargetItem item) {
        if (item == null) {
            return;
        }
        setChildParent(item);
        this.selectTargetItems.add(item);
    }

    public SQLFromClause getFromClause() {
        return fromClause;
    }

    public void setFromClause(SQLFromClause fromClause) {
        setChildParent(fromClause);
        this.fromClause = fromClause;
    }

    public SQLWhereClause getWhereClause() {
        return whereClause;
    }

    public void setWhereClause(SQLWhereClause whereClause) {
        setChildParent(whereClause);
        this.whereClause = whereClause;
    }

    public SQLHierarchicalQueryClause getHierarchicalQueryClause() {
        return hierarchicalQueryClause;
    }

    public void setHierarchicalQueryClause(SQLHierarchicalQueryClause hierarchicalQueryClause) {
        setChildParent(hierarchicalQueryClause);
        this.hierarchicalQueryClause = hierarchicalQueryClause;
    }

    public SQLGroupByClause getGroupByClause() {
        return groupByClause;
    }

    public void setGroupByClause(SQLGroupByClause groupByClause) {
        setChildParent(groupByClause);
        this.groupByClause = groupByClause;
    }

    public SQLWindowClause getWindowClause() {
        return windowClause;
    }

    public void setWindowClause(SQLWindowClause windowClause) {
        setChildParent(windowClause);
        this.windowClause = windowClause;
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

    public ISQLLockClause getLockClause() {
        return lockClause;
    }

    public void setLockClause(ISQLLockClause lockClause) {
        setChildParent(lockClause);
        this.lockClause = lockClause;
    }
}
