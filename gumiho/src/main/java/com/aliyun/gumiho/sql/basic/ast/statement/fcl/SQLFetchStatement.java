package com.aliyun.gumiho.sql.basic.ast.statement.fcl;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.enums.ISQLEnum;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

import java.util.ArrayList;
import java.util.List;

/**
 * FETCH [[NEXT] FROM] cursor_name INTO var_name [, var_name] ...
 * <p>
 * https://dev.mysql.com/doc/refman/8.0/en/fetch.html
 *
 * FETCH [ direction [ FROM | IN ] ] cursor_name
 * https://www.postgresql.org/docs/devel/static/sql-fetch.html
 * <p>
 * FETCH { cursor | cursor_variable | :host_cursor_variable } { [bulk collect] into expr <, expr>...  [ LIMIT limitExpr ] } ;
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/FETCH-statement.html#GUID-75BC6E63-841A-4103-9B96-8AC97F5C28BB
 *
 * @author kongtong.ouyang on 2018/6/13.
 */
public class SQLFetchStatement extends AbstractSQLStatement {

    protected SQLExpr direction;

    protected SQLFromType fromType;

    protected SQLExpr name;

    protected boolean bulkCollect;

    protected final List<SQLExpr> intoItems = new ArrayList<>();

    protected SQLExpr limitExpr;


    public SQLFetchStatement(DBType dbType) {
        super(dbType);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, direction);
            this.acceptChild(visitor, name);
            this.acceptChild(visitor, intoItems);
            this.acceptChild(visitor, limitExpr);
        }
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == direction) {
            setDirection(target);
            return true;
        }

        if (source == name) {
            setName(target);
            return true;
        }

        boolean replace = replaceInList(intoItems, source, target, this);
        if (replace) {
            return true;
        }

        if (source == limitExpr) {
            setLimitExpr(target);
            return true;
        }
        return false;
    }

    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.FETCH;
    }


    public SQLExpr getDirection() {
        return direction;
    }

    public void setDirection(SQLExpr direction) {
        setChildParent(direction);
        this.direction = direction;
    }

    public SQLFromType getFromType() {
        return fromType;
    }

    public void setFromType(SQLFromType fromType) {
        this.fromType = fromType;
    }

    public SQLExpr getName() {
        return name;
    }

    public String getCursorName() {
        if (name instanceof SQLName) {
            return ((SQLName) name).getName();
        }
        return null;
    }

    public void setName(SQLExpr name) {
        setChildParent(name);
        this.name = name;
    }

    public boolean isBulkCollect() {
        return bulkCollect;
    }

    public void setBulkCollect(boolean bulkCollect) {
        this.bulkCollect = bulkCollect;
    }

    public List<SQLExpr> getIntoItems() {
        return intoItems;
    }

    public void addIntoItem(SQLExpr intoItem) {
        if (intoItem == null) {
            return;
        }
        setChildParent(intoItem);
        this.intoItems.add(intoItem);
    }


    public SQLExpr getLimitExpr() {
        return limitExpr;
    }

    public void setLimitExpr(SQLExpr limitExpr) {
        setChildParent(limitExpr);
        this.limitExpr = limitExpr;
    }



    public interface  SQLFetchDirection extends SQLExpr {

    }

    /**
     * ABSOLUTE count
     */
    public static class SQLFetchAbsoluteDirection extends AbstractSQLExpr {
        protected SQLExpr count;
        @Override
        protected void accept0(SQLASTVisitor visitor) {

        }
    }


    /**
     * RELATIVE count
     */
    public static class SQLFetchRelativeDirection extends AbstractSQLExpr {
        protected SQLExpr count;
        @Override
        protected void accept0(SQLASTVisitor visitor) {

        }
    }

    /**
     * BACKWARD count
     */
    public static class SQLFetchBackwardDirection extends AbstractSQLExpr {
        protected SQLExpr count;
        @Override
        protected void accept0(SQLASTVisitor visitor) {
//            if (visitor.visit(this)) {
//                this.acceptChild(visitor, count);
//            }
        }
    }


    public enum  SQLFromType implements ISQLEnum {
        FROM(SQLReserved.FROM),
        NEXT_FROM(SQLReserved.NEXT_FROM),
        IN(SQLReserved.IN),;
        public final SQLReserved name;

        SQLFromType(SQLReserved name) {
            this.name = name;
        }

        @Override
        public SQLReserved getName() {
            return name;
        }
    }
}
