package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * UNDER <table name>
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#subview%20clause
 * <p>
 * <p>
 * UNDER [ schema. ] superview
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-VIEW.html#GUID-61D2D2B4-DACC-4C7C-89EB-7E50D9594D30
 *
 * @author kongtong.ouyang on 2018/7/13.
 */
public class SQLSubViewClause extends AbstractSQLExpr {

    protected SQLName name;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
        }
    }

    @Override
    public SQLSubViewClause clone() {
        SQLSubViewClause x = new SQLSubViewClause();
        SQLName nameClone = this.name.clone();
        x.setName(nameClone);
        return x;
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

    public SQLName getName() {
        return name;
    }

    public void setName(SQLName name) {
        setChildParent(name);
        this.name = name;
    }
}
