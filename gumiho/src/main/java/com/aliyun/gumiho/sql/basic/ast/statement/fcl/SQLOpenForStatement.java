package com.aliyun.gumiho.sql.basic.ast.statement.fcl;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.clause.SQLUsingClause;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

/**
 * OPEN expr FOR expr using_clause?
 *
 * @author kongtong.ouyang on 2018/6/9.
 */
public class SQLOpenForStatement extends AbstractSQLStatement {

    protected SQLExpr open;
    protected SQLExpr for_;
    protected SQLUsingClause usingClause;


    public SQLOpenForStatement(DBType dbType) {
        super(dbType);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, open);
            this.acceptChild(visitor, for_);
            this.acceptChild(visitor, usingClause);
        }
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == open) {
            setOpen(target);
            return true;
        }
        if (source == for_) {
            setFor_(target);
            return true;
        }

        return false;
    }

    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.OPEN_FOR;
    }



    public SQLExpr getOpen() {
        return open;
    }

    public void setOpen(SQLExpr open) {
        setChildParent(open);
        this.open = open;
    }

    public SQLExpr getFor_() {
        return for_;
    }

    public void setFor_(SQLExpr for_) {
        setChildParent(for_);
        this.for_ = for_;
    }

    public SQLUsingClause getUsingClause() {
        return usingClause;
    }

    public void setUsingClause(SQLUsingClause usingClause) {
        setChildParent(usingClause);
        this.usingClause = usingClause;
    }



}
