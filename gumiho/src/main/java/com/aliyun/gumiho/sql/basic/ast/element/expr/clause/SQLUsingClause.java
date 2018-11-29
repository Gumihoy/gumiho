package com.aliyun.gumiho.sql.basic.ast.element.expr.clause;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLParameterModel;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * USING [model] argument [[model] argument]...
 *
 * @author kongtong.ouyang on 2018/6/14.
 */
public class SQLUsingClause extends AbstractSQLExpr {

    protected final List<SQLUsingArgumentClause> arguments = new ArrayList<>();

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, arguments);
        }
    }

    public List<SQLUsingArgumentClause> getArguments() {
        return arguments;
    }

    public void addArgument(SQLUsingArgumentClause argument) {
        if (argument == null) {
            return;
        }
        setChildParent(argument);
        this.arguments.add(argument);
    }

    public static class SQLUsingArgumentClause extends AbstractSQLExpr {

        protected SQLParameterModel model;

        protected SQLExpr expr;

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, expr);
            }
        }

        public SQLParameterModel getModel() {
            return model;
        }

        public void setModel(SQLParameterModel model) {
            this.model = model;
        }

        public SQLExpr getExpr() {
            return expr;
        }

        public void setExpr(SQLExpr expr) {
            setChildParent(expr);
            this.expr = expr;
        }
    }

}
