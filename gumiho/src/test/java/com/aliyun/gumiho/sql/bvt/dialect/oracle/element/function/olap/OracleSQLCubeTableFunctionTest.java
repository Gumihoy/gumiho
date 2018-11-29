package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.function.olap;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CUBE_TABLE.html#GUID-55CDE2F2-14ED-4F8F-B5BF-1566C0E18727
 *
 * @author kongtong.ouyang on 2018/5/17.
 */
public class OracleSQLCubeTableFunctionTest {

    @Test
    public void test_0() {
        String s = "SELECT CUBE_TABLE('global.units_cube HIERARCHY customer market HIERARCHY time calendar') FROM dual;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT CUBE_TABLE('global.units_cube HIERARCHY customer market HIERARCHY time calendar')\n" +
                "FROM dual;", formatSQL);
    }

}
