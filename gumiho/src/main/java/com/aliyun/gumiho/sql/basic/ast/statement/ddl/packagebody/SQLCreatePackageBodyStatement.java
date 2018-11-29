package com.aliyun.gumiho.sql.basic.ast.statement.ddl.packagebody;

import com.aliyun.gumiho.sql.basic.ast.SQLObject;
import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLBody;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.clause.SQLExceptionClause;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLASType;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLEditionAbleType;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.SQLStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.SQLCreateStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

import java.util.ArrayList;
import java.util.List;

/**
 * CREATE [ OR REPLACE ] [ EDITIONABLE | NONEDITIONABLE ] PACKAGE BODY  [ schema. ] package
 * { IS | AS }
 * declare_section
 * [ initialize_section ]
 * END [ package_name ]
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/CREATE-PACKAGE-statement.html#GUID-03A70A54-90FF-4293-B6B8-F0B35E184AC5
 *
 * @author kongtong.ouyang on 2018/5/31.
 */
public class SQLCreatePackageBodyStatement extends AbstractSQLStatement implements SQLCreateStatement {

    protected boolean orReplace;

    protected SQLEditionAbleType editionAbleType;

    protected SQLName name;

    protected SQLASType as = SQLASType.AS;

    protected final List<SQLExpr> items = new ArrayList<>();

    protected final List<SQLBody.SQLBodyItem> bodyItems = new ArrayList<>();

    protected SQLExceptionClause exceptionClause;

    protected SQLName endName;

    public SQLCreatePackageBodyStatement(DBType dbType) {
        super(dbType);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
            this.acceptChild(visitor, items);
            this.acceptChild(visitor, bodyItems);
            this.acceptChild(visitor, exceptionClause);
            this.acceptChild(visitor, endName);
        }
    }

    @Override
    public SQLCreatePackageBodyStatement clone() {
        SQLCreatePackageBodyStatement x = new SQLCreatePackageBodyStatement(this.dbType);
        this.cloneTo(x);
        return x;
    }

    public void cloneTo(SQLCreatePackageBodyStatement x) {
        super.cloneTo(x);
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == name) {
            this.setName((SQLName) target);
            return true;
        }

        if (source == endName) {
            this.setEndName((SQLName) target);
            return true;
        }
        return false;
    }

    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.CREATE_PACKAGE_BODY;
    }



    public boolean isOrReplace() {
        return orReplace;
    }

    public void setOrReplace(boolean orReplace) {
        this.orReplace = orReplace;
    }

    public SQLEditionAbleType getEditionAbleType() {
        return editionAbleType;
    }

    public void setEditionAbleType(SQLEditionAbleType editionAbleType) {
        this.editionAbleType = editionAbleType;
    }

    public SQLName getName() {
        return name;
    }

    public String getPackageName() {
        return name.getName();
    }

    public void setName(SQLName name) {
        setChildParent(name);
        this.name = name;
    }

    public SQLASType getAs() {
        return as;
    }

    public void setAs(SQLASType as) {
        this.as = as;
    }

    public List<SQLExpr> getItems() {
        return items;
    }

    public void addItem(SQLExpr item) {
        if (item == null) {
            return;
        }
        setChildParent(item);
        this.items.add(item);
    }


    public List<SQLBody.SQLBodyItem> getBodyItems() {
        return bodyItems;
    }

    public void addBodyItem(SQLBody.SQLBodyItem bodyItem) {
        if (bodyItem == null) {
            return;
        }
        setChildParent(bodyItem);
        this.bodyItems.add(bodyItem);
    }

    public SQLExceptionClause getExceptionClause() {
        return exceptionClause;
    }

    public void setExceptionClause(SQLExceptionClause exceptionClause) {
        setChildParent(exceptionClause);
        this.exceptionClause = exceptionClause;
    }

    public SQLName getEndName() {
        return endName;
    }

    public void setEndName(SQLName endName) {
        this.endName = endName;
    }
}
