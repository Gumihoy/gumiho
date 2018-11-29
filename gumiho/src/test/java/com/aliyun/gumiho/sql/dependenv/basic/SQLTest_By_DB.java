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
package com.aliyun.gumiho.sql.dependenv.basic;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.util.JdbcUtils;
import com.alibaba.druid.util.ResultSetConsumer;

import org.junit.After;
import org.junit.Before;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.function.Consumer;

/**
 * @author kongtong.ouyang onCondition 2018/3/15.
 */
public class SQLTest_By_DB {

    protected final String resource;
    protected DruidDataSource dataSource;

    public SQLTest_By_DB() {
        this("db.properties");
    }

    public SQLTest_By_DB(String resource) {
        this.resource = resource;
    }

    @Before
    public void setUp() throws Exception {
        dataSource = createDataSourceFromResource(resource);
    }

    static DruidDataSource createDataSourceFromResource(String resource) throws IOException {
        Properties properties = new Properties();

        InputStream configStream = null;
        try {
            configStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(resource);
            properties.load(configStream);
        } finally {
            if (configStream != null) {
                configStream.close();
            }
        }

        DruidDataSource dataSource = new DruidDataSource();
        dataSource.configFromPropety(properties);
        return dataSource;
    }

    @After
    public void tearDown() throws Exception {
        dataSource.close();
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public void loadDBID(Consumer<Long> consumer) throws SQLException {
        JdbcUtils.executeQuery(dataSource
                , new ResultSetConsumer<Long>() {
                    @Override
                    public Long apply(ResultSet rs) throws SQLException {
                        Long dbid = rs.getLong("dbid");
                        return dbid;
                    }

                    @Override
                    public void accept(Long object) {
                        consumer.accept(object);
                    }
                }
                , "select dbid from object_sequence group by dbid"
        );
    }

    public void loadPPASDDL(long dbid, Consumer<SQL> consumer) throws SQLException {
        JdbcUtils.executeQuery(dataSource
                , new ResultSetConsumer<SQL>() {
                    @Override
                    public SQL apply(ResultSet rs) throws SQLException {
                        SQL sql = new SQL();
                        sql.dbid = rs.getLong("dbid");
                        sql.owner = rs.getString("owner");
                        sql.sourceSQL = rs.getString("sourceDDL");
                        return sql;
                    }

                    @Override
                    public void accept(SQL object) {
                        consumer.accept(object);
                    }
                }
                , "select * from object_sequence where dbid = ? and target_db = 'PPAS' order by id"
                , dbid
        );
    }


    public static class Schemal {
        public String name;


    }

    public static class SQL {
        public long dbid;
        public String owner;
        public String sourceSQL;
        public String targetSQL;
    }

}
