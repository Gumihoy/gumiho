package com.aliyun.gumiho.sql.basic.ast.element.expr.sequence;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.sequence.OracleSQLSequenceOption;
import com.aliyun.gumiho.sql.dialect.postgresql.ast.element.expr.sequence.PostgreSQLSQLSequenceOption;
import com.aliyun.gumiho.sql.dialect.ppas.ast.element.expr.sequence.PPASSQLSequenceOption;

/**
 * NO CYCLE
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#sequence%20generator%20cycle%20option
 * <p>
 * NOCYCLE
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-SEQUENCE.html#GUID-E9C78A8C-615A-4757-B2A8-5E6EFB130571
 *
 * @author kongtong.ouyang onCondition 2018/4/2.
 */
public class SQLSequenceNoCycleOption extends AbstractSQLExpr implements OracleSQLSequenceOption, PPASSQLSequenceOption, PostgreSQLSQLSequenceOption {


    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SQLSequenceNoCycleOption clone() {
        return new SQLSequenceNoCycleOption();
    }
}
