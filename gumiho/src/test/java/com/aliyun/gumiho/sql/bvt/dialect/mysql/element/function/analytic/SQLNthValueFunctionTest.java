package com.aliyun.gumiho.sql.bvt.dialect.mysql.element.function.analytic;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author kongtong.ouyang on 2018/5/17.
 */
public class SQLNthValueFunctionTest {

    @Test
    public void test_1() {
        String sql = "SELECT prod_id, channel_id, MIN(amount_sold),\n" +
                "    NTH_VALUE(MIN(amount_sold), 2) OVER (PARTITION BY prod_id ORDER BY channel_id\n" +
                "    ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING) nv\n" +
                "  FROM sales\n" +
                "  WHERE prod_id BETWEEN 13 and 16\n" +
                "  GROUP BY prod_id, channel_id;";
        System.out.println(sql);
        String format = OracleUtils.format(sql);
        System.out.println("--------------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT prod_id, channel_id, MIN(amount_sold),\n" +
                "\tNTH_VALUE(MIN(amount_sold), 2) OVER (PARTITION BY prod_id ORDER BY channel_id ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING) nv\n" +
                "FROM sales\n" +
                "WHERE prod_id BETWEEN 13 AND 16\n" +
                "GROUP BY prod_id, channel_id;", format);
    }

}
