package com.aliyun.gumiho.sql.dialect.mysql.visitor;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.ISQLSelectQuery;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.limit.SQLLimitOffsetClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.SQLColumnDefinition;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.constraint.column.ISQLColumnConstraint;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.constraint.column.ISQLNullColumnConstraint;
import com.aliyun.gumiho.sql.basic.ast.element.literal.numeric.SQLIntegerLiteral;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLRowType;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.table.SQLCreateTableStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTOutputVisitor;
import com.aliyun.gumiho.sql.config.SQLOutputConfig;
import com.aliyun.gumiho.sql.dialect.mysql.ast.element.expr.MySQLSQLMatchExpr;
import com.aliyun.gumiho.sql.dialect.mysql.ast.element.expr.select.MySQLSQLOJTableReference;
import com.aliyun.gumiho.sql.dialect.mysql.ast.element.expr.select.MySQLSQLSelectQuery;
import com.aliyun.gumiho.sql.dialect.mysql.ast.statement.utility.MySQLSQLHelpStatement;

import java.util.List;

/**
 * @author kongtong.ouyang onCondition 2018/2/8.
 */
public class MySQLSQLASTOutputVisitor extends SQLASTOutputVisitor implements MySQLSQLASTVisitor{

    public MySQLSQLASTOutputVisitor(StringBuilder appender) {
        super(appender);
    }

    public MySQLSQLASTOutputVisitor(StringBuilder appender, SQLOutputConfig config) {
        super(appender, config);
    }




    @Override
    public boolean visit(SQLCreateTableStatement x) {
        print(SQLReserved.CREATE);

        printSpaceAfterValue(x.getScope());

        printSpaceAfterValue(SQLReserved.TABLE);

        if (x.isIfNotExists()) {
            printSpaceAfterValue(SQLReserved.IF_NOT_EXISTS);
        }

        printSpaceAfterAccept(x.getName());

        printTableElements(x.getTableElements(), x.isTableElementsParen());

        printSpaceAfterAccept(x.getProperties(), " ");

        printlnAndAccept(x.getPartitionBy());

        ISQLSelectQuery subQuery = x.getSubQuery();
        if (subQuery != null) {
            if (x.isAs()) {
                printlnAfterValue(SQLReserved.AS);
            }
            printIndentLnAndAccept(x.getSubQuery());
        }

        return false;
    }

    @Override
    public boolean visit(MySQLSQLHelpStatement x) {
        print(SQLReserved.HELP);
        printSpaceAfterAccept(x.getValue());
        return false;
    }


    // ------------------------- Literal Start ----------------------------------------

    // ------------------------- Literal End ----------------------------------------


    // ------------------------- Comment Start ----------------------------------------

    // ------------------------- Comment End ----------------------------------------

    // ------------------------- Hint Start ----------------------------------------

    // ------------------------- Hint End ----------------------------------------


    // ------------------------- Commons Expr Start ----------------------------------------

    @Override
    public boolean visit(MySQLSQLMatchExpr x) {
        return false;
    }


    // ------------------------- Commons Expr End ----------------------------------------


    // ------------------ Details ----------------------


    // ------------------ Select Details Start ----------------------

    @Override
    public boolean visit(MySQLSQLSelectQuery x) {
        print(SQLReserved.SELECT);

        printSpaceAfterValue(x.getSetQuantifier());

        if (x.isHighPriority()) {
            printSpaceAfterValue(SQLReserved.HIGH_PRIORITY);
        }

        if (x.isStraightJoin()) {
            printSpaceAfterValue(SQLReserved.STRAIGHT_JOIN);
        }

        if (x.isSmallResult()) {
            printSpaceAfterValue(SQLReserved.SQL_SMALL_RESULT);
        }

        if (x.isBigResult()) {
            printSpaceAfterValue(SQLReserved.SQL_BIG_RESULT);
        }

        if (x.isBufferResult()) {
            printSpaceAfterValue(SQLReserved.SQL_BUFFER_RESULT);
        }

        printSpaceAfterValue(x.getCache());

        if (x.isCalcFoundRows()) {
            printSpaceAfterValue(SQLReserved.SQL_CALC_FOUND_ROWS);
        }

        printSpace();
        printSelectItems(x.getSelectItems());

        printlnAndAccept(x.getFromClause());

        printlnAndAccept(x.getWhereClause());

        printlnAndAccept(x.getGroupByClause());

        printlnAndAccept(x.getWindowClause());

        printlnAndAccept(x.getOrderByClause());

        printlnAndAccept(x.getLimitClause());


        return false;
    }

    @Override
    public boolean visit(MySQLSQLSelectQuery.MySQLSQLIntoOutFileClause x) {
        return false;
    }

    @Override
    public boolean visit(MySQLSQLSelectQuery.MySQLSQLIntoDumpFileClause x) {
        return false;
    }

    @Override
    public boolean visit(MySQLSQLSelectQuery.MySQLSQLIntoClause x) {
        return false;
    }


    @Override
    public boolean visit(MySQLSQLOJTableReference x) {
        print(SQLReserved.LEFT_BRACE);
        print(SQLReserved.OJ);

        printSpace();
        x.getTableReference().accept(this);
        print(SQLReserved.RIGHT_BRACE);
        return false;
    }

    @Override
    public boolean visit(SQLLimitOffsetClause x) {
        print(SQLReserved.LIMIT);

        boolean isOffset = x.isOffset();
        SQLExpr offset = x.getOffsetExpr();
        if (offset != null
                && !isOffset) {
            printSpace();
            offset.accept(this);
            print(",");
        }

        SQLExpr rowCountExpr = x.getRowCountExpr();
        if (rowCountExpr == null) {
            rowCountExpr = SQLIntegerLiteral.max();
        }
        printSpaceAfterAccept(rowCountExpr);

        if (offset != null
                && isOffset) {
            printSpace();
            print(SQLReserved.OFFSET);

            printSpaceAfterAccept(offset);

            SQLRowType offSetRowType = x.getOffSetRowType();
            if (offSetRowType != null) {
                printSpace();
                print(offSetRowType.name);
            }
        }

        return false;
    }

    // ------------------ Select Details End ----------------------


    // ------------------ Table Details Start ----------------------
    @Override
    public boolean visit(SQLColumnDefinition x) {
        print(x.getName());
        printSpaceAfterAccept(x.getDataType());

        ISQLNullColumnConstraint nullOrNotNullColumnConstraint = x.findNullOrNotNullColumnConstraint();
        if (nullOrNotNullColumnConstraint != null) {
            printSpaceAfterAccept(nullOrNotNullColumnConstraint);
        }

        printSpaceAfterAccept(x.getReferenceScopeCheck());
        printSpaceAfterAccept(x.getDefaultExpr());
        printColumnConstraints(x.getColumnConstraints());
        printSpaceAfterAccept(x.getCollateClause());
        printSpaceAfterAccept(x.getCommentClause());
        return false;
    }

    @Override
    public void printColumnConstraints(List<ISQLColumnConstraint> columnConstraints) {
        for (ISQLColumnConstraint columnConstraint : columnConstraints) {
            if (columnConstraint instanceof ISQLNullColumnConstraint) {
                continue;
            }
            printSpaceAfterAccept(columnConstraint);
        }
    }

    // ------------------ Table Details End ----------------------

}
