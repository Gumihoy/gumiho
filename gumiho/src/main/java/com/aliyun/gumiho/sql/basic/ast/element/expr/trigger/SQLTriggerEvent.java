package com.aliyun.gumiho.sql.basic.ast.element.expr.trigger;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.enums.ISQLEnum;

/**
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#trigger%20event
 * https://www.postgresql.org/docs/10/static/sql-createtrigger.html
 *
 * @author kongtong.ouyang on 2018/4/26.
 */
public interface SQLTriggerEvent extends SQLExpr {

    String getEvent();

    @Override
    SQLTriggerEvent clone();

    interface ISQLTriggerDMLEvent extends SQLTriggerEvent {

    }

    interface ISQLTriggerDDLEvent extends SQLTriggerEvent {

    }

    interface ISQLTriggerDatabaseEvent extends SQLTriggerEvent {

    }

    interface TriggerEventType extends ISQLEnum {
        String getEvent();
    }

}
