package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.constraint;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/AVG.html#GUID-B64BCBF1-DAA0-4D88-9821-2C4D3FDE5E4A
 *
 * @author kongtong.ouyang on 2018/5/17.
 */
public class OracleSQLReferencesColumnConstraintTest {

    @Test
    public void test_0() {
        String sql = "CREATE TABLE dept_20 \n" +
                "   (employee_id     NUMBER(4), \n" +
                "    last_name       VARCHAR2(10), \n" +
                "    job_id          VARCHAR2(9), \n" +
                "    manager_id      NUMBER(4), \n" +
                "    hire_date       DATE, \n" +
                "    salary          NUMBER(7,2), \n" +
                "    commission_pct  NUMBER(7,2), \n" +
                "    department_id   CONSTRAINT fk_deptno \n" +
                "                    REFERENCES departments(department_id) ); ";

        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("-------------------");
        System.out.println(format);
        Assert.assertEquals("CREATE TABLE dept_20 (\n" +
                "\temployee_id NUMBER(4),\n" +
                "\tlast_name VARCHAR2(10),\n" +
                "\tjob_id VARCHAR2(9),\n" +
                "\tmanager_id NUMBER(4),\n" +
                "\thire_date DATE,\n" +
                "\tsalary NUMBER(7, 2),\n" +
                "\tcommission_pct NUMBER(7, 2),\n" +
                "\tdepartment_id CONSTRAINT fk_deptno REFERENCES departments(department_id)\n" +
                ");", format);
    }

    @Test
    public void test_1() {
        String sql = "CREATE TABLE dept_20 \n" +
                "   (employee_id     NUMBER(4) PRIMARY KEY, \n" +
                "    last_name       VARCHAR2(10), \n" +
                "    job_id          VARCHAR2(9), \n" +
                "    manager_id      NUMBER(4) CONSTRAINT fk_mgr\n" +
                "                    REFERENCES employees ON DELETE SET NULL, \n" +
                "    hire_date       DATE, \n" +
                "    salary          NUMBER(7,2), \n" +
                "    commission_pct  NUMBER(7,2), \n" +
                "    department_id   NUMBER(2)   CONSTRAINT fk_deptno \n" +
                "                    REFERENCES departments(department_id) \n" +
                "                    ON DELETE CASCADE ); ";

        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("-------------------");
        System.out.println(format);
        Assert.assertEquals("CREATE TABLE dept_20 (\n" +
                "\temployee_id NUMBER(4) PRIMARY KEY,\n" +
                "\tlast_name VARCHAR2(10),\n" +
                "\tjob_id VARCHAR2(9),\n" +
                "\tmanager_id NUMBER(4) CONSTRAINT fk_mgr REFERENCES employees ON DELETE SET NULL,\n" +
                "\thire_date DATE,\n" +
                "\tsalary NUMBER(7, 2),\n" +
                "\tcommission_pct NUMBER(7, 2),\n" +
                "\tdepartment_id NUMBER(2) CONSTRAINT fk_deptno REFERENCES departments(department_id) ON DELETE CASCADE\n" +
                ");", format);
    }

}
