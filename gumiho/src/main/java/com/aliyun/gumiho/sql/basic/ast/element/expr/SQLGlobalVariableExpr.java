package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * GLOBAL VARIABLE ： @@variableName
 * <p>
 * https://dev.mysql.com/doc/refman/8.0/en/user-variables.html
 *
 * @author kongtong.ouyang on 2018/7/25.
 */
public class SQLGlobalVariableExpr extends AbstractSQLVariable {

    public SQLGlobalVariableExpr() {
    }

    public SQLGlobalVariableExpr(String name) {
        setName(name);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
        }
    }

    @Override
    public SQLGlobalVariableExpr clone() {
        SQLGlobalVariableExpr x = new SQLGlobalVariableExpr();
        this.cloneTo(x);
        return x;
    }


    @Override
    public String notation() {
        if (notation == null) {
            notation = SQLReserved.AT_SIGN_AT_SIGN.upper + name;
        }
        return notation;
    }

}
