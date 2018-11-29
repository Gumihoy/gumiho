package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common;

import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

/**
 *
 *  PIPELINED TABLE POLYMORPHIC USING ["schema" "."] "implementation_package" )
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/PIPELINED-clause.html#GUID-FA182210-C68D-4E03-85B9-A6C681099705
 *
 * @author kongtong.ouyang on 2018/6/1.
 */
public class OracleSQLPipelinedByTableClause extends AbstractOracleSQLExpr implements IOracleSQLPipelinedClause {

    protected SQLName using;

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, using);
        }
    }

    @Override
    public OracleSQLPipelinedByTableClause clone() {
        OracleSQLPipelinedByTableClause x = new OracleSQLPipelinedByTableClause();

        SQLName usingClone = this.using.clone();
        x.setUsing(usingClone);
        return x;
    }

    public SQLName getUsing() {
        return using;
    }

    public void setUsing(SQLName using) {
        setChildParent(using);
        this.using = using;
    }
}
