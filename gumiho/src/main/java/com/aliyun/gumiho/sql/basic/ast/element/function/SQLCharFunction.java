package com.aliyun.gumiho.sql.basic.ast.element.function;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLCharsetNameType;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * CHAR(N,... [USING charset_name])
 * https://dev.mysql.com/doc/refman/8.0/en/string-functions.html
 *
 * @author kongtong.ouyang on 2018/7/24.
 */
public class SQLCharFunction extends AbstractSQLFunction {

    protected SQLCharsetNameType charsetName;

    public SQLCharFunction() {
        super(SQLReserved.CHAR.ofExpr());
    }

    public SQLCharFunction(SQLExpr... arguments) {
        super(SQLReserved.CHAR.ofExpr());
        for (SQLExpr argument : arguments) {
            this.addArgument(argument);
        }
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, arguments);
        }
    }

    @Override
    public SQLCharFunction clone() {
        SQLCharFunction x = new SQLCharFunction();
        this.cloneTo(x);
        x.charsetName = this.charsetName;
        return x;
    }


    public SQLCharsetNameType getCharsetName() {
        return charsetName;
    }

    public void setCharsetName(SQLCharsetNameType charsetName) {
        this.charsetName = charsetName;
    }
}
