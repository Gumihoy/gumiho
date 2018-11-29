package com.aliyun.gumiho.sql.bvt.dialect.mysql.element.datatype;

import com.aliyun.gumiho.sql.util.MySQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/15.
 */
public class MySQLSQLDataTypeTest_1_Number {


    @Test
    public void test() {
        String sql = "Create table t(" +
                " b1 bit, " +
                " b2 bit(1), " +

                " ti1 TINYINT, " +
                " ti2 TINYINT(1), " +
                " ti3 TINYINT UNSIGNED, " +
                " ti4 TINYINT ZEROFILL, " +
                " ti5 TINYINT UNSIGNED ZEROFILL, " +
                " ti6 TINYINT(1) UNSIGNED ZEROFILL, " +

                " b1 bool, " +
                " b2 boolean, " +

                " si1 SMALLINT, " +
                " si2 SMALLINT(1), " +
                " si3 SMALLINT UNSIGNED, " +
                " si4 SMALLINT ZEROFILL, " +
                " si5 SMALLINT UNSIGNED ZEROFILL, " +
                " si6 SMALLINT(1) UNSIGNED ZEROFILL, " +

                " si1 MEDIUMINT, " +
                " si2 MEDIUMINT(1), " +
                " si3 MEDIUMINT UNSIGNED, " +
                " si4 MEDIUMINT ZEROFILL, " +
                " si5 MEDIUMINT UNSIGNED ZEROFILL, " +
                " si6 MEDIUMINT(1) UNSIGNED ZEROFILL, " +

                " si1 INT, " +
                " si2 INT(1), " +
                " si3 INT UNSIGNED, " +
                " si4 INT ZEROFILL, " +
                " si5 INT UNSIGNED ZEROFILL, " +
                " si6 INT(1) UNSIGNED ZEROFILL, " +

                " si1 INTEGER, " +
                " si2 INTEGER(1), " +
                " si3 INTEGER UNSIGNED, " +
                " si4 INTEGER ZEROFILL, " +
                " si5 INTEGER UNSIGNED ZEROFILL, " +
                " si6 INTEGER(1) UNSIGNED ZEROFILL, " +

                " si1 bigint, " +
                " si2 bigint(1), " +
                " si3 bigint UNSIGNED, " +
                " si4 bigint ZEROFILL, " +
                " si5 bigint UNSIGNED ZEROFILL, " +
                " si6 bigint(1) UNSIGNED ZEROFILL, " +

                " si1 decimal, " +
                " si2 decimal(1), " +
                " si2 decimal(8, 2), " +
                " si3 decimal UNSIGNED, " +
                " si4 decimal ZEROFILL, " +
                " si5 decimal UNSIGNED ZEROFILL, " +
                " si6 decimal(1) UNSIGNED ZEROFILL, " +
                " si6 decimal(8,2) UNSIGNED ZEROFILL, " +

                " si1 dec, " +
                " si2 dec(1), " +
                " si2 dec(8, 2), " +
                " si3 dec UNSIGNED, " +
                " si4 dec ZEROFILL, " +
                " si5 dec UNSIGNED ZEROFILL, " +
                " si6 dec(1) UNSIGNED ZEROFILL, " +
                " si6 dec(8,2) UNSIGNED ZEROFILL, " +

                " si1 numeric, " +
                " si2 numeric(1), " +
                " si2 numeric(8, 2), " +
                " si3 numeric UNSIGNED, " +
                " si4 numeric ZEROFILL, " +
                " si5 numeric UNSIGNED ZEROFILL, " +
                " si6 numeric(1) UNSIGNED ZEROFILL, " +
                " si6 numeric(8,2) UNSIGNED ZEROFILL, " +

                " si1 fixed, " +
                " si2 fixed(1), " +
                " si2 fixed(8, 2), " +
                " si3 fixed UNSIGNED, " +
                " si4 fixed ZEROFILL, " +
                " si5 fixed UNSIGNED ZEROFILL, " +
                " si6 fixed(1) UNSIGNED ZEROFILL, " +
                " si6 fixed(8,2) UNSIGNED ZEROFILL, " +

                " si1 float, " +
                " si2 float(2), " +
                " si2 float(8, 2), " +
                " si3 float UNSIGNED, " +
                " si4 float ZEROFILL, " +
                " si5 float UNSIGNED ZEROFILL, " +
                " si6 float(8,2) UNSIGNED ZEROFILL, " +

                " si1 double, " +
                " si2 double(8, 2), " +
                " si3 double UNSIGNED, " +
                " si4 double ZEROFILL, " +
                " si5 double UNSIGNED ZEROFILL, " +
                " si6 double(8,2) UNSIGNED ZEROFILL, " +

                " si1 double precision, " +
                " si2 double precision(8, 2), " +
                " si3 double precision UNSIGNED, " +
                " si4 double precision ZEROFILL, " +
                " si5 double precision UNSIGNED ZEROFILL, " +
                " si6 double precision(8,2) UNSIGNED ZEROFILL, " +

                " si1 real, " +
                " si2 real(8, 2), " +
                " si3 real UNSIGNED, " +
                " si4 real ZEROFILL, " +
                " si5 real UNSIGNED ZEROFILL, " +
                " si6 real(8,2) UNSIGNED ZEROFILL " +

                ")";
        String format = MySQLUtils.format(sql);
        System.out.println(sql);
        System.out.println("--------------------------");
        System.out.println(format);
        Assert.assertEquals("CREATE TABLE t (\n" +
                "\tb1 BIT,\n" +
                "\tb2 BIT(1),\n" +
                "\tti1 TINYINT,\n" +
                "\tti2 TINYINT(1),\n" +
                "\tti3 TINYINT UNSIGNED,\n" +
                "\tti4 TINYINT ZEROFILL,\n" +
                "\tti5 TINYINT UNSIGNED ZEROFILL,\n" +
                "\tti6 TINYINT(1) UNSIGNED ZEROFILL,\n" +
                "\tb1 BOOL,\n" +
                "\tb2 BOOLEAN,\n" +
                "\tsi1 SMALLINT,\n" +
                "\tsi2 SMALLINT(1),\n" +
                "\tsi3 SMALLINT UNSIGNED,\n" +
                "\tsi4 SMALLINT ZEROFILL,\n" +
                "\tsi5 SMALLINT UNSIGNED ZEROFILL,\n" +
                "\tsi6 SMALLINT(1) UNSIGNED ZEROFILL,\n" +
                "\tsi1 MEDIUMINT,\n" +
                "\tsi2 MEDIUMINT(1),\n" +
                "\tsi3 MEDIUMINT UNSIGNED,\n" +
                "\tsi4 MEDIUMINT ZEROFILL,\n" +
                "\tsi5 MEDIUMINT UNSIGNED ZEROFILL,\n" +
                "\tsi6 MEDIUMINT(1) UNSIGNED ZEROFILL,\n" +
                "\tsi1 INT,\n" +
                "\tsi2 INT(1),\n" +
                "\tsi3 INT UNSIGNED,\n" +
                "\tsi4 INT ZEROFILL,\n" +
                "\tsi5 INT UNSIGNED ZEROFILL,\n" +
                "\tsi6 INT(1) UNSIGNED ZEROFILL,\n" +
                "\tsi1 INTEGER,\n" +
                "\tsi2 INTEGER(1),\n" +
                "\tsi3 INTEGER UNSIGNED,\n" +
                "\tsi4 INTEGER ZEROFILL,\n" +
                "\tsi5 INTEGER UNSIGNED ZEROFILL,\n" +
                "\tsi6 INTEGER(1) UNSIGNED ZEROFILL,\n" +
                "\tsi1 BIGINT,\n" +
                "\tsi2 BIGINT(1),\n" +
                "\tsi3 BIGINT UNSIGNED,\n" +
                "\tsi4 BIGINT ZEROFILL,\n" +
                "\tsi5 BIGINT UNSIGNED ZEROFILL,\n" +
                "\tsi6 BIGINT(1) UNSIGNED ZEROFILL,\n" +
                "\tsi1 DECIMAL,\n" +
                "\tsi2 DECIMAL(1),\n" +
                "\tsi2 DECIMAL(8, 2),\n" +
                "\tsi3 DECIMAL UNSIGNED,\n" +
                "\tsi4 DECIMAL ZEROFILL,\n" +
                "\tsi5 DECIMAL UNSIGNED ZEROFILL,\n" +
                "\tsi6 DECIMAL(1) UNSIGNED ZEROFILL,\n" +
                "\tsi6 DECIMAL(8, 2) UNSIGNED ZEROFILL,\n" +
                "\tsi1 DEC,\n" +
                "\tsi2 DEC(1),\n" +
                "\tsi2 DEC(8, 2),\n" +
                "\tsi3 DEC UNSIGNED,\n" +
                "\tsi4 DEC ZEROFILL,\n" +
                "\tsi5 DEC UNSIGNED ZEROFILL,\n" +
                "\tsi6 DEC(1) UNSIGNED ZEROFILL,\n" +
                "\tsi6 DEC(8, 2) UNSIGNED ZEROFILL,\n" +
                "\tsi1 NUMERIC,\n" +
                "\tsi2 NUMERIC(1),\n" +
                "\tsi2 NUMERIC(8, 2),\n" +
                "\tsi3 NUMERIC UNSIGNED,\n" +
                "\tsi4 NUMERIC ZEROFILL,\n" +
                "\tsi5 NUMERIC UNSIGNED ZEROFILL,\n" +
                "\tsi6 NUMERIC(1) UNSIGNED ZEROFILL,\n" +
                "\tsi6 NUMERIC(8, 2) UNSIGNED ZEROFILL,\n" +
                "\tsi1 FIXED,\n" +
                "\tsi2 FIXED(1),\n" +
                "\tsi2 FIXED(8, 2),\n" +
                "\tsi3 FIXED UNSIGNED,\n" +
                "\tsi4 FIXED ZEROFILL,\n" +
                "\tsi5 FIXED UNSIGNED ZEROFILL,\n" +
                "\tsi6 FIXED(1) UNSIGNED ZEROFILL,\n" +
                "\tsi6 FIXED(8, 2) UNSIGNED ZEROFILL,\n" +
                "\tsi1 FLOAT,\n" +
                "\tsi2 FLOAT(2),\n" +
                "\tsi2 FLOAT(8, 2),\n" +
                "\tsi3 FLOAT UNSIGNED,\n" +
                "\tsi4 FLOAT ZEROFILL,\n" +
                "\tsi5 FLOAT UNSIGNED ZEROFILL,\n" +
                "\tsi6 FLOAT(8, 2) UNSIGNED ZEROFILL,\n" +
                "\tsi1 DOUBLE,\n" +
                "\tsi2 DOUBLE(8, 2),\n" +
                "\tsi3 DOUBLE UNSIGNED,\n" +
                "\tsi4 DOUBLE ZEROFILL,\n" +
                "\tsi5 DOUBLE UNSIGNED ZEROFILL,\n" +
                "\tsi6 DOUBLE(8, 2) UNSIGNED ZEROFILL,\n" +
                "\tsi1 DOUBLE PRECISION,\n" +
                "\tsi2 DOUBLE PRECISION(8, 2),\n" +
                "\tsi3 DOUBLE PRECISION UNSIGNED,\n" +
                "\tsi4 DOUBLE PRECISION ZEROFILL,\n" +
                "\tsi5 DOUBLE PRECISION UNSIGNED ZEROFILL,\n" +
                "\tsi6 DOUBLE PRECISION(8, 2) UNSIGNED ZEROFILL,\n" +
                "\tsi1 REAL,\n" +
                "\tsi2 REAL(8, 2),\n" +
                "\tsi3 REAL UNSIGNED,\n" +
                "\tsi4 REAL ZEROFILL,\n" +
                "\tsi5 REAL UNSIGNED ZEROFILL,\n" +
                "\tsi6 REAL(8, 2) UNSIGNED ZEROFILL\n" +
                ")", format);
    }


}
