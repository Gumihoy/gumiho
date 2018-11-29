package com.aliyun.gumiho.sql.config;

import com.aliyun.gumiho.sql.dialect.drds.ast.enums.DRDSSQLDBPartitionType;
import com.aliyun.gumiho.sql.dialect.drds.ast.enums.DRDSSQLTBPartitionType;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kongtong.ouyang on 2018/9/3.
 */
public class DRDSConfig {

    /**
     * 创建广播表
     */
    public boolean createBroadcastTable = false;
    /**
     * 分库：分库字段
     */
    public DRDSDBPartition dbPartition = null;
    /**
     * 分表：分表字段
     */
    public DRDSTBPartition tbPartition = null;


    /**
     * DRDS 分库
     */
    public static class DRDSDBPartition {
        public List<String> columnNames = new ArrayList<>();
        public DRDSSQLDBPartitionType type;
        /**
         * type = range_Hash , 必须设置 num
         * 默认值： 10
         */
        public Integer rangeHashNum = null;

        public DRDSDBPartition(DRDSSQLDBPartitionType type, String... names) {
            this.type = type;
            for (String name : names) {
                this.columnNames.add(name);
            }

        }

        public DRDSDBPartition(DRDSSQLDBPartitionType type, Integer rangeHashNum, String... names) {
            this.type = type;
            this.rangeHashNum = rangeHashNum;
            for (String name : names) {
                this.columnNames.add(name);
            }

        }
    }


    /**
     * DRDS 分表
     */
    public static class DRDSTBPartition {
        public List<String> columnNames = new ArrayList<>();
        public DRDSSQLTBPartitionType type;
        /**
         * type = range_Hash , 必须设置 num
         * 默认值： 10
         */
        public Integer rangeHashNum;
        public Integer partitionNum;

        public DRDSTBPartition() {
        }

        public DRDSTBPartition(DRDSSQLTBPartitionType type, String... columnNames) {

            this.type = type;
            for (String columnName : columnNames) {
                this.columnNames.add(columnName);
            }
        }

        public DRDSTBPartition(DRDSSQLTBPartitionType type, Integer partitionNum, String... columnNames) {
            this.type = type;
            this.partitionNum = partitionNum;
            for (String columnName : columnNames) {
                this.columnNames.add(columnName);
            }
        }
    }

}
