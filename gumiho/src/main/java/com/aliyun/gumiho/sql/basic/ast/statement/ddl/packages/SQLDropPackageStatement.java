package com.aliyun.gumiho.sql.basic.ast.statement.ddl.packages;

import com.aliyun.gumiho.sql.basic.ast.SQLObject;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.SQLStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.SQLCreateStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

/**
 * DROP PACKAGE [ schema. ] package ;
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/DROP-PACKAGE-statement.html#GUID-91CB731B-471A-409B-A22B-4C1AF9E5903B
 *
 * @author kongtong.ouyang on 2018/5/31.
 */
public class SQLDropPackageStatement extends AbstractSQLStatement implements SQLCreateStatement {

    protected SQLName name;

    public SQLDropPackageStatement(DBType dbType) {
        super(dbType);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
        }
    }

    @Override
    public SQLDropPackageStatement clone() {
        SQLDropPackageStatement x = new SQLDropPackageStatement(this.dbType);
        this.cloneTo(x);
        return x;
    }

    public void cloneTo(SQLDropPackageStatement x) {
        super.cloneTo(x);
        SQLName nameClone = this.name.clone();
        x.setName(nameClone);
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == name) {
            this.setName((SQLName) target);
            return true;
        }
        return false;
    }

    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.DROP_PACKAGE;
    }


    public SQLName getName() {
        return name;
    }

    public void setName(SQLName name) {
        setChildParent(name);
        this.name = name;
    }
}
