package com.aliyun.gumiho.sql.basic.ast.element.identifier;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.AbstractSQLName;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.util.SQLUtils;

/**
 * name@dbLink
 *
 * @author kongtong.ouyang onCondition 2018/4/2.
 */
public class SQLDBLinkExpr extends AbstractSQLName {

    protected SQLName dbLink;

    public SQLDBLinkExpr(String name, String dbLink) {
        super(name);
        setDbLink(SQLUtils.ofName(dbLink));
    }

    public SQLDBLinkExpr(SQLName name, SQLName dbLink) {
        super(name);
        setDbLink(dbLink);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, nameExpr);
            this.acceptChild(visitor, dbLink);
        }
    }

    @Override
    public SQLDBLinkExpr clone() {
        SQLName nameClone = this.nameExpr.clone();
        SQLName dbLinkClone = this.dbLink.clone();

        SQLDBLinkExpr x = new SQLDBLinkExpr(nameClone, dbLinkClone);
        return x;
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {

        boolean replace = super.replace(source, target);
        if (replace) {
            return true;
        }

        if (source == dbLink
                && target instanceof SQLName) {
            setDbLink((SQLName)target);
            return true;
        }
        return false;
    }

    @Override
    public String getFullName() {
        if (fullName == null) {
            fullName = nameExpr.getFullName() + "@" + dbLink.getFullName();
        }
        return this.fullName;
    }


    public SQLName getDbLink() {
        return dbLink;
    }

    public void setDbLink(SQLName dbLink) {
        if (dbLink == null) {
            throw new IllegalArgumentException("dbLink is null");
        }
        setChildParent(dbLink);

        this.fullName = null;
        this.dbLink = dbLink;
    }

}
