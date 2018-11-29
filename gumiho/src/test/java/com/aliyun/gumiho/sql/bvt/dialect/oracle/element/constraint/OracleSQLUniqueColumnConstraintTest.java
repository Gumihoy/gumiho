package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.constraint;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/AVG.html#GUID-B64BCBF1-DAA0-4D88-9821-2C4D3FDE5E4A
 *
 * @author kongtong.ouyang on 2018/5/17.
 */
public class OracleSQLUniqueColumnConstraintTest {

    @Test
    public void test_0() {
        String sql = "CREATE TABLE promotions_var1\n" +
                "    ( promo_id         NUMBER(6)\n" +
                "                       CONSTRAINT promo_id_u  UNIQUE\n" +
                "    , promo_name       VARCHAR2(20)\n" +
                "    , promo_category   VARCHAR2(15)\n" +
                "    , promo_cost       NUMBER(10,2)\n" +
                "    , promo_begin_date DATE\n" +
                "    , promo_end_date   DATE\n" +
                "    ) ; ";

        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("-------------------");
        System.out.println(format);
        Assert.assertEquals("CREATE TABLE promotions_var1 (\n" +
                "\tpromo_id NUMBER(6) CONSTRAINT promo_id_u UNIQUE,\n" +
                "\tpromo_name VARCHAR2(20),\n" +
                "\tpromo_category VARCHAR2(15),\n" +
                "\tpromo_cost NUMBER(10, 2),\n" +
                "\tpromo_begin_date DATE,\n" +
                "\tpromo_end_date DATE\n" +
                ");", format);
    }

}
