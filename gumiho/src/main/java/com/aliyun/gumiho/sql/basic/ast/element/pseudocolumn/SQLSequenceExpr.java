package com.aliyun.gumiho.sql.basic.ast.element.pseudocolumn;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * sequence. { CURRVAL | NEXTVAL }
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Simple-Expressions.html#GUID-0E033897-60FB-40D7-A5F3-498B0FCC31B0
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Sequence-Pseudocolumns.html#GUID-693B576A-191D-45F5-B7CB-88D0EA821B44
 *
 * @author kongtong.ouyang on 2018/5/16.
 */
public class SQLSequenceExpr extends AbstractSQLExpr implements SQLPseudoColumn {

    protected SQLName sequence;
    protected SQLSequenceFunction name;


    public SQLSequenceExpr(SQLName sequence, SQLSequenceFunction name) {
        setSequence(sequence);
        this.name = name;
    }

    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, sequence);
        }
    }

    @Override
    public SQLSequenceExpr clone() {

        SQLName sequenceName = this.sequence.clone();

        SQLSequenceExpr x = new SQLSequenceExpr(sequenceName, this.name);

        return x;
    }

    public SQLName getSequence() {
        return sequence;
    }

    public void setSequence(SQLName sequence) {
        setChildParent(sequence);
        this.sequence = sequence;
    }

    public SQLSequenceFunction getName() {
        return name;
    }

    public void setName(SQLSequenceFunction name) {
        this.name = name;
    }


    public enum SQLSequenceFunction {

        CURRVAL(SQLReserved.CURRVAL),
        NEXTVAL(SQLReserved.NEXTVAL),;

        public final SQLReserved name;

        SQLSequenceFunction(SQLReserved name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name.upper;
        }
    }
}
