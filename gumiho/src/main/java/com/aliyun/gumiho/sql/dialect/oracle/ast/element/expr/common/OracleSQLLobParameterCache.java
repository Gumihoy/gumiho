package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common;

import com.aliyun.gumiho.sql.basic.ast.element.expr.ISQLLobParameter;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common.logging.IOracleSQLLoggingClause;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

/**
 * CACHE [logging_clause]
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-TABLE.html#GUID-F9CE0CC3-13AE-4744-A43C-EAC7A71AAAB6
 *
 * @author kongtong.ouyang on 2018/6/22.
 */
public class OracleSQLLobParameterCache extends AbstractOracleSQLExpr implements ISQLLobParameter {

    protected IOracleSQLLoggingClause loggingClause;


    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, loggingClause);
        }
    }

    @Override
    public OracleSQLLobParameterCache clone() {
        OracleSQLLobParameterCache x = new OracleSQLLobParameterCache();
        IOracleSQLLoggingClause loggingClauseClone = this.loggingClause.clone();
        x.setLoggingClause(loggingClauseClone);
        return x;
    }

    public IOracleSQLLoggingClause getLoggingClause() {
        return loggingClause;
    }

    public void setLoggingClause(IOracleSQLLoggingClause loggingClause) {
        setChildParent(loggingClause);
        this.loggingClause = loggingClause;
    }
}
