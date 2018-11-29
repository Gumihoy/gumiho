package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common;

import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

/**
 * ORGANIZATION EXTERNAL external_table_clause
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-MATERIALIZED-VIEW.html#GUID-EE262CA4-01E5-4618-B659-6165D993CA1B
 *
 * @author kongtong.ouyang on 2018/6/22.
 */
public class OracleSQLPhysicalPropertyOrganizationExternalClause extends AbstractOracleSQLExpr implements IOracleSQLPhysicalPropertyOrganizationClause {

    protected OracleSQLExternalTableClause externalTableClause;


    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, externalTableClause);
        }
    }

    @Override
    public OracleSQLPhysicalPropertyOrganizationExternalClause clone() {
        OracleSQLPhysicalPropertyOrganizationExternalClause x = new OracleSQLPhysicalPropertyOrganizationExternalClause();
        return x;
    }


    public OracleSQLExternalTableClause getExternalTableClause() {
        return externalTableClause;
    }

    public void setExternalTableClause(OracleSQLExternalTableClause externalTableClause) {
        setChildParent(externalTableClause);
        this.externalTableClause = externalTableClause;
    }
}
