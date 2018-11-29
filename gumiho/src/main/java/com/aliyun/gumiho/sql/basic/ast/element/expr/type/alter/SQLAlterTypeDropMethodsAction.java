package com.aliyun.gumiho.sql.basic.ast.element.expr.type.alter;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * DROP { map_order_function_spec | subprogram_spec } [, DROP { map_order_function_spec | subprogram_spec }]
 * <p>
 * alter_method_spec
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/ALTER-TYPE-statement.html#GUID-A8B449E7-E3A8-48F4-A4C6-5BB87B1841CD
 *
 * @author kongtong.ouyang on 2018/9/11.
 */
public class SQLAlterTypeDropMethodsAction extends AbstractSQLExpr implements ISQLAlterTypeAction {

    protected final List<SQLItem> items = new ArrayList<>();

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, items);
        }
    }

    @Override
    public SQLAlterTypeDropMethodsAction clone() {
        SQLAlterTypeDropMethodsAction x = new SQLAlterTypeDropMethodsAction();
        return x;
    }

    public List<SQLItem> getItems() {
        return items;
    }

    public void addItem(SQLItem item) {
        if (item == null) {
            return;
        }
        setChildParent(item);
        this.items.add(item);
    }


    /**
     * DROP { map_order_function_spec | subprogram_spec }
     */
    public static class SQLItem extends AbstractSQLExpr {
        protected SQLExpr method;

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, method);
            }
        }

        public SQLExpr getMethod() {
            return method;
        }

        public void setMethod(SQLExpr method) {
            setChildParent(method);
            this.method = method;
        }
    }
}
