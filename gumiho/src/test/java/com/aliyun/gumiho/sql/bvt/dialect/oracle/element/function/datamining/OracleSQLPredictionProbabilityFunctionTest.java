package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.function.datamining;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/17.
 */
public class OracleSQLPredictionProbabilityFunctionTest {

    @Test
    public void test_0() {
        String s = "SELECT cust_id, cust_marital_status,\n" +
                "            PREDICTION_PROBABILITY(OF ANOMALY, 0 USING *)\n" +
                "              OVER (PARTITION BY CUST_MARITAL_STATUS) anom_prob,\n" +
                "            PREDICTION_DETAILS(OF ANOMALY, 0, 3 USING *)\n" +
                "              OVER (PARTITION BY CUST_MARITAL_STATUS) anom_det\n" +
                "     FROM mining_data_one_class_v ";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT cust_id, cust_marital_status,\n" +
                "\tPREDICTION_PROBABILITY(OF ANOMALY, 0 USING *) OVER (PARTITION BY CUST_MARITAL_STATUS) anom_prob,\n" +
                "\tPREDICTION_DETAILS(OF ANOMALY, 0, 3 USING *) OVER (PARTITION BY CUST_MARITAL_STATUS) anom_det\n" +
                "FROM mining_data_one_class_v", formatSQL);
    }

}
