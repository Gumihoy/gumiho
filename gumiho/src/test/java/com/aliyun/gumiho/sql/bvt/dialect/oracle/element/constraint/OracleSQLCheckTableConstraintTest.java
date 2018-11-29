package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.constraint;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/AVG.html#GUID-B64BCBF1-DAA0-4D88-9821-2C4D3FDE5E4A
 *
 * @author kongtong.ouyang on 2018/5/17.
 */
public class OracleSQLCheckTableConstraintTest {

    @Test
    public void test_0() {
        String sql = "CREATE TABLE dept_20\n" +
                "   (employee_id     NUMBER(4) PRIMARY KEY, \n" +
                "    last_name       VARCHAR2(10), \n" +
                "    job_id          VARCHAR2(9), \n" +
                "    manager_id      NUMBER(4), \n" +
                "    salary          NUMBER(7,2), \n" +
                "    commission_pct  NUMBER(7,2), \n" +
                "    department_id   NUMBER(2),\n" +
                "    CONSTRAINT check_sal CHECK (salary * commission_pct <= 5000)); ";

        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("-------------------");
        System.out.println(format);
        Assert.assertEquals("CREATE TABLE dept_20 (\n" +
                "\temployee_id NUMBER(4) PRIMARY KEY,\n" +
                "\tlast_name VARCHAR2(10),\n" +
                "\tjob_id VARCHAR2(9),\n" +
                "\tmanager_id NUMBER(4),\n" +
                "\tsalary NUMBER(7, 2),\n" +
                "\tcommission_pct NUMBER(7, 2),\n" +
                "\tdepartment_id NUMBER(2),\n" +
                "\tCONSTRAINT check_sal CHECK (salary * commission_pct <= 5000)\n" +
                ");", format);
    }


    @Test
    public void test_1() {
        String sql = "CREATE TABLE order_detail \n" +
                "  (CONSTRAINT pk_od PRIMARY KEY (order_id, part_no), \n" +
                "   order_id    NUMBER \n" +
                "      CONSTRAINT fk_oid \n" +
                "         REFERENCES oe.orders(order_id), \n" +
                "   part_no     NUMBER \n" +
                "      CONSTRAINT fk_pno \n" +
                "         REFERENCES oe.product_information(product_id), \n" +
                "   quantity    NUMBER \n" +
                "      CONSTRAINT nn_qty NOT NULL \n" +
                "      CONSTRAINT check_qty CHECK (quantity > 0), \n" +
                "   cost        NUMBER \n" +
                "      CONSTRAINT check_cost CHECK (cost > 0) ); ";

        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("-------------------");
        System.out.println(format);
        Assert.assertEquals("CREATE TABLE order_detail (\n" +
                "\tCONSTRAINT pk_od PRIMARY KEY (order_id, part_no),\n" +
                "\torder_id NUMBER CONSTRAINT fk_oid REFERENCES oe.orders(order_id),\n" +
                "\tpart_no NUMBER CONSTRAINT fk_pno REFERENCES oe.product_information(product_id),\n" +
                "\tquantity NUMBER CONSTRAINT nn_qty NOT NULL CONSTRAINT check_qty CHECK (quantity > 0),\n" +
                "\tcost NUMBER CONSTRAINT check_cost CHECK (cost > 0)\n" +
                ");", format);
    }


    @Test
    public void test_2() {
        String sql = "CREATE TABLE students (name person_name, age INTEGER,\n" +
                "   CHECK (name.first_name IS NOT NULL AND \n" +
                "          name.last_name IS NOT NULL));";

        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("-------------------");
        System.out.println(format);
        Assert.assertEquals("CREATE TABLE students (\n" +
                "\tname person_name,\n" +
                "\tage INTEGER,\n" +
                "\tCHECK (name.first_name IS NOT NULL AND name.last_name IS NOT NULL)\n" +
                ");", format);
    }
}
