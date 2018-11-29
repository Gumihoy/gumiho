package com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.constraint.column;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.enums.ISQLEnum;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * COLUMN_FORMAT {FIXED|DYNAMIC|DEFAULT}
 * https://dev.mysql.com/doc/refman/5.6/en/create-table.html
 *
 * @author kongtong.ouyang on 2018/7/31.
 */
public class SQLFormatColumnConstraint extends AbstractSQLExpr implements ISQLColumnConstraint {

    protected FormatType formatType;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SQLFormatColumnConstraint clone() {
        SQLFormatColumnConstraint x = new SQLFormatColumnConstraint();
        x.formatType = this.formatType;
        return x;
    }

    public FormatType getFormatType() {
        return formatType;
    }

    public void setFormatType(FormatType formatType) {
        this.formatType = formatType;
    }

    /**
     * FIXED|DYNAMIC|DEFAULT
     */
    public enum FormatType implements ISQLEnum {
        FIXED(SQLReserved.FIXED),
        DYNAMIC(SQLReserved.DYNAMIC),
        DEFAULT(SQLReserved.DEFAULT);

        public final SQLReserved name;

        FormatType(SQLReserved name) {
            this.name = name;
        }

        @Override
        public SQLReserved getName() {
            return name;
        }

        @Override
        public String toString() {
            return name.upper;
        }
    }
}
