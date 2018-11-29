package com.aliyun.gumiho.sql.bvt.translate.oracle2.mysql.version5_6.element.function.datamining;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/17.
 */
public class SQLFeatureIdFunctionTest {

    @Test
    public void test_1() {
        String sql = "SELECT FEATURE_ID(nmf_sh_sample USING *) AS feat, COUNT(*) AS cnt\n" +
                "  FROM nmf_sh_sample_apply_prepared\n" +
                "  GROUP BY FEATURE_ID(nmf_sh_sample USING *)\n" +
                "  ORDER BY cnt DESC, feat DESC;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }

}
