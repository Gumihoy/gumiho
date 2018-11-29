package com.aliyun.gumiho.sql.basic.ast.element.expr.clause;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * COMPILE [ DEBUG ] [ PACKAGE | SPECIFICATION | BODY ] [ compiler_parameters_clause ... ] [ REUSE SETTINGS ]
 *
 * type_compile_clause
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/ALTER-TYPE-statement.html#GUID-A8B449E7-E3A8-48F4-A4C6-5BB87B1841CD
 * @author kongtong.ouyang on 2018/6/13.
 */
public class SQLCompileClause extends AbstractSQLExpr {

    protected boolean debug;
    protected SQLCompiler compiler;
    protected final List<SQLExpr> parameters = new ArrayList<>();
    protected boolean reuseSettings;


    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, parameters);
        }
    }

    @Override
    public SQLCompileClause clone() {
        SQLCompileClause x = new SQLCompileClause();
        return x;
    }

    public boolean isDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    public SQLCompiler getCompiler() {
        return compiler;
    }

    public void setCompiler(SQLCompiler compiler) {
        this.compiler = compiler;
    }

    public List<SQLExpr> getParameters() {
        return parameters;
    }

    public void addParameter(SQLExpr parameter) {
        if (parameter == null) {
            return;
        }
        setChildParent(parameter);
        this.parameters.add(parameter);
    }

    public boolean isReuseSettings() {
        return reuseSettings;
    }

    public void setReuseSettings(boolean reuseSettings) {
        this.reuseSettings = reuseSettings;
    }


    public enum SQLCompiler {
        PACKAGE(SQLReserved.PACKAGE),
        SPECIFICATION(SQLReserved.SPECIFICATION),
        BODY(SQLReserved.BODY),;

        public final SQLReserved name;

        SQLCompiler(SQLReserved name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name.upper;
        }
    }

}
