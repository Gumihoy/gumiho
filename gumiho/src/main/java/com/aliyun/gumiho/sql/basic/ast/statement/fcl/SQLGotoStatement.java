package com.aliyun.gumiho.sql.basic.ast.statement.fcl;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

/**
 * GOTO label
 *
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/GOTO-statement.html#GUID-89407985-3BA9-4508-9F1F-DE36878B4C89
 *
 * @author kongtong.ouyang on 2018/6/13.
 */
public class SQLGotoStatement extends AbstractSQLStatement {

    protected SQLName name;

    public SQLGotoStatement(DBType dbType) {
        super(dbType);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
        }
    }

    @Override
    public SQLGotoStatement clone() {
        SQLGotoStatement x = new SQLGotoStatement(this.dbType);
        this.cloneTo(x);
        return x;
    }

    public void cloneTo(SQLGotoStatement x) {
        super.cloneTo(x);

        SQLName labelClone = this.name.clone();
        x.setName(labelClone);
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == name
                && target instanceof SQLName) {
            setName((SQLName) target);
            return true;
        }
        return false;
    }

    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.GO_TO;
    }


    public SQLName getName() {
        return name;
    }

    public void setName(SQLName name) {
        setChildParent(name);
        this.name = name;
    }
}
