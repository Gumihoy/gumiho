package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLVariableDeclaration;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * record_type_definition
 * <p>
 * TYPE record_type IS RECORD  ( field_definition [, field_definition]... ) ;
 * field_definition: field datatype [ [ NOT NULL ] { := | DEFAULT } expression ]
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/record-variable-declaration.html#GUID-704FC014-561E-422C-9636-EDCA3B996AAD
 *
 * @author kongtong.ouyang on 2018/4/25.
 */
public class OracleSQLRecordTypeDefinition extends AbstractOracleSQLExpr implements OracleSQLTypeDefinition {

    protected SQLName name;

    protected final List<SQLVariableDeclaration> arguments = new ArrayList<>();

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
            this.acceptChild(visitor, arguments);
        }
    }

    @Override
    public OracleSQLRecordTypeDefinition clone() {
        OracleSQLRecordTypeDefinition x = new OracleSQLRecordTypeDefinition();

        this.cloneTo(x);
        return x;
    }


    public void cloneTo(OracleSQLRecordTypeDefinition x) {
        super.cloneTo(x);
    }

    public SQLName getName() {
        return name;
    }


    public void setName(SQLName name) {
        setChildParent(name);
        this.name = name;
    }

    public List<SQLVariableDeclaration> getArguments() {
        return arguments;
    }

    public void addArgument(SQLVariableDeclaration argument) {
        if (argument == null) {
            return;
        }
        setChildParent(argument);
        this.arguments.add(argument);
    }

}
