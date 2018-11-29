package com.aliyun.gumiho.sql.basic.ast.element.pseudocolumn;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * ORA_ROWSCN
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ORA_ROWSCN-Pseudocolumn.html#GUID-8071AAB0-F656-4C93-B926-0BCE1439F121
 *
 * @author kongtong.ouyang on 2018/9/11.
 */
public class SQLOraRowScnExpr extends AbstractSQLExpr implements SQLPseudoColumn {

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SQLOraRowScnExpr clone() {
        return new SQLOraRowScnExpr();
    }


}
