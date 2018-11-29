package com.aliyun.gumiho.sql.basic.ast.element.pseudocolumn;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * COLUMN_VALUE
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/COLUMN_VALUE-Pseudocolumn.html#GUID-66AD602D-7207-4BDF-9CB0-E7418CCC81D3
 *
 * @author kongtong.ouyang on 2018/5/10.
 */
public class SQLColumnValueExpr extends AbstractSQLExpr implements SQLPseudoColumn {

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SQLColumnValueExpr clone() {
        return new SQLColumnValueExpr();
    }
}
