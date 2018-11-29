package com.aliyun.gumiho.sql.bvt.dialect.mysql.element.constraint;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/AVG.html#GUID-B64BCBF1-DAA0-4D88-9821-2C4D3FDE5E4A
 *
 * @author kongtong.ouyang on 2018/5/17.
 */
public class SQLDeferrableConstraintTest {

    @Test
    public void test_1() {
        String sql = "CREATE TABLE games\n" +
                "  (scores NUMBER, CONSTRAINT unq_num UNIQUE (scores)\n" +
                "   INITIALLY DEFERRED DEFERRABLE); ";

        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("-------------------");
        System.out.println(format);
        Assert.assertEquals("CREATE TABLE games (\n" +
                "\tscores NUMBER,\n" +
                "\tCONSTRAINT unq_num UNIQUE (scores) INITIALLY DEFERRED DEFERRABLE\n" +
                ");", format);
    }
}
