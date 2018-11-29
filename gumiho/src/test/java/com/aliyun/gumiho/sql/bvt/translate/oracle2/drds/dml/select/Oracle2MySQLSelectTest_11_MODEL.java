package com.aliyun.gumiho.sql.bvt.translate.oracle2.drds.dml.select;

import com.aliyun.gumiho.sql.translate.result.SQLTransformResult;
import com.aliyun.gumiho.sql.util.OracleUtils;
import com.aliyun.gumiho.sql.util.SQLTransformUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CASE-Expressions.html#GUID-CA29B333-572B-4E1D-BA64-851FABDBAE96
 *
 * @author kongtong.ouyang on 2018/5/15.
 */
public class Oracle2MySQLSelectTest_11_MODEL {


    @Test
    public void test_0() {
        String sql = "SELECT employee_id, manager_id \n" +
                "   FROM employees\n" +
                "   WHERE employees.manager_id(+) = employees.employee_id;";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("SELECT `employee_id`, `manager_id`\n" +
                "FROM `employees`\n" +
                "\tRIGHT JOIN `employees` `e2` ON `employees`.`manager_id` = `e2`.`employee_id`;", result.targetSql);

    }

    @Test
    public void test_1() {
        String sql = "SELECT employee_id, manager_id \n" +
                "   FROM employees\n" +
                "   WHERE employees.manager_id = employees.employee_id(+);";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("SELECT `employee_id`, `manager_id`\n" +
                "FROM `employees`\n" +
                "\tLEFT JOIN `employees` `e2` ON `employees`.`manager_id` = `e2`.`employee_id`;", result.targetSql);

    }

    @Test
    public void test_2() {
        String sql = "SELECT e1.employee_id, e1.manager_id, e2.employee_id\n" +
                "   FROM employees e1, employees e2\n" +
                "   WHERE e1.manager_id(+) = e2.employee_id\n" +
                "   ORDER BY e1.employee_id, e1.manager_id, e2.employee_id;";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("SELECT `e1`.`employee_id`, `e1`.`manager_id`, `e2`.`employee_id`\n" +
                "FROM `employees` `e1`\n" +
                "\tRIGHT JOIN `employees` `e2` ON `e1`.`manager_id` = `e2`.`employee_id`\n" +
                "ORDER BY `e1`.`employee_id`, `e1`.`manager_id`, `e2`.`employee_id`;", result.targetSql);

    }

    @Test
    public void test_3() {
        String sql = "SELECT * FROM A, B, D\n" +
                "  WHERE A.c1 = B.c2(+) and D.c3 = B.c4(+)";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("SELECT *\n" +
                "FROM `A`\n" +
                "\tLEFT JOIN `B` ON `A`.`c1` = `B`.`c2`\n" +
                "\tRIGHT JOIN `D` ON `D`.`c3` = `B`.`c4`", result.targetSql);

    }

    @Test
    public void test_4() {
        String sql = "SELECT NVL(B.NSRMC, A.XFSBH)\n" +
                "FROM ZZS_DBD_CGL_WSSB A, DJ_NSRXX B, DJ_NSRXX_DZB C\n" +
                "WHERE A.XFSBH = C.NSRSBH_OLD(+)\n" +
                "\tAND A.XFSBH = C.NSRSBH_NEW(+)\n" +
                "\tAND B.NSRDZDAH(+) = C.NSRDZDAH\n" +
                "\tAND A.GFSBH = :B2\n" +
                "\tAND KPRQ < SYSDATE - ?\n" +
                "\tAND KPRQ >= TRUNC(SYSDATE) - ?";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("SELECT NVL(`B`.`NSRMC`, `A`.`XFSBH`)\n" +
                "FROM `ZZS_DBD_CGL_WSSB` `A`, `DJ_NSRXX` `B`\n" +
                "\tLEFT JOIN `DJ_NSRXX_DZB` `C` ON `A`.`XFSBH` = `C`.`NSRSBH_OLD` AND `A`.`XFSBH` = `C`.`NSRSBH_NEW`\n" +
                "WHERE `B`.`NSRDZDAH` = `C`.`NSRDZDAH` AND `A`.`GFSBH` = ?\n" +
                "\tAND `KPRQ` < SYSDATE - ? AND `KPRQ` >= TRUNC(SYSDATE) - ?", result.targetSql);

    }
}
