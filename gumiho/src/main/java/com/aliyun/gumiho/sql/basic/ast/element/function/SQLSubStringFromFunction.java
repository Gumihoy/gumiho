package com.aliyun.gumiho.sql.basic.ast.element.function;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * SUBSTRING(str FROM pos)
 * SUBSTRING(str FROM pos FOR len)
 *
 * https://dev.mysql.com/doc/refman/8.0/en/string-functions.html
 * @author kongtong.ouyang on 2018/7/25.
 */
public class SQLSubStringFromFunction extends AbstractSQLFunction {


    public SQLSubStringFromFunction() {
        super(SQLReserved.SUBSTRING.ofExpr());
    }

    public SQLSubStringFromFunction(SQLExpr str, SQLExpr pos) {
        super(SQLReserved.SUBSTRING.ofExpr());
        this.addArgument(str);
        this.addArgument(pos);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, arguments);
        }
    }

    @Override
    public AbstractSQLFunction clone() {

        SQLSubStringFromFunction x = new SQLSubStringFromFunction();
        return x;
    }

}
