package com.aliyun.gumiho.sql.basic.ast.element.expr.condition;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExprAsObjectExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLReservedIdentifier;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * JSON_EXISTS( expr [ FORMAT JSON ], JSON_basic_path_expression [ JSON_passing_clause] [ JSON_exists_on_error_clause ] )
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/SQL-JSON-Conditions.html#GUID-99B9493D-2929-4A09-BA39-A56F8E7319DA
 *
 * @author kongtong.ouyang on 2018/5/11.
 */
public class SQLJsonExistsCondition extends AbstractSQLExpr implements ISQLCondition{

    protected SQLExpr expr;

    protected boolean formatJson;

    protected SQLExpr pathExpr;

    protected final List<SQLExprAsObjectExpr> jsonPassingClauseItems = new ArrayList<>();

    protected SQLReservedIdentifier onErrorClause;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, expr);
            this.acceptChild(visitor, pathExpr);
            this.acceptChild(visitor, jsonPassingClauseItems);
        }
    }


    @Override
    public SQLJsonExistsCondition clone() {
        SQLJsonExistsCondition x = new SQLJsonExistsCondition();
        this.cloneTo(x);
        return x;
    }

    public void cloneTo(SQLJsonExistsCondition x) {
        super.cloneTo(x);

        SQLExpr exprClone = this.expr.clone();
        x.setExpr(exprClone);

        x.formatJson = this.formatJson;

        SQLExpr pathExprClone = this.pathExpr.clone();
        x.setPathExpr(pathExprClone);

        for (SQLExprAsObjectExpr item : jsonPassingClauseItems) {
            SQLExprAsObjectExpr itemClone = item.clone();
            x.addJsonPassingClauseItem(itemClone);
        }

        x.onErrorClause = this.onErrorClause;
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == expr) {
            setExpr(target);
            return true;
        }

        if (source == pathExpr) {
            setPathExpr(target);
            return true;
        }
        return false;
    }


    public SQLExpr getExpr() {
        return expr;
    }

    public void setExpr(SQLExpr expr) {
        this.expr = expr;
    }

    public boolean isFormatJson() {
        return formatJson;
    }

    public void setFormatJson(boolean formatJson) {
        this.formatJson = formatJson;
    }

    public SQLExpr getPathExpr() {
        return pathExpr;
    }

    public void setPathExpr(SQLExpr pathExpr) {
        this.pathExpr = pathExpr;
    }

    public List<SQLExprAsObjectExpr> getJsonPassingClauseItems() {
        return jsonPassingClauseItems;
    }

    public void addJsonPassingClauseItem(SQLExprAsObjectExpr item) {
        if (item == null) {
            return;
        }
        setChildParent(item);
        this.jsonPassingClauseItems.add(item);
    }

    public SQLReservedIdentifier getOnErrorClause() {
        return onErrorClause;
    }

    public void setOnErrorClause(SQLReservedIdentifier onErrorClause) {
        setChildParent(onErrorClause);
        this.onErrorClause = onErrorClause;
    }


}
