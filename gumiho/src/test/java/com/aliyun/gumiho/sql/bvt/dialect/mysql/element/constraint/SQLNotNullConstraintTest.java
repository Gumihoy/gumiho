package com.aliyun.gumiho.sql.bvt.dialect.mysql.element.constraint;

import com.aliyun.gumiho.sql.util.MySQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/AVG.html#GUID-B64BCBF1-DAA0-4D88-9821-2C4D3FDE5E4A
 *
 * @author kongtong.ouyang on 2018/5/17.
 */
public class SQLNotNullConstraintTest {

    @Test
    public void test_1() {
        String sql = "ALTER TABLE locations_demo\n" +
                "   MODIFY (country_id CONSTRAINT country_nn NOT NULL);  ";

        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-------------------");
        System.out.println(format);
        Assert.assertEquals("ALTER TABLE locations_demo\n" +
                "   MODIFY (country_id CONSTRAINT country_nn NOT NULL);", format);
    }

}
