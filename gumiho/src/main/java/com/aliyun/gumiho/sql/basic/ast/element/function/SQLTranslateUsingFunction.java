package com.aliyun.gumiho.sql.basic.ast.element.function;

import static com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved.TRANSLATE;

import com.aliyun.gumiho.sql.basic.ast.element.function.AbstractSQLFunction;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * TRANSLATE ( char USING  usingType={CHAR_CS | NCHAR_CS })
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/TRANSLATE-USING.html#GUID-EC8DE4D2-4F24-456D-A2E7-AD8F82E3A148
 *
 * @author kongtong.ouyang on 2018/4/28.
 */
public class SQLTranslateUsingFunction extends AbstractSQLFunction {

    protected SQLReserved usingType;

    public SQLTranslateUsingFunction() {
        super(TRANSLATE.ofExpr());
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, nameExpr);
            this.acceptChild(visitor, arguments);
        }
    }

    public SQLReserved getUsingType() {
        return usingType;
    }

    public void setUsingType(SQLReserved usingType) {
        this.usingType = usingType;
    }
}
