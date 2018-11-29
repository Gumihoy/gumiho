package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.select;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

/**
 * flashback_query_clause
 * <p>
 * VERSIONS PERIOD FOR valid_time_column BETWEEN { expr | MINVALUE } AND { expr | MAXVALUE }
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/SELECT.html#GUID-CFA006CA-6FF1-4972-821E-6996142A51C6
 *
 * @author kongtong.ouyang on 2018/5/4.
 */
public class OracleSQLFlashbackQueryByVersionsPeriodForClause extends AbstractOracleSQLFlashbackQueryByVersionsClause implements OracleSQLFlashbackQueryClause {

    protected SQLExpr validTimeColumn;

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, validTimeColumn);
            this.acceptChild(visitor, minValue);
            this.acceptChild(visitor, maxValue);
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
        setChildParent(validTimeColumn);
        this.validTimeColumn = validTimeColumn;
    }
}
