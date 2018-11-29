package com.aliyun.gumiho.sql.basic.ast.element.expr.table;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * FOR EXCHANGE WITH TABLE [ schema .] table }
 * <p>
 * table_properties
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-TABLE.html#GUID-F9CE0CC3-13AE-4744-A43C-EAC7A71AAAB6
 *
 * @author kongtong.ouyang on 2018/7/10.
 */
public class SQLForExchangeWithTableClause extends AbstractSQLExpr {

    protected SQLExpr name;

    public SQLForExchangeWithTableClause(SQLExpr name) {
        setName(name);
    }

    public static SQLForExchangeWithTableClause of(SQLExpr name) {
        return new SQLForExchangeWithTableClause(name);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
        }
    }

    @Override
    public SQLForExchangeWithTableClause clone() {
        SQLExpr nameClone = this.name.clone();
        SQLForExchangeWithTableClause x = new SQLForExchangeWithTableClause(nameClone);
        return x;
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == name) {
            setName(target);
            return true;
        }
        return false;
    }

    public SQLExpr getName() {
        return name;
    }

    public String getTableName() {
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
