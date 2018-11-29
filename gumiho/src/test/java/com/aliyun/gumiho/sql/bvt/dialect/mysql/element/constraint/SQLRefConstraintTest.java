package com.aliyun.gumiho.sql.bvt.dialect.mysql.element.constraint;

import com.aliyun.gumiho.sql.util.MySQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/AVG.html#GUID-B64BCBF1-DAA0-4D88-9821-2C4D3FDE5E4A
 *
 * @author kongtong.ouyang on 2018/5/17.
 */
public class SQLRefConstraintTest {

    @Test
    public void test_1() {
        String sql = "CREATE TABLE customer_addresses (\n" +
                "   add_id NUMBER, \n" +
                "   address REF cust_address_typ_new\n" +
                "   SCOPE IS address_table); ";

        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-------------------");
        System.out.println(format);
        Assert.assertEquals("CREATE TABLE customer_addresses (\n" +
                "\tadd_id NUMBER,\n" +
                "\taddress REF cust_address_typ_new SCOPE IS address_table\n" +
                ");", format);
    }



    @Test
    public void test_2() {
        String sql = "CREATE TABLE customer_addresses (\n" +
                "   add_id NUMBER,\n" +
                "   address REF cust_address_typ REFERENCES address_table); ";

        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-------------------");
        System.out.println(format);
        Assert.assertEquals("CREATE TABLE customer_addresses (\n" +
                "\tadd_id NUMBER,\n" +
                "\taddress REF cust_address_typ REFERENCES address_table\n" +
                ");", format);
    }


    @Test
    public void test_3() {
        String sql = "CREATE TABLE employees_obj\n" +
                "   ( e_name   VARCHAR2(100),\n" +
                "     e_number NUMBER,\n" +
                "     e_dept   REF department_typ SCOPE IS departments_obj_t ); ";

        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-------------------");
        System.out.println(format);
        Assert.assertEquals("CREATE TABLE employees_obj (\n" +
                "\te_name VARCHAR2(100),\n" +
                "\te_number NUMBER,\n" +
                "\te_dept REF department_typ SCOPE IS departments_obj_t\n" +
                ");", format);
    }
}
