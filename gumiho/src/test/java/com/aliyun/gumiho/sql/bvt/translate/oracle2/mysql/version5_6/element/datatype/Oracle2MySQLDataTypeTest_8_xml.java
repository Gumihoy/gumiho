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
public class Oracle2MySQLDataTypeTest_8_xml {


    @Test
    public void test() {
        String sql = "CREATE TABLE t (\n" +
                "\tc1 XMLTYPE,\n" +
                "\tc2 URIType\n" +
                ")";
        String format = OracleUtils.format(sql);
        SQLTransformConfig config = new SQLTransformConfig();
        config.targetVersion = DBVersion.MYSQL_VERSION_5_6;
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql, config);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("CREATE TABLE `t` (\n" +
                "\t`c1` LONGTEXT,\n" +
                "\t`c2` URIType\n" +
                ")", result.targetSql);

        Assert.assertEquals(1, result.errors.size());
    }

}
