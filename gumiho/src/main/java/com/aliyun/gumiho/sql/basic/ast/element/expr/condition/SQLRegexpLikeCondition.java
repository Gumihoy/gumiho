package com.aliyun.gumiho.sql.basic.ast.element.expr.condition;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * REGEXP_LIKE(source_char, pattern[, match_param ])
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Pattern-matching-Conditions.html#GUID-D2124F3A-C6E4-4CCA-A40E-2FFCABFD8E19
 *
 * @author kongtong.ouyang on 2018/5/11.
 */
public class SQLRegexpLikeCondition extends AbstractSQLExpr implements ISQLCondition {

    protected final List<SQLExpr> arguments = new ArrayList<>();

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, arguments);
        }
    }

    @Override
    public SQLRegexpLikeCondition clone() {
        SQLRegexpLikeCondition x = new SQLRegexpLikeCondition();
        this.cloneTo(x);
        return x;
    }

    public void cloneTo(SQLRegexpLikeCondition x) {
        super.cloneTo(x);

        for (SQLExpr argument : this.arguments) {
            SQLExpr argumentClone = argument.clone();
            x.addArgument(argumentClone);
        }
    }


    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        boolean replace = replaceInList(arguments, source, target, this);
        if (replace) {
            return true;
        }
        return false;
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
