package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.ast.enums.ISQLEnum;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * GLOBAL VARIABLE ： @@persist_only.variableName / PERSIST_ONLY variableName
 * <p>
 * https://dev.mysql.com/doc/refman/8.0/en/user-variables.html
 *
 * @author kongtong.ouyang on 2018/7/25.
 */
public class SQLPersistOnlyGlobalVariableExpr extends AbstractSQLVariable {

    protected SQLPrefix prefix = SQLPrefix.AT_SIGN_AT_SIGN_PERSIST_ONLY;

    public SQLPersistOnlyGlobalVariableExpr() {
    }

    public SQLPersistOnlyGlobalVariableExpr(String name) {
        setName(name);
    }

    public SQLPersistOnlyGlobalVariableExpr(SQLPrefix prefix, String name) {
        this.prefix = prefix;
        setName(name);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SQLPersistOnlyGlobalVariableExpr clone() {
        SQLPersistOnlyGlobalVariableExpr x = new SQLPersistOnlyGlobalVariableExpr();
        this.cloneTo(x);
        x.prefix = this.prefix;
        return x;
    }


    @Override
    public String notation() {
        if (notation == null) {
            notation = prefix.name.upper;
            if (prefix == SQLPrefix.AT_SIGN_AT_SIGN_PERSIST_ONLY) {
                notation += SQLReserved.PERIOD;
            } else {
                notation += SQLReserved.SPACE;
            }
            notation += name.getName();
        }
        return notation;
    }

    public SQLPrefix getPrefix() {
        return prefix;
    }

    public void setPrefix(SQLPrefix prefix) {
        this.prefix = prefix;
    }




    public enum SQLPrefix implements ISQLEnum {

        PERSIST_ONLY(SQLReserved.PERSIST_ONLY),
        AT_SIGN_AT_SIGN_PERSIST_ONLY(SQLReserved.AT_SIGN_AT_SIGN_PERSIST_ONLY),;

        public final SQLReserved name;

        SQLPrefix(SQLReserved name) {
            this.name = name;
        }

        @Override
        public SQLReserved getName() {
            return name;
        }

        @Override
        public String toString() {
            return name.upper;
        }
    }

}
