package com.aliyun.gumiho.sql.basic.ast.element.datatype.datetime;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.literal.numeric.SQLIntegerLiteral;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#datetime%20type
 * <p>
 * DATETIME[(fsp)]
 * https://dev.mysql.com/doc/refman/5.7/en/date-and-time-type-overview.html
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/sqlrf/Data-Types.html#GUID-A3C0D836-BADB-44E5-A5D4-265BA5968483
 *
 * @author kongtong.ouyang on 2018/4/19.
 */
public class SQLDateTimeDataType extends AbstractSQLDateTimeDataType implements ISQLDateTimeDataType {

    public SQLDateTimeDataType() {
        super(SQLReserved.DATETIME.ofExpr());
    }

    public SQLDateTimeDataType(int len) {
        super(SQLReserved.DATETIME.ofExpr());
        this.addArgument(SQLIntegerLiteral.of(len));
    }

    public SQLDateTimeDataType(SQLExpr arg) {
        super(SQLReserved.DATETIME.ofExpr(), arg);
    }

    public static SQLDateTimeDataType of(int len) {
        return new SQLDateTimeDataType(len);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

}
