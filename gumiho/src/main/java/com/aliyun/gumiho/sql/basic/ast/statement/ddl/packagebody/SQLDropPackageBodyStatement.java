package com.aliyun.gumiho.sql.basic.ast.statement.ddl.packagebody;

import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.SQLStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.SQLCreateStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

/**
 * DROP PACKAGE BODY packageName ;
 *
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/CREATE-PACKAGE-statement.html#GUID-03A70A54-90FF-4293-B6B8-F0B35E184AC5
 *
 * @author kongtong.ouyang on 2018/5/31.
 */
public class SQLDropPackageBodyStatement extends AbstractSQLStatement implements SQLCreateStatement {

    protected SQLName name;

    public SQLDropPackageBodyStatement(DBType dbType) {
        super(dbType);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
        }
    }

    @Override
    public SQLDropPackageBodyStatement clone() {
        SQLDropPackageBodyStatement x=new SQLDropPackageBodyStatement(this.dbType);
        SQLName nameClone = this.name.clone();
        x.setName(nameClone);
        return x;
    }

    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.DROP_PACKAGE_BODY;
    }


    public SQLName getName() {
        return name;
    }

    public void setName(SQLName name) {
        setChildParent(name);
        this.name = name;
    }
}
