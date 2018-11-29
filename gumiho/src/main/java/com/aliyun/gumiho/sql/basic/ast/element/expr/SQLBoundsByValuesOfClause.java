package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * VALUES OF index_collection
 *
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/FORALL-statement.html#GUID-C45B8241-F9DF-4C93-8577-C840A25963DB
 *
 * @author kongtong.ouyang on 2018/6/9.
 */
public class SQLBoundsByValuesOfClause extends AbstractSQLExpr implements ISQLBoundsClause {

    protected SQLName collection;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, collection);
        }
    }

    @Override
    public SQLBoundsByValuesOfClause clone() {
        SQLBoundsByValuesOfClause x = new SQLBoundsByValuesOfClause();

        SQLName collectionClone = this.collection.clone();
        x.setCollection(collectionClone);

        return x;
    }

    public SQLName getCollection() {
        return collection;
    }

    public void setCollection(SQLName collection) {
        setChildParent(collection);
        this.collection = collection;
    }
}
