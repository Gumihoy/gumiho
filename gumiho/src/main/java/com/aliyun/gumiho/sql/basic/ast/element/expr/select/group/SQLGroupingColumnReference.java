package com.aliyun.gumiho.sql.basic.ast.element.expr.select.group;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLCollateOptionExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#grouping%20column%20reference
 * 
 * @author kongtong.ouyang on 2018/5/2.
 */
public class SQLGroupingColumnReference extends AbstractSQLExpr {

    protected SQLExpr columnReference;

    protected SQLCollateOptionExpr collateClause;

    @Override
    protected void accept0(SQLASTVisitor visitor) {

    }


    public SQLExpr getColumnReference() {
        return columnReference;
    }

    public void setColumnReference(SQLExpr columnReference) {
        setChildParent(columnReference);
        this.columnReference = columnReference;
    }

    public SQLCollateOptionExpr getCollateClause() {
        return collateClause;
    }

    public void setCollateClause(SQLCollateOptionExpr collateClause) {
        setChildParent(collateClause);
        this.collateClause = collateClause;
    }
}
