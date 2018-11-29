package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common;

import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
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
public class OracleSQLIlmClauseEnablePolicyOption extends AbstractOracleSQLExpr implements IOracleSQLIlmClause {

    protected SQLName name;

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
        }
    }

    @Override
    public OracleSQLIlmClauseEnablePolicyOption clone() {
        OracleSQLIlmClauseEnablePolicyOption x = new OracleSQLIlmClauseEnablePolicyOption();
        this.cloneTo(x);
        return x;
    }

    public SQLName getName() {
        return name;
    }

    public void setName(SQLName name) {
        setChildParent(name);
        this.name = name;
    }
}
