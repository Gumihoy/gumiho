package com.aliyun.gumiho.sql.repository;

import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author kongtong.ouyang on 2018/10/14.
 */
public class SchemaRepository {

    private static final ConcurrentHashMap<SQLName, Schema> SCHEMA_CONCURRENT_MAP = new ConcurrentHashMap<>();



}
