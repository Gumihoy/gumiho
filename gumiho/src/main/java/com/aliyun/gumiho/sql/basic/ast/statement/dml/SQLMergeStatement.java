package com.aliyun.gumiho.sql.basic.ast.statement.dml;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.basic.ast.SQLObject;
import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.SQLObjectNameTableReference;
import com.aliyun.gumiho.sql.basic.ast.element.expr.clause.SQLValuesClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.clause.SQLWhereClause;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

import java.util.ArrayList;
import java.util.List;

/**
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#merge%20statement
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/sqlrf/MERGE.html
 *
 * @author kongtong.ouyang onCondition 2018/4/8.
 */
public class SQLMergeStatement extends AbstractSQLStatement {


    protected SQLObjectNameTableReference into;

    protected SQLExpr using;

    protected SQLExpr onCondition;

    protected final List<SQLMergeWhenClause> mergeWhenClauses = new ArrayList<>();


    public SQLMergeStatement(DBType dbType) {
        super(dbType);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, into);
            this.acceptChild(visitor, using);
            this.acceptChild(visitor, onCondition);
            this.acceptChild(visitor, mergeWhenClauses);
        }
    }

    @Override
    public SQLMergeStatement clone() {
        SQLMergeStatement x = new SQLMergeStatement(this.dbType);

        this.cloneTo(x);
        return x;
    }

    public void cloneTo(SQLMergeStatement x) {
        super.cloneTo(x);

    }

    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.MERGE;
    }



    public SQLObjectNameTableReference getInto() {
        return into;
    }

    public void setInto(SQLObjectNameTableReference into) {
        this.into = into;
    }

    public SQLExpr getUsing() {
        return using;
    }

    public void setUsing(SQLExpr using) {
        this.using = using;
    }

    public SQLExpr getOnCondition() {
        return onCondition;
    }

    public void setOnCondition(SQLExpr onCondition) {
        this.onCondition = onCondition;
    }

    public List<SQLMergeWhenClause> getMergeWhenClauses() {
        return mergeWhenClauses;
    }

    public void addMergeWhenClause(SQLMergeWhenClause mergeWhenClause) {
        if (mergeWhenClause == null) {
            return;
        }
        mergeWhenClause.setParent(this);
        this.mergeWhenClauses.add(mergeWhenClause);
    }




    /**
     * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#merge%20when%20clause
     */
    public interface SQLMergeWhenClause extends SQLObject {
    }

    /**
     * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#merge%20when%20matched%20clause
     * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/sqlrf/MERGE.html#GUID-5692CCB7-24D9-4C0E-81A7-A22436DC968F
     */
    public static class SQLMergeWhenMatchClause extends AbstractSQLExpr implements SQLMergeWhenClause {

        protected SQLExpr matchThen;

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, matchThen);
            }
        }

        public SQLExpr getMatchThen() {
            return matchThen;
        }

        public void setMatchThen(SQLExpr matchThen) {
            this.matchThen = matchThen;
        }
    }

    /**
     * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#merge%20when%20not%20matched%20clause
     * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/sqlrf/MERGE.html#GUID-5692CCB7-24D9-4C0E-81A7-A22436DC968F
     */
    public static class SQLMergeWhenNotMatchClause extends AbstractSQLExpr implements SQLMergeWhenClause {

        protected SQLExpr notMatchThen;

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, notMatchThen);
            }
        }

        public SQLExpr getNotMatchThen() {
            return notMatchThen;
        }

        public void setNotMatchThen(SQLExpr notMatchThen) {
            this.notMatchThen = notMatchThen;
        }
    }

    public static class SQLMergeUpdateClause extends AbstractSQLExpr {


        protected SQLWhereClause whereClause;

        protected SQLWhereClause deleteWhereClause;


        @Override
        protected void accept0(SQLASTVisitor visitor) {

        }
    }

    /**
     * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#merge%20when%20not%20matched%20clause
     * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/sqlrf/MERGE.html#GUID-5692CCB7-24D9-4C0E-81A7-A22436DC968F
     */
    public static class SQLMergeInsertClause extends AbstractSQLExpr {

        private List<SQLExpr> columns = new ArrayList<SQLExpr>();

        protected SQLValuesClause valuesClause;

        protected SQLWhereClause whereClause;

        @Override
        protected void accept0(SQLASTVisitor visitor) {

        }
    }
}
