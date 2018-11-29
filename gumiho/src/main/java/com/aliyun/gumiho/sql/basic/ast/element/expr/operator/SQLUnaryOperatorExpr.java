package com.aliyun.gumiho.sql.basic.ast.element.expr.operator;

import com.aliyun.gumiho.sql.basic.ast.enums.SQLUnaryOperator;
import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * -3
 * (-3)
 * operator operand
 * <p>
 * A unary operator operates onCondition only one operand
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/sqlrf/About-SQL-Operators.html#GUID-CF1DBF8D-966F-4E5E-8AC8-9BF777B984D8
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/About-SQL-Operators.html#GUID-FEF44762-F45C-41D9-B380-F6A61AD25338
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Compound-Expressions.html#GUID-533C7BA0-C8B4-4323-81EA-1379657AF64A
 *
 * @author kongtong.ouyang onCondition 2018/4/4.
 */
public class SQLUnaryOperatorExpr extends AbstractSQLExpr {

    protected boolean paren;

    protected SQLUnaryOperator operator;

    protected SQLExpr operand;

    public SQLUnaryOperatorExpr(SQLUnaryOperator operator, SQLExpr operand) {
        this.operator = operator;
        setOperand(operand);
    }

    public SQLUnaryOperatorExpr(boolean paren, SQLUnaryOperator operator, SQLExpr operand) {
        this.paren = paren;
        this.operator = operator;
        setOperand(operand);
    }

    public static SQLUnaryOperatorExpr of(SQLUnaryOperator operator, SQLExpr operand) {
        return new SQLUnaryOperatorExpr(operator, operand);
    }

    public static SQLUnaryOperatorExpr of(boolean paren, SQLUnaryOperator operator, SQLExpr operand) {
        return new SQLUnaryOperatorExpr(paren, operator, operand);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, operand);
        }
    }

    @Override
    public SQLUnaryOperatorExpr clone() {
        SQLExpr operandClone = this.operand.clone();
        return new SQLUnaryOperatorExpr(this.paren, this.operator, operandClone);
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == operand) {
            setOperand(target);
            return true;
        }
        return false;
    }

    public boolean isParen() {
        return paren;
    }

    public void setParen(boolean paren) {
        this.paren = paren;
    }

    public SQLUnaryOperator getOperator() {
        return operator;
    }

    public void setOperator(SQLUnaryOperator operator) {
        this.operator = operator;
    }

    public SQLExpr getOperand() {
        return operand;
    }

    public void setOperand(SQLExpr operand) {
        setChildParent(operand);
        this.operand = operand;
    }
}
