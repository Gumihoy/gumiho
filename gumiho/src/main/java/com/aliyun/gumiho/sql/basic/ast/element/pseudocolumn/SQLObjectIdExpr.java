package com.aliyun.gumiho.sql.basic.ast.element.pseudocolumn;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * OBJECT_ID
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/OBJECT_ID-Pseudocolumn.html#GUID-EA125CCC-B4EE-4065-996E-12A1ADCC5F7F
 *
 * @author kongtong.ouyang on 2018/5/10.
 */
public class SQLObjectIdExpr extends AbstractSQLExpr implements SQLPseudoColumn {

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SQLObjectIdExpr clone() {
        return new SQLObjectIdExpr();
    }
}
