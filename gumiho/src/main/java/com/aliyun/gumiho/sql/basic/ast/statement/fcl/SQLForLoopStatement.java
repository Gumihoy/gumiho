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
 * [ <<label>> ]
 * FOR target IN query LOOP
 * statements
 * END LOOP [ label ];
 * https://www.postgresql.org/docs/current/static/plpgsql-control-structures.html
 * <p>
 * FOR index IN [ REVERSE ] [inExpr] LOOP
 * statement... END LOOP [ label ] ;
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/FOR-LOOP-statement.html#GUID-D00F8F0B-ECFC-48B6-B399-D8B5114E7E21
 *
 * @author kongtong.ouyang onCondition 2018/4/4.
 */
public class SQLForLoopStatement extends AbstractSQLStatement {

    protected SQLExpr index;

    protected boolean reverse;

    protected SQLExpr inExpr;

    protected final List<SQLObject> statements = new ArrayList<>();

    protected SQLName endLabel;

    public SQLForLoopStatement(DBType dbType) {
        super(dbType);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, index);
            this.acceptChild(visitor, inExpr);
            this.acceptChild(visitor, statements);
            this.acceptChild(visitor, endLabel);
        }
    }

    @Override
    public SQLForLoopStatement clone() {
       throw new UnsupportedOperationException(getClass().getName());
    }


    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == index) {
            setIndex(target);
            return true;
        }

        if (source == inExpr) {
            setInExpr(target);
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
        return SQLObjectType.FOR_LOOP;
    }



    public SQLExpr getIndex() {
        return index;
    }

    public void setIndex(SQLExpr index) {
        setChildParent(index);
        this.index = index;
    }

    public boolean isReverse() {
        return reverse;
    }

    public void setReverse(boolean reverse) {
        this.reverse = reverse;
    }

    public SQLExpr getInExpr() {
        return inExpr;
    }

    public void setInExpr(SQLExpr inExpr) {
        setChildParent(inExpr);
        this.inExpr = inExpr;
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
