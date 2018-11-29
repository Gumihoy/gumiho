package com.aliyun.gumiho.sql.basic.ast.element.function;

import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * POSITION(substr IN str)
 * https://dev.mysql.com/doc/refman/8.0/en/string-functions.html
 *
 * @author kongtong.ouyang on 2018/7/24.
 */
public class SQLPositionFunction extends AbstractSQLFunction {

    public SQLPositionFunction() {
        super(SQLReserved.POSITION.ofExpr());
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, arguments);
        }
    }

    @Override
    public SQLPositionFunction clone() {
        SQLPositionFunction x = new SQLPositionFunction();
        return x;
    }


}
