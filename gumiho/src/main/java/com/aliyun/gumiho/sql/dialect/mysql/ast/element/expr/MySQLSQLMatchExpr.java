package com.aliyun.gumiho.sql.dialect.mysql.ast.element.expr;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.enums.ISQLEnum;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.dialect.mysql.visitor.MySQLSQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * match_expr
 * <p>
 * MATCH (col1,col2,...) AGAINST (expr [search_modifier])
 * <p>
 * https://dev.mysql.com/doc/refman/8.0/en/expressions.html
 *
 * @author kongtong.ouyang on 2018/7/24.
 */
public class MySQLSQLMatchExpr extends AbstractMySQLSQLExpr {

    protected final List<SQLExpr> items = new ArrayList<>();
    protected SQLExpr expr;
    protected SQLModifier modifier;

    @Override
    public void accept0(MySQLSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, items);
            this.acceptChild(visitor, expr);
        }
    }


    @Override
    public MySQLSQLMatchExpr clone() {
        MySQLSQLMatchExpr x = new MySQLSQLMatchExpr();
        return x;
    }


    public List<SQLExpr> getItems() {
        return items;
    }

    public void addItem(SQLExpr item) {
        if (item == null) {
            return;
        }
        setChildParent(item);
        this.items.add(item);
    }

    public SQLExpr getExpr() {
        return expr;
    }

    public void setExpr(SQLExpr expr) {
        setChildParent(expr);
        this.expr = expr;
    }

    public SQLModifier getModifier() {
        return modifier;
    }

    public void setModifier(SQLModifier modifier) {
        this.modifier = modifier;
    }

    public enum SQLModifier implements ISQLEnum {

        IN_NATURAL_LANGUAGE_MODE(SQLReserved.IN_NATURAL_LANGUAGE_MODE),
        IN_NATURAL_LANGUAGE_MODE_WITH_QUERY_EXPANSION(SQLReserved.IN_NATURAL_LANGUAGE_MODE_WITH_QUERY_EXPANSION),
        IN_BOOLEAN_MODE(SQLReserved.IN_BOOLEAN_MODE),
        WITH_QUERY_EXPANSION(SQLReserved.WITH_QUERY_EXPANSION),;

        public final SQLReserved name;

        SQLModifier(SQLReserved name) {
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
