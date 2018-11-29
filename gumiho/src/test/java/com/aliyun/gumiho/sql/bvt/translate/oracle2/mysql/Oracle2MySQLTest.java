package com.aliyun.gumiho.sql.bvt.translate.oracle2.mysql;

import com.aliyun.gumiho.sql.translate.SQLTransformConfig;
import com.aliyun.gumiho.sql.translate.result.SQLTransformResult;
import com.aliyun.gumiho.sql.util.OracleUtils;
import com.aliyun.gumiho.sql.util.SQLTransformUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/9/18.
 */
public class Oracle2MySQLTest {

    @Test
    public void test () throws Exception {
       String s = "SELECT *\n" +
               "FROM (SELECT T1.*, rownum AS countrownum from (SELECT vw_zeus_message.*\n" +
               "\t\tFROM vw_zeus_message\n" +
               "\t\tWHERE vw_zeus_message.MSG_TYPE NOT (?)\n" +
               "\t\t\tAND vw_zeus_message.IS_DELETED = :3\n" +
               "\t\t\tAND vw_zeus_message.RECEIVER_ID = :4\n" +
               "\t\tORDER BY vw_zeus_message.GMT_CREATE DESC ) WHERE rownum <= :5) " +
               "WHERE countrownum > :6";
        System.out.println(s);
//
        SQLTransformConfig config = new SQLTransformConfig();
        String format = OracleUtils.format(s);
//        TransformResult result1 = TransformUtils.oracleToPPAS(oracleSql.toString());
        SQLTransformResult result1 = SQLTransformUtils.oracleToPPAS(s);
//        TransformResult result = TransformUtils.oracleToPPAS(oracleSql.toString(), config);
//        assertNotNull(result.targetSql);
        System.out.println(format);
        System.out.println("----------------");
        System.out.println(result1.targetSql);
//
        Assert.assertEquals(s, result1.targetSql);


    }
}
