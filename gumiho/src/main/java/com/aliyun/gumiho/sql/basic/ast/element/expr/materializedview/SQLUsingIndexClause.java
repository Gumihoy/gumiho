package com.aliyun.gumiho.sql.basic.ast.element.expr.materializedview;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.constraint.option.ISQLConstraintOption;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.index.SQLCreateIndexStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * USING INDEX   [physical_attributes_clause| TABLESPACE tablespace]...
 * |
 * USING NO INDEX
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-MATERIALIZED-VIEW.html#GUID-EE262CA4-01E5-4618-B659-6165D993CA1B
 *
 * @author kongtong.ouyang on 2018/6/23.
 */
public class SQLUsingIndexClause extends AbstractSQLExpr implements ISQLUsingIndexClause, ISQLConstraintOption {

    protected final List<SQLExpr> items = new ArrayList<>();

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, items);
        }
    }

    @Override
    public SQLUsingIndexClause clone() {
        SQLUsingIndexClause x = new SQLUsingIndexClause();

        for (SQLExpr item : items) {
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

    /**
     * ( create_index_statement )
     * <p>
     * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/constraint.html#GUID-1055EA97-BA6F-4764-A15F-1024FD5B6DFE
     */
    public static class SQLCreateIndexStatementItem extends AbstractSQLExpr {

        protected SQLCreateIndexStatement createIndexStatement;

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, createIndexStatement);
            }
        }

        @Override
        public SQLCreateIndexStatementItem clone() {
            SQLCreateIndexStatementItem x = new SQLCreateIndexStatementItem();
            SQLCreateIndexStatement createIndexStatementClone = this.createIndexStatement.clone();
            x.setCreateIndexStatement(createIndexStatementClone);
            return x;
        }

        public SQLCreateIndexStatement getCreateIndexStatement() {
            return createIndexStatement;
        }

        public void setCreateIndexStatement(SQLCreateIndexStatement createIndexStatement) {
            setChildParent(createIndexStatement);
            this.createIndexStatement = createIndexStatement;
        }
    }
}
