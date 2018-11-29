package com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.enums.ISQLEnum;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * {WITHOUT|WITH} VALIDATION
 * https://dev.mysql.com/doc/refman/8.0/en/alter-table.html
 *
 * @author kongtong.ouyang on 2018/6/4.
 */
public class SQLAlterTableWithValidationAction extends AbstractSQLExpr implements ISQLAlterTableAction {

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
        }
    }

    @Override
    public SQLAlterTableWithValidationAction clone() {
        SQLAlterTableWithValidationAction x = new SQLAlterTableWithValidationAction();
        return x;
    }

}
