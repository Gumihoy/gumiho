package com.aliyun.gumiho.sql.basic.ast.statement.fcl;

import com.aliyun.gumiho.sql.basic.ast.element.expr.ISQLBoundsClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.SQLStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

/**
 * FORALL index IN bounds_clause [ SAVE EXCEPTIONS ] dml_statement;
 *
 * FORALL index IN bounds_clause dml_statement [ SAVE EXCEPTIONS ] ;
 *
 * https://docs.oracle.com/cd/B28359_01/appdev.111/b28370/forall_statement.htm#LNPLS01321
 *
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/FORALL-statement.html#GUID-C45B8241-F9DF-4C93-8577-C840A25963DB
 *
 * @author kongtong.ouyang onCondition 2018/4/4.
 */
public class SQLForAllStatement extends AbstractSQLStatement {

    protected SQLExpr index;

    protected ISQLBoundsClause boundsClause;

    protected boolean beforeSaveExceptions;

    protected SQLStatement statement;

    protected boolean afterSaveExceptions;

    public SQLForAllStatement(DBType dbType) {
        super(dbType);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, index);
            this.acceptChild(visitor, boundsClause);
            this.acceptChild(visitor, statement);
        }
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == index) {
            setIndex(target);
            return true;
        }
        return false;
    }

    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.FOR_ALL;
    }



    public SQLExpr getIndex() {
        return index;
    }

    public void setIndex(SQLExpr index) {
        setChildParent(index);
        this.index = index;
    }

    public ISQLBoundsClause getBoundsClause() {
        return boundsClause;
    }

    public void setBoundsClause(ISQLBoundsClause boundsClause) {
        setChildParent(boundsClause);
        this.boundsClause = boundsClause;
    }


    public boolean isBeforeSaveExceptions() {
        return beforeSaveExceptions;
    }

    public void setBeforeSaveExceptions(boolean beforeSaveExceptions) {
        this.beforeSaveExceptions = beforeSaveExceptions;
    }

    public SQLStatement getStatement() {
        return statement;
    }

    public void setStatement(SQLStatement statement) {
        setChildParent(statement);
        this.statement = statement;
    }

    public boolean isAfterSaveExceptions() {
        return afterSaveExceptions;
    }

    public void setAfterSaveExceptions(boolean afterSaveExceptions) {
        this.afterSaveExceptions = afterSaveExceptions;
    }
}
