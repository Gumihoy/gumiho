package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.select;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.SQLTableFunctionTableReference;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * TABLE (expr) [ (+) ]     [flashbackQueryClause]  [pivot]  [alias]
 * Only (  TABLE (expr) [ (+) ]   )   [flashbackQueryClause]  [pivot]  [alias]
 * @author kongtong.ouyang on 2018/6/7.
 */
public class OracleSQLTableFunctionTableReference extends SQLTableFunctionTableReference implements IOracleSQLTableReference {

    protected List<OracleSQLFlashbackQueryClause> flashbackQueryClauses = new ArrayList<>();

    protected SQLExpr pivot;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor instanceof OracleSQLASTVisitor) {
            this.accept0((OracleSQLASTVisitor)visitor);
        } else {
            throw new UnsupportedOperationException(getClass().getName());
        }
    }

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, expr);
            this.acceptChild(visitor, flashbackQueryClauses);
            this.acceptChild(visitor, pivot);
            this.acceptChild(visitor, alias);
        }
    }


    public List<OracleSQLFlashbackQueryClause> getFlashbackQueryClauses() {
        return flashbackQueryClauses;
    }

    public void addFlashbackQueryClause(OracleSQLFlashbackQueryClause flashbackQueryClause) {
        if (flashbackQueryClause == null) {
            return;
        }
        setChildParent(flashbackQueryClause);
        this.flashbackQueryClauses.add(flashbackQueryClause);
    }

    public SQLExpr getPivot() {
        return pivot;
    }

    public void setPivot(SQLExpr pivot) {
        setChildParent(pivot);
        this.pivot = pivot;
    }
}
