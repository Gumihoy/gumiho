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
package com.aliyun.gumiho.sql.bvt.dialect.oracle.dml.select;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang onCondition 2018/3/22.
 */
public class OracleSelectTest_2_With_Clause_Recursive_Subquery_Factoring {

    @Test
    public void test1() {
        String sql = "WITH\n" +
                "  reports_to_101 (eid, emp_last, mgr_id, reportLevel) AS\n" +
                "  (\n" +
                "     SELECT employee_id, last_name, manager_id, 0 reportLevel\n" +
                "     FROM employees\n" +
                "     WHERE employee_id = 101\n" +
                "   UNION ALL\n" +
                "     SELECT e.employee_id, e.last_name, e.manager_id, reportLevel+1\n" +
                "     FROM reports_to_101 r, employees e\n" +
                "     WHERE r.eid = e.manager_id\n" +
                "  )\n" +
                "SELECT eid, emp_last, mgr_id, reportLevel\n" +
                "FROM reports_to_101\n" +
                "ORDER BY reportLevel, eid;";
        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
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
                "FROM reports_to_101\n" +
                "ORDER BY reportLevel, eid;", format);
    }


    @Test
    public void test2() {
        String sql = "WITH\n" +
                "  reports_to_101 (eid, emp_last, mgr_id, reportLevel, mgr_list) AS\n" +
                "  (\n" +
                "     SELECT employee_id, last_name, manager_id, 0 reportLevel,\n" +
                "            CAST(manager_id AS VARCHAR2(2000))\n" +
                "     FROM employees\n" +
                "     WHERE employee_id = 101\n" +
                "  UNION ALL\n" +
                "     SELECT e.employee_id, e.last_name, e.manager_id, reportLevel+1,\n" +
                "            CAST(mgr_list || ',' || manager_id AS VARCHAR2(2000))\n" +
                "     FROM reports_to_101 r, employees e\n" +
                "     WHERE r.eid = e.manager_id\n" +
                "  )\n" +
                "SELECT eid, emp_last, mgr_id, reportLevel, mgr_list\n" +
                "FROM reports_to_101";
        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("WITH\n" +
                "\treports_to_101 (eid, emp_last, mgr_id, reportLevel, mgr_list) AS (\n" +
                "\t\tSELECT employee_id, last_name, manager_id, 0 reportLevel,\n" +
                "\t\t\tCAST(manager_id AS VARCHAR2(2000))\n" +
                "\t\tFROM employees\n" +
                "\t\tWHERE employee_id = 101\n" +
                "\t\tUNION ALL\n" +
                "\t\tSELECT e.employee_id, e.last_name, e.manager_id, reportLevel + 1,\n" +
                "\t\t\tCAST(mgr_list || ',' || manager_id AS VARCHAR2(2000))\n" +
                "\t\tFROM reports_to_101 r, employees e\n" +
                "\t\tWHERE r.eid = e.manager_id\n" +
                "\t)\n" +
                "SELECT eid, emp_last, mgr_id, reportLevel, mgr_list\n" +
                "FROM reports_to_101", format);
    }


    @Test
    public void test3() {
        String sql = "WITH\n" +
                "  reports_to_101 (eid, emp_last, mgr_id, reportLevel) AS\n" +
                "  (\n" +
                "    SELECT employee_id, last_name, manager_id, 0 reportLevel\n" +
                "    FROM employees\n" +
                "    WHERE employee_id = 101\n" +
                "  UNION ALL\n" +
                "    SELECT e.employee_id, e.last_name, e.manager_id, reportLevel+1\n" +
                "    FROM reports_to_101 r, employees e\n" +
                "    WHERE r.eid = e.manager_id\n" +
                "  )\n" +
                "SELECT eid, emp_last, mgr_id, reportLevel\n" +
                "FROM reports_to_101\n" +
                "WHERE reportLevel <= 1\n" +
                "ORDER BY reportLevel, eid;";
        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
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
                "FROM reports_to_101\n" +
                "WHERE reportLevel <= 1\n" +
                "ORDER BY reportLevel, eid;", format);
    }


    @Test
    public void test4() {
        String sql = "WITH\n" +
                "  org_chart (eid, emp_last, mgr_id, reportLevel, salary, job_id) AS\n" +
                "  (\n" +
                "    SELECT employee_id, last_name, manager_id, 0 reportLevel, salary, job_id\n" +
                "    FROM employees\n" +
                "    WHERE manager_id is null\n" +
                "  UNION ALL\n" +
                "    SELECT e.employee_id, e.last_name, e.manager_id,\n" +
                "           r.reportLevel+1 reportLevel, e.salary, e.job_id\n" +
                "    FROM org_chart r, employees e\n" +
                "    WHERE r.eid = e.manager_id\n" +
                "  )\n" +
                "  SEARCH DEPTH FIRST BY emp_last SET order1\n" +
                "SELECT lpad(' ',2*reportLevel)||emp_last emp_name, eid, mgr_id, salary, job_id\n" +
                "FROM org_chart\n" +
                "ORDER BY order1;";
        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("WITH\n" +
                "\torg_chart (eid, emp_last, mgr_id, reportLevel, salary, job_id) AS (\n" +
                "\t\tSELECT employee_id, last_name, manager_id, 0 reportLevel, salary, job_id\n" +
                "\t\tFROM employees\n" +
                "\t\tWHERE manager_id IS NULL\n" +
                "\t\tUNION ALL\n" +
                "\t\tSELECT e.employee_id, e.last_name, e.manager_id,\n" +
                "\t\t\tr.reportLevel + 1 reportLevel, e.salary, e.job_id\n" +
                "\t\tFROM org_chart r, employees e\n" +
                "\t\tWHERE r.eid = e.manager_id\n" +
                "\t)\n" +
                "\tSEARCH DEPTH FIRST BY emp_last SET order1\n" +
                "SELECT lpad(' ', 2 * reportLevel) || emp_last emp_name, eid, mgr_id,\n" +
                "\tsalary, job_id\n" +
                "FROM org_chart\n" +
                "ORDER BY order1;", format);
    }


    @Test
    public void test5() {
        String sql = "WITH\n" +
                "  dup_hiredate (eid, emp_last, mgr_id, reportLevel, hire_date, job_id) AS\n" +
                "  (\n" +
                "    SELECT employee_id, last_name, manager_id, 0 reportLevel, hire_date, job_id\n" +
                "    FROM employees\n" +
                "    WHERE manager_id is null\n" +
                "  UNION ALL\n" +
                "    SELECT e.employee_id, e.last_name, e.manager_id,\n" +
                "           r.reportLevel+1 reportLevel, e.hire_date, e.job_id\n" +
                "    FROM dup_hiredate r, employees e\n" +
                "    WHERE r.eid = e.manager_id\n" +
                "  )\n" +
                "  SEARCH DEPTH FIRST BY hire_date SET order1\n" +
                "  CYCLE hire_date SET is_cycle TO 'Y' DEFAULT 'N'\n" +
                "SELECT lpad(' ',2*reportLevel)||emp_last emp_name, eid, mgr_id,\n" +
                "       hire_date, job_id, is_cycle\n" +
                "FROM dup_hiredate\n" +
                "ORDER BY order1;";
        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("WITH\n" +
                "\tdup_hiredate (eid, emp_last, mgr_id, reportLevel, hire_date, job_id) AS (\n" +
                "\t\tSELECT employee_id, last_name, manager_id, 0 reportLevel, hire_date, job_id\n" +
                "\t\tFROM employees\n" +
                "\t\tWHERE manager_id IS NULL\n" +
                "\t\tUNION ALL\n" +
                "\t\tSELECT e.employee_id, e.last_name, e.manager_id,\n" +
                "\t\t\tr.reportLevel + 1 reportLevel, e.hire_date, e.job_id\n" +
                "\t\tFROM dup_hiredate r, employees e\n" +
                "\t\tWHERE r.eid = e.manager_id\n" +
                "\t)\n" +
                "\tSEARCH DEPTH FIRST BY hire_date SET order1\n" +
                "\tCYCLE hire_date SET is_cycle TO 'Y' DEFAULT 'N'\n" +
                "SELECT lpad(' ', 2 * reportLevel) || emp_last emp_name, eid, mgr_id,\n" +
                "\thire_date, job_id, is_cycle\n" +
                "FROM dup_hiredate\n" +
                "ORDER BY order1;", format);
    }


    @Test
    public void test6() {
        String sql = "WITH\n" +
                "  emp_count (eid, emp_last, mgr_id, mgrLevel, salary, cnt_employees) AS\n" +
                "  (\n" +
                "    SELECT employee_id, last_name, manager_id, 0 mgrLevel, salary, 0 cnt_employees\n" +
                "    FROM employees\n" +
                "  UNION ALL\n" +
                "    SELECT e.employee_id, e.last_name, e.manager_id,\n" +
                "           r.mgrLevel+1 mgrLevel, e.salary, 1 cnt_employees\n" +
                "    FROM emp_count r, employees e\n" +
                "    WHERE e.employee_id = r.mgr_id\n" +
                "  )\n" +
                "  SEARCH DEPTH FIRST BY emp_last SET order1\n" +
                "SELECT emp_last, eid, mgr_id, salary, sum(cnt_employees), max(mgrLevel) mgrLevel\n" +
                "FROM emp_count\n" +
                "GROUP BY emp_last, eid, mgr_id, salary\n" +
                "HAVING max(mgrLevel) > 0\n" +
                "ORDER BY mgr_id NULLS FIRST, emp_last;\n";
        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("WITH\n" +
                "\temp_count (eid, emp_last, mgr_id, mgrLevel, salary, cnt_employees) AS (\n" +
                "\t\tSELECT employee_id, last_name, manager_id, 0 mgrLevel, salary,\n" +
                "\t\t\t0 cnt_employees\n" +
                "\t\tFROM employees\n" +
                "\t\tUNION ALL\n" +
                "\t\tSELECT e.employee_id, e.last_name, e.manager_id, r.mgrLevel + 1 mgrLevel,\n" +
                "\t\t\te.salary, 1 cnt_employees\n" +
                "\t\tFROM emp_count r, employees e\n" +
                "\t\tWHERE e.employee_id = r.mgr_id\n" +
                "\t)\n" +
                "\tSEARCH DEPTH FIRST BY emp_last SET order1\n" +
                "SELECT emp_last, eid, mgr_id, salary, sum(cnt_employees),\n" +
                "\tmax(mgrLevel) mgrLevel\n" +
                "FROM emp_count\n" +
                "GROUP BY emp_last, eid, mgr_id, salary\n" +
                "HAVING max(mgrLevel) > 0\n" +
                "ORDER BY mgr_id NULLS FIRST, emp_last;", format);
    }
}
