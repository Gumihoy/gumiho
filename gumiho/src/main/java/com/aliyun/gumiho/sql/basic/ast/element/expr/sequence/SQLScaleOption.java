package com.aliyun.gumiho.sql.basic.ast.element.expr.sequence;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.sequence.OracleSQLSequenceOption;

/**
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#sequence%20generator%20increment%20by%20option
 *
 * @author kongtong.ouyang onCondition 2018/4/2.
 */
public class SQLScaleOption extends AbstractSQLExpr implements OracleSQLSequenceOption {

    protected SQLScaleOptionType type;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SQLScaleOption clone() {
        SQLScaleOption x = new SQLScaleOption();
        this.cloneTo(x);

        x.type = this.type;

        return x;
    }


    public SQLScaleOptionType getType() {
        return type;
    }

    public void setType(SQLScaleOptionType type) {
        this.type = type;
    }

    public enum SQLScaleOptionType {
        EXTEND(SQLReserved.EXTEND),
        NOEXTEND(SQLReserved.NOEXTEND),;

        public final SQLReserved name;

        SQLScaleOptionType(SQLReserved name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name.upper;
        }
    }
}
