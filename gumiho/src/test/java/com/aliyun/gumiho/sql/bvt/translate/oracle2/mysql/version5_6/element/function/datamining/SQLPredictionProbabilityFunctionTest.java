package com.aliyun.gumiho.sql.bvt.translate.oracle2.mysql.version5_6.element.function.datamining;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/17.
 */
public class SQLPredictionProbabilityFunctionTest {

    @Test
    public void test_1() {
        String sql = "SELECT cust_id, cust_marital_status,\n" +
                "            PREDICTION_PROBABILITY(OF ANOMALY, 0 USING *)\n" +
                "              OVER (PARTITION BY CUST_MARITAL_STATUS) anom_prob,\n" +
                "            PREDICTION_DETAILS(OF ANOMALY, 0, 3 USING *)\n" +
                "              OVER (PARTITION BY CUST_MARITAL_STATUS) anom_det\n" +
                "     FROM mining_data_one_class_v";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }

}
