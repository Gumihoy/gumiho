package com.aliyun.gumiho.sql.basic.ast.element.expr.type.alter;

import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * DROP ATTRIBUTE { attribute| ( attribute [, attribute ]... )}
 * <p>
 * alter_attribute_definition
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/ALTER-TYPE-statement.html#GUID-A8B449E7-E3A8-48F4-A4C6-5BB87B1841CD
 *
 * @author kongtong.ouyang on 2018/9/11.
 */
public class SQLAlterTypeDropAttributeAction extends AbstractSQLAlterTypeAlterAttributeAction implements ISQLAlterTypeAction {

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, items);
        }
    }

    @Override
    public SQLAlterTypeDropAttributeAction clone() {
        SQLAlterTypeDropAttributeAction x = new SQLAlterTypeDropAttributeAction();
        super.cloneTo(x);
        return x;
    }


}