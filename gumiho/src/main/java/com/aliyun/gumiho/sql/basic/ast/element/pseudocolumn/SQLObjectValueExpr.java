package com.aliyun.gumiho.sql.basic.ast.element.pseudocolumn;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * OBJECT_VALUE
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/OBJECT_VALUE-Pseudocolumn.html#GUID-456B90CD-30DE-4973-98E0-E4B531938E6E
 *
 * @author kongtong.ouyang on 2018/5/10.
 */
public class SQLObjectValueExpr extends AbstractSQLExpr implements SQLPseudoColumn {

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SQLObjectValueExpr clone() {
        return new SQLObjectValueExpr();
    }
}
