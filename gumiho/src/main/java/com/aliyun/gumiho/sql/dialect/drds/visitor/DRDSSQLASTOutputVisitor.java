package com.aliyun.gumiho.sql.dialect.drds.visitor;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.config.SQLOutputConfig;
import com.aliyun.gumiho.sql.dialect.drds.ast.element.expr.table.partition.*;
import com.aliyun.gumiho.sql.dialect.mysql.visitor.MySQLSQLASTOutputVisitor;

/**
 * @author kongtong.ouyang onCondition 2018/2/8.
 */
public class DRDSSQLASTOutputVisitor extends MySQLSQLASTOutputVisitor implements DRDSSQLASTVisitor {

    public DRDSSQLASTOutputVisitor(StringBuilder appender) {
        super(appender);
    }

    public DRDSSQLASTOutputVisitor(StringBuilder appender, SQLOutputConfig config) {
        super(appender, config);
    }


    // ------------------ Table Details Start ----------------------

    @Override
    public boolean visit(DRDSSQLDBPartitionByHash x) {
        print(SQLReserved.DBPARTITION_BY);
        printSpaceAfterValue(SQLReserved.HASH);
        printSpaceAfterAccept(x.getColumns(), ", ", true);
        printIndentLnAndAccept(x.getTbPartitionBy());
        return false;
    }

    @Override
    public boolean visit(DRDSSQLDBPartitionByRangeHash x) {
        print(SQLReserved.DBPARTITION_BY);
        printSpaceAfterValue(SQLReserved.RANGE_HASH);

        printSpaceAfterValue(SQLReserved.LEFT_PAREN);
        printAccept(x.getColumns(), ", ");

        print(", ");
        print(x.getRangeHashNum());
        print(SQLReserved.RIGHT_PAREN);

        printIndentLnAndAccept(x.getTbPartitionBy());
        return false;
    }

    @Override
    public boolean visit(DRDSSQLTBPartitionByHash x) {
        print(SQLReserved.TBPARTITION_BY);
        printSpaceAfterValue(SQLReserved.HASH);
        printSpaceAfterAccept(x.getColumns(), ", ", true);

        printlnAfterTBPartitionsNum(x.getTbPartitionsNum());
        return false;
    }

    @Override
    public boolean visit(DRDSSQLTBPartitionByRangeHash x) {
        print(SQLReserved.TBPARTITION_BY);
        printSpaceAfterValue(SQLReserved.RANGE_HASH);

        printSpaceAfterValue(SQLReserved.LEFT_PAREN);
        printAccept(x.getColumns(), ", ");

        print(", ");
        print(x.getRangeHashNum());
        print(SQLReserved.RIGHT_PAREN);


        printlnAfterTBPartitionsNum(x.getTbPartitionsNum());
        return false;
    }

    @Override
    public boolean visit(DRDSSQLTBPartitionByMM x) {
        print(SQLReserved.TBPARTITION_BY);
        printSpaceAfterValue(SQLReserved.MM);
        printSpaceAfterAccept(x.getColumns(), ", ", true);

        printlnAfterTBPartitionsNum(x.getTbPartitionsNum());
        return false;
    }

    @Override
    public boolean visit(DRDSSQLTBPartitionByDD x) {
        print(SQLReserved.TBPARTITION_BY);
        printSpaceAfterValue(SQLReserved.DD);
        printSpaceAfterAccept(x.getColumns(), ", ", true);

        printlnAfterTBPartitionsNum(x.getTbPartitionsNum());
        return false;
    }

    @Override
    public boolean visit(DRDSSQLTBPartitionByWeek x) {
        print(SQLReserved.TBPARTITION_BY);
        printSpaceAfterValue(SQLReserved.WEEK);
        printSpaceAfterAccept(x.getColumns(), ", ", true);

        printlnAfterTBPartitionsNum(x.getTbPartitionsNum());
        return false;
    }

    @Override
    public boolean visit(DRDSSQLTBPartitionByMMDD x) {
        print(SQLReserved.TBPARTITION_BY);
        printSpaceAfterValue(SQLReserved.MMDD);
        printSpaceAfterAccept(x.getColumns(), ", ", true);

        printlnAfterTBPartitionsNum(x.getTbPartitionsNum());
        return false;
    }

    public void printlnAfterTBPartitionsNum(SQLExpr tbPartitionsNum) {
        if (tbPartitionsNum == null) {
            return;
        }
        printlnAfterValue(SQLReserved.TBPARTITIONS);
        printSpaceAfterAccept(tbPartitionsNum);
    }
    // ------------------ Table Details End ----------------------

}
