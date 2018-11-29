package com.aliyun.gumiho.sql.basic.ast.statement.ddl.table;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

import java.util.ArrayList;
import java.util.List;

/**
 * RENAME TABLE tbl_name TO new_tbl_name [, tbl_name2 TO new_tbl_name2] ...
 * https://dev.mysql.com/doc/refman/8.0/en/rename-table.html
 * <p>
 * RENAME TABLE tbl_name TO new_tbl_name
 * https://help.aliyun.com/document_detail/71318.html?spm=a2c4g.11186623.6.695.7065614bab5dRr
 * <p>
 * RENAME TABLE old_name TO new_name
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/RENAME.html
 *
 * @author kongtong.ouyang on 2018/6/4.
 */
public class SQLRenameTableStatement extends AbstractSQLStatement {

    protected final List<Item> items = new ArrayList<>();

    public SQLRenameTableStatement(DBType dbType) {
        super(dbType);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, items);
        }
    }

    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.RENAME_TABLE;
    }


    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        if (item == null) {
            return;
        }
        setChildParent(item);
        this.items.add(item);
    }


    /**
     * oldName TO newName
     */
    public static class Item extends AbstractSQLExpr {
        protected SQLName oldName;
        protected SQLName newName;

        public Item(SQLName oldName, SQLName newName) {
            setOldName(oldName);
            setNewName(newName);
        }

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, oldName);
                this.acceptChild(visitor, newName);
            }
        }

        @Override
        public Item clone() {
            SQLName oldNameClone = this.oldName.clone();
            SQLName newName = this.newName.clone();
            Item x = new Item(oldNameClone, newName);
            return x;
        }

        public SQLName getOldName() {
            return oldName;
        }

        public void setOldName(SQLName oldName) {
            setChildParent(oldName);
            this.oldName = oldName;
        }

        public SQLName getNewName() {
            return newName;
        }

        public void setNewName(SQLName newName) {
            setChildParent(newName);
            this.newName = newName;
        }
    }

}
