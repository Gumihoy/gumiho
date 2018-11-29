package com.aliyun.gumiho.sql.basic.ast.element.function.xml;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.function.AbstractSQLFunction;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * XMLCAST ( value_expression AS datatype )
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/XMLCAST.html#GUID-06563B93-1247-4F0C-B6BE-42DB3B1DB069
 *
 * @author kongtong.ouyang on 2018/5/24.
 */
public class SQLXmlCastFunction extends AbstractSQLFunction {

    public SQLXmlCastFunction() {
        super(SQLReserved.XMLCAST.ofExpr());
    }

    public SQLXmlCastFunction(SQLExpr argument) {
        super(SQLReserved.XMLCAST.ofExpr());
        this.addArgument(argument);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, arguments);
        }
    }

}
