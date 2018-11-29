/*
 * Copyright (C) 2017-2018 kent(kent.bohai@gmail.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.aliyun.gumiho.sql.bvt.dialect.oracle.ddl.database.create;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/3/15.
 */
public class OracleCreateDatabaseTest_1_CDB {

    @Test
    public void test() {
        String s = "CREATE DATABASE newcdb\n" +
                "  USER SYS IDENTIFIED BY sys_password\n" +
                "  USER SYSTEM IDENTIFIED BY system_password\n" +
                "  LOGFILE GROUP 1 ('/u01/logs/my/redo01a.log','/u02/logs/my/redo01b.log')\n" +
                "             SIZE 100M BLOCKSIZE 512,\n" +
                "          GROUP 2 ('/u01/logs/my/redo02a.log','/u02/logs/my/redo02b.log')\n" +
                "             SIZE 100M BLOCKSIZE 512,\n" +
                "          GROUP 3 ('/u01/logs/my/redo03a.log','/u02/logs/my/redo03b.log')\n" +
                "             SIZE 100M BLOCKSIZE 512\n" +
                "  MAXLOGHISTORY 1\n" +
                "  MAXLOGFILES 16\n" +
                "  MAXLOGMEMBERS 3\n" +
                "  MAXDATAFILES 1024\n" +
                "  CHARACTER SET AL32UTF8\n" +
                "  NATIONAL CHARACTER SET AL16UTF16\n" +
                "  EXTENT MANAGEMENT LOCAL\n" +
                "  DATAFILE '/u01/app/oracle/oradata/newcdb/system01.dbf'\n" +
                "    SIZE 700M REUSE AUTOEXTEND ON NEXT 10240K MAXSIZE UNLIMITED\n" +
                "  SYSAUX DATAFILE '/u01/app/oracle/oradata/newcdb/sysaux01.dbf'\n" +
                "    SIZE 550M REUSE AUTOEXTEND ON NEXT 10240K MAXSIZE UNLIMITED\n" +
                "  DEFAULT TABLESPACE deftbs\n" +
                "    DATAFILE '/u01/app/oracle/oradata/newcdb/deftbs01.dbf'\n" +
                "    SIZE 500M REUSE AUTOEXTEND ON MAXSIZE UNLIMITED\n" +
                "  DEFAULT TEMPORARY TABLESPACE tempts1\n" +
                "    TEMPFILE '/u01/app/oracle/oradata/newcdb/temp01.dbf'\n" +
                "    SIZE 20M REUSE AUTOEXTEND ON NEXT 640K MAXSIZE UNLIMITED\n" +
                "  UNDO TABLESPACE undotbs1\n" +
                "    DATAFILE '/u01/app/oracle/oradata/newcdb/undotbs01.dbf'\n" +
                "    SIZE 200M REUSE AUTOEXTEND ON NEXT 5120K MAXSIZE UNLIMITED\n" +
                "  ENABLE PLUGGABLE DATABASE\n" +
                "    SEED\n" +
                "    FILE_NAME_CONVERT = ('/u01/app/oracle/oradata/newcdb/',\n" +
                "                         '/u01/app/oracle/oradata/pdbseed/')\n" +
                "    SYSTEM DATAFILES SIZE 125M AUTOEXTEND ON NEXT 10M MAXSIZE UNLIMITED\n" +
                "    SYSAUX DATAFILES SIZE 100M\n" +
                "  USER_DATA TABLESPACE usertbs\n" +
                "    DATAFILE '/u01/app/oracle/oradata/pdbseed/usertbs01.dbf'\n" +
                "    SIZE 200M REUSE AUTOEXTEND ON MAXSIZE UNLIMITED;";

        System.out.println(s);
        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals(s, formatSQL);
    }
}
