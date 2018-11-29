package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.function.json;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/17.
 */
public class OracleSQLJsonArrayFunctionTest {

    @Test
    public void test_1() {
        String s = "SELECT JSON_ARRAY (     \n" +
                "    JSON_OBJECT('percentage' VALUE .50),\n" +
                "    JSON_ARRAY(1,2,3),\n" +
                "    100,\n" +
                "    'California',\n" +
                "    null\n" +
                "    NULL ON NULL\n" +
                "    ) \"JSON Array Example\"\n" +
                "  FROM DUAL;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT JSON_ARRAY(JSON_OBJECT('percentage' VALUE .50), JSON_ARRAY(1, 2, 3), 100, 'California', NULL NULL ON NULL) \"JSON Array Example\"\n" +
                "FROM DUAL;", formatSQL);
    }


}
