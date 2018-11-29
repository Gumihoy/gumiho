package com.aliyun.gumiho.sql.bvt.translate.oracle2.mysql.version5_6.dml.select;

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
public class Oracle2MySQLSelectTest_4_Minus {


    @Test
    public void test_0() {
        String sql = "SELECT x, y\n" +
                "FROM table_a\n" +
                "MINUS\n" +
                "SELECT x, y\n" +
                "FROM table_b\n" +
                "MINUS\n" +
                "SELECT x, y\n" +
                "FROM table_c;";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("SELECT a.x, a.y\n" +
                "FROM `table_a` a\n" +
                "\tLEFT JOIN `table_b` b\n" +
                "\tON a.x = b.x\n" +
                "\t\tAND a.y = b.y\n" +
                "WHERE b.x IS NULL;", result.targetSql);

    }

    @Test
    public void test_1() {
        String sql = "SELECT product_id\n" +
                "FROM inventories\n" +
                "MINUS\n" +
                "SELECT product_id\n" +
                "FROM order_items;";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("SELECT a.product_id\n" +
                "FROM `inventories` a\n" +
                "\tLEFT JOIN `order_items` b ON a.product_id = b.product_id\n" +
                "WHERE b.product_id IS NULL;", result.targetSql);

    }

    @Test
    public void test_2() {
        String sql = "SELECT c.customerID, c.name, t.transType\n" +
                "FROM customer c, transaction t\n" +
                "WHERE c.accountNumber = t.accountNumber\n" +
                "MINUS\n" +
                "SELECT c.customerID, c.name, t.transType\n" +
                "FROM customer c, transaction t\n" +
                "WHERE c.accountNumber = t.accountNumber\n" +
                "\tAND t.transType = 'Sale';";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("SELECT c.customerID, c.name, t.transType\n" +
                "FROM `customer` c\n" +
                "\tINNER JOIN `transaction` t ON c.accountNumber = t.accountNumber\n" +
                "WHERE t.transType <> 'Sale';", result.targetSql);

    }

    @Test
    public void test_3() {
        String sql = "SELECT c.customerID, c.name, t.transType\n" +
                "FROM customer c, transaction t\n" +
                "WHERE c.accountNumber = t.accountNumber\n" +
                "MINUS\n" +
                "SELECT c.customerID, c.name, t.transType\n" +
                "FROM customer c, transaction t\n" +
                "WHERE c.accountNumber = t.accountNumber;";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("SELECT c.customerID, c.name, t.transType\n" +
                "FROM `customer` c\n" +
                "\tINNER JOIN `transaction` t ON c.accountNumber = t.accountNumber\n" +
                "WHERE 1 <> 1;", result.targetSql);

    }

    @Test
    public void test_4() {
        String sql = "SELECT c.customerID, c.name, t.transType\n" +
                "FROM customer c, transaction t\n" +
                "WHERE c.accountNumber = t.accountNumber\n" +
                "MINUS\n" +
                "SELECT c.customerID, c.name, t.transType\n" +
                "FROM customer c, transaction t\n" +
                "WHERE c.accountNumber = t.accountNumber\n" +
                "\tAND t.transType IS NULL;";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("SELECT c.customerID, c.name, t.transType\n" +
                "FROM `customer` c\n" +
                "\tINNER JOIN `transaction` t ON c.accountNumber = t.accountNumber\n" +
                "WHERE t.transType IS NOT NULL;", result.targetSql);

    }

    @Test
    public void test_5() {
        String sql = "SELECT DRAFT_WAY_DETAIL, GMT_REMIT, REMIT_NO, ALI_ACCOUNT_NO, CO_ACCOUNT_NO\n" +
                "\t, AMOUNT, CURRENCY_TYPE, CO_COMPANY, DRAFT_TIME_STAMP\n" +
                "FROM (\n" +
                "\tSELECT DRAFT_WAY_DETAIL, TRUNC(GMT_REMIT) AS GMT_REMIT, REMIT_NO, ALI_ACCOUNT_NO\n" +
                "\t\t, CO_ACCOUNT_NO, AMOUNT, CURRENCY_TYPE, CO_COMPANY, DRAFT_TIME_STAMP\n" +
                "\tFROM FIN_DRAFT_PREPARED\n" +
                "\tWHERE GMT_REMIT >= TRUNC(:B2)\n" +
                "\t\tAND GMT_REMIT < TRUNC(:B1) + ?\n" +
                "\t\tAND DRAFT_WAY_DETAIL IN (?, ?)\n" +
                "\tMINUS\n" +
                "\tSELECT DRAFT_WAY_DETAIL, TRUNC(GMT_REMIT) AS GMT_REMIT, REMIT_NO, ALI_ACCOUNT_NO\n" +
                "\t\t, CO_ACCOUNT_NO, AMOUNT, CURRENCY_TYPE, CO_COMPANY, DRAFT_TIME_STAMP\n" +
                "\tFROM FIN_MONITOR_DRAFT\n" +
                "\tWHERE GMT_REMIT >= TRUNC(:B2)\n" +
                "\t\tAND GMT_REMIT < TRUNC(:B1) + ?\n" +
                "\t\tAND DRAFT_WAY_DETAIL IN (?, ?)\n" +
                ");";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("SELECT DRAFT_WAY_DETAIL, GMT_REMIT, REMIT_NO, ALI_ACCOUNT_NO, CO_ACCOUNT_NO\n" +
                "\t, AMOUNT, CURRENCY_TYPE, CO_COMPANY, DRAFT_TIME_STAMP\n" +
                "FROM (\n" +
                "\tSELECT a.DRAFT_WAY_DETAIL, a.GMT_REMIT, a.REMIT_NO, a.ALI_ACCOUNT_NO, a.CO_ACCOUNT_NO\n" +
                "\t\t, a.AMOUNT, a.CURRENCY_TYPE, a.CO_COMPANY, a.DRAFT_TIME_STAMP\n" +
                "\tFROM (\n" +
                "\t\tSELECT DRAFT_WAY_DETAIL, TRUNC(GMT_REMIT) AS `GMT_REMIT`, REMIT_NO, ALI_ACCOUNT_NO\n" +
                "\t\t\t, CO_ACCOUNT_NO, AMOUNT, CURRENCY_TYPE, CO_COMPANY, DRAFT_TIME_STAMP\n" +
                "\t\tFROM `FIN_DRAFT_PREPARED`\n" +
                "\t\tWHERE GMT_REMIT >= TRUNC(?)\n" +
                "\t\t\tAND GMT_REMIT < TRUNC(?) + ?\n" +
                "\t\t\tAND DRAFT_WAY_DETAIL IN (?, ?)\n" +
                "\t) a\n" +
                "\t\tLEFT JOIN (\n" +
                "\t\t\tSELECT DRAFT_WAY_DETAIL, TRUNC(GMT_REMIT) AS `GMT_REMIT`, REMIT_NO, ALI_ACCOUNT_NO\n" +
                "\t\t\t\t, CO_ACCOUNT_NO, AMOUNT, CURRENCY_TYPE, CO_COMPANY, DRAFT_TIME_STAMP\n" +
                "\t\t\tFROM `FIN_MONITOR_DRAFT`\n" +
                "\t\t\tWHERE GMT_REMIT >= TRUNC(?)\n" +
                "\t\t\t\tAND GMT_REMIT < TRUNC(?) + ?\n" +
                "\t\t\t\tAND DRAFT_WAY_DETAIL IN (?, ?)\n" +
                "\t\t) b\n" +
                "\t\tON a.DRAFT_WAY_DETAIL = b.DRAFT_WAY_DETAIL\n" +
                "\t\t\tAND a.GMT_REMIT = b.GMT_REMIT\n" +
                "\t\t\tAND a.REMIT_NO = b.REMIT_NO\n" +
                "\t\t\tAND a.ALI_ACCOUNT_NO = b.ALI_ACCOUNT_NO\n" +
                "\t\t\tAND a.CO_ACCOUNT_NO = b.CO_ACCOUNT_NO\n" +
                "\t\t\tAND a.AMOUNT = b.AMOUNT\n" +
                "\t\t\tAND a.CURRENCY_TYPE = b.CURRENCY_TYPE\n" +
                "\t\t\tAND a.CO_COMPANY = b.CO_COMPANY\n" +
                "\t\t\tAND a.DRAFT_TIME_STAMP = b.DRAFT_TIME_STAMP\n" +
                "\tWHERE b.DRAFT_WAY_DETAIL IS NULL\n" +
                ") xx0;", result.targetSql);

    }
}
