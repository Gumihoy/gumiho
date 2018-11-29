package com.aliyun.gumiho.sql.basic.ast.element.expr.clause;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLAssignmentExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * ON DUPLICATE KEY UPDATE assignment [, assignment] ...
 * <p>
 * assignment : column = value
 * https://dev.mysql.com/doc/refman/8.0/en/insert.html
 *
 * @author kongtong.ouyang on 2018/6/12.
 */
public class SQLOnDuplicateKeyUpdateClause extends AbstractSQLExpr {

    private final List<SQLAssignmentExpr> items = new ArrayList<>();

    @Override
    protected void accept0(SQLASTVisitor visitor) {

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
