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
package com.aliyun.gumiho.sql.bvt.dialect.oracle.ddl.comment;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/sqlrf/COMMENT.html#GUID-65F447C4-6914-4823-9691-F15D52DB74D7
 *
 * @author kongtong.ouyang on 2018/3/27.
 */
public class OracleSQLCommentOnTest {

    @Test
    public void testCommentOnAuditPolicyStatement() {
        String sql = "COMMENT ON AUDIT POLICY AUDIT_UNIFIED_POLICY_COMMENTS is ' ' ";

        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------");
        System.out.println(format);

        Assert.assertEquals("COMMENT ON AUDIT POLICY AUDIT_UNIFIED_POLICY_COMMENTS IS ' '", format);
    }

    @Test
    public void testCommentOnColumnStatement1() {
        String sql = "COMMENT ON COLUMN employees.job_id \n" +
                "   IS 'abbreviated job title';";


        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------");
        System.out.println(format);

        Assert.assertEquals("COMMENT ON COLUMN employees.job_id IS 'abbreviated job title';", format);
    }

    @Test
    public void testCommentOnColumnStatement2() {
        String sql = "comment on column employees.job_id is ' '; ";

        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------");
        System.out.println(format);

        Assert.assertEquals("COMMENT ON COLUMN employees.job_id IS ' ';", format);
    }

    @Test
    public void testCommentOnEditionStatement() {
        String sql = "COMMENT ON Edition edition_name is ' ' ";

        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------");
        System.out.println(format);

        Assert.assertEquals("COMMENT ON EDITION edition_name IS ' '", format);
    }

    @Test
    public void testCommentOnIndexTypeStatement() {
        String sql = "COMMENT ON IndexType schema.indextype is ' ' ";

        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------");
        System.out.println(format);

        Assert.assertEquals("COMMENT ON INDEXTYPE schema.indextype IS ' '", format);
    }

    @Test
    public void testCommentOnMaterializedViewStatement() {
        String sql = "COMMENT ON MATERIALIZED VIEW materialized_view is ' ' ";

        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------");
        System.out.println(format);

        Assert.assertEquals("COMMENT ON MATERIALIZED VIEW materialized_view IS ' '", format);
    }

    @Test
    public void testCommentOnMiningModelStatement() {
        String sql = "COMMENT ON MINING MODEL schema.model is ' ' ";

        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------");
        System.out.println(format);

        Assert.assertEquals("COMMENT ON MINING MODEL schema.model IS ' '", format);
    }

    @Test
    public void testCommentOnOperatorStatement() {
        String sql = "COMMENT ON OPERATOR operator is ' ' ";

        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------");
        System.out.println(format);

        Assert.assertEquals("COMMENT ON OPERATOR operator IS ' '", format);
    }


    @Test
    public void testCommentOnTableStatement() {
        String sql = "COMMENT ON TABLE \"table\" is ' ' ";

        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------");
        System.out.println(format);

        Assert.assertEquals("COMMENT ON TABLE \"table\" IS ' '", format);
    }
}
