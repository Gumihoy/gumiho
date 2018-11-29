package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.function.numeric;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * abs(n)
 *
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ABS.html#GUID-D8D3489A-44EA-4FEC-A6F0-B5E312FFC231
 *
 * @author kongtong.ouyang on 2018/5/17.
 */
public class OracleSQLAbsFunctionTest {

    @Test
    public void test_0() {
        String sql = "SELECT abs(1) FROM dual;";
        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT abs(1)\n" +
                "FROM dual;", format);
    }

    @Test
    public void test_1() {
        String sql = "SELECT abs(?) FROM dual;";
        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT abs(?)\n" +
                "FROM dual;", format);
    }

}
