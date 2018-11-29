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
package com.aliyun.gumiho.sql.enums;

/**
 * @author kongtong.ouyang onCondition 2018/1/25.
 */
public enum DBVersion {

    Oracle_Version_9i("9i"),
    Oracle_Version_10g("10g"),
    Oracle_Version_11g("11g"),
    Oracle_Version_12c("12c"),
    Oracle_Version_18("18"),

    MYSQL_VERSION_5_6("5.6"),
    MYSQL_VERSION_5_7("5.7"),
    MYSQL_VERSION_8_0("8.0"),

    DRDS_VERSION_5_6("5.6"),
    DRDS_VERSION_5_7("5.7"),
    DRDS_VERSION_8_0("8.0"),


    ADS_VERSION(""),


    PPAS_VERSION_9_6("9.6"),
    PPAS_VERSION_10("10"),


    POSTGRESQL_VERSION_9_6("9.6"),
    POSTGRESQL_VERSION_10("10"),


    SQL_SERVER_VERSION_2008("2008"),
    SQL_SERVER_VERSION_2012("2012"),
    SQL_SERVER_VERSION_2014("2014"),
    SQL_SERVER_VERSION_2016("2016"),
    SQL_SERVER_VERSION_2017("2017"),


    ;

    public final String version;

    DBVersion(String version) {
        this.version = version;
    }

    public static DBVersion defaultVersion(DBType targetDBType) {
        if (targetDBType == null) {
            throw new IllegalArgumentException("database type is null.");
        }

        switch (targetDBType) {
            case Oracle:
                return DefaultVersion.ORACLE_VERSION_DEFAULT;
            case MySQL:
                return DefaultVersion.MYSQL_VERSION_DEFAULT;
            case DRDS:
                return DefaultVersion.DRDS_VERSION_DEFAULT;
            case ADS:
                return DefaultVersion.ADS_VERSION_DEFAULT;
            case PPAS:
                return DefaultVersion.PPAS_VERSION_DEFAULT;
            case PostgreSQL:
                return DefaultVersion.POSTGRESQL_VERSION_DEFAULT;
            case SQLServer:
                return DefaultVersion.SQL_SERVER_VERSION_DEFAULT;

        }

        throw new IllegalArgumentException("database type: " + targetDBType + " not support.");
    }


    public interface DefaultVersion {
        DBVersion ORACLE_VERSION_DEFAULT = DBVersion.Oracle_Version_11g;
        DBVersion MYSQL_VERSION_DEFAULT = DBVersion.MYSQL_VERSION_5_6;
        DBVersion DRDS_VERSION_DEFAULT = DBVersion.DRDS_VERSION_5_6;
        DBVersion ADS_VERSION_DEFAULT = DBVersion.ADS_VERSION;
        DBVersion PPAS_VERSION_DEFAULT = DBVersion.PPAS_VERSION_9_6;
        DBVersion POSTGRESQL_VERSION_DEFAULT = DBVersion.POSTGRESQL_VERSION_9_6;
        DBVersion SQL_SERVER_VERSION_DEFAULT = DBVersion.SQL_SERVER_VERSION_2017;
    }


}
