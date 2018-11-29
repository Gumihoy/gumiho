package com.aliyun.gumiho.sql.basic.ast.element.expr.user;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * NO IDENTIFIED
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-ROLE.html#GUID-B2252DC5-5AE7-49B7-9048-98062993E450
 *
 * @author kongtong.ouyang on 2018/6/20.
 */
public class SQLNoIdentifiedClause extends AbstractSQLExpr {

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SQLNoIdentifiedClause clone() {
        return new SQLNoIdentifiedClause();
    }
}
