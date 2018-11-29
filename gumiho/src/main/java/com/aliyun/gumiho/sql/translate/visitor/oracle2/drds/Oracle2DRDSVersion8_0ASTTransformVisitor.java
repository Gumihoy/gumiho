package com.aliyun.gumiho.sql.translate.visitor.oracle2.drds;

import com.aliyun.gumiho.sql.dialect.drds.ast.element.expr.table.partition.*;
import com.aliyun.gumiho.sql.dialect.drds.visitor.DRDSSQLASTVisitor;
import com.aliyun.gumiho.sql.translate.SQLTransformConfig;
import com.aliyun.gumiho.sql.translate.visitor.oracle2.mysql.Oracle2MySQLVersion8_0ASTTransformVisitor;

/**
 * @author kongtong.ouyang onCondition 2018/1/16.
 */
public class Oracle2DRDSVersion8_0ASTTransformVisitor extends Oracle2MySQLVersion8_0ASTTransformVisitor implements DRDSSQLASTVisitor {

    public Oracle2DRDSVersion8_0ASTTransformVisitor(SQLTransformConfig config) {
        super(config);
    }

    // ------------------ Table Details Start ----------------------

    @Override
    public boolean visit(DRDSSQLDBPartitionByHash x) {
        return true;
    }

    @Override
    public boolean visit(DRDSSQLDBPartitionByRangeHash x) {
        return true;
    }

    @Override
    public boolean visit(DRDSSQLTBPartitionByHash x) {
        return true;
    }

    @Override
    public boolean visit(DRDSSQLTBPartitionByRangeHash x) {
        return true;
    }

    @Override
    public boolean visit(DRDSSQLTBPartitionByMM x) {
        return true;
    }

    @Override
    public boolean visit(DRDSSQLTBPartitionByDD x) {
        return true;
    }

    @Override
    public boolean visit(DRDSSQLTBPartitionByWeek x) {
        return true;
    }

    @Override
    public boolean visit(DRDSSQLTBPartitionByMMDD x) {
        return true;
    }

    // ------------------ Table Details End ----------------------
}
