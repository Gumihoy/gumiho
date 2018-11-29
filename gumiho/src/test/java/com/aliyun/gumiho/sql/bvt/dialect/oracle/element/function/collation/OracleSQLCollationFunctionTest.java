package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.function.collation;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/17.
 */
public class OracleSQLCollationFunctionTest {

    @Test
    public void test_1() {
        String s = "SELECT COLLATION(name), COLLATION(?)\n" +
                "  FROM id_table;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals(s, formatSQL);
    }

}
