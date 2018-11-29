package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLASType;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * [ FINAL ] [ INSTANTIABLE ] CONSTRUCTOR FUNCTION datatype
 * [ [ SELF IN OUT datatype, ]
 * parameter datatype [, parameter datatype ]...
 * ]
 * RETURN SELF AS RESULT
 * { IS | AS } { [ declare_section ] body | call_spec }
 *
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/element-specification.html#GUID-20D95D8A-5C17-4C89-9AAB-1852CDB57CE2
 *
 * @author kongtong.ouyang on 2018/6/17.
 */
public class OracleSQLConstructorDefinition extends OracleSQLConstructorHeading {

    protected SQLASType as = SQLASType.AS;

    protected final List<SQLExpr> declareSections = new ArrayList<>();

    protected SQLExpr asExpr;

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, dataType);
            this.acceptChild(visitor, selfInOutDataType);
            this.acceptChild(visitor, parameters);
            this.acceptChild(visitor, declareSections);
            this.acceptChild(visitor, asExpr);
        }
    }


    public SQLASType getAs() {
        return as;
    }

    public void setAs(SQLASType as) {
        this.as = as;
    }

    public List<SQLExpr> getDeclareSections() {
        return declareSections;
    }

    public void addDeclareSection(SQLExpr declareSection) {
        if (declareSection == null) {
            return;
        }
        setChildParent(declareSection);
        this.declareSections.add(declareSection);
    }


    public SQLExpr getAsExpr() {
        return asExpr;
    }

    public void setAsExpr(SQLExpr asExpr) {
        setChildParent(asExpr);
        this.asExpr = asExpr;
    }
}
