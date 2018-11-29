package com.aliyun.gumiho.sql.basic.ast.statement.fcl;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

/**
 * @author kongtong.ouyang onCondition 2018/4/4.
 */
public class SQLLeaveStatement extends AbstractSQLStatement {



    public SQLLeaveStatement(DBType dbType) {
        super(dbType);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {

    }

    @Override
    public SQLLeaveStatement clone() {
        SQLLeaveStatement x = new SQLLeaveStatement(this.dbType);

        return x;
    }

    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.LEAVE;
    }

}
