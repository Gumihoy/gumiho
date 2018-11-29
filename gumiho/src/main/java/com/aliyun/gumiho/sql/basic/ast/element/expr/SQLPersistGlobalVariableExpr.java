package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.ast.enums.ISQLEnum;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * GLOBAL VARIABLE ： @@persist.variableName / PERSIST variableName
 * <p>
 * https://dev.mysql.com/doc/refman/8.0/en/user-variables.html
 *
 * @author kongtong.ouyang on 2018/7/25.
 */
public class SQLPersistGlobalVariableExpr extends AbstractSQLVariable {

    protected SQLPrefix prefix = SQLPrefix.AT_SIGN_AT_SIGN_PERSIST;

    public SQLPersistGlobalVariableExpr() {
    }

    public SQLPersistGlobalVariableExpr(String name) {
        setName(name);
    }

    public SQLPersistGlobalVariableExpr(SQLPrefix prefix, String name) {
        this.prefix = prefix;
        setName(name);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SQLPersistGlobalVariableExpr clone() {
        SQLPersistGlobalVariableExpr x = new SQLPersistGlobalVariableExpr();
        this.cloneTo(x);
        x.prefix = this.prefix;
        return x;
    }

    public SQLPrefix getPrefix() {
        return prefix;
    }

    public void setPrefix(SQLPrefix prefix) {
        this.prefix = prefix;
    }

    @Override
    public String notation() {
        if (notation == null) {
            notation = prefix.name.upper;
            if (prefix == SQLPrefix.AT_SIGN_AT_SIGN_PERSIST) {
                notation += SQLReserved.PERIOD;
            } else {
                notation += SQLReserved.SPACE;
            }
            notation += name.getName();
        }
        return notation;
    }


    public enum SQLPrefix implements ISQLEnum {

        PERSIST(SQLReserved.PERSIST),
        AT_SIGN_AT_SIGN_PERSIST(SQLReserved.AT_SIGN_AT_SIGN_PERSIST),;

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
