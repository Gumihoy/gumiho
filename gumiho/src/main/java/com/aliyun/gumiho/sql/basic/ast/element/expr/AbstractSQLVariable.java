package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLIdentifier;
import com.aliyun.gumiho.sql.util.SQLUtils;

/**
 * @author kongtong.ouyang on 2018/7/25.
 */
public abstract class AbstractSQLVariable extends AbstractSQLNotation implements ISQLVariable {

    protected SQLIdentifier name;

    @Override
    public AbstractSQLVariable clone() {
        throw new UnsupportedOperationException(getClass().getName());
    }

    public void cloneTo(AbstractSQLVariable x) {
        super.cloneTo(x);
        SQLIdentifier nameClone = this.name.clone();
        x.setName(nameClone);
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == name
                && target instanceof SQLIdentifier) {
            setName((SQLIdentifier) target);
            return true;
        }
        return false;
    }

    public SQLIdentifier getName() {
        return name;
    }

    public void setName(SQLIdentifier name) {
        setChildParent(name);
        this.name = name;
    }

    public void setName(String name) {
        name = removeAtSign(name);
        setName(SQLUtils.ofName(name));
    }

    /**
     * remove @: @xx => xx、@@xx => xx
     */
    protected static String removeAtSign(String name) {
        if (name == null
                || name.length() == 0) {
            return name;
        }

        int index = -1;
        for (int i = 0; i < name.toCharArray().length; i++) {
            char c = name.charAt(i);
            if (c != '@') {
                break;
            }
            index = i;
        }

        if (index != -1) {
            name = name.substring(index + 1, name.length());
        }
        return name;
    }
}
