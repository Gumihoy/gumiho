package com.aliyun.gumiho.sql.basic.ast.element.expr.table;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLEnableType;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * { ENABLE | DISABLE } ROW MOVEMENT
 *
 * row_movement_clause
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-TABLE.html#GUID-F9CE0CC3-13AE-4744-A43C-EAC7A71AAAB6
 * @author kongtong.ouyang on 2018/7/10.
 */
public class SQLRowMovementClause extends AbstractSQLExpr {

    protected SQLEnableType enable;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SQLRowMovementClause clone() {
        SQLRowMovementClause x = new SQLRowMovementClause();
        x.enable = this.enable;
        return x;
    }

    public SQLEnableType getEnable() {
        return enable;
    }

    public void setEnable(SQLEnableType enable) {
        this.enable = enable;
    }
}
