package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.function.json;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/17.
 */
public class OracleSQLJsonTableFunctionTest {

    @Test
    public void test_0() {
        String s = "SELECT JSON_TABLE(po_document, '$.ShippingInstructions'\n" +
                "COLUMNS\n" +
                "  (phones VARCHAR2(100) FORMAT JSON PATH '$.Phone')) AS jt\n" +
                "  FROM id_table;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT JSON_TABLE(po_document, '$.ShippingInstructions' COLUMNS (phones VARCHAR2(100) FORMAT JSON PATH '$.Phone')) AS jt\n" +
                "FROM id_table;", formatSQL);
    }


}
