package com.aliyun.gumiho.sql.translate.visitor.oracle2.sqlserver;

import com.aliyun.gumiho.sql.config.SQLOutputConfig;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTOutputVisitor;
import com.aliyun.gumiho.sql.dialect.sqlserver.visitor.SQLServerSQLASTVisitor;

/**
 * @author kongtong.ouyang onCondition 2018/1/16.
 */
public class Oracle2SQLServerASTOutputVisitor extends OracleSQLASTOutputVisitor implements SQLServerSQLASTVisitor {

    public Oracle2SQLServerASTOutputVisitor(StringBuilder appender) {
        super(appender);
    }

    public Oracle2SQLServerASTOutputVisitor(StringBuilder appender, SQLOutputConfig config) {
        super(appender, config);
    }
}
