package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * xxx [xxx, xxx]
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Model-Expressions.html#GUID-83D3FD56-8346-4D3F-A49E-5FE41FE19257
 *
 * @author kongtong.ouyang on 2018/5/16.
 */
public class SQLArrayExpr extends AbstractSQLExpr {

    protected SQLExpr name;

    protected final List<SQLExpr> arguments = new ArrayList<>();

    @Override
    public SQLArrayExpr clone() {
        SQLArrayExpr x = new SQLArrayExpr();
        this.cloneTo(x);

        SQLExpr nameClone = this.name.clone();
        x.setName(nameClone);

        for (SQLExpr argument : arguments) {
            SQLExpr argumentClone = argument.clone();
            x.addArgument(argumentClone);
        }
        return x;
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
            this.acceptChild(visitor, arguments);
        }
    }

    public SQLExpr getName() {
        return name;
    }

    public void setName(SQLExpr name) {
        setChildParent(name);
        this.name = name;
    }

    public List<SQLExpr> getArguments() {
        return arguments;
    }

    public void addArgument(SQLExpr argument) {
        if (argument == null) {
            return;
        }
        setChildParent(argument);
        this.arguments.add(argument);
    }
}
