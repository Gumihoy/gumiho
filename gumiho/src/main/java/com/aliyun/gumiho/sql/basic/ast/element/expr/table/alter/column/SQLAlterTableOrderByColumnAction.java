package com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.column;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.ISQLColumnDefinition;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * ORDER BY col_name [, col_name] ...
 * https://dev.mysql.com/doc/refman/8.0/en/alter-table.html
 *
 * @author kongtong.ouyang on 2018/6/4.
 */
public class SQLAlterTableOrderByColumnAction extends AbstractSQLExpr implements ISQLAlterTableColumnAction {

    protected final List<SQLExpr> names = new ArrayList<>();

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, names);
        }
    }

    @Override
    public SQLAlterTableOrderByColumnAction clone() {
        return null;
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        boolean replace = replaceInList(names, source, target, this);
        if (replace) {
            return true;
        }
        return false;
    }

    public List<SQLExpr> getNames() {
        return names;
    }

    public void addName(SQLExpr name) {
        if (name == null) {
            return;
        }
        setChildParent(name);
        this.names.add(name);
    }


}
