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
 * [begin_label:] WHILE search_condition DO
 * statement_list
 * END WHILE [end_label]
 * https://dev.mysql.com/doc/refman/5.7/en/while.html
 * <p>
 *
 * @author kongtong.ouyang onCondition 2018/4/4.
 */
public class SQLWhileStatement extends AbstractSQLStatement {

    protected SQLName beginLabel;

    protected SQLExpr condition;

    protected final List<SQLObject> statements = new ArrayList<>();

    protected SQLName endLabel;


    public SQLWhileStatement(DBType dbType) {
        super(dbType);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, beginLabel);
            this.acceptChild(visitor, condition);
            this.acceptChild(visitor, statements);
            this.acceptChild(visitor, endLabel);
        }
    }

    @Override
    public SQLWhileStatement clone() {
        SQLWhileStatement x = new SQLWhileStatement(this.dbType);
        this.cloneTo(x);
        return x;
    }


    public void cloneTo(SQLWhileStatement x) {
        super.cloneTo(x);

        if (this.beginLabel != null) {
            SQLName beginLabelClone = this.beginLabel.clone();
            x.setBeginLabel(beginLabelClone);
        }

        SQLExpr exprClone = this.condition.clone();
        x.setCondition(exprClone);

        for (SQLObject stmt : statements) {
            SQLObject stmtClone = stmt.clone();
            x.addStatement(stmtClone);
        }

        if (this.endLabel != null) {
            SQLName endLabelClone = this.endLabel.clone();
            x.setEndLabel(endLabelClone);
        }
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == beginLabel
                && target instanceof SQLName) {
            setBeginLabel((SQLName) target);
            return true;
        }

        if (source == condition) {
            setCondition(target);
            return true;
        }

        if (source == endLabel
                && target instanceof SQLName) {
            setEndLabel((SQLName) target);
            return true;
        }
        return false;
    }

    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.WHILE;
    }



    public SQLName getBeginLabel() {
        return beginLabel;
    }

    public void setBeginLabel(SQLName beginLabel) {
        setChildParent(beginLabel);
        this.beginLabel = beginLabel;
    }

    public SQLExpr getCondition() {
        return condition;
    }

    public void setCondition(SQLExpr condition) {
        setChildParent(condition);
        this.condition = condition;
    }

    public List<SQLObject> getStatements() {
        return statements;
    }

    public void addStatement(SQLObject stmt) {
        if (stmt == null) {
            return;
        }
        setChildParent(stmt);
        this.statements.add(stmt);
    }

    public SQLName getEndLabel() {
        return endLabel;
    }

    public void setEndLabel(SQLName endLabel) {
        setChildParent(endLabel);
        this.endLabel = endLabel;
    }
}
