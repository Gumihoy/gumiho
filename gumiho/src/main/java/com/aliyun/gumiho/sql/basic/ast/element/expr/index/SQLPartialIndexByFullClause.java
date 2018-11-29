package com.aliyun.gumiho.sql.basic.ast.element.expr.index;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * INDEXING { PARTIAL | FULL }
 * <p>
 * partial_index_clause
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-INDEX.html#GUID-1F89BBC0-825F-4215-AF71-7588E31D8BFE
 *
 * @author kongtong.ouyang on 2018/7/9.
 */
public class SQLPartialIndexByFullClause extends AbstractSQLExpr implements ISQLPartialIndexClause {
    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SQLPartialIndexByFullClause clone() {
        return new SQLPartialIndexByFullClause();
    }
}
