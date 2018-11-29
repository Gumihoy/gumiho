package com.aliyun.gumiho.sql.basic.ast.statement.dal;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

/**
 * SET NAMES {'charset_name' [COLLATE 'collation_name'] | DEFAULT}
 * <p>
 * https://dev.mysql.com/doc/refman/8.0/en/set-names.html
 *
 * @author kongtong.ouyang on 2018/7/26.
 */
public class SQLSetNameStatement extends AbstractSQLStatement {

    protected SQLExpr name;

    public SQLSetNameStatement(DBType dbType) {
        super(dbType);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
        }
    }

    @Override
    public SQLSetNameStatement clone() {
        SQLSetNameStatement x = new SQLSetNameStatement(this.dbType);
        SQLExpr nameClone = this.name.clone();
        x.setName(nameClone);
        return x;
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == name) {
            setName(target);
            return true;
        }
        return false;
    }


    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.SET_NAMES;
    }


    public SQLExpr getName() {
        return name;
    }

    public void setName(SQLExpr name) {
        setChildParent(name);
        this.name = name;
    }
}
