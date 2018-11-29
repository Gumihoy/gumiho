/*
 * Copyright (C) 2017-2018 kent(kent.bohai@gmail.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.aliyun.gumiho.sql.bvt.translate.oracle2.postgresql.version9_6.dml.select;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.DoubleQuoteActionType;
import com.aliyun.gumiho.sql.translate.SQLTransformConfig;
import com.aliyun.gumiho.sql.translate.result.SQLTransformResult;
import com.aliyun.gumiho.sql.util.SQLTransformUtils;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang onCondition 2018/3/22.
 */
public class OracleSelectTest_0_remove_quote {

    @Test
    public void test1() {
        String sql = "WITH\n" +
                "  reports_to_101 (\"eid\", emp_last, mgr_id, reportLevel) AS\n" +
                "  (\n" +
                "    SELECT employee_id, last_name, manager_id, 0 reportLevel\n" +
                "    FROM employees\n" +
                "    WHERE employee_id = 101\n" +
                "  UNION ALL\n" +
                "    SELECT e.\"employee_id\", e.last_name, e.manager_id, reportLevel+1\n" +
                "    FROM \"reports_to_101\" r, \"employees\" e\n" +
                "    WHERE r.eid = e.manager_id\n" +
                "  )\n" +
                "SELECT \"eid\", \"emp_last\", \"mgr_id\", \"reportLevel\"\n" +
                "FROM reports_to_101 as \"rs\"\n" +
                "WHERE \"reportLevel\" <= 1\n" +
                "START WITH \"job_id\" = 'AD_VP'\n" +
                "CONNECT BY PRIOR \"employee_id\" = \"manager_id\"\n" +
                "GROUP BY \"department_id\"\n" +
                "HAVING MIN(\"salary\") < 5000\n" +
                "ORDER BY \"reportLevel\", \"eid\";";

        SQLTransformConfig config = new SQLTransformConfig();
        config.doubleQuoteAction = DoubleQuoteActionType.REMOVE;
        SQLTransformResult result = SQLTransformUtils.oracleToPPAS(sql, config);
        System.out.println(SQLUtils.format(sql, DBType.Oracle));
        System.out.println("----------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("WITH\n" +
                "\treports_to_101 (eid, emp_last, mgr_id, reportLevel) AS (\n" +
                "\t\tSELECT employee_id, last_name, manager_id, 0 reportLevel\n" +
                "\t\tFROM employees\n" +
                "\t\tWHERE employee_id = 101\n" +
                "\t\tUNION ALL\n" +
                "\t\tSELECT e.employee_id, e.last_name, e.manager_id, reportLevel + 1\n" +
                "\t\tFROM reports_to_101 r, employees e\n" +
                "\t\tWHERE r.eid = e.manager_id\n" +
                "\t)\n" +
                "SELECT eid, emp_last, mgr_id, reportLevel\n" +
                "FROM reports_to_101 AS rs\n" +
                "WHERE reportLevel <= 1\n" +
                "START WITH job_id = 'AD_VP'\n" +
                "CONNECT BY PRIOR employee_id = manager_id\n" +
                "GROUP BY department_id\n" +
                "HAVING MIN(salary) < 5000\n" +
                "ORDER BY reportLevel, eid;", result.targetSql);
    }
}
