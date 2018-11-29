package com.aliyun.gumiho.sql.basic.ast.element.expr.settransaction;

/**
 * @author kongtong.ouyang on 2018/6/29.
 */

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * READ ONLY
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/SET-TRANSACTION.html#GUID-F11E1E30-5871-48D1-8266-F80A1DF126A1
 *
 * @author kongtong.ouyang on 2018/6/29.
 */
public class SQLSetTransactionReadOnlyOption extends AbstractSQLExpr implements SQLSetTransactionOption {

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SQLSetTransactionReadOnlyOption clone() {
        SQLSetTransactionReadOnlyOption x = new SQLSetTransactionReadOnlyOption();
        return x;
    }

}
