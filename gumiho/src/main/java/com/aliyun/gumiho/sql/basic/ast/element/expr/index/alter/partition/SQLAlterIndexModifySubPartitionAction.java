package com.aliyun.gumiho.sql.basic.ast.element.expr.index.alter.partition;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * MODIFY SUBPARTITION subpartition { UNUSABLE | allocate_extent_clause | deallocate_unused_clause}
 * <p>
 * <p>
 * modify_index_subpartition
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-INDEX.html#GUID-D8F648E7-8C07-4C89-BB71-862512536558
 *
 * @author kongtong.ouyang on 2018/7/10.
 */
public class SQLAlterIndexModifySubPartitionAction extends AbstractSQLExpr implements ISQLAlterIndexPartitionAction {

    protected SQLExpr name;
    protected SQLExpr option;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
            this.acceptChild(visitor, option);
        }
    }

    @Override
    public SQLAlterIndexModifySubPartitionAction clone() {
        SQLAlterIndexModifySubPartitionAction x = new SQLAlterIndexModifySubPartitionAction();

        SQLExpr nameClone = this.name.clone();
        x.setName(nameClone);

        if (this.option != null) {
            SQLExpr optionClone = this.option.clone();
            x.setOption(optionClone);
        }
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

    public SQLExpr getOption() {
        return option;
    }

    public void setOption(SQLExpr option) {
        setChildParent(option);
        this.option = option;
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
