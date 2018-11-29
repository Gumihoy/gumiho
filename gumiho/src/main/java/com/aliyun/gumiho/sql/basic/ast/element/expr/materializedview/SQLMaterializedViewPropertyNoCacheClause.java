package com.aliyun.gumiho.sql.basic.ast.element.expr.materializedview;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * NOCACHE
 * <p>
 * materialized_view_props
 * https://docs.oracle.com/cd/B28359_01/server.111/b28286/statements_6002.htm#i2116410
 *
 * @author kongtong.ouyang on 2018/6/28.
 */
public class SQLMaterializedViewPropertyNoCacheClause extends AbstractSQLExpr {

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SQLMaterializedViewPropertyNoCacheClause clone() {
        return new SQLMaterializedViewPropertyNoCacheClause();
    }
}
