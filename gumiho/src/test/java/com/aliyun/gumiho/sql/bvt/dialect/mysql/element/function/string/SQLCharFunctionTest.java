package com.aliyun.gumiho.sql.bvt.dialect.mysql.element.function.string;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/TRANSLATE-USING.html#GUID-EC8DE4D2-4F24-456D-A2E7-AD8F82E3A148
 *
 * @author kongtong.ouyang on 2018/5/17.
 */
public class SQLCharFunctionTest {

    @Test
    public void test_1() {
        String sql = "SELECT TRANSLATE(nchar_col USING CHAR_CS) FROM DUAL;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }

    @Test
    public void test_2() {
        String sql = "SELECT TRANSLATE (? USING CHAR_CS) FROM DUAL;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }

}
