package com.aliyun.gumiho.sql.bvt.translate.oracle2.drds.element.function.hierarchical;

import com.aliyun.gumiho.sql.translate.result.SQLTransformResult;
import com.aliyun.gumiho.sql.util.OracleUtils;
import com.aliyun.gumiho.sql.util.SQLTransformUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/17.
 */
public class Oracle2MySQLHierarchicalFunctionTest {

    @Test
    public void test_0() {
        String sql = "SELECT SYS_CONNECT_BY_PATH(hire_date, 1) FROM DUAL ";

        String format = OracleUtils.format(sql);
        System.out.println(format);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println("--------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("SELECT SYS_CONNECT_BY_PATH(MONTH, 1, `hire_date`)\n" +
                "FROM `DUAL`", result.targetSql);
    }


}
