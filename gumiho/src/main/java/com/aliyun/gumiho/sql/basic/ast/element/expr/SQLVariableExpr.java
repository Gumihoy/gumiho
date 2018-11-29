package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.ast.element.literal.SQLLiteral;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * question mark: ?
 * <p>
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#dynamic%20parameter%20specification
 *
 * @author kongtong.ouyang onCondition 2018/4/4.
 */
public class SQLVariableExpr extends AbstractSQLExpr implements SQLLiteral {

    public SQLVariableExpr() {
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SQLVariableExpr clone() {
        return new SQLVariableExpr();
    }


    public String getVariable() {
        return SQLReserved.QUESTION_MARK.upper;
    }

    @Override
    public String getValue() {
        return SQLReserved.QUESTION_MARK.upper;
    }


}
