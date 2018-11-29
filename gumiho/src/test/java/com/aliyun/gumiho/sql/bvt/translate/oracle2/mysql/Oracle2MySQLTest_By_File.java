package com.aliyun.gumiho.sql.bvt.translate.oracle2.mysql;

import com.aliyun.gumiho.sql.translate.SQLTransformConfig;
import com.aliyun.gumiho.sql.translate.result.SQLTransformResult;
import com.aliyun.gumiho.sql.util.SQLTransformUtils;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * @author kongtong.ouyang on 2018/9/18.
 */
public class Oracle2MySQLTest_By_File {

    @Test
    public void test () throws Exception {
        String path = "/Users/kongtong.ouyang/Downloads/pkg_GetCellsData.txt";
        File file = FileUtils.getFile(path);

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), "utf8"));

        StringBuilder oracleSql = new StringBuilder();
        String line = "";
        int i = 0;
        while (line != null) {
            i++;
            line = reader.readLine();
            if (line == null) {
                break;
            }
            oracleSql.append(line).append(" ").append("\n");
        }
        System.out.println(oracleSql);
//
        SQLTransformConfig config = new SQLTransformConfig();
        System.out.println("oracleSql.length():" + oracleSql.length());
//        TransformResult result1 = TransformUtils.oracleToPPAS(oracleSql.toString());
        SQLTransformResult result1 = SQLTransformUtils.oracleToMySQL(oracleSql.toString());
//        TransformResult result = TransformUtils.oracleToPPAS(oracleSql.toString(), config);
//        assertNotNull(result.targetSql);
        System.out.println("----------------");
        System.out.println(result1.targetSql);
//
        Assert.assertEquals(oracleSql.toString(), result1.targetSql);


    }
}
