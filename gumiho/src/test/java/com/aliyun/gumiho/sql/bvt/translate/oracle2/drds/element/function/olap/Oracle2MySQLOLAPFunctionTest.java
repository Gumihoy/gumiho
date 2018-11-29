package com.aliyun.gumiho.sql.bvt.translate.oracle2.drds.element.function.olap;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CUBE_TABLE.html#GUID-55CDE2F2-14ED-4F8F-B5BF-1566C0E18727
 *
 * @author kongtong.ouyang on 2018/5/17.
 */
public class Oracle2MySQLOLAPFunctionTest {

    @Test
    public void test_1() {
        String sql = "SELECT CUBE_TABLE('global.units_cube HIERARCHY customer market HIERARCHY time calendar') FROM dual;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }

}
