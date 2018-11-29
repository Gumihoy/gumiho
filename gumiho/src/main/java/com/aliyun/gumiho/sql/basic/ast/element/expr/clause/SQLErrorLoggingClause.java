package com.aliyun.gumiho.sql.basic.ast.element.expr.clause;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

/**
 * error_logging_clause
 * <p>
 * LOG ERRORS
 * [ INTO [schema.] table ]
 * [ (simple_expression) ]
 * [ REJECT LIMIT rejectLimit={ integer | UNLIMITED } ]
 * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/sqlrf/INSERT.html
 * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/sqlrf/MERGE.html
 *
 * @author kongtong.ouyang onCondition 2018/4/8.
 */
public class SQLErrorLoggingClause extends AbstractSQLExpr {

    protected SQLName into;

    protected SQLExpr expr;

    protected SQLExpr rejectLimit;


    @Override
    public void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, into);
            this.acceptChild(visitor, expr);
            this.acceptChild(visitor, rejectLimit);
        }
    }


    @Override
    public SQLErrorLoggingClause clone() {
        SQLErrorLoggingClause x = new SQLErrorLoggingClause();
        this.cloneTo(x);
        return x;
    }

    public void cloneTo(SQLErrorLoggingClause x) {
        super.cloneTo(x);
        SQLName intoClone = this.into.clone();
        x.setInto(intoClone);

        SQLExpr exprClone = this.expr.clone();
        x.setExpr(exprClone);

        SQLExpr rejectLimitClone = this.rejectLimit.clone();
        x.setRejectLimit(rejectLimitClone);
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == into
                && target instanceof SQLName) {
            setInto((SQLName)target);
            return true;
        }

        if (source == expr) {
            setExpr(target);
            return true;
        }

        if (source == rejectLimit) {
            setRejectLimit(target);
            return true;
        }

        return false;
    }

    public SQLName getInto() {
        return into;
    }

    public void setInto(SQLName into) {
        setChildParent(into);
        this.into = into;
    }

    public SQLExpr getExpr() {
        return expr;
    }

    public void setExpr(SQLExpr expr) {
        setChildParent(expr);
        this.expr = expr;
    }

    public SQLExpr getRejectLimit() {
        return rejectLimit;
    }

    public void setRejectLimit(SQLExpr rejectLimit) {
        setChildParent(rejectLimit);
        this.rejectLimit = rejectLimit;
    }
}
