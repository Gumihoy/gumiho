package com.aliyun.gumiho.sql.basic.ast.element.expr.sequence;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.sequence.OracleSQLSequenceOption;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/sqlrf/CREATE-SEQUENCE.html#GUID-E9C78A8C-615A-4757-B2A8-5E6EFB130571
 *
 * @author kongtong.ouyang onCondition 2018/4/2.
 */
public class SQLSequenceGlobalOption extends AbstractSQLExpr implements OracleSQLSequenceOption {


    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SQLSequenceGlobalOption clone() {
        return new SQLSequenceGlobalOption();
    }
}
