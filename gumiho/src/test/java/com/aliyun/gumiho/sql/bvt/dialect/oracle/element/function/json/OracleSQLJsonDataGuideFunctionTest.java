package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.function.json;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/17.
 */
public class OracleSQLJsonDataGuideFunctionTest {

    @Test
    public void test_1() {
        String s = "SELECT EXTRACT(YEAR FROM date_loaded) YEAR,\n" +
                "       JSON_DATAGUIDE(po_document) \"DATA GUIDE\"\n" +
                "  FROM j_purchaseorder\n" +
                "  GROUP BY extract(YEAR FROM date_loaded)\n" +
                "  ORDER BY extract(YEAR FROM date_loaded) DESC;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT EXTRACT(YEAR FROM date_loaded) YEAR,\n" +
                "\tJSON_DATAGUIDE(po_document) \"DATA GUIDE\"\n" +
                "FROM j_purchaseorder\n" +
                "GROUP BY EXTRACT(YEAR FROM date_loaded)\n" +
                "ORDER BY EXTRACT(YEAR FROM date_loaded) DESC;", formatSQL);
    }


}
