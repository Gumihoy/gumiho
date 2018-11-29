package com.aliyun.gumiho.sql.basic.ast.element.expr.trigger;

import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * NEW [ROW|TABLE] [AS] alias
 * <p>
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#trigger%20definition
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/CREATE-TRIGGER-statement.html#GUID-AF9E33F1-64D1-4382-A6A4-EC33C36F237B
 *
 * @author kongtong.ouyang on 2018/4/26.
 */
public class SQLTriggerReferencingNewOption extends AbstractSQLTriggerReferencingOption implements SQLTriggerReferencingOption {


    public SQLTriggerReferencingNewOption() {
    }

    public SQLTriggerReferencingNewOption(String name) {
        super(name);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
        }
    }

    @Override
    public SQLTriggerReferencingNewOption clone() {
        SQLTriggerReferencingNewOption x = new SQLTriggerReferencingNewOption();
        this.cloneTo(x);
        return x;
    }
}
