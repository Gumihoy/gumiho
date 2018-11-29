package com.aliyun.gumiho.sql.bvt.translate.oracle2.mysql.version5_6.ddl.view.create;

import com.aliyun.gumiho.sql.translate.result.SQLTransformResult;
import com.aliyun.gumiho.sql.util.OracleUtils;
import com.aliyun.gumiho.sql.util.SQLTransformUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang
 */
public class Oracle2MySQLCreateViewTest_WITH_CHECK_OPTION {


    @Test
    public void test() {
        String sql = "CREATE VIEW clerk AS\n" +
                "   SELECT employee_id, last_name, department_id, job_id \n" +
                "   FROM employees\n" +
                "   WHERE job_id = 'PU_CLERK' \n" +
                "      or job_id = 'SH_CLERK' \n" +
                "      or job_id = 'ST_CLERK'\n" +
                "   WITH CHECK OPTION CONSTRAINT \"constraint1\";\n";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("CREATE VIEW `clerk`\n" +
                "AS\n" +
                "\tSELECT `employee_id`, `last_name`, `department_id`, `job_id`\n" +
                "\tFROM `employees`\n" +
                "\tWHERE `job_id` = 'PU_CLERK' OR `job_id` = 'SH_CLERK'\n" +
                "\t\tOR `job_id` = 'ST_CLERK'\n" +
                "WITH CHECK OPTION;", result.targetSql);

    }


}
