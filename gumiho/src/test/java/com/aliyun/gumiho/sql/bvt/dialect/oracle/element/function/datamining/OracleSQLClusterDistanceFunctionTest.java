package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.function.datamining;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/17.
 */
public class OracleSQLClusterDistanceFunctionTest {

    @Test
    public void test_0() {
        String s = "SELECT cust_id\n" +
                "  FROM (\n" +
                "    SELECT cust_id,\n" +
                "           rank() over\n" +
                "             (order by CLUSTER_DISTANCE(km_sh_clus_sample USING *) desc) rnk\n" +
                "      FROM mining_data_apply_v)\n" +
                "  WHERE rnk <= 11\n" +
                "  ORDER BY rnk;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT cust_id\n" +
                "FROM (\n" +
                "\tSELECT cust_id,\n" +
                "\t\trank() OVER (ORDER BY CLUSTER_DISTANCE(km_sh_clus_sample USING *) DESC) rnk\n" +
                "\tFROM mining_data_apply_v\n" +
                ")\n" +
                "WHERE rnk <= 11\n" +
                "ORDER BY rnk;", formatSQL);
    }

    @Test
    public void test_1() {
        String s = "SELECT * FROM (\n" +
                "     SELECT cust_id,\n" +
                "          CLUSTER_ID(INTO 4 USING *) OVER () cls,\n" +
                "          CLUSTER_DETAILS(INTO 4 USING *) OVER () cls_details\n" +
                "     FROM mining_data_apply_v)\n" +
                "WHERE cust_id <= 100003\n" +
                "ORDER BY 1; ";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT *\n" +
                "FROM (\n" +
                "\tSELECT cust_id, CLUSTER_ID(INTO 4 USING *) OVER () cls,\n" +
                "\t\tCLUSTER_DETAILS(INTO 4 USING *) OVER () cls_details\n" +
                "\tFROM mining_data_apply_v\n" +
                ")\n" +
                "WHERE cust_id <= 100003\n" +
                "ORDER BY 1;", formatSQL);
    }
}
