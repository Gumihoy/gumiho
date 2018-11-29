package com.aliyun.gumiho.sql.basic.ast.element.expr.condition;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * NOT expr
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Logical-Conditions.html#GUID-C5E48AF2-3FF9-401D-A104-CDB5FC19E65F
 * https://www.techonthenet.com/oracle/not.php
 *
 * @author kongtong.ouyang on 2018/5/16.
 */
public class SQLNotCondition extends AbstractSQLExpr implements ISQLCondition {

    protected SQLExpr condition;

    public SQLNotCondition(SQLExpr condition) {
        setCondition(condition);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, condition);
        }
    }


    @Override
    public SQLNotCondition clone() {
        SQLExpr conditionClone = this.condition.clone();
        return new SQLNotCondition(conditionClone);
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == condition) {
            setCondition(target);
            return true;
        }
        return false;
    }

    public SQLExpr getCondition() {
        return condition;
    }

    public void setCondition(SQLExpr condition) {
        setChildParent(condition);
        this.condition = condition;
    }
}
