package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common;

import com.aliyun.gumiho.sql.basic.ast.element.datatype.SQLDataType;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.clause.SQLDefaultClause;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

/**
 * constant_declaration
 * <p>
 * constant CONSTANT datatype [NOT NULL] { := | DEFAULT } expression ;
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/constant-declaration.html#GUID-C6DA65F8-3F0C-43F3-8BC6-231064E8C1B6
 *
 * @author kongtong.ouyang on 2018/4/25.
 */
public class OracleSQLConstantDeclaration extends AbstractOracleSQLExpr {

    protected SQLName name;

    protected SQLDataType dataType;

    protected boolean notNull;

    protected SQLDefaultClause defaultClause;

    public OracleSQLConstantDeclaration() {
        setAfterSemi(true);
    }

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
            this.acceptChild(visitor, dataType);
            this.acceptChild(visitor, defaultClause);
        }
    }




    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        return false;
    }

    public SQLName getName() {
        return name;
    }

    public void setName(SQLName name) {
        setChildParent(name);
        this.name = name;
    }

    public SQLDataType getDataType() {
        return dataType;
    }

    public void setDataType(SQLDataType dataType) {
        setChildParent(dataType);
        this.dataType = dataType;
    }

    public boolean isNotNull() {
        return notNull;
    }

    public void setNotNull(boolean notNull) {
        this.notNull = notNull;
    }

    public SQLDefaultClause getDefaultClause() {
        return defaultClause;
    }

    public void setDefaultClause(SQLDefaultClause defaultClause) {
        setChildParent(defaultClause);
        this.defaultClause = defaultClause;
    }
}
