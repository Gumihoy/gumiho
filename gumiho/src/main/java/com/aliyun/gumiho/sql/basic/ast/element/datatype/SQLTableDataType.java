package com.aliyun.gumiho.sql.basic.ast.element.datatype;

import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * table ( expr (, expr)... )
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#returns%20table%20type
 *
 * @author kongtong.ouyang on 2018/6/20.
 */
public class SQLTableDataType extends AbstractSQLDataType {

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, arguments);
        }
    }

    @Override
    public SQLTableDataType clone() {
        SQLTableDataType x = new SQLTableDataType();
        this.cloneTo(x);
        return x;
    }
}
