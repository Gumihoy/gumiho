package com.aliyun.gumiho.sql.basic.ast.element.datatype.interval;

import com.aliyun.gumiho.sql.basic.ast.element.datatype.AbstractSQLDataType;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;

/**
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#interval%20type
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/sqlrf/Data-Types.html#GUID-A3C0D836-BADB-44E5-A5D4-265BA5968483
 *
 * @author kongtong.ouyang on 2018/4/19.
 */
public abstract class AbstractSQLIntervalDataType extends AbstractSQLDataType implements ISQLIntervalDataType {

    public AbstractSQLIntervalDataType() {
    }

    public AbstractSQLIntervalDataType(String name) {
        super(name);
    }

    public AbstractSQLIntervalDataType(SQLName name) {
        super(name);
    }
}
