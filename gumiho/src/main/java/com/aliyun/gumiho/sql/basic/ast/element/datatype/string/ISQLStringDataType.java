package com.aliyun.gumiho.sql.basic.ast.element.datatype.string;

import com.aliyun.gumiho.sql.basic.ast.element.datatype.SQLDataType;

/**
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#predefined%20type
 * <p>
 * https://dev.mysql.com/doc/refman/5.7/en/string-type-overview.html
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/sqlrf/Data-Types.html#GUID-A3C0D836-BADB-44E5-A5D4-265BA5968483
 *
 * @author kongtong.ouyang on 2018/4/19.
 */
public interface ISQLStringDataType extends SQLDataType {

    String getCharacterSetName();

    String getCollationName();
}
