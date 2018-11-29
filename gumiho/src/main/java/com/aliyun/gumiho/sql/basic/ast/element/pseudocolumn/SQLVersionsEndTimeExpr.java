package com.aliyun.gumiho.sql.basic.ast.element.pseudocolumn;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * VERSIONS_ENDTIME
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Version-Query-Pseudocolumns.html#GUID-F4DB0235-43A9-4AA2-8E9C-F2D9699D4AAD
 *
 * @author kongtong.ouyang on 2018/5/10.
 */
public class SQLVersionsEndTimeExpr extends AbstractSQLExpr implements SQLPseudoColumn {

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SQLVersionsEndTimeExpr clone() {
        return new SQLVersionsEndTimeExpr();
    }
}
