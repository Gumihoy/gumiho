package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.ast.element.expr.clause.SQLWhereClause;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * INCLUDING ROWS where_clause
 * <p>
 * filter_condition
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-TABLE.html#GUID-552E7373-BF93-477D-9DA3-B2C9386F2877
 *
 * @author kongtong.ouyang on 2018/7/16.
 */
public class SQLFilterCondition extends AbstractSQLExpr {

    protected SQLWhereClause whereClause;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, whereClause);
        }
    }

    @Override
    public SQLExpr clone() {
        return super.clone();
    }

    public SQLWhereClause getWhereClause() {
        return whereClause;
    }

    public void setWhereClause(SQLWhereClause whereClause) {
        setChildParent(whereClause);
        this.whereClause = whereClause;
    }
}
