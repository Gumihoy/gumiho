package com.aliyun.gumiho.sql.basic.ast.element.expr.index.attribute;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * ONLINE
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-INDEX.html#GUID-1F89BBC0-825F-4215-AF71-7588E31D8BFE
 *
 * @author kongtong.ouyang on 2018/7/9.
 */
public class SQLIndexAttributeOnline extends AbstractSQLExpr implements ISQLIndexAttribute {

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SQLIndexAttributeOnline clone() {
        return new SQLIndexAttributeOnline();
    }
}
