package com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.constraint.option;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * https://docs.oracle.com/cd/B28359_01/server.111/b28286/clauses002.htm#CJAFFBAA
 *
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/constraint.html#GUID-1055EA97-BA6F-4764-A15F-1024FD5B6DFE
 *
 * @author kongtong.ouyang on 2018/6/26.
 */
public class SQLRelyConstraintState extends AbstractSQLExpr implements ISQLConstraintOption {

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SQLDeferrableConstraintState clone() {
        return new SQLDeferrableConstraintState();
    }
}
