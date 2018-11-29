package com.aliyun.gumiho.sql.basic.ast.element.pseudocolumn;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * XMLDATA
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/XMLDATA-Pseudocolumn.html#GUID-EBB52EE8-57B4-4DCA-A17E-351DE5CFA934
 *
 * @author kongtong.ouyang on 2018/5/10.
 */
public class SQLXmlDataExpr extends AbstractSQLExpr implements SQLPseudoColumn {

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SQLXmlDataExpr clone() {
        return new SQLXmlDataExpr();
    }
}
