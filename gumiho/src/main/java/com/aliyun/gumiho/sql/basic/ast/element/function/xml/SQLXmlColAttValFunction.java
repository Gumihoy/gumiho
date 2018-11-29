package com.aliyun.gumiho.sql.basic.ast.element.function.xml;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.function.AbstractSQLFunction;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * XMLCOLATTVAL (value_expr [ AS { c_alias  | EVALNAME value_expr } ] [, value_expr [ AS { c_alias  | EVALNAME value_expr } ] ]...)
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/XMLCOLATTVAL.html#GUID-AE3B6441-74D8-4033-900B-A578A79E5F0A
 *
 * @author kongtong.ouyang on 2018/5/24.
 */
public class SQLXmlColAttValFunction extends AbstractSQLFunction {

    public SQLXmlColAttValFunction() {
        super(SQLReserved.XMLCOLATTVAL.ofExpr());
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, arguments);
        }
    }

    /**
     * value_expr AS EVALNAME value_expr
     */
    public static class SQLArgumentExpr extends AbstractSQLExpr {
        protected SQLExpr expr;
        protected SQLExpr alias;

        public SQLArgumentExpr(SQLExpr expr, SQLExpr alias) {
            setExpr(expr);
            setAlias(alias);
        }

        @Override
        protected void accept0(SQLASTVisitor visitor) {
//            if (visitor.visit(this)) {
//                this.acceptChild(visitor, expr);
//                this.acceptChild(visitor, alias);
//            }
        }

        public SQLExpr getExpr() {
            return expr;
        }

        public void setExpr(SQLExpr expr) {
            setChildParent(expr);
            this.expr = expr;
        }

        public SQLExpr getAlias() {
            return alias;
        }

        public void setAlias(SQLExpr alias) {
            setChildParent(alias);
            this.alias = alias;
        }
    }
}
