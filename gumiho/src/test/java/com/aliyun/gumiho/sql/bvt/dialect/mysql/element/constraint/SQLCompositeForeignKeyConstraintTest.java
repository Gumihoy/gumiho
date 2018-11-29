package com.aliyun.gumiho.sql.bvt.dialect.mysql.element.constraint;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/AVG.html#GUID-B64BCBF1-DAA0-4D88-9821-2C4D3FDE5E4A
 *
 * @author kongtong.ouyang on 2018/5/17.
 */
public class SQLCompositeForeignKeyConstraintTest {

    @Test
    public void test_1() {
        String sql = "ALTER TABLE dept_20\n" +
                "   ADD CONSTRAINT fk_empid_hiredate\n" +
                "   FOREIGN KEY (employee_id, hire_date)\n" +
                "   REFERENCES hr.job_history(employee_id, start_date)\n" +
                "   EXCEPTIONS INTO wrong_emp; ";

        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("-------------------");
        System.out.println(format);
        Assert.assertEquals("ALTER TABLE dept_20\n" +
                "   ADD CONSTRAINT fk_empid_hiredate\n" +
                "   FOREIGN KEY (employee_id, hire_date)\n" +
                "   REFERENCES hr.job_history(employee_id, start_date)\n" +
                "   EXCEPTIONS INTO wrong_emp;", format);
    }

}
