package com.aliyun.gumiho.sql.basic.ast.statement.ddl.packagebody;

import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.SQLCreateStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

/**
 *
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/CREATE-PACKAGE-statement.html#GUID-03A70A54-90FF-4293-B6B8-F0B35E184AC5
 *
 * @author kongtong.ouyang on 2018/5/31.
 */
public class SQLAlterPackageBodyStatement extends AbstractSQLStatement implements SQLCreateStatement {


    public SQLAlterPackageBodyStatement(DBType dbType) {
        super(dbType);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {

        }
    }

    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.ALTER_PACKAGE_BODY;
    }

}
