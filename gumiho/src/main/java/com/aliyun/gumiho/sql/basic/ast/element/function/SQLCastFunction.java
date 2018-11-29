package com.aliyun.gumiho.sql.basic.ast.element.function;

import com.aliyun.gumiho.sql.basic.ast.element.datatype.SQLDataType;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#cast%20specification
 * <p>
 * https://dev.mysql.com/doc/refman/5.5/en/cast-functions.html#function_cast
 * <p>
 * CAST({ expr | MULTISET (subquery) } AS type_name [ DEFAULT return_value ON CONVERSION ERROR ] [, fmt [, 'nlsparam' ] ])
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Single-Row-Functions.html#GUID-D16F7FB3-48D9-4354-A58A-357515D402DC
 *
 * @author kongtong.ouyang on 2018/4/27.
 */
public class SQLCastFunction extends AbstractSQLFunction {

    protected SQLDataType dataType;

    public SQLCastFunction() {
        super(SQLReserved.CAST.ofExpr());
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, arguments);
            this.acceptChild(visitor, dataType);
            this.acceptChild(visitor, defaultOnConversionError);
        }
    }

    public SQLDataType getDataType() {
        return dataType;
    }

    public void setDataType(SQLDataType dataType) {
        setChildParent(dataType);
        this.dataType = dataType;
    }
}
