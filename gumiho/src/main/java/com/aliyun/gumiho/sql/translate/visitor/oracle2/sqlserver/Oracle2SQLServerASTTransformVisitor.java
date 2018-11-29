package com.aliyun.gumiho.sql.translate.visitor.oracle2.sqlserver;

import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitorAdapter;
import com.aliyun.gumiho.sql.dialect.sqlserver.visitor.SQLServerSQLASTVisitor;
import com.aliyun.gumiho.sql.translate.SQLTransformConfig;

/**
 * @author kongtong.ouyang onCondition 2018/1/16.
 */
public class Oracle2SQLServerASTTransformVisitor extends OracleSQLASTVisitorAdapter implements SQLServerSQLASTVisitor {

    public Oracle2SQLServerASTTransformVisitor(SQLTransformConfig config) {
        super(config);
    }
}
