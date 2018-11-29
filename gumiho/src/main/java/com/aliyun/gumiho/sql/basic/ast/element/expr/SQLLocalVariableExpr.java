package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * local variable @variableName
 * https://dev.mysql.com/doc/refman/8.0/en/user-variables.html
 *
 * @author kongtong.ouyang on 2018/7/25.
 */
public class SQLLocalVariableExpr extends AbstractSQLVariable implements ISQLVariable {


    public SQLLocalVariableExpr() {
    }

    public SQLLocalVariableExpr(String name) {
        setName(name);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SQLLocalVariableExpr clone() {
        SQLLocalVariableExpr x = new SQLLocalVariableExpr();
        this.cloneTo(x);
        return x;
    }

    @Override
    public String notation() {
        if (notation == null) {
            notation = SQLReserved.AT_SIGN.upper + name;
        }
        return notation;
    }


}
