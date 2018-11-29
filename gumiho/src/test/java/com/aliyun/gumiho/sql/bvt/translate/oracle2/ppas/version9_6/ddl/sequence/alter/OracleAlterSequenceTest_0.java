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
package com.aliyun.gumiho.sql.bvt.translate.oracle2.ppas.version9_6.ddl.sequence.alter;

import com.aliyun.gumiho.sql.translate.result.SQLTransformResult;
import com.aliyun.gumiho.sql.util.SQLTransformUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang onCondition 2018/3/15.
 */
public class OracleAlterSequenceTest_0 {

    @Test
    public void test() {
        String s = "ALTER SEQUENCE customers_seq \n" +
                "   MAXVALUE 1500;";

        SQLTransformResult result = SQLTransformUtils.oracleToPPAS(s);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("ALTER SEQUENCE customers_seq MAXVALUE 1500;", result.targetSql);
    }
}