package com.aliyun.gumiho.sql.basic.ast.statement.utility;

import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.SQLStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

/**
 *
 * https://dev.mysql.com/doc/refman/8.0/en/explain.html
 *
 * https://www.postgresql.org/docs/devel/static/sql-explain.html
 *
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/EXPLAIN-PLAN.html#GUID-FD540872-4ED3-4936-96A2-362539931BA0
 *
 * @author kongtong.ouyang on 2018/6/4.
 */
public class SQLExplainStatement extends AbstractSQLStatement {

    protected SQLStatement statement;

    public SQLExplainStatement(DBType dbType) {
        super(dbType);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, statement);
        }
    }

    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.EXPLAIN;
    }


    public SQLStatement getStatement() {
        return statement;
    }

    public void setStatement(SQLStatement statement) {
        setChildParent(statement);
        this.statement = statement;
    }
}
