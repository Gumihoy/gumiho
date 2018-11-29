package com.aliyun.gumiho.sql.bvt.dialect.mysql.element.function.analytic;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/AVG.html#GUID-B64BCBF1-DAA0-4D88-9821-2C4D3FDE5E4A
 *
 * @author kongtong.ouyang on 2018/5/17.
 */
public class SQLFirstValueFunctionTest {

    @Test
    public void test_1() {
        String sql = "SELECT employee_id, last_name, salary, hire_date,\n" +
                "       FIRST_VALUE(last_name)\n" +
                "         OVER (ORDER BY salary ASC ROWS UNBOUNDED PRECEDING) AS fv\n" +
                "  FROM (SELECT * FROM employees\n" +
                "          WHERE department_id = 90\n" +
                "          ORDER BY hire_date);";
        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("--------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT employee_id, last_name, salary, hire_date,\n" +
                "\tFIRST_VALUE(last_name) OVER (ORDER BY salary ASC ROWS UNBOUNDED PRECEDING) AS fv\n" +
                "FROM (\n" +
                "\tSELECT *\n" +
                "\tFROM employees\n" +
                "\tWHERE department_id = 90\n" +
                "\tORDER BY hire_date\n" +
                ");", format);
    }


    @Test
    public void test_2() {
        String sql = "SELECT employee_id, last_name, salary, hire_date,\n" +
                "       FIRST_VALUE(last_name)\n" +
                "         OVER (ORDER BY salary ASC, employee_id ROWS UNBOUNDED PRECEDING) AS fv\n" +
                "  FROM (SELECT * FROM employees\n" +
                "          WHERE department_id = 90\n" +
                "          ORDER BY hire_date);";
        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("--------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT employee_id, last_name, salary, hire_date,\n" +
                "       FIRST_VALUE(last_name)\n" +
                "         OVER (ORDER BY salary ASC, employee_id ROWS UNBOUNDED PRECEDING) AS fv\n" +
                "  FROM (SELECT * FROM employees\n" +
                "          WHERE department_id = 90\n" +
                "          ORDER BY hire_date);", format);
    }

    @Test
    public void test_3() {
        String sql = "SELECT employee_id, last_name, salary, hire_date,\n" +
                "       FIRST_VALUE(last_name)\n" +
                "         OVER (ORDER BY salary ASC RANGE UNBOUNDED PRECEDING) AS fv\n" +
                "  FROM (SELECT * FROM employees\n" +
                "          WHERE department_id = 90\n" +
                "          ORDER BY hire_date);";
        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("--------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT employee_id, last_name, salary, hire_date,\n" +
                "\tFIRST_VALUE(last_name) OVER (ORDER BY salary ASC RANGE UNBOUNDED PRECEDING) AS fv\n" +
                "FROM (\n" +
                "\tSELECT *\n" +
                "\tFROM employees\n" +
                "\tWHERE department_id = 90\n" +
                "\tORDER BY hire_date\n" +
                ");", format);
    }

    @Test
    public void test_4() {
        String sql = "SELECT First_Value(Current_Surplus_Qty) OVER (PARTITION BY Mds_Item_Id, Project_Code ORDER BY Mo_Plan_Type DESC, Mds_Item_Id, Project_Code, Balance_Flag, Status DESC, Req_Date, Manufacture_Lotno, Id ROWS 1 PRECEDING) AS fv\n" +
                "  FROM (SELECT * FROM employees\n" +
                "          WHERE department_id = 90\n" +
                "          ORDER BY hire_date);";
        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("--------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT First_Value(Current_Surplus_Qty) OVER (PARTITION BY Mds_Item_Id, Project_Code ORDER BY Mo_Plan_Type DESC, Mds_Item_Id, Project_Code, Balance_Flag, Status DESC, Req_Date, Manufacture_Lotno, Id ROWS 1 PRECEDING) AS fv\n" +
                "FROM (\n" +
                "\tSELECT *\n" +
                "\tFROM employees\n" +
                "\tWHERE department_id = 90\n" +
                "\tORDER BY hire_date\n" +
                ");", format);
    }


}
