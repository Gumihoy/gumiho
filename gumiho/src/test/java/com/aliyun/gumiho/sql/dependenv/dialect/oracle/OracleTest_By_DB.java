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
package com.aliyun.gumiho.sql.dependenv.dialect.oracle;

import com.aliyun.gumiho.sql.basic.ast.SQLObject;
import com.aliyun.gumiho.sql.dependenv.basic.SQLTest_By_DB;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLParserUtils;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author kongtong.ouyang onCondition 2018/3/15.
 */
public class OracleTest_By_DB extends SQLTest_By_DB {

    @Test
    public void test_0() throws Exception {
//        long dbid = 1801196429L;
//        test_by_dbid(dbid);
        List<Long> dbids = new ArrayList<>();
        loadDBID(dbid -> {
            dbids.add(dbid);
        });

        for (Long dbid : dbids) {
            if (dbid == null) {
                continue;
            }
            test_by_dbid(dbid);
        }
    }

    public void test_by_dbid(long dbid) throws SQLException {
        List<SQL> sqls = new ArrayList<>();
        loadPPASDDL(dbid, sql -> {
            sqls.add(sql);
        });

        for (SQL sql : sqls) {
            List<SQLObject> stmtList;
            try {
                stmtList = SQLParserUtils.parse(sql.sourceSQL, DBType.Oracle);
            } catch (Exception e) {
                System.out.println(sql.sourceSQL);
                e.printStackTrace();
            }
        }
    }


}
