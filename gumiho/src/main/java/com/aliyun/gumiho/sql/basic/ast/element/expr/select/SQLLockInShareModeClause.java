package com.aliyun.gumiho.sql.basic.ast.element.expr.select;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * LOCK IN SHARE MODE
 * https://dev.mysql.com/doc/refman/8.0/en/select.html
 *
 * @author kongtong.ouyang on 2018/7/24.
 */
public class SQLLockInShareModeClause extends AbstractSQLExpr implements ISQLLockClause {
    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SQLLockInShareModeClause clone() {
        return new SQLLockInShareModeClause();
    }
}
