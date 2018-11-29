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
package com.aliyun.gumiho.sql.bvt.translate.oracle2.ppas.version9_6.ddl.sequence.create;

import com.aliyun.gumiho.sql.enums.DBVersion;
import com.aliyun.gumiho.sql.translate.SQLTransformConfig;
import com.aliyun.gumiho.sql.translate.result.SQLTransformResult;
import com.aliyun.gumiho.sql.util.SQLTransformUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang onCondition 2018/3/15.
 */
public class OracleCreateSequenceTest_1_MINVALUE {

    @Test
    public void test() {
        String s = "CREATE SEQUENCE  \"J1_KJHS\".\"SEQ_THUNISOFT_ETL_LOG\"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 2 NOCACHE  NOORDER  NOCYCLE";

        SQLTransformConfig config = new SQLTransformConfig();
        config.targetVersion = DBVersion.PPAS_VERSION_10;
        SQLTransformResult result = SQLTransformUtils.oracleToPPAS(s, config);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("CREATE SEQUENCE J1_KJHS.SEQ_THUNISOFT_ETL_LOG MINVALUE 1 MAXVALUE 9223372036854775807 INCREMENT BY 1 START WITH 2 NOCACHE NO CYCLE", result.targetSql);
    }
}
