package com.aliyun.gumiho.sql.basic.ast.element.datatype.datetime;

import com.aliyun.gumiho.sql.basic.ast.element.datatype.AbstractSQLDataType;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLWithTimeZoneType;

/**
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#datetime%20type
 * <p>
 * https://dev.mysql.com/doc/refman/5.7/en/date-and-time-type-overview.html
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/sqlrf/Data-Types.html#GUID-A3C0D836-BADB-44E5-A5D4-265BA5968483
 *
 * @author kongtong.ouyang on 2018/4/19.
 */
public abstract class AbstractSQLDateTimeDataType extends AbstractSQLDataType implements ISQLDateTimeDataType {

    protected SQLWithTimeZoneType withTimeZoneType;


    public AbstractSQLDateTimeDataType(String name) {
        super(name);
    }

    public AbstractSQLDateTimeDataType(SQLName name) {
        super(name);
    }

    public AbstractSQLDateTimeDataType(SQLName name, SQLExpr... args) {
        super(name);
        for (SQLExpr arg : args) {
            this.addArgument(arg);
        }
    }


    public SQLWithTimeZoneType getWithTimeZoneType() {
        return withTimeZoneType;
    }

    public void setWithTimeZoneType(SQLWithTimeZoneType withTimeZoneType) {
        this.withTimeZoneType = withTimeZoneType;
    }
}
