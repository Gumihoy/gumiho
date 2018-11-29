package com.aliyun.gumiho.sql.basic.ast.element.expr.trigger;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.hash.FNVHash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kongtong.ouyang on 2018/6/15.
 */
public class SQLTriggerDatabaseEvent extends AbstractSQLExpr implements SQLTriggerEvent.ISQLTriggerDatabaseEvent {

    protected SQLTriggerDatabaseEventType type;

    public SQLTriggerDatabaseEvent(SQLTriggerDatabaseEventType type) {
        this.type = type;
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SQLTriggerDatabaseEvent clone() {
        SQLTriggerDatabaseEvent x = new SQLTriggerDatabaseEvent(this.type);
        return x;
    }

    @Override
    public String getEvent() {
        return type.getEvent();
    }

    public SQLTriggerDatabaseEventType getType() {
        return type;
    }

    public void setType(SQLTriggerDatabaseEventType type) {
        this.type = type;
    }


    public enum SQLTriggerDatabaseEventType implements TriggerEventType {
        STARTUP(SQLReserved.STARTUP),
        SERVERERROR(SQLReserved.SERVERERROR),
        LOGON(SQLReserved.LOGON),
        SUSPEND(SQLReserved.SUSPEND),
        DB_ROLE_CHANGE(SQLReserved.DB_ROLE_CHANGE),
        CLONE(SQLReserved.CLONE),
        SET_CONTAINER(SQLReserved.SET_CONTAINER),

        SHUTDOWN(SQLReserved.SHUTDOWN),
        BEFORE_LOGOFF(SQLReserved.LOGOFF),
        BEFORE_UNPLUG(SQLReserved.UNPLUG),;

        public final SQLReserved name;

        SQLTriggerDatabaseEventType(SQLReserved name) {
            this.name = name;
        }

        public static SQLTriggerDatabaseEventType of(String name) {
            long lowerHashCode = FNVHash.fnv1a_64_lower(name);
            return SQLTriggerDatabaseEventTypeHolder.MAP.get(lowerHashCode);
        }

        @Override
        public String toString() {
            return name.upper;
        }

        @Override
        public SQLReserved getName() {
            return name;
        }

        @Override
        public String getEvent() {
            return name.upper;
        }

        public static class SQLTriggerDatabaseEventTypeHolder {

            public static final Map<Long, SQLTriggerDatabaseEventType> MAP = new HashMap<>();

            static {
                for (SQLTriggerDatabaseEventType eventType : SQLTriggerDatabaseEventType.values()) {
                    MAP.put(eventType.name.lowerHashCode64, eventType);
                }
            }
        }
    }

}
