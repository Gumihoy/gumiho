package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.ast.element.datatype.SQLDataType;
import com.aliyun.gumiho.sql.basic.ast.element.expr.clause.SQLDefaultClause;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * <attribute name> <data type> [ <reference scope check> ] [ <attribute default> ] [ <collate clause> ]
 * <p>
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#attribute%20definition
 * <p>
 *
 * externalName : sqlj_object_type_attr
 * https://docs.oracle.com/database/121/LNPLS/create_type.htm#LNPLS01375
 *
 * @author kongtong.ouyang onCondition 2018/4/3.
 */
public class SQLAttributeDefinition extends AbstractSQLExpr {

    protected SQLName name;

    protected SQLDataType dataType;

    protected SQLReferenceScopeCheck referenceScopeCheck;

    protected SQLDefaultClause defaultExpr;

    protected SQLCollateOptionExpr collate;

    protected SQLExpr externalName;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
            this.acceptChild(visitor, dataType);
            this.acceptChild(visitor, defaultExpr);
            this.acceptChild(visitor, collate);
            this.acceptChild(visitor, externalName);
        }
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == name
                && target instanceof SQLName) {
            setName((SQLName) target);
            return true;
        }

        if (source == dataType
                && target instanceof SQLDataType) {
            setDataType((SQLDataType) target);
            return true;
        }

        if (source == externalName) {
            setExternalName(target);
            return true;
        }

        return false;
    }

    public SQLName getName() {
        return name;
    }

    public void setName(SQLName name) {
        setChildParent(name);
        this.name = name;
    }

    public SQLDataType getDataType() {
        return dataType;
    }

    public void setDataType(SQLDataType dataType) {
        setChildParent(dataType);
        this.dataType = dataType;
    }

    public SQLReferenceScopeCheck getReferenceScopeCheck() {
        return referenceScopeCheck;
    }

    public void setReferenceScopeCheck(SQLReferenceScopeCheck referenceScopeCheck) {
        setChildParent(referenceScopeCheck);
        this.referenceScopeCheck = referenceScopeCheck;
    }

    public SQLDefaultClause getDefaultExpr() {
        return defaultExpr;
    }

    public void setDefaultExpr(SQLDefaultClause defaultExpr) {
        setChildParent(defaultExpr);
        this.defaultExpr = defaultExpr;
    }

    public SQLCollateOptionExpr getCollate() {
        return collate;
    }

    public void setCollate(SQLCollateOptionExpr collate) {
        setChildParent(collate);
        this.collate = collate;
    }

    public SQLExpr getExternalName() {
        return externalName;
    }

    public void setExternalName(SQLExpr externalName) {
        setChildParent(externalName);
        this.externalName = externalName;
    }
}
