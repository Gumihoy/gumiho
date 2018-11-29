package com.aliyun.gumiho.sql.bvt.translate.oracle2.mysql.version5_6.element.function.datamining;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/17.
 */
public class SQLFeatureCompareFunctionTest {

    @Test
    public void test_1() {
        String sql = "SELECT 1-FEATURE_COMPARE(esa_wiki_mod USING 'There are several PGA tour golfers from South Africa' text AND USING 'Nick Price won the 2002 Mastercard Colonial Open' text) similarity FROM DUAL;";
        String format = OracleUtils.format(sql);
        Assert.assertEquals(sql, format);
    }

}
