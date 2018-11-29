package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * Build <IMMEDIATE|DEFERRED>
 * build_clause
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-MATERIALIZED-VIEW.html#GUID-EE262CA4-01E5-4618-B659-6165D993CA1B
 *
 * @author kongtong.ouyang on 2018/6/21.
 */
public class SQLBuildClause extends AbstractSQLExpr {

    protected SQLBuildType type;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SQLBuildClause clone() {
        SQLBuildClause x = new SQLBuildClause();
        x.type = this.type;
        return x;
    }

    public SQLBuildType getType() {
        return type;
    }

    public void setType(SQLBuildType type) {
        this.type = type;
    }

    public enum SQLBuildType {
        IMMEDIATE(SQLReserved.IMMEDIATE),
        DEFERRED(SQLReserved.DEFERRED),;
        public final SQLReserved name;

        SQLBuildType(SQLReserved name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name.upper;
        }
    }
}
