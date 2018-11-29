package com.aliyun.gumiho.sql.basic.ast.element.expr.condition;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * { expr [ NOT ] IN ({ expression_list | subquery }) | ( expr [, expr ]... )[ NOT ] IN ({ expression_list [, expression_list ]...| subquery})}
 * <p>
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#in%20predicate
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/IN-Condition.html#GUID-C7961CB3-8F60-47E0-96EB-BDCF5DB1317C
 *
 * @author kongtong.ouyang on 2018/5/15.
 */
public class SQLInCondition extends AbstractSQLExpr implements ISQLCondition {

    protected SQLExpr expr;

    protected boolean not;

    protected final List<SQLExpr> values = new ArrayList<>();

    public SQLInCondition() {
    }

    public SQLInCondition(SQLExpr expr, SQLExpr... values) {
        setExpr(expr);
        for (SQLExpr value : values) {
         this.addValue(value);
        }
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, expr);
            this.acceptChild(visitor, values);
        }
    }

    @Override
    public SQLInCondition clone() {
        SQLInCondition x = new SQLInCondition();
        this.cloneTo(x);
        return x;
    }


    public void cloneTo(SQLInCondition x) {
        super.cloneTo(x);

        SQLExpr exprClone = this.expr.clone();
        x.setExpr(exprClone);

        for (SQLExpr value : values) {
            SQLExpr valueClone = value.clone();
            this.addValue(valueClone);
        }
    }


    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == expr) {
            this.setExpr(target);
            return true;
        }

        boolean replace = replaceInList(values, source, target, this);
        if (replace) {
            return true;
        }
        return false;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SQLInCondition that = (SQLInCondition) o;

        if (not != that.not) return false;
        if (expr != null ? !expr.equals(that.expr) : that.expr != null) return false;
        return values != null ? values.equals(that.values) : that.values == null;
    }

    @Override
    public int hashCode() {
        int result = expr != null ? expr.hashCode() : 0;
        result = 31 * result + (not ? 1 : 0);
        result = 31 * result + (values != null ? values.hashCode() : 0);
        return result;
    }

    public SQLExpr getExpr() {
        return expr;
    }

    public void setExpr(SQLExpr expr) {
        setChildParent(expr);
        this.expr = expr;
    }

    public boolean isNot() {
        return not;
    }

    public void setNot(boolean not) {
        this.not = not;
    }

    public List<SQLExpr> getValues() {
        return values;
    }

    public void addValue(SQLExpr value) {
        if (value == null) {
            return;
        }
        setChildParent(value);
        this.values.add(value);
    }
    
}
