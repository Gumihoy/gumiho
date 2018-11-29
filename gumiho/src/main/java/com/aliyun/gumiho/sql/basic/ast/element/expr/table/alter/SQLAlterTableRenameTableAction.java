package com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.enums.ISQLEnum;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * RENAME [TO|AS] new_tbl_name
 * https://dev.mysql.com/doc/refman/8.0/en/alter-table.html
 * <p>
 * RENAME name=nameIdentifier TO newName=nameIdentifier
 *
 * @author kongtong.ouyang on 2018/6/4.
 */
public class SQLAlterTableRenameTableAction extends AbstractSQLExpr implements ISQLAlterTableAction {

    protected SQLName name;
    protected SQLRenameOption to = SQLRenameOption.TO;
    protected SQLName newName;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
            this.acceptChild(visitor, newName);
        }
    }

    @Override
    public SQLAlterTableRenameTableAction clone() {
        SQLAlterTableRenameTableAction x = new SQLAlterTableRenameTableAction();
        x.to = this.to;
        SQLName nameClone = this.name.clone();
        x.setName(nameClone);
        return x;
    }


    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == name
                && target instanceof SQLName) {
            setName((SQLName) target);
            return true;
        }
        return false;
    }

    public SQLName getName() {
        return name;
    }

    public void setName(SQLName name) {
        setChildParent(name);
        this.name = name;
    }


    public SQLRenameOption getTo() {
        return to;
    }

    public void setTo(SQLRenameOption to) {
        this.to = to;
    }

    public SQLName getNewName() {
        return newName;
    }

    public void setNewName(SQLName newName) {
        setChildParent(newName);
        this.newName = newName;
    }

    public enum SQLRenameOption implements ISQLEnum {
        TO(SQLReserved.TO),
        AS(SQLReserved.AS);

        public final SQLReserved name;

        SQLRenameOption(SQLReserved name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name.upper;
        }

        @Override
        public SQLReserved getName() {
            return name;
        }
    }
}
