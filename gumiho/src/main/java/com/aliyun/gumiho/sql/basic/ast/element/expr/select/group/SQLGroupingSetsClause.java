package com.aliyun.gumiho.sql.basic.ast.element.expr.select.group;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * grouping_sets_clause : GROUPING SETS <left paren> <grouping set list> <right paren>
 * <p>
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#grouping%20sets%20specification
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/SELECT.html#GUID-CFA006CA-6FF1-4972-821E-6996142A51C6
 *
 * @author kongtong.ouyang on 2018/5/2.
 */
public class SQLGroupingSetsClause extends AbstractSQLExpr {

    protected final List<SQLExpr> arguments = new ArrayList<>();

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, arguments);
        }
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
