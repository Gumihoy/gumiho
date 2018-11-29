package com.aliyun.gumiho.sql.enums;

/**
 * 双引号处理方式
 *
 * @author kongtong.ouyang on 2018/7/19.
 */
public enum DoubleQuoteActionType {
    NONE,       // 原样不处理
    REMOVE,     // 移除
    MIX         // 1、全是中文移除 2、有小写字母，数字开头保留双引号
    ;
}
