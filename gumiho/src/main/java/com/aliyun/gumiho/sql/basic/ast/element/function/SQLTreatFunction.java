package com.aliyun.gumiho.sql.basic.ast.element.function;

import com.aliyun.gumiho.sql.basic.ast.element.datatype.SQLDataType;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * TREAT(expr AS ([ REF ] [ schema. ]type | JSON)
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/TREAT.html#GUID-037C0CD3-C256-4A02-80E0-C6F15147C5BF
 *
 * @author kongtong.ouyang on 2018/5/21.
 */
public class SQLTreatFunction extends AbstractSQLFunction {

    protected boolean ref;

    protected SQLDataType dataType;

    public SQLTreatFunction() {
        super(SQLReserved.TREAT.ofExpr());
    }

    public SQLTreatFunction(SQLExpr argument, boolean ref, SQLDataType dataType) {
        super(SQLReserved.TREAT.ofExpr());
        this.addArgument(argument);
        this.ref = ref;
        setDataType(dataType);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, arguments);
            this.acceptChild(visitor, dataType);
        }
    }


    public boolean isRef() {
        return ref;
    }

    public void setRef(boolean ref) {
        this.ref = ref;
    }

    public SQLDataType getDataType() {
        return dataType;
    }

    public void setDataType(SQLDataType dataType) {
        setChildParent(dataType);
        this.dataType = dataType;
    }
}
