package com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.column;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.ISQLAlterTableAction;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * @author kongtong.ouyang on 2018/7/11.
 */
public interface ISQLAlterTableColumnAction extends ISQLAlterTableAction {
    @Override
    ISQLAlterTableColumnAction clone();


    /**
     * FIRST
     * https://dev.mysql.com/doc/refman/8.0/en/alter-table.html
     */
    class SQLFirstPropertyExpr extends AbstractSQLExpr {

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            if (visitor.visit(this)) {
            }
        }
    }

    /**
     * AFTER name
     * https://dev.mysql.com/doc/refman/8.0/en/alter-table.html
     */
    class SQLAfterPropertyExpr extends AbstractSQLExpr {
        protected SQLName name;

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, name);
            }
        }

        public SQLName getName() {
            return name;
        }

        public void setName(SQLName name) {
            setChildParent(name);
            this.name = name;
        }
    }
}
