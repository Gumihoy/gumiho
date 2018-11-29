package com.aliyun.gumiho.sql.bvt.translate.oracle2.mysql.version5_6.element.datatype;

import com.aliyun.gumiho.sql.enums.DBVersion;
import com.aliyun.gumiho.sql.translate.SQLTransformConfig;
import com.aliyun.gumiho.sql.translate.result.SQLTransformResult;
import com.aliyun.gumiho.sql.util.OracleUtils;
import com.aliyun.gumiho.sql.util.SQLTransformUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CASE-Expressions.html#GUID-CA29B333-572B-4E1D-BA64-851FABDBAE96
 *
 * @author kongtong.ouyang on 2018/5/15.
 */
public class Oracle2MySQLDataTypeTest_3_DataTime {

    @Test
    public void test() {
        String sql = "CREATE TABLE t (\n" +
                "\td1 date,\n" +
                "\tt1 TIMESTAMP,\n" +
                "\tt2 TIMESTAMP(1),\n" +
                "\tt3 TIMESTAMP WITH TIME ZONE,\n" +
                "\tt4 TIMESTAMP(1) WITH TIME ZONE,\n" +
                "\tt5 TIMESTAMP(6) WITH TIME ZONE,\n" +
                "\tt6 TIMESTAMP WITH LOCAL TIME ZONE,\n" +
                "\tt7 TIMESTAMP(1) WITH LOCAL TIME ZONE,\n" +
                "\tt8 TIMESTAMP(6) WITH LOCAL TIME ZONE,\n" +
                "\tiy1 INTERVAL YEAR TO MONTH,\n" +
                "\tiy2 INTERVAL YEAR (1) TO MONTH,\n" +
                "\tid1 INTERVAL DAY TO SECOND,\n" +
                "\tid2 INTERVAL DAY (1) TO SECOND,\n" +
                "\tid3 INTERVAL DAY TO SECOND (1),\n" +
                "\tid4 INTERVAL DAY (1) TO SECOND (1)\n" +
                ")";
        String format = OracleUtils.format(sql);
        SQLTransformConfig config = new SQLTransformConfig();
        config.targetVersion = DBVersion.MYSQL_VERSION_5_6;
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql, config);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("CREATE TABLE `t` (\n" +
                "\t`d1` DATETIME,\n" +
                "\t`t1` DATETIME(6),\n" +
                "\t`t2` DATETIME(1),\n" +
                "\t`t3` DATETIME(6),\n" +
                "\t`t4` DATETIME(1),\n" +
                "\t`t5` DATETIME(6),\n" +
                "\t`t6` DATETIME(6),\n" +
                "\t`t7` DATETIME(1),\n" +
                "\t`t8` DATETIME(6),\n" +
                "\t`iy1` INTERVAL YEAR TO MONTH,\n" +
                "\t`iy2` INTERVAL YEAR (1) TO MONTH,\n" +
                "\t`id1` INTERVAL DAY TO SECOND,\n" +
                "\t`id2` INTERVAL DAY (1) TO SECOND,\n" +
                "\t`id3` INTERVAL DAY TO SECOND (1),\n" +
                "\t`id4` INTERVAL DAY (1) TO SECOND (1)\n" +
                ")", result.targetSql);

        Assert.assertEquals(6, result.errors.size());
    }

}
