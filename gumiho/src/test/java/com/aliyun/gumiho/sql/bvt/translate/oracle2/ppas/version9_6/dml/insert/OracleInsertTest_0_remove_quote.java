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
package com.aliyun.gumiho.sql.bvt.translate.oracle2.ppas.version9_6.dml.insert;

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
public class OracleInsertTest_0_remove_quote {

    @Test
    public void test1() {
        String sql = "insert into \"dual\"(\"id\", \"name\") values (1, '1'), (2, '2')";

        SQLTransformConfig config = new SQLTransformConfig();
        config.doubleQuoteAction = DoubleQuoteActionType.REMOVE;
        SQLTransformResult result = SQLTransformUtils.oracleToPPAS(sql, config);
        System.out.println(SQLUtils.format(sql, DBType.Oracle));
        System.out.println("----------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("INSERT INTO dual (id, name)\n" +
                "VALUES (1, '1'),\n" +
                "\t(2, '2')", result.targetSql);
    }
}
