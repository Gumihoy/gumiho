package com.aliyun.gumiho.sql.bvt.translate.oracle2.drds.ddl.index.create;

import com.aliyun.gumiho.sql.translate.result.SQLTransformResult;
import com.aliyun.gumiho.sql.util.OracleUtils;
import com.aliyun.gumiho.sql.util.SQLTransformUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kongtong.ouyang on 2018/8/1.
 */
public class Oracle2MySQLCreateIndexTest_100 {


    @Test
    public void test() {
        String sql = "CREATE OR REPLACE FORCE VIEW \"NIRVANA\".\"B$SFA_VOUCHER_SMD\" (\"ID\", \"GMT_CREATED\", \"CREATOR\", \"GMT_MODIFIED\", \"MODIFIER\", \"VOUCHER_NUMBER\", \"ORDER_ID\", \"ORDER_NUMBER\", \"PAYMENT_STATUS\", \"REMITTER\", \"AMOUNT\", \"GMT_RECEIVE\", \"MEMO\", \"JOINT_VOUCHER_ID\", \"MEMBER_ID\", \"ACCOUNT_ID\", \"OPPORTUNITY_ID\", \"IS_DISABLED\", \"GMT_DISABLED\", \"PAYMENT_METHOD\", \"CURRENCY\") AS \n" +
                "  SELECT\n" +
                "ID,\n" +
                "GMT_CREATED,\n" +
                "CONVERT(UTL_RAW.CAST_TO_VARCHAR2(CREATOR),'ZHS16GBK','UTF8') AS CREATOR,\n" +
                "GMT_MODIFIED,\n" +
                "CONVERT(UTL_RAW.CAST_TO_VARCHAR2(MODIFIER),'ZHS16GBK','UTF8') AS MODIFIER,\n" +
                "CONVERT(UTL_RAW.CAST_TO_VARCHAR2(VOUCHER_NUMBER),'ZHS16GBK','UTF8') AS VOUCHER_NUMBER,\n" +
                "ORDER_ID,\n" +
                "CONVERT(UTL_RAW.CAST_TO_VARCHAR2(ORDER_NUMBER),'ZHS16GBK','UTF8') AS ORDER_NUMBER,\n" +
                "CONVERT(UTL_RAW.CAST_TO_VARCHAR2(PAYMENT_STATUS),'ZHS16GBK','UTF8') AS PAYMENT_STATUS,\n" +
                "CONVERT(nvl(UTL_RAW.CAST_TO_VARCHAR2(REMITTER_1),'') ||\n" +
                "nvl(UTL_RAW.CAST_TO_VARCHAR2(REMITTER_2),'') ||\n" +
                "nvl(UTL_RAW.CAST_TO_VARCHAR2(REMITTER_3),'') ||\n" +
                "nvl(UTL_RAW.CAST_TO_VARCHAR2(REMITTER_4),'') ||\n" +
                "nvl(UTL_RAW.CAST_TO_VARCHAR2(REMITTER_5),'') ||\n" +
                "nvl(UTL_RAW.CAST_TO_VARCHAR2(REMITTER_6),'') ||\n" +
                "nvl(UTL_RAW.CAST_TO_VARCHAR2(REMITTER_7),'') ,'ZHS16GBK','UTF8') AS REMITTER,\n" +
                "AMOUNT,\n" +
                "GMT_RECEIVE,\n" +
                "CONVERT(nvl(UTL_RAW.CAST_TO_VARCHAR2(MEMO_1),'') ||\n" +
                "nvl(UTL_RAW.CAST_TO_VARCHAR2(MEMO_2),'') ||\n" +
                "nvl(UTL_RAW.CAST_TO_VARCHAR2(MEMO_3),'') ||\n" +
                "nvl(UTL_RAW.CAST_TO_VARCHAR2(MEMO_4),'') ||\n" +
                "nvl(UTL_RAW.CAST_TO_VARCHAR2(MEMO_5),'') ||\n" +
                "nvl(UTL_RAW.CAST_TO_VARCHAR2(MEMO_6),'') ||\n" +
                "nvl(UTL_RAW.CAST_TO_VARCHAR2(MEMO_7),'') ,'ZHS16GBK','UTF8') AS MEMO,\n" +
                "JOINT_VOUCHER_ID,\n" +
                "CONVERT(UTL_RAW.CAST_TO_VARCHAR2(MEMBER_ID),'ZHS16GBK','UTF8') AS MEMBER_ID,\n" +
                "ACCOUNT_ID,\n" +
                "OPPORTUNITY_ID,\n" +
                "IS_DISABLED,\n" +
                "GMT_DISABLED,\n" +
                "CONVERT(UTL_RAW.CAST_TO_VARCHAR2(PAYMENT_METHOD),'ZHS16GBK','UTF8') AS PAYMENT_METHOD,\n" +
                "CONVERT(UTL_RAW.CAST_TO_VARCHAR2(CURRENCY),'ZHS16GBK','UTF8') AS CURRENCY\n" +
                " FROM B$SFA_VOUCHER_SMD@APOLLO";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("CREATE OR REPLACE FORCE VIEW \"NIRVANA\".\"B$SFA_VOUCHER_SMD\" (\"ID\", \"GMT_CREATED\", \"CREATOR\", \"GMT_MODIFIED\", \"MODIFIER\", \"VOUCHER_NUMBER\", \"ORDER_ID\", \"ORDER_NUMBER\", \"PAYMENT_STATUS\", \"REMITTER\", \"AMOUNT\", \"GMT_RECEIVE\", \"MEMO\", \"JOINT_VOUCHER_ID\", \"MEMBER_ID\", \"ACCOUNT_ID\", \"OPPORTUNITY_ID\", \"IS_DISABLED\", \"GMT_DISABLED\", \"PAYMENT_METHOD\", \"CURRENCY\") AS \n" +
                "  SELECT\n" +
                "ID,\n" +
                "GMT_CREATED,\n" +
                "CONVERT(UTL_RAW.CAST_TO_VARCHAR2(CREATOR),'ZHS16GBK','UTF8') AS CREATOR,\n" +
                "GMT_MODIFIED,\n" +
                "CONVERT(UTL_RAW.CAST_TO_VARCHAR2(MODIFIER),'ZHS16GBK','UTF8') AS MODIFIER,\n" +
                "CONVERT(UTL_RAW.CAST_TO_VARCHAR2(VOUCHER_NUMBER),'ZHS16GBK','UTF8') AS VOUCHER_NUMBER,\n" +
                "ORDER_ID,\n" +
                "CONVERT(UTL_RAW.CAST_TO_VARCHAR2(ORDER_NUMBER),'ZHS16GBK','UTF8') AS ORDER_NUMBER,\n" +
                "CONVERT(UTL_RAW.CAST_TO_VARCHAR2(PAYMENT_STATUS),'ZHS16GBK','UTF8') AS PAYMENT_STATUS,\n" +
                "CONVERT(nvl(UTL_RAW.CAST_TO_VARCHAR2(REMITTER_1),'') ||\n" +
                "nvl(UTL_RAW.CAST_TO_VARCHAR2(REMITTER_2),'') ||\n" +
                "nvl(UTL_RAW.CAST_TO_VARCHAR2(REMITTER_3),'') ||\n" +
                "nvl(UTL_RAW.CAST_TO_VARCHAR2(REMITTER_4),'') ||\n" +
                "nvl(UTL_RAW.CAST_TO_VARCHAR2(REMITTER_5),'') ||\n" +
                "nvl(UTL_RAW.CAST_TO_VARCHAR2(REMITTER_6),'') ||\n" +
                "nvl(UTL_RAW.CAST_TO_VARCHAR2(REMITTER_7),'') ,'ZHS16GBK','UTF8') AS REMITTER,\n" +
                "AMOUNT,\n" +
                "GMT_RECEIVE,\n" +
                "CONVERT(nvl(UTL_RAW.CAST_TO_VARCHAR2(MEMO_1),'') ||\n" +
                "nvl(UTL_RAW.CAST_TO_VARCHAR2(MEMO_2),'') ||\n" +
                "nvl(UTL_RAW.CAST_TO_VARCHAR2(MEMO_3),'') ||\n" +
                "nvl(UTL_RAW.CAST_TO_VARCHAR2(MEMO_4),'') ||\n" +
                "nvl(UTL_RAW.CAST_TO_VARCHAR2(MEMO_5),'') ||\n" +
                "nvl(UTL_RAW.CAST_TO_VARCHAR2(MEMO_6),'') ||\n" +
                "nvl(UTL_RAW.CAST_TO_VARCHAR2(MEMO_7),'') ,'ZHS16GBK','UTF8') AS MEMO,\n" +
                "JOINT_VOUCHER_ID,\n" +
                "CONVERT(UTL_RAW.CAST_TO_VARCHAR2(MEMBER_ID),'ZHS16GBK','UTF8') AS MEMBER_ID,\n" +
                "ACCOUNT_ID,\n" +
                "OPPORTUNITY_ID,\n" +
                "IS_DISABLED,\n" +
                "GMT_DISABLED,\n" +
                "CONVERT(UTL_RAW.CAST_TO_VARCHAR2(PAYMENT_METHOD),'ZHS16GBK','UTF8') AS PAYMENT_METHOD,\n" +
                "CONVERT(UTL_RAW.CAST_TO_VARCHAR2(CURRENCY),'ZHS16GBK','UTF8') AS CURRENCY\n" +
                " FROM B$SFA_VOUCHER_SMD@APOLLO", result.targetSql);

    }

    @Test
    public void main() {
        List<String> a = new ArrayList<>();
        a.add("1");
        a.add("2");
        a.add("3");
        String [] strs = a.toArray(new String[3]);
        strs[0] = "5";
        System.out.println(a);
    }

}
