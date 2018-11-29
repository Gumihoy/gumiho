package com.aliyun.gumiho.sql.basic.ast.element.function.window;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.clause.SQLPartitionByClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.order.SQLOrderByClause;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * [ <existing window name> ] [ <window partition clause> ] [ <window order clause> ] [ <window frame clause> ]
 * <p>
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#window%20specification
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Analytic-Functions.html#GUID-527832F7-63C0-4445-8C16-307FA5084056
 *
 * @author kongtong.ouyang on 2018/4/27.
 */
public class SQLWindowSpecification extends AbstractSQLExpr {

    protected SQLName name;

    protected SQLPartitionByClause partitionClause;

    protected SQLOrderByClause orderByClause;

    protected SQLWindowFrameClause windowFrameClause;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
            this.acceptChild(visitor, partitionClause);
            this.acceptChild(visitor, orderByClause);
            this.acceptChild(visitor, windowFrameClause);
        }
    }

    @Override
    public SQLWindowSpecification clone() {
        SQLWindowSpecification x = new SQLWindowSpecification();
        this.cloneTo(x);
        return x;
    }

    public void cloneTo(SQLWindowSpecification x) {
        super.cloneTo(x);

        SQLName nameClone = this.name.clone();
        x.setName(nameClone);

        SQLPartitionByClause partitionClauseClone = this.partitionClause.clone();
        x.setPartitionClause(partitionClauseClone);

        SQLOrderByClause orderByClauseClone = this.orderByClause.clone();
        x.setOrderByClause(orderByClauseClone);

        SQLWindowFrameClause windowFrameClauseClone = this.windowFrameClause.clone();
        x.setWindowFrameClause(windowFrameClauseClone);
    }

    public SQLName getName() {
        return name;
    }

    public void setName(SQLName name) {
        setChildParent(name);
        this.name = name;
    }

    public SQLPartitionByClause getPartitionClause() {
        return partitionClause;
    }

    public void setPartitionClause(SQLPartitionByClause partitionClause) {
        setChildParent(partitionClause);
        this.partitionClause = partitionClause;
    }

    public SQLOrderByClause getOrderByClause() {
        return orderByClause;
    }

    public void setOrderByClause(SQLOrderByClause orderByClause) {
        setChildParent(orderByClause);
        this.orderByClause = orderByClause;
    }

    public SQLWindowFrameClause getWindowFrameClause() {
        return windowFrameClause;
    }

    public void setWindowFrameClause(SQLWindowFrameClause windowFrameClause) {
        setChildParent(windowFrameClause);
        this.windowFrameClause = windowFrameClause;
    }
}
