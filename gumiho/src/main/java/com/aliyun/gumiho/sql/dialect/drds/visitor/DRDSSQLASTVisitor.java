package com.aliyun.gumiho.sql.dialect.drds.visitor;

import com.aliyun.gumiho.sql.dialect.drds.ast.element.expr.table.partition.*;
import com.aliyun.gumiho.sql.dialect.mysql.visitor.MySQLSQLASTVisitor;

/**
 * @author kongtong.ouyang onCondition 2018/2/8.
 */
public interface DRDSSQLASTVisitor extends MySQLSQLASTVisitor {

    // ------------------ Table Details Start ----------------------
    boolean visit(DRDSSQLDBPartitionByHash x);

    boolean visit(DRDSSQLDBPartitionByRangeHash x);

    boolean visit(DRDSSQLTBPartitionByHash x);

    boolean visit(DRDSSQLTBPartitionByRangeHash x);

    boolean visit(DRDSSQLTBPartitionByMM x);

    boolean visit(DRDSSQLTBPartitionByDD x);

    boolean visit(DRDSSQLTBPartitionByWeek x);

    boolean visit(DRDSSQLTBPartitionByMMDD x);
    // ------------------ Table Details End ----------------------

}
