package com.aliyun.gumiho.sql.basic.ast.element.function;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

import java.util.List;

/**
 * function [( [[ DISTINCT | ALL ] argument [DEFAULT return_value ON CONVERSION ERROR] [, argument, ...]])]
 * <p>
 * <value expression primary> <period> <method name>  <left paren> [ <SQL argument> [ { <comma> <SQL argument> }... ] ] <right paren>
 * <p>
 * <left paren> <value expression primary> AS <data type> <right paren> <period> <method name> [ <SQL argument list> ]
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#method%20invocation
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Functions.html#GUID-D079EFD3-C683-441F-977E-2C9503089982
 *
 * @author kongtong.ouyang on 2018/4/28.
 */
public class SQLMethodInvocation extends AbstractSQLFunction {

    public SQLMethodInvocation(String name) {
        super(name);
        this.name = name;
    }

    public SQLMethodInvocation(String name, SQLExpr... arguments) {
        super(name);
        this.name = name;
        for (SQLExpr argument : arguments) {
            this.addArgument(argument);
        }
    }

    public SQLMethodInvocation(String name, List<SQLExpr> arguments) {
        super(name);
        this.name = name;
        for (SQLExpr argument : arguments) {
            this.addArgument(argument);
        }
    }

    public SQLMethodInvocation(SQLExpr name) {
        super(name);
    }

    public static SQLMethodInvocation ofNoneParen(String name) {
        SQLMethodInvocation x = new SQLMethodInvocation(name);
        x.setParen(false);
        return x;
    }

    public static SQLMethodInvocation of(SQLExpr name) {
        return new SQLMethodInvocation(name);
    }

    public static SQLMethodInvocation of(String name, SQLExpr... arguments) {
        return new SQLMethodInvocation(name, arguments);
    }

    public static SQLMethodInvocation of(String name, List<SQLExpr> arguments) {
        return new SQLMethodInvocation(name, arguments);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, nameExpr);
            this.acceptChild(visitor, defaultOnConversionError);
            this.acceptChild(visitor, arguments);
        }
    }

    @Override
    public SQLMethodInvocation clone() {
        SQLMethodInvocation x = new SQLMethodInvocation(this.name);
        super.cloneTo(x);
        return x;
    }

    @Override
    public String getName() {
        if (name == null) {
            if (nameExpr instanceof SQLName) {
                this.name = ((SQLName) nameExpr).getName();
            }
        }
        return super.getName();
    }


}
