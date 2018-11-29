package com.aliyun.gumiho.sql.basic.ast.statement.ddl.packages;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.SQLCreateStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

/**
 * ALTER PACKAGE [ schema. ] package_name { package_compile_clause | { EDITIONABLE | NONEDITIONABLE } } ;
 * <p>
 * package_compile_clause: COMPILE [ DEBUG ] [ compiler_parameters_clause ... ] [ REUSE SETTINGS ]
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/ALTER-PACKAGE-statement.html#GUID-61273667-8D8F-4E79-9D81-072CFFE3A7F1
 *
 * @author kongtong.ouyang on 2018/5/31.
 */
public class SQLAlterPackageStatement extends AbstractSQLStatement implements SQLCreateStatement {

    protected SQLName name;

    protected SQLExpr option;

    public SQLAlterPackageStatement(DBType dbType) {
        super(dbType);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
            this.acceptChild(visitor, option);
        }
    }


    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.ALTER_PACKAGE;
    }


    public SQLName getName() {
        return name;
    }

    public void setName(SQLName name) {
        setChildParent(name);
        this.name = name;
    }

    public SQLExpr getOption() {
        return option;
    }

    public void setOption(SQLExpr option) {
        setChildParent(option);
        this.option = option;
    }



}
