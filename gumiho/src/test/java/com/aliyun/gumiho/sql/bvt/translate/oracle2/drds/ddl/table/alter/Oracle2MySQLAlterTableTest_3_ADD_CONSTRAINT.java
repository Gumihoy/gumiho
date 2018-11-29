package com.aliyun.gumiho.sql.bvt.translate.oracle2.drds.ddl.table.alter;

import com.aliyun.gumiho.sql.translate.result.SQLTransformResult;
import com.aliyun.gumiho.sql.util.SQLTransformUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CASE-Expressions.html#GUID-CA29B333-572B-4E1D-BA64-851FABDBAE96
 *
 * @author kongtong.ouyang on 2018/5/15.
 */
public class Oracle2MySQLAlterTableTest_3_ADD_CONSTRAINT {


    @Test
    public void test() {
        String sql =  "ALTER TABLE \"WEB_WSSB\".\"SB_BZ\"\n" +
                "    ADD CONSTRAINT \"PK_SB_BZ\" PRIMARY KEY (\"PZXH\", \"PZZL_DM\", \"LXBZ\")\n" +
                "    USING INDEX\n" +
                "    ENABLE;";
        SQLTransformResult result = SQLTransformUtils.oracleToPPAS(sql);
        System.out.println(sql);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("", result.targetSql);

    }


}
