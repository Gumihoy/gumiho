package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.function.json;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/17.
 */
public class OracleSQLJsonObjectAggFunctionTest {

    @Test
    public void test_1() {
        String s = "SELECT JSON_OBJECTAGG(KEY department_name VALUE department_id) \"Department Numbers\"\n" +
                "  FROM departments\n" +
                "  WHERE department_id <= 30;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT JSON_OBJECTAGG(KEY department_name VALUE department_id) \"Department Numbers\"\n" +
                "FROM departments\n" +
                "WHERE department_id <= 30;", formatSQL);
    }


}
