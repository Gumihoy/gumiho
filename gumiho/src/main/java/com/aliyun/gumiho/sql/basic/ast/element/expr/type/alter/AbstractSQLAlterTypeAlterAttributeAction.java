package com.aliyun.gumiho.sql.basic.ast.element.expr.type.alter;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;

import java.util.ArrayList;
import java.util.List;

/**
 * { { ADD | MODIFY } ATTRIBUTE
 * { attribute [ datatype ] | ( attribute datatype [, attribute datatype ]... ) }
 * | DROP ATTRIBUTE { attribute| ( attribute [, attribute ]... )}
 * }
 * <p>
 * alter_attribute_definition
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/ALTER-TYPE-statement.html#GUID-A8B449E7-E3A8-48F4-A4C6-5BB87B1841CD
 *
 * @author kongtong.ouyang on 2018/9/11.
 */
public abstract class AbstractSQLAlterTypeAlterAttributeAction extends AbstractSQLExpr implements ISQLAlterTypeAction {

    protected boolean paren;
    protected final List<SQLExpr> items = new ArrayList<>();

    @Override
    public AbstractSQLAlterTypeAlterAttributeAction clone() {
        throw new UnsupportedOperationException(getClass().getName());
    }

    public void cloneTo(AbstractSQLAlterTypeAlterAttributeAction x) {
        super.cloneTo(x);

        x.paren = this.paren;
        for (SQLExpr item : this.items) {
            SQLExpr itemClone = item.clone();
            x.addItem(itemClone);
        }
    }

    public boolean isParen() {
        return paren;
    }

    public void setParen(boolean paren) {
        this.paren = paren;
    }

    public List<SQLExpr> getItems() {
        return items;
    }

    public void addItem(SQLExpr item) {
        if (item == null) {
            return;
        }
        setChildParent(item);
        this.items.add(item);
    }
}
