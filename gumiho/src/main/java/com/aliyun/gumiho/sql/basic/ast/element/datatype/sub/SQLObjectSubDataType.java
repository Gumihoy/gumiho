package com.aliyun.gumiho.sql.basic.ast.element.datatype.sub;

import com.aliyun.gumiho.sql.basic.ast.element.datatype.AbstractSQLDataType;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * UNDER name
 * <p>
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#subtype%20clause
 * <p>
 * object_subtype_def:
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/CREATE-TYPE-statement.html#GUID-389D603D-FBD0-452A-8414-240BBBC57034
 *
 * @author kongtong.ouyang on 2018/4/20.
 */
public class SQLObjectSubDataType extends AbstractSQLDataType {

    protected SQLName superDataType;

    public SQLObjectSubDataType() {
        super(SQLReserved.UNDER.ofExpr());
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, superDataType);
        }
    }

    @Override
    public SQLObjectSubDataType clone() {
        SQLObjectSubDataType x = new SQLObjectSubDataType();
        this.cloneTo(x);
        return x;
    }

    public void cloneTo(SQLObjectSubDataType x) {
        super.cloneTo(x);
    }

    public SQLName getSuperDataType() {
        return superDataType;
    }

    public void setSuperDataType(SQLName superDataType) {
        setChildParent(superDataType);
        this.superDataType = superDataType;
    }
}
