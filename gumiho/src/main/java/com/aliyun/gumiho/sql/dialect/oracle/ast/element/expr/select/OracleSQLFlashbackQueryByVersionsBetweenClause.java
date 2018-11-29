package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.select;

import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

/**
 * flashback_query_clause
 * <p>
 * VERSIONS BETWEEN { SCN | TIMESTAMP } { expr | MINVALUE } AND { expr | MAXVALUE }
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/SELECT.html#GUID-CFA006CA-6FF1-4972-821E-6996142A51C6
 *
 * @author kongtong.ouyang on 2018/5/4.
 */
public class OracleSQLFlashbackQueryByVersionsBetweenClause extends AbstractOracleSQLFlashbackQueryByVersionsClause {

    protected SQLReserved type;

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, minValue);
            this.acceptChild(visitor, maxValue);
        }
    }

    @Override
    public OracleSQLFlashbackQueryByAsOfPeriodForClause clone() {
        OracleSQLFlashbackQueryByAsOfPeriodForClause x = new OracleSQLFlashbackQueryByAsOfPeriodForClause();
        return x;
    }


    public SQLReserved getType() {
        return type;
    }

    public void setType(SQLReserved type) {
        this.type = type;
    }
}
