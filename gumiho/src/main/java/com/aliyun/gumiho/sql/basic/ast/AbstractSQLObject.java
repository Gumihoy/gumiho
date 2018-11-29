package com.aliyun.gumiho.sql.basic.ast;

import com.aliyun.gumiho.sql.basic.visitor.SQLASTOutputVisitor;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;

import java.util.Collection;
import java.util.Iterator;

/**
 * @author kongtong.ouyang on 2018/10/30.
 */
public abstract class AbstractSQLObject implements SQLObject {

    protected DBType dbType;
    protected DBType targetDBType;
    protected SQLObject parent;
    protected boolean afterSemi = false;

    public AbstractSQLObject() {
    }

    @Override
    public final void accept(SQLASTVisitor visitor) {
        if (visitor == null) {
            throw new IllegalArgumentException();
        }

        visitor.preVisit(this);

        accept0(visitor);

        visitor.postVisit(this);
    }

    protected abstract void accept0(SQLASTVisitor visitor);

    @Override
    public SQLObject clone() {
        throw new UnsupportedOperationException(this.getClass().getName());
    }

    @Override
    public void cloneTo(SQLObject x) {
        x.setAfterSemi(this.afterSemi);
    }

    protected final void acceptChild(SQLASTVisitor visitor, Collection<? extends SQLObject> children) {
        if (children == null) {
            return;
        }

        for (Iterator<? extends SQLObject> iterator = children.iterator(); iterator.hasNext(); ) {
            acceptChild(visitor, iterator.next());
        }
    }

    protected final void acceptChild(SQLASTVisitor visitor, SQLObject child) {
        if (child == null) {
            return;
        }

        child.accept(visitor);
    }


    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        output(out);
        return out.toString();
    }

    public void output(StringBuilder out) {
        SQLASTOutputVisitor outputVisitor = SQLUtils.createASTOutputVisitor(out, getDbType(), getTargetDBType());
        this.accept(outputVisitor);
    }

    @Override
    public DBType getDbType() {
        if (dbType != null) {
            return dbType;
        }

        SQLObject parent = this.parent;
        for (; ; ) {
            if (parent == null) {
                return null;
            }

            if (parent.getDbType() != null) {
                this.dbType = parent.getDbType();
                return this.dbType;
            }
            parent = parent.getParent();
        }

    }

    @Override
    public void setDbType(DBType dbType) {
        this.dbType = dbType;
    }


    @Override
    public DBType getTargetDBType() {
        if (targetDBType != null) {
            return targetDBType;
        }

        SQLObject parent = this.parent;
        for (; ; ) {
            if (parent == null) {
                return null;
            }

            if (parent.getTargetDBType() != null) {
                this.targetDBType = parent.getTargetDBType();
                return this.targetDBType;
            }
            parent = parent.getParent();
        }
    }

    @Override
    public void setTargetDBType(DBType targetDBType) {
        this.targetDBType = targetDBType;
    }

    @Override
    public SQLObject getParent() {
        return parent;
    }

    @Override
    public void setParent(SQLObject parent) {
        this.parent = parent;
    }

    public void setChildParent(SQLObject child) {
        if (child == null) {
            return;
        }
        child.setParent(this);
        setChildDBType(child);
    }

    private void setChildDBType(SQLObject child) {
        if (child == null) {
            return;
        }
        child.setDbType(this.getDbType());
    }



    @Override
    public boolean isAfterSemi() {
        return afterSemi;
    }

    @Override
    public void setAfterSemi(boolean afterSemi) {
        this.afterSemi = afterSemi;
    }
}
