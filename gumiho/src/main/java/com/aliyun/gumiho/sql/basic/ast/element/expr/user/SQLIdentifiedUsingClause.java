package com.aliyun.gumiho.sql.basic.ast.element.expr.user;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * IDENTIFIED USING package
 *
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-ROLE.html#GUID-B2252DC5-5AE7-49B7-9048-98062993E450
 *
 * @author kongtong.ouyang on 2018/6/20.
 */
public class SQLIdentifiedUsingClause extends AbstractSQLExpr {

    protected SQLExpr name;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
        }
    }

    public SQLExpr getName() {
        return name;
    }

    public String getPackageName() {
        if (name instanceof SQLName) {
            return ((SQLName) name).getName();
        }
        return null;
    }

    public void setName(SQLExpr name) {
        setChildParent(name);
        this.name = name;
    }
}
