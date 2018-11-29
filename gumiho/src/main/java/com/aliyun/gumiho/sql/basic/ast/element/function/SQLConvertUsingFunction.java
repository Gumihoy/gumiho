package com.aliyun.gumiho.sql.basic.ast.element.function;

import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * CONVERT(expr USING transcoding_name)
 * https://dev.mysql.com/doc/refman/8.0/en/cast-functions.html#function_convert
 *
 * @author kongtong.ouyang on 2018/7/24.
 */
public class SQLConvertUsingFunction extends AbstractSQLFunction {

    protected SQLName coding;

    public SQLConvertUsingFunction() {
        super(SQLReserved.CONVERT.ofExpr());
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, arguments);
        }
    }

    @Override
    public AbstractSQLFunction clone() {
        return super.clone();
    }

    public SQLName getCoding() {
        return coding;
    }

    public void setCoding(SQLName coding) {
        this.coding = coding;
    }
}
