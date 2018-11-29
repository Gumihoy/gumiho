package com.aliyun.gumiho.sql.basic.ast.statement.fcl;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

/**
 * CONTINUE [ label ] [ WHEN boolean-expression ];
 * https://www.postgresql.org/docs/9.3/static/plpgsql-control-structures.html
 *
 * CONTINUE [ label ] [ WHEN expr ] ;
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/CONTINUE-statement.html#GUID-3ED7E5D5-E2D0-42D1-8A7F-97FFC7372775
 *
 * @author kongtong.ouyang on 2018/6/13.
 */
public class SQLContinueStatement extends AbstractSQLStatement {

    protected SQLName name;
    protected SQLExpr condition;

    public SQLContinueStatement(DBType dbType) {
        super(dbType);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
    if (visitor.visit(this)) {
        this.acceptChild(visitor, name);
        this.acceptChild(visitor, condition);
    }
    }

    @Override
    public SQLContinueStatement clone() {
        SQLContinueStatement x = new SQLContinueStatement(this.dbType);
        this.cloneTo(x);
        return x;
    }


    public void cloneTo(SQLContinueStatement x) {
        super.cloneTo(x);

        if (this.name != null) {
            SQLName nameClone = this.name.clone();
            x.setName(nameClone);
        }

        if (this.condition != null) {
            SQLExpr conditionClone = this.condition.clone();
            x.setCondition(conditionClone);
        }
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == name
                && target instanceof SQLName) {
            setName((SQLName) target);
            return true;
        }

        if (source == condition) {
            setCondition(target);
            return true;
        }
        return false;
    }

    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.CONTINUE;
    }


    public SQLName getName() {
        return name;
    }

    public void setName(SQLName name) {
        setChildParent(name);
        this.name = name;
    }

    public SQLExpr getCondition() {
        return condition;
    }

    public void setCondition(SQLExpr condition) {
        setChildParent(condition);
        this.condition = condition;
    }
}
