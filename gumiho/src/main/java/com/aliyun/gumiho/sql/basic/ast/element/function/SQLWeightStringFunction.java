package com.aliyun.gumiho.sql.basic.ast.element.function;

import com.aliyun.gumiho.sql.basic.ast.element.datatype.SQLDataType;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * WEIGHT_STRING(str [AS {CHAR|BINARY}(N)] [flags])
 *
 * https://dev.mysql.com/doc/refman/8.0/en/string-functions.html
 * @author kongtong.ouyang on 2018/7/25.
 */
public class SQLWeightStringFunction extends AbstractSQLFunction {

    protected SQLDataType dataType;

    public SQLWeightStringFunction() {
        super(SQLReserved.WEIGHT_STRING.ofExpr());
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, arguments);
        }
    }

    @Override
    public AbstractSQLFunction clone() {
        SQLWeightStringFunction x = new SQLWeightStringFunction();
        return x;
    }

    public SQLDataType getDataType() {
        return dataType;
    }

    public void setDataType(SQLDataType dataType) {
        setChildParent(dataType);
        this.dataType = dataType;
    }
}
