package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common;

import com.aliyun.gumiho.sql.basic.ast.element.expr.ISQLLobParameter;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.enums.ISQLEnum;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

/**
 * RETENTION [ MAX | MIN integer | AUTO | NONE ]
 *
 * LOB_retention_clause
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-TABLE.html#GUID-F9CE0CC3-13AE-4744-A43C-EAC7A71AAAB6
 *
 * @author kongtong.ouyang on 2018/6/25.
 */
public class OracleSQLLobRetentionClause extends AbstractOracleSQLExpr implements ISQLLobParameter {

    protected OptionType optionType;
    protected SQLExpr value;

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, value);
        }
    }

    @Override
    public OracleSQLLobRetentionClause clone() {
        OracleSQLLobRetentionClause x = new OracleSQLLobRetentionClause();
        this.cloneTo(x);

        x.optionType = this.optionType;

        if (this.value != null) {
            SQLExpr valueClone = this.value.clone();
            x.setValue(valueClone);
        }
        return x;
    }

    public OptionType getOptionType() {
        return optionType;
    }

    public void setOptionType(OptionType optionType) {
        this.optionType = optionType;
    }

    public SQLExpr getValue() {
        return value;
    }

    public void setValue(SQLExpr value) {
        setChildParent(value);
        this.value = value;
    }

    public enum OptionType implements ISQLEnum {
        MAX(SQLReserved.MAX),
        MIN(SQLReserved.MIN),
        AUTO(SQLReserved.AUTO),
        NONE(SQLReserved.NONE),;
        public final SQLReserved name;

        OptionType(SQLReserved name) {
            this.name = name;
        }


        @Override
        public SQLReserved getName() {
            return name;
        }
    }
}
