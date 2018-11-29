package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.constraint;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/AVG.html#GUID-B64BCBF1-DAA0-4D88-9821-2C4D3FDE5E4A
 *
 * @author kongtong.ouyang on 2018/5/17.
 */
public class OracleSQLUniqueTableConstraintTest {

    @Test
    public void test_0() {
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
        Assert.assertEquals("CREATE TABLE promotions_var2 (\n" +
                "\tpromo_id NUMBER(6),\n" +
                "\tpromo_name VARCHAR2(20),\n" +
                "\tpromo_category VARCHAR2(15),\n" +
                "\tpromo_cost NUMBER(10, 2),\n" +
                "\tpromo_begin_date DATE,\n" +
                "\tpromo_end_date DATE,\n" +
                "\tCONSTRAINT promo_id_u UNIQUE (promo_id)\n" +
                "\t\tUSING INDEX PCTFREE 20 TABLESPACE stocks STORAGE (\n" +
                "\t\t\tINITIAL 8M\n" +
                "\t\t)\n" +
                ");", format);
    }

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
                "\tCONSTRAINT unq_num UNIQUE (scores)\n" +
                "\t\tINITIALLY DEFERRED\n" +
                "\t\tDEFERRABLE\n" +
                ");", format);
    }

    @Test
    public void test_2() {
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
        Assert.assertEquals("CREATE TABLE promotions_var3 (\n" +
                "\tpromo_id NUMBER(6),\n" +
                "\tpromo_name VARCHAR2(20),\n" +
                "\tpromo_category VARCHAR2(15),\n" +
                "\tpromo_cost NUMBER(10, 2),\n" +
                "\tpromo_begin_date DATE,\n" +
                "\tpromo_end_date DATE,\n" +
                "\tCONSTRAINT promo_id_u UNIQUE (promo_id, promo_cost)\n" +
                "\t\tUSING INDEX (\n" +
                "\t\t\tCREATE UNIQUE INDEX promo_ix1 ON promotions_var3 (\n" +
                "\t\t\t\tpromo_id,\n" +
                "\t\t\t\tpromo_cost\n" +
                "\t\t\t)\n" +
                "\t\t),\n" +
                "\tCONSTRAINT promo_id_u2 UNIQUE (promo_cost, promo_id)\n" +
                "\t\tUSING INDEX promo_ix1\n" +
                ");", format);
    }
}
