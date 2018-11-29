package com.aliyun.gumiho.sql.basic.ast.element.expr.sequence;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.literal.numeric.SQLIntegerLiteral;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.sequence.OracleSQLSequenceOption;
import com.aliyun.gumiho.sql.dialect.postgresql.ast.element.expr.sequence.PostgreSQLSQLSequenceOption;
import com.aliyun.gumiho.sql.dialect.ppas.ast.element.expr.sequence.PPASSQLSequenceOption;

/**
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#sequence%20generator%20cycle%20option
 *
 * @author kongtong.ouyang onCondition 2018/4/2.
 */
public class SQLSequenceCacheOption extends AbstractSQLExpr implements OracleSQLSequenceOption, PPASSQLSequenceOption, PostgreSQLSQLSequenceOption {

    protected SQLIntegerLiteral cache;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, cache);
        }
    }

    @Override
    public SQLSequenceCacheOption clone() {
        SQLSequenceCacheOption x = new SQLSequenceCacheOption();
        SQLIntegerLiteral cloneCache = this.cache.clone();
        x.setCache(cloneCache);

        return x;
    }

    public SQLIntegerLiteral getCache() {
        return cache;
    }

    public void setCache(SQLIntegerLiteral cache) {
        this.cache = cache;
    }
}
