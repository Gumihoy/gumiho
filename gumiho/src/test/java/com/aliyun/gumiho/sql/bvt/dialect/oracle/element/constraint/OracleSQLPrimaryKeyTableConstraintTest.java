package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.constraint;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/AVG.html#GUID-B64BCBF1-DAA0-4D88-9821-2C4D3FDE5E4A
 *
 * @author kongtong.ouyang on 2018/5/17.
 */
public class OracleSQLPrimaryKeyTableConstraintTest {

    @Test
    public void test_0() {
        String sql = "CREATE TABLE locations_demo\n" +
                "    ( location_id    NUMBER(4) \n" +
                "    , street_address VARCHAR2(40)\n" +
                "    , postal_code    VARCHAR2(12)\n" +
                "    , city           VARCHAR2(30)\n" +
                "    , state_province VARCHAR2(25)\n" +
                "    , country_id     CHAR(2)\n" +
                "    , CONSTRAINT loc_id_pk PRIMARY KEY (location_id)); ";

        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("-------------------");
        System.out.println(format);
        Assert.assertEquals("CREATE TABLE locations_demo (\n" +
                "\tlocation_id NUMBER(4),\n" +
                "\tstreet_address VARCHAR2(40),\n" +
                "\tpostal_code VARCHAR2(12),\n" +
                "\tcity VARCHAR2(30),\n" +
                "\tstate_province VARCHAR2(25),\n" +
                "\tcountry_id CHAR(2),\n" +
                "\tCONSTRAINT loc_id_pk PRIMARY KEY (location_id)\n" +
                ");", format);
    }
}
