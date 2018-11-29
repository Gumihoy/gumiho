package com.aliyun.gumiho.sql.basic.ast.statement.dal;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLAssignmentExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

import java.util.ArrayList;
import java.util.List;

/**
 * SET variable_assignment [, variable_assignment] ...
 * variable_assignment:
 * user_var_name = expr
 * | param_name = expr
 * | local_var_name = expr
 * | [GLOBAL | SESSION | PERSIST | PERSIST_ONLY]
 * system_var_name = expr
 * | [@@global. | @@session. | @@persist. | @@persist_only. | @@]
 * system_var_name = expr
 * <p>
 * https://dev.mysql.com/doc/refman/8.0/en/set-variable.html
 *
 * @author kongtong.ouyang on 2018/7/26.
 */
public class SQLSetVariableStatement extends AbstractSQLStatement {

    protected final List<SQLAssignmentExpr> items = new ArrayList<>();

    public SQLSetVariableStatement(DBType dbType) {
        super(dbType);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, items);
        }
    }

    @Override
    public SQLSetVariableStatement clone() {
        SQLSetVariableStatement x = new SQLSetVariableStatement(this.dbType);
        for (SQLAssignmentExpr item : items) {
            SQLAssignmentExpr itemClone = item.clone();
            x.addItem(itemClone);
        }
        return x;
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (target == null) {
            boolean replace = replaceInList(items, source, null, this);
            if (replace) {
                return true;
            }

            return false;
        }

        if (target instanceof SQLAssignmentExpr) {
            boolean replace = replaceInList(items, source, (SQLAssignmentExpr) target, this);
            if (replace) {
                return true;
            }
        }

        return false;
    }

    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.SET;
    }

    public List<SQLAssignmentExpr> getItems() {
        return items;
    }

    public void addItem(SQLAssignmentExpr item) {
        if (item == null) {
            return;
        }
        setChildParent(item);
        this.items.add(item);
    }
}
