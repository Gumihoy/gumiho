package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.literal;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Literals.html#GUID-F521FBA0-FFED-4079-ABC4-9052218B3FD5
 * @author kongtong.ouyang on 2018/5/15.
 */
public class OracleSQLTextLiteralTest {

    @Test
    public void test1() {
        String sql = "select 'Hello', 'Oracle.dbs', 'Jackie''s raincoat', '09-MAR-98', N'nchar literal' from dual; ";

        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT 'Hello', 'Oracle.dbs', 'Jackie''s raincoat', '09-MAR-98',\n" +
                "\tN'nchar literal'\n" +
                "FROM dual;", format);
    }

    @Test
    public void test2() {
        String sql = "select 'LIKE', 'SELECT * FROM dual' from dual; ";

        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT 'LIKE', 'SELECT * FROM dual'\n" +
                "FROM dual;", format);
    }

    @Test
    public void test3() {
        String sql = "select n '1' from dual; ";

        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT n '1'\n" +
                "FROM dual;", format);
    }

    @Test
    public void test4() {
        String sql = "select q'!name LIKE '%DBMS_%%'!', " +
                " nq'<'So,' she said, 'It's finished.'>', q'{SELECT * FROM employees WHERE last_name = 'Smith';}', " +
                " q'\"name like '['\"' from dual;";

        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("----------------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT Q'!name LIKE '%DBMS_%%'!',\n" +
                "\tNQ'<'So,' she said, 'It's finished.'>',\n" +
                "\tQ'{SELECT * FROM employees WHERE last_name = 'Smith';}',\n" +
                "\tQ'\"name like '['\"'\n" +
                "FROM dual;", format);
    }
}
