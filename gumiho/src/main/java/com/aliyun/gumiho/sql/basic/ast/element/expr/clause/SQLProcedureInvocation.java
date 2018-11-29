package com.aliyun.gumiho.sql.basic.ast.element.expr.clause;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.util.SQLUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * procedure [ ( [ parameter [, parameter ]... ] ) ] ;
 * <p>
 * procedure_call
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/block.html#GUID-9ACEB9ED-567E-4E1A-A16A-B8B35214FC9D
 *
 * @author kongtong.ouyang on 2018/6/14.
 */
public class SQLProcedureInvocation extends AbstractSQLExpr {

    protected SQLName name;

    protected final List<SQLExpr> arguments = new ArrayList<>();


    public SQLProcedureInvocation(String name) {
        setName(SQLUtils.ofName(name));
    }

    public SQLProcedureInvocation(SQLName name) {
        setName(name);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
            this.acceptChild(visitor, arguments);
        }
    }

    public SQLName getName() {
        return name;
    }

    public void setName(SQLName name) {
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
        argument.setParent(this);
        this.arguments.add(argument);
    }

}
