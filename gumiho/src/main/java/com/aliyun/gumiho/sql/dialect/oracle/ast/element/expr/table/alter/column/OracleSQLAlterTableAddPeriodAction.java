package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.table.alter.column;

import com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.ISQLAlterTableAction;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.table.element.OracleSQLPeriodDefinition;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

/**
 * ADD ( period_definition )
 * <p>
 * add_period_clause
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-TABLE.html#GUID-552E7373-BF93-477D-9DA3-B2C9386F2877
 *
 * @author kongtong.ouyang on 2018/7/14.
 */
public class OracleSQLAlterTableAddPeriodAction extends AbstractOracleSQLExpr implements ISQLAlterTableAction {

    protected OracleSQLPeriodDefinition periodDefinition;

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, periodDefinition);
        }
    }

    @Override
    public OracleSQLAlterTableAddPeriodAction clone() {
        OracleSQLAlterTableAddPeriodAction x = new OracleSQLAlterTableAddPeriodAction();
        return x;
    }

    public OracleSQLPeriodDefinition getPeriodDefinition() {
        return periodDefinition;
    }

    public void setPeriodDefinition(OracleSQLPeriodDefinition periodDefinition) {
        setChildParent(periodDefinition);
        this.periodDefinition = periodDefinition;
    }
}
