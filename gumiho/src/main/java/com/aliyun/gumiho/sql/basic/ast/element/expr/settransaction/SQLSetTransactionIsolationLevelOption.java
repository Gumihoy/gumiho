package com.aliyun.gumiho.sql.basic.ast.element.expr.settransaction;

/**
 * @author kongtong.ouyang on 2018/6/29.
 */

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.enums.ISQLEnum;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * ISOLATION LEVEL level
 * level:
 * REPEATABLE READ
 * | READ COMMITTED
 * | READ UNCOMMITTED
 * | SERIALIZABLE
 * https://dev.mysql.com/doc/refman/8.0/en/set-transaction.html
 * <p>
 * <p>
 * ISOLATION LEVEL { SERIALIZABLE | REPEATABLE READ | READ COMMITTED | READ UNCOMMITTED }
 * https://www.postgresql.org/docs/10/static/sql-set-transaction.html
 * <p>
 * <p>
 * ISOLATION LEVEL { SERIALIZABLE | READ COMMITTED }
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/SET-TRANSACTION.html#GUID-F11E1E30-5871-48D1-8266-F80A1DF126A1
 *
 * @author kongtong.ouyang on 2018/6/29.
 */
public class SQLSetTransactionIsolationLevelOption extends AbstractSQLExpr implements SQLSetTransactionOption {

    protected SQLLevel level;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SQLSetTransactionIsolationLevelOption clone() {
        SQLSetTransactionIsolationLevelOption x = new SQLSetTransactionIsolationLevelOption();
        x.level = this.level;
        return x;
    }

    public SQLLevel getLevel() {
        return level;
    }

    public void setLevel(SQLLevel level) {
        this.level = level;
    }

    public enum SQLLevel implements ISQLEnum {
        SERIALIZABLE(SQLReserved.SERIALIZABLE),
        REPEATABLE_READ(SQLReserved.REPEATABLE_READ),
        READ_COMMITTED(SQLReserved.READ_COMMITTED),
        READ_UNCOMMITTED(SQLReserved.READ_UNCOMMITTED);

        public final SQLReserved name;

        SQLLevel(SQLReserved name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name.upper;
        }


        @Override
        public SQLReserved getName() {
            return name;
        }
    }
}
