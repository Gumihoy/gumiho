package com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.partition;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.ISQLAlterTableAction;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-TABLE.html#GUID-552E7373-BF93-477D-9DA3-B2C9386F2877
 *
 * @author kongtong.ouyang on 2018/7/11.
 */
public interface ISQLAlterTablePartitionAction extends ISQLAlterTableAction {
    @Override
    ISQLAlterTablePartitionAction clone();


    /**
     * FOR ( name [,name]... )
     */
    class SQLForItem extends AbstractSQLExpr {

        protected final List<SQLExpr> names = new ArrayList<>();

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, names);
            }
        }

        @Override
        public SQLForItem clone() {
            SQLForItem x = new SQLForItem();
            return x;
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
}
