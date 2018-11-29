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
package com.aliyun.gumiho.sql.bvt.translate.oracle2.ppas.version9_6.ddl.procedure.create;

import com.aliyun.gumiho.sql.translate.result.SQLTransformResult;
import com.aliyun.gumiho.sql.util.SQLTransformUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang onCondition 2018/3/15.
 */
public class OracleCreateProcedureTest_1_External_Procedure {

    @Test
    public void test() {
        String s = "CREATE PROCEDURE find_root\n" +
                "   ( x IN REAL ) \n" +
                "   IS LANGUAGE C\n" +
                "      NAME c_find_root\n" +
                "      LIBRARY c_utils\n" +
                "      PARAMETERS ( x BY REFERENCE );";

        SQLTransformResult result = SQLTransformUtils.oracleToPPAS(s);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("CREATE PROCEDURE find_root (\n" +
                "\tx IN REAL\n" +
                ")\n" +
                "IS\n" +
                "\tLANGUAGE C NAME c_find_root LIBRARY c_utils PARAMETERS (x BY REFERENCE);", result.targetSql);
    }
}
