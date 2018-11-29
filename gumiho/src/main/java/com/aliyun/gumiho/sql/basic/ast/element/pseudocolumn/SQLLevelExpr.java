package com.aliyun.gumiho.sql.basic.ast.element.pseudocolumn;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * LEVEL
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Hierarchical-Query-Pseudocolumns.html#GUID-2F2FBA6F-2FD1-47D6-A74F-DB4B31E4D400
 *
 * @author kongtong.ouyang on 2018/5/16.
 */
public class SQLLevelExpr extends AbstractSQLExpr implements SQLPseudoColumn {

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SQLLevelExpr clone() {
        return new SQLLevelExpr();
    }
}
