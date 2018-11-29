package com.aliyun.gumiho.sql.basic.ast.statement.fcl;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

/**
 * RETURN [ expression ] ;
 *
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/RETURN-statement.html#GUID-2DCDD1F2-041A-479C-A2F8-B3B68F50FE5D
 *
 * @author kongtong.ouyang onCondition 2018/4/4.
 */
public class SQLReturnStatement extends AbstractSQLStatement {

    protected SQLExpr expr;


    public SQLReturnStatement(DBType dbType) {
        super(dbType);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, expr);
        }
    }

    @Override
    public SQLReturnStatement clone() {
        SQLReturnStatement x = new SQLReturnStatement(this.dbType);

        if (expr != null) {
            SQLExpr exprClone = this.expr.clone();
            x.setExpr(exprClone);
        }
        return x;
    }


    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == expr) {
            this.setExpr(target);
            return true;
        }
        return false;
    }

    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.RETURN;
    }



    public SQLExpr getExpr() {
        return expr;
    }

    public void setExpr(SQLExpr expr) {
        setChildParent(expr);
        this.expr = expr;
    }
}
