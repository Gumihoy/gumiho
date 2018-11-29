package com.aliyun.gumiho.sql.basic.ast.element.function;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * SUBSTR(str FROM pos)
 * SUBSTR(str FROM pos FOR len)
 * <p>
 * https://dev.mysql.com/doc/refman/8.0/en/string-functions.html
 *
 * @author kongtong.ouyang on 2018/7/25.
 */
public class SQLSubStrFromFunction extends AbstractSQLFunction {

    public SQLSubStrFromFunction() {
        super(SQLReserved.SUBSTR.ofExpr());
    }

    public SQLSubStrFromFunction(SQLExpr str, SQLExpr pos) {
        super(SQLReserved.SUBSTR.ofExpr());
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
        SQLSubStrFromFunction x = new SQLSubStrFromFunction();
        return x;
    }

}
