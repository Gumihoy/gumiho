package com.aliyun.gumiho.sql.basic.ast.element.hint;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.enums.ISQLEnum;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;

import java.util.ArrayList;
import java.util.List;

/**
 * USE {INDEX|KEY} [FOR {JOIN|ORDER BY|GROUP BY}] ([index_list])
 * | IGNORE {INDEX|KEY} [FOR {JOIN|ORDER BY|GROUP BY}] (index_list)
 * | FORCE {INDEX|KEY} [FOR {JOIN|ORDER BY|GROUP BY}] (index_list)
 * <p>
 * https://dev.mysql.com/doc/refman/5.7/en/index-hints.html
 *
 * @author kongtong.ouyang on 2018/8/28.
 */
public abstract class AbstractSQLIndexHint extends AbstractSQLExpr implements SQLIndexHint {

    protected SQLForType forType;

    protected final List<SQLExpr> names = new ArrayList<>();

    @Override
    public AbstractSQLIndexHint clone() {
        throw new UnsupportedOperationException(this.getClass().getName());
    }

    public void cloneTo(AbstractSQLIndexHint x) {
        super.cloneTo(x);

        x.forType = this.forType;

        for (SQLExpr name : this.names) {
            SQLExpr nameClone = name.clone();
            x.addName(nameClone);
        }
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        boolean replace = replaceInList(names, source, target, this);
        if (replace) {
            return true;
        }

        return false;
    }

    public SQLForType getForType() {
        return forType;
    }

    public AbstractSQLIndexHint setForType(SQLForType forType) {
        this.forType = forType;
        return this;
    }

    public List<SQLExpr> getNames() {
        return names;
    }

    public void addName(SQLExpr name) {
        if (name == null) {
            return;
        }
        setChildParent(name);
        this.names.add(name);
    }


    /**
     * FOR {JOIN|ORDER BY|GROUP BY}
     */
    public enum SQLForType implements ISQLEnum {

        JOIN(SQLReserved.JOIN),
        ORDER_BY(SQLReserved.ORDER_BY),
        GROUP_BY(SQLReserved.GROUP_BY),;

        public final SQLReserved name;

        SQLForType(SQLReserved name) {
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
