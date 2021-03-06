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
package com.aliyun.gumiho.sql.bvt.dialect.oracle.ddl.table.create;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang onCondition 2018/3/15.
 */
public class OracleCreateTableTest_8_ENABLE_DISABLE {

    @Test
    public void test() {
        String s = "CREATE TABLE departments_demo\n" +
                "    ( department_id    NUMBER(4)   PRIMARY KEY DISABLE\n" +
                "    , department_name  VARCHAR2(30)\n" +
                "           CONSTRAINT  dept_name_nn  NOT NULL\n" +
                "    , manager_id       NUMBER(6)\n" +
                "    , location_id      NUMBER(4)\n" +
                "    , dn               VARCHAR2(300)\n" +
                "    ) ; ";

        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE TABLE departments_demo (\n" +
                "\tdepartment_id NUMBER(4) PRIMARY KEY DISABLE,\n" +
                "\tdepartment_name VARCHAR2(30) CONSTRAINT dept_name_nn NOT NULL,\n" +
                "\tmanager_id NUMBER(6),\n" +
                "\tlocation_id NUMBER(4),\n" +
                "\tdn VARCHAR2(300)\n" +
                ");", formatSQL);
    }
}
