package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.select;

import com.aliyun.gumiho.sql.basic.ast.element.expr.select.AbstractSQLTableReference;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLIdentifier;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

/**
 * ANALYTIC VIEW (sub_av_clause) [[AS] inline_av_alias]
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/SELECT.html#GUID-CFA006CA-6FF1-4972-821E-6996142A51C6
 *
 * @author kongtong.ouyang on 2018/5/10.
 */
public class OracleSQLInlineAnalyticViewTableReference extends AbstractSQLTableReference implements IOracleSQLTableReference {

    protected OracleSQLSubAvClause subAvClause;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor instanceof OracleSQLASTVisitor) {
            this.accept0((OracleSQLASTVisitor) visitor);
        } else {
            throw new UnsupportedOperationException(getClass().getName());
        }
    }

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, subAvClause);
            this.acceptChild(visitor, alias);
        }
    }

    @Override
    public OracleSQLInlineAnalyticViewTableReference clone() {
        OracleSQLInlineAnalyticViewTableReference x = new OracleSQLInlineAnalyticViewTableReference();
        return x;
    }

    public OracleSQLSubAvClause getSubAvClause() {
        return subAvClause;
    }

    public void setSubAvClause(OracleSQLSubAvClause subAvClause) {
        setChildParent(subAvClause);
        this.subAvClause = subAvClause;
    }

    public boolean isAs() {
        return as;
    }

    public void setAs(boolean as) {
        this.as = as;
    }

    public SQLIdentifier getAlias() {
        return alias;
    }

    public void setAlias(SQLIdentifier alias) {
        this.alias = alias;
    }
}
