package com.aliyun.gumiho.sql.bvt.dialect.mysql.element.constraint;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/AVG.html#GUID-B64BCBF1-DAA0-4D88-9821-2C4D3FDE5E4A
 *
 * @author kongtong.ouyang on 2018/5/17.
 */
public class SQLCompositeUniqueConstraintTest {

    @Test
    public void test_1() {
        String sql = "ALTER TABLE warehouses\n" +
                "   ADD CONSTRAINT wh_unq UNIQUE (warehouse_id, warehouse_name)\n" +
                "   USING INDEX PCTFREE 5\n" +
                "   EXCEPTIONS INTO wrong_id; ";

        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("-------------------");
        System.out.println(format);
        Assert.assertEquals("ALTER TABLE warehouses\n" +
                "   ADD CONSTRAINT wh_unq UNIQUE (warehouse_id, warehouse_name)\n" +
                "   USING INDEX PCTFREE 5\n" +
                "   EXCEPTIONS INTO wrong_id;", format);
    }


    @Test
    public void test_2() {
        String sql = "CREATE TABLE promotions_var2\n" +
                "    ( promo_id         NUMBER(6)\n" +
                "    , promo_name       VARCHAR2(20)\n" +
                "    , promo_category   VARCHAR2(15)\n" +
                "    , promo_cost       NUMBER(10,2)\n" +
                "    , promo_begin_date DATE\n" +
                "    , promo_end_date   DATE\n" +
                "    , CONSTRAINT promo_id_u UNIQUE (promo_id)\n" +
                "   USING INDEX PCTFREE 20\n" +
                "      TABLESPACE stocks\n" +
                "      STORAGE (INITIAL 8M) ); ";

        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("-------------------");
        System.out.println(format);
        Assert.assertEquals("CREATE TABLE promotions_var2\n" +
                "    ( promo_id         NUMBER(6)\n" +
                "    , promo_name       VARCHAR2(20)\n" +
                "    , promo_category   VARCHAR2(15)\n" +
                "    , promo_cost       NUMBER(10,2)\n" +
                "    , promo_begin_date DATE\n" +
                "    , promo_end_date   DATE\n" +
                "    , CONSTRAINT promo_id_u UNIQUE (promo_id)\n" +
                "   USING INDEX PCTFREE 20\n" +
                "      TABLESPACE stocks\n" +
                "      STORAGE (INITIAL 8M) );", format);
    }
}
