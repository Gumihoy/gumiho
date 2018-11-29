package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * NEW [ schema. ] type_name ([ expr [, expr ]... ])
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Type-Constructor-Expressions.html#GUID-E8A491DE-18BA-4A1E-8CE2-BBA43E5C52D6
 *
 * @author kongtong.ouyang on 2018/5/16.
 */
public class SQLTypeConstructorExpr extends AbstractSQLExpr {

    protected SQLName name;
    protected final List<SQLExpr> arguments = new ArrayList<>();

    public SQLTypeConstructorExpr(SQLName name) {
        setName(name);
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

        setChildParent(argument);
        this.arguments.add(argument);
    }
}
