package com.aliyun.gumiho.sql.bvt.dialect.mysql.element.constraint;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/AVG.html#GUID-B64BCBF1-DAA0-4D88-9821-2C4D3FDE5E4A
 *
 * @author kongtong.ouyang on 2018/5/17.
 */
public class SQLCaseInsensitiveConstraintTest {

    @Test
    public void test_1() {
        String sql = "CREATE TABLE products\n" +
                "    ( product_id VARCHAR2(20) COLLATE BINARY_CI\n" +
                "           CONSTRAINT product_pk PRIMARY KEY\n" +
                "    , description VARCHAR2(1000) COLLATE BINARY_CI\n" +
                "           CONSTRAINT product_description_unq UNIQUE\n" +
                "    ); ";

        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("-------------------");
        System.out.println(format);
        Assert.assertEquals("CREATE TABLE products (\n" +
                "\tproduct_id VARCHAR2(20) COLLATE BINARY_CI CONSTRAINT product_pk PRIMARY KEY,\n" +
                "\tdescription VARCHAR2(1000) COLLATE BINARY_CI CONSTRAINT product_description_unq UNIQUE\n" +
                ");", format);
    }



    @Test
    public void test_2() {
        String sql = "CREATE TABLE product_components\n" +
                "    ( component_id VARCHAR2(40) COLLATE BINARY_CI\n" +
                "           CONSTRAINT product_component_pk PRIMARY KEY\n" +
                "    , product_id CONSTRAINT product_component_fk REFERENCES products(product_id)\n" +
                "    , description VARCHAR2(1000) COLLATE BINARY_CI\n" +
                "           CONSTRAINT product_component_descr_unq UNIQUE\n" +
                "    ); ";

        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("-------------------");
        System.out.println(format);
        Assert.assertEquals("CREATE TABLE product_components (\n" +
                "\tcomponent_id VARCHAR2(40) COLLATE BINARY_CI CONSTRAINT product_component_pk PRIMARY KEY,\n" +
                "\tproduct_id CONSTRAINT product_component_fk REFERENCES products(product_id),\n" +
                "\tdescription VARCHAR2(1000) COLLATE BINARY_CI CONSTRAINT product_component_descr_unq UNIQUE\n" +
                ");", format);
    }

}
