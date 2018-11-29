package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * <<label>>
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/lnpls/block.html#GUID-9ACEB9ED-567E-4E1A-A16A-B8B35214FC9D
 *
 * @author kongtong.ouyang onCondition 2018/4/4.
 */
public class SQLLabel extends AbstractSQLExpr {

    protected SQLName label;

    public SQLLabel(SQLName label) {
        setLabel(label);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, label);
        }
    }

    @Override
    public SQLLabel clone() {
        SQLName labelClone = label.clone();
        return new SQLLabel(labelClone);
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == label
                && target instanceof SQLName) {
            setLabel((SQLName) target);
            return true;
        }
        return false;
    }

    public SQLName getLabel() {
        return label;
    }

    public void setLabel(SQLName label) {
        this.label = label;
    }
}
