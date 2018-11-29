package com.aliyun.gumiho.sql.bvt.translate.oracle2.drds.element.function.datamining;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/17.
 */
public class SQLClusterDistanceFunctionTest {

    @Test
    public void test_1() {
        String sql = "SELECT cust_id\n" +
                "  FROM (\n" +
                "    SELECT cust_id,\n" +
                "           rank() over\n" +
                "             (order by CLUSTER_DISTANCE(km_sh_clus_sample USING *) desc) rnk\n" +
                "      FROM mining_data_apply_v)\n" +
                "  WHERE rnk <= 11\n" +
                "  ORDER BY rnk;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }

    @Test
    public void test_2() {
        String sql = "SELECT * FROM (\n" +
                "     SELECT cust_id,\n" +
                "          CLUSTER_ID(INTO 4 USING *) OVER () cls,\n" +
                "          CLUSTER_DETAILS(INTO 4 USING *) OVER () cls_details\n" +
                "     FROM mining_data_apply_v)\n" +
                "WHERE cust_id <= 100003\n" +
                "ORDER BY 1; ";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }
}
