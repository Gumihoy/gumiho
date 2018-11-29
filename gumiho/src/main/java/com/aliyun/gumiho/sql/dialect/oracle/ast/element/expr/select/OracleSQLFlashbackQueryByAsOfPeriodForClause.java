package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.select;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

/**
 * flashback_query_clause
 *
 * AS OF PERIOD FOR valid_time_column expr
 *
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/SELECT.html#GUID-CFA006CA-6FF1-4972-821E-6996142A51C6
 *
 * @author kongtong.ouyang on 2018/5/4.
 */
public class OracleSQLFlashbackQueryByAsOfPeriodForClause extends AbstractOracleSQLExpr implements OracleSQLFlashbackQueryClause {

    protected SQLExpr validTimeColumn;

    protected SQLExpr expr;

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, validTimeColumn);
            this.acceptChild(visitor, expr);
        }
    }

    @Override
    public OracleSQLFlashbackQueryByAsOfPeriodForClause clone() {
        OracleSQLFlashbackQueryByAsOfPeriodForClause x = new OracleSQLFlashbackQueryByAsOfPeriodForClause();
        return x;
    }

    public SQLExpr getValidTimeColumn() {
        return validTimeColumn;
    }

    public void setValidTimeColumn(SQLExpr validTimeColumn) {
        this.validTimeColumn = validTimeColumn;
    }

    public SQLExpr getExpr() {
        return expr;
    }

    public void setExpr(SQLExpr expr) {
        this.expr = expr;
    }
}
