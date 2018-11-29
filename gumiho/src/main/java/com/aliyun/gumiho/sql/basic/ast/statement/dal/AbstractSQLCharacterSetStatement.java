package com.aliyun.gumiho.sql.basic.ast.statement.dal;

import com.aliyun.gumiho.sql.basic.ast.SQLObject;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.enums.DBType;

/**
 * SET {CHARACTER SET | CHARSET} {'charset_name' | DEFAULT}
 * <p>
 * https://dev.mysql.com/doc/refman/8.0/en/set-character-set.html
 *
 * @author kongtong.ouyang on 2018/7/26.
 */
public abstract class AbstractSQLCharacterSetStatement extends AbstractSQLStatement {

    protected SQLExpr name;

    public AbstractSQLCharacterSetStatement(DBType dbType) {
        super(dbType);
    }

    @Override
    public AbstractSQLCharacterSetStatement clone() {
        throw new UnsupportedOperationException(getClass().getName());
    }

    public void cloneTo(AbstractSQLCharacterSetStatement x) {
        super.cloneTo(x);
        SQLExpr nameClone = this.name.clone();
        x.setName(nameClone);
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == name) {
            setName(name);
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
}
