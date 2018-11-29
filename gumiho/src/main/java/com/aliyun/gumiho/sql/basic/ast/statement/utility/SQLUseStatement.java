package com.aliyun.gumiho.sql.basic.ast.statement.utility;

import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

/**
 * https://dev.mysql.com/doc/refman/8.0/en/use.html
 *
 * @author kongtong.ouyang on 2018/6/4.
 */
public class SQLUseStatement extends AbstractSQLStatement {

    protected SQLName database;

    public SQLUseStatement(DBType dbType) {
        super(dbType);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, database);
        }
    }

    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.USE;
    }

    public SQLName getDatabase() {
        return database;
    }

    public void setDatabase(SQLName database) {
        setChildParent(database);
        this.database = database;
    }
}
