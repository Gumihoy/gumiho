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
public class OracleSelectTest_0_With_Clause {

    @Test
    public void test1() {
        String sql = "WITH\n" +
                " FUNCTION get_domain(url VARCHAR2) RETURN VARCHAR2 IS\n" +
                "   pos BINARY_INTEGER;\n" +
                "   len BINARY_INTEGER;\n" +
                " BEGIN\n" +
                "   pos := INSTR(url, 'www.');\n" +
                "   len := INSTR(SUBSTR(url, pos + 4), '.') - 1;\n" +
                "   RETURN SUBSTR(url, pos + 4, len);\n" +
                " END;\n" +
                "SELECT DISTINCT get_domain(catalog_url)\n" +
                "  FROM product_information;\n" +
                "/";
        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("WITH\n" +
                "\tFUNCTION get_domain (\n" +
                "\t\turl VARCHAR2\n" +
                "\t) RETURN VARCHAR2 IS\n" +
                "\t\tpos BINARY_INTEGER;\n" +
                "\t\tlen BINARY_INTEGER;\n" +
                "\t\tBEGIN\n" +
                "\t\t\tpos := INSTR(url, 'www.');\n" +
                "\t\t\tlen := INSTR(SUBSTR(url, pos + 4), '.') - 1;\n" +
                "\t\t\tRETURN SUBSTR(url, pos + 4, len);\n" +
                "\t\tEND;\n" +
                "SELECT DISTINCT get_domain(catalog_url)\n" +
                "FROM product_information;", format);
    }
}
