package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.ast.element.datatype.SQLDataType;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#field%20definition
 * @author kongtong.ouyang onCondition 2018/4/3.
 */
public class SQLFieldDefinition extends AbstractSQLExpr {

    protected SQLName name;

    protected SQLDataType dataType;

    protected SQLReferenceScopeCheck referenceScopeCheck;

    @Override
    protected void accept0(SQLASTVisitor visitor) {

    }
}
