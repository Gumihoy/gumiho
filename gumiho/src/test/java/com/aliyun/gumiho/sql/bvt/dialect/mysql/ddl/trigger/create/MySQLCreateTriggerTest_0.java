package com.aliyun.gumiho.sql.bvt.dialect.mysql.ddl.trigger.create;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/7/31.
 */
public class MySQLCreateTriggerTest_0 {

    @Test
    public void test_0() {
        String sql = "CREATE TRIGGER before_insert_U3C_MG_BRANCHUPLOG\n" +
                "BEFORE INSERT ON `U3C_MG_BRANCHUPLOG`\n" +
                "FOR EACH ROW\n" +
                "BEGIN\n" +
                "\tIF new.`OPERATEDATE` IS NULL THEN\n" +
                "\t\tSET new.OPERATEDATE = sysdate();\n" +
                "\tEND IF;\n" +
                "END;";

        String format = SQLUtils.format(sql, DBType.MySQL);
        System.out.println(sql);
        System.out.println("----------------");
        System.out.println(format);
        Assert.assertEquals("CREATE TRIGGER before_insert_U3C_MG_BRANCHUPLOG\n" +
                "\tBEFORE\n" +
                "\t\tINSERT\n" +
                "\tON `U3C_MG_BRANCHUPLOG`\n" +
                "\tFOR EACH ROW\n" +
                "\tBEGIN\n" +
                "\t\tIF NEW.`OPERATEDATE` IS NULL THEN\n" +
                "\t\t\tSET NEW.OPERATEDATE = sysdate();\n" +
                "\t\tEND IF;\n" +
                "\tEND;", format);
    }

    @Test
    public void test_1() {
        String sql = "CREATE TRIGGER ins_sum BEFORE INSERT ON account\n" +
                "       FOR EACH ROW SET @@sum = @sum + NEW.amount;";

        String format = SQLUtils.format(sql, DBType.MySQL);
        System.out.println(sql);
        System.out.println("----------------");
        System.out.println(format);
        Assert.assertEquals("CREATE TRIGGER ins_sum\n" +
                "\tBEFORE\n" +
                "\t\tINSERT\n" +
                "\tON account\n" +
                "\tFOR EACH ROW\n" +
                "\tSET @@sum = @sum + NEW.amount;", format);
    }

    @Test
    public void test_2() {
        String sql = "CREATE DEFINER = CURRENT_USER TRIGGER ins_sum BEFORE INSERT ON account\n" +
                "       FOR EACH ROW SET @@sum = @sum + NEW.amount;";

        String format = SQLUtils.format(sql, DBType.MySQL);
        System.out.println(sql);
        System.out.println("----------------");
        System.out.println(format);
        Assert.assertEquals("CREATE DEFINER = CURRENT_USER TRIGGER ins_sum\n" +
                "\tBEFORE\n" +
                "\t\tINSERT\n" +
                "\tON account\n" +
                "\tFOR EACH ROW\n" +
                "\tSET @@sum = @sum + NEW.amount;", format);
    }

    @Test
    public void test_3() {
        String sql = "CREATE DEFINER = CURRENT_USER() TRIGGER ins_sum BEFORE INSERT ON account\n" +
                "       FOR EACH ROW SET @@sum = @sum + NEW.amount;";

        String format = SQLUtils.format(sql, DBType.MySQL);
        System.out.println(sql);
        System.out.println("----------------");
        System.out.println(format);
        Assert.assertEquals("CREATE DEFINER = CURRENT_USER() TRIGGER ins_sum\n" +
                "\tBEFORE\n" +
                "\t\tINSERT\n" +
                "\tON account\n" +
                "\tFOR EACH ROW\n" +
                "\tSET @@sum = @sum + NEW.amount;", format);
    }
}
