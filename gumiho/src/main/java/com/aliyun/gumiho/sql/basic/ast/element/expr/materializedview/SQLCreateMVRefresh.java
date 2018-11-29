package com.aliyun.gumiho.sql.basic.ast.element.expr.materializedview;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.enums.ISQLEnum;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * create_mv_refresh
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-MATERIALIZED-VIEW.html#GUID-EE262CA4-01E5-4618-B659-6165D993CA1B
 *
 * @author kongtong.ouyang on 2018/6/23.
 */
public class SQLCreateMVRefresh extends AbstractSQLExpr implements ISQLCreateMVRefresh {

    protected final List<SQLCreateMVRefreshItem> items = new ArrayList<>();


    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, items);
        }
    }

    @Override
    public SQLCreateMVRefresh clone() {
        SQLCreateMVRefresh x = new SQLCreateMVRefresh();
        for (SQLCreateMVRefreshItem item : items) {
            SQLCreateMVRefreshItem itemClone = item.clone();
            x.addItem(itemClone);
        }
        return x;
    }


    public List<SQLCreateMVRefreshItem> getItems() {
        return items;
    }

    public void addItem(SQLCreateMVRefreshItem item) {
        if (item == null) {
            return;
        }
        setChildParent(item);
        this.items.add(item);
    }


    public interface SQLCreateMVRefreshItem extends SQLExpr {
        @Override
        SQLCreateMVRefreshItem clone();
    }

    /**
     * FAST
     */
    public static class SQLCreateMVRefreshFastItem extends AbstractSQLExpr implements SQLCreateMVRefreshItem {
        @Override
        protected void accept0(SQLASTVisitor visitor) {
            visitor.visit(this);
        }

        @Override
        public SQLCreateMVRefreshFastItem clone() {
            return new SQLCreateMVRefreshFastItem();
        }
    }

    /**
     * COMPLETE
     */
    public static class SQLCreateMVRefreshCompleteItem extends AbstractSQLExpr implements SQLCreateMVRefreshItem {
        @Override
        protected void accept0(SQLASTVisitor visitor) {
            visitor.visit(this);
        }

        @Override
        public SQLCreateMVRefreshCompleteItem clone() {
            return new SQLCreateMVRefreshCompleteItem();
        }
    }

    /**
     * FORCE
     */
    public static class SQLCreateMVRefreshForceItem extends AbstractSQLExpr implements SQLCreateMVRefreshItem {
        @Override
        protected void accept0(SQLASTVisitor visitor) {
            visitor.visit(this);
        }

        @Override
        public SQLCreateMVRefreshForceItem clone() {
            return new SQLCreateMVRefreshForceItem();
        }
    }


    /**
     * ON DEMAND
     */
    public static class SQLCreateMVRefreshOnDemandItem extends AbstractSQLExpr implements SQLCreateMVRefreshItem {
        @Override
        protected void accept0(SQLASTVisitor visitor) {
            visitor.visit(this);
        }

        @Override
        public SQLCreateMVRefreshOnDemandItem clone() {
            return new SQLCreateMVRefreshOnDemandItem();
        }
    }


    /**
     * ON COMMIT
     */
    public static class SQLCreateMVRefreshOnCommitItem extends AbstractSQLExpr implements SQLCreateMVRefreshItem {
        @Override
        protected void accept0(SQLASTVisitor visitor) {
            visitor.visit(this);
        }

        @Override
        public SQLCreateMVRefreshOnCommitItem clone() {
            return new SQLCreateMVRefreshOnCommitItem();
        }
    }


    /**
     * ON STATEMENT
     */
    public static class SQLCreateMVRefreshOnStatementItem extends AbstractSQLExpr implements SQLCreateMVRefreshItem {
        @Override
        protected void accept0(SQLASTVisitor visitor) {
            visitor.visit(this);
        }

        @Override
        public SQLCreateMVRefreshOnStatementItem clone() {
            return new SQLCreateMVRefreshOnStatementItem();
        }
    }


    /**
     * START WITH expr
     */
    public static class SQLCreateMVRefreshStartWithItem extends AbstractSQLExpr implements SQLCreateMVRefreshItem {

        protected SQLExpr value;

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, value);
            }
        }

        @Override
        public SQLCreateMVRefreshStartWithItem clone() {
            SQLCreateMVRefreshStartWithItem x = new SQLCreateMVRefreshStartWithItem();
            SQLExpr valueClone = this.value.clone();
            x.setValue(valueClone);
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

        public SQLExpr getValue() {
            return value;
        }

        public void setValue(SQLExpr value) {
            setChildParent(value);
            this.value = value;
        }
    }


    /**
     * NEXT expr
     */
    public static class SQLCreateMVRefreshNextItem extends AbstractSQLExpr implements SQLCreateMVRefreshItem {

        protected SQLExpr value;

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, value);
            }
        }

        @Override
        public SQLCreateMVRefreshNextItem clone() {
            SQLCreateMVRefreshNextItem x = new SQLCreateMVRefreshNextItem();
            SQLExpr valueClone = this.value.clone();
            x.setValue(valueClone);
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

        public SQLExpr getValue() {
            return value;
        }

        public void setValue(SQLExpr value) {
            setChildParent(value);
            this.value = value;
        }
    }


    /**
     * WITH PRIMARY KEY
     */
    public static class SQLCreateMVRefreshWithPrimaryKeyItem extends AbstractSQLExpr implements SQLCreateMVRefreshItem {
        @Override
        protected void accept0(SQLASTVisitor visitor) {
            visitor.visit(this);
        }

        @Override
        public SQLCreateMVRefreshWithPrimaryKeyItem clone() {
            return new SQLCreateMVRefreshWithPrimaryKeyItem();
        }
    }


    /**
     * WITH ROWID
     */
    public static class SQLCreateMVRefreshWithRowidItem extends AbstractSQLExpr implements SQLCreateMVRefreshItem {
        @Override
        protected void accept0(SQLASTVisitor visitor) {
            visitor.visit(this);
        }

        @Override
        public SQLCreateMVRefreshWithRowidItem clone() {
            return new SQLCreateMVRefreshWithRowidItem();
        }
    }

    /**
     * USING { DEFAULT [ MASTER | LOCAL ] ROLLBACK SEGMENT | [ MASTER | LOCAL ] ROLLBACK SEGMENT rollback_segment }...
     */
    public static class SQLCreateMVRefreshUsingRollbackSegmentItem extends AbstractSQLExpr implements SQLCreateMVRefreshItem {

        protected final List<SQLExpr> items = new ArrayList<>();

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, items);
            }

        }

        @Override
        public SQLCreateMVRefreshUsingRollbackSegmentItem clone() {
            SQLCreateMVRefreshUsingRollbackSegmentItem x = new SQLCreateMVRefreshUsingRollbackSegmentItem();
            for (SQLExpr item : this.items) {
                SQLExpr itemClone = item.clone();
                x.addItem(itemClone);
            }
            return x;
        }

        @Override
        public boolean replace(SQLExpr source, SQLExpr target) {
            boolean replace = replaceInList(items, source, target, this);
            if (replace) {
                return true;
            }
            return false;
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

    /**
     * DEFAULT [ MASTER | LOCAL ] ROLLBACK SEGMENT
     */
    public static class SQLUsingRollbackSegmentByDefaultItem extends AbstractSQLExpr {
        protected SQLUsingRollbackSegmentOptionType optionType;
        @Override
        protected void accept0(SQLASTVisitor visitor) {
            visitor.visit(this);
        }

        @Override
        public SQLUsingRollbackSegmentByDefaultItem clone() {
            return new SQLUsingRollbackSegmentByDefaultItem();
        }

        public SQLUsingRollbackSegmentOptionType getOptionType() {
            return optionType;
        }

        public void setOptionType(SQLUsingRollbackSegmentOptionType optionType) {
            this.optionType = optionType;
        }
    }

    /**
     * [ MASTER | LOCAL ] ROLLBACK SEGMENT rollback_segment
     */
    public static class SQLUsingRollbackSegmentByNoDefaultItem extends AbstractSQLExpr {

        protected SQLUsingRollbackSegmentOptionType optionType;
        protected SQLName name;

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            if(visitor.visit(this)) {
                this.acceptChild(visitor, name);
            }
        }

        @Override
        public SQLUsingRollbackSegmentByNoDefaultItem clone() {
            SQLUsingRollbackSegmentByNoDefaultItem x = new SQLUsingRollbackSegmentByNoDefaultItem();
            SQLName nameClone = this.name.clone();
            x.setName(nameClone);
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

        public SQLUsingRollbackSegmentOptionType getOptionType() {
            return optionType;
        }

        public void setOptionType(SQLUsingRollbackSegmentOptionType optionType) {
            this.optionType = optionType;
        }

        public SQLName getName() {
            return name;
        }

        public void setName(SQLName name) {
            setChildParent(name);
            this.name = name;
        }
    }

    public enum SQLUsingRollbackSegmentOptionType implements ISQLEnum {
        MASTER(SQLReserved.MASTER),
        LOCAL(SQLReserved.LOCAL),;
        public final SQLReserved name;

        SQLUsingRollbackSegmentOptionType(SQLReserved name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name.upper;
        }

        @Override
        public SQLReserved getName() {
            return name;
        }
    }

    /**
     * USING ENFORCED CONSTRAINTS
     */
    public static class SQLCreateMVRefreshUsingEnforcedConstraintsItem extends AbstractSQLExpr implements SQLCreateMVRefreshItem {
        @Override
        protected void accept0(SQLASTVisitor visitor) {
            visitor.visit(this);
        }

        @Override
        public SQLCreateMVRefreshUsingEnforcedConstraintsItem clone() {
            return new SQLCreateMVRefreshUsingEnforcedConstraintsItem();
        }
    }

    /**
     * USING TRUSTED CONSTRAINTS
     */
    public static class SQLCreateMVRefreshUsingTrustedConstraintsItem extends AbstractSQLExpr implements SQLCreateMVRefreshItem {
        @Override
        protected void accept0(SQLASTVisitor visitor) {
            visitor.visit(this);
        }

        @Override
        public SQLCreateMVRefreshUsingTrustedConstraintsItem clone() {
            return new SQLCreateMVRefreshUsingTrustedConstraintsItem();
        }
    }
}
