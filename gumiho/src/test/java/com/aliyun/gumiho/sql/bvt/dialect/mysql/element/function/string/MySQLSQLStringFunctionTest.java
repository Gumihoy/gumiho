package com.aliyun.gumiho.sql.bvt.dialect.mysql.element.function.string;

import com.aliyun.gumiho.sql.util.MySQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/17.
 */
public class MySQLSQLStringFunctionTest {

    @Test
    public void test_1() {
        String sql = "SELECT ASCII('2'), ASCII(2), ASCII('dx') \n" +
                "  FROM DUAL;";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT ASCII('2'), ASCII(2), ASCII('dx')\n" +
                "FROM DUAL;", format);
    }


    @Test
    public void test_2() {
        String sql = "SELECT BIN(12)" +
                "  FROM DUAL;";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT BIN(12)\n" +
                "FROM DUAL;", format);
    }


    @Test
    public void test_3() {
        String sql = "SELECT BIT_LENGTH('text')" +
                "  FROM DUAL;";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT BIT_LENGTH('text')\n" +
                "FROM DUAL;", format);
    }

    @Test
    public void test_4() {
        String sql = "SELECT CHAR_LENGTH('text')" +
                "  FROM DUAL;";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT CHAR_LENGTH('text')\n" +
                "FROM DUAL;", format);
    }

    @Test
    public void test_5() {
        String sql = "SELECT CHARACTER_LENGTH('text')" +
                "  FROM DUAL;";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT CHARACTER_LENGTH('text')\n" +
                "FROM DUAL;", format);
    }

    @Test
    public void test_6() {
        String sql = "SELECT CONCAT('My', 'S', 'QL'), CONCAT('My', NULL, 'QL'), CONCAT(14.3)" +
                "  FROM DUAL;";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT CONCAT('My', 'S', 'QL'), CONCAT('My', NULL, 'QL'), CONCAT(14.3)\n" +
                "FROM DUAL;", format);
    }

    @Test
    public void test_7() {
        String sql = "SELECT CONCAT_WS(',','First name','Second name','Last Name'), CONCAT_WS(',','First name',NULL,'Last Name')" +
                "  FROM DUAL;";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT CONCAT_WS(',', 'First name', 'Second name', 'Last Name'),\n" +
                "\tCONCAT_WS(',', 'First name', NULL, 'Last Name')\n" +
                "FROM DUAL;", format);
    }

    @Test
    public void test_8() {
        String sql = "SELECT  ELT(1, 'Aa', 'Bb', 'Cc', 'Dd')" +
                "  FROM DUAL;";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT ELT(1, 'Aa', 'Bb', 'Cc', 'Dd')\n" +
                "FROM DUAL;", format);
    }

    @Test
    public void test_9() {
        String sql = "SELECT EXPORT_SET(5,'Y','N',',',4)" +
                "  FROM DUAL;";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT EXPORT_SET(5, 'Y', 'N', ',', 4)\n" +
                "FROM DUAL;", format);
    }

    @Test
    public void test_10() {
        String sql = "SELECT FIELD('Bb', 'Aa', 'Bb', 'Cc', 'Dd', 'Ff')" +
                "  FROM DUAL;";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT FIELD('Bb', 'Aa', 'Bb', 'Cc', 'Dd', 'Ff')\n" +
                "FROM DUAL;", format);
    }

    @Test
    public void test_11() {
        String sql = "SELECT FIND_IN_SET('b','a,b,c,d')" +
                "  FROM DUAL;";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT FIND_IN_SET('b', 'a,b,c,d')\n" +
                "FROM DUAL;", format);
    }

    @Test
    public void test_12() {
        String sql = "SELECT FORMAT(12332.123456, 4)" +
                "  FROM DUAL;";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT FORMAT(12332.123456, 4)\n" +
                "FROM DUAL;", format);
    }

    @Test
    public void test_13() {
        String sql = "SELECT TO_BASE64('abc'), FROM_BASE64(TO_BASE64('abc'))" +
                "  FROM DUAL;";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT TO_BASE64('abc'), FROM_BASE64(TO_BASE64('abc'))\n" +
                "FROM DUAL;", format);
    }

    @Test
    public void test_14() {
        String sql = "SELECT X'616263', HEX('abc'), UNHEX(HEX('abc')), HEX(255), CONV(HEX(255),16,10)" +
                "  FROM DUAL;";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT X'616263', HEX('abc'), UNHEX(HEX('abc')), HEX(255),\n" +
                "\tCONV(HEX(255), 16, 10)\n" +
                "FROM DUAL;", format);
    }

    @Test
    public void test_15() {
        String sql = "SELECT INSERT('Quadratic', 3, 4, 'What')" +
                "  FROM DUAL;";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT INSERT('Quadratic', 3, 4, 'What')\n" +
                "FROM DUAL;", format);
    }

    @Test
    public void test_16() {
        String sql = "SELECT INSTR('foobarbar', 'bar')" +
                "  FROM DUAL;";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT INSTR('foobarbar', 'bar')\n" +
                "FROM DUAL;", format);
    }

    @Test
    public void test_17() {
        String sql = "SELECT LCASE('foobarbar')" +
                "  FROM DUAL;";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT LCASE('foobarbar')\n" +
                "FROM DUAL;", format);
    }

    @Test
    public void test_18() {
        String sql = "SELECT LEFT('foobarbar', 5)" +
                "  FROM DUAL;";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT LEFT('foobarbar', 5)\n" +
                "FROM DUAL;", format);
    }

    @Test
    public void test_19() {
        String sql = "SELECT LENGTH('text')" +
                "  FROM DUAL;";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT LENGTH('text')\n" +
                "FROM DUAL;", format);
    }

    @Test
    public void test_20() {
        String sql = "UPDATE t\n" +
                "            SET blob_col=LOAD_FILE('/tmp/picture')\n" +
                "            WHERE id=1;";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------");
        System.out.println(format);
        Assert.assertEquals("UPDATE t\n" +
                "SET blob_col = LOAD_FILE('/tmp/picture')\n" +
                "WHERE id = 1;", format);
    }


    @Test
    public void test_21() {
        String sql = "SELECT LOCATE('bar', 'foobarbar'); ";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT LOCATE('bar', 'foobarbar');", format);
    }

    @Test
    public void test_22() {
        String sql = "SELECT LOWER('QUADRATICALLY') ";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT LOWER('QUADRATICALLY')", format);
    }

    @Test
    public void test_23() {
        String sql = "SELECT LPAD('hi',4,'??')";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT LPAD('hi', 4, '??')", format);
    }

    @Test
    public void test_24() {
        String sql = "SELECT LTRIM('  barbar') ";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT LTRIM('  barbar')", format);
    }

    @Test
    public void test_25() {
        String sql = "SELECT MAKE_SET(1,'a','b','c'), MAKE_SET(1 | 4,'hello','nice','world')";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT MAKE_SET(1, 'a', 'b', 'c'),\n" +
                "\tMAKE_SET(1 | 4, 'hello', 'nice', 'world')", format);
    }

    @Test
    public void test_26() {
        String sql = "SELECT MID('afaf',1, 1)";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT MID('afaf', 1, 1)", format);
    }

    @Test
    public void test_27() {
        String sql = "SELECT OCT(12); ";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT OCT(12);", format);
    }

    @Test
    public void test_28() {
        String sql = "SELECT OCTET_LENGTH('12222'); ";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT OCTET_LENGTH('12222');", format);
    }

    @Test
    public void test_29() {
        String sql = "SELECT ORD('2'); ";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT ORD('2');", format);
    }

    @Test
    public void test_30() {
        String sql = "SELECT QUOTE('Don\\'t!'); ";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT QUOTE('Don\\'t!');", format);
    }

    @Test
    public void test_31() {
        String sql = "SELECT REPLACE('www.mysql.com', 'w', 'Ww'); ";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT REPLACE('www.mysql.com', 'w', 'Ww');", format);
    }

    @Test
    public void test_32() {
        String sql = "SELECT REVERSE('abc') ";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT REVERSE('abc')", format);
    }

    @Test
    public void test_33() {
        String sql = "SELECT RIGHT('foobarbar', 4); ";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT RIGHT('foobarbar', 4);", format);
    }

    @Test
    public void test_34() {
        String sql = "SELECT RPAD('hi',5,'?')";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT RPAD('hi', 5, '?')", format);
    }

    @Test
    public void test_35() {
        String sql = "SELECT RTRIM('barbar   ') ";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT RTRIM('barbar   ')", format);
    }

    @Test
    public void test_36() {
        String sql = "SELECT SOUNDEX('Hello'); ";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT SOUNDEX('Hello');", format);
    }

    @Test
    public void test_37() {
        String sql = "SELECT SPACE(6); ";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT SPACE(6);", format);
    }

    @Test
    public void test_38() {
        String sql = "SELECT SUBSTR('Quadratically',5), SUBSTR('Quadratically',5,6), SUBSTRING('Quadratically',5), SUBSTRING('Quadratically',5,6) ";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT SUBSTR('Quadratically', 5), SUBSTR('Quadratically', 5, 6),\n" +
                "\tSUBSTRING('Quadratically', 5),\n" +
                "\tSUBSTRING('Quadratically', 5, 6)", format);
    }

    @Test
    public void test_39() {
        String sql = "SELECT SUBSTRING_INDEX('www.mysql.com', '.', 2) ";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT SUBSTRING_INDEX('www.mysql.com', '.', 2)", format);
    }

    @Test
    public void test_40() {
        String sql = "SELECT UCASE('www.mysql.com') ";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT UCASE('www.mysql.com')", format);
    }

    @Test
    public void test_41() {
        String sql = "SELECT UNHEX('4D7953514C') ";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT UNHEX('4D7953514C')", format);
    }

    @Test
    public void test_42() {
        String sql = "SELECT UPPER('4D7953514C') ";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("-----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT UPPER('4D7953514C')", format);
    }
}
