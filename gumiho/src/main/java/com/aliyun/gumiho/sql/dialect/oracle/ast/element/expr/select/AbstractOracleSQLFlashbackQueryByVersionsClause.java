package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.select;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;

/**
 * flashback_query_clause
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/SELECT.html#GUID-CFA006CA-6FF1-4972-821E-6996142A51C6
 *
 * @author kongtong.ouyang on 2018/5/4.
 */
public abstract class AbstractOracleSQLFlashbackQueryByVersionsClause extends AbstractOracleSQLExpr implements OracleSQLFlashbackQueryClause {

    protected SQLExpr minValue;

    protected SQLExpr maxValue;


    @Override
    public OracleSQLFlashbackQueryByAsOfPeriodForClause clone() {
        throw new UnsupportedOperationException(getClass().getName());
    }

    public void cloneTo(AbstractOracleSQLFlashbackQueryByVersionsClause x) {
        super.cloneTo(x);

        SQLExpr minValueClone = minValue.clone();
        x.setMinValue(minValueClone);

        SQLExpr maxValueClone = maxValue.clone();
        x.setMaxValue(maxValueClone);

    }

    public SQLExpr getMinValue() {
        return minValue;
    }

    public void setMinValue(SQLExpr minValue) {
        this.minValue = minValue;
    }

    public SQLExpr getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(SQLExpr maxValue) {
        this.maxValue = maxValue;
    }
}
