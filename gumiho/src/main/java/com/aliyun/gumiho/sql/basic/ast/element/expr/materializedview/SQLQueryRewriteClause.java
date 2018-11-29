package com.aliyun.gumiho.sql.basic.ast.element.expr.materializedview;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLUnusableEditionsClause;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLEnableType;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * { ENABLE | DISABLE } QUERY REWRITE [ unusable_editions_clause ]
 *
 * query_rewrite_clause
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-MATERIALIZED-VIEW.html#GUID-EE262CA4-01E5-4618-B659-6165D993CA1B
 *
 * @author kongtong.ouyang on 2018/6/23.
 */
public class SQLQueryRewriteClause extends AbstractSQLExpr {

    protected SQLEnableType action;
    protected SQLUnusableEditionsClause unusableEditionsClause;


    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, unusableEditionsClause);
        }
    }

    @Override
    public SQLQueryRewriteClause clone() {
        SQLQueryRewriteClause x= new SQLQueryRewriteClause();
        x.action = this.action;

        if (unusableEditionsClause != null) {
            SQLUnusableEditionsClause unusableEditionsClauseClone = this.unusableEditionsClause.clone();
            x.setUnusableEditionsClause(unusableEditionsClauseClone);
        }
        return x;
    }

    public SQLEnableType getAction() {
        return action;
    }

    public void setAction(SQLEnableType action) {
        this.action = action;
    }

    public SQLUnusableEditionsClause getUnusableEditionsClause() {
        return unusableEditionsClause;
    }

    public void setUnusableEditionsClause(SQLUnusableEditionsClause unusableEditionsClause) {
        setChildParent(unusableEditionsClause);
        this.unusableEditionsClause = unusableEditionsClause;
    }
}
