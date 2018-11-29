package com.aliyun.gumiho.sql.basic.ast.element.expr.materializedview;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * USING INDEX   [physical_attributes_clause| TABLESPACE tablespace]...
 * |
 * USING NO INDEX
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-MATERIALIZED-VIEW.html#GUID-EE262CA4-01E5-4618-B659-6165D993CA1B
 *
 * @author kongtong.ouyang on 2018/6/23.
 */
public class SQLUsingNoIndexClause extends AbstractSQLExpr implements ISQLUsingIndexClause {

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SQLUsingNoIndexClause clone() {
        SQLUsingNoIndexClause x = new SQLUsingNoIndexClause();
        return x;
    }

}
