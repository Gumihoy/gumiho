package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.ast.enums.SQLWithType;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * ON PREBUILT TABLE [ { WITH | WITHOUT } REDUCED PRECISION ]
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-MATERIALIZED-VIEW.html#GUID-EE262CA4-01E5-4618-B659-6165D993CA1B
 *
 * @author kongtong.ouyang on 2018/6/23.
 */
public class SQLOnPrebuiltTableProperty extends AbstractSQLExpr {

    protected SQLWithType reducedPrecisionAction;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SQLOnPrebuiltTableProperty clone() {
        SQLOnPrebuiltTableProperty x = new SQLOnPrebuiltTableProperty();
        this.cloneTo(x);

        x.reducedPrecisionAction = this.reducedPrecisionAction;

        return x;
    }

    public SQLWithType getReducedPrecisionAction() {
        return reducedPrecisionAction;
    }

    public void setReducedPrecisionAction(SQLWithType reducedPrecisionAction) {
        this.reducedPrecisionAction = reducedPrecisionAction;
    }
}

