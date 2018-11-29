package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * TABLESPACE SET tablespace
 *
 * @author kongtong.ouyang on 2018/6/21.
 */
public class SQLTableSpaceSetClause extends AbstractSQLExpr implements ISQLSegmentAttributesClause, ISQLLobStorageParameter, ISQLPartitioningStorageClause {

    protected SQLExpr tablespace;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, tablespace);
        }
    }

    @Override
    public SQLTableSpaceSetClause clone() {
        SQLTableSpaceSetClause x = new SQLTableSpaceSetClause();
        this.cloneTo(x);

        SQLExpr tablespaceClone = this.tablespace.clone();
        x.setTablespace(tablespaceClone);
        return x;
    }

    public SQLExpr getTablespace() {
        return tablespace;
    }

    public void setTablespace(SQLExpr tablespace) {
        setChildParent(tablespace);
        this.tablespace = tablespace;
    }
}
