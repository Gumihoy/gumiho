package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * INDICES OF collection [ BETWEEN lower_bound AND upper_bound ]
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/FORALL-statement.html#GUID-C45B8241-F9DF-4C93-8577-C840A25963DB
 *
 * @author kongtong.ouyang on 2018/6/9.
 */
public class SQLBoundsByIndicesOfClause extends AbstractSQLExpr implements ISQLBoundsClause {

    protected SQLName collection;
    protected SQLExpr lower;
    protected SQLExpr upper;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, collection);
            this.acceptChild(visitor, lower);
            this.acceptChild(visitor, upper);
        }
    }

    @Override
    public SQLBoundsByIndicesOfClause clone() {
        SQLBoundsByIndicesOfClause x = new SQLBoundsByIndicesOfClause();

        SQLName collectionClone = collection.clone();
        x.setCollection(collectionClone);

        if (this.lower != null) {
            SQLExpr lowerClone = this.lower.clone();
            x.setLower(lowerClone);
        }

        if (this.upper != null) {
            SQLExpr upperClone = this.upper.clone();
            x.setUpper(upperClone);
        }

        return x;
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == collection
                && target instanceof SQLName) {
            setCollection((SQLName) target);
            return true;
        }
        if (source == lower) {
            setLower(target);
            return true;
        }
        if (source == upper) {
            setUpper(target);
            return true;
        }
        return false;
    }

    public SQLName getCollection() {
        return collection;
    }

    public void setCollection(SQLName collection) {
        setChildParent(collection);
        this.collection = collection;
    }

    public SQLExpr getLower() {
        return lower;
    }

    public void setLower(SQLExpr lower) {
        setChildParent(lower);
        this.lower = lower;
    }

    public SQLExpr getUpper() {
        return upper;
    }

    public void setUpper(SQLExpr upper) {
        setChildParent(upper);
        this.upper = upper;
    }
}
