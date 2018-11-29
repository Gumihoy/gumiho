package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.function.datamining;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/17.
 */
public class OracleSQLFeatureIdFunctionTest {

    @Test
    public void test_0() {
        String s = "SELECT FEATURE_ID(nmf_sh_sample USING *) AS feat, COUNT(*) AS cnt\n" +
                "  FROM nmf_sh_sample_apply_prepared\n" +
                "  GROUP BY FEATURE_ID(nmf_sh_sample USING *)\n" +
                "  ORDER BY cnt DESC, feat DESC;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT FEATURE_ID(nmf_sh_sample USING *) AS feat, COUNT(*) AS cnt\n" +
                "FROM nmf_sh_sample_apply_prepared\n" +
                "GROUP BY FEATURE_ID(nmf_sh_sample USING *)\n" +
                "ORDER BY cnt DESC, feat DESC;", formatSQL);
    }

}
