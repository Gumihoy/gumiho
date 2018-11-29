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
package com.aliyun.gumiho.sql.bvt.dialect.oracle.fcl;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang onCondition 2018/3/22.
 */
public class OracleNullStatementTest_0 {

    @Test
    public void test1() {
        String sql = "DECLARE\n" +
                "  v_job_id  VARCHAR2(10);\n" +
                "   v_emp_id  NUMBER(6) := 110;\n" +
                "BEGIN\n" +
                "  SELECT job_id INTO v_job_id\n" +
                "  FROM employees\n" +
                "  WHERE employee_id = v_emp_id;\n" +
                "  \n" +
                "  IF v_job_id = 'SA_REP' THEN\n" +
                "    UPDATE employees\n" +
                "    SET commission_pct = commission_pct * 1.2;\n" +
                "  ELSE\n" +
                "    NULL;  -- Employee is not a sales rep\n" +
                "  END IF;\n" +
                "END;";

        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("--------------------");
        System.out.println(format);
        Assert.assertEquals("DECLARE\n" +
                "\tv_job_id VARCHAR2(10);\n" +
                "\tv_emp_id NUMBER(6) := 110;\n" +
                "BEGIN\n" +
                "\tSELECT job_id\n" +
                "\tINTO v_job_id\n" +
                "\tFROM employees\n" +
                "\tWHERE employee_id = v_emp_id;\n" +
                "\tIF v_job_id = 'SA_REP' THEN\n" +
                "\t\tUPDATE employees\n" +
                "\t\tSET commission_pct = commission_pct * 1.2;\n" +
                "\tELSE\n" +
                "\t\tNULL;\n" +
                "\tEND IF;\n" +
                "END;", format);
    }


}
