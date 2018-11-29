package com.aliyun.gumiho.sql.dialect.mysql.ast.element.expr.select;

import com.aliyun.gumiho.sql.basic.ast.element.expr.select.AbstractSQLTableReference;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.ISQLTableReference;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.dialect.mysql.visitor.MySQLSQLASTVisitor;

/**
 *
 * { OJ table_reference }
 *
 * https://dev.mysql.com/doc/refman/5.7/en/join.html
 *
 * @author kongtong.ouyang on 2018/5/3.
 */
public class MySQLSQLOJTableReference extends AbstractSQLTableReference implements IMySQLSQLTableReference {

    protected ISQLTableReference tableReference;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor instanceof MySQLSQLASTVisitor) {
            this.accept0((MySQLSQLASTVisitor) visitor);
        } else {
            throw new UnsupportedOperationException(getClass().getName());
        }
    }

    @Override
    public void accept0(MySQLSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, tableReference);
        }
    }

    @Override
    public MySQLSQLOJTableReference clone() {
        MySQLSQLOJTableReference x = new MySQLSQLOJTableReference();

        this.cloneTo(x);
        return x;
    }


    public void cloneTo(MySQLSQLOJTableReference x) {
        super.cloneTo(x);

        ISQLTableReference tableReferenceClone = this.tableReference.clone();
        x.setTableReference(tableReferenceClone);
    }

    public ISQLTableReference getTableReference() {
        return tableReference;
    }

    public void setTableReference(ISQLTableReference tableReference) {
        setChildParent(tableReference);
        this.tableReference = tableReference;
    }
}
