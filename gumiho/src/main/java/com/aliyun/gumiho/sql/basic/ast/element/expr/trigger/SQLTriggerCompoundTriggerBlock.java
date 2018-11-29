package com.aliyun.gumiho.sql.basic.ast.element.expr.trigger;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLBody;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * COMPOUND TRIGGER [ declare_section ] timing_point_section [ timing_point_section ]... END [ trigger ] ;
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/CREATE-TRIGGER-statement.html#GUID-AF9E33F1-64D1-4382-A6A4-EC33C36F237B
 *
 * @author kongtong.ouyang on 2018/6/15.
 */
public class SQLTriggerCompoundTriggerBlock extends AbstractSQLExpr {

    protected final List<SQLExpr> declareSections = new ArrayList<>();

    protected final List<SQLExpr> items = new ArrayList<>();

    protected SQLName endName;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, declareSections);
            this.acceptChild(visitor, items);
            this.acceptChild(visitor, endName);
        }
    }

    public List<SQLExpr> getDeclareSections() {
        return declareSections;
    }

    public void addDeclareSection(SQLExpr item) {
        if (item == null) {
            return;
        }
        setChildParent(item);
        this.declareSections.add(item);
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

    public SQLName getEndName() {
        return endName;
    }

    public void setEndName(SQLName endName) {
        setChildParent(endName);
        this.endName = endName;
    }

    /**
     * timing_point IS BEGIN tps_body END timing_point ;
     * <p>
     * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/CREATE-TRIGGER-statement.html#GUID-AF9E33F1-64D1-4382-A6A4-EC33C36F237B
     */
    public static class SQLTimingPointSection extends AbstractSQLExpr {

        protected SQLTimingPoint beforeTimingPoint;

        protected SQLBody body;

        protected SQLTimingPoint afterTimingPoint;

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, body);
            }
        }

        @Override
        public SQLTimingPointSection clone() {
            SQLTimingPointSection x = new SQLTimingPointSection();

            x.beforeTimingPoint = this.beforeTimingPoint;

            SQLBody bodyClone = body.clone();
            x.setBody(bodyClone);

            x.afterTimingPoint = this.afterTimingPoint;
            x.setAfterTimingPoint(afterTimingPoint);

            return x;
        }

        public SQLTimingPoint getBeforeTimingPoint() {
            return beforeTimingPoint;
        }

        public void setBeforeTimingPoint(SQLTimingPoint beforeTimingPoint) {
            this.beforeTimingPoint = beforeTimingPoint;
        }

        public SQLBody getBody() {
            return body;
        }

        public void setBody(SQLBody body) {
            setChildParent(body);
            this.body = body;
        }

        public SQLTimingPoint getAfterTimingPoint() {
            return afterTimingPoint;
        }

        public void setAfterTimingPoint(SQLTimingPoint afterTimingPoint) {
            this.afterTimingPoint = afterTimingPoint;
        }
    }


    public enum SQLTimingPoint {

        BEFORE_STATEMENT("BEFORE STATEMENT"),
        BEFORE_EACH_ROW("BEFORE EACH ROW"),
        AFTER_STATEMENT("AFTER STATEMENT"),
        AFTER_EACH_ROW("AFTER EACH ROW"),
        INSTEAD_OF_EACH_ROW("INSTEAD OF EACH ROW"),;

        public final String name;

        SQLTimingPoint(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
