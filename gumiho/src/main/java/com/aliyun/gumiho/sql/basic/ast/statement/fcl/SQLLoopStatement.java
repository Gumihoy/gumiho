package com.aliyun.gumiho.sql.basic.ast.statement.fcl;

import com.aliyun.gumiho.sql.basic.ast.SQLObject;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

import java.util.ArrayList;
import java.util.List;

/**
 * [begin_label:] LOOP statement_list END LOOP [end_label]
 * https://dev.mysql.com/doc/refman/5.7/en/loop.html
 * <p>
 * LOOP statement... END LOOP [ label ] ;
 * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/lnpls/basic-LOOP-statement.html#GUID-99AC48AC-D868-43C4-9E4D-6A7671942A39
 *
 * @author kongtong.ouyang onCondition 2018/4/4.
 */
public class SQLLoopStatement extends AbstractSQLStatement {

    protected SQLName beginLabel;

    protected final List<SQLObject> statements = new ArrayList<>();

    protected SQLName endLabel;

    public SQLLoopStatement(DBType dbType) {
        super(dbType);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, beginLabel);
            this.acceptChild(visitor, statements);
            this.acceptChild(visitor, endLabel);
        }
    }

    @Override
    public SQLLoopStatement clone() {
        SQLLoopStatement x = new SQLLoopStatement(this.dbType);
        return x;
    }


    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {

        if (source == beginLabel
                && target instanceof SQLName) {
            setBeginLabel((SQLName) target);
        }

        if (source == endLabel
                && target instanceof SQLName) {
            setEndLabel((SQLName) target);
        }
        return false;
    }

    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.LOOP;
    }


    public SQLName getBeginLabel() {
        return beginLabel;
    }

    public void setBeginLabel(SQLName beginLabel) {
        setChildParent(beginLabel);
        this.beginLabel = beginLabel;
    }

    public List<SQLObject> getStatements() {
        return statements;
    }

    public void addStatement(SQLObject statement) {
        if (statement == null) {
            return;
        }
        setChildParent(statement);
        this.statements.add(statement);
    }

    public SQLName getEndLabel() {
        return endLabel;
    }

    public void setEndLabel(SQLName endLabel) {
        setChildParent(endLabel);
        this.endLabel = endLabel;
    }
}
