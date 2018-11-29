package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.constraint;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/AVG.html#GUID-B64BCBF1-DAA0-4D88-9821-2C4D3FDE5E4A
 *
 * @author kongtong.ouyang on 2018/5/17.
 */
public class OracleSQLWithRowIdColumnConstraintTest {

    @Test
    public void test_0() {
        String sql = "CREATE TABLE customer_addresses (\n" +
                "   add_id NUMBER, \n" +
                "   address REF cust_address_typ_new\n" +
                "   with rowid); ";

        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("-------------------");
        System.out.println(format);
        Assert.assertEquals("CREATE TABLE customer_addresses (\n" +
                "\tadd_id NUMBER,\n" +
                "\taddress REF cust_address_typ_new WITH ROWID\n" +
                ");", format);
    }

}
