package com.aliyun.gumiho.sql.bvt.dialect.mysql.element.datatype;

import com.aliyun.gumiho.sql.util.MySQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/5/15.
 */
public class MySQLSQLDataTypeTest_0_Character {


    @Test
    public void test() {
        String sql = "Create table t(" +
                " c1 char, \n" +
                " c2 char(1), \n" +
                " c3 char CHARACTER SET utf8, \n" +
                " c4 char COLLATE latin1_general_cs, \n" +
                " c5 char CHARACTER SET utf8 COLLATE latin1_general_cs, \n" +
                " c6 char(1) CHARACTER SET utf8, \n" +
                " c7 char(1) COLLATE latin1_general_cs, \n" +
                " c8 char(1) CHARACTER SET utf8 COLLATE latin1_general_cs, \n" +

                " nc1 national char, \n" +
                " nc2 national char(1), \n" +
                " nc3 national char CHARACTER SET utf8, \n" +
                " nc3 national char COLLATE latin1_general_cs, \n" +
                " nc3 national char CHARACTER SET utf8 COLLATE latin1_general_cs, \n" +
                " nc4 national char(1) CHARACTER SET utf8, \n" +
                " nc4 national char(1) COLLATE latin1_general_cs, \n" +
                " nc4 national char(1) CHARACTER SET utf8 COLLATE latin1_general_cs, \n" +

                " vc21 varchar(1), \n" +
                " vc22 varchar(1) CHARACTER SET utf8, \n" +
                " vc23 varchar(1) COLLATE latin1_general_cs, \n" +
                " vc24 varchar(1) CHARACTER SET utf8 COLLATE latin1_general_cs, \n" +

                " nvc21 national varchar(1), \n" +
                " nvc22 national varchar(1) CHARACTER SET utf8, \n" +
                " nvc23 national varchar(1) COLLATE latin1_general_cs, \n" +
                " nvc24 national varchar(1) CHARACTER SET utf8 COLLATE latin1_general_cs, \n" +

                " b1 binary, \n" +
                " b2 binary(1), \n" +

                " vb1 varbinary(1), \n" +

                " tb tinyblob, \n" +

                " tt1 tinytext, \n" +
                " tt2 tinytext CHARACTER SET utf8, \n" +
                " tt3 tinytext COLLATE latin1_general_cs, \n" +
                " tt4 tinytext CHARACTER SET utf8 COLLATE latin1_general_cs, \n" +

                " blob1 blob, \n" +
                " blob2 blob(1), \n" +

                " t1 text, \n" +
                " t2 text CHARACTER SET utf8, \n" +
                " t3 text COLLATE latin1_general_cs, \n" +
                " t4 text CHARACTER SET utf8 COLLATE latin1_general_cs, \n" +

                " t5 text(1), \n" +
                " t6 text(1) CHARACTER SET utf8, \n" +
                " t7 text(1) COLLATE latin1_general_cs, \n" +
                " t8 text(1) CHARACTER SET utf8 COLLATE latin1_general_cs, \n" +

                " mbb1 mediumblob, \n" +

                " mt1 mediumtext, \n" +
                " mt2 mediumtext CHARACTER SET utf8, \n" +
                " mt3 mediumtext COLLATE latin1_general_cs, \n" +
                " mt4 mediumtext CHARACTER SET utf8 COLLATE latin1_general_cs, \n" +

                " lb1 longblob, \n" +

                " lt1 longtext, \n" +
                " lt2 longtext CHARACTER SET utf8, \n" +
                " lt3 longtext COLLATE latin1_general_cs, \n" +
                " lt4 longtext CHARACTER SET utf8 COLLATE latin1_general_cs, \n" +

                " e1 enum('v1', 'v2'), " +
                " e2 enum('v1', 'v2') CHARACTER SET utf8, " +
                " e3 enum('v1', 'v2') COLLATE latin1_general_cs, " +
                " e4 enum('v1', 'v2') CHARACTER SET utf8 COLLATE latin1_general_cs, " +

                " s1 set('v1', 'v2'), \n" +
                " s2 set('v1', 'v2') CHARACTER SET utf8, \n" +
                " s3 set('v1', 'v2') COLLATE latin1_general_cs, \n" +
                " s4 set('v1', 'v2') CHARACTER SET utf8 COLLATE latin1_general_cs \n" +

                ")";

        System.out.println(sql);
        String format = MySQLUtils.format(sql);
        System.out.println("--------------------------");
        System.out.println(format);
        Assert.assertEquals("CREATE TABLE t (\n" +
                "\tc1 CHAR,\n" +
                "\tc2 CHAR(1),\n" +
                "\tc3 CHAR CHARACTER SET utf8,\n" +
                "\tc4 CHAR COLLATE latin1_general_cs,\n" +
                "\tc5 CHAR CHARACTER SET utf8 COLLATE latin1_general_cs,\n" +
                "\tc6 CHAR(1) CHARACTER SET utf8,\n" +
                "\tc7 CHAR(1) COLLATE latin1_general_cs,\n" +
                "\tc8 CHAR(1) CHARACTER SET utf8 COLLATE latin1_general_cs,\n" +
                "\tnc1 NATIONAL CHAR,\n" +
                "\tnc2 NATIONAL CHAR(1),\n" +
                "\tnc3 NATIONAL CHAR CHARACTER SET utf8,\n" +
                "\tnc3 NATIONAL CHAR COLLATE latin1_general_cs,\n" +
                "\tnc3 NATIONAL CHAR CHARACTER SET utf8 COLLATE latin1_general_cs,\n" +
                "\tnc4 NATIONAL CHAR(1) CHARACTER SET utf8,\n" +
                "\tnc4 NATIONAL CHAR(1) COLLATE latin1_general_cs,\n" +
                "\tnc4 NATIONAL CHAR(1) CHARACTER SET utf8 COLLATE latin1_general_cs,\n" +
                "\tvc21 VARCHAR(1),\n" +
                "\tvc22 VARCHAR(1) CHARACTER SET utf8,\n" +
                "\tvc23 VARCHAR(1) COLLATE latin1_general_cs,\n" +
                "\tvc24 VARCHAR(1) CHARACTER SET utf8 COLLATE latin1_general_cs,\n" +
                "\tnvc21 NATIONAL VARCHAR(1),\n" +
                "\tnvc22 NATIONAL VARCHAR(1) CHARACTER SET utf8,\n" +
                "\tnvc23 NATIONAL VARCHAR(1) COLLATE latin1_general_cs,\n" +
                "\tnvc24 NATIONAL VARCHAR(1) CHARACTER SET utf8 COLLATE latin1_general_cs,\n" +
                "\tb1 BINARY,\n" +
                "\tb2 BINARY(1),\n" +
                "\tvb1 VARBINARY(1),\n" +
                "\ttb TINYBLOB,\n" +
                "\ttt1 TINYTEXT,\n" +
                "\ttt2 TINYTEXT CHARACTER SET utf8,\n" +
                "\ttt3 TINYTEXT COLLATE latin1_general_cs,\n" +
                "\ttt4 TINYTEXT CHARACTER SET utf8 COLLATE latin1_general_cs,\n" +
                "\tblob1 BLOB,\n" +
                "\tblob2 BLOB(1),\n" +
                "\tt1 TEXT,\n" +
                "\tt2 TEXT CHARACTER SET utf8,\n" +
                "\tt3 TEXT COLLATE latin1_general_cs,\n" +
                "\tt4 TEXT CHARACTER SET utf8 COLLATE latin1_general_cs,\n" +
                "\tt5 TEXT(1),\n" +
                "\tt6 TEXT(1) CHARACTER SET utf8,\n" +
                "\tt7 TEXT(1) COLLATE latin1_general_cs,\n" +
                "\tt8 TEXT(1) CHARACTER SET utf8 COLLATE latin1_general_cs,\n" +
                "\tmbb1 MEDIUMBLOB,\n" +
                "\tmt1 MEDIUMTEXT,\n" +
                "\tmt2 MEDIUMTEXT CHARACTER SET utf8,\n" +
                "\tmt3 MEDIUMTEXT COLLATE latin1_general_cs,\n" +
                "\tmt4 MEDIUMTEXT CHARACTER SET utf8 COLLATE latin1_general_cs,\n" +
                "\tlb1 LONGBLOB,\n" +
                "\tlt1 LONGTEXT,\n" +
                "\tlt2 LONGTEXT CHARACTER SET utf8,\n" +
                "\tlt3 LONGTEXT COLLATE latin1_general_cs,\n" +
                "\tlt4 LONGTEXT CHARACTER SET utf8 COLLATE latin1_general_cs,\n" +
                "\te1 ENUM('v1', 'v2'),\n" +
                "\te2 ENUM('v1', 'v2') CHARACTER SET utf8,\n" +
                "\te3 ENUM('v1', 'v2') COLLATE latin1_general_cs,\n" +
                "\te4 ENUM('v1', 'v2') CHARACTER SET utf8 COLLATE latin1_general_cs,\n" +
                "\ts1 SET('v1', 'v2'),\n" +
                "\ts2 SET('v1', 'v2') CHARACTER SET utf8,\n" +
                "\ts3 SET('v1', 'v2') COLLATE latin1_general_cs,\n" +
                "\ts4 SET('v1', 'v2') CHARACTER SET utf8 COLLATE latin1_general_cs\n" +
                ")", format);
    }


}
