package com.aliyun.gumiho.sql.bvt.dialect.mysql.element.literal;

import com.aliyun.gumiho.sql.util.MySQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://dev.mysql.com/doc/refman/5.7/en/string-literals.html
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Literals.html#GUID-F521FBA0-FFED-4079-ABC4-9052218B3FD5
 * @author kongtong.ouyang on 2018/5/15.
 */
public class SQLBitValuesLiteralTest {

    @Test
    public void test1() {
        String sql = "select b'01', B'01', 0b01 from dual; ";

        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT B'01', B'01', 0b01\n" +
                "FROM dual;", format);
    }

}
