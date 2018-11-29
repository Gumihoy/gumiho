package com.aliyun.gumiho.sql.basic.ast.element.function;

import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * VALIDATE_CONVERSION (expr AS type_name [, fmt [, 'nlsparam' ] ])
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/VALIDATE_CONVERSION.html#GUID-DC485EEB-CB6D-42EF-97AA-4487884CB2CD
 *
 * @author kongtong.ouyang on 2018/5/21.
 */
public class SQLValidateConversionFunction extends AbstractSQLFunction {

    public SQLValidateConversionFunction() {
        super(SQLReserved.VALIDATE_CONVERSION.ofExpr());
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, arguments);
        }
    }

}
