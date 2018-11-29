package com.aliyun.gumiho.sql.basic.ast.element.expr.operator;

import com.aliyun.gumiho.sql.basic.ast.SQLReplaceable;
import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.condition.ISQLCondition;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLBinaryOperator;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/sqlrf/About-SQL-Operators.html#GUID-CF1DBF8D-966F-4E5E-8AC8-9BF777B984D8
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Compound-Expressions.html#GUID-533C7BA0-C8B4-4323-81EA-1379657AF64A
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Multiset-Operators.html#GUID-793FCBB0-A97C-4884-BCAC-DD0542EA746B
 *
 * @author kongtong.ouyang onCondition 2018/4/4.
 */
public class SQLBinaryOperatorGroupExpr extends AbstractSQLExpr implements SQLReplaceable, ISQLCondition {

    private boolean paren = false;
    protected SQLBinaryOperator operator;
    private final List<SQLExpr> items = new ArrayList<>();

    public SQLBinaryOperatorGroupExpr() {
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, items);
        }
    }

    @Override
    public SQLBinaryOperatorGroupExpr clone() {
        SQLBinaryOperatorGroupExpr x = new SQLBinaryOperatorGroupExpr();
        x.operator = this.operator;

        for (SQLExpr item : this.items) {
            SQLExpr itemClone = item.clone();
            x.addItem(itemClone);
        }
        return x;
    }

    public boolean isParen() {
        return paren;
    }

    public void setParen(boolean paren) {
        this.paren = paren;
    }

    public SQLBinaryOperator getOperator() {
        return operator;
    }

    public void setOperator(SQLBinaryOperator operator) {
        this.operator = operator;
    }

    public List<SQLExpr> getItems() {
        return items;
    }

    public void addItem(SQLExpr item) {
        if (item == null) {
            return;
        }
        setChildParent(item);
        this.items.add(item);
    }
}
