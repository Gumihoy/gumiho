package com.aliyun.gumiho.sql.basic.ast.element.expr.trigger;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.util.SQLUtils;

/**
 * NEW/OLD [ROW|TABLE] [AS] alias
 * <p>
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#trigger%20definition
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/CREATE-TRIGGER-statement.html#GUID-AF9E33F1-64D1-4382-A6A4-EC33C36F237B
 *
 * @author kongtong.ouyang on 2018/4/26.
 */
public abstract class AbstractSQLTriggerReferencingOption extends AbstractSQLExpr implements SQLTriggerReferencingOption {

    protected SQLTriggerReferencingType referencingType;

    protected boolean as;

    protected SQLName name;

    public AbstractSQLTriggerReferencingOption() {
    }

    public AbstractSQLTriggerReferencingOption(String name) {
        setName(SQLUtils.ofName(name));
    }

    public AbstractSQLTriggerReferencingOption(SQLName name) {
        setName(name);
    }

    @Override
    public AbstractSQLTriggerReferencingOption clone() {
        throw new UnsupportedOperationException(getClass().getName());
    }

    public void cloneTo(AbstractSQLTriggerReferencingOption x) {
        super.cloneTo(x);

        x.referencingType = this.referencingType;

        x.as = this.as;

        SQLName nameClone = this.name.clone();
        x.setName(nameClone);
    }


    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == name
                && target instanceof SQLName) {
            setName((SQLName) target);
            return true;
        }
        return false;
    }

    public SQLTriggerReferencingType getReferencingType() {
        return referencingType;
    }

    public void setReferencingType(SQLTriggerReferencingType referencingType) {
        this.referencingType = referencingType;
    }

    public boolean isAs() {
        return as;
    }

    public void setAs(boolean as) {
        this.as = as;
    }

    public SQLName getName() {
        return name;
    }

    public void setName(SQLName name) {
        setChildParent(name);
        this.name = name;
    }

    public enum SQLTriggerReferencingType {

        ROW(SQLReserved.ROW),
        TABLE(SQLReserved.TABLE),;

        public final SQLReserved name;

        SQLTriggerReferencingType(SQLReserved name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name.upper;
        }
    }
}
