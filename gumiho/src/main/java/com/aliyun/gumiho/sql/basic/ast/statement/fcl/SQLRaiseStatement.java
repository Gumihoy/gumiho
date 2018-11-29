package com.aliyun.gumiho.sql.basic.ast.statement.fcl;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

/**
 * RAISE [ exception ] ;
 *
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/RAISE-statement.html#GUID-5F58843F-84C8-4768-A7B3-0E318948A88B
 *
 * @author kongtong.ouyang on 2018/6/14.
 */
public class SQLRaiseStatement extends AbstractSQLStatement {

    protected SQLExpr exception;

    public SQLRaiseStatement(DBType dbType) {
        super(dbType);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, exception);
        }
    }

    @Override
    public SQLRaiseStatement clone() {
        SQLRaiseStatement x =new SQLRaiseStatement(this.dbType);
        this.cloneTo(x);
        return x;
    }

    public void cloneTo(SQLRaiseStatement x) {
        super.cloneTo(x);

        if (this.exception != null) {
            SQLExpr exceptionClone = this.exception.clone();
            x.setException(exceptionClone);
        }
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == exception) {
            setException(target);
            return true;
        }
        return false;
    }

    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.RAISE;
    }

    public SQLExpr getException() {
        return exception;
    }

    public void setException(SQLExpr exception) {
        setChildParent(exception);
        this.exception = exception;
    }
}
