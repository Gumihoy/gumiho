package com.aliyun.gumiho.sql.basic.ast.element.expr.commit;

/**
 * @author kongtong.ouyang on 2018/6/29.
 */

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.SQLWithClause;
import com.aliyun.gumiho.sql.basic.ast.enums.ISQLEnum;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLWaitType;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * WRITE [WAIT | NOWAIT] [IMMEDIATE | BATCH]
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/COMMIT.html#GUID-6CD5C9A7-54B9-4FA2-BA3C-D6B4492B9EE2
 *
 * @author kongtong.ouyang on 2018/6/29.
 */
public class SQLCommitWriteOption extends AbstractSQLExpr implements SQLCommitOption {

    protected SQLWaitType wait;
    protected SQLImmediateType immediate;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SQLCommitWriteOption clone() {
        SQLCommitWriteOption x = new SQLCommitWriteOption();
        x.wait = this.wait;
        x.immediate = this.immediate;
        return x;
    }


    public SQLWaitType getWait() {
        return wait;
    }

    public void setWait(SQLWaitType wait) {
        this.wait = wait;
    }

    public SQLImmediateType getImmediate() {
        return immediate;
    }

    public void setImmediate(SQLImmediateType immediate) {
        this.immediate = immediate;
    }



    public enum SQLImmediateType implements ISQLEnum {
        IMMEDIATE(SQLReserved.IMMEDIATE),
        BATCH(SQLReserved.BATCH),;

        public final SQLReserved name;

        SQLImmediateType(SQLReserved name) {
            this.name = name;
        }


        @Override
        public SQLReserved getName() {
            return name;
        }
    }
}
