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
public class SQLTriggerDDLEvent extends AbstractSQLExpr implements SQLTriggerEvent.ISQLTriggerDDLEvent {

    protected SQLTriggerDDLEventType type;

    public SQLTriggerDDLEvent(SQLTriggerDDLEventType type) {
        this.type = type;
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SQLTriggerDDLEvent clone() {
        SQLTriggerDDLEvent x = new SQLTriggerDDLEvent(this.type);
        return x;
    }

    @Override
    public String getEvent() {
        return type.getEvent();
    }

    public SQLTriggerDDLEventType getType() {
        return type;
    }

    public void setType(SQLTriggerDDLEventType type) {
        this.type = type;
    }

    public enum SQLTriggerDDLEventType implements TriggerEventType {
        ALTER(SQLReserved.ALTER),
        ANALYZE(SQLReserved.ANALYZE),
        ASSOCIATE_STATISTICS(SQLReserved.ASSOCIATE_STATISTICS),
        AUDIT(SQLReserved.AUDIT),
        COMMENT(SQLReserved.COMMENT),
        CREATE(SQLReserved.CREATE),
        DISASSOCIATE_STATISTICS(SQLReserved.DISASSOCIATE_STATISTICS),
        DROP(SQLReserved.DROP),
        GRANT(SQLReserved.GRANT),
        NOAUDIT(SQLReserved.NOAUDIT),
        RENAME(SQLReserved.RENAME),
        REVOKE(SQLReserved.REVOKE),
        TRUNCATE(SQLReserved.TRUNCATE),
        DDL(SQLReserved.DDL),;
        public final SQLReserved name;

        SQLTriggerDDLEventType(SQLReserved name) {
            this.name = name;
        }

        public static SQLTriggerDDLEventType of(String name) {
            long lowerHashCode = FNVHash.fnv1a_64_lower(name);
            return SQLTriggerDDLEventTypeHolder.MAP.get(lowerHashCode);
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


        public static class SQLTriggerDDLEventTypeHolder {

            public static final Map<Long, SQLTriggerDDLEventType> MAP = new HashMap<>();

            static {
                for (SQLTriggerDDLEventType eventType : SQLTriggerDDLEventType.values()) {
                    MAP.put(eventType.name.lowerHashCode64, eventType);
                }
            }
        }
    }

}
