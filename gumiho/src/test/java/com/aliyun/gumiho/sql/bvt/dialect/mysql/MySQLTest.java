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
package com.aliyun.gumiho.sql.bvt.dialect.mysql;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.operator.SQLBinaryOperatorExpr;
import com.aliyun.gumiho.sql.basic.ast.element.literal.numeric.SQLIntegerLiteral;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLBinaryOperator;
import com.aliyun.gumiho.sql.translate.SQLTransformConfig;
import com.aliyun.gumiho.sql.util.MySQLUtils;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Test;

/**
 * @author kongtong.ouyang onCondition 2018/3/15.
 */
public class MySQLTest {

    @Test
    public void test() throws Exception {
        String sql = "CREATE TABLE `ASSIGNQUOTA` (\n" +
                "\t`FILEID` DECIMAL(19) NOT NULL COMMENT '分配总序号',\n" +
                "\t`BUDGETCATEGORYGUID` DECIMAL(19) COMMENT '指标类型id',\n" +
                "\t`BUDGETCATEGORYNAME` VARCHAR(255) COMMENT '指标类型名称',\n" +
                "\t`CHILDRENNUM` DECIMAL(19) COMMENT '项目明细的记录数',\n" +
                "\t`DELIVERDATE` DATETIME COMMENT '发文日期',\n" +
                "\t`DIVISIONGUID` DECIMAL(19) COMMENT '归口id',\n" +
                "\t`DIVISIONNAME` VARCHAR(255) COMMENT '归口名称',\n" +
                "\t`FILENO` VARCHAR(255) COMMENT '文号',\n" +
                "\t`FILETYPE` BIGINT COMMENT '文件类型(1正常,2核减,3分配调剂)',\n" +
                "\t`FLOWID` BIGINT COMMENT '流程id',\n" +
                "\t`MODIFYDATE` DATETIME COMMENT '修改日期',\n" +
                "\t`MONEY` DECIMAL(16, 2) DEFAULT 0 COMMENT '分配金额',\n" +
                "\t`MONEY1` DECIMAL(16, 2) DEFAULT 0,\n" +
                "\t`MONEY10` DECIMAL(16, 2) DEFAULT 0,\n" +
                "\t`MONEY2` DECIMAL(16, 2) DEFAULT 0,\n" +
                "\t`MONEY3` DECIMAL(16, 2) DEFAULT 0,\n" +
                "\t`MONEY4` DECIMAL(16, 2) DEFAULT 0,\n" +
                "\t`MONEY5` DECIMAL(16, 2) DEFAULT 0,\n" +
                "\t`MONEY6` DECIMAL(16, 2) DEFAULT 0,\n" +
                "\t`MONEY7` DECIMAL(16, 2) DEFAULT 0,\n" +
                "\t`MONEY8` DECIMAL(16, 2) DEFAULT 0,\n" +
                "\t`MONEY9` DECIMAL(16, 2) DEFAULT 0,\n" +
                "\t`MONEYJC1` DECIMAL(16, 2) COMMENT '省级金额',\n" +
                "\t`MONEYJC2` DECIMAL(16, 2) COMMENT '市县金额',\n" +
                "\t`MONEYJC3` DECIMAL(16, 2) COMMENT '单列金额',\n" +
                "\t`OLDDELIVERDATE` DATETIME COMMENT '原发文日期',\n" +
                "\t`OLDFILENO` VARCHAR(255) COMMENT '原文号',\n" +
                "\t`OPERATORGUID` DECIMAL(19) COMMENT '操作员id',\n" +
                "\t`OPERATORGUID1` DECIMAL(19) COMMENT '撤销的操作员id',\n" +
                "\t`OPERATORNAME` VARCHAR(255) COMMENT '操作员名称',\n" +
                "\t`OPERATORNAME1` VARCHAR(255) COMMENT '撤销的操作员名称',\n" +
                "\t`STATUS` BIGINT COMMENT '状态',\n" +
                "\t`SUMMARY` VARCHAR(255) COMMENT '摘要',\n" +
                "\t`YEAR` BIGINT COMMENT '年度',\n" +
                "\t`CHOICEFLAG` TINYINT COMMENT '选择标志',\n" +
                "\t`CAVFLAG` TINYINT COMMENT '8核销完全标志,6未核销标志，7核销未完标志',\n" +
                "\t`STATEFLAG` TINYINT COMMENT '状态标志',\n" +
                "\t`CSDW` VARCHAR(255) COMMENT '抄送单位',\n" +
                "\t`EXPLAIN` VARCHAR(255) COMMENT '说明',\n" +
                "\t`ISPRINT` CHAR(1) DEFAULT '0' COMMENT '是否打印标志(省级指标通知单),1为已经打印',\n" +
                "\t`MONEY11` DECIMAL(16, 2) DEFAULT 0,\n" +
                "\t`MONEY12` DECIMAL(16, 2) DEFAULT 0,\n" +
                "\t`MONEY13` DECIMAL(16, 2) DEFAULT 0,\n" +
                "\t`MONEY14` DECIMAL(16, 2) DEFAULT 0,\n" +
                "\t`MONEY15` DECIMAL(16, 2) DEFAULT 0,\n" +
                "\t`MONEY16` DECIMAL(16, 2) DEFAULT 0,\n" +
                "\t`MONEY17` DECIMAL(16, 2) DEFAULT 0,\n" +
                "\t`MONEY18` DECIMAL(16, 2) DEFAULT 0,\n" +
                "\t`MONEY19` DECIMAL(16, 2) DEFAULT 0,\n" +
                "\t`MONEY20` DECIMAL(16, 2) DEFAULT 0,\n" +
                "\t`DATASOURCE` CHAR(1) DEFAULT 0 COMMENT '数据来源(\\'0\\',默认指标生成,\\'1\\',政府采购生成,\\'2\\'政府采购净结余/项目资金结余生成,\\'3\\'预算外核减\\'4\\'指标订正生成',\n" +
                "\t`HJTYPE` CHAR(1) COMMENT '核减数据类型（‘1’特殊标志的核减数据，无需进行采购的余额判断）',\n" +
                "\t`YSTYPE` CHAR(1) COMMENT '预算类型1年初预算2追加预算',\n" +
                "\t`BUDGETYEAR` SMALLINT COMMENT '指标年度',\n" +
                "\t`SXJFWJXZ` CHAR(1) COMMENT '市县经费文件性质(从option表取值)',\n" +
                "\t`RZTIME` DATETIME COMMENT '入账时间',\n" +
                "\t`RZID` DECIMAL(19) COMMENT '入账序号',\n" +
                "\t`ZXZJ` CHAR(1) DEFAULT 0 COMMENT '是否专项资金',\n" +
                "\t`ISXPE` CHAR(1) DEFAULT 0,\n" +
                "\t`CFILEID` DECIMAL(19) COMMENT '采购调整正文件对应的负文件fileid',\n" +
                "\t`DISPFLAG` TINYINT DEFAULT 0 COMMENT '以后年度不再发文标识',\n" +
                "\t`BATCHID` VARCHAR(200),\n" +
                "\t`ZYZFHDFLAG` VARCHAR(1) DEFAULT 0 COMMENT '转移支付核定标识',\n" +
                "\tCONSTRAINT `SYS_C0032949` PRIMARY KEY (`FILEID`)\n" +
                ") COMMENT '分配总表';";


//        String format = SQLUtils.format(oracleSql, DBType.MySQL);
        System.out.println(sql);
//
        SQLTransformConfig config = new SQLTransformConfig();

        String format = MySQLUtils.format(sql);
//        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(oracleSql, config);
                System.out.println(format);
////        assertNotNull(result.targetSql);
//        System.out.println("----------------");
//        System.out.println(result.targetSql);
////
////        Assert.assertEquals(oracleSql, format);
//
//
//        Assert.assertEquals(format, result.targetSql);
    }

    @Test
    public void test_2() {
        SQLBinaryOperatorExpr a = new SQLBinaryOperatorExpr(new SQLIntegerLiteral(1), SQLBinaryOperator.LESS_THAN_OP, new SQLIntegerLiteral(2));
        SQLBinaryOperatorExpr b = new SQLBinaryOperatorExpr(new SQLIntegerLiteral(1), SQLBinaryOperator.LESS_THAN_OP, new SQLIntegerLiteral(2));

        SQLBinaryOperatorExpr c = new SQLBinaryOperatorExpr(new SQLIntegerLiteral(1), SQLBinaryOperator.LESS_THAN_OP, new SQLIntegerLiteral(2));
        SQLBinaryOperatorExpr d = new SQLBinaryOperatorExpr(new SQLIntegerLiteral(1), SQLBinaryOperator.LESS_THAN_OP, new SQLIntegerLiteral(2));

        SQLBinaryOperatorExpr e = new SQLBinaryOperatorExpr(new SQLIntegerLiteral(1), SQLBinaryOperator.LESS_THAN_OP, new SQLIntegerLiteral(2));
        SQLBinaryOperatorExpr f = new SQLBinaryOperatorExpr(new SQLIntegerLiteral(1), SQLBinaryOperator.LESS_THAN_OP, new SQLIntegerLiteral(2));

        SQLBinaryOperatorExpr and = new SQLBinaryOperatorExpr(a, SQLBinaryOperator.And, b);

        SQLBinaryOperatorExpr or = new SQLBinaryOperatorExpr(c, SQLBinaryOperator.Or, d);
        SQLBinaryOperatorExpr and1 = new SQLBinaryOperatorExpr(or, SQLBinaryOperator.And, e);

//        System.out.println(and);
//        System.out.println(or);
//        System.out.println(and1);

        SQLExpr expr = SQLBinaryOperatorExpr.and(and, and1);
        SQLUtils.replaceInParent(and, null);
        System.out.println(expr);
    }
}
