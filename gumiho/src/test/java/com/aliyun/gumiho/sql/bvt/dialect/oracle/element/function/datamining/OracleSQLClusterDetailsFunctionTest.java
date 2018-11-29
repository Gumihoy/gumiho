package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.function.datamining;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/17.
 */
public class OracleSQLClusterDetailsFunctionTest {

    @Test
    public void test_0() {
        String s = "SELECT S.cluster_id, probability prob,\n" +
                "       CLUSTER_DETAILS(em_sh_clus_sample, S.cluster_id, 5 USING T.*) det\n" +
                "FROM\n" +
                "  (SELECT v.*, CLUSTER_SET(em_sh_clus_sample, NULL, 0.2 USING *) pset\n" +
                "    FROM mining_data_apply_v v\n" +
                "   WHERE cust_id = 100955) T,\n" +
                "  TABLE(T.pset) S\n" +
                "ORDER BY 2 DESC;  ";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT S.cluster_id, probability prob,\n" +
                "\tCLUSTER_DETAILS(em_sh_clus_sample, S.cluster_id, 5 USING T.*) det\n" +
                "FROM (\n" +
                "\tSELECT v.*, CLUSTER_SET(em_sh_clus_sample, NULL, 0.2 USING *) pset\n" +
                "\tFROM mining_data_apply_v v\n" +
                "\tWHERE cust_id = 100955\n" +
                ") T, TABLE(T.pset) S\n" +
                "ORDER BY 2 DESC;", formatSQL);
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
