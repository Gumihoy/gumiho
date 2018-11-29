package com.aliyun.gumiho.sql.bvt.translate.oracle2.drds.element.function.datamining;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/17.
 */
public class SQLClusterDetailsFunctionTest {

    @Test
    public void test_1() {
        String sql = "SELECT S.cluster_id, probability prob,\n" +
                "       CLUSTER_DETAILS(em_sh_clus_sample, S.cluster_id, 5 USING T.*) det\n" +
                "FROM\n" +
                "  (SELECT v.*, CLUSTER_SET(em_sh_clus_sample, NULL, 0.2 USING *) pset\n" +
                "    FROM mining_data_apply_v v\n" +
                "   WHERE cust_id = 100955) T,\n" +
                "  TABLE(T.pset) S\n" +
                "ORDER BY 2 DESC;  ";
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
