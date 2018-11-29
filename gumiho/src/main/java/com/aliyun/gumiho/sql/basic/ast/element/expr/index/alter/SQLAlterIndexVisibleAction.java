package com.aliyun.gumiho.sql.basic.ast.element.expr.index.alter;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * VISIBLE
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-INDEX.html#GUID-D8F648E7-8C07-4C89-BB71-862512536558
 *
 * @author kongtong.ouyang on 2018/7/9.
 */
public class SQLAlterIndexVisibleAction extends AbstractSQLExpr implements ISQLAlterIndexAction {

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SQLAlterIndexVisibleAction clone() {
        return new SQLAlterIndexVisibleAction();
    }
}
