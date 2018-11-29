package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common;

import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

/**
 * ILM { ADD POLICY ilm_policy_clause | { DELETE | ENABLE | DISABLE } POLICY ilm_policy_name | DELETE_ALL | ENABLE_ALL | DISABLE_ALL }
 * <p>
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-TABLE.html#GUID-F9CE0CC3-13AE-4744-A43C-EAC7A71AAAB6
 *
 * @author kongtong.ouyang on 2018/6/25.
 */
public class OracleSQLIlmClauseAddPolicyOption extends AbstractOracleSQLExpr implements IOracleSQLIlmClause {

    protected OracleSQLIlmPolicyClause  ilmPolicyClause;

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, ilmPolicyClause);
        }
    }

    @Override
    public OracleSQLIlmClauseAddPolicyOption clone() {
        OracleSQLIlmClauseAddPolicyOption x = new OracleSQLIlmClauseAddPolicyOption();
        this.cloneTo(x);

        OracleSQLIlmPolicyClause  ilmPolicyClauseClone = this.ilmPolicyClause.clone();
        x.setIlmPolicyClause(ilmPolicyClauseClone);
        return x;
    }

    public OracleSQLIlmPolicyClause getIlmPolicyClause() {
        return ilmPolicyClause;
    }

    public void setIlmPolicyClause(OracleSQLIlmPolicyClause ilmPolicyClause) {
        setChildParent(ilmPolicyClause);
        this.ilmPolicyClause = ilmPolicyClause;
    }
}
