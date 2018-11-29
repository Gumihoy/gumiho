package com.aliyun.gumiho.sql.translate.visitor.oracle2.ppas;

import com.aliyun.gumiho.sql.dialect.ppas.visitor.PPASSQLASTVisitorAdapter;
import com.aliyun.gumiho.sql.translate.SQLTransformConfig;

/**
 * @author kongtong.ouyang onCondition 2018/1/16.
 */
public class Oracle2PPASVersion10ASTTransformVisitor extends PPASSQLASTVisitorAdapter {

    public Oracle2PPASVersion10ASTTransformVisitor(SQLTransformConfig config) {
        super(config);
    }
}
