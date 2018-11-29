package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.function.json;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/17.
 */
public class OracleSQLJsonObjectFunctionTest {

    @Test
    public void test_1() {
        String s = "SELECT JSON_OBJECT (\n" +
                "    KEY 'deptno' VALUE d.department_id,\n" +
                "    KEY 'deptname' VALUE d.department_name \n" +
                "    ) \"Department Objects\"\n" +
                "  FROM departments d\n" +
                "  ORDER BY d.department_id;\n";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT JSON_OBJECT(KEY 'deptno' VALUE d.department_id, KEY 'deptname' VALUE d.department_name) \"Department Objects\"\n" +
                "FROM departments d\n" +
                "ORDER BY d.department_id;", formatSQL);
    }


}
