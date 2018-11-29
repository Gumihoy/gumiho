package com.aliyun.gumiho.sql.bvt.dialect.mysql.element.constraint;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/AVG.html#GUID-B64BCBF1-DAA0-4D88-9821-2C4D3FDE5E4A
 *
 * @author kongtong.ouyang on 2018/5/17.
 */
public class SQLExplicitIndexControlTest {

    @Test
    public void test_1() {
        String sql = "CREATE TABLE promotions_var3\n" +
                "    ( promo_id         NUMBER(6)\n" +
                "    , promo_name       VARCHAR2(20)\n" +
                "    , promo_category   VARCHAR2(15)\n" +
                "    , promo_cost       NUMBER(10,2)\n" +
                "    , promo_begin_date DATE\n" +
                "    , promo_end_date   DATE\n" +
                "    , CONSTRAINT promo_id_u UNIQUE (promo_id, promo_cost)\n" +
                "         USING INDEX (CREATE UNIQUE INDEX promo_ix1\n" +
                "            ON promotions_var3 (promo_id, promo_cost))\n" +
                "    , CONSTRAINT promo_id_u2 UNIQUE (promo_cost, promo_id) \n" +
                "         USING INDEX promo_ix1); ";

        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("-------------------");
        System.out.println(format);
        Assert.assertEquals("CREATE TABLE promotions_var3\n" +
                "    ( promo_id         NUMBER(6)\n" +
                "    , promo_name       VARCHAR2(20)\n" +
                "    , promo_category   VARCHAR2(15)\n" +
                "    , promo_cost       NUMBER(10,2)\n" +
                "    , promo_begin_date DATE\n" +
                "    , promo_end_date   DATE\n" +
                "    , CONSTRAINT promo_id_u UNIQUE (promo_id, promo_cost)\n" +
                "         USING INDEX (CREATE UNIQUE INDEX promo_ix1\n" +
                "            ON promotions_var3 (promo_id, promo_cost))\n" +
                "    , CONSTRAINT promo_id_u2 UNIQUE (promo_cost, promo_id) \n" +
                "         USING INDEX promo_ix1);", format);
    }
}
