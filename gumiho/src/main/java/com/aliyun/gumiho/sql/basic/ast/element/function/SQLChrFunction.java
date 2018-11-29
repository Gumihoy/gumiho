package com.aliyun.gumiho.sql.basic.ast.element.function;

import static com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved.CHR;

import com.aliyun.gumiho.sql.basic.ast.enums.SQLFunctionType;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * CHR(n usingType=[ USING NCHAR_CS ])
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CHR.html#GUID-35FEE007-D49C-4562-A904-041186AC8928
 *
 * @author kongtong.ouyang on 2018/4/28.
 */
public class SQLChrFunction extends AbstractSQLFunction {

    protected SQLReserved usingType;

    public SQLChrFunction() {
        super(CHR.ofExpr());
    }

    {
        this.addFunctionType(SQLFunctionType.String);
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
