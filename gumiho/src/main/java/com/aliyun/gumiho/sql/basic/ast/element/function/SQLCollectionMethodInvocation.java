package com.aliyun.gumiho.sql.basic.ast.element.function;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.SQLJoinTableReference;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.hash.FNVHash;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * collection.name (expr (, expr)...)
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/collection-method.html#GUID-7AF1A3C4-D04B-4F91-9D7B-C92C75E3A300
 *
 * @author kongtong.ouyang on 2018/6/14.
 */
public class SQLCollectionMethodInvocation extends AbstractSQLExpr {

    protected SQLName collection;

    protected SQLCollectionMethodName name;

    protected final List<SQLExpr> arguments = new ArrayList<>();

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, collection);
            this.acceptChild(visitor, arguments);
        }
    }

    public SQLName getCollection() {
        return collection;
    }

    public void setCollection(SQLName collection) {
        setChildParent(collection);
        this.collection = collection;
    }

    public SQLCollectionMethodName getName() {
        return name;
    }

    public void setName(SQLCollectionMethodName name) {
        this.name = name;
    }

    public List<SQLExpr> getArguments() {
        return arguments;
    }

    public void addArgument(SQLExpr argument) {
        if (argument == null) {
            return;
        }
        argument.setParent(this);
        this.arguments.add(argument);
    }

    public enum SQLCollectionMethodName {
        COUNT(SQLReserved.COUNT),
        DELETE(SQLReserved.DELETE),
        EXISTS(SQLReserved.EXISTS),
        EXTEND(SQLReserved.EXTEND),
        FIRST(SQLReserved.FIRST),
        LAST(SQLReserved.LAST),
        LIMIT(SQLReserved.LIMIT),
        NEXT(SQLReserved.NEXT),
        PRIOR(SQLReserved.PRIOR),
        TRIM(SQLReserved.TRIM),;

        public final SQLReserved name;

        SQLCollectionMethodName(SQLReserved name) {
            this.name = name;
        }

        public static SQLCollectionMethodName of(String name) {
            if (name == null) {
                return null;
            }
            long lowerHashCode64 = FNVHash.fnv1a_64_lower(name);
            return SQLCollectionMethodNameHolder.MAP.get(lowerHashCode64);
        }

        public static class SQLCollectionMethodNameHolder {

            public static ConcurrentHashMap<Long, SQLCollectionMethodName> MAP = new ConcurrentHashMap<>();

            static {
                for (SQLCollectionMethodName joinType : SQLCollectionMethodName.values()) {
                    MAP.put(joinType.name.lowerHashCode64, joinType);
                }
            }
        }
    }
}
