package com.aliyun.gumiho.sql.bvt.dialect.mysql.element.literal;

import com.aliyun.gumiho.sql.util.MySQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://dev.mysql.com/doc/refman/5.7/en/string-literals.html
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Literals.html#GUID-F521FBA0-FFED-4079-ABC4-9052218B3FD5
 * @author kongtong.ouyang on 2018/5/15.
 */
public class SQLHexadecimalLiteralTest {

    @Test
    public void test1() {
        String sql = "select X'01AF', X'01af', x'01AF', x'01af', 0x01AF, 0x01af\n from dual; ";

        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT X'01AF', X'01af', X'01AF', X'01af', 0x01AF, 0x01af\n" +
                "FROM dual;", format);
    }

}
