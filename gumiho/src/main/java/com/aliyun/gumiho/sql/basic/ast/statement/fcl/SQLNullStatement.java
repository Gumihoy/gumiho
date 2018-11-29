package com.aliyun.gumiho.sql.basic.ast.statement.fcl;

import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

/**
 * NULL
 *
 * @author kongtong.ouyang on 2018/6/9.
 */
public class SQLNullStatement extends AbstractSQLStatement {

    public SQLNullStatement(DBType dbType) {
        super(dbType);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SQLNullStatement clone() {
        SQLNullStatement x = new SQLNullStatement(this.dbType);
        this.cloneTo(x);
        return x;
    }

    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.NULL;
    }
}
