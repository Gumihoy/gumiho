package com.aliyun.gumiho.sql.bvt.translate.oracle2.drds.ddl.index.drop;

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
public class Oracle2MySQLDropIndexTest_2_FORCE {

    @Test
    public void test() {
        String sql = "CREATE INDEX ord_customer_ix ON orders (customer_id); DROP INDEX ord_customer_ix FORCE;";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("CREATE INDEX `ord_customer_ix` ON `orders` (\n" +
                "\t`customer_id`\n" +
                ");\n" +
                "DROP INDEX `ord_customer_ix` ON `orders`;", result.targetSql);
    }


}
