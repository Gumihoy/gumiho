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
import javax.rmi.PortableRemoteObject;

/**
 * [begin_label:] REPEAT statement_list UNTIL search_condition END REPEAT [end_label]
 * https://dev.mysql.com/doc/refman/8.0/en/repeat.html
 *
 * @author kongtong.ouyang onCondition 2018/4/4.
 */
public class SQLRepeatStatement extends AbstractSQLStatement {

    protected SQLName beginLabel;
    protected final List<SQLObject> statements = new ArrayList<>();
    protected SQLExpr condition;
    protected SQLName endLabel;


    public SQLRepeatStatement(DBType dbType) {
        super(dbType);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, beginLabel);
            this.acceptChild(visitor, statements);
            this.acceptChild(visitor, condition);
            this.acceptChild(visitor, endLabel);
        }
    }

    @Override
    public SQLRepeatStatement clone() {
        SQLRepeatStatement x = new SQLRepeatStatement(this.dbType);
        this.cloneTo(x);
        return x;
    }

    public void cloneTo(SQLRepeatStatement x) {
        super.cloneTo(x);

        if (this.beginLabel != null) {
            SQLName beginLabelClone = this.beginLabel.clone();
            x.setBeginLabel(beginLabelClone);
        }
        for (SQLObject statement : this.statements) {
            SQLObject statementClone = statement.clone();
            x.addStatement(statementClone);
        }

        if (this.condition != null) {
            SQLExpr conditionClone = this.condition.clone();
            x.setCondition(conditionClone);
        }

        if (this.endLabel != null) {
            SQLName endLabelClone = this.endLabel.clone();
            x.setEndLabel(endLabelClone);
        }
    }

    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.REPEAT;
    }


    public SQLName getBeginLabel() {
        return beginLabel;
    }

    public SQLRepeatStatement setBeginLabel(SQLName beginLabel) {
        setChildParent(beginLabel);
        this.beginLabel = beginLabel;
        return this;
    }

    public List<SQLObject> getStatements() {
        return statements;
    }

    public SQLRepeatStatement addStatement(SQLObject statement) {
        if (statement == null) {
            return this;
        }
        setChildParent(statement);
        this.statements.add(statement);
        return this;
    }

    public SQLExpr getCondition() {
        return condition;
    }

    public SQLRepeatStatement setCondition(SQLExpr condition) {
        setChildParent(condition);
        this.condition = condition;
        return this;
    }

    public SQLName getEndLabel() {
        return endLabel;
    }

    public SQLRepeatStatement setEndLabel(SQLName endLabel) {
        setChildParent(endLabel);
        this.endLabel = endLabel;
        return this;
    }
}
