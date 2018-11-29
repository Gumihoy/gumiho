package com.aliyun.gumiho.sql.dialect.ppas.visitor;

import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;
import com.aliyun.gumiho.sql.dialect.postgresql.visitor.PostgreSQLSQLASTVisitor;

/**
 * @author kongtong.ouyang onCondition 2018/2/8.
 */
public interface PPASSQLASTVisitor extends OracleSQLASTVisitor, PostgreSQLSQLASTVisitor {
}
