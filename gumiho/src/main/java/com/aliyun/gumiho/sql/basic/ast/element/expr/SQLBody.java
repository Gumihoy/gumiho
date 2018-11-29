package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.ast.SQLObject;
import com.aliyun.gumiho.sql.basic.ast.element.expr.clause.SQLExceptionClause;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * [begin_label:] BEGIN
 * [statement_list]
 * END [end_label]
 * https://dev.mysql.com/doc/refman/5.7/en/begin-end.html
 * <p>
 * <p>
 * [ <<label>> ]
 * [ DECLARE declarations ]
 * BEGIN statements
 * END [ label ];
 * https://www.postgresql.org/docs/devel/static/plpgsql-structure.html
 * <p>
 * <p>
 * BEGIN statement ...
 * [ EXCEPTION exception_handler [ exception_handler ]... ]
 * END [ name ] ;
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/lnpls/block.html
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/block.html#GUID-9ACEB9ED-567E-4E1A-A16A-B8B35214FC9D
 *
 * @author kongtong.ouyang onCondition 2018/4/3.
 */
public class SQLBody extends AbstractSQLExpr {

    protected SQLName beginLabel;

    protected final List<SQLBodyItem> bodyItems = new ArrayList<>();

    protected SQLExceptionClause exceptionClause;

    protected SQLName endName;


    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, beginLabel);
            this.acceptChild(visitor, bodyItems);
            this.acceptChild(visitor, exceptionClause);
            this.acceptChild(visitor, endName);
        }
    }

    @Override
    public SQLBody clone() {
        SQLBody x = new SQLBody();
        this.cloneTo(x);
        return x;
    }


    public void cloneTo(SQLBody x) {
        super.cloneTo(x);

        if (this.beginLabel != null) {
            SQLName beginLabelClone = this.beginLabel.clone();
            x.setBeginLabel(beginLabelClone);
        }

        for (SQLBodyItem bodyItem : this.bodyItems) {
            SQLBodyItem bodyItemClone = bodyItem.clone();
            x.addBodyItem(bodyItemClone);
        }

        if (this.exceptionClause != null) {
            SQLExceptionClause exceptionClauseClone = this.exceptionClause.clone();
            x.setExceptionClause(exceptionClauseClone);
        }

        if (this.endName != null) {
            SQLName endNameClone = this.endName.clone();
            x.setEndName(endNameClone);
        }
    }


    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {

        if (target == null) {

            if (source == beginLabel) {
                setBeginLabel(null);
                return true;
            }

            boolean replace = replaceInList(bodyItems, source, null, this);
            if (replace) {
                return true;
            }

            if (source == endName) {
                setEndName(null);
                return true;
            }

            return false;

        }

        if (source == beginLabel
                && target instanceof SQLName) {
            setBeginLabel((SQLName) target);
            return true;
        }

        if (source == endName
                && target instanceof SQLName) {
            setEndName((SQLName) target);
            return true;
        }

        return false;
    }

    public SQLName getBeginLabel() {
        return beginLabel;
    }

    public SQLBody setBeginLabel(SQLName beginLabel) {
        setChildParent(beginLabel);
        this.beginLabel = beginLabel;
        return this;
    }

    public List<SQLBodyItem> getBodyItems() {
        return bodyItems;
    }

    public SQLBody addBodyItem(SQLBodyItem bodyItem) {
        if (bodyItem == null) {
            return this;
        }
        setChildParent(bodyItem);
        this.bodyItems.add(bodyItem);
        return this;
    }

    public SQLBody addBodyItem(SQLObject statement) {
        if (statement == null) {
            return this;
        }
        SQLBodyItem bodyItem;
        if (statement instanceof SQLBodyItem) {
            bodyItem = (SQLBodyItem) statement;
        } else {
            bodyItem = new SQLBodyItem(statement);
        }
        setChildParent(bodyItem);
        this.bodyItems.add(bodyItem);
        return this;
    }

    public SQLExceptionClause getExceptionClause() {
        return exceptionClause;
    }

    public SQLBody setExceptionClause(SQLExceptionClause exceptionClause) {
        setChildParent(exceptionClause);
        this.exceptionClause = exceptionClause;
        return this;
    }

    public SQLName getEndName() {
        return endName;
    }

    public void setEndName(SQLName endName) {
        setChildParent(endName);
        this.endName = endName;
    }

    /**
     * labels
     * statement
     */
    public static class SQLBodyItem extends AbstractSQLExpr {

        protected final List<SQLLabel> labels = new ArrayList<>();

        protected SQLObject statement;

        public SQLBodyItem() {
        }

        public SQLBodyItem(SQLObject statement) {
            setStatement(statement);
        }

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, labels);
                this.acceptChild(visitor, statement);
            }
        }


        @Override
        public SQLBodyItem clone() {
            SQLBodyItem x = new SQLBodyItem();
            for (SQLLabel label : labels) {
                SQLLabel labelClone = label.clone();
                x.addLabel(labelClone);
            }

            SQLObject statementClone = this.statement.clone();
            x.setStatement(statementClone);
            return x;
        }

        public List<SQLLabel> getLabels() {
            return labels;
        }

        public void addLabel(SQLLabel label) {
            if (label == null) {
                return;
            }
            setChildParent(label);
            this.labels.add(label);
        }

        public SQLObject getStatement() {
            return statement;
        }

        public void setStatement(SQLObject statement) {
            setChildParent(statement);
            this.statement = statement;
        }
    }

}
