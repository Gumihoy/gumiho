package com.aliyun.gumiho.sql.bvt.dialect.oracle.element.constraint;

import com.aliyun.gumiho.sql.util.OracleUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/AVG.html#GUID-B64BCBF1-DAA0-4D88-9821-2C4D3FDE5E4A
 *
 * @author kongtong.ouyang on 2018/5/17.
 */
public class OracleSQLCheckColumnConstraintTest {

    @Test
    public void test_0() {
        String sql = "CREATE TABLE divisions  \n" +
                "   (div_no    NUMBER  CONSTRAINT check_divno\n" +
                "              CHECK (div_no BETWEEN 10 AND 99) \n" +
                "              DISABLE, \n" +
                "    div_name  VARCHAR2(9)  CONSTRAINT check_divname\n" +
                "              CHECK (div_name = UPPER(div_name)) \n" +
                "              DISABLE, \n" +
                "    office    VARCHAR2(10)  CONSTRAINT check_office\n" +
                "              CHECK (office IN ('DALLAS','BOSTON',\n" +
                "              'PARIS','TOKYO')) \n" +
                "              DISABLE);  ";

        String format = OracleUtils.format(sql);
        System.out.println(sql);
        System.out.println("-------------------");
        System.out.println(format);
        Assert.assertEquals("CREATE TABLE divisions (\n" +
                "\tdiv_no NUMBER CONSTRAINT check_divno CHECK (div_no BETWEEN 10 AND 99) DISABLE,\n" +
                "\tdiv_name VARCHAR2(9) CONSTRAINT check_divname CHECK (div_name = UPPER(div_name)) DISABLE,\n" +
                "\toffice VARCHAR2(10) CONSTRAINT check_office CHECK (office IN ('DALLAS', 'BOSTON', 'PARIS', 'TOKYO')) DISABLE\n" +
                ");", format);
    }
}
