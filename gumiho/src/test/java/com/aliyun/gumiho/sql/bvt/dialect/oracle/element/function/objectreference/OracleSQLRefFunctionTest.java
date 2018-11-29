package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.function.objectreference;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/REF.html#GUID-B7622138-6EB6-4203-B5E7-91CAD52E9DB1
 *
 * @author kongtong.ouyang on 2018/5/17.
 */
public class OracleSQLRefFunctionTest {

    @Test
    public void test_0() {
        String s = "SELECT REF(e) FROM addresses e;";
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("SELECT REF(e)\n" +
                "FROM addresses e;", formatSQL);
    }

}
