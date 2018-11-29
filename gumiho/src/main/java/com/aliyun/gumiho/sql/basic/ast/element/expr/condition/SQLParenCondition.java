package com.aliyun.gumiho.sql.basic.ast.element.expr.condition;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * (condition)
 *
 * @author kongtong.ouyang on 2018/5/17.
 */
public class SQLParenCondition extends AbstractSQLExpr implements ISQLCondition {

    protected ISQLCondition condition;

    public SQLParenCondition(ISQLCondition condition) {
        setCondition(condition);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, condition);
        }
    }


    @Override
    public SQLParenCondition clone() {
        ISQLCondition conditionClone = condition.clone();

        SQLParenCondition x = new SQLParenCondition(conditionClone);
        return x;
    }

    public ISQLCondition getCondition() {
        return condition;
    }

    public void setCondition(ISQLCondition condition) {
        setChildParent(condition);
        this.condition = condition;
    }
}
