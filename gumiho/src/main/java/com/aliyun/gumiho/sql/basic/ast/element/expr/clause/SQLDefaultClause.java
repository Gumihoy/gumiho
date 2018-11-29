package com.aliyun.gumiho.sql.basic.ast.element.expr.clause;

import static com.aliyun.gumiho.sql.basic.ast.element.expr.clause.SQLDefaultClause.OpType.DEFAULT;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * DEFAULT expr
 * :=   expr
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#default%20clause
 *
 * DEFAULT default_value
 * https://dev.mysql.com/doc/refman/5.6/en/create-table.html
 *
 * DEFAULT expr
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-TABLE.html#GUID-F9CE0CC3-13AE-4744-A43C-EAC7A71AAAB6
 *
 * @author kongtong.ouyang onCondition 2018/4/4.
 */
public class SQLDefaultClause extends AbstractSQLExpr {

    protected OpType op = DEFAULT;

    protected SQLExpr expr;

    public SQLDefaultClause() {
    }

    public SQLDefaultClause(SQLExpr expr) {
        setExpr(expr);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, expr);
        }
    }

    @Override
    public SQLDefaultClause clone() {
        SQLDefaultClause x = new SQLDefaultClause();
        x.op = this.op;

        SQLExpr exprClone = this.expr.clone();
        x.setExpr(exprClone);

        return x;
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == expr) {
            this.setExpr(target);
            return true;
        }
        return false;
    }

    public OpType getOp() {
        return op;
    }

    public void setOp(OpType op) {
        this.op = op;
    }

    public SQLExpr getExpr() {
        return expr;
    }

    public void setExpr(SQLExpr expr) {
        setChildParent(expr);
        this.expr = expr;
    }

    public enum OpType {
        DEFAULT(SQLReserved.DEFAULT),
        VAR_ASSIGN_OP(SQLReserved.VAR_ASSIGN_OP);

        public final SQLReserved name;

        OpType(SQLReserved name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name.upper;
        }
    }

}
