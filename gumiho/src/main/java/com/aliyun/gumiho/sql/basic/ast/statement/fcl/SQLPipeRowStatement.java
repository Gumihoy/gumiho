package com.aliyun.gumiho.sql.basic.ast.statement.fcl;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

/**
 * PIPE ROW ( row ) ;
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/PIPE-ROW-statement.html#GUID-AD2713A9-062A-42DD-B49E-804C6120378B
 *
 * @author kongtong.ouyang on 2018/6/14.
 */
public class SQLPipeRowStatement extends AbstractSQLStatement {

    protected SQLExpr row;

    public SQLPipeRowStatement(DBType dbType) {
        super(dbType);
    }

    public SQLPipeRowStatement(DBType dbType, SQLExpr row) {
        super(dbType);
        setRow(row);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, row);
        }
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if(source == row) {
            setRow(target);
            return true;
        }
        return false;
    }

    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.PIPE_ROW;
    }


    public SQLExpr getRow() {
        return row;
    }

    public void setRow(SQLExpr row) {
        setChildParent(row);
        this.row = row;
    }
}
