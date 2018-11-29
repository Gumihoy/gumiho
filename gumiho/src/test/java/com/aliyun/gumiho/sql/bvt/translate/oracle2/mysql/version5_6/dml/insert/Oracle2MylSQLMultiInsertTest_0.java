package com.aliyun.gumiho.sql.bvt.translate.oracle2.mysql.version5_6.dml.insert;

import com.aliyun.gumiho.sql.translate.result.SQLTransformResult;
import com.aliyun.gumiho.sql.util.SQLTransformUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/9/3.
 */
public class Oracle2MylSQLMultiInsertTest_0 {

    @Test
    public void test_0() {
        String sql = "INSERT ALL\n" +
                "      INTO sales (prod_id, cust_id, time_id, amount)\n" +
                "      VALUES (product_id, customer_id, weekly_start_date, sales_sun)\n" +
                "      INTO sales (prod_id, cust_id, time_id, amount)\n" +
                "      VALUES (product_id, customer_id, weekly_start_date+1, sales_mon)\n" +
                "      INTO sales (prod_id, cust_id, time_id, amount)\n" +
                "      VALUES (product_id, customer_id, weekly_start_date+2, sales_tue)\n" +
                "      INTO sales (prod_id, cust_id, time_id, amount)\n" +
                "      VALUES (product_id, customer_id, weekly_start_date+3, sales_wed)\n" +
                "      INTO sales (prod_id, cust_id, time_id, amount)\n" +
                "      VALUES (product_id, customer_id, weekly_start_date+4, sales_thu)\n" +
                "      INTO sales (prod_id, cust_id, time_id, amount)\n" +
                "      VALUES (product_id, customer_id, weekly_start_date+5, sales_fri)\n" +
                "      INTO sales (prod_id, cust_id, time_id, amount)\n" +
                "      VALUES (product_id, customer_id, weekly_start_date+6, sales_sat)\n" +
                "   SELECT product_id, customer_id, weekly_start_date, sales_sun,\n" +
                "      sales_mon, sales_tue, sales_wed, sales_thu, sales_fri, sales_sat\n" +
                "      FROM sales_input_table;";

        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(sql);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals(sql, result.targetSql);
    }
}
