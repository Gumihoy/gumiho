package com.aliyun.gumiho.sql.basic.ast.element.expr.trigger;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * { FOLLOWS | PRECEDES } [ schmema.] trigger [ , [ schmema.] trigger ]...
 * <p>
 * trigger_ordering_clause
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/CREATE-TRIGGER-statement.html#GUID-AF9E33F1-64D1-4382-A6A4-EC33C36F237B
 *
 * @author kongtong.ouyang on 2018/4/26.
 */
public class SQLTriggerOrderingClause extends AbstractSQLExpr {

    protected Type type;

    protected final List<SQLName> names = new ArrayList<>();

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, names);
        }
    }

    @Override
    public SQLTriggerOrderingClause clone() {
        SQLTriggerOrderingClause x = new SQLTriggerOrderingClause();
        x.type = this.type;

        for (SQLName name : names) {
            SQLName nameClone = name.clone();
            x.addName(nameClone);
        }
        return x;
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (target instanceof SQLName) {
            boolean replace = replaceInList(names, source, (SQLName) target, this);
            if (replace) {
                return true;
            }
        }

        return false;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<SQLName> getNames() {
        return names;
    }

    public void addName(SQLName name) {
        if (name == null) {
            return;
        }
        setChildParent(name);
        this.names.add(name);
    }

    public enum Type {
        FOLLOWS(SQLReserved.FOLLOWS),
        PRECEDES(SQLReserved.PRECEDES);

        public final SQLReserved name;

        Type(SQLReserved name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name.upper;
        }
    }
}
