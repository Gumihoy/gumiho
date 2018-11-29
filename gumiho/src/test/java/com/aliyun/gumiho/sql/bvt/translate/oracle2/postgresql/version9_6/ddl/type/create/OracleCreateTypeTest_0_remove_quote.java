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
package com.aliyun.gumiho.sql.bvt.translate.oracle2.postgresql.version9_6.ddl.type.create;

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
public class OracleCreateTypeTest_0_remove_quote {

    @Test
    public void test1() {
        String sql = "create or replace TYPE \"dmbanimp\" AUTHID CURRENT_USER AS OBJECT (\n" +
                "  \"key\" RAW(4),\n" +
                "  shared_ctx RAW(8),\n" +
                "  STATIC FUNCTION \"ODCITablePrepare\" (\n" +
                "                    \"sctx\"                  IN OUT dmbanimp,\n" +
                "                    tf_info                   SYS.ODCITabFuncInfo,\n" +
                "                    qkn_ptr               IN  RAW,\n" +
                "                    heap_ptr              IN  RAW,\n" +
                "                    query_sequence        IN  CLOB,\n" +
                "                    seqdb_cursor              SYS_REFCURSOR,\n" +
                "                    subsequence_from      IN  PLS_INTEGER  DEFAULT 1,\n" +
                "                    subsequence_to        IN  PLS_INTEGER  DEFAULT -1,\n" +
                "                    filter_low_complexity IN  PLS_INTEGER  DEFAULT 0,\n" +
                "                    mask_lower_case       IN  PLS_INTEGER  DEFAULT 0,\n" +
                "                    expect_value          IN  NUMBER       DEFAULT 10,\n" +
                "                    open_gap_cost         IN  PLS_INTEGER  DEFAULT 5,\n" +
                "                    extend_gap_cost       IN  PLS_INTEGER  DEFAULT 2,\n" +
                "                    mismatch_cost         IN  PLS_INTEGER  DEFAULT -3,\n" +
                "                    match_reward          IN  PLS_INTEGER  DEFAULT 1,\n" +
                "                    word_size             IN  PLS_INTEGER  DEFAULT 11,\n" +
                "                    xdropoff              IN  PLS_INTEGER  DEFAULT 30,\n" +
                "                    final_x_dropoff       IN  PLS_INTEGER  DEFAULT 50\n" +
                "                  ) RETURN PLS_INTEGER,\n" +
                "  STATIC FUNCTION ODCITableStart (\n" +
                "                    sctx                  IN OUT dmbanimp,\n" +
                "                    rws_ptr               IN  RAW,\n" +
                "                    query_sequence        IN  CLOB,\n" +
                "                    seqdb_cursor              SYS_REFCURSOR,\n" +
                "                    subsequence_from      IN  PLS_INTEGER  DEFAULT 1,\n" +
                "                    subsequence_to        IN  PLS_INTEGER  DEFAULT -1,\n" +
                "                    filter_low_complexity IN  PLS_INTEGER  DEFAULT 0,\n" +
                "                    mask_lower_case       IN  PLS_INTEGER  DEFAULT 0,\n" +
                "                    expect_value          IN  NUMBER       DEFAULT 10,\n" +
                "                    open_gap_cost         IN  PLS_INTEGER  DEFAULT 5,\n" +
                "                    extend_gap_cost       IN  PLS_INTEGER  DEFAULT 2,\n" +
                "                    mismatch_cost         IN  PLS_INTEGER  DEFAULT -3,\n" +
                "                    match_reward          IN  PLS_INTEGER  DEFAULT 1,\n" +
                "                    word_size             IN  PLS_INTEGER  DEFAULT 11,\n" +
                "                    xdropoff              IN  PLS_INTEGER  DEFAULT 30,\n" +
                "                    final_x_dropoff       IN  PLS_INTEGER  DEFAULT 50\n" +
                "                  ) RETURN NUMBER,\n" +
                "  MEMBER FUNCTION ODCITableFetch (\n" +
                "                    self             IN OUT dmbanimp,\n" +
                "                    nrows            IN     NUMBER,\n" +
                "                    outset           OUT    dmbaos\n" +
                "                  ) RETURN NUMBER,\n" +
                "  MEMBER FUNCTION \"ODCITableClose\" (\n" +
                "                    self             IN  dmbanimp\n" +
                "                                 ) RETURN NUMBER,\n" +
                "  STATIC FUNCTION dmbanPrepareStub (\n" +
                "                    sctx                  IN OUT dmbanimp,\n" +
                "                    tf_info                  SYS.ODCITabFuncInfo,\n" +
                "                    qkn_ptr               IN RAW,\n" +
                "                    heap_ptr              IN RAW,\n" +
                "                    query_sequence        IN CLOB,\n" +
                "                    seqdb_cursor             SYS_REFCURSOR,\n" +
                "                    subsequence_from      IN PLS_INTEGER,\n" +
                "                    subsequence_to        IN PLS_INTEGER,\n" +
                "                    filter_low_complexity IN PLS_INTEGER,\n" +
                "                    mask_lower_case       IN PLS_INTEGER,\n" +
                "                    expect_value          IN NUMBER,\n" +
                "                    open_gap_cost         IN PLS_INTEGER,\n" +
                "                    extend_gap_cost       IN PLS_INTEGER,\n" +
                "                    mismatch_cost         IN PLS_INTEGER,\n" +
                "                    match_reward          IN PLS_INTEGER,\n" +
                "                    word_size             IN PLS_INTEGER,\n" +
                "                    xdropoff              IN PLS_INTEGER,\n" +
                "                    final_x_dropoff       IN PLS_INTEGER\n" +
                "                  ) RETURN PLS_INTEGER,\n" +
                "  STATIC FUNCTION dmbanStartStub (\n" +
                "                    sctx                  IN OUT dmbanimp,\n" +
                "                    rws_ptr               IN  RAW,\n" +
                "                    query_sequence        IN CLOB,\n" +
                "                    seqdb_cursor             SYS_REFCURSOR,\n" +
                "                    subsequence_from      IN PLS_INTEGER,\n" +
                "                    subsequence_to        IN PLS_INTEGER,\n" +
                "                    filter_low_complexity IN PLS_INTEGER,\n" +
                "                    mask_lower_case       IN PLS_INTEGER,\n" +
                "                    expect_value          IN NUMBER,\n" +
                "                    open_gap_cost         IN PLS_INTEGER,\n" +
                "                    extend_gap_cost       IN PLS_INTEGER,\n" +
                "                    mismatch_cost         IN PLS_INTEGER,\n" +
                "                    match_reward          IN PLS_INTEGER,\n" +
                "                    word_size             IN PLS_INTEGER,\n" +
                "                    xdropoff              IN PLS_INTEGER,\n" +
                "                    final_x_dropoff       IN PLS_INTEGER\n" +
                "                  ) RETURN NUMBER,\n" +
                "  MEMBER FUNCTION dmbanFetchStub (\n" +
                "                    self             IN OUT dmbanimp,\n" +
                "                    nrows            IN     NUMBER,\n" +
                "                    outset           OUT    dmbaos\n" +
                "                  ) RETURN NUMBER,\n" +
                "  MEMBER FUNCTION dmbanCloseStub (\n" +
                "                    self             IN dmbanimp\n" +
                "                  ) RETURN NUMBER\n" +
                ");";

        SQLTransformConfig config = new SQLTransformConfig();
        config.doubleQuoteAction = DoubleQuoteActionType.REMOVE;
        SQLTransformResult result = SQLTransformUtils.oracleToPPAS(sql, config);
        System.out.println(SQLUtils.format(sql, DBType.Oracle));
        System.out.println("----------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("create or replace TYPE \"dmbanimp\" AUTHID CURRENT_USER AS OBJECT (\n" +
                "  \"key\" RAW(4),\n" +
                "  shared_ctx RAW(8),\n" +
                "  STATIC FUNCTION \"ODCITablePrepare\" (\n" +
                "                    \"sctx\"                  IN OUT dmbanimp,\n" +
                "                    tf_info                   SYS.ODCITabFuncInfo,\n" +
                "                    qkn_ptr               IN  RAW,\n" +
                "                    heap_ptr              IN  RAW,\n" +
                "                    query_sequence        IN  CLOB,\n" +
                "                    seqdb_cursor              SYS_REFCURSOR,\n" +
                "                    subsequence_from      IN  PLS_INTEGER  DEFAULT 1,\n" +
                "                    subsequence_to        IN  PLS_INTEGER  DEFAULT -1,\n" +
                "                    filter_low_complexity IN  PLS_INTEGER  DEFAULT 0,\n" +
                "                    mask_lower_case       IN  PLS_INTEGER  DEFAULT 0,\n" +
                "                    expect_value          IN  NUMBER       DEFAULT 10,\n" +
                "                    open_gap_cost         IN  PLS_INTEGER  DEFAULT 5,\n" +
                "                    extend_gap_cost       IN  PLS_INTEGER  DEFAULT 2,\n" +
                "                    mismatch_cost         IN  PLS_INTEGER  DEFAULT -3,\n" +
                "                    match_reward          IN  PLS_INTEGER  DEFAULT 1,\n" +
                "                    word_size             IN  PLS_INTEGER  DEFAULT 11,\n" +
                "                    xdropoff              IN  PLS_INTEGER  DEFAULT 30,\n" +
                "                    final_x_dropoff       IN  PLS_INTEGER  DEFAULT 50\n" +
                "                  ) RETURN PLS_INTEGER,\n" +
                "  STATIC FUNCTION ODCITableStart (\n" +
                "                    sctx                  IN OUT dmbanimp,\n" +
                "                    rws_ptr               IN  RAW,\n" +
                "                    query_sequence        IN  CLOB,\n" +
                "                    seqdb_cursor              SYS_REFCURSOR,\n" +
                "                    subsequence_from      IN  PLS_INTEGER  DEFAULT 1,\n" +
                "                    subsequence_to        IN  PLS_INTEGER  DEFAULT -1,\n" +
                "                    filter_low_complexity IN  PLS_INTEGER  DEFAULT 0,\n" +
                "                    mask_lower_case       IN  PLS_INTEGER  DEFAULT 0,\n" +
                "                    expect_value          IN  NUMBER       DEFAULT 10,\n" +
                "                    open_gap_cost         IN  PLS_INTEGER  DEFAULT 5,\n" +
                "                    extend_gap_cost       IN  PLS_INTEGER  DEFAULT 2,\n" +
                "                    mismatch_cost         IN  PLS_INTEGER  DEFAULT -3,\n" +
                "                    match_reward          IN  PLS_INTEGER  DEFAULT 1,\n" +
                "                    word_size             IN  PLS_INTEGER  DEFAULT 11,\n" +
                "                    xdropoff              IN  PLS_INTEGER  DEFAULT 30,\n" +
                "                    final_x_dropoff       IN  PLS_INTEGER  DEFAULT 50\n" +
                "                  ) RETURN NUMBER,\n" +
                "  MEMBER FUNCTION ODCITableFetch (\n" +
                "                    self             IN OUT dmbanimp,\n" +
                "                    nrows            IN     NUMBER,\n" +
                "                    outset           OUT    dmbaos\n" +
                "                  ) RETURN NUMBER,\n" +
                "  MEMBER FUNCTION \"ODCITableClose\" (\n" +
                "                    self             IN  dmbanimp\n" +
                "                                 ) RETURN NUMBER,\n" +
                "  STATIC FUNCTION dmbanPrepareStub (\n" +
                "                    sctx                  IN OUT dmbanimp,\n" +
                "                    tf_info                  SYS.ODCITabFuncInfo,\n" +
                "                    qkn_ptr               IN RAW,\n" +
                "                    heap_ptr              IN RAW,\n" +
                "                    query_sequence        IN CLOB,\n" +
                "                    seqdb_cursor             SYS_REFCURSOR,\n" +
                "                    subsequence_from      IN PLS_INTEGER,\n" +
                "                    subsequence_to        IN PLS_INTEGER,\n" +
                "                    filter_low_complexity IN PLS_INTEGER,\n" +
                "                    mask_lower_case       IN PLS_INTEGER,\n" +
                "                    expect_value          IN NUMBER,\n" +
                "                    open_gap_cost         IN PLS_INTEGER,\n" +
                "                    extend_gap_cost       IN PLS_INTEGER,\n" +
                "                    mismatch_cost         IN PLS_INTEGER,\n" +
                "                    match_reward          IN PLS_INTEGER,\n" +
                "                    word_size             IN PLS_INTEGER,\n" +
                "                    xdropoff              IN PLS_INTEGER,\n" +
                "                    final_x_dropoff       IN PLS_INTEGER\n" +
                "                  ) RETURN PLS_INTEGER,\n" +
                "  STATIC FUNCTION dmbanStartStub (\n" +
                "                    sctx                  IN OUT dmbanimp,\n" +
                "                    rws_ptr               IN  RAW,\n" +
                "                    query_sequence        IN CLOB,\n" +
                "                    seqdb_cursor             SYS_REFCURSOR,\n" +
                "                    subsequence_from      IN PLS_INTEGER,\n" +
                "                    subsequence_to        IN PLS_INTEGER,\n" +
                "                    filter_low_complexity IN PLS_INTEGER,\n" +
                "                    mask_lower_case       IN PLS_INTEGER,\n" +
                "                    expect_value          IN NUMBER,\n" +
                "                    open_gap_cost         IN PLS_INTEGER,\n" +
                "                    extend_gap_cost       IN PLS_INTEGER,\n" +
                "                    mismatch_cost         IN PLS_INTEGER,\n" +
                "                    match_reward          IN PLS_INTEGER,\n" +
                "                    word_size             IN PLS_INTEGER,\n" +
                "                    xdropoff              IN PLS_INTEGER,\n" +
                "                    final_x_dropoff       IN PLS_INTEGER\n" +
                "                  ) RETURN NUMBER,\n" +
                "  MEMBER FUNCTION dmbanFetchStub (\n" +
                "                    self             IN OUT dmbanimp,\n" +
                "                    nrows            IN     NUMBER,\n" +
                "                    outset           OUT    dmbaos\n" +
                "                  ) RETURN NUMBER,\n" +
                "  MEMBER FUNCTION dmbanCloseStub (\n" +
                "                    self             IN dmbanimp\n" +
                "                  ) RETURN NUMBER\n" +
                ");", result.targetSql);
    }
}
