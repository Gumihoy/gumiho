package com.aliyun.gumiho.sql.bvt.dialect.mysql.element.function.conversion;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/TO_CHAR-datetime.html#GUID-0C3EEFD1-AE3D-452D-BF23-2FC95664E78F
 *
 * @author kongtong.ouyang on 2018/5/17.
 */
public class SQLToCharFunctionTest {

    @Test
    public void test_1() {
        String sql = "SELECT TO_CHAR(media_col, 873) FROM media_tab;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }

    @Test
    public void test_2() {
        String sql = "SELECT TO_CHAR('01110') FROM DUAL;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }


    @Test
    public void test_3() {
        String sql = "SELECT TO_CHAR('01110' + 1) FROM DUAL;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }

    @Test
    public void test_4() {
        String sql = "SELECT TO_CHAR(-10000,'L99G999D99MI') \"Amount\"\n" +
                "     FROM DUAL;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }
}
