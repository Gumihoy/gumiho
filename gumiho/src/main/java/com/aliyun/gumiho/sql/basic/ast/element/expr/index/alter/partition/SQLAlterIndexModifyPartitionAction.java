package com.aliyun.gumiho.sql.basic.ast.element.expr.index.alter.partition;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * MODIFY PARTITION partition
 * { { deallocate_unused_clause
 * | allocate_extent_clause
 * | physical_attributes_clause
 * | logging_clause
 * | index_compression
 * }...
 * | PARAMETERS ('ODCI_parameters')
 * | COALESCE [ CLEANUP ]
 * | UPDATE BLOCK REFERENCES
 * | UNUSABLE
 * }
 * <p>
 * <p>
 * modify_index_partition
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-INDEX.html#GUID-D8F648E7-8C07-4C89-BB71-862512536558
 *
 * @author kongtong.ouyang on 2018/7/10.
 */
public class SQLAlterIndexModifyPartitionAction extends AbstractSQLExpr implements ISQLAlterIndexPartitionAction {

    protected SQLExpr name;
    protected final List<SQLExpr> items = new ArrayList<>();

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
            this.acceptChild(visitor, items);
        }
    }

    @Override
    public SQLAlterIndexModifyPartitionAction clone() {
        SQLAlterIndexModifyPartitionAction x = new SQLAlterIndexModifyPartitionAction();
        SQLExpr nameClone = this.name.clone();
        x.setName(nameClone);
        return x;
    }


    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == name) {
            setName(target);
            return true;
        }

        return false;
    }

    public SQLExpr getName() {
        return name;
    }

    public void setName(SQLExpr name) {
        setChildParent(name);
        this.name = name;
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


    /**
     * COALESCE [ CLEANUP ]
     */
    public static class SQLCoalesceOption extends AbstractSQLExpr {
        protected boolean cleanup;

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            visitor.visit(this);
        }

        @Override
        public SQLCoalesceOption clone() {
            SQLCoalesceOption x = new SQLCoalesceOption();
            x.cleanup = this.cleanup;
            return x;
        }

        public boolean isCleanup() {
            return cleanup;
        }

        public void setCleanup(boolean cleanup) {
            this.cleanup = cleanup;
        }
    }

    /**
     * UPDATE BLOCK REFERENCES
     */
    public static class SQLUpdateBlockReferencesOption extends AbstractSQLExpr {
        @Override
        protected void accept0(SQLASTVisitor visitor) {
            visitor.visit(this);
        }

        @Override
        public SQLUpdateBlockReferencesOption clone() {
            return new SQLUpdateBlockReferencesOption();
        }
    }

    /**
     * UNUSABLE
     */
    public static class SQLUnusableOption extends AbstractSQLExpr {
        @Override
        protected void accept0(SQLASTVisitor visitor) {
            visitor.visit(this);
        }

        @Override
        public SQLUnusableOption clone() {
            return new SQLUnusableOption();
        }
    }

}
