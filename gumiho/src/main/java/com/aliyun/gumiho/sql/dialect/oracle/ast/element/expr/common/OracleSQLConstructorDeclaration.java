package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common;

import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

/**
 * [ FINAL ] [ INSTANTIABLE ] CONSTRUCTOR FUNCTION datatype
 * [ [ SELF IN OUT datatype, ]
 * parameter datatype [, parameter datatype ]...
 * ]
 * RETURN SELF AS RESULT
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/element-specification.html#GUID-20D95D8A-5C17-4C89-9AAB-1852CDB57CE2
 *
 * @author kongtong.ouyang on 2018/6/17.
 */
public class OracleSQLConstructorDeclaration extends OracleSQLConstructorHeading {

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, dataType);
            this.acceptChild(visitor, selfInOutDataType);
            this.acceptChild(visitor, parameters);
        }
    }

    @Override
    public OracleSQLConstructorDeclaration clone() {
        OracleSQLConstructorDeclaration x = new OracleSQLConstructorDeclaration();
        this.cloneTo(x);
        return x;
    }
}
