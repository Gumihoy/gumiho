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
package com.aliyun.gumiho.sql.translate;

import com.aliyun.gumiho.sql.basic.ast.SQLObject;
import com.aliyun.gumiho.sql.basic.ast.element.datatype.SQLDataType;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.config.DRDSConfig;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.DBVersion;
import com.aliyun.gumiho.sql.enums.DoubleQuoteActionType;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author kongtong.ouyang onCondition 2018/1/23.
 */
public class SQLTransformConfig {

    public DBType source;
    public DBType target;
    public DBVersion targetVersion;

    /**
     * 表名、字段名移除引号
     */
    public DoubleQuoteActionType doubleQuoteAction = DoubleQuoteActionType.NONE;

    /**
     * 对象名(表、视图、PL/SQL等)、字段名移除schema
     */
    public boolean removeSchema = false;


    private Map<String, TableMapping> tableMappings = new LinkedHashMap<>();

    public TableMapping findTableMapping(SQLName tableName) {

        String lowerFullName = tableName.getFullName().toLowerCase();
        String lowerName = tableName.getName().toLowerCase();

        TableMapping mapping = tableMappings.get(lowerFullName);
        if (mapping != null) {
            return mapping;
        }

        return tableMappings.get(lowerName);
    }

    public void addTableMapping(TableMapping tableMapping) {
        if (tableMapping == null
                || tableMapping.name == null
                || tableMapping.name.length() == 0) {
            return;
        }
        this.tableMappings.put(tableMapping.name.toLowerCase(), tableMapping);

        if (tableMapping.targetName == null) {
            tableMapping.targetName = tableMapping.name;
        }
    }

    public static class TableMapping {
        public String owner;
        public String name;
        public String targetOwner;
        public String targetName;
        /**
         * 修改字段
         */
        public final Set<ColumnMapping> columnMappings = new LinkedHashSet<>();
        /**
         * 移除字段
         */
        public final Set<String> removeColumns = new LinkedHashSet<>();
        /**
         * 添加字段
         */
        public final Set<ColumnMapping> addColumnMappings = new LinkedHashSet<>();

        public DRDSConfig drdsConfig;


        public TableMapping(String name, String targetName, ColumnMapping... columnMappings) {
            this.name = name;
            this.targetName = targetName;

            for (ColumnMapping columnMapping : columnMappings) {
                addColumnMapping(columnMapping);
            }
        }


        public ColumnMapping findColumnMapping(String columnName) {
            for (ColumnMapping columnMapping : columnMappings) {
                if (columnMapping.name.equals(columnName)) {
                    return columnMapping;
                }
            }

            for (ColumnMapping columnMapping : columnMappings) {
                if (columnMapping.name.equalsIgnoreCase(columnName)) {
                    return columnMapping;
                }
            }
            return null;
        }

        public void addColumnMapping(ColumnMapping columnMapping) {
            if (columnMapping == null) {
                return;
            }
            this.columnMappings.add(columnMapping);
        }

        public boolean isRemoveColumn(String columnName) {
            return removeColumns.contains(columnName);
        }

        public void addRemoveColumn(String columnName) {
            removeColumns.add(columnName);
        }

        public void addAddColumnMapping(ColumnMapping columnMapping) {
            if (columnMapping == null) {
                return;
            }
            this.addColumnMappings.add(columnMapping);
        }
    }


    // 当前遍历下标
    public int index = 0;
    // 当前 sql 的 stmt LIST
    public List<SQLObject> stmtList = new ArrayList<>();


    /**
     * CREATE index ON table 映射关系
     */
    private final ConcurrentHashMap<String, String> INDEX_TABLE_MAP = new ConcurrentHashMap<>();

    public String getIndexTable(String index) {
        return INDEX_TABLE_MAP.get(index);
    }

    public void setIndexTable(String index, String table) {
        INDEX_TABLE_MAP.put(index, table);
    }


    public static class ColumnMapping {
        public String name;
        public String targetName;
        public SQLDataType dataType;
        public SQLExpr defaultValue;

        public ColumnMapping() {

        }

        public ColumnMapping(String name, String targetName) {
            this.name = name;
            this.targetName = targetName;
        }

        public ColumnMapping(String name, String targetName, SQLDataType dataType) {
            this.name = name;
            this.targetName = targetName;
            this.dataType = dataType;
        }

        public ColumnMapping(String name, String targetName, SQLDataType dataType, SQLExpr defaultValue) {
            this.name = name;
            this.targetName = targetName;
            this.dataType = dataType;
            this.defaultValue = defaultValue;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            ColumnMapping that = (ColumnMapping) o;

            return name != null ? name.equals(that.name) : that.name == null;
        }

        @Override
        public int hashCode() {
            return name != null ? name.hashCode() : 0;
        }
    }




}
