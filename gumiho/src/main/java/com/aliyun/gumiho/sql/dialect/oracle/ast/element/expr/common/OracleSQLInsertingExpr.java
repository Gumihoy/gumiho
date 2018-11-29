package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common;

import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

/**
 * INSERTING
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/expression.html#GUID-D4700B45-F2C8-443E-AEE7-2BD20FFD45B8
 *
 * @author kongtong.ouyang on 2018/4/25.
 */
public class OracleSQLInsertingExpr extends AbstractOracleSQLExpr implements OracleSQLConditionalPredicate {

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
//        visitor.visit(this);
    }

    @Override
    public OracleSQLInsertingExpr clone() {
        OracleSQLInsertingExpr x = new OracleSQLInsertingExpr();
        return x;
    }
}
