package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * OVERFLOW [ TABLESPACE tablespace] | TABLESPACE SET tablespace_set ]
 *
 * partitioning_storage_clause
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-INDEX.html#GUID-1F89BBC0-825F-4215-AF71-7588E31D8BFE
 *
 * @author kongtong.ouyang on 2018/7/9.
 */
public class SQLOverflowClause extends AbstractSQLExpr implements ISQLPartitioningStorageClause {

    protected SQLExpr expr;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, expr);
        }
    }

    @Override
    public SQLOverflowClause clone() {
        SQLOverflowClause x = new SQLOverflowClause();
        if (expr != null) {
            SQLExpr exprClone = this.expr.clone();
            x.setExpr(exprClone);
        }
        return x;
    }

    public SQLExpr getExpr() {
        return expr;
    }

    public void setExpr(SQLExpr expr) {
        setChildParent(expr);
        this.expr = expr;
    }
}
