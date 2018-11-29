package com.aliyun.gumiho.sql.basic.ast.element.expr.table;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.enums.ISQLEnum;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * GENERATED { ALWAYS | BY DEFAULT } AS IDENTITY [ <left paren> <common sequence generator options> <right paren> ]
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#identity%20column%20specification
 * <p>
 * <p>
 * GENERATED [ ALWAYS | BY DEFAULT [ ON NULL ] ] AS IDENTITY [ ( identity_options ) ]
 * <p>
 * identity_clause
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-TABLE.html#GUID-F9CE0CC3-13AE-4744-A43C-EAC7A71AAAB6
 *
 * @author kongtong.ouyang on 2018/6/28.
 */
public class SQLIdentityClause extends AbstractSQLExpr {

    protected IdentityAction action;

    protected final List<SQLIdentityOption> options = new ArrayList<>();

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, options);
        }
    }

    @Override
    public SQLIdentityClause clone() {
        SQLIdentityClause x = new SQLIdentityClause();
        x.action = this.action;

        for (SQLIdentityOption option : this.options) {
            SQLIdentityOption optionClone = option.clone();
            x.addOption(optionClone);
        }
        return x;
    }


    public IdentityAction getAction() {
        return action;
    }

    public void setAction(IdentityAction action) {
        this.action = action;
    }

    public List<SQLIdentityOption> getOptions() {
        return options;
    }

    public void addOption(SQLIdentityOption option) {
        if (option == null) {
            return;
        }
        setChildParent(option);
        this.options.add(option);
    }

    public enum IdentityAction implements ISQLEnum {
        ALWAYS(SQLReserved.ALWAYS),
        BY_DEFAULT(SQLReserved.BY_DEFAULT),
        BY_DEFAULT_ON_NULL(SQLReserved.BY_DEFAULT_ON_NULL),;

        public final SQLReserved name;

        IdentityAction(SQLReserved name) {
            this.name = name;
        }

        @Override
        public SQLReserved getName() {
            return name;
        }

        @Override
        public String toString() {
            return name.upper;
        }


    }
}
