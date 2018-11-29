package com.aliyun.gumiho.sql.basic.ast.element.expr.table.element;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.enums.ISQLEnum;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Like tableName [option ...]
 * <p>
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#like%20clause
 *
 * @author kongtong.ouyang on 2018/7/6.
 */
public class SQLLikeClause extends AbstractSQLExpr implements SQLTableElement {

    protected SQLName name;
    protected final List<SQLOption> options = new ArrayList<>();

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
        }
    }

    @Override
    public SQLLikeClause clone() {
        SQLLikeClause x = new SQLLikeClause();
        SQLName nameClone = this.name.clone();
        x.setName(nameClone);
        for (SQLOption option : this.options) {
            x.addOption(option);
        }
        return x;
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == name
                && target instanceof SQLName) {
            setName((SQLName) target);
            return true;
        }
        return false;
    }

    public SQLName getName() {
        return name;
    }

    public void setName(SQLName name) {
        setChildParent(name);
        this.name = name;
    }

    public List<SQLOption> getOptions() {
        return options;
    }

    public void addOption(SQLOption option) {
        if (option == null) {
            return;
        }
        this.options.add(option);
    }


    /**
     * INCLUDING IDENTITY | EXCLUDING IDENTITY
     * INCLUDING DEFAULTS | EXCLUDING DEFAULTS
     * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#like%20options
     * <p>
     * { INCLUDING | EXCLUDING } { DEFAULTS | CONSTRAINTS | INDEXES | STORAGE | COMMENTS | ALL }
     * https://www.postgresql.org/docs/9.3/static/sql-createtable.html
     */
    public enum SQLOption implements ISQLEnum {

        INCLUDING_IDENTITY(SQLReserved.INCLUDING_IDENTITY),
        EXCLUDING_IDENTITY(SQLReserved.EXCLUDING_IDENTITY),

        INCLUDING_DEFAULTS(SQLReserved.INCLUDING_DEFAULTS),
        EXCLUDING_DEFAULTS(SQLReserved.EXCLUDING_DEFAULTS),

        INCLUDING_CONSTRAINTS(SQLReserved.INCLUDING_CONSTRAINTS),
        EXCLUDING_CONSTRAINTS(SQLReserved.EXCLUDING_CONSTRAINTS),

        INCLUDING_INDEXES(SQLReserved.INCLUDING_INDEXES),
        EXCLUDING_INDEXES(SQLReserved.EXCLUDING_INDEXES),

        INCLUDING_STORAGE(SQLReserved.INCLUDING_STORAGE),
        EXCLUDING_STORAGE(SQLReserved.EXCLUDING_STORAGE),

        INCLUDING_COMMENTS(SQLReserved.INCLUDING_COMMENTS),
        EXCLUDING_COMMENTS(SQLReserved.EXCLUDING_COMMENTS),

        INCLUDING_ALL(SQLReserved.INCLUDING_ALL),
        EXCLUDING_ALL(SQLReserved.EXCLUDING_ALL),
        ;
        public final SQLReserved name;

        SQLOption(SQLReserved name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name.upper;
        }

        @Override
        public SQLReserved getName() {
            return name;
        }
    }
}
