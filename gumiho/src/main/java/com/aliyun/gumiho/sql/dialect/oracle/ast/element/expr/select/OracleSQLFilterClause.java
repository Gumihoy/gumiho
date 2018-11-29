package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.select;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

/**
 * expr TO predicate
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/SELECT.html#GUID-CFA006CA-6FF1-4972-821E-6996142A51C6
 *
 * @author kongtong.ouyang on 2018/5/10.
 */
public class OracleSQLFilterClause extends AbstractOracleSQLExpr {

    protected SQLExpr expr;

    protected SQLExpr predicate;

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
//        if (visitor.visit(this)) {
//            this.acceptChild(visitor, expr);
//            this.acceptChild(visitor, predicate);
//        }
    }

    public SQLExpr getExpr() {
        return expr;
    }

    public void setExpr(SQLExpr expr) {
        setChildParent(expr);
        this.expr = expr;
    }

    public SQLExpr getPredicate() {
        return predicate;
    }

    public void setPredicate(SQLExpr predicate) {
        setChildParent(predicate);
        this.predicate = predicate;
    }

}
