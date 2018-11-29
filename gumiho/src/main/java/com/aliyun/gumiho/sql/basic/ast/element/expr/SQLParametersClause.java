package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * PARAMETERS ( ' { XMLIndex_parameters | PARAM identifier } ' )
 *
 * XMLIndex_parameters_clause
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/adxdb/indexes-for-XMLType-data.html#GUID-24AAD47C-7D5C-4A61-B1F4-DD1F27D8A393
 * @author kongtong.ouyang on 2018/7/9.
 */
public class SQLParametersClause extends AbstractSQLExpr {

    protected SQLExpr expr;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, expr);
        }
    }

    @Override
    public SQLParametersClause clone() {
        SQLParametersClause x = new SQLParametersClause();
        SQLExpr exprClone = this.expr.clone();
        x.setExpr(exprClone);
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
