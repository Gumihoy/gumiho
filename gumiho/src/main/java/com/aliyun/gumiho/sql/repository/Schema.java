package com.aliyun.gumiho.sql.repository;

import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.statement.SQLStatement;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author kongtong.ouyang on 2018/10/14.
 */
public class Schema {

    private static final ConcurrentHashMap<SQLName, SQLStatement> SQL_STATEMENT_CONCURRENT_HASH_MAP = new ConcurrentHashMap<>();


}
