package com.aliyun.gumiho.sql.basic.ast.element.function.xml;

import com.aliyun.gumiho.sql.basic.ast.element.function.AbstractSQLFunction;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * XMLFOREST ( value_expr [ AS { c_alias | EVALNAME value_expr } ] [, value_expr [ AS { c_alias | EVALNAME value_expr } ] ]...)
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/XMLFOREST.html#GUID-68E5C67E-CE97-4BF8-B7FF-2365E062C363
 *
 * @author kongtong.ouyang on 2018/5/24.
 */
public class SQLXmlForestFunction extends AbstractSQLFunction {

    public SQLXmlForestFunction() {
        super(SQLReserved.XMLCAST.ofExpr());
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, arguments);
        }
    }

}
